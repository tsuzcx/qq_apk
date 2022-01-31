package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

@com.tencent.mm.ui.base.a(7)
public class WebviewScanImageActivity
  extends Activity
{
  private int cpE;
  private int cpF;
  private String ffp;
  private c rGI;
  private String rGz;
  private boolean uZR;
  private String uZS;
  private String url;
  
  public WebviewScanImageActivity()
  {
    AppMethodBeat.i(7336);
    this.uZR = false;
    this.rGz = null;
    this.rGI = new WebviewScanImageActivity.1(this);
    AppMethodBeat.o(7336);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7337);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    setContentView(2130969973);
    AppMethodBeat.o(7337);
  }
  
  protected void onPause()
  {
    AppMethodBeat.i(7339);
    super.onPause();
    ab.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
    an localan = new an();
    localan.cnQ.activity = this;
    localan.cnQ.cnR = this.rGz;
    com.tencent.mm.sdk.b.a.ymk.l(localan);
    com.tencent.mm.sdk.b.a.ymk.d(this.rGI);
    finish();
    AppMethodBeat.o(7339);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(7338);
    super.onStart();
    ab.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
    if ((!this.uZR) && (getIntent() != null))
    {
      this.rGz = getIntent().getStringExtra("key_string_for_scan");
      this.cpE = getIntent().getIntExtra("key_codetype_for_scan", 0);
      this.cpF = getIntent().getIntExtra("key_codeversion_for_scan", 0);
      this.url = getIntent().getStringExtra("key_string_for_url");
      this.ffp = getIntent().getStringExtra("key_string_for_image_url");
      this.uZS = getIntent().getStringExtra("key_string_for_wxapp_id");
      if (this.rGz != null)
      {
        com.tencent.mm.sdk.b.a.ymk.c(this.rGI);
        cg localcg = new cg();
        localcg.cpD.activity = this;
        localcg.cpD.cnR = this.rGz;
        localcg.cpD.cpF = this.cpF;
        localcg.cpD.cpE = this.cpE;
        localcg.cpD.cpG = 6;
        localcg.cpD.imagePath = this.ffp;
        localcg.cpD.scene = 40;
        Bundle localBundle = new Bundle();
        localBundle.putString("stat_app_id", this.uZS);
        localBundle.putString("stat_url", this.url);
        localBundle.putInt("stat_scene", 4);
        localcg.cpD.cpJ = localBundle;
        com.tencent.mm.sdk.b.a.ymk.l(localcg);
      }
    }
    this.uZR = true;
    AppMethodBeat.o(7338);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity
 * JD-Core Version:    0.7.0.1
 */