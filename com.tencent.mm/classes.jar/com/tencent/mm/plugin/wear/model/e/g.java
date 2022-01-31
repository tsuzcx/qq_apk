package com.tencent.mm.plugin.wear.model.e;

import java.util.ArrayList;
import java.util.List;

public final class g
  extends a
{
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11005));
    localArrayList.add(Integer.valueOf(11006));
    localArrayList.add(Integer.valueOf(11007));
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iload_1
    //   4: sipush 11005
    //   7: if_icmpne +142 -> 149
    //   10: new 38	com/tencent/mm/protocal/c/ciy
    //   13: dup
    //   14: invokespecial 39	com/tencent/mm/protocal/c/ciy:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_2
    //   20: invokevirtual 43	com/tencent/mm/protocal/c/ciy:aH	([B)Lcom/tencent/mm/bv/a;
    //   23: pop
    //   24: new 45	com/tencent/mm/protocal/c/ciz
    //   27: dup
    //   28: invokespecial 46	com/tencent/mm/protocal/c/ciz:<init>	()V
    //   31: astore_2
    //   32: aload_3
    //   33: getfield 50	com/tencent/mm/protocal/c/ciy:sxM	Ljava/lang/String;
    //   36: invokestatic 56	com/tencent/mm/plugin/wear/model/h:Ri	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +86 -> 129
    //   46: aload_2
    //   47: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   50: putfield 66	com/tencent/mm/protocal/c/ciz:tXf	J
    //   53: aload 4
    //   55: invokestatic 70	com/tencent/mm/plugin/wear/model/h:P	(Landroid/graphics/Bitmap;)[B
    //   58: astore 4
    //   60: ldc 72
    //   62: ldc 74
    //   64: iconst_1
    //   65: anewarray 76	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_3
    //   71: getfield 50	com/tencent/mm/protocal/c/ciy:sxM	Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 82	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_2
    //   79: new 84	com/tencent/mm/bv/b
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 87	com/tencent/mm/bv/b:<init>	([B)V
    //   88: putfield 91	com/tencent/mm/protocal/c/ciz:hPF	Lcom/tencent/mm/bv/b;
    //   91: aload_2
    //   92: invokevirtual 95	com/tencent/mm/protocal/c/ciz:toByteArray	()[B
    //   95: astore_3
    //   96: aload_3
    //   97: areturn
    //   98: astore_2
    //   99: ldc 72
    //   101: aload_2
    //   102: ldc 97
    //   104: iconst_0
    //   105: anewarray 76	java/lang/Object
    //   108: invokestatic 101	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: goto -87 -> 24
    //   114: astore_2
    //   115: ldc 72
    //   117: aload_2
    //   118: ldc 97
    //   120: iconst_0
    //   121: anewarray 76	java/lang/Object
    //   124: invokestatic 101	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aconst_null
    //   128: areturn
    //   129: ldc 72
    //   131: ldc 103
    //   133: iconst_1
    //   134: anewarray 76	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_3
    //   140: getfield 50	com/tencent/mm/protocal/c/ciy:sxM	Ljava/lang/String;
    //   143: aastore
    //   144: invokestatic 106	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aconst_null
    //   148: areturn
    //   149: iload_1
    //   150: sipush 11006
    //   153: if_icmpne +170 -> 323
    //   156: new 108	java/lang/String
    //   159: dup
    //   160: aload_2
    //   161: ldc 110
    //   163: invokespecial 113	java/lang/String:<init>	([BLjava/lang/String;)V
    //   166: astore_2
    //   167: ldc 115
    //   169: invokestatic 121	com/tencent/mm/kernel/g:t	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   172: checkcast 115	com/tencent/mm/plugin/emoji/b/d
    //   175: invokeinterface 125 1 0
    //   180: aload_2
    //   181: invokeinterface 131 2 0
    //   186: astore_2
    //   187: aload 4
    //   189: astore_3
    //   190: aload_2
    //   191: ifnull -95 -> 96
    //   194: aload_2
    //   195: invokevirtual 137	com/tencent/mm/storage/emotion/EmojiInfo:ZH	()Z
    //   198: ifeq +29 -> 227
    //   201: aload_2
    //   202: invokestatic 143	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   205: invokevirtual 147	com/tencent/mm/storage/emotion/EmojiInfo:gm	(Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   208: invokestatic 70	com/tencent/mm/plugin/wear/model/h:P	(Landroid/graphics/Bitmap;)[B
    //   211: areturn
    //   212: astore_2
    //   213: ldc 72
    //   215: aload_2
    //   216: ldc 97
    //   218: iconst_0
    //   219: anewarray 76	java/lang/Object
    //   222: invokestatic 101	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aconst_null
    //   226: areturn
    //   227: aload_2
    //   228: getfield 151	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   231: getstatic 156	com/tencent/mm/storage/emotion/EmojiGroupInfo:uCQ	I
    //   234: if_icmpne +69 -> 303
    //   237: invokestatic 143	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   240: aload_2
    //   241: invokevirtual 160	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   244: invokestatic 164	com/tencent/mm/storage/emotion/EmojiInfo:bv	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   247: astore_3
    //   248: aload_3
    //   249: astore_2
    //   250: aload_3
    //   251: invokestatic 170	com/tencent/mm/a/e:k	(Ljava/io/InputStream;)[B
    //   254: astore 4
    //   256: aload_3
    //   257: invokestatic 174	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   260: aload 4
    //   262: areturn
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_3
    //   268: astore_2
    //   269: ldc 72
    //   271: ldc 176
    //   273: iconst_1
    //   274: anewarray 76	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload 4
    //   281: invokestatic 181	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   284: aastore
    //   285: invokestatic 184	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: aload_3
    //   289: invokestatic 174	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   292: aconst_null
    //   293: areturn
    //   294: astore_3
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_2
    //   298: invokestatic 174	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   301: aload_3
    //   302: athrow
    //   303: ldc 115
    //   305: invokestatic 121	com/tencent/mm/kernel/g:t	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   308: checkcast 115	com/tencent/mm/plugin/emoji/b/d
    //   311: invokeinterface 125 1 0
    //   316: aload_2
    //   317: invokeinterface 188 2 0
    //   322: areturn
    //   323: aload 4
    //   325: astore_3
    //   326: iload_1
    //   327: sipush 11007
    //   330: if_icmpne -234 -> 96
    //   333: new 190	com/tencent/mm/protocal/c/cjq
    //   336: dup
    //   337: invokespecial 191	com/tencent/mm/protocal/c/cjq:<init>	()V
    //   340: astore_3
    //   341: aload_3
    //   342: aload_2
    //   343: invokevirtual 192	com/tencent/mm/protocal/c/cjq:aH	([B)Lcom/tencent/mm/bv/a;
    //   346: pop
    //   347: invokestatic 198	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   350: pop
    //   351: invokestatic 204	com/tencent/mm/model/c:Fy	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/g;
    //   354: aload_3
    //   355: getfield 207	com/tencent/mm/protocal/c/cjq:tXq	J
    //   358: invokeinterface 213 3 0
    //   363: astore_2
    //   364: aload_3
    //   365: getfield 217	com/tencent/mm/protocal/c/cjq:tXu	Z
    //   368: ifne +77 -> 445
    //   371: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   374: aload_2
    //   375: getfield 228	com/tencent/mm/h/c/cs:field_imgPath	Ljava/lang/String;
    //   378: invokevirtual 234	com/tencent/mm/as/g:me	(Ljava/lang/String;)Ljava/lang/String;
    //   381: astore_2
    //   382: aload 4
    //   384: astore_3
    //   385: aload_2
    //   386: invokestatic 238	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   389: ifne -293 -> 96
    //   392: new 240	com/tencent/mm/protocal/c/cjr
    //   395: dup
    //   396: invokespecial 241	com/tencent/mm/protocal/c/cjr:<init>	()V
    //   399: astore_3
    //   400: aload_3
    //   401: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   404: putfield 242	com/tencent/mm/protocal/c/cjr:tXf	J
    //   407: aload_3
    //   408: new 84	com/tencent/mm/bv/b
    //   411: dup
    //   412: aload_2
    //   413: invokestatic 248	com/tencent/mm/modelsfs/FileOp:mS	(Ljava/lang/String;)[B
    //   416: invokespecial 87	com/tencent/mm/bv/b:<init>	([B)V
    //   419: putfield 249	com/tencent/mm/protocal/c/cjr:hPF	Lcom/tencent/mm/bv/b;
    //   422: aload_3
    //   423: invokevirtual 250	com/tencent/mm/protocal/c/cjr:toByteArray	()[B
    //   426: astore_2
    //   427: aload_2
    //   428: areturn
    //   429: astore_2
    //   430: ldc 72
    //   432: aload_2
    //   433: ldc 97
    //   435: iconst_0
    //   436: anewarray 76	java/lang/Object
    //   439: invokestatic 101	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: goto -95 -> 347
    //   445: new 240	com/tencent/mm/protocal/c/cjr
    //   448: dup
    //   449: invokespecial 241	com/tencent/mm/protocal/c/cjr:<init>	()V
    //   452: astore 6
    //   454: aload 6
    //   456: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   459: putfield 242	com/tencent/mm/protocal/c/cjr:tXf	J
    //   462: aload_2
    //   463: getfield 253	com/tencent/mm/h/c/cs:field_isSend	I
    //   466: iconst_1
    //   467: if_icmpne +102 -> 569
    //   470: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   473: aload_2
    //   474: getfield 256	com/tencent/mm/h/c/cs:field_msgId	J
    //   477: invokevirtual 260	com/tencent/mm/as/g:bY	(J)Lcom/tencent/mm/as/e;
    //   480: astore_3
    //   481: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   484: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   487: aload_3
    //   488: invokevirtual 264	com/tencent/mm/as/g:d	(Lcom/tencent/mm/as/e;)Ljava/lang/String;
    //   491: ldc 97
    //   493: ldc 97
    //   495: invokevirtual 268	com/tencent/mm/as/g:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   498: astore_2
    //   499: aload_2
    //   500: invokestatic 271	com/tencent/mm/modelsfs/FileOp:bK	(Ljava/lang/String;)Z
    //   503: ifeq +37 -> 540
    //   506: aload 4
    //   508: astore_3
    //   509: aload_2
    //   510: invokestatic 238	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   513: ifne -417 -> 96
    //   516: aload 6
    //   518: new 84	com/tencent/mm/bv/b
    //   521: dup
    //   522: aload_2
    //   523: invokestatic 248	com/tencent/mm/modelsfs/FileOp:mS	(Ljava/lang/String;)[B
    //   526: invokespecial 87	com/tencent/mm/bv/b:<init>	([B)V
    //   529: putfield 249	com/tencent/mm/protocal/c/cjr:hPF	Lcom/tencent/mm/bv/b;
    //   532: aload 6
    //   534: invokevirtual 250	com/tencent/mm/protocal/c/cjr:toByteArray	()[B
    //   537: astore_2
    //   538: aload_2
    //   539: areturn
    //   540: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   543: aload_3
    //   544: getfield 276	com/tencent/mm/as/e:enq	Ljava/lang/String;
    //   547: ldc 97
    //   549: ldc 97
    //   551: invokevirtual 268	com/tencent/mm/as/g:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   554: astore_3
    //   555: aload_3
    //   556: astore_2
    //   557: aload_3
    //   558: invokestatic 271	com/tencent/mm/modelsfs/FileOp:bK	(Ljava/lang/String;)Z
    //   561: ifne -55 -> 506
    //   564: aconst_null
    //   565: astore_2
    //   566: goto -60 -> 506
    //   569: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   572: aload_2
    //   573: getfield 279	com/tencent/mm/h/c/cs:field_msgSvrId	J
    //   576: invokevirtual 282	com/tencent/mm/as/g:bX	(J)Lcom/tencent/mm/as/e;
    //   579: astore 5
    //   581: aload 5
    //   583: invokevirtual 285	com/tencent/mm/as/e:Oq	()Z
    //   586: ifeq -22 -> 564
    //   589: aload 5
    //   591: invokevirtual 288	com/tencent/mm/as/e:Or	()Z
    //   594: ifeq +86 -> 680
    //   597: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   600: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   603: aload 5
    //   605: invokevirtual 264	com/tencent/mm/as/g:d	(Lcom/tencent/mm/as/e;)Ljava/lang/String;
    //   608: ldc 97
    //   610: ldc 97
    //   612: invokevirtual 268	com/tencent/mm/as/g:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   615: astore_3
    //   616: aload_3
    //   617: invokestatic 271	com/tencent/mm/modelsfs/FileOp:bK	(Ljava/lang/String;)Z
    //   620: ifeq +60 -> 680
    //   623: aload_3
    //   624: astore_2
    //   625: aload_3
    //   626: invokestatic 238	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   629: ifeq -123 -> 506
    //   632: invokestatic 223	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   635: aload 5
    //   637: getfield 276	com/tencent/mm/as/e:enq	Ljava/lang/String;
    //   640: ldc 97
    //   642: ldc 97
    //   644: invokevirtual 268	com/tencent/mm/as/g:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   647: astore 5
    //   649: aload_3
    //   650: astore_2
    //   651: aload 5
    //   653: invokestatic 271	com/tencent/mm/modelsfs/FileOp:bK	(Ljava/lang/String;)Z
    //   656: ifeq -150 -> 506
    //   659: aload 5
    //   661: astore_2
    //   662: goto -156 -> 506
    //   665: astore_2
    //   666: aconst_null
    //   667: areturn
    //   668: astore_2
    //   669: aconst_null
    //   670: areturn
    //   671: astore_3
    //   672: goto -375 -> 297
    //   675: astore 4
    //   677: goto -410 -> 267
    //   680: aconst_null
    //   681: astore_3
    //   682: goto -59 -> 623
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	g
    //   0	685	1	paramInt	int
    //   0	685	2	paramArrayOfByte	byte[]
    //   17	272	3	localObject1	java.lang.Object
    //   294	8	3	localObject2	java.lang.Object
    //   325	325	3	localObject3	java.lang.Object
    //   671	1	3	localObject4	java.lang.Object
    //   681	1	3	localObject5	java.lang.Object
    //   1	260	4	localObject6	java.lang.Object
    //   263	244	4	localException1	java.lang.Exception
    //   675	1	4	localException2	java.lang.Exception
    //   579	81	5	localObject7	java.lang.Object
    //   452	81	6	localcjr	com.tencent.mm.protocal.c.cjr
    // Exception table:
    //   from	to	target	type
    //   18	24	98	java/io/IOException
    //   91	96	114	java/io/IOException
    //   156	167	212	java/io/UnsupportedEncodingException
    //   237	248	263	java/lang/Exception
    //   237	248	294	finally
    //   341	347	429	java/io/IOException
    //   422	427	665	java/io/IOException
    //   532	538	668	java/io/IOException
    //   250	256	671	finally
    //   269	288	671	finally
    //   250	256	675	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.g
 * JD-Core Version:    0.7.0.1
 */