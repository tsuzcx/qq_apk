package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R.a;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$j
  implements b
{
  private final String rqN = "weixin://feedback/";
  
  private WebViewUI$j(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    paramString = new Bundle();
    paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
    paramString.putInt("MMActivity.OverrideExitAnimation", R.a.push_down_out);
    try
    {
      this.rpH.gGn.a(7, paramString, this.rpH.hashCode());
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + paramString.getMessage());
      }
    }
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://feedback/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.j
 * JD-Core Version:    0.7.0.1
 */