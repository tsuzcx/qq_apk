package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.editor.a.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "", "muteOrigin", "", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editDatas", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "drawingRect", "", "reMuxStartTimeMs", "", "reMuxEndTimeMs", "fakeImagesList", "", "blurBgPath", "(ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;Ljava/util/ArrayList;Ljava/util/ArrayList;[FIILjava/util/ArrayList;Ljava/lang/String;)V", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditDatas", "()Ljava/util/ArrayList;", "setEditDatas", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "getFakeImagesList", "setFakeImagesList", "getMuteOrigin", "()Z", "setMuteOrigin", "(Z)V", "getReMuxEndTimeMs", "()I", "setReMuxEndTimeMs", "(I)V", "getReMuxStartTimeMs", "setReMuxStartTimeMs", "generateTargetConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isLandVideoBySizeAndRotation", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "isLandVideoOnlyBySize", "setSize", "", "config", "toString", "videoConfigForFile", "videoPath", "videoConfigForPhotoToVideo", "params", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "Companion", "EncodeConfig", "plugin-recordvideo_release"})
public final class f
{
  public static final f.a wpz;
  public String wmm;
  public float[] wnb;
  public boolean wpj;
  public AudioCacheInfo wpt;
  public ArrayList<com.tencent.mm.media.editor.a.b> wpu;
  public ArrayList<a> wpv;
  public int wpw;
  public int wpx;
  public ArrayList<String> wpy;
  
  static
  {
    AppMethodBeat.i(75378);
    wpz = new f.a((byte)0);
    AppMethodBeat.o(75378);
  }
  
  public f()
  {
    this(false, null, null, null, null, null, 511);
  }
  
  public f(boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo, ArrayList<com.tencent.mm.media.editor.a.b> paramArrayList, ArrayList<a> paramArrayList1, float[] paramArrayOfFloat, int paramInt1, int paramInt2, ArrayList<String> paramArrayList2, String paramString)
  {
    AppMethodBeat.i(75376);
    this.wpj = paramBoolean;
    this.wpt = paramAudioCacheInfo;
    this.wpu = paramArrayList;
    this.wpv = paramArrayList1;
    this.wnb = paramArrayOfFloat;
    this.wpw = paramInt1;
    this.wpx = paramInt2;
    this.wpy = paramArrayList2;
    this.wmm = paramString;
    AppMethodBeat.o(75376);
  }
  
