package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum i$a
{
  final int dEu;
  
  static
  {
    AppMethodBeat.i(151969);
    Fim = new a("ENCRYPTION", 0, 1);
    Fin = new a("COMPRESSION", 1, 2);
    Fio = new a[] { Fim, Fin };
    AppMethodBeat.o(151969);
  }
  
  private i$a(int paramInt)
  {
    this.dEu = paramInt;
  }
  
  static boolean Ze(int paramInt)
  {
    return (Fim.dEu & paramInt) > 0;
  }
  
  static boolean Zf(int paramInt)
  {
    return (Fin.dEu & paramInt) > 0;
  }
  
  static int Zg(int paramInt)
  {
    return Fin.dEu | paramInt;
  }
  
  static int feB()
  {
    return Fim.dEu | 0x0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.i.a
 * JD-Core Version:    0.7.0.1
 */