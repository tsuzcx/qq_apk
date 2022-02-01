package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends a
{
  public final List<Integer> ehn()
  {
    AppMethodBeat.i(30081);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11005));
    localArrayList.add(Integer.valueOf(11006));
    localArrayList.add(Integer.valueOf(11007));
    AppMethodBeat.o(30081);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30082
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11005
    //   10: if_icmpne +155 -> 165
    //   13: new 47	com/tencent/mm/protocal/protobuf/dqp
    //   16: dup
    //   17: invokespecial 48	com/tencent/mm/protocal/protobuf/dqp:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 52	com/tencent/mm/protocal/protobuf/dqp:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   26: pop
    //   27: new 54	com/tencent/mm/protocal/protobuf/dqq
    //   30: dup
    //   31: invokespecial 55	com/tencent/mm/protocal/protobuf/dqq:<init>	()V
    //   34: astore_2
    //   35: aload_3
    //   36: getfield 59	com/tencent/mm/protocal/protobuf/dqp:Username	Ljava/lang/String;
    //   39: invokestatic 65	com/tencent/mm/plugin/wear/model/h:auQ	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +98 -> 144
    //   49: aload_2
    //   50: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   53: putfield 75	com/tencent/mm/protocal/protobuf/dqq:EGk	J
    //   56: aload 4
    //   58: invokestatic 79	com/tencent/mm/plugin/wear/model/h:ap	(Landroid/graphics/Bitmap;)[B
    //   61: astore 4
    //   63: ldc 81
    //   65: ldc 83
    //   67: iconst_1
    //   68: anewarray 85	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_3
    //   74: getfield 59	com/tencent/mm/protocal/protobuf/dqp:Username	Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 90	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_2
    //   82: new 92	com/tencent/mm/bx/b
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 95	com/tencent/mm/bx/b:<init>	([B)V
    //   91: putfield 99	com/tencent/mm/protocal/protobuf/dqq:mAx	Lcom/tencent/mm/bx/b;
    //   94: aload_2
    //   95: invokevirtual 103	com/tencent/mm/protocal/protobuf/dqq:toByteArray	()[B
    //   98: astore_2
    //   99: sipush 30082
    //   102: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: areturn
    //   107: astore_2
    //   108: ldc 81
    //   110: aload_2
    //   111: ldc 105
    //   113: iconst_0
    //   114: anewarray 85	java/lang/Object
    //   117: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: goto -93 -> 27
    //   123: astore_2
    //   124: ldc 81
    //   126: aload_2
    //   127: ldc 105
    //   129: iconst_0
    //   130: anewarray 85	java/lang/Object
    //   133: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: sipush 30082
    //   139: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aconst_null
    //   143: areturn
    //   144: ldc 81
    //   146: ldc 111
    //   148: iconst_1
    //   149: anewarray 85	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload_3
    //   155: getfield 59	com/tencent/mm/protocal/protobuf/dqp:Username	Ljava/lang/String;
    //   158: aastore
    //   159: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: goto -26 -> 136
    //   165: iload_1
    //   166: sipush 11006
    //   169: if_icmpne +293 -> 462
    //   172: new 116	java/lang/String
    //   175: dup
    //   176: aload_2
    //   177: ldc 118
    //   179: invokespecial 121	java/lang/String:<init>	([BLjava/lang/String;)V
    //   182: astore_2
    //   183: ldc 123
    //   185: invokestatic 129	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   188: checkcast 123	com/tencent/mm/plugin/emoji/b/d
    //   191: invokeinterface 133 1 0
    //   196: aload_2
    //   197: invokeinterface 139 2 0
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -68 -> 136
    //   207: aload_2
    //   208: invokevirtual 145	com/tencent/mm/storage/emotion/EmojiInfo:CZ	()Z
    //   211: ifeq +44 -> 255
    //   214: invokestatic 151	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   217: pop
    //   218: aload_2
    //   219: invokevirtual 155	com/tencent/mm/storage/emotion/EmojiInfo:fZP	()Landroid/graphics/Bitmap;
    //   222: invokestatic 79	com/tencent/mm/plugin/wear/model/h:ap	(Landroid/graphics/Bitmap;)[B
    //   225: astore_2
    //   226: sipush 30082
    //   229: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_2
    //   233: areturn
    //   234: astore_2
    //   235: ldc 81
    //   237: aload_2
    //   238: ldc 105
    //   240: iconst_0
    //   241: anewarray 85	java/lang/Object
    //   244: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: sipush 30082
    //   250: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aconst_null
    //   254: areturn
    //   255: aload_2
    //   256: getfield 159	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   259: getstatic 164	com/tencent/mm/storage/emotion/EmojiGroupInfo:LBN	I
    //   262: if_icmpne +82 -> 344
    //   265: invokestatic 151	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   268: aload_2
    //   269: invokevirtual 168	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   272: invokestatic 172	com/tencent/mm/storage/emotion/EmojiInfo:bZ	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   275: astore_3
    //   276: aload_3
    //   277: astore_2
    //   278: aload_3
    //   279: invokestatic 178	com/tencent/mm/b/e:readFromStream	(Ljava/io/InputStream;)[B
    //   282: astore 4
    //   284: aload_3
    //   285: invokestatic 184	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   288: sipush 30082
    //   291: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload 4
    //   296: areturn
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_3
    //   301: aload_3
    //   302: astore_2
    //   303: ldc 81
    //   305: ldc 186
    //   307: iconst_1
    //   308: anewarray 85	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload 4
    //   315: invokestatic 192	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   318: aastore
    //   319: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload_3
    //   323: invokestatic 184	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   326: goto -190 -> 136
    //   329: astore_3
    //   330: aconst_null
    //   331: astore_2
    //   332: aload_2
    //   333: invokestatic 184	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   336: sipush 30082
    //   339: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aload_3
    //   343: athrow
    //   344: aload_2
    //   345: invokevirtual 198	com/tencent/mm/storage/emotion/EmojiInfo:gaa	()Ljava/lang/String;
    //   348: invokestatic 204	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   351: ldc2_w 205
    //   354: lcmp
    //   355: ifle +79 -> 434
    //   358: ldc 81
    //   360: ldc 208
    //   362: iconst_1
    //   363: anewarray 85	java/lang/Object
    //   366: dup
    //   367: iconst_0
    //   368: aload_2
    //   369: invokevirtual 211	com/tencent/mm/storage/emotion/EmojiInfo:JS	()Ljava/lang/String;
    //   372: aastore
    //   373: invokestatic 90	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: aload_2
    //   377: invokevirtual 214	com/tencent/mm/storage/emotion/EmojiInfo:gab	()Ljava/lang/String;
    //   380: invokestatic 218	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   383: ifeq +21 -> 404
    //   386: aload_2
    //   387: invokevirtual 214	com/tencent/mm/storage/emotion/EmojiInfo:gab	()Ljava/lang/String;
    //   390: iconst_0
    //   391: iconst_m1
    //   392: invokestatic 222	com/tencent/mm/vfs/i:aR	(Ljava/lang/String;II)[B
    //   395: astore_2
    //   396: sipush 30082
    //   399: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload_2
    //   403: areturn
    //   404: ldc 81
    //   406: ldc 224
    //   408: invokestatic 227	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: aload_2
    //   412: invokestatic 233	com/tencent/mm/emoji/loader/c/c:f	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)Z
    //   415: pop
    //   416: aload_2
    //   417: invokevirtual 214	com/tencent/mm/storage/emotion/EmojiInfo:gab	()Ljava/lang/String;
    //   420: iconst_0
    //   421: iconst_m1
    //   422: invokestatic 222	com/tencent/mm/vfs/i:aR	(Ljava/lang/String;II)[B
    //   425: astore_2
    //   426: sipush 30082
    //   429: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: aload_2
    //   433: areturn
    //   434: ldc 123
    //   436: invokestatic 129	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   439: checkcast 123	com/tencent/mm/plugin/emoji/b/d
    //   442: invokeinterface 133 1 0
    //   447: aload_2
    //   448: invokeinterface 237 2 0
    //   453: astore_2
    //   454: sipush 30082
    //   457: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   460: aload_2
    //   461: areturn
    //   462: iload_1
    //   463: sipush 11007
    //   466: if_icmpne -330 -> 136
    //   469: new 239	com/tencent/mm/protocal/protobuf/drh
    //   472: dup
    //   473: invokespecial 240	com/tencent/mm/protocal/protobuf/drh:<init>	()V
    //   476: astore_3
    //   477: aload_3
    //   478: aload_2
    //   479: invokevirtual 241	com/tencent/mm/protocal/protobuf/drh:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   482: pop
    //   483: invokestatic 247	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   486: pop
    //   487: invokestatic 253	com/tencent/mm/model/c:apO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   490: aload_3
    //   491: getfield 256	com/tencent/mm/protocal/protobuf/drh:CCn	J
    //   494: invokeinterface 262 3 0
    //   499: astore_2
    //   500: aload_3
    //   501: getfield 266	com/tencent/mm/protocal/protobuf/drh:EGw	Z
    //   504: ifne +82 -> 586
    //   507: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   510: aload_2
    //   511: getfield 277	com/tencent/mm/g/c/du:field_imgPath	Ljava/lang/String;
    //   514: invokevirtual 283	com/tencent/mm/aw/g:yg	(Ljava/lang/String;)Ljava/lang/String;
    //   517: astore_2
    //   518: aload_2
    //   519: invokestatic 286	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   522: ifne -386 -> 136
    //   525: new 288	com/tencent/mm/protocal/protobuf/dri
    //   528: dup
    //   529: invokespecial 289	com/tencent/mm/protocal/protobuf/dri:<init>	()V
    //   532: astore_3
    //   533: aload_3
    //   534: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   537: putfield 290	com/tencent/mm/protocal/protobuf/dri:EGk	J
    //   540: aload_3
    //   541: new 92	com/tencent/mm/bx/b
    //   544: dup
    //   545: aload_2
    //   546: iconst_0
    //   547: iconst_m1
    //   548: invokestatic 222	com/tencent/mm/vfs/i:aR	(Ljava/lang/String;II)[B
    //   551: invokespecial 95	com/tencent/mm/bx/b:<init>	([B)V
    //   554: putfield 291	com/tencent/mm/protocal/protobuf/dri:mAx	Lcom/tencent/mm/bx/b;
    //   557: aload_3
    //   558: invokevirtual 292	com/tencent/mm/protocal/protobuf/dri:toByteArray	()[B
    //   561: astore_2
    //   562: sipush 30082
    //   565: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   568: aload_2
    //   569: areturn
    //   570: astore_2
    //   571: ldc 81
    //   573: aload_2
    //   574: ldc 105
    //   576: iconst_0
    //   577: anewarray 85	java/lang/Object
    //   580: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   583: goto -100 -> 483
    //   586: new 288	com/tencent/mm/protocal/protobuf/dri
    //   589: dup
    //   590: invokespecial 289	com/tencent/mm/protocal/protobuf/dri:<init>	()V
    //   593: astore 5
    //   595: aload 5
    //   597: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   600: putfield 290	com/tencent/mm/protocal/protobuf/dri:EGk	J
    //   603: aload_2
    //   604: getfield 295	com/tencent/mm/g/c/du:field_isSend	I
    //   607: iconst_1
    //   608: if_icmpne +107 -> 715
    //   611: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   614: aload_2
    //   615: getfield 298	com/tencent/mm/g/c/du:field_msgId	J
    //   618: invokevirtual 302	com/tencent/mm/aw/g:ms	(J)Lcom/tencent/mm/aw/e;
    //   621: astore_3
    //   622: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   625: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   628: aload_3
    //   629: invokevirtual 306	com/tencent/mm/aw/g:d	(Lcom/tencent/mm/aw/e;)Ljava/lang/String;
    //   632: ldc 105
    //   634: ldc 105
    //   636: invokevirtual 310	com/tencent/mm/aw/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   639: astore_2
    //   640: aload_2
    //   641: invokestatic 218	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   644: ifeq +42 -> 686
    //   647: aload_2
    //   648: invokestatic 286	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   651: ifne -515 -> 136
    //   654: aload 5
    //   656: new 92	com/tencent/mm/bx/b
    //   659: dup
    //   660: aload_2
    //   661: iconst_0
    //   662: iconst_m1
    //   663: invokestatic 222	com/tencent/mm/vfs/i:aR	(Ljava/lang/String;II)[B
    //   666: invokespecial 95	com/tencent/mm/bx/b:<init>	([B)V
    //   669: putfield 291	com/tencent/mm/protocal/protobuf/dri:mAx	Lcom/tencent/mm/bx/b;
    //   672: aload 5
    //   674: invokevirtual 292	com/tencent/mm/protocal/protobuf/dri:toByteArray	()[B
    //   677: astore_2
    //   678: sipush 30082
    //   681: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   684: aload_2
    //   685: areturn
    //   686: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   689: aload_3
    //   690: getfield 315	com/tencent/mm/aw/e:hgj	Ljava/lang/String;
    //   693: ldc 105
    //   695: ldc 105
    //   697: invokevirtual 310	com/tencent/mm/aw/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   700: astore_3
    //   701: aload_3
    //   702: astore_2
    //   703: aload_3
    //   704: invokestatic 218	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   707: ifne -60 -> 647
    //   710: aconst_null
    //   711: astore_2
    //   712: goto -65 -> 647
    //   715: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   718: aload_2
    //   719: getfield 318	com/tencent/mm/g/c/du:field_msgSvrId	J
    //   722: invokevirtual 321	com/tencent/mm/aw/g:mr	(J)Lcom/tencent/mm/aw/e;
    //   725: astore 4
    //   727: aload 4
    //   729: invokevirtual 324	com/tencent/mm/aw/e:ayh	()Z
    //   732: ifeq -22 -> 710
    //   735: aload 4
    //   737: invokevirtual 327	com/tencent/mm/aw/e:ayi	()Z
    //   740: ifeq +88 -> 828
    //   743: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   746: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   749: aload 4
    //   751: invokevirtual 306	com/tencent/mm/aw/g:d	(Lcom/tencent/mm/aw/e;)Ljava/lang/String;
    //   754: ldc 105
    //   756: ldc 105
    //   758: invokevirtual 310	com/tencent/mm/aw/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   761: astore_3
    //   762: aload_3
    //   763: invokestatic 218	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   766: ifeq +62 -> 828
    //   769: aload_3
    //   770: astore_2
    //   771: aload_3
    //   772: invokestatic 286	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   775: ifeq -128 -> 647
    //   778: invokestatic 272	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
    //   781: aload 4
    //   783: getfield 315	com/tencent/mm/aw/e:hgj	Ljava/lang/String;
    //   786: ldc 105
    //   788: ldc 105
    //   790: invokevirtual 310	com/tencent/mm/aw/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   793: astore 4
    //   795: aload_3
    //   796: astore_2
    //   797: aload 4
    //   799: invokestatic 218	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   802: ifeq -155 -> 647
    //   805: aload 4
    //   807: astore_2
    //   808: goto -161 -> 647
    //   811: astore_2
    //   812: goto -676 -> 136
    //   815: astore_2
    //   816: goto -680 -> 136
    //   819: astore_3
    //   820: goto -488 -> 332
    //   823: astore 4
    //   825: goto -524 -> 301
    //   828: aconst_null
    //   829: astore_3
    //   830: goto -61 -> 769
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	g
    //   0	833	1	paramInt	int
    //   0	833	2	paramArrayOfByte	byte[]
    //   20	303	3	localObject1	java.lang.Object
    //   329	14	3	localObject2	java.lang.Object
    //   476	320	3	localObject3	java.lang.Object
    //   819	1	3	localObject4	java.lang.Object
    //   829	1	3	localObject5	java.lang.Object
    //   42	253	4	localObject6	java.lang.Object
    //   297	17	4	localException1	java.lang.Exception
    //   725	81	4	localObject7	java.lang.Object
    //   823	1	4	localException2	java.lang.Exception
    //   593	80	5	localdri	com.tencent.mm.protocal.protobuf.dri
    // Exception table:
    //   from	to	target	type
    //   21	27	107	java/io/IOException
    //   94	99	123	java/io/IOException
    //   172	183	234	java/io/UnsupportedEncodingException
    //   265	276	297	java/lang/Exception
    //   265	276	329	finally
    //   477	483	570	java/io/IOException
    //   557	562	811	java/io/IOException
    //   672	678	815	java/io/IOException
    //   278	284	819	finally
    //   303	322	819	finally
    //   278	284	823	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.g
 * JD-Core Version:    0.7.0.1
 */