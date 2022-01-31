package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(19)
public class H5GameWebViewUI
  extends GameWebViewUI
{
  private int oGP;
  
  public final boolean aYi()
  {
    return false;
  }
  
  public final boolean deh()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(8777);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.H5GameWebViewUI", "onCreate");
    this.vew = false;
    this.oGP = this.screenOrientation;
    AppMethodBeat.o(8777);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(8778);
    ab.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    boolean bool = getIntent().getBooleanExtra("show_full_screen", false);
    setIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("rawUrl");
    ab.d("MicroMsg.H5GameWebViewUI", "url = ".concat(String.valueOf(paramIntent)));
    if (!this.vev.equals(paramIntent))
    {
      if (paramIntent.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
        this.vev = paramIntent;
      }
      if (!this.cJr.equals(paramIntent))
      {
        this.cJr = paramIntent;
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        this.vfb.keN = this.cJr;
        if (this.igV == null) {
          this.igV = new k((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"), new H5GameWebViewUI.1(this));
        }
        for (;;)
        {
          this.pOd.loadUrl("about:blank");
          ax(this.cJr, false);
          AppMethodBeat.o(8778);
          return;
          this.igV.a(paramIntent, null, null);
        }
      }
      this.screenOrientation = this.oGP;
      getIntent().putExtra("show_full_screen", bool);
      deo();
    }
    AppMethodBeat.o(8778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8779);
    setMMOrientation();
    super.onResume();
    AppMethodBeat.o(8779);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.H5GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */