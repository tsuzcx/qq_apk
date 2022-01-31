package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.channels.FileLock;

class bz
{
  private static bz a;
  private static FileLock e = null;
  private ca b;
  private boolean c;
  private boolean d;
  
  public static bz a()
  {
    AppMethodBeat.i(139450);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bz();
      }
      bz localbz = a;
      AppMethodBeat.o(139450);
      return localbz;
    }
    finally
    {
      AppMethodBeat.o(139450);
    }
  }
  
  public ca a(boolean paramBoolean)
  {
    AppMethodBeat.i(139451);
    if (paramBoolean)
    {
      localca = this.b;
      AppMethodBeat.o(139451);
      return localca;
    }
    ca localca = c();
    AppMethodBeat.o(139451);
    return localca;
  }
  
  /* Error */
  public FileLock a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 46
    //   7: ldc 48
    //   9: invokestatic 53	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 17	com/tencent/smtt/sdk/bz:e	Ljava/nio/channels/FileLock;
    //   15: ifnull +14 -> 29
    //   18: getstatic 17	com/tencent/smtt/sdk/bz:e	Ljava/nio/channels/FileLock;
    //   21: astore_1
    //   22: ldc 44
    //   24: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: areturn
    //   29: ldc 2
    //   31: monitorenter
    //   32: getstatic 17	com/tencent/smtt/sdk/bz:e	Ljava/nio/channels/FileLock;
    //   35: ifnonnull +23 -> 58
    //   38: aload_1
    //   39: invokestatic 57	com/tencent/smtt/utils/k:e	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   42: astore_1
    //   43: aload_1
    //   44: putstatic 17	com/tencent/smtt/sdk/bz:e	Ljava/nio/channels/FileLock;
    //   47: aload_1
    //   48: ifnonnull +24 -> 72
    //   51: ldc 46
    //   53: ldc 59
    //   55: invokestatic 53	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc 2
    //   60: monitorexit
    //   61: getstatic 17	com/tencent/smtt/sdk/bz:e	Ljava/nio/channels/FileLock;
    //   64: astore_1
    //   65: ldc 44
    //   67: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_1
    //   71: areturn
    //   72: ldc 46
    //   74: new 61	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 63
    //   80: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: getstatic 17	com/tencent/smtt/sdk/bz:e	Ljava/nio/channels/FileLock;
    //   86: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 53	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: goto -37 -> 58
    //   98: astore_1
    //   99: ldc 2
    //   101: monitorexit
    //   102: ldc 44
    //   104: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	bz
    //   0	109	1	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   32	47	98	finally
    //   51	58	98	finally
    //   58	61	98	finally
    //   72	95	98	finally
    //   99	102	98	finally
  }
  
  /* Error */
  public void a(android.content.Context paramContext, an paraman)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 80
    //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 46
    //   12: ldc 82
    //   14: invokestatic 53	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ifnull +10 -> 28
    //   21: aload_2
    //   22: ldc 84
    //   24: iconst_2
    //   25: invokevirtual 89	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   28: iconst_1
    //   29: invokestatic 94	com/tencent/smtt/sdk/o:a	(Z)Lcom/tencent/smtt/sdk/o;
    //   32: astore 8
    //   34: aload 8
    //   36: aload_1
    //   37: iconst_0
    //   38: iconst_0
    //   39: aload_2
    //   40: invokevirtual 97	com/tencent/smtt/sdk/o:a	(Landroid/content/Context;ZZLcom/tencent/smtt/sdk/an;)V
    //   43: new 61	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   50: astore 7
    //   52: aload_2
    //   53: ifnull +10 -> 63
    //   56: aload_2
    //   57: ldc 100
    //   59: iconst_1
    //   60: invokevirtual 89	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   63: aload 8
    //   65: invokevirtual 103	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/bl;
    //   68: astore 9
    //   70: aload 8
    //   72: invokevirtual 106	com/tencent/smtt/sdk/o:b	()Z
    //   75: ifeq +408 -> 483
    //   78: aload 9
    //   80: ifnull +403 -> 483
    //   83: aload_0
    //   84: getfield 108	com/tencent/smtt/sdk/bz:d	Z
    //   87: ifne +563 -> 650
    //   90: aload_2
    //   91: ifnull +8 -> 99
    //   94: aload_2
    //   95: iconst_1
    //   96: putfield 110	com/tencent/smtt/sdk/an:a	Z
    //   99: aload_0
    //   100: new 112	com/tencent/smtt/sdk/ca
    //   103: dup
    //   104: aload 9
    //   106: invokevirtual 117	com/tencent/smtt/sdk/bl:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   109: invokespecial 120	com/tencent/smtt/sdk/ca:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   112: putfield 39	com/tencent/smtt/sdk/bz:b	Lcom/tencent/smtt/sdk/ca;
    //   115: aload_0
    //   116: aload_0
    //   117: getfield 39	com/tencent/smtt/sdk/bz:b	Lcom/tencent/smtt/sdk/ca;
    //   120: invokevirtual 122	com/tencent/smtt/sdk/ca:a	()Z
    //   123: putfield 124	com/tencent/smtt/sdk/bz:c	Z
    //   126: aload_0
    //   127: getfield 124	com/tencent/smtt/sdk/bz:c	Z
    //   130: ifne +11 -> 141
    //   133: aload 7
    //   135: ldc 126
    //   137: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aconst_null
    //   142: astore 4
    //   144: aload 4
    //   146: astore 5
    //   148: aload_0
    //   149: getfield 124	com/tencent/smtt/sdk/bz:c	Z
    //   152: ifeq +22 -> 174
    //   155: invokestatic 135	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   158: aload_1
    //   159: iconst_1
    //   160: iconst_1
    //   161: invokevirtual 138	com/tencent/smtt/sdk/CookieManager:a	(Landroid/content/Context;ZZ)V
    //   164: invokestatic 135	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   167: invokevirtual 140	com/tencent/smtt/sdk/CookieManager:a	()V
    //   170: aload 4
    //   172: astore 5
    //   174: ldc 46
    //   176: new 61	java/lang/StringBuilder
    //   179: dup
    //   180: ldc 142
    //   182: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: aload_0
    //   186: getfield 124	com/tencent/smtt/sdk/bz:c	Z
    //   189: invokevirtual 145	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   192: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 53	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 124	com/tencent/smtt/sdk/bz:c	Z
    //   202: ifne +405 -> 607
    //   205: ldc 46
    //   207: ldc 147
    //   209: invokestatic 149	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload 8
    //   214: invokevirtual 106	com/tencent/smtt/sdk/o:b	()Z
    //   217: istore_3
    //   218: iload_3
    //   219: ifeq +320 -> 539
    //   222: aload 9
    //   224: ifnull +315 -> 539
    //   227: aload 5
    //   229: ifnonnull +310 -> 539
    //   232: aload 9
    //   234: invokevirtual 117	com/tencent/smtt/sdk/bl:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   237: astore 5
    //   239: aload 6
    //   241: astore 4
    //   243: aload 5
    //   245: ifnull +22 -> 267
    //   248: aload 5
    //   250: ldc 151
    //   252: ldc 153
    //   254: iconst_0
    //   255: anewarray 155	java/lang/Class
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokevirtual 161	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   265: astore 4
    //   267: aload 4
    //   269: instanceof 79
    //   272: ifeq +59 -> 331
    //   275: aload 4
    //   277: checkcast 79	java/lang/Throwable
    //   280: astore 5
    //   282: aload 7
    //   284: new 61	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 163
    //   290: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload 5
    //   295: invokevirtual 166	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   298: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc 168
    //   303: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 5
    //   308: invokevirtual 172	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   311: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   314: ldc 174
    //   316: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload 5
    //   321: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 4
    //   333: instanceof 176
    //   336: ifeq +19 -> 355
    //   339: aload 7
    //   341: ldc 178
    //   343: aload 4
    //   345: invokestatic 182	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   348: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   351: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 7
    //   357: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: ldc 188
    //   362: invokevirtual 192	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   365: ifeq +134 -> 499
    //   368: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   371: aload_1
    //   372: sipush 408
    //   375: new 79	java/lang/Throwable
    //   378: dup
    //   379: new 61	java/lang/StringBuilder
    //   382: dup
    //   383: ldc 199
    //   385: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: aload 7
    //   390: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokespecial 200	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   402: invokevirtual 203	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   405: aload_0
    //   406: iconst_1
    //   407: putfield 108	com/tencent/smtt/sdk/bz:d	Z
    //   410: aload_2
    //   411: ifnull +10 -> 421
    //   414: aload_2
    //   415: ldc 100
    //   417: iconst_2
    //   418: invokevirtual 89	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   421: ldc 80
    //   423: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: aload_0
    //   427: monitorexit
    //   428: return
    //   429: astore 4
    //   431: aload_0
    //   432: iconst_1
    //   433: putfield 124	com/tencent/smtt/sdk/bz:c	Z
    //   436: aconst_null
    //   437: astore 4
    //   439: goto -295 -> 144
    //   442: astore 4
    //   444: aload_0
    //   445: iconst_0
    //   446: putfield 124	com/tencent/smtt/sdk/bz:c	Z
    //   449: aload 7
    //   451: new 61	java/lang/StringBuilder
    //   454: dup
    //   455: ldc 205
    //   457: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   460: aload 4
    //   462: invokestatic 211	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   465: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: goto -331 -> 144
    //   478: astore_1
    //   479: aload_0
    //   480: monitorexit
    //   481: aload_1
    //   482: athrow
    //   483: aload_0
    //   484: iconst_0
    //   485: putfield 124	com/tencent/smtt/sdk/bz:c	Z
    //   488: aload 7
    //   490: ldc 213
    //   492: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: goto +154 -> 650
    //   499: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   502: aload_1
    //   503: sipush 407
    //   506: new 79	java/lang/Throwable
    //   509: dup
    //   510: new 61	java/lang/StringBuilder
    //   513: dup
    //   514: ldc 199
    //   516: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload 7
    //   521: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokespecial 200	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   533: invokevirtual 203	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   536: goto -131 -> 405
    //   539: aload 8
    //   541: invokevirtual 106	com/tencent/smtt/sdk/o:b	()Z
    //   544: ifeq +33 -> 577
    //   547: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   550: aload_1
    //   551: sipush 409
    //   554: new 79	java/lang/Throwable
    //   557: dup
    //   558: ldc 215
    //   560: aload 5
    //   562: invokestatic 182	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   565: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   568: invokespecial 200	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   571: invokevirtual 203	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   574: goto -169 -> 405
    //   577: invokestatic 197	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   580: aload_1
    //   581: sipush 410
    //   584: new 79	java/lang/Throwable
    //   587: dup
    //   588: ldc 217
    //   590: aload 5
    //   592: invokestatic 182	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   595: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   598: invokespecial 200	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   601: invokevirtual 203	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   604: goto -199 -> 405
    //   607: ldc 46
    //   609: new 61	java/lang/StringBuilder
    //   612: dup
    //   613: ldc 219
    //   615: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   618: getstatic 17	com/tencent/smtt/sdk/bz:e	Ljava/nio/channels/FileLock;
    //   621: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 53	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: getstatic 17	com/tencent/smtt/sdk/bz:e	Ljava/nio/channels/FileLock;
    //   633: ifnonnull -228 -> 405
    //   636: aload_0
    //   637: aload_1
    //   638: invokevirtual 221	com/tencent/smtt/sdk/bz:a	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   641: pop
    //   642: goto -237 -> 405
    //   645: astore 4
    //   647: goto -292 -> 355
    //   650: aconst_null
    //   651: astore 5
    //   653: goto -479 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	this	bz
    //   0	656	1	paramContext	android.content.Context
    //   0	656	2	paraman	an
    //   217	2	3	bool	boolean
    //   142	202	4	localObject1	Object
    //   429	1	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   437	1	4	localObject2	Object
    //   442	19	4	localThrowable1	java.lang.Throwable
    //   645	1	4	localThrowable2	java.lang.Throwable
    //   146	506	5	localObject3	Object
    //   1	239	6	localObject4	Object
    //   50	470	7	localStringBuilder	java.lang.StringBuilder
    //   32	508	8	localo	o
    //   68	165	9	localbl	bl
    // Exception table:
    //   from	to	target	type
    //   115	141	429	java/lang/NoSuchMethodException
    //   115	141	442	java/lang/Throwable
    //   5	17	478	finally
    //   21	28	478	finally
    //   28	52	478	finally
    //   56	63	478	finally
    //   63	78	478	finally
    //   83	90	478	finally
    //   94	99	478	finally
    //   99	115	478	finally
    //   115	141	478	finally
    //   148	170	478	finally
    //   174	218	478	finally
    //   232	239	478	finally
    //   248	267	478	finally
    //   267	331	478	finally
    //   331	355	478	finally
    //   355	405	478	finally
    //   405	410	478	finally
    //   414	421	478	finally
    //   421	426	478	finally
    //   431	436	478	finally
    //   444	475	478	finally
    //   483	496	478	finally
    //   499	536	478	finally
    //   539	574	478	finally
    //   577	604	478	finally
    //   607	642	478	finally
    //   232	239	645	java/lang/Throwable
    //   248	267	645	java/lang/Throwable
    //   267	331	645	java/lang/Throwable
    //   331	355	645	java/lang/Throwable
  }
  
  public boolean b()
  {
    if (QbSdk.a) {
      return false;
    }
    return this.c;
  }
  
  public ca c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.bz
 * JD-Core Version:    0.7.0.1
 */