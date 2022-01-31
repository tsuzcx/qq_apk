package com.tencent.mm.vending.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a AOq = null;
  
  public static void a(a parama)
  {
    AOq = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(126141);
    if (AOq != null) {
      AOq.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(126141);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(126138);
    if (AOq != null) {
      AOq.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(126138);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(126140);
    if (AOq != null) {
      AOq.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(126140);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(126142);
    if (AOq != null) {
      AOq.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(126142);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(126139);
    if (AOq != null) {
      AOq.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(126139);
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