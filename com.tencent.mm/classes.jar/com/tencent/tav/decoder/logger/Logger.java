package com.tencent.tav.decoder.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Logger
{
  public static final int NO_LOG = 2147483647;
  private static int level;
  private static ILog logProxy;
  
  static
  {
    AppMethodBeat.i(192140);
    level = 3;
    logProxy = new DefaultLogProxy(null);
    AppMethodBeat.o(192140);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192120);
    if ((logProxy == null) || (level > 3))
    {
      AppMethodBeat.o(192120);
      return;
    }
    logProxy.d(paramString1, paramString2);
    AppMethodBeat.o(192120);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192132);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(192132);
      return;
    }
    logProxy.e(paramString1, paramString2);
    AppMethodBeat.o(192132);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(192136);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(192136);
      return;
    }
    logProxy.e(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(192136);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192124);
    if ((logProxy == null) || (level > 4))
    {
      AppMethodBeat.o(192124);
      return;
    }
    logProxy.i(paramString1, paramString2);
    AppMethodBeat.o(192124);
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
    AppMethodBeat.i(192117);
    if ((logProxy == null) || (level > 2))
    {
      AppMethodBeat.o(192117);
      return;
    }
    logProxy.v(paramString1, paramString2);
    AppMethodBeat.o(192117);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192127);
    if ((logProxy == null) || (level > 5))
    {
      AppMethodBeat.o(192127);
      return;
    }
    logProxy.w(paramString1, paramString2);
    AppMethodBeat.o(192127);
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