package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import java.util.Iterator;
import java.util.List;

public final class ae
{
  private static String bwQ;
  private static Context context = null;
  private static volatile Resources mResources = null;
  private static String processName;
  private static String ufh = "com.tencent.mm";
  private static String ufi;
  private static boolean ufj;
  public static boolean ufk;
  private static ActivityManager ufl = null;
  
  static
  {
    bwQ = "com.tencent.mm";
    ufi = "com.tencent.mm.ui.LauncherUI";
    processName = bwQ;
    ufj = false;
    ufk = false;
  }
  
  public static boolean Zl(String paramString)
  {
    if ((context == null) || (bwQ == null)) {
      return false;
    }
    if (ufl == null) {
      ufl = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = ufl.getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals(paramString);
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + paramString.toString());
      return false;
    }
    catch (Error paramString)
    {
      y.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + paramString.toString());
      return false;
    }
    return false;
  }
  
  public static void bw(String paramString)
  {
    processName = paramString;
  }
  
  public static boolean cqO()
  {
    return ufj;
  }
  
  public static String cqP()
  {
    return ufi;
  }
  
  public static String cqQ()
  {
    return ufh;
  }
  
  public static String cqR()
  {
    return bwQ + "_preferences";
  }
  
  public static SharedPreferences cqS()
  {
    if (context != null) {
      return context.getSharedPreferences(cqR(), 0);
    }
    return null;
  }
  
  public static SharedPreferences cqT()
  {
    if (context != null) {
      return context.getSharedPreferences(bwQ + "_preferences_tools", 0);
    }
    return null;
  }
  
  public static String cqU()
  {
    return bwQ + "_tmp_preferences";
  }
  
  public static boolean cqV()
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
      str1 = bwQ;
    }
    return bwQ.equals(str1);
  }
  
  public static boolean cqW()
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
      str1 = bwQ;
    }
    return "com.tencent.mm:push".equalsIgnoreCase(str1);
  }
  
  public static boolean cqX()
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
      str1 = bwQ;
    }
    return "com.tencent.mm:tools".equalsIgnoreCase(str1);
  }
  
  public static boolean cqY()
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
      str1 = bwQ;
    }
    return "com.tencent.mm:toolsmp".equalsIgnoreCase(str1);
  }
  
  public static boolean cqZ()
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
      str1 = bwQ;
    }
    return "com.tencent.mm:exdevice".equalsIgnoreCase(str1);
  }
  
  public static boolean cra()
  {
    return Zl(bwQ);
  }
  
  public static void d(Resources paramResources)
  {
    mResources = paramResources;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static String getPackageName()
  {
    return bwQ;
  }
  
  public static String getProcessName()
  {
    return processName;
  }
  
  public static Resources getResources()
  {
    return mResources;
  }
  
  public static void ms(boolean paramBoolean)
  {
    ufj = paramBoolean;
  }
  
  public static void setContext(Context paramContext)
  {
    context = paramContext;
    bwQ = paramContext.getPackageName();
    y.d("MicroMsg.MMApplicationContext", "setup application context for package: " + bwQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ae
 * JD-Core Version:    0.7.0.1
 */