package com.tencent.tav.decoder.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Logger
{
  private static boolean DEBUG = false;
  public static final int MAX_LOG_LENGTH = 4096;
  private static ILog logger;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202001);
    if (logger != null) {
      logger.d(paramString1, paramString2);
    }
    AppMethodBeat.o(202001);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202003);
    if (logger != null) {
      logger.e(paramString1, paramString2);
    }
    AppMethodBeat.o(202003);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(202005);
    if (logger != null) {
      logger.e(paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(202005);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(202004);
    if (logger != null)
    {
      logger.e(paramString, paramThrowable);
      AppMethodBeat.o(202004);
      return;
    }
    if (DEBUG) {
      new StringBuilder().append(paramThrowable.getMessage());
    }
    AppMethodBeat.o(202004);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(202002);
    if (logger != null)
    {
      logger.i(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(202002);
      return;
    }
    if (DEBUG) {
      String.format(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(202002);
  }
  
  public static void longlogd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202008);
    int m = paramString2.length();
    int i = 4096;
    int j = 0;
    int k = 0;
    while (j < 100) {
      if (m > i)
      {
        d(paramString1 + j, paramString2.substring(k, i));
        j += 1;
        k = i;
        i += 4096;
      }
      else
      {
        d(paramString1, paramString2.substring(k, m));
        AppMethodBeat.o(202008);
        return;
      }
    }
    AppMethodBeat.o(202008);
  }
  
  public static void setLogAble(boolean paramBoolean)
  {
    DEBUG = paramBoolean;
  }
  
  public static void setLogger(ILog paramILog)
  {
    logger = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202006);
    if (logger != null) {
      logger.v(paramString1, paramString2);
    }
    AppMethodBeat.o(202006);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202007);
    if (logger != null) {
      logger.w(paramString1, paramString2);
    }
    AppMethodBeat.o(202007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */