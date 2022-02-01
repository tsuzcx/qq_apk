package com.tencent.mm.pluginsdk.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.aq;

public final class c
{
  private static boolean[] BUf = new boolean[21];
  
  /* Error */
  private static boolean aBw(java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: sipush 31176
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 28	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
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
    //   42: astore 8
    //   44: aload 8
    //   46: invokestatic 28	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   49: ifeq +9 -> 58
    //   52: aload 8
    //   54: invokestatic 49	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   57: pop
    //   58: aload 8
    //   60: invokestatic 52	com/tencent/mm/vfs/i:aMR	(Ljava/lang/String;)Z
    //   63: pop
    //   64: new 54	java/io/DataOutputStream
    //   67: dup
    //   68: aload 8
    //   70: iconst_0
    //   71: invokestatic 58	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   74: invokespecial 61	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   77: astore 5
    //   79: aload 5
    //   81: iconst_1
    //   82: invokevirtual 64	java/io/DataOutputStream:writeInt	(I)V
    //   85: aload 5
    //   87: invokevirtual 67	java/io/DataOutputStream:flush	()V
    //   90: aload 5
    //   92: invokevirtual 70	java/io/DataOutputStream:close	()V
    //   95: new 72	java/io/DataInputStream
    //   98: dup
    //   99: aload 8
    //   101: invokestatic 76	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   104: invokespecial 79	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore 4
    //   109: aload 4
    //   111: astore 7
    //   113: aload 5
    //   115: astore 6
    //   117: aload 4
    //   119: invokevirtual 83	java/io/DataInputStream:readInt	()I
    //   122: istore_1
    //   123: aload 4
    //   125: astore 7
    //   127: aload 5
    //   129: astore 6
    //   131: aload 4
    //   133: invokevirtual 84	java/io/DataInputStream:close	()V
    //   136: aload 4
    //   138: astore 7
    //   140: aload 5
    //   142: astore 6
    //   144: aload 8
    //   146: invokestatic 49	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   149: ifeq +69 -> 218
    //   152: aload 4
    //   154: astore 7
    //   156: aload 5
    //   158: astore 6
    //   160: iconst_1
    //   161: iload_1
    //   162: invokestatic 90	com/tencent/mm/sdk/platformtools/bt:iY	(II)Z
    //   165: istore_3
    //   166: iload_3
    //   167: ifeq +51 -> 218
    //   170: aload 5
    //   172: invokevirtual 70	java/io/DataOutputStream:close	()V
    //   175: aload 4
    //   177: invokevirtual 84	java/io/DataInputStream:close	()V
    //   180: iload_2
    //   181: ifne +29 -> 210
    //   184: ldc 92
    //   186: new 33	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 94
    //   192: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: aload_0
    //   196: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 99
    //   201: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: sipush 31176
    //   213: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: iload_2
    //   217: ireturn
    //   218: iconst_0
    //   219: istore_2
    //   220: goto -50 -> 170
    //   223: astore 5
    //   225: ldc 92
    //   227: aload 5
    //   229: ldc 107
    //   231: iconst_0
    //   232: anewarray 4	java/lang/Object
    //   235: invokestatic 111	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: goto -63 -> 175
    //   241: astore 4
    //   243: ldc 92
    //   245: aload 4
    //   247: ldc 107
    //   249: iconst_0
    //   250: anewarray 4	java/lang/Object
    //   253: invokestatic 111	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: goto -76 -> 180
    //   259: astore 8
    //   261: aconst_null
    //   262: astore 4
    //   264: aconst_null
    //   265: astore 5
    //   267: aload 4
    //   269: astore 7
    //   271: aload 5
    //   273: astore 6
    //   275: ldc 92
    //   277: new 33	java/lang/StringBuilder
    //   280: dup
    //   281: ldc 94
    //   283: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: aload_0
    //   287: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 99
    //   292: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 8
    //   297: invokevirtual 114	java/io/IOException:getMessage	()Ljava/lang/String;
    //   300: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload 5
    //   311: ifnull +8 -> 319
    //   314: aload 5
    //   316: invokevirtual 70	java/io/DataOutputStream:close	()V
    //   319: aload 4
    //   321: ifnull +150 -> 471
    //   324: aload 4
    //   326: invokevirtual 84	java/io/DataInputStream:close	()V
    //   329: iconst_0
    //   330: istore_2
    //   331: goto -151 -> 180
    //   334: astore 5
    //   336: ldc 92
    //   338: aload 5
    //   340: ldc 107
    //   342: iconst_0
    //   343: anewarray 4	java/lang/Object
    //   346: invokestatic 111	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: goto -30 -> 319
    //   352: astore 4
    //   354: ldc 92
    //   356: aload 4
    //   358: ldc 107
    //   360: iconst_0
    //   361: anewarray 4	java/lang/Object
    //   364: invokestatic 111	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   367: iconst_0
    //   368: istore_2
    //   369: goto -189 -> 180
    //   372: astore_0
    //   373: aconst_null
    //   374: astore 7
    //   376: aconst_null
    //   377: astore 5
    //   379: aload 5
    //   381: ifnull +8 -> 389
    //   384: aload 5
    //   386: invokevirtual 70	java/io/DataOutputStream:close	()V
    //   389: aload 7
    //   391: ifnull +8 -> 399
    //   394: aload 7
    //   396: invokevirtual 84	java/io/DataInputStream:close	()V
    //   399: sipush 31176
    //   402: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: aload_0
    //   406: athrow
    //   407: astore 4
    //   409: ldc 92
    //   411: aload 4
    //   413: ldc 107
    //   415: iconst_0
    //   416: anewarray 4	java/lang/Object
    //   419: invokestatic 111	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   422: goto -33 -> 389
    //   425: astore 4
    //   427: ldc 92
    //   429: aload 4
    //   431: ldc 107
    //   433: iconst_0
    //   434: anewarray 4	java/lang/Object
    //   437: invokestatic 111	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   440: goto -41 -> 399
    //   443: astore_0
    //   444: aconst_null
    //   445: astore 7
    //   447: goto -68 -> 379
    //   450: astore_0
    //   451: aload 6
    //   453: astore 5
    //   455: goto -76 -> 379
    //   458: astore 8
    //   460: aconst_null
    //   461: astore 4
    //   463: goto -196 -> 267
    //   466: astore 8
    //   468: goto -201 -> 267
    //   471: iconst_0
    //   472: istore_2
    //   473: goto -293 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	paramString	java.lang.String
    //   122	40	1	i	int
    //   1	472	2	bool1	boolean
    //   165	2	3	bool2	boolean
    //   107	69	4	localDataInputStream	java.io.DataInputStream
    //   241	5	4	localIOException1	java.io.IOException
    //   262	63	4	localObject1	Object
    //   352	5	4	localIOException2	java.io.IOException
    //   407	5	4	localIOException3	java.io.IOException
    //   425	5	4	localIOException4	java.io.IOException
    //   461	1	4	localObject2	Object
    //   77	94	5	localDataOutputStream	java.io.DataOutputStream
    //   223	5	5	localIOException5	java.io.IOException
    //   265	50	5	localObject3	Object
    //   334	5	5	localIOException6	java.io.IOException
    //   377	77	5	localObject4	Object
    //   115	337	6	localObject5	Object
    //   111	335	7	localObject6	Object
    //   42	103	8	str	java.lang.String
    //   259	37	8	localIOException7	java.io.IOException
    //   458	1	8	localIOException8	java.io.IOException
    //   466	1	8	localIOException9	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   170	175	223	java/io/IOException
    //   175	180	241	java/io/IOException
    //   44	58	259	java/io/IOException
    //   58	79	259	java/io/IOException
    //   314	319	334	java/io/IOException
    //   324	329	352	java/io/IOException
    //   44	58	372	finally
    //   58	79	372	finally
    //   384	389	407	java/io/IOException
    //   394	399	425	java/io/IOException
    //   79	109	443	finally
    //   117	123	450	finally
    //   131	136	450	finally
    //   144	152	450	finally
    //   160	166	450	finally
    //   275	309	450	finally
    //   79	109	458	java/io/IOException
    //   117	123	466	java/io/IOException
    //   131	136	466	java/io/IOException
    //   144	152	466	java/io/IOException
    //   160	166	466	java/io/IOException
  }
  
  public static boolean ewU()
  {
    AppMethodBeat.i(31175);
    g.afC();
    if (!g.afB().isSDCardAvailable())
    {
      AppMethodBeat.o(31175);
      return true;
    }
    boolean bool = aBw(b.aih());
    g.afE().ax(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.c
 * JD-Core Version:    0.7.0.1
 */