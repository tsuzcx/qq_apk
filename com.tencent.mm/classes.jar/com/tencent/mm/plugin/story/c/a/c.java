package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.j.e.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "TAG", "", "getTAG", "()Ljava/lang/String;", "findVideoFps", "path", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "EncodeConfig", "plugin-story_release"})
public final class c
  extends b<a>
{
  private static final String TAG = "MicroMsg.StoryEncodeElementConfig";
  public static final c ydE;
  
  static
  {
    AppMethodBeat.i(118594);
    ydE = new c();
    TAG = "MicroMsg.StoryEncodeElementConfig";
    AppMethodBeat.o(118594);
  }
  
  /* Error */
  private static int are(String paramString)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 67	com/tencent/mm/compatible/h/c
    //   8: dup
    //   9: invokespecial 68	com/tencent/mm/compatible/h/c:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload 4
    //   19: aload_0
    //   20: invokevirtual 72	com/tencent/mm/compatible/h/c:setDataSource	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokevirtual 76	com/tencent/mm/compatible/h/c:getTrackCount	()I
    //   31: istore_2
    //   32: iconst_0
    //   33: istore_1
    //   34: iload_1
    //   35: iload_2
    //   36: if_icmpge +218 -> 254
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: iload_1
    //   45: invokevirtual 80	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   48: astore_0
    //   49: aload 4
    //   51: astore_3
    //   52: aload_0
    //   53: ldc 82
    //   55: invokestatic 88	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   58: aload 4
    //   60: astore_3
    //   61: aload_0
    //   62: ldc 90
    //   64: invokevirtual 96	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   67: ifeq +192 -> 259
    //   70: aload 4
    //   72: astore_3
    //   73: aload_0
    //   74: ldc 90
    //   76: invokevirtual 100	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 105	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   82: ifeq +6 -> 88
    //   85: goto +174 -> 259
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
    //   116: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload 4
    //   121: astore_3
    //   122: aload 5
    //   124: ldc 90
    //   126: invokestatic 88	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   129: aload 4
    //   131: astore_3
    //   132: aload 5
    //   134: ldc 116
    //   136: invokestatic 122	d/n/n:mA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   139: ifeq +120 -> 259
    //   142: aload 4
    //   144: astore_3
    //   145: aload_0
    //   146: ldc 124
    //   148: invokevirtual 127	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   151: istore_1
    //   152: aload 4
    //   154: astore_3
    //   155: getstatic 55	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   158: ldc 129
    //   160: iconst_1
    //   161: anewarray 109	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: iload_1
    //   167: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload 4
    //   176: invokevirtual 138	com/tencent/mm/compatible/h/c:release	()V
    //   179: ldc 65
    //   181: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: iload_1
    //   185: ireturn
    //   186: astore 5
    //   188: aconst_null
    //   189: astore_0
    //   190: aload_0
    //   191: astore_3
    //   192: getstatic 55	com/tencent/mm/plugin/story/c/a/c:TAG	Ljava/lang/String;
    //   195: aload 5
    //   197: checkcast 140	java/lang/Throwable
    //   200: ldc 142
    //   202: iconst_0
    //   203: anewarray 109	java/lang/Object
    //   206: invokestatic 146	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload_0
    //   210: ifnull +7 -> 217
    //   213: aload_0
    //   214: invokevirtual 138	com/tencent/mm/compatible/h/c:release	()V
    //   217: ldc 65
    //   219: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_3
    //   227: aload_3
    //   228: ifnull +7 -> 235
    //   231: aload_3
    //   232: invokevirtual 138	com/tencent/mm/compatible/h/c:release	()V
    //   235: ldc 65
    //   237: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_0
    //   241: athrow
    //   242: astore_0
    //   243: goto -16 -> 227
    //   246: astore 5
    //   248: aload 4
    //   250: astore_0
    //   251: goto -61 -> 190
    //   254: iconst_0
    //   255: istore_1
    //   256: goto -82 -> 174
    //   259: iload_1
    //   260: iconst_1
    //   261: iadd
    //   262: istore_1
    //   263: goto -229 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramString	String
    //   33	230	1	i	int
    //   31	6	2	j	int
    //   16	216	3	localObject	Object
    //   12	237	4	localc	com.tencent.mm.compatible.h.c
    //   97	36	5	str	String
    //   186	10	5	localException1	Exception
    //   246	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	14	186	java/lang/Exception
    //   5	14	224	finally
    //   17	23	242	finally
    //   26	32	242	finally
    //   42	49	242	finally
    //   52	58	242	finally
    //   61	70	242	finally
    //   73	85	242	finally
    //   91	99	242	finally
    //   102	119	242	finally
    //   122	129	242	finally
    //   132	142	242	finally
    //   145	152	242	finally
    //   155	174	242	finally
    //   192	209	242	finally
    //   17	23	246	java/lang/Exception
    //   26	32	246	java/lang/Exception
    //   42	49	246	java/lang/Exception
    //   52	58	246	java/lang/Exception
    //   61	70	246	java/lang/Exception
    //   73	85	246	java/lang/Exception
    //   91	99	246	java/lang/Exception
    //   102	119	246	java/lang/Exception
    //   122	129	246	java/lang/Exception
    //   132	142	246	java/lang/Exception
    //   145	152	246	java/lang/Exception
    //   155	174	246	java/lang/Exception
  }
  
  public final void ajo()
  {
    AppMethodBeat.i(118592);
    Object localObject1 = (a)ajm();
    Object localObject2 = com.tencent.mm.plugin.story.proxy.c.ymj;
    com.tencent.mm.plugin.story.proxy.c.dIM();
    localObject2 = com.tencent.mm.plugin.story.proxy.c.getVideoPara();
    k.h(localObject2, "<set-?>");
    ((a)localObject1).vhH = ((VideoTransPara)localObject2);
    localObject1 = ((a)ajm()).vhH;
    ((a)ajm()).gnh = ((VideoTransPara)localObject1).width;
    localObject2 = (a)ajm();
    e.a locala = com.tencent.mm.media.j.e.gwv;
    ((a)localObject2).gni = e.a.mC(((VideoTransPara)localObject1).width);
    if (((a)ajm()).gni % 16 != 0) {
      ((a)ajm()).gni = com.tencent.mm.plugin.mmsight.d.GN(((a)ajm()).gni);
    }
    if (((a)ajm()).gnh % 16 != 0) {
      ((a)ajm()).gnh = com.tencent.mm.plugin.mmsight.d.GN(((a)ajm()).gnh);
    }
    ((a)ajm()).vhH.width = ((a)ajm()).gnh;
    ((a)ajm()).vhH.height = ((a)ajm()).gni;
    ((a)ajm()).videoBitrate = ((VideoTransPara)localObject1).videoBitrate;
    ((a)ajm()).audioBitrate = ((VideoTransPara)localObject1).audioBitrate;
    ((a)ajm()).frameRate = ((VideoTransPara)localObject1).fps;
    ((a)ajm()).hbW = ((VideoTransPara)localObject1).hbW;
    ((a)ajm()).duration = ((VideoTransPara)localObject1).duration;
    ((a)ajm()).hbY = ((VideoTransPara)localObject1).hbY;
    ((a)ajm()).hbX = ((VideoTransPara)localObject1).hbX;
    ((a)ajm()).isDefault = ((VideoTransPara)localObject1).isDefault;
    ((a)ajm()).hci = ((VideoTransPara)localObject1).hci;
    ((a)ajm()).audioSampleRate = ((VideoTransPara)localObject1).audioSampleRate;
    localObject1 = (a)ajm();
    k.h("StoryCheckSendVideoBitrateLimit", "key");
    if (aj.cbv())
    {
      localObject2 = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      k.g(localObject2, "MMKernel.service<IConfig…onfigService::class.java)");
    }
    for (float f = bt.getFloat(((com.tencent.mm.plugin.zero.b.a)localObject2).Zd().getValue("StoryCheckSendVideoBitrateLimit"), 1.3F);; f = bt.getFloat(CaptureMMProxy.getInstance().getDynamicConfig("StoryCheckSendVideoBitrateLimit"), 1.3F))
    {
      ((a)localObject1).ydF = f;
      if (ae.fFE.fEc != -1) {
        ((a)ajm()).fEc = ae.fFE.fEc;
      }
      if (bu.eGT())
      {
        localObject1 = (a)ajm();
        localObject2 = g.afB();
        k.g(localObject2, "MMKernel.storage()");
        ((a)localObject1).fEc = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.FsO, 2);
      }
      ad.i(TAG, "loadConfigFromVideoParam: " + (a)ajm());
      AppMethodBeat.o(118592);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "duration", "iFrame", "profileIndex", "presetIndex", "isDefault", "", "thumbSize", "audioSampleRate", "recorderType", "exceedVideoBitrateTolerance", "", "(IIIIIIIIIIZIIIF)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioSampleRate", "setAudioSampleRate", "getDuration", "setDuration", "getExceedVideoBitrateTolerance", "()F", "setExceedVideoBitrateTolerance", "(F)V", "getFrameRate", "setFrameRate", "getIFrame", "setIFrame", "()Z", "setDefault", "(Z)V", "getPresetIndex", "setPresetIndex", "getProfileIndex", "setProfileIndex", "getRecorderType", "setRecorderType", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getThumbSize", "setThumbSize", "getVideoBitrate", "setVideoBitrate", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoRotate", "setVideoRotate", "checkExceedConfigBitrate", "path", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "videoConfigForLocalFile", "", "Companion", "plugin-story_release"})
  public static final class a
  {
    public static final a ydG;
    int audioBitrate;
    int audioSampleRate;
    public int duration;
    int fEc;
    public int frameRate;
    public int gnh;
    public int gni;
    public int gta;
    int hbW;
    int hbX;
    int hbY;
    int hci;
    boolean isDefault;
    public VideoTransPara vhH;
    public int videoBitrate;
    float ydF;
    
    static
    {
      AppMethodBeat.i(118587);
      ydG = new a((byte)0);
      AppMethodBeat.o(118587);
    }
    
    private a()
    {
      AppMethodBeat.i(118586);
      this.gnh = 0;
      this.gni = 0;
      this.videoBitrate = 0;
      this.audioBitrate = 0;
      this.frameRate = 0;
      this.gta = 0;
      this.duration = 0;
      this.hbW = 0;
      this.hbX = 0;
      this.hbY = 0;
      this.isDefault = false;
      this.hci = 0;
      this.audioSampleRate = 0;
      this.fEc = 2;
      this.ydF = 1.3F;
      this.vhH = new VideoTransPara();
      AppMethodBeat.o(118586);
    }
    
    public final boolean arg(String paramString)
    {
      AppMethodBeat.i(118585);
      k.h(paramString, "path");
      if (ad.getLogLevel() >= 0)
      {
        localObject = com.tencent.mm.plugin.recordvideo.b.e.vgG;
        if (com.tencent.mm.plugin.recordvideo.b.e.dhp())
        {
          AppMethodBeat.o(118585);
          return true;
        }
      }
      Object localObject = com.tencent.mm.plugin.sight.base.e.ano(paramString);
      if (localObject != null) {}
      for (int i = ((com.tencent.mm.plugin.sight.base.a)localObject).videoBitrate;; i = 0)
      {
        int j = i;
        if (i <= 0) {
          j = i;
        }
        try
        {
          localObject = new com.tencent.mm.compatible.h.d();
          j = i;
          ((com.tencent.mm.compatible.h.d)localObject).setDataSource(paramString);
          j = i;
          i = bt.getInt(((com.tencent.mm.compatible.h.d)localObject).extractMetadata(20), 0);
          j = i;
          ((com.tencent.mm.compatible.h.d)localObject).release();
          j = i;
        }
        catch (Exception localException)
        {
          label100:
          break label100;
        }
        ad.i("MicroMsg.IEncodeConfig", "checkExceedConfigBitrate, path:" + paramString + ", bitrate:" + j + ", videoBitrate:" + this.videoBitrate + ", exceedVideoBitrateTolerance:" + this.ydF);
        if (j > this.videoBitrate * this.ydF)
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
          if ((this.gnh != paramObject.gnh) || (this.gni != paramObject.gni) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.gta != paramObject.gta) || (this.duration != paramObject.duration) || (this.hbW != paramObject.hbW) || (this.hbX != paramObject.hbX) || (this.hbY != paramObject.hbY) || (this.isDefault != paramObject.isDefault) || (this.hci != paramObject.hci) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.fEc != paramObject.fEc) || (Float.compare(this.ydF, paramObject.ydF) != 0)) {}
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
      String str = "EncodeConfig(targetWidth=" + this.gnh + ", targetHeight=" + this.gni + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.gta + ", duration=" + this.duration + ", iFrame=" + this.hbW + ", profileIndex=" + this.hbX + ", presetIndex=" + this.hbY + ", isDefault=" + this.isDefault + ", thumbSize=" + this.hci + ", audioSampleRate=" + this.audioSampleRate + ", recorderType=" + this.fEc + ", exceedVideoBitrateTolerance=" + this.ydF + ")";
      AppMethodBeat.o(118588);
      return str;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEncodeElementConfig$EncodeConfig$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.c
 * JD-Core Version:    0.7.0.1
 */