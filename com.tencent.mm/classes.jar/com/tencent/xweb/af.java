package com.tencent.xweb;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.xwalk.b;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class af
{
  static b INX;
  private static boolean INY = false;
  static boolean INZ = false;
  
  public static a B(String paramString, Object paramObject)
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
        paramString = j.g(WebView.c.INC);
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
  
  public static void a(b paramb)
  {
    try
    {
      INX = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
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
      j.g(WebView.getCurWebType()).clearAllWebViewCache(localContext, paramBoolean);
      AppMethodBeat.o(156939);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("XWebSdk", "clearAllWebViewCache failed: " + paramContext.getMessage());
      AppMethodBeat.o(156939);
    }
  }
  
  public static boolean frn()
  {
    AppMethodBeat.i(195166);
    if (!WebView.isXWalk())
    {
      Log.e("XWebSdk", "hasXWebFeature not xwalk now");
      AppMethodBeat.o(195166);
      return false;
    }
    Object localObject = l(80003, new Object[] { Integer.valueOf(2009) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(195166);
      return bool;
    }
    AppMethodBeat.o(195166);
    return false;
  }
  
  public static b fro()
  {
    try
    {
      b localb = INX;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void frp()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 156
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 16	com/tencent/xweb/af:INY	Z
    //   13: ifeq +12 -> 25
    //   16: ldc 156
    //   18: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: invokestatic 102	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   28: ifnonnull +26 -> 54
    //   31: ldc 84
    //   33: ldc 158
    //   35: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc 156
    //   40: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -22 -> 21
    //   46: astore 4
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload 4
    //   53: athrow
    //   54: invokestatic 102	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   57: invokevirtual 164	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   60: ifnull +32 -> 92
    //   63: invokestatic 102	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   66: invokevirtual 164	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   69: getfield 169	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   72: bipush 28
    //   74: if_icmpge +18 -> 92
    //   77: ldc 84
    //   79: ldc 171
    //   81: invokestatic 173	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: ldc 156
    //   86: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -68 -> 21
    //   92: getstatic 178	android/os/Build$VERSION:SDK_INT	I
    //   95: bipush 28
    //   97: if_icmplt +541 -> 638
    //   100: ldc 84
    //   102: ldc 180
    //   104: invokestatic 173	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aconst_null
    //   108: astore 4
    //   110: invokestatic 183	org/xwalk/core/XWalkEnvironment:getProcessName	()Ljava/lang/String;
    //   113: astore 5
    //   115: aload 5
    //   117: astore 4
    //   119: aload 5
    //   121: ldc 185
    //   123: ldc 187
    //   125: invokevirtual 191	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   128: astore 5
    //   130: aload 5
    //   132: astore 4
    //   134: aload 5
    //   136: ldc 193
    //   138: ldc 187
    //   140: invokevirtual 191	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   143: astore 5
    //   145: aload 5
    //   147: astore 4
    //   149: ldc 84
    //   151: ldc 195
    //   153: aload 5
    //   155: invokestatic 198	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokevirtual 202	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokestatic 173	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 5
    //   166: astore 4
    //   168: new 204	java/io/File
    //   171: dup
    //   172: invokestatic 102	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   175: ldc 206
    //   177: aload 4
    //   179: invokestatic 198	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   182: invokevirtual 202	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   185: iconst_0
    //   186: invokevirtual 210	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   189: invokevirtual 213	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   192: ldc 215
    //   194: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: astore 5
    //   199: aload 5
    //   201: invokevirtual 220	java/io/File:exists	()Z
    //   204: ifne +159 -> 363
    //   207: ldc 84
    //   209: ldc 222
    //   211: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aconst_null
    //   215: astore 5
    //   217: iconst_0
    //   218: istore_1
    //   219: iconst_0
    //   220: istore_0
    //   221: aload 5
    //   223: ifnull +430 -> 653
    //   226: aload 5
    //   228: invokevirtual 227	java/nio/channels/FileLock:release	()V
    //   231: aload 5
    //   233: invokevirtual 230	java/nio/channels/FileLock:close	()V
    //   236: iload_1
    //   237: istore_2
    //   238: iload_2
    //   239: ifeq +338 -> 577
    //   242: iload_0
    //   243: ifne +334 -> 577
    //   246: new 112	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   253: aload 4
    //   255: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokestatic 234	org/xwalk/core/XWalkEnvironment:getGrayValue	()I
    //   261: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: astore 5
    //   269: ldc 84
    //   271: ldc 239
    //   273: aload 5
    //   275: invokestatic 198	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   278: invokevirtual 202	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   281: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: ldc2_w 240
    //   287: ldc2_w 242
    //   290: lconst_1
    //   291: invokestatic 249	com/tencent/xweb/util/g:r	(JJJ)V
    //   294: ldc 251
    //   296: ldc 253
    //   298: iconst_1
    //   299: anewarray 255	java/lang/Class
    //   302: dup
    //   303: iconst_0
    //   304: ldc 39
    //   306: aastore
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload 5
    //   315: aastore
    //   316: invokestatic 261	com/tencent/xweb/util/f:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   319: pop
    //   320: iconst_1
    //   321: putstatic 16	com/tencent/xweb/af:INY	Z
    //   324: ldc 156
    //   326: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: goto -308 -> 21
    //   332: astore 5
    //   334: ldc 84
    //   336: new 112	java/lang/StringBuilder
    //   339: dup
    //   340: ldc_w 263
    //   343: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   346: aload 5
    //   348: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   351: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: goto -192 -> 168
    //   363: new 265	java/io/RandomAccessFile
    //   366: dup
    //   367: aload 5
    //   369: ldc_w 267
    //   372: invokespecial 270	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   375: invokevirtual 274	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   378: invokevirtual 280	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   381: astore 5
    //   383: aload 5
    //   385: ifnull +10 -> 395
    //   388: iconst_1
    //   389: istore_0
    //   390: iconst_1
    //   391: istore_1
    //   392: goto -171 -> 221
    //   395: iconst_0
    //   396: istore_0
    //   397: goto -7 -> 390
    //   400: astore 5
    //   402: ldc 84
    //   404: new 112	java/lang/StringBuilder
    //   407: dup
    //   408: ldc_w 282
    //   411: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   414: aload 5
    //   416: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   419: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: iload_1
    //   429: istore_2
    //   430: goto -192 -> 238
    //   433: astore 5
    //   435: iconst_0
    //   436: istore_1
    //   437: ldc 84
    //   439: new 112	java/lang/StringBuilder
    //   442: dup
    //   443: ldc_w 284
    //   446: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: aload 5
    //   451: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   454: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: ldc2_w 240
    //   466: ldc2_w 285
    //   469: lconst_1
    //   470: invokestatic 249	com/tencent/xweb/util/g:r	(JJJ)V
    //   473: iload_3
    //   474: istore_0
    //   475: iload_1
    //   476: istore_2
    //   477: iconst_0
    //   478: ifeq -240 -> 238
    //   481: new 288	java/lang/NullPointerException
    //   484: dup
    //   485: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   488: athrow
    //   489: astore 5
    //   491: ldc 84
    //   493: new 112	java/lang/StringBuilder
    //   496: dup
    //   497: ldc_w 282
    //   500: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload 5
    //   505: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   508: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: iload_3
    //   518: istore_0
    //   519: iload_1
    //   520: istore_2
    //   521: goto -283 -> 238
    //   524: astore 4
    //   526: iconst_0
    //   527: ifeq +11 -> 538
    //   530: new 288	java/lang/NullPointerException
    //   533: dup
    //   534: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   537: athrow
    //   538: ldc 156
    //   540: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: aload 4
    //   545: athrow
    //   546: astore 5
    //   548: ldc 84
    //   550: new 112	java/lang/StringBuilder
    //   553: dup
    //   554: ldc_w 282
    //   557: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   560: aload 5
    //   562: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   565: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   574: goto -36 -> 538
    //   577: aload 4
    //   579: astore 5
    //   581: iload_0
    //   582: ifeq -288 -> 294
    //   585: ldc 84
    //   587: ldc_w 291
    //   590: invokestatic 173	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload 4
    //   595: astore 5
    //   597: goto -303 -> 294
    //   600: astore 4
    //   602: ldc 84
    //   604: new 112	java/lang/StringBuilder
    //   607: dup
    //   608: ldc_w 293
    //   611: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   614: aload 4
    //   616: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   619: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: ldc2_w 240
    //   631: ldc2_w 294
    //   634: lconst_1
    //   635: invokestatic 249	com/tencent/xweb/util/g:r	(JJJ)V
    //   638: ldc 156
    //   640: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   643: goto -622 -> 21
    //   646: astore 5
    //   648: iconst_1
    //   649: istore_1
    //   650: goto -213 -> 437
    //   653: iload_1
    //   654: istore_2
    //   655: goto -417 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   220	362	0	i	int
    //   218	436	1	j	int
    //   237	418	2	k	int
    //   1	517	3	m	int
    //   46	6	4	localObject1	Object
    //   108	146	4	localObject2	Object
    //   524	70	4	localObject3	Object
    //   600	15	4	localException1	Exception
    //   113	201	5	localObject4	Object
    //   332	36	5	localException2	Exception
    //   381	3	5	localFileLock	java.nio.channels.FileLock
    //   400	15	5	localException3	Exception
    //   433	17	5	localException4	Exception
    //   489	15	5	localException5	Exception
    //   546	15	5	localException6	Exception
    //   579	17	5	localObject5	Object
    //   646	1	5	localException7	Exception
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
    //   294	324	46	finally
    //   324	329	46	finally
    //   334	360	46	finally
    //   402	428	46	finally
    //   481	489	46	finally
    //   491	517	46	finally
    //   530	538	46	finally
    //   538	546	46	finally
    //   548	574	46	finally
    //   585	593	46	finally
    //   602	638	46	finally
    //   638	643	46	finally
    //   110	115	332	java/lang/Exception
    //   119	130	332	java/lang/Exception
    //   134	145	332	java/lang/Exception
    //   149	164	332	java/lang/Exception
    //   226	236	400	java/lang/Exception
    //   168	214	433	java/lang/Exception
    //   481	489	489	java/lang/Exception
    //   168	214	524	finally
    //   363	383	524	finally
    //   437	473	524	finally
    //   530	538	546	java/lang/Exception
    //   294	324	600	java/lang/Exception
    //   363	383	646	java/lang/Exception
  }
  
  public static void frq()
  {
    AppMethodBeat.i(185176);
    Log.i("XWebSdk", "set wati for xweb = true");
    INZ = true;
    AppMethodBeat.o(185176);
  }
  
  public static boolean frr()
  {
    return INZ;
  }
  
  public static Object l(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(195165);
    try
    {
      j.a locala = j.g(WebView.c.INC);
      if (locala != null)
      {
        paramArrayOfObject = locala.excute("STR_CMD_INVOKE_TO_RUNTIME", new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
        AppMethodBeat.o(195165);
        return paramArrayOfObject;
      }
    }
    catch (Exception paramArrayOfObject)
    {
      Log.e("XWebSdk", "invokeExtension failed");
      AppMethodBeat.o(195165);
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
  
  public static boolean xq(long paramLong)
  {
    AppMethodBeat.i(195167);
    if (!WebView.isXWalk())
    {
      Log.e("XWebSdk", "bind_native_trans is  not xwalk now");
      AppMethodBeat.o(195167);
      return false;
    }
    try
    {
      j.a locala = j.g(WebView.c.INC);
      if (locala == null)
      {
        AppMethodBeat.o(195167);
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
    AppMethodBeat.o(195167);
    return true;
  }
  
  public static final class a
  {
    public int errorCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.af
 * JD-Core Version:    0.7.0.1
 */