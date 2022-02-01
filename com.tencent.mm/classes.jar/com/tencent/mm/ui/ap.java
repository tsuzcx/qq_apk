package com.tencent.mm.ui;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ap
{
  private static a JgN;
  private static a JgO;
  
  static
  {
    AppMethodBeat.i(159124);
    a local1 = new a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    JgN = local1;
    JgO = local1;
    AppMethodBeat.o(159124);
  }
  
  public static void a(a parama)
  {
    JgO = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159119);
    if (JgO != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      JgO.d(paramString1, paramString2);
    }
    AppMethodBeat.o(159119);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159122);
    if (JgO != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      JgO.e(paramString1, paramString2);
    }
    AppMethodBeat.o(159122);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159120);
    if (JgO != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      JgO.i(paramString1, paramString2);
    }
    AppMethodBeat.o(159120);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159123);
    if (JgO != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      JgO.e(paramString1, paramThrowable);
    }
    AppMethodBeat.o(159123);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159118);
    if (JgO != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      JgO.v(paramString1, paramString2);
    }
    AppMethodBeat.o(159118);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(159121);
    if (JgO != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      JgO.w(paramString1, paramString2);
    }
    AppMethodBeat.o(159121);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void v(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ap
 * JD-Core Version:    0.7.0.1
 */