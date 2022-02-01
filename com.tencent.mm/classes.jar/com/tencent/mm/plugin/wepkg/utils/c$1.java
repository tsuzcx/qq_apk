package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.kernel.g;

final class c$1
  extends o.a
{
  c$1(c paramc) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(110787);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!com.tencent.mm.kernel.a.aiT())
      {
        paramString = new zs();
        paramString.dQc.dlO = 3;
        com.tencent.mm.sdk.b.a.IvT.l(paramString);
      }
    }
    AppMethodBeat.o(110787);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(110786);
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!com.tencent.mm.kernel.a.aiT())
      {
        paramString = new zs();
        paramString.dQc.dlO = 5;
        com.tencent.mm.sdk.b.a.IvT.l(paramString);
      }
    }
    AppMethodBeat.o(110786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.1
 * JD-Core Version:    0.7.0.1
 */