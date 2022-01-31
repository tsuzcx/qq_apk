package com.tencent.tencentmap.mapsdk.a;

public enum sg
{
  private sg() {}
  
  public static String a(sg paramsg)
  {
    if ((paramsg == null) || (paramsg.name() == null) || (paramsg.name().indexOf("_") == -1)) {
      return "en";
    }
    return paramsg.name().substring(paramsg.name().indexOf("_") + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sg
 * JD-Core Version:    0.7.0.1
 */