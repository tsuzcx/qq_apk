package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(18)
public final class q
  extends a
{
  private a.a Fey;
  private a.a Fez;
  private int bufId;
  
  /* Error */
  private int a(c paramc, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 30
    //   7: ldc 32
    //   9: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aconst_null
    //   13: astore 17
    //   15: new 39	com/tencent/mm/plugin/mmsight/segment/h
    //   18: dup
    //   19: invokespecial 40	com/tencent/mm/plugin/mmsight/segment/h:<init>	()V
    //   22: astore 16
    //   24: aload 16
    //   26: aload_0
    //   27: invokevirtual 44	com/tencent/mm/plugin/mmsight/segment/q:getStartTimeMs	()J
    //   30: putfield 48	com/tencent/mm/plugin/mmsight/segment/h:startTimeMs	J
    //   33: aload 16
    //   35: aload_0
    //   36: invokevirtual 51	com/tencent/mm/plugin/mmsight/segment/q:getEndTimeMs	()J
    //   39: putfield 54	com/tencent/mm/plugin/mmsight/segment/h:endTimeMs	J
    //   42: aload_0
    //   43: invokevirtual 58	com/tencent/mm/plugin/mmsight/segment/q:eTQ	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   46: astore 17
    //   48: ldc 60
    //   50: ldc 62
    //   52: iconst_1
    //   53: anewarray 64	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload 17
    //   60: aastore
    //   61: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload 16
    //   66: aload 17
    //   68: putfield 71	com/tencent/mm/plugin/mmsight/segment/h:mjz	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   71: aload_0
    //   72: invokevirtual 75	com/tencent/mm/plugin/mmsight/segment/q:eTU	()I
    //   75: bipush 90
    //   77: if_icmpeq +13 -> 90
    //   80: aload_0
    //   81: invokevirtual 75	com/tencent/mm/plugin/mmsight/segment/q:eTU	()I
    //   84: sipush 270
    //   87: if_icmpne +312 -> 399
    //   90: aload 16
    //   92: aload 17
    //   94: getfield 80	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   97: aload 17
    //   99: getfield 83	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   102: invokevirtual 87	com/tencent/mm/plugin/mmsight/segment/h:dX	(II)V
    //   105: aload 16
    //   107: aload 4
    //   109: putfield 91	com/tencent/mm/plugin/mmsight/segment/h:mjB	Ljava/lang/String;
    //   112: aload_0
    //   113: invokevirtual 75	com/tencent/mm/plugin/mmsight/segment/q:eTU	()I
    //   116: istore 7
    //   118: ldc 60
    //   120: ldc 93
    //   122: iconst_1
    //   123: anewarray 64	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: iload 7
    //   130: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 16
    //   139: iload 7
    //   141: putfield 102	com/tencent/mm/plugin/mmsight/segment/h:fSM	I
    //   144: ldc 30
    //   146: ldc 104
    //   148: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc 30
    //   153: ldc 106
    //   155: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_1
    //   159: aload_0
    //   160: getfield 108	com/tencent/mm/plugin/mmsight/segment/q:Fey	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   163: getfield 113	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   166: invokevirtual 118	com/tencent/mm/compatible/i/c:selectTrack	(I)V
    //   169: aload_1
    //   170: aload_0
    //   171: invokevirtual 44	com/tencent/mm/plugin/mmsight/segment/q:getStartTimeMs	()J
    //   174: ldc2_w 119
    //   177: lmul
    //   178: iconst_0
    //   179: invokevirtual 124	com/tencent/mm/compatible/i/c:seekTo	(JI)V
    //   182: aload_0
    //   183: invokevirtual 58	com/tencent/mm/plugin/mmsight/segment/q:eTQ	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   186: astore 4
    //   188: aload 4
    //   190: getfield 127	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   193: ifle +258 -> 451
    //   196: aload 4
    //   198: getfield 127	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   201: istore 7
    //   203: aload_0
    //   204: iload 7
    //   206: invokestatic 133	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBuf	(I)I
    //   209: putfield 135	com/tencent/mm/plugin/mmsight/segment/q:bufId	I
    //   212: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   215: lstore 11
    //   217: aload_0
    //   218: getfield 108	com/tencent/mm/plugin/mmsight/segment/q:Fey	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   221: getfield 113	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   224: istore 7
    //   226: aload 16
    //   228: aload_1
    //   229: putfield 144	com/tencent/mm/plugin/mmsight/segment/h:kUU	Lcom/tencent/mm/compatible/i/c;
    //   232: aload 16
    //   234: iload 7
    //   236: putfield 147	com/tencent/mm/plugin/mmsight/segment/h:videoTrackIndex	I
    //   239: aload 16
    //   241: aload_0
    //   242: getfield 108	com/tencent/mm/plugin/mmsight/segment/q:Fey	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   245: getfield 151	com/tencent/mm/plugin/mmsight/segment/a$a:mediaFormat	Landroid/media/MediaFormat;
    //   248: invokevirtual 155	com/tencent/mm/plugin/mmsight/segment/h:f	(Landroid/media/MediaFormat;)I
    //   251: istore 7
    //   253: iload 7
    //   255: ifge +203 -> 458
    //   258: aload_0
    //   259: getfield 135	com/tencent/mm/plugin/mmsight/segment/q:bufId	I
    //   262: invokestatic 158	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   265: aload_1
    //   266: getfield 162	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   269: invokevirtual 167	android/media/MediaExtractor:release	()V
    //   272: getstatic 173	com/tencent/mm/plugin/mmsight/model/a/j:FbH	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   275: invokevirtual 176	com/tencent/mm/plugin/mmsight/model/a/j:baL	()V
    //   278: new 178	com/tencent/mm/plugin/mmsight/segment/m
    //   281: dup
    //   282: ldc 180
    //   284: invokespecial 183	com/tencent/mm/plugin/mmsight/segment/m:<init>	(Ljava/lang/String;)V
    //   287: astore 4
    //   289: ldc 22
    //   291: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload 4
    //   296: athrow
    //   297: astore 4
    //   299: ldc 30
    //   301: ldc 188
    //   303: iconst_1
    //   304: anewarray 64	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload 4
    //   311: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   314: aastore
    //   315: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: new 197	java/lang/RuntimeException
    //   321: dup
    //   322: aload 4
    //   324: invokespecial 200	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   327: astore 4
    //   329: ldc 22
    //   331: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aload 4
    //   336: athrow
    //   337: astore 4
    //   339: aload_0
    //   340: getfield 135	com/tencent/mm/plugin/mmsight/segment/q:bufId	I
    //   343: invokestatic 158	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   346: aload_1
    //   347: getfield 162	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   350: invokevirtual 167	android/media/MediaExtractor:release	()V
    //   353: getstatic 173	com/tencent/mm/plugin/mmsight/model/a/j:FbH	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   356: invokevirtual 176	com/tencent/mm/plugin/mmsight/model/a/j:baL	()V
    //   359: ldc 22
    //   361: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aload 4
    //   366: athrow
    //   367: astore_1
    //   368: ldc 30
    //   370: aload_1
    //   371: ldc 202
    //   373: iconst_1
    //   374: anewarray 64	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: aload_1
    //   380: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   383: aastore
    //   384: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: aload 16
    //   389: invokevirtual 207	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   392: ldc 22
    //   394: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   397: iconst_m1
    //   398: ireturn
    //   399: aload 16
    //   401: aload 17
    //   403: getfield 83	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   406: aload 17
    //   408: getfield 80	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   411: invokevirtual 87	com/tencent/mm/plugin/mmsight/segment/h:dX	(II)V
    //   414: goto -309 -> 105
    //   417: astore_1
    //   418: aload 16
    //   420: astore 4
    //   422: ldc 30
    //   424: aload_1
    //   425: ldc 209
    //   427: iconst_0
    //   428: anewarray 64	java/lang/Object
    //   431: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: aload 4
    //   436: ifnull +8 -> 444
    //   439: aload 4
    //   441: invokevirtual 207	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   444: ldc 22
    //   446: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: iconst_m1
    //   450: ireturn
    //   451: bipush 10
    //   453: istore 7
    //   455: goto -252 -> 203
    //   458: aload 16
    //   460: getfield 91	com/tencent/mm/plugin/mmsight/segment/h:mjB	Ljava/lang/String;
    //   463: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   466: ifne +141 -> 607
    //   469: aload 16
    //   471: getfield 91	com/tencent/mm/plugin/mmsight/segment/h:mjB	Ljava/lang/String;
    //   474: invokestatic 219	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   477: astore 17
    //   479: ldc 60
    //   481: ldc 221
    //   483: iconst_1
    //   484: anewarray 64	java/lang/Object
    //   487: dup
    //   488: iconst_0
    //   489: aload 17
    //   491: aastore
    //   492: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: aload 17
    //   497: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   500: istore 15
    //   502: iload 15
    //   504: ifne +103 -> 607
    //   507: new 223	org/json/JSONObject
    //   510: dup
    //   511: aload 17
    //   513: invokespecial 224	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   516: ldc 226
    //   518: invokevirtual 230	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   521: d2i
    //   522: istore 7
    //   524: aload 16
    //   526: getfield 71	com/tencent/mm/plugin/mmsight/segment/h:mjz	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   529: ifnull +680 -> 1209
    //   532: aload 16
    //   534: getfield 71	com/tencent/mm/plugin/mmsight/segment/h:mjz	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   537: getfield 233	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   540: ifle +669 -> 1209
    //   543: aload 16
    //   545: getfield 71	com/tencent/mm/plugin/mmsight/segment/h:mjz	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   548: getfield 233	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   551: i2d
    //   552: dstore 5
    //   554: aload 16
    //   556: iload 7
    //   558: i2d
    //   559: dload 5
    //   561: ddiv
    //   562: invokestatic 239	java/lang/Math:ceil	(D)D
    //   565: d2i
    //   566: putfield 242	com/tencent/mm/plugin/mmsight/segment/h:kTg	I
    //   569: ldc 60
    //   571: ldc 244
    //   573: iconst_3
    //   574: anewarray 64	java/lang/Object
    //   577: dup
    //   578: iconst_0
    //   579: aload 16
    //   581: getfield 242	com/tencent/mm/plugin/mmsight/segment/h:kTg	I
    //   584: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   587: aastore
    //   588: dup
    //   589: iconst_1
    //   590: iload 7
    //   592: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   595: aastore
    //   596: dup
    //   597: iconst_2
    //   598: dload 5
    //   600: invokestatic 249	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   603: aastore
    //   604: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   607: aload 16
    //   609: getfield 253	com/tencent/mm/plugin/mmsight/segment/h:FdU	Lcom/tencent/mm/plugin/mmsight/segment/e;
    //   612: aload 16
    //   614: getfield 242	com/tencent/mm/plugin/mmsight/segment/h:kTg	I
    //   617: invokeinterface 258 2 0
    //   622: aload 16
    //   624: getfield 253	com/tencent/mm/plugin/mmsight/segment/h:FdU	Lcom/tencent/mm/plugin/mmsight/segment/e;
    //   627: new 260	com/tencent/mm/plugin/mmsight/segment/h$1
    //   630: dup
    //   631: aload 16
    //   633: invokespecial 263	com/tencent/mm/plugin/mmsight/segment/h$1:<init>	(Lcom/tencent/mm/plugin/mmsight/segment/h;)V
    //   636: invokeinterface 266 2 0
    //   641: lload 11
    //   643: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   646: lstore 11
    //   648: aload_1
    //   649: aload_0
    //   650: getfield 108	com/tencent/mm/plugin/mmsight/segment/q:Fey	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   653: getfield 113	com/tencent/mm/plugin/mmsight/segment/a$a:index	I
    //   656: invokevirtual 273	com/tencent/mm/compatible/i/c:unselectTrack	(I)V
    //   659: iconst_0
    //   660: istore 15
    //   662: aload_0
    //   663: getfield 275	com/tencent/mm/plugin/mmsight/segment/q:Fez	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   666: ifnull +48 -> 714
    //   669: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   672: lstore 13
    //   674: aload_0
    //   675: aload_1
    //   676: iload_2
    //   677: iload_3
    //   678: invokespecial 278	com/tencent/mm/plugin/mmsight/segment/q:a	(Lcom/tencent/mm/compatible/i/c;II)Z
    //   681: istore 15
    //   683: ldc 30
    //   685: ldc_w 280
    //   688: iconst_2
    //   689: anewarray 64	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: lload 13
    //   696: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   699: invokestatic 285	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   702: aastore
    //   703: dup
    //   704: iconst_1
    //   705: iload 15
    //   707: invokestatic 290	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   710: aastore
    //   711: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   714: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   717: lstore 13
    //   719: aload_0
    //   720: invokevirtual 293	com/tencent/mm/plugin/mmsight/segment/q:brm	()Ljava/lang/String;
    //   723: astore 17
    //   725: ldc 30
    //   727: ldc_w 295
    //   730: iconst_1
    //   731: anewarray 64	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: lload 11
    //   738: invokestatic 285	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   741: aastore
    //   742: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: ldc 30
    //   747: ldc_w 297
    //   750: iconst_1
    //   751: anewarray 64	java/lang/Object
    //   754: dup
    //   755: iconst_0
    //   756: aload 17
    //   758: aastore
    //   759: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   762: invokestatic 300	com/tencent/mm/plugin/mmsight/segment/h:getDecoderType	()I
    //   765: lload 11
    //   767: invokestatic 306	com/tencent/mm/plugin/mmsight/segment/n:aB	(IJ)V
    //   770: iconst_1
    //   771: istore_3
    //   772: iconst_1
    //   773: istore 8
    //   775: aload 4
    //   777: getfield 309	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   780: istore 7
    //   782: aload 4
    //   784: getfield 312	com/tencent/mm/modelcontrol/VideoTransPara:audioBitrate	I
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
    //   804: getfield 275	com/tencent/mm/plugin/mmsight/segment/q:Fez	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   807: getfield 151	com/tencent/mm/plugin/mmsight/segment/a$a:mediaFormat	Landroid/media/MediaFormat;
    //   810: ldc_w 314
    //   813: invokevirtual 320	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   816: istore 8
    //   818: iload 7
    //   820: istore_2
    //   821: iload 8
    //   823: istore_3
    //   824: aload_0
    //   825: getfield 275	com/tencent/mm/plugin/mmsight/segment/q:Fez	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   828: getfield 151	com/tencent/mm/plugin/mmsight/segment/a$a:mediaFormat	Landroid/media/MediaFormat;
    //   831: ldc_w 322
    //   834: invokevirtual 320	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   837: istore 7
    //   839: iload 7
    //   841: istore_2
    //   842: iload 8
    //   844: istore_3
    //   845: aload_0
    //   846: getfield 275	com/tencent/mm/plugin/mmsight/segment/q:Fez	Lcom/tencent/mm/plugin/mmsight/segment/a$a;
    //   849: getfield 151	com/tencent/mm/plugin/mmsight/segment/a$a:mediaFormat	Landroid/media/MediaFormat;
    //   852: ldc_w 324
    //   855: invokevirtual 320	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   858: istore 10
    //   860: iload 10
    //   862: istore_2
    //   863: iload_2
    //   864: istore_3
    //   865: iload 8
    //   867: istore_2
    //   868: ldc 30
    //   870: ldc_w 326
    //   873: iconst_3
    //   874: anewarray 64	java/lang/Object
    //   877: dup
    //   878: iconst_0
    //   879: iload_2
    //   880: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   883: aastore
    //   884: dup
    //   885: iconst_1
    //   886: iload 7
    //   888: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   891: aastore
    //   892: dup
    //   893: iconst_2
    //   894: iload_3
    //   895: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   898: aastore
    //   899: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   902: iload 7
    //   904: sipush 1024
    //   907: iconst_2
    //   908: iload_2
    //   909: aload 17
    //   911: aload 4
    //   913: getfield 233	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   916: i2f
    //   917: aload_0
    //   918: invokevirtual 51	com/tencent/mm/plugin/mmsight/segment/q:getEndTimeMs	()J
    //   921: aload_0
    //   922: invokevirtual 44	com/tencent/mm/plugin/mmsight/segment/q:getStartTimeMs	()J
    //   925: lsub
    //   926: l2i
    //   927: aconst_null
    //   928: iconst_0
    //   929: invokestatic 333	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264VFS	(IIIILjava/lang/String;FI[BI)I
    //   932: istore_2
    //   933: iload_2
    //   934: ifge +94 -> 1028
    //   937: ldc 30
    //   939: ldc_w 335
    //   942: iconst_1
    //   943: anewarray 64	java/lang/Object
    //   946: dup
    //   947: iconst_0
    //   948: iload_2
    //   949: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   952: aastore
    //   953: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   956: new 178	com/tencent/mm/plugin/mmsight/segment/m
    //   959: dup
    //   960: ldc_w 337
    //   963: invokespecial 183	com/tencent/mm/plugin/mmsight/segment/m:<init>	(Ljava/lang/String;)V
    //   966: astore 4
    //   968: ldc 22
    //   970: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   973: aload 4
    //   975: athrow
    //   976: astore 17
    //   978: ldc 60
    //   980: aload 17
    //   982: ldc_w 339
    //   985: iconst_1
    //   986: anewarray 64	java/lang/Object
    //   989: dup
    //   990: iconst_0
    //   991: aload 17
    //   993: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   996: aastore
    //   997: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1000: goto -393 -> 607
    //   1003: astore 18
    //   1005: ldc 30
    //   1007: ldc_w 341
    //   1010: iconst_1
    //   1011: anewarray 64	java/lang/Object
    //   1014: dup
    //   1015: iconst_0
    //   1016: aload 18
    //   1018: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1021: aastore
    //   1022: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1025: goto +192 -> 1217
    //   1028: aload_0
    //   1029: invokevirtual 75	com/tencent/mm/plugin/mmsight/segment/q:eTU	()I
    //   1032: ifle +115 -> 1147
    //   1035: aload_0
    //   1036: invokevirtual 293	com/tencent/mm/plugin/mmsight/segment/q:brm	()Ljava/lang/String;
    //   1039: aload_0
    //   1040: invokevirtual 344	com/tencent/mm/plugin/mmsight/segment/q:eTR	()Ljava/lang/String;
    //   1043: aload_0
    //   1044: invokevirtual 75	com/tencent/mm/plugin/mmsight/segment/q:eTU	()I
    //   1047: invokestatic 348	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideoVFS	(Ljava/lang/String;Ljava/lang/String;I)I
    //   1050: pop
    //   1051: ldc 30
    //   1053: ldc_w 350
    //   1056: iconst_1
    //   1057: anewarray 64	java/lang/Object
    //   1060: dup
    //   1061: iconst_0
    //   1062: lload 13
    //   1064: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   1067: invokestatic 285	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1070: aastore
    //   1071: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1074: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1077: lstore 11
    //   1079: aload_0
    //   1080: invokevirtual 344	com/tencent/mm/plugin/mmsight/segment/q:eTR	()Ljava/lang/String;
    //   1083: invokestatic 356	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getInstance	()Lcom/tencent/mm/plugin/mmsight/model/CaptureMMProxy;
    //   1086: invokevirtual 360	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getWeixinMeta	()[B
    //   1089: invokestatic 364	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagMP4Dscp	(Ljava/lang/String;[B)V
    //   1092: ldc 30
    //   1094: ldc_w 366
    //   1097: iconst_1
    //   1098: anewarray 64	java/lang/Object
    //   1101: dup
    //   1102: iconst_0
    //   1103: lload 11
    //   1105: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   1108: invokestatic 285	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1111: aastore
    //   1112: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1115: aload_0
    //   1116: getfield 135	com/tencent/mm/plugin/mmsight/segment/q:bufId	I
    //   1119: invokestatic 158	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   1122: aload_1
    //   1123: getfield 162	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   1126: invokevirtual 167	android/media/MediaExtractor:release	()V
    //   1129: getstatic 173	com/tencent/mm/plugin/mmsight/model/a/j:FbH	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   1132: invokevirtual 176	com/tencent/mm/plugin/mmsight/model/a/j:baL	()V
    //   1135: aload 16
    //   1137: invokevirtual 207	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   1140: ldc 22
    //   1142: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1145: iconst_0
    //   1146: ireturn
    //   1147: aload_0
    //   1148: invokevirtual 293	com/tencent/mm/plugin/mmsight/segment/q:brm	()Ljava/lang/String;
    //   1151: aload_0
    //   1152: invokevirtual 344	com/tencent/mm/plugin/mmsight/segment/q:eTR	()Ljava/lang/String;
    //   1155: invokestatic 372	com/tencent/mm/vfs/u:oo	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1158: pop
    //   1159: goto -108 -> 1051
    //   1162: astore_1
    //   1163: aload 16
    //   1165: invokevirtual 207	com/tencent/mm/plugin/mmsight/segment/h:release	()V
    //   1168: ldc 22
    //   1170: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1173: aload_1
    //   1174: athrow
    //   1175: astore_1
    //   1176: goto -36 -> 1140
    //   1179: astore_1
    //   1180: goto -788 -> 392
    //   1183: astore 4
    //   1185: goto -17 -> 1168
    //   1188: astore_1
    //   1189: goto -830 -> 359
    //   1192: astore_1
    //   1193: goto -58 -> 1135
    //   1196: astore 4
    //   1198: goto -920 -> 278
    //   1201: astore_1
    //   1202: aload 17
    //   1204: astore 4
    //   1206: goto -784 -> 422
    //   1209: ldc2_w 373
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
    //   0	1228	1	paramc	c
    //   0	1228	2	paramInt1	int
    //   0	1228	3	paramInt2	int
    //   0	1228	4	paramString	String
    //   552	661	5	d	double
    //   116	1103	7	i	int
    //   773	93	8	j	int
    //   787	436	9	k	int
    //   858	3	10	m	int
    //   215	889	11	l1	long
    //   672	391	13	l2	long
    //   500	293	15	bool	boolean
    //   22	1142	16	localh	h
    //   13	897	17	localObject	Object
    //   976	227	17	localException1	Exception
    //   1003	14	18	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   182	203	297	java/lang/Exception
    //   203	253	297	java/lang/Exception
    //   278	297	297	java/lang/Exception
    //   458	502	297	java/lang/Exception
    //   607	659	297	java/lang/Exception
    //   662	714	297	java/lang/Exception
    //   714	770	297	java/lang/Exception
    //   775	789	297	java/lang/Exception
    //   868	933	297	java/lang/Exception
    //   937	976	297	java/lang/Exception
    //   978	1000	297	java/lang/Exception
    //   1005	1025	297	java/lang/Exception
    //   1028	1051	297	java/lang/Exception
    //   1051	1115	297	java/lang/Exception
    //   1147	1159	297	java/lang/Exception
    //   182	203	337	finally
    //   203	253	337	finally
    //   258	278	337	finally
    //   278	297	337	finally
    //   299	337	337	finally
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
    //   937	976	337	finally
    //   978	1000	337	finally
    //   1005	1025	337	finally
    //   1028	1051	337	finally
    //   1051	1115	337	finally
    //   1147	1159	337	finally
    //   151	182	367	java/lang/Exception
    //   359	367	367	java/lang/Exception
    //   24	90	417	java/lang/Exception
    //   90	105	417	java/lang/Exception
    //   105	144	417	java/lang/Exception
    //   399	414	417	java/lang/Exception
    //   507	554	976	java/lang/Exception
    //   554	607	976	java/lang/Exception
    //   803	818	1003	java/lang/Exception
    //   824	839	1003	java/lang/Exception
    //   845	860	1003	java/lang/Exception
    //   151	182	1162	finally
    //   339	359	1162	finally
    //   359	367	1162	finally
    //   368	387	1162	finally
    //   1115	1135	1162	finally
    //   1135	1140	1175	java/lang/Exception
    //   387	392	1179	java/lang/Exception
    //   1163	1168	1183	java/lang/Exception
    //   339	359	1188	java/lang/Exception
    //   1115	1135	1192	java/lang/Exception
    //   258	278	1196	java/lang/Exception
    //   15	24	1201	java/lang/Exception
  }
  
  private boolean a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107695);
    if (this.Fez == null)
    {
      AppMethodBeat.o(107695);
      return false;
    }
    paramc.selectTrack(this.Fez.index);
    paramc.seekTo(getStartTimeMs() * 1000L, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1);
    try
    {
      this.Fez.mediaFormat.getInteger("channel-count");
      Log.i("VideoClipperAPI18", "audio channel count");
      if (CaptureMMProxy.getInstance().getInt(ar.a.Vni, 0) != 1) {
        break label450;
      }
      paramc = new g(paramc, this.Fez.mediaFormat, getStartTimeMs(), getEndTimeMs(), eTQ());
      paramc.FdL = true;
    }
    catch (Exception localException1)
    {
      try
      {
        paramc.FdJ = aa.KR(paramc.aFM);
        paramc.FdJ.a(paramc.miU, null, 0);
        paramc.FdJ.start();
        paramc.miU = paramc.FdJ.avi();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            paramc.kTI = new MediaFormat();
            paramc.kTI.setString("mime", "audio/mp4a-latm");
            paramc.kTI.setInteger("aac-profile", 2);
            paramc.kTI.setInteger("sample-rate", paramc.mjz.audioSampleRate);
            paramc.kTI.setInteger("channel-count", 1);
            paramc.kTI.setInteger("bitrate", paramc.mjz.audioBitrate);
            paramc.kTI.setInteger("max-input-size", 16384);
            paramc.FdK = aa.t(paramc.aFM, false);
            paramc.FdK.a(paramc.kTI, null, 1);
            paramc.FdJ.start();
            Log.i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", new Object[] { Boolean.valueOf(paramc.FdL) });
            paramc.eUc();
            AppMethodBeat.o(107695);
            return true;
            localException3 = localException3;
            Log.e("VideoClipperAPI18", "get channel count error: %s", new Object[] { Integer.valueOf(1) });
            continue;
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", localException1, "init decoder error: %s", new Object[] { localException1.getMessage() });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", new Object[] { localException2.getMessage() });
            paramc.FdL = false;
            paramc.FdM = new ArrayList();
            paramc.FdK.release();
            paramc.FdK = null;
          }
        }
      }
    }
    localException2.position(0);
    MP4MuxerJNI.writeAACData(paramInt2, localException2, paramInt1);
    paramc.jvU.advance();
    label450:
    localException2.clear();
    paramInt1 = paramc.readSampleData(localException2, 0);
    Log.d("VideoClipperAPI18", "sampleSize: %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 <= 0) {
      Log.i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      AppMethodBeat.o(107695);
      return false;
      if (paramc.jvU.getSampleTime() < getEndTimeMs() * 1000L)
      {
        if (paramc.jvU.getSampleTrackIndex() == this.Fez.index) {
          break;
        }
        Log.e("VideoClipperAPI18", "track index not match! break");
      }
    }
  }
  
  /* Error */
  public final int Yw(String paramString)
  {
    // Byte code:
    //   0: ldc_w 515
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 517	com/tencent/mm/compatible/i/d
    //   9: dup
    //   10: invokespecial 518	com/tencent/mm/compatible/i/d:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: invokevirtual 523	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   19: bipush 17
    //   21: invokestatic 529	com/tencent/mm/compatible/util/d:qV	(I)Z
    //   24: ifeq +91 -> 115
    //   27: aload_3
    //   28: bipush 24
    //   30: invokevirtual 533	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   33: astore_1
    //   34: ldc 30
    //   36: ldc_w 535
    //   39: aload_1
    //   40: invokestatic 540	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokevirtual 543	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 545	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_3
    //   50: bipush 19
    //   52: invokevirtual 533	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   55: astore 4
    //   57: aload_3
    //   58: bipush 18
    //   60: invokevirtual 533	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   63: astore 5
    //   65: ldc 30
    //   67: ldc_w 547
    //   70: aload 4
    //   72: invokestatic 540	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokevirtual 543	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   78: invokestatic 545	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: ldc 30
    //   83: ldc_w 549
    //   86: aload 5
    //   88: invokestatic 540	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: invokevirtual 543	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokestatic 545	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: iconst_0
    //   99: invokestatic 552	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   102: istore_2
    //   103: aload_3
    //   104: invokevirtual 553	android/media/MediaMetadataRetriever:release	()V
    //   107: ldc_w 515
    //   110: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iload_2
    //   114: ireturn
    //   115: new 555	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 556	java/lang/StringBuilder:<init>	()V
    //   122: aload_1
    //   123: invokestatic 559	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   126: invokevirtual 563	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 566	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_1
    //   133: goto -99 -> 34
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 553	android/media/MediaMetadataRetriever:release	()V
    //   147: ldc_w 515
    //   150: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: goto -17 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	q
    //   0	159	1	paramString	String
    //   102	12	2	i	int
    //   13	131	3	locald	com.tencent.mm.compatible.i.d
    //   55	16	4	str1	String
    //   63	24	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   6	14	136	finally
    //   14	34	155	finally
    //   34	103	155	finally
    //   115	133	155	finally
  }
  
  protected final int a(c paramc, List<a.a> paramList1, List<a.a> paramList2)
  {
    AppMethodBeat.i(107693);
    this.Fey = ((a.a)paramList2.get(0));
    if ((paramList1 != null) && (paramList1.size() != 0)) {
      this.Fez = ((a.a)paramList1.get(0));
    }
    if (eTT() <= 0) {}
    for (int i = 1048576; a(paramc, i, this.bufId, eTS()) == -1; i = eTT())
    {
      Log.e("VideoClipperAPI18", "transcodeAndMux error");
      release();
      AppMethodBeat.o(107693);
      return -1;
    }
    AppMethodBeat.o(107693);
    return 0;
  }
  
  public final int aj(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107692);
    n.Xd(h.getDecoderType());
    int i = super.aj(paramLong1, paramLong2);
    if (i == -1) {
      n.Xe(h.getDecoderType());
    }
    AppMethodBeat.o(107692);
    return i;
  }
  
  public final void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(107691);
    super.b(paramString1, paramString2, paramVideoTransPara);
    AppMethodBeat.o(107691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.q
 * JD-Core Version:    0.7.0.1
 */