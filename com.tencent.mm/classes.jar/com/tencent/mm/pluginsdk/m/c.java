package com.tencent.mm.pluginsdk.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class c
{
  private static boolean[] Rbn = new boolean[21];
  
  /* Error */
  private static boolean bqI(java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 31176
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 148	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
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
    //   48: invokestatic 148	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   51: ifeq +30 -> 81
    //   54: iload_3
    //   55: istore_2
    //   56: aload 9
    //   58: invokestatic 153	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
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
    //   83: invokestatic 171	com/tencent/mm/vfs/u:bBV	(Ljava/lang/String;)Z
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
    //   112: invokestatic 179	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   115: invokespecial 182	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   118: astore 5
    //   120: aload 5
    //   122: iconst_1
    //   123: invokevirtual 185	java/io/DataOutputStream:writeInt	(I)V
    //   126: aload 5
    //   128: invokevirtual 188	java/io/DataOutputStream:flush	()V
    //   131: new 190	java/io/DataInputStream
    //   134: dup
    //   135: aload 9
    //   137: invokestatic 194	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   140: invokespecial 197	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   143: astore 4
    //   145: aload 4
    //   147: astore 7
    //   149: aload 5
    //   151: astore 6
    //   153: aload 4
    //   155: invokevirtual 201	java/io/DataInputStream:readInt	()I
    //   158: istore_1
    //   159: iload_2
    //   160: istore_3
    //   161: aload 4
    //   163: astore 7
    //   165: aload 5
    //   167: astore 6
    //   169: iconst_1
    //   170: iload_1
    //   171: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:isEqual	(II)Z
    //   174: ifne +27 -> 201
    //   177: aload 4
    //   179: astore 7
    //   181: aload 5
    //   183: astore 6
    //   185: ldc 124
    //   187: ldc 209
    //   189: iload_1
    //   190: invokestatic 212	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   193: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   196: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: iconst_0
    //   200: istore_3
    //   201: iload_3
    //   202: istore_2
    //   203: aload 4
    //   205: astore 7
    //   207: aload 5
    //   209: astore 6
    //   211: aload 9
    //   213: invokestatic 153	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   216: ifne +138 -> 354
    //   219: aload 4
    //   221: astore 7
    //   223: aload 5
    //   225: astore 6
    //   227: ldc 124
    //   229: ldc 214
    //   231: aload 9
    //   233: invokestatic 161	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   236: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload 4
    //   244: astore 7
    //   246: aload 5
    //   248: astore 6
    //   250: getstatic 220	android/os/Build$VERSION:SDK_INT	I
    //   253: bipush 30
    //   255: if_icmpne +149 -> 404
    //   258: aload 4
    //   260: astore 7
    //   262: aload 5
    //   264: astore 6
    //   266: getstatic 225	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   269: ldc 227
    //   271: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   274: invokevirtual 234	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   277: ldc 236
    //   279: invokevirtual 234	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   282: invokevirtual 240	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   285: ifeq +119 -> 404
    //   288: aload 4
    //   290: astore 7
    //   292: aload 5
    //   294: astore 6
    //   296: ldc 124
    //   298: ldc 242
    //   300: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload 4
    //   305: astore 7
    //   307: aload 5
    //   309: astore 6
    //   311: new 244	java/io/File
    //   314: dup
    //   315: aload 9
    //   317: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: astore 8
    //   322: iload_3
    //   323: istore_2
    //   324: aload 4
    //   326: astore 7
    //   328: aload 5
    //   330: astore 6
    //   332: aload 8
    //   334: invokevirtual 249	java/io/File:exists	()Z
    //   337: ifeq +17 -> 354
    //   340: aload 4
    //   342: astore 7
    //   344: aload 5
    //   346: astore 6
    //   348: aload 8
    //   350: invokevirtual 252	java/io/File:delete	()Z
    //   353: istore_2
    //   354: aload 5
    //   356: invokevirtual 255	java/io/DataOutputStream:close	()V
    //   359: aload 4
    //   361: invokevirtual 256	java/io/DataInputStream:close	()V
    //   364: iload_2
    //   365: ifne +31 -> 396
    //   368: ldc 124
    //   370: new 54	java/lang/StringBuilder
    //   373: dup
    //   374: ldc_w 258
    //   377: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: aload_0
    //   381: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 260
    //   387: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: sipush 31176
    //   399: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: iload_2
    //   403: ireturn
    //   404: iconst_0
    //   405: istore_2
    //   406: goto -52 -> 354
    //   409: astore 5
    //   411: ldc 124
    //   413: aload 5
    //   415: ldc 227
    //   417: iconst_0
    //   418: anewarray 4	java/lang/Object
    //   421: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   424: goto -65 -> 359
    //   427: astore 4
    //   429: ldc 124
    //   431: aload 4
    //   433: ldc 227
    //   435: iconst_0
    //   436: anewarray 4	java/lang/Object
    //   439: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: goto -78 -> 364
    //   445: astore 8
    //   447: aconst_null
    //   448: astore 4
    //   450: aconst_null
    //   451: astore 5
    //   453: aload 4
    //   455: astore 7
    //   457: aload 5
    //   459: astore 6
    //   461: ldc 124
    //   463: aload 8
    //   465: ldc_w 266
    //   468: aload 9
    //   470: invokestatic 161	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   473: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   476: iconst_0
    //   477: anewarray 4	java/lang/Object
    //   480: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   483: aload 5
    //   485: ifnull +8 -> 493
    //   488: aload 5
    //   490: invokevirtual 255	java/io/DataOutputStream:close	()V
    //   493: aload 4
    //   495: ifnull +150 -> 645
    //   498: aload 4
    //   500: invokevirtual 256	java/io/DataInputStream:close	()V
    //   503: iconst_0
    //   504: istore_2
    //   505: goto -141 -> 364
    //   508: astore 5
    //   510: ldc 124
    //   512: aload 5
    //   514: ldc 227
    //   516: iconst_0
    //   517: anewarray 4	java/lang/Object
    //   520: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   523: goto -30 -> 493
    //   526: astore 4
    //   528: ldc 124
    //   530: aload 4
    //   532: ldc 227
    //   534: iconst_0
    //   535: anewarray 4	java/lang/Object
    //   538: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: iconst_0
    //   542: istore_2
    //   543: goto -179 -> 364
    //   546: astore_0
    //   547: aconst_null
    //   548: astore 7
    //   550: aconst_null
    //   551: astore 5
    //   553: aload 5
    //   555: ifnull +8 -> 563
    //   558: aload 5
    //   560: invokevirtual 255	java/io/DataOutputStream:close	()V
    //   563: aload 7
    //   565: ifnull +8 -> 573
    //   568: aload 7
    //   570: invokevirtual 256	java/io/DataInputStream:close	()V
    //   573: sipush 31176
    //   576: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   579: aload_0
    //   580: athrow
    //   581: astore 4
    //   583: ldc 124
    //   585: aload 4
    //   587: ldc 227
    //   589: iconst_0
    //   590: anewarray 4	java/lang/Object
    //   593: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   596: goto -33 -> 563
    //   599: astore 4
    //   601: ldc 124
    //   603: aload 4
    //   605: ldc 227
    //   607: iconst_0
    //   608: anewarray 4	java/lang/Object
    //   611: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: goto -41 -> 573
    //   617: astore_0
    //   618: aconst_null
    //   619: astore 7
    //   621: goto -68 -> 553
    //   624: astore_0
    //   625: aload 6
    //   627: astore 5
    //   629: goto -76 -> 553
    //   632: astore 8
    //   634: aconst_null
    //   635: astore 4
    //   637: goto -184 -> 453
    //   640: astore 8
    //   642: goto -189 -> 453
    //   645: iconst_0
    //   646: istore_2
    //   647: goto -283 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	paramString	java.lang.String
    //   158	32	1	i	int
    //   45	602	2	bool1	boolean
    //   1	322	3	bool2	boolean
    //   143	217	4	localDataInputStream	java.io.DataInputStream
    //   427	5	4	localIOException1	java.io.IOException
    //   448	51	4	localObject1	Object
    //   526	5	4	localIOException2	java.io.IOException
    //   581	5	4	localIOException3	java.io.IOException
    //   599	5	4	localIOException4	java.io.IOException
    //   635	1	4	localObject2	Object
    //   118	237	5	localDataOutputStream	java.io.DataOutputStream
    //   409	5	5	localIOException5	java.io.IOException
    //   451	38	5	localObject3	Object
    //   508	5	5	localIOException6	java.io.IOException
    //   551	77	5	localObject4	Object
    //   151	475	6	localObject5	Object
    //   147	473	7	localObject6	Object
    //   320	29	8	localFile	java.io.File
    //   445	19	8	localIOException7	java.io.IOException
    //   632	1	8	localIOException8	java.io.IOException
    //   640	1	8	localIOException9	java.io.IOException
    //   42	427	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   354	359	409	java/io/IOException
    //   359	364	427	java/io/IOException
    //   46	54	445	java/io/IOException
    //   56	79	445	java/io/IOException
    //   81	104	445	java/io/IOException
    //   106	120	445	java/io/IOException
    //   488	493	508	java/io/IOException
    //   498	503	526	java/io/IOException
    //   46	54	546	finally
    //   56	79	546	finally
    //   81	104	546	finally
    //   106	120	546	finally
    //   558	563	581	java/io/IOException
    //   568	573	599	java/io/IOException
    //   120	145	617	finally
    //   153	159	624	finally
    //   169	177	624	finally
    //   185	199	624	finally
    //   211	219	624	finally
    //   227	242	624	finally
    //   250	258	624	finally
    //   266	288	624	finally
    //   296	303	624	finally
    //   311	322	624	finally
    //   332	340	624	finally
    //   348	354	624	finally
    //   461	483	624	finally
    //   120	145	632	java/io/IOException
    //   153	159	640	java/io/IOException
    //   169	177	640	java/io/IOException
    //   185	199	640	java/io/IOException
    //   211	219	640	java/io/IOException
    //   227	242	640	java/io/IOException
    //   250	258	640	java/io/IOException
    //   266	288	640	java/io/IOException
    //   296	303	640	java/io/IOException
    //   311	322	640	java/io/IOException
    //   332	340	640	java/io/IOException
    //   348	354	640	java/io/IOException
  }
  
  public static boolean hiT()
  {
    AppMethodBeat.i(31175);
    h.aHH();
    if (!h.aHG().isSDCardAvailable())
    {
      AppMethodBeat.o(31175);
      return true;
    }
    boolean bool = bqI(b.aSL());
    h.aHJ().postToWorker(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.m.c
 * JD-Core Version:    0.7.0.1
 */