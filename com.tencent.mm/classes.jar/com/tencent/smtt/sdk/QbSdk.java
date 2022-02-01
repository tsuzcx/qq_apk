package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
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
import com.tencent.smtt.utils.r;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QbSdk
{
  private static boolean A = false;
  private static boolean B = false;
  public static final int ERRORCODE_MINIQBREADER_CONTEXTISNULL = -100;
  public static final int ERRORCODE_MINIQBREADER_ISOVERSEA = -103;
  public static final int ERRORCODE_MINIQBREADER_REFLECTFAILED = -104;
  public static final int ERRORCODE_MINIQBREADER_REFUSE = -101;
  public static final int ERRORCODE_MINIQBREADER_X5COREINITFAILED = -102;
  public static String KEY_SET_SENDREQUEST_AND_UPLOAD;
  public static final String KEY_THIRD_PARTY_TURING = "turing";
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  public static final int QBMODE = 2;
  public static final String SVNVERSION = "jnizz";
  public static final int TBSMODE = 1;
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final String USER_ID_FROM_APP_ANDROID_ID = "android_id";
  public static final String USER_ID_FROM_APP_IMSI = "imsi";
  public static final String USER_ID_FROM_APP_MAC = "mac";
  public static final String USER_ID_FROM_APP_MODEL = "model";
  public static final String USER_ID_FROM_APP_OAID = "oaid";
  public static final String USER_ID_FROM_APP_WX_USERID = "wx_userid";
  public static final String USER_ID_FROM_SERIAL = "serial";
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
  private static String w;
  private static boolean x;
  private static TbsListener y;
  private static TbsListener z;
  
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
    w = "";
    x = true;
    y = null;
    z = null;
    A = false;
    B = false;
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
          TbsLog.i("QbSdk", "onInstallFinish errCode is ".concat(String.valueOf(paramAnonymousInt)), true);
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
    //   3: ldc 254
    //   5: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 136	com/tencent/smtt/sdk/QbSdk:a	Z
    //   11: ifeq +37 -> 48
    //   14: ldc_w 256
    //   17: new 258	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 260
    //   24: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: getstatic 150	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   30: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc 254
    //   41: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: iconst_1
    //   49: putstatic 136	com/tencent/smtt/sdk/QbSdk:a	Z
    //   52: ldc_w 277
    //   55: aload_1
    //   56: invokestatic 283	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   62: putstatic 150	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   65: ldc_w 256
    //   68: new 258	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 289
    //   75: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: getstatic 150	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   81: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 291	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: invokestatic 297	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   93: aload_0
    //   94: sipush 401
    //   97: new 299	java/lang/Throwable
    //   100: dup
    //   101: getstatic 150	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   104: invokespecial 300	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 304	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   110: ldc 254
    //   112: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: goto -71 -> 44
    //   118: astore_0
    //   119: ldc 2
    //   121: monitorexit
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramContext	Context
    //   0	124	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	44	118	finally
    //   48	115	118	finally
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
    finally
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
  
  static boolean a(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(55376);
    TbsLog.initIfNeed(paramContext);
    TbsLog.d("QbSdk", "QbSdk-init currentProcessId=" + Process.myPid());
    TbsLog.d("QbSdk", "QbSdk-init currentThreadName=" + Thread.currentThread().getName());
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 44138; SDK_VERSION_NAME: 4.4.1.0038");
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
    if (!x) {
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
  
  /* Error */
  private static void b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc_w 447
    //   6: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_1
    //   10: putstatic 189	com/tencent/smtt/sdk/QbSdk:x	Z
    //   13: ldc_w 256
    //   16: new 258	java/lang/StringBuilder
    //   19: dup
    //   20: ldc_w 449
    //   23: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: invokevirtual 312	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   30: getfield 452	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   33: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 454
    //   39: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 422	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   45: invokevirtual 425	java/lang/Thread:getName	()Ljava/lang/String;
    //   48: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: getstatic 459	android/os/Build$VERSION:SDK_INT	I
    //   60: bipush 11
    //   62: if_icmplt +54 -> 116
    //   65: aload_0
    //   66: ldc_w 461
    //   69: iconst_4
    //   70: invokevirtual 369	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   73: astore 7
    //   75: aload 7
    //   77: ldc_w 463
    //   80: iconst_m1
    //   81: invokeinterface 467 3 0
    //   86: istore_2
    //   87: iload_2
    //   88: iflt +598 -> 686
    //   91: iload_2
    //   92: iconst_1
    //   93: iadd
    //   94: istore_1
    //   95: iload_1
    //   96: iconst_4
    //   97: if_icmple +32 -> 129
    //   100: ldc_w 256
    //   103: ldc_w 469
    //   106: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: ldc_w 447
    //   112: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: aload_0
    //   117: ldc_w 461
    //   120: iconst_0
    //   121: invokevirtual 369	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 7
    //   126: goto -51 -> 75
    //   129: iload_1
    //   130: istore_2
    //   131: invokestatic 474	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   134: aload_0
    //   135: invokevirtual 477	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   138: istore_3
    //   139: ldc_w 256
    //   142: ldc_w 479
    //   145: iload_3
    //   146: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   149: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   152: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: iload_3
    //   156: ifgt +19 -> 175
    //   159: ldc_w 256
    //   162: ldc_w 484
    //   165: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: ldc_w 447
    //   171: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: iload_2
    //   176: iconst_4
    //   177: if_icmpgt +25 -> 202
    //   180: aload 7
    //   182: invokeinterface 373 1 0
    //   187: ldc_w 463
    //   190: iload_2
    //   191: invokeinterface 488 3 0
    //   196: invokeinterface 381 1 0
    //   201: pop
    //   202: aload 7
    //   204: ldc_w 490
    //   207: iconst_m1
    //   208: invokeinterface 467 3 0
    //   213: istore_2
    //   214: iload_2
    //   215: iflt +466 -> 681
    //   218: aload 7
    //   220: invokeinterface 373 1 0
    //   225: astore 6
    //   227: iload_2
    //   228: iconst_1
    //   229: iadd
    //   230: istore_2
    //   231: aload 6
    //   233: ldc_w 490
    //   236: iload_2
    //   237: invokeinterface 488 3 0
    //   242: invokeinterface 381 1 0
    //   247: pop
    //   248: iconst_m1
    //   249: istore 4
    //   251: iload_1
    //   252: istore 5
    //   254: iload_2
    //   255: istore_1
    //   256: iload_1
    //   257: iconst_3
    //   258: if_icmple +241 -> 499
    //   261: aload 7
    //   263: ldc_w 492
    //   266: iconst_m1
    //   267: invokeinterface 467 3 0
    //   272: istore_1
    //   273: aload 7
    //   275: invokeinterface 373 1 0
    //   280: astore 6
    //   282: iload_1
    //   283: iload_3
    //   284: if_icmpne +149 -> 433
    //   287: invokestatic 474	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   290: aload_0
    //   291: invokevirtual 495	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   294: iconst_0
    //   295: invokestatic 500	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   298: aload_0
    //   299: invokestatic 505	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   302: invokevirtual 508	com/tencent/smtt/sdk/n:a	()Ljava/io/File;
    //   305: astore_0
    //   306: aload_0
    //   307: ifnull +8 -> 315
    //   310: aload_0
    //   311: iconst_0
    //   312: invokestatic 500	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   315: ldc_w 256
    //   318: new 258	java/lang/StringBuilder
    //   321: dup
    //   322: ldc_w 510
    //   325: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: iload_3
    //   329: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 512
    //   335: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 291	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload 6
    //   346: ldc_w 514
    //   349: iload_1
    //   350: invokeinterface 488 3 0
    //   355: pop
    //   356: aload 6
    //   358: invokeinterface 381 1 0
    //   363: pop
    //   364: ldc_w 256
    //   367: ldc_w 516
    //   370: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: ldc_w 447
    //   376: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: return
    //   380: astore 6
    //   382: iconst_m1
    //   383: istore_1
    //   384: aconst_null
    //   385: astore 7
    //   387: iconst_m1
    //   388: istore_3
    //   389: iconst_m1
    //   390: istore_2
    //   391: ldc_w 256
    //   394: new 258	java/lang/StringBuilder
    //   397: dup
    //   398: ldc_w 518
    //   401: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   404: aload 6
    //   406: invokestatic 524	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   409: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 291	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: iconst_m1
    //   419: istore 4
    //   421: iload_1
    //   422: istore 5
    //   424: iload 4
    //   426: istore_1
    //   427: iload_2
    //   428: istore 4
    //   430: goto -174 -> 256
    //   433: ldc_w 256
    //   436: new 258	java/lang/StringBuilder
    //   439: dup
    //   440: ldc_w 526
    //   443: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   446: iload_3
    //   447: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: ldc_w 528
    //   453: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload_1
    //   457: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 291	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: goto -122 -> 344
    //   469: astore_0
    //   470: ldc_w 256
    //   473: new 258	java/lang/StringBuilder
    //   476: dup
    //   477: ldc_w 530
    //   480: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   483: aload_0
    //   484: invokestatic 524	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   487: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 291	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: goto -132 -> 364
    //   499: iload 5
    //   501: ifle +174 -> 675
    //   504: iload 5
    //   506: iconst_3
    //   507: if_icmpgt +168 -> 675
    //   510: ldc_w 256
    //   513: ldc_w 532
    //   516: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: invokestatic 234	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   522: aload_0
    //   523: aconst_null
    //   524: invokevirtual 535	com/tencent/smtt/sdk/x:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/p;)V
    //   527: ldc_w 256
    //   530: ldc_w 537
    //   533: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: iconst_0
    //   537: istore_1
    //   538: aload 7
    //   540: ldc_w 490
    //   543: iconst_m1
    //   544: invokeinterface 467 3 0
    //   549: istore_2
    //   550: iload_2
    //   551: ifle +27 -> 578
    //   554: aload 7
    //   556: invokeinterface 373 1 0
    //   561: ldc_w 490
    //   564: iload_2
    //   565: iconst_1
    //   566: isub
    //   567: invokeinterface 488 3 0
    //   572: invokeinterface 381 1 0
    //   577: pop
    //   578: ldc_w 256
    //   581: ldc_w 539
    //   584: iload_1
    //   585: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   588: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   591: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: ldc_w 447
    //   597: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   600: return
    //   601: astore_0
    //   602: ldc_w 256
    //   605: new 258	java/lang/StringBuilder
    //   608: dup
    //   609: ldc_w 541
    //   612: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   615: aload_0
    //   616: invokestatic 524	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   619: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 291	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: goto -50 -> 578
    //   631: astore 6
    //   633: iconst_m1
    //   634: istore_1
    //   635: iconst_m1
    //   636: istore_3
    //   637: iconst_m1
    //   638: istore_2
    //   639: goto -248 -> 391
    //   642: astore 6
    //   644: iconst_m1
    //   645: istore_3
    //   646: iconst_2
    //   647: istore_2
    //   648: goto -257 -> 391
    //   651: astore 6
    //   653: iconst_m1
    //   654: istore_3
    //   655: iconst_m1
    //   656: istore_2
    //   657: goto -266 -> 391
    //   660: astore 6
    //   662: iconst_m1
    //   663: istore_2
    //   664: goto -273 -> 391
    //   667: astore 6
    //   669: iload 4
    //   671: istore_2
    //   672: goto -281 -> 391
    //   675: iload 4
    //   677: istore_1
    //   678: goto -140 -> 538
    //   681: iconst_m1
    //   682: istore_2
    //   683: goto -435 -> 248
    //   686: iconst_m1
    //   687: istore_1
    //   688: goto -557 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	paramContext	Context
    //   94	594	1	i1	int
    //   86	597	2	i2	int
    //   138	517	3	i3	int
    //   1	675	4	i4	int
    //   252	256	5	i5	int
    //   225	132	6	localEditor	SharedPreferences.Editor
    //   380	25	6	localThrowable	Throwable
    //   631	1	6	localObject1	Object
    //   642	1	6	localObject2	Object
    //   651	1	6	localObject3	Object
    //   660	1	6	localObject4	Object
    //   667	1	6	localObject5	Object
    //   73	482	7	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   57	75	380	finally
    //   116	126	380	finally
    //   261	282	469	finally
    //   287	306	469	finally
    //   310	315	469	finally
    //   315	344	469	finally
    //   344	364	469	finally
    //   433	466	469	finally
    //   538	550	601	finally
    //   554	578	601	finally
    //   75	87	631	finally
    //   100	109	642	finally
    //   131	139	651	finally
    //   139	155	660	finally
    //   180	202	660	finally
    //   202	214	660	finally
    //   218	227	660	finally
    //   231	248	660	finally
    //   159	168	667	finally
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
          finally
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
    //   1: astore 5
    //   3: ldc_w 572
    //   6: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 171	com/tencent/smtt/sdk/QbSdk:r	I
    //   12: ifne +9 -> 21
    //   15: invokestatic 576	com/tencent/smtt/sdk/a:a	()I
    //   18: putstatic 171	com/tencent/smtt/sdk/QbSdk:r	I
    //   21: ldc_w 256
    //   24: new 258	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 578
    //   31: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: getstatic 171	com/tencent/smtt/sdk/QbSdk:r	I
    //   37: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 459	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 7
    //   51: if_icmplt +12 -> 63
    //   54: getstatic 171	com/tencent/smtt/sdk/QbSdk:r	I
    //   57: getstatic 173	com/tencent/smtt/sdk/QbSdk:s	I
    //   60: if_icmpge +11 -> 71
    //   63: ldc_w 572
    //   66: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_0
    //   70: ireturn
    //   71: aload_0
    //   72: ifnonnull +11 -> 83
    //   75: ldc_w 572
    //   78: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iconst_0
    //   82: ireturn
    //   83: new 580	java/io/BufferedInputStream
    //   86: dup
    //   87: new 582	java/io/FileInputStream
    //   90: dup
    //   91: new 584	java/io/File
    //   94: dup
    //   95: invokestatic 474	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   98: aload_0
    //   99: invokevirtual 495	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   102: ldc_w 586
    //   105: invokespecial 589	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   108: invokespecial 592	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   111: invokespecial 595	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore 6
    //   116: new 597	java/util/Properties
    //   119: dup
    //   120: invokespecial 598	java/util/Properties:<init>	()V
    //   123: astore 7
    //   125: aload 7
    //   127: aload 6
    //   129: invokevirtual 601	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   132: aload 7
    //   134: ldc_w 603
    //   137: invokevirtual 606	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 8
    //   142: aload 7
    //   144: ldc_w 608
    //   147: invokevirtual 606	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 9
    //   152: aload 8
    //   154: invokestatic 614	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   157: istore_1
    //   158: aload 9
    //   160: invokestatic 614	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   163: istore_2
    //   164: getstatic 617	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   167: invokestatic 614	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: istore_3
    //   171: iload_3
    //   172: iload_1
    //   173: if_icmpgt +8 -> 181
    //   176: iload_3
    //   177: iload_2
    //   178: if_icmpge +32 -> 210
    //   181: ldc_w 256
    //   184: ldc_w 619
    //   187: iload_3
    //   188: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   191: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 6
    //   199: invokevirtual 622	java/io/BufferedInputStream:close	()V
    //   202: ldc_w 572
    //   205: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: aload 7
    //   212: ldc_w 624
    //   215: invokevirtual 606	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   218: invokestatic 614	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   221: istore_1
    //   222: aload 6
    //   224: invokevirtual 622	java/io/BufferedInputStream:close	()V
    //   227: new 582	java/io/FileInputStream
    //   230: dup
    //   231: new 584	java/io/File
    //   234: dup
    //   235: aload_0
    //   236: invokestatic 626	com/tencent/smtt/sdk/q:t	(Landroid/content/Context;)Ljava/io/File;
    //   239: ldc_w 628
    //   242: invokespecial 589	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   245: invokespecial 592	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   248: astore 6
    //   250: new 597	java/util/Properties
    //   253: dup
    //   254: invokespecial 598	java/util/Properties:<init>	()V
    //   257: astore 5
    //   259: aload 5
    //   261: aload 6
    //   263: invokevirtual 601	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   266: aload 5
    //   268: ldc_w 630
    //   271: invokevirtual 606	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 614	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   277: istore_2
    //   278: aload 5
    //   280: ldc_w 632
    //   283: invokevirtual 606	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   286: invokestatic 614	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: istore_3
    //   290: iload_1
    //   291: ldc_w 633
    //   294: if_icmpeq +10 -> 304
    //   297: iload_2
    //   298: ldc_w 633
    //   301: if_icmpne +69 -> 370
    //   304: iconst_0
    //   305: istore_1
    //   306: aload 6
    //   308: invokevirtual 636	java/io/InputStream:close	()V
    //   311: iload_1
    //   312: ifne +191 -> 503
    //   315: ldc_w 572
    //   318: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: iconst_1
    //   322: ireturn
    //   323: astore_0
    //   324: aconst_null
    //   325: astore_0
    //   326: ldc_w 256
    //   329: ldc_w 638
    //   332: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload_0
    //   336: ifnull +7 -> 343
    //   339: aload_0
    //   340: invokevirtual 622	java/io/BufferedInputStream:close	()V
    //   343: ldc_w 572
    //   346: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: iconst_0
    //   350: ireturn
    //   351: astore 5
    //   353: aload_0
    //   354: ifnull +7 -> 361
    //   357: aload_0
    //   358: invokevirtual 622	java/io/BufferedInputStream:close	()V
    //   361: ldc_w 572
    //   364: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: aload 5
    //   369: athrow
    //   370: iload_1
    //   371: iload_2
    //   372: if_icmple +8 -> 380
    //   375: iconst_0
    //   376: istore_1
    //   377: goto -71 -> 306
    //   380: iload_1
    //   381: iload_2
    //   382: if_icmpne +168 -> 550
    //   385: iload_3
    //   386: ifle +16 -> 402
    //   389: iload_3
    //   390: aload_0
    //   391: invokestatic 642	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)I
    //   394: if_icmpeq +8 -> 402
    //   397: iconst_0
    //   398: istore_1
    //   399: goto -93 -> 306
    //   402: aload 5
    //   404: ldc_w 644
    //   407: invokevirtual 606	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokestatic 650	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   413: ifeq +34 -> 447
    //   416: aload_0
    //   417: invokevirtual 654	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   420: invokestatic 332	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   423: getfield 336	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   426: ldc_w 656
    //   429: iconst_0
    //   430: invokeinterface 660 3 0
    //   435: istore 4
    //   437: iload 4
    //   439: ifne +8 -> 447
    //   442: iconst_1
    //   443: istore_1
    //   444: goto -138 -> 306
    //   447: iconst_0
    //   448: istore_1
    //   449: goto -143 -> 306
    //   452: astore_0
    //   453: aload 5
    //   455: astore_0
    //   456: ldc_w 256
    //   459: ldc_w 662
    //   462: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload_0
    //   466: ifnull +7 -> 473
    //   469: aload_0
    //   470: invokevirtual 636	java/io/InputStream:close	()V
    //   473: iconst_1
    //   474: istore_1
    //   475: goto -164 -> 311
    //   478: astore_0
    //   479: iconst_1
    //   480: istore_1
    //   481: goto -170 -> 311
    //   484: astore 5
    //   486: aload_0
    //   487: ifnull +7 -> 494
    //   490: aload_0
    //   491: invokevirtual 636	java/io/InputStream:close	()V
    //   494: ldc_w 572
    //   497: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   500: aload 5
    //   502: athrow
    //   503: ldc_w 572
    //   506: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   509: iconst_0
    //   510: ireturn
    //   511: astore_0
    //   512: goto -310 -> 202
    //   515: astore 6
    //   517: goto -290 -> 227
    //   520: astore_0
    //   521: goto -178 -> 343
    //   524: astore_0
    //   525: goto -164 -> 361
    //   528: astore_0
    //   529: goto -218 -> 311
    //   532: astore_0
    //   533: goto -39 -> 494
    //   536: astore_0
    //   537: aload 6
    //   539: astore_0
    //   540: goto -84 -> 456
    //   543: astore_0
    //   544: aload 6
    //   546: astore_0
    //   547: goto -221 -> 326
    //   550: iconst_0
    //   551: istore_1
    //   552: goto -246 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	paramContext	Context
    //   157	395	1	i1	int
    //   163	220	2	i2	int
    //   170	225	3	i3	int
    //   435	3	4	bool	boolean
    //   1	278	5	localProperties1	java.util.Properties
    //   351	103	5	localObject1	Object
    //   484	17	5	localObject2	Object
    //   114	193	6	localObject3	Object
    //   515	30	6	localException	Exception
    //   123	88	7	localProperties2	java.util.Properties
    //   140	13	8	str1	String
    //   150	9	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   83	116	323	finally
    //   326	335	351	finally
    //   227	250	452	finally
    //   469	473	478	java/lang/Exception
    //   456	465	484	finally
    //   197	202	511	java/lang/Exception
    //   222	227	515	java/lang/Exception
    //   339	343	520	java/lang/Exception
    //   357	361	524	java/lang/Exception
    //   306	311	528	java/lang/Exception
    //   490	494	532	java/lang/Exception
    //   250	290	536	finally
    //   389	397	536	finally
    //   402	437	536	finally
    //   116	171	543	finally
    //   181	197	543	finally
    //   210	222	543	finally
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
    if (!com.tencent.smtt.utils.n.b(paramContext))
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
    //   2: ldc_w 694
    //   5: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 256
    //   11: new 258	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 696
    //   18: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 701
    //   28: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_1
    //   32: invokevirtual 704	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: ldc_w 706
    //   38: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: ldc_w 256
    //   50: ldc_w 708
    //   53: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: new 710	com/tencent/smtt/sdk/WebView
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 712	com/tencent/smtt/sdk/WebView:<init>	(Landroid/content/Context;)V
    //   64: invokevirtual 716	com/tencent/smtt/sdk/WebView:getWebViewClientExtension	()Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewClientExtension;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnull +424 -> 495
    //   74: invokestatic 234	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   77: astore 4
    //   79: iload_3
    //   80: istore_2
    //   81: aload 4
    //   83: ifnull +160 -> 243
    //   86: iload_3
    //   87: istore_2
    //   88: aload 4
    //   90: invokevirtual 237	com/tencent/smtt/sdk/x:b	()Z
    //   93: ifeq +150 -> 243
    //   96: invokestatic 241	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:getCoreEntry	()Lcom/tencent/smtt/export/external/interfaces/IX5CoreEntry;
    //   99: astore 4
    //   101: iload_3
    //   102: istore_2
    //   103: aload 4
    //   105: invokeinterface 719 1 0
    //   110: ifeq +133 -> 243
    //   113: aload 4
    //   115: invokeinterface 723 1 0
    //   120: aload_0
    //   121: invokeinterface 728 2 0
    //   126: aload 4
    //   128: invokeinterface 723 1 0
    //   133: aload_0
    //   134: invokeinterface 731 2 0
    //   139: aload 4
    //   141: invokeinterface 723 1 0
    //   146: aload_0
    //   147: invokeinterface 734 2 0
    //   152: aload 4
    //   154: invokeinterface 738 1 0
    //   159: invokeinterface 743 1 0
    //   164: aload 4
    //   166: invokeinterface 738 1 0
    //   171: invokeinterface 746 1 0
    //   176: iload_1
    //   177: ifeq +52 -> 229
    //   180: aload 4
    //   182: invokeinterface 750 1 0
    //   187: aload_0
    //   188: invokeinterface 755 2 0
    //   193: aload 4
    //   195: invokeinterface 750 1 0
    //   200: invokeinterface 758 1 0
    //   205: aload 4
    //   207: invokeinterface 750 1 0
    //   212: invokeinterface 761 1 0
    //   217: aload 4
    //   219: invokeinterface 765 1 0
    //   224: invokeinterface 770 1 0
    //   229: aload 4
    //   231: invokeinterface 247 1 0
    //   236: invokeinterface 773 1 0
    //   241: iload_3
    //   242: istore_2
    //   243: iload_2
    //   244: ifeq +53 -> 297
    //   247: ldc_w 256
    //   250: ldc_w 775
    //   253: invokestatic 327	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: ldc_w 694
    //   259: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: return
    //   263: astore 4
    //   265: iconst_0
    //   266: istore_2
    //   267: ldc_w 256
    //   270: new 258	java/lang/StringBuilder
    //   273: dup
    //   274: ldc_w 777
    //   277: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   280: aload 4
    //   282: invokestatic 524	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   285: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 291	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: goto -51 -> 243
    //   297: ldc_w 256
    //   300: ldc_w 779
    //   303: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: ldc_w 256
    //   309: ldc_w 781
    //   312: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: new 783	android/webkit/WebView
    //   318: dup
    //   319: aload_0
    //   320: invokespecial 784	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   323: astore 4
    //   325: getstatic 459	android/os/Build$VERSION:SDK_INT	I
    //   328: bipush 11
    //   330: if_icmplt +27 -> 357
    //   333: aload 4
    //   335: ldc_w 786
    //   338: invokevirtual 789	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   341: aload 4
    //   343: ldc_w 791
    //   346: invokevirtual 789	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   349: aload 4
    //   351: ldc_w 793
    //   354: invokevirtual 789	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   357: aload 4
    //   359: iconst_1
    //   360: invokevirtual 797	android/webkit/WebView:clearCache	(Z)V
    //   363: iload_1
    //   364: ifeq +23 -> 387
    //   367: ldc_w 256
    //   370: ldc_w 799
    //   373: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload_0
    //   377: invokestatic 805	android/webkit/CookieSyncManager:createInstance	(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;
    //   380: pop
    //   381: invokestatic 810	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   384: invokevirtual 811	android/webkit/CookieManager:removeAllCookie	()V
    //   387: ldc_w 256
    //   390: ldc_w 813
    //   393: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_0
    //   397: invokestatic 818	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   400: invokevirtual 820	android/webkit/WebViewDatabase:clearUsernamePassword	()V
    //   403: aload_0
    //   404: invokestatic 818	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   407: invokevirtual 822	android/webkit/WebViewDatabase:clearHttpAuthUsernamePassword	()V
    //   410: aload_0
    //   411: invokestatic 818	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   414: invokevirtual 824	android/webkit/WebViewDatabase:clearFormData	()V
    //   417: ldc_w 256
    //   420: ldc_w 826
    //   423: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: invokestatic 831	android/webkit/WebStorage:getInstance	()Landroid/webkit/WebStorage;
    //   429: invokevirtual 834	android/webkit/WebStorage:deleteAllData	()V
    //   432: ldc_w 256
    //   435: ldc_w 836
    //   438: invokestatic 275	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: invokestatic 841	android/webkit/WebIconDatabase:getInstance	()Landroid/webkit/WebIconDatabase;
    //   444: invokevirtual 842	android/webkit/WebIconDatabase:removeAllIcons	()V
    //   447: ldc_w 694
    //   450: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: return
    //   454: astore_0
    //   455: ldc_w 256
    //   458: new 258	java/lang/StringBuilder
    //   461: dup
    //   462: ldc_w 844
    //   465: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   468: aload_0
    //   469: invokestatic 524	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   472: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 291	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: ldc_w 694
    //   484: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: return
    //   488: astore 4
    //   490: iconst_1
    //   491: istore_2
    //   492: goto -225 -> 267
    //   495: iconst_0
    //   496: istore_2
    //   497: goto -254 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	paramContext	Context
    //   0	500	1	paramBoolean	boolean
    //   80	417	2	i1	int
    //   1	241	3	i2	int
    //   67	163	4	localObject1	Object
    //   263	18	4	localThrowable	Throwable
    //   323	35	4	localWebView	android.webkit.WebView
    //   488	1	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	69	263	finally
    //   297	357	454	finally
    //   357	363	454	finally
    //   367	387	454	finally
    //   387	447	454	finally
    //   74	79	488	finally
    //   88	101	488	finally
    //   103	176	488	finally
    //   180	229	488	finally
    //   229	241	488	finally
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
    finally
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
    AppMethodBeat.i(219924);
    m = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("no_sensitive_api", Boolean.TRUE);
    initTbsSettings(localHashMap);
    AppMethodBeat.o(219924);
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
    //   0: ldc_w 912
    //   3: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 582	java/io/FileInputStream
    //   9: dup
    //   10: ldc_w 914
    //   13: invokespecial 915	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: sipush 256
    //   20: newarray byte
    //   22: astore_3
    //   23: iconst_0
    //   24: istore_1
    //   25: aload_0
    //   26: invokevirtual 918	java/io/FileInputStream:read	()I
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
    //   57: new 279	java/lang/String
    //   60: dup
    //   61: aload_3
    //   62: iconst_0
    //   63: iload_1
    //   64: ldc_w 920
    //   67: invokespecial 923	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   70: astore_3
    //   71: aload_0
    //   72: invokevirtual 924	java/io/FileInputStream:close	()V
    //   75: ldc_w 912
    //   78: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_3
    //   82: areturn
    //   83: aload_0
    //   84: invokevirtual 924	java/io/FileInputStream:close	()V
    //   87: ldc_w 912
    //   90: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull -12 -> 87
    //   102: aload_0
    //   103: invokevirtual 924	java/io/FileInputStream:close	()V
    //   106: goto -19 -> 87
    //   109: astore_0
    //   110: goto -23 -> 87
    //   113: astore_0
    //   114: goto -39 -> 75
    //   117: astore_0
    //   118: goto -31 -> 87
    //   121: astore_3
    //   122: goto -24 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramContext	Context
    //   24	40	1	i1	int
    //   29	15	2	i2	int
    //   22	60	3	localObject1	Object
    //   121	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	17	95	finally
    //   102	106	109	java/io/IOException
    //   71	75	113	java/io/IOException
    //   83	87	117	java/io/IOException
    //   17	23	121	finally
    //   25	30	121	finally
    //   57	71	121	finally
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
    return A;
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
  
  public static String getOAIDByApp()
  {
    AppMethodBeat.i(219887);
    TbsLog.i("QbSdk", "getOAIDByApp is " + w);
    String str = w;
    AppMethodBeat.o(219887);
    return str;
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
    return B;
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
      if (b.b())
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
    return 44138;
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
    z = new TbsListener()
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
        break label92;
      }
    }
    label92:
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
      finally
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
    AppMethodBeat.o(55418);
  }
  
  public static void setAppList(Context paramContext, List<String> paramList)
  {
    AppMethodBeat.i(219874);
    if (paramList == null)
    {
      AppMethodBeat.o(219874);
      return;
    }
    paramList = TextUtils.join(",", paramList);
    try
    {
      paramContext = paramContext.getSharedPreferences("uifa", 0).edit();
      paramContext.putString("app_list", paramList);
      paramContext.putString("app_call", "done");
      paramContext.commit();
      return;
    }
    finally
    {
      AppMethodBeat.o(219874);
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
    A = paramBoolean;
  }
  
  public static void setEnableForThirdParty(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(219928);
    r.a(paramContext, paramBundle);
    AppMethodBeat.o(219928);
  }
  
  public static void setNeedInitX5FirstTime(boolean paramBoolean)
  {
    q = paramBoolean;
  }
  
  public static void setNewDnsHostList(String paramString)
  {
    AppMethodBeat.i(219923);
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      localObject = ((x)localObject).c().a();
      try
      {
        ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setNewDnsHostList", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(219923);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(219923);
        return;
      }
    }
    AppMethodBeat.o(219923);
  }
  
  public static void setOAIDByApp(String paramString)
  {
    AppMethodBeat.i(219890);
    TbsLog.i("QbSdk", "setOAIDByApp is ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(219890);
      return;
    }
    try
    {
      Object localObject = x.a();
      if ((localObject != null) && (((x)localObject).b())) {
        localObject = ((x)localObject).c().a();
      }
      try {}finally
      {
        AppMethodBeat.o(219890);
      }
    }
    finally
    {
      try
      {
        ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setOAIDByApp", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(219890);
        return;
      }
      finally {}
      paramString = finally;
      AppMethodBeat.o(219890);
      return;
    }
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
    B = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    y = paramTbsListener;
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
  
  public static void setUserID(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(219883);
    if (paramBundle == null)
    {
      AppMethodBeat.o(219883);
      return;
    }
    Object localObject2 = "";
    Object localObject3 = "";
    String str1 = "";
    String str2 = "";
    Object localObject7 = "";
    Object localObject4 = str1;
    Object localObject5 = localObject3;
    Object localObject6 = localObject2;
    try
    {
      TbsLog.initIfNeed(paramContext);
      localObject4 = str1;
      localObject5 = localObject3;
      localObject6 = localObject2;
      localObject1 = paramBundle.keySet().iterator();
      for (;;)
      {
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject2;
        String str3 = (String)((Iterator)localObject1).next();
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject2;
        TbsLog.i("QbSdk", "setUserID bundle key is " + str3 + " value is " + paramBundle.getString(str3));
      }
      new StringBuilder("setUserID wx_userid is ").append((String)localObject1).append(" imsi is ").append((String)localObject2).append(" android_id is ").append((String)localObject3).append(" mac is ").append(paramBundle);
    }
    finally
    {
      paramBundle = "";
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
    }
    AppMethodBeat.o(219883);
    return;
    localObject4 = str1;
    localObject5 = localObject3;
    localObject6 = localObject2;
    Object localObject1 = localObject2;
    if (paramBundle.containsKey("wx_userid"))
    {
      localObject4 = str1;
      localObject5 = localObject3;
      localObject6 = localObject2;
      localObject1 = paramBundle.getString("wx_userid");
    }
    localObject4 = str1;
    localObject5 = localObject3;
    localObject6 = localObject1;
    if (paramBundle.containsKey("serial"))
    {
      localObject4 = str1;
      localObject5 = localObject3;
      localObject6 = localObject1;
      localObject2 = paramBundle.getString("serial");
      localObject4 = str1;
      localObject5 = localObject3;
      localObject6 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = localObject1;
        label346:
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject1;
        TbsLog.i("QbSdk", "setUserID after fix serial is ".concat(String.valueOf(localObject2)));
        localObject7 = localObject2;
      }
    }
    else
    {
      localObject4 = str1;
      localObject5 = localObject3;
      localObject6 = localObject1;
      if (paramBundle.containsKey("model"))
      {
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject1;
        str2 = paramBundle.getString("model");
      }
      localObject4 = str1;
      localObject5 = localObject3;
      localObject6 = localObject1;
      if (paramBundle.containsKey("oaid"))
      {
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject1;
        localObject2 = paramBundle.getString("oaid");
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject1;
        w = (String)localObject2;
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject1;
        setOAIDByApp((String)localObject2);
      }
      localObject4 = str1;
      localObject5 = localObject3;
      localObject6 = localObject1;
      localObject2 = localObject3;
      if (paramBundle.containsKey("imsi"))
      {
        localObject4 = str1;
        localObject5 = localObject3;
        localObject6 = localObject1;
        localObject2 = paramBundle.getString("imsi");
      }
      localObject4 = str1;
      localObject5 = localObject2;
      localObject6 = localObject1;
      localObject3 = str1;
      if (paramBundle.containsKey("android_id"))
      {
        localObject4 = str1;
        localObject5 = localObject2;
        localObject6 = localObject1;
        localObject3 = paramBundle.getString("android_id");
      }
      localObject4 = localObject3;
      localObject5 = localObject2;
      localObject6 = localObject1;
      if (!paramBundle.containsKey("mac")) {
        break label793;
      }
      localObject4 = localObject3;
      localObject5 = localObject2;
      localObject6 = localObject1;
    }
    label793:
    for (paramBundle = paramBundle.getString("mac");; paramBundle = "")
    {
      try
      {
        paramContext = paramContext.getSharedPreferences("uifa", 0).edit();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramContext.putString("wx_userid", (String)localObject1);
        }
        if (!TextUtils.isEmpty(str2)) {
          paramContext.putString("model", str2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject7)) {
          paramContext.putString("serial", (String)localObject7);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramContext.putString("imsi", (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          paramContext.putString("android_id", (String)localObject3);
        }
        if (!TextUtils.isEmpty(paramBundle)) {
          paramContext.putString("mac", paramBundle);
        }
        paramContext.putString("app_call", "done");
        paramContext.commit();
        break;
      }
      finally {}
      break;
      localObject4 = str1;
      localObject5 = localObject3;
      localObject6 = localObject1;
      boolean bool = ((String)localObject2).contains("unknown");
      if (!bool) {
        break label346;
      }
      localObject2 = localObject1;
      break label346;
    }
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
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */