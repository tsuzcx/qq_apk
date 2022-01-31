package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.Map;

final class n$11
  implements Runnable
{
  n$11(n paramn, WebViewUI paramWebViewUI, d paramd, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(7723);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7723);
      return;
    }
    this.vdo.setMMSubTitle(null);
    if (this.vdp != null) {
      this.vdp.aO(this.vdx);
    }
    AppMethodBeat.o(7723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.11
 * JD-Core Version:    0.7.0.1
 */