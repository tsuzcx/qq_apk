package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

final class p$1
  extends n.a
{
  p$1(p paramp) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(114621);
    if ((g.afw()) && (g.afz().gcn))
    {
      g.afz();
      a.aeC();
    }
    AppMethodBeat.o(114621);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(114620);
    if ((g.afw()) && (g.afz().gcn))
    {
      g.afz();
      if (!a.aeC()) {
        b.SX().v(new p.1.1(this));
      }
    }
    AppMethodBeat.o(114620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p.1
 * JD-Core Version:    0.7.0.1
 */