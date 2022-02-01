package com.tencent.tinker.lib.f;

import android.util.Log;

public final class a
{
  private static a IFi;
  private static a IFj;
  
  static
  {
    a local1 = new a()
    {
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length == 0)) {
          return;
        }
        String.format(paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length == 0)) {
          return;
        }
        String.format(paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length == 0)) {}
        for (paramAnonymousString1 = paramAnonymousString2;; paramAnonymousString1 = String.format(paramAnonymousString2, paramAnonymousVarArgs))
        {
          paramAnonymousString2 = paramAnonymousString1;
          if (paramAnonymousString1 == null) {
            paramAnonymousString2 = "";
          }
          new StringBuilder().append(paramAnonymousString2).append("  ").append(Log.getStackTraceString(paramAnonymousThrowable));
          return;
        }
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length == 0)) {
          return;
        }
        String.format(paramAnonymousString2, paramAnonymousVarArgs);
      }
    };
    IFi = local1;
    IFj = local1;
  }
  
  public static void a(a parama)
  {
    IFj = parama;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (IFj != null) {
      IFj.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (IFj != null) {
      IFj.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (IFj != null) {
      IFj.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (IFj != null) {
      IFj.w(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.f.a
 * JD-Core Version:    0.7.0.1
 */