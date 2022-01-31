package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$13
  implements Runnable
{
  n$13(n paramn, WebViewUI paramWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(7725);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7725);
      return;
    }
    this.vdo.setMMSubTitle(null);
    AppMethodBeat.o(7725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.13
 * JD-Core Version:    0.7.0.1
 */