package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TbsShareManager
{
  private static Context a;
  private static String b = null;
  private static String c = "";
  private static String d = null;
  private static int e = 0;
  private static String f = null;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static String j = null;
  private static boolean k = false;
  private static boolean l = false;
  public static boolean mHasQueryed = false;
  
  static int a(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(54908);
    b(paramContext, paramBoolean);
    int m = e;
    AppMethodBeat.o(54908);
    return m;
  }
  
  static String a()
  {
    return d;
  }
  
  static void a(Context paramContext)
  {
    AppMethodBeat.i(54896);
    TbsLog.i("TbsShareManager", "shareTbsCore #1");
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      a(paramContext, localTbsLinuxToolsJni, q.a().r(paramContext));
      paramContext = q.a().s(paramContext);
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + paramContext.getAbsolutePath());
      localTbsLinuxToolsJni.a(paramContext.getAbsolutePath(), "755");
      AppMethodBeat.o(54896);
      return;
    }
    finally
    {
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + paramContext.getMessage() + " ## " + paramContext.getCause());
      AppMethodBeat.o(54896);
    }
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(54918);
    String str1;
    int m;
    if ((!TbsPVConfig.getInstance(a).isDisableHostBackupCore()) && (q.a().u(paramContext)))
    {
      str1 = paramContext.getPackageName();
      TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
      m = 0;
    }
    for (;;)
    {
      String str2;
      Object localObject;
      if (m < 5)
      {
        str2 = new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", str1 }[m];
        if (paramInt != getBackupCoreVersion(paramContext, str2)) {
          break label204;
        }
        localObject = getPackageContext(paramContext, str2, false);
        if (!q.a().g((Context)localObject)) {
          break label298;
        }
        localObject = getBackupCoreFile(paramContext, str2);
        if (!a.a(paramContext, (File)localObject, 0L, paramInt)) {
          break label298;
        }
        TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + paramInt + " packageName is " + str2);
        q.a().b(paramContext, (File)localObject, paramInt);
      }
      for (;;)
      {
        q.a().b();
        AppMethodBeat.o(54918);
        return;
        label204:
        if (paramInt != getBackupDecoupleCoreVersion(paramContext, str2)) {
          break;
        }
        localObject = getPackageContext(paramContext, str2, false);
        if (!q.a().g((Context)localObject)) {
          break;
        }
        localObject = getBackupDecoupleCoreFile(paramContext, str2);
        if (!a.a(paramContext, (File)localObject, 0L, paramInt)) {
          break;
        }
        TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + paramInt + " packageName is " + str2);
        q.a().b(paramContext, (File)localObject, paramInt);
      }
      label298:
      m += 1;
    }
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    AppMethodBeat.i(54898);
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      AppMethodBeat.o(54898);
      return;
    }
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + paramFile.getAbsolutePath());
    paramTbsLinuxToolsJni.a(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int n = paramFile.length;
    int m = 0;
    if (m < n)
    {
      File localFile = paramFile[m];
      if (localFile.isFile()) {
        if (localFile.getAbsolutePath().indexOf(".so") > 0) {
          paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "755");
        }
      }
      for (;;)
      {
        m += 1;
        break;
        paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "644");
        continue;
        if (localFile.isDirectory()) {
          a(paramContext, paramTbsLinuxToolsJni, localFile);
        } else {
          TbsLog.e("TbsShareManager", "unknown file type.", true);
        }
      }
    }
    AppMethodBeat.o(54898);
  }
  
  static void b(Context paramContext)
  {
    AppMethodBeat.i(54897);
    try
    {
      a(paramContext, new TbsLinuxToolsJni(paramContext), q.a().q(paramContext));
      return;
    }
    finally
    {
      AppMethodBeat.o(54897);
    }
  }
  
  static boolean b(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(54928);
    if (i(paramContext))
    {
      AppMethodBeat.o(54928);
      return true;
    }
    if (paramBoolean) {
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    AppMethodBeat.o(54928);
    return false;
  }
  
  static String c(Context paramContext)
  {
    AppMethodBeat.i(54906);
    j(paramContext);
    paramContext = d;
    AppMethodBeat.o(54906);
    return paramContext;
  }
  
  /* Error */
  private static void c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 273
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 275
    //   10: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore 5
    //   15: aload 5
    //   17: ifnonnull +10 -> 27
    //   20: ldc_w 273
    //   23: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: new 280	java/io/BufferedInputStream
    //   30: dup
    //   31: new 282	java/io/FileInputStream
    //   34: dup
    //   35: aload 5
    //   37: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_3
    //   44: new 290	java/util/Properties
    //   47: dup
    //   48: invokespecial 291	java/util/Properties:<init>	()V
    //   51: astore 4
    //   53: aload 4
    //   55: aload_3
    //   56: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   59: aload 4
    //   61: ldc_w 296
    //   64: ldc_w 298
    //   67: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   70: pop
    //   71: iload_1
    //   72: ifeq +64 -> 136
    //   75: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   78: aload_0
    //   79: invokevirtual 93	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   82: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   85: astore 6
    //   87: aload_0
    //   88: invokevirtual 306	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   91: invokevirtual 162	android/content/Context:getPackageName	()Ljava/lang/String;
    //   94: astore 7
    //   96: aload_0
    //   97: invokestatic 311	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)I
    //   100: istore_2
    //   101: aload 4
    //   103: ldc_w 313
    //   106: aload 7
    //   108: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   111: pop
    //   112: aload 4
    //   114: ldc_w 315
    //   117: aload 6
    //   119: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   122: pop
    //   123: aload 4
    //   125: ldc_w 317
    //   128: iload_2
    //   129: invokestatic 321	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   132: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   135: pop
    //   136: new 323	java/io/BufferedOutputStream
    //   139: dup
    //   140: new 325	java/io/FileOutputStream
    //   143: dup
    //   144: aload 5
    //   146: invokespecial 326	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   149: invokespecial 329	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   152: astore_0
    //   153: aload 4
    //   155: aload_0
    //   156: aconst_null
    //   157: invokevirtual 333	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   160: aload_3
    //   161: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   164: aload_0
    //   165: invokevirtual 337	java/io/BufferedOutputStream:close	()V
    //   168: ldc_w 273
    //   171: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: astore_0
    //   176: ldc_w 273
    //   179: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore_0
    //   184: aconst_null
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   196: aload_0
    //   197: ifnull +7 -> 204
    //   200: aload_0
    //   201: invokevirtual 337	java/io/BufferedOutputStream:close	()V
    //   204: ldc_w 273
    //   207: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: return
    //   211: astore_0
    //   212: ldc_w 273
    //   215: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: return
    //   219: astore_3
    //   220: goto -56 -> 164
    //   223: astore_3
    //   224: goto -28 -> 196
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_0
    //   230: goto -42 -> 188
    //   233: astore 4
    //   235: goto -47 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramContext	Context
    //   0	238	1	paramBoolean	boolean
    //   100	29	2	m	int
    //   43	150	3	localBufferedInputStream	java.io.BufferedInputStream
    //   219	1	3	localException1	Exception
    //   223	1	3	localException2	Exception
    //   51	103	4	localProperties	java.util.Properties
    //   233	1	4	localObject	Object
    //   13	132	5	localFile	File
    //   85	33	6	str1	String
    //   94	13	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   164	168	175	java/lang/Exception
    //   6	15	183	finally
    //   27	44	183	finally
    //   200	204	211	java/lang/Exception
    //   160	164	219	java/lang/Exception
    //   192	196	223	java/lang/Exception
    //   44	71	227	finally
    //   75	136	227	finally
    //   136	153	227	finally
    //   153	160	233	finally
  }
  
  static int d(Context paramContext)
  {
    AppMethodBeat.i(54907);
    int m = a(paramContext, true);
    AppMethodBeat.o(54907);
    return m;
  }
  
  private static String[] d(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(54917);
    String[] arrayOfString;
    if (QbSdk.getOnlyDownload())
    {
      arrayOfString = new String[1];
      arrayOfString[0] = paramContext.getApplicationContext().getPackageName();
    }
    for (;;)
    {
      AppMethodBeat.o(54917);
      return arrayOfString;
      arrayOfString = getCoreProviderAppList();
      if (paramBoolean)
      {
        arrayOfString = new String[1];
        arrayOfString[0] = paramContext.getApplicationContext().getPackageName();
      }
    }
  }
  
  static Context e(Context paramContext)
  {
    Object localObject2 = null;
    AppMethodBeat.i(54909);
    j(paramContext);
    Object localObject1 = localObject2;
    if (f != null)
    {
      localObject1 = getPackageContext(paramContext, f, true);
      if (q.a().g((Context)localObject1)) {
        break label68;
      }
      localObject1 = localObject2;
    }
    label68:
    for (;;)
    {
      if (b != null)
      {
        paramContext = a;
        AppMethodBeat.o(54909);
        return paramContext;
      }
      AppMethodBeat.o(54909);
      return localObject1;
    }
  }
  
  /* Error */
  static String f(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 352
    //   8: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc_w 275
    //   15: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +16 -> 36
    //   23: ldc_w 352
    //   26: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_2
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: new 280	java/io/BufferedInputStream
    //   39: dup
    //   40: new 282	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_0
    //   52: new 290	java/util/Properties
    //   55: dup
    //   56: invokespecial 291	java/util/Properties:<init>	()V
    //   59: astore_3
    //   60: aload_3
    //   61: aload_0
    //   62: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   65: aload_3
    //   66: ldc_w 313
    //   69: ldc 31
    //   71: invokevirtual 356	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_3
    //   75: ldc 31
    //   77: aload_3
    //   78: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: istore_1
    //   82: iload_1
    //   83: ifne +18 -> 101
    //   86: aload_0
    //   87: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   90: ldc_w 352
    //   93: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_3
    //   97: astore_0
    //   98: goto -67 -> 31
    //   101: aload_0
    //   102: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   105: ldc_w 352
    //   108: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_2
    //   112: astore_0
    //   113: goto -82 -> 31
    //   116: astore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   133: ldc_w 352
    //   136: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_2
    //   140: astore_0
    //   141: goto -110 -> 31
    //   144: astore_0
    //   145: goto -55 -> 90
    //   148: astore_0
    //   149: goto -44 -> 105
    //   152: astore_0
    //   153: goto -20 -> 133
    //   156: astore_3
    //   157: goto -32 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramContext	Context
    //   81	2	1	bool	boolean
    //   1	139	2	localObject1	Object
    //   59	38	3	localObject2	Object
    //   156	1	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	116	finally
    //   23	29	116	finally
    //   86	90	116	finally
    //   90	96	116	finally
    //   101	105	116	finally
    //   105	111	116	finally
    //   129	133	116	finally
    //   133	139	116	finally
    //   11	19	122	finally
    //   36	52	122	finally
    //   86	90	144	java/lang/Exception
    //   101	105	148	java/lang/Exception
    //   129	133	152	java/lang/Exception
    //   52	82	156	finally
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    AppMethodBeat.i(54912);
    n(paramContext);
    TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
    if (f == null) {
      TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
    }
    int m;
    if ((f != null) && (f.equals("AppDefined")))
    {
      if (e != q.a().a(b))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + q.a().a(b));
      }
      if (e > 0)
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        if ((!"com.tencent.android.qqdownloader".equals(localApplicationInfo.packageName)) && (!"com.jd.jrapp".equals(localApplicationInfo.packageName))) {
          break label289;
        }
        m = 1;
        label198:
        if (m != 0) {
          break label294;
        }
      }
    }
    label289:
    label294:
    for (boolean bool = QbSdk.a(paramContext, e);; bool = false)
    {
      if ((bool) || (g))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
      }
      m = e;
      AppMethodBeat.o(54912);
      return m;
      if ((k(paramContext)) || (l(paramContext))) {
        break;
      }
      e = 0;
      d = null;
      f = null;
      TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
      break;
      m = 0;
      break label198;
    }
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    AppMethodBeat.i(54915);
    if ((paramContext == null) || (q.a().a(paramContext, null)))
    {
      AppMethodBeat.o(54915);
      return false;
    }
    int m = getSharedTbsCoreVersion(paramContext, "com.tencent.tbs");
    if (m > 0)
    {
      Object localObject = getPackageContext(paramContext, "com.tencent.tbs", true);
      localObject = q.a().r((Context)localObject).getAbsolutePath();
      writeProperties(paramContext, Integer.toString(m), "com.tencent.tbs", (String)localObject, "1");
      AppMethodBeat.o(54915);
      return true;
    }
    AppMethodBeat.o(54915);
    return false;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean)
  {
    int n = 0;
    AppMethodBeat.i(54924);
    for (;;)
    {
      int m;
      try
      {
        boolean bool = QbSdk.isNeedInitX5FirstTime();
        if (!bool)
        {
          AppMethodBeat.o(54924);
          return;
        }
        bool = isThirdPartyApp(paramContext);
        if (!bool)
        {
          AppMethodBeat.o(54924);
          return;
        }
        bool = QbSdk.getOnlyDownload();
        if (bool)
        {
          AppMethodBeat.o(54924);
          return;
        }
        Object localObject = q.a().s(paramContext);
        if (localObject == null)
        {
          AppMethodBeat.o(54924);
          return;
        }
        if (paramBoolean)
        {
          paramBoolean = new File((File)localObject, "core_info").exists();
          if (paramBoolean)
          {
            AppMethodBeat.o(54924);
            return;
          }
        }
        if (b != null)
        {
          m = q.a().a(b);
          if (m > 0)
          {
            d = b;
            f = "AppDefined";
            e = m;
            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
            writeProperties(paramContext, Integer.toString(e), f, d, Integer.toString(1));
            AppMethodBeat.o(54924);
            return;
          }
        }
        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1");
        int i1 = h(paramContext);
        int i2 = q.a().j(paramContext);
        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromConfig is ".concat(String.valueOf(i1)));
        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromCoreShare is ".concat(String.valueOf(i2)));
        localObject = getCoreProviderAppList();
        int i3 = localObject.length;
        m = 0;
        String str;
        int i4;
        Context localContext;
        if (m < i3)
        {
          str = localObject[m];
          i4 = getCoreShareDecoupleCoreVersion(paramContext, str);
          if ((i4 < i1) || (i4 < i2) || (i4 <= 0)) {
            break label905;
          }
          localContext = getPackageContext(paramContext, str, true);
          d = q.a().c(paramContext, localContext).getAbsolutePath();
          f = str;
          e = i4;
          TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
          if (QbSdk.canLoadX5FirstTimeThirdApp(paramContext))
          {
            m = b.e(paramContext);
            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2");
            writeProperties(paramContext, Integer.toString(e), f, d, Integer.toString(m));
            AppMethodBeat.o(54924);
            return;
          }
          e = 0;
          d = null;
          f = null;
          break label905;
        }
        i3 = localObject.length;
        m = 0;
        if (m < i3)
        {
          str = localObject[m];
          i4 = getSharedTbsCoreVersion(paramContext, str);
          if ((i4 < i1) || (i4 < i2) || (i4 <= 0)) {
            break label912;
          }
          localContext = getPackageContext(paramContext, str, true);
          d = q.a().b(paramContext, localContext).getAbsolutePath();
          f = str;
          e = i4;
          TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #3 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
          if (QbSdk.canLoadX5FirstTimeThirdApp(paramContext))
          {
            m = b.e(paramContext);
            writeProperties(paramContext, Integer.toString(e), f, d, Integer.toString(m));
            AppMethodBeat.o(54924);
            return;
          }
          e = 0;
          d = null;
          f = null;
          break label912;
        }
        if (TbsPVConfig.getInstance(a).isDisableHostBackupCore()) {
          break label898;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          i3 = localObject.length;
          m = n;
          if (m < i3)
          {
            str = localObject[m];
            n = getBackupCoreVersion(paramContext, str);
            if ((n >= i1) && (n >= i2) && (n > 0))
            {
              TbsLog.i("TbsShareManager", "find host backup core to unzip forceload coreVersion is " + n + " packageName is " + str);
              localObject = getBackupCoreFile(paramContext, str);
              q.a().a(paramContext, (File)localObject, n);
              TbsLog.i("TbsShareManager", "find host backup core to unzip forceload after unzip ");
              AppMethodBeat.o(54924);
              return;
            }
            n = getBackupDecoupleCoreVersion(paramContext, str);
            if ((n >= i1) && (n >= i2) && (n > 0))
            {
              TbsLog.i("TbsShareManager", "find host backup core to unzip forceload decouple coreVersion is " + n + " packageName is " + str);
              localObject = getBackupCoreFile(paramContext, str);
              q.a().a(paramContext, (File)localObject, n);
              TbsLog.i("TbsShareManager", "find host backup decouple core to unzip forceload after unzip ");
              AppMethodBeat.o(54924);
              return;
            }
            m += 1;
            continue;
          }
          AppMethodBeat.o(54924);
          return;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(54924);
        return;
      }
      TbsLog.i("TbsShareManager", "in mainthread so do not find host backup core to install ");
      label898:
      AppMethodBeat.o(54924);
      return;
      label905:
      m += 1;
      continue;
      label912:
      m += 1;
    }
  }
  
  static String g(Context paramContext)
  {
    AppMethodBeat.i(54921);
    try
    {
      n(paramContext);
      if (d != null)
      {
        boolean bool = TextUtils.isEmpty(d);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(54921);
        return null;
      }
      paramContext = new StringBuilder(d);
      paramContext.append(File.separator);
      paramContext.append("res.apk");
      paramContext = paramContext.toString();
      AppMethodBeat.o(54921);
      return paramContext;
    }
    finally
    {
      new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(paramContext));
      AppMethodBeat.o(54921);
    }
    return null;
  }
  
  public static File getBackupCoreFile(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54904);
    try
    {
      paramContext = new File(new File(f.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      boolean bool = paramContext.exists();
      if (bool) {
        return paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(54904);
    }
    return null;
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54902);
    try
    {
      paramContext = new File(new File(f.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      if (paramContext.exists())
      {
        int m = a.b(paramContext);
        return m;
      }
    }
    finally
    {
      AppMethodBeat.o(54902);
    }
    return 0;
  }
  
  public static File getBackupDecoupleCoreFile(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54905);
    try
    {
      paramContext = new File(new File(f.a(getPackageContext(paramContext, paramString, true), 4)), TbsDownloader.getBackupFileName(true));
      boolean bool = paramContext.exists();
      if (bool) {
        return paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(54905);
    }
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54903);
    try
    {
      paramContext = new File(new File(f.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(true));
      if (paramContext.exists())
      {
        int m = a.b(paramContext);
        return m;
      }
    }
    finally
    {
      AppMethodBeat.o(54903);
    }
    return 0;
  }
  
  public static boolean getCoreDisabled()
  {
    return g;
  }
  
  public static boolean getCoreFormOwn()
  {
    return k;
  }
  
  public static String[] getCoreProviderAppList()
  {
    return new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", "com.tencent.qqlite" };
  }
  
  public static int getCoreShareDecoupleCoreVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54901);
    paramContext = getPackageContext(paramContext, paramString, true);
    if (paramContext != null)
    {
      int m = q.a().i(paramContext);
      AppMethodBeat.o(54901);
      return m;
    }
    AppMethodBeat.o(54901);
    return 0;
  }
  
  public static String getHostCorePathAppDefined()
  {
    return b;
  }
  
  public static long getHostCoreVersions(Context paramContext)
  {
    AppMethodBeat.i(54899);
    long l2 = 0L;
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    int m = 0;
    if (m < n)
    {
      String str = arrayOfString[m];
      long l1;
      if (str.equalsIgnoreCase("com.tencent.mm")) {
        l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 10000000000L;
      }
      for (;;)
      {
        m += 1;
        l2 = l1;
        break;
        if (str.equalsIgnoreCase("com.tencent.mobileqq"))
        {
          l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 100000L;
        }
        else
        {
          l1 = l2;
          if (str.equalsIgnoreCase("com.qzone")) {
            l1 = l2 + getSharedTbsCoreVersion(paramContext, str);
          }
        }
      }
    }
    AppMethodBeat.o(54899);
    return l2;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54929);
    if (paramBoolean) {}
    try
    {
      if ((!paramContext.getPackageName().equals(paramString)) && (TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray()))
      {
        TbsLog.i("TbsShareManager", "gray no core app,skip get context");
        AppMethodBeat.o(54929);
        return null;
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      AppMethodBeat.o(54929);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(54929);
      return null;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(54929);
    }
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54900);
    paramContext = getPackageContext(paramContext, paramString, true);
    if (paramContext != null)
    {
      int m = q.a().j(paramContext);
      AppMethodBeat.o(54900);
      return m;
    }
    AppMethodBeat.o(54900);
    return 0;
  }
  
  public static String getStableCoreZeroReason()
  {
    return c;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54925);
    paramContext = q.a().s(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(54925);
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists())
    {
      AppMethodBeat.o(54925);
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      AppMethodBeat.o(54925);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      AppMethodBeat.o(54925);
    }
    return null;
  }
  
  public static int getTbsStableCoreVersion(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219758);
    Object localObject;
    try
    {
      localObject = getPackageContext(paramContext, "com.tencent.mm", false);
      if (localObject == null) {}
      for (localObject = new File(f.a(paramContext, "com.tencent.mm", 4, true));; localObject = new File(f.a((Context)localObject, 4)))
      {
        localObject = new File((File)localObject, TbsDownloader.getBackupFileName(false, paramInt));
        TbsLog.i("TbsDownload", "getTbsStableCoreVersion, coreStable is " + ((File)localObject).getAbsolutePath());
        c = "none";
        if ((!((File)localObject).exists()) || (!((File)localObject).canRead())) {
          break;
        }
        int n = a.b((File)localObject);
        int m = n;
        if (n <= 0) {
          m = a.a(paramContext, (File)localObject, paramInt);
        }
        AppMethodBeat.o(219758);
        return m;
      }
      AppMethodBeat.o(219758);
    }
    finally
    {
      TbsLog.i("TbsDownload", "getTbsStableCoreVersion stack is " + Log.getStackTraceString(paramContext));
      c = Log.getStackTraceString(paramContext);
    }
    for (;;)
    {
      return 0;
      TbsLog.i("TbsDownload", "getTbsStableCoreVersion,core stable not exist".concat(String.valueOf(localObject)));
      c = ((File)localObject).getAbsolutePath() + " exist is " + ((File)localObject).exists() + " canRead is " + ((File)localObject).canRead();
    }
  }
  
  /* Error */
  static int h(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 611
    //   8: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: ldc 73
    //   13: ldc_w 613
    //   16: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: ldc_w 275
    //   23: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnonnull +22 -> 50
    //   31: ldc 73
    //   33: ldc_w 615
    //   36: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc_w 611
    //   42: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: iload_1
    //   49: ireturn
    //   50: new 280	java/io/BufferedInputStream
    //   53: dup
    //   54: new 282	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore_0
    //   66: new 290	java/util/Properties
    //   69: dup
    //   70: invokespecial 291	java/util/Properties:<init>	()V
    //   73: astore_2
    //   74: aload_2
    //   75: aload_0
    //   76: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   79: aload_2
    //   80: ldc_w 617
    //   83: ldc 31
    //   85: invokevirtual 356	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: astore_2
    //   89: ldc 31
    //   91: aload_2
    //   92: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifne +39 -> 134
    //   98: ldc 73
    //   100: ldc_w 619
    //   103: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_2
    //   107: invokestatic 622	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   110: iconst_0
    //   111: invokestatic 628	java/lang/Math:max	(II)I
    //   114: istore_1
    //   115: aload_0
    //   116: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   119: ldc_w 611
    //   122: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: goto -80 -> 45
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    //   134: ldc 73
    //   136: ldc_w 630
    //   139: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   146: ldc_w 611
    //   149: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: goto -107 -> 45
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   166: ldc 73
    //   168: ldc_w 632
    //   171: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: bipush 254
    //   176: istore_1
    //   177: ldc_w 611
    //   180: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: goto -138 -> 45
    //   186: astore_0
    //   187: goto -68 -> 119
    //   190: astore_0
    //   191: goto -45 -> 146
    //   194: astore_0
    //   195: goto -29 -> 166
    //   198: astore_2
    //   199: goto -41 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramContext	Context
    //   1	176	1	m	int
    //   73	34	2	localObject1	Object
    //   198	1	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	19	128	finally
    //   39	45	128	finally
    //   115	119	128	finally
    //   119	125	128	finally
    //   142	146	128	finally
    //   146	152	128	finally
    //   162	166	128	finally
    //   166	174	128	finally
    //   177	183	128	finally
    //   19	27	155	finally
    //   31	39	155	finally
    //   50	66	155	finally
    //   115	119	186	java/lang/Exception
    //   142	146	190	java/lang/Exception
    //   162	166	194	java/lang/Exception
    //   66	115	198	finally
    //   134	142	198	finally
  }
  
  static boolean i(Context paramContext)
  {
    AppMethodBeat.i(54926);
    try
    {
      if (e == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (e == 0)
      {
        TbsLog.addLog(994, null, new Object[0]);
        AppMethodBeat.o(54926);
        return false;
      }
      int m;
      int n;
      if (b == null)
      {
        if (e != 0)
        {
          m = getSharedTbsCoreVersion(paramContext, f);
          n = e;
          if (m == n)
          {
            AppMethodBeat.o(54926);
            return true;
          }
        }
      }
      else if (e != 0)
      {
        m = q.a().a(b);
        n = e;
        if (m == n)
        {
          AppMethodBeat.o(54926);
          return true;
        }
      }
      boolean bool = l(paramContext);
      if (bool)
      {
        AppMethodBeat.o(54926);
        return true;
      }
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 418, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(paramContext, f) + "; getHostCoreVersions is " + getHostCoreVersions(paramContext)));
      d = null;
      e = 0;
      TbsLog.addLog(993, null, new Object[0]);
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      AppMethodBeat.o(54926);
      return false;
    }
    finally
    {
      TbsLog.addLog(992, null, new Object[0]);
      AppMethodBeat.o(54926);
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    return false;
  }
  
  static boolean j(Context paramContext)
  {
    AppMethodBeat.i(54927);
    boolean bool = b(paramContext, true);
    AppMethodBeat.o(54927);
    return bool;
  }
  
  private static boolean k(Context paramContext)
  {
    AppMethodBeat.i(54910);
    if (f == null)
    {
      AppMethodBeat.o(54910);
      return false;
    }
    if (e == getSharedTbsCoreVersion(paramContext, f))
    {
      AppMethodBeat.o(54910);
      return true;
    }
    if (e == getCoreShareDecoupleCoreVersion(paramContext, f))
    {
      AppMethodBeat.o(54910);
      return true;
    }
    AppMethodBeat.o(54910);
    return false;
  }
  
  private static boolean l(Context paramContext)
  {
    AppMethodBeat.i(54911);
    if (QbSdk.getOnlyDownload())
    {
      AppMethodBeat.o(54911);
      return false;
    }
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    int m = 0;
    String str;
    Context localContext;
    while (m < n)
    {
      str = arrayOfString[m];
      if ((e > 0) && (e == getSharedTbsCoreVersion(paramContext, str)))
      {
        localContext = getPackageContext(paramContext, str, true);
        if (q.a().g(paramContext))
        {
          d = q.a().b(paramContext, localContext).getAbsolutePath();
          f = str;
          AppMethodBeat.o(54911);
          return true;
        }
      }
      m += 1;
    }
    n = arrayOfString.length;
    m = 0;
    while (m < n)
    {
      str = arrayOfString[m];
      if ((e > 0) && (e == getCoreShareDecoupleCoreVersion(paramContext, str)))
      {
        localContext = getPackageContext(paramContext, str, true);
        if (q.a().g(paramContext))
        {
          d = q.a().c(paramContext, localContext).getAbsolutePath();
          f = str;
          AppMethodBeat.o(54911);
          return true;
        }
      }
      m += 1;
    }
    AppMethodBeat.o(54911);
    return false;
  }
  
  private static boolean m(Context paramContext)
  {
    AppMethodBeat.i(54913);
    if (paramContext == null)
    {
      AppMethodBeat.o(54913);
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    AppMethodBeat.o(54913);
    return true;
  }
  
  /* Error */
  private static void n(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 669
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 51	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   9: ifeq +10 -> 19
    //   12: ldc_w 669
    //   15: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: ldc 2
    //   21: monitorenter
    //   22: getstatic 51	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   25: ifeq +13 -> 38
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc_w 669
    //   34: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: aload_0
    //   39: ldc_w 275
    //   42: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   45: astore_0
    //   46: aload_0
    //   47: ifnonnull +13 -> 60
    //   50: ldc 2
    //   52: monitorexit
    //   53: ldc_w 669
    //   56: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: new 280	java/io/BufferedInputStream
    //   63: dup
    //   64: new 282	java/io/FileInputStream
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: astore_0
    //   76: new 290	java/util/Properties
    //   79: dup
    //   80: invokespecial 291	java/util/Properties:<init>	()V
    //   83: astore_1
    //   84: aload_1
    //   85: aload_0
    //   86: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   89: aload_1
    //   90: ldc_w 617
    //   93: ldc 31
    //   95: invokevirtual 356	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_2
    //   99: ldc 31
    //   101: aload_2
    //   102: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifne +60 -> 165
    //   108: aload_2
    //   109: invokestatic 622	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   112: iconst_0
    //   113: invokestatic 628	java/lang/Math:max	(II)I
    //   116: putstatic 37	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   119: ldc 73
    //   121: new 101	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 671
    //   128: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: getstatic 37	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   134: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc_w 440
    //   140: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: new 127	java/lang/Throwable
    //   146: dup
    //   147: ldc_w 442
    //   150: invokespecial 443	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   153: invokestatic 171	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   156: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_1
    //   166: ldc_w 313
    //   169: ldc 31
    //   171: invokevirtual 356	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_2
    //   175: ldc 31
    //   177: aload_2
    //   178: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifne +7 -> 188
    //   184: aload_2
    //   185: putstatic 39	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   188: getstatic 39	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   191: ifnull +28 -> 219
    //   194: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   197: ifnull +22 -> 219
    //   200: getstatic 39	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   203: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   206: invokevirtual 162	android/content/Context:getPackageName	()Ljava/lang/String;
    //   209: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   212: ifeq +87 -> 299
    //   215: iconst_1
    //   216: putstatic 49	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   219: aload_1
    //   220: ldc_w 315
    //   223: ldc 31
    //   225: invokevirtual 356	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   228: astore_2
    //   229: ldc 31
    //   231: aload_2
    //   232: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifne +7 -> 242
    //   238: aload_2
    //   239: putstatic 35	com/tencent/smtt/sdk/TbsShareManager:d	Ljava/lang/String;
    //   242: aload_1
    //   243: ldc_w 317
    //   246: ldc 31
    //   248: invokevirtual 356	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   251: astore_2
    //   252: ldc 31
    //   254: aload_2
    //   255: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifne +7 -> 265
    //   261: aload_2
    //   262: putstatic 47	com/tencent/smtt/sdk/TbsShareManager:j	Ljava/lang/String;
    //   265: aload_1
    //   266: ldc_w 296
    //   269: ldc_w 298
    //   272: invokevirtual 356	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: invokestatic 676	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   278: putstatic 41	com/tencent/smtt/sdk/TbsShareManager:g	Z
    //   281: iconst_1
    //   282: putstatic 51	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   285: aload_0
    //   286: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   289: ldc 2
    //   291: monitorexit
    //   292: ldc_w 669
    //   295: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: return
    //   299: iconst_0
    //   300: putstatic 49	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   303: goto -84 -> 219
    //   306: astore_1
    //   307: aload_0
    //   308: ifnull -19 -> 289
    //   311: aload_0
    //   312: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   315: goto -26 -> 289
    //   318: astore_0
    //   319: goto -30 -> 289
    //   322: astore_0
    //   323: ldc 2
    //   325: monitorexit
    //   326: ldc_w 669
    //   329: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aload_0
    //   333: athrow
    //   334: astore_0
    //   335: goto -46 -> 289
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -34 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramContext	Context
    //   83	183	1	localProperties	java.util.Properties
    //   306	1	1	localObject	Object
    //   98	164	2	str	String
    // Exception table:
    //   from	to	target	type
    //   76	165	306	finally
    //   165	188	306	finally
    //   188	219	306	finally
    //   219	242	306	finally
    //   242	265	306	finally
    //   265	285	306	finally
    //   299	303	306	finally
    //   311	315	318	java/lang/Exception
    //   22	31	322	finally
    //   50	53	322	finally
    //   285	289	322	finally
    //   289	292	322	finally
    //   311	315	322	finally
    //   285	289	334	java/lang/Exception
    //   38	46	338	finally
    //   60	76	338	finally
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    b = paramString;
  }
  
  /* Error */
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: ldc_w 680
    //   9: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc 73
    //   14: ldc_w 682
    //   17: iload_1
    //   18: invokestatic 321	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   21: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: iload_1
    //   28: ifne +30 -> 58
    //   31: aload_0
    //   32: invokestatic 684	com/tencent/smtt/sdk/TbsShareManager:m	(Landroid/content/Context;)Z
    //   35: pop
    //   36: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   39: invokestatic 689	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: sipush -401
    //   45: invokevirtual 692	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   48: ldc_w 680
    //   51: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: ldc 2
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: invokestatic 447	com/tencent/smtt/sdk/TbsShareManager:h	(Landroid/content/Context;)I
    //   62: istore_3
    //   63: ldc 73
    //   65: ldc_w 694
    //   68: iload_3
    //   69: invokestatic 321	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   72: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: iload_3
    //   79: ifge +30 -> 109
    //   82: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   85: invokestatic 689	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   88: sipush -402
    //   91: invokevirtual 692	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   94: ldc_w 680
    //   97: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: goto -46 -> 54
    //   103: astore_0
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    //   109: iload_1
    //   110: iload_3
    //   111: if_icmpne +45 -> 156
    //   114: aload_0
    //   115: invokestatic 696	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   118: ifne +12 -> 130
    //   121: iload_2
    //   122: ifne +8 -> 130
    //   125: aload_0
    //   126: iload_1
    //   127: invokestatic 698	com/tencent/smtt/sdk/TbsShareManager:a	(Landroid/content/Context;I)V
    //   130: aload_0
    //   131: iload_2
    //   132: invokestatic 700	com/tencent/smtt/sdk/TbsShareManager:c	(Landroid/content/Context;Z)V
    //   135: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   138: invokestatic 689	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   141: sipush -403
    //   144: invokevirtual 692	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   147: ldc_w 680
    //   150: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: goto -99 -> 54
    //   156: iload_1
    //   157: iload_3
    //   158: if_icmpge +29 -> 187
    //   161: aload_0
    //   162: invokestatic 684	com/tencent/smtt/sdk/TbsShareManager:m	(Landroid/content/Context;)Z
    //   165: pop
    //   166: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   169: invokestatic 689	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   172: sipush -404
    //   175: invokevirtual 692	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   178: ldc_w 680
    //   181: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: goto -130 -> 54
    //   187: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   190: aload_0
    //   191: invokevirtual 449	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   194: istore_3
    //   195: ldc 73
    //   197: ldc_w 702
    //   200: iload_3
    //   201: invokestatic 321	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   204: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   207: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: iload_1
    //   211: iload_3
    //   212: if_icmpge +29 -> 241
    //   215: aload_0
    //   216: invokestatic 684	com/tencent/smtt/sdk/TbsShareManager:m	(Landroid/content/Context;)Z
    //   219: pop
    //   220: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   223: invokestatic 689	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   226: sipush -404
    //   229: invokevirtual 692	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   232: ldc_w 680
    //   235: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: goto -184 -> 54
    //   241: aload_0
    //   242: iload_2
    //   243: invokestatic 704	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;Z)[Ljava/lang/String;
    //   246: astore 7
    //   248: getstatic 27	com/tencent/smtt/sdk/TbsShareManager:b	Ljava/lang/String;
    //   251: ifnull +346 -> 597
    //   254: iload_1
    //   255: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   258: getstatic 27	com/tencent/smtt/sdk/TbsShareManager:b	Ljava/lang/String;
    //   261: invokevirtual 379	com/tencent/smtt/sdk/q:a	(Ljava/lang/String;)I
    //   264: if_icmpne +107 -> 371
    //   267: aload_0
    //   268: iload_1
    //   269: invokestatic 419	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   272: ldc_w 377
    //   275: getstatic 27	com/tencent/smtt/sdk/TbsShareManager:b	Ljava/lang/String;
    //   278: iconst_1
    //   279: invokestatic 419	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   282: invokestatic 425	com/tencent/smtt/sdk/TbsShareManager:writeProperties	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: ldc_w 275
    //   289: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   292: astore 7
    //   294: getstatic 45	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   297: ifne +55 -> 352
    //   300: aload 7
    //   302: ifnull +50 -> 352
    //   305: new 82	com/tencent/smtt/sdk/TbsLinuxToolsJni
    //   308: dup
    //   309: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   312: invokespecial 84	com/tencent/smtt/sdk/TbsLinuxToolsJni:<init>	(Landroid/content/Context;)V
    //   315: astore 8
    //   317: aload 8
    //   319: aload 7
    //   321: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   324: ldc 246
    //   326: invokevirtual 123	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   329: pop
    //   330: aload 8
    //   332: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   335: aload_0
    //   336: invokevirtual 99	com/tencent/smtt/sdk/q:s	(Landroid/content/Context;)Ljava/io/File;
    //   339: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   342: ldc 120
    //   344: invokevirtual 123	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   347: pop
    //   348: iconst_1
    //   349: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   352: ldc_w 680
    //   355: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: goto -304 -> 54
    //   361: astore_0
    //   362: ldc_w 680
    //   365: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: goto -314 -> 54
    //   371: iload_1
    //   372: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   375: getstatic 27	com/tencent/smtt/sdk/TbsShareManager:b	Ljava/lang/String;
    //   378: invokevirtual 379	com/tencent/smtt/sdk/q:a	(Ljava/lang/String;)I
    //   381: if_icmple +216 -> 597
    //   384: aload 7
    //   386: arraylength
    //   387: istore 5
    //   389: iconst_0
    //   390: istore_3
    //   391: iload_3
    //   392: iload 5
    //   394: if_icmpge +203 -> 597
    //   397: aload 7
    //   399: iload_3
    //   400: aaload
    //   401: astore 8
    //   403: iload_1
    //   404: aload_0
    //   405: aload 8
    //   407: invokestatic 415	com/tencent/smtt/sdk/TbsShareManager:getSharedTbsCoreVersion	(Landroid/content/Context;Ljava/lang/String;)I
    //   410: if_icmpne +643 -> 1053
    //   413: aload_0
    //   414: aload 8
    //   416: iconst_1
    //   417: invokestatic 189	com/tencent/smtt/sdk/TbsShareManager:getPackageContext	(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Context;
    //   420: astore 9
    //   422: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   425: aload 9
    //   427: invokevirtual 93	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   430: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   433: astore 8
    //   435: aload_0
    //   436: invokestatic 311	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)I
    //   439: pop
    //   440: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   443: aload 9
    //   445: invokevirtual 191	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;)Z
    //   448: ifeq +605 -> 1053
    //   451: new 108	java/io/File
    //   454: dup
    //   455: getstatic 27	com/tencent/smtt/sdk/TbsShareManager:b	Ljava/lang/String;
    //   458: invokespecial 523	java/io/File:<init>	(Ljava/lang/String;)V
    //   461: astore 7
    //   463: new 108	java/io/File
    //   466: dup
    //   467: aload 8
    //   469: invokespecial 523	java/io/File:<init>	(Ljava/lang/String;)V
    //   472: astore 8
    //   474: new 6	com/tencent/smtt/sdk/TbsShareManager$1
    //   477: dup
    //   478: invokespecial 705	com/tencent/smtt/sdk/TbsShareManager$1:<init>	()V
    //   481: astore 9
    //   483: aload 8
    //   485: aload 7
    //   487: aload 9
    //   489: invokestatic 708	com/tencent/smtt/utils/f:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   492: pop
    //   493: aload_0
    //   494: iload_1
    //   495: invokestatic 419	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   498: ldc_w 377
    //   501: getstatic 27	com/tencent/smtt/sdk/TbsShareManager:b	Ljava/lang/String;
    //   504: iconst_1
    //   505: invokestatic 419	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   508: invokestatic 425	com/tencent/smtt/sdk/TbsShareManager:writeProperties	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload_0
    //   512: ldc_w 275
    //   515: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   518: astore 7
    //   520: getstatic 45	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   523: ifne +55 -> 578
    //   526: aload 7
    //   528: ifnull +50 -> 578
    //   531: new 82	com/tencent/smtt/sdk/TbsLinuxToolsJni
    //   534: dup
    //   535: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   538: invokespecial 84	com/tencent/smtt/sdk/TbsLinuxToolsJni:<init>	(Landroid/content/Context;)V
    //   541: astore 8
    //   543: aload 8
    //   545: aload 7
    //   547: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   550: ldc 246
    //   552: invokevirtual 123	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   555: pop
    //   556: aload 8
    //   558: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   561: aload_0
    //   562: invokevirtual 99	com/tencent/smtt/sdk/q:s	(Landroid/content/Context;)Ljava/io/File;
    //   565: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   568: ldc 120
    //   570: invokevirtual 123	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   573: pop
    //   574: iconst_1
    //   575: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   578: ldc_w 680
    //   581: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   584: goto -530 -> 54
    //   587: astore_0
    //   588: ldc_w 680
    //   591: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   594: goto -540 -> 54
    //   597: aload 7
    //   599: arraylength
    //   600: istore 5
    //   602: iconst_0
    //   603: istore_3
    //   604: iload_3
    //   605: iload 5
    //   607: if_icmpge +441 -> 1048
    //   610: aload 7
    //   612: iload_3
    //   613: aaload
    //   614: astore 8
    //   616: iload_1
    //   617: aload_0
    //   618: aload 8
    //   620: invokestatic 415	com/tencent/smtt/sdk/TbsShareManager:getSharedTbsCoreVersion	(Landroid/content/Context;Ljava/lang/String;)I
    //   623: if_icmpne +200 -> 823
    //   626: aload_0
    //   627: aload 8
    //   629: iconst_1
    //   630: invokestatic 189	com/tencent/smtt/sdk/TbsShareManager:getPackageContext	(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Context;
    //   633: astore 9
    //   635: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   638: aload 9
    //   640: invokevirtual 93	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   643: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   646: astore 10
    //   648: aload_0
    //   649: invokestatic 311	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)I
    //   652: istore 6
    //   654: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   657: aload 9
    //   659: invokevirtual 191	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;)Z
    //   662: ifeq +366 -> 1028
    //   665: aload 8
    //   667: aload_0
    //   668: invokevirtual 306	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   671: invokevirtual 162	android/content/Context:getPackageName	()Ljava/lang/String;
    //   674: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   677: ifne +31 -> 708
    //   680: ldc 73
    //   682: ldc_w 710
    //   685: iload_1
    //   686: invokestatic 321	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   689: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   692: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   698: invokestatic 715	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   701: ldc_w 717
    //   704: iconst_1
    //   705: invokevirtual 720	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   708: aload_0
    //   709: iload_1
    //   710: invokestatic 419	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   713: aload 8
    //   715: aload 10
    //   717: iload 6
    //   719: invokestatic 419	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   722: invokestatic 425	com/tencent/smtt/sdk/TbsShareManager:writeProperties	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   725: aload_0
    //   726: ldc_w 275
    //   729: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   732: astore 7
    //   734: iload 4
    //   736: istore_3
    //   737: getstatic 45	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   740: ifne +61 -> 801
    //   743: iload 4
    //   745: istore_3
    //   746: aload 7
    //   748: ifnull +53 -> 801
    //   751: new 82	com/tencent/smtt/sdk/TbsLinuxToolsJni
    //   754: dup
    //   755: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   758: invokespecial 84	com/tencent/smtt/sdk/TbsLinuxToolsJni:<init>	(Landroid/content/Context;)V
    //   761: astore 8
    //   763: aload 8
    //   765: aload 7
    //   767: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   770: ldc 246
    //   772: invokevirtual 123	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   775: pop
    //   776: aload 8
    //   778: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   781: aload_0
    //   782: invokevirtual 99	com/tencent/smtt/sdk/q:s	(Landroid/content/Context;)Ljava/io/File;
    //   785: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   788: ldc 120
    //   790: invokevirtual 123	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   793: pop
    //   794: iconst_1
    //   795: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   798: iload 4
    //   800: istore_3
    //   801: iload_3
    //   802: ifne +12 -> 814
    //   805: iload_2
    //   806: ifne +8 -> 814
    //   809: aload_0
    //   810: iload_1
    //   811: invokestatic 698	com/tencent/smtt/sdk/TbsShareManager:a	(Landroid/content/Context;I)V
    //   814: ldc_w 680
    //   817: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   820: goto -766 -> 54
    //   823: iload_1
    //   824: aload_0
    //   825: aload 8
    //   827: invokestatic 460	com/tencent/smtt/sdk/TbsShareManager:getCoreShareDecoupleCoreVersion	(Landroid/content/Context;Ljava/lang/String;)I
    //   830: if_icmpne +198 -> 1028
    //   833: aload_0
    //   834: aload 8
    //   836: iconst_1
    //   837: invokestatic 189	com/tencent/smtt/sdk/TbsShareManager:getPackageContext	(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Context;
    //   840: astore 10
    //   842: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   845: aload 10
    //   847: invokevirtual 255	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   850: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   853: astore 9
    //   855: aload_0
    //   856: invokestatic 311	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)I
    //   859: istore 6
    //   861: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   864: aload 10
    //   866: invokevirtual 191	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;)Z
    //   869: ifeq +159 -> 1028
    //   872: aload 8
    //   874: aload_0
    //   875: invokevirtual 306	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   878: invokevirtual 162	android/content/Context:getPackageName	()Ljava/lang/String;
    //   881: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   884: ifne +40 -> 924
    //   887: ldc 73
    //   889: ldc_w 710
    //   892: iload_1
    //   893: invokestatic 321	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   896: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   899: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   902: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   905: aload_0
    //   906: invokevirtual 93	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   909: astore 7
    //   911: aload 7
    //   913: invokestatic 722	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   916: ldc 73
    //   918: ldc_w 724
    //   921: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   924: aload_0
    //   925: iload_1
    //   926: invokestatic 419	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   929: aload 8
    //   931: aload 9
    //   933: iload 6
    //   935: invokestatic 419	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   938: invokestatic 425	com/tencent/smtt/sdk/TbsShareManager:writeProperties	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   941: aload_0
    //   942: ldc_w 275
    //   945: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   948: astore 7
    //   950: iload 4
    //   952: istore_3
    //   953: getstatic 45	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   956: ifne -155 -> 801
    //   959: iload 4
    //   961: istore_3
    //   962: aload 7
    //   964: ifnull -163 -> 801
    //   967: new 82	com/tencent/smtt/sdk/TbsLinuxToolsJni
    //   970: dup
    //   971: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   974: invokespecial 84	com/tencent/smtt/sdk/TbsLinuxToolsJni:<init>	(Landroid/content/Context;)V
    //   977: astore 8
    //   979: aload 8
    //   981: aload 7
    //   983: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   986: ldc 246
    //   988: invokevirtual 123	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   991: pop
    //   992: aload 8
    //   994: invokestatic 89	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   997: aload_0
    //   998: invokevirtual 99	com/tencent/smtt/sdk/q:s	(Landroid/content/Context;)Ljava/io/File;
    //   1001: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1004: ldc 120
    //   1006: invokevirtual 123	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   1009: pop
    //   1010: iconst_1
    //   1011: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   1014: iload 4
    //   1016: istore_3
    //   1017: goto -216 -> 801
    //   1020: astore 7
    //   1022: iload 4
    //   1024: istore_3
    //   1025: goto -224 -> 801
    //   1028: iload_3
    //   1029: iconst_1
    //   1030: iadd
    //   1031: istore_3
    //   1032: goto -428 -> 604
    //   1035: astore 7
    //   1037: goto -113 -> 924
    //   1040: astore 7
    //   1042: iload 4
    //   1044: istore_3
    //   1045: goto -244 -> 801
    //   1048: iconst_0
    //   1049: istore_3
    //   1050: goto -249 -> 801
    //   1053: iload_3
    //   1054: iconst_1
    //   1055: iadd
    //   1056: istore_3
    //   1057: goto -666 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1060	0	paramContext	Context
    //   0	1060	1	paramInt	int
    //   0	1060	2	paramBoolean	boolean
    //   62	995	3	m	int
    //   1	1042	4	n	int
    //   387	221	5	i1	int
    //   652	282	6	i2	int
    //   246	736	7	localObject1	Object
    //   1020	1	7	localObject2	Object
    //   1035	1	7	localObject3	Object
    //   1040	1	7	localObject4	Object
    //   315	678	8	localObject5	Object
    //   420	512	9	localObject6	Object
    //   646	219	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   6	27	103	finally
    //   31	54	103	finally
    //   58	78	103	finally
    //   82	100	103	finally
    //   114	121	103	finally
    //   125	130	103	finally
    //   130	153	103	finally
    //   161	184	103	finally
    //   187	210	103	finally
    //   215	238	103	finally
    //   241	285	103	finally
    //   352	358	103	finally
    //   362	368	103	finally
    //   371	389	103	finally
    //   403	483	103	finally
    //   578	584	103	finally
    //   588	594	103	finally
    //   597	602	103	finally
    //   616	708	103	finally
    //   708	725	103	finally
    //   809	814	103	finally
    //   814	820	103	finally
    //   823	911	103	finally
    //   924	941	103	finally
    //   285	300	361	finally
    //   305	352	361	finally
    //   483	526	587	finally
    //   531	578	587	finally
    //   941	950	1020	finally
    //   953	959	1020	finally
    //   967	1014	1020	finally
    //   911	924	1035	finally
    //   725	734	1040	finally
    //   737	743	1040	finally
    //   751	798	1040	finally
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: ldc_w 725
    //   6: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 73
    //   11: new 101	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 727
    //   18: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 729
    //   28: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 731
    //   38: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_3
    //   42: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: ldc 73
    //   53: new 101	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 733
    //   60: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: new 127	java/lang/Throwable
    //   66: dup
    //   67: ldc_w 442
    //   70: invokespecial 443	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   73: invokestatic 171	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   76: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 80	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: ldc_w 275
    //   89: invokestatic 278	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   92: astore_0
    //   93: aload_0
    //   94: ifnonnull +22 -> 116
    //   97: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   100: invokestatic 689	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   103: sipush -405
    //   106: invokevirtual 692	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   109: ldc_w 725
    //   112: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: new 280	java/io/BufferedInputStream
    //   119: dup
    //   120: new 282	java/io/FileInputStream
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore 7
    //   133: new 290	java/util/Properties
    //   136: dup
    //   137: invokespecial 291	java/util/Properties:<init>	()V
    //   140: astore 8
    //   142: aload 8
    //   144: aload 7
    //   146: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   149: aload_1
    //   150: invokestatic 622	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   153: istore 6
    //   155: iload 6
    //   157: istore 5
    //   159: iload 5
    //   161: ifeq +111 -> 272
    //   164: aload 8
    //   166: ldc_w 617
    //   169: aload_1
    //   170: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   173: pop
    //   174: aload 8
    //   176: ldc_w 296
    //   179: ldc_w 298
    //   182: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   185: pop
    //   186: aload 8
    //   188: ldc_w 313
    //   191: aload_2
    //   192: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   195: pop
    //   196: aload 8
    //   198: ldc_w 315
    //   201: aload_3
    //   202: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   205: pop
    //   206: aload 8
    //   208: ldc_w 317
    //   211: aload 4
    //   213: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   216: pop
    //   217: new 323	java/io/BufferedOutputStream
    //   220: dup
    //   221: new 325	java/io/FileOutputStream
    //   224: dup
    //   225: aload_0
    //   226: invokespecial 326	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   229: invokespecial 329	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   232: astore_0
    //   233: aload 8
    //   235: aload_0
    //   236: aconst_null
    //   237: invokevirtual 333	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   240: iconst_0
    //   241: putstatic 51	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   244: getstatic 143	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   247: invokestatic 689	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   250: sipush -406
    //   253: invokevirtual 692	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   256: aload 7
    //   258: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   261: aload_0
    //   262: invokevirtual 337	java/io/BufferedOutputStream:close	()V
    //   265: ldc_w 725
    //   268: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: return
    //   272: aload 8
    //   274: ldc_w 296
    //   277: ldc_w 735
    //   280: invokevirtual 302	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   283: pop
    //   284: goto -67 -> 217
    //   287: astore_0
    //   288: aconst_null
    //   289: astore_0
    //   290: aload 7
    //   292: astore_1
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 336	java/io/BufferedInputStream:close	()V
    //   301: aload_0
    //   302: ifnull +7 -> 309
    //   305: aload_0
    //   306: invokevirtual 337	java/io/BufferedOutputStream:close	()V
    //   309: ldc_w 725
    //   312: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: return
    //   316: astore_0
    //   317: ldc_w 725
    //   320: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: return
    //   324: astore_0
    //   325: ldc_w 725
    //   328: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: return
    //   332: astore 9
    //   334: goto -175 -> 159
    //   337: astore_1
    //   338: goto -77 -> 261
    //   341: astore_1
    //   342: goto -41 -> 301
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_0
    //   348: aconst_null
    //   349: astore_1
    //   350: goto -57 -> 293
    //   353: astore_1
    //   354: aload 7
    //   356: astore_1
    //   357: goto -64 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramContext	Context
    //   0	360	1	paramString1	String
    //   0	360	2	paramString2	String
    //   0	360	3	paramString3	String
    //   0	360	4	paramString4	String
    //   1	159	5	m	int
    //   153	3	6	n	int
    //   131	224	7	localBufferedInputStream	java.io.BufferedInputStream
    //   140	133	8	localProperties	java.util.Properties
    //   332	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   133	149	287	finally
    //   149	155	287	finally
    //   164	217	287	finally
    //   217	233	287	finally
    //   272	284	287	finally
    //   261	265	316	java/lang/Exception
    //   305	309	324	java/lang/Exception
    //   149	155	332	java/lang/Exception
    //   256	261	337	java/lang/Exception
    //   297	301	341	java/lang/Exception
    //   85	93	345	finally
    //   97	109	345	finally
    //   116	133	345	finally
    //   233	256	353	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */