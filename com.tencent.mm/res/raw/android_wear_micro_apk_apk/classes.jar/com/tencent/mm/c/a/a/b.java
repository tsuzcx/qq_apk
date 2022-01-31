package com.tencent.mm.c.a.a;

public final class b
{
  public static final String A(String paramString)
  {
    return String.format("/wechat/%s/%d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
  }
  
  public static final boolean B(String paramString)
  {
    try
    {
      boolean bool = paramString.split("/")[2].equals("phone");
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */