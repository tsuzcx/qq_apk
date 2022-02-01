package com.tencent.mm.plugin.music.e;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.plugin.music.e.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class c
  extends com.tencent.mm.plugin.music.e.a.b
{
  private Runnable Gsw;
  String cBw;
  AudioTrack cIK;
  int channels;
  long duration;
  int hsf;
  aa hsr;
  long hst;
  com.tencent.mm.compatible.i.c pcp;
  int sampleRate;
  String sourcePath;
  private boolean stop;
  
  public c()
  {
    AppMethodBeat.i(137313);
    this.stop = true;
    this.cBw = null;
    this.sampleRate = 0;
    this.channels = 0;
    this.hst = 0L;
    this.duration = 0L;
    this.hsf = 0;
    this.Gsw = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 30
        //   7: ldc 32
        //   9: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   12: bipush 237
        //   14: invokestatic 42	android/os/Process:setThreadPriority	(I)V
        //   17: aload_0
        //   18: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   21: getfield 46	com/tencent/mm/plugin/music/e/c:sourcePath	Ljava/lang/String;
        //   24: invokestatic 52	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   27: ifeq +24 -> 51
        //   30: ldc 30
        //   32: ldc 54
        //   34: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   37: aload_0
        //   38: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   41: iconst_0
        //   42: invokevirtual 61	com/tencent/mm/plugin/music/e/c:zL	(Z)V
        //   45: ldc 22
        //   47: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   50: return
        //   51: aload_0
        //   52: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   55: new 66	com/tencent/mm/compatible/i/c
        //   58: dup
        //   59: invokespecial 67	com/tencent/mm/compatible/i/c:<init>	()V
        //   62: putfield 71	com/tencent/mm/plugin/music/e/c:pcp	Lcom/tencent/mm/compatible/i/c;
        //   65: aload_0
        //   66: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   69: getfield 71	com/tencent/mm/plugin/music/e/c:pcp	Lcom/tencent/mm/compatible/i/c;
        //   72: aload_0
        //   73: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   76: getfield 46	com/tencent/mm/plugin/music/e/c:sourcePath	Ljava/lang/String;
        //   79: invokevirtual 75	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
        //   82: aconst_null
        //   83: astore 13
        //   85: aconst_null
        //   86: astore 12
        //   88: aload 13
        //   90: astore 11
        //   92: aload_0
        //   93: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   96: getfield 71	com/tencent/mm/plugin/music/e/c:pcp	Lcom/tencent/mm/compatible/i/c;
        //   99: getfield 79	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
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
        //   125: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   144: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   147: getfield 71	com/tencent/mm/plugin/music/e/c:pcp	Lcom/tencent/mm/compatible/i/c;
        //   150: iload_1
        //   151: invokevirtual 100	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
        //   154: astore 10
        //   156: aload 13
        //   158: astore 11
        //   160: aload_0
        //   161: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   164: aload 10
        //   166: ldc 102
        //   168: invokevirtual 108	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   171: putfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   174: aload 13
        //   176: astore 11
        //   178: aload_0
        //   179: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   182: getfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   185: invokestatic 52	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   188: ifne +120 -> 308
        //   191: aload 13
        //   193: astore 11
        //   195: aload_0
        //   196: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   199: getfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   202: ldc 113
        //   204: invokevirtual 118	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   207: ifeq +101 -> 308
        //   210: aload 10
        //   212: ifnonnull +103 -> 315
        //   215: aload 10
        //   217: astore 11
        //   219: ldc 30
        //   221: ldc 120
        //   223: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   226: aload 10
        //   228: astore 11
        //   230: aload_0
        //   231: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   234: sipush 703
        //   237: putfield 124	com/tencent/mm/plugin/music/e/c:hsf	I
        //   240: aload 10
        //   242: astore 11
        //   244: aload_0
        //   245: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   248: iconst_1
        //   249: invokevirtual 61	com/tencent/mm/plugin/music/e/c:zL	(Z)V
        //   252: aload 10
        //   254: astore 11
        //   256: aload_0
        //   257: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   260: invokestatic 127	com/tencent/mm/plugin/music/e/c:a	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   263: ldc 22
        //   265: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   268: return
        //   269: astore 10
        //   271: ldc 30
        //   273: aload 10
        //   275: ldc 129
        //   277: iconst_0
        //   278: anewarray 4	java/lang/Object
        //   281: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   284: aload_0
        //   285: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   288: sipush 702
        //   291: putfield 124	com/tencent/mm/plugin/music/e/c:hsf	I
        //   294: aload_0
        //   295: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   298: iconst_1
        //   299: invokevirtual 61	com/tencent/mm/plugin/music/e/c:zL	(Z)V
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
        //   321: ldc 135
        //   323: iconst_1
        //   324: anewarray 4	java/lang/Object
        //   327: dup
        //   328: iconst_0
        //   329: aload 10
        //   331: aastore
        //   332: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   335: aload 10
        //   337: astore 11
        //   339: aload_0
        //   340: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   343: aload 10
        //   345: ldc 139
        //   347: invokevirtual 143	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   350: putfield 146	com/tencent/mm/plugin/music/e/c:sampleRate	I
        //   353: aload 10
        //   355: astore 11
        //   357: aload_0
        //   358: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   361: aload 10
        //   363: ldc 148
        //   365: invokevirtual 143	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   368: putfield 151	com/tencent/mm/plugin/music/e/c:channels	I
        //   371: aload 10
        //   373: astore 11
        //   375: aload_0
        //   376: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   379: aload 10
        //   381: ldc 153
        //   383: invokevirtual 157	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
        //   386: putfield 161	com/tencent/mm/plugin/music/e/c:duration	J
        //   389: aload_0
        //   390: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   393: aload_0
        //   394: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   397: getfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   400: invokestatic 167	com/tencent/mm/compatible/deviceinfo/aa:Dw	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   403: putfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   406: aload_0
        //   407: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   410: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   413: aload 10
        //   415: aconst_null
        //   416: iconst_0
        //   417: invokevirtual 174	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
        //   420: aload_0
        //   421: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   424: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   427: invokevirtual 177	com/tencent/mm/compatible/deviceinfo/aa:start	()V
        //   430: aload_0
        //   431: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   434: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   437: invokevirtual 181	com/tencent/mm/compatible/deviceinfo/aa:aPD	()[Ljava/nio/ByteBuffer;
        //   440: astore 12
        //   442: aload_0
        //   443: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   446: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   449: invokevirtual 184	com/tencent/mm/compatible/deviceinfo/aa:aPE	()[Ljava/nio/ByteBuffer;
        //   452: astore 11
        //   454: ldc 30
        //   456: ldc 186
        //   458: iconst_5
        //   459: anewarray 4	java/lang/Object
        //   462: dup
        //   463: iconst_0
        //   464: aload 10
        //   466: aastore
        //   467: dup
        //   468: iconst_1
        //   469: aload_0
        //   470: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   473: getfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   476: aastore
        //   477: dup
        //   478: iconst_2
        //   479: aload_0
        //   480: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   483: getfield 146	com/tencent/mm/plugin/music/e/c:sampleRate	I
        //   486: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   489: aastore
        //   490: dup
        //   491: iconst_3
        //   492: aload_0
        //   493: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   496: getfield 151	com/tencent/mm/plugin/music/e/c:channels	I
        //   499: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   502: aastore
        //   503: dup
        //   504: iconst_4
        //   505: aload_0
        //   506: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   509: getfield 161	com/tencent/mm/plugin/music/e/c:duration	J
        //   512: invokestatic 191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   515: aastore
        //   516: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   519: aload_0
        //   520: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   523: getfield 71	com/tencent/mm/plugin/music/e/c:pcp	Lcom/tencent/mm/compatible/i/c;
        //   526: iconst_0
        //   527: invokevirtual 194	com/tencent/mm/compatible/i/c:selectTrack	(I)V
        //   530: new 196	android/media/MediaCodec$BufferInfo
        //   533: dup
        //   534: invokespecial 197	android/media/MediaCodec$BufferInfo:<init>	()V
        //   537: astore 13
        //   539: iconst_0
        //   540: istore_3
        //   541: iconst_0
        //   542: istore_2
        //   543: aload_0
        //   544: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   547: getfield 201	com/tencent/mm/plugin/music/e/c:LOl	Lcom/tencent/mm/plugin/music/e/a/g;
        //   550: iconst_3
        //   551: putfield 206	com/tencent/mm/plugin/music/e/a/g:GuE	I
        //   554: aload_0
        //   555: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   558: invokevirtual 209	com/tencent/mm/plugin/music/e/c:onStart	()V
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
        //   578: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   581: invokevirtual 212	com/tencent/mm/plugin/music/e/c:gow	()V
        //   584: aload_0
        //   585: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   588: invokevirtual 216	com/tencent/mm/plugin/music/e/c:gou	()Z
        //   591: ifeq +685 -> 1276
        //   594: iload_2
        //   595: iconst_1
        //   596: iadd
        //   597: istore_2
        //   598: iload_1
        //   599: ifne +1071 -> 1670
        //   602: aload_0
        //   603: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   606: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   609: ldc2_w 217
        //   612: invokevirtual 222	com/tencent/mm/compatible/deviceinfo/aa:dequeueInputBuffer	(J)I
        //   615: istore 6
        //   617: iload 6
        //   619: iflt +453 -> 1072
        //   622: aload 12
        //   624: iload 6
        //   626: aaload
        //   627: astore 11
        //   629: aload_0
        //   630: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   633: getfield 71	com/tencent/mm/plugin/music/e/c:pcp	Lcom/tencent/mm/compatible/i/c;
        //   636: aload 11
        //   638: iconst_0
        //   639: invokevirtual 226	com/tencent/mm/compatible/i/c:readSampleData	(Ljava/nio/ByteBuffer;I)I
        //   642: istore 5
        //   644: iload 5
        //   646: ifge +350 -> 996
        //   649: ldc 30
        //   651: ldc 228
        //   653: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   656: iconst_1
        //   657: istore_1
        //   658: iconst_0
        //   659: istore 4
        //   661: aload_0
        //   662: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   665: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   668: astore 11
        //   670: aload_0
        //   671: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   674: getfield 231	com/tencent/mm/plugin/music/e/c:hst	J
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
        //   696: invokevirtual 234	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
        //   699: iload_1
        //   700: ifne +961 -> 1661
        //   703: aload_0
        //   704: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   707: getfield 71	com/tencent/mm/plugin/music/e/c:pcp	Lcom/tencent/mm/compatible/i/c;
        //   710: getfield 79	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
        //   713: invokevirtual 237	android/media/MediaExtractor:advance	()Z
        //   716: pop
        //   717: goto +944 -> 1661
        //   720: aload_0
        //   721: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   724: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   727: aload 13
        //   729: ldc2_w 217
        //   732: invokevirtual 241	com/tencent/mm/compatible/deviceinfo/aa:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
        //   735: istore 4
        //   737: iload 4
        //   739: iflt +415 -> 1154
        //   742: aload 13
        //   744: getfield 244	android/media/MediaCodec$BufferInfo:size	I
        //   747: ifle +911 -> 1658
        //   750: iconst_0
        //   751: istore_2
        //   752: aload 10
        //   754: iload 4
        //   756: aaload
        //   757: astore 11
        //   759: aload 13
        //   761: getfield 244	android/media/MediaCodec$BufferInfo:size	I
        //   764: newarray byte
        //   766: astore 14
        //   768: aload 11
        //   770: aload 14
        //   772: invokevirtual 250	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
        //   775: pop
        //   776: aload 11
        //   778: invokevirtual 254	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
        //   781: pop
        //   782: aload 14
        //   784: arraylength
        //   785: ifle +333 -> 1118
        //   788: aload_0
        //   789: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   792: getfield 258	com/tencent/mm/plugin/music/e/c:cIK	Landroid/media/AudioTrack;
        //   795: ifnonnull +306 -> 1101
        //   798: aload_0
        //   799: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   802: invokevirtual 261	com/tencent/mm/plugin/music/e/c:createAudioTrack	()Z
        //   805: ifne +286 -> 1091
        //   808: ldc 30
        //   810: ldc_w 263
        //   813: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   816: aload_0
        //   817: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   820: sipush 707
        //   823: putfield 124	com/tencent/mm/plugin/music/e/c:hsf	I
        //   826: aload_0
        //   827: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   830: iconst_1
        //   831: invokevirtual 61	com/tencent/mm/plugin/music/e/c:zL	(Z)V
        //   834: aload_0
        //   835: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   838: invokestatic 127	com/tencent/mm/plugin/music/e/c:a	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   841: aload_0
        //   842: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   845: invokestatic 266	com/tencent/mm/plugin/music/e/c:b	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   848: aload_0
        //   849: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   852: invokestatic 269	com/tencent/mm/plugin/music/e/c:c	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   855: aload_0
        //   856: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   859: aconst_null
        //   860: putfield 46	com/tencent/mm/plugin/music/e/c:sourcePath	Ljava/lang/String;
        //   863: aload_0
        //   864: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   867: aconst_null
        //   868: putfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   871: aload_0
        //   872: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   875: iconst_0
        //   876: putfield 146	com/tencent/mm/plugin/music/e/c:sampleRate	I
        //   879: aload_0
        //   880: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   883: iconst_0
        //   884: putfield 151	com/tencent/mm/plugin/music/e/c:channels	I
        //   887: aload_0
        //   888: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   891: lconst_0
        //   892: putfield 231	com/tencent/mm/plugin/music/e/c:hst	J
        //   895: aload_0
        //   896: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   899: lconst_0
        //   900: putfield 161	com/tencent/mm/plugin/music/e/c:duration	J
        //   903: ldc 22
        //   905: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   908: return
        //   909: astore 10
        //   911: ldc 30
        //   913: aload 10
        //   915: ldc_w 271
        //   918: iconst_0
        //   919: anewarray 4	java/lang/Object
        //   922: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   925: aload_0
        //   926: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   929: sipush 705
        //   932: putfield 124	com/tencent/mm/plugin/music/e/c:hsf	I
        //   935: aload 11
        //   937: astore 10
        //   939: goto -550 -> 389
        //   942: astore 10
        //   944: ldc 30
        //   946: aload 10
        //   948: ldc_w 273
        //   951: iconst_0
        //   952: anewarray 4	java/lang/Object
        //   955: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   958: aload_0
        //   959: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   962: sipush 704
        //   965: putfield 124	com/tencent/mm/plugin/music/e/c:hsf	I
        //   968: aload_0
        //   969: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   972: iconst_1
        //   973: invokevirtual 61	com/tencent/mm/plugin/music/e/c:zL	(Z)V
        //   976: aload_0
        //   977: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   980: invokestatic 127	com/tencent/mm/plugin/music/e/c:a	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   983: aload_0
        //   984: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   987: invokestatic 266	com/tencent/mm/plugin/music/e/c:b	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   990: ldc 22
        //   992: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   995: return
        //   996: aload_0
        //   997: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1000: aload_0
        //   1001: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1004: getfield 71	com/tencent/mm/plugin/music/e/c:pcp	Lcom/tencent/mm/compatible/i/c;
        //   1007: getfield 79	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
        //   1010: invokevirtual 277	android/media/MediaExtractor:getSampleTime	()J
        //   1013: putfield 231	com/tencent/mm/plugin/music/e/c:hst	J
        //   1016: aload_0
        //   1017: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1020: getfield 161	com/tencent/mm/plugin/music/e/c:duration	J
        //   1023: lconst_0
        //   1024: lcmp
        //   1025: ifne +22 -> 1047
        //   1028: iconst_0
        //   1029: istore 4
        //   1031: aload_0
        //   1032: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1035: iload 4
        //   1037: invokevirtual 280	com/tencent/mm/plugin/music/e/c:adJ	(I)V
        //   1040: iload 5
        //   1042: istore 4
        //   1044: goto -383 -> 661
        //   1047: ldc2_w 281
        //   1050: aload_0
        //   1051: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1054: getfield 231	com/tencent/mm/plugin/music/e/c:hst	J
        //   1057: lmul
        //   1058: aload_0
        //   1059: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1062: getfield 161	com/tencent/mm/plugin/music/e/c:duration	J
        //   1065: ldiv
        //   1066: l2i
        //   1067: istore 4
        //   1069: goto -38 -> 1031
        //   1072: ldc 30
        //   1074: ldc_w 284
        //   1077: iload 6
        //   1079: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   1082: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1085: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1088: goto +582 -> 1670
        //   1091: aload_0
        //   1092: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1095: getfield 258	com/tencent/mm/plugin/music/e/c:cIK	Landroid/media/AudioTrack;
        //   1098: invokevirtual 295	android/media/AudioTrack:play	()V
        //   1101: aload_0
        //   1102: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1105: getfield 258	com/tencent/mm/plugin/music/e/c:cIK	Landroid/media/AudioTrack;
        //   1108: aload 14
        //   1110: iconst_0
        //   1111: aload 14
        //   1113: arraylength
        //   1114: invokevirtual 299	android/media/AudioTrack:write	([BII)I
        //   1117: pop
        //   1118: aload_0
        //   1119: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1122: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   1125: iload 4
        //   1127: iconst_0
        //   1128: invokevirtual 303	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
        //   1131: aload 13
        //   1133: getfield 306	android/media/MediaCodec$BufferInfo:flags	I
        //   1136: iconst_4
        //   1137: iand
        //   1138: ifeq +535 -> 1673
        //   1141: ldc 30
        //   1143: ldc_w 308
        //   1146: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1149: iconst_1
        //   1150: istore_3
        //   1151: goto +522 -> 1673
        //   1154: iload 4
        //   1156: bipush 253
        //   1158: if_icmpne +26 -> 1184
        //   1161: aload_0
        //   1162: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1165: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   1168: invokevirtual 184	com/tencent/mm/compatible/deviceinfo/aa:aPE	()[Ljava/nio/ByteBuffer;
        //   1171: astore 10
        //   1173: ldc 30
        //   1175: ldc_w 310
        //   1178: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1181: goto -614 -> 567
        //   1184: iload 4
        //   1186: bipush 254
        //   1188: if_icmpne +69 -> 1257
        //   1191: aload_0
        //   1192: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1195: getfield 171	com/tencent/mm/plugin/music/e/c:hsr	Lcom/tencent/mm/compatible/deviceinfo/aa;
        //   1198: invokevirtual 314	com/tencent/mm/compatible/deviceinfo/aa:getOutputFormat	()Landroid/media/MediaFormat;
        //   1201: astore 11
        //   1203: ldc 30
        //   1205: ldc_w 316
        //   1208: aload 11
        //   1210: invokestatic 319	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   1213: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1216: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1219: aload_0
        //   1220: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1223: aload 11
        //   1225: ldc 139
        //   1227: invokevirtual 143	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   1230: putfield 146	com/tencent/mm/plugin/music/e/c:sampleRate	I
        //   1233: aload_0
        //   1234: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1237: aload 11
        //   1239: ldc 148
        //   1241: invokevirtual 143	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
        //   1244: putfield 151	com/tencent/mm/plugin/music/e/c:channels	I
        //   1247: aload_0
        //   1248: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1251: invokestatic 269	com/tencent/mm/plugin/music/e/c:c	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1254: goto -687 -> 567
        //   1257: ldc 30
        //   1259: ldc_w 321
        //   1262: iload 4
        //   1264: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   1267: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   1270: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1273: goto -706 -> 567
        //   1276: aload_0
        //   1277: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1280: getfield 161	com/tencent/mm/plugin/music/e/c:duration	J
        //   1283: ldc2_w 217
        //   1286: ldiv
        //   1287: aload_0
        //   1288: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1291: getfield 231	com/tencent/mm/plugin/music/e/c:hst	J
        //   1294: ldc2_w 217
        //   1297: ldiv
        //   1298: lsub
        //   1299: ldc2_w 322
        //   1302: lcmp
        //   1303: ifge +132 -> 1435
        //   1306: iconst_1
        //   1307: istore 9
        //   1309: iload_2
        //   1310: bipush 50
        //   1312: if_icmplt +129 -> 1441
        //   1315: ldc 30
        //   1317: ldc_w 325
        //   1320: iconst_1
        //   1321: anewarray 4	java/lang/Object
        //   1324: dup
        //   1325: iconst_0
        //   1326: iload_2
        //   1327: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1330: aastore
        //   1331: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1334: aload_0
        //   1335: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1338: sipush 706
        //   1341: putfield 124	com/tencent/mm/plugin/music/e/c:hsf	I
        //   1344: aload_0
        //   1345: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1348: iconst_1
        //   1349: invokevirtual 61	com/tencent/mm/plugin/music/e/c:zL	(Z)V
        //   1352: aload_0
        //   1353: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1356: invokestatic 127	com/tencent/mm/plugin/music/e/c:a	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1359: aload_0
        //   1360: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1363: invokestatic 266	com/tencent/mm/plugin/music/e/c:b	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1366: aload_0
        //   1367: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1370: invokestatic 269	com/tencent/mm/plugin/music/e/c:c	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1373: aload_0
        //   1374: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1377: aconst_null
        //   1378: putfield 46	com/tencent/mm/plugin/music/e/c:sourcePath	Ljava/lang/String;
        //   1381: aload_0
        //   1382: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1385: aconst_null
        //   1386: putfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   1389: aload_0
        //   1390: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1393: iconst_0
        //   1394: putfield 146	com/tencent/mm/plugin/music/e/c:sampleRate	I
        //   1397: aload_0
        //   1398: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1401: iconst_0
        //   1402: putfield 151	com/tencent/mm/plugin/music/e/c:channels	I
        //   1405: aload_0
        //   1406: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1409: lconst_0
        //   1410: putfield 231	com/tencent/mm/plugin/music/e/c:hst	J
        //   1413: aload_0
        //   1414: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1417: lconst_0
        //   1418: putfield 161	com/tencent/mm/plugin/music/e/c:duration	J
        //   1421: ldc 30
        //   1423: ldc_w 327
        //   1426: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   1429: ldc 22
        //   1431: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1434: return
        //   1435: iconst_0
        //   1436: istore 9
        //   1438: goto -129 -> 1309
        //   1441: ldc 30
        //   1443: ldc_w 329
        //   1446: iconst_1
        //   1447: anewarray 4	java/lang/Object
        //   1450: dup
        //   1451: iconst_0
        //   1452: iload 9
        //   1454: invokestatic 334	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   1457: aastore
        //   1458: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1461: aload_0
        //   1462: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1465: iload 9
        //   1467: invokevirtual 337	com/tencent/mm/plugin/music/e/c:zM	(Z)V
        //   1470: goto -118 -> 1352
        //   1473: astore 10
        //   1475: ldc 30
        //   1477: aload 10
        //   1479: ldc_w 339
        //   1482: iconst_0
        //   1483: anewarray 4	java/lang/Object
        //   1486: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1489: aload_0
        //   1490: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1493: sipush 706
        //   1496: putfield 124	com/tencent/mm/plugin/music/e/c:hsf	I
        //   1499: aload_0
        //   1500: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1503: iconst_1
        //   1504: invokevirtual 61	com/tencent/mm/plugin/music/e/c:zL	(Z)V
        //   1507: aload_0
        //   1508: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1511: invokestatic 127	com/tencent/mm/plugin/music/e/c:a	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1514: aload_0
        //   1515: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1518: invokestatic 266	com/tencent/mm/plugin/music/e/c:b	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1521: aload_0
        //   1522: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1525: invokestatic 269	com/tencent/mm/plugin/music/e/c:c	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1528: aload_0
        //   1529: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1532: aconst_null
        //   1533: putfield 46	com/tencent/mm/plugin/music/e/c:sourcePath	Ljava/lang/String;
        //   1536: aload_0
        //   1537: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1540: aconst_null
        //   1541: putfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   1544: aload_0
        //   1545: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1548: iconst_0
        //   1549: putfield 146	com/tencent/mm/plugin/music/e/c:sampleRate	I
        //   1552: aload_0
        //   1553: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1556: iconst_0
        //   1557: putfield 151	com/tencent/mm/plugin/music/e/c:channels	I
        //   1560: aload_0
        //   1561: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1564: lconst_0
        //   1565: putfield 231	com/tencent/mm/plugin/music/e/c:hst	J
        //   1568: aload_0
        //   1569: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1572: lconst_0
        //   1573: putfield 161	com/tencent/mm/plugin/music/e/c:duration	J
        //   1576: goto -155 -> 1421
        //   1579: astore 10
        //   1581: aload_0
        //   1582: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1585: invokestatic 127	com/tencent/mm/plugin/music/e/c:a	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1588: aload_0
        //   1589: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1592: invokestatic 266	com/tencent/mm/plugin/music/e/c:b	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1595: aload_0
        //   1596: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1599: invokestatic 269	com/tencent/mm/plugin/music/e/c:c	(Lcom/tencent/mm/plugin/music/e/c;)V
        //   1602: aload_0
        //   1603: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1606: aconst_null
        //   1607: putfield 46	com/tencent/mm/plugin/music/e/c:sourcePath	Ljava/lang/String;
        //   1610: aload_0
        //   1611: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1614: aconst_null
        //   1615: putfield 111	com/tencent/mm/plugin/music/e/c:cBw	Ljava/lang/String;
        //   1618: aload_0
        //   1619: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1622: iconst_0
        //   1623: putfield 146	com/tencent/mm/plugin/music/e/c:sampleRate	I
        //   1626: aload_0
        //   1627: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1630: iconst_0
        //   1631: putfield 151	com/tencent/mm/plugin/music/e/c:channels	I
        //   1634: aload_0
        //   1635: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1638: lconst_0
        //   1639: putfield 231	com/tencent/mm/plugin/music/e/c:hst	J
        //   1642: aload_0
        //   1643: getfield 14	com/tencent/mm/plugin/music/e/c$1:LNT	Lcom/tencent/mm/plugin/music/e/c;
        //   1646: lconst_0
        //   1647: putfield 161	com/tencent/mm/plugin/music/e/c:duration	J
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
  
  private void aGw()
  {
    try
    {
      AppMethodBeat.i(137316);
      Log.i("MicroMsg.Music.MMPlayer", "sync notify");
      try
      {
        notify();
        AppMethodBeat.o(137316);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Music.MMPlayer", localException, "syncNotify", new Object[0]);
          AppMethodBeat.o(137316);
        }
      }
      return;
    }
    finally {}
  }
  
  public final String aGC()
  {
    return this.cBw;
  }
  
  public final void aPi(String paramString)
  {
    this.sourcePath = paramString;
  }
  
  final boolean createAudioTrack()
  {
    AppMethodBeat.i(137314);
    Log.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
    int i;
    if (this.channels == 1) {
      i = 4;
    }
    for (;;)
    {
      int j = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
      com.tencent.mm.plugin.music.logic.b localb = (com.tencent.mm.plugin.music.logic.b)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.b.class);
      if (localb != null)
      {
        this.cIK = localb.aU(this.sampleRate, i, j);
        label61:
        if (this.cIK == null)
        {
          Log.e("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
          this.cIK = new AudioTrack(3, this.sampleRate, i, 2, j, 1);
        }
        if ((this.cIK != null) && (this.cIK.getState() == 1)) {
          break label157;
        }
        Log.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
        if (this.cIK == null) {}
      }
      try
      {
        this.cIK.release();
        label134:
        AppMethodBeat.o(137314);
        return false;
        i = 12;
        continue;
        Log.e("MicroMsg.Music.MMPlayer", "mediaResService null");
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
  
  public final int getDuration()
  {
    return (int)(this.duration / 1000L);
  }
  
  public final boolean gou()
  {
    return !this.stop;
  }
  
  public final int gov()
  {
    return (int)(this.hst / 1000L);
  }
  
  public final void gow()
  {
    try
    {
      AppMethodBeat.i(137320);
      while (gou())
      {
        boolean bool = this.LOl.goB();
        if (!bool) {
          break;
        }
        try
        {
          Log.i("MicroMsg.Music.MMPlayer", "wait play");
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.printErrStackTrace("MicroMsg.Music.MMPlayer", localInterruptedException, "waitPlay", new Object[0]);
        }
      }
      AppMethodBeat.o(137320);
    }
    finally {}
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137321);
    boolean bool = this.LOl.isPlaying();
    AppMethodBeat.o(137321);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137318);
    Log.i("MicroMsg.Music.MMPlayer", "pause");
    if (!gou())
    {
      AppMethodBeat.o(137318);
      return;
    }
    this.LOl.GuE = 2;
    AppMethodBeat.o(137318);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137315);
    Log.i("MicroMsg.Music.MMPlayer", "play");
    if (!gou())
    {
      this.stop = false;
      ThreadPool.post(this.Gsw, "music_player");
      AppMethodBeat.o(137315);
      return;
    }
    if ((gou()) && (this.LOl.goB()))
    {
      this.LOl.GuE = 3;
      aGw();
    }
    AppMethodBeat.o(137315);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137319);
    this.pcp.seekTo(1000L * paramLong, 2);
    AppMethodBeat.o(137319);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137317);
    Log.i("MicroMsg.Music.MMPlayer", "stop");
    this.stop = true;
    if (this.LOl.goB()) {
      aGw();
    }
    AppMethodBeat.o(137317);
  }
  
  public final void zL(boolean paramBoolean)
  {
    AppMethodBeat.i(137322);
    this.LOl.GuE = 4;
    this.stop = true;
    super.zL(paramBoolean);
    AppMethodBeat.o(137322);
  }
  
  public final void zM(boolean paramBoolean)
  {
    AppMethodBeat.i(137323);
    this.LOl.GuE = 4;
    this.stop = true;
    super.zM(paramBoolean);
    AppMethodBeat.o(137323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.c
 * JD-Core Version:    0.7.0.1
 */