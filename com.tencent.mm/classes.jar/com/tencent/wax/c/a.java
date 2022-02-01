package com.tencent.wax.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a MHL;
  private static a MHW;
  
  static
  {
    AppMethodBeat.i(195520);
    a.1 local1 = new a.1();
    MHW = local1;
    MHL = local1;
    AppMethodBeat.o(195520);
  }
  
  public static void b(a parama)
  {
    MHL = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195516);
    MHL.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(195516);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195519);
    MHL.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(195519);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195517);
    MHL.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(195517);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195515);
    MHL.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(195515);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195518);
    MHL.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(195518);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.c.a
 * JD-Core Version:    0.7.0.1
 */