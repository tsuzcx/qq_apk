package com.tencent.mm.plugin.music.f;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.music.f.a.g;
import com.tencent.mm.sdk.platformtools.ae;

@TargetApi(16)
public final class c
  extends com.tencent.mm.plugin.music.f.a.b
{
  AudioTrack bfq;
  int channels;
  com.tencent.mm.compatible.h.c deA;
  z deB;
  int deq;
  long duration;
  String mime;
  long presentationTimeUs;
  int sampleRate;
  String sourcePath;
  private boolean stop;
  private Runnable wBI;
  
  public c()
  {
    AppMethodBeat.i(137313);
    this.stop = true;
    this.mime = null;
    this.sampleRate = 0;
    this.channels = 0;
    this.presentationTimeUs = 0L;
    this.duration = 0L;
    this.deq = 0;
    this.wBI = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 30
        //   7: ldc 32
        //   9: invokestatic 37	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   12: bipush 237
        //   14: invokestatic 42	android/os/Process:setThreadPriority	(I)V
        //   17: aload_0
        //   18: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   21: getfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   24: invokestatic 52	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
        //   27: ifeq +24 -> 51
        //   30: ldc 30
        //   32: ldc 54
        //   34: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   37: aload_0
        //   38: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   41: iconst_0
        //   42: invokevirtual 61	com/tencent/mm/plugin/music/f/c:pl	(Z)V
        //   45: ldc 22
        //   47: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   50: return
        //   51: aload_0
        //   52: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   55: new 66	com/tencent/mm/compatible/h/c
        //   58: dup
        //   59: invokespecial 67	com/tencent/mm/compatible/h/c:<init>	()V
        //   62: putfield 71	com/tencent/mm/plugin/music/f/c:deA	Lcom/tencent/mm/compatible/h/c;
        //   65: aload_0
        //   66: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   69: getfield 71	com/tencent/mm/plugin/music/f/c:deA	Lcom/tencent/mm/compatible/h/c;
        //   72: aload_0
        //   73: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   76: getfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   79: invokevirtual 75	com/tencent/mm/compatible/h/c:vT	(Ljava/lang/String;)V
        //   82: aconst_null
        //   83: astore 13
        //   85: aconst_null
        //   86: astore 12
        //   88: aload 13
        //   90: astore 11
        //   92: aload_0
        //   93: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   96: getfield 71	com/tencent/mm/plugin/music/f/c:deA	Lcom/tencent/mm/compatible/h/c;
        //   99: getfield 79	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
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
        //   125: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   144: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   147: getfield 71	com/tencent/mm/plugin/music/f/c:deA	Lcom/tencent/mm/compatible/h/c;
        //   150: iload_1
        //   151: invokevirtual 100	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
        //   154: astore 10
        //   156: aload 13
        //   158: astore 11
        //   160: aload_0
        //   161: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   164: aload 10
        //   166: ldc 102
        //   168: invokevirtual 108	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   171: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   174: aload 13
        //   176: astore 11
        //   178: aload_0
        //   179: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   182: getfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   185: invokestatic 52	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
        //   188: ifne +120 -> 308
        //   191: aload 13
        //   193: astore 11
        //   195: aload_0
        //   196: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
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
        //   223: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   226: aload 10
        //   228: astore 11
        //   230: aload_0
        //   231: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   234: sipush 703
        //   237: putfield 123	com/tencent/mm/plugin/music/f/c:deq	I
        //   240: aload 10
        //   242: astore 11
        //   244: aload_0
        //   245: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   248: iconst_1
        //   249: invokevirtual 61	com/tencent/mm/plugin/music/f/c:pl	(Z)V
        //   252: aload 10
        //   254: astore 11
        //   256: aload_0
        //   257: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
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
        //   281: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   284: aload_0
        //   285: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   288: sipush 702
        //   291: putfield 123	com/tencent/mm/plugin/music/f/c:deq	I
        //   294: aload_0
        //   295: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   298: iconst_1
        //   299: invokevirtual 61	com/tencent/mm/plugin/music/f/c:pl	(Z)V
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
        //   332: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   335: aload 10
        //   337: astore 11
        //   339: aload_0
        //   340: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   343: aload 10
        //   345: ldc 138
        //   347: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   350: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   353: aload 10
        //   355: astore 11
        //   357: aload_0
        //   358: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   361: aload 10
        //   363: ldc 147
        //   365: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   368: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   371: aload 10
        //   373: astore 11
        //   375: aload_0
        //   376: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   379: aload 10
        //   381: ldc 152
        //   383: invokevirtual 156	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
        //   386: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   389: aload_0
        //   390: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   393: aload_0
        //   394: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   397: getfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   400: invokestatic 166	com/tencent/mm/compatible/deviceinfo/z:vI	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
        //   403: putfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   406: aload_0
        //   407: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   410: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   413: aload 10
        //   415: aconst_null
        //   416: iconst_0
        //   417: invokevirtual 173	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
        //   420: aload_0
        //   421: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   424: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   427: invokevirtual 176	com/tencent/mm/compatible/deviceinfo/z:start	()V
        //   430: aload_0
        //   431: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   434: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   437: invokevirtual 180	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
        //   440: astore 12
        //   442: aload_0
        //   443: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   446: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
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
        //   470: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   473: getfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   476: aastore
        //   477: dup
        //   478: iconst_2
        //   479: aload_0
        //   480: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   483: getfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   486: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   489: aastore
        //   490: dup
        //   491: iconst_3
        //   492: aload_0
        //   493: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   496: getfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   499: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   502: aastore
        //   503: dup
        //   504: iconst_4
        //   505: aload_0
        //   506: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   509: getfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   512: invokestatic 190	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   515: aastore
        //   516: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   519: aload_0
        //   520: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   523: getfield 71	com/tencent/mm/plugin/music/f/c:deA	Lcom/tencent/mm/compatible/h/c;
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
        //   544: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   547: getfield 200	com/tencent/mm/plugin/music/f/c:wCb	Lcom/tencent/mm/plugin/music/f/a/g;
        //   550: iconst_3
        //   551: putfield 205	com/tencent/mm/plugin/music/f/a/g:ttR	I
        //   554: aload_0
        //   555: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   558: invokevirtual 208	com/tencent/mm/plugin/music/f/c:onStart	()V
        //   561: iconst_0
        //   562: istore_1
        //   563: aload 11
        //   565: astore 10
        //   567: iload_3
        //   568: ifne +708 -> 1276
        //   571: iload_2
        //   572: bipush 50
        //   574: if_icmpge +702 -> 1276
        //   577: aload_0
        //   578: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   581: invokevirtual 211	com/tencent/mm/plugin/music/f/c:dwM	()V
        //   584: aload_0
        //   585: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   588: invokevirtual 215	com/tencent/mm/plugin/music/f/c:dwJ	()Z
        //   591: ifeq +685 -> 1276
        //   594: iload_2
        //   595: iconst_1
        //   596: iadd
        //   597: istore_2
        //   598: iload_1
        //   599: ifne +1071 -> 1670
        //   602: aload_0
        //   603: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   606: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   609: ldc2_w 216
        //   612: invokevirtual 221	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
        //   615: istore 6
        //   617: iload 6
        //   619: iflt +453 -> 1072
        //   622: aload 12
        //   624: iload 6
        //   626: aaload
        //   627: astore 11
        //   629: aload_0
        //   630: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   633: getfield 71	com/tencent/mm/plugin/music/f/c:deA	Lcom/tencent/mm/compatible/h/c;
        //   636: aload 11
        //   638: iconst_0
        //   639: invokevirtual 225	com/tencent/mm/compatible/h/c:readSampleData	(Ljava/nio/ByteBuffer;I)I
        //   642: istore 5
        //   644: iload 5
        //   646: ifge +350 -> 996
        //   649: ldc 30
        //   651: ldc 227
        //   653: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   656: iconst_1
        //   657: istore_1
        //   658: iconst_0
        //   659: istore 4
        //   661: aload_0
        //   662: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   665: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   668: astore 11
        //   670: aload_0
        //   671: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   674: getfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   677: lstore 7
        //   679: iload_1
        //   680: ifeq +984 -> 1664
        //   683: iconst_4
        //   684: istore 5
        //   686: aload 11
        //   688: iload 6
        //   690: iload 4
        //   692: lload 7
        //   694: iload 5
        //   696: invokevirtual 233	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
        //   699: iload_1
        //   700: ifne +961 -> 1661
        //   703: aload_0
        //   704: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   707: getfield 71	com/tencent/mm/plugin/music/f/c:deA	Lcom/tencent/mm/compatible/h/c;
        //   710: getfield 79	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
        //   713: invokevirtual 236	android/media/MediaExtractor:advance	()Z
        //   716: pop
        //   717: goto +944 -> 1661
        //   720: aload_0
        //   721: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   724: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   727: aload 13
        //   729: ldc2_w 216
        //   732: invokevirtual 240	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
        //   735: istore 4
        //   737: iload 4
        //   739: iflt +415 -> 1154
        //   742: aload 13
        //   744: getfield 243	android/media/MediaCodec$BufferInfo:size	I
        //   747: ifle +911 -> 1658
        //   750: iconst_0
        //   751: istore_2
        //   752: aload 10
        //   754: iload 4
        //   756: aaload
        //   757: astore 11
        //   759: aload 13
        //   761: getfield 243	android/media/MediaCodec$BufferInfo:size	I
        //   764: newarray byte
        //   766: astore 14
        //   768: aload 11
        //   770: aload 14
        //   772: invokevirtual 249	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
        //   775: pop
        //   776: aload 11
        //   778: invokevirtual 253	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
        //   781: pop
        //   782: aload 14
        //   784: arraylength
        //   785: ifle +333 -> 1118
        //   788: aload_0
        //   789: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   792: getfield 257	com/tencent/mm/plugin/music/f/c:bfq	Landroid/media/AudioTrack;
        //   795: ifnonnull +306 -> 1101
        //   798: aload_0
        //   799: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   802: invokevirtual 260	com/tencent/mm/plugin/music/f/c:createAudioTrack	()Z
        //   805: ifne +286 -> 1091
        //   808: ldc 30
        //   810: ldc_w 262
        //   813: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   816: aload_0
        //   817: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   820: sipush 707
        //   823: putfield 123	com/tencent/mm/plugin/music/f/c:deq	I
        //   826: aload_0
        //   827: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   830: iconst_1
        //   831: invokevirtual 61	com/tencent/mm/plugin/music/f/c:pl	(Z)V
        //   834: aload_0
        //   835: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   838: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   841: aload_0
        //   842: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   845: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   848: aload_0
        //   849: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   852: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   855: aload_0
        //   856: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   859: aconst_null
        //   860: putfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   863: aload_0
        //   864: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   867: aconst_null
        //   868: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   871: aload_0
        //   872: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   875: iconst_0
        //   876: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   879: aload_0
        //   880: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   883: iconst_0
        //   884: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   887: aload_0
        //   888: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   891: lconst_0
        //   892: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   895: aload_0
        //   896: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   899: lconst_0
        //   900: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   903: ldc 22
        //   905: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   908: return
        //   909: astore 10
        //   911: ldc 30
        //   913: aload 10
        //   915: ldc_w 270
        //   918: iconst_0
        //   919: anewarray 4	java/lang/Object
        //   922: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   925: aload_0
        //   926: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   929: sipush 705
        //   932: putfield 123	com/tencent/mm/plugin/music/f/c:deq	I
        //   935: aload 11
        //   937: astore 10
        //   939: goto -550 -> 389
        //   942: astore 10
        //   944: ldc 30
        //   946: aload 10
        //   948: ldc_w 272
        //   951: iconst_0
        //   952: anewarray 4	java/lang/Object
        //   955: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   958: aload_0
        //   959: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   962: sipush 704
        //   965: putfield 123	com/tencent/mm/plugin/music/f/c:deq	I
        //   968: aload_0
        //   969: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   972: iconst_1
        //   973: invokevirtual 61	com/tencent/mm/plugin/music/f/c:pl	(Z)V
        //   976: aload_0
        //   977: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   980: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   983: aload_0
        //   984: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   987: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   990: ldc 22
        //   992: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   995: return
        //   996: aload_0
        //   997: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1000: aload_0
        //   1001: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1004: getfield 71	com/tencent/mm/plugin/music/f/c:deA	Lcom/tencent/mm/compatible/h/c;
        //   1007: getfield 79	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
        //   1010: invokevirtual 276	android/media/MediaExtractor:getSampleTime	()J
        //   1013: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1016: aload_0
        //   1017: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1020: getfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1023: lconst_0
        //   1024: lcmp
        //   1025: ifne +22 -> 1047
        //   1028: iconst_0
        //   1029: istore 4
        //   1031: aload_0
        //   1032: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1035: iload 4
        //   1037: invokevirtual 279	com/tencent/mm/plugin/music/f/c:Me	(I)V
        //   1040: iload 5
        //   1042: istore 4
        //   1044: goto -383 -> 661
        //   1047: ldc2_w 280
        //   1050: aload_0
        //   1051: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1054: getfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1057: lmul
        //   1058: aload_0
        //   1059: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1062: getfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1065: ldiv
        //   1066: l2i
        //   1067: istore 4
        //   1069: goto -38 -> 1031
        //   1072: ldc 30
        //   1074: ldc_w 283
        //   1077: iload 6
        //   1079: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   1082: invokevirtual 289	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1085: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1088: goto +582 -> 1670
        //   1091: aload_0
        //   1092: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1095: getfield 257	com/tencent/mm/plugin/music/f/c:bfq	Landroid/media/AudioTrack;
        //   1098: invokevirtual 294	android/media/AudioTrack:play	()V
        //   1101: aload_0
        //   1102: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1105: getfield 257	com/tencent/mm/plugin/music/f/c:bfq	Landroid/media/AudioTrack;
        //   1108: aload 14
        //   1110: iconst_0
        //   1111: aload 14
        //   1113: arraylength
        //   1114: invokevirtual 298	android/media/AudioTrack:write	([BII)I
        //   1117: pop
        //   1118: aload_0
        //   1119: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1122: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   1125: iload 4
        //   1127: iconst_0
        //   1128: invokevirtual 302	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
        //   1131: aload 13
        //   1133: getfield 305	android/media/MediaCodec$BufferInfo:flags	I
        //   1136: iconst_4
        //   1137: iand
        //   1138: ifeq +535 -> 1673
        //   1141: ldc 30
        //   1143: ldc_w 307
        //   1146: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1149: iconst_1
        //   1150: istore_3
        //   1151: goto +522 -> 1673
        //   1154: iload 4
        //   1156: bipush 253
        //   1158: if_icmpne +26 -> 1184
        //   1161: aload_0
        //   1162: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1165: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   1168: invokevirtual 183	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
        //   1171: astore 10
        //   1173: ldc 30
        //   1175: ldc_w 309
        //   1178: invokestatic 37	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1181: goto -614 -> 567
        //   1184: iload 4
        //   1186: bipush 254
        //   1188: if_icmpne +69 -> 1257
        //   1191: aload_0
        //   1192: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1195: getfield 170	com/tencent/mm/plugin/music/f/c:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
        //   1198: invokevirtual 313	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
        //   1201: astore 11
        //   1203: ldc 30
        //   1205: ldc_w 315
        //   1208: aload 11
        //   1210: invokestatic 318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   1213: invokevirtual 289	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1216: invokestatic 37	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1219: aload_0
        //   1220: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1223: aload 11
        //   1225: ldc 138
        //   1227: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   1230: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   1233: aload_0
        //   1234: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1237: aload 11
        //   1239: ldc 147
        //   1241: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   1244: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   1247: aload_0
        //   1248: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1251: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1254: goto -687 -> 567
        //   1257: ldc 30
        //   1259: ldc_w 320
        //   1262: iload 4
        //   1264: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   1267: invokevirtual 289	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1270: invokestatic 37	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1273: goto -706 -> 567
        //   1276: aload_0
        //   1277: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1280: getfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1283: ldc2_w 216
        //   1286: ldiv
        //   1287: aload_0
        //   1288: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1291: getfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1294: ldc2_w 216
        //   1297: ldiv
        //   1298: lsub
        //   1299: ldc2_w 321
        //   1302: lcmp
        //   1303: ifge +132 -> 1435
        //   1306: iconst_1
        //   1307: istore 9
        //   1309: iload_2
        //   1310: bipush 50
        //   1312: if_icmplt +129 -> 1441
        //   1315: ldc 30
        //   1317: ldc_w 324
        //   1320: iconst_1
        //   1321: anewarray 4	java/lang/Object
        //   1324: dup
        //   1325: iconst_0
        //   1326: iload_2
        //   1327: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1330: aastore
        //   1331: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1334: aload_0
        //   1335: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1338: sipush 706
        //   1341: putfield 123	com/tencent/mm/plugin/music/f/c:deq	I
        //   1344: aload_0
        //   1345: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1348: iconst_1
        //   1349: invokevirtual 61	com/tencent/mm/plugin/music/f/c:pl	(Z)V
        //   1352: aload_0
        //   1353: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1356: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1359: aload_0
        //   1360: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1363: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1366: aload_0
        //   1367: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1370: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1373: aload_0
        //   1374: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1377: aconst_null
        //   1378: putfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   1381: aload_0
        //   1382: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1385: aconst_null
        //   1386: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   1389: aload_0
        //   1390: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1393: iconst_0
        //   1394: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   1397: aload_0
        //   1398: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1401: iconst_0
        //   1402: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   1405: aload_0
        //   1406: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1409: lconst_0
        //   1410: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1413: aload_0
        //   1414: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1417: lconst_0
        //   1418: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1421: ldc 30
        //   1423: ldc_w 326
        //   1426: invokestatic 37	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1429: ldc 22
        //   1431: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1434: return
        //   1435: iconst_0
        //   1436: istore 9
        //   1438: goto -129 -> 1309
        //   1441: ldc 30
        //   1443: ldc_w 328
        //   1446: iconst_1
        //   1447: anewarray 4	java/lang/Object
        //   1450: dup
        //   1451: iconst_0
        //   1452: iload 9
        //   1454: invokestatic 333	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   1457: aastore
        //   1458: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1461: aload_0
        //   1462: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1465: iload 9
        //   1467: invokevirtual 336	com/tencent/mm/plugin/music/f/c:pm	(Z)V
        //   1470: goto -118 -> 1352
        //   1473: astore 10
        //   1475: ldc 30
        //   1477: aload 10
        //   1479: ldc_w 338
        //   1482: iconst_0
        //   1483: anewarray 4	java/lang/Object
        //   1486: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1489: aload_0
        //   1490: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1493: sipush 706
        //   1496: putfield 123	com/tencent/mm/plugin/music/f/c:deq	I
        //   1499: aload_0
        //   1500: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1503: iconst_1
        //   1504: invokevirtual 61	com/tencent/mm/plugin/music/f/c:pl	(Z)V
        //   1507: aload_0
        //   1508: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1511: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1514: aload_0
        //   1515: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1518: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1521: aload_0
        //   1522: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1525: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1528: aload_0
        //   1529: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1532: aconst_null
        //   1533: putfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   1536: aload_0
        //   1537: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1540: aconst_null
        //   1541: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   1544: aload_0
        //   1545: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1548: iconst_0
        //   1549: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   1552: aload_0
        //   1553: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1556: iconst_0
        //   1557: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   1560: aload_0
        //   1561: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1564: lconst_0
        //   1565: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1568: aload_0
        //   1569: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1572: lconst_0
        //   1573: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1576: goto -155 -> 1421
        //   1579: astore 10
        //   1581: aload_0
        //   1582: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1585: invokestatic 126	com/tencent/mm/plugin/music/f/c:a	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1588: aload_0
        //   1589: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1592: invokestatic 265	com/tencent/mm/plugin/music/f/c:b	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1595: aload_0
        //   1596: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1599: invokestatic 268	com/tencent/mm/plugin/music/f/c:c	(Lcom/tencent/mm/plugin/music/f/c;)V
        //   1602: aload_0
        //   1603: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1606: aconst_null
        //   1607: putfield 46	com/tencent/mm/plugin/music/f/c:sourcePath	Ljava/lang/String;
        //   1610: aload_0
        //   1611: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1614: aconst_null
        //   1615: putfield 110	com/tencent/mm/plugin/music/f/c:mime	Ljava/lang/String;
        //   1618: aload_0
        //   1619: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1622: iconst_0
        //   1623: putfield 145	com/tencent/mm/plugin/music/f/c:sampleRate	I
        //   1626: aload_0
        //   1627: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1630: iconst_0
        //   1631: putfield 150	com/tencent/mm/plugin/music/f/c:channels	I
        //   1634: aload_0
        //   1635: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1638: lconst_0
        //   1639: putfield 230	com/tencent/mm/plugin/music/f/c:presentationTimeUs	J
        //   1642: aload_0
        //   1643: getfield 14	com/tencent/mm/plugin/music/f/c$1:wBJ	Lcom/tencent/mm/plugin/music/f/c;
        //   1646: lconst_0
        //   1647: putfield 160	com/tencent/mm/plugin/music/f/c:duration	J
        //   1650: ldc 22
        //   1652: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1655: aload 10
        //   1657: athrow
        //   1658: goto -906 -> 752
        //   1661: goto -941 -> 720
        //   1664: iconst_0
        //   1665: istore 5
        //   1667: goto -981 -> 686
        //   1670: goto -950 -> 720
        //   1673: goto -1106 -> 567
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1676	0	this	1
        //   129	571	1	i	int
        //   105	1222	2	j	int
        //   540	611	3	k	int
        //   659	604	4	m	int
        //   642	1024	5	n	int
        //   615	463	6	i1	int
        //   677	16	7	l	long
        //   1307	159	9	bool	boolean
        //   132	121	10	localObject1	Object
        //   269	196	10	localException1	Exception
        //   565	188	10	localObject2	Object
        //   909	5	10	localException2	Exception
        //   937	1	10	localObject3	Object
        //   942	5	10	localException3	Exception
        //   1171	1	10	arrayOfByteBuffer1	java.nio.ByteBuffer[]
        //   1473	5	10	localException4	Exception
        //   1579	77	10	localObject4	Object
        //   90	1148	11	localObject5	Object
        //   86	537	12	arrayOfByteBuffer2	java.nio.ByteBuffer[]
        //   83	1049	13	localBufferInfo	android.media.MediaCodec.BufferInfo
        //   766	346	14	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   65	82	269	java/lang/Exception
        //   92	106	909	java/lang/Exception
        //   110	128	909	java/lang/Exception
        //   143	156	909	java/lang/Exception
        //   160	174	909	java/lang/Exception
        //   178	191	909	java/lang/Exception
        //   195	210	909	java/lang/Exception
        //   219	226	909	java/lang/Exception
        //   230	240	909	java/lang/Exception
        //   244	252	909	java/lang/Exception
        //   256	263	909	java/lang/Exception
        //   319	335	909	java/lang/Exception
        //   339	353	909	java/lang/Exception
        //   357	371	909	java/lang/Exception
        //   375	389	909	java/lang/Exception
        //   389	430	942	java/lang/Exception
        //   577	594	1473	java/lang/Exception
        //   602	617	1473	java/lang/Exception
        //   629	644	1473	java/lang/Exception
        //   649	656	1473	java/lang/Exception
        //   661	679	1473	java/lang/Exception
        //   686	699	1473	java/lang/Exception
        //   703	717	1473	java/lang/Exception
        //   720	737	1473	java/lang/Exception
        //   742	750	1473	java/lang/Exception
        //   759	834	1473	java/lang/Exception
        //   996	1028	1473	java/lang/Exception
        //   1031	1040	1473	java/lang/Exception
        //   1047	1069	1473	java/lang/Exception
        //   1072	1088	1473	java/lang/Exception
        //   1091	1101	1473	java/lang/Exception
        //   1101	1118	1473	java/lang/Exception
        //   1118	1131	1473	java/lang/Exception
        //   1131	1149	1473	java/lang/Exception
        //   1161	1181	1473	java/lang/Exception
        //   1191	1254	1473	java/lang/Exception
        //   1257	1273	1473	java/lang/Exception
        //   1276	1306	1473	java/lang/Exception
        //   1315	1352	1473	java/lang/Exception
        //   1441	1470	1473	java/lang/Exception
        //   577	594	1579	finally
        //   602	617	1579	finally
        //   629	644	1579	finally
        //   649	656	1579	finally
        //   661	679	1579	finally
        //   686	699	1579	finally
        //   703	717	1579	finally
        //   720	737	1579	finally
        //   742	750	1579	finally
        //   759	834	1579	finally
        //   996	1028	1579	finally
        //   1031	1040	1579	finally
        //   1047	1069	1579	finally
        //   1072	1088	1579	finally
        //   1091	1101	1579	finally
        //   1101	1118	1579	finally
        //   1118	1131	1579	finally
        //   1131	1149	1579	finally
        //   1161	1181	1579	finally
        //   1191	1254	1579	finally
        //   1257	1273	1579	finally
        //   1276	1306	1579	finally
        //   1315	1352	1579	finally
        //   1441	1470	1579	finally
        //   1475	1507	1579	finally
      }
    };
    AppMethodBeat.o(137313);
  }
  
  private void Pw()
  {
    try
    {
      AppMethodBeat.i(137316);
      ae.i("MicroMsg.Music.MMPlayer", "sync notify");
      try
      {
        notify();
        AppMethodBeat.o(137316);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Music.MMPlayer", localException, "syncNotify", new Object[0]);
          AppMethodBeat.o(137316);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void atY(String paramString)
  {
    this.sourcePath = paramString;
  }
  
  final boolean createAudioTrack()
  {
    AppMethodBeat.i(137314);
    ae.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
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
        this.bfq = localb.am(this.sampleRate, i, j);
        label61:
        if (this.bfq == null)
        {
          ae.e("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
          this.bfq = new AudioTrack(3, this.sampleRate, i, 2, j, 1);
        }
        if ((this.bfq != null) && (this.bfq.getState() == 1)) {
          break label157;
        }
        ae.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
        if (this.bfq == null) {}
      }
      try
      {
        this.bfq.release();
        label134:
        AppMethodBeat.o(137314);
        return false;
        i = 12;
        continue;
        ae.e("MicroMsg.Music.MMPlayer", "mediaResService null");
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
  
  public final boolean dwJ()
  {
    return !this.stop;
  }
  
  public final int dwK()
  {
    return (int)(this.presentationTimeUs / 1000L);
  }
  
  public final String dwL()
  {
    return this.mime;
  }
  
  public final void dwM()
  {
    try
    {
      AppMethodBeat.i(137320);
      while (dwJ())
      {
        boolean bool = this.wCb.dwS();
        if (!bool) {
          break;
        }
        try
        {
          ae.i("MicroMsg.Music.MMPlayer", "wait play");
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          ae.printErrStackTrace("MicroMsg.Music.MMPlayer", localInterruptedException, "waitPlay", new Object[0]);
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
    boolean bool = this.wCb.isPlaying();
    AppMethodBeat.o(137321);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137318);
    ae.i("MicroMsg.Music.MMPlayer", "pause");
    if (!dwJ())
    {
      AppMethodBeat.o(137318);
      return;
    }
    this.wCb.ttR = 2;
    AppMethodBeat.o(137318);
  }
  
  public final void pl(boolean paramBoolean)
  {
    AppMethodBeat.i(137322);
    this.wCb.ttR = 4;
    this.stop = true;
    super.pl(paramBoolean);
    AppMethodBeat.o(137322);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137315);
    ae.i("MicroMsg.Music.MMPlayer", "play");
    if (!dwJ())
    {
      this.stop = false;
      com.tencent.mm.sdk.g.b.c(this.wBI, "music_player");
      AppMethodBeat.o(137315);
      return;
    }
    if ((dwJ()) && (this.wCb.dwS()))
    {
      this.wCb.ttR = 3;
      Pw();
    }
    AppMethodBeat.o(137315);
  }
  
  public final void pm(boolean paramBoolean)
  {
    AppMethodBeat.i(137323);
    this.wCb.ttR = 4;
    this.stop = true;
    super.pm(paramBoolean);
    AppMethodBeat.o(137323);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137319);
    this.deA.seekTo(1000L * paramLong, 2);
    AppMethodBeat.o(137319);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137317);
    ae.i("MicroMsg.Music.MMPlayer", "stop");
    this.stop = true;
    if (this.wCb.dwS()) {
      Pw();
    }
    AppMethodBeat.o(137317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.c
 * JD-Core Version:    0.7.0.1
 */