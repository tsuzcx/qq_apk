package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.kernel.g;

final class c$1
  extends n.a
{
  c$1(c paramc) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(110787);
    if ((g.ajx()) && (g.ajA().gAD))
    {
      g.ajA();
      if (!com.tencent.mm.kernel.a.aiE())
      {
        paramString = new zm();
        paramString.dOM.dkM = 3;
        com.tencent.mm.sdk.b.a.IbL.l(paramString);
      }
    }
    AppMethodBeat.o(110787);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(110786);
    if ((g.ajx()) && (g.ajA().gAD))
    {
      g.ajA();
      if (!com.tencent.mm.kernel.a.aiE())
      {
        paramString = new zm();
        paramString.dOM.dkM = 5;
        com.tencent.mm.sdk.b.a.IbL.l(paramString);
      }
    }
    AppMethodBeat.o(110786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.1
 * JD-Core Version:    0.7.0.1
 */