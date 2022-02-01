package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
{
  private static String IdA = "com.tencent.mm.ui.LauncherUI";
  private static boolean IdB = false;
  public static boolean IdC = false;
  private static String Idz;
  private static Context context = null;
  private static String dFD;
  private static volatile Resources mResources = null;
  private static ActivityManager wKu = null;
  
  static
  {
    Idz = "com.tencent.mm";
    dFD = "com.tencent.mm";
  }
  
  public static boolean aQt(String paramString)
  {
    AppMethodBeat.i(125285);
    if ((context == null) || (dFD == null))
    {
      AppMethodBeat.o(125285);
      return false;
    }
    if (wKu == null) {
      wKu = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = wKu.getRunningAppProcesses().iterator();
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
  
  public static boolean cmR()
  {
    AppMethodBeat.i(125275);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = dFD.equals(str1);
    AppMethodBeat.o(125275);
    return bool;
  }
  
  @Deprecated
  public static boolean cnC()
  {
    AppMethodBeat.i(125276);
    boolean bool = cmR();
    AppMethodBeat.o(125276);
    return bool;
  }
  
  public static String fkA()
  {
    return IdA;
  }
  
  public static String fkB()
  {
    return Idz;
  }
  
  public static String fkC()
  {
    AppMethodBeat.i(125271);
    String str = dFD + "_preferences";
    AppMethodBeat.o(125271);
    return str;
  }
  
  public static SharedPreferences fkD()
  {
    AppMethodBeat.i(125272);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(fkC(), 0);
      AppMethodBeat.o(125272);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125272);
    return null;
  }
  
  public static SharedPreferences fkE()
  {
    AppMethodBeat.i(125273);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(dFD + "_preferences_tools", 0);
      AppMethodBeat.o(125273);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125273);
    return null;
  }
  
  public static String fkF()
  {
    AppMethodBeat.i(125274);
    String str = dFD + "_tmp_preferences";
    AppMethodBeat.o(125274);
    return str;
  }
  
  public static boolean fkG()
  {
    AppMethodBeat.i(125278);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = "com.tencent.mm:push".equalsIgnoreCase(str1);
    AppMethodBeat.o(125278);
    return bool;
  }
  
  public static boolean fkH()
  {
    AppMethodBeat.i(125279);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = "com.tencent.mm:isolated_process0".equalsIgnoreCase(str1);
    AppMethodBeat.o(125279);
    return bool;
  }
  
  public static boolean fkI()
  {
    AppMethodBeat.i(125280);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = "com.tencent.mm:tools".equalsIgnoreCase(str1);
    AppMethodBeat.o(125280);
    return bool;
  }
  
  public static boolean fkJ()
  {
    AppMethodBeat.i(125281);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = "com.tencent.mm:toolsmp".equalsIgnoreCase(str1);
    AppMethodBeat.o(125281);
    return bool;
  }
  
  public static boolean fkK()
  {
    AppMethodBeat.i(125282);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = "com.tencent.mm:sandbox".equalsIgnoreCase(str1);
    AppMethodBeat.o(125282);
    return bool;
  }
  
  public static boolean fkL()
  {
    AppMethodBeat.i(125283);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = "com.tencent.mm:exdevice".equalsIgnoreCase(str1);
    AppMethodBeat.o(125283);
    return bool;
  }
  
  public static boolean fkM()
  {
    AppMethodBeat.i(207448);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = "com.tencent.mm:lite".equalsIgnoreCase(str1);
    AppMethodBeat.o(207448);
    return bool;
  }
  
  public static boolean fkN()
  {
    AppMethodBeat.i(207449);
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = (dFD + ":nospace").equalsIgnoreCase(str1);
    AppMethodBeat.o(207449);
    return bool;
  }
  
  public static boolean fkO()
  {
    AppMethodBeat.i(125284);
    boolean bool = aQt(dFD);
    AppMethodBeat.o(125284);
    return bool;
  }
  
  public static List<String> fkP()
  {
    AppMethodBeat.i(207450);
    LinkedList localLinkedList = new LinkedList();
    if ((context == null) || (dFD == null))
    {
      AppMethodBeat.o(207450);
      return localLinkedList;
    }
    if (wKu == null) {
      wKu = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = wKu.getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        String str = localRunningAppProcessInfo.processName;
        int i = localRunningAppProcessInfo.pid;
        localLinkedList.add(str + "@" + i);
      }
      AppMethodBeat.o(207450);
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + localException.toString());
      AppMethodBeat.o(207450);
      return localLinkedList;
    }
    catch (Error localError)
    {
      ad.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + localError.toString());
      AppMethodBeat.o(207450);
      return localLinkedList;
    }
    return localLinkedList;
  }
  
  public static boolean fkz()
  {
    return IdB;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static String getPackageName()
  {
    return dFD;
  }
  
  public static String getProcessName()
  {
    return d.cDP;
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
    String str2 = d.cDP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dFD;
    }
    boolean bool = str1.startsWith(dFD + ":appbrand");
    AppMethodBeat.o(125277);
    return bool;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(125270);
    context = paramContext;
    dFD = paramContext.getPackageName();
    ad.d("MicroMsg.MMApplicationContext", "setup application context for package: " + dFD);
    AppMethodBeat.o(125270);
  }
  
  public static void wG(boolean paramBoolean)
  {
    IdB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aj
 * JD-Core Version:    0.7.0.1
 */