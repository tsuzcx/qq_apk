package com.tencent.mm.plugin.u.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static a wVP;
  private static b wVQ;
  
  static
  {
    AppMethodBeat.i(224041);
    wVP = new a() {};
    wVQ = new b() {};
    AppMethodBeat.o(224041);
  }
  
  public static a dBH()
  {
    AppMethodBeat.i(224040);
    a locala = (a)com.tencent.mm.kernel.g.ab(a.class);
    if (locala != null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1490L, 0L, 1L, false);
      AppMethodBeat.o(224040);
      return locala;
    }
    locala = wVP;
    AppMethodBeat.o(224040);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.c
 * JD-Core Version:    0.7.0.1
 */