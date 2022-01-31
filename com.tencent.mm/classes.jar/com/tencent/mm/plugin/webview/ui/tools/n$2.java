package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class n$2
  implements Runnable
{
  n$2(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7714);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7714);
      return;
    }
    if (this.vdp != null) {
      this.vdp.dW(this.vds, this.vdt);
    }
    AppMethodBeat.o(7714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.2
 * JD-Core Version:    0.7.0.1
 */