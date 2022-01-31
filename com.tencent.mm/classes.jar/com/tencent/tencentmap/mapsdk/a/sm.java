package com.tencent.tencentmap.mapsdk.a;

public class sm
{
  private final String a;
  private StringBuffer b;
  private boolean c;
  
  /* Error */
  public sm()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokespecial 16	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: ldc 2
    //   10: invokevirtual 22	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   13: putfield 24	com/tencent/tencentmap/mapsdk/a/sm:a	Ljava/lang/String;
    //   16: aload_0
    //   17: new 26	java/lang/StringBuffer
    //   20: dup
    //   21: sipush 300
    //   24: invokespecial 29	java/lang/StringBuffer:<init>	(I)V
    //   27: putfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 33	com/tencent/tencentmap/mapsdk/a/sm:c	Z
    //   35: invokestatic 38	com/tencent/tencentmap/mapsdk/a/tn:a	()Landroid/content/Context;
    //   38: invokestatic 43	com/tencent/tencentmap/mapsdk/a/ub:a	(Landroid/content/Context;)Ljava/lang/String;
    //   41: astore 5
    //   43: aload 5
    //   45: ldc 45
    //   47: invokestatic 51	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 5
    //   52: aload_0
    //   53: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   56: ldc 53
    //   58: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   61: pop
    //   62: aload_0
    //   63: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   66: aload 5
    //   68: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   71: pop
    //   72: aload_0
    //   73: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   76: ldc 59
    //   78: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   81: pop
    //   82: aload_0
    //   83: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   86: ldc 61
    //   88: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   91: pop
    //   92: aload_0
    //   93: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   96: ldc 63
    //   98: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: pop
    //   102: aload_0
    //   103: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   106: ldc 65
    //   108: ldc 45
    //   110: invokestatic 51	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   113: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: pop
    //   117: aload_0
    //   118: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   121: ldc 67
    //   123: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   126: pop
    //   127: aload_0
    //   128: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   131: getstatic 72	android/os/Build:MODEL	Ljava/lang/String;
    //   134: ldc 45
    //   136: invokestatic 51	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   139: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload_0
    //   144: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   147: ldc 74
    //   149: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   152: pop
    //   153: aload_0
    //   154: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   157: getstatic 80	android/os/Build$VERSION:SDK_INT	I
    //   160: invokevirtual 83	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   163: pop
    //   164: aload_0
    //   165: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   168: ldc 85
    //   170: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   173: pop
    //   174: aload_0
    //   175: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   178: invokestatic 38	com/tencent/tencentmap/mapsdk/a/tn:a	()Landroid/content/Context;
    //   181: invokevirtual 90	android/content/Context:getPackageName	()Ljava/lang/String;
    //   184: ldc 45
    //   186: invokestatic 51	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   192: pop
    //   193: aload_0
    //   194: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   197: ldc 92
    //   199: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   202: pop
    //   203: aload_0
    //   204: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   207: invokestatic 38	com/tencent/tencentmap/mapsdk/a/tn:a	()Landroid/content/Context;
    //   210: invokestatic 96	com/tencent/tencentmap/mapsdk/a/sx:b	(Landroid/content/Context;)Ljava/lang/String;
    //   213: invokestatic 99	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   219: pop
    //   220: aload_0
    //   221: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   224: ldc 101
    //   226: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   229: pop
    //   230: aload_0
    //   231: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   234: invokestatic 103	com/tencent/tencentmap/mapsdk/a/ub:a	()Ljava/lang/String;
    //   237: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   240: pop
    //   241: invokestatic 38	com/tencent/tencentmap/mapsdk/a/tn:a	()Landroid/content/Context;
    //   244: invokevirtual 107	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   247: astore 5
    //   249: aload 5
    //   251: invokestatic 38	com/tencent/tencentmap/mapsdk/a/tn:a	()Landroid/content/Context;
    //   254: invokevirtual 90	android/content/Context:getPackageName	()Ljava/lang/String;
    //   257: iconst_0
    //   258: invokevirtual 113	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   261: astore 7
    //   263: aload 7
    //   265: getfield 119	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   268: aload 5
    //   270: invokevirtual 125	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   273: invokeinterface 130 1 0
    //   278: astore 5
    //   280: aload 7
    //   282: getfield 133	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   285: astore 7
    //   287: aload 7
    //   289: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: istore 4
    //   294: iload 4
    //   296: ifne +211 -> 507
    //   299: aload 7
    //   301: astore 6
    //   303: aload 5
    //   305: astore 7
    //   307: aload 6
    //   309: astore 5
    //   311: aload 7
    //   313: ifnull +28 -> 341
    //   316: aload_0
    //   317: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   320: ldc 141
    //   322: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   325: pop
    //   326: aload_0
    //   327: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   330: aload 7
    //   332: ldc 45
    //   334: invokestatic 51	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   337: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   340: pop
    //   341: aload 5
    //   343: ifnull +28 -> 371
    //   346: aload_0
    //   347: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   350: ldc 143
    //   352: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   355: pop
    //   356: aload_0
    //   357: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   360: aload 5
    //   362: ldc 45
    //   364: invokestatic 51	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   367: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   370: pop
    //   371: invokestatic 38	com/tencent/tencentmap/mapsdk/a/tn:a	()Landroid/content/Context;
    //   374: invokevirtual 147	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   377: invokevirtual 153	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   380: astore 5
    //   382: aload 5
    //   384: getfield 158	android/util/DisplayMetrics:densityDpi	I
    //   387: istore_1
    //   388: aload 5
    //   390: getfield 161	android/util/DisplayMetrics:widthPixels	I
    //   393: istore_2
    //   394: aload 5
    //   396: getfield 164	android/util/DisplayMetrics:heightPixels	I
    //   399: istore_3
    //   400: aload_0
    //   401: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   404: ldc 166
    //   406: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   409: pop
    //   410: aload_0
    //   411: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   414: iload_1
    //   415: invokevirtual 83	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   418: pop
    //   419: aload_0
    //   420: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   423: ldc 168
    //   425: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   428: pop
    //   429: aload_0
    //   430: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   433: iload_2
    //   434: invokevirtual 83	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   437: pop
    //   438: aload_0
    //   439: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   442: ldc 170
    //   444: invokevirtual 57	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   447: pop
    //   448: aload_0
    //   449: getfield 31	com/tencent/tencentmap/mapsdk/a/sm:b	Ljava/lang/StringBuffer;
    //   452: iload_3
    //   453: invokevirtual 83	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   456: pop
    //   457: return
    //   458: astore 5
    //   460: aconst_null
    //   461: astore 5
    //   463: aload 5
    //   465: astore 7
    //   467: aload 6
    //   469: astore 5
    //   471: goto -160 -> 311
    //   474: astore 5
    //   476: return
    //   477: astore 5
    //   479: goto -108 -> 371
    //   482: astore 6
    //   484: goto -143 -> 341
    //   487: astore 7
    //   489: goto -26 -> 463
    //   492: astore 5
    //   494: goto -274 -> 220
    //   497: astore 5
    //   499: goto -382 -> 117
    //   502: astore 5
    //   504: goto -432 -> 72
    //   507: aconst_null
    //   508: astore 6
    //   510: goto -207 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	sm
    //   387	28	1	i	int
    //   393	41	2	j	int
    //   399	54	3	k	int
    //   292	3	4	bool	boolean
    //   41	354	5	localObject1	Object
    //   458	1	5	localException1	java.lang.Exception
    //   461	9	5	localObject2	Object
    //   474	1	5	localException2	java.lang.Exception
    //   477	1	5	localException3	java.lang.Exception
    //   492	1	5	localException4	java.lang.Exception
    //   497	1	5	localException5	java.lang.Exception
    //   502	1	5	localException6	java.lang.Exception
    //   1	467	6	localObject3	Object
    //   482	1	6	localException7	java.lang.Exception
    //   508	1	6	localObject4	Object
    //   261	205	7	localObject5	Object
    //   487	1	7	localException8	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   241	280	458	java/lang/Exception
    //   371	457	474	java/lang/Exception
    //   356	371	477	java/lang/Exception
    //   326	341	482	java/lang/Exception
    //   280	294	487	java/lang/Exception
    //   117	220	492	java/lang/Exception
    //   102	117	497	java/lang/Exception
    //   43	72	502	java/lang/Exception
  }
  
  public final void a()
  {
    if (this.c) {
      return;
    }
    new sm.1(this).start();
  }
  
  public final String b()
  {
    if (this.b == null) {
      return "";
    }
    return this.b.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sm
 * JD-Core Version:    0.7.0.1
 */