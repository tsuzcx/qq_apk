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

public final class ak
{
  private static String IxK;
  private static String IxL = "com.tencent.mm.ui.LauncherUI";
  private static boolean IxM = false;
  public static boolean IxN = false;
  private static Context context = null;
  private static String dGI;
  private static volatile Resources mResources = null;
  private static ActivityManager xaf = null;
  
  static
  {
    IxK = "com.tencent.mm";
    dGI = "com.tencent.mm";
  }
  
  public static boolean aRQ(String paramString)
  {
    AppMethodBeat.i(125285);
    if ((context == null) || (dGI == null))
    {
      AppMethodBeat.o(125285);
      return false;
    }
    if (xaf == null) {
      xaf = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = xaf.getRunningAppProcesses().iterator();
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
      ae.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + paramString.toString());
      AppMethodBeat.o(125285);
      return false;
    }
    catch (Error paramString)
    {
      ae.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + paramString.toString());
      AppMethodBeat.o(125285);
      return false;
    }
    AppMethodBeat.o(125285);
    return false;
  }
  
  public static boolean coh()
  {
    AppMethodBeat.i(125275);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = dGI.equals(str1);
    AppMethodBeat.o(125275);
    return bool;
  }
  
  @Deprecated
  public static boolean cpe()
  {
    AppMethodBeat.i(125276);
    boolean bool = coh();
    AppMethodBeat.o(125276);
    return bool;
  }
  
  public static boolean foA()
  {
    AppMethodBeat.i(125278);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = "com.tencent.mm:push".equalsIgnoreCase(str1);
    AppMethodBeat.o(125278);
    return bool;
  }
  
  public static boolean foB()
  {
    AppMethodBeat.i(125279);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = "com.tencent.mm:isolated_process0".equalsIgnoreCase(str1);
    AppMethodBeat.o(125279);
    return bool;
  }
  
  public static boolean foC()
  {
    AppMethodBeat.i(125280);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = "com.tencent.mm:tools".equalsIgnoreCase(str1);
    AppMethodBeat.o(125280);
    return bool;
  }
  
  public static boolean foD()
  {
    AppMethodBeat.i(125281);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = "com.tencent.mm:toolsmp".equalsIgnoreCase(str1);
    AppMethodBeat.o(125281);
    return bool;
  }
  
  public static boolean foE()
  {
    AppMethodBeat.i(125282);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = "com.tencent.mm:sandbox".equalsIgnoreCase(str1);
    AppMethodBeat.o(125282);
    return bool;
  }
  
  public static boolean foF()
  {
    AppMethodBeat.i(125283);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = "com.tencent.mm:exdevice".equalsIgnoreCase(str1);
    AppMethodBeat.o(125283);
    return bool;
  }
  
  public static boolean foG()
  {
    AppMethodBeat.i(211740);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = "com.tencent.mm:hotpot..".equalsIgnoreCase(str1);
    AppMethodBeat.o(211740);
    return bool;
  }
  
  public static boolean foH()
  {
    AppMethodBeat.i(211741);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = "com.tencent.mm:lite".equalsIgnoreCase(str1);
    AppMethodBeat.o(211741);
    return bool;
  }
  
  public static boolean foI()
  {
    AppMethodBeat.i(211742);
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = (dGI + ":nospace").equalsIgnoreCase(str1);
    AppMethodBeat.o(211742);
    return bool;
  }
  
  public static boolean foJ()
  {
    AppMethodBeat.i(125284);
    boolean bool = aRQ(dGI);
    AppMethodBeat.o(125284);
    return bool;
  }
  
  public static List<String> foK()
  {
    AppMethodBeat.i(211743);
    LinkedList localLinkedList = new LinkedList();
    if ((context == null) || (dGI == null))
    {
      AppMethodBeat.o(211743);
      return localLinkedList;
    }
    if (xaf == null) {
      xaf = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = xaf.getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        String str = localRunningAppProcessInfo.processName;
        int i = localRunningAppProcessInfo.pid;
        localLinkedList.add(str + "@" + i);
      }
      AppMethodBeat.o(211743);
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + localException.toString());
      AppMethodBeat.o(211743);
      return localLinkedList;
    }
    catch (Error localError)
    {
      ae.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + localError.toString());
      AppMethodBeat.o(211743);
      return localLinkedList;
    }
    return localLinkedList;
  }
  
  public static boolean fot()
  {
    return IxM;
  }
  
  public static String fou()
  {
    return IxL;
  }
  
  public static String fov()
  {
    return IxK;
  }
  
  public static String fow()
  {
    AppMethodBeat.i(125271);
    String str = dGI + "_preferences";
    AppMethodBeat.o(125271);
    return str;
  }
  
  public static SharedPreferences fox()
  {
    AppMethodBeat.i(125272);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(fow(), 0);
      AppMethodBeat.o(125272);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125272);
    return null;
  }
  
  public static SharedPreferences foy()
  {
    AppMethodBeat.i(125273);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(dGI + "_preferences_tools", 0);
      AppMethodBeat.o(125273);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125273);
    return null;
  }
  
  public static String foz()
  {
    AppMethodBeat.i(125274);
    String str = dGI + "_tmp_preferences";
    AppMethodBeat.o(125274);
    return str;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static String getPackageName()
  {
    return dGI;
  }
  
  public static String getProcessName()
  {
    return d.cEw;
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
    String str2 = d.cEw;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = dGI;
    }
    boolean bool = str1.startsWith(dGI + ":appbrand");
    AppMethodBeat.o(125277);
    return bool;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(125270);
    context = paramContext;
    dGI = paramContext.getPackageName();
    ae.d("MicroMsg.MMApplicationContext", "setup application context for package: " + dGI);
    AppMethodBeat.o(125270);
  }
  
  public static void wO(boolean paramBoolean)
  {
    IxM = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ak
 * JD-Core Version:    0.7.0.1
 */