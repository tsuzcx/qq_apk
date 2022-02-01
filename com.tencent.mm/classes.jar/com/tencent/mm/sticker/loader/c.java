package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.c.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/LensIconDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "()V", "TAG", "", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b<a>
{
  private final String TAG = "MicroMsg.LensIconDownloader";
  
  /* Error */
  public final void a(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.e.g paramg, com.tencent.mm.loader.c.b.b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 43
    //   8: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: ldc 50
    //   14: invokestatic 56	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 57
    //   20: invokestatic 56	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_3
    //   24: ldc 58
    //   26: invokestatic 56	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload_1
    //   30: invokevirtual 64	com/tencent/mm/loader/g/a/a:bmg	()Ljava/lang/Object;
    //   33: checkcast 66	com/tencent/mm/sticker/loader/a
    //   36: getfield 70	com/tencent/mm/sticker/loader/a:acBO	Lcom/tencent/mm/protocal/protobuf/dhp;
    //   39: getfield 76	com/tencent/mm/protocal/protobuf/dhp:aaMT	Lcom/tencent/mm/protocal/protobuf/dho;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnonnull +46 -> 90
    //   47: aconst_null
    //   48: astore 5
    //   50: aload_1
    //   51: invokevirtual 64	com/tencent/mm/loader/g/a/a:bmg	()Ljava/lang/Object;
    //   54: checkcast 66	com/tencent/mm/sticker/loader/a
    //   57: getfield 70	com/tencent/mm/sticker/loader/a:acBO	Lcom/tencent/mm/protocal/protobuf/dhp;
    //   60: getfield 76	com/tencent/mm/protocal/protobuf/dhp:aaMT	Lcom/tencent/mm/protocal/protobuf/dho;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnonnull +34 -> 99
    //   68: aconst_null
    //   69: astore_2
    //   70: aload 5
    //   72: invokestatic 82	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   75: ifeq +32 -> 107
    //   78: aload_3
    //   79: invokeinterface 87 1 0
    //   84: ldc 43
    //   86: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: return
    //   90: aload_2
    //   91: getfield 95	com/tencent/mm/protocal/protobuf/dho:Url	Ljava/lang/String;
    //   94: astore 5
    //   96: goto -46 -> 50
    //   99: aload_1
    //   100: getfield 98	com/tencent/mm/protocal/protobuf/dho:AesKey	Ljava/lang/String;
    //   103: astore_2
    //   104: goto -34 -> 70
    //   107: new 100	com/tencent/mm/network/d$b
    //   110: dup
    //   111: aload 5
    //   113: invokespecial 103	com/tencent/mm/network/d$b:<init>	(Ljava/lang/String;)V
    //   116: astore_1
    //   117: aload 5
    //   119: aload_1
    //   120: invokestatic 108	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   123: astore 8
    //   125: aload 8
    //   127: ldc 110
    //   129: invokestatic 113	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   132: aload 8
    //   134: invokevirtual 119	com/tencent/mm/network/y:getResponseCode	()I
    //   137: istore 4
    //   139: aload 8
    //   141: invokevirtual 123	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
    //   144: astore_1
    //   145: aload 8
    //   147: getfield 127	com/tencent/mm/network/y:connection	Ljava/net/HttpURLConnection;
    //   150: invokevirtual 133	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   153: astore 7
    //   155: aload_0
    //   156: getfield 37	com/tencent/mm/sticker/loader/c:TAG	Ljava/lang/String;
    //   159: new 135	java/lang/StringBuilder
    //   162: dup
    //   163: ldc 137
    //   165: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: iload 4
    //   170: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 144
    //   175: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 7
    //   180: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: iload 4
    //   191: sipush 200
    //   194: if_icmpeq +28 -> 222
    //   197: aload 8
    //   199: invokevirtual 161	com/tencent/mm/network/y:disconnect	()V
    //   202: aload_3
    //   203: invokeinterface 87 1 0
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 166	java/io/InputStream:close	()V
    //   216: ldc 43
    //   218: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: aload_1
    //   223: ifnonnull +37 -> 260
    //   226: aload 6
    //   228: astore 5
    //   230: aload 8
    //   232: invokevirtual 161	com/tencent/mm/network/y:disconnect	()V
    //   235: aload 5
    //   237: ifnonnull +32 -> 269
    //   240: aload_3
    //   241: invokeinterface 87 1 0
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 166	java/io/InputStream:close	()V
    //   254: ldc 43
    //   256: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: return
    //   260: aload_1
    //   261: invokestatic 172	kotlin/f/a:ag	(Ljava/io/InputStream;)[B
    //   264: astore 5
    //   266: goto -36 -> 230
    //   269: aload 5
    //   271: aload_2
    //   272: invokestatic 176	com/tencent/mm/sdk/platformtools/Util:decodeHexString	(Ljava/lang/String;)[B
    //   275: iconst_0
    //   276: invokestatic 182	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   279: invokestatic 188	com/tencent/mm/b/a:c	([BLjava/lang/String;)[B
    //   282: aload 7
    //   284: invokestatic 194	com/tencent/mm/loader/g/b:d	([BLjava/lang/String;)Lcom/tencent/mm/loader/g/b;
    //   287: astore_2
    //   288: aload_2
    //   289: ldc 196
    //   291: invokestatic 113	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   294: aload_3
    //   295: aload_2
    //   296: checkcast 198	com/tencent/mm/loader/g/f
    //   299: invokeinterface 201 2 0
    //   304: aload_1
    //   305: ifnull +7 -> 312
    //   308: aload_1
    //   309: invokevirtual 166	java/io/InputStream:close	()V
    //   312: aload_3
    //   313: invokeinterface 87 1 0
    //   318: ldc 43
    //   320: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: return
    //   324: astore_2
    //   325: aload 7
    //   327: astore_1
    //   328: aload_0
    //   329: getfield 37	com/tencent/mm/sticker/loader/c:TAG	Ljava/lang/String;
    //   332: aload_2
    //   333: checkcast 203	java/lang/Throwable
    //   336: ldc 204
    //   338: iconst_0
    //   339: anewarray 206	java/lang/Object
    //   342: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: aload_1
    //   346: ifnull -34 -> 312
    //   349: aload_1
    //   350: invokevirtual 166	java/io/InputStream:close	()V
    //   353: goto -41 -> 312
    //   356: astore_2
    //   357: aconst_null
    //   358: astore_1
    //   359: aload_1
    //   360: ifnull +7 -> 367
    //   363: aload_1
    //   364: invokevirtual 166	java/io/InputStream:close	()V
    //   367: ldc 43
    //   369: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_2
    //   373: athrow
    //   374: astore_2
    //   375: goto -16 -> 359
    //   378: astore_2
    //   379: goto -20 -> 359
    //   382: astore_2
    //   383: goto -55 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	c
    //   0	386	1	parama	com.tencent.mm.loader.g.a.a<a>
    //   0	386	2	paramg	com.tencent.mm.loader.e.g
    //   0	386	3	paramb	com.tencent.mm.loader.c.b.b
    //   137	58	4	i	int
    //   48	222	5	localObject1	java.lang.Object
    //   4	223	6	localObject2	java.lang.Object
    //   1	325	7	str	String
    //   123	108	8	localy	com.tencent.mm.network.y
    // Exception table:
    //   from	to	target	type
    //   117	145	324	java/lang/Exception
    //   117	145	356	finally
    //   145	189	374	finally
    //   197	208	374	finally
    //   230	235	374	finally
    //   240	246	374	finally
    //   260	266	374	finally
    //   269	304	374	finally
    //   328	345	378	finally
    //   145	189	382	java/lang/Exception
    //   197	208	382	java/lang/Exception
    //   230	235	382	java/lang/Exception
    //   240	246	382	java/lang/Exception
    //   260	266	382	java/lang/Exception
    //   269	304	382	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.c
 * JD-Core Version:    0.7.0.1
 */