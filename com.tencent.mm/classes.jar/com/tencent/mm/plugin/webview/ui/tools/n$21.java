package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class n$21
  implements Runnable
{
  n$21(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat) {}
  
  public final void run()
  {
    AppMethodBeat.i(7733);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7733);
      return;
    }
    if (this.vdp != null) {
      this.vdp.a(this.gSO, this.vdF, this.vdG, this.fCk, this.vdH, this.vdI);
    }
    AppMethodBeat.o(7733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.21
 * JD-Core Version:    0.7.0.1
 */