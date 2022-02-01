package com.tencent.mm.plugin.normsg.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final int[] Muo = { 1, 4, 9, 10, 11 };
  public int Mup;
  public int Muq;
  public String Mur;
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(261908);
    this.Mur = paramString;
    this.Mup = paramInt;
    this.Muq = (paramInt * 20);
    AppMethodBeat.o(261908);
  }
  
  public static int aeV(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    return paramInt * 20 + 2000;
  }
  
  public static boolean sU(long paramLong)
  {
    return paramLong < 15L;
  }
  
  public static boolean sV(long paramLong)
  {
    return paramLong > 25L;
  }
  
  public final boolean gtT()
  {
    return this.Mup > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */