package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.mk;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker;", "", "()V", "AV_PIX_FMT_YUV420P", "", "AV_PIX_FMT_YUV420P10BE", "AV_PIX_FMT_YUV420P10LE", "AV_PIX_FMT_YUV420P12BE", "AV_PIX_FMT_YUV420P12LE", "AV_PIX_FMT_YUV420P14BE", "AV_PIX_FMT_YUV420P14LE", "AV_PIX_FMT_YUV420P16BE", "AV_PIX_FMT_YUV420P16LE", "AV_PIX_FMT_YUV420P9BE", "AV_PIX_FMT_YUV420P9LE", "AV_PIX_FMT_YUVA420P", "AV_PIX_FMT_YUVA420P10BE", "AV_PIX_FMT_YUVA420P10LE", "AV_PIX_FMT_YUVA420P16BE", "AV_PIX_FMT_YUVA420P16LE", "AV_PIX_FMT_YUVA420P9BE", "AV_PIX_FMT_YUVA420P9LE", "AV_PIX_FMT_YUVJ420P", "MalformedAudioSampleRateThreshold", "TAG", "", "videoInfoCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "Lkotlin/collections/HashMap;", "getAudioInfoByMediaExtractor", "path", "getVideoFrameRate", "", "getVideoInfo", "fromCache", "", "getVideoInfoByMediaExtractor", "pixelFormat", "getVideoInfoBySightJNI", "isH265Video", "isYuv420pFormat", "videoFormat", "VideoInfo", "plugin-vlog_release"})
public final class MultiMediaVideoChecker
{
  public static final MultiMediaVideoChecker NmA;
  private static final HashMap<String, a> Nmz;
  private static final String TAG = "MicroMsg.MultiMediaVideoChecker";
  
  static
  {
    AppMethodBeat.i(232331);
    NmA = new MultiMediaVideoChecker();
    TAG = "MicroMsg.MultiMediaVideoChecker";
    Nmz = new HashMap();
    AppMethodBeat.o(232331);
  }
  
