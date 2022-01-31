package com.tencent.pb.a.a;

import com.tencent.pb.common.c.g;

public final class a
{
  private static String TAG = "AccountEngine";
  private static int wJJ = 0;
  private static String wJK = "";
  
  public static void Jg(int paramInt)
  {
    wJJ = paramInt;
  }
  
  public static void afv(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    wJK = str;
  }
  
  public static String cOl()
  {
    return wJK;
  }
  
  public static boolean cOm()
  {
    return !g.isEmpty(wJK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.a.a.a
 * JD-Core Version:    0.7.0.1
 */