package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.d.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/loader/LensIconDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "()V", "TAG", "", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-sticker_release"})
public final class c
  extends b<a>
{
  private final String TAG = "MicroMsg.LensIconDownloader";
  
  /* Error */
  public final void a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.f.f paramf, com.tencent.mm.loader.d.b.b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 40
    //   8: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: ldc 47
    //   14: invokestatic 53	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 54
    //   20: invokestatic 53	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_3
    //   24: ldc 55
    //   26: invokestatic 53	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload_1
    //   30: invokevirtual 61	com/tencent/mm/loader/h/a/a:value	()Ljava/lang/Object;
    //   33: checkcast 63	com/tencent/mm/sticker/loader/a
    //   36: getfield 67	com/tencent/mm/sticker/loader/a:GzM	Lcom/tencent/mm/protocal/protobuf/bpl;
    //   39: getfield 73	com/tencent/mm/protocal/protobuf/bpl:FeL	Lcom/tencent/mm/protocal/protobuf/bpk;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +52 -> 96
    //   47: aload_2
    //   48: getfield 78	com/tencent/mm/protocal/protobuf/bpk:Url	Ljava/lang/String;
    //   51: astore 5
    //   53: aload_1
    //   54: invokevirtual 61	com/tencent/mm/loader/h/a/a:value	()Ljava/lang/Object;
    //   57: checkcast 63	com/tencent/mm/sticker/loader/a
    //   60: getfield 67	com/tencent/mm/sticker/loader/a:GzM	Lcom/tencent/mm/protocal/protobuf/bpl;
    //   63: getfield 73	com/tencent/mm/protocal/protobuf/bpl:FeL	Lcom/tencent/mm/protocal/protobuf/bpk;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +34 -> 102
    //   71: aload_1
    //   72: getfield 81	com/tencent/mm/protocal/protobuf/bpk:AesKey	Ljava/lang/String;
    //   75: astore_2
    //   76: aload 5
    //   78: invokestatic 87	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   81: ifeq +26 -> 107
    //   84: aload_3
    //   85: invokeinterface 92 1 0
    //   90: ldc 40
    //   92: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: aconst_null
    //   97: astore 5
    //   99: goto -46 -> 53
    //   102: aconst_null
    //   103: astore_2
    //   104: goto -28 -> 76
    //   107: new 97	com/tencent/mm/network/b$b
    //   110: dup
    //   111: aload 5
    //   113: invokespecial 100	com/tencent/mm/network/b$b:<init>	(Ljava/lang/String;)V
    //   116: astore_1
    //   117: aload 5
    //   119: aload_1
    //   120: invokestatic 105	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   123: astore 8
    //   125: aload 8
    //   127: ldc 107
    //   129: invokestatic 110	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   132: aload 8
    //   134: invokevirtual 116	com/tencent/mm/network/v:getResponseCode	()I
    //   137: istore 4
    //   139: aload 8
    //   141: invokevirtual 120	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   144: astore_1
    //   145: aload 8
    //   147: invokevirtual 124	com/tencent/mm/network/v:getContentType	()Ljava/lang/String;
    //   150: astore 7
    //   152: aload_0
    //   153: getfield 34	com/tencent/mm/sticker/loader/c:TAG	Ljava/lang/String;
    //   156: new 126	java/lang/StringBuilder
    //   159: dup
    //   160: ldc 128
    //   162: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: iload 4
    //   167: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc 135
    //   172: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 7
    //   177: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: iload 4
    //   188: sipush 200
    //   191: if_icmpeq +34 -> 225
    //   194: aload 8
    //   196: invokevirtual 149	com/tencent/mm/network/v:disconnect	()V
    //   199: aload_3
    //   200: invokeinterface 92 1 0
    //   205: aload_1
    //   206: ifnull +13 -> 219
    //   209: aload_1
    //   210: invokevirtual 154	java/io/InputStream:close	()V
    //   213: ldc 40
    //   215: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: return
    //   219: ldc 40
    //   221: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: return
    //   225: aload 6
    //   227: astore 5
    //   229: aload_1
    //   230: ifnull +9 -> 239
    //   233: aload_1
    //   234: invokestatic 160	d/f/a:U	(Ljava/io/InputStream;)[B
    //   237: astore 5
    //   239: aload 8
    //   241: invokevirtual 149	com/tencent/mm/network/v:disconnect	()V
    //   244: aload 5
    //   246: ifnonnull +29 -> 275
    //   249: aload_3
    //   250: invokeinterface 92 1 0
    //   255: aload_1
    //   256: ifnull +13 -> 269
    //   259: aload_1
    //   260: invokevirtual 154	java/io/InputStream:close	()V
    //   263: ldc 40
    //   265: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: return
    //   269: ldc 40
    //   271: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: return
    //   275: aload 5
    //   277: aload_2
    //   278: invokestatic 164	com/tencent/mm/sdk/platformtools/bs:aLu	(Ljava/lang/String;)[B
    //   281: iconst_0
    //   282: invokestatic 170	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   285: invokestatic 176	com/tencent/mm/b/a:c	([BLjava/lang/String;)[B
    //   288: aload 7
    //   290: invokestatic 182	com/tencent/mm/loader/h/b:d	([BLjava/lang/String;)Lcom/tencent/mm/loader/h/b;
    //   293: astore_2
    //   294: aload_2
    //   295: ldc 184
    //   297: invokestatic 110	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   300: aload_3
    //   301: aload_2
    //   302: checkcast 186	com/tencent/mm/loader/h/f
    //   305: invokeinterface 189 2 0
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 154	java/io/InputStream:close	()V
    //   318: aload_3
    //   319: invokeinterface 92 1 0
    //   324: ldc 40
    //   326: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: astore_2
    //   331: aload 7
    //   333: astore_1
    //   334: aload_0
    //   335: getfield 34	com/tencent/mm/sticker/loader/c:TAG	Ljava/lang/String;
    //   338: aload_2
    //   339: checkcast 191	java/lang/Throwable
    //   342: ldc 192
    //   344: iconst_0
    //   345: anewarray 194	java/lang/Object
    //   348: invokestatic 198	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload_1
    //   352: ifnull -34 -> 318
    //   355: aload_1
    //   356: invokevirtual 154	java/io/InputStream:close	()V
    //   359: goto -41 -> 318
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_1
    //   365: aload_1
    //   366: ifnull +7 -> 373
    //   369: aload_1
    //   370: invokevirtual 154	java/io/InputStream:close	()V
    //   373: ldc 40
    //   375: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload_2
    //   379: athrow
    //   380: astore_2
    //   381: goto -16 -> 365
    //   384: astore_2
    //   385: goto -20 -> 365
    //   388: astore_2
    //   389: goto -55 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	c
    //   0	392	1	parama	com.tencent.mm.loader.h.a.a<a>
    //   0	392	2	paramf	com.tencent.mm.loader.f.f
    //   0	392	3	paramb	com.tencent.mm.loader.d.b.b
    //   137	55	4	i	int
    //   51	225	5	localObject1	java.lang.Object
    //   4	222	6	localObject2	java.lang.Object
    //   1	331	7	str	String
    //   123	117	8	localv	com.tencent.mm.network.v
    // Exception table:
    //   from	to	target	type
    //   117	145	330	java/lang/Exception
    //   117	145	362	finally
    //   145	186	380	finally
    //   194	205	380	finally
    //   233	239	380	finally
    //   239	244	380	finally
    //   249	255	380	finally
    //   275	310	380	finally
    //   334	351	384	finally
    //   145	186	388	java/lang/Exception
    //   194	205	388	java/lang/Exception
    //   233	239	388	java/lang/Exception
    //   239	244	388	java/lang/Exception
    //   249	255	388	java/lang/Exception
    //   275	310	388	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.c
 * JD-Core Version:    0.7.0.1
 */