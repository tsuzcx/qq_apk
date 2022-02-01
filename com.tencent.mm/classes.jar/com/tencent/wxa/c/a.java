package com.tencent.wxa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a ZYS;
  private static a ZZh;
  
  static
  {
    AppMethodBeat.i(224851);
    a.1 local1 = new a.1();
    ZZh = local1;
    ZYS = local1;
    AppMethodBeat.o(224851);
  }
  
  public static void b(a parama)
  {
    ZYS = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(224845);
    ZYS.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(224845);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(224849);
    ZYS.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(224849);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(224846);
    ZYS.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(224846);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(224844);
    ZYS.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(224844);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(224847);
    ZYS.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(224847);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.c.a
 * JD-Core Version:    0.7.0.1
 */