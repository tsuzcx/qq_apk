package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sandbox.SandboxListener;
import com.tencent.smtt.sdk.b.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.m;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static boolean A = false;
  public static final int ERRORCODE_MINIQBREADER_CONTEXTISNULL = -100;
  public static final int ERRORCODE_MINIQBREADER_ISOVERSEA = -103;
  public static final int ERRORCODE_MINIQBREADER_REFLECTFAILED = -104;
  public static final int ERRORCODE_MINIQBREADER_REFUSE = -101;
  public static final int ERRORCODE_MINIQBREADER_X5COREINITFAILED = -102;
  public static String KEY_SET_SENDREQUEST_AND_UPLOAD;
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  public static final int QBMODE = 2;
  public static final String SVNVERSION = "jnizz";
  public static final int TBSMODE = 1;
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  static boolean a;
  static boolean b;
  static boolean c;
  static boolean d;
  static long e;
  static long f;
  static Object g;
  static boolean h;
  static boolean i;
  static boolean j;
  static volatile boolean k;
  static TbsListener l;
  private static boolean m;
  public static boolean mDisableUseHostBackupCore;
  public static Map<String, Object> mSettings;
  private static boolean n;
  private static String o;
  private static String p;
  private static boolean q;
  private static int r;
  private static int s;
  public static boolean sIsVersionPrinted;
  private static String t;
  private static String u;
  private static boolean v;
  private static boolean w;
  private static TbsListener x;
  private static TbsListener y;
  private static boolean z;
  
  static
  {
    AppMethodBeat.i(55430);
    sIsVersionPrinted = false;
    m = true;
    a = false;
    b = false;
    c = true;
    n = false;
    o = "NULL";
    p = "UNKNOWN";
    d = false;
    e = 0L;
    f = 0L;
    g = new Object();
    q = false;
    h = true;
    i = true;
    j = false;
    r = 0;
    s = 170;
    t = null;
    u = null;
    k = a;
    mDisableUseHostBackupCore = false;
    v = false;
    w = true;
    x = null;
    y = null;
    z = false;
    A = false;
    l = new TbsListener()
    {
      public final void onDownloadFinish(int paramAnonymousInt)
      {
        boolean bool = true;
        AppMethodBeat.i(54622);
        if (TbsDownloader.needDownloadDecoupleCore())
        {
          TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
          TbsDownloader.a = true;
          AppMethodBeat.o(54622);
          return;
        }
        TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
        TbsDownloader.a = false;
        if (paramAnonymousInt == 100) {}
        for (;;)
        {
          new StringBuilder("downloadX5 -> isSuccess:").append(bool).append(",code:").append(paramAnonymousInt);
          if (QbSdk.b() != null) {
            QbSdk.b().onDownloadFinish(paramAnonymousInt);
          }
          if (QbSdk.c() != null) {
            QbSdk.c().onDownloadFinish(paramAnonymousInt);
          }
          AppMethodBeat.o(54622);
          return;
          bool = false;
        }
      }
      
      public final void onDownloadProgress(int paramAnonymousInt)
      {
        AppMethodBeat.i(54624);
        if (QbSdk.c() != null) {
          QbSdk.c().onDownloadProgress(paramAnonymousInt);
        }
        if (QbSdk.b() != null) {
          QbSdk.b().onDownloadProgress(paramAnonymousInt);
        }
        AppMethodBeat.o(54624);
      }
      
      public final void onInstallFinish(int paramAnonymousInt)
      {
        AppMethodBeat.i(54623);
        if ((paramAnonymousInt == 200) || (paramAnonymousInt == 220)) {}
        for (boolean bool = true;; bool = false)
        {
          new StringBuilder("installX5 -> isSuccess:").append(bool).append(",code:").append(paramAnonymousInt);
          QbSdk.setTBSInstallingStatus(false);
          TbsDownloader.a = false;
          if (TbsDownloader.startDecoupleCoreIfNeeded()) {}
          for (TbsDownloader.a = true;; TbsDownloader.a = false)
          {
            if (QbSdk.b() != null) {
              QbSdk.b().onInstallFinish(paramAnonymousInt);
            }
            if (QbSdk.c() != null) {
              QbSdk.c().onInstallFinish(paramAnonymousInt);
            }
            AppMethodBeat.o(54623);
            return;
          }
        }
      }
    };
    KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    mSettings = null;
    AppMethodBeat.o(55430);
  }
  
  static Bundle a(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(55379);
    paramContext = TbsOneGreyInfoHelper.getSDKExtensionEntry().incrUpdate(paramContext, paramBundle);
    AppMethodBeat.o(55379);
    return paramContext;
  }
  
  static Object a(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(55424);
    paramContext = TbsOneGreyInfoHelper.getSDKExtensionEntry().onMiscCallExtension(paramContext, paramString, paramBundle);
    AppMethodBeat.o(55424);
    return paramContext;
  }
  
  protected static String a()
  {
    AppMethodBeat.i(55425);
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      localObject = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getGUID();
      AppMethodBeat.o(55425);
      return localObject;
    }
    AppMethodBeat.o(55425);
    return null;
  }
  
  /* Error */
  static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 228
    //   5: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 114	com/tencent/smtt/sdk/QbSdk:a	Z
    //   11: ifeq +35 -> 46
    //   14: ldc 230
    //   16: new 232	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 234
    //   22: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: getstatic 128	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   28: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 249	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc 228
    //   39: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: iconst_1
    //   47: putstatic 114	com/tencent/smtt/sdk/QbSdk:a	Z
    //   50: ldc 251
    //   52: aload_1
    //   53: invokestatic 257	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   56: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   59: putstatic 128	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   62: ldc 230
    //   64: new 232	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 263
    //   71: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: getstatic 128	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   77: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 265	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: invokestatic 271	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   89: aload_0
    //   90: sipush 401
    //   93: new 273	java/lang/Throwable
    //   96: dup
    //   97: getstatic 128	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   100: invokespecial 274	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 278	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   106: ldc 228
    //   108: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -69 -> 42
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	42	114	finally
    //   46	111	114	finally
  }
  
  static boolean a(Context paramContext)
  {
    AppMethodBeat.i(55378);
    if (paramContext == null)
    {
      AppMethodBeat.o(55378);
      return false;
    }
    try
    {
      if (paramContext.getApplicationInfo().packageName.contains("com.tencent.portfolio"))
      {
        TbsLog.i("QbSdk", "clearPluginConfigFile #1");
        String str1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("app_versionname", null);
        String str2 = paramContext.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
        TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + str1 + " newAppVersionName is " + str2);
        if ((str1 != null) && (!str1.contains(str2)))
        {
          paramContext = paramContext.getSharedPreferences("plugin_setting", 0);
          if (paramContext != null)
          {
            paramContext = paramContext.edit();
            paramContext.clear();
            paramContext.commit();
            TbsLog.i("QbSdk", "clearPluginConfigFile done");
          }
        }
      }
      AppMethodBeat.o(55378);
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("QbSdk", "clearPluginConfigFile error is " + paramContext.getMessage());
      AppMethodBeat.o(55378);
    }
    return false;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55380);
    boolean bool = a(paramContext, paramInt, 20000);
    AppMethodBeat.o(55380);
    return bool;
  }
  
  static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55381);
    boolean bool = TbsOneGreyInfoHelper.getSDKExtensionEntry().isX5Disabled(paramContext, paramInt1, paramInt2);
    AppMethodBeat.o(55381);
    return bool;
  }
  
  @SuppressLint({"NewApi"})
  static boolean a(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(55376);
    TbsLog.initIfNeed(paramContext);
    TbsLog.d("QbSdk", "QbSdk-init currentProcessId=" + Process.myPid());
    TbsLog.d("QbSdk", "QbSdk-init currentThreadName=" + Thread.currentThread().getName());
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43809; SDK_VERSION_NAME: 4.4.0.0006");
      sIsVersionPrinted = true;
    }
    if ((a) && (!paramBoolean))
    {
      TbsLog.e("QbSdk", "QbSdk init: " + p, false);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 414, new Throwable(p));
      AppMethodBeat.o(55376);
      return false;
    }
    if (b)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 402, new Throwable(o));
      AppMethodBeat.o(55376);
      return false;
    }
    if (!w) {
      b(paramContext);
    }
    paramBoolean = TbsOneGreyInfoHelper.getSDKExtensionEntry().init(paramContext);
    AppMethodBeat.o(55376);
    return paramBoolean;
  }
  
  static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(55389);
    paramBoolean1 = TbsOneGreyInfoHelper.getSDKExtensionEntry().canLoadX5(paramContext, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(55389);
    return paramBoolean1;
  }
  
  private static void b(Context paramContext)
  {
    i4 = 1;
    AppMethodBeat.i(55407);
    w = true;
    TbsLog.d("QbSdk", "QbSdk - preload_x5_check -- process:" + paramContext.getApplicationInfo().processName + "; thread:" + Thread.currentThread().getName());
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 11) {
          localSharedPreferences = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        }
      }
      catch (Throwable localThrowable1)
      {
        SharedPreferences.Editor localEditor;
        i1 = -1;
        SharedPreferences localSharedPreferences = null;
        i3 = -1;
        i2 = -1;
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable1));
        i4 = -1;
        int i5 = i1;
        i1 = i4;
        i4 = i2;
        continue;
        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i3 + "; value:" + i1);
        continue;
        if ((i5 <= 0) || (i5 > 3)) {
          break label662;
        }
        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
        x.a().a(paramContext, null);
        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
        i1 = 0;
        try
        {
          i2 = localSharedPreferences.getInt("tbs_preload_x5_counter", -1);
          if (i2 > 0) {
            localSharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
          }
        }
        catch (Throwable paramContext)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(paramContext));
          continue;
        }
        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:".concat(String.valueOf(i1)));
        AppMethodBeat.o(55407);
        return;
      }
      for (;;)
      {
        try
        {
          i2 = localSharedPreferences.getInt("tbs_preload_x5_recorder", -1);
          if (i2 < 0) {
            continue;
          }
          i1 = i2 + 1;
          if (i1 <= 4) {
            break;
          }
        }
        catch (Throwable localThrowable2)
        {
          i1 = -1;
          i3 = -1;
          i2 = -1;
          break label385;
          i1 = -1;
          break label129;
        }
        try
        {
          TbsLog.d("QbSdk", "QbSdk -- preload_x5_check -- preload_x5_recorder > PRELOAD_X5_COUNTER_MAX + 1, return:2");
          AppMethodBeat.o(55407);
          return;
        }
        catch (Throwable localThrowable3)
        {
          i3 = -1;
          i2 = 2;
          break label385;
        }
      }
      localSharedPreferences = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
    }
    i2 = i1;
    try
    {
      label129:
      i3 = q.a().j(paramContext);
    }
    catch (Throwable localThrowable4)
    {
      for (;;)
      {
        label244:
        int i3 = -1;
        i2 = -1;
      }
    }
    try
    {
      TbsLog.d("QbSdk", "QbSdk -- preload_x5_check -- tbs_core_version:".concat(String.valueOf(i3)));
      if (i3 > 0) {}
    }
    catch (Throwable localThrowable5)
    {
      i2 = -1;
      break label385;
    }
    try
    {
      TbsLog.d("QbSdk", "QbSdk -- preload_x5_check -- No tbs installed, return:1");
      AppMethodBeat.o(55407);
      return;
    }
    catch (Throwable localThrowable6)
    {
      i2 = i4;
      break label385;
      i1 = i4;
      break label527;
      i2 = -1;
      break label244;
    }
    if (i2 <= 4) {
      localSharedPreferences.edit().putInt("tbs_preload_x5_recorder", i2).commit();
    }
    i2 = localSharedPreferences.getInt("tbs_preload_x5_counter", -1);
    if (i2 >= 0)
    {
      localEditor = localSharedPreferences.edit();
      i2 += 1;
      localEditor.putInt("tbs_preload_x5_counter", i2).commit();
      i4 = -1;
      i5 = i1;
      i1 = i2;
      if (i1 > 3)
      {
        try
        {
          i1 = localSharedPreferences.getInt("tbs_preload_x5_version", -1);
          localEditor = localSharedPreferences.edit();
          if (i1 != i3) {
            break label426;
          }
          f.a(q.a().r(paramContext), false);
          paramContext = n.a(paramContext).a();
          if (paramContext != null) {
            f.a(paramContext, false);
          }
          TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i3 + " is deleted!");
          localEditor.putInt("tbs_precheck_disable_version", i1);
          localEditor.commit();
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
          }
        }
        TbsLog.d("QbSdk", "QbSdk -- preload_x5_check: reset tbs!");
        AppMethodBeat.o(55407);
        return;
      }
    }
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    AppMethodBeat.i(55388);
    boolean bool = TbsOneGreyInfoHelper.getSDKExtensionEntry().canLoadVideo(paramContext);
    AppMethodBeat.o(55388);
    return bool;
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    AppMethodBeat.i(55382);
    boolean bool = a(paramContext, false, false);
    AppMethodBeat.o(55382);
    return bool;
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    AppMethodBeat.i(55377);
    TbsLog.d("QbSdk", "canLoadX5FirstTimeThirdApp");
    boolean bool = TbsOneGreyInfoHelper.getSDKExtensionEntry().canLoadX5FirstTimeThirdApp(paramContext);
    AppMethodBeat.o(55377);
    return bool;
  }
  
  public static void canOpenFile(Context paramContext, final String paramString, final ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(55396);
    new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(54064);
        boolean bool3 = false;
        boolean bool2 = false;
        for (final boolean bool1 = bool3;; bool1 = bool2)
        {
          try
          {
            if (!g.a(true).a(this.a, null)) {
              break label127;
            }
            bool1 = bool3;
            bool2 = TbsOneGreyInfoHelper.getTbsFileInterface(this.a).a(this.a, paramString);
            bool1 = bool2;
            if (!bool2)
            {
              bool1 = bool2;
              localTbsLogInfo = TbsLogReport.getInstance(this.a).tbsLogInfo();
              bool1 = bool2;
              localTbsLogInfo.setErrorCode(805);
              bool1 = bool2;
              TbsLogReport.getInstance(this.a).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, localTbsLogInfo);
              bool1 = bool2;
            }
          }
          catch (Throwable localThrowable)
          {
            TbsLogReport.TbsLogInfo localTbsLogInfo;
            label98:
            label127:
            break label98;
          }
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(55088);
              QbSdk.1.this.c.onReceiveValue(Boolean.valueOf(bool1));
              AppMethodBeat.o(55088);
            }
          });
          AppMethodBeat.o(54064);
          return;
          bool1 = bool3;
          localTbsLogInfo = TbsLogReport.getInstance(this.a).tbsLogInfo();
          bool1 = bool3;
          localTbsLogInfo.setErrorCode(804);
          bool1 = bool3;
          TbsLogReport.getInstance(this.a).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, localTbsLogInfo);
        }
      }
    }.start();
    AppMethodBeat.o(55396);
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    AppMethodBeat.i(55390);
    if (!a(paramContext, false))
    {
      AppMethodBeat.o(55390);
      return false;
    }
    AppMethodBeat.o(55390);
    return false;
  }
  
  /* Error */
  public static boolean canOpenWebPlus(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: ldc_w 547
    //   9: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: getstatic 149	com/tencent/smtt/sdk/QbSdk:r	I
    //   15: ifne +9 -> 24
    //   18: invokestatic 551	com/tencent/smtt/sdk/a:a	()I
    //   21: putstatic 149	com/tencent/smtt/sdk/QbSdk:r	I
    //   24: ldc 230
    //   26: new 232	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 553
    //   33: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: getstatic 149	com/tencent/smtt/sdk/QbSdk:r	I
    //   39: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 301	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: getstatic 434	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 7
    //   53: if_icmplt +12 -> 65
    //   56: getstatic 149	com/tencent/smtt/sdk/QbSdk:r	I
    //   59: getstatic 151	com/tencent/smtt/sdk/QbSdk:s	I
    //   62: if_icmpge +11 -> 73
    //   65: ldc_w 547
    //   68: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_0
    //   74: ifnonnull +11 -> 85
    //   77: ldc_w 547
    //   80: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_0
    //   84: ireturn
    //   85: new 555	java/io/BufferedInputStream
    //   88: dup
    //   89: new 557	java/io/FileInputStream
    //   92: dup
    //   93: new 559	java/io/File
    //   96: dup
    //   97: invokestatic 449	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   100: aload_0
    //   101: invokevirtual 470	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   104: ldc_w 561
    //   107: invokespecial 564	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   110: invokespecial 567	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: invokespecial 570	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   116: astore 6
    //   118: aload 6
    //   120: astore 5
    //   122: new 572	java/util/Properties
    //   125: dup
    //   126: invokespecial 573	java/util/Properties:<init>	()V
    //   129: astore 8
    //   131: aload 6
    //   133: astore 5
    //   135: aload 8
    //   137: aload 6
    //   139: invokevirtual 576	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   142: aload 6
    //   144: astore 5
    //   146: aload 8
    //   148: ldc_w 578
    //   151: invokevirtual 581	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 9
    //   156: aload 6
    //   158: astore 5
    //   160: aload 8
    //   162: ldc_w 583
    //   165: invokevirtual 581	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 10
    //   170: aload 6
    //   172: astore 5
    //   174: aload 9
    //   176: invokestatic 589	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   179: istore_1
    //   180: aload 6
    //   182: astore 5
    //   184: aload 10
    //   186: invokestatic 589	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   189: istore_2
    //   190: aload 6
    //   192: astore 5
    //   194: getstatic 592	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   197: invokestatic 589	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   200: istore_3
    //   201: iload_3
    //   202: iload_1
    //   203: if_icmpgt +8 -> 211
    //   206: iload_3
    //   207: iload_2
    //   208: if_icmpge +35 -> 243
    //   211: aload 6
    //   213: astore 5
    //   215: ldc 230
    //   217: ldc_w 594
    //   220: iload_3
    //   221: invokestatic 457	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   224: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokestatic 301	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 6
    //   232: invokevirtual 597	java/io/BufferedInputStream:close	()V
    //   235: ldc_w 547
    //   238: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: iconst_0
    //   242: ireturn
    //   243: aload 6
    //   245: astore 5
    //   247: aload 8
    //   249: ldc_w 599
    //   252: invokevirtual 581	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 589	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   258: istore_1
    //   259: aload 6
    //   261: invokevirtual 597	java/io/BufferedInputStream:close	()V
    //   264: new 557	java/io/FileInputStream
    //   267: dup
    //   268: new 559	java/io/File
    //   271: dup
    //   272: aload_0
    //   273: invokestatic 601	com/tencent/smtt/sdk/q:t	(Landroid/content/Context;)Ljava/io/File;
    //   276: ldc_w 603
    //   279: invokespecial 564	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   282: invokespecial 567	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   285: astore 5
    //   287: new 572	java/util/Properties
    //   290: dup
    //   291: invokespecial 573	java/util/Properties:<init>	()V
    //   294: astore 6
    //   296: aload 6
    //   298: aload 5
    //   300: invokevirtual 576	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   303: aload 6
    //   305: ldc_w 605
    //   308: invokevirtual 581	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokestatic 589	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   314: istore_2
    //   315: aload 6
    //   317: ldc_w 607
    //   320: invokevirtual 581	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   323: invokestatic 589	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   326: istore_3
    //   327: iload_1
    //   328: ldc_w 608
    //   331: if_icmpeq +10 -> 341
    //   334: iload_2
    //   335: ldc_w 608
    //   338: if_icmpne +71 -> 409
    //   341: iconst_0
    //   342: istore_1
    //   343: aload 5
    //   345: invokevirtual 611	java/io/InputStream:close	()V
    //   348: iload_1
    //   349: ifne +195 -> 544
    //   352: ldc_w 547
    //   355: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: iconst_1
    //   359: ireturn
    //   360: astore_0
    //   361: aconst_null
    //   362: astore_0
    //   363: aload_0
    //   364: astore 5
    //   366: ldc 230
    //   368: ldc_w 613
    //   371: invokestatic 301	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload_0
    //   375: ifnull +7 -> 382
    //   378: aload_0
    //   379: invokevirtual 597	java/io/BufferedInputStream:close	()V
    //   382: ldc_w 547
    //   385: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: iconst_0
    //   389: ireturn
    //   390: astore_0
    //   391: aload 5
    //   393: ifnull +8 -> 401
    //   396: aload 5
    //   398: invokevirtual 597	java/io/BufferedInputStream:close	()V
    //   401: ldc_w 547
    //   404: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: aload_0
    //   408: athrow
    //   409: iload_1
    //   410: iload_2
    //   411: if_icmple +8 -> 419
    //   414: iconst_0
    //   415: istore_1
    //   416: goto -73 -> 343
    //   419: iload_1
    //   420: iload_2
    //   421: if_icmpne +191 -> 612
    //   424: iload_3
    //   425: ifle +16 -> 441
    //   428: iload_3
    //   429: aload_0
    //   430: invokestatic 617	com/tencent/smtt/utils/b:d	(Landroid/content/Context;)I
    //   433: if_icmpeq +8 -> 441
    //   436: iconst_0
    //   437: istore_1
    //   438: goto -95 -> 343
    //   441: aload 6
    //   443: ldc_w 619
    //   446: invokevirtual 581	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   449: invokestatic 625	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   452: ifeq +34 -> 486
    //   455: aload_0
    //   456: invokevirtual 629	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   459: invokestatic 306	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   462: getfield 310	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   465: ldc_w 631
    //   468: iconst_0
    //   469: invokeinterface 635 3 0
    //   474: istore 4
    //   476: iload 4
    //   478: ifne +8 -> 486
    //   481: iconst_1
    //   482: istore_1
    //   483: goto -140 -> 343
    //   486: iconst_0
    //   487: istore_1
    //   488: goto -145 -> 343
    //   491: astore_0
    //   492: aload 7
    //   494: astore_0
    //   495: ldc 230
    //   497: ldc_w 637
    //   500: invokestatic 301	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload_0
    //   504: ifnull +7 -> 511
    //   507: aload_0
    //   508: invokevirtual 611	java/io/InputStream:close	()V
    //   511: iconst_1
    //   512: istore_1
    //   513: goto -165 -> 348
    //   516: astore_0
    //   517: iconst_1
    //   518: istore_1
    //   519: goto -171 -> 348
    //   522: astore_0
    //   523: aconst_null
    //   524: astore 5
    //   526: aload 5
    //   528: ifnull +8 -> 536
    //   531: aload 5
    //   533: invokevirtual 611	java/io/InputStream:close	()V
    //   536: ldc_w 547
    //   539: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: aload_0
    //   543: athrow
    //   544: ldc_w 547
    //   547: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   550: iconst_0
    //   551: ireturn
    //   552: astore_0
    //   553: goto -318 -> 235
    //   556: astore 5
    //   558: goto -294 -> 264
    //   561: astore_0
    //   562: goto -180 -> 382
    //   565: astore 5
    //   567: goto -166 -> 401
    //   570: astore_0
    //   571: goto -223 -> 348
    //   574: astore 5
    //   576: goto -40 -> 536
    //   579: astore_0
    //   580: goto -54 -> 526
    //   583: astore 6
    //   585: aload_0
    //   586: astore 5
    //   588: aload 6
    //   590: astore_0
    //   591: goto -65 -> 526
    //   594: astore_0
    //   595: aload 5
    //   597: astore_0
    //   598: goto -103 -> 495
    //   601: astore_0
    //   602: goto -211 -> 391
    //   605: astore_0
    //   606: aload 6
    //   608: astore_0
    //   609: goto -246 -> 363
    //   612: iconst_0
    //   613: istore_1
    //   614: goto -271 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramContext	Context
    //   179	435	1	i1	int
    //   189	233	2	i2	int
    //   200	234	3	i3	int
    //   474	3	4	bool	boolean
    //   4	528	5	localObject1	Object
    //   556	1	5	localException1	Exception
    //   565	1	5	localException2	Exception
    //   574	1	5	localException3	Exception
    //   586	10	5	localContext	Context
    //   116	326	6	localObject2	Object
    //   583	24	6	localObject3	Object
    //   1	492	7	localObject4	Object
    //   129	119	8	localProperties	java.util.Properties
    //   154	21	9	str1	String
    //   168	17	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   85	118	360	java/lang/Throwable
    //   85	118	390	finally
    //   264	287	491	java/lang/Throwable
    //   507	511	516	java/lang/Exception
    //   264	287	522	finally
    //   230	235	552	java/lang/Exception
    //   259	264	556	java/lang/Exception
    //   378	382	561	java/lang/Exception
    //   396	401	565	java/lang/Exception
    //   343	348	570	java/lang/Exception
    //   531	536	574	java/lang/Exception
    //   287	327	579	finally
    //   428	436	579	finally
    //   441	476	579	finally
    //   495	503	583	finally
    //   287	327	594	java/lang/Throwable
    //   428	436	594	java/lang/Throwable
    //   441	476	594	java/lang/Throwable
    //   122	131	601	finally
    //   135	142	601	finally
    //   146	156	601	finally
    //   160	170	601	finally
    //   174	180	601	finally
    //   184	190	601	finally
    //   194	201	601	finally
    //   215	230	601	finally
    //   247	259	601	finally
    //   366	374	601	finally
    //   122	131	605	java/lang/Throwable
    //   135	142	605	java/lang/Throwable
    //   146	156	605	java/lang/Throwable
    //   160	170	605	java/lang/Throwable
    //   174	180	605	java/lang/Throwable
    //   184	190	605	java/lang/Throwable
    //   194	201	605	java/lang/Throwable
    //   215	230	605	java/lang/Throwable
    //   247	259	605	java/lang/Throwable
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55387);
    boolean bool = TbsOneGreyInfoHelper.getSDKExtensionEntry().canUseVideoFeatrue(paramContext, paramInt);
    AppMethodBeat.o(55387);
    return bool;
  }
  
  public static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(55426);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(55426);
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      AppMethodBeat.o(55426);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(55426);
    }
    return false;
  }
  
  public static void checkTbsValidity(Context paramContext)
  {
    AppMethodBeat.i(55404);
    if (paramContext == null)
    {
      AppMethodBeat.o(55404);
      return;
    }
    if (!m.b(paramContext))
    {
      TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 419);
      forceSysWebView();
    }
    AppMethodBeat.o(55404);
  }
  
  public static void clear(Context paramContext) {}
  
  /* Error */
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 671
    //   5: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 230
    //   10: new 232	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 673
    //   17: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokevirtual 676	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: ldc_w 678
    //   27: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 681	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: ldc_w 683
    //   37: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 301	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: ldc 230
    //   48: ldc_w 685
    //   51: invokestatic 249	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: new 687	com/tencent/smtt/sdk/WebView
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 689	com/tencent/smtt/sdk/WebView:<init>	(Landroid/content/Context;)V
    //   62: invokevirtual 693	com/tencent/smtt/sdk/WebView:getWebViewClientExtension	()Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewClientExtension;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnull +415 -> 484
    //   72: invokestatic 208	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   75: astore 4
    //   77: iload_3
    //   78: istore_2
    //   79: aload 4
    //   81: ifnull +160 -> 241
    //   84: iload_3
    //   85: istore_2
    //   86: aload 4
    //   88: invokevirtual 211	com/tencent/smtt/sdk/x:b	()Z
    //   91: ifeq +150 -> 241
    //   94: invokestatic 215	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:getCoreEntry	()Lcom/tencent/smtt/export/external/interfaces/IX5CoreEntry;
    //   97: astore 4
    //   99: iload_3
    //   100: istore_2
    //   101: aload 4
    //   103: invokeinterface 696 1 0
    //   108: ifeq +133 -> 241
    //   111: aload 4
    //   113: invokeinterface 700 1 0
    //   118: aload_0
    //   119: invokeinterface 705 2 0
    //   124: aload 4
    //   126: invokeinterface 700 1 0
    //   131: aload_0
    //   132: invokeinterface 708 2 0
    //   137: aload 4
    //   139: invokeinterface 700 1 0
    //   144: aload_0
    //   145: invokeinterface 711 2 0
    //   150: aload 4
    //   152: invokeinterface 715 1 0
    //   157: invokeinterface 720 1 0
    //   162: aload 4
    //   164: invokeinterface 715 1 0
    //   169: invokeinterface 723 1 0
    //   174: iload_1
    //   175: ifeq +52 -> 227
    //   178: aload 4
    //   180: invokeinterface 727 1 0
    //   185: aload_0
    //   186: invokeinterface 732 2 0
    //   191: aload 4
    //   193: invokeinterface 727 1 0
    //   198: invokeinterface 735 1 0
    //   203: aload 4
    //   205: invokeinterface 727 1 0
    //   210: invokeinterface 738 1 0
    //   215: aload 4
    //   217: invokeinterface 742 1 0
    //   222: invokeinterface 747 1 0
    //   227: aload 4
    //   229: invokeinterface 221 1 0
    //   234: invokeinterface 750 1 0
    //   239: iload_3
    //   240: istore_2
    //   241: iload_2
    //   242: ifeq +51 -> 293
    //   245: ldc 230
    //   247: ldc_w 752
    //   250: invokestatic 301	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: ldc_w 671
    //   256: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: return
    //   260: astore 4
    //   262: iconst_0
    //   263: istore_2
    //   264: ldc 230
    //   266: new 232	java/lang/StringBuilder
    //   269: dup
    //   270: ldc_w 754
    //   273: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   276: aload 4
    //   278: invokestatic 499	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   281: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 265	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: goto -49 -> 241
    //   293: ldc 230
    //   295: ldc_w 756
    //   298: invokestatic 249	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: ldc 230
    //   303: ldc_w 758
    //   306: invokestatic 249	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: new 760	android/webkit/WebView
    //   312: dup
    //   313: aload_0
    //   314: invokespecial 761	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   317: astore 4
    //   319: getstatic 434	android/os/Build$VERSION:SDK_INT	I
    //   322: bipush 11
    //   324: if_icmplt +27 -> 351
    //   327: aload 4
    //   329: ldc_w 763
    //   332: invokevirtual 766	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   335: aload 4
    //   337: ldc_w 768
    //   340: invokevirtual 766	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   343: aload 4
    //   345: ldc_w 770
    //   348: invokevirtual 766	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   351: aload 4
    //   353: iconst_1
    //   354: invokevirtual 774	android/webkit/WebView:clearCache	(Z)V
    //   357: iload_1
    //   358: ifeq +22 -> 380
    //   361: ldc 230
    //   363: ldc_w 776
    //   366: invokestatic 249	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_0
    //   370: invokestatic 782	android/webkit/CookieSyncManager:createInstance	(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;
    //   373: pop
    //   374: invokestatic 787	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   377: invokevirtual 788	android/webkit/CookieManager:removeAllCookie	()V
    //   380: ldc 230
    //   382: ldc_w 790
    //   385: invokestatic 249	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload_0
    //   389: invokestatic 795	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   392: invokevirtual 797	android/webkit/WebViewDatabase:clearUsernamePassword	()V
    //   395: aload_0
    //   396: invokestatic 795	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   399: invokevirtual 799	android/webkit/WebViewDatabase:clearHttpAuthUsernamePassword	()V
    //   402: aload_0
    //   403: invokestatic 795	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   406: invokevirtual 801	android/webkit/WebViewDatabase:clearFormData	()V
    //   409: ldc 230
    //   411: ldc_w 803
    //   414: invokestatic 249	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: invokestatic 808	android/webkit/WebStorage:getInstance	()Landroid/webkit/WebStorage;
    //   420: invokevirtual 811	android/webkit/WebStorage:deleteAllData	()V
    //   423: ldc 230
    //   425: ldc_w 813
    //   428: invokestatic 249	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: invokestatic 818	android/webkit/WebIconDatabase:getInstance	()Landroid/webkit/WebIconDatabase;
    //   434: invokevirtual 819	android/webkit/WebIconDatabase:removeAllIcons	()V
    //   437: ldc_w 671
    //   440: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: return
    //   444: astore_0
    //   445: ldc 230
    //   447: new 232	java/lang/StringBuilder
    //   450: dup
    //   451: ldc_w 821
    //   454: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   457: aload_0
    //   458: invokestatic 499	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   461: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 265	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: ldc_w 671
    //   473: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   476: return
    //   477: astore 4
    //   479: iconst_1
    //   480: istore_2
    //   481: goto -217 -> 264
    //   484: iconst_0
    //   485: istore_2
    //   486: goto -245 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	paramContext	Context
    //   0	489	1	paramBoolean	boolean
    //   78	408	2	i1	int
    //   1	239	3	i2	int
    //   65	163	4	localObject	Object
    //   260	17	4	localThrowable1	Throwable
    //   317	35	4	localWebView	android.webkit.WebView
    //   477	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   46	67	260	java/lang/Throwable
    //   293	351	444	java/lang/Throwable
    //   351	357	444	java/lang/Throwable
    //   361	380	444	java/lang/Throwable
    //   380	437	444	java/lang/Throwable
    //   72	77	477	java/lang/Throwable
    //   86	99	477	java/lang/Throwable
    //   101	174	477	java/lang/Throwable
    //   178	227	477	java/lang/Throwable
    //   227	239	477	java/lang/Throwable
  }
  
  public static void closeFileReader(Context paramContext)
  {
    AppMethodBeat.i(55397);
    int i1 = 0;
    try
    {
      boolean bool = g.a(true).a(paramContext, null);
      i1 = bool;
    }
    catch (Throwable localThrowable)
    {
      label20:
      break label20;
    }
    if (i1 != 0) {
      TbsOneGreyInfoHelper.getTbsFileInterface(paramContext).a();
    }
    AppMethodBeat.o(55397);
  }
  
  public static void continueLoadSo(Context paramContext) {}
  
  public static void disAllowThirdAppDownload()
  {
    c = false;
  }
  
  public static void disableAutoCreateX5Webview()
  {
    i = false;
  }
  
  public static void disableSensitiveApi()
  {
    AppMethodBeat.i(188320);
    m = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("no_sensitive_api", Boolean.TRUE);
    initTbsSettings(localHashMap);
    AppMethodBeat.o(188320);
  }
  
  public static void fileInfoDetect(Context paramContext, String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(55429);
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().fileInfoDetect(paramContext, paramString, paramValueCallback);
    }
    AppMethodBeat.o(55429);
  }
  
  public static void forceSysWebView()
  {
    AppMethodBeat.i(55394);
    b = true;
    o = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    AppMethodBeat.o(55394);
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    AppMethodBeat.i(55414);
    if (paramContext != null)
    {
      long l1 = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
      AppMethodBeat.o(55414);
      return l1;
    }
    AppMethodBeat.o(55414);
    return 0L;
  }
  
  /* Error */
  public static String getCurrentProcessName(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 889
    //   3: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 557	java/io/FileInputStream
    //   9: dup
    //   10: ldc_w 891
    //   13: invokespecial 892	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: sipush 256
    //   20: newarray byte
    //   22: astore_3
    //   23: iconst_0
    //   24: istore_1
    //   25: aload_0
    //   26: invokevirtual 895	java/io/FileInputStream:read	()I
    //   29: istore_2
    //   30: iload_2
    //   31: ifle +22 -> 53
    //   34: iload_1
    //   35: sipush 256
    //   38: if_icmpge +15 -> 53
    //   41: aload_3
    //   42: iload_1
    //   43: iload_2
    //   44: i2b
    //   45: bastore
    //   46: iload_1
    //   47: iconst_1
    //   48: iadd
    //   49: istore_1
    //   50: goto -25 -> 25
    //   53: iload_1
    //   54: ifle +29 -> 83
    //   57: new 253	java/lang/String
    //   60: dup
    //   61: aload_3
    //   62: iconst_0
    //   63: iload_1
    //   64: ldc_w 897
    //   67: invokespecial 900	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   70: astore_3
    //   71: aload_0
    //   72: invokevirtual 901	java/io/FileInputStream:close	()V
    //   75: ldc_w 889
    //   78: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_3
    //   82: areturn
    //   83: aload_0
    //   84: invokevirtual 901	java/io/FileInputStream:close	()V
    //   87: ldc_w 889
    //   90: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull -12 -> 87
    //   102: aload_0
    //   103: invokevirtual 901	java/io/FileInputStream:close	()V
    //   106: goto -19 -> 87
    //   109: astore_0
    //   110: goto -23 -> 87
    //   113: astore_3
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 901	java/io/FileInputStream:close	()V
    //   124: ldc_w 889
    //   127: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_3
    //   131: athrow
    //   132: astore_0
    //   133: goto -58 -> 75
    //   136: astore_0
    //   137: goto -50 -> 87
    //   140: astore_0
    //   141: goto -17 -> 124
    //   144: astore_3
    //   145: goto -29 -> 116
    //   148: astore_3
    //   149: goto -51 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramContext	Context
    //   24	40	1	i1	int
    //   29	15	2	i2	int
    //   22	60	3	localObject1	Object
    //   113	18	3	localObject2	Object
    //   144	1	3	localObject3	Object
    //   148	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   6	17	95	java/lang/Throwable
    //   102	106	109	java/io/IOException
    //   6	17	113	finally
    //   71	75	132	java/io/IOException
    //   83	87	136	java/io/IOException
    //   120	124	140	java/io/IOException
    //   17	23	144	finally
    //   25	30	144	finally
    //   57	71	144	finally
    //   17	23	148	java/lang/Throwable
    //   25	30	148	java/lang/Throwable
    //   57	71	148	java/lang/Throwable
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    AppMethodBeat.i(55412);
    paramContext1 = TbsOneGreyInfoHelper.getSDKExtensionEntry().getDexLoaderFileList(paramContext1, paramContext2, paramString);
    AppMethodBeat.o(55412);
    return paramContext1;
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return z;
  }
  
  public static boolean getIsSysWebViewForcedByOuter()
  {
    return b;
  }
  
  public static String getLibraryPath()
  {
    AppMethodBeat.i(55372);
    String str = TbsOneGreyInfoHelper.getSDKExtensionEntry().getLibraryPath();
    AppMethodBeat.o(55372);
    return str;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    AppMethodBeat.i(55422);
    x localx = x.a();
    localx.a(paramContext, null);
    if ((localx != null) && (localx.b()))
    {
      paramContext = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getMiniQBVersion();
      AppMethodBeat.o(55422);
      return paramContext;
    }
    AppMethodBeat.o(55422);
    return null;
  }
  
  public static boolean getOnlyDownload()
  {
    return j;
  }
  
  public static String getQQBuildNumber()
  {
    return u;
  }
  
  public static Map<String, Object> getSettings()
  {
    return mSettings;
  }
  
  public static boolean getTBSInstalling()
  {
    return A;
  }
  
  public static String getTID()
  {
    return t;
  }
  
  public static String getTbsCoreVersionString()
  {
    AppMethodBeat.i(55415);
    String str = TbsOneGreyInfoHelper.getSDKExtensionEntry().getTbsCoreVersionString();
    AppMethodBeat.o(55415);
    return str;
  }
  
  public static File getTbsFolderDir(Context paramContext)
  {
    AppMethodBeat.i(55428);
    if (paramContext == null)
    {
      AppMethodBeat.o(55428);
      return null;
    }
    try
    {
      if (b.d())
      {
        File localFile = paramContext.getDir("tbs_64", 0);
        AppMethodBeat.o(55428);
        return localFile;
      }
    }
    catch (Exception localException)
    {
      paramContext = paramContext.getDir("tbs", 0);
      AppMethodBeat.o(55428);
    }
    return paramContext;
  }
  
  public static String getTbsResourcesPath(Context paramContext)
  {
    AppMethodBeat.i(55392);
    paramContext = TbsShareManager.g(paramContext);
    AppMethodBeat.o(55392);
    return paramContext;
  }
  
  public static int getTbsSdkVersion()
  {
    return 43809;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(55410);
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      i1 = TbsShareManager.a(paramContext, false);
      AppMethodBeat.o(55410);
      return i1;
    }
    int i1 = q.a().j(paramContext);
    AppMethodBeat.o(55410);
    return i1;
  }
  
  public static int getTbsVersionForCrash(Context paramContext)
  {
    AppMethodBeat.i(55411);
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      i1 = TbsShareManager.a(paramContext, false);
      AppMethodBeat.o(55411);
      return i1;
    }
    int i1 = q.a().k(paramContext);
    if ((i1 == 0) && (n.a(paramContext).c() == 3)) {
      reset(paramContext);
    }
    AppMethodBeat.o(55411);
    return i1;
  }
  
  public static int getTmpDirTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(55427);
    int i1;
    if (n.a(paramContext).c() == 2)
    {
      i1 = q.a().e(paramContext, 0);
      AppMethodBeat.o(55427);
      return i1;
    }
    if (n.a(paramContext).b("copy_status") == 1)
    {
      i1 = q.a().e(paramContext, 1);
      AppMethodBeat.o(55427);
      return i1;
    }
    AppMethodBeat.o(55427);
    return 0;
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    h = paramBoolean;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(55423);
    if (mSettings == null) {
      mSettings = paramMap;
    }
    for (;;)
    {
      TbsLog.i("QbSdk", "initTbsSettings,maps=".concat(String.valueOf(paramMap)));
      AppMethodBeat.o(55423);
      return;
      try
      {
        mSettings.putAll(paramMap);
      }
      catch (Exception localException) {}
    }
  }
  
  public static void initX5Environment(Context paramContext, final PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(55406);
    if (paramContext == null)
    {
      TbsLog.e("QbSdk", "initX5Environment,context=null");
      AppMethodBeat.o(55406);
      return;
    }
    a(paramContext);
    y = new TbsListener()
    {
      public final void onDownloadFinish(int paramAnonymousInt) {}
      
      public final void onDownloadProgress(int paramAnonymousInt) {}
      
      public final void onInstallFinish(int paramAnonymousInt)
      {
        AppMethodBeat.i(54687);
        QbSdk.preInit(this.a, paramPreInitCallback);
        AppMethodBeat.o(54687);
      }
    };
    q localq;
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      localq = q.a();
      if (g.a != 0) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      localq.b(paramContext, bool);
      TbsDownloader.needDownload(paramContext, false, false, true, new TbsDownloader.TbsDownloaderCallback()
      {
        public final void onNeedDownloadFinish(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(55027);
          if ((TbsShareManager.findCoreForThirdPartyApp(this.a) == 0) && (!TbsShareManager.getCoreDisabled())) {
            TbsShareManager.forceToLoadX5ForThirdApp(this.a, false);
          }
          if ((QbSdk.h) && (TbsShareManager.isThirdPartyApp(this.a))) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
          }
          QbSdk.preInit(this.a, paramPreInitCallback);
          AppMethodBeat.o(55027);
        }
      });
      AppMethodBeat.o(55406);
      return;
    }
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(55386);
    if (TbsOneGreyInfoHelper.isTbsAvailable(paramContext))
    {
      boolean bool = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().installLocalQbApk(paramContext, paramString1, paramString2, paramBundle);
      AppMethodBeat.o(55386);
      return bool;
    }
    AppMethodBeat.o(55386);
    return false;
  }
  
  public static boolean isEnableSensitiveApi()
  {
    return m;
  }
  
  public static boolean isNeedInitX5FirstTime()
  {
    return q;
  }
  
  public static boolean isTbsCoreInited()
  {
    AppMethodBeat.i(55405);
    g localg = g.a(false);
    if ((localg != null) && (localg.g()))
    {
      AppMethodBeat.o(55405);
      return true;
    }
    AppMethodBeat.o(55405);
    return false;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    AppMethodBeat.i(55384);
    boolean bool = TbsOneGreyInfoHelper.getSDKExtensionEntry().isX5DisabledSync(paramContext);
    AppMethodBeat.o(55384);
    return bool;
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(55398);
      preInit(paramContext, null);
      AppMethodBeat.o(55398);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(final Context paramContext, final PreInitCallback paramPreInitCallback)
  {
    try
    {
      AppMethodBeat.i(55402);
      TbsLog.initIfNeed(paramContext);
      TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(paramContext));
      TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
      k = a;
      if (!n)
      {
        paramContext = new Thread()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(55190);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(55190);
              return;
              if (paramPreInitCallback != null) {
                paramPreInitCallback.onViewInitFinished(false);
              }
              TbsLog.writeLogToDisk();
              AppMethodBeat.o(55190);
              return;
              QbSdk.a(TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "disable_unpreinit.txt"));
              if (QbSdk.i) {
                TbsOneGreyInfoHelper.getCoreEntry().createX5WebView(paramContext, false);
              }
              if (paramPreInitCallback != null) {
                paramPreInitCallback.onViewInitFinished(true);
              }
              TbsLog.writeLogToDisk();
              AppMethodBeat.o(55190);
              return;
              if (paramPreInitCallback != null) {
                paramPreInitCallback.onCoreInitFinished();
              }
            }
          }
        }
        {
          public final void run()
          {
            AppMethodBeat.i(54055);
            int i = q.a().a(true, this.a);
            TbsDownloader.setAppContext(this.a);
            TbsLog.i("QbSdk", "QbSdk preinit ver is ".concat(String.valueOf(i)));
            if (i == 0) {
              q.a().b(this.a, true);
            }
            TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
            g.a(true).a(this.a, false, false, null);
            x localx = x.a();
            localx.a(this.a, null);
            boolean bool = localx.b();
            this.b.sendEmptyMessage(3);
            if (!bool)
            {
              this.b.sendEmptyMessage(2);
              AppMethodBeat.o(54055);
              return;
            }
            this.b.sendEmptyMessage(1);
            AppMethodBeat.o(54055);
          }
        };
        paramContext.setName("tbs_preinit");
        paramContext.setPriority(10);
        paramContext.start();
        n = true;
      }
      AppMethodBeat.o(55402);
      return;
    }
    finally {}
  }
  
  public static String replaceLibraryName(String paramString)
  {
    AppMethodBeat.i(55409);
    paramString = i.a(paramString);
    AppMethodBeat.o(55409);
    return paramString;
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(55416);
    reset(paramContext, false);
    AppMethodBeat.o(55416);
  }
  
  public static void reset(Context paramContext, boolean paramBoolean)
  {
    int i1 = 1;
    AppMethodBeat.i(55417);
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        TbsDownloader.stopDownload();
        if ((paramBoolean) && (!TbsShareManager.isThirdPartyApp(paramContext)))
        {
          int i2 = q.a().i(paramContext);
          int i3 = q.a().j(paramContext);
          if ((i2 > 43300) && (i2 != i3))
          {
            TbsDownloader.c(paramContext);
            f.a(getTbsFolderDir(paramContext), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            q.a.set(Integer.valueOf(0));
            File localFile = new File(paramContext.getFilesDir(), "bugly_switch.txt");
            if (localFile.exists()) {
              localFile.delete();
            }
            if (i1 != 0)
            {
              f.b(q.a().q(paramContext), q.a().f(paramContext, 0));
              q.a().c(paramContext);
            }
            AppMethodBeat.o(55417);
            return;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
        AppMethodBeat.o(55417);
        return;
      }
      i1 = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    AppMethodBeat.i(55418);
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    try
    {
      f.b(q.a().q(paramContext));
      AppMethodBeat.o(55418);
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(55418);
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    AppMethodBeat.i(55391);
    if (paramString == null)
    {
      AppMethodBeat.o(55391);
      return;
    }
    if (paramString.startsWith("QQ:"))
    {
      paramString = paramString.substring(3);
      t = "0000000000000000".substring(paramString.length()) + paramString;
    }
    AppMethodBeat.o(55391);
  }
  
  public static void setDisableUnpreinitBySwitch(boolean paramBoolean)
  {
    AppMethodBeat.i(55400);
    v = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + v);
    AppMethodBeat.o(55400);
  }
  
  public static void setDisableUseHostBackupCoreBySwitch(boolean paramBoolean)
  {
    AppMethodBeat.i(55399);
    mDisableUseHostBackupCore = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
    AppMethodBeat.o(55399);
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    z = paramBoolean;
  }
  
  public static void setNeedInitX5FirstTime(boolean paramBoolean)
  {
    q = paramBoolean;
  }
  
  public static void setNewDnsHostList(String paramString)
  {
    AppMethodBeat.i(188319);
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      localObject = ((x)localObject).c().a();
      try
      {
        ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setNewDnsHostList", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(188319);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(188319);
        return;
      }
    }
    AppMethodBeat.o(188319);
  }
  
  public static void setOnlyDownload(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    u = paramString;
  }
  
  public static void setSandboxListener(SandboxListener paramSandboxListener)
  {
    AppMethodBeat.i(55408);
    i.a(paramSandboxListener);
    AppMethodBeat.o(55408);
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    A = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    x = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    AppMethodBeat.i(55385);
    TbsLog.setTbsLogClient(paramTbsLogClient);
    AppMethodBeat.o(55385);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55403);
    if ((paramInt >= 130) && (paramInt <= 139))
    {
      paramContext = TbsDownloadUpload.getInstance(paramContext);
      paramContext.a.put("tbs_needdownload_code", Integer.valueOf(paramInt));
      paramContext.commit();
      AppMethodBeat.o(55403);
      return;
    }
    if ((paramInt >= 150) && (paramInt <= 159))
    {
      paramContext = TbsDownloadUpload.getInstance(paramContext);
      paramContext.a.put("tbs_startdownload_code", Integer.valueOf(paramInt));
      paramContext.commit();
    }
    AppMethodBeat.o(55403);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(55420);
    TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 501);
    TbsLog.i("QbSdk", "startMiniQBToLoadUrl,url=" + paramString + ";args=" + paramHashMap);
    int i1;
    if ((TbsOneGreyInfoHelper.isOneModeAvailable(paramContext)) && (paramHashMap != null) && ("true".equals(paramHashMap.get("local"))))
    {
      TbsLog.i("QbSdk", "openFile Use TbsOne mode");
      i1 = TbsOneFileOpenManager.getInstance(paramContext).startMiniQB(paramContext, paramString, paramHashMap, "", paramValueCallback);
      AppMethodBeat.o(55420);
      return i1;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(55420);
      return -100;
    }
    try
    {
      if (g.a(true).a(paramContext, null))
      {
        if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487))
        {
          paramString = TbsLogReport.getInstance(paramContext).tbsLogInfo();
          paramString.setErrorCode(806);
          TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, paramString);
          AppMethodBeat.o(55420);
          return -101;
        }
        i1 = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().startMiniQB(paramContext, paramString, paramHashMap, paramValueCallback);
        if (i1 == 0) {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 503);
        }
        for (;;)
        {
          AppMethodBeat.o(55420);
          return i1;
          TbsLogReport.getInstance(paramContext).setLoadErrorCode(504, String.valueOf(i1));
        }
        AppMethodBeat.o(55420);
      }
    }
    catch (Throwable paramContext) {}
    for (;;)
    {
      return -102;
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 502);
    }
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(55375);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    boolean bool = com.tencent.smtt.sdk.c.c.a(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
    AppMethodBeat.o(55375);
    return bool;
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(55374);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    boolean bool = com.tencent.smtt.sdk.c.c.a(paramContext, paramString, localHashMap);
    AppMethodBeat.o(55374);
    return bool;
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    AppMethodBeat.i(55373);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    WebView localWebView1 = paramWebView;
    if (paramWebView == null) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      if (localObject != "com.tencent.mm")
      {
        localWebView1 = paramWebView;
        if (localObject != "com.tencent.mobileqq") {}
      }
      else
      {
        localObject = x.a();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((x)localObject).b())
          {
            localObject = ((x)localObject).c().a().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
            localWebView1 = paramWebView;
            if (localObject != null)
            {
              localObject = (IX5WebViewBase)localObject;
              localWebView1 = paramWebView;
              if (localObject != null) {
                localWebView1 = (WebView)((IX5WebViewBase)localObject).getView().getParent();
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WebView localWebView2 = paramWebView;
      }
    }
    if (com.tencent.smtt.sdk.c.c.a(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0)
    {
      AppMethodBeat.o(55373);
      return true;
    }
    AppMethodBeat.o(55373);
    return false;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(55421);
    if (paramContext == null)
    {
      AppMethodBeat.o(55421);
      return false;
    }
    x localx = x.a();
    localx.a(paramContext, null);
    if ((paramHashMap != null) && ("5".equals(paramHashMap.get("PosID"))) && (localx.b())) {
      TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getAdWebViewInfoFromX5Core();
    }
    if (com.tencent.smtt.sdk.c.c.a(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
    {
      if (startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback) == 0)
      {
        AppMethodBeat.o(55421);
        return true;
      }
      AppMethodBeat.o(55421);
      return false;
    }
    AppMethodBeat.o(55421);
    return true;
  }
  
  public static void unForceSysWebView()
  {
    AppMethodBeat.i(55395);
    b = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    AppMethodBeat.o(55395);
  }
  
  public static boolean useSoftWare()
  {
    AppMethodBeat.i(55413);
    boolean bool = TbsOneGreyInfoHelper.getSDKExtensionEntry().useSoftWare();
    AppMethodBeat.o(55413);
    return bool;
  }
  
  public static abstract interface PreInitCallback
  {
    public abstract void onCoreInitFinished();
    
    public abstract void onViewInitFinished(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */