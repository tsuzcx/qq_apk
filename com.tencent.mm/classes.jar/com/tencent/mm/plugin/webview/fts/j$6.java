package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.Log;

final class j$6
  implements h.a
{
  j$6(j paramj) {}
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(210845);
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "handleCallback %s", new Object[] { paramb });
    if (paramb == null)
    {
      AppMethodBeat.o(210845);
      return;
    }
    int i = ((Integer)paramb.IOM).intValue();
    paramb = (j.a)paramb.ION;
    if (paramb == null)
    {
      AppMethodBeat.o(210845);
      return;
    }
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramb.dVP, j.c(this.IPq) });
    g.ahd(i).a(paramb.data, paramb.IPu, paramb.dVP, paramb.dNV);
    AppMethodBeat.o(210845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.j.6
 * JD-Core Version:    0.7.0.1
 */