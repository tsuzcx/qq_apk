package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.e.g.b;
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
  private static final String Xhs;
  private int lastOrientation;
  
  static
  {
    AppMethodBeat.i(297056);
    Xhs = "http://" + WeChatHosts.domainString(c.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/gameloading/index.html";
    AppMethodBeat.o(297056);
  }
  
  public final boolean dhz()
  {
    return false;
  }
  
  public final boolean iyw()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80952);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.H5GameWebViewUI", "onCreate");
    this.WXm = false;
    this.lastOrientation = this.Wzx;
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
    if (!this.WXl.equals(str))
    {
      if (str.startsWith(Xhs)) {
        this.WXl = str;
      }
      if (!dgY().equals(str))
      {
        this.Wzx = getIntent().getIntExtra("screen_orientation", -1);
        if (this.sLD == null) {
          this.sLD = new g(new g.b()
          {
            public final String ise()
            {
              AppMethodBeat.i(297028);
              String str = H5GameWebViewUI.a(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(297028);
              return str;
            }
            
            public final String isf()
            {
              AppMethodBeat.i(297030);
              String str = H5GameWebViewUI.b(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(297030);
              return str;
            }
          });
        }
        for (;;)
        {
          this.sLD.a((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"));
          this.sMP.loadUrl("about:blank");
          this.Wzl.bJ(paramIntent);
          AppMethodBeat.o(80953);
          return;
          this.sLD.a(str, null, null);
        }
      }
      this.Wzx = this.lastOrientation;
      getIntent().putExtra("show_full_screen", bool);
      iyI();
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