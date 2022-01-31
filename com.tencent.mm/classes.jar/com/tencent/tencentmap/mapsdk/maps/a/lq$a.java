package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.os.AsyncTask;

class lq$a
  extends AsyncTask<Context, Void, Void>
{
  private lq$a(lq paramlq) {}
  
  /* Error */
  protected Void a(Context... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: iconst_0
    //   5: istore 4
    //   7: ldc 24
    //   9: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: invokestatic 35	com/tencent/tencentmap/mapsdk/maps/a/lm:a	()I
    //   15: istore 5
    //   17: new 37	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   24: astore 7
    //   26: aload 7
    //   28: ldc 40
    //   30: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 7
    //   36: ldc 46
    //   38: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: ifnull +27 -> 70
    //   46: aload_1
    //   47: arraylength
    //   48: ifle +22 -> 70
    //   51: aload 7
    //   53: aload_0
    //   54: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   57: aload_1
    //   58: iconst_0
    //   59: aaload
    //   60: invokevirtual 52	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   63: invokestatic 55	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;Landroid/content/Context;)Ljava/lang/String;
    //   66: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: new 57	java/net/URL
    //   73: dup
    //   74: aload 7
    //   76: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 64	java/net/URL:<init>	(Ljava/lang/String;)V
    //   82: invokevirtual 68	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   85: checkcast 70	javax/net/ssl/HttpsURLConnection
    //   88: astore_1
    //   89: aload_1
    //   90: sipush 3000
    //   93: invokevirtual 73	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   96: aload_1
    //   97: invokevirtual 76	javax/net/ssl/HttpsURLConnection:connect	()V
    //   100: aload_1
    //   101: invokevirtual 80	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   104: astore 7
    //   106: aload 7
    //   108: invokestatic 85	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/InputStream;)[B
    //   111: astore 8
    //   113: aload 8
    //   115: ifnull +13 -> 128
    //   118: aload 8
    //   120: arraylength
    //   121: istore 6
    //   123: iload 6
    //   125: ifne +123 -> 248
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 88	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   136: aload 7
    //   138: ifnull +8 -> 146
    //   141: aload 7
    //   143: invokestatic 91	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   146: iload 4
    //   148: istore_2
    //   149: iload 5
    //   151: invokestatic 35	com/tencent/tencentmap/mapsdk/maps/a/lm:a	()I
    //   154: if_icmpeq +5 -> 159
    //   157: iconst_1
    //   158: istore_2
    //   159: iload_2
    //   160: ifeq +81 -> 241
    //   163: aload_0
    //   164: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   167: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   170: ifnull +71 -> 241
    //   173: aload_0
    //   174: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   177: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   180: iload 5
    //   182: invokestatic 97	com/tencent/tencentmap/mapsdk/maps/a/lm:a	(Landroid/content/Context;I)V
    //   185: aload_0
    //   186: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   189: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   192: invokestatic 102	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/maps/a/ni;
    //   195: iconst_1
    //   196: invokevirtual 105	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(I)Z
    //   199: pop
    //   200: aload_0
    //   201: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   204: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   207: ifnull +34 -> 241
    //   210: aload_0
    //   211: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   214: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   217: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   220: ifnull +21 -> 241
    //   223: aload_0
    //   224: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   227: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   230: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   233: checkcast 117	com/tencent/tencentmap/mapsdk/maps/a/lq$b
    //   236: invokeinterface 120 1 0
    //   241: ldc 24
    //   243: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aconst_null
    //   247: areturn
    //   248: new 125	java/lang/String
    //   251: dup
    //   252: aload 8
    //   254: invokespecial 128	java/lang/String:<init>	([B)V
    //   257: astore 8
    //   259: aload_0
    //   260: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   263: aload 8
    //   265: iload 5
    //   267: invokestatic 131	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;Ljava/lang/String;I)I
    //   270: istore 4
    //   272: aload_1
    //   273: ifnull +7 -> 280
    //   276: aload_1
    //   277: invokevirtual 88	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   280: aload 7
    //   282: ifnull +8 -> 290
    //   285: aload 7
    //   287: invokestatic 91	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   290: iload 4
    //   292: invokestatic 35	com/tencent/tencentmap/mapsdk/maps/a/lm:a	()I
    //   295: if_icmpeq +5 -> 300
    //   298: iconst_1
    //   299: istore_2
    //   300: iload_2
    //   301: ifeq +81 -> 382
    //   304: aload_0
    //   305: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   308: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   311: ifnull +71 -> 382
    //   314: aload_0
    //   315: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   318: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   321: iload 4
    //   323: invokestatic 97	com/tencent/tencentmap/mapsdk/maps/a/lm:a	(Landroid/content/Context;I)V
    //   326: aload_0
    //   327: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   330: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   333: invokestatic 102	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/maps/a/ni;
    //   336: iconst_1
    //   337: invokevirtual 105	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(I)Z
    //   340: pop
    //   341: aload_0
    //   342: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   345: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   348: ifnull +34 -> 382
    //   351: aload_0
    //   352: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   355: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   358: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   361: ifnull +21 -> 382
    //   364: aload_0
    //   365: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   368: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   371: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   374: checkcast 117	com/tencent/tencentmap/mapsdk/maps/a/lq$b
    //   377: invokeinterface 120 1 0
    //   382: ldc 24
    //   384: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   387: aconst_null
    //   388: areturn
    //   389: astore 8
    //   391: aconst_null
    //   392: astore_1
    //   393: aconst_null
    //   394: astore 7
    //   396: new 37	java/lang/StringBuilder
    //   399: dup
    //   400: ldc 133
    //   402: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   405: aload 8
    //   407: invokevirtual 135	java/lang/Throwable:toString	()Ljava/lang/String;
    //   410: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 7
    //   416: ifnull +8 -> 424
    //   419: aload 7
    //   421: invokevirtual 88	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   424: aload_1
    //   425: ifnull +7 -> 432
    //   428: aload_1
    //   429: invokestatic 91	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   432: iload_3
    //   433: istore_2
    //   434: iload 5
    //   436: invokestatic 35	com/tencent/tencentmap/mapsdk/maps/a/lm:a	()I
    //   439: if_icmpeq +5 -> 444
    //   442: iconst_1
    //   443: istore_2
    //   444: iload_2
    //   445: ifeq -63 -> 382
    //   448: aload_0
    //   449: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   452: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   455: ifnull -73 -> 382
    //   458: aload_0
    //   459: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   462: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   465: iload 5
    //   467: invokestatic 97	com/tencent/tencentmap/mapsdk/maps/a/lm:a	(Landroid/content/Context;I)V
    //   470: aload_0
    //   471: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   474: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   477: invokestatic 102	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/maps/a/ni;
    //   480: iconst_1
    //   481: invokevirtual 105	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(I)Z
    //   484: pop
    //   485: aload_0
    //   486: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   489: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   492: ifnull -110 -> 382
    //   495: aload_0
    //   496: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   499: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   502: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   505: ifnull -123 -> 382
    //   508: aload_0
    //   509: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   512: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   515: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   518: checkcast 117	com/tencent/tencentmap/mapsdk/maps/a/lq$b
    //   521: invokeinterface 120 1 0
    //   526: goto -144 -> 382
    //   529: astore 8
    //   531: aconst_null
    //   532: astore_1
    //   533: aconst_null
    //   534: astore 7
    //   536: aload 7
    //   538: ifnull +8 -> 546
    //   541: aload 7
    //   543: invokevirtual 88	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   546: aload_1
    //   547: ifnull +7 -> 554
    //   550: aload_1
    //   551: invokestatic 91	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   554: iload 5
    //   556: invokestatic 35	com/tencent/tencentmap/mapsdk/maps/a/lm:a	()I
    //   559: if_icmpeq +95 -> 654
    //   562: iconst_1
    //   563: istore_2
    //   564: iload_2
    //   565: ifeq +81 -> 646
    //   568: aload_0
    //   569: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   572: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   575: ifnull +71 -> 646
    //   578: aload_0
    //   579: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   582: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   585: iload 5
    //   587: invokestatic 97	com/tencent/tencentmap/mapsdk/maps/a/lm:a	(Landroid/content/Context;I)V
    //   590: aload_0
    //   591: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   594: invokestatic 94	com/tencent/tencentmap/mapsdk/maps/a/lq:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Landroid/content/Context;
    //   597: invokestatic 102	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/maps/a/ni;
    //   600: iconst_1
    //   601: invokevirtual 105	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(I)Z
    //   604: pop
    //   605: aload_0
    //   606: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   609: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   612: ifnull +34 -> 646
    //   615: aload_0
    //   616: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   619: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   622: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   625: ifnull +21 -> 646
    //   628: aload_0
    //   629: getfield 13	com/tencent/tencentmap/mapsdk/maps/a/lq$a:a	Lcom/tencent/tencentmap/mapsdk/maps/a/lq;
    //   632: invokestatic 109	com/tencent/tencentmap/mapsdk/maps/a/lq:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/lq;)Ljava/lang/ref/WeakReference;
    //   635: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   638: checkcast 117	com/tencent/tencentmap/mapsdk/maps/a/lq$b
    //   641: invokeinterface 120 1 0
    //   646: ldc 24
    //   648: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   651: aload 8
    //   653: athrow
    //   654: iconst_0
    //   655: istore_2
    //   656: goto -92 -> 564
    //   659: astore 8
    //   661: aconst_null
    //   662: astore 9
    //   664: aload_1
    //   665: astore 7
    //   667: aload 9
    //   669: astore_1
    //   670: goto -134 -> 536
    //   673: astore 8
    //   675: aload_1
    //   676: astore 9
    //   678: aload 7
    //   680: astore_1
    //   681: aload 9
    //   683: astore 7
    //   685: goto -149 -> 536
    //   688: astore 8
    //   690: goto -154 -> 536
    //   693: astore 8
    //   695: aconst_null
    //   696: astore 9
    //   698: aload_1
    //   699: astore 7
    //   701: aload 9
    //   703: astore_1
    //   704: goto -308 -> 396
    //   707: astore 8
    //   709: aload_1
    //   710: astore 9
    //   712: aload 7
    //   714: astore_1
    //   715: aload 9
    //   717: astore 7
    //   719: goto -323 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	this	a
    //   0	722	1	paramVarArgs	Context[]
    //   1	655	2	i	int
    //   3	430	3	j	int
    //   5	317	4	k	int
    //   15	571	5	m	int
    //   121	3	6	n	int
    //   24	694	7	localObject1	java.lang.Object
    //   111	153	8	localObject2	java.lang.Object
    //   389	17	8	localThrowable1	java.lang.Throwable
    //   529	123	8	localObject3	java.lang.Object
    //   659	1	8	localObject4	java.lang.Object
    //   673	1	8	localObject5	java.lang.Object
    //   688	1	8	localObject6	java.lang.Object
    //   693	1	8	localThrowable2	java.lang.Throwable
    //   707	1	8	localThrowable3	java.lang.Throwable
    //   662	54	9	arrayOfContext	Context[]
    // Exception table:
    //   from	to	target	type
    //   70	89	389	java/lang/Throwable
    //   70	89	529	finally
    //   89	106	659	finally
    //   106	113	673	finally
    //   118	123	673	finally
    //   248	272	673	finally
    //   396	414	688	finally
    //   89	106	693	java/lang/Throwable
    //   106	113	707	java/lang/Throwable
    //   118	123	707	java/lang/Throwable
    //   248	272	707	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lq.a
 * JD-Core Version:    0.7.0.1
 */