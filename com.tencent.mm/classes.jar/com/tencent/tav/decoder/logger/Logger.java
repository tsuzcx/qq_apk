package com.tencent.tav.decoder.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Logger
{
  public static final int NO_LOG = 2147483647;
  private static int level;
  private static ILog logProxy;
  
  static
  {
    AppMethodBeat.i(215107);
    level = 3;
    logProxy = new Logger.DefaultLogProxy(null);
    AppMethodBeat.o(215107);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215102);
    if ((logProxy == null) || (level > 3))
    {
      AppMethodBeat.o(215102);
      return;
    }
    logProxy.d(paramString1, paramString2);
    AppMethodBeat.o(215102);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215105);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(215105);
      return;
    }
    logProxy.e(paramString1, paramString2);
    AppMethodBeat.o(215105);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(215106);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(215106);
      return;
    }
    logProxy.e(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(215106);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215103);
    if ((logProxy == null) || (level > 4))
    {
      AppMethodBeat.o(215103);
      return;
    }
    logProxy.i(paramString1, paramString2);
    AppMethodBeat.o(215103);
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
    AppMethodBeat.i(215101);
    if ((logProxy == null) || (level > 2))
    {
      AppMethodBeat.o(215101);
      return;
    }
    logProxy.v(paramString1, paramString2);
    AppMethodBeat.o(215101);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215104);
    if ((logProxy == null) || (level > 5))
    {
      AppMethodBeat.o(215104);
      return;
    }
    logProxy.w(paramString1, paramString2);
    AppMethodBeat.o(215104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */