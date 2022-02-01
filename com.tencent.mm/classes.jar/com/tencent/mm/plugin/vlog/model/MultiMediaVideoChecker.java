package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker;", "", "()V", "TAG", "", "videoInfoCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "Lkotlin/collections/HashMap;", "getVideoFrameRate", "", "path", "getVideoInfo", "fromCache", "", "getVideoInfoByMediaExtractor", "getVideoInfoBySightJNI", "isH265Video", "VideoInfo", "plugin-vlog_release"})
public final class MultiMediaVideoChecker
{
  private static final HashMap<String, MultiMediaVideoChecker.a> BFU;
  public static final MultiMediaVideoChecker BFV;
  private static final String TAG = "MicroMsg.MultiMediaVideoChecker";
  
  static
  {
    AppMethodBeat.i(195745);
    BFV = new MultiMediaVideoChecker();
    TAG = "MicroMsg.MultiMediaVideoChecker";
    BFU = new HashMap();
    AppMethodBeat.o(195745);
  }
  
  /* Error */
  private static MultiMediaVideoChecker.a aDl(String paramString)
  {
    // Byte code:
    //   0: ldc 66
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 12
    //   8: new 68	com/tencent/mm/media/f/a
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 71	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   16: astore 11
    //   18: aload 11
    //   20: getfield 75	com/tencent/mm/media/f/a:hka	Landroid/media/MediaFormat;
    //   23: astore 12
    //   25: aload 11
    //   27: getfield 78	com/tencent/mm/media/f/a:hkb	Landroid/media/MediaFormat;
    //   30: astore 13
    //   32: aload 12
    //   34: ifnull +259 -> 293
    //   37: aload 12
    //   39: ldc 80
    //   41: invokevirtual 86	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   44: iconst_1
    //   45: if_icmpne +248 -> 293
    //   48: aload 12
    //   50: ldc 80
    //   52: invokevirtual 90	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   55: istore_2
    //   56: aload 12
    //   58: ifnull +240 -> 298
    //   61: aload 12
    //   63: ldc 92
    //   65: invokevirtual 86	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   68: iconst_1
    //   69: if_icmpne +229 -> 298
    //   72: aload 12
    //   74: ldc 92
    //   76: invokevirtual 90	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   79: istore_3
    //   80: aload 12
    //   82: ifnull +221 -> 303
    //   85: aload 12
    //   87: ldc 94
    //   89: invokevirtual 86	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   92: iconst_1
    //   93: if_icmpne +210 -> 303
    //   96: aload 12
    //   98: ldc 94
    //   100: invokevirtual 98	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   103: lstore 9
    //   105: lload 9
    //   107: ldc2_w 99
    //   110: ldiv
    //   111: lstore 9
    //   113: aload_0
    //   114: invokestatic 105	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   117: istore 8
    //   119: aload 12
    //   121: ifnull +188 -> 309
    //   124: aload 12
    //   126: ldc 107
    //   128: invokevirtual 86	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   131: iconst_1
    //   132: if_icmpne +177 -> 309
    //   135: aload 12
    //   137: ldc 107
    //   139: invokevirtual 90	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   142: istore 4
    //   144: aload 12
    //   146: ifnull +169 -> 315
    //   149: aload 12
    //   151: ldc 109
    //   153: invokevirtual 86	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   156: iconst_1
    //   157: if_icmpne +158 -> 315
    //   160: aload 12
    //   162: ldc 109
    //   164: invokevirtual 90	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   167: istore_1
    //   168: iload_1
    //   169: istore 5
    //   171: iload_1
    //   172: ifgt +10 -> 182
    //   175: aload 11
    //   177: getfield 113	com/tencent/mm/media/f/a:videoBitrate	I
    //   180: istore 5
    //   182: aload 13
    //   184: ifnull +136 -> 320
    //   187: aload 13
    //   189: ldc 109
    //   191: invokevirtual 86	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   194: iconst_1
    //   195: if_icmpne +125 -> 320
    //   198: aload 13
    //   200: ldc 109
    //   202: invokevirtual 90	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   205: istore_1
    //   206: aload 13
    //   208: ifnull +117 -> 325
    //   211: aload 13
    //   213: ldc 115
    //   215: invokevirtual 86	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   218: iconst_1
    //   219: if_icmpne +106 -> 325
    //   222: aload 13
    //   224: ldc 115
    //   226: invokevirtual 90	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   229: istore 6
    //   231: aload 13
    //   233: ifnull +98 -> 331
    //   236: aload 13
    //   238: ldc 117
    //   240: invokevirtual 86	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   243: iconst_1
    //   244: if_icmpne +87 -> 331
    //   247: aload 13
    //   249: ldc 117
    //   251: invokevirtual 90	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   254: istore 7
    //   256: new 6	com/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$a
    //   259: dup
    //   260: iload_2
    //   261: iload_3
    //   262: iload 4
    //   264: i2f
    //   265: lload 9
    //   267: iload 5
    //   269: iload 8
    //   271: iconst_1
    //   272: iload_1
    //   273: iload 6
    //   275: iload 7
    //   277: invokespecial 120	com/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$a:<init>	(IIFJIIZIII)V
    //   280: astore_0
    //   281: aload 11
    //   283: invokevirtual 123	com/tencent/mm/media/f/a:release	()V
    //   286: ldc 66
    //   288: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload_0
    //   292: areturn
    //   293: iconst_0
    //   294: istore_2
    //   295: goto -239 -> 56
    //   298: iconst_0
    //   299: istore_3
    //   300: goto -220 -> 80
    //   303: lconst_0
    //   304: lstore 9
    //   306: goto -201 -> 105
    //   309: iconst_0
    //   310: istore 4
    //   312: goto -168 -> 144
    //   315: iconst_0
    //   316: istore_1
    //   317: goto -149 -> 168
    //   320: iconst_0
    //   321: istore_1
    //   322: goto -116 -> 206
    //   325: iconst_0
    //   326: istore 6
    //   328: goto -97 -> 231
    //   331: iconst_0
    //   332: istore 7
    //   334: goto -78 -> 256
    //   337: astore_0
    //   338: aload 12
    //   340: astore_0
    //   341: aload_0
    //   342: ifnull +7 -> 349
    //   345: aload_0
    //   346: invokevirtual 123	com/tencent/mm/media/f/a:release	()V
    //   349: ldc 66
    //   351: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aconst_null
    //   355: areturn
    //   356: astore_0
    //   357: aconst_null
    //   358: astore 11
    //   360: aload 11
    //   362: ifnull +8 -> 370
    //   365: aload 11
    //   367: invokevirtual 123	com/tencent/mm/media/f/a:release	()V
    //   370: ldc 66
    //   372: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload_0
    //   376: athrow
    //   377: astore_0
    //   378: goto -18 -> 360
    //   381: astore_0
    //   382: aload 11
    //   384: astore_0
    //   385: goto -44 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	paramString	String
    //   167	155	1	i	int
    //   55	240	2	j	int
    //   79	221	3	k	int
    //   142	169	4	m	int
    //   169	99	5	n	int
    //   229	98	6	i1	int
    //   254	79	7	i2	int
    //   117	153	8	i3	int
    //   103	202	9	l	long
    //   16	367	11	locala	com.tencent.mm.media.f.a
    //   6	333	12	localMediaFormat1	android.media.MediaFormat
    //   30	218	13	localMediaFormat2	android.media.MediaFormat
    // Exception table:
    //   from	to	target	type
    //   8	18	337	java/lang/Exception
    //   8	18	356	finally
    //   18	32	377	finally
    //   37	56	377	finally
    //   61	80	377	finally
    //   85	105	377	finally
    //   105	119	377	finally
    //   124	144	377	finally
    //   149	168	377	finally
    //   175	182	377	finally
    //   187	206	377	finally
    //   211	231	377	finally
    //   236	256	377	finally
    //   256	281	377	finally
    //   18	32	381	java/lang/Exception
    //   37	56	381	java/lang/Exception
    //   61	80	381	java/lang/Exception
    //   85	105	381	java/lang/Exception
    //   105	119	381	java/lang/Exception
    //   124	144	381	java/lang/Exception
    //   149	168	381	java/lang/Exception
    //   175	182	381	java/lang/Exception
    //   187	206	381	java/lang/Exception
    //   211	231	381	java/lang/Exception
    //   236	256	381	java/lang/Exception
    //   256	281	381	java/lang/Exception
  }
  
  private final MultiMediaVideoChecker.a getVideoInfoBySightJNI(String paramString)
  {
    AppMethodBeat.i(195744);
    try
    {
      a locala = e.axx(paramString);
      if (locala != null)
      {
        int i = SightVideoJNI.getMp4RotateVFS(paramString);
        paramString = new MultiMediaVideoChecker.a(locala.width, locala.height, locala.frameRate, locala.videoDuration, locala.videoBitrate, i, false, locala.audioBitrate, locala.audioChannel, locala.audioSampleRate);
        AppMethodBeat.o(195744);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(195744);
    }
    return null;
  }
  
  private static boolean isH265Video(String paramString)
  {
    AppMethodBeat.i(195740);
    p.h(paramString, "path");
    boolean bool = SightVideoJNI.isH265VideoVFS(paramString);
    AppMethodBeat.o(195740);
    return bool;
  }
  
  public final MultiMediaVideoChecker.a aDk(String paramString)
  {
    AppMethodBeat.i(195741);
    p.h(paramString, "path");
    paramString = ce(paramString, false);
    AppMethodBeat.o(195741);
    return paramString;
  }
  
  public final MultiMediaVideoChecker.a ce(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195742);
    p.h(paramString, "path");
    if (i.fv(paramString))
    {
      if ((paramBoolean) && (BFU.get(paramString) != null))
      {
        paramString = (MultiMediaVideoChecker.a)BFU.get(paramString);
        AppMethodBeat.o(195742);
        return paramString;
      }
      long l = bt.HI();
      if (isH265Video(paramString)) {}
      for (MultiMediaVideoChecker.a locala = aDl(paramString);; locala = getVideoInfoBySightJNI(paramString))
      {
        ad.d(TAG, "getVideoInfo cost:" + bt.aO(l));
        if (locala != null) {
          ((Map)BFU).put(paramString, locala);
        }
        AppMethodBeat.o(195742);
        return locala;
      }
    }
    AppMethodBeat.o(195742);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker
 * JD-Core Version:    0.7.0.1
 */