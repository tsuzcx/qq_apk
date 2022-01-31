package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Log
{
  public static void d(String paramString, Object paramObject)
  {
    AppMethodBeat.i(19);
    if (!Config.DEBUG)
    {
      AppMethodBeat.o(19);
      return;
    }
    String.valueOf(paramObject);
    AppMethodBeat.o(19);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!Config.DEBUG) {}
  }
  
  public static void e(String paramString1, String paramString2)
  {
    boolean bool = Config.DEBUG;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    boolean bool = Config.DEBUG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Log
 * JD-Core Version:    0.7.0.1
 */