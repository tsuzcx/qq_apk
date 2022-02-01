package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

final class z$1
  extends o.a
{
  z$1(z paramz) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(114621);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      a.aiT();
    }
    AppMethodBeat.o(114621);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(114620);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!a.aiT()) {
        b.Wq().u(new z.1.1(this));
      }
    }
    AppMethodBeat.o(114620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.z.1
 * JD-Core Version:    0.7.0.1
 */