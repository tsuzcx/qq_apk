package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/loader/StickerUrlTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "md5", "outputPath", "zipFile", "call", "", "onResult", "success", "", "uniqueId", "Companion", "plugin-sticker_release"})
public final class i
  extends g
{
  public static final a Fdy;
  private final String Fdx;
  private final String TAG;
  private final String md5;
  private final String oLh;
  
  static
  {
    AppMethodBeat.i(105954);
    Fdy = new a((byte)0);
    AppMethodBeat.o(105954);
  }
  
  public i(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105953);
    this.TAG = "MicroMsg.StickerUrlTask";
    this.md5 = paramStickerLoadInfo.AL();
    paramStickerLoadInfo = new StringBuilder();
    e locale = e.Fds;
    this.oLh = (e.eIZ() + "preview/");
    paramStickerLoadInfo = new StringBuilder();
    locale = e.Fds;
    this.Fdx = (e.eIZ() + "preview.zip");
    AppMethodBeat.o(105953);
  }
  
  public final String abi()
  {
    return this.md5;
  }
  
  /* Error */
  public final void call()
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 110	com/tencent/mm/network/b$b
    //   8: dup
    //   9: aload_0
    //   10: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   13: getfield 116	com/tencent/mm/sticker/loader/StickerLoadInfo:url	Ljava/lang/String;
    //   16: invokespecial 119	com/tencent/mm/network/b$b:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   25: getfield 116	com/tencent/mm/sticker/loader/StickerLoadInfo:url	Ljava/lang/String;
    //   28: aload 4
    //   30: invokestatic 124	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   33: astore 8
    //   35: aload 8
    //   37: ldc 126
    //   39: invokestatic 129	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 8
    //   44: invokevirtual 135	com/tencent/mm/network/v:getResponseCode	()I
    //   47: istore_1
    //   48: aload 8
    //   50: invokevirtual 139	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   53: astore 4
    //   55: aload 8
    //   57: invokevirtual 142	com/tencent/mm/network/v:getContentType	()Ljava/lang/String;
    //   60: astore 9
    //   62: aload_0
    //   63: getfield 68	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   66: new 78	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 144
    //   72: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: iload_1
    //   76: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: ldc 150
    //   81: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 9
    //   86: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: iload_1
    //   96: sipush 200
    //   99: if_icmpeq +43 -> 142
    //   102: aload 8
    //   104: invokevirtual 158	com/tencent/mm/network/v:disconnect	()V
    //   107: aload_0
    //   108: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   111: iconst_1
    //   112: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   115: aload_0
    //   116: iconst_0
    //   117: invokevirtual 166	com/tencent/mm/sticker/loader/i:df	(Z)V
    //   120: aload 4
    //   122: ifnull +14 -> 136
    //   125: aload 4
    //   127: invokevirtual 171	java/io/InputStream:close	()V
    //   130: ldc 108
    //   132: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: ldc 108
    //   138: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: return
    //   142: aload_0
    //   143: getfield 100	com/tencent/mm/sticker/loader/i:oLh	Ljava/lang/String;
    //   146: invokestatic 177	com/tencent/mm/vfs/i:aMF	(Ljava/lang/String;)Z
    //   149: pop
    //   150: aload_0
    //   151: getfield 104	com/tencent/mm/sticker/loader/i:Fdx	Ljava/lang/String;
    //   154: invokestatic 181	com/tencent/mm/vfs/i:vu	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   157: astore 5
    //   159: aload 5
    //   161: astore 6
    //   163: aload 4
    //   165: astore 7
    //   167: aload 4
    //   169: ldc 183
    //   171: invokestatic 129	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   174: aload 5
    //   176: astore 6
    //   178: aload 4
    //   180: astore 7
    //   182: aload 5
    //   184: ldc 185
    //   186: invokestatic 129	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   189: aload 5
    //   191: astore 6
    //   193: aload 4
    //   195: astore 7
    //   197: aload 4
    //   199: aload 5
    //   201: invokestatic 190	d/f/a:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   204: lstore_2
    //   205: aload 5
    //   207: astore 6
    //   209: aload 4
    //   211: astore 7
    //   213: aload_0
    //   214: getfield 68	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   217: ldc 192
    //   219: lload_2
    //   220: invokestatic 198	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   223: invokevirtual 202	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   226: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 5
    //   231: astore 6
    //   233: aload 4
    //   235: astore 7
    //   237: aload 8
    //   239: invokevirtual 158	com/tencent/mm/network/v:disconnect	()V
    //   242: aload 5
    //   244: astore 6
    //   246: aload 4
    //   248: astore 7
    //   250: aload 9
    //   252: ldc 204
    //   254: invokestatic 207	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   257: ifeq +313 -> 570
    //   260: aload 5
    //   262: astore 6
    //   264: aload 4
    //   266: astore 7
    //   268: aload_0
    //   269: getfield 100	com/tencent/mm/sticker/loader/i:oLh	Ljava/lang/String;
    //   272: invokestatic 210	com/tencent/mm/vfs/i:deleteDir	(Ljava/lang/String;)Z
    //   275: pop
    //   276: aload 5
    //   278: astore 6
    //   280: aload 4
    //   282: astore 7
    //   284: aload_0
    //   285: getfield 100	com/tencent/mm/sticker/loader/i:oLh	Ljava/lang/String;
    //   288: invokestatic 177	com/tencent/mm/vfs/i:aMF	(Ljava/lang/String;)Z
    //   291: pop
    //   292: aload 5
    //   294: astore 6
    //   296: aload 4
    //   298: astore 7
    //   300: aload_0
    //   301: getfield 104	com/tencent/mm/sticker/loader/i:Fdx	Ljava/lang/String;
    //   304: aload_0
    //   305: getfield 100	com/tencent/mm/sticker/loader/i:oLh	Ljava/lang/String;
    //   308: invokestatic 214	com/tencent/mm/vfs/i:fc	(Ljava/lang/String;Ljava/lang/String;)I
    //   311: ifeq +48 -> 359
    //   314: aload 5
    //   316: astore 6
    //   318: aload 4
    //   320: astore 7
    //   322: aload_0
    //   323: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   326: iconst_2
    //   327: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   330: aload 5
    //   332: astore 6
    //   334: aload 4
    //   336: astore 7
    //   338: aload_0
    //   339: iconst_0
    //   340: invokevirtual 166	com/tencent/mm/sticker/loader/i:df	(Z)V
    //   343: aload 4
    //   345: invokevirtual 171	java/io/InputStream:close	()V
    //   348: aload 5
    //   350: invokevirtual 217	java/io/OutputStream:close	()V
    //   353: ldc 108
    //   355: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: return
    //   359: aload 5
    //   361: astore 6
    //   363: aload 4
    //   365: astore 7
    //   367: new 219	com/tencent/mm/sticker/e
    //   370: dup
    //   371: invokespecial 220	com/tencent/mm/sticker/e:<init>	()V
    //   374: astore 8
    //   376: aload 5
    //   378: astore 6
    //   380: aload 4
    //   382: astore 7
    //   384: aload 8
    //   386: aload_0
    //   387: getfield 100	com/tencent/mm/sticker/loader/i:oLh	Ljava/lang/String;
    //   390: invokevirtual 223	com/tencent/mm/sticker/e:aGZ	(Ljava/lang/String;)V
    //   393: aload 5
    //   395: astore 6
    //   397: aload 4
    //   399: astore 7
    //   401: aload 8
    //   403: aload_0
    //   404: getfield 100	com/tencent/mm/sticker/loader/i:oLh	Ljava/lang/String;
    //   407: invokevirtual 226	com/tencent/mm/sticker/e:aHb	(Ljava/lang/String;)V
    //   410: aload 5
    //   412: astore 6
    //   414: aload 4
    //   416: astore 7
    //   418: aload 8
    //   420: invokevirtual 230	com/tencent/mm/sticker/e:isValid	()Z
    //   423: ifeq +32 -> 455
    //   426: aload 5
    //   428: astore 6
    //   430: aload 4
    //   432: astore 7
    //   434: aload_0
    //   435: iconst_1
    //   436: invokevirtual 166	com/tencent/mm/sticker/loader/i:df	(Z)V
    //   439: aload 4
    //   441: invokevirtual 171	java/io/InputStream:close	()V
    //   444: aload 5
    //   446: invokevirtual 217	java/io/OutputStream:close	()V
    //   449: ldc 108
    //   451: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   454: return
    //   455: aload 5
    //   457: astore 6
    //   459: aload 4
    //   461: astore 7
    //   463: aload_0
    //   464: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   467: iconst_2
    //   468: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   471: aload 5
    //   473: astore 6
    //   475: aload 4
    //   477: astore 7
    //   479: aload_0
    //   480: iconst_0
    //   481: invokevirtual 166	com/tencent/mm/sticker/loader/i:df	(Z)V
    //   484: goto -45 -> 439
    //   487: astore 8
    //   489: aload 5
    //   491: astore 6
    //   493: aload 4
    //   495: astore 7
    //   497: aload_0
    //   498: getfield 68	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   501: aload 8
    //   503: checkcast 232	java/lang/Throwable
    //   506: ldc 233
    //   508: iconst_0
    //   509: anewarray 235	java/lang/Object
    //   512: invokestatic 239	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: aload 5
    //   517: astore 6
    //   519: aload 4
    //   521: astore 7
    //   523: aload_0
    //   524: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   527: iconst_1
    //   528: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   531: aload 5
    //   533: astore 6
    //   535: aload 4
    //   537: astore 7
    //   539: aload_0
    //   540: iconst_0
    //   541: invokevirtual 166	com/tencent/mm/sticker/loader/i:df	(Z)V
    //   544: aload 4
    //   546: ifnull +8 -> 554
    //   549: aload 4
    //   551: invokevirtual 171	java/io/InputStream:close	()V
    //   554: aload 5
    //   556: ifnull +212 -> 768
    //   559: aload 5
    //   561: invokevirtual 217	java/io/OutputStream:close	()V
    //   564: ldc 108
    //   566: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   569: return
    //   570: aload 5
    //   572: astore 6
    //   574: aload 4
    //   576: astore 7
    //   578: aload_0
    //   579: getfield 104	com/tencent/mm/sticker/loader/i:Fdx	Ljava/lang/String;
    //   582: invokestatic 242	com/tencent/mm/vfs/i:aMP	(Ljava/lang/String;)Ljava/lang/String;
    //   585: astore 8
    //   587: aload 5
    //   589: astore 6
    //   591: aload 4
    //   593: astore 7
    //   595: aload_0
    //   596: getfield 68	com/tencent/mm/sticker/loader/i:TAG	Ljava/lang/String;
    //   599: ldc 244
    //   601: aload 8
    //   603: invokestatic 247	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   606: invokevirtual 202	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   609: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: aload 5
    //   614: astore 6
    //   616: aload 4
    //   618: astore 7
    //   620: new 249	org/json/JSONObject
    //   623: dup
    //   624: aload 8
    //   626: invokespecial 250	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   629: ldc 252
    //   631: invokevirtual 256	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   634: ldc_w 258
    //   637: invokevirtual 262	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   640: tableswitch	default:+172 -> 812, 1206:+90->730, 1207:+109->749
    //   665: iconst_2
    //   666: astore 6
    //   668: aload 4
    //   670: astore 7
    //   672: aload_0
    //   673: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   676: iconst_2
    //   677: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   680: aload 5
    //   682: astore 6
    //   684: aload 4
    //   686: astore 7
    //   688: aload_0
    //   689: iconst_0
    //   690: invokevirtual 166	com/tencent/mm/sticker/loader/i:df	(Z)V
    //   693: goto -254 -> 439
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
    //   722: ldc 108
    //   724: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   727: aload 5
    //   729: athrow
    //   730: aload 5
    //   732: astore 6
    //   734: aload 4
    //   736: astore 7
    //   738: aload_0
    //   739: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   742: iconst_4
    //   743: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   746: goto -66 -> 680
    //   749: aload 5
    //   751: astore 6
    //   753: aload 4
    //   755: astore 7
    //   757: aload_0
    //   758: getfield 113	com/tencent/mm/sticker/loader/g:Fdv	Lcom/tencent/mm/sticker/loader/StickerLoadInfo;
    //   761: iconst_5
    //   762: putfield 162	com/tencent/mm/sticker/loader/StickerLoadInfo:errType	I
    //   765: goto -85 -> 680
    //   768: ldc 108
    //   770: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   773: return
    //   774: astore 5
    //   776: aconst_null
    //   777: astore 6
    //   779: aconst_null
    //   780: astore 4
    //   782: goto -80 -> 702
    //   785: astore 5
    //   787: aconst_null
    //   788: astore 6
    //   790: goto -88 -> 702
    //   793: astore 8
    //   795: aconst_null
    //   796: astore 5
    //   798: aconst_null
    //   799: astore 4
    //   801: goto -312 -> 489
    //   804: astore 8
    //   806: aconst_null
    //   807: astore 5
    //   809: goto -320 -> 489
    //   812: goto -148 -> 664
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	815	0	this	i
    //   47	53	1	i	int
    //   204	16	2	l	long
    //   19	781	4	localObject1	Object
    //   157	524	5	localOutputStream	java.io.OutputStream
    //   696	54	5	localObject2	Object
    //   774	1	5	localObject3	Object
    //   785	1	5	localObject4	Object
    //   796	12	5	localObject5	Object
    //   161	628	6	localObject6	Object
    //   165	591	7	localObject7	Object
    //   33	386	8	localObject8	Object
    //   487	15	8	localException1	java.lang.Exception
    //   585	40	8	str1	String
    //   793	1	8	localException2	java.lang.Exception
    //   804	1	8	localException3	java.lang.Exception
    //   60	191	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   167	174	487	java/lang/Exception
    //   182	189	487	java/lang/Exception
    //   197	205	487	java/lang/Exception
    //   213	229	487	java/lang/Exception
    //   237	242	487	java/lang/Exception
    //   250	260	487	java/lang/Exception
    //   268	276	487	java/lang/Exception
    //   284	292	487	java/lang/Exception
    //   300	314	487	java/lang/Exception
    //   322	330	487	java/lang/Exception
    //   338	343	487	java/lang/Exception
    //   367	376	487	java/lang/Exception
    //   384	393	487	java/lang/Exception
    //   401	410	487	java/lang/Exception
    //   418	426	487	java/lang/Exception
    //   434	439	487	java/lang/Exception
    //   463	471	487	java/lang/Exception
    //   479	484	487	java/lang/Exception
    //   578	587	487	java/lang/Exception
    //   595	612	487	java/lang/Exception
    //   620	664	487	java/lang/Exception
    //   672	680	487	java/lang/Exception
    //   688	693	487	java/lang/Exception
    //   738	746	487	java/lang/Exception
    //   757	765	487	java/lang/Exception
    //   167	174	696	finally
    //   182	189	696	finally
    //   197	205	696	finally
    //   213	229	696	finally
    //   237	242	696	finally
    //   250	260	696	finally
    //   268	276	696	finally
    //   284	292	696	finally
    //   300	314	696	finally
    //   322	330	696	finally
    //   338	343	696	finally
    //   367	376	696	finally
    //   384	393	696	finally
    //   401	410	696	finally
    //   418	426	696	finally
    //   434	439	696	finally
    //   463	471	696	finally
    //   479	484	696	finally
    //   497	515	696	finally
    //   523	531	696	finally
    //   539	544	696	finally
    //   578	587	696	finally
    //   595	612	696	finally
    //   620	664	696	finally
    //   672	680	696	finally
    //   688	693	696	finally
    //   738	746	696	finally
    //   757	765	696	finally
    //   21	55	774	finally
    //   55	95	785	finally
    //   102	120	785	finally
    //   142	159	785	finally
    //   21	55	793	java/lang/Exception
    //   55	95	804	java/lang/Exception
    //   102	120	804	java/lang/Exception
    //   142	159	804	java/lang/Exception
  }
  
  public final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(105952);
    ad.i(this.TAG, "onResult: " + paramBoolean + ", " + this.Fdv.errType);
    super.df(paramBoolean);
    AppMethodBeat.o(105952);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/loader/StickerUrlTask$Companion;", "", "()V", "RET_EXPIRED", "", "RET_UNI_MISMATCH", "plugin-sticker_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.i
 * JD-Core Version:    0.7.0.1
 */