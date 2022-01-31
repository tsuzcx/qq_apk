package com.tencent.mm.plugin.wear.a;

public final class b
{
  public static final boolean Rm(String paramString)
  {
    try
    {
      boolean bool = paramString.split("/")[2].equals("wear");
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static final int Rn(String paramString)
  {
    try
    {
      int i = Integer.valueOf(paramString.split("/")[4]).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.a.b
 * JD-Core Version:    0.7.0.1
 */