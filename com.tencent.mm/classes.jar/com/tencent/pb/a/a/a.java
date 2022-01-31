package com.tencent.pb.a.a;

import com.tencent.pb.common.c.g;

public final class a
{
  private static int Bhj = 0;
  private static String Bhk = "";
  private static String TAG = "AccountEngine";
  
  public static void Sc(int paramInt)
  {
    Bhj = paramInt;
  }
  
  public static void awt(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    Bhk = str;
  }
  
  public static String dTX()
  {
    return Bhk;
  }
  
  public static boolean dTY()
  {
    return !g.isEmpty(Bhk);
  }
  
  public static boolean dTZ()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.a.a.a
 * JD-Core Version:    0.7.0.1
 */