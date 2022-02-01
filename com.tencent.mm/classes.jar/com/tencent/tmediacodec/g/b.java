package com.tencent.tmediacodec.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static String TAG;
  private static String ahUH;
  private static boolean ahUI;
  private static a ahUJ;
  private static int mLogLevel;
  
  static
  {
    AppMethodBeat.i(210873);
    TAG = "LogUtils";
    ahUH = "TMediaCodec";
    mLogLevel = 2;
    ahUI = true;
    ahUJ = new a() {};
    AppMethodBeat.o(210873);
  }
  
  public static void O(String paramString)
  {
    AppMethodBeat.i(210822);
    if (aIZ(3)) {
      new StringBuilder().append(ahUH).append(".").append(paramString);
    }
    AppMethodBeat.o(210822);
  }
  
  public static void Q(String paramString)
  {
    AppMethodBeat.i(210828);
    if (aIZ(4)) {
      new StringBuilder().append(ahUH).append(".").append(paramString);
    }
    AppMethodBeat.o(210828);
  }
  
  public static void R(String paramString)
  {
    AppMethodBeat.i(210835);
    if (aIZ(5)) {
      new StringBuilder().append(ahUH).append(".").append(paramString);
    }
    AppMethodBeat.o(210835);
  }
  
  public static void S(String paramString)
  {
    AppMethodBeat.i(210843);
    if (aIZ(5)) {
      new StringBuilder().append(ahUH).append(".").append(paramString);
    }
    AppMethodBeat.o(210843);
  }
  
  public static void T(String paramString)
  {
    AppMethodBeat.i(210848);
    if (aIZ(6)) {
      new StringBuilder().append(ahUH).append(".").append(paramString);
    }
    AppMethodBeat.o(210848);
  }
  
  public static void U(String paramString)
  {
    AppMethodBeat.i(210856);
    if (aIZ(6)) {
      new StringBuilder().append(ahUH).append(".").append(paramString);
    }
    AppMethodBeat.o(210856);
  }
  
  private static boolean aIZ(int paramInt)
  {
    return (ahUI) && (paramInt >= mLogLevel);
  }
  
  public static void bGt(String paramString)
  {
    AppMethodBeat.i(210815);
    if (aIZ(2)) {
      new StringBuilder().append(ahUH).append(".").append(paramString);
    }
    AppMethodBeat.o(210815);
  }
  
  public static boolean isLogEnable()
  {
    return ahUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.g.b
 * JD-Core Version:    0.7.0.1
 */