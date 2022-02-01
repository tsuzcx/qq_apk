package com.tencent.mm.ui;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bc
{
  private static a adLa;
  private static a adLb;
  
  static
  {
    AppMethodBeat.i(159124);
    bc.1 local1 = new bc.1();
    adLa = local1;
    adLb = local1;
    AppMethodBeat.o(159124);
  }
  
  public static void a(a parama)
  {
    adLb = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159119);
    if (adLb != null) {
      adLb.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(159119);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159122);
    if (adLb != null) {
      adLb.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(159122);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159120);
    if (adLb != null) {
      adLb.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(159120);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159123);
    if (adLb != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      adLb.e(paramString1, paramThrowable, new Object[0]);
    }
    AppMethodBeat.o(159123);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159118);
    if (adLb != null) {
      adLb.v(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(159118);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159121);
    if (adLb != null) {
      adLb.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(159121);
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
 * Qualified Name:     com.tencent.mm.ui.bc
 * JD-Core Version:    0.7.0.1
 */