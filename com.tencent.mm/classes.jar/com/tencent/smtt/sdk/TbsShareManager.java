package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
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
  private static String i = null;
  private static boolean j = false;
  private static boolean k = false;
  public static boolean mHasQueryed = false;
  
  static int a(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, paramBoolean);
    return e;
  }
  
  static String a()
  {
    return d;
  }
  
  static void a(Context paramContext)
  {
    TbsLog.i("TbsShareManager", "shareTbsCore #1");
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      a(paramContext, localTbsLinuxToolsJni, an.a().r(paramContext));
      paramContext = an.a().s(paramContext);
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + paramContext.getAbsolutePath());
      localTbsLinuxToolsJni.a(paramContext.getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + paramContext.getMessage() + " ## " + paramContext.getCause());
    }
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + paramFile.getAbsolutePath());
    paramTbsLinuxToolsJni.a(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int n = paramFile.length;
    int m = 0;
    label72:
    File localFile;
    if (m < n)
    {
      localFile = paramFile[m];
      if (!localFile.isFile()) {
        break label138;
      }
      if (localFile.getAbsolutePath().indexOf(".so") <= 0) {
        break label123;
      }
      paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "755");
    }
    for (;;)
    {
      m += 1;
      break label72;
      break;
      label123:
      paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "644");
      continue;
      label138:
      if (localFile.isDirectory()) {
        a(paramContext, paramTbsLinuxToolsJni, localFile);
      } else {
        TbsLog.e("TbsShareManager", "unknown file type.", true);
      }
    }
  }
  
  static void b(Context paramContext)
  {
    try
    {
      a(paramContext, new TbsLinuxToolsJni(paramContext), an.a().q(paramContext));
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  static boolean b(Context paramContext, boolean paramBoolean)
  {
    if (i(paramContext)) {
      return true;
    }
    if (paramBoolean) {
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    return false;
  }
  
  static String c(Context paramContext)
  {
    j(paramContext);
    return d;
  }
  
  /* Error */
  private static void c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 174
    //   3: invokestatic 178	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +28 -> 38
    //   13: iconst_0
    //   14: ifeq +11 -> 25
    //   17: new 180	java/lang/NullPointerException
    //   20: dup
    //   21: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   24: athrow
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 180	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: return
    //   38: new 183	java/io/BufferedInputStream
    //   41: dup
    //   42: new 185	java/io/FileInputStream
    //   45: dup
    //   46: aload 5
    //   48: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_3
    //   55: new 193	java/util/Properties
    //   58: dup
    //   59: invokespecial 194	java/util/Properties:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: aload_3
    //   67: invokevirtual 197	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload 4
    //   72: ldc 199
    //   74: ldc 201
    //   76: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   79: pop
    //   80: iload_1
    //   81: ifeq +61 -> 142
    //   84: invokestatic 72	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   87: aload_0
    //   88: invokevirtual 76	com/tencent/smtt/sdk/an:r	(Landroid/content/Context;)Ljava/io/File;
    //   91: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   94: astore 6
    //   96: aload_0
    //   97: invokevirtual 211	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   100: invokevirtual 214	android/content/Context:getPackageName	()Ljava/lang/String;
    //   103: astore 7
    //   105: aload_0
    //   106: invokestatic 219	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   109: istore_2
    //   110: aload 4
    //   112: ldc 221
    //   114: aload 7
    //   116: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   119: pop
    //   120: aload 4
    //   122: ldc 223
    //   124: aload 6
    //   126: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   129: pop
    //   130: aload 4
    //   132: ldc 225
    //   134: iload_2
    //   135: invokestatic 229	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   141: pop
    //   142: new 231	java/io/BufferedOutputStream
    //   145: dup
    //   146: new 233	java/io/FileOutputStream
    //   149: dup
    //   150: aload 5
    //   152: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: invokespecial 237	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: astore_0
    //   159: aload 4
    //   161: aload_0
    //   162: aconst_null
    //   163: invokevirtual 241	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   174: aload_0
    //   175: ifnull -138 -> 37
    //   178: aload_0
    //   179: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   182: return
    //   183: astore_0
    //   184: return
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_3
    //   188: aconst_null
    //   189: astore 4
    //   191: aload 4
    //   193: ifnull +8 -> 201
    //   196: aload 4
    //   198: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   201: aload_3
    //   202: ifnull +7 -> 209
    //   205: aload_3
    //   206: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   209: aload_0
    //   210: athrow
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_0
    //   214: aconst_null
    //   215: astore_3
    //   216: aload_3
    //   217: ifnull +7 -> 224
    //   220: aload_3
    //   221: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   224: aload_0
    //   225: ifnull -188 -> 37
    //   228: aload_0
    //   229: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   232: return
    //   233: astore_3
    //   234: goto -10 -> 224
    //   237: astore 4
    //   239: goto -38 -> 201
    //   242: astore_3
    //   243: goto -34 -> 209
    //   246: astore_0
    //   247: goto -222 -> 25
    //   250: astore_3
    //   251: goto -77 -> 174
    //   254: astore_0
    //   255: aconst_null
    //   256: astore 5
    //   258: aload_3
    //   259: astore 4
    //   261: aload 5
    //   263: astore_3
    //   264: goto -73 -> 191
    //   267: astore 5
    //   269: aload_0
    //   270: astore 6
    //   272: aload_3
    //   273: astore 4
    //   275: aload 5
    //   277: astore_0
    //   278: aload 6
    //   280: astore_3
    //   281: goto -90 -> 191
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_0
    //   287: goto -71 -> 216
    //   290: astore 4
    //   292: goto -76 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramContext	Context
    //   0	295	1	paramBoolean	boolean
    //   109	26	2	m	int
    //   54	167	3	localBufferedInputStream	java.io.BufferedInputStream
    //   233	1	3	localException1	Exception
    //   242	1	3	localException2	Exception
    //   250	9	3	localException3	Exception
    //   263	18	3	localObject1	Object
    //   62	135	4	localProperties	java.util.Properties
    //   237	1	4	localException4	Exception
    //   259	15	4	localObject2	Object
    //   290	1	4	localThrowable	Throwable
    //   6	256	5	localFile	File
    //   267	9	5	localObject3	Object
    //   94	185	6	localObject4	Object
    //   103	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   29	37	183	java/lang/Exception
    //   178	182	183	java/lang/Exception
    //   228	232	183	java/lang/Exception
    //   0	8	185	finally
    //   38	55	185	finally
    //   0	8	211	java/lang/Throwable
    //   38	55	211	java/lang/Throwable
    //   220	224	233	java/lang/Exception
    //   196	201	237	java/lang/Exception
    //   205	209	242	java/lang/Exception
    //   17	25	246	java/lang/Exception
    //   170	174	250	java/lang/Exception
    //   55	80	254	finally
    //   84	142	254	finally
    //   142	159	254	finally
    //   159	166	267	finally
    //   55	80	284	java/lang/Throwable
    //   84	142	284	java/lang/Throwable
    //   142	159	284	java/lang/Throwable
    //   159	166	290	java/lang/Throwable
  }
  
  static int d(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  static Context e(Context paramContext)
  {
    j(paramContext);
    if (f != null)
    {
      paramContext = getPackageContext(paramContext, f);
      if (an.a().f(paramContext)) {}
    }
    else
    {
      return null;
    }
    return paramContext;
  }
  
  /* Error */
  static String f(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 174
    //   6: invokestatic 178	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +22 -> 33
    //   14: iconst_0
    //   15: ifeq +11 -> 26
    //   18: new 180	java/lang/NullPointerException
    //   21: dup
    //   22: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   25: athrow
    //   26: aconst_null
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: new 183	java/io/BufferedInputStream
    //   36: dup
    //   37: new 185	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_2
    //   49: new 193	java/util/Properties
    //   52: dup
    //   53: invokespecial 194	java/util/Properties:<init>	()V
    //   56: astore_0
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 197	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   62: aload_0
    //   63: ldc 221
    //   65: ldc_w 256
    //   68: invokevirtual 260	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_3
    //   72: ldc_w 256
    //   75: aload_3
    //   76: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: istore_1
    //   80: iload_1
    //   81: ifne +24 -> 105
    //   84: aload_3
    //   85: astore_0
    //   86: aload_2
    //   87: ifnull -59 -> 28
    //   90: aload_2
    //   91: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   94: aload_3
    //   95: astore_0
    //   96: goto -68 -> 28
    //   99: astore_0
    //   100: aload_3
    //   101: astore_0
    //   102: goto -74 -> 28
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -87 -> 28
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   129: aload_0
    //   130: athrow
    //   131: astore_0
    //   132: ldc 2
    //   134: monitorexit
    //   135: aload_0
    //   136: athrow
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   148: aconst_null
    //   149: astore_0
    //   150: goto -122 -> 28
    //   153: astore_0
    //   154: goto -6 -> 148
    //   157: astore_2
    //   158: goto -29 -> 129
    //   161: astore_0
    //   162: goto -136 -> 26
    //   165: astore_0
    //   166: goto -53 -> 113
    //   169: astore_0
    //   170: goto -49 -> 121
    //   173: astore_0
    //   174: aload_2
    //   175: astore_0
    //   176: goto -36 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramContext	Context
    //   79	2	1	bool	boolean
    //   48	78	2	localBufferedInputStream	java.io.BufferedInputStream
    //   157	18	2	localException	Exception
    //   71	30	3	str	String
    // Exception table:
    //   from	to	target	type
    //   90	94	99	java/lang/Exception
    //   3	10	118	finally
    //   33	49	118	finally
    //   18	26	131	finally
    //   90	94	131	finally
    //   109	113	131	finally
    //   125	129	131	finally
    //   129	131	131	finally
    //   144	148	131	finally
    //   3	10	137	java/lang/Throwable
    //   33	49	137	java/lang/Throwable
    //   144	148	153	java/lang/Exception
    //   125	129	157	java/lang/Exception
    //   18	26	161	java/lang/Exception
    //   109	113	165	java/lang/Exception
    //   49	80	169	finally
    //   49	80	173	java/lang/Throwable
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    n(paramContext);
    TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
    if (f == null) {
      TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
    }
    int m;
    if ((f != null) && (f.equals("AppDefined")))
    {
      if (e != an.a().a(c))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + an.a().a(c));
      }
      if (e > 0)
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        if ((!"com.tencent.android.qqdownloader".equals(localApplicationInfo.packageName)) && (!"com.jd.jrapp".equals(localApplicationInfo.packageName))) {
          break label275;
        }
        m = 1;
        label192:
        if (m != 0) {
          break label280;
        }
      }
    }
    label275:
    label280:
    for (boolean bool = QbSdk.a(paramContext, e);; bool = false)
    {
      if ((bool) || (g))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
      }
      return e;
      if ((k(paramContext)) || (l(paramContext))) {
        break;
      }
      e = 0;
      d = null;
      f = null;
      TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
      break;
      m = 0;
      break label192;
    }
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    return false;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean) {}
  
  static String g(Context paramContext)
  {
    try
    {
      n(paramContext);
      if (d != null)
      {
        if (TextUtils.isEmpty(d)) {
          return null;
        }
        paramContext = new StringBuilder(d);
        paramContext.append(File.separator);
        paramContext.append("res.apk");
        return paramContext.toString();
      }
    }
    catch (Throwable paramContext)
    {
      new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(paramContext));
    }
    return null;
  }
  
  public static File getBackupCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(j.a(getPackageContext(paramContext, paramString), 4)), "x5.tbs.org");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    try
    {
      int m = a.b(new File(new File(j.a(getPackageContext(paramContext, paramString), 4)), "x5.tbs.org"));
      return m;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static File getBackupDecoupleCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(j.a(getPackageContext(paramContext, paramString), 4)), "x5.tbs.decouple");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    try
    {
      int m = a.b(new File(new File(j.a(getPackageContext(paramContext, paramString), 4)), "x5.tbs.decouple"));
      return m;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static boolean getCoreDisabled()
  {
    return g;
  }
  
  public static boolean getCoreFormOwn()
  {
    return j;
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
    return l2;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      return null;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString);
    if (paramContext != null) {
      return an.a().j(paramContext);
    }
    return 0;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = an.a().s(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists()) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  /* Error */
  static int h(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 56
    //   9: ldc_w 402
    //   12: invokestatic 63	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: ldc 174
    //   18: invokestatic 178	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnonnull +32 -> 55
    //   26: ldc 56
    //   28: ldc_w 404
    //   31: invokestatic 63	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: iload_2
    //   35: istore_1
    //   36: iconst_0
    //   37: ifeq +13 -> 50
    //   40: iload_3
    //   41: istore_1
    //   42: new 180	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: ldc 2
    //   52: monitorexit
    //   53: iload_1
    //   54: ireturn
    //   55: new 183	java/io/BufferedInputStream
    //   58: dup
    //   59: new 185	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_0
    //   71: new 193	java/util/Properties
    //   74: dup
    //   75: invokespecial 194	java/util/Properties:<init>	()V
    //   78: astore 4
    //   80: aload 4
    //   82: aload_0
    //   83: invokevirtual 197	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   86: aload 4
    //   88: ldc_w 406
    //   91: ldc_w 256
    //   94: invokevirtual 260	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 4
    //   99: ldc_w 256
    //   102: aload 4
    //   104: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +42 -> 149
    //   110: ldc 56
    //   112: ldc_w 408
    //   115: invokestatic 63	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 4
    //   120: invokestatic 413	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   123: iconst_0
    //   124: invokestatic 419	java/lang/Math:max	(II)I
    //   127: istore_2
    //   128: iload_2
    //   129: istore_1
    //   130: aload_0
    //   131: ifnull -81 -> 50
    //   134: iload_2
    //   135: istore_1
    //   136: aload_0
    //   137: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   140: iload_2
    //   141: istore_1
    //   142: goto -92 -> 50
    //   145: astore_0
    //   146: goto -96 -> 50
    //   149: ldc 56
    //   151: ldc_w 421
    //   154: invokestatic 63	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: iload_2
    //   158: istore_1
    //   159: aload_0
    //   160: ifnull -110 -> 50
    //   163: iload_3
    //   164: istore_1
    //   165: aload_0
    //   166: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   169: iload_2
    //   170: istore_1
    //   171: goto -121 -> 50
    //   174: astore_0
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    //   180: astore 4
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   192: aload 4
    //   194: athrow
    //   195: astore_0
    //   196: aconst_null
    //   197: astore_0
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   206: ldc 56
    //   208: ldc_w 423
    //   211: invokestatic 63	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: bipush 254
    //   216: istore_1
    //   217: goto -167 -> 50
    //   220: astore_0
    //   221: goto -15 -> 206
    //   224: astore_0
    //   225: goto -33 -> 192
    //   228: astore 4
    //   230: goto -46 -> 184
    //   233: astore 4
    //   235: goto -37 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramContext	Context
    //   35	182	1	m	int
    //   3	167	2	n	int
    //   1	163	3	i1	int
    //   78	41	4	localObject1	Object
    //   180	13	4	localObject2	Object
    //   228	1	4	localObject3	Object
    //   233	1	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   42	50	145	java/lang/Exception
    //   136	140	145	java/lang/Exception
    //   165	169	145	java/lang/Exception
    //   7	15	174	finally
    //   42	50	174	finally
    //   136	140	174	finally
    //   165	169	174	finally
    //   188	192	174	finally
    //   192	195	174	finally
    //   202	206	174	finally
    //   206	214	174	finally
    //   15	22	180	finally
    //   26	34	180	finally
    //   55	71	180	finally
    //   15	22	195	java/lang/Throwable
    //   26	34	195	java/lang/Throwable
    //   55	71	195	java/lang/Throwable
    //   202	206	220	java/lang/Exception
    //   188	192	224	java/lang/Exception
    //   71	128	228	finally
    //   149	157	228	finally
    //   71	128	233	java/lang/Throwable
    //   149	157	233	java/lang/Throwable
  }
  
  static boolean i(Context paramContext)
  {
    try
    {
      if (e == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (e == 0)
      {
        TbsLog.addLog(994, null, new Object[0]);
        return false;
      }
      if (c == null)
      {
        if ((e != 0) && (getSharedTbsCoreVersion(paramContext, f) == e)) {
          return true;
        }
      }
      else if ((e != 0) && (an.a().a(c) == e)) {
        return true;
      }
      if (l(paramContext)) {
        return true;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 418, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(paramContext, f) + "; getHostCoreVersions is " + getHostCoreVersions(paramContext)));
      d = null;
      e = 0;
      TbsLog.addLog(993, null, new Object[0]);
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.addLog(992, null, new Object[0]);
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    for (;;)
    {
      int m;
      try
      {
        if ((a != null) && (a.equals(paramContext.getApplicationContext()))) {
          return b;
        }
        paramContext = paramContext.getApplicationContext();
        a = paramContext;
        paramContext = paramContext.getPackageName();
        String[] arrayOfString = getCoreProviderAppList();
        int n = arrayOfString.length;
        m = 0;
        if (m < n)
        {
          if (!paramContext.equals(arrayOfString[m])) {
            break label74;
          }
          b = false;
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        b = true;
        return true;
      }
      label74:
      m += 1;
    }
  }
  
  static boolean j(Context paramContext)
  {
    return b(paramContext, true);
  }
  
  private static boolean k(Context paramContext)
  {
    if (f == null) {}
    while (e != getSharedTbsCoreVersion(paramContext, f)) {
      return false;
    }
    return true;
  }
  
  private static boolean l(Context paramContext)
  {
    if (QbSdk.getOnlyDownload()) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = getCoreProviderAppList();
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        if ((e > 0) && (e == getSharedTbsCoreVersion(paramContext, str)))
        {
          Context localContext = getPackageContext(paramContext, str);
          if (an.a().f(paramContext))
          {
            d = an.a().b(paramContext, localContext).getAbsolutePath();
            f = str;
            return true;
          }
        }
        m += 1;
      }
    }
  }
  
  private static boolean m(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  /* Error */
  private static void n(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 42	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: ldc 174
    //   18: invokestatic 178	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnonnull +19 -> 42
    //   26: iconst_0
    //   27: ifeq -16 -> 11
    //   30: new 180	java/lang/NullPointerException
    //   33: dup
    //   34: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   37: athrow
    //   38: astore_0
    //   39: goto -28 -> 11
    //   42: new 183	java/io/BufferedInputStream
    //   45: dup
    //   46: new 185	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_0
    //   58: new 193	java/util/Properties
    //   61: dup
    //   62: invokespecial 194	java/util/Properties:<init>	()V
    //   65: astore_2
    //   66: aload_2
    //   67: aload_0
    //   68: invokevirtual 197	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   71: aload_2
    //   72: ldc_w 406
    //   75: ldc_w 256
    //   78: invokevirtual 260	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_3
    //   82: ldc_w 256
    //   85: aload_3
    //   86: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +60 -> 149
    //   92: aload_3
    //   93: invokestatic 413	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   96: iconst_0
    //   97: invokestatic 419	java/lang/Math:max	(II)I
    //   100: putstatic 30	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   103: ldc 56
    //   105: new 84	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 475
    //   112: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: getstatic 30	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   118: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc_w 477
    //   124: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: new 54	java/lang/Throwable
    //   130: dup
    //   131: ldc_w 479
    //   134: invokespecial 449	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   137: invokestatic 335	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 63	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_2
    //   150: ldc 221
    //   152: ldc_w 256
    //   155: invokevirtual 260	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore_3
    //   159: ldc_w 256
    //   162: aload_3
    //   163: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifne +7 -> 173
    //   169: aload_3
    //   170: putstatic 32	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   173: getstatic 32	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   176: ifnull +28 -> 204
    //   179: getstatic 457	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   182: ifnull +22 -> 204
    //   185: getstatic 32	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   188: getstatic 457	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   191: invokevirtual 214	android/content/Context:getPackageName	()Ljava/lang/String;
    //   194: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifeq +90 -> 287
    //   200: iconst_1
    //   201: putstatic 40	com/tencent/smtt/sdk/TbsShareManager:j	Z
    //   204: aload_2
    //   205: ldc 223
    //   207: ldc_w 256
    //   210: invokevirtual 260	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   213: astore_3
    //   214: ldc_w 256
    //   217: aload_3
    //   218: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +7 -> 228
    //   224: aload_3
    //   225: putstatic 28	com/tencent/smtt/sdk/TbsShareManager:d	Ljava/lang/String;
    //   228: aload_2
    //   229: ldc 225
    //   231: ldc_w 256
    //   234: invokevirtual 260	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   237: astore_3
    //   238: ldc_w 256
    //   241: aload_3
    //   242: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   245: ifne +7 -> 252
    //   248: aload_3
    //   249: putstatic 38	com/tencent/smtt/sdk/TbsShareManager:i	Ljava/lang/String;
    //   252: aload_2
    //   253: ldc 199
    //   255: ldc 201
    //   257: invokevirtual 260	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   260: invokestatic 484	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   263: putstatic 34	com/tencent/smtt/sdk/TbsShareManager:g	Z
    //   266: iconst_1
    //   267: putstatic 42	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   270: aload_0
    //   271: ifnull -260 -> 11
    //   274: aload_0
    //   275: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   278: goto -267 -> 11
    //   281: astore_0
    //   282: ldc 2
    //   284: monitorexit
    //   285: aload_0
    //   286: athrow
    //   287: iconst_0
    //   288: putstatic 40	com/tencent/smtt/sdk/TbsShareManager:j	Z
    //   291: goto -87 -> 204
    //   294: astore_2
    //   295: aload_0
    //   296: ifnull -285 -> 11
    //   299: aload_0
    //   300: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   303: goto -292 -> 11
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_2
    //   309: aload_2
    //   310: ifnull +7 -> 317
    //   313: aload_2
    //   314: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   317: aload_0
    //   318: athrow
    //   319: astore_2
    //   320: goto -3 -> 317
    //   323: astore_3
    //   324: aload_0
    //   325: astore_2
    //   326: aload_3
    //   327: astore_0
    //   328: goto -19 -> 309
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_0
    //   334: goto -39 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramContext	Context
    //   6	2	1	bool	boolean
    //   65	188	2	localProperties	java.util.Properties
    //   294	1	2	localThrowable	Throwable
    //   308	6	2	localObject1	Object
    //   319	1	2	localException	Exception
    //   325	1	2	localContext	Context
    //   81	168	3	str	String
    //   323	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	38	38	java/lang/Exception
    //   274	278	38	java/lang/Exception
    //   299	303	38	java/lang/Exception
    //   3	7	281	finally
    //   30	38	281	finally
    //   274	278	281	finally
    //   299	303	281	finally
    //   313	317	281	finally
    //   317	319	281	finally
    //   58	149	294	java/lang/Throwable
    //   149	173	294	java/lang/Throwable
    //   173	204	294	java/lang/Throwable
    //   204	228	294	java/lang/Throwable
    //   228	252	294	java/lang/Throwable
    //   252	270	294	java/lang/Throwable
    //   287	291	294	java/lang/Throwable
    //   15	22	306	finally
    //   42	58	306	finally
    //   313	317	319	java/lang/Exception
    //   58	149	323	finally
    //   149	173	323	finally
    //   173	204	323	finally
    //   204	228	323	finally
    //   228	252	323	finally
    //   252	270	323	finally
    //   287	291	323	finally
    //   15	22	331	java/lang/Throwable
    //   42	58	331	java/lang/Throwable
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    c = paramString;
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int n = 0;
    int i1 = 1;
    for (;;)
    {
      try
      {
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is " + paramInt);
        if (paramInt == 0)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
          return;
        }
        m = h(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is " + m);
        if (m < 0)
        {
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
          continue;
        }
        if (paramInt != m) {
          break label133;
        }
      }
      finally {}
      c(paramContext, paramBoolean);
      TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
      continue;
      label133:
      if (paramInt < m)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
      }
      else
      {
        m = an.a().j(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is " + m);
        if (paramInt >= m) {
          break;
        }
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
      }
    }
    Object localObject1;
    if (QbSdk.getOnlyDownload()) {
      localObject1 = new String[] { paramContext.getApplicationContext().getPackageName() };
    }
    label235:
    Object localObject2;
    label373:
    Object localObject3;
    for (;;)
    {
      for (;;)
      {
        if (c == null) {
          break label592;
        }
        if (paramInt != an.a().a(c)) {
          break label373;
        }
        writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
        try
        {
          localObject1 = getTbsShareFile(paramContext, "core_info");
          if ((h) || (localObject1 == null)) {
            break;
          }
          localObject2 = new TbsLinuxToolsJni(a);
          ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
          ((TbsLinuxToolsJni)localObject2).a(an.a().s(paramContext).getAbsolutePath(), "755");
          h = true;
        }
        catch (Throwable paramContext) {}
      }
      break;
      localObject1 = getCoreProviderAppList();
      if (!paramBoolean) {
        break label1112;
      }
      localObject1 = new String[] { paramContext.getApplicationContext().getPackageName() };
      continue;
      if (paramInt > an.a().a(c))
      {
        i2 = localObject1.length;
        m = 0;
        for (;;)
        {
          for (;;)
          {
            if (m >= i2) {
              break label592;
            }
            localObject2 = localObject1[m];
            if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject2)) {
              break label585;
            }
            localObject3 = getPackageContext(paramContext, (String)localObject2);
            localObject2 = an.a().r((Context)localObject3).getAbsolutePath();
            b.b(paramContext);
            if (!an.a().f((Context)localObject3)) {
              break label585;
            }
            localObject1 = new File(c);
            localObject2 = new File((String)localObject2);
            localObject3 = new bc();
            try
            {
              j.a((File)localObject2, (File)localObject1, (FileFilter)localObject3);
              writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
              localObject1 = getTbsShareFile(paramContext, "core_info");
              if ((h) || (localObject1 == null)) {
                break;
              }
              localObject2 = new TbsLinuxToolsJni(a);
              ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
              ((TbsLinuxToolsJni)localObject2).a(an.a().s(paramContext).getAbsolutePath(), "755");
              h = true;
            }
            catch (Throwable paramContext) {}
          }
          break;
          label585:
          m += 1;
        }
      }
    }
    label592:
    int i2 = localObject1.length;
    int m = 0;
    for (;;)
    {
      Object localObject4;
      int i3;
      if (m < i2)
      {
        localObject2 = localObject1[m];
        if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject2)) {
          break label1115;
        }
        localObject4 = getPackageContext(paramContext, (String)localObject2);
        localObject3 = an.a().r((Context)localObject4).getAbsolutePath();
        i3 = b.b(paramContext);
        if (!an.a().f((Context)localObject4)) {
          break label1115;
        }
        if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
        {
          TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + paramInt);
          localObject4 = an.a().r(paramContext);
        }
      }
      for (;;)
      {
        try
        {
          j.b((File)localObject4);
          TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
          writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, (String)localObject3, Integer.toString(i3));
          try
          {
            localObject2 = getTbsShareFile(paramContext, "core_info");
            m = i1;
            if (!h)
            {
              m = i1;
              if (localObject2 != null)
              {
                localObject3 = new TbsLinuxToolsJni(a);
                ((TbsLinuxToolsJni)localObject3).a(((File)localObject2).getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject3).a(an.a().s(paramContext).getAbsolutePath(), "755");
                h = true;
                m = i1;
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            m = i1;
            continue;
          }
          paramBoolean = TbsExtensionFunctionManager.getInstance().canUseFunction(a, "disable_use_host_backup_core.txt");
          QbSdk.mDisableUseHostBackupCore = paramBoolean;
          if ((paramBoolean) || (m != 0)) {
            break;
          }
          TbsLog.i("TbsShareManager", "find host backup core to unzip #1");
          i1 = localObject1.length;
          m = n;
          if (m >= i1) {
            break;
          }
          localObject2 = localObject1[m];
          if (paramInt == getBackupCoreVersion(paramContext, (String)localObject2))
          {
            localObject3 = getPackageContext(paramContext, (String)localObject2);
            if (!an.a().f((Context)localObject3)) {
              continue;
            }
            localObject3 = getBackupCoreFile(paramContext, (String)localObject2);
            if (!a.a(paramContext, (File)localObject3, 0L, paramInt)) {
              continue;
            }
            TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + paramInt + " packageName is " + (String)localObject2);
            if (!an.a().a(paramContext, (File)localObject3)) {
              break;
            }
            an.a().a(paramContext, paramInt);
            an.a().b(paramContext, true);
            break;
          }
          if (paramInt == getBackupDecoupleCoreVersion(paramContext, (String)localObject2))
          {
            localObject3 = getPackageContext(paramContext, (String)localObject2);
            if (an.a().f((Context)localObject3))
            {
              localObject3 = getBackupDecoupleCoreFile(paramContext, (String)localObject2);
              if (a.a(paramContext, (File)localObject3, 0L, paramInt))
              {
                TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + paramInt + " packageName is " + (String)localObject2);
                if (!an.a().a(paramContext, (File)localObject3)) {
                  break;
                }
                an.a().a(paramContext, paramInt);
                an.a().b(paramContext, true);
                break;
              }
            }
          }
          m += 1;
          continue;
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        m = 0;
      }
      label1112:
      break label235;
      label1115:
      m += 1;
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc 56
    //   5: new 84	java/lang/StringBuilder
    //   8: dup
    //   9: ldc_w 563
    //   12: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 565
    //   22: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 567
    //   32: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 63	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc 56
    //   47: new 84	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 569
    //   54: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: new 54	java/lang/Throwable
    //   60: dup
    //   61: ldc_w 479
    //   64: invokespecial 449	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   67: invokestatic 335	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   70: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 63	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: ldc 174
    //   82: invokestatic 178	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnonnull +40 -> 127
    //   90: getstatic 457	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   93: invokestatic 496	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   96: sipush -405
    //   99: invokevirtual 500	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   102: iconst_0
    //   103: ifeq +11 -> 114
    //   106: new 180	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: iconst_0
    //   115: ifeq +11 -> 126
    //   118: new 180	java/lang/NullPointerException
    //   121: dup
    //   122: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   125: athrow
    //   126: return
    //   127: new 183	java/io/BufferedInputStream
    //   130: dup
    //   131: new 185	java/io/FileInputStream
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   142: astore 7
    //   144: new 193	java/util/Properties
    //   147: dup
    //   148: invokespecial 194	java/util/Properties:<init>	()V
    //   151: astore 8
    //   153: aload 8
    //   155: aload 7
    //   157: invokevirtual 197	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   160: aload_1
    //   161: invokestatic 413	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   164: istore 5
    //   166: iload 5
    //   168: ifeq +111 -> 279
    //   171: aload 8
    //   173: ldc_w 406
    //   176: aload_1
    //   177: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   180: pop
    //   181: aload 8
    //   183: ldc 199
    //   185: ldc 201
    //   187: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   190: pop
    //   191: aload 8
    //   193: ldc 221
    //   195: aload_2
    //   196: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   199: pop
    //   200: aload 8
    //   202: ldc 223
    //   204: aload_3
    //   205: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   208: pop
    //   209: aload 8
    //   211: ldc 225
    //   213: aload 4
    //   215: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   218: pop
    //   219: new 231	java/io/BufferedOutputStream
    //   222: dup
    //   223: new 233	java/io/FileOutputStream
    //   226: dup
    //   227: aload_0
    //   228: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   231: invokespecial 237	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   234: astore_0
    //   235: aload 8
    //   237: aload_0
    //   238: aconst_null
    //   239: invokevirtual 241	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   242: iconst_0
    //   243: putstatic 42	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   246: getstatic 457	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   249: invokestatic 496	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   252: sipush -406
    //   255: invokevirtual 500	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   258: aload 7
    //   260: ifnull +8 -> 268
    //   263: aload 7
    //   265: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   268: aload_0
    //   269: ifnull -143 -> 126
    //   272: aload_0
    //   273: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   276: return
    //   277: astore_0
    //   278: return
    //   279: aload 8
    //   281: ldc 199
    //   283: ldc_w 571
    //   286: invokevirtual 205	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   289: pop
    //   290: goto -71 -> 219
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_0
    //   296: aload 7
    //   298: ifnull +8 -> 306
    //   301: aload 7
    //   303: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   306: aload_0
    //   307: ifnull -181 -> 126
    //   310: aload_0
    //   311: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   314: return
    //   315: astore_0
    //   316: aconst_null
    //   317: astore_1
    //   318: aconst_null
    //   319: astore 7
    //   321: aload 7
    //   323: ifnull +8 -> 331
    //   326: aload 7
    //   328: invokevirtual 244	java/io/BufferedInputStream:close	()V
    //   331: aload_1
    //   332: ifnull +7 -> 339
    //   335: aload_1
    //   336: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   339: aload_0
    //   340: athrow
    //   341: astore 9
    //   343: iload 6
    //   345: istore 5
    //   347: goto -181 -> 166
    //   350: astore_1
    //   351: goto -45 -> 306
    //   354: astore_2
    //   355: goto -24 -> 331
    //   358: astore_1
    //   359: goto -20 -> 339
    //   362: astore_0
    //   363: goto -249 -> 114
    //   366: astore_1
    //   367: goto -99 -> 268
    //   370: astore_0
    //   371: aconst_null
    //   372: astore_1
    //   373: goto -52 -> 321
    //   376: astore_1
    //   377: aload_0
    //   378: astore_2
    //   379: aload_1
    //   380: astore_0
    //   381: aload_2
    //   382: astore_1
    //   383: goto -62 -> 321
    //   386: astore_0
    //   387: aconst_null
    //   388: astore_0
    //   389: aconst_null
    //   390: astore 7
    //   392: goto -96 -> 296
    //   395: astore_1
    //   396: goto -100 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramContext	Context
    //   0	399	1	paramString1	String
    //   0	399	2	paramString2	String
    //   0	399	3	paramString3	String
    //   0	399	4	paramString4	String
    //   164	182	5	m	int
    //   1	343	6	n	int
    //   142	249	7	localBufferedInputStream	java.io.BufferedInputStream
    //   151	129	8	localProperties	java.util.Properties
    //   341	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   118	126	277	java/lang/Exception
    //   272	276	277	java/lang/Exception
    //   310	314	277	java/lang/Exception
    //   144	160	293	java/lang/Throwable
    //   160	166	293	java/lang/Throwable
    //   171	219	293	java/lang/Throwable
    //   219	235	293	java/lang/Throwable
    //   279	290	293	java/lang/Throwable
    //   79	86	315	finally
    //   90	102	315	finally
    //   127	144	315	finally
    //   160	166	341	java/lang/Exception
    //   301	306	350	java/lang/Exception
    //   326	331	354	java/lang/Exception
    //   335	339	358	java/lang/Exception
    //   106	114	362	java/lang/Exception
    //   263	268	366	java/lang/Exception
    //   144	160	370	finally
    //   160	166	370	finally
    //   171	219	370	finally
    //   219	235	370	finally
    //   279	290	370	finally
    //   235	258	376	finally
    //   79	86	386	java/lang/Throwable
    //   90	102	386	java/lang/Throwable
    //   127	144	386	java/lang/Throwable
    //   235	258	395	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */