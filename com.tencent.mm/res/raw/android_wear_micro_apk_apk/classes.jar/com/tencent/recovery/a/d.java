package com.tencent.recovery.a;

public final class d
{
  private static e ajq = new a();
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ajq != null) {
      ajq.a(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (ajq != null) {
      ajq.a(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ajq != null) {
      ajq.c(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void nK()
  {
    if ((ajq instanceof c)) {
      ((c)ajq).b("", true);
    }
  }
  
  public static e nN()
  {
    return ajq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.a.d
 * JD-Core Version:    0.7.0.1
 */