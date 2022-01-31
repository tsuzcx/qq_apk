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
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.q;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static boolean A = false;
  private static boolean B = false;
  private static TbsListener C;
  private static TbsListener D;
  private static boolean E = false;
  public static final int EXTENSION_INIT_FAILURE = -99999;
  private static boolean F = false;
  public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
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
  static Map<String, Object> n = null;
  private static int o;
  private static String p;
  private static Class<?> q;
  private static Object r;
  private static boolean s;
  public static boolean sIsVersionPrinted = false;
  private static String[] t;
  private static String u;
  private static String v;
  private static int w;
  private static int x;
  private static String y;
  private static String z;
  
  static
  {
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
    i = true;
    j = true;
    k = false;
    w = 0;
    x = 170;
    y = null;
    z = null;
    l = a;
    mDisableUseHostBackupCore = false;
    A = false;
    B = true;
    C = null;
    D = null;
    E = false;
    F = false;
    m = new n();
  }
  
  static Bundle a(Context paramContext, Bundle paramBundle)
  {
    if (!a(paramContext))
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "initForPatch return false!");
      return null;
    }
    paramBundle = q.a(r, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null) {
      return (Bundle)paramBundle;
    }
    TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "incrUpdate return null!");
    return null;
  }
  
  static Object a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!a(paramContext)) {
      paramContext = Integer.valueOf(-99999);
    }
    do
    {
      return paramContext;
      paramString = q.a(r, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
      paramContext = paramString;
    } while (paramString != null);
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
    //   3: getstatic 100	com/tencent/smtt/sdk/QbSdk:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 100	com/tencent/smtt/sdk/QbSdk:a	Z
    //   19: new 213	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 215
    //   25: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: putstatic 114	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   38: ldc 227
    //   40: new 213	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 229
    //   46: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: getstatic 114	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   52: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 234	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: invokestatic 239	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   64: aload_0
    //   65: sipush 401
    //   68: new 241	java/lang/Throwable
    //   71: dup
    //   72: getstatic 114	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   75: invokespecial 242	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 245	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   81: goto -70 -> 11
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramContext	Context
    //   0	90	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	84	finally
    //   15	81	84	finally
  }
  
  static boolean a(Context paramContext)
  {
    try
    {
      if (q != null) {
        return true;
      }
      Object localObject = an.a().r(paramContext);
      if (localObject == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        return false;
      }
      File localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
      if (!localFile.exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        return false;
      }
      TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + localFile.getAbsolutePath());
      bv.a().a(paramContext);
      String str1 = localFile.getParent();
      String str2 = localFile.getAbsolutePath();
      localObject = ((File)localObject).getAbsolutePath();
      q = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, localFile.getParent());
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 20000);
  }
  
  static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((n != null) && (n.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD)) && (n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return true;
    }
    if (!c(paramContext)) {
      return true;
    }
    paramContext = q.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43617), Integer.valueOf(paramInt2) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    paramContext = q.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43617) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43617; SDK_VERSION_NAME: 3.6.0.1350");
      sIsVersionPrinted = true;
    }
    if ((a) && (!paramBoolean))
    {
      TbsLog.e("QbSdk", "QbSdk init: " + v, false);
      TbsCoreLoadStat.getInstance().a(paramContext, 414, new Throwable(v));
      return false;
    }
    if (b)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable(u));
      return false;
    }
    if (!B) {
      d(paramContext);
    }
    for (;;)
    {
      try
      {
        localObject2 = an.a().r(paramContext);
        if (localObject2 == null)
        {
          TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
          TbsCoreLoadStat.getInstance().a(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
          return false;
        }
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          if ((o != 0) && (o != TbsShareManager.d(paramContext)))
          {
            q = null;
            r = null;
            TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
            TbsCoreLoadStat.getInstance().a(paramContext, 302, new Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + TbsShareManager.d(paramContext)));
            return false;
          }
          o = TbsShareManager.d(paramContext);
          if (q != null) {
            return true;
          }
        }
        else
        {
          if (o == 0) {
            break label967;
          }
          int i2 = an.a().a(true, paramContext);
          i1 = i2;
          if (o != i2)
          {
            q = null;
            r = null;
            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i2, true);
            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
            TbsCoreLoadStat.getInstance().a(paramContext, 303, new Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + i2));
            return false;
          }
          o = i1;
          continue;
        }
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label591;
        }
      }
      catch (Throwable localThrowable)
      {
        TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable));
        TbsCoreLoadStat.getInstance().a(paramContext, 306, localThrowable);
        return false;
      }
      Object localObject1;
      if (TbsShareManager.j(paramContext))
      {
        localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        paramBoolean = ((File)localObject1).exists();
        if (paramBoolean) {}
      }
      else
      {
        for (;;)
        {
          try
          {
            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
            i1 = an.a().j(paramContext);
            if (!new File(((File)localObject1).getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
              continue;
            }
            if (i1 <= 0) {
              continue;
            }
            TbsCoreLoadStat.getInstance().a(paramContext, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i1));
          }
          catch (Throwable paramContext)
          {
            label591:
            continue;
          }
          return false;
          TbsCoreLoadStat.getInstance().a(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
          return false;
          localObject1 = new File(an.a().r(paramContext), "tbs_sdk_extension_dex.jar");
          break;
          TbsCoreLoadStat.getInstance().a(paramContext, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i1));
          continue;
          if (i1 > 0) {
            TbsCoreLoadStat.getInstance().a(paramContext, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i1));
          } else {
            TbsCoreLoadStat.getInstance().a(paramContext, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i1));
          }
        }
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (Object localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + (String)localObject2);
        TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + ((File)localObject1).getAbsolutePath());
        bv.a().a(paramContext);
        q = new DexLoader(((File)localObject1).getParent(), paramContext, new String[] { ((File)localObject1).getAbsolutePath() }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
        localObject1 = r;
        localObject2 = b.a;
        String str1 = b.b;
        String str2 = b.c;
        String str3 = b.d;
        q.a(localObject1, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject2, str1, str2, str3 });
        q.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
      label967:
      int i1 = 0;
    }
  }
  
  static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    paramBoolean2 = false;
    int i1 = TbsPVConfig.getInstance(paramContext).getDisabledCoreVersion();
    if ((i1 != 0) && (i1 == an.a().j(paramContext))) {
      TbsLog.e("QbSdk", "force use sys by remote switch");
    }
    for (;;)
    {
      return paramBoolean2;
      if ((TbsShareManager.isThirdPartyApp(paramContext)) && (!TbsShareManager.i(paramContext)))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 302);
        return false;
      }
      if (!a(paramContext, paramBoolean1))
      {
        TbsLog.e("QbSdk", "QbSdk.init failure!");
        return false;
      }
      Object localObject2 = q.a(r, "canLoadX5Core", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43617) });
      if (localObject2 != null)
      {
        if (((localObject2 instanceof String)) && (((String)localObject2).equalsIgnoreCase("AuthenticationFail"))) {
          continue;
        }
        if (!(localObject2 instanceof Bundle))
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 330, new Throwable(String.valueOf(localObject2)));
          TbsLog.e("loaderror", "ret not instance of bundle");
          return false;
        }
        Bundle localBundle = (Bundle)localObject2;
        if (localBundle.isEmpty())
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 331, new Throwable(String.valueOf(localObject2)));
          TbsLog.e("loaderror", "empty bundle");
          return false;
        }
        try
        {
          i1 = localBundle.getInt("result_code", -1);
          if (i1 == 0)
          {
            paramBoolean1 = true;
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              break label425;
            }
            o.a(TbsShareManager.d(paramContext));
            localObject2 = String.valueOf(TbsShareManager.d(paramContext));
            p = (String)localObject2;
            if (((String)localObject2).length() == 5) {
              p = "0" + p;
            }
            if (p.length() != 6) {
              p = "";
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            try
            {
              t = localBundle.getStringArray("tbs_jarfiles");
              if ((t instanceof String[])) {
                break label671;
              }
              TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("sJarFiles not instanceof String[]: " + t));
              return false;
            }
            catch (Throwable localThrowable)
            {
              label425:
              TbsCoreLoadStat.getInstance().a(paramContext, 329, localThrowable);
              return false;
            }
            localException2 = localException2;
            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + localException2.toString());
            i1 = -1;
            continue;
            paramBoolean1 = false;
            continue;
            try
            {
              if (Build.VERSION.SDK_INT >= 12) {
                p = localBundle.getString("tbs_core_version", "0");
              }
            }
            catch (Exception localException3)
            {
              try
              {
                o = Integer.parseInt(p);
                o.a(o);
                if (o == 0)
                {
                  TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("sTbsVersion is 0"));
                  return false;
                  String str = localBundle.getString("tbs_core_version");
                  p = str;
                  if (str != null) {
                    continue;
                  }
                  p = "0";
                  continue;
                  localException3 = localException3;
                  p = "0";
                }
              }
              catch (NumberFormatException localNumberFormatException)
              {
                o = 0;
                continue;
                int i2;
                if (o > 0)
                {
                  i2 = i3;
                  if (o <= 25442) {}
                }
                else
                {
                  if (o != 25472) {
                    continue;
                  }
                  i2 = i3;
                }
                if (i2 != 0)
                {
                  TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + o);
                  com.tencent.smtt.utils.j.b(an.a().r(paramContext));
                  TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("is_obsolete --> delete old core:" + o));
                  return false;
                  i2 = 0;
                }
              }
            }
          }
        }
      }
      try
      {
        label671:
        d = localThrowable.getString("tbs_librarypath");
        Class localClass2 = null;
        Object localObject1 = localClass2;
        if (i1 != 0) {}
        try
        {
          localObject1 = q.a(r, "getErrorCodeForLogReport", new Class[0], new Object[0]);
          switch (i1)
          {
          default: 
            TbsCoreLoadStat.getInstance().a(paramContext, 415, new Throwable("detail: " + localObject1 + "errcode" + i1));
          }
          for (;;)
          {
            paramBoolean2 = paramBoolean1;
            if (paramBoolean1) {
              break;
            }
            TbsLog.e("loaderror", "319");
            return paramBoolean1;
            if ((localObject1 instanceof Integer))
            {
              TbsCoreLoadStat.getInstance().a(paramContext, ((Integer)localObject1).intValue(), new Throwable("detail: " + localObject1));
            }
            else
            {
              TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("detail: " + localObject1));
              continue;
              if ((localObject1 instanceof Integer))
              {
                TbsCoreLoadStat.getInstance().a(paramContext, ((Integer)localObject1).intValue(), new Throwable("detail: " + localObject1));
              }
              else
              {
                TbsCoreLoadStat.getInstance().a(paramContext, 404, new Throwable("detail: " + localObject1));
                continue;
                continue;
                localObject1 = r;
                localClass2 = Integer.TYPE;
                i1 = a.a();
                localObject1 = q.a(localObject1, "canLoadX5", new Class[] { localClass2 }, new Object[] { Integer.valueOf(i1) });
                if (localObject1 != null)
                {
                  if (((localObject1 instanceof String)) && (((String)localObject1).equalsIgnoreCase("AuthenticationFail"))) {
                    break;
                  }
                  paramBoolean1 = bool2;
                  if (!(localObject1 instanceof Boolean)) {
                    continue;
                  }
                  o = o.d();
                  bool2 = a(paramContext, o.d());
                  paramBoolean1 = bool1;
                  if (((Boolean)localObject1).booleanValue())
                  {
                    paramBoolean1 = bool1;
                    if (!bool2) {
                      paramBoolean1 = true;
                    }
                  }
                  paramBoolean2 = paramBoolean1;
                  if (paramBoolean1) {
                    break;
                  }
                  TbsLog.e("loaderror", "318");
                  TbsLog.w("loaderror", "isX5Disable:" + bool2);
                  TbsLog.w("loaderror", "(Boolean) ret:" + (Boolean)localObject1);
                  return paramBoolean1;
                }
                TbsCoreLoadStat.getInstance().a(paramContext, 308);
                paramBoolean1 = bool2;
              }
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Class localClass1 = localClass2;
          }
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  protected static String b()
  {
    Object localObject = bv.a();
    if ((localObject != null) && (((bv)localObject).b()))
    {
      localObject = ((bv)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String))) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  static boolean b(Context paramContext)
  {
    if (paramContext == null) {
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
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("QbSdk", "clearPluginConfigFile error is " + paramContext.getMessage());
    }
    return false;
  }
  
  private static boolean c(Context paramContext)
  {
    try
    {
      if (q != null) {
        return true;
      }
      Object localObject2 = an.a().r(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.j(paramContext)) {}
      }
      for (Object localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar"); !((File)localObject1).exists(); localObject1 = new File(an.a().r(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        return false;
        TbsCoreLoadStat.getInstance().a(paramContext, 304);
        return false;
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + (String)localObject2);
        TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + ((File)localObject1).getAbsolutePath());
        bv.a().a(paramContext);
        q = new DexLoader(((File)localObject1).getParent(), paramContext, new String[] { ((File)localObject1).getAbsolutePath() }, (String)localObject2, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
        paramContext = r;
        localObject1 = b.a;
        localObject2 = b.b;
        String str1 = b.c;
        String str2 = b.d;
        q.a(paramContext, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject1, localObject2, str1, str2 });
        q.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
    }
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = q.a(r, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().a(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      return false;
      TbsCoreLoadStat.getInstance().a(paramContext, 314);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    return a(paramContext, false, false);
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    try
    {
      if ((paramContext.getApplicationInfo().packageName.contains("com.moji.mjweather")) && (Build.VERSION.SDK_INT == 19)) {
        return true;
      }
      if (q == null)
      {
        Object localObject = an.a().r(paramContext);
        if (localObject == null)
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
          return false;
        }
        File localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        if (!localFile.exists())
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
          return false;
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {}
        for (localObject = TbsShareManager.getHostCorePathAppDefined();; localObject = ((File)localObject).getAbsolutePath())
        {
          TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + (String)localObject);
          TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + localFile.getAbsolutePath());
          bv.a().a(paramContext);
          q = new DexLoader(localFile.getParent(), paramContext, new String[] { localFile.getAbsolutePath() }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
          if (r != null) {
            break label239;
          }
          if ((TbsShareManager.e(paramContext) != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) {
            break;
          }
          TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
          return false;
        }
        loadTBSSDKExtension(paramContext, localFile.getParent());
      }
      label239:
      paramContext = q.a(r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Boolean)))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  public static void canOpenFile(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    new h(paramContext, paramString, paramValueCallback).start();
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!a(paramContext, false)) {}
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
    //   6: getstatic 133	com/tencent/smtt/sdk/QbSdk:w	I
    //   9: ifne +9 -> 18
    //   12: invokestatic 564	com/tencent/smtt/sdk/a:a	()I
    //   15: putstatic 133	com/tencent/smtt/sdk/QbSdk:w	I
    //   18: ldc 227
    //   20: new 213	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 733
    //   27: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: getstatic 133	com/tencent/smtt/sdk/QbSdk:w	I
    //   33: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: getstatic 522	android/os/Build$VERSION:SDK_INT	I
    //   45: bipush 7
    //   47: if_icmplt +12 -> 59
    //   50: getstatic 133	com/tencent/smtt/sdk/QbSdk:w	I
    //   53: getstatic 135	com/tencent/smtt/sdk/QbSdk:x	I
    //   56: if_icmpge +5 -> 61
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_0
    //   62: ifnull -3 -> 59
    //   65: new 735	java/io/BufferedInputStream
    //   68: dup
    //   69: new 737	java/io/FileInputStream
    //   72: dup
    //   73: new 257	java/io/File
    //   76: dup
    //   77: invokestatic 250	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   80: aload_0
    //   81: invokevirtual 253	com/tencent/smtt/sdk/an:r	(Landroid/content/Context;)Ljava/io/File;
    //   84: ldc_w 739
    //   87: invokespecial 262	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: invokespecial 741	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: invokespecial 744	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   96: astore 6
    //   98: aload 6
    //   100: astore 5
    //   102: new 746	java/util/Properties
    //   105: dup
    //   106: invokespecial 747	java/util/Properties:<init>	()V
    //   109: astore 8
    //   111: aload 6
    //   113: astore 5
    //   115: aload 8
    //   117: aload 6
    //   119: invokevirtual 750	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   122: aload 6
    //   124: astore 5
    //   126: aload 8
    //   128: ldc_w 752
    //   131: invokevirtual 755	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 9
    //   136: aload 6
    //   138: astore 5
    //   140: aload 8
    //   142: ldc_w 757
    //   145: invokevirtual 755	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 10
    //   150: aload 6
    //   152: astore 5
    //   154: aload 9
    //   156: invokestatic 532	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   159: istore_1
    //   160: aload 6
    //   162: astore 5
    //   164: aload 10
    //   166: invokestatic 532	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   169: istore_2
    //   170: aload 6
    //   172: astore 5
    //   174: getstatic 760	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   177: invokestatic 532	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   180: istore_3
    //   181: iload_3
    //   182: iload_1
    //   183: if_icmpgt +8 -> 191
    //   186: iload_3
    //   187: iload_2
    //   188: if_icmpge +39 -> 227
    //   191: aload 6
    //   193: astore 5
    //   195: ldc 227
    //   197: new 213	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 762
    //   204: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: iload_3
    //   208: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 6
    //   219: invokevirtual 765	java/io/BufferedInputStream:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: iconst_0
    //   226: ireturn
    //   227: aload 6
    //   229: astore 5
    //   231: aload 8
    //   233: ldc_w 524
    //   236: invokevirtual 755	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokestatic 532	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   242: istore_1
    //   243: aload 6
    //   245: invokevirtual 765	java/io/BufferedInputStream:close	()V
    //   248: new 737	java/io/FileInputStream
    //   251: dup
    //   252: new 257	java/io/File
    //   255: dup
    //   256: aload_0
    //   257: invokestatic 767	com/tencent/smtt/sdk/an:t	(Landroid/content/Context;)Ljava/io/File;
    //   260: ldc_w 769
    //   263: invokespecial 262	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   266: invokespecial 741	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   269: astore 5
    //   271: new 746	java/util/Properties
    //   274: dup
    //   275: invokespecial 747	java/util/Properties:<init>	()V
    //   278: astore 6
    //   280: aload 6
    //   282: aload 5
    //   284: invokevirtual 750	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   287: aload 6
    //   289: ldc_w 771
    //   292: invokevirtual 755	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   295: invokestatic 532	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   298: istore_2
    //   299: aload 6
    //   301: ldc_w 773
    //   304: invokevirtual 755	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokestatic 532	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   310: istore_3
    //   311: iload_1
    //   312: ldc_w 774
    //   315: if_icmpeq +10 -> 325
    //   318: iload_2
    //   319: ldc_w 774
    //   322: if_icmpne +56 -> 378
    //   325: iconst_0
    //   326: istore_1
    //   327: aload 5
    //   329: invokevirtual 777	java/io/InputStream:close	()V
    //   332: iload_1
    //   333: ifne -274 -> 59
    //   336: iconst_1
    //   337: ireturn
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_0
    //   341: aload_0
    //   342: astore 5
    //   344: ldc 227
    //   346: ldc_w 779
    //   349: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_0
    //   353: ifnull -294 -> 59
    //   356: aload_0
    //   357: invokevirtual 765	java/io/BufferedInputStream:close	()V
    //   360: iconst_0
    //   361: ireturn
    //   362: astore_0
    //   363: iconst_0
    //   364: ireturn
    //   365: astore_0
    //   366: aload 5
    //   368: ifnull +8 -> 376
    //   371: aload 5
    //   373: invokevirtual 765	java/io/BufferedInputStream:close	()V
    //   376: aload_0
    //   377: athrow
    //   378: iload_1
    //   379: iload_2
    //   380: if_icmple +8 -> 388
    //   383: iconst_0
    //   384: istore_1
    //   385: goto -58 -> 327
    //   388: iload_1
    //   389: iload_2
    //   390: if_icmpne +169 -> 559
    //   393: iload_3
    //   394: ifle +16 -> 410
    //   397: iload_3
    //   398: aload_0
    //   399: invokestatic 781	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   402: if_icmpeq +8 -> 410
    //   405: iconst_0
    //   406: istore_1
    //   407: goto -80 -> 327
    //   410: aload 6
    //   412: ldc_w 783
    //   415: invokevirtual 755	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   418: invokestatic 786	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   421: ifeq +34 -> 455
    //   424: aload_0
    //   425: invokevirtual 708	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   428: invokestatic 622	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   431: getfield 626	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   434: ldc_w 788
    //   437: iconst_0
    //   438: invokeinterface 792 3 0
    //   443: istore 4
    //   445: iload 4
    //   447: ifne +8 -> 455
    //   450: iconst_1
    //   451: istore_1
    //   452: goto -125 -> 327
    //   455: iconst_0
    //   456: istore_1
    //   457: goto -130 -> 327
    //   460: astore_0
    //   461: aload 7
    //   463: astore_0
    //   464: ldc 227
    //   466: ldc_w 794
    //   469: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload_0
    //   473: ifnull +7 -> 480
    //   476: aload_0
    //   477: invokevirtual 777	java/io/InputStream:close	()V
    //   480: iconst_1
    //   481: istore_1
    //   482: goto -150 -> 332
    //   485: astore_0
    //   486: iconst_1
    //   487: istore_1
    //   488: goto -156 -> 332
    //   491: astore_0
    //   492: aconst_null
    //   493: astore 5
    //   495: aload 5
    //   497: ifnull +8 -> 505
    //   500: aload 5
    //   502: invokevirtual 777	java/io/InputStream:close	()V
    //   505: aload_0
    //   506: athrow
    //   507: astore 5
    //   509: goto -261 -> 248
    //   512: astore 5
    //   514: goto -138 -> 376
    //   517: astore_0
    //   518: goto -186 -> 332
    //   521: astore 5
    //   523: goto -18 -> 505
    //   526: astore_0
    //   527: goto -32 -> 495
    //   530: astore 6
    //   532: aload_0
    //   533: astore 5
    //   535: aload 6
    //   537: astore_0
    //   538: goto -43 -> 495
    //   541: astore_0
    //   542: aload 5
    //   544: astore_0
    //   545: goto -81 -> 464
    //   548: astore_0
    //   549: goto -183 -> 366
    //   552: astore_0
    //   553: aload 6
    //   555: astore_0
    //   556: goto -215 -> 341
    //   559: iconst_0
    //   560: istore_1
    //   561: goto -234 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	paramContext	Context
    //   159	402	1	i1	int
    //   169	222	2	i2	int
    //   180	223	3	i3	int
    //   443	3	4	bool	boolean
    //   4	497	5	localObject1	Object
    //   507	1	5	localException1	Exception
    //   512	1	5	localException2	Exception
    //   521	1	5	localException3	Exception
    //   533	10	5	localContext	Context
    //   96	315	6	localObject2	Object
    //   530	24	6	localObject3	Object
    //   1	461	7	localObject4	Object
    //   109	123	8	localProperties	java.util.Properties
    //   134	21	9	str1	String
    //   148	17	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   217	222	224	java/lang/Exception
    //   65	98	338	java/lang/Throwable
    //   356	360	362	java/lang/Exception
    //   65	98	365	finally
    //   248	271	460	java/lang/Throwable
    //   476	480	485	java/lang/Exception
    //   248	271	491	finally
    //   243	248	507	java/lang/Exception
    //   371	376	512	java/lang/Exception
    //   327	332	517	java/lang/Exception
    //   500	505	521	java/lang/Exception
    //   271	311	526	finally
    //   397	405	526	finally
    //   410	445	526	finally
    //   464	472	530	finally
    //   271	311	541	java/lang/Throwable
    //   397	405	541	java/lang/Throwable
    //   410	445	541	java/lang/Throwable
    //   102	111	548	finally
    //   115	122	548	finally
    //   126	136	548	finally
    //   140	150	548	finally
    //   154	160	548	finally
    //   164	170	548	finally
    //   174	181	548	finally
    //   195	217	548	finally
    //   231	243	548	finally
    //   344	352	548	finally
    //   102	111	552	java/lang/Throwable
    //   115	122	552	java/lang/Throwable
    //   126	136	552	java/lang/Throwable
    //   140	150	552	java/lang/Throwable
    //   154	160	552	java/lang/Throwable
    //   164	170	552	java/lang/Throwable
    //   174	181	552	java/lang/Throwable
    //   195	217	552	java/lang/Throwable
    //   231	243	552	java/lang/Throwable
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = q.a(r, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean))) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static void clear(Context paramContext) {}
  
  /* Error */
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 227
    //   4: new 213	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 800
    //   11: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: ldc_w 802
    //   21: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_1
    //   25: invokevirtual 577	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc_w 804
    //   31: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: new 806	com/tencent/smtt/sdk/WebView
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 808	com/tencent/smtt/sdk/WebView:<init>	(Landroid/content/Context;)V
    //   48: invokevirtual 812	com/tencent/smtt/sdk/WebView:getWebViewClientExtension	()Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewClientExtension;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +214 -> 269
    //   58: invokestatic 283	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   61: astore 4
    //   63: iload_3
    //   64: istore_2
    //   65: aload 4
    //   67: ifnull +25 -> 92
    //   70: iload_3
    //   71: istore_2
    //   72: aload 4
    //   74: invokevirtual 584	com/tencent/smtt/sdk/bv:b	()Z
    //   77: ifeq +15 -> 92
    //   80: aload 4
    //   82: invokevirtual 587	com/tencent/smtt/sdk/bv:c	()Lcom/tencent/smtt/sdk/bw;
    //   85: aload_0
    //   86: iload_1
    //   87: invokevirtual 814	com/tencent/smtt/sdk/bw:a	(Landroid/content/Context;Z)V
    //   90: iload_3
    //   91: istore_2
    //   92: iload_2
    //   93: ifeq +45 -> 138
    //   96: ldc 227
    //   98: ldc_w 816
    //   101: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: return
    //   105: astore 4
    //   107: iconst_0
    //   108: istore_2
    //   109: ldc 227
    //   111: new 213	java/lang/StringBuilder
    //   114: dup
    //   115: ldc_w 818
    //   118: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: aload 4
    //   123: invokestatic 311	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   126: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 234	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -43 -> 92
    //   138: new 820	android/webkit/WebView
    //   141: dup
    //   142: aload_0
    //   143: invokespecial 821	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   146: astore 4
    //   148: getstatic 522	android/os/Build$VERSION:SDK_INT	I
    //   151: bipush 11
    //   153: if_icmplt +27 -> 180
    //   156: aload 4
    //   158: ldc_w 823
    //   161: invokevirtual 826	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   164: aload 4
    //   166: ldc_w 828
    //   169: invokevirtual 826	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   172: aload 4
    //   174: ldc_w 830
    //   177: invokevirtual 826	android/webkit/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   180: aload 4
    //   182: iconst_1
    //   183: invokevirtual 834	android/webkit/WebView:clearCache	(Z)V
    //   186: iload_1
    //   187: ifeq +14 -> 201
    //   190: aload_0
    //   191: invokestatic 840	android/webkit/CookieSyncManager:createInstance	(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;
    //   194: pop
    //   195: invokestatic 845	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   198: invokevirtual 848	android/webkit/CookieManager:removeAllCookie	()V
    //   201: aload_0
    //   202: invokestatic 853	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   205: invokevirtual 856	android/webkit/WebViewDatabase:clearUsernamePassword	()V
    //   208: aload_0
    //   209: invokestatic 853	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   212: invokevirtual 859	android/webkit/WebViewDatabase:clearHttpAuthUsernamePassword	()V
    //   215: aload_0
    //   216: invokestatic 853	android/webkit/WebViewDatabase:getInstance	(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;
    //   219: invokevirtual 862	android/webkit/WebViewDatabase:clearFormData	()V
    //   222: invokestatic 867	android/webkit/WebStorage:getInstance	()Landroid/webkit/WebStorage;
    //   225: invokevirtual 870	android/webkit/WebStorage:deleteAllData	()V
    //   228: invokestatic 875	android/webkit/WebIconDatabase:getInstance	()Landroid/webkit/WebIconDatabase;
    //   231: invokevirtual 878	android/webkit/WebIconDatabase:removeAllIcons	()V
    //   234: return
    //   235: astore_0
    //   236: ldc 227
    //   238: new 213	java/lang/StringBuilder
    //   241: dup
    //   242: ldc_w 880
    //   245: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   248: aload_0
    //   249: invokestatic 311	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   252: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 234	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: return
    //   262: astore 4
    //   264: iconst_1
    //   265: istore_2
    //   266: goto -157 -> 109
    //   269: iconst_0
    //   270: istore_2
    //   271: goto -179 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramContext	Context
    //   0	274	1	paramBoolean	boolean
    //   64	207	2	i1	int
    //   1	90	3	i2	int
    //   51	30	4	localObject	Object
    //   105	17	4	localThrowable1	Throwable
    //   146	35	4	localWebView	android.webkit.WebView
    //   262	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   40	53	105	java/lang/Throwable
    //   138	180	235	java/lang/Throwable
    //   180	186	235	java/lang/Throwable
    //   190	201	235	java/lang/Throwable
    //   201	234	235	java/lang/Throwable
    //   58	63	262	java/lang/Throwable
    //   72	90	262	java/lang/Throwable
  }
  
  public static void closeFileReader(Context paramContext)
  {
    bv localbv = bv.a();
    localbv.a(paramContext, null);
    if (localbv.b()) {
      localbv.c().p();
    }
  }
  
  public static void continueLoadSo(Context paramContext)
  {
    if (("com.tencent.mm".equals(getCurrentProcessName(paramContext))) && (WebView.mWebViewCreated)) {
      q.a(r, "continueLoadSo", new Class[0], new Object[0]);
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localbv.c().b();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + paramContext);
      return paramContext != null;
    }
    return false;
  }
  
  private static void d(Context paramContext)
  {
    int i6 = -1;
    B = true;
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          i3 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
          if (i3 < 0) {
            continue;
          }
          i2 = i3 + 1;
          if (i2 > 4)
          {
            return;
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            continue;
          }
          i1 = i2;
          i3 = i2;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          int i2;
          int i5;
          Object localObject2;
          int i4;
          Object localObject3;
          int i3 = -1;
          int i1 = -1;
          continue;
          i1 = -1;
          continue;
        }
        try
        {
          i2 = an.a().j(paramContext);
          if (i2 <= 0) {
            continue;
          }
          if (i3 > 4) {}
        }
        catch (Throwable localThrowable3)
        {
          i2 = -1;
          i3 = i1;
          i1 = i2;
          continue;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", i3).commit();
          i5 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
          i3 = i1;
          localObject2 = localObject1;
          i4 = i2;
          if (i5 < 0) {
            continue;
          }
          localObject2 = ((SharedPreferences)localObject1).edit();
          i5 += 1;
          ((SharedPreferences.Editor)localObject2).putInt("tbs_preload_x5_counter", i5).commit();
          if (i5 <= 3) {
            continue;
          }
          try
          {
            i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_version", -1);
            localObject1 = ((SharedPreferences)localObject1).edit();
            if (i1 != i2) {
              continue;
            }
            com.tencent.smtt.utils.j.a(an.a().r(paramContext), false);
            paramContext = ai.a(paramContext).a();
            if (paramContext != null) {
              com.tencent.smtt.utils.j.a(paramContext, false);
            }
            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
            ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i1);
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
          catch (Throwable paramContext)
          {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
            return;
          }
          localThrowable1 = localThrowable1;
          i3 = -1;
          localObject1 = null;
          i1 = -1;
        }
        catch (Throwable localThrowable4)
        {
          i3 = i1;
          i1 = i2;
          continue;
        }
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable1));
        i4 = i1;
        localObject3 = localObject1;
        i5 = -1;
        i1 = i3;
        localObject1 = localObject3;
        i2 = i4;
        continue;
        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i1);
      }
      i2 = i6;
      if (i1 > 0)
      {
        i2 = i6;
        if (i1 <= 3)
        {
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
          bv.a().a(paramContext, null);
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
          i2 = 0;
        }
      }
      try
      {
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
      TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
      return;
    }
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    bv localbv;
    do
    {
      do
      {
        do
        {
          return false;
        } while (TbsDownloader.getOverSea(paramContext));
        localbv = bv.a();
      } while ((localbv == null) || (!localbv.b()));
    } while (localbv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) == null);
    return true;
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
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {}
    try
    {
      localbv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void forceSysWebView()
  {
    b = true;
    u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l1 = 0L;
    if (paramContext != null) {
      l1 = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
    }
    return l1;
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    int i1 = Process.myPid();
    Object localObject = "";
    Iterator localIterator = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    paramContext = (Context)localObject;
    if (localIterator.hasNext())
    {
      localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).pid != i1) {
        break label71;
      }
      paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
    }
    label71:
    for (;;)
    {
      break;
      return paramContext;
    }
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i1 = 0;
    if ((t instanceof String[]))
    {
      int i2 = t.length;
      paramContext2 = new String[i2];
      for (;;)
      {
        paramContext1 = paramContext2;
        if (i1 >= i2) {
          break;
        }
        paramContext2[i1] = (paramString + t[i1]);
        i1 += 1;
      }
    }
    paramContext1 = q.a(r, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      return paramContext1;
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return E;
  }
  
  public static boolean getIsSysWebViewForcedByOuter()
  {
    return b;
  }
  
  public static boolean getJarFilesAndLibraryPath(Context paramContext)
  {
    if (r == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
      return false;
    }
    Bundle localBundle = (Bundle)q.a(r, "canLoadX5CoreAndNotLoadSo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43617) });
    if (localBundle == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + an.a().a(true, paramContext));
      return false;
    }
    t = localBundle.getStringArray("tbs_jarfiles");
    d = localBundle.getString("tbs_librarypath");
    return true;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    Object localObject = null;
    bv localbv = bv.a();
    localbv.a(paramContext, null);
    paramContext = localObject;
    if (localbv != null)
    {
      paramContext = localObject;
      if (localbv.b()) {
        paramContext = localbv.c().f();
      }
    }
    return paramContext;
  }
  
  public static boolean getOnlyDownload()
  {
    return k;
  }
  
  public static String getQQBuildNumber()
  {
    return z;
  }
  
  public static Map<String, Object> getSettings()
  {
    return n;
  }
  
  public static boolean getTBSInstalling()
  {
    return F;
  }
  
  public static String getTID()
  {
    return y;
  }
  
  public static String getTbsResourcesPath(Context paramContext)
  {
    return TbsShareManager.g(paramContext);
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    int i1;
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      i1 = TbsShareManager.a(paramContext, false);
    }
    int i2;
    do
    {
      do
      {
        return i1;
        i2 = an.a().j(paramContext);
        i1 = i2;
      } while (i2 != 0);
      i1 = i2;
    } while (ai.a(paramContext).c() != 3);
    reset(paramContext);
    return i2;
  }
  
  public static int getTbsVersionForCrash(Context paramContext)
  {
    int i1;
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      i1 = TbsShareManager.a(paramContext, false);
    }
    int i2;
    do
    {
      do
      {
        return i1;
        i2 = an.a().k(paramContext);
        i1 = i2;
      } while (i2 != 0);
      i1 = i2;
    } while (ai.a(paramContext).c() != 3);
    reset(paramContext);
    return i2;
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public static void initForinitAndNotLoadSo(Context paramContext)
  {
    if (q == null)
    {
      localObject = an.a().r(paramContext);
      if (localObject != null) {
        break label19;
      }
    }
    label19:
    File localFile;
    do
    {
      return;
      localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
    } while (!localFile.exists());
    Object localObject = ((File)localObject).getAbsolutePath();
    bv.a().a(paramContext);
    q = new DexLoader(localFile.getParent(), paramContext, new String[] { localFile.getAbsolutePath() }, (String)localObject, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    if (n == null)
    {
      n = paramMap;
      return;
    }
    try
    {
      n.putAll(paramMap);
      return;
    }
    catch (Exception paramMap) {}
  }
  
  public static void initX5Environment(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback)
  {
    if (paramContext == null) {
      return;
    }
    b(paramContext);
    D = new l(paramContext, paramPreInitCallback);
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      an.a().b(paramContext, true);
    }
    TbsDownloader.needDownload(paramContext, false, false, new m(paramContext, paramPreInitCallback));
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool2 = false;
    o localo = o.a(true);
    localo.a(paramContext, false, false, null);
    boolean bool1 = bool2;
    if (localo != null)
    {
      bool1 = bool2;
      if (localo.b()) {
        bool1 = localo.a().a(paramContext, paramString1, paramString2, paramBundle);
      }
    }
    return bool1;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    Context localContext;
    int i1;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      localContext = paramWebView.getContext();
      i1 = paramString1.indexOf("url=");
      if (i1 <= 0) {
        break label178;
      }
    }
    label178:
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
          paramString1 = bv.a();
          if ((paramString1 != null) && (paramString1.b()) && (paramString1.c().a(localContext, paramIntent, null, paramString2, null) == 0)) {
            return true;
          }
          paramWebView.loadUrl(paramIntent);
        }
        for (;;)
        {
          return false;
          paramWebView.loadUrl(paramString1);
        }
      }
    }
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    paramString2 = bv.a();
    if ((paramString2 != null) && (paramString2.b()))
    {
      paramContext = paramString2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramContext != null) {
        if (!(paramContext instanceof Boolean)) {
          break label98;
        }
      }
    }
    label98:
    for (paramContext = (Boolean)paramContext;; paramContext = Boolean.valueOf(false))
    {
      return paramContext.booleanValue();
      return false;
      return false;
    }
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    o localo = o.a(false);
    boolean bool1 = bool2;
    if (localo != null)
    {
      bool1 = bool2;
      if (localo.g()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (ai.a(paramContext).c() == 2) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return false;
    }
    if (!c(paramContext)) {
      return true;
    }
    i1 = an.a().j(paramContext);
    paramContext = q.a(r, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i1), Integer.valueOf(43617) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  public static void loadTBSSDKExtension(Context paramContext, String paramString)
  {
    Object localObject3 = null;
    int i1 = 1;
    if (r != null) {
      return;
    }
    if (q == null) {
      TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
    }
    try
    {
      Constructor localConstructor = q.getConstructor(new Class[] { Context.class, Context.class, String.class, String.class, String.class });
      try
      {
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          localObject2 = TbsShareManager.e(paramContext);
          if ((localObject2 == null) && (TbsShareManager.getHostCorePathAppDefined() == null))
          {
            TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
            return;
          }
          if (i1 == 0)
          {
            if (localObject2 == null)
            {
              r = q.getConstructor(new Class[] { Context.class, Context.class, String.class }).newInstance(new Object[] { paramContext, localObject2, TbsShareManager.getHostCorePathAppDefined() });
              return;
            }
            r = q.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, localObject2 });
            return;
          }
          r = localConstructor.newInstance(new Object[] { paramContext, localObject2, TbsShareManager.getHostCorePathAppDefined(), paramString, null });
          return;
        }
        if (i1 == 0)
        {
          r = q.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, paramContext });
          return;
        }
        Object localObject2 = localObject3;
        if ("com.tencent.mm".equals(getCurrentProcessName(paramContext)))
        {
          localObject2 = localObject3;
          if (!WebView.mWebViewCreated) {
            localObject2 = "notLoadSo";
          }
        }
        r = localConstructor.newInstance(new Object[] { paramContext, paramContext, null, paramString, localObject2 });
        return;
      }
      catch (Throwable paramContext) {}
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i1 = 0;
        Object localObject1 = null;
      }
    }
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
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
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void reset(Context paramContext)
  {
    reset(paramContext, false);
  }
  
  public static void reset(Context paramContext, boolean paramBoolean)
  {
    int i1 = 1;
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        TbsDownloader.stopDownload();
        if ((paramBoolean) && (!TbsShareManager.isThirdPartyApp(paramContext)))
        {
          int i2 = an.a().i(paramContext);
          int i3 = an.a().j(paramContext);
          if ((i2 > 43300) && (i2 != i3))
          {
            TbsDownloader.b(paramContext);
            com.tencent.smtt.utils.j.a(paramContext.getDir("tbs", 0), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            an.a.set(Integer.valueOf(0));
            File localFile = new File(paramContext.getFilesDir(), "bugly_switch.txt");
            if (localFile.exists()) {
              localFile.delete();
            }
            if (i1 != 0)
            {
              com.tencent.smtt.utils.j.b(an.a().q(paramContext), an.a().u(paramContext));
              an.a().b(paramContext);
            }
            return;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
        return;
      }
      i1 = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    try
    {
      com.tencent.smtt.utils.j.b(an.a().q(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("QQ:")) {
      return;
    }
    paramString = paramString.substring(3);
    y = "0000000000000000".substring(paramString.length()) + paramString;
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
    A = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + A);
  }
  
  public static void setDisableUseHostBackupCoreBySwitch(boolean paramBoolean)
  {
    mDisableUseHostBackupCore = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    E = paramBoolean;
  }
  
  public static void setOnlyDownload(boolean paramBoolean)
  {
    k = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    z = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    C = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    TbsLog.setTbsLogClient(paramTbsLogClient);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    if ((paramInt >= 130) && (paramInt <= 139))
    {
      paramContext = TbsDownloadUpload.getInstance(paramContext);
      paramContext.a.put("tbs_needdownload_code", Integer.valueOf(paramInt));
      paramContext.commit();
    }
    while ((paramInt < 150) || (paramInt > 159)) {
      return;
    }
    paramContext = TbsDownloadUpload.getInstance(paramContext);
    paramContext.a.put("tbs_startdownload_code", Integer.valueOf(paramInt));
    paramContext.commit();
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    TbsCoreLoadStat.getInstance().a(paramContext, 501);
    if (paramContext == null) {
      return -100;
    }
    bv localbv = bv.a();
    localbv.a(paramContext, null);
    if (localbv.b())
    {
      if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) {
        return -101;
      }
      int i1 = localbv.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback);
      if (i1 == 0)
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 503);
        return i1;
      }
      TbsLogReport.getInstance(paramContext).setLoadErrorCode(504, String.valueOf(i1));
      return i1;
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 502);
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return d.a(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return d.a(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
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
        localObject = bv.a();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((bv)localObject).b())
          {
            localObject = ((bv)localObject).c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
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
    return d.a(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return false;
    }
    bv localbv = bv.a();
    localbv.a(paramContext, null);
    if ((paramHashMap != null) && ("5".equals(paramHashMap.get("PosID"))) && (localbv.b())) {
      localbv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
    }
    if (d.a(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
    {
      if (localbv.b())
      {
        if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) {
          return false;
        }
        if (localbv.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback) == 0) {
          return true;
        }
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public static void unForceSysWebView()
  {
    b = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean unPreInit(Context paramContext)
  {
    return true;
  }
  
  public static boolean useSoftWare()
  {
    if (r == null) {
      return false;
    }
    Object localObject2 = q.a(r, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = r;
      localObject2 = Integer.TYPE;
      int i1 = a.a();
      localObject1 = q.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i1) });
    }
    if (localObject1 == null) {
      return false;
    }
    return ((Boolean)localObject1).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */