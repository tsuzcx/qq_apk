package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class n$20
  implements Runnable
{
  n$20(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(7732);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7732);
      return;
    }
    if (this.vdp != null) {
      this.vdp.aiY(this.val$message);
    }
    AppMethodBeat.o(7732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.20
 * JD-Core Version:    0.7.0.1
 */