package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$c
  implements b
{
  private WebViewUI$c(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    if (!this.rpH.gGo.cdI().hi(17))
    {
      y.e("MicroMsg.WebViewUI", "close window permission fail");
      return true;
    }
    this.rpH.finish();
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://webview/close/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.c
 * JD-Core Version:    0.7.0.1
 */