  private static b a(String paramString, RecordConfigProvider paramRecordConfigProvider, b paramb)
  {
    AppMethodBeat.i(75374);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(75374);
      return paramb;
    }
    c localc = c.wDO;
    if (paramString == null) {
      k.fOy();
    }
    paramString = c.arc(paramString);
    if (paramString != null)
    {
      paramb.audioBitrate = paramRecordConfigProvider.wqt.audioBitrate;
      paramb.audioSampleRate = paramRecordConfigProvider.wqt.audioSampleRate;
      paramb.videoBitrate = paramString.videoBitrate;
      paramb.gTI = paramString.duc;
      paramb.gOt = paramRecordConfigProvider.wqt.gOt;
      ac.d("MicroMsg.RemuxMediaEditConfig", "video info : ".concat(String.valueOf(paramString)));
      if (paramString.videoBitrate - 200000 > paramRecordConfigProvider.wqt.videoBitrate)
      {
        paramb.videoBitrate = paramRecordConfigProvider.wqt.videoBitrate;
        paramb.wpA = true;
        ac.i("MicroMsg.RemuxMediaEditConfig", "remux by high videoBitrate " + paramString.videoBitrate + "  " + paramRecordConfigProvider.wqt.videoBitrate);
      }
      a(paramRecordConfigProvider, paramb, paramString);
      int j = paramString.fps;
      int i = j;
      if (paramString.fps > paramRecordConfigProvider.wqt.fps * 1.5F)
      {
        i = j;
        if (paramRecordConfigProvider.wqt.fps >= 0) {
          i = paramRecordConfigProvider.wqt.fps;
        }
      }
      paramb.frameRate = i;
    }
    paramb.videoBitrate = paramRecordConfigProvider.wqt.videoBitrate;
    if (paramRecordConfigProvider != null) {}
    for (paramString = paramRecordConfigProvider.wqt;; paramString = null)
    {
      if ((paramString != null) && (paramString.hCM == 2))
      {
        paramb.gOb = paramString.gOb;
        paramb.gOc = paramString.gOc;
        paramb.hCM = paramString.hCM;
        ac.i("MicroMsg.RemuxMediaEditConfig", "ABA: Min/Max QP Methods:videoBitrate [%d]  minQP [%d]  maxQP [%d]", new Object[] { Integer.valueOf(paramb.videoBitrate), Integer.valueOf(paramb.gOb), Integer.valueOf(paramb.gOc) });
      }
      paramString = paramb.duX();
      AppMethodBeat.o(75374);
      return paramString;
    }
  }
  
  private static void a(RecordConfigProvider paramRecordConfigProvider, b paramb, c.a parama)
  {
    AppMethodBeat.i(163421);
    int i = paramRecordConfigProvider.wqt.width;
    int j = paramRecordConfigProvider.wqt.height;
    boolean bool = a(parama);
    if (bool) {}
    for (;;)
    {
      int m;
      if (paramRecordConfigProvider.wqw == 1)
      {
        Point localPoint = aj.cl(ai.getContext());
        k = localPoint.y;
        m = localPoint.x;
        paramRecordConfigProvider.wqt.height = (k * paramRecordConfigProvider.wqt.width / m);
        k = parama.width;
        m = parama.height;
        if ((k - 32 > j) || (m - 32 > i))
        {
          paramb.gNU = j;
          paramb.gNV = i;
          paramb.wpA = true;
          ac.i("MicroMsg.RemuxMediaEditConfig", "remux by:FIT_SCREEN by high size " + parama.width + "  " + paramb.gNU);
        }
      }
      for (;;)
      {
        if ((paramRecordConfigProvider.wqN) && (b(parama)))
        {
          paramb.gNU = Math.min(paramRecordConfigProvider.wqt.width, paramRecordConfigProvider.wqt.height);
          paramb.gNV = Math.max(paramRecordConfigProvider.wqt.width, paramRecordConfigProvider.wqt.height);
        }
        AppMethodBeat.o(163421);
        return;
        paramb.gNV = parama.height;
        paramb.gNU = parama.width;
        continue;
        if (paramRecordConfigProvider.wqw == 2)
        {
          k = parama.width;
          m = parama.height;
          if ((k != j) || (m != i))
          {
            paramb.wpA = true;
            ac.i("MicroMsg.RemuxMediaEditConfig", "remux by:FORCE_WIDTH_AND_HEIGHT by high size ");
          }
          paramb.gNU = j;
          paramb.gNV = i;
        }
        else if (paramRecordConfigProvider.wqw == 4)
        {
          k = parama.width - 32;
          m = parama.height - 32;
          paramb.gNV = parama.height;
          paramb.gNU = parama.width;
          if (bool)
          {
            if (m > i)
            {
              paramb.gNV = i;
              paramb.gNU = (i * k / m);
              paramb.wpA = true;
              ac.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
            }
          }
          else if (k > j)
          {
            paramb.gNU = j;
            paramb.gNV = (j * m / k);
            paramb.wpA = true;
            ac.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
          }
        }
        else if (paramRecordConfigProvider.wqw == 3)
        {
          paramb.gNU = parama.width;
          paramb.gNV = parama.height;
        }
      }
      int k = i;
      i = j;
      j = k;
    }
  }
  
  private static boolean a(c.a parama)
  {
    return parama.width > parama.height;
  }
  
  private static boolean b(c.a parama)
  {
    if ((parama.duc == 90) || (parama.duc == 270)) {
      if (parama.height <= parama.width) {}
    }
    while (parama.width > parama.height)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final b a(RecordConfigProvider paramRecordConfigProvider, com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(163420);
    if ((paramRecordConfigProvider == null) || (paramb == null))
    {
      ac.e("MicroMsg.RemuxMediaEditConfig", "configProvider  is null");
      paramRecordConfigProvider = new b((byte)0);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    Object localObject1 = (Collection)paramb.hbO;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.wqt;
      k.g(paramRecordConfigProvider, "configProvider.videoParam");
      paramb = new b((byte)0);
      e.wps.duW();
      localObject1 = e.wps;
      paramb.gNU = e.getWidth();
      localObject1 = e.wps;
      paramb.gNV = e.getHeight();
      localObject1 = e.wps;
      paramb.frameRate = e.getFrameRate();
      float f2 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRy, 2.0F);
      float f1 = f2;
      if (f2 <= 1.0F) {
        f1 = 1.0F;
      }
      paramb.audioBitrate = paramRecordConfigProvider.audioBitrate;
      paramb.audioSampleRate = paramRecordConfigProvider.audioSampleRate;
      paramb.gOt = paramRecordConfigProvider.gOt;
      paramb.videoBitrate = ((int)(f1 * paramRecordConfigProvider.videoBitrate));
      paramb.gTI = 0;
      paramb.wpA = true;
      paramb.wpB = true;
      AppMethodBeat.o(163420);
      return paramb;
    }
    if (paramRecordConfigProvider.wqt == null)
    {
      localObject1 = com.tencent.mm.modelcontrol.d.aDL();
      k.g(localObject1, "SubCoreVideoControl.getCore()");
      paramRecordConfigProvider.wqt = ((com.tencent.mm.modelcontrol.d)localObject1).aDO();
    }
    localObject1 = paramRecordConfigProvider.wqt;
    Object localObject2;
    if ((localObject1 == null) || (((VideoTransPara)localObject1).hCL != 1))
    {
      localObject1 = paramRecordConfigProvider.wqt;
      if ((localObject1 == null) || (((VideoTransPara)localObject1).hCL != 2)) {}
    }
    else
    {
      localObject2 = paramRecordConfigProvider.wqt;
      if (localObject2 != null)
      {
        localObject1 = paramRecordConfigProvider.wqt;
        if (localObject1 == null) {
          break label474;
        }
        localObject1 = Integer.valueOf(((VideoTransPara)localObject1).hCU);
        ((VideoTransPara)localObject2).videoBitrate = ((Integer)localObject1).intValue();
      }
      localObject2 = new StringBuilder("match aba switch, target videoBitrate:");
      localObject1 = paramRecordConfigProvider.wqt;
      if (localObject1 == null) {
        break label480;
      }
    }
    label474:
    label480:
    for (localObject1 = Integer.valueOf(((VideoTransPara)localObject1).videoBitrate);; localObject1 = null)
    {
      ac.i("MicroMsg.RemuxMediaEditConfig", localObject1);
      if ((this.wpu.isEmpty()) && (this.wpt == null)) {
        break label486;
      }
      localObject1 = new b((byte)0);
      ((b)localObject1).wpA = true;
      ((b)localObject1).wpB = true;
      ac.i("MicroMsg.RemuxMediaEditConfig", "remux by add editItems " + this.wpu);
      paramRecordConfigProvider = a(paramb.hbF, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
      localObject1 = null;
      break;
    }
    label486:
    if ((this.wpw - 80 >= 0) || (this.wpx + 80 <= paramb.hbI))
    {
      ac.i("MicroMsg.RemuxMediaEditConfig", "remux by time reMuxEndTimeMs:" + this.wpx + "  reMuxStartTimeMs:" + this.wpw);
      localObject1 = new b((byte)0);
      ((b)localObject1).wpA = true;
      ((b)localObject1).wpB = true;
      paramRecordConfigProvider = a(paramb.hbF, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    boolean bool = r.isH265Video(paramb.hbF);
    ac.i("MicroMsg.RemuxMediaEditConfig", "generateTargetConfig, isH265File:".concat(String.valueOf(bool)));
    if (bool)
    {
      ac.i("MicroMsg.RemuxMediaEditConfig", "force remux h265 file");
      localObject1 = new b((byte)0);
      ((b)localObject1).wpA = true;
      paramRecordConfigProvider = a(paramb.hbF, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    if ((paramRecordConfigProvider.remuxType == 2) && (this.wpu.isEmpty()))
    {
      paramRecordConfigProvider = new b((byte)0);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    paramRecordConfigProvider = a(paramb.hbF, paramRecordConfigProvider, new b((byte)0));
    AppMethodBeat.o(163420);
    return paramRecordConfigProvider;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75375);
    String str = "RemuxMediaEditConfig(muteOrigin=" + this.wpj + ", audioCacheInfo=" + this.wpt + ", editItems=" + this.wpu + ", drawingRect=" + Arrays.toString(this.wnb) + ", reMuxStartTimeMs=" + this.wpw + ", reMuxEndTimeMs=" + this.wpx + ')';
    AppMethodBeat.o(75375);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "needRemux", "", "change", "minQP", "maxQP", "qpSwitch", "(IIIIIIIIZZIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getChange", "()Z", "setChange", "(Z)V", "getFrameRate", "setFrameRate", "getMaxQP", "setMaxQP", "getMinQP", "setMinQP", "getNeedRemux", "setNeedRemux", "getQpSwitch", "setQpSwitch", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "buildMediaCodecConfig", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class b
  {
    public int audioBitrate = 0;
    public int audioSampleRate = 0;
    public int frameRate = 0;
    public int gNU = 0;
    public int gNV = 0;
    public int gOb = 0;
    public int gOc = 0;
    public int gOt = 1;
    public int gTI = 0;
    public int hCM = 0;
    public int videoBitrate = 0;
    public boolean wpA = false;
    public boolean wpB = false;
    
    public final b duX()
    {
      AppMethodBeat.i(163419);
      if (this.gNU % 16 != 0) {
        this.gNU = com.tencent.mm.plugin.mmsight.d.IJ(this.gNU);
      }
      if (this.gNV % 16 != 0) {
        this.gNV = com.tencent.mm.plugin.mmsight.d.IJ(this.gNV);
      }
      AppMethodBeat.o(163419);
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.gNU != paramObject.gNU) || (this.gNV != paramObject.gNV) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.gTI != paramObject.gTI) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.gOt != paramObject.gOt) || (this.wpA != paramObject.wpA) || (this.wpB != paramObject.wpB) || (this.gOb != paramObject.gOb) || (this.gOc != paramObject.gOc) || (this.hCM != paramObject.hCM)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75373);
      String str = "EncodeConfig(targetWidth=" + this.gNU + ", targetHeight=" + this.gNV + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.gTI + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.gOt + ", needRemux=" + this.wpA + ", change=" + this.wpB + ", qpmin=" + this.gOb + ", qpmax=" + this.gOc + ')';
      AppMethodBeat.o(75373);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.f
 * JD-Core Version:    0.7.0.1
 */