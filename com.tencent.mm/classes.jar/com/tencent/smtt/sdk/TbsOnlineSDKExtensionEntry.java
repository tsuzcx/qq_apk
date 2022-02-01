package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.b.c;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.util.Map;

public class TbsOnlineSDKExtensionEntry
  implements c
{
  public static final int EXTENSION_INIT_FAILURE = -99999;
  public static final String TAG = "TbsOnlineSDKExtensionEntry";
  static String a;
  private static Class<?> b = null;
  private static Object c = null;
  private static String[] d;
  private static int e = 0;
  private static String f = "";
  
  static boolean a(Context paramContext)
  {
    AppMethodBeat.i(55003);
    TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk initExtension");
    try
    {
      if (b != null)
      {
        TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk initExtension (true) sExtensionClass != null");
        AppMethodBeat.o(55003);
        return true;
      }
      Object localObject = q.a().r(paramContext);
      if (localObject == null)
      {
        TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk initExtension (false) optDir == null");
        AppMethodBeat.o(55003);
        return false;
      }
      File localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
      if (!localFile.exists())
      {
        TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk initExtension (false) dexFile.exists()=false", true);
        AppMethodBeat.o(55003);
        return false;
      }
      TbsLog.i("TbsOnlineSDKExtensionEntry", "new DexLoader #3 dexFile is " + localFile.getAbsolutePath());
      x.a().a(paramContext);
      com.tencent.smtt.utils.n.a(paramContext);
      String str1 = localFile.getParent();
      String str2 = localFile.getAbsolutePath();
      localObject = ((File)localObject).getAbsolutePath();
      Map localMap = QbSdk.getSettings();
      b = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      if ((!QbSdk.isEnableSensitiveApi()) && (k.a(b, "isSuiteableGetSensitative", new Class[0], new Object[0]) == null))
      {
        TbsLog.e("TbsOnlineSDKExtensionEntry", "isSuiteableGetSensitative check failed,can not use x5");
        AppMethodBeat.o(55003);
        return false;
      }
      loadTBSSDKExtension(paramContext, localFile.getParent());
      TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk initExtension (true)");
      AppMethodBeat.o(55003);
      return true;
    }
    finally
    {
      TbsLog.e("TbsOnlineSDKExtensionEntry", "initExtension sys WebView: " + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(55003);
    }
    return false;
  }
  
  private static boolean b(Context paramContext)
  {
    AppMethodBeat.i(55004);
    TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk initForX5DisableConfig");
    try
    {
      if (b != null)
      {
        TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk initForX5DisableConfig (true) sExtensionClass != null");
        AppMethodBeat.o(55004);
        return true;
      }
      Object localObject2 = q.a().r(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk initForX5DisableConfig (false) optDir == null");
        AppMethodBeat.o(55004);
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.j(paramContext)) {}
      }
      for (Object localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar"); !((File)localObject1).exists(); localObject1 = new File(q.a().r(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk initForX5DisableConfig (false) tbs_sdk_extension_dex.jar is not exist!");
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        AppMethodBeat.o(55004);
        return false;
        TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk initForX5DisableConfig (false) isShareTbsCoreAvailable=false");
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 304);
        AppMethodBeat.o(55004);
        return false;
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
      {
        TbsLog.i("TbsOnlineSDKExtensionEntry", "QbSdk init optDirExtension #3 is ".concat(String.valueOf(localObject2)));
        TbsLog.i("TbsOnlineSDKExtensionEntry", "new DexLoader #4 dexFile is " + ((File)localObject1).getAbsolutePath());
        x.a().a(paramContext);
        com.tencent.smtt.utils.n.a(paramContext);
        str1 = ((File)localObject1).getParent();
        str2 = ((File)localObject1).getAbsolutePath();
        Map localMap = QbSdk.getSettings();
        b = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject2, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        if ((QbSdk.isEnableSensitiveApi()) || (k.a(b, "isSuiteableGetSensitative", new Class[0], new Object[0]) != null)) {
          break;
        }
        TbsLog.e("TbsOnlineSDKExtensionEntry", "isSuiteableGetSensitative check failed,can not use x5");
        AppMethodBeat.o(55004);
        return false;
      }
      loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
      paramContext = c;
      localObject1 = b.a;
      localObject2 = b.b;
      String str1 = b.c;
      String str2 = b.d;
      k.a(paramContext, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject1, localObject2, str1, str2 });
      k.a(c, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk initForX5DisableConfig (true)");
      AppMethodBeat.o(55004);
      return true;
    }
    finally
    {
      TbsLog.e("TbsOnlineSDKExtensionEntry", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(55004);
    }
    return false;
  }
  
  public static void fileInfoDetect(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(55006);
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      try
      {
        localx.c().a().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
        AppMethodBeat.o(55006);
        return;
      }
      finally {}
    }
    AppMethodBeat.o(55006);
  }
  
  /* Error */
  public static void loadTBSSDKExtension(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 283
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   11: ifnull +10 -> 21
    //   14: ldc_w 283
    //   17: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: ldc 125
    //   23: monitorenter
    //   24: getstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   27: ifnull +13 -> 40
    //   30: ldc 125
    //   32: monitorexit
    //   33: ldc_w 283
    //   36: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: return
    //   40: getstatic 27	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:b	Ljava/lang/Class;
    //   43: ifnonnull +11 -> 54
    //   46: ldc 13
    //   48: ldc_w 285
    //   51: invokestatic 108	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aconst_null
    //   55: astore_3
    //   56: getstatic 27	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:b	Ljava/lang/Class;
    //   59: iconst_5
    //   60: anewarray 149	java/lang/Class
    //   63: dup
    //   64: iconst_0
    //   65: ldc_w 274
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc_w 274
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: ldc 133
    //   79: aastore
    //   80: dup
    //   81: iconst_3
    //   82: ldc 133
    //   84: aastore
    //   85: dup
    //   86: iconst_4
    //   87: ldc 133
    //   89: aastore
    //   90: invokevirtual 289	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   93: astore 4
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: invokestatic 182	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   102: ifeq +220 -> 322
    //   105: aload_0
    //   106: invokestatic 292	com/tencent/smtt/sdk/TbsShareManager:e	(Landroid/content/Context;)Landroid/content/Context;
    //   109: astore 4
    //   111: aload 4
    //   113: ifnonnull +42 -> 155
    //   116: invokestatic 215	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   119: ifnonnull +36 -> 155
    //   122: aload_0
    //   123: invokevirtual 296	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   126: invokestatic 301	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   129: sipush 227
    //   132: ldc_w 303
    //   135: invokevirtual 306	com/tencent/smtt/sdk/TbsLogReport:setLoadErrorCode	(ILjava/lang/String;)V
    //   138: ldc 125
    //   140: monitorexit
    //   141: ldc_w 283
    //   144: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: return
    //   148: astore 4
    //   150: iconst_0
    //   151: istore_2
    //   152: goto -54 -> 98
    //   155: iload_2
    //   156: ifne +317 -> 473
    //   159: aload 4
    //   161: ifnonnull +75 -> 236
    //   164: getstatic 27	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:b	Ljava/lang/Class;
    //   167: iconst_3
    //   168: anewarray 149	java/lang/Class
    //   171: dup
    //   172: iconst_0
    //   173: ldc_w 274
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: ldc_w 274
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: ldc 133
    //   187: aastore
    //   188: invokevirtual 289	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   191: astore_3
    //   192: aload_3
    //   193: iconst_5
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_0
    //   200: aastore
    //   201: dup
    //   202: iconst_1
    //   203: aload 4
    //   205: aastore
    //   206: dup
    //   207: iconst_2
    //   208: invokestatic 215	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   211: aastore
    //   212: dup
    //   213: iconst_3
    //   214: aload_1
    //   215: aastore
    //   216: dup
    //   217: iconst_4
    //   218: aconst_null
    //   219: aastore
    //   220: invokevirtual 312	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   223: putstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   226: ldc 125
    //   228: monitorexit
    //   229: ldc_w 283
    //   232: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: getstatic 27	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:b	Ljava/lang/Class;
    //   239: iconst_2
    //   240: anewarray 149	java/lang/Class
    //   243: dup
    //   244: iconst_0
    //   245: ldc_w 274
    //   248: aastore
    //   249: dup
    //   250: iconst_1
    //   251: ldc_w 274
    //   254: aastore
    //   255: invokevirtual 289	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   258: iconst_2
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload_0
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: aload 4
    //   270: aastore
    //   271: invokevirtual 312	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   274: putstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   277: goto -51 -> 226
    //   280: astore_0
    //   281: ldc_w 314
    //   284: new 90	java/lang/StringBuilder
    //   287: dup
    //   288: ldc_w 316
    //   291: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: aload_0
    //   295: invokestatic 170	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   298: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: goto -81 -> 226
    //   310: astore_0
    //   311: ldc 125
    //   313: monitorexit
    //   314: ldc_w 283
    //   317: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload_0
    //   321: athrow
    //   322: iload_2
    //   323: ifne +62 -> 385
    //   326: getstatic 27	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:b	Ljava/lang/Class;
    //   329: iconst_2
    //   330: anewarray 149	java/lang/Class
    //   333: dup
    //   334: iconst_0
    //   335: ldc_w 274
    //   338: aastore
    //   339: dup
    //   340: iconst_1
    //   341: ldc_w 274
    //   344: aastore
    //   345: invokevirtual 289	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   348: astore_3
    //   349: aload_0
    //   350: astore_1
    //   351: aload_0
    //   352: invokevirtual 296	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   355: ifnull +8 -> 363
    //   358: aload_0
    //   359: invokevirtual 296	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   362: astore_1
    //   363: aload_3
    //   364: iconst_2
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload_1
    //   371: aastore
    //   372: dup
    //   373: iconst_1
    //   374: aload_1
    //   375: aastore
    //   376: invokevirtual 312	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   379: putstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   382: goto -156 -> 226
    //   385: aconst_null
    //   386: astore 5
    //   388: aload 5
    //   390: astore 4
    //   392: ldc_w 318
    //   395: aload_0
    //   396: invokestatic 321	com/tencent/smtt/sdk/QbSdk:getCurrentProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   399: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   402: ifeq +18 -> 420
    //   405: aload 5
    //   407: astore 4
    //   409: getstatic 331	com/tencent/smtt/sdk/WebView:mWebViewCreated	Z
    //   412: ifne +8 -> 420
    //   415: ldc_w 333
    //   418: astore 4
    //   420: aload_0
    //   421: astore 5
    //   423: aload_0
    //   424: invokevirtual 296	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   427: ifnull +9 -> 436
    //   430: aload_0
    //   431: invokevirtual 296	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   434: astore 5
    //   436: aload_3
    //   437: iconst_5
    //   438: anewarray 4	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: aload 5
    //   445: aastore
    //   446: dup
    //   447: iconst_1
    //   448: aload 5
    //   450: aastore
    //   451: dup
    //   452: iconst_2
    //   453: aconst_null
    //   454: aastore
    //   455: dup
    //   456: iconst_3
    //   457: aload_1
    //   458: aastore
    //   459: dup
    //   460: iconst_4
    //   461: aload 4
    //   463: aastore
    //   464: invokevirtual 312	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   467: putstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   470: goto -244 -> 226
    //   473: goto -281 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	paramContext	Context
    //   0	476	1	paramString	String
    //   1	322	2	i	int
    //   55	382	3	localObject1	Object
    //   93	19	4	localObject2	Object
    //   148	121	4	localObject3	Object
    //   390	72	4	localObject4	Object
    //   386	63	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   56	95	148	finally
    //   98	111	280	finally
    //   116	138	280	finally
    //   164	192	280	finally
    //   192	226	280	finally
    //   236	277	280	finally
    //   326	349	280	finally
    //   351	363	280	finally
    //   363	382	280	finally
    //   392	405	280	finally
    //   409	415	280	finally
    //   423	436	280	finally
    //   436	470	280	finally
    //   24	33	310	finally
    //   40	54	310	finally
    //   138	141	310	finally
    //   226	229	310	finally
    //   281	307	310	finally
  }
  
  public boolean canLoadVideo(Context paramContext)
  {
    AppMethodBeat.i(54992);
    Object localObject = k.a(c, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk canLoadVideo ret=" + (Boolean)localObject);
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      AppMethodBeat.o(54992);
      return false;
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 314);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(54992);
    return bool;
  }
  
  /* Error */
  public boolean canLoadX5(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 6
    //   8: ldc_w 351
    //   11: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: invokestatic 356	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   18: invokevirtual 360	com/tencent/smtt/sdk/TbsPVConfig:getDisabledCoreVersion	()I
    //   21: istore 4
    //   23: iload 4
    //   25: ifeq +31 -> 56
    //   28: iload 4
    //   30: invokestatic 64	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   33: aload_1
    //   34: invokevirtual 363	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   37: if_icmpne +19 -> 56
    //   40: ldc 13
    //   42: ldc_w 365
    //   45: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 351
    //   51: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iconst_0
    //   55: ireturn
    //   56: aload_1
    //   57: iload_2
    //   58: invokestatic 368	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Z)Z
    //   61: ifne +19 -> 80
    //   64: ldc 13
    //   66: ldc_w 370
    //   69: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc_w 351
    //   75: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: ireturn
    //   80: getstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   83: ldc_w 372
    //   86: iconst_1
    //   87: anewarray 149	java/lang/Class
    //   90: dup
    //   91: iconst_0
    //   92: getstatic 249	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   95: aastore
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 373
    //   105: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: invokestatic 242	com/tencent/smtt/utils/k:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   112: astore 8
    //   114: aload 8
    //   116: ifnull +905 -> 1021
    //   119: aload 8
    //   121: instanceof 133
    //   124: ifeq +25 -> 149
    //   127: aload 8
    //   129: checkcast 133	java/lang/String
    //   132: ldc_w 375
    //   135: invokevirtual 379	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   138: ifeq +11 -> 149
    //   141: ldc_w 351
    //   144: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_0
    //   148: ireturn
    //   149: aload 8
    //   151: instanceof 381
    //   154: ifne +42 -> 196
    //   157: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   160: aload_1
    //   161: sipush 330
    //   164: new 383	java/lang/Throwable
    //   167: dup
    //   168: aload 8
    //   170: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   176: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   179: ldc_w 386
    //   182: ldc_w 388
    //   185: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: ldc_w 351
    //   191: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: iconst_0
    //   195: ireturn
    //   196: aload 8
    //   198: checkcast 381	android/os/Bundle
    //   201: astore 7
    //   203: aload 7
    //   205: invokevirtual 391	android/os/Bundle:isEmpty	()Z
    //   208: ifeq +42 -> 250
    //   211: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   214: aload_1
    //   215: sipush 331
    //   218: new 383	java/lang/Throwable
    //   221: dup
    //   222: aload 8
    //   224: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   227: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   230: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   233: ldc_w 386
    //   236: ldc_w 393
    //   239: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: ldc_w 351
    //   245: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: iconst_0
    //   249: ireturn
    //   250: aload 7
    //   252: ldc_w 395
    //   255: iconst_m1
    //   256: invokevirtual 399	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   259: istore 4
    //   261: iload 4
    //   263: ifne +178 -> 441
    //   266: iconst_1
    //   267: istore_2
    //   268: aload_1
    //   269: invokestatic 182	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   272: ifeq +174 -> 446
    //   275: aload_1
    //   276: invokestatic 401	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   279: invokestatic 405	com/tencent/smtt/sdk/g:a	(I)V
    //   282: aload_1
    //   283: invokestatic 401	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   286: invokestatic 408	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   289: astore 8
    //   291: aload 8
    //   293: putstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   296: aload 8
    //   298: invokevirtual 411	java/lang/String:length	()I
    //   301: iconst_5
    //   302: if_icmpne +25 -> 327
    //   305: new 90	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 413
    //   312: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: getstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   318: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: putstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   327: getstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   330: invokevirtual 411	java/lang/String:length	()I
    //   333: bipush 6
    //   335: if_icmpeq +8 -> 343
    //   338: ldc 33
    //   340: putstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   343: aload 7
    //   345: ldc_w 415
    //   348: invokevirtual 419	android/os/Bundle:getStringArray	(Ljava/lang/String;)[Ljava/lang/String;
    //   351: putstatic 421	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:d	[Ljava/lang/String;
    //   354: getstatic 421	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:d	[Ljava/lang/String;
    //   357: instanceof 422
    //   360: ifne +362 -> 722
    //   363: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   366: aload_1
    //   367: sipush 307
    //   370: new 383	java/lang/Throwable
    //   373: dup
    //   374: new 90	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 424
    //   381: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: getstatic 421	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:d	[Ljava/lang/String;
    //   387: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   396: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   399: ldc_w 351
    //   402: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: iconst_0
    //   406: ireturn
    //   407: astore 8
    //   409: ldc 13
    //   411: new 90	java/lang/StringBuilder
    //   414: dup
    //   415: ldc_w 426
    //   418: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: aload 8
    //   423: invokevirtual 427	java/lang/Exception:toString	()Ljava/lang/String;
    //   426: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: iconst_m1
    //   436: istore 4
    //   438: goto -177 -> 261
    //   441: iconst_0
    //   442: istore_2
    //   443: goto -175 -> 268
    //   446: getstatic 432	android/os/Build$VERSION:SDK_INT	I
    //   449: bipush 12
    //   451: if_icmplt +66 -> 517
    //   454: aload 7
    //   456: ldc_w 434
    //   459: ldc_w 413
    //   462: invokevirtual 438	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   465: putstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   468: getstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   471: invokestatic 442	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   474: putstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   477: getstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   480: invokestatic 405	com/tencent/smtt/sdk/g:a	(I)V
    //   483: getstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   486: ifne +80 -> 566
    //   489: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   492: aload_1
    //   493: sipush 307
    //   496: new 383	java/lang/Throwable
    //   499: dup
    //   500: ldc_w 444
    //   503: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   506: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   509: ldc_w 351
    //   512: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   515: iconst_0
    //   516: ireturn
    //   517: aload 7
    //   519: ldc_w 434
    //   522: invokevirtual 446	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: astore 8
    //   527: aload 8
    //   529: putstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   532: aload 8
    //   534: ifnonnull -66 -> 468
    //   537: ldc_w 413
    //   540: putstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   543: goto -75 -> 468
    //   546: astore 8
    //   548: ldc_w 413
    //   551: putstatic 35	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:f	Ljava/lang/String;
    //   554: goto -86 -> 468
    //   557: astore 8
    //   559: iconst_0
    //   560: putstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   563: goto -86 -> 477
    //   566: getstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   569: ifle +15 -> 584
    //   572: iload 5
    //   574: istore_3
    //   575: getstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   578: sipush 25442
    //   581: if_icmple +15 -> 596
    //   584: getstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   587: sipush 25472
    //   590: if_icmpne +105 -> 695
    //   593: iload 5
    //   595: istore_3
    //   596: ldc_w 448
    //   599: ldc_w 450
    //   602: iload_3
    //   603: invokestatic 453	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   606: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   609: invokestatic 54	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: iload_3
    //   613: ifeq -270 -> 343
    //   616: ldc_w 448
    //   619: new 90	java/lang/StringBuilder
    //   622: dup
    //   623: ldc_w 455
    //   626: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   629: getstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   632: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   635: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: invokestatic 64	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   644: aload_1
    //   645: invokevirtual 68	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   648: invokestatic 463	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   651: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   654: aload_1
    //   655: sipush 307
    //   658: new 383	java/lang/Throwable
    //   661: dup
    //   662: new 90	java/lang/StringBuilder
    //   665: dup
    //   666: ldc_w 455
    //   669: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   672: getstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   675: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   678: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   684: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   687: ldc_w 351
    //   690: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   693: iconst_0
    //   694: ireturn
    //   695: iconst_0
    //   696: istore_3
    //   697: goto -101 -> 596
    //   700: astore 7
    //   702: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   705: aload_1
    //   706: sipush 329
    //   709: aload 7
    //   711: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   714: ldc_w 351
    //   717: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   720: iconst_0
    //   721: ireturn
    //   722: aload 7
    //   724: ldc_w 465
    //   727: invokevirtual 446	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   730: putstatic 466	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:a	Ljava/lang/String;
    //   733: aconst_null
    //   734: astore 8
    //   736: aload 8
    //   738: astore 7
    //   740: iload 4
    //   742: ifeq +22 -> 764
    //   745: getstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   748: ldc_w 468
    //   751: iconst_0
    //   752: anewarray 149	java/lang/Class
    //   755: iconst_0
    //   756: anewarray 4	java/lang/Object
    //   759: invokestatic 242	com/tencent/smtt/utils/k:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   762: astore 7
    //   764: iload 4
    //   766: tableswitch	default:+26 -> 792, -2:+177->943, -1:+102->868, 0:+252->1018
    //   793: nop
    //   794: ifnull +11025 -> 11819
    //   797: aconst_null
    //   798: if_icmpeq -17663 -> -16865
    //   801: land
    //   802: dup
    //   803: new 90	java/lang/StringBuilder
    //   806: dup
    //   807: ldc_w 470
    //   810: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   813: aload 7
    //   815: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   818: ldc_w 472
    //   821: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: iload 4
    //   826: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   829: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   835: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   838: iload_2
    //   839: ifne +12 -> 851
    //   842: ldc_w 386
    //   845: ldc_w 474
    //   848: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   851: ldc_w 351
    //   854: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   857: iload_2
    //   858: ireturn
    //   859: astore_1
    //   860: ldc_w 351
    //   863: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   866: iconst_0
    //   867: ireturn
    //   868: aload 7
    //   870: instanceof 246
    //   873: ifeq +39 -> 912
    //   876: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   879: aload_1
    //   880: aload 7
    //   882: checkcast 246	java/lang/Integer
    //   885: invokevirtual 477	java/lang/Integer:intValue	()I
    //   888: new 383	java/lang/Throwable
    //   891: dup
    //   892: ldc_w 470
    //   895: aload 7
    //   897: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   900: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   903: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   906: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   909: goto -71 -> 838
    //   912: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   915: aload_1
    //   916: sipush 307
    //   919: new 383	java/lang/Throwable
    //   922: dup
    //   923: ldc_w 470
    //   926: aload 7
    //   928: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   931: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   934: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   937: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   940: goto -102 -> 838
    //   943: aload 7
    //   945: instanceof 246
    //   948: ifeq +39 -> 987
    //   951: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   954: aload_1
    //   955: aload 7
    //   957: checkcast 246	java/lang/Integer
    //   960: invokevirtual 477	java/lang/Integer:intValue	()I
    //   963: new 383	java/lang/Throwable
    //   966: dup
    //   967: ldc_w 470
    //   970: aload 7
    //   972: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   975: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   978: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   981: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   984: goto -146 -> 838
    //   987: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   990: aload_1
    //   991: sipush 404
    //   994: new 383	java/lang/Throwable
    //   997: dup
    //   998: ldc_w 470
    //   1001: aload 7
    //   1003: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1006: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1009: invokespecial 384	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   1012: invokevirtual 207	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   1015: goto -177 -> 838
    //   1018: goto -180 -> 838
    //   1021: getstatic 29	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:c	Ljava/lang/Object;
    //   1024: astore 7
    //   1026: getstatic 249	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1029: astore 8
    //   1031: invokestatic 481	com/tencent/smtt/sdk/a:a	()I
    //   1034: istore 4
    //   1036: aload 7
    //   1038: ldc_w 482
    //   1041: iconst_1
    //   1042: anewarray 149	java/lang/Class
    //   1045: dup
    //   1046: iconst_0
    //   1047: aload 8
    //   1049: aastore
    //   1050: iconst_1
    //   1051: anewarray 4	java/lang/Object
    //   1054: dup
    //   1055: iconst_0
    //   1056: iload 4
    //   1058: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1061: aastore
    //   1062: invokestatic 242	com/tencent/smtt/utils/k:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1065: astore 7
    //   1067: aload 7
    //   1069: ifnull +146 -> 1215
    //   1072: aload 7
    //   1074: instanceof 133
    //   1077: ifeq +25 -> 1102
    //   1080: aload 7
    //   1082: checkcast 133	java/lang/String
    //   1085: ldc_w 375
    //   1088: invokevirtual 379	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1091: ifeq +11 -> 1102
    //   1094: ldc_w 351
    //   1097: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1100: iconst_0
    //   1101: ireturn
    //   1102: iload 6
    //   1104: istore_2
    //   1105: aload 7
    //   1107: instanceof 340
    //   1110: ifeq -272 -> 838
    //   1113: invokestatic 484	com/tencent/smtt/sdk/g:d	()I
    //   1116: putstatic 31	com/tencent/smtt/sdk/TbsOnlineSDKExtensionEntry:e	I
    //   1119: aload_1
    //   1120: invokestatic 484	com/tencent/smtt/sdk/g:d	()I
    //   1123: invokestatic 487	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;I)Z
    //   1126: istore 5
    //   1128: iload_3
    //   1129: istore_2
    //   1130: aload 7
    //   1132: checkcast 340	java/lang/Boolean
    //   1135: invokevirtual 346	java/lang/Boolean:booleanValue	()Z
    //   1138: ifeq +12 -> 1150
    //   1141: iload_3
    //   1142: istore_2
    //   1143: iload 5
    //   1145: ifne +5 -> 1150
    //   1148: iconst_1
    //   1149: istore_2
    //   1150: iload_2
    //   1151: ifne +56 -> 1207
    //   1154: ldc_w 386
    //   1157: ldc_w 489
    //   1160: invokestatic 72	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1163: ldc_w 386
    //   1166: ldc_w 491
    //   1169: iload 5
    //   1171: invokestatic 453	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1174: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1177: invokestatic 494	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1180: ldc_w 386
    //   1183: new 90	java/lang/StringBuilder
    //   1186: dup
    //   1187: ldc_w 496
    //   1190: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1193: aload 7
    //   1195: checkcast 340	java/lang/Boolean
    //   1198: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokestatic 494	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1207: ldc_w 351
    //   1210: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1213: iload_2
    //   1214: ireturn
    //   1215: invokestatic 198	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1218: aload_1
    //   1219: sipush 308
    //   1222: invokevirtual 212	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;I)V
    //   1225: iload 6
    //   1227: istore_2
    //   1228: goto -390 -> 838
    //   1231: astore 7
    //   1233: aload 8
    //   1235: astore 7
    //   1237: goto -473 -> 764
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1240	0	this	TbsOnlineSDKExtensionEntry
    //   0	1240	1	paramContext	Context
    //   0	1240	2	paramBoolean1	boolean
    //   0	1240	3	paramBoolean2	boolean
    //   21	1036	4	i	int
    //   1	1169	5	bool1	boolean
    //   6	1220	6	bool2	boolean
    //   201	317	7	localBundle	Bundle
    //   700	23	7	localThrowable	Throwable
    //   738	456	7	localObject1	Object
    //   1231	1	7	localException1	Exception
    //   1235	1	7	localClass1	Class
    //   112	185	8	localObject2	Object
    //   407	15	8	localException2	Exception
    //   525	8	8	str	String
    //   546	1	8	localException3	Exception
    //   557	1	8	localNumberFormatException	java.lang.NumberFormatException
    //   734	500	8	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   250	261	407	java/lang/Exception
    //   446	468	546	java/lang/Exception
    //   517	532	546	java/lang/Exception
    //   537	543	546	java/lang/Exception
    //   468	477	557	java/lang/NumberFormatException
    //   343	354	700	finally
    //   722	733	859	java/lang/Exception
    //   745	764	1231	java/lang/Exception
  }
  
  public boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    AppMethodBeat.i(54998);
    try
    {
      if (paramContext.getApplicationInfo().packageName.contains("com.moji.mjweather"))
      {
        int i = Build.VERSION.SDK_INT;
        if (i == 19)
        {
          AppMethodBeat.o(54998);
          return true;
        }
      }
      if (b == null)
      {
        Object localObject = q.a().r(paramContext);
        if (localObject == null)
        {
          TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
          AppMethodBeat.o(54998);
          return false;
        }
        File localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        if (!localFile.exists())
        {
          TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
          AppMethodBeat.o(54998);
          return false;
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {}
        for (localObject = TbsShareManager.getHostCorePathAppDefined();; localObject = ((File)localObject).getAbsolutePath())
        {
          TbsLog.i("TbsOnlineSDKExtensionEntry", "QbSdk init optDirExtension #2 is ".concat(String.valueOf(localObject)));
          TbsLog.i("TbsOnlineSDKExtensionEntry", "new DexLoader #2 dexFile is " + localFile.getAbsolutePath());
          x.a().a(paramContext);
          com.tencent.smtt.utils.n.a(paramContext);
          String str1 = localFile.getParent();
          String str2 = localFile.getAbsolutePath();
          Map localMap = QbSdk.getSettings();
          b = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
          if (c != null) {
            break label334;
          }
          if ((TbsShareManager.e(paramContext) != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) {
            break;
          }
          TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
          AppMethodBeat.o(54998);
          return false;
        }
        if ((!QbSdk.isEnableSensitiveApi()) && (k.a(b, "isSuiteableGetSensitative", new Class[0], new Object[0]) == null))
        {
          TbsLog.e("TbsOnlineSDKExtensionEntry", "isSuiteableGetSensitative check failed,can not use x5");
          AppMethodBeat.o(54998);
          return false;
        }
        loadTBSSDKExtension(paramContext, localFile.getParent());
      }
      label334:
      paramContext = k.a(c, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Boolean)))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        AppMethodBeat.o(54998);
        return bool;
      }
      AppMethodBeat.o(54998);
      return false;
    }
    finally
    {
      TbsLog.e("TbsOnlineSDKExtensionEntry", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(54998);
    }
    return false;
  }
  
  public boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55002);
    paramContext = k.a(c, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean)))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(55002);
      return bool;
    }
    AppMethodBeat.o(55002);
    return false;
  }
  
  public void dispatchX5EcCommands(Context paramContext, Integer paramInteger, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(219633);
    if (!a(paramContext))
    {
      AppMethodBeat.o(219633);
      return;
    }
    k.a(c, "dispatchEmergencyCommand", new Class[] { Integer.class, Map.class }, new Object[] { paramInteger, paramMap });
    AppMethodBeat.o(219633);
  }
  
  public String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(54994);
    a(paramContext1);
    if ((d instanceof String[]))
    {
      int j = d.length;
      paramContext1 = new String[j];
      while (i < j)
      {
        paramContext1[i] = (paramString + d[i]);
        i += 1;
      }
      AppMethodBeat.o(54994);
      return paramContext1;
    }
    paramContext1 = k.a(c, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      AppMethodBeat.o(54994);
      return paramContext1;
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
  }
  
  public String getLibraryPath()
  {
    return a;
  }
  
  public String getTbsCoreVersionString()
  {
    return f;
  }
  
  public Bundle incrUpdate(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(54999);
    if (!a(paramContext))
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "initForPatch return false!");
      AppMethodBeat.o(54999);
      return null;
    }
    paramBundle = k.a(c, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null)
    {
      paramContext = (Bundle)paramBundle;
      AppMethodBeat.o(54999);
      return paramContext;
    }
    TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "incrUpdate return null!");
    AppMethodBeat.o(54999);
    return null;
  }
  
  public boolean init(Context paramContext)
  {
    AppMethodBeat.i(54997);
    int i;
    try
    {
      localObject2 = q.a().r(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk init (false) optDir == null");
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
        AppMethodBeat.o(54997);
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        if ((e != 0) && (e != TbsShareManager.d(paramContext)))
        {
          b = null;
          c = null;
          TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 302, new Throwable("sTbsVersion: " + e + "; AvailableTbsCoreVersion: " + TbsShareManager.d(paramContext)));
          AppMethodBeat.o(54997);
          return false;
        }
        i = TbsShareManager.d(paramContext);
        e = i;
        if ((i != 0) && (e != TbsShareManager.d(paramContext)))
        {
          b = null;
          c = null;
          TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 302, new Throwable("sTbsVersion: " + e + "; AvailableTbsCoreVersion: " + TbsShareManager.d(paramContext)));
          AppMethodBeat.o(54997);
          return false;
        }
      }
      for (e = TbsShareManager.d(paramContext); (b != null) && (c != null); e = i)
      {
        TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk init (true) sExtensionClass != null");
        AppMethodBeat.o(54997);
        return true;
        if (e != 0)
        {
          int j = q.a().a(true, paramContext);
          i = j;
          if (e != j)
          {
            b = null;
            c = null;
            TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=".concat(String.valueOf(j)), true);
            TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + e, true);
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 303, new Throwable("sTbsVersion: " + e + "; tbsCoreInstalledVer: " + j));
            AppMethodBeat.o(54997);
            return false;
          }
        }
        else
        {
          i = 0;
        }
      }
      if (!TbsShareManager.isThirdPartyApp(paramContext)) {
        break label620;
      }
    }
    finally
    {
      TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable));
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 306, localThrowable);
      AppMethodBeat.o(54997);
      return false;
    }
    if (TbsShareManager.j(paramContext))
    {
      localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
      boolean bool = ((File)localObject1).exists();
      if (bool) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          TbsLog.e("TbsOnlineSDKExtensionEntry", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
          i = q.a().j(paramContext);
          if (!new File(((File)localObject1).getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
            continue;
          }
          if (i <= 0) {
            continue;
          }
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(i))));
        }
        finally
        {
          label620:
          String str1;
          String str2;
          Object localObject3;
          continue;
        }
        AppMethodBeat.o(54997);
        return false;
        TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk init (false) isShareTbsCoreAvailable=false");
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
        AppMethodBeat.o(54997);
        return false;
        localObject1 = new File(q.a().r(paramContext), "tbs_sdk_extension_dex.jar");
        break;
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(i))));
        continue;
        if (i > 0) {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(i))));
        } else {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(i))));
        }
      }
    }
    if (TbsShareManager.getHostCorePathAppDefined() != null) {}
    for (Object localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
    {
      TbsLog.i("TbsOnlineSDKExtensionEntry", "QbSdk init optDirExtension #1 is ".concat(String.valueOf(localObject2)));
      TbsLog.i("TbsOnlineSDKExtensionEntry", "new DexLoader #1 dexFile is " + ((File)localObject1).getAbsolutePath());
      x.a().a(paramContext);
      com.tencent.smtt.utils.n.a(paramContext);
      str1 = ((File)localObject1).getParent();
      str2 = ((File)localObject1).getAbsolutePath();
      localObject3 = QbSdk.getSettings();
      b = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject2, (Map)localObject3).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      if ((QbSdk.isEnableSensitiveApi()) || (k.a(b, "isSuiteableGetSensitative", new Class[0], new Object[0]) != null)) {
        break;
      }
      TbsLog.e("TbsOnlineSDKExtensionEntry", "isSuiteableGetSensitative check failed,can not use x5");
      AppMethodBeat.o(54997);
      return false;
    }
    loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
    Object localObject1 = c;
    localObject2 = b.a;
    str1 = b.b;
    str2 = b.c;
    localObject3 = b.d;
    k.a(localObject1, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject2, str1, str2, localObject3 });
    k.a(c, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
    TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk init (true)");
    AppMethodBeat.o(54997);
    return true;
  }
  
  public boolean isX5Disabled(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55000);
    if ((QbSdk.mSettings != null) && (QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("TbsOnlineSDKExtensionEntry", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
      AppMethodBeat.o(55000);
      return true;
    }
    q localq = q.a();
    if (g.a == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localq.b(paramContext, bool);
      if (QbSdk.isEnableSensitiveApi()) {
        break;
      }
      TbsLog.e("TbsOnlineSDKExtensionEntry", "isEnableSensitiveApi return false,disable core");
      AppMethodBeat.o(55000);
      return true;
    }
    if (!b(paramContext))
    {
      AppMethodBeat.o(55000);
      return true;
    }
    paramContext = k.a(c, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(44138), Integer.valueOf(paramInt2) });
    TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk isX5Disabled  ret=".concat(String.valueOf(paramContext)));
    if (paramContext != null)
    {
      bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(55000);
      return bool;
    }
    paramContext = k.a(c, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(44138) });
    if (paramContext != null)
    {
      bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(55000);
      return bool;
    }
    AppMethodBeat.o(55000);
    return true;
  }
  
  public boolean isX5DisabledSync(Context paramContext)
  {
    AppMethodBeat.i(55001);
    if (n.a(paramContext).c() == 2) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(55001);
      return false;
    }
    if (!b(paramContext))
    {
      AppMethodBeat.o(55001);
      return true;
    }
    i = q.a().j(paramContext);
    paramContext = k.a(c, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i), Integer.valueOf(44138) });
    TbsLog.d("TbsOnlineSDKExtensionEntry", "QbSdk isX5DisabledSync  ret=".concat(String.valueOf(paramContext)));
    if (paramContext != null)
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(55001);
      return bool;
    }
    AppMethodBeat.o(55001);
    return true;
  }
  
  public Object onMiscCallExtension(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(54996);
    if (!a(paramContext))
    {
      AppMethodBeat.o(54996);
      return Integer.valueOf(-99999);
    }
    paramContext = k.a(c, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
    if (paramContext != null)
    {
      AppMethodBeat.o(54996);
      return paramContext;
    }
    AppMethodBeat.o(54996);
    return null;
  }
  
  public boolean useSoftWare()
  {
    AppMethodBeat.i(54995);
    if (c == null)
    {
      AppMethodBeat.o(54995);
      return false;
    }
    Object localObject2 = k.a(c, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = c;
      localObject2 = Integer.TYPE;
      int i = a.a();
      localObject1 = k.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i) });
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(54995);
      return false;
    }
    boolean bool = ((Boolean)localObject1).booleanValue();
    AppMethodBeat.o(54995);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsOnlineSDKExtensionEntry
 * JD-Core Version:    0.7.0.1
 */