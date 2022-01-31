package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sandbox.SandboxListener;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.t;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static String A;
  private static boolean B = false;
  private static boolean C = false;
  private static TbsListener D;
  private static TbsListener E;
  public static final int EXTENSION_INIT_FAILURE = -99999;
  private static boolean F = false;
  private static boolean G = false;
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
  static String d;
  static boolean e;
  static long f;
  static long g;
  static Object h;
  static boolean i;
  static boolean j;
  static boolean k;
  static volatile boolean l;
  static TbsListener m;
  public static boolean mDisableUseHostBackupCore;
  static Map<String, Object> n;
  private static int o;
  private static String p;
  private static Class<?> q;
  private static Object r;
  private static boolean s;
  public static boolean sIsVersionPrinted;
  private static String[] t;
  private static String u;
  private static String v;
  private static boolean w;
  private static int x;
  private static int y;
  private static String z;
  
  static
  {
    AppMethodBeat.i(64056);
    sIsVersionPrinted = false;
    o = 0;
    p = "";
    q = null;
    r = null;
    a = false;
    b = false;
    c = true;
    s = false;
    u = "NULL";
    v = "UNKNOWN";
    e = false;
    f = 0L;
    g = 0L;
    h = new Object();
    w = false;
    i = true;
    j = true;
    k = false;
    x = 0;
    y = 170;
    z = null;
    A = null;
    l = a;
    mDisableUseHostBackupCore = false;
    B = false;
    C = true;
    D = null;
    E = null;
    F = false;
    G = false;
    m = new n();
    KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    n = null;
    AppMethodBeat.o(64056);
  }
  
  static Bundle a(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(64004);
    if (!a(paramContext))
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "initForPatch return false!");
      AppMethodBeat.o(64004);
      return null;
    }
    paramBundle = r.a(r, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null)
    {
      paramContext = (Bundle)paramBundle;
      AppMethodBeat.o(64004);
      return paramContext;
    }
    TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "incrUpdate return null!");
    AppMethodBeat.o(64004);
    return null;
  }
  
  static Object a(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(64052);
    if (!a(paramContext))
    {
      AppMethodBeat.o(64052);
      return Integer.valueOf(-99999);
    }
    paramContext = r.a(r, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
    if (paramContext != null)
    {
      AppMethodBeat.o(64052);
      return paramContext;
    }
    AppMethodBeat.o(64052);
    return null;
  }
  
  static String a()
  {
    return p;
  }
  
  /* Error */
  static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 225
    //   5: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 107	com/tencent/smtt/sdk/QbSdk:a	Z
    //   11: ifeq +12 -> 23
    //   14: ldc 225
    //   16: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_1
    //   24: putstatic 107	com/tencent/smtt/sdk/QbSdk:a	Z
    //   27: ldc 227
    //   29: aload_1
    //   30: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   36: putstatic 121	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   39: ldc 236
    //   41: new 238	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 240
    //   47: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: getstatic 121	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   53: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   65: aload_0
    //   66: sipush 401
    //   69: new 262	java/lang/Throwable
    //   72: dup
    //   73: getstatic 121	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   76: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   79: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   82: ldc 225
    //   84: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -68 -> 19
    //   90: astore_0
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	19	90	finally
    //   23	87	90	finally
  }
  
  static boolean a(Context paramContext)
  {
    AppMethodBeat.i(64001);
    try
    {
      Object localObject1 = q;
      if (localObject1 != null)
      {
        AppMethodBeat.o(64001);
        return true;
      }
      Object localObject2 = ao.a().q(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        AppMethodBeat.o(64001);
        return false;
      }
      localObject1 = new File((File)localObject2, "tbs_sdk_extension_dex.jar");
      if (!((File)localObject1).exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        AppMethodBeat.o(64001);
        return false;
      }
      TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + ((File)localObject1).getAbsolutePath());
      bz.a().a(paramContext);
      t.a(paramContext);
      String str1 = ((File)localObject1).getParent();
      String str2 = ((File)localObject1).getAbsolutePath();
      localObject2 = ((File)localObject2).getAbsolutePath();
      q = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
      AppMethodBeat.o(64001);
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(64001);
    }
    return false;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(64005);
    boolean bool = a(paramContext, paramInt, 20000);
    AppMethodBeat.o(64005);
    return bool;
  }
  
  static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(64006);
    if ((n != null) && (n.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD)) && (n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
      AppMethodBeat.o(64006);
      return true;
    }
    ao localao = ao.a();
    if (o.a == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localao.b(paramContext, bool);
      if (c(paramContext)) {
        break;
      }
      AppMethodBeat.o(64006);
      return true;
    }
    paramContext = r.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43663), Integer.valueOf(paramInt2) });
    if (paramContext != null)
    {
      bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(64006);
      return bool;
    }
    paramContext = r.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43663) });
    if (paramContext != null)
    {
      bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(64006);
      return bool;
    }
    AppMethodBeat.o(64006);
    return true;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(63997);
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43663; SDK_VERSION_NAME: 4.3.0.1114");
      sIsVersionPrinted = true;
    }
    if ((a) && (!paramBoolean))
    {
      TbsLog.e("QbSdk", "QbSdk init: " + v, false);
      TbsCoreLoadStat.getInstance().a(paramContext, 414, new Throwable(v));
      AppMethodBeat.o(63997);
      return false;
    }
    if (b)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable(u));
      AppMethodBeat.o(63997);
      return false;
    }
    if (!C) {
      d(paramContext);
    }
    int i1;
    try
    {
      localObject3 = ao.a().q(paramContext);
      if (localObject3 == null)
      {
        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
        TbsCoreLoadStat.getInstance().a(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
        AppMethodBeat.o(63997);
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if ((o != 0) && (o != TbsShareManager.d(paramContext)))
        {
          q = null;
          r = null;
          TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
          TbsCoreLoadStat.getInstance().a(paramContext, 302, new Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + TbsShareManager.d(paramContext)));
          AppMethodBeat.o(63997);
          return false;
        }
      }
      for (o = TbsShareManager.d(paramContext); q != null; o = i1)
      {
        Object localObject1 = r;
        if (localObject1 == null) {
          break;
        }
        AppMethodBeat.o(63997);
        return true;
        if (o != 0)
        {
          int i2 = ao.a().a(true, paramContext);
          i1 = i2;
          if (o != i2)
          {
            q = null;
            r = null;
            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=".concat(String.valueOf(i2)), true);
            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
            TbsCoreLoadStat.getInstance().a(paramContext, 303, new Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + i2));
            AppMethodBeat.o(63997);
            return false;
          }
        }
        else
        {
          i1 = 0;
        }
      }
      if (!TbsShareManager.isThirdPartyApp(paramContext)) {
        break label649;
      }
    }
    catch (Throwable localThrowable)
    {
      TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable));
      TbsCoreLoadStat.getInstance().a(paramContext, 306, localThrowable);
      AppMethodBeat.o(63997);
      return false;
    }
    Object localObject2;
    if (TbsShareManager.j(paramContext))
    {
      localObject2 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
      paramBoolean = ((File)localObject2).exists();
      if (paramBoolean) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
          i1 = ao.a().i(paramContext);
          if (!new File(((File)localObject2).getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
            continue;
          }
          if (i1 <= 0) {
            continue;
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(i1))));
        }
        catch (Throwable paramContext)
        {
          label649:
          continue;
        }
        AppMethodBeat.o(63997);
        return false;
        TbsCoreLoadStat.getInstance().a(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
        AppMethodBeat.o(63997);
        return false;
        localObject2 = new File(ao.a().q(paramContext), "tbs_sdk_extension_dex.jar");
        break;
        TbsCoreLoadStat.getInstance().a(paramContext, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(i1))));
        continue;
        if (i1 > 0) {
          TbsCoreLoadStat.getInstance().a(paramContext, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(i1))));
        } else {
          TbsCoreLoadStat.getInstance().a(paramContext, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(i1))));
        }
      }
    }
    if (TbsShareManager.getHostCorePathAppDefined() != null) {}
    for (Object localObject3 = TbsShareManager.getHostCorePathAppDefined();; localObject3 = ((File)localObject3).getAbsolutePath())
    {
      TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is ".concat(String.valueOf(localObject3)));
      TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + ((File)localObject2).getAbsolutePath());
      bz.a().a(paramContext);
      t.a(paramContext);
      q = new DexLoader(((File)localObject2).getParent(), paramContext, new String[] { ((File)localObject2).getAbsolutePath() }, (String)localObject3, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, ((File)localObject2).getParent());
      localObject2 = r;
      localObject3 = b.a;
      String str1 = b.b;
      String str2 = b.c;
      String str3 = b.d;
      r.a(localObject2, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject3, str1, str2, str3 });
      r.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(63997);
      return true;
    }
  }
  
  /* Error */
  static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore 6
    //   8: ldc_w 480
    //   11: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_0
    //   15: invokestatic 485	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   18: invokevirtual 489	com/tencent/smtt/sdk/TbsPVConfig:getDisabledCoreVersion	()I
    //   21: istore_3
    //   22: iload_3
    //   23: ifeq +30 -> 53
    //   26: iload_3
    //   27: invokestatic 272	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   30: aload_0
    //   31: invokevirtual 439	com/tencent/smtt/sdk/ao:i	(Landroid/content/Context;)I
    //   34: if_icmpne +19 -> 53
    //   37: ldc 236
    //   39: ldc_w 491
    //   42: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc_w 480
    //   48: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_0
    //   54: invokestatic 402	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   57: ifeq +28 -> 85
    //   60: aload_0
    //   61: invokestatic 493	com/tencent/smtt/sdk/TbsShareManager:i	(Landroid/content/Context;)Z
    //   64: ifne +21 -> 85
    //   67: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   70: aload_0
    //   71: sipush 302
    //   74: invokevirtual 496	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;I)V
    //   77: ldc_w 480
    //   80: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_0
    //   84: ireturn
    //   85: aload_0
    //   86: iload_1
    //   87: invokestatic 498	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Z)Z
    //   90: ifne +19 -> 109
    //   93: ldc 236
    //   95: ldc_w 500
    //   98: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: ldc_w 480
    //   104: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_0
    //   108: ireturn
    //   109: getstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   112: ldc_w 502
    //   115: iconst_1
    //   116: anewarray 199	java/lang/Class
    //   119: dup
    //   120: iconst_0
    //   121: getstatic 373	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   124: aastore
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: ldc_w 374
    //   134: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: invokestatic 208	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   141: astore 8
    //   143: aload 8
    //   145: ifnull +887 -> 1032
    //   148: aload 8
    //   150: instanceof 222
    //   153: ifeq +25 -> 178
    //   156: aload 8
    //   158: checkcast 222	java/lang/String
    //   161: ldc_w 504
    //   164: invokevirtual 508	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   167: ifeq +11 -> 178
    //   170: ldc_w 480
    //   173: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: iconst_0
    //   177: ireturn
    //   178: aload 8
    //   180: instanceof 203
    //   183: ifne +42 -> 225
    //   186: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   189: aload_0
    //   190: sipush 330
    //   193: new 262	java/lang/Throwable
    //   196: dup
    //   197: aload 8
    //   199: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   202: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   205: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   208: ldc_w 510
    //   211: ldc_w 512
    //   214: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: ldc_w 480
    //   220: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: iconst_0
    //   224: ireturn
    //   225: aload 8
    //   227: checkcast 203	android/os/Bundle
    //   230: astore 7
    //   232: aload 7
    //   234: invokevirtual 515	android/os/Bundle:isEmpty	()Z
    //   237: ifeq +42 -> 279
    //   240: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   243: aload_0
    //   244: sipush 331
    //   247: new 262	java/lang/Throwable
    //   250: dup
    //   251: aload 8
    //   253: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   256: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   259: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   262: ldc_w 510
    //   265: ldc_w 517
    //   268: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: ldc_w 480
    //   274: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload 7
    //   281: ldc_w 519
    //   284: iconst_m1
    //   285: invokevirtual 523	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   288: istore_3
    //   289: iload_3
    //   290: ifne +177 -> 467
    //   293: iconst_1
    //   294: istore_1
    //   295: aload_0
    //   296: invokestatic 402	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   299: ifeq +173 -> 472
    //   302: aload_0
    //   303: invokestatic 405	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   306: invokestatic 525	com/tencent/smtt/sdk/o:a	(I)V
    //   309: aload_0
    //   310: invokestatic 405	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   313: invokestatic 422	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   316: astore 8
    //   318: aload 8
    //   320: putstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   323: aload 8
    //   325: invokevirtual 528	java/lang/String:length	()I
    //   328: iconst_5
    //   329: if_icmpne +25 -> 354
    //   332: new 238	java/lang/StringBuilder
    //   335: dup
    //   336: ldc_w 530
    //   339: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: getstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   345: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: putstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   354: getstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   357: invokevirtual 528	java/lang/String:length	()I
    //   360: bipush 6
    //   362: if_icmpeq +8 -> 370
    //   365: ldc 99
    //   367: putstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   370: aload 7
    //   372: ldc_w 532
    //   375: invokevirtual 536	android/os/Bundle:getStringArray	(Ljava/lang/String;)[Ljava/lang/String;
    //   378: putstatic 538	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   381: getstatic 538	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   384: instanceof 539
    //   387: ifne +349 -> 736
    //   390: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   393: aload_0
    //   394: sipush 307
    //   397: new 262	java/lang/Throwable
    //   400: dup
    //   401: new 238	java/lang/StringBuilder
    //   404: dup
    //   405: ldc_w 541
    //   408: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: getstatic 538	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   414: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   423: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   426: ldc_w 480
    //   429: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: iconst_0
    //   433: ireturn
    //   434: astore 8
    //   436: ldc 236
    //   438: new 238	java/lang/StringBuilder
    //   441: dup
    //   442: ldc_w 546
    //   445: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   448: aload 8
    //   450: invokevirtual 547	java/lang/Exception:toString	()Ljava/lang/String;
    //   453: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: iconst_m1
    //   463: istore_3
    //   464: goto -175 -> 289
    //   467: iconst_0
    //   468: istore_1
    //   469: goto -174 -> 295
    //   472: getstatic 552	android/os/Build$VERSION:SDK_INT	I
    //   475: bipush 12
    //   477: if_icmplt +66 -> 543
    //   480: aload 7
    //   482: ldc_w 554
    //   485: ldc_w 530
    //   488: invokevirtual 558	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   491: putstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   494: getstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   497: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   500: putstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   503: getstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   506: invokestatic 525	com/tencent/smtt/sdk/o:a	(I)V
    //   509: getstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   512: ifne +80 -> 592
    //   515: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   518: aload_0
    //   519: sipush 307
    //   522: new 262	java/lang/Throwable
    //   525: dup
    //   526: ldc_w 564
    //   529: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   532: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   535: ldc_w 480
    //   538: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: iconst_0
    //   542: ireturn
    //   543: aload 7
    //   545: ldc_w 554
    //   548: invokevirtual 566	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   551: astore 8
    //   553: aload 8
    //   555: putstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   558: aload 8
    //   560: ifnonnull -66 -> 494
    //   563: ldc_w 530
    //   566: putstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   569: goto -75 -> 494
    //   572: astore 8
    //   574: ldc_w 530
    //   577: putstatic 101	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   580: goto -86 -> 494
    //   583: astore 8
    //   585: iconst_0
    //   586: putstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   589: goto -86 -> 503
    //   592: getstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   595: ifle +16 -> 611
    //   598: iload 5
    //   600: istore 4
    //   602: getstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   605: sipush 25442
    //   608: if_icmple +16 -> 624
    //   611: getstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   614: sipush 25472
    //   617: if_icmpne +91 -> 708
    //   620: iload 5
    //   622: istore 4
    //   624: iload 4
    //   626: ifeq -256 -> 370
    //   629: ldc_w 568
    //   632: new 238	java/lang/StringBuilder
    //   635: dup
    //   636: ldc_w 570
    //   639: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   642: getstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   645: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: invokestatic 272	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   657: aload_0
    //   658: invokevirtual 275	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   661: invokestatic 575	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   664: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   667: aload_0
    //   668: sipush 307
    //   671: new 262	java/lang/Throwable
    //   674: dup
    //   675: new 238	java/lang/StringBuilder
    //   678: dup
    //   679: ldc_w 570
    //   682: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   685: getstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   688: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   697: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   700: ldc_w 480
    //   703: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   706: iconst_0
    //   707: ireturn
    //   708: iconst_0
    //   709: istore 4
    //   711: goto -87 -> 624
    //   714: astore 7
    //   716: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   719: aload_0
    //   720: sipush 329
    //   723: aload 7
    //   725: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   728: ldc_w 480
    //   731: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   734: iconst_0
    //   735: ireturn
    //   736: aload 7
    //   738: ldc_w 577
    //   741: invokevirtual 566	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   744: putstatic 578	com/tencent/smtt/sdk/QbSdk:d	Ljava/lang/String;
    //   747: aconst_null
    //   748: astore 8
    //   750: aload 8
    //   752: astore 7
    //   754: iload_3
    //   755: ifeq +22 -> 777
    //   758: getstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   761: ldc_w 580
    //   764: iconst_0
    //   765: anewarray 199	java/lang/Class
    //   768: iconst_0
    //   769: anewarray 4	java/lang/Object
    //   772: invokestatic 208	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   775: astore 7
    //   777: iload_3
    //   778: tableswitch	default:+26 -> 804, -2:+176->954, -1:+101->879, 0:+251->1029
    //   805: aconst_null
    //   806: iconst_1
    //   807: aload_0
    //   808: sipush 415
    //   811: new 262	java/lang/Throwable
    //   814: dup
    //   815: new 238	java/lang/StringBuilder
    //   818: dup
    //   819: ldc_w 582
    //   822: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   825: aload 7
    //   827: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   830: ldc_w 584
    //   833: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: iload_3
    //   837: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   840: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   846: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   849: iload_1
    //   850: ifne +12 -> 862
    //   853: ldc_w 510
    //   856: ldc_w 586
    //   859: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   862: ldc_w 480
    //   865: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   868: iload_1
    //   869: ireturn
    //   870: astore_0
    //   871: ldc_w 480
    //   874: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   877: iconst_0
    //   878: ireturn
    //   879: aload 7
    //   881: instanceof 214
    //   884: ifeq +39 -> 923
    //   887: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   890: aload_0
    //   891: aload 7
    //   893: checkcast 214	java/lang/Integer
    //   896: invokevirtual 589	java/lang/Integer:intValue	()I
    //   899: new 262	java/lang/Throwable
    //   902: dup
    //   903: ldc_w 582
    //   906: aload 7
    //   908: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   911: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   914: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   917: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   920: goto -71 -> 849
    //   923: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   926: aload_0
    //   927: sipush 307
    //   930: new 262	java/lang/Throwable
    //   933: dup
    //   934: ldc_w 582
    //   937: aload 7
    //   939: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   942: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   945: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   948: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   951: goto -102 -> 849
    //   954: aload 7
    //   956: instanceof 214
    //   959: ifeq +39 -> 998
    //   962: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   965: aload_0
    //   966: aload 7
    //   968: checkcast 214	java/lang/Integer
    //   971: invokevirtual 589	java/lang/Integer:intValue	()I
    //   974: new 262	java/lang/Throwable
    //   977: dup
    //   978: ldc_w 582
    //   981: aload 7
    //   983: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   986: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   989: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   992: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   995: goto -146 -> 849
    //   998: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1001: aload_0
    //   1002: sipush 404
    //   1005: new 262	java/lang/Throwable
    //   1008: dup
    //   1009: ldc_w 582
    //   1012: aload 7
    //   1014: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1017: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1020: invokespecial 263	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   1023: invokevirtual 266	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   1026: goto -177 -> 849
    //   1029: goto -180 -> 849
    //   1032: getstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   1035: astore 7
    //   1037: getstatic 373	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1040: astore 8
    //   1042: invokestatic 593	com/tencent/smtt/sdk/a:a	()I
    //   1045: istore_3
    //   1046: aload 7
    //   1048: ldc_w 595
    //   1051: iconst_1
    //   1052: anewarray 199	java/lang/Class
    //   1055: dup
    //   1056: iconst_0
    //   1057: aload 8
    //   1059: aastore
    //   1060: iconst_1
    //   1061: anewarray 4	java/lang/Object
    //   1064: dup
    //   1065: iconst_0
    //   1066: iload_3
    //   1067: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1070: aastore
    //   1071: invokestatic 208	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1074: astore 7
    //   1076: aload 7
    //   1078: ifnull +146 -> 1224
    //   1081: aload 7
    //   1083: instanceof 222
    //   1086: ifeq +25 -> 1111
    //   1089: aload 7
    //   1091: checkcast 222	java/lang/String
    //   1094: ldc_w 504
    //   1097: invokevirtual 508	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1100: ifeq +11 -> 1111
    //   1103: ldc_w 480
    //   1106: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1109: iconst_0
    //   1110: ireturn
    //   1111: iload 6
    //   1113: istore_1
    //   1114: aload 7
    //   1116: instanceof 376
    //   1119: ifeq -270 -> 849
    //   1122: invokestatic 597	com/tencent/smtt/sdk/o:d	()I
    //   1125: putstatic 97	com/tencent/smtt/sdk/QbSdk:o	I
    //   1128: aload_0
    //   1129: invokestatic 597	com/tencent/smtt/sdk/o:d	()I
    //   1132: invokestatic 599	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;I)Z
    //   1135: istore 6
    //   1137: iload_2
    //   1138: istore_1
    //   1139: aload 7
    //   1141: checkcast 376	java/lang/Boolean
    //   1144: invokevirtual 379	java/lang/Boolean:booleanValue	()Z
    //   1147: ifeq +12 -> 1159
    //   1150: iload_2
    //   1151: istore_1
    //   1152: iload 6
    //   1154: ifne +5 -> 1159
    //   1157: iconst_1
    //   1158: istore_1
    //   1159: iload_1
    //   1160: ifne +56 -> 1216
    //   1163: ldc_w 510
    //   1166: ldc_w 601
    //   1169: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1172: ldc_w 510
    //   1175: ldc_w 603
    //   1178: iload 6
    //   1180: invokestatic 606	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1183: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1186: invokestatic 608	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1189: ldc_w 510
    //   1192: new 238	java/lang/StringBuilder
    //   1195: dup
    //   1196: ldc_w 610
    //   1199: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1202: aload 7
    //   1204: checkcast 376	java/lang/Boolean
    //   1207: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1210: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1213: invokestatic 608	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1216: ldc_w 480
    //   1219: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1222: iload_1
    //   1223: ireturn
    //   1224: invokestatic 260	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1227: aload_0
    //   1228: sipush 308
    //   1231: invokevirtual 496	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;I)V
    //   1234: iload 6
    //   1236: istore_1
    //   1237: goto -388 -> 849
    //   1240: astore 7
    //   1242: aload 8
    //   1244: astore 7
    //   1246: goto -469 -> 777
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1249	0	paramContext	Context
    //   0	1249	1	paramBoolean1	boolean
    //   0	1249	2	paramBoolean2	boolean
    //   21	1046	3	i1	int
    //   600	110	4	i2	int
    //   1	620	5	i3	int
    //   6	1229	6	bool	boolean
    //   230	314	7	localBundle	Bundle
    //   714	23	7	localThrowable	Throwable
    //   752	451	7	localObject1	Object
    //   1240	1	7	localException1	Exception
    //   1244	1	7	localClass1	Class
    //   141	183	8	localObject2	Object
    //   434	15	8	localException2	Exception
    //   551	8	8	str	String
    //   572	1	8	localException3	Exception
    //   583	1	8	localNumberFormatException	java.lang.NumberFormatException
    //   748	495	8	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   279	289	434	java/lang/Exception
    //   472	494	572	java/lang/Exception
    //   543	558	572	java/lang/Exception
    //   563	569	572	java/lang/Exception
    //   494	503	583	java/lang/NumberFormatException
    //   370	381	714	java/lang/Throwable
    //   736	747	870	java/lang/Exception
    //   758	777	1240	java/lang/Exception
  }
  
  protected static String b()
  {
    AppMethodBeat.i(64053);
    Object localObject = bz.a();
    if ((localObject != null) && (((bz)localObject).b()))
    {
      localObject = ((bz)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String)))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(64053);
        return localObject;
      }
    }
    AppMethodBeat.o(64053);
    return null;
  }
  
  static boolean b(Context paramContext)
  {
    AppMethodBeat.i(64003);
    if (paramContext == null)
    {
      AppMethodBeat.o(64003);
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
      AppMethodBeat.o(64003);
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("QbSdk", "clearPluginConfigFile error is " + paramContext.getMessage());
      AppMethodBeat.o(64003);
    }
    return false;
  }
  
  private static boolean c(Context paramContext)
  {
    AppMethodBeat.i(64002);
    try
    {
      Object localObject1 = q;
      if (localObject1 != null)
      {
        AppMethodBeat.o(64002);
        return true;
      }
      Object localObject2 = ao.a().q(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
        AppMethodBeat.o(64002);
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.j(paramContext)) {}
      }
      for (localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar"); !((File)localObject1).exists(); localObject1 = new File(ao.a().q(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        AppMethodBeat.o(64002);
        return false;
        TbsCoreLoadStat.getInstance().a(paramContext, 304);
        AppMethodBeat.o(64002);
        return false;
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is ".concat(String.valueOf(localObject2)));
        TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + ((File)localObject1).getAbsolutePath());
        bz.a().a(paramContext);
        t.a(paramContext);
        q = new DexLoader(((File)localObject1).getParent(), paramContext, new String[] { ((File)localObject1).getAbsolutePath() }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
        paramContext = r;
        localObject1 = b.a;
        localObject2 = b.b;
        String str1 = b.c;
        String str2 = b.d;
        r.a(paramContext, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject1, localObject2, str1, str2 });
        r.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(64002);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(64002);
    }
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    AppMethodBeat.i(64013);
    Object localObject = r.a(r, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().a(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      AppMethodBeat.o(64013);
      return false;
      TbsCoreLoadStat.getInstance().a(paramContext, 314);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(64013);
    return bool;
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    AppMethodBeat.i(64007);
    boolean bool = a(paramContext, false, false);
    AppMethodBeat.o(64007);
    return bool;
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    AppMethodBeat.i(64000);
    try
    {
      if (paramContext.getApplicationInfo().packageName.contains("com.moji.mjweather"))
      {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 == 19)
        {
          AppMethodBeat.o(64000);
          return true;
        }
      }
      if (q == null)
      {
        Object localObject = ao.a().q(paramContext);
        if (localObject == null)
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
          AppMethodBeat.o(64000);
          return false;
        }
        File localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        if (!localFile.exists())
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
          AppMethodBeat.o(64000);
          return false;
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {}
        for (localObject = TbsShareManager.getHostCorePathAppDefined();; localObject = ((File)localObject).getAbsolutePath())
        {
          TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is ".concat(String.valueOf(localObject)));
          TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + localFile.getAbsolutePath());
          bz.a().a(paramContext);
          t.a(paramContext);
          q = new DexLoader(localFile.getParent(), paramContext, new String[] { localFile.getAbsolutePath() }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
          if (r != null) {
            break label275;
          }
          if ((TbsShareManager.e(paramContext) != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) {
            break;
          }
          TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
          AppMethodBeat.o(64000);
          return false;
        }
        loadTBSSDKExtension(paramContext, localFile.getParent());
      }
      label275:
      paramContext = r.a(r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Boolean)))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        AppMethodBeat.o(64000);
        return bool;
      }
      AppMethodBeat.o(64000);
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(64000);
    }
    return false;
  }
  
  public static void canOpenFile(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(64021);
    new h(paramContext, paramString, paramValueCallback).start();
    AppMethodBeat.o(64021);
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    AppMethodBeat.i(64015);
    if (!a(paramContext, false))
    {
      AppMethodBeat.o(64015);
      return false;
    }
    AppMethodBeat.o(64015);
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
    //   6: ldc_w 769
    //   9: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: getstatic 142	com/tencent/smtt/sdk/QbSdk:x	I
    //   15: ifne +9 -> 24
    //   18: invokestatic 593	com/tencent/smtt/sdk/a:a	()I
    //   21: putstatic 142	com/tencent/smtt/sdk/QbSdk:x	I
    //   24: ldc 236
    //   26: new 238	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 771
    //   33: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: getstatic 142	com/tencent/smtt/sdk/QbSdk:x	I
    //   39: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 300	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: getstatic 552	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 7
    //   53: if_icmplt +12 -> 65
    //   56: getstatic 142	com/tencent/smtt/sdk/QbSdk:x	I
    //   59: getstatic 144	com/tencent/smtt/sdk/QbSdk:y	I
    //   62: if_icmpge +11 -> 73
    //   65: ldc_w 769
    //   68: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_0
    //   74: ifnonnull +11 -> 85
    //   77: ldc_w 769
    //   80: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_0
    //   84: ireturn
    //   85: new 773	java/io/BufferedInputStream
    //   88: dup
    //   89: new 775	java/io/FileInputStream
    //   92: dup
    //   93: new 279	java/io/File
    //   96: dup
    //   97: invokestatic 272	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   100: aload_0
    //   101: invokevirtual 275	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   104: ldc_w 777
    //   107: invokespecial 284	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   110: invokespecial 779	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: invokespecial 782	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   116: astore 6
    //   118: aload 6
    //   120: astore 5
    //   122: new 784	java/util/Properties
    //   125: dup
    //   126: invokespecial 785	java/util/Properties:<init>	()V
    //   129: astore 8
    //   131: aload 6
    //   133: astore 5
    //   135: aload 8
    //   137: aload 6
    //   139: invokevirtual 788	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   142: aload 6
    //   144: astore 5
    //   146: aload 8
    //   148: ldc_w 790
    //   151: invokevirtual 793	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 9
    //   156: aload 6
    //   158: astore 5
    //   160: aload 8
    //   162: ldc_w 795
    //   165: invokevirtual 793	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 10
    //   170: aload 6
    //   172: astore 5
    //   174: aload 9
    //   176: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   179: istore_1
    //   180: aload 6
    //   182: astore 5
    //   184: aload 10
    //   186: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   189: istore_2
    //   190: aload 6
    //   192: astore 5
    //   194: getstatic 798	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   197: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   200: istore_3
    //   201: iload_3
    //   202: iload_1
    //   203: if_icmpgt +8 -> 211
    //   206: iload_3
    //   207: iload_2
    //   208: if_icmpge +35 -> 243
    //   211: aload 6
    //   213: astore 5
    //   215: ldc 236
    //   217: ldc_w 800
    //   220: iload_3
    //   221: invokestatic 422	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   224: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokestatic 300	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 6
    //   232: invokevirtual 803	java/io/BufferedInputStream:close	()V
    //   235: ldc_w 769
    //   238: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: iconst_0
    //   242: ireturn
    //   243: aload 6
    //   245: astore 5
    //   247: aload 8
    //   249: ldc_w 554
    //   252: invokevirtual 793	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   258: istore_1
    //   259: aload 6
    //   261: invokevirtual 803	java/io/BufferedInputStream:close	()V
    //   264: new 775	java/io/FileInputStream
    //   267: dup
    //   268: new 279	java/io/File
    //   271: dup
    //   272: aload_0
    //   273: invokestatic 805	com/tencent/smtt/sdk/ao:s	(Landroid/content/Context;)Ljava/io/File;
    //   276: ldc_w 807
    //   279: invokespecial 284	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   282: invokespecial 779	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   285: astore 5
    //   287: new 784	java/util/Properties
    //   290: dup
    //   291: invokespecial 785	java/util/Properties:<init>	()V
    //   294: astore 6
    //   296: aload 6
    //   298: aload 5
    //   300: invokevirtual 788	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   303: aload 6
    //   305: ldc_w 809
    //   308: invokevirtual 793	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   314: istore_2
    //   315: aload 6
    //   317: ldc_w 811
    //   320: invokevirtual 793	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   323: invokestatic 562	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   326: istore_3
    //   327: iload_1
    //   328: ldc_w 812
    //   331: if_icmpeq +10 -> 341
    //   334: iload_2
    //   335: ldc_w 812
    //   338: if_icmpne +71 -> 409
    //   341: iconst_0
    //   342: istore_1
    //   343: aload 5
    //   345: invokevirtual 815	java/io/InputStream:close	()V
    //   348: iload_1
    //   349: ifne +195 -> 544
    //   352: ldc_w 769
    //   355: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: iconst_1
    //   359: ireturn
    //   360: astore_0
    //   361: aconst_null
    //   362: astore_0
    //   363: aload_0
    //   364: astore 5
    //   366: ldc 236
    //   368: ldc_w 817
    //   371: invokestatic 300	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload_0
    //   375: ifnull +7 -> 382
    //   378: aload_0
    //   379: invokevirtual 803	java/io/BufferedInputStream:close	()V
    //   382: ldc_w 769
    //   385: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: iconst_0
    //   389: ireturn
    //   390: astore_0
    //   391: aload 5
    //   393: ifnull +8 -> 401
    //   396: aload 5
    //   398: invokevirtual 803	java/io/BufferedInputStream:close	()V
    //   401: ldc_w 769
    //   404: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   430: invokestatic 819	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   433: if_icmpeq +8 -> 441
    //   436: iconst_0
    //   437: istore_1
    //   438: goto -95 -> 343
    //   441: aload 6
    //   443: ldc_w 821
    //   446: invokevirtual 793	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   449: invokestatic 824	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   452: ifeq +34 -> 486
    //   455: aload_0
    //   456: invokevirtual 743	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   459: invokestatic 653	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   462: getfield 657	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   465: ldc_w 826
    //   468: iconst_0
    //   469: invokeinterface 830 3 0
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
    //   495: ldc 236
    //   497: ldc_w 832
    //   500: invokestatic 300	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload_0
    //   504: ifnull +7 -> 511
    //   507: aload_0
    //   508: invokevirtual 815	java/io/InputStream:close	()V
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
    //   533: invokevirtual 815	java/io/InputStream:close	()V
    //   536: ldc_w 769
    //   539: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: aload_0
    //   543: athrow
    //   544: ldc_w 769
    //   547: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(64012);
    paramContext = r.a(r, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean)))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(64012);
      return bool;
    }
    AppMethodBeat.o(64012);
    return false;
  }
  
  public static void checkTbsValidity(Context paramContext)
  {
    AppMethodBeat.i(64029);
    if (paramContext == null)
    {
      AppMethodBeat.o(64029);
      return;
    }
    if (!t.b(paramContext))
    {
      TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
      TbsCoreLoadStat.getInstance().a(paramContext, 419);
      forceSysWebView();
    }
    AppMethodBeat.o(64029);
  }
  
  public static void clear(Context paramContext) {}
  
  /* Error */
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 846
    //   5: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 236
    //   10: new 238	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 848
    //   17: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: ldc_w 850
    //   27: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 853	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: ldc_w 855
    //   37: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 300	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: new 857	com/tencent/smtt/sdk/WebView
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 859	com/tencent/smtt/sdk/WebView:<init>	(Landroid/content/Context;)V
    //   54: invokevirtual 863	com/tencent/smtt/sdk/WebView:getWebViewClientExtension	()Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewClientExtension;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +232 -> 293
    //   64: invokestatic 305	com/tencent/smtt/sdk/bz:a	()Lcom/tencent/smtt/sdk/bz;
    //   67: astore 4
    //   69: iload_3
    //   70: istore_2
    //   71: aload 4
    //   73: ifnull +25 -> 98
    //   76: iload_3
    //   77: istore_2
    //   78: aload 4
    //   80: invokevirtual 614	com/tencent/smtt/sdk/bz:b	()Z
    //   83: ifeq +15 -> 98
    //   86: aload 4
    //   88: invokevirtual 617	com/tencent/smtt/sdk/bz:c	()Lcom/tencent/smtt/sdk/ca;
    //   91: aload_0
    //   92: iload_1
    //   93: invokevirtual 865	com/tencent/smtt/sdk/ca:a	(Landroid/content/Context;Z)V
    //   96: iload_3
    //   97: istore_2
    //   98: iload_2
    //   99: ifeq +51 -> 150
    //   102: ldc 236
    //   104: ldc_w 867
    //   107: invokestatic 300	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc_w 846
    //   113: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore 4
    //   119: iconst_0
    //   120: istore_2
    //   121: ldc 236
    //   123: new 238	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 869
    //   130: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload 4
    //   135: invokestatic 336	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   138: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: goto -49 -> 98
    //   150: new 871	android/webkit/WebView
    //   153: dup
    //   154: aload_0
    //   155: invokespecial 872	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   158: astore 4
    //   160: getstatic 552	android/os/Build$VERSION:SDK_INT	I
    //   163: bipush 11
    //   165: if_icmplt +27 -> 192
    //   168: aload 4
    //   170: ldc_w 874
    //   173: invokevirtual 877	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   176: aload 4
    //   178: ldc_w 879
    //   181: invokevirtual 877	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   184: aload 4
    //   186: ldc_w 881
    //   189: invokevirtual 877	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   192: aload 4
    //   194: iconst_1
    //   195: invokevirtual 885	android/webkit/WebView:clearCache	(Z)V
    //   198: iload_1
    //   199: ifeq +14 -> 213
    //   202: aload_0
    //   203: invokestatic 891	android/webkit/CookieSyncManager:createInstance	(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;
    //   206: pop
    //   207: invokestatic 896	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   210: invokevirtual 899	android/webkit/CookieManager:removeAllCookie	()V
    //   213: aload_0
    //   214: invokestatic 904	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   217: invokevirtual 907	android/webkit/WebViewDatabase:clearUsernamePassword	()V
    //   220: aload_0
    //   221: invokestatic 904	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   224: invokevirtual 910	android/webkit/WebViewDatabase:clearHttpAuthUsernamePassword	()V
    //   227: aload_0
    //   228: invokestatic 904	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   231: invokevirtual 913	android/webkit/WebViewDatabase:clearFormData	()V
    //   234: invokestatic 918	android/webkit/WebStorage:getInstance	()Landroid/webkit/WebStorage;
    //   237: invokevirtual 921	android/webkit/WebStorage:deleteAllData	()V
    //   240: invokestatic 926	android/webkit/WebIconDatabase:getInstance	()Landroid/webkit/WebIconDatabase;
    //   243: invokevirtual 929	android/webkit/WebIconDatabase:removeAllIcons	()V
    //   246: ldc_w 846
    //   249: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: return
    //   253: astore_0
    //   254: ldc 236
    //   256: new 238	java/lang/StringBuilder
    //   259: dup
    //   260: ldc_w 931
    //   263: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_0
    //   267: invokestatic 336	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   270: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: ldc_w 846
    //   282: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: return
    //   286: astore 4
    //   288: iconst_1
    //   289: istore_2
    //   290: goto -169 -> 121
    //   293: iconst_0
    //   294: istore_2
    //   295: goto -197 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramContext	Context
    //   0	298	1	paramBoolean	boolean
    //   70	225	2	i1	int
    //   1	96	3	i2	int
    //   57	30	4	localObject	Object
    //   117	17	4	localThrowable1	Throwable
    //   158	35	4	localWebView	android.webkit.WebView
    //   286	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   46	59	117	java/lang/Throwable
    //   150	192	253	java/lang/Throwable
    //   192	198	253	java/lang/Throwable
    //   202	213	253	java/lang/Throwable
    //   213	246	253	java/lang/Throwable
    //   64	69	286	java/lang/Throwable
    //   78	96	286	java/lang/Throwable
  }
  
  public static void closeFileReader(Context paramContext)
  {
    AppMethodBeat.i(64022);
    bz localbz = bz.a();
    localbz.a(paramContext, null);
    if (localbz.b()) {
      localbz.c().p();
    }
    AppMethodBeat.o(64022);
  }
  
  public static void continueLoadSo(Context paramContext)
  {
    AppMethodBeat.i(64035);
    if (("com.tencent.mm".equals(getCurrentProcessName(paramContext))) && (WebView.mWebViewCreated)) {
      r.a(r, "continueLoadSo", new Class[0], new Object[0]);
    }
    AppMethodBeat.o(64035);
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    AppMethodBeat.i(64047);
    if (paramContext == null)
    {
      AppMethodBeat.o(64047);
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext))
    {
      AppMethodBeat.o(64047);
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true)
    {
      AppMethodBeat.o(64047);
      return false;
    }
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localbz.c().b();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: ".concat(String.valueOf(paramContext)));
      if (paramContext != null)
      {
        AppMethodBeat.o(64047);
        return true;
      }
      AppMethodBeat.o(64047);
      return false;
    }
    AppMethodBeat.o(64047);
    return false;
  }
  
  private static void d(Context paramContext)
  {
    int i6 = -1;
    AppMethodBeat.i(64032);
    C = true;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject2 = localObject1;
          localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
          localObject2 = localObject1;
          i3 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
          if (i3 < 0) {
            break label594;
          }
          i1 = i3 + 1;
          if (i1 > 4) {
            AppMethodBeat.o(64032);
          }
        }
        else
        {
          localObject2 = localObject1;
          localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
          continue;
        }
        int i3 = i1;
        int i5;
        int i4;
        if (i1 <= 0) {
          break label491;
        }
      }
      catch (Throwable localThrowable3)
      {
        try
        {
          i2 = ao.a().i(paramContext);
          if (i2 <= 0)
          {
            AppMethodBeat.o(64032);
            return;
          }
          if (i3 > 4) {}
        }
        catch (Throwable localThrowable1)
        {
          int i2 = -1;
          continue;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", i3).commit();
          i5 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
          i4 = i1;
          localObject2 = localObject1;
          i3 = i2;
          if (i5 >= 0)
          {
            localObject2 = ((SharedPreferences)localObject1).edit();
            i5 += 1;
            ((SharedPreferences.Editor)localObject2).putInt("tbs_preload_x5_counter", i5).commit();
            if (i5 <= 3) {
              break label450;
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        try
        {
          i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_version", -1);
          localObject1 = ((SharedPreferences)localObject1).edit();
          if (i1 == i2)
          {
            com.tencent.smtt.utils.k.a(ao.a().q(paramContext), false);
            paramContext = aj.a(paramContext).a();
            if (paramContext != null) {
              com.tencent.smtt.utils.k.a(paramContext, false);
            }
            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
            ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i1);
            ((SharedPreferences.Editor)localObject1).commit();
            AppMethodBeat.o(64032);
            return;
            localThrowable3 = localThrowable3;
            i1 = -1;
            i2 = -1;
            localObject1 = localObject2;
            localObject2 = localThrowable3;
            TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString((Throwable)localObject2));
            i3 = i2;
            localObject2 = localObject1;
            i4 = i1;
            i5 = -1;
            i1 = i4;
            localObject1 = localObject2;
            i2 = i3;
            continue;
          }
          TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i1);
          continue;
          i2 = i6;
        }
        catch (Throwable paramContext)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
          AppMethodBeat.o(64032);
          return;
        }
      }
      label450:
      i2 = i6;
      if (i1 <= 3)
      {
        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
        bz.a().a(paramContext, null);
        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
        i2 = 0;
      }
      try
      {
        label491:
        i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
        if (i1 > 0) {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_counter", i1 - 1).commit();
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(paramContext));
        }
      }
      TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:".concat(String.valueOf(i2)));
      AppMethodBeat.o(64032);
      return;
      label594:
      int i1 = -1;
    }
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(64049);
    if (paramContext == null)
    {
      AppMethodBeat.o(64049);
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext))
    {
      AppMethodBeat.o(64049);
      return false;
    }
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      if (localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) != null)
      {
        AppMethodBeat.o(64049);
        return true;
      }
      AppMethodBeat.o(64049);
      return false;
    }
    AppMethodBeat.o(64049);
    return false;
  }
  
  public static void disAllowThirdAppDownload()
  {
    c = false;
  }
  
  public static void disableAutoCreateX5Webview()
  {
    j = false;
  }
  
  public static void fileInfoDetect(Context paramContext, String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(64054);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b())) {
      try
      {
        localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
        AppMethodBeat.o(64054);
        return;
      }
      catch (Throwable paramContext) {}
    }
    AppMethodBeat.o(64054);
  }
  
  public static void forceSysWebView()
  {
    AppMethodBeat.i(64019);
    b = true;
    u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    AppMethodBeat.o(64019);
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    AppMethodBeat.i(64039);
    if (paramContext != null)
    {
      long l1 = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
      AppMethodBeat.o(64039);
      return l1;
    }
    AppMethodBeat.o(64039);
    return 0L;
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    AppMethodBeat.i(64026);
    for (;;)
    {
      try
      {
        int i1 = Process.myPid();
        Object localObject = "";
        Iterator localIterator = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses().iterator();
        paramContext = (Context)localObject;
        if (localIterator.hasNext())
        {
          localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i1) {
            paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          }
        }
        else
        {
          AppMethodBeat.o(64026);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(64026);
        return "";
      }
    }
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i1 = 0;
    AppMethodBeat.i(64037);
    if ((t instanceof String[]))
    {
      int i2 = t.length;
      paramContext1 = new String[i2];
      while (i1 < i2)
      {
        paramContext1[i1] = (paramString + t[i1]);
        i1 += 1;
      }
      AppMethodBeat.o(64037);
      return paramContext1;
    }
    paramContext1 = r.a(r, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      AppMethodBeat.o(64037);
      return paramContext1;
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return F;
  }
  
  public static boolean getIsSysWebViewForcedByOuter()
  {
    return b;
  }
  
  public static boolean getJarFilesAndLibraryPath(Context paramContext)
  {
    AppMethodBeat.i(64036);
    if (r == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
      AppMethodBeat.o(64036);
      return false;
    }
    Bundle localBundle = (Bundle)r.a(r, "canLoadX5CoreAndNotLoadSo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43663) });
    if (localBundle == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + ao.a().a(true, paramContext));
      AppMethodBeat.o(64036);
      return false;
    }
    t = localBundle.getStringArray("tbs_jarfiles");
    d = localBundle.getString("tbs_librarypath");
    AppMethodBeat.o(64036);
    return true;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    AppMethodBeat.i(64046);
    bz localbz = bz.a();
    localbz.a(paramContext, null);
    if ((localbz != null) && (localbz.b()))
    {
      paramContext = localbz.c().f();
      AppMethodBeat.o(64046);
      return paramContext;
    }
    AppMethodBeat.o(64046);
    return null;
  }
  
  public static boolean getOnlyDownload()
  {
    return k;
  }
  
  public static String getQQBuildNumber()
  {
    return A;
  }
  
  public static Map<String, Object> getSettings()
  {
    return n;
  }
  
  public static boolean getTBSInstalling()
  {
    return G;
  }
  
  public static String getTID()
  {
    return z;
  }
  
  public static String getTbsResourcesPath(Context paramContext)
  {
    AppMethodBeat.i(64017);
    paramContext = TbsShareManager.g(paramContext);
    AppMethodBeat.o(64017);
    return paramContext;
  }
  
  public static int getTbsSdkVersion()
  {
    return 43663;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(64033);
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      i1 = TbsShareManager.a(paramContext, false);
      AppMethodBeat.o(64033);
      return i1;
    }
    int i1 = ao.a().i(paramContext);
    if ((i1 == 0) && (aj.a(paramContext).c() == 3)) {
      reset(paramContext);
    }
    AppMethodBeat.o(64033);
    return i1;
  }
  
  public static int getTbsVersionForCrash(Context paramContext)
  {
    AppMethodBeat.i(64034);
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      i1 = TbsShareManager.a(paramContext, false);
      AppMethodBeat.o(64034);
      return i1;
    }
    int i1 = ao.a().j(paramContext);
    if ((i1 == 0) && (aj.a(paramContext).c() == 3)) {
      reset(paramContext);
    }
    AppMethodBeat.o(64034);
    return i1;
  }
  
  public static int getTmpDirTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(64055);
    int i1;
    if (aj.a(paramContext).c() == 2)
    {
      i1 = ao.a().e(paramContext, 0);
      AppMethodBeat.o(64055);
      return i1;
    }
    if (aj.a(paramContext).b("copy_status") == 1)
    {
      i1 = ao.a().e(paramContext, 1);
      AppMethodBeat.o(64055);
      return i1;
    }
    AppMethodBeat.o(64055);
    return 0;
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public static void initForinitAndNotLoadSo(Context paramContext)
  {
    AppMethodBeat.i(63999);
    if (q == null)
    {
      Object localObject = ao.a().q(paramContext);
      if (localObject == null)
      {
        AppMethodBeat.o(63999);
        return;
      }
      File localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
      if (!localFile.exists())
      {
        AppMethodBeat.o(63999);
        return;
      }
      localObject = ((File)localObject).getAbsolutePath();
      bz.a().a(paramContext);
      t.a(paramContext);
      q = new DexLoader(localFile.getParent(), paramContext, new String[] { localFile.getAbsolutePath() }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
    }
    AppMethodBeat.o(63999);
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(64051);
    if (n == null)
    {
      n = paramMap;
      AppMethodBeat.o(64051);
      return;
    }
    try
    {
      n.putAll(paramMap);
      AppMethodBeat.o(64051);
      return;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(64051);
    }
  }
  
  public static void initX5Environment(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(64031);
    if (paramContext == null)
    {
      TbsLog.e("QbSdk", "initX5Environment,context=null");
      AppMethodBeat.o(64031);
      return;
    }
    b(paramContext);
    E = new l(paramContext, paramPreInitCallback);
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      ao.a().b(paramContext, true);
    }
    TbsDownloader.needDownload(paramContext, false, false, true, new m(paramContext, paramPreInitCallback));
    AppMethodBeat.o(64031);
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(64011);
    o localo = o.a(true);
    localo.a(paramContext, false, false, null);
    if ((localo != null) && (localo.b()))
    {
      boolean bool = localo.a().a(paramContext, paramString1, paramString2, paramBundle);
      AppMethodBeat.o(64011);
      return bool;
    }
    AppMethodBeat.o(64011);
    return false;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    AppMethodBeat.i(64050);
    if (paramWebView == null)
    {
      AppMethodBeat.o(64050);
      return false;
    }
    Context localContext;
    int i1;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      localContext = paramWebView.getContext();
      i1 = paramString1.indexOf("url=");
      if (i1 <= 0) {
        break label202;
      }
    }
    label202:
    for (paramIntent = paramString1.substring(i1 + 4);; paramIntent = null)
    {
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        String str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          paramString1 = paramIntent;
        }
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent))
      {
        paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";
        if (d.a(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
        {
          paramString1 = bz.a();
          if ((paramString1 != null) && (paramString1.b()) && (paramString1.c().a(localContext, paramIntent, null, paramString2, null) == 0))
          {
            AppMethodBeat.o(64050);
            return true;
          }
          paramWebView.loadUrl(paramIntent);
        }
        for (;;)
        {
          AppMethodBeat.o(64050);
          return false;
          paramWebView.loadUrl(paramString1);
        }
      }
    }
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(64048);
    if (paramContext == null)
    {
      AppMethodBeat.o(64048);
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext))
    {
      AppMethodBeat.o(64048);
      return false;
    }
    paramString2 = bz.a();
    if ((paramString2 != null) && (paramString2.b()))
    {
      paramString1 = paramString2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramString1 != null)
      {
        paramContext = Boolean.FALSE;
        if (!(paramString1 instanceof Boolean)) {
          break label140;
        }
        paramContext = (Boolean)paramString1;
      }
    }
    label140:
    for (;;)
    {
      boolean bool = paramContext.booleanValue();
      AppMethodBeat.o(64048);
      return bool;
      AppMethodBeat.o(64048);
      return false;
      AppMethodBeat.o(64048);
      return false;
    }
  }
  
  public static boolean isNeedInitX5FirstTime()
  {
    return w;
  }
  
  public static boolean isTbsCoreInited()
  {
    AppMethodBeat.i(64030);
    o localo = o.a(false);
    if ((localo != null) && (localo.g()))
    {
      AppMethodBeat.o(64030);
      return true;
    }
    AppMethodBeat.o(64030);
    return false;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    AppMethodBeat.i(64009);
    if (aj.a(paramContext).c() == 2) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      AppMethodBeat.o(64009);
      return false;
    }
    if (!c(paramContext))
    {
      AppMethodBeat.o(64009);
      return true;
    }
    i1 = ao.a().i(paramContext);
    paramContext = r.a(r, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i1), Integer.valueOf(43663) });
    if (paramContext != null)
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(64009);
      return bool;
    }
    AppMethodBeat.o(64009);
    return true;
  }
  
  /* Error */
  public static void loadTBSSDKExtension(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 1250
    //   5: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   11: ifnull +10 -> 21
    //   14: ldc_w 1250
    //   17: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: ldc 2
    //   23: monitorenter
    //   24: getstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   27: ifnull +13 -> 40
    //   30: ldc 2
    //   32: monitorexit
    //   33: ldc_w 1250
    //   36: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: return
    //   40: getstatic 103	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   43: ifnonnull +11 -> 54
    //   46: ldc 236
    //   48: ldc_w 1252
    //   51: invokestatic 300	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aconst_null
    //   55: astore_3
    //   56: getstatic 103	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   59: iconst_5
    //   60: anewarray 199	java/lang/Class
    //   63: dup
    //   64: iconst_0
    //   65: ldc 201
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: ldc 201
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: ldc 222
    //   77: aastore
    //   78: dup
    //   79: iconst_3
    //   80: ldc 222
    //   82: aastore
    //   83: dup
    //   84: iconst_4
    //   85: ldc 222
    //   87: aastore
    //   88: invokevirtual 1256	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   91: astore 4
    //   93: aload 4
    //   95: astore_3
    //   96: aload_0
    //   97: invokestatic 402	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   100: ifeq +215 -> 315
    //   103: aload_0
    //   104: invokestatic 739	com/tencent/smtt/sdk/TbsShareManager:e	(Landroid/content/Context;)Landroid/content/Context;
    //   107: astore 4
    //   109: aload 4
    //   111: ifnonnull +42 -> 153
    //   114: invokestatic 457	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   117: ifnonnull +36 -> 153
    //   120: aload_0
    //   121: invokevirtual 743	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   124: invokestatic 189	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   127: sipush 227
    //   130: ldc_w 745
    //   133: invokevirtual 748	com/tencent/smtt/sdk/TbsLogReport:setLoadErrorCode	(ILjava/lang/String;)V
    //   136: ldc 2
    //   138: monitorexit
    //   139: ldc_w 1250
    //   142: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: return
    //   146: astore 4
    //   148: iconst_0
    //   149: istore_2
    //   150: goto -54 -> 96
    //   153: iload_2
    //   154: ifne +310 -> 464
    //   157: aload 4
    //   159: ifnonnull +73 -> 232
    //   162: getstatic 103	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   165: iconst_3
    //   166: anewarray 199	java/lang/Class
    //   169: dup
    //   170: iconst_0
    //   171: ldc 201
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: ldc 201
    //   178: aastore
    //   179: dup
    //   180: iconst_2
    //   181: ldc 222
    //   183: aastore
    //   184: invokevirtual 1256	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   187: astore_3
    //   188: aload_3
    //   189: iconst_5
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_0
    //   196: aastore
    //   197: dup
    //   198: iconst_1
    //   199: aload 4
    //   201: aastore
    //   202: dup
    //   203: iconst_2
    //   204: invokestatic 457	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   207: aastore
    //   208: dup
    //   209: iconst_3
    //   210: aload_1
    //   211: aastore
    //   212: dup
    //   213: iconst_4
    //   214: aconst_null
    //   215: aastore
    //   216: invokevirtual 1262	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   219: putstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   222: ldc 2
    //   224: monitorexit
    //   225: ldc_w 1250
    //   228: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: return
    //   232: getstatic 103	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   235: iconst_2
    //   236: anewarray 199	java/lang/Class
    //   239: dup
    //   240: iconst_0
    //   241: ldc 201
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: ldc 201
    //   248: aastore
    //   249: invokevirtual 1256	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   252: iconst_2
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_0
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: aload 4
    //   264: aastore
    //   265: invokevirtual 1262	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   268: putstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   271: goto -49 -> 222
    //   274: astore_0
    //   275: ldc 236
    //   277: new 238	java/lang/StringBuilder
    //   280: dup
    //   281: ldc_w 1264
    //   284: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: aload_0
    //   288: invokestatic 336	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   291: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 255	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: goto -78 -> 222
    //   303: astore_0
    //   304: ldc 2
    //   306: monitorexit
    //   307: ldc_w 1250
    //   310: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: aload_0
    //   314: athrow
    //   315: iload_2
    //   316: ifne +60 -> 376
    //   319: getstatic 103	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   322: iconst_2
    //   323: anewarray 199	java/lang/Class
    //   326: dup
    //   327: iconst_0
    //   328: ldc 201
    //   330: aastore
    //   331: dup
    //   332: iconst_1
    //   333: ldc 201
    //   335: aastore
    //   336: invokevirtual 1256	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   339: astore_3
    //   340: aload_0
    //   341: astore_1
    //   342: aload_0
    //   343: invokevirtual 743	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   346: ifnull +8 -> 354
    //   349: aload_0
    //   350: invokevirtual 743	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   353: astore_1
    //   354: aload_3
    //   355: iconst_2
    //   356: anewarray 4	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: aload_1
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: aload_1
    //   366: aastore
    //   367: invokevirtual 1262	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   370: putstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   373: goto -151 -> 222
    //   376: aconst_null
    //   377: astore 5
    //   379: aload 5
    //   381: astore 4
    //   383: ldc_w 942
    //   386: aload_0
    //   387: invokestatic 945	com/tencent/smtt/sdk/QbSdk:getCurrentProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   390: invokevirtual 946	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   393: ifeq +18 -> 411
    //   396: aload 5
    //   398: astore 4
    //   400: getstatic 949	com/tencent/smtt/sdk/WebView:mWebViewCreated	Z
    //   403: ifne +8 -> 411
    //   406: ldc_w 1266
    //   409: astore 4
    //   411: aload_0
    //   412: astore 5
    //   414: aload_0
    //   415: invokevirtual 743	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   418: ifnull +9 -> 427
    //   421: aload_0
    //   422: invokevirtual 743	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   425: astore 5
    //   427: aload_3
    //   428: iconst_5
    //   429: anewarray 4	java/lang/Object
    //   432: dup
    //   433: iconst_0
    //   434: aload 5
    //   436: aastore
    //   437: dup
    //   438: iconst_1
    //   439: aload 5
    //   441: aastore
    //   442: dup
    //   443: iconst_2
    //   444: aconst_null
    //   445: aastore
    //   446: dup
    //   447: iconst_3
    //   448: aload_1
    //   449: aastore
    //   450: dup
    //   451: iconst_4
    //   452: aload 4
    //   454: aastore
    //   455: invokevirtual 1262	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   458: putstatic 105	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   461: goto -239 -> 222
    //   464: goto -276 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	paramContext	Context
    //   0	467	1	paramString	String
    //   1	315	2	i1	int
    //   55	373	3	localObject1	Object
    //   91	19	4	localObject2	Object
    //   146	117	4	localThrowable	Throwable
    //   381	72	4	localObject3	Object
    //   377	63	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   56	93	146	java/lang/Throwable
    //   96	109	274	java/lang/Throwable
    //   114	136	274	java/lang/Throwable
    //   162	188	274	java/lang/Throwable
    //   188	222	274	java/lang/Throwable
    //   232	271	274	java/lang/Throwable
    //   319	340	274	java/lang/Throwable
    //   342	354	274	java/lang/Throwable
    //   354	373	274	java/lang/Throwable
    //   383	396	274	java/lang/Throwable
    //   400	406	274	java/lang/Throwable
    //   414	427	274	java/lang/Throwable
    //   427	461	274	java/lang/Throwable
    //   24	33	303	finally
    //   40	54	303	finally
    //   56	93	303	finally
    //   96	109	303	finally
    //   114	136	303	finally
    //   136	139	303	finally
    //   162	188	303	finally
    //   188	222	303	finally
    //   222	225	303	finally
    //   232	271	303	finally
    //   275	300	303	finally
    //   304	307	303	finally
    //   319	340	303	finally
    //   342	354	303	finally
    //   354	373	303	finally
    //   383	396	303	finally
    //   400	406	303	finally
    //   414	427	303	finally
    //   427	461	303	finally
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(64023);
      preInit(paramContext, null);
      AppMethodBeat.o(64023);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback)
  {
    try
    {
      AppMethodBeat.i(64027);
      TbsLog.initIfNeed(paramContext);
      TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(paramContext));
      TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
      l = a;
      if (!s)
      {
        paramContext = new k(paramContext, new j(Looper.getMainLooper(), paramPreInitCallback, paramContext));
        paramContext.setName("tbs_preinit");
        paramContext.setPriority(10);
        paramContext.start();
        s = true;
      }
      AppMethodBeat.o(64027);
      return;
    }
    finally {}
  }
  
  public static String replaceLibraryName(String paramString)
  {
    AppMethodBeat.i(139045);
    paramString = q.a(paramString);
    AppMethodBeat.o(139045);
    return paramString;
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(64040);
    reset(paramContext, false);
    AppMethodBeat.o(64040);
  }
  
  public static void reset(Context paramContext, boolean paramBoolean)
  {
    int i1 = 1;
    AppMethodBeat.i(64041);
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        TbsDownloader.stopDownload();
        if ((paramBoolean) && (!TbsShareManager.isThirdPartyApp(paramContext)))
        {
          int i2 = ao.a().h(paramContext);
          int i3 = ao.a().i(paramContext);
          if ((i2 > 43300) && (i2 != i3))
          {
            TbsDownloader.c(paramContext);
            com.tencent.smtt.utils.k.a(paramContext.getDir("tbs", 0), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            ao.a.set(Integer.valueOf(0));
            File localFile = new File(paramContext.getFilesDir(), "bugly_switch.txt");
            if (localFile.exists()) {
              localFile.delete();
            }
            if (i1 != 0)
            {
              com.tencent.smtt.utils.k.b(ao.a().p(paramContext), ao.a().f(paramContext, 0));
              ao.a().b(paramContext);
            }
            AppMethodBeat.o(64041);
            return;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
        AppMethodBeat.o(64041);
        return;
      }
      i1 = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    AppMethodBeat.i(64042);
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    try
    {
      com.tencent.smtt.utils.k.b(ao.a().p(paramContext));
      AppMethodBeat.o(64042);
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(64042);
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    AppMethodBeat.i(64016);
    if (paramString == null)
    {
      AppMethodBeat.o(64016);
      return;
    }
    if (paramString.startsWith("QQ:"))
    {
      paramString = paramString.substring(3);
      z = "0000000000000000".substring(paramString.length()) + paramString;
    }
    AppMethodBeat.o(64016);
  }
  
  public static void setDeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b.a = paramString1;
    b.b = paramString2;
    b.c = paramString3;
    b.d = paramString4;
  }
  
  public static void setDisableUnpreinitBySwitch(boolean paramBoolean)
  {
    AppMethodBeat.i(64025);
    B = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + B);
    AppMethodBeat.o(64025);
  }
  
  public static void setDisableUseHostBackupCoreBySwitch(boolean paramBoolean)
  {
    AppMethodBeat.i(64024);
    mDisableUseHostBackupCore = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
    AppMethodBeat.o(64024);
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public static void setNeedInitX5FirstTime(boolean paramBoolean)
  {
    w = paramBoolean;
  }
  
  public static void setOnlyDownload(boolean paramBoolean)
  {
    k = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    A = paramString;
  }
  
  public static void setSandboxListener(SandboxListener paramSandboxListener)
  {
    AppMethodBeat.i(139044);
    q.a(paramSandboxListener);
    AppMethodBeat.o(139044);
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    G = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    D = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    AppMethodBeat.i(64010);
    TbsLog.setTbsLogClient(paramTbsLogClient);
    AppMethodBeat.o(64010);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(64028);
    if ((paramInt >= 130) && (paramInt <= 139))
    {
      paramContext = TbsDownloadUpload.getInstance(paramContext);
      paramContext.a.put("tbs_needdownload_code", Integer.valueOf(paramInt));
      paramContext.commit();
      AppMethodBeat.o(64028);
      return;
    }
    if ((paramInt >= 150) && (paramInt <= 159))
    {
      paramContext = TbsDownloadUpload.getInstance(paramContext);
      paramContext.a.put("tbs_startdownload_code", Integer.valueOf(paramInt));
      paramContext.commit();
    }
    AppMethodBeat.o(64028);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(64044);
    TbsCoreLoadStat.getInstance().a(paramContext, 501);
    if (paramContext == null)
    {
      AppMethodBeat.o(64044);
      return -100;
    }
    bz localbz = bz.a();
    localbz.a(paramContext, null);
    if (localbz.b())
    {
      if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487))
      {
        AppMethodBeat.o(64044);
        return -101;
      }
      int i1 = localbz.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback);
      if (i1 == 0) {
        TbsCoreLoadStat.getInstance().a(paramContext, 503);
      }
      for (;;)
      {
        AppMethodBeat.o(64044);
        return i1;
        TbsLogReport.getInstance(paramContext).setLoadErrorCode(504, String.valueOf(i1));
      }
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 502);
    AppMethodBeat.o(64044);
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(63996);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    boolean bool = d.a(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
    AppMethodBeat.o(63996);
    return bool;
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(63995);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    boolean bool = d.a(paramContext, paramString, localHashMap);
    AppMethodBeat.o(63995);
    return bool;
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    AppMethodBeat.i(63994);
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
        localObject = bz.a();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((bz)localObject).b())
          {
            localObject = ((bz)localObject).c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
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
    if (d.a(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0)
    {
      AppMethodBeat.o(63994);
      return true;
    }
    AppMethodBeat.o(63994);
    return false;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(64045);
    if (paramContext == null)
    {
      AppMethodBeat.o(64045);
      return false;
    }
    bz localbz = bz.a();
    localbz.a(paramContext, null);
    if ((paramHashMap != null) && ("5".equals(paramHashMap.get("PosID"))) && (localbz.b())) {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
    }
    if (d.a(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
    {
      if (localbz.b())
      {
        if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487))
        {
          AppMethodBeat.o(64045);
          return false;
        }
        if (localbz.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback) == 0)
        {
          AppMethodBeat.o(64045);
          return true;
        }
      }
    }
    else
    {
      AppMethodBeat.o(64045);
      return true;
    }
    AppMethodBeat.o(64045);
    return false;
  }
  
  public static void unForceSysWebView()
  {
    AppMethodBeat.i(64020);
    b = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    AppMethodBeat.o(64020);
  }
  
  public static boolean unPreInit(Context paramContext)
  {
    return true;
  }
  
  public static boolean useSoftWare()
  {
    AppMethodBeat.i(64038);
    if (r == null)
    {
      AppMethodBeat.o(64038);
      return false;
    }
    Object localObject2 = r.a(r, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = r;
      localObject2 = Integer.TYPE;
      int i1 = a.a();
      localObject1 = r.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i1) });
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(64038);
      return false;
    }
    boolean bool = ((Boolean)localObject1).booleanValue();
    AppMethodBeat.o(64038);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */