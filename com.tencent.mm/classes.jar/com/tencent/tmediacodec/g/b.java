package com.tencent.tmediacodec.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static String TAG;
  private static String ZPG;
  private static boolean ZPH;
  private static a ZPI;
  private static int mLogLevel;
  
  static
  {
    AppMethodBeat.i(224604);
    TAG = "LogUtils";
    ZPG = "TMediaCodec";
    mLogLevel = 2;
    ZPH = true;
    ZPI = new a() {};
    AppMethodBeat.o(224604);
  }
  
  private static boolean aCk(int paramInt)
  {
    return (ZPH) && (paramInt >= mLogLevel);
  }
  
  public static void bDO(String paramString)
  {
    AppMethodBeat.i(224591);
    if (aCk(2)) {
      new StringBuilder().append(ZPG).append(".").append(paramString);
    }
    AppMethodBeat.o(224591);
  }
  
  public static void bDP(String paramString)
  {
    AppMethodBeat.i(224592);
    if (aCk(3)) {
      new StringBuilder().append(ZPG).append(".").append(paramString);
    }
    AppMethodBeat.o(224592);
  }
  
  public static void bDQ(String paramString)
  {
    AppMethodBeat.i(224593);
    if (aCk(4)) {
      new StringBuilder().append(ZPG).append(".").append(paramString);
    }
    AppMethodBeat.o(224593);
  }
  
  public static void bDR(String paramString)
  {
    AppMethodBeat.i(224594);
    if (aCk(5)) {
      new StringBuilder().append(ZPG).append(".").append(paramString);
    }
    AppMethodBeat.o(224594);
  }
  
  public static void bDS(String paramString)
  {
    AppMethodBeat.i(224595);
    if (aCk(5)) {
      new StringBuilder().append(ZPG).append(".").append(paramString);
    }
    AppMethodBeat.o(224595);
  }
  
  public static void bDT(String paramString)
  {
    AppMethodBeat.i(224596);
    if (aCk(6)) {
      new StringBuilder().append(ZPG).append(".").append(paramString);
    }
    AppMethodBeat.o(224596);
  }
  
  public static void bDU(String paramString)
  {
    AppMethodBeat.i(224599);
    if (aCk(6)) {
      new StringBuilder().append(ZPG).append(".").append(paramString);
    }
    AppMethodBeat.o(224599);
  }
  
  public static boolean isLogEnable()
  {
    return ZPH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.g.b
 * JD-Core Version:    0.7.0.1
 */