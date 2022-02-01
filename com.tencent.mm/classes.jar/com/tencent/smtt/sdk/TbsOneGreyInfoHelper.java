package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.sandbox.Log;
import com.tencent.smtt.sdk.a.b;
import com.tencent.smtt.sdk.a.c;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class TbsOneGreyInfoHelper
{
  static IX5CoreEntry a;
  static c b;
  static boolean c = false;
  private static d d;
  private static int e = -1;
  private static int f = -1;
  private static int g = -1;
  public static DexLoader mDexloader;
  public static File path;
  
  static TBSOneManager a(Context paramContext)
  {
    AppMethodBeat.i(190691);
    String str = "default";
    if (is64BitImpl()) {
      str = "default_64";
    }
    paramContext = TBSOneManager.getInstance(paramContext, str);
    AppMethodBeat.o(190691);
    return paramContext;
  }
  
  private static int b(Context paramContext)
  {
    AppMethodBeat.i(190692);
    if (g != -1)
    {
      i = g;
      AppMethodBeat.o(190692);
      return i;
    }
    int i = paramContext.getSharedPreferences("one_config", 0).getInt("one_enable", 0);
    g = i;
    AppMethodBeat.o(190692);
    return i;
  }
  
  private static String b(String paramString)
  {
    AppMethodBeat.i(174295);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174295);
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject != null)
      {
        if (localJSONObject.isNull("ext")) {
          break label74;
        }
        paramString = localJSONObject.optString("ext");
        AppMethodBeat.o(174295);
        return paramString;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
      paramString = getExtensionName(paramString);
      AppMethodBeat.o(174295);
      return paramString;
    }
    label74:
    AppMethodBeat.o(174295);
    return "";
  }
  
  public static File getCoreDir(Context paramContext)
  {
    AppMethodBeat.i(54351);
    if (isOneModeAvailable(paramContext))
    {
      paramContext = path;
      AppMethodBeat.o(54351);
      return paramContext;
    }
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      TbsLog.i("", "getTbsCoreShareDir,mkdir false");
      AppMethodBeat.o(54351);
      return null;
    }
    AppMethodBeat.o(54351);
    return paramContext;
  }
  
  public static IX5CoreEntry getCoreEntry()
  {
    return a;
  }
  
  public static String getCurrentProcessNameIngoreColon(Context paramContext)
  {
    AppMethodBeat.i(54347);
    if ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName))
    {
      AppMethodBeat.o(54347);
      return "com.tencent.mm_tools";
    }
    if ("com.tencent.tbs".equals(paramContext.getApplicationContext().getApplicationInfo().packageName))
    {
      AppMethodBeat.o(54347);
      return "com.tencent.tbs_tool";
    }
    paramContext = QbSdk.getCurrentProcessName(paramContext);
    if (TextUtils.isEmpty(paramContext))
    {
      AppMethodBeat.o(54347);
      return "";
    }
    paramContext = paramContext.replace(":", "_");
    AppMethodBeat.o(54347);
    return paramContext;
  }
  
  public static DexLoader getDexloader()
  {
    return mDexloader;
  }
  
  public static String getExtensionName(String paramString)
  {
    AppMethodBeat.i(54349);
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = paramString.lastIndexOf('.');
      if ((i >= 0) && (i < paramString.length() - 1))
      {
        paramString = paramString.substring(i + 1);
        AppMethodBeat.o(54349);
        return paramString;
      }
    }
    AppMethodBeat.o(54349);
    return paramString;
  }
  
  public static c getSDKExtensionEntry()
  {
    try
    {
      c localc = b;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static d getTbsFileInterface(Context paramContext)
  {
    AppMethodBeat.i(54350);
    if (isOneModeAvailable(paramContext))
    {
      paramContext = new d()
      {
        public final void a()
        {
          AppMethodBeat.i(54533);
          TbsOneFileOpenManager.getInstance(this.a).closeFileReader();
          AppMethodBeat.o(54533);
        }
        
        public final boolean a(Context paramAnonymousContext, String paramAnonymousString)
        {
          AppMethodBeat.i(54532);
          paramAnonymousString = TbsOneGreyInfoHelper.a(paramAnonymousString);
          boolean bool = TbsOneFileOpenManager.getInstance(paramAnonymousContext).canOpenFile(paramAnonymousContext, paramAnonymousString);
          AppMethodBeat.o(54532);
          return bool;
        }
      };
      AppMethodBeat.o(54350);
      return paramContext;
    }
    paramContext = d;
    AppMethodBeat.o(54350);
    return paramContext;
  }
  
  public static void init(Context paramContext)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(54344);
      }
      finally {}
      try
      {
        bool = c;
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(54344);
      }
      catch (Exception paramContext)
      {
        IX5CoreEntry localIX5CoreEntry;
        StatisticReport.create("LOAD_ERROR", 332).setDescription("exception", paramContext).report();
        TbsLog.e("tag", "entry create failed" + Log.getStackTraceString(paramContext));
        AppMethodBeat.o(54344);
        continue;
      }
      return;
      TbsLog.i("TbsOneGreyInfoHolder", "init,current process=" + QbSdk.getCurrentProcessName(paramContext));
      if (!isOneModeAvailable(paramContext))
      {
        TbsLog.i("TbsOneGreyInfoHolder", "tbsone mode not enable,return!");
        AppMethodBeat.o(54344);
      }
      else
      {
        paramContext = a(paramContext);
        if (paramContext.isComponentInstalled("x5webview")) {
          break;
        }
        TbsLog.i("TbsOneGreyInfoHolder", "x5 webview not installed,return!");
        AppMethodBeat.o(54344);
      }
    }
    paramContext.setPolicy(TBSOneManager.Policy.LOCAL_ONLY);
    paramContext = paramContext.loadComponentSync("x5webview");
    if (paramContext != null)
    {
      localIX5CoreEntry = (IX5CoreEntry)paramContext.getEntryObject();
      a = localIX5CoreEntry;
      path = paramContext.getInstallationDirectory();
      TbsLog.i("TbsOneGreyInfoHolder", "tbsone init success!,path=" + path + ",entry=" + localIX5CoreEntry);
    }
    for (;;)
    {
      c = true;
      AppMethodBeat.o(54344);
      break;
      StatisticReport.create("LOAD_ERROR", 333).report();
    }
  }
  
  public static void init(DexLoader paramDexLoader, Context paramContext1, Context paramContext2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54345);
    a = new b(paramDexLoader, paramContext1, paramContext2, paramString1, paramString2);
    d = new com.tencent.smtt.sdk.a.e(paramDexLoader);
    AppMethodBeat.o(54345);
  }
  
  public static void initExtension(Context paramContext)
  {
    AppMethodBeat.i(54343);
    if (b != null)
    {
      AppMethodBeat.o(54343);
      return;
    }
    if (!isOneModeAvailable(paramContext))
    {
      b = new TbsOnlineSDKExtensionEntry();
      AppMethodBeat.o(54343);
      return;
    }
    b = new c()
    {
      public final boolean canLoadVideo(Context paramAnonymousContext)
      {
        return false;
      }
      
      public final boolean canLoadX5(Context paramAnonymousContext, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        return true;
      }
      
      public final boolean canLoadX5FirstTimeThirdApp(Context paramAnonymousContext)
      {
        return true;
      }
      
      public final boolean canUseVideoFeatrue(Context paramAnonymousContext, int paramAnonymousInt)
      {
        return true;
      }
      
      public final String[] getDexLoaderFileList(Context paramAnonymousContext1, Context paramAnonymousContext2, String paramAnonymousString)
      {
        return new String[0];
      }
      
      public final String getLibraryPath()
      {
        return null;
      }
      
      public final String getTbsCoreVersionString()
      {
        AppMethodBeat.i(55104);
        int i = o.a().i(this.a);
        AppMethodBeat.o(55104);
        return String.valueOf(i);
      }
      
      public final Bundle incrUpdate(Context paramAnonymousContext, Bundle paramAnonymousBundle)
      {
        return null;
      }
      
      public final boolean init(Context paramAnonymousContext)
      {
        return true;
      }
      
      public final boolean isX5Disabled(Context paramAnonymousContext, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return false;
      }
      
      public final boolean isX5DisabledSync(Context paramAnonymousContext)
      {
        return false;
      }
      
      public final Object onMiscCallExtension(Context paramAnonymousContext, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        return null;
      }
      
      public final boolean useSoftWare()
      {
        return true;
      }
    };
    AppMethodBeat.o(54343);
  }
  
  public static boolean is64BitImpl()
  {
    AppMethodBeat.i(190693);
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 21)
      {
        AppMethodBeat.o(190693);
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null)
      {
        AppMethodBeat.o(190693);
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null)
      {
        AppMethodBeat.o(190693);
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null)
      {
        AppMethodBeat.o(190693);
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null)
      {
        AppMethodBeat.o(190693);
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        AppMethodBeat.o(190693);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190693);
    }
    return false;
  }
  
  public static boolean isOneModeAvailable(Context paramContext)
  {
    AppMethodBeat.i(174293);
    int i = b(paramContext);
    if (i == 1)
    {
      AppMethodBeat.o(174293);
      return false;
    }
    if (i == 2)
    {
      AppMethodBeat.o(174293);
      return true;
    }
    boolean bool2 = isTbsOneModeEnable(paramContext);
    boolean bool1;
    if (f == 1) {
      bool1 = true;
    }
    while ((bool2) && (bool1))
    {
      AppMethodBeat.o(174293);
      return true;
      if (f == 2)
      {
        bool1 = false;
      }
      else
      {
        bool1 = a(paramContext).isComponentInstalled("x5webview");
        if (bool1) {
          f = 1;
        } else {
          f = 2;
        }
      }
    }
    AppMethodBeat.o(174293);
    return false;
  }
  
  public static boolean isTbsAvailable(Context paramContext)
  {
    AppMethodBeat.i(54348);
    e locale = e.a(true);
    locale.a(paramContext, false, false, null);
    if ((locale != null) && (locale.b()))
    {
      AppMethodBeat.o(54348);
      return true;
    }
    AppMethodBeat.o(54348);
    return false;
  }
  
  public static boolean isTbsOneModeEnable(Context paramContext)
  {
    AppMethodBeat.i(54346);
    if (e == 1)
    {
      AppMethodBeat.o(54346);
      return true;
    }
    if (e == 2)
    {
      AppMethodBeat.o(54346);
      return false;
    }
    int i = b(paramContext);
    if (i == 1)
    {
      e = 2;
      AppMethodBeat.o(54346);
      return false;
    }
    if (i == 2)
    {
      e = 1;
      AppMethodBeat.o(54346);
      return true;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(getCurrentProcessNameIngoreColon(paramContext) + "_tbs_public_settings", 0);
    if ((localSharedPreferences.contains("TBS_ONE_GREY")) && (localSharedPreferences.getInt("TBS_ONE_GREY", -1) == 1) && (!TbsPVConfig.getInstance(paramContext).isDisableTbsOneGrey()))
    {
      e = 1;
      AppMethodBeat.o(54346);
      return true;
    }
    e = 2;
    AppMethodBeat.o(54346);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsOneGreyInfoHelper
 * JD-Core Version:    0.7.0.1
 */