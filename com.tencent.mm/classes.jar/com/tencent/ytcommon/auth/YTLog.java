package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class YTLog
{
  public static void d(String paramString, Object paramObject)
  {
    AppMethodBeat.i(2631);
    if (!Config.DEBUG)
    {
      AppMethodBeat.o(2631);
      return;
    }
    String.valueOf(paramObject);
    AppMethodBeat.o(2631);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ytcommon.auth.YTLog
 * JD-Core Version:    0.7.0.1
 */