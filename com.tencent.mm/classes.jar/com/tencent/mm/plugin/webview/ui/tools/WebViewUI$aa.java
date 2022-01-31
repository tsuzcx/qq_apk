package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$aa
  implements b
{
  private WebViewUI$aa(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    try
    {
      if (!this.rpH.gGn.isSDCardAvailable())
      {
        this.rpH.gGn.a(2, null, this.rpH.hashCode());
        return true;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + paramString.getMessage());
      return false;
    }
    WebViewUI.s(this.rpH, paramString.substring(19));
    y.i("MicroMsg.WebViewUI", "viewimage currentUrl :" + WebViewUI.aS(this.rpH));
    s.a(this.rpH.niQ, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", WebViewUI.aT(this.rpH));
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://viewimage/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.aa
 * JD-Core Version:    0.7.0.1
 */