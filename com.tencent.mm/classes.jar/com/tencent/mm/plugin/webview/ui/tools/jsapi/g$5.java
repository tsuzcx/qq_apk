package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$5
  implements Runnable
{
  g$5(g paramg, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(154925);
    if (this.uZa.vrQ.equals("login"))
    {
      g.a(this.vqm, this.uZa, g.dgO());
      AppMethodBeat.o(154925);
      return;
    }
    if (this.uZa.vrQ.equals("authorize")) {
      g.b(this.vqm, this.uZa, g.dgO());
    }
    AppMethodBeat.o(154925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.5
 * JD-Core Version:    0.7.0.1
 */