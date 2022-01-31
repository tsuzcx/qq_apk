package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;

public final class i
{
  private static String Xm;
  private static String Xn;
  private static String Xo;
  private static boolean Xp;
  public static boolean Xq;
  private static ActivityManager Xr = null;
  private static Context context = null;
  private static volatile Resources nw;
  private static String processName;
  
  static
  {
    Xm = "com.tencent.mm";
    Xn = "com.tencent.mm";
    Xo = "com.tencent.mm.ui.LauncherUI";
    processName = Xn;
    Xp = false;
    Xq = false;
    nw = null;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static boolean lp()
  {
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = Xn;
    }
    return Xn.equals(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.i
 * JD-Core Version:    0.7.0.1
 */