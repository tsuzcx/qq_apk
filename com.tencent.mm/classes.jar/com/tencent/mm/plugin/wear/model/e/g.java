package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends a
{
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26399);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11005));
    localArrayList.add(Integer.valueOf(11006));
    localArrayList.add(Integer.valueOf(11007));
    AppMethodBeat.o(26399);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 26400
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11005
    //   10: if_icmpne +155 -> 165
    //   13: new 47	com/tencent/mm/protocal/protobuf/cwl
    //   16: dup
    //   17: invokespecial 48	com/tencent/mm/protocal/protobuf/cwl:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 52	com/tencent/mm/protocal/protobuf/cwl:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   26: pop
    //   27: new 54	com/tencent/mm/protocal/protobuf/cwm
    //   30: dup
    //   31: invokespecial 55	com/tencent/mm/protocal/protobuf/cwm:<init>	()V
    //   34: astore_2
    //   35: aload_3
    //   36: getfield 59	com/tencent/mm/protocal/protobuf/cwl:Username	Ljava/lang/String;
    //   39: invokestatic 65	com/tencent/mm/plugin/wear/model/h:agf	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +98 -> 144
    //   49: aload_2
    //   50: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   53: putfield 75	com/tencent/mm/protocal/protobuf/cwm:yeA	J
    //   56: aload 4
    //   58: invokestatic 79	com/tencent/mm/plugin/wear/model/h:ad	(Landroid/graphics/Bitmap;)[B
    //   61: astore 4
    //   63: ldc 81
    //   65: ldc 83
    //   67: iconst_1
    //   68: anewarray 85	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_3
    //   74: getfield 59	com/tencent/mm/protocal/protobuf/cwl:Username	Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_2
    //   82: new 92	com/tencent/mm/bv/b
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 95	com/tencent/mm/bv/b:<init>	([B)V
    //   91: putfield 99	com/tencent/mm/protocal/protobuf/cwm:jJh	Lcom/tencent/mm/bv/b;
    //   94: aload_2
    //   95: invokevirtual 103	com/tencent/mm/protocal/protobuf/cwm:toByteArray	()[B
    //   98: astore_2
    //   99: sipush 26400
    //   102: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: areturn
    //   107: astore_2
    //   108: ldc 81
    //   110: aload_2
    //   111: ldc 105
    //   113: iconst_0
    //   114: anewarray 85	java/lang/Object
    //   117: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: goto -93 -> 27
    //   123: astore_2
    //   124: ldc 81
    //   126: aload_2
    //   127: ldc 105
    //   129: iconst_0
    //   130: anewarray 85	java/lang/Object
    //   133: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: sipush 26400
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
    //   155: getfield 59	com/tencent/mm/protocal/protobuf/cwl:Username	Ljava/lang/String;
    //   158: aastore
    //   159: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: goto -26 -> 136
    //   165: iload_1
    //   166: sipush 11006
    //   169: if_icmpne +292 -> 461
    //   172: new 116	java/lang/String
    //   175: dup
    //   176: aload_2
    //   177: ldc 118
    //   179: invokespecial 121	java/lang/String:<init>	([BLjava/lang/String;)V
    //   182: astore_2
    //   183: ldc 123
    //   185: invokestatic 129	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   188: checkcast 123	com/tencent/mm/plugin/emoji/b/d
    //   191: invokeinterface 133 1 0
    //   196: aload_2
    //   197: invokeinterface 139 2 0
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -68 -> 136
    //   207: aload_2
    //   208: invokevirtual 145	com/tencent/mm/storage/emotion/EmojiInfo:vY	()Z
    //   211: ifeq +43 -> 254
    //   214: aload_2
    //   215: invokestatic 151	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   218: invokevirtual 155	com/tencent/mm/storage/emotion/EmojiInfo:hD	(Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   221: invokestatic 79	com/tencent/mm/plugin/wear/model/h:ad	(Landroid/graphics/Bitmap;)[B
    //   224: astore_2
    //   225: sipush 26400
    //   228: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_2
    //   232: areturn
    //   233: astore_2
    //   234: ldc 81
    //   236: aload_2
    //   237: ldc 105
    //   239: iconst_0
    //   240: anewarray 85	java/lang/Object
    //   243: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: sipush 26400
    //   249: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aconst_null
    //   253: areturn
    //   254: aload_2
    //   255: getfield 159	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   258: getstatic 164	com/tencent/mm/storage/emotion/EmojiGroupInfo:yPd	I
    //   261: if_icmpne +82 -> 343
    //   264: invokestatic 151	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   267: aload_2
    //   268: invokevirtual 168	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   271: invokestatic 172	com/tencent/mm/storage/emotion/EmojiInfo:bI	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   274: astore_3
    //   275: aload_3
    //   276: astore_2
    //   277: aload_3
    //   278: invokestatic 178	com/tencent/mm/a/e:m	(Ljava/io/InputStream;)[B
    //   281: astore 4
    //   283: aload_3
    //   284: invokestatic 182	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   287: sipush 26400
    //   290: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload 4
    //   295: areturn
    //   296: astore 4
    //   298: aconst_null
    //   299: astore_3
    //   300: aload_3
    //   301: astore_2
    //   302: ldc 81
    //   304: ldc 184
    //   306: iconst_1
    //   307: anewarray 85	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload 4
    //   314: invokestatic 189	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   317: aastore
    //   318: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: aload_3
    //   322: invokestatic 182	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   325: goto -189 -> 136
    //   328: astore_3
    //   329: aconst_null
    //   330: astore_2
    //   331: aload_2
    //   332: invokestatic 182	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   335: sipush 26400
    //   338: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_3
    //   342: athrow
    //   343: aload_2
    //   344: invokevirtual 195	com/tencent/mm/storage/emotion/EmojiInfo:dQB	()Ljava/lang/String;
    //   347: invokestatic 201	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   350: ldc2_w 202
    //   353: lcmp
    //   354: ifle +79 -> 433
    //   357: ldc 81
    //   359: ldc 205
    //   361: iconst_1
    //   362: anewarray 85	java/lang/Object
    //   365: dup
    //   366: iconst_0
    //   367: aload_2
    //   368: invokevirtual 208	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   371: aastore
    //   372: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: aload_2
    //   376: invokevirtual 211	com/tencent/mm/storage/emotion/EmojiInfo:dQC	()Ljava/lang/String;
    //   379: invokestatic 215	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   382: ifeq +21 -> 403
    //   385: aload_2
    //   386: invokevirtual 211	com/tencent/mm/storage/emotion/EmojiInfo:dQC	()Ljava/lang/String;
    //   389: iconst_0
    //   390: iconst_m1
    //   391: invokestatic 218	com/tencent/mm/vfs/e:i	(Ljava/lang/String;II)[B
    //   394: astore_2
    //   395: sipush 26400
    //   398: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload_2
    //   402: areturn
    //   403: ldc 81
    //   405: ldc 220
    //   407: invokestatic 223	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: aload_2
    //   411: invokestatic 229	com/tencent/mm/emoji/loader/c/b:d	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)Z
    //   414: pop
    //   415: aload_2
    //   416: invokevirtual 211	com/tencent/mm/storage/emotion/EmojiInfo:dQC	()Ljava/lang/String;
    //   419: iconst_0
    //   420: iconst_m1
    //   421: invokestatic 218	com/tencent/mm/vfs/e:i	(Ljava/lang/String;II)[B
    //   424: astore_2
    //   425: sipush 26400
    //   428: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: aload_2
    //   432: areturn
    //   433: ldc 123
    //   435: invokestatic 129	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   438: checkcast 123	com/tencent/mm/plugin/emoji/b/d
    //   441: invokeinterface 133 1 0
    //   446: aload_2
    //   447: invokeinterface 232 2 0
    //   452: astore_2
    //   453: sipush 26400
    //   456: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: aload_2
    //   460: areturn
    //   461: iload_1
    //   462: sipush 11007
    //   465: if_icmpne -329 -> 136
    //   468: new 234	com/tencent/mm/protocal/protobuf/cxd
    //   471: dup
    //   472: invokespecial 235	com/tencent/mm/protocal/protobuf/cxd:<init>	()V
    //   475: astore_3
    //   476: aload_3
    //   477: aload_2
    //   478: invokevirtual 236	com/tencent/mm/protocal/protobuf/cxd:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   481: pop
    //   482: invokestatic 242	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   485: pop
    //   486: invokestatic 248	com/tencent/mm/model/c:YC	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   489: aload_3
    //   490: getfield 251	com/tencent/mm/protocal/protobuf/cxd:wsz	J
    //   493: invokeinterface 257 3 0
    //   498: astore_2
    //   499: aload_3
    //   500: getfield 261	com/tencent/mm/protocal/protobuf/cxd:yeM	Z
    //   503: ifne +80 -> 583
    //   506: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   509: aload_2
    //   510: getfield 272	com/tencent/mm/g/c/dd:field_imgPath	Ljava/lang/String;
    //   513: invokevirtual 278	com/tencent/mm/at/g:te	(Ljava/lang/String;)Ljava/lang/String;
    //   516: astore_2
    //   517: aload_2
    //   518: invokestatic 281	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   521: ifne -385 -> 136
    //   524: new 283	com/tencent/mm/protocal/protobuf/cxe
    //   527: dup
    //   528: invokespecial 284	com/tencent/mm/protocal/protobuf/cxe:<init>	()V
    //   531: astore_3
    //   532: aload_3
    //   533: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   536: putfield 285	com/tencent/mm/protocal/protobuf/cxe:yeA	J
    //   539: aload_3
    //   540: new 92	com/tencent/mm/bv/b
    //   543: dup
    //   544: aload_2
    //   545: invokestatic 291	com/tencent/mm/modelsfs/FileOp:uc	(Ljava/lang/String;)[B
    //   548: invokespecial 95	com/tencent/mm/bv/b:<init>	([B)V
    //   551: putfield 292	com/tencent/mm/protocal/protobuf/cxe:jJh	Lcom/tencent/mm/bv/b;
    //   554: aload_3
    //   555: invokevirtual 293	com/tencent/mm/protocal/protobuf/cxe:toByteArray	()[B
    //   558: astore_2
    //   559: sipush 26400
    //   562: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload_2
    //   566: areturn
    //   567: astore_2
    //   568: ldc 81
    //   570: aload_2
    //   571: ldc 105
    //   573: iconst_0
    //   574: anewarray 85	java/lang/Object
    //   577: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: goto -98 -> 482
    //   583: new 283	com/tencent/mm/protocal/protobuf/cxe
    //   586: dup
    //   587: invokespecial 284	com/tencent/mm/protocal/protobuf/cxe:<init>	()V
    //   590: astore 5
    //   592: aload 5
    //   594: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   597: putfield 285	com/tencent/mm/protocal/protobuf/cxe:yeA	J
    //   600: aload_2
    //   601: getfield 296	com/tencent/mm/g/c/dd:field_isSend	I
    //   604: iconst_1
    //   605: if_icmpne +105 -> 710
    //   608: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   611: aload_2
    //   612: getfield 299	com/tencent/mm/g/c/dd:field_msgId	J
    //   615: invokevirtual 303	com/tencent/mm/at/g:gT	(J)Lcom/tencent/mm/at/e;
    //   618: astore_3
    //   619: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   622: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   625: aload_3
    //   626: invokevirtual 306	com/tencent/mm/at/g:d	(Lcom/tencent/mm/at/e;)Ljava/lang/String;
    //   629: ldc 105
    //   631: ldc 105
    //   633: invokevirtual 309	com/tencent/mm/at/g:q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   636: astore_2
    //   637: aload_2
    //   638: invokestatic 310	com/tencent/mm/modelsfs/FileOp:cN	(Ljava/lang/String;)Z
    //   641: ifeq +40 -> 681
    //   644: aload_2
    //   645: invokestatic 281	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   648: ifne -512 -> 136
    //   651: aload 5
    //   653: new 92	com/tencent/mm/bv/b
    //   656: dup
    //   657: aload_2
    //   658: invokestatic 291	com/tencent/mm/modelsfs/FileOp:uc	(Ljava/lang/String;)[B
    //   661: invokespecial 95	com/tencent/mm/bv/b:<init>	([B)V
    //   664: putfield 292	com/tencent/mm/protocal/protobuf/cxe:jJh	Lcom/tencent/mm/bv/b;
    //   667: aload 5
    //   669: invokevirtual 293	com/tencent/mm/protocal/protobuf/cxe:toByteArray	()[B
    //   672: astore_2
    //   673: sipush 26400
    //   676: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   679: aload_2
    //   680: areturn
    //   681: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   684: aload_3
    //   685: getfield 315	com/tencent/mm/at/e:fDM	Ljava/lang/String;
    //   688: ldc 105
    //   690: ldc 105
    //   692: invokevirtual 309	com/tencent/mm/at/g:q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   695: astore_3
    //   696: aload_3
    //   697: astore_2
    //   698: aload_3
    //   699: invokestatic 310	com/tencent/mm/modelsfs/FileOp:cN	(Ljava/lang/String;)Z
    //   702: ifne -58 -> 644
    //   705: aconst_null
    //   706: astore_2
    //   707: goto -63 -> 644
    //   710: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   713: aload_2
    //   714: getfield 318	com/tencent/mm/g/c/dd:field_msgSvrId	J
    //   717: invokevirtual 321	com/tencent/mm/at/g:gS	(J)Lcom/tencent/mm/at/e;
    //   720: astore 4
    //   722: aload 4
    //   724: invokevirtual 324	com/tencent/mm/at/e:ahg	()Z
    //   727: ifeq -22 -> 705
    //   730: aload 4
    //   732: invokevirtual 327	com/tencent/mm/at/e:ahh	()Z
    //   735: ifeq +88 -> 823
    //   738: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   741: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   744: aload 4
    //   746: invokevirtual 306	com/tencent/mm/at/g:d	(Lcom/tencent/mm/at/e;)Ljava/lang/String;
    //   749: ldc 105
    //   751: ldc 105
    //   753: invokevirtual 309	com/tencent/mm/at/g:q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   756: astore_3
    //   757: aload_3
    //   758: invokestatic 310	com/tencent/mm/modelsfs/FileOp:cN	(Ljava/lang/String;)Z
    //   761: ifeq +62 -> 823
    //   764: aload_3
    //   765: astore_2
    //   766: aload_3
    //   767: invokestatic 281	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   770: ifeq -126 -> 644
    //   773: invokestatic 267	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   776: aload 4
    //   778: getfield 315	com/tencent/mm/at/e:fDM	Ljava/lang/String;
    //   781: ldc 105
    //   783: ldc 105
    //   785: invokevirtual 309	com/tencent/mm/at/g:q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   788: astore 4
    //   790: aload_3
    //   791: astore_2
    //   792: aload 4
    //   794: invokestatic 310	com/tencent/mm/modelsfs/FileOp:cN	(Ljava/lang/String;)Z
    //   797: ifeq -153 -> 644
    //   800: aload 4
    //   802: astore_2
    //   803: goto -159 -> 644
    //   806: astore_2
    //   807: goto -671 -> 136
    //   810: astore_2
    //   811: goto -675 -> 136
    //   814: astore_3
    //   815: goto -484 -> 331
    //   818: astore 4
    //   820: goto -520 -> 300
    //   823: aconst_null
    //   824: astore_3
    //   825: goto -61 -> 764
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	828	0	this	g
    //   0	828	1	paramInt	int
    //   0	828	2	paramArrayOfByte	byte[]
    //   20	302	3	localObject1	java.lang.Object
    //   328	14	3	localObject2	java.lang.Object
    //   475	316	3	localObject3	java.lang.Object
    //   814	1	3	localObject4	java.lang.Object
    //   824	1	3	localObject5	java.lang.Object
    //   42	252	4	localObject6	java.lang.Object
    //   296	17	4	localException1	java.lang.Exception
    //   720	81	4	localObject7	java.lang.Object
    //   818	1	4	localException2	java.lang.Exception
    //   590	78	5	localcxe	com.tencent.mm.protocal.protobuf.cxe
    // Exception table:
    //   from	to	target	type
    //   21	27	107	java/io/IOException
    //   94	99	123	java/io/IOException
    //   172	183	233	java/io/UnsupportedEncodingException
    //   264	275	296	java/lang/Exception
    //   264	275	328	finally
    //   476	482	567	java/io/IOException
    //   554	559	806	java/io/IOException
    //   667	673	810	java/io/IOException
    //   277	283	814	finally
    //   302	321	814	finally
    //   277	283	818	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.g
 * JD-Core Version:    0.7.0.1
 */