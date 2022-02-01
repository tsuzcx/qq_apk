package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.f.g.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(19)
public class H5GameWebViewUI
  extends GameWebViewUI
{
  private static final String JrI;
  private int lastOrientation;
  
  static
  {
    AppMethodBeat.i(211342);
    JrI = "http://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/gameloading/index.html";
    AppMethodBeat.o(211342);
  }
  
  public final boolean cpz()
  {
    return false;
  }
  
  public final boolean gfq()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80952);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.H5GameWebViewUI", "onCreate");
    this.Jio = false;
    this.lastOrientation = this.screenOrientation;
    AppMethodBeat.o(80952);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(80953);
    Log.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    boolean bool = getIntent().getBooleanExtra("show_full_screen", false);
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("rawUrl");
    Log.d("MicroMsg.H5GameWebViewUI", "url = ".concat(String.valueOf(str)));
    if (!this.Jin.equals(str))
    {
      if (str.startsWith(JrI)) {
        this.Jin = str;
      }
      if (!coX().equals(str))
      {
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        if (this.mHi == null) {
          this.mHi = new g(new g.b()
          {
            public final String fZK()
            {
              AppMethodBeat.i(211340);
              String str = H5GameWebViewUI.a(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(211340);
              return str;
            }
            
            public final String fZL()
            {
              AppMethodBeat.i(211341);
              String str = H5GameWebViewUI.b(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(211341);
              return str;
            }
          });
        }
        for (;;)
        {
          this.mHi.a((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"));
          this.pGj.loadUrl("about:blank");
          this.IMH.aB(paramIntent);
          AppMethodBeat.o(80953);
          return;
          this.mHi.a(str, null, null);
        }
      }
      this.screenOrientation = this.lastOrientation;
      getIntent().putExtra("show_full_screen", bool);
      gfA();
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