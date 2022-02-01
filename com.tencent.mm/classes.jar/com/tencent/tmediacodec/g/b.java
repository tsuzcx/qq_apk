package com.tencent.tmediacodec.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static String SmV;
  private static boolean SmW;
  private static a SmX;
  private static String TAG;
  private static int mLogLevel;
  
  static
  {
    AppMethodBeat.i(190190);
    TAG = "LogUtils";
    SmV = "TMediaCodec";
    mLogLevel = 2;
    SmW = true;
    SmX = new a() {};
    AppMethodBeat.o(190190);
  }
  
  private static boolean asw(int paramInt)
  {
    return (SmW) && (paramInt >= mLogLevel);
  }
  
  public static void bqP(String paramString)
  {
    AppMethodBeat.i(190183);
    if (asw(2)) {
      new StringBuilder().append(SmV).append(".").append(paramString);
    }
    AppMethodBeat.o(190183);
  }
  
  public static void bqQ(String paramString)
  {
    AppMethodBeat.i(190184);
    if (asw(3)) {
      new StringBuilder().append(SmV).append(".").append(paramString);
    }
    AppMethodBeat.o(190184);
  }
  
  public static void bqR(String paramString)
  {
    AppMethodBeat.i(190185);
    if (asw(4)) {
      new StringBuilder().append(SmV).append(".").append(paramString);
    }
    AppMethodBeat.o(190185);
  }
  
  public static void bqS(String paramString)
  {
    AppMethodBeat.i(190186);
    if (asw(5)) {
      new StringBuilder().append(SmV).append(".").append(paramString);
    }
    AppMethodBeat.o(190186);
  }
  
  public static void bqT(String paramString)
  {
    AppMethodBeat.i(190187);
    if (asw(5)) {
      new StringBuilder().append(SmV).append(".").append(paramString);
    }
    AppMethodBeat.o(190187);
  }
  
  public static void bqU(String paramString)
  {
    AppMethodBeat.i(190188);
    if (asw(6)) {
      new StringBuilder().append(SmV).append(".").append(paramString);
    }
    AppMethodBeat.o(190188);
  }
  
  public static void bqV(String paramString)
  {
    AppMethodBeat.i(190189);
    if (asw(6)) {
      new StringBuilder().append(SmV).append(".").append(paramString);
    }
    AppMethodBeat.o(190189);
  }
  
  public static boolean isLogEnable()
  {
    return SmW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.g.b
 * JD-Core Version:    0.7.0.1
 */