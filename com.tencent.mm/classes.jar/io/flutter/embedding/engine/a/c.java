package io.flutter.embedding.engine.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class c
{
  private FlutterJNI aapT;
  public b aarp;
  private long aarq;
  public b aarr;
  Future<a> aars;
  public boolean initialized = false;
  
  public c()
  {
    this(new FlutterJNI());
    AppMethodBeat.i(254354);
    AppMethodBeat.o(254354);
  }
  
  private c(FlutterJNI paramFlutterJNI)
  {
    this.aapT = paramFlutterJNI;
  }
  
  public final void a(final Context paramContext, b paramb)
  {
    AppMethodBeat.i(254356);
    if (this.aarp != null)
    {
      AppMethodBeat.o(254356);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("startInitialization must be called on the main thread");
      AppMethodBeat.o(254356);
      throw paramContext;
    }
    paramContext = paramContext.getApplicationContext();
    this.aarp = paramb;
    this.aarq = SystemClock.uptimeMillis();
    this.aarr = a.mK(paramContext);
    VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
    paramContext = new Callable() {};
    this.aars = Executors.newSingleThreadExecutor().submit(paramContext);
    AppMethodBeat.o(254356);
  }
  
  public final String bGf(String paramString)
  {
    AppMethodBeat.i(254360);
    paramString = this.aarr.aarl + File.separator + paramString;
    AppMethodBeat.o(254360);
    return paramString;
  }
  
  /* Error */
  public final void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc 165
    //   2: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 54	io/flutter/embedding/engine/a/c:initialized	Z
    //   9: ifeq +9 -> 18
    //   12: ldc 165
    //   14: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: return
    //   18: invokestatic 69	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   21: invokestatic 72	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   24: if_acmpeq +20 -> 44
    //   27: new 74	java/lang/IllegalStateException
    //   30: dup
    //   31: ldc 167
    //   33: invokespecial 79	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   36: astore_1
    //   37: ldc 165
    //   39: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: athrow
    //   44: aload_0
    //   45: getfield 63	io/flutter/embedding/engine/a/c:aarp	Lio/flutter/embedding/engine/a/c$b;
    //   48: ifnonnull +20 -> 68
    //   51: new 74	java/lang/IllegalStateException
    //   54: dup
    //   55: ldc 169
    //   57: invokespecial 79	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   60: astore_1
    //   61: ldc 165
    //   63: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: athrow
    //   68: aload_0
    //   69: getfield 135	io/flutter/embedding/engine/a/c:aars	Ljava/util/concurrent/Future;
    //   72: invokeinterface 175 1 0
    //   77: checkcast 14	io/flutter/embedding/engine/a/c$a
    //   80: astore 9
    //   82: new 177	java/util/ArrayList
    //   85: dup
    //   86: invokespecial 178	java/util/ArrayList:<init>	()V
    //   89: astore 10
    //   91: aload 10
    //   93: ldc 180
    //   95: invokeinterface 186 2 0
    //   100: pop
    //   101: aload 10
    //   103: new 140	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 188
    //   109: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_0
    //   113: getfield 101	io/flutter/embedding/engine/a/c:aarr	Lio/flutter/embedding/engine/a/b;
    //   116: getfield 192	io/flutter/embedding/engine/a/b:aarn	Ljava/lang/String;
    //   119: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 156	java/io/File:separator	Ljava/lang/String;
    //   125: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 194
    //   130: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokeinterface 186 2 0
    //   141: pop
    //   142: aload_2
    //   143: ifnull +10 -> 153
    //   146: aload 10
    //   148: aload_2
    //   149: invokestatic 200	java/util/Collections:addAll	(Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   152: pop
    //   153: aload 10
    //   155: new 140	java/lang/StringBuilder
    //   158: dup
    //   159: ldc 202
    //   161: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload_0
    //   165: getfield 101	io/flutter/embedding/engine/a/c:aarr	Lio/flutter/embedding/engine/a/b;
    //   168: getfield 205	io/flutter/embedding/engine/a/b:aari	Ljava/lang/String;
    //   171: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokeinterface 186 2 0
    //   182: pop
    //   183: aload 10
    //   185: new 140	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 202
    //   191: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: getfield 101	io/flutter/embedding/engine/a/c:aarr	Lio/flutter/embedding/engine/a/b;
    //   198: getfield 192	io/flutter/embedding/engine/a/b:aarn	Ljava/lang/String;
    //   201: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: getstatic 156	java/io/File:separator	Ljava/lang/String;
    //   207: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_0
    //   211: getfield 101	io/flutter/embedding/engine/a/c:aarr	Lio/flutter/embedding/engine/a/b;
    //   214: getfield 205	io/flutter/embedding/engine/a/b:aari	Ljava/lang/String;
    //   217: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokeinterface 186 2 0
    //   228: pop
    //   229: aload 10
    //   231: new 140	java/lang/StringBuilder
    //   234: dup
    //   235: ldc 207
    //   237: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload 9
    //   242: getfield 210	io/flutter/embedding/engine/a/c$a:aarz	Ljava/lang/String;
    //   245: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokeinterface 186 2 0
    //   256: pop
    //   257: aload_0
    //   258: getfield 101	io/flutter/embedding/engine/a/c:aarr	Lio/flutter/embedding/engine/a/b;
    //   261: getfield 213	io/flutter/embedding/engine/a/b:aaro	Z
    //   264: ifne +13 -> 277
    //   267: aload 10
    //   269: ldc 215
    //   271: invokeinterface 186 2 0
    //   276: pop
    //   277: aload_0
    //   278: getfield 101	io/flutter/embedding/engine/a/c:aarr	Lio/flutter/embedding/engine/a/b;
    //   281: getfield 218	io/flutter/embedding/engine/a/b:aarm	Ljava/lang/String;
    //   284: ifnull +33 -> 317
    //   287: aload 10
    //   289: new 140	java/lang/StringBuilder
    //   292: dup
    //   293: ldc 220
    //   295: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   298: aload_0
    //   299: getfield 101	io/flutter/embedding/engine/a/c:aarr	Lio/flutter/embedding/engine/a/b;
    //   302: getfield 218	io/flutter/embedding/engine/a/b:aarm	Ljava/lang/String;
    //   305: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokeinterface 186 2 0
    //   316: pop
    //   317: aload_0
    //   318: getfield 63	io/flutter/embedding/engine/a/c:aarp	Lio/flutter/embedding/engine/a/c$b;
    //   321: getfield 223	io/flutter/embedding/engine/a/c$b:logTag	Ljava/lang/String;
    //   324: ifnull +33 -> 357
    //   327: aload 10
    //   329: new 140	java/lang/StringBuilder
    //   332: dup
    //   333: ldc 225
    //   335: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   338: aload_0
    //   339: getfield 63	io/flutter/embedding/engine/a/c:aarp	Lio/flutter/embedding/engine/a/c$b;
    //   342: getfield 223	io/flutter/embedding/engine/a/c$b:logTag	Ljava/lang/String;
    //   345: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokeinterface 186 2 0
    //   356: pop
    //   357: aload_1
    //   358: invokevirtual 229	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   361: aload_1
    //   362: invokevirtual 232	android/content/Context:getPackageName	()Ljava/lang/String;
    //   365: sipush 128
    //   368: invokevirtual 238	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   371: getfield 244	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   374: astore_2
    //   375: aload_2
    //   376: ifnull +165 -> 541
    //   379: aload_2
    //   380: ldc 246
    //   382: invokevirtual 252	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   385: istore_3
    //   386: iload_3
    //   387: istore 4
    //   389: iload_3
    //   390: ifne +47 -> 437
    //   393: aload_1
    //   394: ldc 254
    //   396: invokevirtual 107	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   399: checkcast 256	android/app/ActivityManager
    //   402: astore 11
    //   404: new 258	android/app/ActivityManager$MemoryInfo
    //   407: dup
    //   408: invokespecial 259	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   411: astore 12
    //   413: aload 11
    //   415: aload 12
    //   417: invokevirtual 263	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   420: aload 12
    //   422: getfield 266	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   425: l2d
    //   426: ldc2_w 267
    //   429: ddiv
    //   430: ldc2_w 269
    //   433: ddiv
    //   434: d2i
    //   435: istore 4
    //   437: aload 10
    //   439: ldc_w 272
    //   442: iload 4
    //   444: invokestatic 278	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   447: invokevirtual 281	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   450: invokeinterface 186 2 0
    //   455: pop
    //   456: aload_2
    //   457: ifnull +24 -> 481
    //   460: aload_2
    //   461: ldc_w 283
    //   464: invokevirtual 287	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   467: ifeq +14 -> 481
    //   470: aload 10
    //   472: ldc_w 289
    //   475: invokeinterface 186 2 0
    //   480: pop
    //   481: invokestatic 91	android/os/SystemClock:uptimeMillis	()J
    //   484: lstore 5
    //   486: aload_0
    //   487: getfield 93	io/flutter/embedding/engine/a/c:aarq	J
    //   490: lstore 7
    //   492: aload_0
    //   493: getfield 56	io/flutter/embedding/engine/a/c:aapT	Lio/flutter/embedding/engine/FlutterJNI;
    //   496: aload_1
    //   497: aload 10
    //   499: iconst_0
    //   500: anewarray 274	java/lang/String
    //   503: invokeinterface 293 2 0
    //   508: checkcast 295	[Ljava/lang/String;
    //   511: aconst_null
    //   512: aload 9
    //   514: getfield 298	io/flutter/embedding/engine/a/c$a:aary	Ljava/lang/String;
    //   517: aload 9
    //   519: getfield 210	io/flutter/embedding/engine/a/c$a:aarz	Ljava/lang/String;
    //   522: lload 5
    //   524: lload 7
    //   526: lsub
    //   527: invokevirtual 301	io/flutter/embedding/engine/FlutterJNI:init	(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   530: aload_0
    //   531: iconst_1
    //   532: putfield 54	io/flutter/embedding/engine/a/c:initialized	Z
    //   535: ldc 165
    //   537: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   540: return
    //   541: iconst_0
    //   542: istore_3
    //   543: goto -157 -> 386
    //   546: astore_1
    //   547: invokestatic 306	io/flutter/b:iAi	()V
    //   550: new 308	java/lang/RuntimeException
    //   553: dup
    //   554: aload_1
    //   555: invokespecial 311	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   558: astore_1
    //   559: ldc 165
    //   561: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   564: aload_1
    //   565: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	c
    //   0	566	1	paramContext	Context
    //   0	566	2	paramArrayOfString	String[]
    //   385	158	3	i	int
    //   387	56	4	j	int
    //   484	39	5	l1	long
    //   490	35	7	l2	long
    //   80	438	9	locala	a
    //   89	409	10	localArrayList	java.util.ArrayList
    //   402	12	11	localActivityManager	android.app.ActivityManager
    //   411	10	12	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    // Exception table:
    //   from	to	target	type
    //   68	142	546	java/lang/Exception
    //   146	153	546	java/lang/Exception
    //   153	277	546	java/lang/Exception
    //   277	317	546	java/lang/Exception
    //   317	357	546	java/lang/Exception
    //   357	375	546	java/lang/Exception
    //   379	386	546	java/lang/Exception
    //   393	437	546	java/lang/Exception
    //   437	456	546	java/lang/Exception
    //   460	481	546	java/lang/Exception
    //   481	535	546	java/lang/Exception
  }
  
  public final String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(254358);
    paramString1 = bGf("packages" + File.separator + paramString2 + File.separator + paramString1);
    AppMethodBeat.o(254358);
    return paramString1;
  }
  
  public final void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(254355);
    a(paramContext, new b());
    AppMethodBeat.o(254355);
  }
  
  static final class a
  {
    final String aarA;
    final String aary;
    final String aarz;
    
    private a(String paramString1, String paramString2, String paramString3)
    {
      this.aary = paramString1;
      this.aarz = paramString2;
      this.aarA = paramString3;
    }
  }
  
  public static final class b
  {
    public String logTag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.a.c
 * JD-Core Version:    0.7.0.1
 */