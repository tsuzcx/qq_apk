package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.channels.FileLock;

class v
{
  private static v a;
  private static FileLock e = null;
  private w b;
  private boolean c;
  private boolean d;
  
  public static v a()
  {
    AppMethodBeat.i(55192);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new v();
      }
      v localv = a;
      AppMethodBeat.o(55192);
      return localv;
    }
    finally
    {
      AppMethodBeat.o(55192);
    }
  }
  
  /* Error */
  public FileLock a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 39
    //   7: ldc 41
    //   9: invokestatic 46	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 17	com/tencent/smtt/sdk/v:e	Ljava/nio/channels/FileLock;
    //   15: ifnull +14 -> 29
    //   18: getstatic 17	com/tencent/smtt/sdk/v:e	Ljava/nio/channels/FileLock;
    //   21: astore_1
    //   22: ldc 37
    //   24: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: areturn
    //   29: ldc 2
    //   31: monitorenter
    //   32: getstatic 17	com/tencent/smtt/sdk/v:e	Ljava/nio/channels/FileLock;
    //   35: ifnonnull +23 -> 58
    //   38: aload_1
    //   39: invokestatic 50	com/tencent/smtt/utils/f:e	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   42: astore_1
    //   43: aload_1
    //   44: putstatic 17	com/tencent/smtt/sdk/v:e	Ljava/nio/channels/FileLock;
    //   47: aload_1
    //   48: ifnonnull +24 -> 72
    //   51: ldc 39
    //   53: ldc 52
    //   55: invokestatic 46	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc 2
    //   60: monitorexit
    //   61: getstatic 17	com/tencent/smtt/sdk/v:e	Ljava/nio/channels/FileLock;
    //   64: astore_1
    //   65: ldc 37
    //   67: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_1
    //   71: areturn
    //   72: ldc 39
    //   74: new 54	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 56
    //   80: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: getstatic 17	com/tencent/smtt/sdk/v:e	Ljava/nio/channels/FileLock;
    //   86: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 46	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: goto -37 -> 58
    //   98: astore_1
    //   99: ldc 2
    //   101: monitorexit
    //   102: ldc 37
    //   104: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	v
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
  public void a(android.content.Context paramContext, n paramn)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 73
    //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 39
    //   12: ldc 75
    //   14: invokestatic 46	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ifnull +10 -> 28
    //   21: aload_2
    //   22: ldc 77
    //   24: iconst_2
    //   25: invokevirtual 82	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   28: iconst_1
    //   29: invokestatic 87	com/tencent/smtt/sdk/e:a	(Z)Lcom/tencent/smtt/sdk/e;
    //   32: astore 8
    //   34: aload 8
    //   36: aload_1
    //   37: iconst_0
    //   38: iconst_0
    //   39: aload_2
    //   40: invokevirtual 90	com/tencent/smtt/sdk/e:a	(Landroid/content/Context;ZZLcom/tencent/smtt/sdk/n;)V
    //   43: new 54	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   50: astore 7
    //   52: aload_2
    //   53: ifnull +10 -> 63
    //   56: aload_2
    //   57: ldc 93
    //   59: iconst_1
    //   60: invokevirtual 82	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   63: aload 8
    //   65: invokevirtual 96	com/tencent/smtt/sdk/e:a	()Lcom/tencent/smtt/sdk/TbsWizard;
    //   68: astore 9
    //   70: aload 8
    //   72: invokevirtual 99	com/tencent/smtt/sdk/e:b	()Z
    //   75: ifeq +409 -> 484
    //   78: aload 9
    //   80: ifnull +404 -> 484
    //   83: aload_0
    //   84: getfield 101	com/tencent/smtt/sdk/v:d	Z
    //   87: ifne +564 -> 651
    //   90: aload_2
    //   91: ifnull +8 -> 99
    //   94: aload_2
    //   95: iconst_1
    //   96: putfield 103	com/tencent/smtt/sdk/n:a	Z
    //   99: aload_0
    //   100: new 105	com/tencent/smtt/sdk/w
    //   103: dup
    //   104: aload 9
    //   106: invokevirtual 111	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   109: invokespecial 114	com/tencent/smtt/sdk/w:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   112: putfield 116	com/tencent/smtt/sdk/v:b	Lcom/tencent/smtt/sdk/w;
    //   115: aload_0
    //   116: invokestatic 122	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:getCoreEntry	()Lcom/tencent/smtt/export/external/interfaces/IX5CoreEntry;
    //   119: invokeinterface 127 1 0
    //   124: putfield 129	com/tencent/smtt/sdk/v:c	Z
    //   127: aload_0
    //   128: getfield 129	com/tencent/smtt/sdk/v:c	Z
    //   131: ifne +11 -> 142
    //   134: aload 7
    //   136: ldc 131
    //   138: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 4
    //   147: astore 5
    //   149: aload_0
    //   150: getfield 129	com/tencent/smtt/sdk/v:c	Z
    //   153: ifeq +22 -> 175
    //   156: invokestatic 140	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   159: aload_1
    //   160: iconst_1
    //   161: iconst_1
    //   162: invokevirtual 143	com/tencent/smtt/sdk/CookieManager:a	(Landroid/content/Context;ZZ)V
    //   165: invokestatic 140	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   168: invokevirtual 145	com/tencent/smtt/sdk/CookieManager:a	()V
    //   171: aload 4
    //   173: astore 5
    //   175: ldc 39
    //   177: new 54	java/lang/StringBuilder
    //   180: dup
    //   181: ldc 147
    //   183: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: aload_0
    //   187: getfield 129	com/tencent/smtt/sdk/v:c	Z
    //   190: invokevirtual 150	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   193: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 46	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_0
    //   200: getfield 129	com/tencent/smtt/sdk/v:c	Z
    //   203: ifne +405 -> 608
    //   206: ldc 39
    //   208: ldc 152
    //   210: invokestatic 154	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 8
    //   215: invokevirtual 99	com/tencent/smtt/sdk/e:b	()Z
    //   218: istore_3
    //   219: iload_3
    //   220: ifeq +320 -> 540
    //   223: aload 9
    //   225: ifnull +315 -> 540
    //   228: aload 5
    //   230: ifnonnull +310 -> 540
    //   233: aload 9
    //   235: invokevirtual 111	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   238: astore 5
    //   240: aload 6
    //   242: astore 4
    //   244: aload 5
    //   246: ifnull +22 -> 268
    //   249: aload 5
    //   251: ldc 156
    //   253: ldc 158
    //   255: iconst_0
    //   256: anewarray 160	java/lang/Class
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokevirtual 166	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   266: astore 4
    //   268: aload 4
    //   270: instanceof 72
    //   273: ifeq +59 -> 332
    //   276: aload 4
    //   278: checkcast 72	java/lang/Throwable
    //   281: astore 5
    //   283: aload 7
    //   285: new 54	java/lang/StringBuilder
    //   288: dup
    //   289: ldc 168
    //   291: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: aload 5
    //   296: invokevirtual 171	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   299: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc 173
    //   304: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 5
    //   309: invokevirtual 177	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   312: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   315: ldc 179
    //   317: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 5
    //   322: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 4
    //   334: instanceof 181
    //   337: ifeq +19 -> 356
    //   340: aload 7
    //   342: ldc 183
    //   344: aload 4
    //   346: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   349: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   352: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 7
    //   358: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: ldc 193
    //   363: invokevirtual 197	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   366: ifeq +134 -> 500
    //   369: invokestatic 202	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   372: aload_1
    //   373: sipush 408
    //   376: new 72	java/lang/Throwable
    //   379: dup
    //   380: new 54	java/lang/StringBuilder
    //   383: dup
    //   384: ldc 204
    //   386: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   389: aload 7
    //   391: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokespecial 205	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   403: invokevirtual 209	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   406: aload_0
    //   407: iconst_1
    //   408: putfield 101	com/tencent/smtt/sdk/v:d	Z
    //   411: aload_2
    //   412: ifnull +10 -> 422
    //   415: aload_2
    //   416: ldc 93
    //   418: iconst_2
    //   419: invokevirtual 82	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   422: ldc 73
    //   424: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload_0
    //   428: monitorexit
    //   429: return
    //   430: astore 4
    //   432: aload_0
    //   433: iconst_1
    //   434: putfield 129	com/tencent/smtt/sdk/v:c	Z
    //   437: aconst_null
    //   438: astore 4
    //   440: goto -295 -> 145
    //   443: astore 4
    //   445: aload_0
    //   446: iconst_0
    //   447: putfield 129	com/tencent/smtt/sdk/v:c	Z
    //   450: aload 7
    //   452: new 54	java/lang/StringBuilder
    //   455: dup
    //   456: ldc 211
    //   458: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   461: aload 4
    //   463: invokestatic 217	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   466: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: goto -331 -> 145
    //   479: astore_1
    //   480: aload_0
    //   481: monitorexit
    //   482: aload_1
    //   483: athrow
    //   484: aload_0
    //   485: iconst_0
    //   486: putfield 129	com/tencent/smtt/sdk/v:c	Z
    //   489: aload 7
    //   491: ldc 219
    //   493: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: goto +154 -> 651
    //   500: invokestatic 202	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   503: aload_1
    //   504: sipush 407
    //   507: new 72	java/lang/Throwable
    //   510: dup
    //   511: new 54	java/lang/StringBuilder
    //   514: dup
    //   515: ldc 204
    //   517: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   520: aload 7
    //   522: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokespecial 205	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   534: invokevirtual 209	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   537: goto -131 -> 406
    //   540: aload 8
    //   542: invokevirtual 99	com/tencent/smtt/sdk/e:b	()Z
    //   545: ifeq +33 -> 578
    //   548: invokestatic 202	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   551: aload_1
    //   552: sipush 409
    //   555: new 72	java/lang/Throwable
    //   558: dup
    //   559: ldc 221
    //   561: aload 5
    //   563: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   566: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   569: invokespecial 205	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   572: invokevirtual 209	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   575: goto -169 -> 406
    //   578: invokestatic 202	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   581: aload_1
    //   582: sipush 410
    //   585: new 72	java/lang/Throwable
    //   588: dup
    //   589: ldc 223
    //   591: aload 5
    //   593: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   596: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   599: invokespecial 205	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   602: invokevirtual 209	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   605: goto -199 -> 406
    //   608: ldc 39
    //   610: new 54	java/lang/StringBuilder
    //   613: dup
    //   614: ldc 225
    //   616: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   619: getstatic 17	com/tencent/smtt/sdk/v:e	Ljava/nio/channels/FileLock;
    //   622: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 46	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: getstatic 17	com/tencent/smtt/sdk/v:e	Ljava/nio/channels/FileLock;
    //   634: ifnonnull -228 -> 406
    //   637: aload_0
    //   638: aload_1
    //   639: invokevirtual 227	com/tencent/smtt/sdk/v:a	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   642: pop
    //   643: goto -237 -> 406
    //   646: astore 4
    //   648: goto -292 -> 356
    //   651: aconst_null
    //   652: astore 5
    //   654: goto -479 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	this	v
    //   0	657	1	paramContext	android.content.Context
    //   0	657	2	paramn	n
    //   218	2	3	bool	boolean
    //   143	202	4	localObject1	Object
    //   430	1	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   438	1	4	localObject2	Object
    //   443	19	4	localThrowable1	java.lang.Throwable
    //   646	1	4	localThrowable2	java.lang.Throwable
    //   147	506	5	localObject3	Object
    //   1	240	6	localObject4	Object
    //   50	471	7	localStringBuilder	java.lang.StringBuilder
    //   32	509	8	locale	e
    //   68	166	9	localTbsWizard	TbsWizard
    // Exception table:
    //   from	to	target	type
    //   115	142	430	java/lang/NoSuchMethodException
    //   115	142	443	java/lang/Throwable
    //   5	17	479	finally
    //   21	28	479	finally
    //   28	52	479	finally
    //   56	63	479	finally
    //   63	78	479	finally
    //   83	90	479	finally
    //   94	99	479	finally
    //   99	115	479	finally
    //   115	142	479	finally
    //   149	171	479	finally
    //   175	219	479	finally
    //   233	240	479	finally
    //   249	268	479	finally
    //   268	332	479	finally
    //   332	356	479	finally
    //   356	406	479	finally
    //   406	411	479	finally
    //   415	422	479	finally
    //   422	427	479	finally
    //   432	437	479	finally
    //   445	476	479	finally
    //   484	497	479	finally
    //   500	537	479	finally
    //   540	575	479	finally
    //   578	605	479	finally
    //   608	643	479	finally
    //   233	240	646	java/lang/Throwable
    //   249	268	646	java/lang/Throwable
    //   268	332	646	java/lang/Throwable
    //   332	356	646	java/lang/Throwable
  }
  
  public boolean b()
  {
    if (QbSdk.a) {
      return false;
    }
    return this.c;
  }
  
  public w c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.v
 * JD-Core Version:    0.7.0.1
 */