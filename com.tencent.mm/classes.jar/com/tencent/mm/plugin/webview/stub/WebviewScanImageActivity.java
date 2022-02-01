package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.be;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.pv;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebviewScanImageActivity
  extends HellActivity
{
  private IListener Rdt;
  private String WDP;
  private boolean WRT;
  private String WRU;
  private int hDb;
  private int hDc;
  private String imageUrl;
  private String url;
  
  public WebviewScanImageActivity()
  {
    AppMethodBeat.i(79530);
    this.WRT = false;
    this.WRU = null;
    this.Rdt = new IListener(f.hfK) {};
    AppMethodBeat.o(79530);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79531);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    String str;
    ad.b localb;
    if (Util.isNullOrNil(getIntent().getStringExtra("img_gallery_session_id")))
    {
      paramBundle = getIntent().getStringExtra("key_string_for_url");
      if (!Util.isNullOrNil(paramBundle))
      {
        str = ad.Jo("WebviewQrCode");
        localb = ad.bCb().M(str, true);
        localb.q("url", paramBundle);
        if (((c)h.ax(c.class)).isMpUrl(paramBundle)) {
          break label164;
        }
      }
    }
    label164:
    for (int i = 6;; i = 1)
    {
      localb.q("Contact_Sub_Scene", Integer.valueOf(i));
      localb.q("Contact_Scene_Note", paramBundle);
      getIntent().putExtra("img_gallery_session_id", str);
      setContentView(c.g.layout_empty_activity);
      AppMethodBeat.o(79531);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79533);
    super.onPause();
    Log.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
    be localbe = new be();
    localbe.hBh.activity = this;
    localbe.hBh.hBi = this.WRU;
    localbe.publish();
    this.Rdt.dead();
    finish();
    AppMethodBeat.o(79533);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(79532);
    super.onStart();
    Log.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
    df localdf;
    Bundle localBundle;
    if ((!this.WRT) && (getIntent() != null))
    {
      this.WRU = getIntent().getStringExtra("key_string_for_scan");
      this.hDb = getIntent().getIntExtra("key_codetype_for_scan", 0);
      this.hDc = getIntent().getIntExtra("key_codeversion_for_scan", 0);
      this.url = getIntent().getStringExtra("key_string_for_url");
      this.imageUrl = getIntent().getStringExtra("key_string_for_image_url");
      this.WDP = getIntent().getStringExtra("key_string_for_wxapp_id");
      if (this.WRU != null)
      {
        this.Rdt.alive();
        localdf = new df();
        localdf.hDa.activity = this;
        localdf.hDa.hBi = this.WRU;
        localdf.hDa.hDc = this.hDc;
        localdf.hDa.hDb = this.hDb;
        localdf.hDa.sourceType = 6;
        localdf.hDa.imagePath = this.imageUrl;
        localdf.hDa.scene = getIntent().getIntExtra("geta8key_scene", 40);
        localBundle = new Bundle();
        localBundle.putString("stat_app_id", this.WDP);
        localBundle.putString("stat_url", this.url);
        localBundle.putInt("stat_scene", 4);
        localBundle.putString("stat_send_msg_user", getIntent().getStringExtra("key_string_for_from_username"));
        localBundle.putString("wxappPathWithQuery", getIntent().getStringExtra("wxappPathWithQuery"));
        if (!Util.isNullOrNil(this.WDP)) {
          break label333;
        }
        Log.i("MicroMsg.WebviewScanImageActivity", "addStatInfo4AppBrand, from h5");
        localBundle.putInt("LaunchCodeScene_ScanScene", 3);
      }
    }
    for (;;)
    {
      localdf.hDa.hDf = localBundle;
      localdf.publish();
      this.WRT = true;
      AppMethodBeat.o(79532);
      return;
      label333:
      Log.i("MicroMsg.WebviewScanImageActivity", "addStatInfo4AppBrand, from wxapp");
      localBundle.putInt("LaunchCodeScene_ScanScene", 5);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity
 * JD-Core Version:    0.7.0.1
 */