package com.tencent.mm.pluginsdk.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.aq;

public final class c
{
  private static boolean[] ERx = new boolean[21];
  
  /* Error */
  private static boolean aMo(java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 31176
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 28	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   12: ifne +11 -> 23
    //   15: sipush 31176
    //   18: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_1
    //   22: ireturn
    //   23: new 33	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   30: aload_0
    //   31: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 42
    //   36: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 9
    //   44: iload_3
    //   45: istore_2
    //   46: aload 9
    //   48: invokestatic 28	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   51: ifeq +30 -> 81
    //   54: iload_3
    //   55: istore_2
    //   56: aload 9
    //   58: invokestatic 49	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   61: ifne +20 -> 81
    //   64: ldc 51
    //   66: ldc 53
    //   68: aload 9
    //   70: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iconst_0
    //   80: istore_2
    //   81: aload 9
    //   83: invokestatic 72	com/tencent/mm/vfs/i:aYs	(Ljava/lang/String;)Z
    //   86: ifne +20 -> 106
    //   89: ldc 51
    //   91: ldc 74
    //   93: aload 9
    //   95: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: iconst_0
    //   105: istore_2
    //   106: new 76	java/io/DataOutputStream
    //   109: dup
    //   110: aload 9
    //   112: iconst_0
    //   113: invokestatic 80	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   116: invokespecial 83	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   119: astore 5
    //   121: aload 5
    //   123: iconst_1
    //   124: invokevirtual 86	java/io/DataOutputStream:writeInt	(I)V
    //   127: aload 5
    //   129: invokevirtual 89	java/io/DataOutputStream:flush	()V
    //   132: new 91	java/io/DataInputStream
    //   135: dup
    //   136: aload 9
    //   138: invokestatic 95	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: invokespecial 98	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   144: astore 4
    //   146: aload 4
    //   148: astore 7
    //   150: aload 5
    //   152: astore 6
    //   154: aload 4
    //   156: invokevirtual 102	java/io/DataInputStream:readInt	()I
    //   159: istore_1
    //   160: iload_2
    //   161: istore_3
    //   162: aload 4
    //   164: astore 7
    //   166: aload 5
    //   168: astore 6
    //   170: iconst_1
    //   171: iload_1
    //   172: invokestatic 108	com/tencent/mm/sdk/platformtools/bt:jx	(II)Z
    //   175: ifne +27 -> 202
    //   178: aload 4
    //   180: astore 7
    //   182: aload 5
    //   184: astore 6
    //   186: ldc 51
    //   188: ldc 110
    //   190: iload_1
    //   191: invokestatic 113	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   197: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: iconst_0
    //   201: istore_3
    //   202: iload_3
    //   203: istore_2
    //   204: aload 4
    //   206: astore 7
    //   208: aload 5
    //   210: astore 6
    //   212: aload 9
    //   214: invokestatic 49	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   217: ifne +138 -> 355
    //   220: aload 4
    //   222: astore 7
    //   224: aload 5
    //   226: astore 6
    //   228: ldc 51
    //   230: ldc 115
    //   232: aload 9
    //   234: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   237: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 4
    //   245: astore 7
    //   247: aload 5
    //   249: astore 6
    //   251: getstatic 121	android/os/Build$VERSION:SDK_INT	I
    //   254: bipush 30
    //   256: if_icmpne +147 -> 403
    //   259: aload 4
    //   261: astore 7
    //   263: aload 5
    //   265: astore 6
    //   267: getstatic 127	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   270: ldc 129
    //   272: invokestatic 133	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual 136	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   278: ldc 138
    //   280: invokevirtual 136	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   283: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   286: ifeq +117 -> 403
    //   289: aload 4
    //   291: astore 7
    //   293: aload 5
    //   295: astore 6
    //   297: ldc 51
    //   299: ldc 144
    //   301: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 4
    //   306: astore 7
    //   308: aload 5
    //   310: astore 6
    //   312: new 146	java/io/File
    //   315: dup
    //   316: aload 9
    //   318: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   321: astore 8
    //   323: iload_3
    //   324: istore_2
    //   325: aload 4
    //   327: astore 7
    //   329: aload 5
    //   331: astore 6
    //   333: aload 8
    //   335: invokevirtual 153	java/io/File:exists	()Z
    //   338: ifeq +17 -> 355
    //   341: aload 4
    //   343: astore 7
    //   345: aload 5
    //   347: astore 6
    //   349: aload 8
    //   351: invokevirtual 156	java/io/File:delete	()Z
    //   354: istore_2
    //   355: aload 5
    //   357: invokevirtual 159	java/io/DataOutputStream:close	()V
    //   360: aload 4
    //   362: invokevirtual 160	java/io/DataInputStream:close	()V
    //   365: iload_2
    //   366: ifne +29 -> 395
    //   369: ldc 51
    //   371: new 33	java/lang/StringBuilder
    //   374: dup
    //   375: ldc 162
    //   377: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: aload_0
    //   381: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc 165
    //   386: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: sipush 31176
    //   398: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: iload_2
    //   402: ireturn
    //   403: iconst_0
    //   404: istore_2
    //   405: goto -50 -> 355
    //   408: astore 5
    //   410: ldc 51
    //   412: aload 5
    //   414: ldc 129
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: goto -63 -> 360
    //   426: astore 4
    //   428: ldc 51
    //   430: aload 4
    //   432: ldc 129
    //   434: iconst_0
    //   435: anewarray 4	java/lang/Object
    //   438: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: goto -76 -> 365
    //   444: astore 8
    //   446: aconst_null
    //   447: astore 4
    //   449: aconst_null
    //   450: astore 5
    //   452: aload 4
    //   454: astore 7
    //   456: aload 5
    //   458: astore 6
    //   460: ldc 51
    //   462: aload 8
    //   464: ldc 171
    //   466: aload 9
    //   468: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   471: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   474: iconst_0
    //   475: anewarray 4	java/lang/Object
    //   478: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: aload 5
    //   483: ifnull +8 -> 491
    //   486: aload 5
    //   488: invokevirtual 159	java/io/DataOutputStream:close	()V
    //   491: aload 4
    //   493: ifnull +150 -> 643
    //   496: aload 4
    //   498: invokevirtual 160	java/io/DataInputStream:close	()V
    //   501: iconst_0
    //   502: istore_2
    //   503: goto -138 -> 365
    //   506: astore 5
    //   508: ldc 51
    //   510: aload 5
    //   512: ldc 129
    //   514: iconst_0
    //   515: anewarray 4	java/lang/Object
    //   518: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: goto -30 -> 491
    //   524: astore 4
    //   526: ldc 51
    //   528: aload 4
    //   530: ldc 129
    //   532: iconst_0
    //   533: anewarray 4	java/lang/Object
    //   536: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   539: iconst_0
    //   540: istore_2
    //   541: goto -176 -> 365
    //   544: astore_0
    //   545: aconst_null
    //   546: astore 7
    //   548: aconst_null
    //   549: astore 5
    //   551: aload 5
    //   553: ifnull +8 -> 561
    //   556: aload 5
    //   558: invokevirtual 159	java/io/DataOutputStream:close	()V
    //   561: aload 7
    //   563: ifnull +8 -> 571
    //   566: aload 7
    //   568: invokevirtual 160	java/io/DataInputStream:close	()V
    //   571: sipush 31176
    //   574: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   577: aload_0
    //   578: athrow
    //   579: astore 4
    //   581: ldc 51
    //   583: aload 4
    //   585: ldc 129
    //   587: iconst_0
    //   588: anewarray 4	java/lang/Object
    //   591: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   594: goto -33 -> 561
    //   597: astore 4
    //   599: ldc 51
    //   601: aload 4
    //   603: ldc 129
    //   605: iconst_0
    //   606: anewarray 4	java/lang/Object
    //   609: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   612: goto -41 -> 571
    //   615: astore_0
    //   616: aconst_null
    //   617: astore 7
    //   619: goto -68 -> 551
    //   622: astore_0
    //   623: aload 6
    //   625: astore 5
    //   627: goto -76 -> 551
    //   630: astore 8
    //   632: aconst_null
    //   633: astore 4
    //   635: goto -183 -> 452
    //   638: astore 8
    //   640: goto -188 -> 452
    //   643: iconst_0
    //   644: istore_2
    //   645: goto -280 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	paramString	java.lang.String
    //   159	32	1	i	int
    //   45	600	2	bool1	boolean
    //   1	323	3	bool2	boolean
    //   144	217	4	localDataInputStream	java.io.DataInputStream
    //   426	5	4	localIOException1	java.io.IOException
    //   447	50	4	localObject1	Object
    //   524	5	4	localIOException2	java.io.IOException
    //   579	5	4	localIOException3	java.io.IOException
    //   597	5	4	localIOException4	java.io.IOException
    //   633	1	4	localObject2	Object
    //   119	237	5	localDataOutputStream	java.io.DataOutputStream
    //   408	5	5	localIOException5	java.io.IOException
    //   450	37	5	localObject3	Object
    //   506	5	5	localIOException6	java.io.IOException
    //   549	77	5	localObject4	Object
    //   152	472	6	localObject5	Object
    //   148	470	7	localObject6	Object
    //   321	29	8	localFile	java.io.File
    //   444	19	8	localIOException7	java.io.IOException
    //   630	1	8	localIOException8	java.io.IOException
    //   638	1	8	localIOException9	java.io.IOException
    //   42	425	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   355	360	408	java/io/IOException
    //   360	365	426	java/io/IOException
    //   46	54	444	java/io/IOException
    //   56	79	444	java/io/IOException
    //   81	104	444	java/io/IOException
    //   106	121	444	java/io/IOException
    //   486	491	506	java/io/IOException
    //   496	501	524	java/io/IOException
    //   46	54	544	finally
    //   56	79	544	finally
    //   81	104	544	finally
    //   106	121	544	finally
    //   556	561	579	java/io/IOException
    //   566	571	597	java/io/IOException
    //   121	146	615	finally
    //   154	160	622	finally
    //   170	178	622	finally
    //   186	200	622	finally
    //   212	220	622	finally
    //   228	243	622	finally
    //   251	259	622	finally
    //   267	289	622	finally
    //   297	304	622	finally
    //   312	323	622	finally
    //   333	341	622	finally
    //   349	355	622	finally
    //   460	481	622	finally
    //   121	146	630	java/io/IOException
    //   154	160	638	java/io/IOException
    //   170	178	638	java/io/IOException
    //   186	200	638	java/io/IOException
    //   212	220	638	java/io/IOException
    //   228	243	638	java/io/IOException
    //   251	259	638	java/io/IOException
    //   267	289	638	java/io/IOException
    //   297	304	638	java/io/IOException
    //   312	323	638	java/io/IOException
    //   333	341	638	java/io/IOException
    //   349	355	638	java/io/IOException
  }
  
  public static boolean fbl()
  {
    AppMethodBeat.i(31175);
    g.ajD();
    if (!g.ajC().isSDCardAvailable())
    {
      AppMethodBeat.o(31175);
      return true;
    }
    boolean bool = aMo(b.arU());
    g.ajF().ay(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.c
 * JD-Core Version:    0.7.0.1
 */