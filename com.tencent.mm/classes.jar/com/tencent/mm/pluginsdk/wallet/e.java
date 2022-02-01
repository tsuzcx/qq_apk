package com.tencent.mm.pluginsdk.wallet;

public final class e
{
  private static String CoC = null;
  
  public static void aCV(String paramString)
  {
    CoC = paramString;
  }
  
  public static boolean eBc()
  {
    return CoC == null;
  }
  
  public static String eBd()
  {
    return CoC;
  }
  
  public static void eBe()
  {
    CoC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.e
 * JD-Core Version:    0.7.0.1
 */