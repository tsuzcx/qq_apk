package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class n$4
  implements Runnable
{
  n$4(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7716);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7716);
      return;
    }
    if (this.vdp != null) {
      this.vdp.dX(this.vdw, this.gAL);
    }
    AppMethodBeat.o(7716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.4
 * JD-Core Version:    0.7.0.1
 */