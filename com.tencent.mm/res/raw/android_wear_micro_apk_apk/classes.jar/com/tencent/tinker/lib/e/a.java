package com.tencent.tinker.lib.e;

import android.util.Log;

public final class a
{
  private static b aki;
  private static b akj;
  
  static
  {
    b local1 = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        String str = paramAnonymousString2;
        if (paramAnonymousVarArgs != null) {
          if (paramAnonymousVarArgs.length != 0) {
            break label23;
          }
        }
        label23:
        for (str = paramAnonymousString2;; str = String.format(paramAnonymousString2, paramAnonymousVarArgs))
        {
          Log.e(paramAnonymousString1, str);
          return;
        }
      }
      
      public final void a(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length == 0)) {}
        for (;;)
        {
          paramAnonymousVarArgs = paramAnonymousString2;
          if (paramAnonymousString2 == null) {
            paramAnonymousVarArgs = "";
          }
          Log.e(paramAnonymousString1, paramAnonymousVarArgs + "  " + Log.getStackTraceString(paramAnonymousThrowable));
          return;
          paramAnonymousString2 = String.format(paramAnonymousString2, paramAnonymousVarArgs);
        }
      }
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        String str = paramAnonymousString2;
        if (paramAnonymousVarArgs != null) {
          if (paramAnonymousVarArgs.length != 0) {
            break label23;
          }
        }
        label23:
        for (str = paramAnonymousString2;; str = String.format(paramAnonymousString2, paramAnonymousVarArgs))
        {
          Log.w(paramAnonymousString1, str);
          return;
        }
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        String str = paramAnonymousString2;
        if (paramAnonymousVarArgs != null) {
          if (paramAnonymousVarArgs.length != 0) {
            break label23;
          }
        }
        label23:
        for (str = paramAnonymousString2;; str = String.format(paramAnonymousString2, paramAnonymousVarArgs))
        {
          Log.i(paramAnonymousString1, str);
          return;
        }
      }
    };
    aki = local1;
    akj = local1;
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (akj != null) {
      akj.a(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (akj != null) {
      akj.a(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (akj != null) {
      akj.b(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (akj != null) {
      akj.c(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */