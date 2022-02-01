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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(19)
public class H5GameWebViewUI
  extends GameWebViewUI
{
  private int cpv;
  
  public final boolean bRP()
  {
    return false;
  }
  
  public final boolean eWt()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80952);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.H5GameWebViewUI", "onCreate");
    this.EuV = false;
    this.cpv = this.screenOrientation;
    AppMethodBeat.o(80952);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(80953);
    ae.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    boolean bool = getIntent().getBooleanExtra("show_full_screen", false);
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("rawUrl");
    ae.d("MicroMsg.H5GameWebViewUI", "url = ".concat(String.valueOf(str)));
    if (!this.EuU.equals(str))
    {
      if (str.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
        this.EuU = str;
      }
      if (!bRn().equals(str))
      {
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        if (this.lzU == null) {
          this.lzU = new g(new g.b()
          {
            public final String eRh()
            {
              AppMethodBeat.i(198430);
              String str = H5GameWebViewUI.a(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(198430);
              return str;
            }
            
            public final String eRi()
            {
              AppMethodBeat.i(198431);
              String str = H5GameWebViewUI.b(H5GameWebViewUI.this).getUrl();
              AppMethodBeat.o(198431);
              return str;
            }
          });
        }
        for (;;)
        {
          this.lzU.a((JsapiPermissionWrapper)getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)getIntent().getParcelableExtra("hardcode_general_ctrl"));
          this.osM.loadUrl("about:blank");
          this.Eat.au(paramIntent);
          AppMethodBeat.o(80953);
          return;
          this.lzU.a(str, null, null);
        }
      }
      this.screenOrientation = this.cpv;
      getIntent().putExtra("show_full_screen", bool);
      eWC();
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