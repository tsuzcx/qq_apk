package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.e.g.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(19)
public class H5GameWebViewUI
  extends GameWebViewUI
{
  private int gNO;
  
  public final boolean bQO()
  {
    return false;
  }
  
  public final boolean eSH()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80952);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.H5GameWebViewUI", "onCreate");
    this.EcT = false;
    this.gNO = this.screenOrientation;
    AppMethodBeat.o(80952);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(80953);
    ad.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    boolean bool = getIntent().getBooleanExtra("show_full_screen", false);
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("rawUrl");
    ad.d("MicroMsg.H5GameWebViewUI", "url = ".concat(String.valueOf(str)));
    if (!this.EcS.equals(str))
    {
      if (str.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
        this.EcS = str;
      }
      if (!bQm().equals(str))
      {
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        if (this.lvw == null) {
          this.lvw = new g(new g.b()
          {
            public final String eNw()
            {
              AppMethodBeat.i(208248);
              String str = H5GameWebViewUI.a(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(208248);
              return str;
            }
            
            public final String eNx()
            {
              AppMethodBeat.i(208249);
              String str = H5GameWebViewUI.b(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(208249);
              return str;
            }
          });
        }
        for (;;)
        {
          this.lvw.a((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"));
          this.omW.loadUrl("about:blank");
          this.DIv.at(paramIntent);
          AppMethodBeat.o(80953);
          return;
          this.lvw.a(str, null, null);
        }
      }
      this.screenOrientation = this.gNO;
      getIntent().putExtra("show_full_screen", bool);
      eSQ();
    }
    AppMethodBeat.o(80953);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80954);
    setMMOrientation();
    super.onResume();
    AppMethodBeat.o(80954);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.H5GameWebViewUI
 * JD-Core Version:    0.7.0.1
 */