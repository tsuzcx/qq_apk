package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.ILog;

public class Logger
{
  private static ILog mILog;
  
  static
  {
    AppMethodBeat.i(105521);
    mILog = new Logger.1();
    AppMethodBeat.o(105521);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105513);
    if (mILog != null) {
      mILog.d(paramString1, paramString2);
    }
    AppMethodBeat.o(105513);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105515);
    if (mILog != null) {
      mILog.e(paramString1, paramString2);
    }
    AppMethodBeat.o(105515);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(105518);
    if (mILog != null) {
      mILog.e(paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(105518);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(105519);
    if (mILog != null) {
      mILog.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(105519);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(105517);
    if (mILog != null) {
      mILog.e(paramString, paramThrowable);
    }
    AppMethodBeat.o(105517);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105516);
    if (mILog != null) {
      mILog.i(paramString1, paramString2);
    }
    AppMethodBeat.o(105516);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(105520);
    if (mILog != null) {
      mILog.i(paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(105520);
  }
  
  public static void setLog(ILog paramILog)
  {
    mILog = paramILog;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105514);
    if (mILog != null) {
      mILog.w(paramString1, paramString2);
    }
    AppMethodBeat.o(105514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Logger
 * JD-Core Version:    0.7.0.1
 */