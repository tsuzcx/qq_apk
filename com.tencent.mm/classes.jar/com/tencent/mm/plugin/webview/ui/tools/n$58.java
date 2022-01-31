package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;

final class n$58
  implements Runnable
{
  n$58(n paramn, WebViewUI paramWebViewUI, d paramd, k paramk, String paramString, int paramInt, Boolean paramBoolean) {}
  
  public final void run()
  {
    boolean bool2 = false;
    AppMethodBeat.i(7772);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7772);
      return;
    }
    if ((this.vdp != null) && (this.vdq != null) && (this.vdq.ddV() != null))
    {
      this.vdq.ddV();
      this.vdp.dV(this.vdy, this.gB);
      AppMethodBeat.o(7772);
      return;
    }
    if ((this.vdp != null) && (this.vdX.booleanValue()))
    {
      this.vdp.dV(this.vdy, this.gB);
      AppMethodBeat.o(7772);
      return;
    }
    if (this.vdp == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.vdq == null) {
        bool2 = true;
      }
      ab.w("MicroMsg.WebViewStubCallbackAIDLStub", "something null, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(7772);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.58
 * JD-Core Version:    0.7.0.1
 */