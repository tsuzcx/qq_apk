package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static c ahxc;
  
  static
  {
    AppMethodBeat.i(88658);
    ahxc = new d.a((byte)0);
    AppMethodBeat.o(88658);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(88651);
    if (paramc == null)
    {
      paramc = new RuntimeException("logInstance can not be null");
      AppMethodBeat.o(88651);
      throw paramc;
    }
    ahxc = paramc;
    AppMethodBeat.o(88651);
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    AppMethodBeat.i(88657);
    ahxc.a(paramString1, paramThrowable, paramString2);
    AppMethodBeat.o(88657);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(88653);
    ahxc.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(88653);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(88656);
    ahxc.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(88656);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(88654);
    ahxc.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(88654);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(88652);
    ahxc.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(88652);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(88655);
    ahxc.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(88655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.core.c.d
 * JD-Core Version:    0.7.0.1
 */