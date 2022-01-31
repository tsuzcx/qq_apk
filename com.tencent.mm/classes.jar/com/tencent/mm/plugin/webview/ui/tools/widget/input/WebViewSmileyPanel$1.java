package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewSmileyPanel$1
  implements Runnable
{
  WebViewSmileyPanel$1(WebViewSmileyPanel paramWebViewSmileyPanel) {}
  
  public final void run()
  {
    AppMethodBeat.i(10109);
    this.vtH.onPageSelected(WebViewSmileyPanel.a(this.vtH).getCurrentItem());
    AppMethodBeat.o(10109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.1
 * JD-Core Version:    0.7.0.1
 */