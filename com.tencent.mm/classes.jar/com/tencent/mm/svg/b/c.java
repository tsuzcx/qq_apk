package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static a Hdt = null;
  
  public static void b(a parama)
  {
    Hdt = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(148765);
    if (Hdt != null) {
      Hdt.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(148765);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(148762);
    if (Hdt != null) {
      Hdt.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(148762);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(148764);
    if (Hdt != null) {
      Hdt.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(148764);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(148766);
    if (Hdt != null) {
      Hdt.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(148766);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(148763);
    if (Hdt != null) {
      Hdt.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(148763);
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
 * Qualified Name:     com.tencent.mm.svg.b.c
 * JD-Core Version:    0.7.0.1
 */