package com.tencent.voip.mars.xlog;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Xlog
  implements Log.LogImp
{
  public static final int AppednerModeAsync = 0;
  public static final int AppednerModeSync = 1;
  public static final int LEVEL_ALL = 0;
  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 4;
  public static final int LEVEL_FATAL = 5;
  public static final int LEVEL_INFO = 2;
  public static final int LEVEL_NONE = 6;
  public static final int LEVEL_VERBOSE = 0;
  public static final int LEVEL_WARNING = 3;
  
  public static native void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4);
  
  private static String decryptTag(String paramString)
  {
    return paramString;
  }
  
  public static native void logWrite(Xlog.XLoggerInfo paramXLoggerInfo, String paramString);
  
  public static native void logWrite2(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString4);
  
  public static void open(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(92817);
    if (paramBoolean)
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("wechatxlog");
    }
    appenderOpen(paramInt1, paramInt2, paramString1, paramString2, paramString3, 0, paramString4);
    AppMethodBeat.o(92817);
  }
  
  public static native void setAppenderMode(int paramInt);
  
  public static native void setConsoleLogOpen(boolean paramBoolean);
  
  public static native void setErrLogOpen(boolean paramBoolean);
  
  public static native void setLogLevel(int paramInt);
  
  public static native void setMaxAliveTime(long paramLong);
  
  public static native void setMaxFileSize(long paramLong);
  
  public native void appenderClose();
  
  public native void appenderFlush(boolean paramBoolean);
  
  public native int getLogLevel();
  
  public void logD(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92819);
    logWrite2(1, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(92819);
  }
  
  public void logE(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92822);
    logWrite2(4, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(92822);
  }
  
  public void logF(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92823);
    logWrite2(5, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(92823);
  }
  
  public void logI(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92820);
    logWrite2(2, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(92820);
  }
  
  public void logV(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92818);
    logWrite2(0, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(92818);
  }
  
  public void logW(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92821);
    logWrite2(3, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(92821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.voip.mars.xlog.Xlog
 * JD-Core Version:    0.7.0.1
 */