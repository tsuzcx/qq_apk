package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(18)
public final class q
  extends a
{
  private int eIz;
  private a.a mnc;
  private a.a mnd;
  
  /* Error */
  private int a(MediaExtractor paramMediaExtractor, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 23
    //   2: ldc 25
    //   4: invokestatic 31	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aconst_null
    //   8: astore 17
    //   10: new 33	com/tencent/mm/plugin/mmsight/segment/h
    //   13: dup
    //   14: invokespecial 34	com/tencent/mm/plugin/mmsight/segment/h:<init>	()V
    //   17: astore 16
    //   19: aload 16
    //   21: aload_0
    //   22: getfield 38	com/tencent/mm/plugin/mmsight/segment/a:eJg	J
    //   25: putfield 41	com/tencent/mm/plugin/mmsight/segment/h:aRW	J
    //   28: aload 16
    //   30: aload_0
    //   31: getfield 44	com/tencent/mm/plugin/mmsight/segment/a:eJh	J
    //   34: putfield 47	com/tencent/mm/plugin/mmsight/segment/h:eIR	J
    //   37: aload_0
    //   38: getfield 51	com/tencent/mm/plugin/mmsight/segment/a:eJf	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   41: astore 17
    //   43: ldc 53
    //   45: ldc 55
    //   47: iconst_1
    //   48: anewarray 57	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload 17
    //   55: aastore
    //   56: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload 16
    //   61: aload 17
    //   63: putfield 63	com/tencent/mm/plugin/mmsight/segment/h:eJA	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   66: aload_0
    //   67: getfield 66	com/tencent/mm/plugin/mmsight/segment/a:eJj	I
    //   70: bipush 90
    //   72: if_icmpeq +13 -> 85
    //   75: aload_0
    //   76: getfield 66	com/tencent/mm/plugin/mmsight/segment/a:eJj	I
    //   79: sipush 270
    //   82: if_icmpne +278 -> 360
    //   85: aload 16
    //   87: aload 17
    //   89: getfield 71	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   92: aload 17
    //   94: getfield 74	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   97: invokevirtual 78	com/tencent/mm/plugin/mmsight/segment/h:by	(II)V
    //   100: aload 16
    //   102: aload 4
    //   104: putfield 82	com/tencent/mm/plugin/mmsight/segment/h:eJC	Ljava/lang/String;
    //   107: aload_0
    //   108: getfield 66	com/tencent/mm/plugin/mmsight/segment/a:eJj	I
    //   111: istore 7
    //   113: ldc 53
    //   115: ldc 84
    //   117: iconst_1
    //   118: anewarray 57	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: iload 7
    //   125: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload 16
    //   134: iload 7
    //   136: putfield 93	com/tencent/mm/plugin/mmsight/segment/h:rotate	I
    //   139: ldc 23
    //   141: ldc 95
    //   143: invokestatic 31	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: ldc 23
    //   148: ldc 97
    //   150: invokestatic 31	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_1
    //   154: aload_0
    //   155: getfield 99	com/tencent/mm/plugin/mmsight/segment/q:mnc	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   158: getfield 104	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   161: invokevirtual 110	android/media/MediaExtractor:selectTrack	(I)V
    //   164: aload_1
    //   165: aload_0
    //   166: getfield 38	com/tencent/mm/plugin/mmsight/segment/a:eJg	J
    //   169: ldc2_w 111
    //   172: lmul
    //   173: iconst_0
    //   174: invokevirtual 116	android/media/MediaExtractor:seekTo	(JI)V
    //   177: aload_0
    //   178: getfield 51	com/tencent/mm/plugin/mmsight/segment/a:eJf	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   181: astore 4
    //   183: aload 4
    //   185: getfield 119	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   188: ifle +219 -> 407
    //   191: aload 4
    //   193: getfield 119	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   196: istore 7
    //   198: aload_0
    //   199: iload 7
    //   201: invokestatic 125	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBuf	(I)I
    //   204: putfield 127	com/tencent/mm/plugin/mmsight/segment/q:eIz	I
    //   207: invokestatic 133	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   210: lstore 11
    //   212: aload_0
    //   213: getfield 99	com/tencent/mm/plugin/mmsight/segment/q:mnc	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   216: getfield 104	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   219: istore 7
    //   221: aload 16
    //   223: aload_1
    //   224: putfield 137	com/tencent/mm/plugin/mmsight/segment/h:eJD	Landroid/media/MediaExtractor;
    //   227: aload 16
    //   229: iload 7
    //   231: putfield 140	com/tencent/mm/plugin/mmsight/segment/h:eIU	I
    //   234: aload 16
    //   236: aload_0
    //   237: getfield 99	com/tencent/mm/plugin/mmsight/segment/q:mnc	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   240: getfield 144	com/tencent/mm/plugin/mmsight/segment/a$a:eIG	Landroid/media/MediaFormat;
    //   243: invokevirtual 148	com/tencent/mm/plugin/mmsight/segment/h:e	(Landroid/media/MediaFormat;)I
    //   246: istore 7
    //   248: iload 7
    //   250: ifge +164 -> 414
    //   253: aload_0
    //   254: getfield 127	com/tencent/mm/plugin/mmsight/segment/q:eIz	I
    //   257: invokestatic 151	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   260: aload_1
    //   261: invokevirtual 154	android/media/MediaExtractor:release	()V
    //   264: getstatic 160	com/tencent/mm/plugin/mmsight/model/a/j:mji	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   267: invokevirtual 163	com/tencent/mm/plugin/mmsight/model/a/j:ET	()V
    //   270: new 165	com/tencent/mm/plugin/mmsight/segment/m
    //   273: dup
    //   274: ldc 167
    //   276: invokespecial 170	com/tencent/mm/plugin/mmsight/segment/m:<init>	(Ljava/lang/String;)V
    //   279: athrow
    //   280: astore 4
    //   282: ldc 23
    //   284: ldc 172
    //   286: iconst_1
    //   287: anewarray 57	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload 4
    //   294: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   297: aastore
    //   298: invokestatic 179	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: new 181	java/lang/RuntimeException
    //   304: dup
    //   305: aload 4
    //   307: invokespecial 184	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   310: athrow
    //   311: astore 4
    //   313: aload_0
    //   314: getfield 127	com/tencent/mm/plugin/mmsight/segment/q:eIz	I
    //   317: invokestatic 151	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   320: aload_1
    //   321: invokevirtual 154	android/media/MediaExtractor:release	()V
    //   324: getstatic 160	com/tencent/mm/plugin/mmsight/model/a/j:mji	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   327: invokevirtual 163	com/tencent/mm/plugin/mmsight/model/a/j:ET	()V
    //   330: aload 4
    //   332: athrow
    //   333: astore_1
    //   334: ldc 23
    //   336: aload_1
    //   337: ldc 186
    //   339: iconst_1
    //   340: anewarray 57	java/lang/Object
    //   343: dup
    //   344: iconst_0
    //   345: aload_1
    //   346: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   349: aastore
    //   350: invokestatic 190	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: aload 16
    //   355: invokevirtual 191	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   358: iconst_m1
    //   359: ireturn
    //   360: aload 16
    //   362: aload 17
    //   364: getfield 74	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   367: aload 17
    //   369: getfield 71	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   372: invokevirtual 78	com/tencent/mm/plugin/mmsight/segment/h:by	(II)V
    //   375: goto -275 -> 100
    //   378: astore_1
    //   379: aload 16
    //   381: astore 4
    //   383: ldc 23
    //   385: aload_1
    //   386: ldc 193
    //   388: iconst_0
    //   389: anewarray 57	java/lang/Object
    //   392: invokestatic 190	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: aload 4
    //   397: ifnull +8 -> 405
    //   400: aload 4
    //   402: invokevirtual 191	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   405: iconst_m1
    //   406: ireturn
    //   407: bipush 10
    //   409: istore 7
    //   411: goto -213 -> 198
    //   414: aload 16
    //   416: getfield 82	com/tencent/mm/plugin/mmsight/segment/h:eJC	Ljava/lang/String;
    //   419: invokestatic 197	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   422: ifne +141 -> 563
    //   425: aload 16
    //   427: getfield 82	com/tencent/mm/plugin/mmsight/segment/h:eJC	Ljava/lang/String;
    //   430: invokestatic 203	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4Info	(Ljava/lang/String;)Ljava/lang/String;
    //   433: astore 17
    //   435: ldc 53
    //   437: ldc 205
    //   439: iconst_1
    //   440: anewarray 57	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload 17
    //   447: aastore
    //   448: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   451: aload 17
    //   453: invokestatic 197	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   456: istore 15
    //   458: iload 15
    //   460: ifne +103 -> 563
    //   463: new 207	org/json/JSONObject
    //   466: dup
    //   467: aload 17
    //   469: invokespecial 208	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   472: ldc 210
    //   474: invokevirtual 214	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   477: d2i
    //   478: istore 7
    //   480: aload 16
    //   482: getfield 63	com/tencent/mm/plugin/mmsight/segment/h:eJA	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   485: ifnull +657 -> 1142
    //   488: aload 16
    //   490: getfield 63	com/tencent/mm/plugin/mmsight/segment/h:eJA	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   493: getfield 217	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   496: ifle +646 -> 1142
    //   499: aload 16
    //   501: getfield 63	com/tencent/mm/plugin/mmsight/segment/h:eJA	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   504: getfield 217	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   507: i2d
    //   508: dstore 5
    //   510: aload 16
    //   512: iload 7
    //   514: i2d
    //   515: dload 5
    //   517: ddiv
    //   518: invokestatic 223	java/lang/Math:ceil	(D)D
    //   521: d2i
    //   522: putfield 226	com/tencent/mm/plugin/mmsight/segment/h:eIV	I
    //   525: ldc 53
    //   527: ldc 228
    //   529: iconst_3
    //   530: anewarray 57	java/lang/Object
    //   533: dup
    //   534: iconst_0
    //   535: aload 16
    //   537: getfield 226	com/tencent/mm/plugin/mmsight/segment/h:eIV	I
    //   540: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   543: aastore
    //   544: dup
    //   545: iconst_1
    //   546: iload 7
    //   548: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   551: aastore
    //   552: dup
    //   553: iconst_2
    //   554: dload 5
    //   556: invokestatic 233	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   559: aastore
    //   560: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   563: aload 16
    //   565: getfield 237	com/tencent/mm/plugin/mmsight/segment/h:mlR	Lcom/tencent/mm/plugin/mmsight/segment/e;
    //   568: aload 16
    //   570: getfield 226	com/tencent/mm/plugin/mmsight/segment/h:eIV	I
    //   573: invokeinterface 242 2 0
    //   578: aload 16
    //   580: getfield 237	com/tencent/mm/plugin/mmsight/segment/h:mlR	Lcom/tencent/mm/plugin/mmsight/segment/e;
    //   583: new 244	com/tencent/mm/plugin/mmsight/segment/h$1
    //   586: dup
    //   587: aload 16
    //   589: invokespecial 247	com/tencent/mm/plugin/mmsight/segment/h$1:<init>	(Lcom/tencent/mm/plugin/mmsight/segment/h;)V
    //   592: invokeinterface 251 2 0
    //   597: lload 11
    //   599: invokestatic 255	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   602: lstore 11
    //   604: aload_1
    //   605: aload_0
    //   606: getfield 99	com/tencent/mm/plugin/mmsight/segment/q:mnc	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   609: getfield 104	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   612: invokevirtual 258	android/media/MediaExtractor:unselectTrack	(I)V
    //   615: iconst_0
    //   616: istore 15
    //   618: aload_0
    //   619: getfield 260	com/tencent/mm/plugin/mmsight/segment/q:mnd	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   622: ifnull +48 -> 670
    //   625: invokestatic 133	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   628: lstore 13
    //   630: aload_0
    //   631: aload_1
    //   632: iload_2
    //   633: iload_3
    //   634: invokespecial 263	com/tencent/mm/plugin/mmsight/segment/q:a	(Landroid/media/MediaExtractor;II)Z
    //   637: istore 15
    //   639: ldc 23
    //   641: ldc_w 265
    //   644: iconst_2
    //   645: anewarray 57	java/lang/Object
    //   648: dup
    //   649: iconst_0
    //   650: lload 13
    //   652: invokestatic 255	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   655: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   658: aastore
    //   659: dup
    //   660: iconst_1
    //   661: iload 15
    //   663: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   666: aastore
    //   667: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   670: invokestatic 133	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   673: lstore 13
    //   675: aload_0
    //   676: invokevirtual 278	com/tencent/mm/plugin/mmsight/segment/q:SV	()Ljava/lang/String;
    //   679: astore 17
    //   681: ldc 23
    //   683: ldc_w 280
    //   686: iconst_1
    //   687: anewarray 57	java/lang/Object
    //   690: dup
    //   691: iconst_0
    //   692: lload 11
    //   694: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   697: aastore
    //   698: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   701: ldc 23
    //   703: ldc_w 282
    //   706: iconst_1
    //   707: anewarray 57	java/lang/Object
    //   710: dup
    //   711: iconst_0
    //   712: aload 17
    //   714: aastore
    //   715: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   718: invokestatic 286	com/tencent/mm/plugin/mmsight/segment/h:bjU	()I
    //   721: lload 11
    //   723: invokestatic 292	com/tencent/mm/plugin/mmsight/segment/n:G	(IJ)V
    //   726: iconst_1
    //   727: istore_3
    //   728: iconst_1
    //   729: istore 8
    //   731: aload 4
    //   733: getfield 295	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   736: istore 7
    //   738: aload 4
    //   740: getfield 298	com/tencent/mm/modelcontrol/VideoTransPara:ejM	I
    //   743: istore 9
    //   745: iload 7
    //   747: istore_2
    //   748: iload 15
    //   750: ifne +400 -> 1150
    //   753: iload 7
    //   755: istore_2
    //   756: iload 8
    //   758: istore_3
    //   759: aload_0
    //   760: getfield 260	com/tencent/mm/plugin/mmsight/segment/q:mnd	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   763: getfield 144	com/tencent/mm/plugin/mmsight/segment/a$a:eIG	Landroid/media/MediaFormat;
    //   766: ldc_w 300
    //   769: invokevirtual 306	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   772: istore 8
    //   774: iload 7
    //   776: istore_2
    //   777: iload 8
    //   779: istore_3
    //   780: aload_0
    //   781: getfield 260	com/tencent/mm/plugin/mmsight/segment/q:mnd	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   784: getfield 144	com/tencent/mm/plugin/mmsight/segment/a$a:eIG	Landroid/media/MediaFormat;
    //   787: ldc_w 308
    //   790: invokevirtual 306	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   793: istore 7
    //   795: iload 7
    //   797: istore_2
    //   798: iload 8
    //   800: istore_3
    //   801: aload_0
    //   802: getfield 260	com/tencent/mm/plugin/mmsight/segment/q:mnd	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   805: getfield 144	com/tencent/mm/plugin/mmsight/segment/a$a:eIG	Landroid/media/MediaFormat;
    //   808: ldc_w 310
    //   811: invokevirtual 306	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   814: istore 10
    //   816: iload 10
    //   818: istore_2
    //   819: iload_2
    //   820: istore_3
    //   821: iload 8
    //   823: istore_2
    //   824: ldc 23
    //   826: ldc_w 312
    //   829: iconst_3
    //   830: anewarray 57	java/lang/Object
    //   833: dup
    //   834: iconst_0
    //   835: iload_2
    //   836: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   839: aastore
    //   840: dup
    //   841: iconst_1
    //   842: iload 7
    //   844: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   847: aastore
    //   848: dup
    //   849: iconst_2
    //   850: iload_3
    //   851: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   854: aastore
    //   855: invokestatic 314	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   858: iload 7
    //   860: sipush 1024
    //   863: iconst_2
    //   864: iload_2
    //   865: aload 17
    //   867: aload 4
    //   869: getfield 217	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   872: i2f
    //   873: aload_0
    //   874: getfield 44	com/tencent/mm/plugin/mmsight/segment/a:eJh	J
    //   877: aload_0
    //   878: getfield 38	com/tencent/mm/plugin/mmsight/segment/a:eJg	J
    //   881: lsub
    //   882: l2i
    //   883: aconst_null
    //   884: iconst_0
    //   885: invokestatic 318	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264	(IIIILjava/lang/String;FI[BI)I
    //   888: istore_2
    //   889: iload_2
    //   890: ifge +85 -> 975
    //   893: ldc 23
    //   895: ldc_w 320
    //   898: iconst_1
    //   899: anewarray 57	java/lang/Object
    //   902: dup
    //   903: iconst_0
    //   904: iload_2
    //   905: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   908: aastore
    //   909: invokestatic 314	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   912: new 165	com/tencent/mm/plugin/mmsight/segment/m
    //   915: dup
    //   916: ldc_w 322
    //   919: invokespecial 170	com/tencent/mm/plugin/mmsight/segment/m:<init>	(Ljava/lang/String;)V
    //   922: athrow
    //   923: astore 17
    //   925: ldc 53
    //   927: aload 17
    //   929: ldc_w 324
    //   932: iconst_1
    //   933: anewarray 57	java/lang/Object
    //   936: dup
    //   937: iconst_0
    //   938: aload 17
    //   940: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   943: aastore
    //   944: invokestatic 190	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   947: goto -384 -> 563
    //   950: astore 18
    //   952: ldc 23
    //   954: ldc_w 326
    //   957: iconst_1
    //   958: anewarray 57	java/lang/Object
    //   961: dup
    //   962: iconst_0
    //   963: aload 18
    //   965: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   968: aastore
    //   969: invokestatic 314	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   972: goto +178 -> 1150
    //   975: aload_0
    //   976: getfield 66	com/tencent/mm/plugin/mmsight/segment/a:eJj	I
    //   979: ifle +106 -> 1085
    //   982: aload_0
    //   983: invokevirtual 278	com/tencent/mm/plugin/mmsight/segment/q:SV	()Ljava/lang/String;
    //   986: aload_0
    //   987: getfield 329	com/tencent/mm/plugin/mmsight/segment/a:eJd	Ljava/lang/String;
    //   990: aload_0
    //   991: getfield 66	com/tencent/mm/plugin/mmsight/segment/a:eJj	I
    //   994: invokestatic 333	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideo	(Ljava/lang/String;Ljava/lang/String;I)V
    //   997: ldc 23
    //   999: ldc_w 335
    //   1002: iconst_1
    //   1003: anewarray 57	java/lang/Object
    //   1006: dup
    //   1007: iconst_0
    //   1008: lload 13
    //   1010: invokestatic 255	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   1013: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1016: aastore
    //   1017: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1020: invokestatic 133	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   1023: lstore 11
    //   1025: aload_0
    //   1026: getfield 329	com/tencent/mm/plugin/mmsight/segment/a:eJd	Ljava/lang/String;
    //   1029: invokestatic 341	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getInstance	()Lcom/tencent/mm/plugin/mmsight/model/CaptureMMProxy;
    //   1032: invokevirtual 345	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getWeixinMeta	()[B
    //   1035: invokestatic 349	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagMP4Dscp	(Ljava/lang/String;[B)V
    //   1038: ldc 23
    //   1040: ldc_w 351
    //   1043: iconst_1
    //   1044: anewarray 57	java/lang/Object
    //   1047: dup
    //   1048: iconst_0
    //   1049: lload 11
    //   1051: invokestatic 255	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   1054: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1057: aastore
    //   1058: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1061: aload_0
    //   1062: getfield 127	com/tencent/mm/plugin/mmsight/segment/q:eIz	I
    //   1065: invokestatic 151	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   1068: aload_1
    //   1069: invokevirtual 154	android/media/MediaExtractor:release	()V
    //   1072: getstatic 160	com/tencent/mm/plugin/mmsight/model/a/j:mji	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   1075: invokevirtual 163	com/tencent/mm/plugin/mmsight/model/a/j:ET	()V
    //   1078: aload 16
    //   1080: invokevirtual 191	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   1083: iconst_0
    //   1084: ireturn
    //   1085: aload_0
    //   1086: invokevirtual 278	com/tencent/mm/plugin/mmsight/segment/q:SV	()Ljava/lang/String;
    //   1089: aload_0
    //   1090: getfield 329	com/tencent/mm/plugin/mmsight/segment/a:eJd	Ljava/lang/String;
    //   1093: invokestatic 357	com/tencent/mm/vfs/e:aA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1096: pop
    //   1097: goto -100 -> 997
    //   1100: astore_1
    //   1101: aload 16
    //   1103: invokevirtual 191	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   1106: aload_1
    //   1107: athrow
    //   1108: astore_1
    //   1109: goto -26 -> 1083
    //   1112: astore_1
    //   1113: goto -755 -> 358
    //   1116: astore 4
    //   1118: goto -12 -> 1106
    //   1121: astore_1
    //   1122: goto -792 -> 330
    //   1125: astore_1
    //   1126: goto -48 -> 1078
    //   1129: astore 4
    //   1131: goto -861 -> 270
    //   1134: astore_1
    //   1135: aload 17
    //   1137: astore 4
    //   1139: goto -756 -> 383
    //   1142: ldc2_w 358
    //   1145: dstore 5
    //   1147: goto -637 -> 510
    //   1150: iload_2
    //   1151: istore 7
    //   1153: iload_3
    //   1154: istore_2
    //   1155: iload 9
    //   1157: istore_3
    //   1158: goto -334 -> 824
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1161	0	this	q
    //   0	1161	1	paramMediaExtractor	MediaExtractor
    //   0	1161	2	paramInt1	int
    //   0	1161	3	paramInt2	int
    //   0	1161	4	paramString	String
    //   508	638	5	d	double
    //   111	1041	7	i	int
    //   729	93	8	j	int
    //   743	413	9	k	int
    //   814	3	10	m	int
    //   210	840	11	l1	long
    //   628	381	13	l2	long
    //   456	293	15	bool	boolean
    //   17	1085	16	localh	h
    //   8	858	17	localObject	Object
    //   923	213	17	localException1	Exception
    //   950	14	18	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   177	198	280	java/lang/Exception
    //   198	248	280	java/lang/Exception
    //   270	280	280	java/lang/Exception
    //   414	458	280	java/lang/Exception
    //   563	615	280	java/lang/Exception
    //   618	670	280	java/lang/Exception
    //   670	726	280	java/lang/Exception
    //   731	745	280	java/lang/Exception
    //   824	889	280	java/lang/Exception
    //   893	923	280	java/lang/Exception
    //   925	947	280	java/lang/Exception
    //   952	972	280	java/lang/Exception
    //   975	997	280	java/lang/Exception
    //   997	1061	280	java/lang/Exception
    //   1085	1097	280	java/lang/Exception
    //   177	198	311	finally
    //   198	248	311	finally
    //   253	270	311	finally
    //   270	280	311	finally
    //   282	311	311	finally
    //   414	458	311	finally
    //   463	510	311	finally
    //   510	563	311	finally
    //   563	615	311	finally
    //   618	670	311	finally
    //   670	726	311	finally
    //   731	745	311	finally
    //   759	774	311	finally
    //   780	795	311	finally
    //   801	816	311	finally
    //   824	889	311	finally
    //   893	923	311	finally
    //   925	947	311	finally
    //   952	972	311	finally
    //   975	997	311	finally
    //   997	1061	311	finally
    //   1085	1097	311	finally
    //   146	177	333	java/lang/Exception
    //   330	333	333	java/lang/Exception
    //   19	85	378	java/lang/Exception
    //   85	100	378	java/lang/Exception
    //   100	139	378	java/lang/Exception
    //   360	375	378	java/lang/Exception
    //   463	510	923	java/lang/Exception
    //   510	563	923	java/lang/Exception
    //   759	774	950	java/lang/Exception
    //   780	795	950	java/lang/Exception
    //   801	816	950	java/lang/Exception
    //   146	177	1100	finally
    //   313	330	1100	finally
    //   330	333	1100	finally
    //   334	353	1100	finally
    //   1061	1078	1100	finally
    //   1078	1083	1108	java/lang/Exception
    //   353	358	1112	java/lang/Exception
    //   1101	1106	1116	java/lang/Exception
    //   313	330	1121	java/lang/Exception
    //   1061	1078	1125	java/lang/Exception
    //   253	270	1129	java/lang/Exception
    //   10	19	1134	java/lang/Exception
  }
  
  private boolean a(MediaExtractor paramMediaExtractor, int paramInt1, int paramInt2)
  {
    if (this.mnd == null) {
      return false;
    }
    paramMediaExtractor.selectTrack(this.mnd.index);
    paramMediaExtractor.seekTo(this.eJg * 1000L, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1);
    try
    {
      this.mnd.eIG.getInteger("channel-count");
      y.i("VideoClipperAPI18", "audio channel count");
      if (CaptureMMProxy.getInstance().getInt(ac.a.utX, 0) != 1) {
        break label430;
      }
      paramMediaExtractor = new g(paramMediaExtractor, this.mnd.eIG, this.eJg, this.eJh, this.eJf);
      paramMediaExtractor.mlI = true;
    }
    catch (Exception localException1)
    {
      try
      {
        paramMediaExtractor.mlF = MediaCodec.createDecoderByType(paramMediaExtractor.jkV);
        paramMediaExtractor.mlF.configure(paramMediaExtractor.eIS, null, null, 0);
        paramMediaExtractor.mlF.start();
        paramMediaExtractor.eIS = paramMediaExtractor.mlF.getOutputFormat();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            paramMediaExtractor.mlH = new MediaFormat();
            paramMediaExtractor.mlH.setString("mime", "audio/mp4a-latm");
            paramMediaExtractor.mlH.setInteger("aac-profile", 2);
            paramMediaExtractor.mlH.setInteger("sample-rate", paramMediaExtractor.eJA.audioSampleRate);
            paramMediaExtractor.mlH.setInteger("channel-count", 1);
            paramMediaExtractor.mlH.setInteger("bitrate", paramMediaExtractor.eJA.ejM);
            paramMediaExtractor.mlH.setInteger("max-input-size", 16384);
            paramMediaExtractor.mlG = MediaCodec.createEncoderByType(paramMediaExtractor.jkV);
            paramMediaExtractor.mlG.configure(paramMediaExtractor.mlH, null, null, 1);
            paramMediaExtractor.mlF.start();
            y.i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", new Object[] { Boolean.valueOf(paramMediaExtractor.mlI) });
            paramMediaExtractor.bjR();
            return true;
            localException3 = localException3;
            y.e("VideoClipperAPI18", "get channel count error: %s", new Object[] { Integer.valueOf(1) });
            continue;
            localException1 = localException1;
            y.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException1, "init decoder error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            y.e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", new Object[] { localException2.getMessage() });
            paramMediaExtractor.mlI = false;
            paramMediaExtractor.mlJ = new ArrayList();
            paramMediaExtractor.mlG.release();
            paramMediaExtractor.mlG = null;
          }
        }
      }
    }
    localException2.position(0);
    MP4MuxerJNI.writeAACData(paramInt2, localException2, paramInt1);
    paramMediaExtractor.advance();
    label430:
    localException2.clear();
    paramInt1 = paramMediaExtractor.readSampleData(localException2, 0);
    y.d("VideoClipperAPI18", "sampleSize: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 <= 0) {
      y.i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      return false;
      if (paramMediaExtractor.getSampleTime() < this.eJh * 1000L)
      {
        if (paramMediaExtractor.getSampleTrackIndex() == this.mnd.index) {
          break;
        }
        y.e("VideoClipperAPI18", "track index not match! break");
      }
    }
  }
  
  public final int E(long paramLong1, long paramLong2)
  {
    n.ug(h.bjU());
    int i = super.E(paramLong1, paramLong2);
    if (i == -1) {
      n.uh(h.bjU());
    }
    return i;
  }
  
  protected final int a(MediaExtractor paramMediaExtractor, List<a.a> paramList1, List<a.a> paramList2)
  {
    this.mnc = ((a.a)paramList2.get(0));
    if ((paramList1 != null) && (paramList1.size() != 0)) {
      this.mnd = ((a.a)paramList1.get(0));
    }
    if (this.eJi <= 0) {}
    for (int i = 1048576; a(paramMediaExtractor, i, this.eIz, this.eJc) == -1; i = this.eJi)
    {
      y.e("VideoClipperAPI18", "transcodeAndMux error");
      release();
      return -1;
    }
    return 0;
  }
  
  public final void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    super.b(paramString1, paramString2, paramVideoTransPara);
  }
  
  /* Error */
  public final int oq(String paramString)
  {
    // Byte code:
    //   0: new 538	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 539	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: invokevirtual 542	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: bipush 17
    //   15: invokestatic 548	com/tencent/mm/compatible/util/d:gF	(I)Z
    //   18: ifeq +106 -> 124
    //   21: aload_3
    //   22: bipush 24
    //   24: invokevirtual 552	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   27: astore_1
    //   28: ldc 23
    //   30: new 554	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 556
    //   37: invokespecial 557	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 566	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_3
    //   51: bipush 19
    //   53: invokevirtual 552	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   56: astore 4
    //   58: aload_3
    //   59: bipush 18
    //   61: invokevirtual 552	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   64: astore 5
    //   66: ldc 23
    //   68: new 554	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 568
    //   75: invokespecial 557	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload 4
    //   80: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 566	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 23
    //   91: new 554	java/lang/StringBuilder
    //   94: dup
    //   95: ldc_w 570
    //   98: invokespecial 557	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload 5
    //   103: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 566	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_1
    //   113: iconst_0
    //   114: invokestatic 573	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   117: istore_2
    //   118: aload_3
    //   119: invokevirtual 574	android/media/MediaMetadataRetriever:release	()V
    //   122: iload_2
    //   123: ireturn
    //   124: new 554	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 575	java/lang/StringBuilder:<init>	()V
    //   131: aload_1
    //   132: invokestatic 578	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4Rotate	(Ljava/lang/String;)I
    //   135: invokevirtual 581	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore_1
    //   142: goto -114 -> 28
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_3
    //   148: aload_3
    //   149: ifnull +7 -> 156
    //   152: aload_3
    //   153: invokevirtual 574	android/media/MediaMetadataRetriever:release	()V
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: goto -11 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	q
    //   0	162	1	paramString	String
    //   117	6	2	i	int
    //   7	146	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   56	23	4	str1	String
    //   64	38	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	8	145	finally
    //   8	28	158	finally
    //   28	118	158	finally
    //   124	142	158	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.q
 * JD-Core Version:    0.7.0.1
 */