package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker;", "", "()V", "MalformedAudioSampleRateThreshold", "", "TAG", "", "videoInfoCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "Lkotlin/collections/HashMap;", "getVideoFrameRate", "", "path", "getVideoInfo", "fromCache", "", "getVideoInfoByMediaExtractor", "getVideoInfoBySightJNI", "isH265Video", "VideoInfo", "plugin-vlog_release"})
public final class MultiMediaVideoChecker
{
  private static final HashMap<String, a> BXs;
  public static final MultiMediaVideoChecker BXt;
  private static final String TAG = "MicroMsg.MultiMediaVideoChecker";
  
  static
  {
    AppMethodBeat.i(191202);
    BXt = new MultiMediaVideoChecker();
    TAG = "MicroMsg.MultiMediaVideoChecker";
    BXs = new HashMap();
    AppMethodBeat.o(191202);
  }
  
  /* Error */
  private static a aEE(String paramString)
  {
    // Byte code:
    //   0: ldc 68
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 12
    //   8: new 70	com/tencent/mm/media/f/a
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 73	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   16: astore 11
    //   18: aload 11
    //   20: getfield 77	com/tencent/mm/media/f/a:hmO	Landroid/media/MediaFormat;
    //   23: astore 12
    //   25: aload 11
    //   27: getfield 80	com/tencent/mm/media/f/a:hmP	Landroid/media/MediaFormat;
    //   30: astore 13
    //   32: aload 12
    //   34: ifnull +259 -> 293
    //   37: aload 12
    //   39: ldc 82
    //   41: invokevirtual 88	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   44: iconst_1
    //   45: if_icmpne +248 -> 293
    //   48: aload 12
    //   50: ldc 82
    //   52: invokevirtual 92	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   55: istore_2
    //   56: aload 12
    //   58: ifnull +240 -> 298
    //   61: aload 12
    //   63: ldc 94
    //   65: invokevirtual 88	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   68: iconst_1
    //   69: if_icmpne +229 -> 298
    //   72: aload 12
    //   74: ldc 94
    //   76: invokevirtual 92	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   79: istore_3
    //   80: aload 12
    //   82: ifnull +221 -> 303
    //   85: aload 12
    //   87: ldc 96
    //   89: invokevirtual 88	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   92: iconst_1
    //   93: if_icmpne +210 -> 303
    //   96: aload 12
    //   98: ldc 96
    //   100: invokevirtual 100	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   103: lstore 9
    //   105: lload 9
    //   107: ldc2_w 101
    //   110: ldiv
    //   111: lstore 9
    //   113: aload_0
    //   114: invokestatic 107	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   117: istore 8
    //   119: aload 12
    //   121: ifnull +188 -> 309
    //   124: aload 12
    //   126: ldc 109
    //   128: invokevirtual 88	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   131: iconst_1
    //   132: if_icmpne +177 -> 309
    //   135: aload 12
    //   137: ldc 109
    //   139: invokevirtual 92	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   142: istore 4
    //   144: aload 12
    //   146: ifnull +169 -> 315
    //   149: aload 12
    //   151: ldc 111
    //   153: invokevirtual 88	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   156: iconst_1
    //   157: if_icmpne +158 -> 315
    //   160: aload 12
    //   162: ldc 111
    //   164: invokevirtual 92	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   167: istore_1
    //   168: iload_1
    //   169: istore 5
    //   171: iload_1
    //   172: ifgt +10 -> 182
    //   175: aload 11
    //   177: getfield 115	com/tencent/mm/media/f/a:videoBitrate	I
    //   180: istore 5
    //   182: aload 13
    //   184: ifnull +136 -> 320
    //   187: aload 13
    //   189: ldc 111
    //   191: invokevirtual 88	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   194: iconst_1
    //   195: if_icmpne +125 -> 320
    //   198: aload 13
    //   200: ldc 111
    //   202: invokevirtual 92	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   205: istore_1
    //   206: aload 13
    //   208: ifnull +117 -> 325
    //   211: aload 13
    //   213: ldc 117
    //   215: invokevirtual 88	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   218: iconst_1
    //   219: if_icmpne +106 -> 325
    //   222: aload 13
    //   224: ldc 117
    //   226: invokevirtual 92	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   229: istore 6
    //   231: aload 13
    //   233: ifnull +98 -> 331
    //   236: aload 13
    //   238: ldc 119
    //   240: invokevirtual 88	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   243: iconst_1
    //   244: if_icmpne +87 -> 331
    //   247: aload 13
    //   249: ldc 119
    //   251: invokevirtual 92	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
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
    //   277: invokespecial 122	com/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$a:<init>	(IIFJIIZIII)V
    //   280: astore_0
    //   281: aload 11
    //   283: invokevirtual 125	com/tencent/mm/media/f/a:release	()V
    //   286: ldc 68
    //   288: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   346: invokevirtual 125	com/tencent/mm/media/f/a:release	()V
    //   349: ldc 68
    //   351: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aconst_null
    //   355: areturn
    //   356: astore_0
    //   357: aconst_null
    //   358: astore 11
    //   360: aload 11
    //   362: ifnull +8 -> 370
    //   365: aload 11
    //   367: invokevirtual 125	com/tencent/mm/media/f/a:release	()V
    //   370: ldc 68
    //   372: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private final a getVideoInfoBySightJNI(String paramString)
  {
    AppMethodBeat.i(191201);
    try
    {
      a locala = e.ayN(paramString);
      if (locala != null)
      {
        int i = SightVideoJNI.getMp4RotateVFS(paramString);
        paramString = new a(locala.width, locala.height, locala.frameRate, locala.videoDuration, locala.videoBitrate, i, false, locala.audioBitrate, locala.audioChannel, locala.audioSampleRate);
        AppMethodBeat.o(191201);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(191201);
    }
    return null;
  }
  
  private static boolean isH265Video(String paramString)
  {
    AppMethodBeat.i(191197);
    p.h(paramString, "path");
    boolean bool = SightVideoJNI.isH265VideoVFS(paramString);
    AppMethodBeat.o(191197);
    return bool;
  }
  
  public final a aED(String paramString)
  {
    AppMethodBeat.i(191198);
    p.h(paramString, "path");
    paramString = ci(paramString, false);
    AppMethodBeat.o(191198);
    return paramString;
  }
  
  public final a ci(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(191199);
    p.h(paramString, "path");
    if (o.fB(paramString))
    {
      if ((paramBoolean) && (BXs.get(paramString) != null))
      {
        paramString = (a)BXs.get(paramString);
        AppMethodBeat.o(191199);
        return paramString;
      }
      long l = bu.HQ();
      a locala;
      if (isH265Video(paramString)) {
        locala = aEE(paramString);
      }
      label187:
      for (;;)
      {
        ae.d(TAG, "getVideoInfo cost:" + bu.aO(l) + ", info:" + locala);
        if (locala != null) {
          ((Map)BXs).put(paramString, locala);
        }
        AppMethodBeat.o(191199);
        return locala;
        locala = getVideoInfoBySightJNI(paramString);
        if (locala != null) {}
        for (int i = locala.audioSampleRate;; i = 0)
        {
          if (i > 1000) {
            break label187;
          }
          ae.i(TAG, "error audio sample rate:".concat(String.valueOf(locala)));
          locala = aEE(paramString);
          break;
        }
      }
    }
    AppMethodBeat.o(191199);
    return null;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "", "width", "", "height", "fps", "", "duration", "", "bitrate", "rotate", "isH265", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "(IIFJIIZIII)V", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getBitrate", "getDuration", "()J", "getFps", "()F", "getHeight", "()Z", "getRotate", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class a
  {
    public final int audioBitrate;
    final int audioChannelCount;
    public final int audioSampleRate;
    public final int bitrate;
    public final float cwp;
    public final int dHi;
    public final long duration;
    public final int height;
    public final boolean wfj;
    public final int width;
    
    public a(int paramInt1, int paramInt2, float paramFloat, long paramLong, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.cwp = paramFloat;
      this.duration = paramLong;
      this.bitrate = paramInt3;
      this.dHi = paramInt4;
      this.wfj = paramBoolean;
      this.audioBitrate = paramInt5;
      this.audioChannelCount = paramInt6;
      this.audioSampleRate = paramInt7;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(191196);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height) || (Float.compare(this.cwp, paramObject.cwp) != 0) || (this.duration != paramObject.duration) || (this.bitrate != paramObject.bitrate) || (this.dHi != paramObject.dHi) || (this.wfj != paramObject.wfj) || (this.audioBitrate != paramObject.audioBitrate) || (this.audioChannelCount != paramObject.audioChannelCount) || (this.audioSampleRate != paramObject.audioSampleRate)) {}
        }
      }
      else
      {
        AppMethodBeat.o(191196);
        return true;
      }
      AppMethodBeat.o(191196);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(191194);
      String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", fps=" + this.cwp + ", duration=" + this.duration + ", bitrate=" + this.bitrate + ", rotate=" + this.dHi + ", isH265=" + this.wfj + ", audioBitrate=" + this.audioBitrate + ", audioChannelCount=" + this.audioChannelCount + ", audioSampleRate=" + this.audioSampleRate + ")";
      AppMethodBeat.o(191194);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker
 * JD-Core Version:    0.7.0.1
 */