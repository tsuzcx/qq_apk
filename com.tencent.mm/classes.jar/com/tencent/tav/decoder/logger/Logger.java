package com.tencent.tav.decoder.logger;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Logger
{
  public static final int NO_LOG = 2147483647;
  private static int level;
  private static ILog logProxy;
  
  static
  {
    AppMethodBeat.i(218467);
    level = 3;
    logProxy = new DefaultLogProxy(null);
    AppMethodBeat.o(218467);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218462);
    if ((logProxy == null) || (level > 3))
    {
      AppMethodBeat.o(218462);
      return;
    }
    logProxy.d(paramString1, paramString2);
    AppMethodBeat.o(218462);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218465);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(218465);
      return;
    }
    logProxy.e(paramString1, paramString2);
    AppMethodBeat.o(218465);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(218466);
    if ((logProxy == null) || (level > 6))
    {
      AppMethodBeat.o(218466);
      return;
    }
    logProxy.e(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(218466);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218463);
    if ((logProxy == null) || (level > 4))
    {
      AppMethodBeat.o(218463);
      return;
    }
    logProxy.i(paramString1, paramString2);
    AppMethodBeat.o(218463);
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
    AppMethodBeat.i(218461);
    if ((logProxy == null) || (level > 2))
    {
      AppMethodBeat.o(218461);
      return;
    }
    logProxy.v(paramString1, paramString2);
    AppMethodBeat.o(218461);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218464);
    if ((logProxy == null) || (level > 5))
    {
      AppMethodBeat.o(218464);
      return;
    }
    logProxy.w(paramString1, paramString2);
    AppMethodBeat.o(218464);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */