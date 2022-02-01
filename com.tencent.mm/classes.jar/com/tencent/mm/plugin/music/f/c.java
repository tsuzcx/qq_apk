package com.tencent.mm.plugin.music.f;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.music.f.a.g;
import com.tencent.mm.sdk.platformtools.ac;

@TargetApi(16)
public final class c
  extends com.tencent.mm.plugin.music.f.a.b
{
  AudioTrack aUW;
  int cRY;
  com.tencent.mm.compatible.h.c cSi;
  z cSj;
  int channels;
  long duration;
  String mime;
  long presentationTimeUs;
  int sampleRate;
  String sourcePath;
  private boolean stop;
  private Runnable vgE;
  
  public c()
  {
    AppMethodBeat.i(137313);
    this.stop = true;
    this.mime = null;
    this.sampleRate = 0;
    this.channels = 0;
    this.presentationTimeUs = 0L;
    this.duration = 0L;
    this.cRY = 0;
    this.vgE = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 30
        //   7: ldc 32
        //   9: invokestatic 37	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   12: bipush 237
        //   14: invokestatic 42	android/os/Process:setThreadPriority	(I)V
        //   17: aload_0
        //   18: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   21: getfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   24: invokestatic 52	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
        //   27: ifeq +24 -> 51
        //   30: ldc 30
        //   32: ldc 54
        //   34: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   37: aload_0
        //   38: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   41: iconst_0
        //   42: invokevirtual 61	com/tencent/mm/plugin/music/f/c:oE	(Z)V
        //   45: ldc 22
        //   47: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   50: return
        //   51: aload_0
        //   52: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   55: new 66	com/tencent/mm/compatible/h/c
        //   58: dup
        //   59: invokespecial 67	com/tencent/mm/compatible/h/c:<init>	()V
        //   62: putfield 71	com/tencent/mm/plugin/music/f/c:cSi	Lcom/tencent/mm/compatible/h/c;
        //   65: aload_0
        //   66: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   69: getfield 71	com/tencent/mm/plugin/music/f/c:cSi	Lcom/tencent/mm/compatible/h/c;
        //   72: aload_0
        //   73: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   76: getfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   79: invokevirtual 75	com/tencent/mm/compatible/h/c:sI	(Ljava/lang/String;)V
        //   82: aconst_null
        //   83: astore 13
        //   85: aconst_null
        //   86: astore 12
        //   88: aload 13
        //   90: astore 11
        //   92: aload_0
        //   93: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   96: getfield 71	com/tencent/mm/plugin/music/f/c:cSi	Lcom/tencent/mm/compatible/h/c;
        //   99: getfield 79	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
        //   102: invokevirtual 85	android/media/MediaExtractor:getTrackCount	()I
        //   105: istore_2
        //   106: aload 13
        //   108: astore 11
        //   110: ldc 30
        //   112: ldc 87
        //   114: iconst_1
        //   115: anewarray 4	java/lang/Object
        //   118: dup
        //   119: iconst_0
        //   120: iload_2
        //   121: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   124: aastore
        //   125: invokestatic 96	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   128: iconst_0
        //   129: istore_1
        //   130: aload 12
        //   132: astore 10
        //   134: iload_1
        //   135: iload_2
        //   136: if_icmpge +74 -> 210
        //   139: aload 13
        //   141: astore 11
        //   143: aload_0
        //   144: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   147: getfield 71	com/tencent/mm/plugin/music/f/c:cSi	Lcom/tencent/mm/compatible/h/c;
        //   150: iload_1
        //   151: invokevirtual 100	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
        //   154: astore 10
        //   156: aload 13
        //   158: astore 11
        //   160: aload_0
        //   161: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   164: aload 10
        //   166: ldc 102
        //   168: invokevirtual 108	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   171: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   174: aload 13
        //   176: astore 11
        //   178: aload_0
        //   179: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   182: getfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   185: invokestatic 52	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
        //   188: ifne +120 -> 308
        //   191: aload 13
        //   193: astore 11
        //   195: aload_0
        //   196: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   199: getfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   202: ldc 112
        //   204: invokevirtual 117	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   207: ifeq +101 -> 308
        //   210: aload 10
        //   212: ifnonnull +103 -> 315
        //   215: aload 10
        //   217: astore 11
        //   219: ldc 30
        //   221: ldc 119
        //   223: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   226: aload 10
        //   228: astore 11
        //   230: aload_0
        //   231: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   234: sipush 703
        //   237: putfield 123	com/tencent/mm/plugin/music/f/c:cRY	I
        //   240: aload 10
        //   242: astore 11
        //   244: aload_0
        //   245: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   248: iconst_1
        //   249: invokevirtual 61	com/tencent/mm/plugin/music/f/c:oE	(Z)V
        //   252: aload 10
        //   254: astore 11
        //   256: aload_0
        //   257: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   260: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   263: ldc 22
        //   265: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   268: return
        //   269: astore 10
        //   271: ldc 30
        //   273: aload 10
        //   275: ldc 128
        //   277: iconst_0
        //   278: anewarray 4	java/lang/Object
        //   281: invokestatic 132	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   284: aload_0
        //   285: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   288: sipush 702
        //   291: putfield 123	com/tencent/mm/plugin/music/f/c:cRY	I
        //   294: aload_0
        //   295: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   298: iconst_1
        //   299: invokevirtual 61	com/tencent/mm/plugin/music/f/c:oE	(Z)V
        //   302: ldc 22
        //   304: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   307: return
        //   308: iload_1
        //   309: iconst_1
        //   310: iadd
        //   311: istore_1
        //   312: goto -182 -> 130
        //   315: aload 10
        //   317: astore 11
        //   319: ldc 30
        //   321: ldc 134
        //   323: iconst_1
        //   324: anewarray 4	java/lang/Object
        //   327: dup
        //   328: iconst_0
        //   329: aload 10
        //   331: aastore
        //   332: invokestatic 136	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   335: aload 10
        //   337: astore 11
        //   339: aload_0
        //   340: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   343: aload 10
        //   345: ldc 138
        //   347: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   350: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   353: aload 10
        //   355: astore 11
        //   357: aload_0
        //   358: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   361: aload 10
        //   363: ldc 147
        //   365: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   368: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   371: aload 10
        //   373: astore 11
        //   375: aload_0
        //   376: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   379: aload 10
        //   381: ldc 152
        //   383: invokevirtual 156	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
        //   386: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   389: aload_0
        //   390: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   393: aload_0
        //   394: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   397: getfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   400: invokestatic 166	com/tencent/mm/compatible/deviceinfo/z:sx	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
        //   403: putfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   406: aload_0
        //   407: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   410: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   413: aload 10
        //   415: aconst_null
        //   416: iconst_0
        //   417: invokevirtual 173	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
        //   420: aload_0
        //   421: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   424: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   427: invokevirtual 176	com/tencent/mm/compatible/deviceinfo/z:start	()V
        //   430: aload_0
        //   431: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   434: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   437: invokevirtual 180	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
        //   440: astore 12
        //   442: aload_0
        //   443: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   446: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   449: invokevirtual 183	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
        //   452: astore 11
        //   454: ldc 30
        //   456: ldc 185
        //   458: iconst_5
        //   459: anewarray 4	java/lang/Object
        //   462: dup
        //   463: iconst_0
        //   464: aload 10
        //   466: aastore
        //   467: dup
        //   468: iconst_1
        //   469: aload_0
        //   470: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   473: getfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   476: aastore
        //   477: dup
        //   478: iconst_2
        //   479: aload_0
        //   480: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   483: getfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   486: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   489: aastore
        //   490: dup
        //   491: iconst_3
        //   492: aload_0
        //   493: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   496: getfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   499: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   502: aastore
        //   503: dup
        //   504: iconst_4
        //   505: aload_0
        //   506: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   509: getfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   512: invokestatic 190	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   515: aastore
        //   516: invokestatic 136	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   519: aload_0
        //   520: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   523: getfield 71	com/tencent/mm/plugin/music/f/c:cSi	Lcom/tencent/mm/compatible/h/c;
        //   526: iconst_0
        //   527: invokevirtual 193	com/tencent/mm/compatible/h/c:selectTrack	(I)V
        //   530: new 195	android/media/MediaCodec$BufferInfo
        //   533: dup
        //   534: invokespecial 196	android/media/MediaCodec$BufferInfo:<init>	()V
        //   537: astore 13
        //   539: iconst_0
        //   540: istore_3
        //   541: iconst_0
        //   542: istore_2
        //   543: aload_0
        //   544: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   547: getfield 200	com/tencent/mm/plugin/music/f/c:vgX	Lcom/tencent/mm/plugin/music/f/a/g;
        //   550: iconst_3
        //   551: putfield 205	com/tencent/mm/plugin/music/f/a/g:smv	I
        //   554: aload_0
        //   555: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   558: invokevirtual 208	com/tencent/mm/plugin/music/f/c:onStart	()V
        //   561: iconst_0
        //   562: istore_1
        //   563: aload 11
        //   565: astore 10
        //   567: iload_3
        //   568: ifne +707 -> 1275
        //   571: iload_2
        //   572: bipush 50
        //   574: if_icmpge +701 -> 1275
        //   577: aload_0
        //   578: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   581: invokevirtual 211	com/tencent/mm/plugin/music/f/c:djl	()V
        //   584: aload_0
        //   585: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   588: invokevirtual 215	com/tencent/mm/plugin/music/f/c:dji	()Z
        //   591: ifeq +684 -> 1275
        //   594: iload_2
        //   595: iconst_1
        //   596: iadd
        //   597: istore_2
        //   598: iload_1
        //   599: ifne +1070 -> 1669
        //   602: aload_0
        //   603: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   606: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   609: ldc2_w 216
        //   612: invokevirtual 221	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
        //   615: istore 6
        //   617: iload 6
        //   619: iflt +452 -> 1071
        //   622: aload 12
        //   624: iload 6
        //   626: aaload
        //   627: astore 11
        //   629: aload_0
        //   630: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   633: getfield 71	com/tencent/mm/plugin/music/f/c:cSi	Lcom/tencent/mm/compatible/h/c;
        //   636: aload 11
        //   638: invokevirtual 225	com/tencent/mm/compatible/h/c:j	(Ljava/nio/ByteBuffer;)I
        //   641: istore 5
        //   643: iload 5
        //   645: ifge +350 -> 995
        //   648: ldc 30
        //   650: ldc 227
        //   652: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   655: iconst_1
        //   656: istore_1
        //   657: iconst_0
        //   658: istore 4
        //   660: aload_0
        //   661: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   664: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   667: astore 11
        //   669: aload_0
        //   670: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   673: getfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   676: lstore 7
        //   678: iload_1
        //   679: ifeq +984 -> 1663
        //   682: iconst_4
        //   683: istore 5
        //   685: aload 11
        //   687: iload 6
        //   689: iload 4
        //   691: lload 7
        //   693: iload 5
        //   695: invokevirtual 233	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
        //   698: iload_1
        //   699: ifne +961 -> 1660
        //   702: aload_0
        //   703: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   706: getfield 71	com/tencent/mm/plugin/music/f/c:cSi	Lcom/tencent/mm/compatible/h/c;
        //   709: getfield 79	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
        //   712: invokevirtual 236	android/media/MediaExtractor:advance	()Z
        //   715: pop
        //   716: goto +944 -> 1660
        //   719: aload_0
        //   720: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   723: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   726: aload 13
        //   728: ldc2_w 216
        //   731: invokevirtual 240	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
        //   734: istore 4
        //   736: iload 4
        //   738: iflt +415 -> 1153
        //   741: aload 13
        //   743: getfield 243	android/media/MediaCodec$BufferInfo:size	I
        //   746: ifle +911 -> 1657
        //   749: iconst_0
        //   750: istore_2
        //   751: aload 10
        //   753: iload 4
        //   755: aaload
        //   756: astore 11
        //   758: aload 13
        //   760: getfield 243	android/media/MediaCodec$BufferInfo:size	I
        //   763: newarray byte
        //   765: astore 14
        //   767: aload 11
        //   769: aload 14
        //   771: invokevirtual 249	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
        //   774: pop
        //   775: aload 11
        //   777: invokevirtual 253	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
        //   780: pop
        //   781: aload 14
        //   783: arraylength
        //   784: ifle +333 -> 1117
        //   787: aload_0
        //   788: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   791: getfield 257	com/tencent/mm/plugin/music/f/c:aUW	Landroid/media/AudioTrack;
        //   794: ifnonnull +306 -> 1100
        //   797: aload_0
        //   798: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   801: invokevirtual 260	com/tencent/mm/plugin/music/f/c:createAudioTrack	()Z
        //   804: ifne +286 -> 1090
        //   807: ldc 30
        //   809: ldc_w 262
        //   812: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   815: aload_0
        //   816: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   819: sipush 707
        //   822: putfield 123	com/tencent/mm/plugin/music/f/c:cRY	I
        //   825: aload_0
        //   826: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   829: iconst_1
        //   830: invokevirtual 61	com/tencent/mm/plugin/music/f/c:oE	(Z)V
        //   833: aload_0
        //   834: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   837: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   840: aload_0
        //   841: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   844: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   847: aload_0
        //   848: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   851: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   854: aload_0
        //   855: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   858: aconst_null
        //   859: putfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   862: aload_0
        //   863: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   866: aconst_null
        //   867: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   870: aload_0
        //   871: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   874: iconst_0
        //   875: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   878: aload_0
        //   879: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   882: iconst_0
        //   883: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   886: aload_0
        //   887: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   890: lconst_0
        //   891: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   894: aload_0
        //   895: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   898: lconst_0
        //   899: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   902: ldc 22
        //   904: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   907: return
        //   908: astore 10
        //   910: ldc 30
        //   912: aload 10
        //   914: ldc_w 270
        //   917: iconst_0
        //   918: anewarray 4	java/lang/Object
        //   921: invokestatic 132	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   924: aload_0
        //   925: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   928: sipush 705
        //   931: putfield 123	com/tencent/mm/plugin/music/f/c:cRY	I
        //   934: aload 11
        //   936: astore 10
        //   938: goto -549 -> 389
        //   941: astore 10
        //   943: ldc 30
        //   945: aload 10
        //   947: ldc_w 272
        //   950: iconst_0
        //   951: anewarray 4	java/lang/Object
        //   954: invokestatic 132	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   957: aload_0
        //   958: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   961: sipush 704
        //   964: putfield 123	com/tencent/mm/plugin/music/f/c:cRY	I
        //   967: aload_0
        //   968: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   971: iconst_1
        //   972: invokevirtual 61	com/tencent/mm/plugin/music/f/c:oE	(Z)V
        //   975: aload_0
        //   976: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   979: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   982: aload_0
        //   983: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   986: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   989: ldc 22
        //   991: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   994: return
        //   995: aload_0
        //   996: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   999: aload_0
        //   1000: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1003: getfield 71	com/tencent/mm/plugin/music/f/c:cSi	Lcom/tencent/mm/compatible/h/c;
        //   1006: getfield 79	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
        //   1009: invokevirtual 276	android/media/MediaExtractor:getSampleTime	()J
        //   1012: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1015: aload_0
        //   1016: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1019: getfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1022: lconst_0
        //   1023: lcmp
        //   1024: ifne +22 -> 1046
        //   1027: iconst_0
        //   1028: istore 4
        //   1030: aload_0
        //   1031: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1034: iload 4
        //   1036: invokevirtual 279	com/tencent/mm/plugin/music/f/c:JX	(I)V
        //   1039: iload 5
        //   1041: istore 4
        //   1043: goto -383 -> 660
        //   1046: ldc2_w 280
        //   1049: aload_0
        //   1050: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1053: getfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1056: lmul
        //   1057: aload_0
        //   1058: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1061: getfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1064: ldiv
        //   1065: l2i
        //   1066: istore 4
        //   1068: goto -38 -> 1030
        //   1071: ldc 30
        //   1073: ldc_w 283
        //   1076: iload 6
        //   1078: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   1081: invokevirtual 289	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1084: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1087: goto +582 -> 1669
        //   1090: aload_0
        //   1091: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1094: getfield 257	com/tencent/mm/plugin/music/f/c:aUW	Landroid/media/AudioTrack;
        //   1097: invokevirtual 294	android/media/AudioTrack:play	()V
        //   1100: aload_0
        //   1101: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1104: getfield 257	com/tencent/mm/plugin/music/f/c:aUW	Landroid/media/AudioTrack;
        //   1107: aload 14
        //   1109: iconst_0
        //   1110: aload 14
        //   1112: arraylength
        //   1113: invokevirtual 298	android/media/AudioTrack:write	([BII)I
        //   1116: pop
        //   1117: aload_0
        //   1118: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1121: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   1124: iload 4
        //   1126: iconst_0
        //   1127: invokevirtual 302	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
        //   1130: aload 13
        //   1132: getfield 305	android/media/MediaCodec$BufferInfo:flags	I
        //   1135: iconst_4
        //   1136: iand
        //   1137: ifeq +535 -> 1672
        //   1140: ldc 30
        //   1142: ldc_w 307
        //   1145: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1148: iconst_1
        //   1149: istore_3
        //   1150: goto +522 -> 1672
        //   1153: iload 4
        //   1155: bipush 253
        //   1157: if_icmpne +26 -> 1183
        //   1160: aload_0
        //   1161: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1164: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   1167: invokevirtual 183	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
        //   1170: astore 10
        //   1172: ldc 30
        //   1174: ldc_w 309
        //   1177: invokestatic 37	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1180: goto -613 -> 567
        //   1183: iload 4
        //   1185: bipush 254
        //   1187: if_icmpne +69 -> 1256
        //   1190: aload_0
        //   1191: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1194: getfield 170	com/tencent/mm/plugin/music/f/c:cSj	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   1197: invokevirtual 313	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
        //   1200: astore 11
        //   1202: ldc 30
        //   1204: ldc_w 315
        //   1207: aload 11
        //   1209: invokestatic 318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   1212: invokevirtual 289	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1215: invokestatic 37	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1218: aload_0
        //   1219: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1222: aload 11
        //   1224: ldc 138
        //   1226: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   1229: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   1232: aload_0
        //   1233: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1236: aload 11
        //   1238: ldc 147
        //   1240: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   1243: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   1246: aload_0
        //   1247: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1250: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1253: goto -686 -> 567
        //   1256: ldc 30
        //   1258: ldc_w 320
        //   1261: iload 4
        //   1263: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   1266: invokevirtual 289	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1269: invokestatic 37	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1272: goto -705 -> 567
        //   1275: aload_0
        //   1276: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1279: getfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1282: ldc2_w 216
        //   1285: ldiv
        //   1286: aload_0
        //   1287: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1290: getfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1293: ldc2_w 216
        //   1296: ldiv
        //   1297: lsub
        //   1298: ldc2_w 321
        //   1301: lcmp
        //   1302: ifge +132 -> 1434
        //   1305: iconst_1
        //   1306: istore 9
        //   1308: iload_2
        //   1309: bipush 50
        //   1311: if_icmplt +129 -> 1440
        //   1314: ldc 30
        //   1316: ldc_w 324
        //   1319: iconst_1
        //   1320: anewarray 4	java/lang/Object
        //   1323: dup
        //   1324: iconst_0
        //   1325: iload_2
        //   1326: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1329: aastore
        //   1330: invokestatic 96	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1333: aload_0
        //   1334: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1337: sipush 706
        //   1340: putfield 123	com/tencent/mm/plugin/music/f/c:cRY	I
        //   1343: aload_0
        //   1344: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1347: iconst_1
        //   1348: invokevirtual 61	com/tencent/mm/plugin/music/f/c:oE	(Z)V
        //   1351: aload_0
        //   1352: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1355: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1358: aload_0
        //   1359: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1362: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1365: aload_0
        //   1366: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1369: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1372: aload_0
        //   1373: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1376: aconst_null
        //   1377: putfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   1380: aload_0
        //   1381: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1384: aconst_null
        //   1385: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   1388: aload_0
        //   1389: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1392: iconst_0
        //   1393: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   1396: aload_0
        //   1397: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1400: iconst_0
        //   1401: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   1404: aload_0
        //   1405: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1408: lconst_0
        //   1409: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1412: aload_0
        //   1413: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1416: lconst_0
        //   1417: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1420: ldc 30
        //   1422: ldc_w 326
        //   1425: invokestatic 37	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1428: ldc 22
        //   1430: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1433: return
        //   1434: iconst_0
        //   1435: istore 9
        //   1437: goto -129 -> 1308
        //   1440: ldc 30
        //   1442: ldc_w 328
        //   1445: iconst_1
        //   1446: anewarray 4	java/lang/Object
        //   1449: dup
        //   1450: iconst_0
        //   1451: iload 9
        //   1453: invokestatic 333	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   1456: aastore
        //   1457: invokestatic 136	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1460: aload_0
        //   1461: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1464: iload 9
        //   1466: invokevirtual 336	com/tencent/mm/plugin/music/f/c:oF	(Z)V
        //   1469: goto -118 -> 1351
        //   1472: astore 10
        //   1474: ldc 30
        //   1476: aload 10
        //   1478: ldc_w 338
        //   1481: iconst_0
        //   1482: anewarray 4	java/lang/Object
        //   1485: invokestatic 132	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1488: aload_0
        //   1489: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1492: sipush 706
        //   1495: putfield 123	com/tencent/mm/plugin/music/f/c:cRY	I
        //   1498: aload_0
        //   1499: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1502: iconst_1
        //   1503: invokevirtual 61	com/tencent/mm/plugin/music/f/c:oE	(Z)V
        //   1506: aload_0
        //   1507: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1510: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1513: aload_0
        //   1514: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1517: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1520: aload_0
        //   1521: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1524: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1527: aload_0
        //   1528: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1531: aconst_null
        //   1532: putfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   1535: aload_0
        //   1536: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1539: aconst_null
        //   1540: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   1543: aload_0
        //   1544: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1547: iconst_0
        //   1548: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   1551: aload_0
        //   1552: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1555: iconst_0
        //   1556: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   1559: aload_0
        //   1560: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1563: lconst_0
        //   1564: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1567: aload_0
        //   1568: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1571: lconst_0
        //   1572: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1575: goto -155 -> 1420
        //   1578: astore 10
        //   1580: aload_0
        //   1581: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1584: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1587: aload_0
        //   1588: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1591: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1594: aload_0
        //   1595: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1598: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1601: aload_0
        //   1602: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1605: aconst_null
        //   1606: putfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   1609: aload_0
        //   1610: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1613: aconst_null
        //   1614: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   1617: aload_0
        //   1618: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1621: iconst_0
        //   1622: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   1625: aload_0
        //   1626: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1629: iconst_0
        //   1630: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   1633: aload_0
        //   1634: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1637: lconst_0
        //   1638: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1641: aload_0
        //   1642: getfield 14	com/tencent/mm/plugin/music/f/c$1:vgF	Lcom/tencent/mm/plugin/music/f/c;
        //   1645: lconst_0
        //   1646: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1649: ldc 22
        //   1651: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1654: aload 10
        //   1656: athrow
        //   1657: goto -906 -> 751
        //   1660: goto -941 -> 719
        //   1663: iconst_0
        //   1664: istore 5
        //   1666: goto -981 -> 685
        //   1669: goto -950 -> 719
        //   1672: goto -1105 -> 567
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1675	0	this	1
        //   129	570	1	i	int
        //   105	1221	2	j	int
        //   540	610	3	k	int
        //   658	604	4	m	int
        //   641	1024	5	n	int
        //   615	462	6	i1	int
        //   676	16	7	l	long
        //   1306	159	9	bool	boolean
        //   132	121	10	localObject1	Object
        //   269	196	10	localException1	Exception
        //   565	187	10	localObject2	Object
        //   908	5	10	localException2	Exception
        //   936	1	10	localObject3	Object
        //   941	5	10	localException3	Exception
        //   1170	1	10	arrayOfByteBuffer1	java.nio.ByteBuffer[]
        //   1472	5	10	localException4	Exception
        //   1578	77	10	localObject4	Object
        //   90	1147	11	localObject5	Object
        //   86	537	12	arrayOfByteBuffer2	java.nio.ByteBuffer[]
        //   83	1048	13	localBufferInfo	android.media.MediaCodec.BufferInfo
        //   765	346	14	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   65	82	269	java/lang/Exception
        //   92	106	908	java/lang/Exception
        //   110	128	908	java/lang/Exception
        //   143	156	908	java/lang/Exception
        //   160	174	908	java/lang/Exception
        //   178	191	908	java/lang/Exception
        //   195	210	908	java/lang/Exception
        //   219	226	908	java/lang/Exception
        //   230	240	908	java/lang/Exception
        //   244	252	908	java/lang/Exception
        //   256	263	908	java/lang/Exception
        //   319	335	908	java/lang/Exception
        //   339	353	908	java/lang/Exception
        //   357	371	908	java/lang/Exception
        //   375	389	908	java/lang/Exception
        //   389	430	941	java/lang/Exception
        //   577	594	1472	java/lang/Exception
        //   602	617	1472	java/lang/Exception
        //   629	643	1472	java/lang/Exception
        //   648	655	1472	java/lang/Exception
        //   660	678	1472	java/lang/Exception
        //   685	698	1472	java/lang/Exception
        //   702	716	1472	java/lang/Exception
        //   719	736	1472	java/lang/Exception
        //   741	749	1472	java/lang/Exception
        //   758	833	1472	java/lang/Exception
        //   995	1027	1472	java/lang/Exception
        //   1030	1039	1472	java/lang/Exception
        //   1046	1068	1472	java/lang/Exception
        //   1071	1087	1472	java/lang/Exception
        //   1090	1100	1472	java/lang/Exception
        //   1100	1117	1472	java/lang/Exception
        //   1117	1130	1472	java/lang/Exception
        //   1130	1148	1472	java/lang/Exception
        //   1160	1180	1472	java/lang/Exception
        //   1190	1253	1472	java/lang/Exception
        //   1256	1272	1472	java/lang/Exception
        //   1275	1305	1472	java/lang/Exception
        //   1314	1351	1472	java/lang/Exception
        //   1440	1469	1472	java/lang/Exception
        //   577	594	1578	finally
        //   602	617	1578	finally
        //   629	643	1578	finally
        //   648	655	1578	finally
        //   660	678	1578	finally
        //   685	698	1578	finally
        //   702	716	1578	finally
        //   719	736	1578	finally
        //   741	749	1578	finally
        //   758	833	1578	finally
        //   995	1027	1578	finally
        //   1030	1039	1578	finally
        //   1046	1068	1578	finally
        //   1071	1087	1578	finally
        //   1090	1100	1578	finally
        //   1100	1117	1578	finally
        //   1117	1130	1578	finally
        //   1130	1148	1578	finally
        //   1160	1180	1578	finally
        //   1190	1253	1578	finally
        //   1256	1272	1578	finally
        //   1275	1305	1578	finally
        //   1314	1351	1578	finally
        //   1440	1469	1578	finally
        //   1474	1506	1578	finally
      }
    };
    AppMethodBeat.o(137313);
  }
  
  private void NP()
  {
    try
    {
      AppMethodBeat.i(137316);
      ac.i("MicroMsg.Music.MMPlayer", "sync notify");
      try
      {
        notify();
        AppMethodBeat.o(137316);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.Music.MMPlayer", localException, "syncNotify", new Object[0]);
          AppMethodBeat.o(137316);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void anM(String paramString)
  {
    this.sourcePath = paramString;
  }
  
  final boolean createAudioTrack()
  {
    AppMethodBeat.i(137314);
    ac.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
    int i;
    if (this.channels == 1) {
      i = 4;
    }
    for (;;)
    {
      int j = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
      com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.b.class);
      if (localb != null)
      {
        this.aUW = localb.am(this.sampleRate, i, j);
        label61:
        if (this.aUW == null)
        {
          ac.e("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
          this.aUW = new AudioTrack(3, this.sampleRate, i, 2, j, 1);
        }
        if ((this.aUW != null) && (this.aUW.getState() == 1)) {
          break label157;
        }
        ac.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
        if (this.aUW == null) {}
      }
      try
      {
        this.aUW.release();
        label134:
        AppMethodBeat.o(137314);
        return false;
        i = 12;
        continue;
        ac.e("MicroMsg.Music.MMPlayer", "mediaResService null");
        break label61;
        label157:
        AppMethodBeat.o(137314);
        return true;
      }
      catch (Exception localException)
      {
        break label134;
      }
    }
  }
  
  public final boolean dji()
  {
    return !this.stop;
  }
  
  public final int djj()
  {
    return (int)(this.presentationTimeUs / 1000L);
  }
  
  public final String djk()
  {
    return this.mime;
  }
  
  public final void djl()
  {
    try
    {
      AppMethodBeat.i(137320);
      while (dji())
      {
        boolean bool = this.vgX.djr();
        if (!bool) {
          break;
        }
        try
        {
          ac.i("MicroMsg.Music.MMPlayer", "wait play");
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          ac.printErrStackTrace("MicroMsg.Music.MMPlayer", localInterruptedException, "waitPlay", new Object[0]);
        }
      }
      AppMethodBeat.o(137320);
    }
    finally {}
  }
  
  public final int getDuration()
  {
    return (int)(this.duration / 1000L);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137321);
    boolean bool = this.vgX.isPlaying();
    AppMethodBeat.o(137321);
    return bool;
  }
  
  public final void oE(boolean paramBoolean)
  {
    AppMethodBeat.i(137322);
    this.vgX.smv = 4;
    this.stop = true;
    super.oE(paramBoolean);
    AppMethodBeat.o(137322);
  }
  
  public final void oF(boolean paramBoolean)
  {
    AppMethodBeat.i(137323);
    this.vgX.smv = 4;
    this.stop = true;
    super.oF(paramBoolean);
    AppMethodBeat.o(137323);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137318);
    ac.i("MicroMsg.Music.MMPlayer", "pause");
    if (!dji())
    {
      AppMethodBeat.o(137318);
      return;
    }
    this.vgX.smv = 2;
    AppMethodBeat.o(137318);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137315);
    ac.i("MicroMsg.Music.MMPlayer", "play");
    if (!dji())
    {
      this.stop = false;
      com.tencent.mm.sdk.g.b.c(this.vgE, "music_player");
      AppMethodBeat.o(137315);
      return;
    }
    if ((dji()) && (this.vgX.djr()))
    {
      this.vgX.smv = 3;
      NP();
    }
    AppMethodBeat.o(137315);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137319);
    this.cSi.seekTo(1000L * paramLong, 2);
    AppMethodBeat.o(137319);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137317);
    ac.i("MicroMsg.Music.MMPlayer", "stop");
    this.stop = true;
    if (this.vgX.djr()) {
      NP();
    }
    AppMethodBeat.o(137317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.c
 * JD-Core Version:    0.7.0.1
 */