package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.media.k.h.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "TAG", "", "getTAG", "()Ljava/lang/String;", "findVideoFps", "path", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "EncodeConfig", "plugin-story_release"})
public final class c
  extends com.tencent.mm.plugin.story.c.b<a>
{
  public static final c LFb;
  private static final String TAG = "MicroMsg.StoryEncodeElementConfig";
  
  static
  {
    AppMethodBeat.i(118594);
    LFb = new c();
    TAG = "MicroMsg.StoryEncodeElementConfig";
    AppMethodBeat.o(118594);
  }
  
  /* Error */
  private static int bcL(String paramString)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 67	com/tencent/mm/compatible/i/c
    //   8: dup
    //   9: invokespecial 68	com/tencent/mm/compatible/i/c:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload 4
    //   19: aload_0
    //   20: invokevirtual 72	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokevirtual 76	com/tencent/mm/compatible/i/c:getTrackCount	()I
    //   31: istore_2
    //   32: iconst_0
    //   33: istore_1
    //   34: iload_1
    //   35: iload_2
    //   36: if_icmpge +219 -> 255
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: iload_1
    //   45: invokevirtual 80	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   48: astore_0
    //   49: aload 4
    //   51: astore_3
    //   52: aload_0
    //   53: ldc 82
    //   55: invokestatic 88	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   58: aload 4
    //   60: astore_3
    //   61: aload_0
    //   62: ldc 90
    //   64: invokevirtual 96	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   67: ifeq +193 -> 260
    //   70: aload 4
    //   72: astore_3
    //   73: aload_0
    //   74: ldc 90
    //   76: invokevirtual 100	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   82: ifeq +6 -> 88
    //   85: goto +175 -> 260
    //   88: aload 4
    //   90: astore_3
    //   91: aload_0
    //   92: ldc 90
    //   94: invokevirtual 100	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 5
    //   99: aload 4
    //   101: astore_3
    //   102: getstatic 55	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   105: ldc 107
    //   107: iconst_1
    //   108: anewarray 109	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 5
    //   115: aastore
    //   116: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload 4
    //   121: astore_3
    //   122: aload 5
    //   124: ldc 90
    //   126: invokestatic 88	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   129: aload 4
    //   131: astore_3
    //   132: aload 5
    //   134: ldc 116
    //   136: iconst_0
    //   137: invokestatic 122	kotlin/n/n:M	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   140: ifeq +120 -> 260
    //   143: aload 4
    //   145: astore_3
    //   146: aload_0
    //   147: ldc 124
    //   149: invokevirtual 127	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   152: istore_1
    //   153: aload 4
    //   155: astore_3
    //   156: getstatic 55	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   159: ldc 129
    //   161: iconst_1
    //   162: anewarray 109	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: iload_1
    //   168: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: aastore
    //   172: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload 4
    //   177: invokevirtual 138	com/tencent/mm/compatible/i/c:release	()V
    //   180: ldc 65
    //   182: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iload_1
    //   186: ireturn
    //   187: astore 5
    //   189: aconst_null
    //   190: astore_0
    //   191: aload_0
    //   192: astore_3
    //   193: getstatic 55	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   196: aload 5
    //   198: checkcast 140	java/lang/Throwable
    //   201: ldc 142
    //   203: iconst_0
    //   204: anewarray 109	java/lang/Object
    //   207: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_0
    //   211: ifnull +7 -> 218
    //   214: aload_0
    //   215: invokevirtual 138	com/tencent/mm/compatible/i/c:release	()V
    //   218: ldc 65
    //   220: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_3
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 138	com/tencent/mm/compatible/i/c:release	()V
    //   236: ldc 65
    //   238: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_0
    //   242: athrow
    //   243: astore_0
    //   244: goto -16 -> 228
    //   247: astore 5
    //   249: aload 4
    //   251: astore_0
    //   252: goto -61 -> 191
    //   255: iconst_0
    //   256: istore_1
    //   257: goto -82 -> 175
    //   260: iload_1
    //   261: iconst_1
    //   262: iadd
    //   263: istore_1
    //   264: goto -230 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramString	String
    //   33	231	1	i	int
    //   31	6	2	j	int
    //   16	217	3	localObject	Object
    //   12	238	4	localc	com.tencent.mm.compatible.i.c
    //   97	36	5	str	String
    //   187	10	5	localException1	Exception
    //   247	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	14	187	java/lang/Exception
    //   5	14	225	finally
    //   17	23	243	finally
    //   26	32	243	finally
    //   42	49	243	finally
    //   52	58	243	finally
    //   61	70	243	finally
    //   73	85	243	finally
    //   91	99	243	finally
    //   102	119	243	finally
    //   122	129	243	finally
    //   132	143	243	finally
    //   146	153	243	finally
    //   156	175	243	finally
    //   193	210	243	finally
    //   17	23	247	java/lang/Exception
    //   26	32	247	java/lang/Exception
    //   42	49	247	java/lang/Exception
    //   52	58	247	java/lang/Exception
    //   61	70	247	java/lang/Exception
    //   73	85	247	java/lang/Exception
    //   91	99	247	java/lang/Exception
    //   102	119	247	java/lang/Exception
    //   122	129	247	java/lang/Exception
    //   132	143	247	java/lang/Exception
    //   146	153	247	java/lang/Exception
    //   156	175	247	java/lang/Exception
  }
  
  public final void aTZ()
  {
    AppMethodBeat.i(118592);
    Object localObject1 = (a)aTX();
    Object localObject2 = com.tencent.mm.plugin.story.proxy.c.LNy;
    com.tencent.mm.plugin.story.proxy.c.gef();
    localObject2 = com.tencent.mm.plugin.story.proxy.c.getVideoPara();
    p.k(localObject2, "<set-?>");
    ((a)localObject1).mfk = ((VideoTransPara)localObject2);
    localObject1 = ((a)aTX()).mfk;
    ((a)aTX()).targetWidth = ((VideoTransPara)localObject1).width;
    localObject2 = (a)aTX();
    h.a locala = com.tencent.mm.media.k.h.laG;
    ((a)localObject2).targetHeight = h.a.ug(((VideoTransPara)localObject1).width);
    if (((a)aTX()).targetHeight % 16 != 0) {
      ((a)aTX()).targetHeight = com.tencent.mm.plugin.mmsight.d.WV(((a)aTX()).targetHeight);
    }
    if (((a)aTX()).targetWidth % 16 != 0) {
      ((a)aTX()).targetWidth = com.tencent.mm.plugin.mmsight.d.WV(((a)aTX()).targetWidth);
    }
    ((a)aTX()).mfk.width = ((a)aTX()).targetWidth;
    ((a)aTX()).mfk.height = ((a)aTX()).targetHeight;
    ((a)aTX()).videoBitrate = ((VideoTransPara)localObject1).videoBitrate;
    ((a)aTX()).audioBitrate = ((VideoTransPara)localObject1).audioBitrate;
    ((a)aTX()).frameRate = ((VideoTransPara)localObject1).fps;
    ((a)aTX()).kXt = ((VideoTransPara)localObject1).kXt;
    ((a)aTX()).duration = ((VideoTransPara)localObject1).duration;
    ((a)aTX()).lJn = ((VideoTransPara)localObject1).lJn;
    ((a)aTX()).lJm = ((VideoTransPara)localObject1).lJm;
    ((a)aTX()).lJx = ((VideoTransPara)localObject1).lJx;
    ((a)aTX()).lJy = ((VideoTransPara)localObject1).lJy;
    ((a)aTX()).audioSampleRate = ((VideoTransPara)localObject1).audioSampleRate;
    localObject1 = (a)aTX();
    p.k("StoryCheckSendVideoBitrateLimit", "key");
    if (MMApplicationContext.isMMProcess())
    {
      localObject2 = com.tencent.mm.kernel.h.ae(a.class);
      p.j(localObject2, "MMKernel.service<IConfig…onfigService::class.java)");
    }
    for (float f = Util.getFloat(((a)localObject2).axc().getValue("StoryCheckSendVideoBitrateLimit"), 1.3F);; f = Util.getFloat(CaptureMMProxy.getInstance().getDynamicConfig("StoryCheckSendVideoBitrateLimit"), 1.3F))
    {
      ((a)localObject1).LFc = f;
      if (af.juP.jth != -1) {
        ((a)aTX()).jth = af.juP.jth;
      }
      if (WeChatEnvironment.hasDebugger())
      {
        localObject1 = (a)aTX();
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        ((a)localObject1).jth = ((com.tencent.mm.kernel.f)localObject2).aHp().getInt(ar.a.Vup, 2);
      }
      Log.i(TAG, "loadConfigFromVideoParam: " + (a)aTX());
      AppMethodBeat.o(118592);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "duration", "iFrame", "profileIndex", "presetIndex", "isDefault", "", "thumbSize", "audioSampleRate", "recorderType", "exceedVideoBitrateTolerance", "", "(IIIIIIIIIIZIIIF)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioSampleRate", "setAudioSampleRate", "getDuration", "setDuration", "getExceedVideoBitrateTolerance", "()F", "setExceedVideoBitrateTolerance", "(F)V", "getFrameRate", "setFrameRate", "getIFrame", "setIFrame", "()Z", "setDefault", "(Z)V", "getPresetIndex", "setPresetIndex", "getProfileIndex", "setProfileIndex", "getRecorderType", "setRecorderType", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getThumbSize", "setThumbSize", "getVideoBitrate", "setVideoBitrate", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoRotate", "setVideoRotate", "checkExceedConfigBitrate", "path", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "videoConfigForLocalFile", "", "Companion", "plugin-story_release"})
  public static final class a
  {
    public static final a LFd;
    float LFc;
    int audioBitrate;
    int audioSampleRate;
    public int duration;
    public int frameRate;
    int jth;
    public int kWG;
    int kXt;
    int lJm;
    int lJn;
    boolean lJx;
    int lJy;
    public VideoTransPara mfk;
    public int targetHeight;
    public int targetWidth;
    public int videoBitrate;
    
    static
    {
      AppMethodBeat.i(118587);
      LFd = new a((byte)0);
      AppMethodBeat.o(118587);
    }
    
    private a()
    {
      AppMethodBeat.i(118586);
      this.targetWidth = 0;
      this.targetHeight = 0;
      this.videoBitrate = 0;
      this.audioBitrate = 0;
      this.frameRate = 0;
      this.kWG = 0;
      this.duration = 0;
      this.kXt = 0;
      this.lJm = 0;
      this.lJn = 0;
      this.lJx = false;
      this.lJy = 0;
      this.audioSampleRate = 0;
      this.jth = 2;
      this.LFc = 1.3F;
      this.mfk = new VideoTransPara();
      AppMethodBeat.o(118586);
    }
    
    public final boolean bcN(String paramString)
    {
      AppMethodBeat.i(118585);
      p.k(paramString, "path");
      if (Log.getLogLevel() >= 0)
      {
        localObject = com.tencent.mm.plugin.recordvideo.b.f.HJU;
        if (com.tencent.mm.plugin.recordvideo.b.f.fvD())
        {
          AppMethodBeat.o(118585);
          return true;
        }
      }
      Object localObject = com.tencent.mm.plugin.sight.base.f.aYg(paramString);
      if (localObject != null) {}
      for (int i = ((com.tencent.mm.plugin.sight.base.b)localObject).videoBitrate;; i = 0)
      {
        int j = i;
        if (i <= 0) {
          j = i;
        }
        try
        {
          localObject = new com.tencent.mm.compatible.i.d();
          j = i;
          ((com.tencent.mm.compatible.i.d)localObject).setDataSource(paramString);
          j = i;
          i = Util.getInt(((com.tencent.mm.compatible.i.d)localObject).extractMetadata(20), 0);
          j = i;
          ((com.tencent.mm.compatible.i.d)localObject).release();
          j = i;
        }
        catch (Exception localException)
        {
          label100:
          break label100;
        }
        Log.i("MicroMsg.IEncodeConfig", "checkExceedConfigBitrate, path:" + paramString + ", bitrate:" + j + ", videoBitrate:" + this.videoBitrate + ", exceedVideoBitrateTolerance:" + this.LFc);
        if (j > this.videoBitrate * this.LFc)
        {
          AppMethodBeat.o(118585);
          return true;
        }
        AppMethodBeat.o(118585);
        return false;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(118590);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.targetWidth != paramObject.targetWidth) || (this.targetHeight != paramObject.targetHeight) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.kWG != paramObject.kWG) || (this.duration != paramObject.duration) || (this.kXt != paramObject.kXt) || (this.lJm != paramObject.lJm) || (this.lJn != paramObject.lJn) || (this.lJx != paramObject.lJx) || (this.lJy != paramObject.lJy) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.jth != paramObject.jth) || (Float.compare(this.LFc, paramObject.LFc) != 0)) {}
        }
      }
      else
      {
        AppMethodBeat.o(118590);
        return true;
      }
      AppMethodBeat.o(118590);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(118588);
      String str = "EncodeConfig(targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.kWG + ", duration=" + this.duration + ", iFrame=" + this.kXt + ", profileIndex=" + this.lJm + ", presetIndex=" + this.lJn + ", isDefault=" + this.lJx + ", thumbSize=" + this.lJy + ", audioSampleRate=" + this.audioSampleRate + ", recorderType=" + this.jth + ", exceedVideoBitrateTolerance=" + this.LFc + ")";
      AppMethodBeat.o(118588);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.c
 * JD-Core Version:    0.7.0.1
 */