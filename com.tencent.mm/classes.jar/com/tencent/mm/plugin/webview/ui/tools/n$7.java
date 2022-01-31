package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class n$7
  implements Runnable
{
  n$7(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7719);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7719);
      return;
    }
    if (this.vdp != null) {
      this.vdp.ea(this.nlv, this.gAL);
    }
    AppMethodBeat.o(7719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.7
 * JD-Core Version:    0.7.0.1
 */