package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.as.i;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$10
  implements LogoWebViewWrapper.a
{
  WebViewUI$10(WebViewUI paramWebViewUI) {}
  
  public final void ddx()
  {
    AppMethodBeat.i(7818);
    if (this.vgz.pOd.getIsX5Kernel())
    {
      as.i locali = this.vgz.uVh.dco();
      locali.uWQ = new Object[] { this.vgz.cJr, Integer.valueOf(10) };
      locali.b(this.vgz.igU);
    }
    AppMethodBeat.o(7818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.10
 * JD-Core Version:    0.7.0.1
 */