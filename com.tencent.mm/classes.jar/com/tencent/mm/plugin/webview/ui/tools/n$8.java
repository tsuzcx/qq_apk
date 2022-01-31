package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.Map;

final class n$8
  implements Runnable
{
  n$8(n paramn, WebViewUI paramWebViewUI, d paramd, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(7720);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7720);
      return;
    }
    if (this.vdp != null) {
      this.vdp.aN(this.vdx);
    }
    AppMethodBeat.o(7720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.8
 * JD-Core Version:    0.7.0.1
 */