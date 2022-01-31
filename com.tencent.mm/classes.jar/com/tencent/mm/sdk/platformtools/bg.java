package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;

public final class bg
{
  private static final HashMap<String, String> uiv = new HashMap();
  
  public static String getProperty(String paramString)
  {
    return (String)uiv.get(paramString);
  }
  
  public static void setProperty(String paramString1, String paramString2)
  {
    uiv.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bg
 * JD-Core Version:    0.7.0.1
 */