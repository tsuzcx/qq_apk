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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(19)
public class H5GameWebViewUI
  extends GameWebViewUI
{
  private int gud;
  
  public final boolean bMn()
  {
    return false;
  }
  
  public final boolean eDP()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80952);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.H5GameWebViewUI", "onCreate");
    this.Czk = false;
    this.gud = this.screenOrientation;
    AppMethodBeat.o(80952);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(80953);
    ac.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    boolean bool = getIntent().getBooleanExtra("show_full_screen", false);
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("rawUrl");
    ac.d("MicroMsg.H5GameWebViewUI", "url = ".concat(String.valueOf(str)));
    if (!this.Czj.equals(str))
    {
      if (str.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
        this.Czj = str;
      }
      if (!bLL().equals(str))
      {
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        if (this.kYu == null) {
          this.kYu = new g(new g.b()
          {
            public final String eyH()
            {
              AppMethodBeat.i(188572);
              String str = H5GameWebViewUI.a(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(188572);
              return str;
            }
            
            public final String eyI()
            {
              AppMethodBeat.i(188573);
              String str = H5GameWebViewUI.b(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(188573);
              return str;
            }
          });
        }
        for (;;)
        {
          this.kYu.a((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"));
          this.nKq.loadUrl("about:blank");
          this.Cfr.ao(paramIntent);
          AppMethodBeat.o(80953);
          return;
          this.kYu.a(str, null, null);
        }
      }
      this.screenOrientation = this.gud;
      getIntent().putExtra("show_full_screen", bool);
      eDY();
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