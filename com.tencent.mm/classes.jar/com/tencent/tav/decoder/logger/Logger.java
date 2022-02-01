package com.tencent.tav.decoder.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Logger
{
  public static final int NO_LOG = 2147483647;
  private static int level;
  private static ILog logProxy;
  
  static
  {
    AppMethodBeat.i(218458);
    level = 3;
    logProxy = new Logger.DefaultLogProxy(null);
    AppMethodBeat.o(218458);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218453);
    if ((logProxy == null) || (level > 3))
    {
      AppMethodBeat.o(218453);
      return;
    }
    logProxy.d(paramString1, paramString2);
    AppMethodBeat.o(218453);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218456);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(218456);
      return;
    }
    logProxy.e(paramString1, paramString2);
    AppMethodBeat.o(218456);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(218457);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(218457);
      return;
    }
    logProxy.e(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(218457);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218454);
    if ((logProxy == null) || (level > 4))
    {
      AppMethodBeat.o(218454);
      return;
    }
    logProxy.i(paramString1, paramString2);
    AppMethodBeat.o(218454);
  }
  
  public static void setLevel(int paramInt)
  {
    level = paramInt;
  }
  
  public static void setLogProxy(ILog paramILog)
  {
    logProxy = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218452);
    if ((logProxy == null) || (level > 2))
    {
      AppMethodBeat.o(218452);
      return;
    }
    logProxy.v(paramString1, paramString2);
    AppMethodBeat.o(218452);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218455);
    if ((logProxy == null) || (level > 5))
    {
      AppMethodBeat.o(218455);
      return;
    }
    logProxy.w(paramString1, paramString2);
    AppMethodBeat.o(218455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */