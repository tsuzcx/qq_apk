package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum i$a
{
  final int cUP;
  
  static
  {
    AppMethodBeat.i(151969);
    QZJ = new a("ENCRYPTION", 0, 1);
    QZK = new a("COMPRESSION", 1, 2);
    QZL = new a[] { QZJ, QZK };
    AppMethodBeat.o(151969);
  }
  
  private i$a(int paramInt)
  {
    this.cUP = paramInt;
  }
  
  static boolean apQ(int paramInt)
  {
    return (QZJ.cUP & paramInt) > 0;
  }
  
  static boolean apR(int paramInt)
  {
    return (QZK.cUP & paramInt) > 0;
  }
  
  static int apS(int paramInt)
  {
    return QZK.cUP | paramInt;
  }
  
  static int his()
  {
    return QZJ.cUP | 0x0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.i.a
 * JD-Core Version:    0.7.0.1
 */