package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum i$b
{
  final int dEu;
  
  static
  {
    AppMethodBeat.i(151973);
    Fip = new b("DoNothing", 0, 0);
    Fiq = new b("DoCache", 1, 1);
    Fir = new b("DoDecrypt", 2, 2);
    Fis = new b("DoDelete", 3, 4);
    Fit = new b[] { Fip, Fiq, Fir, Fis };
    AppMethodBeat.o(151973);
  }
  
  private i$b(int paramInt)
  {
    this.dEu = paramInt;
  }
  
  static boolean Zh(int paramInt)
  {
    return paramInt == Fip.dEu;
  }
  
  static boolean Zi(int paramInt)
  {
    return (Fiq.dEu & paramInt) > 0;
  }
  
  static boolean Zj(int paramInt)
  {
    return (Fir.dEu & paramInt) > 0;
  }
  
  static boolean Zk(int paramInt)
  {
    return (Fis.dEu & paramInt) > 0;
  }
  
  static int aNx(String paramString)
  {
    AppMethodBeat.i(151972);
    if ("cache".equals(paramString))
    {
      i = Fiq.dEu;
      AppMethodBeat.o(151972);
      return i;
    }
    if ("delete".equals(paramString))
    {
      i = Fis.dEu;
      AppMethodBeat.o(151972);
      return i;
    }
    if ("decrypt".equals(paramString))
    {
      i = Fir.dEu;
      AppMethodBeat.o(151972);
      return i;
    }
    int i = Fip.dEu;
    AppMethodBeat.o(151972);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.i.b
 * JD-Core Version:    0.7.0.1
 */