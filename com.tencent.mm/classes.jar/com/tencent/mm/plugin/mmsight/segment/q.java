package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(18)
public final class q
  extends a
{
  private int eRm;
  private a.a oMj;
  private a.a oMk;
  
  /* Error */
  private int a(MediaExtractor paramMediaExtractor, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: sipush 3692
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 29
    //   8: ldc 31
    //   10: invokestatic 36	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aconst_null
    //   14: astore 17
    //   16: new 38	com/tencent/mm/plugin/mmsight/segment/h
    //   19: dup
    //   20: invokespecial 39	com/tencent/mm/plugin/mmsight/segment/h:<init>	()V
    //   23: astore 16
    //   25: aload 16
    //   27: aload_0
    //   28: getfield 43	com/tencent/mm/plugin/mmsight/segment/a:fYL	J
    //   31: putfield 46	com/tencent/mm/plugin/mmsight/segment/h:aZw	J
    //   34: aload 16
    //   36: aload_0
    //   37: getfield 49	com/tencent/mm/plugin/mmsight/segment/a:fYM	J
    //   40: putfield 52	com/tencent/mm/plugin/mmsight/segment/h:eRN	J
    //   43: aload_0
    //   44: getfield 56	com/tencent/mm/plugin/mmsight/segment/a:fYK	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   47: astore 17
    //   49: ldc 58
    //   51: ldc 60
    //   53: iconst_1
    //   54: anewarray 62	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload 17
    //   61: aastore
    //   62: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload 16
    //   67: aload 17
    //   69: putfield 68	com/tencent/mm/plugin/mmsight/segment/h:fZe	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   72: aload_0
    //   73: getfield 71	com/tencent/mm/plugin/mmsight/segment/a:mRotationDegree	I
    //   76: bipush 90
    //   78: if_icmpeq +13 -> 91
    //   81: aload_0
    //   82: getfield 71	com/tencent/mm/plugin/mmsight/segment/a:mRotationDegree	I
    //   85: sipush 270
    //   88: if_icmpne +310 -> 398
    //   91: aload 16
    //   93: aload 17
    //   95: getfield 76	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   98: aload 17
    //   100: getfield 79	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   103: invokevirtual 83	com/tencent/mm/plugin/mmsight/segment/h:cI	(II)V
    //   106: aload 16
    //   108: aload 4
    //   110: putfield 87	com/tencent/mm/plugin/mmsight/segment/h:fZg	Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 71	com/tencent/mm/plugin/mmsight/segment/a:mRotationDegree	I
    //   117: istore 7
    //   119: ldc 58
    //   121: ldc 89
    //   123: iconst_1
    //   124: anewarray 62	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: iload 7
    //   131: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: aastore
    //   135: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: aload 16
    //   140: iload 7
    //   142: putfield 98	com/tencent/mm/plugin/mmsight/segment/h:rotate	I
    //   145: ldc 29
    //   147: ldc 100
    //   149: invokestatic 36	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: ldc 29
    //   154: ldc 102
    //   156: invokestatic 36	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_1
    //   160: aload_0
    //   161: getfield 104	com/tencent/mm/plugin/mmsight/segment/q:oMj	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   164: getfield 109	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   167: invokevirtual 114	android/media/MediaExtractor:selectTrack	(I)V
    //   170: aload_1
    //   171: aload_0
    //   172: getfield 43	com/tencent/mm/plugin/mmsight/segment/a:fYL	J
    //   175: ldc2_w 115
    //   178: lmul
    //   179: iconst_0
    //   180: invokevirtual 120	android/media/MediaExtractor:seekTo	(JI)V
    //   183: aload_0
    //   184: getfield 56	com/tencent/mm/plugin/mmsight/segment/a:fYK	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   187: astore 4
    //   189: aload 4
    //   191: getfield 123	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   194: ifle +257 -> 451
    //   197: aload 4
    //   199: getfield 123	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   202: istore 7
    //   204: aload_0
    //   205: iload 7
    //   207: invokestatic 129	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBuf	(I)I
    //   210: putfield 131	com/tencent/mm/plugin/mmsight/segment/q:eRm	I
    //   213: invokestatic 137	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   216: lstore 11
    //   218: aload_0
    //   219: getfield 104	com/tencent/mm/plugin/mmsight/segment/q:oMj	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   222: getfield 109	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   225: istore 7
    //   227: aload 16
    //   229: aload_1
    //   230: putfield 141	com/tencent/mm/plugin/mmsight/segment/h:mediaExtractor	Landroid/media/MediaExtractor;
    //   233: aload 16
    //   235: iload 7
    //   237: putfield 144	com/tencent/mm/plugin/mmsight/segment/h:eUR	I
    //   240: aload 16
    //   242: aload_0
    //   243: getfield 104	com/tencent/mm/plugin/mmsight/segment/q:oMj	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   246: getfield 148	com/tencent/mm/plugin/mmsight/segment/a$a:mediaFormat	Landroid/media/MediaFormat;
    //   249: invokevirtual 152	com/tencent/mm/plugin/mmsight/segment/h:g	(Landroid/media/MediaFormat;)I
    //   252: istore 7
    //   254: iload 7
    //   256: ifge +202 -> 458
    //   259: aload_0
    //   260: getfield 131	com/tencent/mm/plugin/mmsight/segment/q:eRm	I
    //   263: invokestatic 155	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   266: aload_1
    //   267: invokevirtual 158	android/media/MediaExtractor:release	()V
    //   270: getstatic 164	com/tencent/mm/plugin/mmsight/model/a/j:oJp	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   273: invokevirtual 167	com/tencent/mm/plugin/mmsight/model/a/j:XJ	()V
    //   276: new 169	com/tencent/mm/plugin/mmsight/segment/l
    //   279: dup
    //   280: ldc 171
    //   282: invokespecial 174	com/tencent/mm/plugin/mmsight/segment/l:<init>	(Ljava/lang/String;)V
    //   285: astore 4
    //   287: sipush 3692
    //   290: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload 4
    //   295: athrow
    //   296: astore 4
    //   298: ldc 29
    //   300: ldc 179
    //   302: iconst_1
    //   303: anewarray 62	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: aload 4
    //   310: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   313: aastore
    //   314: invokestatic 186	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: new 188	java/lang/RuntimeException
    //   320: dup
    //   321: aload 4
    //   323: invokespecial 191	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   326: astore 4
    //   328: sipush 3692
    //   331: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aload 4
    //   336: athrow
    //   337: astore 4
    //   339: aload_0
    //   340: getfield 131	com/tencent/mm/plugin/mmsight/segment/q:eRm	I
    //   343: invokestatic 155	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   346: aload_1
    //   347: invokevirtual 158	android/media/MediaExtractor:release	()V
    //   350: getstatic 164	com/tencent/mm/plugin/mmsight/model/a/j:oJp	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   353: invokevirtual 167	com/tencent/mm/plugin/mmsight/model/a/j:XJ	()V
    //   356: sipush 3692
    //   359: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aload 4
    //   364: athrow
    //   365: astore_1
    //   366: ldc 29
    //   368: aload_1
    //   369: ldc 193
    //   371: iconst_1
    //   372: anewarray 62	java/lang/Object
    //   375: dup
    //   376: iconst_0
    //   377: aload_1
    //   378: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: aastore
    //   382: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: aload 16
    //   387: invokevirtual 198	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   390: sipush 3692
    //   393: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: iconst_m1
    //   397: ireturn
    //   398: aload 16
    //   400: aload 17
    //   402: getfield 79	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   405: aload 17
    //   407: getfield 76	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   410: invokevirtual 83	com/tencent/mm/plugin/mmsight/segment/h:cI	(II)V
    //   413: goto -307 -> 106
    //   416: astore_1
    //   417: aload 16
    //   419: astore 4
    //   421: ldc 29
    //   423: aload_1
    //   424: ldc 200
    //   426: iconst_0
    //   427: anewarray 62	java/lang/Object
    //   430: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: aload 4
    //   435: ifnull +8 -> 443
    //   438: aload 4
    //   440: invokevirtual 198	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   443: sipush 3692
    //   446: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: iconst_m1
    //   450: ireturn
    //   451: bipush 10
    //   453: istore 7
    //   455: goto -251 -> 204
    //   458: aload 16
    //   460: getfield 87	com/tencent/mm/plugin/mmsight/segment/h:fZg	Ljava/lang/String;
    //   463: invokestatic 204	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   466: ifne +141 -> 607
    //   469: aload 16
    //   471: getfield 87	com/tencent/mm/plugin/mmsight/segment/h:fZg	Ljava/lang/String;
    //   474: invokestatic 210	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4Info	(Ljava/lang/String;)Ljava/lang/String;
    //   477: astore 17
    //   479: ldc 58
    //   481: ldc 212
    //   483: iconst_1
    //   484: anewarray 62	java/lang/Object
    //   487: dup
    //   488: iconst_0
    //   489: aload 17
    //   491: aastore
    //   492: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: aload 17
    //   497: invokestatic 204	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   500: istore 15
    //   502: iload 15
    //   504: ifne +103 -> 607
    //   507: new 214	org/json/JSONObject
    //   510: dup
    //   511: aload 17
    //   513: invokespecial 215	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   516: ldc 217
    //   518: invokevirtual 221	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   521: d2i
    //   522: istore 7
    //   524: aload 16
    //   526: getfield 68	com/tencent/mm/plugin/mmsight/segment/h:fZe	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   529: ifnull +680 -> 1209
    //   532: aload 16
    //   534: getfield 68	com/tencent/mm/plugin/mmsight/segment/h:fZe	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   537: getfield 224	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   540: ifle +669 -> 1209
    //   543: aload 16
    //   545: getfield 68	com/tencent/mm/plugin/mmsight/segment/h:fZe	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   548: getfield 224	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   551: i2d
    //   552: dstore 5
    //   554: aload 16
    //   556: iload 7
    //   558: i2d
    //   559: dload 5
    //   561: ddiv
    //   562: invokestatic 230	java/lang/Math:ceil	(D)D
    //   565: d2i
    //   566: putfield 233	com/tencent/mm/plugin/mmsight/segment/h:eRW	I
    //   569: ldc 58
    //   571: ldc 235
    //   573: iconst_3
    //   574: anewarray 62	java/lang/Object
    //   577: dup
    //   578: iconst_0
    //   579: aload 16
    //   581: getfield 233	com/tencent/mm/plugin/mmsight/segment/h:eRW	I
    //   584: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   587: aastore
    //   588: dup
    //   589: iconst_1
    //   590: iload 7
    //   592: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   595: aastore
    //   596: dup
    //   597: iconst_2
    //   598: dload 5
    //   600: invokestatic 240	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   603: aastore
    //   604: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   607: aload 16
    //   609: getfield 244	com/tencent/mm/plugin/mmsight/segment/h:oKY	Lcom/tencent/mm/plugin/mmsight/segment/e;
    //   612: aload 16
    //   614: getfield 233	com/tencent/mm/plugin/mmsight/segment/h:eRW	I
    //   617: invokeinterface 249 2 0
    //   622: aload 16
    //   624: getfield 244	com/tencent/mm/plugin/mmsight/segment/h:oKY	Lcom/tencent/mm/plugin/mmsight/segment/e;
    //   627: new 251	com/tencent/mm/plugin/mmsight/segment/h$1
    //   630: dup
    //   631: aload 16
    //   633: invokespecial 254	com/tencent/mm/plugin/mmsight/segment/h$1:<init>	(Lcom/tencent/mm/plugin/mmsight/segment/h;)V
    //   636: invokeinterface 258 2 0
    //   641: lload 11
    //   643: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   646: lstore 11
    //   648: aload_1
    //   649: aload_0
    //   650: getfield 104	com/tencent/mm/plugin/mmsight/segment/q:oMj	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   653: getfield 109	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   656: invokevirtual 265	android/media/MediaExtractor:unselectTrack	(I)V
    //   659: iconst_0
    //   660: istore 15
    //   662: aload_0
    //   663: getfield 267	com/tencent/mm/plugin/mmsight/segment/q:oMk	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   666: ifnull +48 -> 714
    //   669: invokestatic 137	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   672: lstore 13
    //   674: aload_0
    //   675: aload_1
    //   676: iload_2
    //   677: iload_3
    //   678: invokespecial 270	com/tencent/mm/plugin/mmsight/segment/q:a	(Landroid/media/MediaExtractor;II)Z
    //   681: istore 15
    //   683: ldc 29
    //   685: ldc_w 272
    //   688: iconst_2
    //   689: anewarray 62	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: lload 13
    //   696: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   699: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   702: aastore
    //   703: dup
    //   704: iconst_1
    //   705: iload 15
    //   707: invokestatic 282	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   710: aastore
    //   711: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   714: invokestatic 137	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   717: lstore 13
    //   719: aload_0
    //   720: invokevirtual 285	com/tencent/mm/plugin/mmsight/segment/q:amg	()Ljava/lang/String;
    //   723: astore 17
    //   725: ldc 29
    //   727: ldc_w 287
    //   730: iconst_1
    //   731: anewarray 62	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: lload 11
    //   738: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   741: aastore
    //   742: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: ldc 29
    //   747: ldc_w 289
    //   750: iconst_1
    //   751: anewarray 62	java/lang/Object
    //   754: dup
    //   755: iconst_0
    //   756: aload 17
    //   758: aastore
    //   759: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   762: invokestatic 293	com/tencent/mm/plugin/mmsight/segment/h:bRH	()I
    //   765: lload 11
    //   767: invokestatic 299	com/tencent/mm/plugin/mmsight/segment/m:W	(IJ)V
    //   770: iconst_1
    //   771: istore_3
    //   772: iconst_1
    //   773: istore 8
    //   775: aload 4
    //   777: getfield 302	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   780: istore 7
    //   782: aload 4
    //   784: getfield 305	com/tencent/mm/modelcontrol/VideoTransPara:fzT	I
    //   787: istore 9
    //   789: iload 7
    //   791: istore_2
    //   792: iload 15
    //   794: ifne +423 -> 1217
    //   797: iload 7
    //   799: istore_2
    //   800: iload 8
    //   802: istore_3
    //   803: aload_0
    //   804: getfield 267	com/tencent/mm/plugin/mmsight/segment/q:oMk	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   807: getfield 148	com/tencent/mm/plugin/mmsight/segment/a$a:mediaFormat	Landroid/media/MediaFormat;
    //   810: ldc_w 307
    //   813: invokevirtual 313	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   816: istore 8
    //   818: iload 7
    //   820: istore_2
    //   821: iload 8
    //   823: istore_3
    //   824: aload_0
    //   825: getfield 267	com/tencent/mm/plugin/mmsight/segment/q:oMk	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   828: getfield 148	com/tencent/mm/plugin/mmsight/segment/a$a:mediaFormat	Landroid/media/MediaFormat;
    //   831: ldc_w 315
    //   834: invokevirtual 313	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   837: istore 7
    //   839: iload 7
    //   841: istore_2
    //   842: iload 8
    //   844: istore_3
    //   845: aload_0
    //   846: getfield 267	com/tencent/mm/plugin/mmsight/segment/q:oMk	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   849: getfield 148	com/tencent/mm/plugin/mmsight/segment/a$a:mediaFormat	Landroid/media/MediaFormat;
    //   852: ldc_w 317
    //   855: invokevirtual 313	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   858: istore 10
    //   860: iload 10
    //   862: istore_2
    //   863: iload_2
    //   864: istore_3
    //   865: iload 8
    //   867: istore_2
    //   868: ldc 29
    //   870: ldc_w 319
    //   873: iconst_3
    //   874: anewarray 62	java/lang/Object
    //   877: dup
    //   878: iconst_0
    //   879: iload_2
    //   880: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   883: aastore
    //   884: dup
    //   885: iconst_1
    //   886: iload 7
    //   888: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   891: aastore
    //   892: dup
    //   893: iconst_2
    //   894: iload_3
    //   895: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   898: aastore
    //   899: invokestatic 322	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   902: iload 7
    //   904: sipush 1024
    //   907: iconst_2
    //   908: iload_2
    //   909: aload 17
    //   911: aload 4
    //   913: getfield 224	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   916: i2f
    //   917: aload_0
    //   918: getfield 49	com/tencent/mm/plugin/mmsight/segment/a:fYM	J
    //   921: aload_0
    //   922: getfield 43	com/tencent/mm/plugin/mmsight/segment/a:fYL	J
    //   925: lsub
    //   926: l2i
    //   927: aconst_null
    //   928: iconst_0
    //   929: invokestatic 326	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264	(IIIILjava/lang/String;FI[BI)I
    //   932: istore_2
    //   933: iload_2
    //   934: ifge +95 -> 1029
    //   937: ldc 29
    //   939: ldc_w 328
    //   942: iconst_1
    //   943: anewarray 62	java/lang/Object
    //   946: dup
    //   947: iconst_0
    //   948: iload_2
    //   949: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   952: aastore
    //   953: invokestatic 322	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   956: new 169	com/tencent/mm/plugin/mmsight/segment/l
    //   959: dup
    //   960: ldc_w 330
    //   963: invokespecial 174	com/tencent/mm/plugin/mmsight/segment/l:<init>	(Ljava/lang/String;)V
    //   966: astore 4
    //   968: sipush 3692
    //   971: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   974: aload 4
    //   976: athrow
    //   977: astore 17
    //   979: ldc 58
    //   981: aload 17
    //   983: ldc_w 332
    //   986: iconst_1
    //   987: anewarray 62	java/lang/Object
    //   990: dup
    //   991: iconst_0
    //   992: aload 17
    //   994: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   997: aastore
    //   998: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1001: goto -394 -> 607
    //   1004: astore 18
    //   1006: ldc 29
    //   1008: ldc_w 334
    //   1011: iconst_1
    //   1012: anewarray 62	java/lang/Object
    //   1015: dup
    //   1016: iconst_0
    //   1017: aload 18
    //   1019: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1022: aastore
    //   1023: invokestatic 322	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1026: goto +191 -> 1217
    //   1029: aload_0
    //   1030: getfield 71	com/tencent/mm/plugin/mmsight/segment/a:mRotationDegree	I
    //   1033: ifle +113 -> 1146
    //   1036: aload_0
    //   1037: invokevirtual 285	com/tencent/mm/plugin/mmsight/segment/q:amg	()Ljava/lang/String;
    //   1040: aload_0
    //   1041: getfield 337	com/tencent/mm/plugin/mmsight/segment/a:fYJ	Ljava/lang/String;
    //   1044: aload_0
    //   1045: getfield 71	com/tencent/mm/plugin/mmsight/segment/a:mRotationDegree	I
    //   1048: invokestatic 341	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideo	(Ljava/lang/String;Ljava/lang/String;I)I
    //   1051: pop
    //   1052: ldc 29
    //   1054: ldc_w 343
    //   1057: iconst_1
    //   1058: anewarray 62	java/lang/Object
    //   1061: dup
    //   1062: iconst_0
    //   1063: lload 13
    //   1065: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   1068: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1071: aastore
    //   1072: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1075: invokestatic 137	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   1078: lstore 11
    //   1080: aload_0
    //   1081: getfield 337	com/tencent/mm/plugin/mmsight/segment/a:fYJ	Ljava/lang/String;
    //   1084: invokestatic 349	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getInstance	()Lcom/tencent/mm/plugin/mmsight/model/CaptureMMProxy;
    //   1087: invokevirtual 353	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getWeixinMeta	()[B
    //   1090: invokestatic 357	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagMP4Dscp	(Ljava/lang/String;[B)V
    //   1093: ldc 29
    //   1095: ldc_w 359
    //   1098: iconst_1
    //   1099: anewarray 62	java/lang/Object
    //   1102: dup
    //   1103: iconst_0
    //   1104: lload 11
    //   1106: invokestatic 262	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   1109: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1112: aastore
    //   1113: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1116: aload_0
    //   1117: getfield 131	com/tencent/mm/plugin/mmsight/segment/q:eRm	I
    //   1120: invokestatic 155	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   1123: aload_1
    //   1124: invokevirtual 158	android/media/MediaExtractor:release	()V
    //   1127: getstatic 164	com/tencent/mm/plugin/mmsight/model/a/j:oJp	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   1130: invokevirtual 167	com/tencent/mm/plugin/mmsight/model/a/j:XJ	()V
    //   1133: aload 16
    //   1135: invokevirtual 198	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   1138: sipush 3692
    //   1141: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1144: iconst_0
    //   1145: ireturn
    //   1146: aload_0
    //   1147: invokevirtual 285	com/tencent/mm/plugin/mmsight/segment/q:amg	()Ljava/lang/String;
    //   1150: aload_0
    //   1151: getfield 337	com/tencent/mm/plugin/mmsight/segment/a:fYJ	Ljava/lang/String;
    //   1154: invokestatic 365	com/tencent/mm/vfs/e:aT	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1157: pop
    //   1158: goto -106 -> 1052
    //   1161: astore_1
    //   1162: aload 16
    //   1164: invokevirtual 198	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   1167: sipush 3692
    //   1170: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1173: aload_1
    //   1174: athrow
    //   1175: astore_1
    //   1176: goto -38 -> 1138
    //   1179: astore_1
    //   1180: goto -790 -> 390
    //   1183: astore 4
    //   1185: goto -18 -> 1167
    //   1188: astore_1
    //   1189: goto -833 -> 356
    //   1192: astore_1
    //   1193: goto -60 -> 1133
    //   1196: astore 4
    //   1198: goto -922 -> 276
    //   1201: astore_1
    //   1202: aload 17
    //   1204: astore 4
    //   1206: goto -785 -> 421
    //   1209: ldc2_w 366
    //   1212: dstore 5
    //   1214: goto -660 -> 554
    //   1217: iload_2
    //   1218: istore 7
    //   1220: iload_3
    //   1221: istore_2
    //   1222: iload 9
    //   1224: istore_3
    //   1225: goto -357 -> 868
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1228	0	this	q
    //   0	1228	1	paramMediaExtractor	MediaExtractor
    //   0	1228	2	paramInt1	int
    //   0	1228	3	paramInt2	int
    //   0	1228	4	paramString	String
    //   552	661	5	d	double
    //   117	1102	7	i	int
    //   773	93	8	j	int
    //   787	436	9	k	int
    //   858	3	10	m	int
    //   216	889	11	l1	long
    //   672	392	13	l2	long
    //   500	293	15	bool	boolean
    //   23	1140	16	localh	h
    //   14	896	17	localObject	Object
    //   977	226	17	localException1	Exception
    //   1004	14	18	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   183	204	296	java/lang/Exception
    //   204	254	296	java/lang/Exception
    //   276	296	296	java/lang/Exception
    //   458	502	296	java/lang/Exception
    //   607	659	296	java/lang/Exception
    //   662	714	296	java/lang/Exception
    //   714	770	296	java/lang/Exception
    //   775	789	296	java/lang/Exception
    //   868	933	296	java/lang/Exception
    //   937	977	296	java/lang/Exception
    //   979	1001	296	java/lang/Exception
    //   1006	1026	296	java/lang/Exception
    //   1029	1052	296	java/lang/Exception
    //   1052	1116	296	java/lang/Exception
    //   1146	1158	296	java/lang/Exception
    //   183	204	337	finally
    //   204	254	337	finally
    //   259	276	337	finally
    //   276	296	337	finally
    //   298	337	337	finally
    //   458	502	337	finally
    //   507	554	337	finally
    //   554	607	337	finally
    //   607	659	337	finally
    //   662	714	337	finally
    //   714	770	337	finally
    //   775	789	337	finally
    //   803	818	337	finally
    //   824	839	337	finally
    //   845	860	337	finally
    //   868	933	337	finally
    //   937	977	337	finally
    //   979	1001	337	finally
    //   1006	1026	337	finally
    //   1029	1052	337	finally
    //   1052	1116	337	finally
    //   1146	1158	337	finally
    //   152	183	365	java/lang/Exception
    //   356	365	365	java/lang/Exception
    //   25	91	416	java/lang/Exception
    //   91	106	416	java/lang/Exception
    //   106	145	416	java/lang/Exception
    //   398	413	416	java/lang/Exception
    //   507	554	977	java/lang/Exception
    //   554	607	977	java/lang/Exception
    //   803	818	1004	java/lang/Exception
    //   824	839	1004	java/lang/Exception
    //   845	860	1004	java/lang/Exception
    //   152	183	1161	finally
    //   339	356	1161	finally
    //   356	365	1161	finally
    //   366	385	1161	finally
    //   1116	1133	1161	finally
    //   1133	1138	1175	java/lang/Exception
    //   385	390	1179	java/lang/Exception
    //   1162	1167	1183	java/lang/Exception
    //   339	356	1188	java/lang/Exception
    //   1116	1133	1192	java/lang/Exception
    //   259	276	1196	java/lang/Exception
    //   16	25	1201	java/lang/Exception
  }
  
  private boolean a(MediaExtractor paramMediaExtractor, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3693);
    if (this.oMk == null)
    {
      AppMethodBeat.o(3693);
      return false;
    }
    paramMediaExtractor.selectTrack(this.oMk.index);
    paramMediaExtractor.seekTo(this.fYL * 1000L, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1);
    try
    {
      this.oMk.mediaFormat.getInteger("channel-count");
      ab.i("VideoClipperAPI18", "audio channel count");
      if (CaptureMMProxy.getInstance().getInt(ac.a.yEa, 0) != 1) {
        break label448;
      }
      paramMediaExtractor = new g(paramMediaExtractor, this.oMk.mediaFormat, this.fYL, this.fYM, this.fYK);
      paramMediaExtractor.oKP = true;
    }
    catch (Exception localException1)
    {
      try
      {
        paramMediaExtractor.oKN = MediaCodec.createDecoderByType(paramMediaExtractor.cfP);
        paramMediaExtractor.oKN.configure(paramMediaExtractor.fYw, null, null, 0);
        paramMediaExtractor.oKN.start();
        paramMediaExtractor.fYw = paramMediaExtractor.oKN.getOutputFormat();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            paramMediaExtractor.eUh = new MediaFormat();
            paramMediaExtractor.eUh.setString("mime", "audio/mp4a-latm");
            paramMediaExtractor.eUh.setInteger("aac-profile", 2);
            paramMediaExtractor.eUh.setInteger("sample-rate", paramMediaExtractor.fZe.audioSampleRate);
            paramMediaExtractor.eUh.setInteger("channel-count", 1);
            paramMediaExtractor.eUh.setInteger("bitrate", paramMediaExtractor.fZe.fzT);
            paramMediaExtractor.eUh.setInteger("max-input-size", 16384);
            paramMediaExtractor.oKO = MediaCodec.createEncoderByType(paramMediaExtractor.cfP);
            paramMediaExtractor.oKO.configure(paramMediaExtractor.eUh, null, null, 1);
            paramMediaExtractor.oKN.start();
            ab.i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", new Object[] { Boolean.valueOf(paramMediaExtractor.oKP) });
            paramMediaExtractor.bRE();
            AppMethodBeat.o(3693);
            return true;
            localException3 = localException3;
            ab.e("VideoClipperAPI18", "get channel count error: %s", new Object[] { Integer.valueOf(1) });
            continue;
            localException1 = localException1;
            ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException1, "init decoder error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", new Object[] { localException2.getMessage() });
            paramMediaExtractor.oKP = false;
            paramMediaExtractor.oKQ = new ArrayList();
            paramMediaExtractor.oKO.release();
            paramMediaExtractor.oKO = null;
          }
        }
      }
    }
    localException2.position(0);
    MP4MuxerJNI.writeAACData(paramInt2, localException2, paramInt1);
    paramMediaExtractor.advance();
    label448:
    localException2.clear();
    paramInt1 = paramMediaExtractor.readSampleData(localException2, 0);
    ab.d("VideoClipperAPI18", "sampleSize: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 <= 0) {
      ab.i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      AppMethodBeat.o(3693);
      return false;
      if (paramMediaExtractor.getSampleTime() < this.fYM * 1000L)
      {
        if (paramMediaExtractor.getSampleTrackIndex() == this.oMk.index) {
          break;
        }
        ab.e("VideoClipperAPI18", "track index not match! break");
      }
    }
  }
  
  public final int Q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(3690);
    m.zu(h.bRH());
    int i = super.Q(paramLong1, paramLong2);
    if (i == -1) {
      m.zv(h.bRH());
    }
    AppMethodBeat.o(3690);
    return i;
  }
  
  protected final int a(MediaExtractor paramMediaExtractor, List<a.a> paramList1, List<a.a> paramList2)
  {
    AppMethodBeat.i(3691);
    this.oMj = ((a.a)paramList2.get(0));
    if ((paramList1 != null) && (paramList1.size() != 0)) {
      this.oMk = ((a.a)paramList1.get(0));
    }
    if (this.fYN <= 0) {}
    for (int i = 1048576; a(paramMediaExtractor, i, this.eRm, this.fYI) == -1; i = this.fYN)
    {
      ab.e("VideoClipperAPI18", "transcodeAndMux error");
      release();
      AppMethodBeat.o(3691);
      return -1;
    }
    AppMethodBeat.o(3691);
    return 0;
  }
  
  public final void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(3689);
    super.b(paramString1, paramString2, paramVideoTransPara);
    AppMethodBeat.o(3689);
  }
  
  /* Error */
  public final int vE(String paramString)
  {
    // Byte code:
    //   0: sipush 3694
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 546	android/media/MediaMetadataRetriever
    //   9: dup
    //   10: invokespecial 547	android/media/MediaMetadataRetriever:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: invokevirtual 550	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   19: bipush 17
    //   21: invokestatic 556	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   24: ifeq +91 -> 115
    //   27: aload_3
    //   28: bipush 24
    //   30: invokevirtual 560	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   33: astore_1
    //   34: ldc 29
    //   36: ldc_w 562
    //   39: aload_1
    //   40: invokestatic 567	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokevirtual 570	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 572	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_3
    //   50: bipush 19
    //   52: invokevirtual 560	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   55: astore 4
    //   57: aload_3
    //   58: bipush 18
    //   60: invokevirtual 560	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   63: astore 5
    //   65: ldc 29
    //   67: ldc_w 574
    //   70: aload 4
    //   72: invokestatic 567	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokevirtual 570	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   78: invokestatic 572	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: ldc 29
    //   83: ldc_w 576
    //   86: aload 5
    //   88: invokestatic 567	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: invokevirtual 570	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokestatic 572	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: iconst_0
    //   99: invokestatic 579	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   102: istore_2
    //   103: aload_3
    //   104: invokevirtual 580	android/media/MediaMetadataRetriever:release	()V
    //   107: sipush 3694
    //   110: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iload_2
    //   114: ireturn
    //   115: new 582	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   122: aload_1
    //   123: invokestatic 586	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4Rotate	(Ljava/lang/String;)I
    //   126: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 593	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_1
    //   133: goto -99 -> 34
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 580	android/media/MediaMetadataRetriever:release	()V
    //   147: sipush 3694
    //   150: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: goto -17 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	q
    //   0	159	1	paramString	String
    //   102	12	2	i	int
    //   13	131	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   55	16	4	str1	String
    //   63	24	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   6	14	136	finally
    //   14	34	155	finally
    //   34	103	155	finally
    //   115	133	155	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.q
 * JD-Core Version:    0.7.0.1
 */