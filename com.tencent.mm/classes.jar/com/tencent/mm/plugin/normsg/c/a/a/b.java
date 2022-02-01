package com.tencent.mm.plugin.normsg.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final int[] Gyg = { 1, 4, 9, 10, 11 };
  public int Gyh;
  public int Gyi;
  public String Gyj;
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(257662);
    this.Gyj = paramString;
    this.Gyh = paramInt;
    this.Gyi = (paramInt * 20);
    AppMethodBeat.o(257662);
  }
  
  public static boolean OR(long paramLong)
  {
    return paramLong < 15L;
  }
  
  public static boolean OS(long paramLong)
  {
    return paramLong > 25L;
  }
  
  public static int aaC(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    return paramInt * 20 + 2000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */