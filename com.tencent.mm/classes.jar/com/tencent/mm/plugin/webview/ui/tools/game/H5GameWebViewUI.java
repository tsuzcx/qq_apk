package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(19)
public class H5GameWebViewUI
  extends GameWebViewUI
{
  private int mgq;
  
  protected final boolean aYK()
  {
    return false;
  }
  
  protected final boolean cdP()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.H5GameWebViewUI", "onCreate");
    this.rnH = false;
    this.mgq = this.screenOrientation;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    boolean bool = getIntent().getBooleanExtra("show_full_screen", false);
    setIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("rawUrl");
    y.d("MicroMsg.H5GameWebViewUI", "url = " + paramIntent);
    if (!this.rnG.equals(paramIntent))
    {
      if (paramIntent.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
        this.rnG = paramIntent;
      }
      if (this.caS.equals(paramIntent)) {
        break label205;
      }
      this.caS = paramIntent;
      this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
      this.roh.rfY = this.caS;
      if (this.gGo != null) {
        break label192;
      }
      this.gGo = new f((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"), new H5GameWebViewUI.1(this));
    }
    for (;;)
    {
      this.niQ.loadUrl("about:blank");
      bo(this.caS, false);
      return;
      label192:
      this.gGo.a(paramIntent, null, null);
    }
    label205:
    this.screenOrientation = this.mgq;
    getIntent().putExtra("show_full_screen", bool);
    cdW();
  }
  
  public void onResume()
  {
    ahA();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.H5GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */