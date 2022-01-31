package com.tencent.smtt.sdk;

import java.nio.channels.FileLock;

class bv
{
  private static bv a;
  private static FileLock e = null;
  private bw b;
  private boolean c;
  private boolean d;
  
  public static bv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bv();
      }
      return a;
    }
    finally {}
  }
  
  public bw a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return c();
  }
  
  /* Error */
  public FileLock a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: ldc 36
    //   6: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: getstatic 17	com/tencent/smtt/sdk/bv:e	Ljava/nio/channels/FileLock;
    //   12: ifnull +11 -> 23
    //   15: getstatic 17	com/tencent/smtt/sdk/bv:e	Ljava/nio/channels/FileLock;
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: aload_1
    //   24: invokestatic 46	com/tencent/smtt/utils/j:e	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   27: astore_1
    //   28: aload_1
    //   29: putstatic 17	com/tencent/smtt/sdk/bv:e	Ljava/nio/channels/FileLock;
    //   32: aload_1
    //   33: ifnonnull +17 -> 50
    //   36: ldc 34
    //   38: ldc 48
    //   40: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: getstatic 17	com/tencent/smtt/sdk/bv:e	Ljava/nio/channels/FileLock;
    //   46: astore_1
    //   47: goto -28 -> 19
    //   50: ldc 34
    //   52: ldc 50
    //   54: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: goto -14 -> 43
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	bv
    //   0	65	1	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   2	19	60	finally
    //   23	32	60	finally
    //   36	43	60	finally
    //   43	47	60	finally
    //   50	57	60	finally
  }
  
  /* Error */
  public void a(android.content.Context paramContext, am paramam)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 34
    //   7: ldc 57
    //   9: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ifnull +10 -> 23
    //   16: aload_2
    //   17: ldc 59
    //   19: iconst_2
    //   20: invokevirtual 64	com/tencent/smtt/sdk/am:a	(Ljava/lang/String;B)V
    //   23: iconst_1
    //   24: invokestatic 69	com/tencent/smtt/sdk/o:a	(Z)Lcom/tencent/smtt/sdk/o;
    //   27: astore 8
    //   29: aload 8
    //   31: aload_1
    //   32: iconst_0
    //   33: iconst_0
    //   34: aload_2
    //   35: invokevirtual 72	com/tencent/smtt/sdk/o:a	(Landroid/content/Context;ZZLcom/tencent/smtt/sdk/am;)V
    //   38: new 74	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   45: astore 7
    //   47: aload_2
    //   48: ifnull +10 -> 58
    //   51: aload_2
    //   52: ldc 77
    //   54: iconst_1
    //   55: invokevirtual 64	com/tencent/smtt/sdk/am:a	(Ljava/lang/String;B)V
    //   58: aload 8
    //   60: invokevirtual 80	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/bi;
    //   63: astore 9
    //   65: aload 8
    //   67: invokevirtual 83	com/tencent/smtt/sdk/o:b	()Z
    //   70: ifeq +410 -> 480
    //   73: aload 9
    //   75: ifnull +405 -> 480
    //   78: aload_0
    //   79: getfield 85	com/tencent/smtt/sdk/bv:d	Z
    //   82: ifne +579 -> 661
    //   85: aload_2
    //   86: ifnull +8 -> 94
    //   89: aload_2
    //   90: iconst_1
    //   91: putfield 87	com/tencent/smtt/sdk/am:a	Z
    //   94: aload_0
    //   95: new 89	com/tencent/smtt/sdk/bw
    //   98: dup
    //   99: aload 9
    //   101: invokevirtual 94	com/tencent/smtt/sdk/bi:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   104: invokespecial 97	com/tencent/smtt/sdk/bw:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   107: putfield 28	com/tencent/smtt/sdk/bv:b	Lcom/tencent/smtt/sdk/bw;
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 28	com/tencent/smtt/sdk/bv:b	Lcom/tencent/smtt/sdk/bw;
    //   115: invokevirtual 99	com/tencent/smtt/sdk/bw:a	()Z
    //   118: putfield 101	com/tencent/smtt/sdk/bv:c	Z
    //   121: aload_0
    //   122: getfield 101	com/tencent/smtt/sdk/bv:c	Z
    //   125: ifne +11 -> 136
    //   128: aload 7
    //   130: ldc 103
    //   132: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aconst_null
    //   137: astore 4
    //   139: aload 4
    //   141: astore 5
    //   143: aload_0
    //   144: getfield 101	com/tencent/smtt/sdk/bv:c	Z
    //   147: ifeq +22 -> 169
    //   150: invokestatic 113	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   153: aload_1
    //   154: iconst_1
    //   155: iconst_1
    //   156: invokevirtual 116	com/tencent/smtt/sdk/CookieManager:a	(Landroid/content/Context;ZZ)V
    //   159: invokestatic 113	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   162: invokevirtual 118	com/tencent/smtt/sdk/CookieManager:a	()V
    //   165: aload 4
    //   167: astore 5
    //   169: ldc 34
    //   171: new 74	java/lang/StringBuilder
    //   174: dup
    //   175: ldc 120
    //   177: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield 101	com/tencent/smtt/sdk/bv:c	Z
    //   184: invokevirtual 126	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 101	com/tencent/smtt/sdk/bv:c	Z
    //   197: ifne +421 -> 618
    //   200: ldc 34
    //   202: ldc 132
    //   204: invokestatic 134	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload 8
    //   209: invokevirtual 83	com/tencent/smtt/sdk/o:b	()Z
    //   212: istore_3
    //   213: iload_3
    //   214: ifeq +322 -> 536
    //   217: aload 9
    //   219: ifnull +317 -> 536
    //   222: aload 5
    //   224: ifnonnull +312 -> 536
    //   227: aload 9
    //   229: invokevirtual 94	com/tencent/smtt/sdk/bi:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   232: astore 5
    //   234: aload 6
    //   236: astore 4
    //   238: aload 5
    //   240: ifnull +22 -> 262
    //   243: aload 5
    //   245: ldc 136
    //   247: ldc 138
    //   249: iconst_0
    //   250: anewarray 140	java/lang/Class
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokevirtual 146	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   260: astore 4
    //   262: aload 4
    //   264: instanceof 55
    //   267: ifeq +59 -> 326
    //   270: aload 4
    //   272: checkcast 55	java/lang/Throwable
    //   275: astore 5
    //   277: aload 7
    //   279: new 74	java/lang/StringBuilder
    //   282: dup
    //   283: ldc 148
    //   285: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: aload 5
    //   290: invokevirtual 151	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   293: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc 153
    //   298: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 5
    //   303: invokevirtual 157	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   306: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: ldc 162
    //   311: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 5
    //   316: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 4
    //   328: instanceof 164
    //   331: ifeq +26 -> 357
    //   334: aload 7
    //   336: new 74	java/lang/StringBuilder
    //   339: dup
    //   340: ldc 166
    //   342: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: aload 4
    //   347: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 7
    //   359: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: ldc 168
    //   364: invokevirtual 172	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   367: ifeq +129 -> 496
    //   370: invokestatic 177	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   373: aload_1
    //   374: sipush 408
    //   377: new 55	java/lang/Throwable
    //   380: dup
    //   381: new 74	java/lang/StringBuilder
    //   384: dup
    //   385: ldc 179
    //   387: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload 7
    //   392: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokespecial 180	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   404: invokevirtual 183	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   407: aload_0
    //   408: iconst_1
    //   409: putfield 85	com/tencent/smtt/sdk/bv:d	Z
    //   412: aload_2
    //   413: ifnull +10 -> 423
    //   416: aload_2
    //   417: ldc 77
    //   419: iconst_2
    //   420: invokevirtual 64	com/tencent/smtt/sdk/am:a	(Ljava/lang/String;B)V
    //   423: aload_0
    //   424: monitorexit
    //   425: return
    //   426: astore 4
    //   428: aload_0
    //   429: iconst_1
    //   430: putfield 101	com/tencent/smtt/sdk/bv:c	Z
    //   433: aconst_null
    //   434: astore 4
    //   436: goto -297 -> 139
    //   439: astore 4
    //   441: aload_0
    //   442: iconst_0
    //   443: putfield 101	com/tencent/smtt/sdk/bv:c	Z
    //   446: aload 7
    //   448: new 74	java/lang/StringBuilder
    //   451: dup
    //   452: ldc 185
    //   454: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   457: aload 4
    //   459: invokestatic 191	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   462: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: goto -333 -> 139
    //   475: astore_1
    //   476: aload_0
    //   477: monitorexit
    //   478: aload_1
    //   479: athrow
    //   480: aload_0
    //   481: iconst_0
    //   482: putfield 101	com/tencent/smtt/sdk/bv:c	Z
    //   485: aload 7
    //   487: ldc 193
    //   489: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: goto +168 -> 661
    //   496: invokestatic 177	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   499: aload_1
    //   500: sipush 407
    //   503: new 55	java/lang/Throwable
    //   506: dup
    //   507: new 74	java/lang/StringBuilder
    //   510: dup
    //   511: ldc 179
    //   513: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   516: aload 7
    //   518: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokespecial 180	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   530: invokevirtual 183	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   533: goto -126 -> 407
    //   536: aload 8
    //   538: invokevirtual 83	com/tencent/smtt/sdk/o:b	()Z
    //   541: ifeq +40 -> 581
    //   544: invokestatic 177	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   547: aload_1
    //   548: sipush 409
    //   551: new 55	java/lang/Throwable
    //   554: dup
    //   555: new 74	java/lang/StringBuilder
    //   558: dup
    //   559: ldc 195
    //   561: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   564: aload 5
    //   566: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokespecial 180	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   575: invokevirtual 183	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   578: goto -171 -> 407
    //   581: invokestatic 177	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   584: aload_1
    //   585: sipush 410
    //   588: new 55	java/lang/Throwable
    //   591: dup
    //   592: new 74	java/lang/StringBuilder
    //   595: dup
    //   596: ldc 197
    //   598: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   601: aload 5
    //   603: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokespecial 180	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   612: invokevirtual 183	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   615: goto -208 -> 407
    //   618: ldc 34
    //   620: new 74	java/lang/StringBuilder
    //   623: dup
    //   624: ldc 199
    //   626: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   629: getstatic 17	com/tencent/smtt/sdk/bv:e	Ljava/nio/channels/FileLock;
    //   632: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 42	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: getstatic 17	com/tencent/smtt/sdk/bv:e	Ljava/nio/channels/FileLock;
    //   644: ifnonnull -237 -> 407
    //   647: aload_0
    //   648: aload_1
    //   649: invokevirtual 201	com/tencent/smtt/sdk/bv:a	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   652: pop
    //   653: goto -246 -> 407
    //   656: astore 4
    //   658: goto -301 -> 357
    //   661: aconst_null
    //   662: astore 5
    //   664: goto -495 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	this	bv
    //   0	667	1	paramContext	android.content.Context
    //   0	667	2	paramam	am
    //   212	2	3	bool	boolean
    //   137	209	4	localObject1	Object
    //   426	1	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   434	1	4	localObject2	Object
    //   439	19	4	localThrowable1	java.lang.Throwable
    //   656	1	4	localThrowable2	java.lang.Throwable
    //   141	522	5	localObject3	Object
    //   1	234	6	localObject4	Object
    //   45	472	7	localStringBuilder	java.lang.StringBuilder
    //   27	510	8	localo	o
    //   63	165	9	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   110	136	426	java/lang/NoSuchMethodException
    //   110	136	439	java/lang/Throwable
    //   5	12	475	finally
    //   16	23	475	finally
    //   23	47	475	finally
    //   51	58	475	finally
    //   58	73	475	finally
    //   78	85	475	finally
    //   89	94	475	finally
    //   94	110	475	finally
    //   110	136	475	finally
    //   143	165	475	finally
    //   169	213	475	finally
    //   227	234	475	finally
    //   243	262	475	finally
    //   262	326	475	finally
    //   326	357	475	finally
    //   357	407	475	finally
    //   407	412	475	finally
    //   416	423	475	finally
    //   428	433	475	finally
    //   441	472	475	finally
    //   480	493	475	finally
    //   496	533	475	finally
    //   536	578	475	finally
    //   581	615	475	finally
    //   618	653	475	finally
    //   227	234	656	java/lang/Throwable
    //   243	262	656	java/lang/Throwable
    //   262	326	656	java/lang/Throwable
    //   326	357	656	java/lang/Throwable
  }
  
  public boolean b()
  {
    if (QbSdk.a) {
      return false;
    }
    return this.c;
  }
  
  public bw c()
  {
    if (QbSdk.a) {
      return null;
    }
    return this.b;
  }
  
  boolean d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.bv
 * JD-Core Version:    0.7.0.1
 */