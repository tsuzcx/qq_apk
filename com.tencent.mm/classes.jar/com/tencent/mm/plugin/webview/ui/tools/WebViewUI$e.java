package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;

final class WebViewUI$e
  implements b
{
  private WebViewUI$e(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    h.nFQ.a(405L, 25L, 1L, true);
    WebViewUI.i(this.rpH, 1);
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://critical_update/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.e
 * JD-Core Version:    0.7.0.1
 */