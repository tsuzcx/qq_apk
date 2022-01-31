package com.tencent.mm.plugin.music.f;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 30
    //   7: ldc 32
    //   9: invokestatic 37	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: bipush 237
    //   14: invokestatic 42	android/os/Process:setThreadPriority	(I)V
    //   17: aload_0
    //   18: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   21: getfield 46	com/tencent/mm/plugin/music/f/c:cfF	Ljava/lang/String;
    //   24: invokestatic 52	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   27: ifeq +24 -> 51
    //   30: ldc 30
    //   32: ldc 54
    //   34: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   41: iconst_0
    //   42: invokevirtual 61	com/tencent/mm/plugin/music/f/c:jP	(Z)V
    //   45: ldc 22
    //   47: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: aload_0
    //   52: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   55: new 66	android/media/MediaExtractor
    //   58: dup
    //   59: invokespecial 67	android/media/MediaExtractor:<init>	()V
    //   62: putfield 71	com/tencent/mm/plugin/music/f/c:cfO	Landroid/media/MediaExtractor;
    //   65: aload_0
    //   66: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   69: getfield 71	com/tencent/mm/plugin/music/f/c:cfO	Landroid/media/MediaExtractor;
    //   72: aload_0
    //   73: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   76: getfield 46	com/tencent/mm/plugin/music/f/c:cfF	Ljava/lang/String;
    //   79: invokevirtual 75	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   82: aconst_null
    //   83: astore 13
    //   85: aconst_null
    //   86: astore 12
    //   88: aload 13
    //   90: astore 11
    //   92: aload_0
    //   93: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   96: getfield 71	com/tencent/mm/plugin/music/f/c:cfO	Landroid/media/MediaExtractor;
    //   99: invokevirtual 79	android/media/MediaExtractor:getTrackCount	()I
    //   102: istore_2
    //   103: aload 13
    //   105: astore 11
    //   107: ldc 30
    //   109: ldc 81
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: iload_2
    //   118: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iconst_0
    //   126: istore_1
    //   127: aload 12
    //   129: astore 10
    //   131: iload_1
    //   132: iload_2
    //   133: if_icmpge +74 -> 207
    //   136: aload 13
    //   138: astore 11
    //   140: aload_0
    //   141: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   144: getfield 71	com/tencent/mm/plugin/music/f/c:cfO	Landroid/media/MediaExtractor;
    //   147: iload_1
    //   148: invokevirtual 94	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   151: astore 10
    //   153: aload 13
    //   155: astore 11
    //   157: aload_0
    //   158: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   161: aload 10
    //   163: ldc 96
    //   165: invokevirtual 102	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: putfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   171: aload 13
    //   173: astore 11
    //   175: aload_0
    //   176: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   179: getfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   182: invokestatic 52	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   185: ifne +120 -> 305
    //   188: aload 13
    //   190: astore 11
    //   192: aload_0
    //   193: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   196: getfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   199: ldc 107
    //   201: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   204: ifeq +101 -> 305
    //   207: aload 10
    //   209: ifnonnull +103 -> 312
    //   212: aload 10
    //   214: astore 11
    //   216: ldc 30
    //   218: ldc 114
    //   220: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload 10
    //   225: astore 11
    //   227: aload_0
    //   228: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   231: sipush 703
    //   234: putfield 118	com/tencent/mm/plugin/music/f/c:cfE	I
    //   237: aload 10
    //   239: astore 11
    //   241: aload_0
    //   242: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   245: iconst_1
    //   246: invokevirtual 61	com/tencent/mm/plugin/music/f/c:jP	(Z)V
    //   249: aload 10
    //   251: astore 11
    //   253: aload_0
    //   254: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   257: invokestatic 121	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   260: ldc 22
    //   262: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore 10
    //   268: ldc 30
    //   270: aload 10
    //   272: ldc 123
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: aload_0
    //   282: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   285: sipush 702
    //   288: putfield 118	com/tencent/mm/plugin/music/f/c:cfE	I
    //   291: aload_0
    //   292: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   295: iconst_1
    //   296: invokevirtual 61	com/tencent/mm/plugin/music/f/c:jP	(Z)V
    //   299: ldc 22
    //   301: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: return
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: goto -182 -> 127
    //   312: aload 10
    //   314: astore 11
    //   316: ldc 30
    //   318: ldc 129
    //   320: iconst_1
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: aload 10
    //   328: aastore
    //   329: invokestatic 131	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: aload 10
    //   334: astore 11
    //   336: aload_0
    //   337: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   340: aload 10
    //   342: ldc 133
    //   344: invokevirtual 137	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   347: putfield 140	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   350: aload 10
    //   352: astore 11
    //   354: aload_0
    //   355: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   358: aload 10
    //   360: ldc 142
    //   362: invokevirtual 137	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   365: putfield 145	com/tencent/mm/plugin/music/f/c:channels	I
    //   368: aload 10
    //   370: astore 11
    //   372: aload_0
    //   373: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   376: aload 10
    //   378: ldc 147
    //   380: invokevirtual 151	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   383: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   386: aload_0
    //   387: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   390: aload_0
    //   391: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   394: getfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   397: invokestatic 161	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   400: putfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   403: aload_0
    //   404: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   407: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   410: aload 10
    //   412: aconst_null
    //   413: aconst_null
    //   414: iconst_0
    //   415: invokevirtual 169	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   418: aload_0
    //   419: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   422: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   425: invokevirtual 172	android/media/MediaCodec:start	()V
    //   428: aload_0
    //   429: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   432: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   435: invokevirtual 176	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   438: astore 12
    //   440: aload_0
    //   441: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   444: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   447: invokevirtual 179	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   450: astore 11
    //   452: ldc 30
    //   454: ldc 181
    //   456: iconst_5
    //   457: anewarray 4	java/lang/Object
    //   460: dup
    //   461: iconst_0
    //   462: aload 10
    //   464: aastore
    //   465: dup
    //   466: iconst_1
    //   467: aload_0
    //   468: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   471: getfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   474: aastore
    //   475: dup
    //   476: iconst_2
    //   477: aload_0
    //   478: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   481: getfield 140	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   484: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   487: aastore
    //   488: dup
    //   489: iconst_3
    //   490: aload_0
    //   491: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   494: getfield 145	com/tencent/mm/plugin/music/f/c:channels	I
    //   497: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_4
    //   503: aload_0
    //   504: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   507: getfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   510: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   513: aastore
    //   514: invokestatic 131	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   517: aload_0
    //   518: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   521: getfield 71	com/tencent/mm/plugin/music/f/c:cfO	Landroid/media/MediaExtractor;
    //   524: iconst_0
    //   525: invokevirtual 189	android/media/MediaExtractor:selectTrack	(I)V
    //   528: new 191	android/media/MediaCodec$BufferInfo
    //   531: dup
    //   532: invokespecial 192	android/media/MediaCodec$BufferInfo:<init>	()V
    //   535: astore 13
    //   537: iconst_0
    //   538: istore_2
    //   539: iconst_0
    //   540: istore_1
    //   541: iconst_0
    //   542: istore_3
    //   543: aload_0
    //   544: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   547: getfield 196	com/tencent/mm/plugin/music/f/c:paX	Lcom/tencent/mm/plugin/music/f/a/g;
    //   550: iconst_3
    //   551: putfield 201	com/tencent/mm/plugin/music/f/a/g:pbb	I
    //   554: aload_0
    //   555: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   558: invokevirtual 204	com/tencent/mm/plugin/music/f/c:onStart	()V
    //   561: aload 11
    //   563: astore 10
    //   565: iload_1
    //   566: ifne +914 -> 1480
    //   569: iload_3
    //   570: bipush 50
    //   572: if_icmpge +908 -> 1480
    //   575: aload_0
    //   576: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   579: invokevirtual 207	com/tencent/mm/plugin/music/f/c:bWe	()V
    //   582: aload_0
    //   583: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   586: invokevirtual 211	com/tencent/mm/plugin/music/f/c:bWb	()Z
    //   589: ifeq +891 -> 1480
    //   592: iload_3
    //   593: iconst_1
    //   594: iadd
    //   595: istore_3
    //   596: iload_2
    //   597: istore 4
    //   599: iload_2
    //   600: ifne +119 -> 719
    //   603: aload_0
    //   604: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   607: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   610: ldc2_w 212
    //   613: invokevirtual 217	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   616: istore 6
    //   618: iload 6
    //   620: iflt +448 -> 1068
    //   623: aload 12
    //   625: iload 6
    //   627: aaload
    //   628: astore 11
    //   630: aload_0
    //   631: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   634: getfield 71	com/tencent/mm/plugin/music/f/c:cfO	Landroid/media/MediaExtractor;
    //   637: aload 11
    //   639: iconst_0
    //   640: invokevirtual 221	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   643: istore 5
    //   645: iload 5
    //   647: ifge +348 -> 995
    //   650: ldc 30
    //   652: ldc 223
    //   654: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   657: iconst_1
    //   658: istore_2
    //   659: iconst_0
    //   660: istore 4
    //   662: aload_0
    //   663: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   666: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   669: astore 11
    //   671: aload_0
    //   672: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   675: getfield 226	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   678: lstore 7
    //   680: iload_2
    //   681: ifeq +999 -> 1680
    //   684: iconst_4
    //   685: istore 5
    //   687: aload 11
    //   689: iload 6
    //   691: iconst_0
    //   692: iload 4
    //   694: lload 7
    //   696: iload 5
    //   698: invokevirtual 230	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   701: iload_2
    //   702: ifne +972 -> 1674
    //   705: aload_0
    //   706: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   709: getfield 71	com/tencent/mm/plugin/music/f/c:cfO	Landroid/media/MediaExtractor;
    //   712: invokevirtual 233	android/media/MediaExtractor:advance	()Z
    //   715: pop
    //   716: goto +958 -> 1674
    //   719: aload_0
    //   720: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   723: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   726: aload 13
    //   728: ldc2_w 212
    //   731: invokevirtual 237	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   734: istore 5
    //   736: iload 5
    //   738: iflt +532 -> 1270
    //   741: aload 13
    //   743: getfield 240	android/media/MediaCodec$BufferInfo:size	I
    //   746: ifle +923 -> 1669
    //   749: iconst_0
    //   750: istore_2
    //   751: aload 10
    //   753: iload 5
    //   755: aaload
    //   756: astore 11
    //   758: aload 13
    //   760: getfield 240	android/media/MediaCodec$BufferInfo:size	I
    //   763: newarray byte
    //   765: astore 14
    //   767: aload 11
    //   769: aload 14
    //   771: invokevirtual 246	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   774: pop
    //   775: aload 11
    //   777: invokevirtual 250	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   780: pop
    //   781: aload 14
    //   783: arraylength
    //   784: ifle +450 -> 1234
    //   787: aload_0
    //   788: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   791: getfield 254	com/tencent/mm/plugin/music/f/c:ayN	Landroid/media/AudioTrack;
    //   794: ifnonnull +423 -> 1217
    //   797: aload_0
    //   798: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   801: invokevirtual 257	com/tencent/mm/plugin/music/f/c:createAudioTrack	()Z
    //   804: ifne +403 -> 1207
    //   807: ldc 30
    //   809: ldc_w 259
    //   812: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: aload_0
    //   816: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   819: sipush 707
    //   822: putfield 118	com/tencent/mm/plugin/music/f/c:cfE	I
    //   825: aload_0
    //   826: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   829: iconst_1
    //   830: invokevirtual 61	com/tencent/mm/plugin/music/f/c:jP	(Z)V
    //   833: aload_0
    //   834: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   837: invokestatic 121	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   840: aload_0
    //   841: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   844: invokestatic 262	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   847: aload_0
    //   848: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   851: invokestatic 265	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   854: aload_0
    //   855: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   858: aconst_null
    //   859: putfield 46	com/tencent/mm/plugin/music/f/c:cfF	Ljava/lang/String;
    //   862: aload_0
    //   863: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   866: aconst_null
    //   867: putfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   870: aload_0
    //   871: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   874: iconst_0
    //   875: putfield 140	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   878: aload_0
    //   879: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   882: iconst_0
    //   883: putfield 145	com/tencent/mm/plugin/music/f/c:channels	I
    //   886: aload_0
    //   887: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   890: lconst_0
    //   891: putfield 226	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   894: aload_0
    //   895: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   898: lconst_0
    //   899: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   902: ldc 22
    //   904: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   907: return
    //   908: astore 10
    //   910: ldc 30
    //   912: aload 10
    //   914: ldc_w 267
    //   917: iconst_0
    //   918: anewarray 4	java/lang/Object
    //   921: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   924: aload_0
    //   925: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   928: sipush 705
    //   931: putfield 118	com/tencent/mm/plugin/music/f/c:cfE	I
    //   934: aload 11
    //   936: astore 10
    //   938: goto -552 -> 386
    //   941: astore 10
    //   943: ldc 30
    //   945: aload 10
    //   947: ldc_w 268
    //   950: iconst_0
    //   951: anewarray 4	java/lang/Object
    //   954: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   957: aload_0
    //   958: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   961: sipush 704
    //   964: putfield 118	com/tencent/mm/plugin/music/f/c:cfE	I
    //   967: aload_0
    //   968: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   971: iconst_1
    //   972: invokevirtual 61	com/tencent/mm/plugin/music/f/c:jP	(Z)V
    //   975: aload_0
    //   976: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   979: invokestatic 121	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   982: aload_0
    //   983: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   986: invokestatic 262	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   989: ldc 22
    //   991: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   994: return
    //   995: aload_0
    //   996: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   999: aload_0
    //   1000: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1003: getfield 71	com/tencent/mm/plugin/music/f/c:cfO	Landroid/media/MediaExtractor;
    //   1006: invokevirtual 272	android/media/MediaExtractor:getSampleTime	()J
    //   1009: putfield 226	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1012: aload_0
    //   1013: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1016: getfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1019: lconst_0
    //   1020: lcmp
    //   1021: ifne +22 -> 1043
    //   1024: iconst_0
    //   1025: istore 4
    //   1027: aload_0
    //   1028: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1031: iload 4
    //   1033: invokevirtual 275	com/tencent/mm/plugin/music/f/c:Av	(I)V
    //   1036: iload 5
    //   1038: istore 4
    //   1040: goto -378 -> 662
    //   1043: ldc2_w 276
    //   1046: aload_0
    //   1047: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1050: getfield 226	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1053: lmul
    //   1054: aload_0
    //   1055: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1058: getfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1061: ldiv
    //   1062: l2i
    //   1063: istore 4
    //   1065: goto -38 -> 1027
    //   1068: ldc 30
    //   1070: ldc_w 279
    //   1073: iload 6
    //   1075: invokestatic 282	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1078: invokevirtual 285	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1081: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1084: iload_2
    //   1085: istore 4
    //   1087: goto -368 -> 719
    //   1090: astore 10
    //   1092: ldc 30
    //   1094: aload 10
    //   1096: ldc_w 287
    //   1099: iconst_0
    //   1100: anewarray 4	java/lang/Object
    //   1103: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1106: aload_0
    //   1107: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1110: sipush 706
    //   1113: putfield 118	com/tencent/mm/plugin/music/f/c:cfE	I
    //   1116: aload_0
    //   1117: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1120: iconst_1
    //   1121: invokevirtual 61	com/tencent/mm/plugin/music/f/c:jP	(Z)V
    //   1124: aload_0
    //   1125: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1128: invokestatic 121	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1131: aload_0
    //   1132: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1135: invokestatic 262	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1138: aload_0
    //   1139: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1142: invokestatic 265	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1145: aload_0
    //   1146: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1149: aconst_null
    //   1150: putfield 46	com/tencent/mm/plugin/music/f/c:cfF	Ljava/lang/String;
    //   1153: aload_0
    //   1154: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1157: aconst_null
    //   1158: putfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   1161: aload_0
    //   1162: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1165: iconst_0
    //   1166: putfield 140	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   1169: aload_0
    //   1170: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1173: iconst_0
    //   1174: putfield 145	com/tencent/mm/plugin/music/f/c:channels	I
    //   1177: aload_0
    //   1178: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1181: lconst_0
    //   1182: putfield 226	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1185: aload_0
    //   1186: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1189: lconst_0
    //   1190: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1193: ldc 30
    //   1195: ldc_w 289
    //   1198: invokestatic 37	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1201: ldc 22
    //   1203: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1206: return
    //   1207: aload_0
    //   1208: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1211: getfield 254	com/tencent/mm/plugin/music/f/c:ayN	Landroid/media/AudioTrack;
    //   1214: invokevirtual 294	android/media/AudioTrack:play	()V
    //   1217: aload_0
    //   1218: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1221: getfield 254	com/tencent/mm/plugin/music/f/c:ayN	Landroid/media/AudioTrack;
    //   1224: aload 14
    //   1226: iconst_0
    //   1227: aload 14
    //   1229: arraylength
    //   1230: invokevirtual 298	android/media/AudioTrack:write	([BII)I
    //   1233: pop
    //   1234: aload_0
    //   1235: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1238: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   1241: iload 5
    //   1243: iconst_0
    //   1244: invokevirtual 302	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   1247: aload 13
    //   1249: getfield 305	android/media/MediaCodec$BufferInfo:flags	I
    //   1252: iconst_4
    //   1253: iand
    //   1254: ifeq +412 -> 1666
    //   1257: ldc 30
    //   1259: ldc_w 307
    //   1262: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1265: iconst_1
    //   1266: istore_1
    //   1267: goto +419 -> 1686
    //   1270: iload 5
    //   1272: bipush 253
    //   1274: if_icmpne +29 -> 1303
    //   1277: aload_0
    //   1278: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1281: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   1284: invokevirtual 179	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1287: astore 10
    //   1289: ldc 30
    //   1291: ldc_w 309
    //   1294: invokestatic 37	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1297: iload 4
    //   1299: istore_2
    //   1300: goto -735 -> 565
    //   1303: iload 5
    //   1305: bipush 254
    //   1307: if_icmpne +151 -> 1458
    //   1310: aload_0
    //   1311: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1314: getfield 165	com/tencent/mm/plugin/music/f/c:aMR	Landroid/media/MediaCodec;
    //   1317: invokevirtual 313	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1320: astore 11
    //   1322: ldc 30
    //   1324: ldc_w 315
    //   1327: aload 11
    //   1329: invokestatic 318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1332: invokevirtual 285	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1335: invokestatic 37	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1338: aload_0
    //   1339: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1342: aload 11
    //   1344: ldc 133
    //   1346: invokevirtual 137	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1349: putfield 140	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   1352: aload_0
    //   1353: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1356: aload 11
    //   1358: ldc 142
    //   1360: invokevirtual 137	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1363: putfield 145	com/tencent/mm/plugin/music/f/c:channels	I
    //   1366: aload_0
    //   1367: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1370: invokestatic 265	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1373: iload 4
    //   1375: istore_2
    //   1376: goto -811 -> 565
    //   1379: astore 10
    //   1381: aload_0
    //   1382: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1385: invokestatic 121	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1388: aload_0
    //   1389: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1392: invokestatic 262	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1395: aload_0
    //   1396: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1399: invokestatic 265	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1402: aload_0
    //   1403: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1406: aconst_null
    //   1407: putfield 46	com/tencent/mm/plugin/music/f/c:cfF	Ljava/lang/String;
    //   1410: aload_0
    //   1411: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1414: aconst_null
    //   1415: putfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   1418: aload_0
    //   1419: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1422: iconst_0
    //   1423: putfield 140	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   1426: aload_0
    //   1427: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1430: iconst_0
    //   1431: putfield 145	com/tencent/mm/plugin/music/f/c:channels	I
    //   1434: aload_0
    //   1435: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1438: lconst_0
    //   1439: putfield 226	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1442: aload_0
    //   1443: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1446: lconst_0
    //   1447: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1450: ldc 22
    //   1452: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1455: aload 10
    //   1457: athrow
    //   1458: ldc 30
    //   1460: ldc_w 320
    //   1463: iload 5
    //   1465: invokestatic 282	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1468: invokevirtual 285	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1471: invokestatic 37	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1474: iload 4
    //   1476: istore_2
    //   1477: goto -912 -> 565
    //   1480: aload_0
    //   1481: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1484: getfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1487: ldc2_w 212
    //   1490: ldiv
    //   1491: aload_0
    //   1492: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1495: getfield 226	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1498: ldc2_w 212
    //   1501: ldiv
    //   1502: lsub
    //   1503: ldc2_w 321
    //   1506: lcmp
    //   1507: ifge +121 -> 1628
    //   1510: iconst_1
    //   1511: istore 9
    //   1513: iload_3
    //   1514: bipush 50
    //   1516: if_icmplt +118 -> 1634
    //   1519: ldc 30
    //   1521: ldc_w 324
    //   1524: iconst_1
    //   1525: anewarray 4	java/lang/Object
    //   1528: dup
    //   1529: iconst_0
    //   1530: iload_3
    //   1531: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1534: aastore
    //   1535: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1538: aload_0
    //   1539: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1542: sipush 706
    //   1545: putfield 118	com/tencent/mm/plugin/music/f/c:cfE	I
    //   1548: aload_0
    //   1549: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1552: iconst_1
    //   1553: invokevirtual 61	com/tencent/mm/plugin/music/f/c:jP	(Z)V
    //   1556: aload_0
    //   1557: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1560: invokestatic 121	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1563: aload_0
    //   1564: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1567: invokestatic 262	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1570: aload_0
    //   1571: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1574: invokestatic 265	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1577: aload_0
    //   1578: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1581: aconst_null
    //   1582: putfield 46	com/tencent/mm/plugin/music/f/c:cfF	Ljava/lang/String;
    //   1585: aload_0
    //   1586: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1589: aconst_null
    //   1590: putfield 105	com/tencent/mm/plugin/music/f/c:cfP	Ljava/lang/String;
    //   1593: aload_0
    //   1594: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1597: iconst_0
    //   1598: putfield 140	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   1601: aload_0
    //   1602: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1605: iconst_0
    //   1606: putfield 145	com/tencent/mm/plugin/music/f/c:channels	I
    //   1609: aload_0
    //   1610: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1613: lconst_0
    //   1614: putfield 226	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1617: aload_0
    //   1618: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1621: lconst_0
    //   1622: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1625: goto -432 -> 1193
    //   1628: iconst_0
    //   1629: istore 9
    //   1631: goto -118 -> 1513
    //   1634: ldc 30
    //   1636: ldc_w 326
    //   1639: iconst_1
    //   1640: anewarray 4	java/lang/Object
    //   1643: dup
    //   1644: iconst_0
    //   1645: iload 9
    //   1647: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1650: aastore
    //   1651: invokestatic 131	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1654: aload_0
    //   1655: getfield 14	com/tencent/mm/plugin/music/f/c$1:paF	Lcom/tencent/mm/plugin/music/f/c;
    //   1658: iload 9
    //   1660: invokevirtual 334	com/tencent/mm/plugin/music/f/c:jQ	(Z)V
    //   1663: goto -107 -> 1556
    //   1666: goto +20 -> 1686
    //   1669: iload_3
    //   1670: istore_2
    //   1671: goto -920 -> 751
    //   1674: iload_2
    //   1675: istore 4
    //   1677: goto -958 -> 719
    //   1680: iconst_0
    //   1681: istore 5
    //   1683: goto -996 -> 687
    //   1686: iload_2
    //   1687: istore_3
    //   1688: iload 4
    //   1690: istore_2
    //   1691: goto -1126 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1694	0	this	1
    //   126	1141	1	i	int
    //   102	1589	2	j	int
    //   542	1146	3	k	int
    //   597	1092	4	m	int
    //   643	1039	5	n	int
    //   616	458	6	i1	int
    //   678	17	7	l	long
    //   1511	148	9	bool	boolean
    //   129	121	10	localObject1	Object
    //   266	197	10	localException1	java.lang.Exception
    //   563	189	10	localObject2	Object
    //   908	5	10	localException2	java.lang.Exception
    //   936	1	10	localObject3	Object
    //   941	5	10	localException3	java.lang.Exception
    //   1090	5	10	localException4	java.lang.Exception
    //   1287	1	10	arrayOfByteBuffer1	java.nio.ByteBuffer[]
    //   1379	77	10	localObject4	Object
    //   90	1267	11	localObject5	Object
    //   86	538	12	arrayOfByteBuffer2	java.nio.ByteBuffer[]
    //   83	1165	13	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   765	463	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   65	82	266	java/lang/Exception
    //   92	103	908	java/lang/Exception
    //   107	125	908	java/lang/Exception
    //   140	153	908	java/lang/Exception
    //   157	171	908	java/lang/Exception
    //   175	188	908	java/lang/Exception
    //   192	207	908	java/lang/Exception
    //   216	223	908	java/lang/Exception
    //   227	237	908	java/lang/Exception
    //   241	249	908	java/lang/Exception
    //   253	260	908	java/lang/Exception
    //   316	332	908	java/lang/Exception
    //   336	350	908	java/lang/Exception
    //   354	368	908	java/lang/Exception
    //   372	386	908	java/lang/Exception
    //   386	428	941	java/lang/Exception
    //   575	592	1090	java/lang/Exception
    //   603	618	1090	java/lang/Exception
    //   630	645	1090	java/lang/Exception
    //   650	657	1090	java/lang/Exception
    //   662	680	1090	java/lang/Exception
    //   687	701	1090	java/lang/Exception
    //   705	716	1090	java/lang/Exception
    //   719	736	1090	java/lang/Exception
    //   741	749	1090	java/lang/Exception
    //   758	833	1090	java/lang/Exception
    //   995	1024	1090	java/lang/Exception
    //   1027	1036	1090	java/lang/Exception
    //   1043	1065	1090	java/lang/Exception
    //   1068	1084	1090	java/lang/Exception
    //   1207	1217	1090	java/lang/Exception
    //   1217	1234	1090	java/lang/Exception
    //   1234	1265	1090	java/lang/Exception
    //   1277	1297	1090	java/lang/Exception
    //   1310	1373	1090	java/lang/Exception
    //   1458	1474	1090	java/lang/Exception
    //   1480	1510	1090	java/lang/Exception
    //   1519	1556	1090	java/lang/Exception
    //   1634	1663	1090	java/lang/Exception
    //   575	592	1379	finally
    //   603	618	1379	finally
    //   630	645	1379	finally
    //   650	657	1379	finally
    //   662	680	1379	finally
    //   687	701	1379	finally
    //   705	716	1379	finally
    //   719	736	1379	finally
    //   741	749	1379	finally
    //   758	833	1379	finally
    //   995	1024	1379	finally
    //   1027	1036	1379	finally
    //   1043	1065	1379	finally
    //   1068	1084	1379	finally
    //   1092	1124	1379	finally
    //   1207	1217	1379	finally
    //   1217	1234	1379	finally
    //   1234	1265	1379	finally
    //   1277	1297	1379	finally
    //   1310	1373	1379	finally
    //   1458	1474	1379	finally
    //   1480	1510	1379	finally
    //   1519	1556	1379	finally
    //   1634	1663	1379	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.c.1
 * JD-Core Version:    0.7.0.1
 */