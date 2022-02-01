package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
{
  private static long Ljk = 0L;
  private static long Ljl = 0L;
  private static int Ljm = 0;
  private static int wUT;
  private static int wUU;
  private static int wUV;
  private static int wUW;
  private static int wUX;
  private static int wUY;
  private static int wUZ;
  private static int wVa;
  private static int wVb;
  
  static void abr(int paramInt)
  {
    wUT = paramInt;
  }
  
  static void abs(int paramInt)
  {
    wUU = paramInt;
  }
  
  static void abt(int paramInt)
  {
    wUV = paramInt;
  }
  
  static void abu(int paramInt)
  {
    wUW = paramInt;
  }
  
  static void abv(int paramInt)
  {
    wUX = paramInt;
  }
  
  static void abw(int paramInt)
  {
    wUY = paramInt;
  }
  
  static void abx(int paramInt)
  {
    wUZ = paramInt;
  }
  
  static void aby(int paramInt)
  {
    wVa = paramInt;
  }
  
  static void abz(int paramInt)
  {
    wVb = paramInt;
  }
  
  static afj geo()
  {
    AppMethodBeat.i(285201);
    afj localafj = new afj();
    localafj.wUT = wUT;
    localafj.wUU = wUU;
    localafj.wUV = wUV;
    localafj.wVa = wVa;
    localafj.wUZ = wUZ;
    localafj.wUX = wUX;
    localafj.wUW = wUW;
    localafj.wUY = wUY;
    localafj.wVb = wVb;
    localafj.ZnL = Ljk;
    localafj.ZnM = Ljl;
    localafj.ZnN = Ljm;
    Log.i("MicroMsg.ILinkReporter", "amyfwang,interrupt_cnt:%d", new Object[] { Integer.valueOf(Ljm) });
    AppMethodBeat.o(285201);
    return localafj;
  }
  
  static void n(long paramLong1, long paramLong2, int paramInt)
  {
    Ljk = paramLong1;
    Ljl = paramLong2;
    Ljm = paramInt;
  }
  
  static void reset()
  {
    wUT = 0;
    wUU = 0;
    wUV = 0;
    wUW = 0;
    wUX = 0;
    wUY = 0;
    wUZ = 0;
    wVa = 0;
    wVb = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.n
 * JD-Core Version:    0.7.0.1
 */