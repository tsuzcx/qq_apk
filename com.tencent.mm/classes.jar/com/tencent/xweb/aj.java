package com.tencent.xweb;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.xwalk.c;
import java.util.HashMap;
import java.util.Locale;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class aj
{
  static c aabJ;
  private static boolean aabK = false;
  static boolean aabL = false;
  
  public static a H(String paramString, Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(156937);
    a locala = new a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!(paramObject instanceof Bundle))
    {
      localObject1 = localObject2;
      if ((paramObject instanceof HashMap)) {
        localObject1 = (HashMap)paramObject;
      }
    }
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label78:
        locala.errorCode = -1;
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(156937);
      return locala;
      if (!paramString.equals("SET_INIT_ARG")) {
        break;
      }
      break label78;
      if (!paramString.equals("BASE_CONTEXT_CHANGED")) {
        break;
      }
      i = 1;
      break label78;
      XWalkEnvironment.setXWebInitArgs((HashMap)localObject1);
      continue;
      try
      {
        paramString = l.h(WebView.c.aabm);
        if (paramString != null)
        {
          paramString.excute("BASE_CONTEXT_CHANGED", new Object[] { paramObject });
          locala.errorCode = 0;
        }
      }
      catch (Exception paramString)
      {
        Log.e("XWebSdk", "excute context changed failed");
      }
    }
  }
  
  public static boolean Xd(long paramLong)
  {
    AppMethodBeat.i(195792);
    if (!WebView.isXWalk())
    {
      Log.e("XWebSdk", "bind_native_trans is  not xwalk now");
      AppMethodBeat.o(195792);
      return false;
    }
    try
    {
      l.a locala = l.h(WebView.c.aabm);
      if (locala == null)
      {
        AppMethodBeat.o(195792);
        return false;
      }
      locala.excute("STR_CMD_NATIVE_TRANS_INIT", new Object[] { Long.valueOf(paramLong) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWebSdk", "invokeExtension failed");
      }
    }
    AppMethodBeat.o(195792);
    return true;
  }
  
  public static void a(c paramc)
  {
    try
    {
      aabJ = paramc;
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(156939);
    Context localContext = paramContext;
    if (paramContext == null) {}
    try
    {
      localContext = XWalkEnvironment.getApplicationContext();
      if (localContext == null)
      {
        AppMethodBeat.o(156939);
        return;
      }
      l.h(WebView.getCurWebType()).clearAllWebViewCache(localContext, paramBoolean);
      AppMethodBeat.o(156939);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("XWebSdk", "clearAllWebViewCache failed: " + paramContext.getMessage());
      AppMethodBeat.o(156939);
    }
  }
  
  public static boolean iwL()
  {
    AppMethodBeat.i(195772);
    if (!WebView.isXWalk())
    {
      Log.e("XWebSdk", "hasXWebFeature not xwalk now");
      AppMethodBeat.o(195772);
      return false;
    }
    Object localObject = l(80003, new Object[] { Integer.valueOf(2009) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(195772);
      return bool;
    }
    AppMethodBeat.o(195772);
    return false;
  }
  
  public static c iwM()
  {
    try
    {
      c localc = aabJ;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void iwN()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 170
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 16	com/tencent/xweb/aj:aabK	Z
    //   13: ifeq +12 -> 25
    //   16: ldc 170
    //   18: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: invokestatic 123	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   28: ifnonnull +26 -> 54
    //   31: ldc 84
    //   33: ldc 172
    //   35: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc 170
    //   40: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -22 -> 21
    //   46: astore 4
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload 4
    //   53: athrow
    //   54: invokestatic 123	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   57: invokevirtual 178	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   60: ifnull +32 -> 92
    //   63: invokestatic 123	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   66: invokevirtual 178	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   69: getfield 183	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   72: bipush 28
    //   74: if_icmpge +18 -> 92
    //   77: ldc 84
    //   79: ldc 185
    //   81: invokestatic 187	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: ldc 170
    //   86: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -68 -> 21
    //   92: getstatic 192	android/os/Build$VERSION:SDK_INT	I
    //   95: bipush 28
    //   97: if_icmplt +543 -> 640
    //   100: ldc 84
    //   102: ldc 194
    //   104: invokestatic 187	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aconst_null
    //   108: astore 4
    //   110: invokestatic 197	org/xwalk/core/XWalkEnvironment:getProcessName	()Ljava/lang/String;
    //   113: astore 5
    //   115: aload 5
    //   117: astore 4
    //   119: aload 5
    //   121: ldc 199
    //   123: ldc 201
    //   125: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   128: astore 5
    //   130: aload 5
    //   132: astore 4
    //   134: aload 5
    //   136: ldc 207
    //   138: ldc 201
    //   140: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   143: astore 5
    //   145: aload 5
    //   147: astore 4
    //   149: ldc 84
    //   151: ldc 209
    //   153: aload 5
    //   155: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokevirtual 216	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokestatic 187	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 5
    //   166: astore 4
    //   168: new 218	java/io/File
    //   171: dup
    //   172: invokestatic 123	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   175: ldc 220
    //   177: aload 4
    //   179: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   182: invokevirtual 216	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   185: iconst_0
    //   186: invokevirtual 224	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   189: invokevirtual 227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   192: ldc 229
    //   194: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: astore 5
    //   199: aload 5
    //   201: invokevirtual 234	java/io/File:exists	()Z
    //   204: ifne +161 -> 365
    //   207: ldc 84
    //   209: ldc 236
    //   211: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aconst_null
    //   215: astore 5
    //   217: iconst_0
    //   218: istore_1
    //   219: iconst_0
    //   220: istore_0
    //   221: aload 5
    //   223: ifnull +432 -> 655
    //   226: aload 5
    //   228: invokevirtual 241	java/nio/channels/FileLock:release	()V
    //   231: aload 5
    //   233: invokevirtual 244	java/nio/channels/FileLock:close	()V
    //   236: iload_1
    //   237: istore_2
    //   238: iload_2
    //   239: ifeq +340 -> 579
    //   242: iload_0
    //   243: ifne +336 -> 579
    //   246: new 131	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   253: aload 4
    //   255: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokestatic 248	org/xwalk/core/XWalkEnvironment:getGrayValue	()I
    //   261: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: astore 5
    //   269: ldc 84
    //   271: ldc 253
    //   273: aload 5
    //   275: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   278: invokevirtual 216	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   281: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: ldc2_w 254
    //   287: ldc2_w 256
    //   290: lconst_1
    //   291: invokestatic 263	com/tencent/xweb/util/h:u	(JJJ)V
    //   294: ldc_w 265
    //   297: ldc_w 267
    //   300: iconst_1
    //   301: anewarray 269	java/lang/Class
    //   304: dup
    //   305: iconst_0
    //   306: ldc 39
    //   308: aastore
    //   309: iconst_1
    //   310: anewarray 4	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: aload 5
    //   317: aastore
    //   318: invokestatic 275	com/tencent/xweb/util/g:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   321: pop
    //   322: iconst_1
    //   323: putstatic 16	com/tencent/xweb/aj:aabK	Z
    //   326: ldc 170
    //   328: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: goto -310 -> 21
    //   334: astore 5
    //   336: ldc 84
    //   338: new 131	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 277
    //   345: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: aload 5
    //   350: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   353: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -194 -> 168
    //   365: new 279	java/io/RandomAccessFile
    //   368: dup
    //   369: aload 5
    //   371: ldc_w 281
    //   374: invokespecial 284	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   377: invokevirtual 288	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   380: invokevirtual 294	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   383: astore 5
    //   385: aload 5
    //   387: ifnull +10 -> 397
    //   390: iconst_1
    //   391: istore_0
    //   392: iconst_1
    //   393: istore_1
    //   394: goto -173 -> 221
    //   397: iconst_0
    //   398: istore_0
    //   399: goto -7 -> 392
    //   402: astore 5
    //   404: ldc 84
    //   406: new 131	java/lang/StringBuilder
    //   409: dup
    //   410: ldc_w 296
    //   413: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: aload 5
    //   418: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: iload_1
    //   431: istore_2
    //   432: goto -194 -> 238
    //   435: astore 5
    //   437: iconst_0
    //   438: istore_1
    //   439: ldc 84
    //   441: new 131	java/lang/StringBuilder
    //   444: dup
    //   445: ldc_w 298
    //   448: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   451: aload 5
    //   453: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   456: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: ldc2_w 254
    //   468: ldc2_w 299
    //   471: lconst_1
    //   472: invokestatic 263	com/tencent/xweb/util/h:u	(JJJ)V
    //   475: iload_3
    //   476: istore_0
    //   477: iload_1
    //   478: istore_2
    //   479: iconst_0
    //   480: ifeq -242 -> 238
    //   483: new 302	java/lang/NullPointerException
    //   486: dup
    //   487: invokespecial 303	java/lang/NullPointerException:<init>	()V
    //   490: athrow
    //   491: astore 5
    //   493: ldc 84
    //   495: new 131	java/lang/StringBuilder
    //   498: dup
    //   499: ldc_w 296
    //   502: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   505: aload 5
    //   507: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   510: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: iload_3
    //   520: istore_0
    //   521: iload_1
    //   522: istore_2
    //   523: goto -285 -> 238
    //   526: astore 5
    //   528: iconst_0
    //   529: ifeq +11 -> 540
    //   532: new 302	java/lang/NullPointerException
    //   535: dup
    //   536: invokespecial 303	java/lang/NullPointerException:<init>	()V
    //   539: athrow
    //   540: ldc 170
    //   542: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   545: aload 5
    //   547: athrow
    //   548: astore 4
    //   550: ldc 84
    //   552: new 131	java/lang/StringBuilder
    //   555: dup
    //   556: ldc_w 296
    //   559: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   562: aload 4
    //   564: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   567: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: goto -36 -> 540
    //   579: aload 4
    //   581: astore 5
    //   583: iload_0
    //   584: ifeq -290 -> 294
    //   587: ldc 84
    //   589: ldc_w 305
    //   592: invokestatic 187	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload 4
    //   597: astore 5
    //   599: goto -305 -> 294
    //   602: astore 4
    //   604: ldc 84
    //   606: new 131	java/lang/StringBuilder
    //   609: dup
    //   610: ldc_w 307
    //   613: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   616: aload 4
    //   618: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   621: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: ldc2_w 254
    //   633: ldc2_w 308
    //   636: lconst_1
    //   637: invokestatic 263	com/tencent/xweb/util/h:u	(JJJ)V
    //   640: ldc 170
    //   642: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   645: goto -624 -> 21
    //   648: astore 5
    //   650: iconst_1
    //   651: istore_1
    //   652: goto -213 -> 439
    //   655: iload_1
    //   656: istore_2
    //   657: goto -419 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   220	364	0	i	int
    //   218	438	1	j	int
    //   237	420	2	k	int
    //   1	519	3	m	int
    //   46	6	4	localObject1	Object
    //   108	146	4	localObject2	Object
    //   548	48	4	localException1	Exception
    //   602	15	4	localException2	Exception
    //   113	203	5	localObject3	Object
    //   334	36	5	localException3	Exception
    //   383	3	5	localFileLock	java.nio.channels.FileLock
    //   402	15	5	localException4	Exception
    //   435	17	5	localException5	Exception
    //   491	15	5	localException6	Exception
    //   526	20	5	localObject4	Object
    //   581	17	5	localException7	Exception
    //   648	1	5	localException8	Exception
    // Exception table:
    //   from	to	target	type
    //   5	21	46	finally
    //   25	43	46	finally
    //   54	89	46	finally
    //   92	107	46	finally
    //   110	115	46	finally
    //   119	130	46	finally
    //   134	145	46	finally
    //   149	164	46	finally
    //   226	236	46	finally
    //   246	294	46	finally
    //   294	326	46	finally
    //   326	331	46	finally
    //   336	362	46	finally
    //   404	430	46	finally
    //   483	491	46	finally
    //   493	519	46	finally
    //   532	540	46	finally
    //   540	548	46	finally
    //   550	576	46	finally
    //   587	595	46	finally
    //   604	640	46	finally
    //   640	645	46	finally
    //   110	115	334	java/lang/Exception
    //   119	130	334	java/lang/Exception
    //   134	145	334	java/lang/Exception
    //   149	164	334	java/lang/Exception
    //   226	236	402	java/lang/Exception
    //   168	214	435	java/lang/Exception
    //   483	491	491	java/lang/Exception
    //   168	214	526	finally
    //   365	385	526	finally
    //   439	475	526	finally
    //   532	540	548	java/lang/Exception
    //   294	326	602	java/lang/Exception
    //   365	385	648	java/lang/Exception
  }
  
  public static void iwO()
  {
    AppMethodBeat.i(185176);
    Log.i("XWebSdk", "set wati for xweb = true");
    aabL = true;
    AppMethodBeat.o(185176);
  }
  
  public static boolean iwP()
  {
    return aabL;
  }
  
  public static Object l(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(195771);
    try
    {
      l.a locala = l.h(WebView.c.aabm);
      if (locala != null)
      {
        paramArrayOfObject = locala.excute("STR_CMD_INVOKE_TO_RUNTIME", new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
        AppMethodBeat.o(195771);
        return paramArrayOfObject;
      }
    }
    catch (Exception paramArrayOfObject)
    {
      Log.e("XWebSdk", "invokeExtension failed");
      AppMethodBeat.o(195771);
    }
    return null;
  }
  
  public static void setSharedPreferenceProvider(ISharedPreferenceProvider paramISharedPreferenceProvider)
  {
    try
    {
      AppMethodBeat.i(156940);
      XWalkEnvironment.setSharedPreferenceProvider(paramISharedPreferenceProvider);
      AppMethodBeat.o(156940);
      return;
    }
    finally
    {
      paramISharedPreferenceProvider = finally;
      throw paramISharedPreferenceProvider;
    }
  }
  
  public static void updateResourceLocale(Locale paramLocale)
  {
    AppMethodBeat.i(195793);
    if (!WebView.isXWalk())
    {
      Log.e("XWebSdk", "[updateResourceLocale] not xwalk now");
      AppMethodBeat.o(195793);
      return;
    }
    try
    {
      l.a locala = l.h(WebView.c.aabm);
      if (locala == null)
      {
        Log.e("XWebSdk", "[updateResourceLocale] no xweb provider");
        AppMethodBeat.o(195793);
        return;
      }
      locala.excute("STR_CMD_UPDATE_RESOURCE_LOCALE", new Object[] { paramLocale });
      AppMethodBeat.o(195793);
      return;
    }
    catch (Exception paramLocale)
    {
      Log.e("XWebSdk", "[updateResourceLocale] error:", paramLocale);
      AppMethodBeat.o(195793);
    }
  }
  
  public static final class a
  {
    public int errorCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.aj
 * JD-Core Version:    0.7.0.1
 */