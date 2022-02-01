package com.tencent.recovery.a;

public final class d
{
  private static e amS = new a();
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (amS != null) {
      amS.a(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (amS != null) {
      amS.a(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (amS != null) {
      amS.c(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static e oB()
  {
    return amS;
  }
  
  public static void oy()
  {
    if ((amS instanceof c)) {
      ((c)amS).a("", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.a.d
 * JD-Core Version:    0.7.0.1
 */