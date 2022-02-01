package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.media.util.h.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "TAG", "", "getTAG", "()Ljava/lang/String;", "findVideoFps", "path", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "EncodeConfig", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.story.c.b<a>
{
  public static final c SiN;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118594);
    SiN = new c();
    TAG = "MicroMsg.StoryEncodeElementConfig";
    AppMethodBeat.o(118594);
  }
  
  /* Error */
  private static int bbz(String paramString)
  {
    // Byte code:
    //   0: ldc 72
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 74	com/tencent/mm/compatible/i/c
    //   8: dup
    //   9: invokespecial 75	com/tencent/mm/compatible/i/c:<init>	()V
    //   12: astore 6
    //   14: aload 6
    //   16: astore 5
    //   18: aload 6
    //   20: aload_0
    //   21: invokevirtual 79	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   24: aload 6
    //   26: astore 5
    //   28: aload 6
    //   30: getfield 83	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   33: invokevirtual 89	android/media/MediaExtractor:getTrackCount	()I
    //   36: istore_3
    //   37: iload_3
    //   38: ifle +68 -> 106
    //   41: iconst_0
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_1
    //   45: iadd
    //   46: istore_2
    //   47: aload 6
    //   49: astore 5
    //   51: aload 6
    //   53: iload_1
    //   54: invokevirtual 93	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   57: astore_0
    //   58: aload 6
    //   60: astore 5
    //   62: aload_0
    //   63: ldc 95
    //   65: invokestatic 101	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   68: aload 6
    //   70: astore 5
    //   72: aload_0
    //   73: ldc 103
    //   75: invokevirtual 109	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   78: ifeq +23 -> 101
    //   81: aload 6
    //   83: astore 5
    //   85: aload_0
    //   86: ldc 103
    //   88: invokevirtual 113	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 118	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   94: istore 4
    //   96: iload 4
    //   98: ifeq +25 -> 123
    //   101: iload_2
    //   102: iload_3
    //   103: if_icmplt +196 -> 299
    //   106: iconst_0
    //   107: istore_1
    //   108: aload 6
    //   110: getfield 83	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   113: invokevirtual 121	android/media/MediaExtractor:release	()V
    //   116: ldc 72
    //   118: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_1
    //   122: ireturn
    //   123: aload 6
    //   125: astore 5
    //   127: aload_0
    //   128: ldc 103
    //   130: invokevirtual 113	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 7
    //   135: aload 6
    //   137: astore 5
    //   139: getstatic 58	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   142: ldc 123
    //   144: iconst_1
    //   145: anewarray 125	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload 7
    //   152: aastore
    //   153: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload 6
    //   158: astore 5
    //   160: aload 7
    //   162: invokestatic 134	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   165: aload 6
    //   167: astore 5
    //   169: aload 7
    //   171: ldc 136
    //   173: iconst_0
    //   174: invokestatic 142	kotlin/n/n:U	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   177: ifeq -76 -> 101
    //   180: aload 6
    //   182: astore 5
    //   184: aload_0
    //   185: ldc 144
    //   187: invokevirtual 147	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   190: istore_1
    //   191: aload 6
    //   193: astore 5
    //   195: getstatic 58	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   198: ldc 149
    //   200: iconst_1
    //   201: anewarray 125	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: iload_1
    //   207: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: aastore
    //   211: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -106 -> 108
    //   217: astore 5
    //   219: aload 6
    //   221: astore_0
    //   222: aload 5
    //   224: astore 6
    //   226: aload_0
    //   227: astore 5
    //   229: getstatic 58	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   232: aload 6
    //   234: checkcast 157	java/lang/Throwable
    //   237: ldc 159
    //   239: iconst_0
    //   240: anewarray 125	java/lang/Object
    //   243: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload_0
    //   247: ifnull +10 -> 257
    //   250: aload_0
    //   251: getfield 83	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   254: invokevirtual 121	android/media/MediaExtractor:release	()V
    //   257: ldc 72
    //   259: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: iconst_0
    //   263: ireturn
    //   264: astore_0
    //   265: aconst_null
    //   266: astore 5
    //   268: aload 5
    //   270: ifnull +11 -> 281
    //   273: aload 5
    //   275: getfield 83	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   278: invokevirtual 121	android/media/MediaExtractor:release	()V
    //   281: ldc 72
    //   283: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_0
    //   287: athrow
    //   288: astore_0
    //   289: goto -21 -> 268
    //   292: astore 6
    //   294: aconst_null
    //   295: astore_0
    //   296: goto -70 -> 226
    //   299: iload_2
    //   300: istore_1
    //   301: goto -258 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString	String
    //   42	259	1	i	int
    //   46	254	2	j	int
    //   36	68	3	k	int
    //   94	3	4	bool	boolean
    //   16	178	5	localObject1	Object
    //   217	6	5	localException1	Exception
    //   227	47	5	str1	String
    //   12	221	6	localObject2	Object
    //   292	1	6	localException2	Exception
    //   133	37	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   18	24	217	java/lang/Exception
    //   28	37	217	java/lang/Exception
    //   51	58	217	java/lang/Exception
    //   62	68	217	java/lang/Exception
    //   72	81	217	java/lang/Exception
    //   85	96	217	java/lang/Exception
    //   127	135	217	java/lang/Exception
    //   139	156	217	java/lang/Exception
    //   160	165	217	java/lang/Exception
    //   169	180	217	java/lang/Exception
    //   184	191	217	java/lang/Exception
    //   195	214	217	java/lang/Exception
    //   5	14	264	finally
    //   18	24	288	finally
    //   28	37	288	finally
    //   51	58	288	finally
    //   62	68	288	finally
    //   72	81	288	finally
    //   85	96	288	finally
    //   127	135	288	finally
    //   139	156	288	finally
    //   160	165	288	finally
    //   169	180	288	finally
    //   184	191	288	finally
    //   195	214	288	finally
    //   229	246	288	finally
    //   5	14	292	java/lang/Exception
  }
  
  public final void boD()
  {
    AppMethodBeat.i(118592);
    Object localObject1 = (a)boB();
    Object localObject2 = com.tencent.mm.plugin.story.proxy.c.Sql;
    com.tencent.mm.plugin.story.proxy.c.hxy();
    localObject2 = com.tencent.mm.plugin.story.proxy.c.getVideoPara();
    s.u(localObject2, "<set-?>");
    ((a)localObject1).oXZ = ((VideoTransPara)localObject2);
    localObject1 = ((a)boB()).oXZ;
    ((a)boB()).nxO = ((VideoTransPara)localObject1).width;
    localObject2 = (a)boB();
    h.a locala = com.tencent.mm.media.util.h.nFI;
    ((a)localObject2).nxP = h.a.uf(((VideoTransPara)localObject1).width);
    if (((a)boB()).nxP % 16 != 0) {
      ((a)boB()).nxP = com.tencent.mm.plugin.mmsight.d.aaX(((a)boB()).nxP);
    }
    if (((a)boB()).nxO % 16 != 0) {
      ((a)boB()).nxO = com.tencent.mm.plugin.mmsight.d.aaX(((a)boB()).nxO);
    }
    ((a)boB()).oXZ.width = ((a)boB()).nxO;
    ((a)boB()).oXZ.height = ((a)boB()).nxP;
    ((a)boB()).videoBitrate = ((VideoTransPara)localObject1).videoBitrate;
    ((a)boB()).audioBitrate = ((VideoTransPara)localObject1).audioBitrate;
    ((a)boB()).frameRate = ((VideoTransPara)localObject1).fps;
    ((a)boB()).nCd = ((VideoTransPara)localObject1).nCd;
    ((a)boB()).duration = ((VideoTransPara)localObject1).duration;
    ((a)boB()).oBP = ((VideoTransPara)localObject1).oBP;
    ((a)boB()).oBO = ((VideoTransPara)localObject1).oBO;
    ((a)boB()).oBZ = ((VideoTransPara)localObject1).oBZ;
    ((a)boB()).oCa = ((VideoTransPara)localObject1).oCa;
    ((a)boB()).audioSampleRate = ((VideoTransPara)localObject1).audioSampleRate;
    localObject1 = (a)boB();
    s.u("StoryCheckSendVideoBitrateLimit", "key");
    if (MMApplicationContext.isMMProcess()) {}
    for (float f = Util.getFloat(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("StoryCheckSendVideoBitrateLimit"), 1.3F);; f = Util.getFloat(CaptureMMProxy.getInstance().getDynamicConfig("StoryCheckSendVideoBitrateLimit"), 1.3F))
    {
      ((a)localObject1).SiP = f;
      if (af.lYg.lWy != -1) {
        ((a)boB()).lWy = af.lYg.lWy;
      }
      if (WeChatEnvironment.hasDebugger()) {
        ((a)boB()).lWy = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acVY, 2);
      }
      Log.i(TAG, s.X("loadConfigFromVideoParam: ", boB()));
      AppMethodBeat.o(118592);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "duration", "iFrame", "profileIndex", "presetIndex", "isDefault", "", "thumbSize", "audioSampleRate", "recorderType", "exceedVideoBitrateTolerance", "", "(IIIIIIIIIIZIIIF)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioSampleRate", "setAudioSampleRate", "getDuration", "setDuration", "getExceedVideoBitrateTolerance", "()F", "setExceedVideoBitrateTolerance", "(F)V", "getFrameRate", "setFrameRate", "getIFrame", "setIFrame", "()Z", "setDefault", "(Z)V", "getPresetIndex", "setPresetIndex", "getProfileIndex", "setProfileIndex", "getRecorderType", "setRecorderType", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getThumbSize", "setThumbSize", "getVideoBitrate", "setVideoBitrate", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoRotate", "setVideoRotate", "checkExceedConfigBitrate", "path", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "videoConfigForLocalFile", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final c.a.a SiO;
    float SiP;
    int audioBitrate;
    int audioSampleRate;
    public int duration;
    public int frameRate;
    int lWy;
    int nCd;
    public int nCg;
    public int nxO;
    public int nxP;
    int oBO;
    int oBP;
    boolean oBZ;
    int oCa;
    public VideoTransPara oXZ;
    public int videoBitrate;
    
    static
    {
      AppMethodBeat.i(118587);
      SiO = new c.a.a((byte)0);
      AppMethodBeat.o(118587);
    }
    
    private a()
    {
      AppMethodBeat.i(118586);
      this.nxO = 0;
      this.nxP = 0;
      this.videoBitrate = 0;
      this.audioBitrate = 0;
      this.frameRate = 0;
      this.nCg = 0;
      this.duration = 0;
      this.nCd = 0;
      this.oBO = 0;
      this.oBP = 0;
      this.oBZ = false;
      this.oCa = 0;
      this.audioSampleRate = 0;
      this.lWy = 2;
      this.SiP = 1.3F;
      this.oXZ = new VideoTransPara();
      AppMethodBeat.o(118586);
    }
    
    public final boolean bbB(String paramString)
    {
      AppMethodBeat.i(118585);
      s.u(paramString, "path");
      if (Log.getLogLevel() >= 0)
      {
        localObject = com.tencent.mm.plugin.recordvideo.c.f.NGM;
        if (com.tencent.mm.plugin.recordvideo.c.f.gHr())
        {
          AppMethodBeat.o(118585);
          return true;
        }
      }
      Object localObject = com.tencent.mm.plugin.sight.base.f.aVX(paramString);
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
        Log.i("MicroMsg.IEncodeConfig", "checkExceedConfigBitrate, path:" + paramString + ", bitrate:" + j + ", videoBitrate:" + this.videoBitrate + ", exceedVideoBitrateTolerance:" + this.SiP);
        if (j > this.videoBitrate * this.SiP)
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
      if (this == paramObject)
      {
        AppMethodBeat.o(118590);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(118590);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.nxO != paramObject.nxO)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.nxP != paramObject.nxP)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.videoBitrate != paramObject.videoBitrate)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.audioBitrate != paramObject.audioBitrate)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.frameRate != paramObject.frameRate)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.nCg != paramObject.nCg)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.duration != paramObject.duration)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.nCd != paramObject.nCd)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.oBO != paramObject.oBO)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.oBP != paramObject.oBP)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.oBZ != paramObject.oBZ)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.oCa != paramObject.oCa)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.audioSampleRate != paramObject.audioSampleRate)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (this.lWy != paramObject.lWy)
      {
        AppMethodBeat.o(118590);
        return false;
      }
      if (!s.p(Float.valueOf(this.SiP), Float.valueOf(paramObject.SiP)))
      {
        AppMethodBeat.o(118590);
        return false;
      }
      AppMethodBeat.o(118590);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(118588);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EncodeConfig(targetWidth=").append(this.nxO).append(", targetHeight=").append(this.nxP).append(", videoBitrate=").append(this.videoBitrate).append(", audioBitrate=").append(this.audioBitrate).append(", frameRate=").append(this.frameRate).append(", videoRotate=").append(this.nCg).append(", duration=").append(this.duration).append(", iFrame=").append(this.nCd).append(", profileIndex=").append(this.oBO).append(", presetIndex=").append(this.oBP).append(", isDefault=").append(this.oBZ).append(", thumbSize=");
      ((StringBuilder)localObject).append(this.oCa).append(", audioSampleRate=").append(this.audioSampleRate).append(", recorderType=").append(this.lWy).append(", exceedVideoBitrateTolerance=").append(this.SiP).append(')');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(118588);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.c
 * JD-Core Version:    0.7.0.1
 */