package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerUrlTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "md5", "outputPath", "zipFile", "call", "", "onResult", "success", "", "uniqueId", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends g
{
  public static final i.a acCX;
  private final String TAG;
  private final String acCY;
  private final String md5;
  private final String outputPath;
  
  static
  {
    AppMethodBeat.i(105954);
    acCX = new i.a((byte)0);
    AppMethodBeat.o(105954);
  }
  
  public i(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105953);
    this.TAG = "MicroMsg.StickerUrlTask";
    this.md5 = paramStickerLoadInfo.key();
    paramStickerLoadInfo = e.acCJ;
    this.outputPath = s.X(e.iWB(), "preview/");
    paramStickerLoadInfo = e.acCJ;
    this.acCY = s.X(e.iWB(), "preview.zip");
    AppMethodBeat.o(105953);
  }
  
  public final String aUE()
  {
    return this.md5;
  }
  
  /* Error */
  public final void call()
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 104	com/tencent/mm/network/d$b
    //   8: dup
    //   9: aload_0
    //   10: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   13: getfield 110	com/tencent/mm/sticker/loader/StickerLoadInfo:url	Ljava/lang/String;
    //   16: invokespecial 113	com/tencent/mm/network/d$b:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   25: getfield 110	com/tencent/mm/sticker/loader/StickerLoadInfo:url	Ljava/lang/String;
    //   28: aload 4
    //   30: invokestatic 119	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   33: astore 8
    //   35: aload 8
    //   37: ldc 121
    //   39: invokestatic 124	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 8
    //   44: invokevirtual 130	com/tencent/mm/network/y:getResponseCode	()I
    //   47: istore_1
    //   48: aload 8
    //   50: invokevirtual 134	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
    //   53: astore 4
    //   55: aload 8
    //   57: getfield 138	com/tencent/mm/network/y:connection	Ljava/net/HttpURLConnection;
    //   60: invokevirtual 143	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   63: astore 9
    //   65: aload_0
    //   66: getfield 69	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   69: new 145	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 147
    //   75: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: iload_1
    //   79: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: ldc 154
    //   84: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 9
    //   89: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: iload_1
    //   99: sipush 200
    //   102: if_icmpeq +37 -> 139
    //   105: aload 8
    //   107: invokevirtual 171	com/tencent/mm/network/y:disconnect	()V
    //   110: aload_0
    //   111: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   114: iconst_1
    //   115: putfield 175	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   118: aload_0
    //   119: iconst_0
    //   120: invokevirtual 178	com/tencent/mm/sticker/loader/i:onResult	(Z)V
    //   123: aload 4
    //   125: ifnull +8 -> 133
    //   128: aload 4
    //   130: invokevirtual 183	java/io/InputStream:close	()V
    //   133: ldc 102
    //   135: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: aload_0
    //   140: getfield 94	com/tencent/mm/sticker/loader/i:outputPath	Ljava/lang/String;
    //   143: invokestatic 189	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   146: pop
    //   147: aload_0
    //   148: getfield 98	com/tencent/mm/sticker/loader/i:acCY	Ljava/lang/String;
    //   151: iconst_0
    //   152: invokestatic 193	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   155: astore 5
    //   157: aload 5
    //   159: astore 6
    //   161: aload 4
    //   163: astore 7
    //   165: aload 4
    //   167: aload 5
    //   169: invokestatic 199	kotlin/f/a:j	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   172: lstore_2
    //   173: aload 5
    //   175: astore 6
    //   177: aload 4
    //   179: astore 7
    //   181: aload_0
    //   182: getfield 69	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   185: ldc 201
    //   187: lload_2
    //   188: invokestatic 207	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: invokestatic 92	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 5
    //   199: astore 6
    //   201: aload 4
    //   203: astore 7
    //   205: aload 8
    //   207: invokevirtual 171	com/tencent/mm/network/y:disconnect	()V
    //   210: aload 5
    //   212: astore 6
    //   214: aload 4
    //   216: astore 7
    //   218: aload 9
    //   220: ldc 209
    //   222: invokestatic 213	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   225: ifeq +334 -> 559
    //   228: aload 5
    //   230: astore 6
    //   232: aload 4
    //   234: astore 7
    //   236: aload_0
    //   237: getfield 94	com/tencent/mm/sticker/loader/i:outputPath	Ljava/lang/String;
    //   240: iconst_1
    //   241: invokestatic 217	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   244: pop
    //   245: aload 5
    //   247: astore 6
    //   249: aload 4
    //   251: astore 7
    //   253: aload_0
    //   254: getfield 94	com/tencent/mm/sticker/loader/i:outputPath	Ljava/lang/String;
    //   257: invokestatic 189	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   260: pop
    //   261: aload 5
    //   263: astore 6
    //   265: aload 4
    //   267: astore 7
    //   269: aload_0
    //   270: getfield 98	com/tencent/mm/sticker/loader/i:acCY	Ljava/lang/String;
    //   273: aload_0
    //   274: getfield 94	com/tencent/mm/sticker/loader/i:outputPath	Ljava/lang/String;
    //   277: invokestatic 221	com/tencent/mm/vfs/y:aA	(Ljava/lang/String;Ljava/lang/String;)I
    //   280: ifeq +58 -> 338
    //   283: aload 5
    //   285: astore 6
    //   287: aload 4
    //   289: astore 7
    //   291: aload_0
    //   292: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   295: iconst_2
    //   296: putfield 175	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   299: aload 5
    //   301: astore 6
    //   303: aload 4
    //   305: astore 7
    //   307: aload_0
    //   308: iconst_0
    //   309: invokevirtual 178	com/tencent/mm/sticker/loader/i:onResult	(Z)V
    //   312: aload 4
    //   314: ifnull +8 -> 322
    //   317: aload 4
    //   319: invokevirtual 183	java/io/InputStream:close	()V
    //   322: aload 5
    //   324: ifnull +8 -> 332
    //   327: aload 5
    //   329: invokevirtual 224	java/io/OutputStream:close	()V
    //   332: ldc 102
    //   334: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: return
    //   338: aload 5
    //   340: astore 6
    //   342: aload 4
    //   344: astore 7
    //   346: new 226	com/tencent/mm/sticker/f
    //   349: dup
    //   350: invokespecial 228	com/tencent/mm/sticker/f:<init>	()V
    //   353: astore 8
    //   355: aload 5
    //   357: astore 6
    //   359: aload 4
    //   361: astore 7
    //   363: aload 8
    //   365: aload_0
    //   366: getfield 94	com/tencent/mm/sticker/loader/i:outputPath	Ljava/lang/String;
    //   369: invokevirtual 231	com/tencent/mm/sticker/f:buM	(Ljava/lang/String;)V
    //   372: aload 5
    //   374: astore 6
    //   376: aload 4
    //   378: astore 7
    //   380: aload 8
    //   382: aload_0
    //   383: getfield 94	com/tencent/mm/sticker/loader/i:outputPath	Ljava/lang/String;
    //   386: invokevirtual 234	com/tencent/mm/sticker/f:buP	(Ljava/lang/String;)V
    //   389: aload 5
    //   391: astore 6
    //   393: aload 4
    //   395: astore 7
    //   397: aload 8
    //   399: invokevirtual 238	com/tencent/mm/sticker/f:isValid	()Z
    //   402: ifeq +42 -> 444
    //   405: aload 5
    //   407: astore 6
    //   409: aload 4
    //   411: astore 7
    //   413: aload_0
    //   414: iconst_1
    //   415: invokevirtual 178	com/tencent/mm/sticker/loader/i:onResult	(Z)V
    //   418: aload 4
    //   420: ifnull +8 -> 428
    //   423: aload 4
    //   425: invokevirtual 183	java/io/InputStream:close	()V
    //   428: aload 5
    //   430: ifnull +8 -> 438
    //   433: aload 5
    //   435: invokevirtual 224	java/io/OutputStream:close	()V
    //   438: ldc 102
    //   440: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: return
    //   444: aload 5
    //   446: astore 6
    //   448: aload 4
    //   450: astore 7
    //   452: aload_0
    //   453: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   456: iconst_2
    //   457: putfield 175	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   460: aload 5
    //   462: astore 6
    //   464: aload 4
    //   466: astore 7
    //   468: aload_0
    //   469: iconst_0
    //   470: invokevirtual 178	com/tencent/mm/sticker/loader/i:onResult	(Z)V
    //   473: goto -55 -> 418
    //   476: astore 8
    //   478: aload 5
    //   480: astore 6
    //   482: aload 4
    //   484: astore 7
    //   486: aload_0
    //   487: getfield 69	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   490: aload 8
    //   492: checkcast 240	java/lang/Throwable
    //   495: ldc 241
    //   497: iconst_0
    //   498: anewarray 243	java/lang/Object
    //   501: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: aload 5
    //   506: astore 6
    //   508: aload 4
    //   510: astore 7
    //   512: aload_0
    //   513: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   516: iconst_1
    //   517: putfield 175	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   520: aload 5
    //   522: astore 6
    //   524: aload 4
    //   526: astore 7
    //   528: aload_0
    //   529: iconst_0
    //   530: invokevirtual 178	com/tencent/mm/sticker/loader/i:onResult	(Z)V
    //   533: aload 4
    //   535: ifnull +8 -> 543
    //   538: aload 4
    //   540: invokevirtual 183	java/io/InputStream:close	()V
    //   543: aload 5
    //   545: ifnull +8 -> 553
    //   548: aload 5
    //   550: invokevirtual 224	java/io/OutputStream:close	()V
    //   553: ldc 102
    //   555: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: return
    //   559: aload 5
    //   561: astore 6
    //   563: aload 4
    //   565: astore 7
    //   567: aload_0
    //   568: getfield 98	com/tencent/mm/sticker/loader/i:acCY	Ljava/lang/String;
    //   571: invokestatic 251	com/tencent/mm/vfs/y:bEn	(Ljava/lang/String;)Ljava/lang/String;
    //   574: astore 8
    //   576: aload 5
    //   578: astore 6
    //   580: aload 4
    //   582: astore 7
    //   584: aload_0
    //   585: getfield 69	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   588: ldc 253
    //   590: aload 8
    //   592: invokestatic 92	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   595: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload 5
    //   600: astore 6
    //   602: aload 4
    //   604: astore 7
    //   606: new 255	org/json/JSONObject
    //   609: dup
    //   610: aload 8
    //   612: invokespecial 256	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   615: ldc_w 258
    //   618: invokevirtual 262	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   621: ldc_w 264
    //   624: invokevirtual 268	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   627: tableswitch	default:+163 -> 790, 1206:+87->714, 1207:+106->733
    //   649: iconst_2
    //   650: astore 6
    //   652: aload 4
    //   654: astore 7
    //   656: aload_0
    //   657: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   660: iconst_2
    //   661: putfield 175	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   664: aload 5
    //   666: astore 6
    //   668: aload 4
    //   670: astore 7
    //   672: aload_0
    //   673: iconst_0
    //   674: invokevirtual 178	com/tencent/mm/sticker/loader/i:onResult	(Z)V
    //   677: goto -259 -> 418
    //   680: astore 5
    //   682: aload 7
    //   684: astore 4
    //   686: aload 4
    //   688: ifnull +8 -> 696
    //   691: aload 4
    //   693: invokevirtual 183	java/io/InputStream:close	()V
    //   696: aload 6
    //   698: ifnull +8 -> 706
    //   701: aload 6
    //   703: invokevirtual 224	java/io/OutputStream:close	()V
    //   706: ldc 102
    //   708: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   711: aload 5
    //   713: athrow
    //   714: aload 5
    //   716: astore 6
    //   718: aload 4
    //   720: astore 7
    //   722: aload_0
    //   723: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   726: iconst_4
    //   727: putfield 175	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   730: goto -66 -> 664
    //   733: aload 5
    //   735: astore 6
    //   737: aload 4
    //   739: astore 7
    //   741: aload_0
    //   742: getfield 107	com/tencent/mm/sticker/loader/g:acCU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   745: iconst_5
    //   746: putfield 175	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   749: goto -85 -> 664
    //   752: astore 5
    //   754: aconst_null
    //   755: astore 6
    //   757: aconst_null
    //   758: astore 4
    //   760: goto -74 -> 686
    //   763: astore 5
    //   765: aconst_null
    //   766: astore 6
    //   768: goto -82 -> 686
    //   771: astore 8
    //   773: aconst_null
    //   774: astore 5
    //   776: aconst_null
    //   777: astore 4
    //   779: goto -301 -> 478
    //   782: astore 8
    //   784: aconst_null
    //   785: astore 5
    //   787: goto -309 -> 478
    //   790: goto -142 -> 648
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	793	0	this	i
    //   47	56	1	i	int
    //   172	16	2	l	long
    //   19	759	4	localObject1	java.lang.Object
    //   155	510	5	localOutputStream	java.io.OutputStream
    //   680	54	5	localObject2	java.lang.Object
    //   752	1	5	localObject3	java.lang.Object
    //   763	1	5	localObject4	java.lang.Object
    //   774	12	5	localObject5	java.lang.Object
    //   159	608	6	localObject6	java.lang.Object
    //   163	577	7	localObject7	java.lang.Object
    //   33	365	8	localObject8	java.lang.Object
    //   476	15	8	localException1	java.lang.Exception
    //   574	37	8	str1	String
    //   771	1	8	localException2	java.lang.Exception
    //   782	1	8	localException3	java.lang.Exception
    //   63	156	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   165	173	476	java/lang/Exception
    //   181	197	476	java/lang/Exception
    //   205	210	476	java/lang/Exception
    //   218	228	476	java/lang/Exception
    //   236	245	476	java/lang/Exception
    //   253	261	476	java/lang/Exception
    //   269	283	476	java/lang/Exception
    //   291	299	476	java/lang/Exception
    //   307	312	476	java/lang/Exception
    //   346	355	476	java/lang/Exception
    //   363	372	476	java/lang/Exception
    //   380	389	476	java/lang/Exception
    //   397	405	476	java/lang/Exception
    //   413	418	476	java/lang/Exception
    //   452	460	476	java/lang/Exception
    //   468	473	476	java/lang/Exception
    //   567	576	476	java/lang/Exception
    //   584	598	476	java/lang/Exception
    //   606	648	476	java/lang/Exception
    //   656	664	476	java/lang/Exception
    //   672	677	476	java/lang/Exception
    //   722	730	476	java/lang/Exception
    //   741	749	476	java/lang/Exception
    //   165	173	680	finally
    //   181	197	680	finally
    //   205	210	680	finally
    //   218	228	680	finally
    //   236	245	680	finally
    //   253	261	680	finally
    //   269	283	680	finally
    //   291	299	680	finally
    //   307	312	680	finally
    //   346	355	680	finally
    //   363	372	680	finally
    //   380	389	680	finally
    //   397	405	680	finally
    //   413	418	680	finally
    //   452	460	680	finally
    //   468	473	680	finally
    //   486	504	680	finally
    //   512	520	680	finally
    //   528	533	680	finally
    //   567	576	680	finally
    //   584	598	680	finally
    //   606	648	680	finally
    //   656	664	680	finally
    //   672	677	680	finally
    //   722	730	680	finally
    //   741	749	680	finally
    //   21	55	752	finally
    //   55	98	763	finally
    //   105	123	763	finally
    //   139	157	763	finally
    //   21	55	771	java/lang/Exception
    //   55	98	782	java/lang/Exception
    //   105	123	782	java/lang/Exception
    //   139	157	782	java/lang/Exception
  }
  
  public final void onResult(boolean paramBoolean)
  {
    AppMethodBeat.i(105952);
    Log.i(this.TAG, "onResult: " + paramBoolean + ", " + this.acCU.errType);
    super.onResult(paramBoolean);
    AppMethodBeat.o(105952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.i
 * JD-Core Version:    0.7.0.1
 */