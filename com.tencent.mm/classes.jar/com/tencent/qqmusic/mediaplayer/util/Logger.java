package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.ILog;

public class Logger
{
  private static ILog mILog;
  
  static
  {
    AppMethodBeat.i(87707);
    mILog = new Logger.1();
    AppMethodBeat.o(87707);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87699);
    if (mILog != null) {
      mILog.d(paramString1, paramString2);
    }
    AppMethodBeat.o(87699);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87701);
    if (mILog != null) {
      mILog.e(paramString1, paramString2);
    }
    AppMethodBeat.o(87701);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(87704);
    if (mILog != null) {
      mILog.e(paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(87704);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(87705);
    if (mILog != null) {
      mILog.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(87705);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(87703);
    if (mILog != null) {
      mILog.e(paramString, paramThrowable);
    }
    AppMethodBeat.o(87703);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87702);
    if (mILog != null) {
      mILog.i(paramString1, paramString2);
    }
    AppMethodBeat.o(87702);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(87706);
    if (mILog != null) {
      mILog.i(paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(87706);
  }
  
  public static void setLog(ILog paramILog)
  {
    mILog = paramILog;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87700);
    if (mILog != null) {
      mILog.w(paramString1, paramString2);
    }
    AppMethodBeat.o(87700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Logger
 * JD-Core Version:    0.7.0.1
 */