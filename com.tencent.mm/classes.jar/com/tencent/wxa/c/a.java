package com.tencent.wxa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a SxO;
  private static a Sya;
  
  static
  {
    AppMethodBeat.i(206333);
    a.1 local1 = new a.1();
    Sya = local1;
    SxO = local1;
    AppMethodBeat.o(206333);
  }
  
  public static void b(a parama)
  {
    SxO = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(206329);
    SxO.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(206329);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(206332);
    SxO.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(206332);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(206330);
    SxO.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(206330);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(206328);
    SxO.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(206328);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(206331);
    SxO.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(206331);
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