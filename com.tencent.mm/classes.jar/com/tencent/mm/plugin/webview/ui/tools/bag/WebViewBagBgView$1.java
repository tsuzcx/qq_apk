package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewBagBgView$1
  implements Runnable
{
  WebViewBagBgView$1(WebViewBagBgView paramWebViewBagBgView) {}
  
  public final void run()
  {
    AppMethodBeat.i(8197);
    WebViewBagBgView.a(this.viv);
    this.viv.invalidate();
    AppMethodBeat.o(8197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView.1
 * JD-Core Version:    0.7.0.1
 */