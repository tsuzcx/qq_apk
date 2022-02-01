package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.l;
import com.tencent.xweb.xwalk.c;
import java.util.Locale;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public class ap
{
  private static boolean aigj = false;
  protected static c aigk;
  protected static boolean aigl = false;
  protected static boolean aigm = false;
  
  private static void a(Context paramContext, Locale paramLocale)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212453);
        if (paramContext == null)
        {
          AppMethodBeat.o(212453);
          return;
        }
        if (aigj)
        {
          AppMethodBeat.o(212453);
          continue;
        }
        XWalkEnvironment.init(paramContext);
      }
      finally {}
      XWalkEnvironment.setLocale(paramLocale);
      paramLocale = WebViewWrapperFactory.e(WebView.WebViewKind.aifI);
      if (paramLocale != null) {
        paramLocale.initEnviroment(paramContext);
      }
      paramLocale = WebViewWrapperFactory.e(WebView.WebViewKind.aifL);
      if (paramLocale != null) {
        paramLocale.initEnviroment(paramContext);
      }
      paramLocale = WebViewWrapperFactory.e(WebView.WebViewKind.aifJ);
      if (paramLocale != null) {
        paramLocale.initEnviroment(paramContext);
      }
      u.a(new a((byte)0));
      aigj = true;
      AppMethodBeat.o(212453);
    }
  }
  
  protected static boolean aJC(int paramInt)
  {
    AppMethodBeat.i(212493);
    if (!WebView.isXWalk())
    {
      Log.w("XWebSdkInternal", "hasXWebFeature, not xweb now");
      AppMethodBeat.o(212493);
      return false;
    }
    Object localObject4 = null;
    try
    {
      WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.e(WebView.getCurWebType());
      localObject1 = localObject4;
      if (localIWebViewProvider != null) {
        localObject1 = localIWebViewProvider.excute("STR_CMD_INVOKE_TO_RUNTIME", new Object[] { Integer.valueOf(80003), { Integer.valueOf(paramInt) } });
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        boolean bool;
        Log.e("XWebSdkInternal", "hasXWebFeature, error:".concat(String.valueOf(localObject2)));
        Object localObject3 = localObject4;
      }
      AppMethodBeat.o(212493);
    }
    if ((localObject1 instanceof Boolean))
    {
      bool = ((Boolean)localObject1).booleanValue();
      AppMethodBeat.o(212493);
      return bool;
    }
    return false;
  }
  
  public static void b(Context paramContext, String paramString, WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(212488);
    try
    {
      oT(paramContext).b(paramString, paramWebViewKind);
      AppMethodBeat.o(212488);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("XWebSdkInternal", "setABTestWebViewKind failed, error:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(212488);
    }
  }
  
  protected static void b(Context paramContext, Locale paramLocale, IXWebLogClient paramIXWebLogClient, ISharedPreferenceProvider paramISharedPreferenceProvider, aj paramaj, WebViewExtensionListener paramWebViewExtensionListener)
  {
    try
    {
      AppMethodBeat.i(212448);
      Log.i("XWebSdkInternal", String.format("initXWebEnvironment, locale:%s, logListener:%s, spProvider:%s, reportInterface:%s, extensionListener:%s", new Object[] { paramLocale, paramIXWebLogClient, paramISharedPreferenceProvider, paramaj, paramWebViewExtensionListener }));
      if (paramIXWebLogClient != null) {
        Log.SetLogCallBack(paramIXWebLogClient);
      }
      if (paramaj != null) {
        l.a(paramaj);
      }
      if (paramISharedPreferenceProvider != null) {
        XWalkSharedPreferenceUtil.setSharedPreferenceProvider(paramISharedPreferenceProvider);
      }
      a(paramContext, paramLocale);
      if (paramWebViewExtensionListener != null)
      {
        if (paramWebViewExtensionListener != null)
        {
          paramContext = WebViewWrapperFactory.e(WebView.WebViewKind.aifI);
          if (paramContext != null) {
            paramContext.initWebViewExtensionListener(paramWebViewExtensionListener);
          }
        }
        if (paramWebViewExtensionListener != null)
        {
          paramContext = WebViewWrapperFactory.e(WebView.WebViewKind.aifL);
          if (paramContext != null) {
            paramContext.initWebViewExtensionListener(paramWebViewExtensionListener);
          }
        }
        if (paramWebViewExtensionListener != null)
        {
          paramContext = WebViewWrapperFactory.e(WebView.WebViewKind.aifJ);
          if (paramContext != null) {
            paramContext.initWebViewExtensionListener(paramWebViewExtensionListener);
          }
        }
      }
      XWebCoreContentProvider.kgb();
      AppMethodBeat.o(212448);
      return;
    }
    finally {}
  }
  
  protected static void b(c paramc)
  {
    try
    {
      aigk = paramc;
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static int kgt()
  {
    AppMethodBeat.i(212458);
    int i = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getInt("IP_TYPE", -2);
    AppMethodBeat.o(212458);
    return i;
  }
  
  public static c kgu()
  {
    try
    {
      c localc = aigk;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected static void kgv()
  {
    AppMethodBeat.i(212502);
    Log.i("XWebSdkInternal", "setWaitForXWeb:true");
    aigl = true;
    AppMethodBeat.o(212502);
  }
  
  public static boolean kgw()
  {
    return aigl;
  }
  
  /* Error */
  protected static void kgx()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 208
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 21	com/tencent/xweb/ap:aigm	Z
    //   13: ifeq +12 -> 25
    //   16: ldc 208
    //   18: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: invokestatic 212	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   28: ifnonnull +26 -> 54
    //   31: ldc 86
    //   33: ldc 214
    //   35: invokestatic 94	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc 208
    //   40: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -22 -> 21
    //   46: astore 4
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload 4
    //   53: athrow
    //   54: invokestatic 212	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   57: invokevirtual 220	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   60: ifnull +32 -> 92
    //   63: invokestatic 212	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   66: invokevirtual 220	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   69: getfield 226	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   72: bipush 28
    //   74: if_icmpge +18 -> 92
    //   77: ldc 86
    //   79: ldc 228
    //   81: invokestatic 155	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: ldc 208
    //   86: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -68 -> 21
    //   92: getstatic 233	android/os/Build$VERSION:SDK_INT	I
    //   95: istore_0
    //   96: iload_0
    //   97: bipush 28
    //   99: if_icmplt +592 -> 691
    //   102: invokestatic 237	org/xwalk/core/XWalkEnvironment:getProcessName	()Ljava/lang/String;
    //   105: astore 5
    //   107: aload 5
    //   109: astore 4
    //   111: aload 5
    //   113: ldc 239
    //   115: ldc 241
    //   117: invokevirtual 245	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   120: astore 5
    //   122: aload 5
    //   124: astore 4
    //   126: aload 5
    //   128: ldc 247
    //   130: ldc 241
    //   132: invokevirtual 245	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   135: astore 5
    //   137: aload 5
    //   139: astore 4
    //   141: ldc 86
    //   143: ldc 249
    //   145: aload 5
    //   147: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   150: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   153: invokestatic 155	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 5
    //   158: astore 4
    //   160: new 251	java/io/File
    //   163: dup
    //   164: invokestatic 212	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   167: ldc 253
    //   169: aload 4
    //   171: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   174: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   177: iconst_0
    //   178: invokevirtual 257	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   181: invokevirtual 260	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   184: ldc_w 262
    //   187: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: astore 5
    //   192: aload 5
    //   194: invokevirtual 267	java/io/File:exists	()Z
    //   197: ifne +164 -> 361
    //   200: ldc 86
    //   202: ldc_w 269
    //   205: invokestatic 94	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aconst_null
    //   209: astore 5
    //   211: aconst_null
    //   212: astore 6
    //   214: iconst_0
    //   215: istore_1
    //   216: iconst_0
    //   217: istore_0
    //   218: aload 6
    //   220: ifnull +13 -> 233
    //   223: aload 6
    //   225: invokevirtual 274	java/nio/channels/FileLock:release	()V
    //   228: aload 6
    //   230: invokevirtual 277	java/nio/channels/FileLock:close	()V
    //   233: aload 5
    //   235: ifnull +516 -> 751
    //   238: aload 5
    //   240: invokevirtual 280	java/io/RandomAccessFile:close	()V
    //   243: iload_1
    //   244: istore_2
    //   245: iload_2
    //   246: ifeq +386 -> 632
    //   249: iload_0
    //   250: ifne +382 -> 632
    //   253: new 282	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   260: aload 4
    //   262: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokestatic 293	org/xwalk/core/XWalkGrayValueUtil:getGrayValue	()I
    //   268: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: astore 5
    //   276: ldc 86
    //   278: ldc_w 301
    //   281: aload 5
    //   283: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   289: invokestatic 94	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: ldc2_w 302
    //   295: ldc2_w 304
    //   298: lconst_1
    //   299: invokestatic 309	com/tencent/xweb/util/l:y	(JJJ)V
    //   302: ldc_w 311
    //   305: ldc_w 313
    //   308: iconst_1
    //   309: anewarray 315	java/lang/Class
    //   312: dup
    //   313: iconst_0
    //   314: ldc 120
    //   316: aastore
    //   317: iconst_1
    //   318: anewarray 4	java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: aload 5
    //   325: aastore
    //   326: invokestatic 320	com/tencent/xweb/util/k:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   329: pop
    //   330: iconst_1
    //   331: putstatic 21	com/tencent/xweb/ap:aigm	Z
    //   334: ldc 208
    //   336: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: goto -318 -> 21
    //   342: ldc 86
    //   344: ldc_w 322
    //   347: aload 5
    //   349: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   352: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   355: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: goto -198 -> 160
    //   361: new 279	java/io/RandomAccessFile
    //   364: dup
    //   365: aload 5
    //   367: ldc_w 324
    //   370: invokespecial 327	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   373: astore 5
    //   375: aload 5
    //   377: invokevirtual 331	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   380: invokevirtual 337	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   383: astore 6
    //   385: aload 6
    //   387: ifnull +10 -> 397
    //   390: iconst_1
    //   391: istore_0
    //   392: iconst_1
    //   393: istore_1
    //   394: goto -176 -> 218
    //   397: iconst_0
    //   398: istore_0
    //   399: goto -7 -> 392
    //   402: astore 6
    //   404: ldc 86
    //   406: ldc_w 339
    //   409: aload 6
    //   411: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   414: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   417: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: goto -187 -> 233
    //   423: astore 5
    //   425: ldc 86
    //   427: ldc_w 341
    //   430: aload 5
    //   432: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   435: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   438: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: iload_1
    //   442: istore_2
    //   443: goto -198 -> 245
    //   446: astore 6
    //   448: aconst_null
    //   449: astore 5
    //   451: iconst_0
    //   452: istore_1
    //   453: ldc 86
    //   455: ldc_w 343
    //   458: aload 6
    //   460: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   463: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   466: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: ldc2_w 302
    //   472: ldc2_w 344
    //   475: lconst_1
    //   476: invokestatic 309	com/tencent/xweb/util/l:y	(JJJ)V
    //   479: iconst_0
    //   480: ifeq +11 -> 491
    //   483: new 347	java/lang/NullPointerException
    //   486: dup
    //   487: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   490: athrow
    //   491: iload_3
    //   492: istore_0
    //   493: iload_1
    //   494: istore_2
    //   495: aload 5
    //   497: ifnull -252 -> 245
    //   500: aload 5
    //   502: invokevirtual 280	java/io/RandomAccessFile:close	()V
    //   505: iload_3
    //   506: istore_0
    //   507: iload_1
    //   508: istore_2
    //   509: goto -264 -> 245
    //   512: astore 5
    //   514: ldc 86
    //   516: ldc_w 341
    //   519: aload 5
    //   521: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   524: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   527: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: iload_3
    //   531: istore_0
    //   532: iload_1
    //   533: istore_2
    //   534: goto -289 -> 245
    //   537: astore 6
    //   539: ldc 86
    //   541: ldc_w 339
    //   544: aload 6
    //   546: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   549: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: goto -64 -> 491
    //   558: astore 4
    //   560: iconst_0
    //   561: ifeq +11 -> 572
    //   564: new 347	java/lang/NullPointerException
    //   567: dup
    //   568: invokespecial 348	java/lang/NullPointerException:<init>	()V
    //   571: athrow
    //   572: aload 5
    //   574: ifnull +8 -> 582
    //   577: aload 5
    //   579: invokevirtual 280	java/io/RandomAccessFile:close	()V
    //   582: ldc 208
    //   584: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   587: aload 4
    //   589: athrow
    //   590: astore 6
    //   592: ldc 86
    //   594: ldc_w 339
    //   597: aload 6
    //   599: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   602: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   605: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: goto -36 -> 572
    //   611: astore 5
    //   613: ldc 86
    //   615: ldc_w 341
    //   618: aload 5
    //   620: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   623: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   626: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: goto -47 -> 582
    //   632: aload 4
    //   634: astore 5
    //   636: iload_0
    //   637: ifeq -335 -> 302
    //   640: ldc 86
    //   642: ldc_w 350
    //   645: invokestatic 155	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   648: aload 4
    //   650: astore 5
    //   652: goto -350 -> 302
    //   655: astore 4
    //   657: ldc 86
    //   659: ldc_w 352
    //   662: aload 4
    //   664: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   667: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   670: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: ldc2_w 302
    //   676: ldc2_w 353
    //   679: lconst_1
    //   680: invokestatic 309	com/tencent/xweb/util/l:y	(JJJ)V
    //   683: ldc 208
    //   685: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: goto -667 -> 21
    //   691: ldc 86
    //   693: new 282	java/lang/StringBuilder
    //   696: dup
    //   697: ldc_w 356
    //   700: invokespecial 359	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   703: getstatic 233	android/os/Build$VERSION:SDK_INT	I
    //   706: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   709: ldc_w 361
    //   712: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 155	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: ldc 208
    //   723: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: goto -705 -> 21
    //   729: astore 6
    //   731: aconst_null
    //   732: astore 5
    //   734: iconst_1
    //   735: istore_1
    //   736: goto -283 -> 453
    //   739: astore 6
    //   741: iconst_1
    //   742: istore_1
    //   743: goto -290 -> 453
    //   746: astore 5
    //   748: goto -406 -> 342
    //   751: iload_1
    //   752: istore_2
    //   753: goto -508 -> 245
    //   756: astore 5
    //   758: aconst_null
    //   759: astore 4
    //   761: goto -419 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   95	542	0	i	int
    //   215	537	1	j	int
    //   244	509	2	k	int
    //   1	530	3	m	int
    //   46	6	4	localObject1	Object
    //   109	152	4	localObject2	Object
    //   558	91	4	localObject3	Object
    //   655	8	4	localObject4	Object
    //   759	1	4	localObject5	Object
    //   105	271	5	localObject6	Object
    //   423	8	5	localObject7	Object
    //   449	52	5	localObject8	Object
    //   512	66	5	localObject9	Object
    //   611	8	5	localObject10	Object
    //   634	99	5	localObject11	Object
    //   746	1	5	localObject12	Object
    //   756	1	5	localObject13	Object
    //   212	174	6	localFileLock	java.nio.channels.FileLock
    //   402	8	6	localObject14	Object
    //   446	13	6	localObject15	Object
    //   537	8	6	localObject16	Object
    //   590	8	6	localObject17	Object
    //   729	1	6	localObject18	Object
    //   739	1	6	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   5	21	46	finally
    //   25	43	46	finally
    //   54	89	46	finally
    //   92	96	46	finally
    //   253	302	46	finally
    //   334	339	46	finally
    //   342	358	46	finally
    //   404	420	46	finally
    //   425	441	46	finally
    //   514	530	46	finally
    //   539	555	46	finally
    //   582	590	46	finally
    //   592	608	46	finally
    //   613	629	46	finally
    //   640	648	46	finally
    //   657	688	46	finally
    //   691	726	46	finally
    //   223	233	402	finally
    //   238	243	423	finally
    //   160	208	446	finally
    //   500	505	512	finally
    //   483	491	537	finally
    //   453	479	558	finally
    //   564	572	590	finally
    //   577	582	611	finally
    //   302	334	655	finally
    //   361	375	729	finally
    //   375	385	739	finally
    //   111	122	746	finally
    //   126	137	746	finally
    //   141	156	746	finally
    //   102	107	756	finally
  }
  
  private static aa oT(Context paramContext)
  {
    AppMethodBeat.i(212464);
    if (aa.kfE() == null) {
      aa.oP(paramContext);
    }
    paramContext = aa.kfE();
    AppMethodBeat.o(212464);
    return paramContext;
  }
  
  public static void oU(Context paramContext)
  {
    AppMethodBeat.i(212471);
    try
    {
      oT(paramContext);
      aa.OS(true);
      AppMethodBeat.o(212471);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("XWebSdkInternal", "setEnableCheckStorage failed, error:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(212471);
    }
  }
  
  public static void oV(Context paramContext)
  {
    AppMethodBeat.i(212481);
    try
    {
      oT(paramContext);
      aa.OR(true);
      AppMethodBeat.o(212481);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("XWebSdkInternal", "setEnableLocalDebug failed, error:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(212481);
    }
  }
  
  static final class a
    implements u.a
  {
    public final void ET(int paramInt) {}
    
    public final void EU(int paramInt)
    {
      AppMethodBeat.i(212373);
      if (paramInt == 0)
      {
        if (!ao.kgw())
        {
          Log.i("XWebSdkInternal", "onUpdateFinished, not waiting for xweb");
          AppMethodBeat.o(212373);
          return;
        }
        paramInt = XWalkEnvironment.getAvailableVersion();
        int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        if ((paramInt <= 0) && (i > 0) && (!"true".equalsIgnoreCase(a.keX().bHl("dis_reinit_web_core"))))
        {
          WebView.WebViewKind localWebViewKind = XWalkEnvironment.getWebViewKindFromAvailableVersion();
          Log.i("XWebSdkInternal", "onUpdateFinished, loadedVersion:" + paramInt + ", installedVersion:" + i + ", webViewKind:" + localWebViewKind);
          if (localWebViewKind == WebView.WebViewKind.aifI)
          {
            WebView.reinitToXWalk();
            AppMethodBeat.o(212373);
            return;
          }
          if (localWebViewKind == WebView.WebViewKind.aifL) {
            WebView.reinitToPinus();
          }
        }
      }
      AppMethodBeat.o(212373);
    }
    
    public final void EV(int paramInt) {}
    
    public final void cTB()
    {
      AppMethodBeat.i(212376);
      XWalkGrayValueUtil.resetGrayValue();
      if (!"true".equalsIgnoreCase(a.keX().qM("dis_refresh_main_cmd", "tools")))
      {
        a.keY();
        v.bDL();
        AppMethodBeat.o(212376);
        return;
      }
      Log.i("XWebSdkInternal", "onMainCfgUpdated, dis_refresh_main_cmd false");
      AppMethodBeat.o(212376);
    }
    
    public final void cTC()
    {
      AppMethodBeat.i(212377);
      if (!"true".equalsIgnoreCase(a.keX().qM("dis_refresh_plugin_cmd", "tools")))
      {
        b.kfj();
        AppMethodBeat.o(212377);
        return;
      }
      Log.i("XWebSdkInternal", "onPluginCfgUpdated, dis_refresh_plugin_cmd false");
      AppMethodBeat.o(212377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.ap
 * JD-Core Version:    0.7.0.1
 */