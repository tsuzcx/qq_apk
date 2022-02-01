package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum i$b
{
  final int cUP;
  
  static
  {
    AppMethodBeat.i(151973);
    QZM = new b("DoNothing", 0, 0);
    QZN = new b("DoCache", 1, 1);
    QZO = new b("DoDecrypt", 2, 2);
    QZP = new b("DoDelete", 3, 4);
    QZQ = new b[] { QZM, QZN, QZO, QZP };
    AppMethodBeat.o(151973);
  }
  
  private i$b(int paramInt)
  {
    this.cUP = paramInt;
  }
  
  static boolean apT(int paramInt)
  {
    return paramInt == QZM.cUP;
  }
  
  static boolean apU(int paramInt)
  {
    return (QZN.cUP & paramInt) > 0;
  }
  
  static boolean apV(int paramInt)
  {
    return (QZO.cUP & paramInt) > 0;
  }
  
  static boolean apW(int paramInt)
  {
    return (QZP.cUP & paramInt) > 0;
  }
  
  static int bqv(String paramString)
  {
    AppMethodBeat.i(151972);
    if ("cache".equals(paramString))
    {
      i = QZN.cUP;
      AppMethodBeat.o(151972);
      return i;
    }
    if ("delete".equals(paramString))
    {
      i = QZP.cUP;
      AppMethodBeat.o(151972);
      return i;
    }
    if ("decrypt".equals(paramString))
    {
      i = QZO.cUP;
      AppMethodBeat.o(151972);
      return i;
    }
    int i = QZM.cUP;
    AppMethodBeat.o(151972);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.i.b
 * JD-Core Version:    0.7.0.1
 */