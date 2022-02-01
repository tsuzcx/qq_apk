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

public final class ai
{
  private static String GrJ;
  private static String GrK;
  private static boolean GrL;
  public static boolean GrM;
  private static ActivityManager GrN = null;
  private static Context context = null;
  private static String dtC;
  private static volatile Resources mResources;
  private static String processName;
  
  static
  {
    GrJ = "com.tencent.mm";
    dtC = "com.tencent.mm";
    GrK = "com.tencent.mm.ui.LauncherUI";
    processName = dtC;
    GrL = false;
    GrM = false;
    mResources = null;
  }
  
  public static boolean aKN(String paramString)
  {
    AppMethodBeat.i(125285);
    if ((context == null) || (dtC == null))
    {
      AppMethodBeat.o(125285);
      return false;
    }
    if (GrN == null) {
      GrN = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = GrN.getRunningAppProcesses().iterator();
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
      ac.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + paramString.toString());
      AppMethodBeat.o(125285);
      return false;
    }
    catch (Error paramString)
    {
      ac.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + paramString.toString());
      AppMethodBeat.o(125285);
      return false;
    }
    AppMethodBeat.o(125285);
    return false;
  }
  
  @Deprecated
  public static boolean ciE()
  {
    AppMethodBeat.i(125276);
    boolean bool = cin();
    AppMethodBeat.o(125276);
    return bool;
  }
  
  public static boolean cin()
  {
    AppMethodBeat.i(125275);
    String str2 = d.csT;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dtC;
    }
    boolean bool = dtC.equals(str1);
    AppMethodBeat.o(125275);
    return bool;
  }
  
  public static boolean eUU()
  {
    return GrL;
  }
  
  public static String eUV()
  {
    return GrK;
  }
  
  public static String eUW()
  {
    return GrJ;
  }
  
  public static String eUX()
  {
    AppMethodBeat.i(125271);
    String str = dtC + "_preferences";
    AppMethodBeat.o(125271);
    return str;
  }
  
  public static SharedPreferences eUY()
  {
    AppMethodBeat.i(125272);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(eUX(), 0);
      AppMethodBeat.o(125272);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125272);
    return null;
  }
  
  public static SharedPreferences eUZ()
  {
    AppMethodBeat.i(125273);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(dtC + "_preferences_tools", 0);
      AppMethodBeat.o(125273);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125273);
    return null;
  }
  
  public static String eVa()
  {
    AppMethodBeat.i(125274);
    String str = dtC + "_tmp_preferences";
    AppMethodBeat.o(125274);
    return str;
  }
  
  public static boolean eVb()
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
      str1 = dtC;
    }
    boolean bool = "com.tencent.mm:push".equalsIgnoreCase(str1);
    AppMethodBeat.o(125278);
    return bool;
  }
  
  public static boolean eVc()
  {
    AppMethodBeat.i(125279);
    String str2 = d.csT;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dtC;
    }
    boolean bool = "com.tencent.mm:isolated_process0".equalsIgnoreCase(str1);
    AppMethodBeat.o(125279);
    return bool;
  }
  
  public static boolean eVd()
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
      str1 = dtC;
    }
    boolean bool = "com.tencent.mm:tools".equalsIgnoreCase(str1);
    AppMethodBeat.o(125280);
    return bool;
  }
  
  public static boolean eVe()
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
      str1 = dtC;
    }
    boolean bool = "com.tencent.mm:toolsmp".equalsIgnoreCase(str1);
    AppMethodBeat.o(125281);
    return bool;
  }
  
  public static boolean eVf()
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
      str1 = dtC;
    }
    boolean bool = "com.tencent.mm:sandbox".equalsIgnoreCase(str1);
    AppMethodBeat.o(125282);
    return bool;
  }
  
  public static boolean eVg()
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
      str1 = dtC;
    }
    boolean bool = "com.tencent.mm:exdevice".equalsIgnoreCase(str1);
    AppMethodBeat.o(125283);
    return bool;
  }
  
  public static boolean eVh()
  {
    AppMethodBeat.i(205039);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dtC;
    }
    boolean bool = "com.tencent.mm:lite".equalsIgnoreCase(str1);
    AppMethodBeat.o(205039);
    return bool;
  }
  
  public static boolean eVi()
  {
    AppMethodBeat.i(125284);
    boolean bool = aKN(dtC);
    AppMethodBeat.o(125284);
    return bool;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static String getPackageName()
  {
    return dtC;
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
      str1 = dtC;
    }
    boolean bool = str1.startsWith(dtC + ":appbrand");
    AppMethodBeat.o(125277);
    return bool;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(125270);
    context = paramContext;
    dtC = paramContext.getPackageName();
    ac.d("MicroMsg.MMApplicationContext", "setup application context for package: " + dtC);
    AppMethodBeat.o(125270);
  }
  
  public static void setProcessName(String paramString)
  {
    processName = paramString;
  }
  
  public static void vU(boolean paramBoolean)
  {
    GrL = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ai
 * JD-Core Version:    0.7.0.1
 */