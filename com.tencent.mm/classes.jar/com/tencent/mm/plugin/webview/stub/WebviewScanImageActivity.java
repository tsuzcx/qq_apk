package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.R.i;
import com.tencent.mm.h.a.al;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

@com.tencent.mm.ui.base.a(7)
public class WebviewScanImageActivity
  extends Activity
{
  private int bIj;
  private int bIk;
  private String exD;
  private String oOO = null;
  private c oOV = new WebviewScanImageActivity.1(this);
  private boolean rkw = false;
  private String rkx;
  private String url;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    setContentView(R.i.layout_empty_activity);
  }
  
  protected void onPause()
  {
    super.onPause();
    y.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
    al localal = new al();
    localal.bGD.activity = this;
    localal.bGD.bGE = this.oOO;
    com.tencent.mm.sdk.b.a.udP.m(localal);
    com.tencent.mm.sdk.b.a.udP.d(this.oOV);
    finish();
  }
  
  protected void onStart()
  {
    super.onStart();
    y.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
    if ((!this.rkw) && (getIntent() != null))
    {
      this.oOO = getIntent().getStringExtra("key_string_for_scan");
      this.bIj = getIntent().getIntExtra("key_codetype_for_scan", 0);
      this.bIk = getIntent().getIntExtra("key_codeversion_for_scan", 0);
      this.url = getIntent().getStringExtra("key_string_for_url");
      this.exD = getIntent().getStringExtra("key_string_for_image_url");
      this.rkx = getIntent().getStringExtra("key_string_for_wxapp_id");
      if (this.oOO != null)
      {
        cd localcd = new cd();
        localcd.bIi.activity = this;
        localcd.bIi.bGE = this.oOO;
        localcd.bIi.bIk = this.bIk;
        localcd.bIi.bIj = this.bIj;
        localcd.bIi.bIl = 6;
        localcd.bIi.imagePath = this.exD;
        localcd.bIi.scene = 40;
        Bundle localBundle = new Bundle();
        localBundle.putString("stat_app_id", this.rkx);
        localBundle.putString("stat_url", this.url);
        localBundle.putInt("stat_scene", 4);
        localcd.bIi.bIo = localBundle;
        com.tencent.mm.sdk.b.a.udP.m(localcd);
        com.tencent.mm.sdk.b.a.udP.c(this.oOV);
      }
    }
    this.rkw = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity
 * JD-Core Version:    0.7.0.1
 */