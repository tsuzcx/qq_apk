package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class n$24
  implements Runnable
{
  n$24(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(7736);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7736);
      return;
    }
    if (this.vdp != null) {
      this.vdp.ajb(this.vdJ);
    }
    AppMethodBeat.o(7736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.24
 * JD-Core Version:    0.7.0.1
 */