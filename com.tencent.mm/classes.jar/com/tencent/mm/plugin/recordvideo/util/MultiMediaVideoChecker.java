package com.tencent.mm.plugin.recordvideo.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pn;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;", "", "()V", "AV_PIX_FMT_YUV420P", "", "AV_PIX_FMT_YUV420P10BE", "AV_PIX_FMT_YUV420P10LE", "AV_PIX_FMT_YUV420P12BE", "AV_PIX_FMT_YUV420P12LE", "AV_PIX_FMT_YUV420P14BE", "AV_PIX_FMT_YUV420P14LE", "AV_PIX_FMT_YUV420P16BE", "AV_PIX_FMT_YUV420P16LE", "AV_PIX_FMT_YUV420P9BE", "AV_PIX_FMT_YUV420P9LE", "AV_PIX_FMT_YUVA420P", "AV_PIX_FMT_YUVA420P10BE", "AV_PIX_FMT_YUVA420P10LE", "AV_PIX_FMT_YUVA420P16BE", "AV_PIX_FMT_YUVA420P16LE", "AV_PIX_FMT_YUVA420P9BE", "AV_PIX_FMT_YUVA420P9LE", "AV_PIX_FMT_YUVJ420P", "MalformedAudioSampleRateThreshold", "TAG", "", "videoInfoCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$VideoInfo;", "Lkotlin/collections/HashMap;", "getAudioInfoByMediaExtractor", "path", "getVideoFrameRate", "", "getVideoInfo", "fromCache", "", "getVideoInfoByMediaExtractor", "pixelFormat", "getVideoInfoBySightJNI", "isH265Video", "isYuv420pFormat", "videoFormat", "VideoInfo", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiMediaVideoChecker
{
  public static final MultiMediaVideoChecker ObB;
  private static final HashMap<String, a> ObC;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(279555);
    ObB = new MultiMediaVideoChecker();
    TAG = "MicroMsg.MultiMediaVideoChecker";
    ObC = new HashMap();
    AppMethodBeat.o(279555);
  }
  
  /* Error */
  public static a aTH(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: ldc 94
    //   7: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: ldc 95
    //   13: invokestatic 101	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: new 103	com/tencent/mm/media/f/a
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 106	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: getfield 110	com/tencent/mm/media/f/a:nAt	Landroid/media/MediaFormat;
    //   29: astore 7
    //   31: aload 7
    //   33: ifnull +153 -> 186
    //   36: aload 7
    //   38: ldc 112
    //   40: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   43: iconst_1
    //   44: if_icmpne +142 -> 186
    //   47: iconst_1
    //   48: istore_1
    //   49: iload_1
    //   50: ifeq +141 -> 191
    //   53: aload 7
    //   55: ldc 112
    //   57: invokevirtual 122	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   60: lstore 5
    //   62: lload 5
    //   64: ldc2_w 123
    //   67: ldiv
    //   68: lstore 5
    //   70: aload 7
    //   72: ifnull +125 -> 197
    //   75: aload 7
    //   77: ldc 126
    //   79: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   82: iconst_1
    //   83: if_icmpne +114 -> 197
    //   86: iconst_1
    //   87: istore_1
    //   88: iload_1
    //   89: ifeq +113 -> 202
    //   92: aload 7
    //   94: ldc 126
    //   96: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   99: istore_1
    //   100: aload 7
    //   102: ifnull +105 -> 207
    //   105: aload 7
    //   107: ldc 132
    //   109: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   112: iconst_1
    //   113: if_icmpne +94 -> 207
    //   116: iconst_1
    //   117: istore_2
    //   118: iload_2
    //   119: ifeq +93 -> 212
    //   122: aload 7
    //   124: ldc 132
    //   126: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   129: istore_2
    //   130: aload 7
    //   132: ifnull +85 -> 217
    //   135: aload 7
    //   137: ldc 134
    //   139: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   142: iconst_1
    //   143: if_icmpne +74 -> 217
    //   146: iload_3
    //   147: ifeq +12 -> 159
    //   150: aload 7
    //   152: ldc 134
    //   154: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   157: istore 4
    //   159: new 6	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a
    //   162: dup
    //   163: lload 5
    //   165: iload_1
    //   166: iload_2
    //   167: iload 4
    //   169: invokespecial 137	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:<init>	(JIII)V
    //   172: astore 7
    //   174: aload_0
    //   175: invokevirtual 140	com/tencent/mm/media/f/a:release	()V
    //   178: ldc 94
    //   180: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload 7
    //   185: areturn
    //   186: iconst_0
    //   187: istore_1
    //   188: goto -139 -> 49
    //   191: lconst_0
    //   192: lstore 5
    //   194: goto -132 -> 62
    //   197: iconst_0
    //   198: istore_1
    //   199: goto -111 -> 88
    //   202: iconst_0
    //   203: istore_1
    //   204: goto -104 -> 100
    //   207: iconst_0
    //   208: istore_2
    //   209: goto -91 -> 118
    //   212: iconst_0
    //   213: istore_2
    //   214: goto -84 -> 130
    //   217: iconst_0
    //   218: istore_3
    //   219: goto -73 -> 146
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_0
    //   225: aload_0
    //   226: ifnull +7 -> 233
    //   229: aload_0
    //   230: invokevirtual 140	com/tencent/mm/media/f/a:release	()V
    //   233: ldc 94
    //   235: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aconst_null
    //   239: areturn
    //   240: astore 7
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 140	com/tencent/mm/media/f/a:release	()V
    //   252: ldc 94
    //   254: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: aload 7
    //   259: athrow
    //   260: astore 7
    //   262: goto -18 -> 244
    //   265: astore 7
    //   267: goto -42 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramString	String
    //   48	156	1	i	int
    //   117	97	2	j	int
    //   4	215	3	k	int
    //   1	167	4	m	int
    //   60	133	5	l	long
    //   29	155	7	localObject1	Object
    //   240	18	7	localObject2	Object
    //   260	1	7	localObject3	Object
    //   265	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	25	222	java/lang/Exception
    //   16	25	240	finally
    //   25	31	260	finally
    //   36	47	260	finally
    //   53	62	260	finally
    //   62	70	260	finally
    //   75	86	260	finally
    //   92	100	260	finally
    //   105	116	260	finally
    //   122	130	260	finally
    //   135	146	260	finally
    //   150	159	260	finally
    //   159	174	260	finally
    //   25	31	265	java/lang/Exception
    //   36	47	265	java/lang/Exception
    //   53	62	265	java/lang/Exception
    //   62	70	265	java/lang/Exception
    //   75	86	265	java/lang/Exception
    //   92	100	265	java/lang/Exception
    //   105	116	265	java/lang/Exception
    //   122	130	265	java/lang/Exception
    //   135	146	265	java/lang/Exception
    //   150	159	265	java/lang/Exception
    //   159	174	265	java/lang/Exception
  }
  
  public static boolean ahd(int paramInt)
  {
    AppMethodBeat.i(279547);
    if (p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(12), Integer.valueOf(35), Integer.valueOf(54), Integer.valueOf(55), Integer.valueOf(69), Integer.valueOf(70), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(72), Integer.valueOf(95), Integer.valueOf(96), Integer.valueOf(101), Integer.valueOf(102), Integer.valueOf(107), Integer.valueOf(108), Integer.valueOf(129), Integer.valueOf(130), Integer.valueOf(133), Integer.valueOf(134) }).contains(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(279547);
      return true;
    }
    AppMethodBeat.o(279547);
    return false;
  }
  
  /* Error */
  private static a gG(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 164
    //   2: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 14
    //   8: new 103	com/tencent/mm/media/f/a
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 106	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   16: astore 13
    //   18: aload 13
    //   20: getfield 167	com/tencent/mm/media/f/a:nAs	Landroid/media/MediaFormat;
    //   23: astore 15
    //   25: aload 13
    //   27: getfield 110	com/tencent/mm/media/f/a:nAt	Landroid/media/MediaFormat;
    //   30: astore 14
    //   32: getstatic 79	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:TAG	Ljava/lang/String;
    //   35: new 169	java/lang/StringBuilder
    //   38: dup
    //   39: ldc 171
    //   41: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: aload 15
    //   46: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc 178
    //   51: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 14
    //   56: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload 15
    //   67: ifnull +353 -> 420
    //   70: aload 15
    //   72: ldc 192
    //   74: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   77: iconst_1
    //   78: if_icmpne +342 -> 420
    //   81: iconst_1
    //   82: istore_2
    //   83: iload_2
    //   84: ifeq +341 -> 425
    //   87: aload 15
    //   89: ldc 192
    //   91: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   94: istore_3
    //   95: aload 15
    //   97: ifnull +333 -> 430
    //   100: aload 15
    //   102: ldc 194
    //   104: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   107: iconst_1
    //   108: if_icmpne +322 -> 430
    //   111: iconst_1
    //   112: istore_2
    //   113: iload_2
    //   114: ifeq +321 -> 435
    //   117: aload 15
    //   119: ldc 194
    //   121: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   124: istore 4
    //   126: aload 15
    //   128: ifnull +313 -> 441
    //   131: aload 15
    //   133: ldc 112
    //   135: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   138: iconst_1
    //   139: if_icmpne +302 -> 441
    //   142: iconst_1
    //   143: istore_2
    //   144: iload_2
    //   145: ifeq +301 -> 446
    //   148: aload 15
    //   150: ldc 112
    //   152: invokevirtual 122	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   155: lstore 10
    //   157: lload 10
    //   159: ldc2_w 123
    //   162: ldiv
    //   163: lstore 10
    //   165: aload_0
    //   166: invokestatic 199	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   169: istore 9
    //   171: aload 15
    //   173: ifnull +279 -> 452
    //   176: aload 15
    //   178: ldc 201
    //   180: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   183: iconst_1
    //   184: if_icmpne +268 -> 452
    //   187: iconst_1
    //   188: istore_2
    //   189: iload_2
    //   190: ifeq +267 -> 457
    //   193: aload 15
    //   195: ldc 201
    //   197: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   200: istore 5
    //   202: aload 15
    //   204: ifnull +259 -> 463
    //   207: aload 15
    //   209: ldc 126
    //   211: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   214: iconst_1
    //   215: if_icmpne +248 -> 463
    //   218: iconst_1
    //   219: istore_2
    //   220: iload_2
    //   221: ifeq +247 -> 468
    //   224: aload 15
    //   226: ldc 126
    //   228: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   231: istore_2
    //   232: iload_2
    //   233: istore 6
    //   235: iload_2
    //   236: ifgt +10 -> 246
    //   239: aload 13
    //   241: getfield 205	com/tencent/mm/media/f/a:videoBitrate	I
    //   244: istore 6
    //   246: aload 15
    //   248: ifnull +225 -> 473
    //   251: aload 15
    //   253: ldc 207
    //   255: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   258: iconst_1
    //   259: if_icmpne +214 -> 473
    //   262: iconst_1
    //   263: istore_2
    //   264: iload_2
    //   265: ifeq +213 -> 478
    //   268: aload 15
    //   270: ldc 207
    //   272: invokevirtual 211	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: astore_0
    //   276: aload_0
    //   277: ldc 213
    //   279: invokestatic 217	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   282: istore 12
    //   284: aload 14
    //   286: ifnull +198 -> 484
    //   289: aload 14
    //   291: ldc 126
    //   293: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   296: iconst_1
    //   297: if_icmpne +187 -> 484
    //   300: iconst_1
    //   301: istore_2
    //   302: iload_2
    //   303: ifeq +186 -> 489
    //   306: aload 14
    //   308: ldc 126
    //   310: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   313: istore_2
    //   314: aload 14
    //   316: ifnull +178 -> 494
    //   319: aload 14
    //   321: ldc 132
    //   323: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   326: iconst_1
    //   327: if_icmpne +167 -> 494
    //   330: iconst_1
    //   331: istore 7
    //   333: iload 7
    //   335: ifeq +165 -> 500
    //   338: aload 14
    //   340: ldc 132
    //   342: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   345: istore 7
    //   347: aload 14
    //   349: ifnull +157 -> 506
    //   352: aload 14
    //   354: ldc 134
    //   356: invokevirtual 118	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   359: iconst_1
    //   360: if_icmpne +146 -> 506
    //   363: iconst_1
    //   364: istore 8
    //   366: iload 8
    //   368: ifeq +144 -> 512
    //   371: aload 14
    //   373: ldc 134
    //   375: invokevirtual 130	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   378: istore 8
    //   380: new 6	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a
    //   383: dup
    //   384: iload_3
    //   385: iload 4
    //   387: iload 5
    //   389: i2f
    //   390: lload 10
    //   392: iload 6
    //   394: iload 9
    //   396: iload 12
    //   398: iload_2
    //   399: iload 7
    //   401: iload 8
    //   403: iload_1
    //   404: invokespecial 220	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:<init>	(IIFJIIZIIII)V
    //   407: astore_0
    //   408: aload 13
    //   410: invokevirtual 140	com/tencent/mm/media/f/a:release	()V
    //   413: ldc 164
    //   415: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: aload_0
    //   419: areturn
    //   420: iconst_0
    //   421: istore_2
    //   422: goto -339 -> 83
    //   425: iconst_0
    //   426: istore_3
    //   427: goto -332 -> 95
    //   430: iconst_0
    //   431: istore_2
    //   432: goto -319 -> 113
    //   435: iconst_0
    //   436: istore 4
    //   438: goto -312 -> 126
    //   441: iconst_0
    //   442: istore_2
    //   443: goto -299 -> 144
    //   446: lconst_0
    //   447: lstore 10
    //   449: goto -292 -> 157
    //   452: iconst_0
    //   453: istore_2
    //   454: goto -265 -> 189
    //   457: iconst_0
    //   458: istore 5
    //   460: goto -258 -> 202
    //   463: iconst_0
    //   464: istore_2
    //   465: goto -245 -> 220
    //   468: iconst_0
    //   469: istore_2
    //   470: goto -238 -> 232
    //   473: iconst_0
    //   474: istore_2
    //   475: goto -211 -> 264
    //   478: ldc 221
    //   480: astore_0
    //   481: goto -205 -> 276
    //   484: iconst_0
    //   485: istore_2
    //   486: goto -184 -> 302
    //   489: iconst_0
    //   490: istore_2
    //   491: goto -177 -> 314
    //   494: iconst_0
    //   495: istore 7
    //   497: goto -164 -> 333
    //   500: iconst_0
    //   501: istore 7
    //   503: goto -156 -> 347
    //   506: iconst_0
    //   507: istore 8
    //   509: goto -143 -> 366
    //   512: iconst_0
    //   513: istore 8
    //   515: goto -135 -> 380
    //   518: astore_0
    //   519: aload 14
    //   521: astore_0
    //   522: aload_0
    //   523: ifnull +7 -> 530
    //   526: aload_0
    //   527: invokevirtual 140	com/tencent/mm/media/f/a:release	()V
    //   530: ldc 164
    //   532: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   535: aconst_null
    //   536: areturn
    //   537: astore_0
    //   538: aconst_null
    //   539: astore 13
    //   541: aload 13
    //   543: ifnull +8 -> 551
    //   546: aload 13
    //   548: invokevirtual 140	com/tencent/mm/media/f/a:release	()V
    //   551: ldc 164
    //   553: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: aload_0
    //   557: athrow
    //   558: astore_0
    //   559: goto -18 -> 541
    //   562: astore_0
    //   563: aload 13
    //   565: astore_0
    //   566: goto -44 -> 522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	paramString	String
    //   0	569	1	paramInt	int
    //   82	409	2	i	int
    //   94	333	3	j	int
    //   124	313	4	k	int
    //   200	259	5	m	int
    //   233	160	6	n	int
    //   331	171	7	i1	int
    //   364	150	8	i2	int
    //   169	226	9	i3	int
    //   155	293	10	l	long
    //   282	115	12	bool	boolean
    //   16	548	13	locala	com.tencent.mm.media.f.a
    //   6	514	14	localMediaFormat1	android.media.MediaFormat
    //   23	246	15	localMediaFormat2	android.media.MediaFormat
    // Exception table:
    //   from	to	target	type
    //   8	18	518	java/lang/Exception
    //   8	18	537	finally
    //   18	65	558	finally
    //   70	81	558	finally
    //   87	95	558	finally
    //   100	111	558	finally
    //   117	126	558	finally
    //   131	142	558	finally
    //   148	157	558	finally
    //   157	171	558	finally
    //   176	187	558	finally
    //   193	202	558	finally
    //   207	218	558	finally
    //   224	232	558	finally
    //   239	246	558	finally
    //   251	262	558	finally
    //   268	276	558	finally
    //   276	284	558	finally
    //   289	300	558	finally
    //   306	314	558	finally
    //   319	330	558	finally
    //   338	347	558	finally
    //   352	363	558	finally
    //   371	380	558	finally
    //   380	408	558	finally
    //   18	65	562	java/lang/Exception
    //   70	81	562	java/lang/Exception
    //   87	95	562	java/lang/Exception
    //   100	111	562	java/lang/Exception
    //   117	126	562	java/lang/Exception
    //   131	142	562	java/lang/Exception
    //   148	157	562	java/lang/Exception
    //   157	171	562	java/lang/Exception
    //   176	187	562	java/lang/Exception
    //   193	202	562	java/lang/Exception
    //   207	218	562	java/lang/Exception
    //   224	232	562	java/lang/Exception
    //   239	246	562	java/lang/Exception
    //   251	262	562	java/lang/Exception
    //   268	276	562	java/lang/Exception
    //   276	284	562	java/lang/Exception
    //   289	300	562	java/lang/Exception
    //   306	314	562	java/lang/Exception
    //   319	330	562	java/lang/Exception
    //   338	347	562	java/lang/Exception
    //   352	363	562	java/lang/Exception
    //   371	380	562	java/lang/Exception
    //   380	408	562	java/lang/Exception
  }
  
  private final a getVideoInfoBySightJNI(String paramString)
  {
    AppMethodBeat.i(279539);
    try
    {
      b localb = f.aVY(paramString);
      if (localb != null)
      {
        int j = localb.hYK;
        int i = j;
        if (j < 0) {
          i = SightVideoJNI.getMp4RotateVFS(paramString);
        }
        paramString = new a(localb.width, localb.height, localb.frameRate, localb.videoDuration, localb.videoBitrate, i, false, localb.audioBitrate, localb.audioChannel, localb.audioSampleRate, localb.pixelFormat);
        paramString.ObD = localb;
        AppMethodBeat.o(279539);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(279539);
    }
    return null;
  }
  
  public final a aTG(String paramString)
  {
    AppMethodBeat.i(279562);
    s.u(paramString, "path");
    paramString = cI(paramString, false);
    AppMethodBeat.o(279562);
    return paramString;
  }
  
  public final a cI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(279577);
    s.u(paramString, "path");
    long l;
    Object localObject;
    int i;
    if (y.ZC(paramString))
    {
      if ((paramBoolean) && (ObC.get(paramString) != null))
      {
        paramString = (a)ObC.get(paramString);
        AppMethodBeat.o(279577);
        return paramString;
      }
      l = Util.currentTicks();
      localObject = getVideoInfoBySightJNI(paramString);
      if ((localObject != null) && (((a)localObject).gLk()) && (((a)localObject).audioSampleRate >= 1000)) {
        break label252;
      }
      Log.i(TAG, s.X("getVideoInfo: jni info invalid ", localObject));
      if (localObject == null)
      {
        i = -1;
        localObject = gG(paramString, i);
      }
    }
    label252:
    for (;;)
    {
      Log.i(TAG, "getVideoInfo cost:" + Util.ticksToNow(l) + ", info:" + localObject + ' ' + paramString);
      if (localObject != null) {
        ((Map)ObC).put(paramString, localObject);
      }
      AppMethodBeat.o(279577);
      return localObject;
      i = ((a)localObject).pixelFormat;
      break;
      localObject = new pn();
      ((pn)localObject).jmN = 2021;
      ((pn)localObject).wU(paramString);
      ((pn)localObject).bMH();
      Log.i(TAG, s.X("file not exist: ", paramString));
      AppMethodBeat.o(279577);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$VideoInfo;", "", "width", "", "height", "fps", "", "duration", "", "bitrate", "rotate", "isH265", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "pixelFormat", "(IIFJIIZIIII)V", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getBitrate", "getDuration", "()J", "getFps", "()F", "getHeight", "()Z", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/sight/base/MediaInfo;)V", "getPixelFormat", "getRotate", "getWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "isVideoValid", "toString", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public final boolean Lam;
    public b ObD;
    public final int audioBitrate;
    public final int audioChannelCount;
    public final int audioSampleRate;
    public final int bitrate;
    public final long duration;
    public final float eGw;
    public final int hYK;
    public final int height;
    public final int pixelFormat;
    public final int width;
    
    public a(int paramInt1, int paramInt2, float paramFloat, long paramLong, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.eGw = paramFloat;
      this.duration = paramLong;
      this.bitrate = paramInt3;
      this.hYK = paramInt4;
      this.Lam = paramBoolean;
      this.audioBitrate = paramInt5;
      this.audioChannelCount = paramInt6;
      this.audioSampleRate = paramInt7;
      this.pixelFormat = paramInt8;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(279583);
      if (this == paramObject)
      {
        AppMethodBeat.o(279583);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(279583);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.width != paramObject.width)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.height != paramObject.height)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (!s.p(Float.valueOf(this.eGw), Float.valueOf(paramObject.eGw)))
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.duration != paramObject.duration)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.bitrate != paramObject.bitrate)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.hYK != paramObject.hYK)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.Lam != paramObject.Lam)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.audioBitrate != paramObject.audioBitrate)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.audioChannelCount != paramObject.audioChannelCount)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.audioSampleRate != paramObject.audioSampleRate)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      if (this.pixelFormat != paramObject.pixelFormat)
      {
        AppMethodBeat.o(279583);
        return false;
      }
      AppMethodBeat.o(279583);
      return true;
    }
    
    public final boolean gLk()
    {
      return (this.width > 0) && (this.height > 0) && (this.duration > 0L);
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(279549);
      String str = "[width:" + this.width + ",height:" + this.height + ",fps:" + this.eGw + ",duration:" + this.duration + ']';
      AppMethodBeat.o(279549);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker
 * JD-Core Version:    0.7.0.1
 */