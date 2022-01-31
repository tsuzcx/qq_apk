package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class n$5
  implements Runnable
{
  n$5(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7717);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7717);
      return;
    }
    if (this.vdp != null) {
      this.vdp.dY(this.nlv, this.gAL);
    }
    AppMethodBeat.o(7717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.5
 * JD-Core Version:    0.7.0.1
 */