  public static boolean ake(int paramInt)
  {
    AppMethodBeat.i(232329);
    if (j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(12), Integer.valueOf(35), Integer.valueOf(54), Integer.valueOf(55), Integer.valueOf(69), Integer.valueOf(70), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(72), Integer.valueOf(95), Integer.valueOf(96), Integer.valueOf(101), Integer.valueOf(102), Integer.valueOf(107), Integer.valueOf(108), Integer.valueOf(129), Integer.valueOf(130), Integer.valueOf(133), Integer.valueOf(134) }).contains(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(232329);
      return true;
    }
    AppMethodBeat.o(232329);
    return false;
  }
  
  /* Error */
  public static a bft(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 112
    //   5: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 113
    //   11: invokestatic 119	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: new 121	com/tencent/mm/media/f/a
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 124	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: getfield 128	com/tencent/mm/media/f/a:kUW	Landroid/media/MediaFormat;
    //   27: astore 7
    //   29: aload 7
    //   31: ifnull +135 -> 166
    //   34: aload 7
    //   36: ldc 130
    //   38: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   41: iconst_1
    //   42: if_icmpne +124 -> 166
    //   45: aload 7
    //   47: ldc 130
    //   49: invokevirtual 140	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   52: lstore 5
    //   54: lload 5
    //   56: ldc2_w 141
    //   59: ldiv
    //   60: lstore 5
    //   62: aload 7
    //   64: ifnull +108 -> 172
    //   67: aload 7
    //   69: ldc 144
    //   71: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   74: iconst_1
    //   75: if_icmpne +97 -> 172
    //   78: aload 7
    //   80: ldc 144
    //   82: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   85: istore_1
    //   86: aload 7
    //   88: ifnull +89 -> 177
    //   91: aload 7
    //   93: ldc 150
    //   95: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   98: iconst_1
    //   99: if_icmpne +78 -> 177
    //   102: aload 7
    //   104: ldc 150
    //   106: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   109: istore_2
    //   110: iload 4
    //   112: istore_3
    //   113: aload 7
    //   115: ifnull +25 -> 140
    //   118: iload 4
    //   120: istore_3
    //   121: aload 7
    //   123: ldc 152
    //   125: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   128: iconst_1
    //   129: if_icmpne +11 -> 140
    //   132: aload 7
    //   134: ldc 152
    //   136: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   139: istore_3
    //   140: new 6	com/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$a
    //   143: dup
    //   144: lload 5
    //   146: iload_1
    //   147: iload_2
    //   148: iload_3
    //   149: invokespecial 155	com/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$a:<init>	(JIII)V
    //   152: astore 7
    //   154: aload_0
    //   155: invokevirtual 158	com/tencent/mm/media/f/a:release	()V
    //   158: ldc 112
    //   160: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 7
    //   165: areturn
    //   166: lconst_0
    //   167: lstore 5
    //   169: goto -115 -> 54
    //   172: iconst_0
    //   173: istore_1
    //   174: goto -88 -> 86
    //   177: iconst_0
    //   178: istore_2
    //   179: goto -69 -> 110
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 158	com/tencent/mm/media/f/a:release	()V
    //   193: ldc 112
    //   195: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aconst_null
    //   199: areturn
    //   200: astore 7
    //   202: aconst_null
    //   203: astore_0
    //   204: aload_0
    //   205: ifnull +7 -> 212
    //   208: aload_0
    //   209: invokevirtual 158	com/tencent/mm/media/f/a:release	()V
    //   212: ldc 112
    //   214: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload 7
    //   219: athrow
    //   220: astore 7
    //   222: goto -18 -> 204
    //   225: astore 7
    //   227: goto -42 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramString	String
    //   85	89	1	i	int
    //   109	70	2	j	int
    //   112	37	3	k	int
    //   1	118	4	m	int
    //   52	116	5	l	long
    //   27	137	7	localObject1	Object
    //   200	18	7	localObject2	Object
    //   220	1	7	localObject3	Object
    //   225	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   14	23	182	java/lang/Exception
    //   14	23	200	finally
    //   23	29	220	finally
    //   34	54	220	finally
    //   54	62	220	finally
    //   67	86	220	finally
    //   91	110	220	finally
    //   121	140	220	finally
    //   140	154	220	finally
    //   23	29	225	java/lang/Exception
    //   34	54	225	java/lang/Exception
    //   54	62	225	java/lang/Exception
    //   67	86	225	java/lang/Exception
    //   91	110	225	java/lang/Exception
    //   121	140	225	java/lang/Exception
    //   140	154	225	java/lang/Exception
  }
  
  /* Error */
  private static a gB(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 13
    //   8: new 121	com/tencent/mm/media/f/a
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 124	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   16: astore 12
    //   18: aload 12
    //   20: getfield 164	com/tencent/mm/media/f/a:kUV	Landroid/media/MediaFormat;
    //   23: astore 13
    //   25: aload 12
    //   27: getfield 128	com/tencent/mm/media/f/a:kUW	Landroid/media/MediaFormat;
    //   30: astore 14
    //   32: getstatic 76	com/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker:TAG	Ljava/lang/String;
    //   35: new 166	java/lang/StringBuilder
    //   38: dup
    //   39: ldc 168
    //   41: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: aload 13
    //   46: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc 175
    //   51: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 14
    //   56: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload 13
    //   67: ifnull +262 -> 329
    //   70: aload 13
    //   72: ldc 189
    //   74: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   77: iconst_1
    //   78: if_icmpne +251 -> 329
    //   81: aload 13
    //   83: ldc 189
    //   85: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   88: istore_3
    //   89: aload 13
    //   91: ifnull +243 -> 334
    //   94: aload 13
    //   96: ldc 191
    //   98: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   101: iconst_1
    //   102: if_icmpne +232 -> 334
    //   105: aload 13
    //   107: ldc 191
    //   109: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   112: istore 4
    //   114: aload 13
    //   116: ifnull +224 -> 340
    //   119: aload 13
    //   121: ldc 130
    //   123: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   126: iconst_1
    //   127: if_icmpne +213 -> 340
    //   130: aload 13
    //   132: ldc 130
    //   134: invokevirtual 140	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   137: lstore 10
    //   139: lload 10
    //   141: ldc2_w 141
    //   144: ldiv
    //   145: lstore 10
    //   147: aload_0
    //   148: invokestatic 196	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   151: istore 9
    //   153: aload 13
    //   155: ifnull +191 -> 346
    //   158: aload 13
    //   160: ldc 198
    //   162: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   165: iconst_1
    //   166: if_icmpne +180 -> 346
    //   169: aload 13
    //   171: ldc 198
    //   173: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   176: istore 5
    //   178: aload 13
    //   180: ifnull +172 -> 352
    //   183: aload 13
    //   185: ldc 144
    //   187: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   190: iconst_1
    //   191: if_icmpne +161 -> 352
    //   194: aload 13
    //   196: ldc 144
    //   198: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   201: istore_2
    //   202: iload_2
    //   203: istore 6
    //   205: iload_2
    //   206: ifgt +10 -> 216
    //   209: aload 12
    //   211: getfield 202	com/tencent/mm/media/f/a:videoBitrate	I
    //   214: istore 6
    //   216: aload 14
    //   218: ifnull +139 -> 357
    //   221: aload 14
    //   223: ldc 144
    //   225: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   228: iconst_1
    //   229: if_icmpne +128 -> 357
    //   232: aload 14
    //   234: ldc 144
    //   236: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   239: istore_2
    //   240: aload 14
    //   242: ifnull +120 -> 362
    //   245: aload 14
    //   247: ldc 150
    //   249: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   252: iconst_1
    //   253: if_icmpne +109 -> 362
    //   256: aload 14
    //   258: ldc 150
    //   260: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   263: istore 7
    //   265: aload 14
    //   267: ifnull +101 -> 368
    //   270: aload 14
    //   272: ldc 152
    //   274: invokevirtual 136	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   277: iconst_1
    //   278: if_icmpne +90 -> 368
    //   281: aload 14
    //   283: ldc 152
    //   285: invokevirtual 148	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   288: istore 8
    //   290: new 6	com/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$a
    //   293: dup
    //   294: iload_3
    //   295: iload 4
    //   297: iload 5
    //   299: i2f
    //   300: lload 10
    //   302: iload 6
    //   304: iload 9
    //   306: iconst_1
    //   307: iload_2
    //   308: iload 7
    //   310: iload 8
    //   312: iload_1
    //   313: invokespecial 205	com/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$a:<init>	(IIFJIIZIIII)V
    //   316: astore_0
    //   317: aload 12
    //   319: invokevirtual 158	com/tencent/mm/media/f/a:release	()V
    //   322: ldc 161
    //   324: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload_0
    //   328: areturn
    //   329: iconst_0
    //   330: istore_3
    //   331: goto -242 -> 89
    //   334: iconst_0
    //   335: istore 4
    //   337: goto -223 -> 114
    //   340: lconst_0
    //   341: lstore 10
    //   343: goto -204 -> 139
    //   346: iconst_0
    //   347: istore 5
    //   349: goto -171 -> 178
    //   352: iconst_0
    //   353: istore_2
    //   354: goto -152 -> 202
    //   357: iconst_0
    //   358: istore_2
    //   359: goto -119 -> 240
    //   362: iconst_0
    //   363: istore 7
    //   365: goto -100 -> 265
    //   368: iconst_0
    //   369: istore 8
    //   371: goto -81 -> 290
    //   374: astore_0
    //   375: aload 13
    //   377: astore_0
    //   378: aload_0
    //   379: ifnull +7 -> 386
    //   382: aload_0
    //   383: invokevirtual 158	com/tencent/mm/media/f/a:release	()V
    //   386: ldc 161
    //   388: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   391: aconst_null
    //   392: areturn
    //   393: astore_0
    //   394: aconst_null
    //   395: astore 12
    //   397: aload 12
    //   399: ifnull +8 -> 407
    //   402: aload 12
    //   404: invokevirtual 158	com/tencent/mm/media/f/a:release	()V
    //   407: ldc 161
    //   409: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aload_0
    //   413: athrow
    //   414: astore_0
    //   415: goto -18 -> 397
    //   418: astore_0
    //   419: aload 12
    //   421: astore_0
    //   422: goto -44 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	paramString	String
    //   0	425	1	paramInt	int
    //   201	158	2	i	int
    //   88	243	3	j	int
    //   112	224	4	k	int
    //   176	172	5	m	int
    //   203	100	6	n	int
    //   263	101	7	i1	int
    //   288	82	8	i2	int
    //   151	154	9	i3	int
    //   137	205	10	l	long
    //   16	404	12	locala	com.tencent.mm.media.f.a
    //   6	370	13	localMediaFormat1	android.media.MediaFormat
    //   30	252	14	localMediaFormat2	android.media.MediaFormat
    // Exception table:
    //   from	to	target	type
    //   8	18	374	java/lang/Exception
    //   8	18	393	finally
    //   18	65	414	finally
    //   70	89	414	finally
    //   94	114	414	finally
    //   119	139	414	finally
    //   139	153	414	finally
    //   158	178	414	finally
    //   183	202	414	finally
    //   209	216	414	finally
    //   221	240	414	finally
    //   245	265	414	finally
    //   270	290	414	finally
    //   290	317	414	finally
    //   18	65	418	java/lang/Exception
    //   70	89	418	java/lang/Exception
    //   94	114	418	java/lang/Exception
    //   119	139	418	java/lang/Exception
    //   139	153	418	java/lang/Exception
    //   158	178	418	java/lang/Exception
    //   183	202	418	java/lang/Exception
    //   209	216	418	java/lang/Exception
    //   221	240	418	java/lang/Exception
    //   245	265	418	java/lang/Exception
    //   270	290	418	java/lang/Exception
    //   290	317	418	java/lang/Exception
  }
  
  private final a getVideoInfoBySightJNI(String paramString)
  {
    AppMethodBeat.i(232328);
    try
    {
      b localb = f.aYh(paramString);
      if (localb != null)
      {
        int j = localb.fSM;
        int i = j;
        if (j < 0) {
          i = SightVideoJNI.getMp4RotateVFS(paramString);
        }
        paramString = new a(localb.width, localb.height, localb.frameRate, localb.videoDuration, localb.videoBitrate, i, false, localb.audioBitrate, localb.audioChannel, localb.audioSampleRate, localb.pixelFormat);
        AppMethodBeat.o(232328);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(232328);
    }
    return null;
  }
  
  public final a bfs(String paramString)
  {
    AppMethodBeat.i(232321);
    p.k(paramString, "path");
    paramString = cO(paramString, false);
    AppMethodBeat.o(232321);
    return paramString;
  }
  
  public final a cO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(232322);
    p.k(paramString, "path");
    long l;
    Object localObject;
    int i;
    if (u.agG(paramString))
    {
      if ((paramBoolean) && (Nmz.get(paramString) != null))
      {
        paramString = (a)Nmz.get(paramString);
        AppMethodBeat.o(232322);
        return paramString;
      }
      l = Util.currentTicks();
      localObject = getVideoInfoBySightJNI(paramString);
      if (localObject != null)
      {
        i = ((a)localObject).audioSampleRate;
        if (i > 1000) {
          break label245;
        }
        Log.i(TAG, "error audio sample rate:".concat(String.valueOf(localObject)));
        if (localObject == null) {
          break label186;
        }
        i = ((a)localObject).pixelFormat;
        label108:
        localObject = gB(paramString, i);
      }
    }
    label186:
    label245:
    for (;;)
    {
      Log.i(TAG, "getVideoInfo cost:" + Util.ticksToNow(l) + ", info:" + localObject);
      if (localObject != null) {
        ((Map)Nmz).put(paramString, localObject);
      }
      AppMethodBeat.o(232322);
      return localObject;
      i = 0;
      break;
      i = -1;
      break label108;
      localObject = new mk();
      ((mk)localObject).nP(2021);
      ((mk)localObject).CN(paramString);
      ((mk)localObject).bpa();
      Log.i(TAG, "file not exist: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(232322);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "", "width", "", "height", "fps", "", "duration", "", "bitrate", "rotate", "isH265", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "pixelFormat", "(IIFJIIZIIII)V", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getBitrate", "getDuration", "()J", "getFps", "()F", "getHeight", "()Z", "getPixelFormat", "getRotate", "getWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class a
  {
    public final boolean FeD;
    public final int audioBitrate;
    public final int audioChannelCount;
    public final int audioSampleRate;
    public final int bitrate;
    public final float cLa;
    public final long duration;
    public final int fSM;
    public final int height;
    public final int pixelFormat;
    public final int width;
    
    public a(int paramInt1, int paramInt2, float paramFloat, long paramLong, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.cLa = paramFloat;
      this.duration = paramLong;
      this.bitrate = paramInt3;
      this.fSM = paramInt4;
      this.FeD = paramBoolean;
      this.audioBitrate = paramInt5;
      this.audioChannelCount = paramInt6;
      this.audioSampleRate = paramInt7;
      this.pixelFormat = paramInt8;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(223883);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height) || (Float.compare(this.cLa, paramObject.cLa) != 0) || (this.duration != paramObject.duration) || (this.bitrate != paramObject.bitrate) || (this.fSM != paramObject.fSM) || (this.FeD != paramObject.FeD) || (this.audioBitrate != paramObject.audioBitrate) || (this.audioChannelCount != paramObject.audioChannelCount) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.pixelFormat != paramObject.pixelFormat)) {}
        }
      }
      else
      {
        AppMethodBeat.o(223883);
        return true;
      }
      AppMethodBeat.o(223883);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223868);
      String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", fps=" + this.cLa + ", duration=" + this.duration + ", bitrate=" + this.bitrate + ", rotate=" + this.fSM + ", isH265=" + this.FeD + ", audioBitrate=" + this.audioBitrate + ", audioChannelCount=" + this.audioChannelCount + ", audioSampleRate=" + this.audioSampleRate + ", pixelFormat=" + this.pixelFormat + ")";
      AppMethodBeat.o(223868);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker
 * JD-Core Version:    0.7.0.1
 */