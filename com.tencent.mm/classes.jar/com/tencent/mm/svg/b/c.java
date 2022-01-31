package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static a ySG = null;
  
  public static void b(a parama)
  {
    ySG = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(70130);
    if (ySG != null) {
      ySG.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(70130);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(70128);
    if (ySG != null) {
      ySG.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(70128);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(70129);
    if (ySG != null) {
      ySG.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(70129);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(70131);
    if (ySG != null) {
      ySG.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(70131);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(156022);
    if (ySG != null) {
      ySG.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(156022);
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