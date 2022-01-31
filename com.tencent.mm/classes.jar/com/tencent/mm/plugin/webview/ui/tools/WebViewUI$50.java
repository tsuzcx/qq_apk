package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$50
  implements k.b
{
  WebViewUI$50(WebViewUI paramWebViewUI) {}
  
  public final String aYZ()
  {
    AppMethodBeat.i(7881);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7881);
      return null;
    }
    String str = this.vgz.pOd.getUrl();
    AppMethodBeat.o(7881);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.50
 * JD-Core Version:    0.7.0.1
 */