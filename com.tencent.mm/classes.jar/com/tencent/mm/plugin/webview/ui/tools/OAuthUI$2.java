package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

final class OAuthUI$2
  extends p
{
  OAuthUI$2(OAuthUI paramOAuthUI) {}
  
  public final void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(7418);
    super.d(paramWebView, paramString);
    this.vaY.setMMTitle(paramString);
    AppMethodBeat.o(7418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OAuthUI.2
 * JD-Core Version:    0.7.0.1
 */