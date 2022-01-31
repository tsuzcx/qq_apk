package com.tencent.mm.plugin.qqmail.ui;

import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.luggage.m.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;

final class MailWebViewUI$3
  extends a
{
  MailWebViewUI$3(MailWebViewUI paramMailWebViewUI) {}
  
  public final void a(MMWebView paramMMWebView, String paramString)
  {
    super.a(paramMMWebView, paramString);
    s.c(paramMMWebView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
  }
  
  public final void a(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    MailWebViewUI.c(this.niS).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith("weixin://private/getcontentwidth/"))
    {
      y.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = " + paramString);
      MailWebViewUI.b(this.niS, paramString);
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */