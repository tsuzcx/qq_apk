package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class q$a
  implements a
{
  private g ISU;
  private com.tencent.mm.plugin.webview.f.c ITv;
  private Set<String> IUN;
  
  public q$a(g paramg, com.tencent.mm.plugin.webview.f.c paramc)
  {
    AppMethodBeat.i(210935);
    this.IUN = new HashSet();
    this.ISU = paramg;
    this.ITv = paramc;
    AppMethodBeat.o(210935);
  }
  
  public final void a(com.tencent.luggage.d.a.c paramc)
  {
    AppMethodBeat.i(210937);
    paramc.a(b.cua);
    AppMethodBeat.o(210937);
  }
  
  public final void a(String paramString, com.tencent.luggage.d.a.c paramc)
  {
    AppMethodBeat.i(210938);
    if (this.IUN.contains(paramString))
    {
      this.IUN.remove(paramString);
      paramc.a(b.cua);
      AppMethodBeat.o(210938);
      return;
    }
    if (this.ITv.gs(this.ISU.getUrl(), com.tencent.mm.plugin.webview.f.c.aZG(paramString))) {}
    for (paramString = b.cua;; paramString = b.cub)
    {
      paramc.a(paramString);
      AppMethodBeat.o(210938);
      return;
    }
  }
  
  public final void aYu(String paramString)
  {
    AppMethodBeat.i(210936);
    this.IUN.add(paramString);
    AppMethodBeat.o(210936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q.a
 * JD-Core Version:    0.7.0.1
 */