package com.tencent.mm.pluginsdk.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class c
{
  private static boolean[] KaK = new boolean[21];
  
  /* Error */
  private static boolean bem(java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 31176
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 148	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   12: ifne +11 -> 23
    //   15: sipush 31176
    //   18: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_1
    //   22: ireturn
    //   23: new 54	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   30: aload_0
    //   31: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 150
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 9
    //   44: iload_3
    //   45: istore_2
    //   46: aload 9
    //   48: invokestatic 148	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   51: ifeq +30 -> 81
    //   54: iload_3
    //   55: istore_2
    //   56: aload 9
    //   58: invokestatic 153	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   61: ifne +20 -> 81
    //   64: ldc 124
    //   66: ldc 155
    //   68: aload 9
    //   70: invokestatic 161	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iconst_0
    //   80: istore_2
    //   81: aload 9
    //   83: invokestatic 171	com/tencent/mm/vfs/s:bpa	(Ljava/lang/String;)Z
    //   86: ifne +20 -> 106
    //   89: ldc 124
    //   91: ldc 173
    //   93: aload 9
    //   95: invokestatic 161	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: iconst_0
    //   105: istore_2
    //   106: new 175	java/io/DataOutputStream
    //   109: dup
    //   110: aload 9
    //   112: iconst_0
    //   113: invokestatic 179	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   116: invokespecial 182	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   119: astore 5
    //   121: aload 5
    //   123: iconst_1
    //   124: invokevirtual 185	java/io/DataOutputStream:writeInt	(I)V
    //   127: aload 5
    //   129: invokevirtual 188	java/io/DataOutputStream:flush	()V
    //   132: new 190	java/io/DataInputStream
    //   135: dup
    //   136: aload 9
    //   138: invokestatic 194	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: invokespecial 197	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   144: astore 4
    //   146: aload 4
    //   148: astore 7
    //   150: aload 5
    //   152: astore 6
    //   154: aload 4
    //   156: invokevirtual 201	java/io/DataInputStream:readInt	()I
    //   159: istore_1
    //   160: iload_2
    //   161: istore_3
    //   162: aload 4
    //   164: astore 7
    //   166: aload 5
    //   168: astore 6
    //   170: iconst_1
    //   171: iload_1
    //   172: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:isEqual	(II)Z
    //   175: ifne +27 -> 202
    //   178: aload 4
    //   180: astore 7
    //   182: aload 5
    //   184: astore 6
    //   186: ldc 124
    //   188: ldc 209
    //   190: iload_1
    //   191: invokestatic 212	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   197: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: iconst_0
    //   201: istore_3
    //   202: iload_3
    //   203: istore_2
    //   204: aload 4
    //   206: astore 7
    //   208: aload 5
    //   210: astore 6
    //   212: aload 9
    //   214: invokestatic 153	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   217: ifne +138 -> 355
    //   220: aload 4
    //   222: astore 7
    //   224: aload 5
    //   226: astore 6
    //   228: ldc 124
    //   230: ldc 214
    //   232: aload 9
    //   234: invokestatic 161	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   237: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 4
    //   245: astore 7
    //   247: aload 5
    //   249: astore 6
    //   251: getstatic 220	android/os/Build$VERSION:SDK_INT	I
    //   254: bipush 30
    //   256: if_icmpne +149 -> 405
    //   259: aload 4
    //   261: astore 7
    //   263: aload 5
    //   265: astore 6
    //   267: getstatic 225	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   270: ldc 227
    //   272: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual 234	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   278: ldc 236
    //   280: invokevirtual 234	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   283: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   286: ifeq +119 -> 405
    //   289: aload 4
    //   291: astore 7
    //   293: aload 5
    //   295: astore 6
    //   297: ldc 124
    //   299: ldc 242
    //   301: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 4
    //   306: astore 7
    //   308: aload 5
    //   310: astore 6
    //   312: new 244	java/io/File
    //   315: dup
    //   316: aload 9
    //   318: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   321: astore 8
    //   323: iload_3
    //   324: istore_2
    //   325: aload 4
    //   327: astore 7
    //   329: aload 5
    //   331: astore 6
    //   333: aload 8
    //   335: invokevirtual 249	java/io/File:exists	()Z
    //   338: ifeq +17 -> 355
    //   341: aload 4
    //   343: astore 7
    //   345: aload 5
    //   347: astore 6
    //   349: aload 8
    //   351: invokevirtual 252	java/io/File:delete	()Z
    //   354: istore_2
    //   355: aload 5
    //   357: invokevirtual 255	java/io/DataOutputStream:close	()V
    //   360: aload 4
    //   362: invokevirtual 256	java/io/DataInputStream:close	()V
    //   365: iload_2
    //   366: ifne +31 -> 397
    //   369: ldc 124
    //   371: new 54	java/lang/StringBuilder
    //   374: dup
    //   375: ldc_w 258
    //   378: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: aload_0
    //   382: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc_w 260
    //   388: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: sipush 31176
    //   400: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: iload_2
    //   404: ireturn
    //   405: iconst_0
    //   406: istore_2
    //   407: goto -52 -> 355
    //   410: astore 5
    //   412: ldc 124
    //   414: aload 5
    //   416: ldc 227
    //   418: iconst_0
    //   419: anewarray 4	java/lang/Object
    //   422: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: goto -65 -> 360
    //   428: astore 4
    //   430: ldc 124
    //   432: aload 4
    //   434: ldc 227
    //   436: iconst_0
    //   437: anewarray 4	java/lang/Object
    //   440: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: goto -78 -> 365
    //   446: astore 8
    //   448: aconst_null
    //   449: astore 4
    //   451: aconst_null
    //   452: astore 5
    //   454: aload 4
    //   456: astore 7
    //   458: aload 5
    //   460: astore 6
    //   462: ldc 124
    //   464: aload 8
    //   466: ldc_w 266
    //   469: aload 9
    //   471: invokestatic 161	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   474: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   477: iconst_0
    //   478: anewarray 4	java/lang/Object
    //   481: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: aload 5
    //   486: ifnull +8 -> 494
    //   489: aload 5
    //   491: invokevirtual 255	java/io/DataOutputStream:close	()V
    //   494: aload 4
    //   496: ifnull +150 -> 646
    //   499: aload 4
    //   501: invokevirtual 256	java/io/DataInputStream:close	()V
    //   504: iconst_0
    //   505: istore_2
    //   506: goto -141 -> 365
    //   509: astore 5
    //   511: ldc 124
    //   513: aload 5
    //   515: ldc 227
    //   517: iconst_0
    //   518: anewarray 4	java/lang/Object
    //   521: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   524: goto -30 -> 494
    //   527: astore 4
    //   529: ldc 124
    //   531: aload 4
    //   533: ldc 227
    //   535: iconst_0
    //   536: anewarray 4	java/lang/Object
    //   539: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   542: iconst_0
    //   543: istore_2
    //   544: goto -179 -> 365
    //   547: astore_0
    //   548: aconst_null
    //   549: astore 7
    //   551: aconst_null
    //   552: astore 5
    //   554: aload 5
    //   556: ifnull +8 -> 564
    //   559: aload 5
    //   561: invokevirtual 255	java/io/DataOutputStream:close	()V
    //   564: aload 7
    //   566: ifnull +8 -> 574
    //   569: aload 7
    //   571: invokevirtual 256	java/io/DataInputStream:close	()V
    //   574: sipush 31176
    //   577: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   580: aload_0
    //   581: athrow
    //   582: astore 4
    //   584: ldc 124
    //   586: aload 4
    //   588: ldc 227
    //   590: iconst_0
    //   591: anewarray 4	java/lang/Object
    //   594: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   597: goto -33 -> 564
    //   600: astore 4
    //   602: ldc 124
    //   604: aload 4
    //   606: ldc 227
    //   608: iconst_0
    //   609: anewarray 4	java/lang/Object
    //   612: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   615: goto -41 -> 574
    //   618: astore_0
    //   619: aconst_null
    //   620: astore 7
    //   622: goto -68 -> 554
    //   625: astore_0
    //   626: aload 6
    //   628: astore 5
    //   630: goto -76 -> 554
    //   633: astore 8
    //   635: aconst_null
    //   636: astore 4
    //   638: goto -184 -> 454
    //   641: astore 8
    //   643: goto -189 -> 454
    //   646: iconst_0
    //   647: istore_2
    //   648: goto -283 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	paramString	java.lang.String
    //   159	32	1	i	int
    //   45	603	2	bool1	boolean
    //   1	323	3	bool2	boolean
    //   144	217	4	localDataInputStream	java.io.DataInputStream
    //   428	5	4	localIOException1	java.io.IOException
    //   449	51	4	localObject1	Object
    //   527	5	4	localIOException2	java.io.IOException
    //   582	5	4	localIOException3	java.io.IOException
    //   600	5	4	localIOException4	java.io.IOException
    //   636	1	4	localObject2	Object
    //   119	237	5	localDataOutputStream	java.io.DataOutputStream
    //   410	5	5	localIOException5	java.io.IOException
    //   452	38	5	localObject3	Object
    //   509	5	5	localIOException6	java.io.IOException
    //   552	77	5	localObject4	Object
    //   152	475	6	localObject5	Object
    //   148	473	7	localObject6	Object
    //   321	29	8	localFile	java.io.File
    //   446	19	8	localIOException7	java.io.IOException
    //   633	1	8	localIOException8	java.io.IOException
    //   641	1	8	localIOException9	java.io.IOException
    //   42	428	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   355	360	410	java/io/IOException
    //   360	365	428	java/io/IOException
    //   46	54	446	java/io/IOException
    //   56	79	446	java/io/IOException
    //   81	104	446	java/io/IOException
    //   106	121	446	java/io/IOException
    //   489	494	509	java/io/IOException
    //   499	504	527	java/io/IOException
    //   46	54	547	finally
    //   56	79	547	finally
    //   81	104	547	finally
    //   106	121	547	finally
    //   559	564	582	java/io/IOException
    //   569	574	600	java/io/IOException
    //   121	146	618	finally
    //   154	160	625	finally
    //   170	178	625	finally
    //   186	200	625	finally
    //   212	220	625	finally
    //   228	243	625	finally
    //   251	259	625	finally
    //   267	289	625	finally
    //   297	304	625	finally
    //   312	323	625	finally
    //   333	341	625	finally
    //   349	355	625	finally
    //   462	484	625	finally
    //   121	146	633	java/io/IOException
    //   154	160	641	java/io/IOException
    //   170	178	641	java/io/IOException
    //   186	200	641	java/io/IOException
    //   212	220	641	java/io/IOException
    //   228	243	641	java/io/IOException
    //   251	259	641	java/io/IOException
    //   267	289	641	java/io/IOException
    //   297	304	641	java/io/IOException
    //   312	323	641	java/io/IOException
    //   333	341	641	java/io/IOException
    //   349	355	641	java/io/IOException
  }
  
  public static boolean goj()
  {
    AppMethodBeat.i(31175);
    g.aAi();
    if (!g.aAh().isSDCardAvailable())
    {
      AppMethodBeat.o(31175);
      return true;
    }
    boolean bool = bem(b.aKJ());
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31174);
        c.access$000();
        AppMethodBeat.o(31174);
      }
    });
    AppMethodBeat.o(31175);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.c
 * JD-Core Version:    0.7.0.1
 */