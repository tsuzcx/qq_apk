package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TbsShareManager
{
  private static Context a;
  private static boolean b;
  private static String c = null;
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
    AppMethodBeat.i(64580);
    b(paramContext, paramBoolean);
    int m = e;
    AppMethodBeat.o(64580);
    return m;
  }
  
  static String a()
  {
    return d;
  }
  
  static void a(Context paramContext)
  {
    AppMethodBeat.i(64568);
    TbsLog.i("TbsShareManager", "shareTbsCore #1");
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      a(paramContext, localTbsLinuxToolsJni, ao.a().q(paramContext));
      paramContext = ao.a().r(paramContext);
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + paramContext.getAbsolutePath());
      localTbsLinuxToolsJni.a(paramContext.getAbsolutePath(), "755");
      AppMethodBeat.o(64568);
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + paramContext.getMessage() + " ## " + paramContext.getCause());
      AppMethodBeat.o(64568);
    }
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(64589);
    if (!TbsPVConfig.getInstance(a).isDisableHostBackupCore())
    {
      String str1 = paramContext.getPackageName();
      TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
      int m = 0;
      while (m < 5)
      {
        String str2 = new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", str1 }[m];
        Object localObject;
        if (paramInt == getBackupCoreVersion(paramContext, str2))
        {
          localObject = getPackageContext(paramContext, str2, false);
          if (ao.a().f((Context)localObject))
          {
            localObject = getBackupCoreFile(paramContext, str2);
            if (a.a(paramContext, (File)localObject, 0L, paramInt))
            {
              TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + paramInt + " packageName is " + str2);
              ao.a().a(paramContext, (File)localObject, paramInt);
              AppMethodBeat.o(64589);
            }
          }
        }
        else if (paramInt == getBackupDecoupleCoreVersion(paramContext, str2))
        {
          localObject = getPackageContext(paramContext, str2, false);
          if (ao.a().f((Context)localObject))
          {
            localObject = getBackupDecoupleCoreFile(paramContext, str2);
            if (a.a(paramContext, (File)localObject, 0L, paramInt))
            {
              TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + paramInt + " packageName is " + str2);
              ao.a().a(paramContext, (File)localObject, paramInt);
              AppMethodBeat.o(64589);
              return;
            }
          }
        }
        m += 1;
      }
    }
    AppMethodBeat.o(64589);
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    AppMethodBeat.i(64570);
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      AppMethodBeat.o(64570);
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
    AppMethodBeat.o(64570);
  }
  
  static void b(Context paramContext)
  {
    AppMethodBeat.i(64569);
    try
    {
      a(paramContext, new TbsLinuxToolsJni(paramContext), ao.a().p(paramContext));
      AppMethodBeat.o(64569);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(64569);
    }
  }
  
  static boolean b(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(64598);
    if (i(paramContext))
    {
      AppMethodBeat.o(64598);
      return true;
    }
    if (paramBoolean) {
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    AppMethodBeat.o(64598);
    return false;
  }
  
  static String c(Context paramContext)
  {
    AppMethodBeat.i(64578);
    j(paramContext);
    paramContext = d;
    AppMethodBeat.o(64578);
    return paramContext;
  }
  
  /* Error */
  private static void c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 262
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 264
    //   10: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore 5
    //   15: aload 5
    //   17: ifnonnull +10 -> 27
    //   20: ldc_w 262
    //   23: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: new 269	java/io/BufferedInputStream
    //   30: dup
    //   31: new 271	java/io/FileInputStream
    //   34: dup
    //   35: aload 5
    //   37: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 277	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_3
    //   44: new 279	java/util/Properties
    //   47: dup
    //   48: invokespecial 280	java/util/Properties:<init>	()V
    //   51: astore 4
    //   53: aload 4
    //   55: aload_3
    //   56: invokevirtual 283	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   59: aload 4
    //   61: ldc_w 285
    //   64: ldc_w 287
    //   67: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   70: pop
    //   71: iload_1
    //   72: ifeq +64 -> 136
    //   75: invokestatic 85	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   78: aload_0
    //   79: invokevirtual 89	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   82: invokevirtual 107	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   85: astore 6
    //   87: aload_0
    //   88: invokevirtual 295	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   91: invokevirtual 152	android/content/Context:getPackageName	()Ljava/lang/String;
    //   94: astore 7
    //   96: aload_0
    //   97: invokestatic 300	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   100: istore_2
    //   101: aload 4
    //   103: ldc_w 302
    //   106: aload 7
    //   108: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   111: pop
    //   112: aload 4
    //   114: ldc_w 304
    //   117: aload 6
    //   119: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   122: pop
    //   123: aload 4
    //   125: ldc_w 306
    //   128: iload_2
    //   129: invokestatic 310	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   132: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   135: pop
    //   136: new 312	java/io/BufferedOutputStream
    //   139: dup
    //   140: new 314	java/io/FileOutputStream
    //   143: dup
    //   144: aload 5
    //   146: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   149: invokespecial 318	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   152: astore_0
    //   153: aload 4
    //   155: aload_0
    //   156: aconst_null
    //   157: invokevirtual 322	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   160: aload_3
    //   161: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   164: aload_0
    //   165: invokevirtual 326	java/io/BufferedOutputStream:close	()V
    //   168: ldc_w 262
    //   171: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: astore_0
    //   176: ldc_w 262
    //   179: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore_0
    //   184: aconst_null
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   196: aload_0
    //   197: ifnull +7 -> 204
    //   200: aload_0
    //   201: invokevirtual 326	java/io/BufferedOutputStream:close	()V
    //   204: ldc_w 262
    //   207: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: return
    //   211: astore_0
    //   212: ldc_w 262
    //   215: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: return
    //   219: astore_0
    //   220: aconst_null
    //   221: astore_3
    //   222: aconst_null
    //   223: astore 4
    //   225: aload 4
    //   227: ifnull +8 -> 235
    //   230: aload 4
    //   232: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 326	java/io/BufferedOutputStream:close	()V
    //   243: ldc_w 262
    //   246: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload_0
    //   250: athrow
    //   251: astore_3
    //   252: goto -88 -> 164
    //   255: astore_3
    //   256: goto -60 -> 196
    //   259: astore 4
    //   261: goto -26 -> 235
    //   264: astore_3
    //   265: goto -22 -> 243
    //   268: astore_0
    //   269: aconst_null
    //   270: astore 5
    //   272: aload_3
    //   273: astore 4
    //   275: aload 5
    //   277: astore_3
    //   278: goto -53 -> 225
    //   281: astore 5
    //   283: aload_0
    //   284: astore 6
    //   286: aload_3
    //   287: astore 4
    //   289: aload 5
    //   291: astore_0
    //   292: aload 6
    //   294: astore_3
    //   295: goto -70 -> 225
    //   298: astore_0
    //   299: aconst_null
    //   300: astore_0
    //   301: goto -113 -> 188
    //   304: astore 4
    //   306: goto -118 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramContext	Context
    //   0	309	1	paramBoolean	boolean
    //   100	29	2	m	int
    //   43	197	3	localBufferedInputStream	java.io.BufferedInputStream
    //   251	1	3	localException1	Exception
    //   255	1	3	localException2	Exception
    //   264	9	3	localException3	Exception
    //   277	18	3	localObject1	Object
    //   51	180	4	localProperties	java.util.Properties
    //   259	1	4	localException4	Exception
    //   273	15	4	localObject2	Object
    //   304	1	4	localThrowable	Throwable
    //   13	263	5	localFile	File
    //   281	9	5	localObject3	Object
    //   85	208	6	localObject4	Object
    //   94	13	7	str	String
    // Exception table:
    //   from	to	target	type
    //   164	168	175	java/lang/Exception
    //   6	15	183	java/lang/Throwable
    //   27	44	183	java/lang/Throwable
    //   200	204	211	java/lang/Exception
    //   6	15	219	finally
    //   27	44	219	finally
    //   160	164	251	java/lang/Exception
    //   192	196	255	java/lang/Exception
    //   230	235	259	java/lang/Exception
    //   239	243	264	java/lang/Exception
    //   44	71	268	finally
    //   75	136	268	finally
    //   136	153	268	finally
    //   153	160	281	finally
    //   44	71	298	java/lang/Throwable
    //   75	136	298	java/lang/Throwable
    //   136	153	298	java/lang/Throwable
    //   153	160	304	java/lang/Throwable
  }
  
  static int d(Context paramContext)
  {
    AppMethodBeat.i(64579);
    int m = a(paramContext, true);
    AppMethodBeat.o(64579);
    return m;
  }
  
  private static String[] d(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(64588);
    String[] arrayOfString;
    if (QbSdk.getOnlyDownload())
    {
      arrayOfString = new String[1];
      arrayOfString[0] = paramContext.getApplicationContext().getPackageName();
    }
    for (;;)
    {
      AppMethodBeat.o(64588);
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
    AppMethodBeat.i(64581);
    j(paramContext);
    Object localObject1 = localObject2;
    if (f != null)
    {
      localObject1 = getPackageContext(paramContext, f, true);
      if (ao.a().f((Context)localObject1)) {
        break label68;
      }
      localObject1 = localObject2;
    }
    label68:
    for (;;)
    {
      if (c != null)
      {
        paramContext = a;
        AppMethodBeat.o(64581);
        return paramContext;
      }
      AppMethodBeat.o(64581);
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
    //   5: ldc_w 341
    //   8: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc_w 264
    //   15: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +16 -> 36
    //   23: ldc_w 341
    //   26: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_2
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: new 269	java/io/BufferedInputStream
    //   39: dup
    //   40: new 271	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 277	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_0
    //   52: new 279	java/util/Properties
    //   55: dup
    //   56: invokespecial 280	java/util/Properties:<init>	()V
    //   59: astore_3
    //   60: aload_3
    //   61: aload_0
    //   62: invokevirtual 283	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   65: aload_3
    //   66: ldc_w 302
    //   69: ldc_w 343
    //   72: invokevirtual 347	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_3
    //   76: ldc_w 343
    //   79: aload_3
    //   80: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: istore_1
    //   84: iload_1
    //   85: ifne +18 -> 103
    //   88: aload_0
    //   89: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   92: ldc_w 341
    //   95: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_3
    //   99: astore_0
    //   100: goto -69 -> 31
    //   103: aload_0
    //   104: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   107: ldc_w 341
    //   110: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: astore_0
    //   115: goto -84 -> 31
    //   118: astore_0
    //   119: ldc 2
    //   121: monitorexit
    //   122: aload_0
    //   123: athrow
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   135: ldc_w 341
    //   138: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_2
    //   142: astore_0
    //   143: goto -112 -> 31
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   157: ldc_w 341
    //   160: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_2
    //   164: athrow
    //   165: astore_0
    //   166: goto -74 -> 92
    //   169: astore_0
    //   170: goto -63 -> 107
    //   173: astore_0
    //   174: goto -39 -> 135
    //   177: astore_0
    //   178: goto -21 -> 157
    //   181: astore_2
    //   182: goto -33 -> 149
    //   185: astore_3
    //   186: goto -59 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramContext	Context
    //   83	2	1	bool	boolean
    //   1	141	2	localObject1	Object
    //   146	18	2	localObject2	Object
    //   181	1	2	localObject3	Object
    //   59	40	3	localObject4	Object
    //   185	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	11	118	finally
    //   23	29	118	finally
    //   88	92	118	finally
    //   92	98	118	finally
    //   103	107	118	finally
    //   107	113	118	finally
    //   131	135	118	finally
    //   135	141	118	finally
    //   153	157	118	finally
    //   157	165	118	finally
    //   11	19	124	java/lang/Throwable
    //   36	52	124	java/lang/Throwable
    //   11	19	146	finally
    //   36	52	146	finally
    //   88	92	165	java/lang/Exception
    //   103	107	169	java/lang/Exception
    //   131	135	173	java/lang/Exception
    //   153	157	177	java/lang/Exception
    //   52	84	181	finally
    //   52	84	185	java/lang/Throwable
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    AppMethodBeat.i(64584);
    n(paramContext);
    TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
    if (f == null) {
      TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
    }
    int m;
    if ((f != null) && (f.equals("AppDefined")))
    {
      if (e != ao.a().a(c))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + ao.a().a(c));
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
      AppMethodBeat.o(64584);
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
    return false;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean) {}
  
  static String g(Context paramContext)
  {
    AppMethodBeat.i(64592);
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
        AppMethodBeat.o(64592);
        return null;
      }
      paramContext = new StringBuilder(d);
      paramContext.append(File.separator);
      paramContext.append("res.apk");
      paramContext = paramContext.toString();
      AppMethodBeat.o(64592);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(paramContext));
      AppMethodBeat.o(64592);
    }
    return null;
  }
  
  public static File getBackupCoreFile(Context paramContext, String paramString)
  {
    AppMethodBeat.i(64576);
    try
    {
      paramContext = new File(new File(k.a(getPackageContext(paramContext, paramString, false), 4)), "x5.tbs.org");
      boolean bool = paramContext.exists();
      if (bool)
      {
        AppMethodBeat.o(64576);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(64576);
    }
    return null;
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(64574);
    try
    {
      paramContext = new File(new File(k.a(getPackageContext(paramContext, paramString, false), 4)), "x5.tbs.org");
      if (paramContext.exists())
      {
        int m = a.b(paramContext);
        AppMethodBeat.o(64574);
        return m;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(64574);
    }
    return 0;
  }
  
  public static File getBackupDecoupleCoreFile(Context paramContext, String paramString)
  {
    AppMethodBeat.i(64577);
    try
    {
      paramContext = new File(new File(k.a(getPackageContext(paramContext, paramString, true), 4)), "x5.tbs.decouple");
      boolean bool = paramContext.exists();
      if (bool)
      {
        AppMethodBeat.o(64577);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(64577);
    }
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(64575);
    try
    {
      paramContext = new File(new File(k.a(getPackageContext(paramContext, paramString, false), 4)), "x5.tbs.decouple");
      if (paramContext.exists())
      {
        int m = a.b(paramContext);
        AppMethodBeat.o(64575);
        return m;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(64575);
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
    return new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone" };
  }
  
  public static int getCoreShareDecoupleCoreVersion(Context paramContext, String paramString)
  {
    return 0;
  }
  
  public static String getHostCorePathAppDefined()
  {
    return c;
  }
  
  public static long getHostCoreVersions(Context paramContext)
  {
    AppMethodBeat.i(64572);
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
    AppMethodBeat.o(64572);
    return l2;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(64599);
    if (paramBoolean) {}
    try
    {
      if ((!paramContext.getPackageName().equals(paramString)) && (TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray()))
      {
        TbsLog.i("TbsShareManager", "gray no core app,skip get context");
        AppMethodBeat.o(64599);
        return null;
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      AppMethodBeat.o(64599);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(64599);
      return null;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(64599);
    }
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(64573);
    paramContext = getPackageContext(paramContext, paramString, true);
    if (paramContext != null)
    {
      int m = ao.a().i(paramContext);
      AppMethodBeat.o(64573);
      return m;
    }
    AppMethodBeat.o(64573);
    return 0;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    AppMethodBeat.i(64595);
    paramContext = ao.a().r(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(64595);
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists())
    {
      AppMethodBeat.o(64595);
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      AppMethodBeat.o(64595);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      AppMethodBeat.o(64595);
    }
    return null;
  }
  
  /* Error */
  static int h(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 474
    //   8: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: ldc 69
    //   13: ldc_w 476
    //   16: invokestatic 76	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: ldc_w 264
    //   23: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnonnull +22 -> 50
    //   31: ldc 69
    //   33: ldc_w 478
    //   36: invokestatic 76	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc_w 474
    //   42: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: iload_1
    //   49: ireturn
    //   50: new 269	java/io/BufferedInputStream
    //   53: dup
    //   54: new 271	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 277	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore_0
    //   66: new 279	java/util/Properties
    //   69: dup
    //   70: invokespecial 280	java/util/Properties:<init>	()V
    //   73: astore_2
    //   74: aload_2
    //   75: aload_0
    //   76: invokevirtual 283	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   79: aload_2
    //   80: ldc_w 480
    //   83: ldc_w 343
    //   86: invokevirtual 347	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: astore_2
    //   90: ldc_w 343
    //   93: aload_2
    //   94: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifne +39 -> 136
    //   100: ldc 69
    //   102: ldc_w 482
    //   105: invokestatic 76	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_2
    //   109: invokestatic 487	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   112: iconst_0
    //   113: invokestatic 493	java/lang/Math:max	(II)I
    //   116: istore_1
    //   117: aload_0
    //   118: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   121: ldc_w 474
    //   124: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: goto -82 -> 45
    //   130: astore_0
    //   131: ldc 2
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    //   136: ldc 69
    //   138: ldc_w 495
    //   141: invokestatic 76	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   148: ldc_w 474
    //   151: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: goto -109 -> 45
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_0
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   168: ldc 69
    //   170: ldc_w 497
    //   173: invokestatic 76	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: bipush 254
    //   178: istore_1
    //   179: ldc_w 474
    //   182: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: goto -140 -> 45
    //   188: astore_2
    //   189: aconst_null
    //   190: astore_0
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   199: ldc_w 474
    //   202: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_2
    //   206: athrow
    //   207: astore_0
    //   208: goto -87 -> 121
    //   211: astore_0
    //   212: goto -64 -> 148
    //   215: astore_0
    //   216: goto -48 -> 168
    //   219: astore_0
    //   220: goto -21 -> 199
    //   223: astore_2
    //   224: goto -33 -> 191
    //   227: astore_2
    //   228: goto -68 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramContext	Context
    //   1	178	1	m	int
    //   73	36	2	localObject1	Object
    //   188	18	2	localObject2	Object
    //   223	1	2	localObject3	Object
    //   227	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	19	130	finally
    //   39	45	130	finally
    //   117	121	130	finally
    //   121	127	130	finally
    //   144	148	130	finally
    //   148	154	130	finally
    //   164	168	130	finally
    //   168	176	130	finally
    //   179	185	130	finally
    //   195	199	130	finally
    //   199	207	130	finally
    //   19	27	157	java/lang/Throwable
    //   31	39	157	java/lang/Throwable
    //   50	66	157	java/lang/Throwable
    //   19	27	188	finally
    //   31	39	188	finally
    //   50	66	188	finally
    //   117	121	207	java/lang/Exception
    //   144	148	211	java/lang/Exception
    //   164	168	215	java/lang/Exception
    //   195	199	219	java/lang/Exception
    //   66	117	223	finally
    //   136	144	223	finally
    //   66	117	227	java/lang/Throwable
    //   136	144	227	java/lang/Throwable
  }
  
  static boolean i(Context paramContext)
  {
    AppMethodBeat.i(64596);
    try
    {
      if (e == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (e == 0)
      {
        TbsLog.addLog(994, null, new Object[0]);
        AppMethodBeat.o(64596);
        return false;
      }
      int m;
      int n;
      if (c == null)
      {
        if (e != 0)
        {
          m = getSharedTbsCoreVersion(paramContext, f);
          n = e;
          if (m == n)
          {
            AppMethodBeat.o(64596);
            return true;
          }
        }
      }
      else if (e != 0)
      {
        m = ao.a().a(c);
        n = e;
        if (m == n)
        {
          AppMethodBeat.o(64596);
          return true;
        }
      }
      boolean bool = l(paramContext);
      if (bool)
      {
        AppMethodBeat.o(64596);
        return true;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 418, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(paramContext, f) + "; getHostCoreVersions is " + getHostCoreVersions(paramContext)));
      d = null;
      e = 0;
      TbsLog.addLog(993, null, new Object[0]);
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      AppMethodBeat.o(64596);
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.addLog(992, null, new Object[0]);
      AppMethodBeat.o(64596);
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    AppMethodBeat.i(64571);
    try
    {
      if ((a != null) && (a.equals(paramContext.getApplicationContext())))
      {
        boolean bool = b;
        AppMethodBeat.o(64571);
        return bool;
      }
      paramContext = paramContext.getApplicationContext();
      a = paramContext;
      paramContext = paramContext.getPackageName();
      String[] arrayOfString = getCoreProviderAppList();
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        if (paramContext.equals(arrayOfString[m]))
        {
          b = false;
          AppMethodBeat.o(64571);
          return false;
        }
        m += 1;
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      b = true;
      AppMethodBeat.o(64571);
    }
  }
  
  static boolean j(Context paramContext)
  {
    AppMethodBeat.i(64597);
    boolean bool = b(paramContext, true);
    AppMethodBeat.o(64597);
    return bool;
  }
  
  private static boolean k(Context paramContext)
  {
    AppMethodBeat.i(64582);
    if (f == null)
    {
      AppMethodBeat.o(64582);
      return false;
    }
    if (e == getSharedTbsCoreVersion(paramContext, f))
    {
      AppMethodBeat.o(64582);
      return true;
    }
    AppMethodBeat.o(64582);
    return false;
  }
  
  private static boolean l(Context paramContext)
  {
    AppMethodBeat.i(64583);
    if (QbSdk.getOnlyDownload())
    {
      AppMethodBeat.o(64583);
      return false;
    }
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    int m = 0;
    while (m < n)
    {
      String str = arrayOfString[m];
      if ((e > 0) && (e == getSharedTbsCoreVersion(paramContext, str)))
      {
        Context localContext = getPackageContext(paramContext, str, true);
        if (ao.a().f(paramContext))
        {
          d = ao.a().b(paramContext, localContext).getAbsolutePath();
          f = str;
          AppMethodBeat.o(64583);
          return true;
        }
      }
      m += 1;
    }
    AppMethodBeat.o(64583);
    return false;
  }
  
  private static boolean m(Context paramContext)
  {
    AppMethodBeat.i(64585);
    if (paramContext == null)
    {
      AppMethodBeat.o(64585);
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    AppMethodBeat.o(64585);
    return true;
  }
  
  /* Error */
  private static void n(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 548
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 45	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   9: ifeq +10 -> 19
    //   12: ldc_w 548
    //   15: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: ldc 2
    //   21: monitorenter
    //   22: getstatic 45	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   25: ifeq +13 -> 38
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc_w 548
    //   34: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: aload_0
    //   39: ldc_w 264
    //   42: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   45: astore_0
    //   46: aload_0
    //   47: ifnonnull +13 -> 60
    //   50: ldc 2
    //   52: monitorexit
    //   53: ldc_w 548
    //   56: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: new 269	java/io/BufferedInputStream
    //   63: dup
    //   64: new 271	java/io/FileInputStream
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: invokespecial 277	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: astore_0
    //   76: new 279	java/util/Properties
    //   79: dup
    //   80: invokespecial 280	java/util/Properties:<init>	()V
    //   83: astore_1
    //   84: aload_1
    //   85: aload_0
    //   86: invokevirtual 283	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   89: aload_1
    //   90: ldc_w 480
    //   93: ldc_w 343
    //   96: invokevirtual 347	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: astore_2
    //   100: ldc_w 343
    //   103: aload_2
    //   104: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +60 -> 167
    //   110: aload_2
    //   111: invokestatic 487	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: iconst_0
    //   115: invokestatic 493	java/lang/Math:max	(II)I
    //   118: putstatic 31	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   121: ldc 69
    //   123: new 97	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 550
    //   130: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: getstatic 31	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   136: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: ldc_w 552
    //   142: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: new 66	java/lang/Throwable
    //   148: dup
    //   149: ldc_w 554
    //   152: invokespecial 523	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   155: invokestatic 161	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   158: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 76	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_1
    //   168: ldc_w 302
    //   171: ldc_w 343
    //   174: invokevirtual 347	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: ldc_w 343
    //   181: aload_2
    //   182: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: ifne +7 -> 192
    //   188: aload_2
    //   189: putstatic 33	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   192: getstatic 33	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   195: ifnull +28 -> 223
    //   198: getstatic 137	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   201: ifnull +22 -> 223
    //   204: getstatic 33	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   207: getstatic 137	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   210: invokevirtual 152	android/content/Context:getPackageName	()Ljava/lang/String;
    //   213: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   216: ifeq +91 -> 307
    //   219: iconst_1
    //   220: putstatic 43	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   223: aload_1
    //   224: ldc_w 304
    //   227: ldc_w 343
    //   230: invokevirtual 347	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   233: astore_2
    //   234: ldc_w 343
    //   237: aload_2
    //   238: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifne +7 -> 248
    //   244: aload_2
    //   245: putstatic 29	com/tencent/smtt/sdk/TbsShareManager:d	Ljava/lang/String;
    //   248: aload_1
    //   249: ldc_w 306
    //   252: ldc_w 343
    //   255: invokevirtual 347	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   258: astore_2
    //   259: ldc_w 343
    //   262: aload_2
    //   263: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifne +7 -> 273
    //   269: aload_2
    //   270: putstatic 41	com/tencent/smtt/sdk/TbsShareManager:j	Ljava/lang/String;
    //   273: aload_1
    //   274: ldc_w 285
    //   277: ldc_w 287
    //   280: invokevirtual 347	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   283: invokestatic 559	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   286: putstatic 35	com/tencent/smtt/sdk/TbsShareManager:g	Z
    //   289: iconst_1
    //   290: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   293: aload_0
    //   294: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   297: ldc 2
    //   299: monitorexit
    //   300: ldc_w 548
    //   303: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: return
    //   307: iconst_0
    //   308: putstatic 43	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   311: goto -88 -> 223
    //   314: astore_1
    //   315: aload_0
    //   316: ifnull -19 -> 297
    //   319: aload_0
    //   320: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   323: goto -26 -> 297
    //   326: astore_0
    //   327: goto -30 -> 297
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_1
    //   333: aload_1
    //   334: ifnull +7 -> 341
    //   337: aload_1
    //   338: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   341: ldc_w 548
    //   344: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload_0
    //   348: athrow
    //   349: astore_0
    //   350: ldc 2
    //   352: monitorexit
    //   353: ldc_w 548
    //   356: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: aload_0
    //   360: athrow
    //   361: astore_0
    //   362: goto -65 -> 297
    //   365: astore_1
    //   366: goto -25 -> 341
    //   369: astore_1
    //   370: aload_0
    //   371: astore_2
    //   372: aload_1
    //   373: astore_0
    //   374: aload_2
    //   375: astore_1
    //   376: goto -43 -> 333
    //   379: astore_0
    //   380: aconst_null
    //   381: astore_0
    //   382: goto -67 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramContext	Context
    //   83	191	1	localProperties	java.util.Properties
    //   314	1	1	localThrowable	Throwable
    //   332	6	1	localObject1	Object
    //   365	1	1	localException	Exception
    //   369	4	1	localObject2	Object
    //   375	1	1	localObject3	Object
    //   99	276	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   76	167	314	java/lang/Throwable
    //   167	192	314	java/lang/Throwable
    //   192	223	314	java/lang/Throwable
    //   223	248	314	java/lang/Throwable
    //   248	273	314	java/lang/Throwable
    //   273	293	314	java/lang/Throwable
    //   307	311	314	java/lang/Throwable
    //   319	323	326	java/lang/Exception
    //   38	46	330	finally
    //   60	76	330	finally
    //   22	31	349	finally
    //   50	53	349	finally
    //   293	297	349	finally
    //   297	300	349	finally
    //   319	323	349	finally
    //   337	341	349	finally
    //   341	349	349	finally
    //   350	353	349	finally
    //   293	297	361	java/lang/Exception
    //   337	341	365	java/lang/Exception
    //   76	167	369	finally
    //   167	192	369	finally
    //   192	223	369	finally
    //   223	248	369	finally
    //   248	273	369	finally
    //   273	293	369	finally
    //   307	311	369	finally
    //   38	46	379	java/lang/Throwable
    //   60	76	379	java/lang/Throwable
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    c = paramString;
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int n = 1;
    int m;
    label156:
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64587);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is ".concat(String.valueOf(paramInt)));
        if (paramInt == 0)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
          AppMethodBeat.o(64587);
          return;
        }
        m = h(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is ".concat(String.valueOf(m)));
        if (m < 0)
        {
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
          AppMethodBeat.o(64587);
          continue;
        }
        if (paramInt != m) {
          break label156;
        }
      }
      finally {}
      if ((d(paramContext) == 0) && (!paramBoolean)) {
        a(paramContext, paramInt);
      }
      c(paramContext, paramBoolean);
      TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
      AppMethodBeat.o(64587);
      continue;
      if (paramInt < m)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
        AppMethodBeat.o(64587);
      }
      else
      {
        m = ao.a().i(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is ".concat(String.valueOf(m)));
        if (paramInt < m)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
          AppMethodBeat.o(64587);
        }
        else
        {
          localObject1 = d(paramContext, paramBoolean);
          if (c == null) {
            break label597;
          }
          if (paramInt != ao.a().a(c)) {
            break;
          }
          writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
          try
          {
            localObject1 = getTbsShareFile(paramContext, "core_info");
            if ((!i) && (localObject1 != null))
            {
              localObject2 = new TbsLinuxToolsJni(a);
              ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
              ((TbsLinuxToolsJni)localObject2).a(ao.a().r(paramContext).getAbsolutePath(), "755");
              i = true;
            }
            AppMethodBeat.o(64587);
          }
          catch (Throwable paramContext)
          {
            AppMethodBeat.o(64587);
          }
        }
      }
    }
    int i1;
    if (paramInt > ao.a().a(c))
    {
      i1 = localObject1.length;
      m = 0;
    }
    for (;;)
    {
      Object localObject3;
      for (;;)
      {
        if (m >= i1) {
          break label597;
        }
        localObject2 = localObject1[m];
        if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject2)) {
          break label857;
        }
        localObject3 = getPackageContext(paramContext, (String)localObject2, true);
        localObject2 = ao.a().q((Context)localObject3).getAbsolutePath();
        b.b(paramContext);
        if (!ao.a().f((Context)localObject3)) {
          break label857;
        }
        localObject1 = new File(c);
        localObject2 = new File((String)localObject2);
        localObject3 = new bf();
        try
        {
          k.a((File)localObject2, (File)localObject1, (FileFilter)localObject3);
          writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
          localObject1 = getTbsShareFile(paramContext, "core_info");
          if ((!i) && (localObject1 != null))
          {
            localObject2 = new TbsLinuxToolsJni(a);
            ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
            ((TbsLinuxToolsJni)localObject2).a(ao.a().r(paramContext).getAbsolutePath(), "755");
            i = true;
          }
          AppMethodBeat.o(64587);
        }
        catch (Throwable paramContext)
        {
          AppMethodBeat.o(64587);
        }
      }
      break;
      label597:
      i1 = localObject1.length;
      m = 0;
      int i2;
      if (m < i1)
      {
        localObject2 = localObject1[m];
        if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject2))
        {
          Context localContext = getPackageContext(paramContext, (String)localObject2, true);
          localObject3 = ao.a().q(localContext).getAbsolutePath();
          i2 = b.b(paramContext);
          if (ao.a().f(localContext)) {
            if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
            {
              TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:".concat(String.valueOf(paramInt)));
              localObject1 = ao.a().q(paramContext);
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          k.b((File)localObject1);
          TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
          writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, (String)localObject3, Integer.toString(i2));
          try
          {
            localObject1 = getTbsShareFile(paramContext, "core_info");
            m = n;
            if (!i)
            {
              m = n;
              if (localObject1 != null)
              {
                localObject2 = new TbsLinuxToolsJni(a);
                ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject2).a(ao.a().r(paramContext).getAbsolutePath(), "755");
                i = true;
                m = n;
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            m = n;
            continue;
          }
          if ((m == 0) && (!paramBoolean)) {
            a(paramContext, paramInt);
          }
          AppMethodBeat.o(64587);
          break;
          m += 1;
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        m = 0;
      }
      label857:
      m += 1;
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: ldc_w 606
    //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 69
    //   11: new 97	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 608
    //   18: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 610
    //   28: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 612
    //   38: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_3
    //   42: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 76	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: ldc 69
    //   53: new 97	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 614
    //   60: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: new 66	java/lang/Throwable
    //   66: dup
    //   67: ldc_w 554
    //   70: invokespecial 523	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   73: invokestatic 161	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   76: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 76	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: ldc_w 264
    //   89: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   92: astore_0
    //   93: aload_0
    //   94: ifnonnull +22 -> 116
    //   97: getstatic 137	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   100: invokestatic 576	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   103: sipush -405
    //   106: invokevirtual 579	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   109: ldc_w 606
    //   112: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: new 269	java/io/BufferedInputStream
    //   119: dup
    //   120: new 271	java/io/FileInputStream
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 277	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore 7
    //   133: new 279	java/util/Properties
    //   136: dup
    //   137: invokespecial 280	java/util/Properties:<init>	()V
    //   140: astore 8
    //   142: aload 8
    //   144: aload 7
    //   146: invokevirtual 283	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   149: aload_1
    //   150: invokestatic 487	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   153: istore 6
    //   155: iload 6
    //   157: istore 5
    //   159: iload 5
    //   161: ifeq +111 -> 272
    //   164: aload 8
    //   166: ldc_w 480
    //   169: aload_1
    //   170: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   173: pop
    //   174: aload 8
    //   176: ldc_w 285
    //   179: ldc_w 287
    //   182: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   185: pop
    //   186: aload 8
    //   188: ldc_w 302
    //   191: aload_2
    //   192: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   195: pop
    //   196: aload 8
    //   198: ldc_w 304
    //   201: aload_3
    //   202: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   205: pop
    //   206: aload 8
    //   208: ldc_w 306
    //   211: aload 4
    //   213: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   216: pop
    //   217: new 312	java/io/BufferedOutputStream
    //   220: dup
    //   221: new 314	java/io/FileOutputStream
    //   224: dup
    //   225: aload_0
    //   226: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   229: invokespecial 318	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   232: astore_0
    //   233: aload 8
    //   235: aload_0
    //   236: aconst_null
    //   237: invokevirtual 322	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   240: iconst_0
    //   241: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   244: getstatic 137	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   247: invokestatic 576	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   250: sipush -406
    //   253: invokevirtual 579	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   256: aload 7
    //   258: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   261: aload_0
    //   262: invokevirtual 326	java/io/BufferedOutputStream:close	()V
    //   265: ldc_w 606
    //   268: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: return
    //   272: aload 8
    //   274: ldc_w 285
    //   277: ldc_w 616
    //   280: invokevirtual 291	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   283: pop
    //   284: goto -67 -> 217
    //   287: astore_0
    //   288: aconst_null
    //   289: astore_0
    //   290: aload 7
    //   292: ifnull +8 -> 300
    //   295: aload 7
    //   297: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   300: aload_0
    //   301: ifnull +7 -> 308
    //   304: aload_0
    //   305: invokevirtual 326	java/io/BufferedOutputStream:close	()V
    //   308: ldc_w 606
    //   311: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: return
    //   315: astore_0
    //   316: ldc_w 606
    //   319: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: return
    //   323: astore_0
    //   324: ldc_w 606
    //   327: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: return
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_1
    //   334: aconst_null
    //   335: astore 7
    //   337: aload 7
    //   339: ifnull +8 -> 347
    //   342: aload 7
    //   344: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   347: aload_1
    //   348: ifnull +7 -> 355
    //   351: aload_1
    //   352: invokevirtual 326	java/io/BufferedOutputStream:close	()V
    //   355: ldc_w 606
    //   358: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: aload_0
    //   362: athrow
    //   363: astore 9
    //   365: goto -206 -> 159
    //   368: astore_1
    //   369: goto -108 -> 261
    //   372: astore_1
    //   373: goto -73 -> 300
    //   376: astore_2
    //   377: goto -30 -> 347
    //   380: astore_1
    //   381: goto -26 -> 355
    //   384: astore_0
    //   385: aconst_null
    //   386: astore_1
    //   387: goto -50 -> 337
    //   390: astore_1
    //   391: aload_0
    //   392: astore_2
    //   393: aload_1
    //   394: astore_0
    //   395: aload_2
    //   396: astore_1
    //   397: goto -60 -> 337
    //   400: astore_0
    //   401: aconst_null
    //   402: astore_0
    //   403: aconst_null
    //   404: astore 7
    //   406: goto -116 -> 290
    //   409: astore_1
    //   410: goto -120 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramContext	Context
    //   0	413	1	paramString1	String
    //   0	413	2	paramString2	String
    //   0	413	3	paramString3	String
    //   0	413	4	paramString4	String
    //   1	159	5	m	int
    //   153	3	6	n	int
    //   131	274	7	localBufferedInputStream	java.io.BufferedInputStream
    //   140	133	8	localProperties	java.util.Properties
    //   363	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   133	149	287	java/lang/Throwable
    //   149	155	287	java/lang/Throwable
    //   164	217	287	java/lang/Throwable
    //   217	233	287	java/lang/Throwable
    //   272	284	287	java/lang/Throwable
    //   261	265	315	java/lang/Exception
    //   304	308	323	java/lang/Exception
    //   85	93	331	finally
    //   97	109	331	finally
    //   116	133	331	finally
    //   149	155	363	java/lang/Exception
    //   256	261	368	java/lang/Exception
    //   295	300	372	java/lang/Exception
    //   342	347	376	java/lang/Exception
    //   351	355	380	java/lang/Exception
    //   133	149	384	finally
    //   149	155	384	finally
    //   164	217	384	finally
    //   217	233	384	finally
    //   272	284	384	finally
    //   233	256	390	finally
    //   85	93	400	java/lang/Throwable
    //   97	109	400	java/lang/Throwable
    //   116	133	400	java/lang/Throwable
    //   233	256	409	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */