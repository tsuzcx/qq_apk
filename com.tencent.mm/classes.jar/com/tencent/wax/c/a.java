package com.tencent.wax.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a MkN;
  private static a MkZ;
  
  static
  {
    AppMethodBeat.i(217511);
    a.1 local1 = new a.1();
    MkZ = local1;
    MkN = local1;
    AppMethodBeat.o(217511);
  }
  
  public static void b(a parama)
  {
    MkN = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217508);
    MkN.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(217508);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217509);
    MkN.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(217509);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217507);
    MkN.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(217507);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217510);
    MkN.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(217510);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.c.a
 * JD-Core Version:    0.7.0.1
 */