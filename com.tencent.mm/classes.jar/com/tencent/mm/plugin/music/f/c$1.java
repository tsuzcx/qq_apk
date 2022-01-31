package com.tencent.mm.plugin.music.f;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 23
    //   2: ldc 25
    //   4: invokestatic 31	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: bipush 237
    //   9: invokestatic 37	android/os/Process:setThreadPriority	(I)V
    //   12: aload_0
    //   13: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   16: getfield 41	com/tencent/mm/plugin/music/f/c:mAz	Ljava/lang/String;
    //   19: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   22: ifeq +19 -> 41
    //   25: ldc 23
    //   27: ldc 49
    //   29: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   36: iconst_0
    //   37: invokevirtual 56	com/tencent/mm/plugin/music/f/c:hS	(Z)V
    //   40: return
    //   41: aload_0
    //   42: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   45: new 58	android/media/MediaExtractor
    //   48: dup
    //   49: invokespecial 59	android/media/MediaExtractor:<init>	()V
    //   52: putfield 63	com/tencent/mm/plugin/music/f/c:eIP	Landroid/media/MediaExtractor;
    //   55: aload_0
    //   56: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   59: getfield 63	com/tencent/mm/plugin/music/f/c:eIP	Landroid/media/MediaExtractor;
    //   62: aload_0
    //   63: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   66: getfield 41	com/tencent/mm/plugin/music/f/c:mAz	Ljava/lang/String;
    //   69: invokevirtual 67	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   72: aconst_null
    //   73: astore 13
    //   75: aconst_null
    //   76: astore 12
    //   78: aload 13
    //   80: astore 11
    //   82: aload_0
    //   83: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   86: getfield 63	com/tencent/mm/plugin/music/f/c:eIP	Landroid/media/MediaExtractor;
    //   89: invokevirtual 71	android/media/MediaExtractor:getTrackCount	()I
    //   92: istore_2
    //   93: aload 13
    //   95: astore 11
    //   97: ldc 23
    //   99: ldc 73
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: iload_2
    //   108: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: invokestatic 82	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: iconst_0
    //   116: istore_1
    //   117: aload 12
    //   119: astore 10
    //   121: iload_1
    //   122: iload_2
    //   123: if_icmpge +74 -> 197
    //   126: aload 13
    //   128: astore 11
    //   130: aload_0
    //   131: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   134: getfield 63	com/tencent/mm/plugin/music/f/c:eIP	Landroid/media/MediaExtractor;
    //   137: iload_1
    //   138: invokevirtual 86	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   141: astore 10
    //   143: aload 13
    //   145: astore 11
    //   147: aload_0
    //   148: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   151: aload 10
    //   153: ldc 88
    //   155: invokevirtual 94	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: putfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   161: aload 13
    //   163: astore 11
    //   165: aload_0
    //   166: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   169: getfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   172: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   175: ifne +655 -> 830
    //   178: aload 13
    //   180: astore 11
    //   182: aload_0
    //   183: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   186: getfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   189: ldc 99
    //   191: invokevirtual 104	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   194: ifeq +636 -> 830
    //   197: aload 10
    //   199: ifnonnull +638 -> 837
    //   202: aload 10
    //   204: astore 11
    //   206: ldc 23
    //   208: ldc 106
    //   210: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 10
    //   215: astore 11
    //   217: aload_0
    //   218: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   221: sipush 703
    //   224: putfield 110	com/tencent/mm/plugin/music/f/c:dUg	I
    //   227: aload 10
    //   229: astore 11
    //   231: aload_0
    //   232: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   235: iconst_1
    //   236: invokevirtual 56	com/tencent/mm/plugin/music/f/c:hS	(Z)V
    //   239: aload 10
    //   241: astore 11
    //   243: aload_0
    //   244: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   247: invokestatic 113	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   250: return
    //   251: astore 10
    //   253: ldc 23
    //   255: aload 10
    //   257: ldc 115
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 119	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: aload_0
    //   267: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   270: sipush 705
    //   273: putfield 110	com/tencent/mm/plugin/music/f/c:dUg	I
    //   276: aload 11
    //   278: astore 10
    //   280: aload_0
    //   281: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   284: aload_0
    //   285: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   288: getfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   291: invokestatic 125	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   294: putfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   297: aload_0
    //   298: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   301: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   304: aload 10
    //   306: aconst_null
    //   307: aconst_null
    //   308: iconst_0
    //   309: invokevirtual 133	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   312: aload_0
    //   313: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   316: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   319: invokevirtual 136	android/media/MediaCodec:start	()V
    //   322: aload_0
    //   323: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   326: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   329: invokevirtual 140	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   332: astore 12
    //   334: aload_0
    //   335: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   338: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   341: invokevirtual 143	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   344: astore 11
    //   346: ldc 23
    //   348: ldc 145
    //   350: iconst_5
    //   351: anewarray 4	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: aload 10
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: aload_0
    //   362: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   365: getfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   368: aastore
    //   369: dup
    //   370: iconst_2
    //   371: aload_0
    //   372: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   375: getfield 148	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   378: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: aastore
    //   382: dup
    //   383: iconst_3
    //   384: aload_0
    //   385: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   388: getfield 151	com/tencent/mm/plugin/music/f/c:channels	I
    //   391: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aastore
    //   395: dup
    //   396: iconst_4
    //   397: aload_0
    //   398: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   401: getfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   404: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: aastore
    //   408: invokestatic 162	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: aload_0
    //   412: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   415: getfield 63	com/tencent/mm/plugin/music/f/c:eIP	Landroid/media/MediaExtractor;
    //   418: iconst_0
    //   419: invokevirtual 165	android/media/MediaExtractor:selectTrack	(I)V
    //   422: new 167	android/media/MediaCodec$BufferInfo
    //   425: dup
    //   426: invokespecial 168	android/media/MediaCodec$BufferInfo:<init>	()V
    //   429: astore 13
    //   431: iconst_0
    //   432: istore_2
    //   433: iconst_0
    //   434: istore_1
    //   435: iconst_0
    //   436: istore_3
    //   437: aload_0
    //   438: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   441: getfield 172	com/tencent/mm/plugin/music/f/c:mAS	Lcom/tencent/mm/plugin/music/f/a/g;
    //   444: iconst_3
    //   445: putfield 177	com/tencent/mm/plugin/music/f/a/g:mAW	I
    //   448: aload_0
    //   449: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   452: invokevirtual 180	com/tencent/mm/plugin/music/f/c:onStart	()V
    //   455: aload 11
    //   457: astore 10
    //   459: iload_1
    //   460: ifne +999 -> 1459
    //   463: iload_3
    //   464: bipush 50
    //   466: if_icmpge +993 -> 1459
    //   469: aload_0
    //   470: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   473: invokevirtual 183	com/tencent/mm/plugin/music/f/c:bnI	()V
    //   476: aload_0
    //   477: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   480: invokevirtual 187	com/tencent/mm/plugin/music/f/c:bnE	()Z
    //   483: ifeq +976 -> 1459
    //   486: iload_3
    //   487: iconst_1
    //   488: iadd
    //   489: istore_3
    //   490: iload_2
    //   491: istore 4
    //   493: iload_2
    //   494: ifne +119 -> 613
    //   497: aload_0
    //   498: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   501: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   504: ldc2_w 188
    //   507: invokevirtual 193	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   510: istore 6
    //   512: iload 6
    //   514: iflt +522 -> 1036
    //   517: aload 12
    //   519: iload 6
    //   521: aaload
    //   522: astore 11
    //   524: aload_0
    //   525: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   528: getfield 63	com/tencent/mm/plugin/music/f/c:eIP	Landroid/media/MediaExtractor;
    //   531: aload 11
    //   533: iconst_0
    //   534: invokevirtual 197	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   537: istore 5
    //   539: iload 5
    //   541: ifge +422 -> 963
    //   544: ldc 23
    //   546: ldc 199
    //   548: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: iconst_1
    //   552: istore_2
    //   553: iconst_0
    //   554: istore 4
    //   556: aload_0
    //   557: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   560: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   563: astore 11
    //   565: aload_0
    //   566: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   569: getfield 202	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   572: lstore 7
    //   574: iload_2
    //   575: ifeq +1084 -> 1659
    //   578: iconst_4
    //   579: istore 5
    //   581: aload 11
    //   583: iload 6
    //   585: iconst_0
    //   586: iload 4
    //   588: lload 7
    //   590: iload 5
    //   592: invokevirtual 206	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   595: iload_2
    //   596: ifne +1057 -> 1653
    //   599: aload_0
    //   600: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   603: getfield 63	com/tencent/mm/plugin/music/f/c:eIP	Landroid/media/MediaExtractor;
    //   606: invokevirtual 209	android/media/MediaExtractor:advance	()Z
    //   609: pop
    //   610: goto +1043 -> 1653
    //   613: aload_0
    //   614: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   617: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   620: aload 13
    //   622: ldc2_w 188
    //   625: invokevirtual 213	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   628: istore 5
    //   630: iload 5
    //   632: iflt +608 -> 1240
    //   635: aload 13
    //   637: getfield 216	android/media/MediaCodec$BufferInfo:size	I
    //   640: ifle +1008 -> 1648
    //   643: iconst_0
    //   644: istore_2
    //   645: aload 10
    //   647: iload 5
    //   649: aaload
    //   650: astore 11
    //   652: aload 13
    //   654: getfield 216	android/media/MediaCodec$BufferInfo:size	I
    //   657: newarray byte
    //   659: astore 14
    //   661: aload 11
    //   663: aload 14
    //   665: invokevirtual 222	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   668: pop
    //   669: aload 11
    //   671: invokevirtual 226	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   674: pop
    //   675: aload 14
    //   677: arraylength
    //   678: ifle +526 -> 1204
    //   681: aload_0
    //   682: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   685: getfield 230	com/tencent/mm/plugin/music/f/c:awx	Landroid/media/AudioTrack;
    //   688: ifnonnull +499 -> 1187
    //   691: aload_0
    //   692: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   695: invokevirtual 233	com/tencent/mm/plugin/music/f/c:createAudioTrack	()Z
    //   698: ifne +479 -> 1177
    //   701: ldc 23
    //   703: ldc 235
    //   705: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: aload_0
    //   709: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   712: sipush 707
    //   715: putfield 110	com/tencent/mm/plugin/music/f/c:dUg	I
    //   718: aload_0
    //   719: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   722: iconst_1
    //   723: invokevirtual 56	com/tencent/mm/plugin/music/f/c:hS	(Z)V
    //   726: aload_0
    //   727: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   730: invokestatic 113	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   733: aload_0
    //   734: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   737: invokestatic 238	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   740: aload_0
    //   741: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   744: invokestatic 241	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   747: aload_0
    //   748: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   751: aconst_null
    //   752: putfield 41	com/tencent/mm/plugin/music/f/c:mAz	Ljava/lang/String;
    //   755: aload_0
    //   756: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   759: aconst_null
    //   760: putfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   763: aload_0
    //   764: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   767: iconst_0
    //   768: putfield 148	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   771: aload_0
    //   772: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   775: iconst_0
    //   776: putfield 151	com/tencent/mm/plugin/music/f/c:channels	I
    //   779: aload_0
    //   780: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   783: lconst_0
    //   784: putfield 202	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   787: aload_0
    //   788: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   791: lconst_0
    //   792: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   795: return
    //   796: astore 10
    //   798: ldc 23
    //   800: aload 10
    //   802: ldc 243
    //   804: iconst_0
    //   805: anewarray 4	java/lang/Object
    //   808: invokestatic 119	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   811: aload_0
    //   812: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   815: sipush 702
    //   818: putfield 110	com/tencent/mm/plugin/music/f/c:dUg	I
    //   821: aload_0
    //   822: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   825: iconst_1
    //   826: invokevirtual 56	com/tencent/mm/plugin/music/f/c:hS	(Z)V
    //   829: return
    //   830: iload_1
    //   831: iconst_1
    //   832: iadd
    //   833: istore_1
    //   834: goto -717 -> 117
    //   837: aload 10
    //   839: astore 11
    //   841: ldc 23
    //   843: ldc 245
    //   845: iconst_1
    //   846: anewarray 4	java/lang/Object
    //   849: dup
    //   850: iconst_0
    //   851: aload 10
    //   853: aastore
    //   854: invokestatic 162	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   857: aload 10
    //   859: astore 11
    //   861: aload_0
    //   862: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   865: aload 10
    //   867: ldc 247
    //   869: invokevirtual 251	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   872: putfield 148	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   875: aload 10
    //   877: astore 11
    //   879: aload_0
    //   880: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   883: aload 10
    //   885: ldc 253
    //   887: invokevirtual 251	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   890: putfield 151	com/tencent/mm/plugin/music/f/c:channels	I
    //   893: aload 10
    //   895: astore 11
    //   897: aload_0
    //   898: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   901: aload 10
    //   903: ldc 255
    //   905: invokevirtual 259	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   908: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   911: goto -631 -> 280
    //   914: astore 10
    //   916: ldc 23
    //   918: aload 10
    //   920: ldc_w 260
    //   923: iconst_0
    //   924: anewarray 4	java/lang/Object
    //   927: invokestatic 119	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   930: aload_0
    //   931: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   934: sipush 704
    //   937: putfield 110	com/tencent/mm/plugin/music/f/c:dUg	I
    //   940: aload_0
    //   941: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   944: iconst_1
    //   945: invokevirtual 56	com/tencent/mm/plugin/music/f/c:hS	(Z)V
    //   948: aload_0
    //   949: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   952: invokestatic 113	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   955: aload_0
    //   956: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   959: invokestatic 238	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   962: return
    //   963: aload_0
    //   964: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   967: aload_0
    //   968: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   971: getfield 63	com/tencent/mm/plugin/music/f/c:eIP	Landroid/media/MediaExtractor;
    //   974: invokevirtual 264	android/media/MediaExtractor:getSampleTime	()J
    //   977: putfield 202	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   980: aload_0
    //   981: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   984: getfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   987: lconst_0
    //   988: lcmp
    //   989: ifne +22 -> 1011
    //   992: iconst_0
    //   993: istore 4
    //   995: aload_0
    //   996: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   999: iload 4
    //   1001: invokevirtual 267	com/tencent/mm/plugin/music/f/c:uU	(I)V
    //   1004: iload 5
    //   1006: istore 4
    //   1008: goto -452 -> 556
    //   1011: ldc2_w 268
    //   1014: aload_0
    //   1015: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1018: getfield 202	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1021: lmul
    //   1022: aload_0
    //   1023: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1026: getfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1029: ldiv
    //   1030: l2i
    //   1031: istore 4
    //   1033: goto -38 -> 995
    //   1036: ldc 23
    //   1038: new 271	java/lang/StringBuilder
    //   1041: dup
    //   1042: ldc_w 273
    //   1045: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1048: iload 6
    //   1050: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1053: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1059: iload_2
    //   1060: istore 4
    //   1062: goto -449 -> 613
    //   1065: astore 10
    //   1067: ldc 23
    //   1069: aload 10
    //   1071: ldc_w 285
    //   1074: iconst_0
    //   1075: anewarray 4	java/lang/Object
    //   1078: invokestatic 119	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: aload_0
    //   1082: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1085: sipush 706
    //   1088: putfield 110	com/tencent/mm/plugin/music/f/c:dUg	I
    //   1091: aload_0
    //   1092: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1095: iconst_1
    //   1096: invokevirtual 56	com/tencent/mm/plugin/music/f/c:hS	(Z)V
    //   1099: aload_0
    //   1100: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1103: invokestatic 113	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1106: aload_0
    //   1107: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1110: invokestatic 238	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1113: aload_0
    //   1114: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1117: invokestatic 241	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1120: aload_0
    //   1121: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1124: aconst_null
    //   1125: putfield 41	com/tencent/mm/plugin/music/f/c:mAz	Ljava/lang/String;
    //   1128: aload_0
    //   1129: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1132: aconst_null
    //   1133: putfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   1136: aload_0
    //   1137: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1140: iconst_0
    //   1141: putfield 148	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   1144: aload_0
    //   1145: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1148: iconst_0
    //   1149: putfield 151	com/tencent/mm/plugin/music/f/c:channels	I
    //   1152: aload_0
    //   1153: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1156: lconst_0
    //   1157: putfield 202	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1160: aload_0
    //   1161: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1164: lconst_0
    //   1165: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1168: ldc 23
    //   1170: ldc_w 287
    //   1173: invokestatic 31	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1176: return
    //   1177: aload_0
    //   1178: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1181: getfield 230	com/tencent/mm/plugin/music/f/c:awx	Landroid/media/AudioTrack;
    //   1184: invokevirtual 292	android/media/AudioTrack:play	()V
    //   1187: aload_0
    //   1188: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1191: getfield 230	com/tencent/mm/plugin/music/f/c:awx	Landroid/media/AudioTrack;
    //   1194: aload 14
    //   1196: iconst_0
    //   1197: aload 14
    //   1199: arraylength
    //   1200: invokevirtual 296	android/media/AudioTrack:write	([BII)I
    //   1203: pop
    //   1204: aload_0
    //   1205: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1208: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   1211: iload 5
    //   1213: iconst_0
    //   1214: invokevirtual 300	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   1217: aload 13
    //   1219: getfield 303	android/media/MediaCodec$BufferInfo:flags	I
    //   1222: iconst_4
    //   1223: iand
    //   1224: ifeq +421 -> 1645
    //   1227: ldc 23
    //   1229: ldc_w 305
    //   1232: invokestatic 52	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1235: iconst_1
    //   1236: istore_1
    //   1237: goto +428 -> 1665
    //   1240: iload 5
    //   1242: bipush 253
    //   1244: if_icmpne +29 -> 1273
    //   1247: aload_0
    //   1248: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1251: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   1254: invokevirtual 143	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1257: astore 10
    //   1259: ldc 23
    //   1261: ldc_w 307
    //   1264: invokestatic 31	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1267: iload 4
    //   1269: istore_2
    //   1270: goto -811 -> 459
    //   1273: iload 5
    //   1275: bipush 254
    //   1277: if_icmpne +153 -> 1430
    //   1280: aload_0
    //   1281: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1284: getfield 129	com/tencent/mm/plugin/music/f/c:aFW	Landroid/media/MediaCodec;
    //   1287: invokevirtual 311	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1290: astore 11
    //   1292: ldc 23
    //   1294: new 271	java/lang/StringBuilder
    //   1297: dup
    //   1298: ldc_w 313
    //   1301: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1304: aload 11
    //   1306: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1309: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1312: invokestatic 31	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1315: aload_0
    //   1316: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1319: aload 11
    //   1321: ldc 247
    //   1323: invokevirtual 251	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1326: putfield 148	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   1329: aload_0
    //   1330: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1333: aload 11
    //   1335: ldc 253
    //   1337: invokevirtual 251	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1340: putfield 151	com/tencent/mm/plugin/music/f/c:channels	I
    //   1343: aload_0
    //   1344: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1347: invokestatic 241	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1350: iload 4
    //   1352: istore_2
    //   1353: goto -894 -> 459
    //   1356: astore 10
    //   1358: aload_0
    //   1359: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1362: invokestatic 113	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1365: aload_0
    //   1366: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1369: invokestatic 238	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1372: aload_0
    //   1373: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1376: invokestatic 241	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1379: aload_0
    //   1380: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1383: aconst_null
    //   1384: putfield 41	com/tencent/mm/plugin/music/f/c:mAz	Ljava/lang/String;
    //   1387: aload_0
    //   1388: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1391: aconst_null
    //   1392: putfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   1395: aload_0
    //   1396: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1399: iconst_0
    //   1400: putfield 148	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   1403: aload_0
    //   1404: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1407: iconst_0
    //   1408: putfield 151	com/tencent/mm/plugin/music/f/c:channels	I
    //   1411: aload_0
    //   1412: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1415: lconst_0
    //   1416: putfield 202	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1419: aload_0
    //   1420: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1423: lconst_0
    //   1424: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1427: aload 10
    //   1429: athrow
    //   1430: ldc 23
    //   1432: new 271	java/lang/StringBuilder
    //   1435: dup
    //   1436: ldc_w 318
    //   1439: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1442: iload 5
    //   1444: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokestatic 31	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1453: iload 4
    //   1455: istore_2
    //   1456: goto -997 -> 459
    //   1459: aload_0
    //   1460: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1463: getfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1466: ldc2_w 188
    //   1469: ldiv
    //   1470: aload_0
    //   1471: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1474: getfield 202	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1477: ldc2_w 188
    //   1480: ldiv
    //   1481: lsub
    //   1482: ldc2_w 319
    //   1485: lcmp
    //   1486: ifge +121 -> 1607
    //   1489: iconst_1
    //   1490: istore 9
    //   1492: iload_3
    //   1493: bipush 50
    //   1495: if_icmplt +118 -> 1613
    //   1498: ldc 23
    //   1500: ldc_w 322
    //   1503: iconst_1
    //   1504: anewarray 4	java/lang/Object
    //   1507: dup
    //   1508: iconst_0
    //   1509: iload_3
    //   1510: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1513: aastore
    //   1514: invokestatic 82	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1517: aload_0
    //   1518: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1521: sipush 706
    //   1524: putfield 110	com/tencent/mm/plugin/music/f/c:dUg	I
    //   1527: aload_0
    //   1528: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1531: iconst_1
    //   1532: invokevirtual 56	com/tencent/mm/plugin/music/f/c:hS	(Z)V
    //   1535: aload_0
    //   1536: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1539: invokestatic 113	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1542: aload_0
    //   1543: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1546: invokestatic 238	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1549: aload_0
    //   1550: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1553: invokestatic 241	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
    //   1556: aload_0
    //   1557: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1560: aconst_null
    //   1561: putfield 41	com/tencent/mm/plugin/music/f/c:mAz	Ljava/lang/String;
    //   1564: aload_0
    //   1565: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1568: aconst_null
    //   1569: putfield 97	com/tencent/mm/plugin/music/f/c:jkV	Ljava/lang/String;
    //   1572: aload_0
    //   1573: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1576: iconst_0
    //   1577: putfield 148	com/tencent/mm/plugin/music/f/c:sampleRate	I
    //   1580: aload_0
    //   1581: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1584: iconst_0
    //   1585: putfield 151	com/tencent/mm/plugin/music/f/c:channels	I
    //   1588: aload_0
    //   1589: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1592: lconst_0
    //   1593: putfield 202	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
    //   1596: aload_0
    //   1597: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1600: lconst_0
    //   1601: putfield 155	com/tencent/mm/plugin/music/f/c:duration	J
    //   1604: goto -436 -> 1168
    //   1607: iconst_0
    //   1608: istore 9
    //   1610: goto -118 -> 1492
    //   1613: ldc 23
    //   1615: ldc_w 324
    //   1618: iconst_1
    //   1619: anewarray 4	java/lang/Object
    //   1622: dup
    //   1623: iconst_0
    //   1624: iload 9
    //   1626: invokestatic 329	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1629: aastore
    //   1630: invokestatic 162	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1633: aload_0
    //   1634: getfield 14	com/tencent/mm/plugin/music/f/c$1:mAB	Lcom/tencent/mm/plugin/music/f/c;
    //   1637: iload 9
    //   1639: invokevirtual 332	com/tencent/mm/plugin/music/f/c:hT	(Z)V
    //   1642: goto -107 -> 1535
    //   1645: goto +20 -> 1665
    //   1648: iload_3
    //   1649: istore_2
    //   1650: goto -1005 -> 645
    //   1653: iload_2
    //   1654: istore 4
    //   1656: goto -1043 -> 613
    //   1659: iconst_0
    //   1660: istore 5
    //   1662: goto -1081 -> 581
    //   1665: iload_2
    //   1666: istore_3
    //   1667: iload 4
    //   1669: istore_2
    //   1670: goto -1211 -> 459
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1673	0	this	1
    //   116	1121	1	i	int
    //   92	1578	2	j	int
    //   436	1231	3	k	int
    //   491	1177	4	m	int
    //   537	1124	5	n	int
    //   510	539	6	i1	int
    //   572	17	7	l	long
    //   1490	148	9	bool	boolean
    //   119	121	10	localObject1	Object
    //   251	5	10	localException1	java.lang.Exception
    //   278	368	10	localObject2	Object
    //   796	106	10	localException2	java.lang.Exception
    //   914	5	10	localException3	java.lang.Exception
    //   1065	5	10	localException4	java.lang.Exception
    //   1257	1	10	arrayOfByteBuffer1	java.nio.ByteBuffer[]
    //   1356	72	10	localObject3	Object
    //   80	1254	11	localObject4	Object
    //   76	442	12	arrayOfByteBuffer2	java.nio.ByteBuffer[]
    //   73	1145	13	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   659	539	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   82	93	251	java/lang/Exception
    //   97	115	251	java/lang/Exception
    //   130	143	251	java/lang/Exception
    //   147	161	251	java/lang/Exception
    //   165	178	251	java/lang/Exception
    //   182	197	251	java/lang/Exception
    //   206	213	251	java/lang/Exception
    //   217	227	251	java/lang/Exception
    //   231	239	251	java/lang/Exception
    //   243	250	251	java/lang/Exception
    //   841	857	251	java/lang/Exception
    //   861	875	251	java/lang/Exception
    //   879	893	251	java/lang/Exception
    //   897	911	251	java/lang/Exception
    //   55	72	796	java/lang/Exception
    //   280	322	914	java/lang/Exception
    //   469	486	1065	java/lang/Exception
    //   497	512	1065	java/lang/Exception
    //   524	539	1065	java/lang/Exception
    //   544	551	1065	java/lang/Exception
    //   556	574	1065	java/lang/Exception
    //   581	595	1065	java/lang/Exception
    //   599	610	1065	java/lang/Exception
    //   613	630	1065	java/lang/Exception
    //   635	643	1065	java/lang/Exception
    //   652	726	1065	java/lang/Exception
    //   963	992	1065	java/lang/Exception
    //   995	1004	1065	java/lang/Exception
    //   1011	1033	1065	java/lang/Exception
    //   1036	1059	1065	java/lang/Exception
    //   1177	1187	1065	java/lang/Exception
    //   1187	1204	1065	java/lang/Exception
    //   1204	1235	1065	java/lang/Exception
    //   1247	1267	1065	java/lang/Exception
    //   1280	1350	1065	java/lang/Exception
    //   1430	1453	1065	java/lang/Exception
    //   1459	1489	1065	java/lang/Exception
    //   1498	1535	1065	java/lang/Exception
    //   1613	1642	1065	java/lang/Exception
    //   469	486	1356	finally
    //   497	512	1356	finally
    //   524	539	1356	finally
    //   544	551	1356	finally
    //   556	574	1356	finally
    //   581	595	1356	finally
    //   599	610	1356	finally
    //   613	630	1356	finally
    //   635	643	1356	finally
    //   652	726	1356	finally
    //   963	992	1356	finally
    //   995	1004	1356	finally
    //   1011	1033	1356	finally
    //   1036	1059	1356	finally
    //   1067	1099	1356	finally
    //   1177	1187	1356	finally
    //   1187	1204	1356	finally
    //   1204	1235	1356	finally
    //   1247	1267	1356	finally
    //   1280	1350	1356	finally
    //   1430	1453	1356	finally
    //   1459	1489	1356	finally
    //   1498	1535	1356	finally
    //   1613	1642	1356	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.c.1
 * JD-Core Version:    0.7.0.1
 */