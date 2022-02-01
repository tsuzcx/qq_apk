package com.tencent.mm.wear.a.c;

import android.util.Log;

public final class d
{
  private static e amD = new a();
  private static boolean amE;
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (amD != null) {
      amD.a(paramString1, paramString2, paramVarArgs);
    }
    if (amE) {
      Log.e(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (amD != null) {
      amD.a(paramString, paramThrowable, "", new Object[0]);
    }
    if (amE) {
      Log.e(paramString, "", paramThrowable);
    }
  }
  
  public static void b(e parame)
  {
    if ((amD instanceof a)) {
      ((a)amD).a(parame);
    }
    amD = parame;
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (amD != null) {
      amD.b(paramString1, paramString2, paramVarArgs);
    }
    if (amE) {
      Log.w(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (amD != null) {
      amD.a(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    if (amE) {
      Log.e(paramString1, String.format(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (amD != null) {
      amD.c(paramString1, paramString2, paramVarArgs);
    }
    if (amE) {
      Log.i(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (amD != null) {
      amD.d(paramString1, paramString2, paramVarArgs);
    }
    if (amE) {
      Log.d(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void oy()
  {
    if ((amD instanceof c)) {
      ((c)amD).a("appendLog", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.c.d
 * JD-Core Version:    0.7.0.1
 */