package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/loader/StickerUrlTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "md5", "outputPath", "zipFile", "call", "", "onResult", "success", "", "uniqueId", "Companion", "plugin-sticker_release"})
public final class i
  extends g
{
  public static final i.a NNX;
  private final String NNW;
  private final String TAG;
  private final String md5;
  private final String rpE;
  
  static
  {
    AppMethodBeat.i(105954);
    NNX = new i.a((byte)0);
    AppMethodBeat.o(105954);
  }
  
  public i(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105953);
    this.TAG = "MicroMsg.StickerUrlTask";
    this.md5 = paramStickerLoadInfo.Lb();
    paramStickerLoadInfo = new StringBuilder();
    e locale = e.NNN;
    this.rpE = (e.gyY() + "preview/");
    paramStickerLoadInfo = new StringBuilder();
    locale = e.NNN;
    this.NNW = (e.gyY() + "preview.zip");
    AppMethodBeat.o(105953);
  }
  
  public final String auK()
  {
    return this.md5;
  }
  
  /* Error */
  public final void call()
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 109	com/tencent/mm/network/d$b
    //   8: dup
    //   9: aload_0
    //   10: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   13: getfield 115	com/tencent/mm/sticker/loader/StickerLoadInfo:url	Ljava/lang/String;
    //   16: invokespecial 118	com/tencent/mm/network/d$b:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   25: getfield 115	com/tencent/mm/sticker/loader/StickerLoadInfo:url	Ljava/lang/String;
    //   28: aload 4
    //   30: invokestatic 124	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
    //   33: astore 8
    //   35: aload 8
    //   37: ldc 126
    //   39: invokestatic 129	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 8
    //   44: invokevirtual 135	com/tencent/mm/network/x:getResponseCode	()I
    //   47: istore_1
    //   48: aload 8
    //   50: invokevirtual 139	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
    //   53: astore 4
    //   55: aload 8
    //   57: invokevirtual 142	com/tencent/mm/network/x:getContentType	()Ljava/lang/String;
    //   60: astore 9
    //   62: aload_0
    //   63: getfield 67	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   66: new 77	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 144
    //   72: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: iload_1
    //   76: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: ldc 150
    //   81: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 9
    //   86: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: iload_1
    //   96: sipush 200
    //   99: if_icmpeq +43 -> 142
    //   102: aload 8
    //   104: invokevirtual 158	com/tencent/mm/network/x:disconnect	()V
    //   107: aload_0
    //   108: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   111: iconst_1
    //   112: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   115: aload_0
    //   116: iconst_0
    //   117: invokevirtual 166	com/tencent/mm/sticker/loader/i:dQ	(Z)V
    //   120: aload 4
    //   122: ifnull +14 -> 136
    //   125: aload 4
    //   127: invokevirtual 171	java/io/InputStream:close	()V
    //   130: ldc 107
    //   132: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: ldc 107
    //   138: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: return
    //   142: aload_0
    //   143: getfield 99	com/tencent/mm/sticker/loader/i:rpE	Ljava/lang/String;
    //   146: invokestatic 177	com/tencent/mm/vfs/s:boN	(Ljava/lang/String;)Z
    //   149: pop
    //   150: aload_0
    //   151: getfield 103	com/tencent/mm/sticker/loader/i:NNW	Ljava/lang/String;
    //   154: invokestatic 181	com/tencent/mm/vfs/s:LM	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   157: astore 5
    //   159: aload 5
    //   161: astore 6
    //   163: aload 4
    //   165: astore 7
    //   167: aload 4
    //   169: ldc 183
    //   171: invokestatic 129	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   174: aload 5
    //   176: astore 6
    //   178: aload 4
    //   180: astore 7
    //   182: aload 4
    //   184: aload 5
    //   186: invokestatic 189	kotlin/f/a:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   189: lstore_2
    //   190: aload 5
    //   192: astore 6
    //   194: aload 4
    //   196: astore 7
    //   198: aload_0
    //   199: getfield 67	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   202: ldc 191
    //   204: lload_2
    //   205: invokestatic 197	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   208: invokevirtual 201	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   211: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload 5
    //   216: astore 6
    //   218: aload 4
    //   220: astore 7
    //   222: aload 8
    //   224: invokevirtual 158	com/tencent/mm/network/x:disconnect	()V
    //   227: aload 5
    //   229: astore 6
    //   231: aload 4
    //   233: astore 7
    //   235: aload 9
    //   237: ldc 203
    //   239: invokestatic 207	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   242: ifeq +329 -> 571
    //   245: aload 5
    //   247: astore 6
    //   249: aload 4
    //   251: astore 7
    //   253: aload_0
    //   254: getfield 99	com/tencent/mm/sticker/loader/i:rpE	Ljava/lang/String;
    //   257: invokestatic 210	com/tencent/mm/vfs/s:deleteDir	(Ljava/lang/String;)Z
    //   260: pop
    //   261: aload 5
    //   263: astore 6
    //   265: aload 4
    //   267: astore 7
    //   269: aload_0
    //   270: getfield 99	com/tencent/mm/sticker/loader/i:rpE	Ljava/lang/String;
    //   273: invokestatic 177	com/tencent/mm/vfs/s:boN	(Ljava/lang/String;)Z
    //   276: pop
    //   277: aload 5
    //   279: astore 6
    //   281: aload 4
    //   283: astore 7
    //   285: aload_0
    //   286: getfield 103	com/tencent/mm/sticker/loader/i:NNW	Ljava/lang/String;
    //   289: aload_0
    //   290: getfield 99	com/tencent/mm/sticker/loader/i:rpE	Ljava/lang/String;
    //   293: invokestatic 214	com/tencent/mm/vfs/s:fW	(Ljava/lang/String;Ljava/lang/String;)I
    //   296: ifeq +59 -> 355
    //   299: aload 5
    //   301: astore 6
    //   303: aload 4
    //   305: astore 7
    //   307: aload_0
    //   308: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   311: iconst_2
    //   312: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   315: aload 5
    //   317: astore 6
    //   319: aload 4
    //   321: astore 7
    //   323: aload_0
    //   324: iconst_0
    //   325: invokevirtual 166	com/tencent/mm/sticker/loader/i:dQ	(Z)V
    //   328: aload 4
    //   330: invokevirtual 171	java/io/InputStream:close	()V
    //   333: aload 5
    //   335: ifnull +14 -> 349
    //   338: aload 5
    //   340: invokevirtual 217	java/io/OutputStream:close	()V
    //   343: ldc 107
    //   345: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: return
    //   349: ldc 107
    //   351: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: return
    //   355: aload 5
    //   357: astore 6
    //   359: aload 4
    //   361: astore 7
    //   363: new 219	com/tencent/mm/sticker/f
    //   366: dup
    //   367: invokespecial 220	com/tencent/mm/sticker/f:<init>	()V
    //   370: astore 8
    //   372: aload 5
    //   374: astore 6
    //   376: aload 4
    //   378: astore 7
    //   380: aload 8
    //   382: aload_0
    //   383: getfield 99	com/tencent/mm/sticker/loader/i:rpE	Ljava/lang/String;
    //   386: invokevirtual 223	com/tencent/mm/sticker/f:bip	(Ljava/lang/String;)V
    //   389: aload 5
    //   391: astore 6
    //   393: aload 4
    //   395: astore 7
    //   397: aload 8
    //   399: aload_0
    //   400: getfield 99	com/tencent/mm/sticker/loader/i:rpE	Ljava/lang/String;
    //   403: invokevirtual 226	com/tencent/mm/sticker/f:bis	(Ljava/lang/String;)V
    //   406: aload 5
    //   408: astore 6
    //   410: aload 4
    //   412: astore 7
    //   414: aload 8
    //   416: invokevirtual 230	com/tencent/mm/sticker/f:isValid	()Z
    //   419: ifeq +37 -> 456
    //   422: aload 5
    //   424: astore 6
    //   426: aload 4
    //   428: astore 7
    //   430: aload_0
    //   431: iconst_1
    //   432: invokevirtual 166	com/tencent/mm/sticker/loader/i:dQ	(Z)V
    //   435: aload 4
    //   437: invokevirtual 171	java/io/InputStream:close	()V
    //   440: aload 5
    //   442: ifnull +326 -> 768
    //   445: aload 5
    //   447: invokevirtual 217	java/io/OutputStream:close	()V
    //   450: ldc 107
    //   452: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   455: return
    //   456: aload 5
    //   458: astore 6
    //   460: aload 4
    //   462: astore 7
    //   464: aload_0
    //   465: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   468: iconst_2
    //   469: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   472: aload 5
    //   474: astore 6
    //   476: aload 4
    //   478: astore 7
    //   480: aload_0
    //   481: iconst_0
    //   482: invokevirtual 166	com/tencent/mm/sticker/loader/i:dQ	(Z)V
    //   485: goto -50 -> 435
    //   488: astore 8
    //   490: aload 5
    //   492: astore 6
    //   494: aload 4
    //   496: astore 7
    //   498: aload_0
    //   499: getfield 67	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   502: aload 8
    //   504: checkcast 232	java/lang/Throwable
    //   507: ldc 233
    //   509: iconst_0
    //   510: anewarray 235	java/lang/Object
    //   513: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   516: aload 5
    //   518: astore 6
    //   520: aload 4
    //   522: astore 7
    //   524: aload_0
    //   525: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   528: iconst_1
    //   529: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   532: aload 5
    //   534: astore 6
    //   536: aload 4
    //   538: astore 7
    //   540: aload_0
    //   541: iconst_0
    //   542: invokevirtual 166	com/tencent/mm/sticker/loader/i:dQ	(Z)V
    //   545: aload 4
    //   547: ifnull +8 -> 555
    //   550: aload 4
    //   552: invokevirtual 171	java/io/InputStream:close	()V
    //   555: aload 5
    //   557: ifnull +217 -> 774
    //   560: aload 5
    //   562: invokevirtual 217	java/io/OutputStream:close	()V
    //   565: ldc 107
    //   567: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   570: return
    //   571: aload 5
    //   573: astore 6
    //   575: aload 4
    //   577: astore 7
    //   579: aload_0
    //   580: getfield 103	com/tencent/mm/sticker/loader/i:NNW	Ljava/lang/String;
    //   583: invokestatic 242	com/tencent/mm/vfs/s:boY	(Ljava/lang/String;)Ljava/lang/String;
    //   586: astore 8
    //   588: aload 5
    //   590: astore 6
    //   592: aload 4
    //   594: astore 7
    //   596: aload_0
    //   597: getfield 67	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   600: ldc 244
    //   602: aload 8
    //   604: invokestatic 247	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   607: invokevirtual 201	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   610: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: aload 5
    //   615: astore 6
    //   617: aload 4
    //   619: astore 7
    //   621: new 249	org/json/JSONObject
    //   624: dup
    //   625: aload 8
    //   627: invokespecial 250	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   630: ldc 252
    //   632: invokevirtual 256	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   635: ldc_w 258
    //   638: invokevirtual 262	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   641: tableswitch	default:+177 -> 818, 1206:+89->730, 1207:+108->749
    //   665: iconst_2
    //   666: astore 6
    //   668: aload 4
    //   670: astore 7
    //   672: aload_0
    //   673: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   676: iconst_2
    //   677: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   680: aload 5
    //   682: astore 6
    //   684: aload 4
    //   686: astore 7
    //   688: aload_0
    //   689: iconst_0
    //   690: invokevirtual 166	com/tencent/mm/sticker/loader/i:dQ	(Z)V
    //   693: goto -258 -> 435
    //   696: astore 5
    //   698: aload 7
    //   700: astore 4
    //   702: aload 4
    //   704: ifnull +8 -> 712
    //   707: aload 4
    //   709: invokevirtual 171	java/io/InputStream:close	()V
    //   712: aload 6
    //   714: ifnull +8 -> 722
    //   717: aload 6
    //   719: invokevirtual 217	java/io/OutputStream:close	()V
    //   722: ldc 107
    //   724: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   727: aload 5
    //   729: athrow
    //   730: aload 5
    //   732: astore 6
    //   734: aload 4
    //   736: astore 7
    //   738: aload_0
    //   739: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   742: iconst_4
    //   743: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   746: goto -66 -> 680
    //   749: aload 5
    //   751: astore 6
    //   753: aload 4
    //   755: astore 7
    //   757: aload_0
    //   758: getfield 112	com/tencent/mm/sticker/loader/g:NNU	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   761: iconst_5
    //   762: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   765: goto -85 -> 680
    //   768: ldc 107
    //   770: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   773: return
    //   774: ldc 107
    //   776: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   779: return
    //   780: astore 5
    //   782: aconst_null
    //   783: astore 6
    //   785: aconst_null
    //   786: astore 4
    //   788: goto -86 -> 702
    //   791: astore 5
    //   793: aconst_null
    //   794: astore 6
    //   796: goto -94 -> 702
    //   799: astore 8
    //   801: aconst_null
    //   802: astore 5
    //   804: aconst_null
    //   805: astore 4
    //   807: goto -317 -> 490
    //   810: astore 8
    //   812: aconst_null
    //   813: astore 5
    //   815: goto -325 -> 490
    //   818: goto -154 -> 664
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	this	i
    //   47	53	1	i	int
    //   189	16	2	l	long
    //   19	787	4	localObject1	java.lang.Object
    //   157	524	5	localOutputStream	java.io.OutputStream
    //   696	54	5	localObject2	java.lang.Object
    //   780	1	5	localObject3	java.lang.Object
    //   791	1	5	localObject4	java.lang.Object
    //   802	12	5	localObject5	java.lang.Object
    //   161	634	6	localObject6	java.lang.Object
    //   165	591	7	localObject7	java.lang.Object
    //   33	382	8	localObject8	java.lang.Object
    //   488	15	8	localException1	java.lang.Exception
    //   586	40	8	str1	String
    //   799	1	8	localException2	java.lang.Exception
    //   810	1	8	localException3	java.lang.Exception
    //   60	176	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   167	174	488	java/lang/Exception
    //   182	190	488	java/lang/Exception
    //   198	214	488	java/lang/Exception
    //   222	227	488	java/lang/Exception
    //   235	245	488	java/lang/Exception
    //   253	261	488	java/lang/Exception
    //   269	277	488	java/lang/Exception
    //   285	299	488	java/lang/Exception
    //   307	315	488	java/lang/Exception
    //   323	328	488	java/lang/Exception
    //   363	372	488	java/lang/Exception
    //   380	389	488	java/lang/Exception
    //   397	406	488	java/lang/Exception
    //   414	422	488	java/lang/Exception
    //   430	435	488	java/lang/Exception
    //   464	472	488	java/lang/Exception
    //   480	485	488	java/lang/Exception
    //   579	588	488	java/lang/Exception
    //   596	613	488	java/lang/Exception
    //   621	664	488	java/lang/Exception
    //   672	680	488	java/lang/Exception
    //   688	693	488	java/lang/Exception
    //   738	746	488	java/lang/Exception
    //   757	765	488	java/lang/Exception
    //   167	174	696	finally
    //   182	190	696	finally
    //   198	214	696	finally
    //   222	227	696	finally
    //   235	245	696	finally
    //   253	261	696	finally
    //   269	277	696	finally
    //   285	299	696	finally
    //   307	315	696	finally
    //   323	328	696	finally
    //   363	372	696	finally
    //   380	389	696	finally
    //   397	406	696	finally
    //   414	422	696	finally
    //   430	435	696	finally
    //   464	472	696	finally
    //   480	485	696	finally
    //   498	516	696	finally
    //   524	532	696	finally
    //   540	545	696	finally
    //   579	588	696	finally
    //   596	613	696	finally
    //   621	664	696	finally
    //   672	680	696	finally
    //   688	693	696	finally
    //   738	746	696	finally
    //   757	765	696	finally
    //   21	55	780	finally
    //   55	95	791	finally
    //   102	120	791	finally
    //   142	159	791	finally
    //   21	55	799	java/lang/Exception
    //   55	95	810	java/lang/Exception
    //   102	120	810	java/lang/Exception
    //   142	159	810	java/lang/Exception
  }
  
  public final void dQ(boolean paramBoolean)
  {
    AppMethodBeat.i(105952);
    Log.i(this.TAG, "onResult: " + paramBoolean + ", " + this.NNU.errType);
    super.dQ(paramBoolean);
    AppMethodBeat.o(105952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.i
 * JD-Core Version:    0.7.0.1
 */