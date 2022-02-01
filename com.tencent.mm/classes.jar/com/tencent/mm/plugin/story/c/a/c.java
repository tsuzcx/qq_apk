package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.k.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "TAG", "", "getTAG", "()Ljava/lang/String;", "findVideoFps", "path", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "EncodeConfig", "plugin-story_release"})
public final class c
  extends b<a>
{
  public static final c FkZ;
  private static final String TAG = "MicroMsg.StoryEncodeElementConfig";
  
  static
  {
    AppMethodBeat.i(118594);
    FkZ = new c();
    TAG = "MicroMsg.StoryEncodeElementConfig";
    AppMethodBeat.o(118594);
  }
  
  /* Error */
  private static int aRH(String paramString)
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
    //   55: invokestatic 88	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
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
    //   126: invokestatic 88	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   129: aload 4
    //   131: astore_3
    //   132: aload 5
    //   134: ldc 116
    //   136: iconst_0
    //   137: invokestatic 122	kotlin/n/n:J	(Ljava/lang/String;Ljava/lang/String;Z)Z
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
  
  public final void aLS()
  {
    AppMethodBeat.i(118592);
    Object localObject1 = (a)aLQ();
    Object localObject2 = com.tencent.mm.plugin.story.proxy.c.Ftv;
    com.tencent.mm.plugin.story.proxy.c.fpL();
    localObject2 = com.tencent.mm.plugin.story.proxy.c.getVideoPara();
    p.h(localObject2, "<set-?>");
    ((a)localObject1).BOm = ((VideoTransPara)localObject2);
    localObject1 = ((a)aLQ()).BOm;
    ((a)aLQ()).targetWidth = ((VideoTransPara)localObject1).width;
    localObject2 = (a)aLQ();
    f.a locala = com.tencent.mm.media.k.f.ilG;
    ((a)localObject2).targetHeight = f.a.ro(((VideoTransPara)localObject1).width);
    if (((a)aLQ()).targetHeight % 16 != 0) {
      ((a)aLQ()).targetHeight = com.tencent.mm.plugin.mmsight.d.QH(((a)aLQ()).targetHeight);
    }
    if (((a)aLQ()).targetWidth % 16 != 0) {
      ((a)aLQ()).targetWidth = com.tencent.mm.plugin.mmsight.d.QH(((a)aLQ()).targetWidth);
    }
    ((a)aLQ()).BOm.width = ((a)aLQ()).targetWidth;
    ((a)aLQ()).BOm.height = ((a)aLQ()).targetHeight;
    ((a)aLQ()).videoBitrate = ((VideoTransPara)localObject1).videoBitrate;
    ((a)aLQ()).audioBitrate = ((VideoTransPara)localObject1).audioBitrate;
    ((a)aLQ()).frameRate = ((VideoTransPara)localObject1).fps;
    ((a)aLQ()).iiH = ((VideoTransPara)localObject1).iiH;
    ((a)aLQ()).duration = ((VideoTransPara)localObject1).duration;
    ((a)aLQ()).iSV = ((VideoTransPara)localObject1).iSV;
    ((a)aLQ()).iSU = ((VideoTransPara)localObject1).iSU;
    ((a)aLQ()).isDefault = ((VideoTransPara)localObject1).isDefault;
    ((a)aLQ()).iTf = ((VideoTransPara)localObject1).iTf;
    ((a)aLQ()).audioSampleRate = ((VideoTransPara)localObject1).audioSampleRate;
    localObject1 = (a)aLQ();
    p.h("StoryCheckSendVideoBitrateLimit", "key");
    if (MMApplicationContext.isMMProcess())
    {
      localObject2 = g.af(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject2, "MMKernel.service<IConfig…onfigService::class.java)");
    }
    for (float f = Util.getFloat(((com.tencent.mm.plugin.zero.b.a)localObject2).aqJ().getValue("StoryCheckSendVideoBitrateLimit"), 1.3F);; f = Util.getFloat(CaptureMMProxy.getInstance().getDynamicConfig("StoryCheckSendVideoBitrateLimit"), 1.3F))
    {
      ((a)localObject1).Fla = f;
      if (ae.gKB.gIP != -1) {
        ((a)aLQ()).gIP = ae.gKB.gIP;
      }
      if (WeChatEnvironment.hasDebugger())
      {
        localObject1 = (a)aLQ();
        localObject2 = g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        ((a)localObject1).gIP = ((com.tencent.mm.kernel.e)localObject2).azQ().getInt(ar.a.OfZ, 2);
      }
      Log.i(TAG, "loadConfigFromVideoParam: " + (a)aLQ());
      AppMethodBeat.o(118592);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "duration", "iFrame", "profileIndex", "presetIndex", "isDefault", "", "thumbSize", "audioSampleRate", "recorderType", "exceedVideoBitrateTolerance", "", "(IIIIIIIIIIZIIIF)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioSampleRate", "setAudioSampleRate", "getDuration", "setDuration", "getExceedVideoBitrateTolerance", "()F", "setExceedVideoBitrateTolerance", "(F)V", "getFrameRate", "setFrameRate", "getIFrame", "setIFrame", "()Z", "setDefault", "(Z)V", "getPresetIndex", "setPresetIndex", "getProfileIndex", "setProfileIndex", "getRecorderType", "setRecorderType", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getThumbSize", "setThumbSize", "getVideoBitrate", "setVideoBitrate", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoRotate", "setVideoRotate", "checkExceedConfigBitrate", "path", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "videoConfigForLocalFile", "", "Companion", "plugin-story_release"})
  public static final class a
  {
    public static final a Flb;
    public VideoTransPara BOm;
    float Fla;
    int audioBitrate;
    int audioSampleRate;
    public int duration;
    public int frameRate;
    int gIP;
    int iSU;
    int iSV;
    int iTf;
    public int ihS;
    int iiH;
    boolean isDefault;
    public int targetHeight;
    public int targetWidth;
    public int videoBitrate;
    
    static
    {
      AppMethodBeat.i(118587);
      Flb = new a((byte)0);
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
      this.ihS = 0;
      this.duration = 0;
      this.iiH = 0;
      this.iSU = 0;
      this.iSV = 0;
      this.isDefault = false;
      this.iTf = 0;
      this.audioSampleRate = 0;
      this.gIP = 2;
      this.Fla = 1.3F;
      this.BOm = new VideoTransPara();
      AppMethodBeat.o(118586);
    }
    
    public final boolean aRJ(String paramString)
    {
      AppMethodBeat.i(118585);
      p.h(paramString, "path");
      if (Log.getLogLevel() >= 0)
      {
        localObject = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        if (com.tencent.mm.plugin.recordvideo.b.e.eJu())
        {
          AppMethodBeat.o(118585);
          return true;
        }
      }
      Object localObject = com.tencent.mm.plugin.sight.base.e.aNx(paramString);
      if (localObject != null) {}
      for (int i = ((com.tencent.mm.plugin.sight.base.a)localObject).videoBitrate;; i = 0)
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
        Log.i("MicroMsg.IEncodeConfig", "checkExceedConfigBitrate, path:" + paramString + ", bitrate:" + j + ", videoBitrate:" + this.videoBitrate + ", exceedVideoBitrateTolerance:" + this.Fla);
        if (j > this.videoBitrate * this.Fla)
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
          if ((this.targetWidth != paramObject.targetWidth) || (this.targetHeight != paramObject.targetHeight) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.ihS != paramObject.ihS) || (this.duration != paramObject.duration) || (this.iiH != paramObject.iiH) || (this.iSU != paramObject.iSU) || (this.iSV != paramObject.iSV) || (this.isDefault != paramObject.isDefault) || (this.iTf != paramObject.iTf) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.gIP != paramObject.gIP) || (Float.compare(this.Fla, paramObject.Fla) != 0)) {}
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
      String str = "EncodeConfig(targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.ihS + ", duration=" + this.duration + ", iFrame=" + this.iiH + ", profileIndex=" + this.iSU + ", presetIndex=" + this.iSV + ", isDefault=" + this.isDefault + ", thumbSize=" + this.iTf + ", audioSampleRate=" + this.audioSampleRate + ", recorderType=" + this.gIP + ", exceedVideoBitrateTolerance=" + this.Fla + ")";
      AppMethodBeat.o(118588);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.c
 * JD-Core Version:    0.7.0.1
 */