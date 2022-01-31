package com.tencent.mm.plugin.webview.modelcache;

public enum b$a
{
  final int bcw;
  
  private b$a(int paramInt)
  {
    this.bcw = paramInt;
  }
  
  public static boolean Cb(int paramInt)
  {
    return (rhb.bcw & paramInt) > 0;
  }
  
  public static boolean Cc(int paramInt)
  {
    return (rhc.bcw & paramInt) > 0;
  }
  
  public static int Cd(int paramInt)
  {
    return rhc.bcw | paramInt;
  }
  
  public static int cct()
  {
    return rhb.bcw | 0x0;
  }
  
  public static String toString(int paramInt)
  {
    String str1;
    if (Cb(paramInt))
    {
      str1 = "http";
      if (!Cc(paramInt)) {
        break label44;
      }
    }
    label44:
    for (String str2 = "https";; str2 = "-")
    {
      return String.format("[ %s | %s ]", new Object[] { str1, str2 });
      str1 = "-";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.b.a
 * JD-Core Version:    0.7.0.1
 */