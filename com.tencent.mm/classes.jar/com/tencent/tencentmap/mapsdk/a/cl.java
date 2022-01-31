package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public final class cl
  implements Runnable
{
  private static long a = 0L;
  private Context b = null;
  
  public cl(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private static long a()
  {
    try
    {
      long l = a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      a = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      int i = Integer.parseInt(a.b(paramContext, "querytimes", "0"));
      String str = a.b(paramContext, "initsdkdate", "");
      if (!e.g().equals(str))
      {
        a.b(paramContext, e.g());
        i = 0;
      }
      if (i <= cm.a().f())
      {
        a.a(paramContext, String.valueOf(i + 1));
        return false;
      }
      bool = true;
      cy.c(" set init times failed! ", new Object[0]);
    }
    catch (Exception paramContext)
    {
      try
      {
        cy.e(" sdk init max times", new Object[0]);
        return true;
      }
      catch (Exception paramContext)
      {
        boolean bool;
        break label78;
      }
      paramContext = paramContext;
      bool = false;
    }
    label78:
    return bool;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   4: invokestatic 97	com/tencent/tencentmap/mapsdk/a/e:h	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/cq;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnull +60 -> 71
    //   14: aload 6
    //   16: invokevirtual 101	com/tencent/tencentmap/mapsdk/a/cq:b	()I
    //   19: bipush 101
    //   21: if_icmpne +50 -> 71
    //   24: aload 6
    //   26: invokevirtual 104	com/tencent/tencentmap/mapsdk/a/cq:c	()[B
    //   29: ifnull +42 -> 71
    //   32: aload_0
    //   33: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   36: invokestatic 109	com/tencent/tencentmap/mapsdk/a/ck:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ck;
    //   39: invokevirtual 112	com/tencent/tencentmap/mapsdk/a/ck:f	()Lcom/tencent/tencentmap/mapsdk/a/dw;
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +25 -> 71
    //   49: aload 7
    //   51: bipush 101
    //   53: aload 6
    //   55: invokevirtual 104	com/tencent/tencentmap/mapsdk/a/cq:c	()[B
    //   58: iconst_0
    //   59: invokevirtual 117	com/tencent/tencentmap/mapsdk/a/dw:a	(I[BZ)V
    //   62: ldc 119
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_0
    //   72: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   75: invokestatic 109	com/tencent/tencentmap/mapsdk/a/ck:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ck;
    //   78: astore 7
    //   80: aload 7
    //   82: invokevirtual 122	com/tencent/tencentmap/mapsdk/a/ck:j	()I
    //   85: ifne +189 -> 274
    //   88: ldc 124
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload 7
    //   99: iconst_1
    //   100: invokevirtual 127	com/tencent/tencentmap/mapsdk/a/ck:a	(I)V
    //   103: aload_0
    //   104: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   107: invokestatic 129	com/tencent/tencentmap/mapsdk/a/a:c	(Landroid/content/Context;)Z
    //   110: istore_3
    //   111: ldc 131
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: iload_3
    //   120: invokestatic 136	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   123: aastore
    //   124: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: iload_3
    //   128: ifeq +112 -> 240
    //   131: ldc 138
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_0
    //   140: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   143: aconst_null
    //   144: invokestatic 143	com/tencent/tencentmap/mapsdk/a/cg:a	(Landroid/content/Context;[I)I
    //   147: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload 7
    //   156: monitorenter
    //   157: ldc 148
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload 7
    //   168: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/ck:i	()[Lcom/tencent/tencentmap/mapsdk/a/cj;
    //   171: astore 6
    //   173: aload 7
    //   175: invokevirtual 154	com/tencent/tencentmap/mapsdk/a/ck:h	()V
    //   178: aload 7
    //   180: monitorexit
    //   181: aload 6
    //   183: ifnull +91 -> 274
    //   186: ldc 156
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload 6
    //   197: arraylength
    //   198: istore_2
    //   199: iconst_0
    //   200: istore_1
    //   201: iload_1
    //   202: iload_2
    //   203: if_icmpge +71 -> 274
    //   206: aload 6
    //   208: iload_1
    //   209: aaload
    //   210: invokeinterface 160 1 0
    //   215: iload_1
    //   216: iconst_1
    //   217: iadd
    //   218: istore_1
    //   219: goto -18 -> 201
    //   222: astore 6
    //   224: aload 6
    //   226: invokestatic 163	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   229: goto -158 -> 71
    //   232: astore 6
    //   234: aload 7
    //   236: monitorexit
    //   237: aload 6
    //   239: athrow
    //   240: invokestatic 165	com/tencent/tencentmap/mapsdk/a/cl:a	()J
    //   243: lstore 4
    //   245: lload 4
    //   247: lconst_0
    //   248: lcmp
    //   249: ifle +25 -> 274
    //   252: ldc 167
    //   254: iconst_1
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: lload 4
    //   262: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   265: aastore
    //   266: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: lload 4
    //   271: invokestatic 177	java/lang/Thread:sleep	(J)V
    //   274: aload 7
    //   276: monitorenter
    //   277: ldc 179
    //   279: iconst_0
    //   280: anewarray 4	java/lang/Object
    //   283: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: aload 7
    //   288: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/ck:i	()[Lcom/tencent/tencentmap/mapsdk/a/cj;
    //   291: astore 6
    //   293: aload 7
    //   295: iconst_2
    //   296: invokevirtual 127	com/tencent/tencentmap/mapsdk/a/ck:a	(I)V
    //   299: aload 7
    //   301: monitorexit
    //   302: aload 6
    //   304: ifnull +57 -> 361
    //   307: ldc 181
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: aload 6
    //   318: arraylength
    //   319: istore_2
    //   320: iconst_0
    //   321: istore_1
    //   322: iload_1
    //   323: iload_2
    //   324: if_icmpge +37 -> 361
    //   327: aload 6
    //   329: iload_1
    //   330: aaload
    //   331: invokeinterface 183 1 0
    //   336: iload_1
    //   337: iconst_1
    //   338: iadd
    //   339: istore_1
    //   340: goto -18 -> 322
    //   343: astore 6
    //   345: aload 6
    //   347: invokestatic 163	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   350: goto -76 -> 274
    //   353: astore 6
    //   355: aload 7
    //   357: monitorexit
    //   358: aload 6
    //   360: athrow
    //   361: invokestatic 65	com/tencent/tencentmap/mapsdk/a/cm:a	()Lcom/tencent/tencentmap/mapsdk/a/cm;
    //   364: invokevirtual 186	com/tencent/tencentmap/mapsdk/a/cm:g	()Z
    //   367: ifne +82 -> 449
    //   370: invokestatic 189	com/tencent/tencentmap/mapsdk/a/ck:c	()Lcom/tencent/tencentmap/mapsdk/a/dx;
    //   373: astore 6
    //   375: iconst_0
    //   376: istore_1
    //   377: aload 6
    //   379: ifnonnull +36 -> 415
    //   382: iload_1
    //   383: iconst_1
    //   384: iadd
    //   385: istore_1
    //   386: iload_1
    //   387: iconst_5
    //   388: if_icmpge +27 -> 415
    //   391: ldc2_w 190
    //   394: invokestatic 177	java/lang/Thread:sleep	(J)V
    //   397: invokestatic 189	com/tencent/tencentmap/mapsdk/a/ck:c	()Lcom/tencent/tencentmap/mapsdk/a/dx;
    //   400: astore 6
    //   402: goto -25 -> 377
    //   405: astore 6
    //   407: aload 6
    //   409: invokestatic 163	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   412: goto -15 -> 397
    //   415: aload 6
    //   417: ifnull +122 -> 539
    //   420: aload_0
    //   421: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   424: invokestatic 193	com/tencent/tencentmap/mapsdk/a/cl:a	(Landroid/content/Context;)Z
    //   427: ifeq +91 -> 518
    //   430: ldc 195
    //   432: iconst_0
    //   433: anewarray 4	java/lang/Object
    //   436: invokestatic 88	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: aload_0
    //   440: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   443: invokestatic 109	com/tencent/tencentmap/mapsdk/a/ck:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ck;
    //   446: invokevirtual 197	com/tencent/tencentmap/mapsdk/a/ck:b	()V
    //   449: ldc 199
    //   451: iconst_0
    //   452: anewarray 4	java/lang/Object
    //   455: invokestatic 201	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   458: aload 7
    //   460: monitorenter
    //   461: aload 7
    //   463: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/ck:i	()[Lcom/tencent/tencentmap/mapsdk/a/cj;
    //   466: astore 6
    //   468: aload 7
    //   470: iconst_3
    //   471: invokevirtual 127	com/tencent/tencentmap/mapsdk/a/ck:a	(I)V
    //   474: aload 7
    //   476: monitorexit
    //   477: aload 6
    //   479: ifnull +80 -> 559
    //   482: ldc 203
    //   484: iconst_0
    //   485: anewarray 4	java/lang/Object
    //   488: invokestatic 83	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   491: aload 6
    //   493: arraylength
    //   494: istore_2
    //   495: iconst_0
    //   496: istore_1
    //   497: iload_1
    //   498: iload_2
    //   499: if_icmpge +60 -> 559
    //   502: aload 6
    //   504: iload_1
    //   505: aaload
    //   506: invokeinterface 204 1 0
    //   511: iload_1
    //   512: iconst_1
    //   513: iadd
    //   514: istore_1
    //   515: goto -18 -> 497
    //   518: aload 6
    //   520: new 206	com/tencent/tencentmap/mapsdk/a/du
    //   523: dup
    //   524: aload_0
    //   525: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   528: invokespecial 208	com/tencent/tencentmap/mapsdk/a/du:<init>	(Landroid/content/Context;)V
    //   531: invokeinterface 213 2 0
    //   536: goto -87 -> 449
    //   539: ldc 215
    //   541: iconst_0
    //   542: anewarray 4	java/lang/Object
    //   545: invokestatic 201	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   548: goto -99 -> 449
    //   551: astore 6
    //   553: aload 7
    //   555: monitorexit
    //   556: aload 6
    //   558: athrow
    //   559: aload_0
    //   560: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   563: invokestatic 109	com/tencent/tencentmap/mapsdk/a/ck:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ck;
    //   566: invokevirtual 217	com/tencent/tencentmap/mapsdk/a/ck:e	()Lcom/tencent/tencentmap/mapsdk/a/cm;
    //   569: astore 6
    //   571: aload 6
    //   573: ifnonnull +13 -> 586
    //   576: ldc 219
    //   578: iconst_0
    //   579: anewarray 4	java/lang/Object
    //   582: invokestatic 222	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   585: return
    //   586: aload 6
    //   588: invokevirtual 224	com/tencent/tencentmap/mapsdk/a/cm:c	()I
    //   591: ldc 225
    //   593: imul
    //   594: i2l
    //   595: lstore 4
    //   597: lload 4
    //   599: lconst_0
    //   600: lcmp
    //   601: ifle +41 -> 642
    //   604: invokestatic 230	com/tencent/tencentmap/mapsdk/a/b:a	()Lcom/tencent/tencentmap/mapsdk/a/b;
    //   607: aload_0
    //   608: lload 4
    //   610: invokevirtual 233	com/tencent/tencentmap/mapsdk/a/b:a	(Ljava/lang/Runnable;J)V
    //   613: ldc 235
    //   615: iconst_1
    //   616: anewarray 4	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: lload 4
    //   623: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   626: aastore
    //   627: invokestatic 201	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   630: aload_0
    //   631: getfield 21	com/tencent/tencentmap/mapsdk/a/cl:b	Landroid/content/Context;
    //   634: invokestatic 109	com/tencent/tencentmap/mapsdk/a/ck:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ck;
    //   637: iconst_4
    //   638: invokevirtual 127	com/tencent/tencentmap/mapsdk/a/ck:a	(I)V
    //   641: return
    //   642: ldc 237
    //   644: iconst_0
    //   645: anewarray 4	java/lang/Object
    //   648: invokestatic 201	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   651: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	cl
    //   200	315	1	i	int
    //   198	302	2	j	int
    //   110	18	3	bool	boolean
    //   243	379	4	l	long
    //   7	200	6	localObject1	Object
    //   222	3	6	localThrowable	java.lang.Throwable
    //   232	6	6	localObject2	Object
    //   291	37	6	arrayOfcj1	cj[]
    //   343	3	6	localInterruptedException1	java.lang.InterruptedException
    //   353	6	6	localObject3	Object
    //   373	28	6	localdx	dx
    //   405	11	6	localInterruptedException2	java.lang.InterruptedException
    //   466	53	6	arrayOfcj2	cj[]
    //   551	6	6	localObject4	Object
    //   569	18	6	localcm	cm
    //   42	512	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   32	44	222	java/lang/Throwable
    //   49	71	222	java/lang/Throwable
    //   157	181	232	finally
    //   269	274	343	java/lang/InterruptedException
    //   277	302	353	finally
    //   391	397	405	java/lang/InterruptedException
    //   461	477	551	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cl
 * JD-Core Version:    0.7.0.1
 */