package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.kernel.g;

final class ag$3
  extends j.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(155719);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new ol();
        paramString.cEZ.state = 0;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
        paramString = new tx();
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(155719);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(155718);
    if ((g.RG()) && (g.RJ().eHg))
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP())
      {
        paramString = new ol();
        paramString.cEZ.state = 1;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(155718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag.3
 * JD-Core Version:    0.7.0.1
 */