package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class d
{
  private static c Bmp;
  
  static
  {
    AppMethodBeat.i(73031);
    Bmp = new d.a((byte)0);
    AppMethodBeat.o(73031);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(73024);
    if (paramc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Bmp = paramc;
      AppMethodBeat.o(73024);
      return;
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(73030);
    Bmp.a(paramString1, paramThrowable, paramString2);
    AppMethodBeat.o(73030);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73026);
    Bmp.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73026);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73029);
    Bmp.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73029);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73027);
    Bmp.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73027);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73025);
    Bmp.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73025);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(73028);
    Bmp.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(73028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.c.d
 * JD-Core Version:    0.7.0.1
 */