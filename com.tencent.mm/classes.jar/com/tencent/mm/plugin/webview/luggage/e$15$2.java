package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$15$2
  implements Runnable
{
  e$15$2(e.15 param15, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(153100);
    e locale = this.uRX.uRQ;
    String str = this.fOX;
    locale.bzs.bzf.loadData(str, "text/html", "utf-8");
    AppMethodBeat.o(153100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.15.2
 * JD-Core Version:    0.7.0.1
 */