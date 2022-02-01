package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class MMApplicationContext
{
  public static final String INTENT_PROCESS_NAME = "_application_context_process_";
  private static final String TAG = "MicroMsg.MMApplicationContext";
  private static Context context = null;
  private static String launchName;
  private static ActivityManager mActivityManager = null;
  private static boolean mAppHasInitFlag;
  private static volatile Resources mResources;
  private static String pkgName;
  public static boolean sIsRevChange;
  private static String sourcePkgName = "com.tencent.mm";
  
  static
  {
    pkgName = "com.tencent.mm";
    launchName = "com.tencent.mm.ui.LauncherUI";
    mAppHasInitFlag = false;
    sIsRevChange = false;
    mResources = null;
  }
  
  public static List<String> getAliveProcess()
  {
    AppMethodBeat.i(249234);
    LinkedList localLinkedList = new LinkedList();
    if ((context == null) || (pkgName == null))
    {
      AppMethodBeat.o(249234);
      return localLinkedList;
    }
    if (mActivityManager == null) {
      mActivityManager = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = mActivityManager.getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        String str = localRunningAppProcessInfo.processName;
        int i = localRunningAppProcessInfo.pid;
        localLinkedList.add(str + "@" + i);
      }
      AppMethodBeat.o(249234);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + localException.toString());
      AppMethodBeat.o(249234);
      return localLinkedList;
    }
    catch (Error localError)
    {
      Log.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + localError.toString());
      AppMethodBeat.o(249234);
      return localLinkedList;
    }
    return localLinkedList;
  }
  
  public static String getApplicationId()
  {
    return pkgName;
  }
  
  public static int getColor(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(249239);
    paramInt = androidx.core.content.a.w(getContext(), paramInt);
    AppMethodBeat.o(249239);
    return paramInt;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static SharedPreferences getDefaultPreference()
  {
    AppMethodBeat.i(125272);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(getDefaultPreferencePath(), 0);
      AppMethodBeat.o(125272);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125272);
    return null;
  }
  
  public static String getDefaultPreferencePath()
  {
    AppMethodBeat.i(125271);
    String str = pkgName + "_preferences";
    AppMethodBeat.o(125271);
    return str;
  }
  
  public static SharedPreferences getExdeviceProcessPreference()
  {
    AppMethodBeat.i(249209);
    if (context != null)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        localSharedPreferences = context.getSharedPreferences(getExdeviceProcessPreferencePath(), 4);
        AppMethodBeat.o(249209);
        return localSharedPreferences;
      }
      SharedPreferences localSharedPreferences = context.getSharedPreferences(getExdeviceProcessPreferencePath(), 0);
      AppMethodBeat.o(249209);
      return localSharedPreferences;
    }
    AppMethodBeat.o(249209);
    return null;
  }
  
  public static String getExdeviceProcessPreferencePath()
  {
    AppMethodBeat.i(249207);
    String str = pkgName + "_preferences_exdevice_";
    AppMethodBeat.o(249207);
    return str;
  }
  
  public static String getLaunchName()
  {
    return launchName;
  }
  
  public static String getLiteProcessName()
  {
    AppMethodBeat.i(249240);
    String str = pkgName + ":lite";
    AppMethodBeat.o(249240);
    return str;
  }
  
  public static String getMainProcessName()
  {
    return pkgName;
  }
  
  @Deprecated
  public static String getPackageName()
  {
    return pkgName;
  }
  
  public static String getProcessName()
  {
    return d.cQP;
  }
  
  public static Resources getResources()
  {
    return mResources;
  }
  
  public static String getSourcePackageName()
  {
    return sourcePkgName;
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(249237);
    String str = getResources().getString(paramInt);
    AppMethodBeat.o(249237);
    return str;
  }
  
  public static SharedPreferences getTmpPreference()
  {
    AppMethodBeat.i(249210);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(getTmpPreferencePath(), 0);
      AppMethodBeat.o(249210);
      return localSharedPreferences;
    }
    AppMethodBeat.o(249210);
    return null;
  }
  
  public static String getTmpPreferencePath()
  {
    AppMethodBeat.i(125274);
    String str = pkgName + "_tmp_preferences";
    AppMethodBeat.o(125274);
    return str;
  }
  
  public static String getToolsProcessPreferencePath()
  {
    AppMethodBeat.i(249205);
    String str = pkgName + "_preferences_tools";
    AppMethodBeat.o(249205);
    return str;
  }
  
  public static SharedPreferences getToolsProcesstPreference()
  {
    AppMethodBeat.i(125273);
    if (context != null)
    {
      SharedPreferences localSharedPreferences = context.getSharedPreferences(getToolsProcessPreferencePath(), 0);
      AppMethodBeat.o(125273);
      return localSharedPreferences;
    }
    AppMethodBeat.o(125273);
    return null;
  }
  
  public static boolean isAppBrandProcess()
  {
    AppMethodBeat.i(125277);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = str1.startsWith(pkgName + ":appbrand");
    AppMethodBeat.o(125277);
    return bool;
  }
  
  public static boolean isAppHasInit()
  {
    return mAppHasInitFlag;
  }
  
  public static boolean isBacktraceProcess()
  {
    AppMethodBeat.i(249226);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":backtrace__").equalsIgnoreCase(str1);
    AppMethodBeat.o(249226);
    return bool;
  }
  
  public static boolean isExdeviceProcess()
  {
    AppMethodBeat.i(125283);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":exdevice").equalsIgnoreCase(str1);
    AppMethodBeat.o(125283);
    return bool;
  }
  
  public static boolean isHotpotDotDotProcess()
  {
    AppMethodBeat.i(249224);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":hotpot..").equalsIgnoreCase(str1);
    AppMethodBeat.o(249224);
    return bool;
  }
  
  public static boolean isImeProcess()
  {
    AppMethodBeat.i(249229);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":hld").equalsIgnoreCase(str1);
    AppMethodBeat.o(249229);
    return bool;
  }
  
  public static boolean isLiteProcess()
  {
    AppMethodBeat.i(249227);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = getLiteProcessName().equalsIgnoreCase(str1);
    AppMethodBeat.o(249227);
    return bool;
  }
  
  @Deprecated
  public static boolean isMMProcess()
  {
    AppMethodBeat.i(125276);
    boolean bool = isMainProcess();
    AppMethodBeat.o(125276);
    return bool;
  }
  
  public static boolean isMMProcessExist()
  {
    AppMethodBeat.i(125284);
    boolean bool = isProcessExist(pkgName);
    AppMethodBeat.o(125284);
    return bool;
  }
  
  public static boolean isMainProcess()
  {
    AppMethodBeat.i(125275);
    String str2 = d.cQP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = pkgName.equals(str1);
    AppMethodBeat.o(125275);
    return bool;
  }
  
  public static boolean isNoSpaceProcess()
  {
    AppMethodBeat.i(249230);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":nospace").equalsIgnoreCase(str1);
    AppMethodBeat.o(249230);
    return bool;
  }
  
  public static boolean isProcessExist(String paramString)
  {
    AppMethodBeat.i(125285);
    if ((context == null) || (pkgName == null))
    {
      AppMethodBeat.o(125285);
      return false;
    }
    if (mActivityManager == null) {
      mActivityManager = (ActivityManager)context.getSystemService("activity");
    }
    try
    {
      Iterator localIterator = mActivityManager.getRunningAppProcesses().iterator();
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
      Log.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + paramString.toString());
      AppMethodBeat.o(125285);
      return false;
    }
    catch (Error paramString)
    {
      Log.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + paramString.toString());
      AppMethodBeat.o(125285);
      return false;
    }
    AppMethodBeat.o(125285);
    return false;
  }
  
  public static boolean isPushProcess()
  {
    AppMethodBeat.i(125278);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":push").equalsIgnoreCase(str1);
    AppMethodBeat.o(125278);
    return bool;
  }
  
  public static boolean isSandBoxProcess()
  {
    AppMethodBeat.i(125282);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":sandbox").equalsIgnoreCase(str1);
    AppMethodBeat.o(125282);
    return bool;
  }
  
  public static boolean isSupportProcess()
  {
    AppMethodBeat.i(249220);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":support").equalsIgnoreCase(str1);
    AppMethodBeat.o(249220);
    return bool;
  }
  
  public static boolean isSwitchProcess()
  {
    AppMethodBeat.i(249222);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":switch").equalsIgnoreCase(str1);
    AppMethodBeat.o(249222);
    return bool;
  }
  
  public static boolean isToolsIsolatedProcess()
  {
    AppMethodBeat.i(125279);
    String str2 = d.cQP;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":isolated_process0").equalsIgnoreCase(str1);
    AppMethodBeat.o(125279);
    return bool;
  }
  
  public static boolean isToolsMpProcess()
  {
    AppMethodBeat.i(125281);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":toolsmp").equalsIgnoreCase(str1);
    AppMethodBeat.o(125281);
    return bool;
  }
  
  public static boolean isToolsProcess()
  {
    AppMethodBeat.i(125280);
    String str2 = getProcessName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = pkgName;
    }
    boolean bool = (pkgName + ":tools").equalsIgnoreCase(str1);
    AppMethodBeat.o(125280);
    return bool;
  }
  
  public static void setAppHasInitFlag(boolean paramBoolean)
  {
    mAppHasInitFlag = paramBoolean;
  }
  
  public static void setApplicationId(String paramString)
  {
    pkgName = paramString;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(125270);
    context = paramContext;
    pkgName = paramContext.getPackageName();
    Log.d("MicroMsg.MMApplicationContext", "setup application context for package: " + pkgName);
    if ((paramContext instanceof Application)) {
      ApplicationGlobal.attach((Application)paramContext);
    }
    AppMethodBeat.o(125270);
  }
  
  public static void setResources(Resources paramResources)
  {
    mResources = paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMApplicationContext
 * JD-Core Version:    0.7.0.1
 */