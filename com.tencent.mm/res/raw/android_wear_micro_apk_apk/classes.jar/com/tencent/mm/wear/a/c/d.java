package com.tencent.mm.wear.a.c;

import android.util.Log;

public final class d
{
  private static e ajb = new a();
  private static boolean ajc;
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ajb != null) {
      ajb.a(paramString1, paramString2, paramVarArgs);
    }
    if (ajc) {
      Log.e(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (ajb != null) {
      ajb.a(paramString, paramThrowable, "", new Object[0]);
    }
    if (ajc) {
      Log.e(paramString, "", paramThrowable);
    }
  }
  
  public static void b(e parame)
  {
    if ((ajb instanceof a)) {
      ((a)ajb).a(parame);
    }
    ajb = parame;
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ajb != null) {
      ajb.b(paramString1, paramString2, paramVarArgs);
    }
    if (ajc) {
      Log.w(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (ajb != null) {
      ajb.a(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    if (ajc) {
      Log.e(paramString1, String.format(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ajb != null) {
      ajb.c(paramString1, paramString2, paramVarArgs);
    }
    if (ajc) {
      Log.i(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ajb != null) {
      ajb.e(paramString1, paramString2, paramVarArgs);
    }
    if (ajc) {
      Log.d(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void nK()
  {
    if ((ajb instanceof c)) {
      ((c)ajb).b("appendLog", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.c.d
 * JD-Core Version:    0.7.0.1
 */