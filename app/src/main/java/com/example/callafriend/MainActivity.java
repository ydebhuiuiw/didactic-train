package com.example.callafriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txtmob = findViewById(R.id.mobno);
        Button btncall = findViewById(R.id.btncall);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobno = txtmob.getText().toString();
                String moburl = "tel:" + mobno;
                String mobile = "+91" + mobno;
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) ==
                        PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(moburl));
                     //Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://techpile.in"));
                    // Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://api.whatsapp.com/send?phoneno="+mobile+"&text=hello")) ;

                    startActivity(intent);
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });
        Button btnmsg = findViewById(R.id.btnmes);
        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText mobno = findViewById(R.id.mobno);
                EditText msg = findViewById(R.id.txtmsg);
                String mobile = mobno.getText().toString();
                String text = msg.getText().toString();
                if (mobno != null && msg != null) {
                    Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+91"+mobile+"&text="+text));
                    startActivity(in);
                } else {
                    Toast.makeText(MainActivity.this, "please enter mobile number and message", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
