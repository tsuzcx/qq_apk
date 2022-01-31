package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$o
  implements b
{
  private WebViewUI$o(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    if (!bk.bl(paramString))
    {
      paramString = paramString.substring(17);
      y.i("MicroMsg.WebViewUI", "[oneliang]get html content :" + paramString);
      this.rpH.cen();
    }
    return false;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://gethtml/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.o
 * JD-Core Version:    0.7.0.1
 */