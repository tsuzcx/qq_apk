package com.tencent.tav.decoder.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Logger
{
  private static boolean DEBUG = false;
  public static final int MAX_LOG_LENGTH = 4096;
  private static ILog logger;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198062);
    if (logger != null) {
      logger.d(paramString1, paramString2);
    }
    AppMethodBeat.o(198062);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198064);
    if (logger != null) {
      logger.e(paramString1, paramString2);
    }
    AppMethodBeat.o(198064);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(198066);
    if (logger != null) {
      logger.e(paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(198066);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(198065);
    if (logger != null)
    {
      logger.e(paramString, paramThrowable);
      AppMethodBeat.o(198065);
      return;
    }
    if (DEBUG) {
      new StringBuilder().append(paramThrowable.getMessage());
    }
    AppMethodBeat.o(198065);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(198063);
    if (logger != null)
    {
      logger.i(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(198063);
      return;
    }
    if (DEBUG) {
      String.format(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(198063);
  }
  
  public static void longlogd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198069);
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
        AppMethodBeat.o(198069);
        return;
      }
    }
    AppMethodBeat.o(198069);
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
    AppMethodBeat.i(198067);
    if (logger != null) {
      logger.v(paramString1, paramString2);
    }
    AppMethodBeat.o(198067);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198068);
    if (logger != null) {
      logger.w(paramString1, paramString2);
    }
    AppMethodBeat.o(198068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */