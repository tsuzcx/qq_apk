package com.tencent.mm.vending.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a HPV = null;
  
  public static void a(a parama)
  {
    HPV = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(74938);
    if (HPV != null) {
      HPV.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(74938);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(74935);
    if (HPV != null) {
      HPV.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(74935);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(74937);
    if (HPV != null) {
      HPV.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(74937);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(74939);
    if (HPV != null) {
      HPV.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(74939);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(74936);
    if (HPV != null) {
      HPV.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(74936);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.f.a
 * JD-Core Version:    0.7.0.1
 */