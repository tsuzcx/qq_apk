package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import java.util.Iterator;
import java.util.List;

public final class aj
{
  public static boolean EUA;
  private static ActivityManager EUB = null;
  private static String EUx;
  private static String EUy;
  private static boolean EUz;
  private static Context context = null;
  private static String dvP;
  private static volatile Resources mResources;
  private static String processName;
  
  static
  {
    EUx = "com.tencent.mm";
    dvP = "com.tencent.mm";
    EUy = "com.tencent.mm.ui.LauncherUI";
    processName = dvP;
    EUz = false;
    EUA = false;
    mResources = null;
  }
  
  public static boolean aFw(String paramString)
  {
    AppMethodBeat.i(125285);
    if ((context == null) || (dvP == null))
    {
      AppMethodBeat.o(125285);
      return false;
    }
    if (EUB == null) {
      EUB = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = EUB.getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals(paramString);
        if (bool)
        {
          AppMethodBeat.o(125285);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + paramString.toString());
      AppMethodBeat.o(125285);
      return false;
    }
    catch (Error paramString)
    {
      ad.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + paramString.toString());
      AppMethodBeat.o(125285);
      return false;
    }
    AppMethodBeat.o(125285);
    return false;
  }
  
  public static boolean cbe()
  {
    AppMethodBeat.i(125275);
    String str2 = d.cvL;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dvP;
    }
    boolean bool = dvP.equals(str1);
    AppMethodBeat.o(125275);
    return bool;
  }
  
  @Deprecated
  public static boolean cbv()
  {
    AppMethodBeat.i(125276);
    boolean bool = cbe();
    AppMethodBeat.o(125276);
    return bool;
  }
  
  public static boolean eFA()
  {
    return EUz;
  }
  
  public static String eFB()
  {
    return EUy;
  }
  
  public static String eFC()
  {
    return EUx;
  }
  
  public static String eFD()
  {
    AppMethodBeat.i(125271);
    String str = dvP + "_preferences";
    AppMethodBeat.o(125271);
    return str;
  }
  
  public static SharedPreferences eFE()
  {
    AppMethodBeat.i(125272);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(eFD(), 0);
      AppMethodBeat.o(125272);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125272);
    return null;
  }
  
  public static SharedPreferences eFF()
  {
    AppMethodBeat.i(125273);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(dvP + "_preferences_tools", 0);
      AppMethodBeat.o(125273);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125273);
    return null;
  }
  
  public static String eFG()
  {
    AppMethodBeat.i(125274);
    String str = dvP + "_tmp_preferences";
    AppMethodBeat.o(125274);
    return str;
  }
  
  public static boolean eFH()
  {
    AppMethodBeat.i(125278);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dvP;
    }
    boolean bool = "com.tencent.mm:push".equalsIgnoreCase(str1);
    AppMethodBeat.o(125278);
    return bool;
  }
  
  public static boolean eFI()
  {
    AppMethodBeat.i(125279);
    String str2 = d.cvL;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dvP;
    }
    boolean bool = "com.tencent.mm:isolated_process0".equalsIgnoreCase(str1);
    AppMethodBeat.o(125279);
    return bool;
  }
  
  public static boolean eFJ()
  {
    AppMethodBeat.i(125280);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dvP;
    }
    boolean bool = "com.tencent.mm:tools".equalsIgnoreCase(str1);
    AppMethodBeat.o(125280);
    return bool;
  }
  
  public static boolean eFK()
  {
    AppMethodBeat.i(125281);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dvP;
    }
    boolean bool = "com.tencent.mm:toolsmp".equalsIgnoreCase(str1);
    AppMethodBeat.o(125281);
    return bool;
  }
  
  public static boolean eFL()
  {
    AppMethodBeat.i(125282);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dvP;
    }
    boolean bool = "com.tencent.mm:sandbox".equalsIgnoreCase(str1);
    AppMethodBeat.o(125282);
    return bool;
  }
  
  public static boolean eFM()
  {
    AppMethodBeat.i(125283);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dvP;
    }
    boolean bool = "com.tencent.mm:exdevice".equalsIgnoreCase(str1);
    AppMethodBeat.o(125283);
    return bool;
  }
  
  public static boolean eFN()
  {
    AppMethodBeat.i(125284);
    boolean bool = aFw(dvP);
    AppMethodBeat.o(125284);
    return bool;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static String getPackageName()
  {
    return dvP;
  }
  
  public static String getProcessName()
  {
    return processName;
  }
  
  public static Resources getResources()
  {
    return mResources;
  }
  
  public static void h(Resources paramResources)
  {
    mResources = paramResources;
  }
  
  public static boolean isAppBrandProcess()
  {
    AppMethodBeat.i(125277);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dvP;
    }
    boolean bool = str1.startsWith(dvP + ":appbrand");
    AppMethodBeat.o(125277);
    return bool;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(125270);
    context = paramContext;
    dvP = paramContext.getPackageName();
    ad.d("MicroMsg.MMApplicationContext", "setup application context for package: " + dvP);
    AppMethodBeat.o(125270);
  }
  
  public static void setProcessName(String paramString)
  {
    processName = paramString;
  }
  
  public static void uS(boolean paramBoolean)
  {
    EUz = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aj
 * JD-Core Version:    0.7.0.1
 */