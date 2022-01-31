package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ab;

final class g$69
  implements Runnable
{
  g$69(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(154990);
    if (g.B(this.vqm) != null) {
      g.B(this.vqm).c(g.C(this.vqm));
    }
    if (g.C(this.vqm) == null)
    {
      ab.w("MicroMsg.MsgHandler", "already callback");
      AppMethodBeat.o(154990);
      return;
    }
    g.D(this.vqm);
    this.vqm.a(g.k(this.vqm), "geo_location:fail_timeout", null);
    AppMethodBeat.o(154990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.69
 * JD-Core Version:    0.7.0.1
 */