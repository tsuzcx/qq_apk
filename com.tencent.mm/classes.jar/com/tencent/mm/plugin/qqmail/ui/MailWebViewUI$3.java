package com.tencent.mm.plugin.qqmail.ui;

import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.t;
import com.tencent.xweb.w;

final class MailWebViewUI$3
  extends w
{
  MailWebViewUI$3(MailWebViewUI paramMailWebViewUI) {}
  
  public final void a(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(68395);
    MailWebViewUI.c(this.pOf).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    AppMethodBeat.o(68395);
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(68396);
    if (paramString.startsWith("weixin://private/getcontentwidth/"))
    {
      ab.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = ".concat(String.valueOf(paramString)));
      MailWebViewUI.b(this.pOf, paramString);
      AppMethodBeat.o(68396);
      return true;
    }
    paramWebView.loadUrl(paramString);
    AppMethodBeat.o(68396);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(68397);
    super.b(paramWebView, paramString);
    u.b(paramWebView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
    AppMethodBeat.o(68397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */