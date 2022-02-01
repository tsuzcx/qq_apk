package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

final class c$1
  extends n.a
{
  c$1(c paramc) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(114801);
    if ((g.ajx()) && (g.ajA().gAD))
    {
      g.ajA();
      a.aiE();
    }
    AppMethodBeat.o(114801);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(114800);
    if ((g.ajx()) && (g.ajA().gAD))
    {
      g.ajA();
      if (!a.aiE()) {
        b.Wi().w(new c.1.1(this));
      }
    }
    AppMethodBeat.o(114800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.1
 * JD-Core Version:    0.7.0.1
 */