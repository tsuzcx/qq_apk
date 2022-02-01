package com.tencent.tav.decoder.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Formatter;

public class Logger
{
  public static final int NO_LOG = 2147483647;
  private static int level;
  private static ILog logProxy;
  
  static
  {
    AppMethodBeat.i(216371);
    level = 3;
    logProxy = new DefaultLogProxy(null);
    AppMethodBeat.o(216371);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216299);
    if ((logProxy == null) || (level > 3))
    {
      AppMethodBeat.o(216299);
      return;
    }
    logProxy.d(paramString1, paramString2);
    AppMethodBeat.o(216299);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216308);
    if ((logProxy == null) || (level > 3))
    {
      AppMethodBeat.o(216308);
      return;
    }
    d(paramString1, new Formatter().format(paramString2, paramVarArgs).toString());
    AppMethodBeat.o(216308);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216345);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(216345);
      return;
    }
    logProxy.e(paramString1, paramString2);
    AppMethodBeat.o(216345);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(216361);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(216361);
      return;
    }
    logProxy.e(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(216361);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216353);
    e(paramString1, new Formatter().format(paramString2, paramVarArgs).toString());
    AppMethodBeat.o(216353);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216318);
    if ((logProxy == null) || (level > 4))
    {
      AppMethodBeat.o(216318);
      return;
    }
    logProxy.i(paramString1, paramString2);
    AppMethodBeat.o(216318);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216328);
    if ((logProxy == null) || (level > 4))
    {
      AppMethodBeat.o(216328);
      return;
    }
    i(paramString1, new Formatter().format(paramString2, paramVarArgs).toString());
    AppMethodBeat.o(216328);
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
    AppMethodBeat.i(216284);
    if ((logProxy == null) || (level > 2))
    {
      AppMethodBeat.o(216284);
      return;
    }
    logProxy.v(paramString1, paramString2);
    AppMethodBeat.o(216284);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216337);
    if ((logProxy == null) || (level > 5))
    {
      AppMethodBeat.o(216337);
      return;
    }
    logProxy.w(paramString1, paramString2);
    AppMethodBeat.o(216337);
  }
  
  static class DefaultLogProxy
    implements ILog
  {
    public void d(String paramString1, String paramString2) {}
    
    public void e(String paramString1, String paramString2) {}
    
    public void e(String paramString1, String paramString2, Throwable paramThrowable) {}
    
    public void i(String paramString1, String paramString2) {}
    
    public void v(String paramString1, String paramString2) {}
    
    public void w(String paramString1, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */