package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;

final class h$3
  implements Runnable
{
  h$3(h paramh, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(6123);
    if (h.a(this.uSc) == null)
    {
      AppMethodBeat.o(6123);
      return;
    }
    this.uSc.igX = this.ihj;
    this.uSc.igW.b(h.a(this.uSc).getWebView(), new h.3.1(this), null);
    this.uSc.igW.cwt();
    AppMethodBeat.o(6123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.3
 * JD-Core Version:    0.7.0.1
 */