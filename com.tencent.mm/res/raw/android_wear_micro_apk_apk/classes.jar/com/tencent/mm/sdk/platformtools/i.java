package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;

public final class i
{
  private static String Zo;
  private static String Zp;
  private static String Zq;
  private static boolean Zr;
  public static boolean Zs;
  private static ActivityManager Zt = null;
  private static Context context = null;
  private static volatile Resources pk;
  private static String processName;
  
  static
  {
    Zo = "com.tencent.mm";
    Zp = "com.tencent.mm";
    Zq = "com.tencent.mm.ui.LauncherUI";
    processName = Zp;
    Zr = false;
    Zs = false;
    pk = null;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  @Deprecated
  public static boolean lB()
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
      str1 = Zp;
    }
    return Zp.equals(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.i
 * JD-Core Version:    0.7.0.1
 */