package com.tencent.tencentmap.mapsdk.a;

import android.os.Build;

public class ji
{
  private static String[] a = new String[0];
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    int j = a.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (str.equalsIgnoreCase(a[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ji
 * JD-Core Version:    0.7.0.1
 */