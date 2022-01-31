package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.b;
import java.util.Iterator;
import java.util.List;

public final class ah
{
  private static String bYA;
  private static Context context = null;
  private static volatile Resources mResources = null;
  private static String processName;
  private static String ynH = "com.tencent.mm";
  private static String ynI;
  private static boolean ynJ;
  public static boolean ynK;
  private static ActivityManager ynL = null;
  
  static
  {
    bYA = "com.tencent.mm";
    ynI = "com.tencent.mm.ui.LauncherUI";
    processName = bYA;
    ynJ = false;
    ynK = false;
  }
  
  public static boolean apj(String paramString)
  {
    AppMethodBeat.i(115248);
    if ((context == null) || (bYA == null))
    {
      AppMethodBeat.o(115248);
      return false;
    }
    if (ynL == null) {
      ynL = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = ynL.getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals(paramString);
        if (bool)
        {
          AppMethodBeat.o(115248);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + paramString.toString());
      AppMethodBeat.o(115248);
      return false;
    }
    catch (Error paramString)
    {
      ab.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + paramString.toString());
      AppMethodBeat.o(115248);
      return false;
    }
    AppMethodBeat.o(115248);
    return false;
  }
  
  @Deprecated
  public static boolean brt()
  {
    AppMethodBeat.i(115241);
    boolean bool = dsT();
    AppMethodBeat.o(115241);
    return bool;
  }
  
  public static boolean dsM()
  {
    return ynJ;
  }
  
  public static String dsN()
  {
    return ynI;
  }
  
  public static String dsO()
  {
    return ynH;
  }
  
  public static String dsP()
  {
    AppMethodBeat.i(115237);
    String str = bYA + "_preferences";
    AppMethodBeat.o(115237);
    return str;
  }
  
  public static SharedPreferences dsQ()
  {
    AppMethodBeat.i(115238);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(dsP(), 0);
      AppMethodBeat.o(115238);
      return localSharedPreferences;
    }
    AppMethodBeat.o(115238);
    return null;
  }
  
  public static SharedPreferences dsR()
  {
    AppMethodBeat.i(115239);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(bYA + "_preferences_tools", 0);
      AppMethodBeat.o(115239);
      return localSharedPreferences;
    }
    AppMethodBeat.o(115239);
    return null;
  }
  
  public static String dsS()
  {
    AppMethodBeat.i(115240);
    String str = bYA + "_tmp_preferences";
    AppMethodBeat.o(115240);
    return str;
  }
  
  public static boolean dsT()
  {
    AppMethodBeat.i(141781);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = bYA;
    }
    boolean bool = bYA.equals(str1);
    AppMethodBeat.o(141781);
    return bool;
  }
  
  public static boolean dsU()
  {
    AppMethodBeat.i(115243);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = bYA;
    }
    boolean bool = "com.tencent.mm:push".equalsIgnoreCase(str1);
    AppMethodBeat.o(115243);
    return bool;
  }
  
  public static boolean dsV()
  {
    AppMethodBeat.i(141782);
    String str2 = b.bNv;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = bYA;
    }
    boolean bool = "com.tencent.mm:isolated_process0".equalsIgnoreCase(str1);
    AppMethodBeat.o(141782);
    return bool;
  }
  
  public static boolean dsW()
  {
    AppMethodBeat.i(115244);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = bYA;
    }
    boolean bool = "com.tencent.mm:tools".equalsIgnoreCase(str1);
    AppMethodBeat.o(115244);
    return bool;
  }
  
  public static boolean dsX()
  {
    AppMethodBeat.i(115245);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = bYA;
    }
    boolean bool = "com.tencent.mm:toolsmp".equalsIgnoreCase(str1);
    AppMethodBeat.o(115245);
    return bool;
  }
  
  public static boolean dsY()
  {
    AppMethodBeat.i(115246);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = bYA;
    }
    boolean bool = "com.tencent.mm:exdevice".equalsIgnoreCase(str1);
    AppMethodBeat.o(115246);
    return bool;
  }
  
  public static boolean dsZ()
  {
    AppMethodBeat.i(115247);
    boolean bool = apj(bYA);
    AppMethodBeat.o(115247);
    return bool;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static String getPackageName()
  {
    return bYA;
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
    AppMethodBeat.i(115242);
    String str2 = processName;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = bYA;
    }
    boolean bool = str1.startsWith(bYA + ":appbrand");
    AppMethodBeat.o(115242);
    return bool;
  }
  
  public static void pI(boolean paramBoolean)
  {
    ynJ = paramBoolean;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(115236);
    context = paramContext;
    bYA = paramContext.getPackageName();
    ab.d("MicroMsg.MMApplicationContext", "setup application context for package: " + bYA);
    AppMethodBeat.o(115236);
  }
  
  public static void setProcessName(String paramString)
  {
    processName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ah
 * JD-Core Version:    0.7.0.1
 */