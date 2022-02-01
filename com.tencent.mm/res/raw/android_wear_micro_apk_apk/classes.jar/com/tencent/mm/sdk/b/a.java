package com.tencent.mm.sdk.b;

public final class a
{
  static final ThreadLocal<String> aal = new ThreadLocal();
  
  protected static void E(String paramString)
  {
    aal.set(paramString);
  }
  
  public static String getTag()
  {
    return (String)aal.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */