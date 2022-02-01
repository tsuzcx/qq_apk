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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "", "muteOrigin", "", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editDatas", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "drawingRect", "", "reMuxStartTimeMs", "", "reMuxEndTimeMs", "fakeImagesList", "", "blurBgPath", "(ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;Ljava/util/ArrayList;Ljava/util/ArrayList;[FIILjava/util/ArrayList;Ljava/lang/String;)V", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditDatas", "()Ljava/util/ArrayList;", "setEditDatas", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "getFakeImagesList", "setFakeImagesList", "getMuteOrigin", "()Z", "setMuteOrigin", "(Z)V", "getReMuxEndTimeMs", "()I", "setReMuxEndTimeMs", "(I)V", "getReMuxStartTimeMs", "setReMuxStartTimeMs", "generateTargetConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isLandVideoBySizeAndRotation", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "isLandVideoOnlyBySize", "setSize", "", "config", "toString", "videoConfigForFile", "videoPath", "videoConfigForPhotoToVideo", "params", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "Companion", "EncodeConfig", "plugin-recordvideo_release"})
public final class f
{
  public static final a vgN;
  public String vdw;
  public float[] vem;
  public AudioCacheInfo vgH;
  public ArrayList<com.tencent.mm.media.editor.a.b> vgI;
  public ArrayList<a> vgJ;
  public int vgK;
  public int vgL;
  public ArrayList<String> vgM;
  public boolean vgx;
  
  static
  {
    AppMethodBeat.i(75378);
    vgN = new a((byte)0);
    AppMethodBeat.o(75378);
  }
  
  public f()
  {
    this(false, null, null, null, null, null, 511);
  }
  
  public f(boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo, ArrayList<com.tencent.mm.media.editor.a.b> paramArrayList, ArrayList<a> paramArrayList1, float[] paramArrayOfFloat, int paramInt1, int paramInt2, ArrayList<String> paramArrayList2, String paramString)
  {
    AppMethodBeat.i(75376);
    this.vgx = paramBoolean;
    this.vgH = paramAudioCacheInfo;
    this.vgI = paramArrayList;
    this.vgJ = paramArrayList1;
    this.vem = paramArrayOfFloat;
    this.vgK = paramInt1;
    this.vgL = paramInt2;
    this.vgM = paramArrayList2;
    this.vdw = paramString;
    AppMethodBeat.o(75376);
  }
  
  private static b a(String paramString, RecordConfigProvider paramRecordConfigProvider, b paramb)
  {
    AppMethodBeat.i(75374);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(75374);
      return paramb;
    }
    c localc = c.vtL;
    if (paramString == null) {
      k.fvU();
    }
    paramString = c.alZ(paramString);
    if (paramString != null)
    {
      paramb.audioBitrate = paramRecordConfigProvider.vhH.audioBitrate;
      paramb.audioSampleRate = paramRecordConfigProvider.vhH.audioSampleRate;
      paramb.videoBitrate = paramString.videoBitrate;
      paramb.gta = paramString.dwp;
      paramb.gnH = paramRecordConfigProvider.vhH.gnH;
      ad.d("MicroMsg.RemuxMediaEditConfig", "video info : ".concat(String.valueOf(paramString)));
      if (paramString.videoBitrate - 200000 > paramRecordConfigProvider.vhH.videoBitrate)
      {
        paramb.videoBitrate = paramRecordConfigProvider.vhH.videoBitrate;
        paramb.vgO = true;
        ad.i("MicroMsg.RemuxMediaEditConfig", "remux by high videoBitrate " + paramString.videoBitrate + "  " + paramRecordConfigProvider.vhH.videoBitrate);
      }
      a(paramRecordConfigProvider, paramb, paramString);
      int j = paramString.fps;
      int i = j;
      if (paramString.fps > paramRecordConfigProvider.vhH.fps * 1.5F)
      {
        i = j;
        if (paramRecordConfigProvider.vhH.fps >= 0) {
          i = paramRecordConfigProvider.vhH.fps;
        }
      }
      paramb.frameRate = i;
    }
    paramb.videoBitrate = paramRecordConfigProvider.vhH.videoBitrate;
    if (paramRecordConfigProvider != null) {}
    for (paramString = paramRecordConfigProvider.vhH;; paramString = null)
    {
      if ((paramString != null) && (paramString.hck == 2))
      {
        paramb.gnp = paramString.gnp;
        paramb.gnq = paramString.gnq;
        paramb.hck = paramString.hck;
        ad.i("MicroMsg.RemuxMediaEditConfig", "ABA: Min/Max QP Methods:videoBitrate [%d]  minQP [%d]  maxQP [%d]", new Object[] { Integer.valueOf(paramb.videoBitrate), Integer.valueOf(paramb.gnp), Integer.valueOf(paramb.gnq) });
      }
      paramString = paramb.dhr();
      AppMethodBeat.o(75374);
      return paramString;
    }
  }
  
  private static void a(RecordConfigProvider paramRecordConfigProvider, b paramb, c.a parama)
  {
    AppMethodBeat.i(163421);
    int i = paramRecordConfigProvider.vhH.width;
    int j = paramRecordConfigProvider.vhH.height;
    boolean bool = a(parama);
    if (bool) {}
    for (;;)
    {
      int m;
      if (paramRecordConfigProvider.vhK == 1)
      {
        Point localPoint = ai.cf(aj.getContext());
        k = localPoint.y;
        m = localPoint.x;
        paramRecordConfigProvider.vhH.height = (k * paramRecordConfigProvider.vhH.width / m);
        k = parama.width;
        m = parama.height;
        if ((k - 32 > j) || (m - 32 > i))
        {
          paramb.gnh = j;
          paramb.gni = i;
          paramb.vgO = true;
          ad.i("MicroMsg.RemuxMediaEditConfig", "remux by:FIT_SCREEN by high size " + parama.width + "  " + paramb.gnh);
        }
      }
      for (;;)
      {
        if ((paramRecordConfigProvider.vic) && (b(parama)))
        {
          paramb.gnh = Math.min(paramRecordConfigProvider.vhH.width, paramRecordConfigProvider.vhH.height);
          paramb.gni = Math.max(paramRecordConfigProvider.vhH.width, paramRecordConfigProvider.vhH.height);
        }
        AppMethodBeat.o(163421);
        return;
        paramb.gni = parama.height;
        paramb.gnh = parama.width;
        continue;
        if (paramRecordConfigProvider.vhK == 2)
        {
          k = parama.width;
          m = parama.height;
          if ((k != j) || (m != i))
          {
            paramb.vgO = true;
            ad.i("MicroMsg.RemuxMediaEditConfig", "remux by:FORCE_WIDTH_AND_HEIGHT by high size ");
          }
          paramb.gnh = j;
          paramb.gni = i;
        }
        else if (paramRecordConfigProvider.vhK == 4)
        {
          k = parama.width - 32;
          m = parama.height - 32;
          paramb.gni = parama.height;
          paramb.gnh = parama.width;
          if (bool)
          {
            if (m > i)
            {
              paramb.gni = i;
              paramb.gnh = (i * k / m);
              paramb.vgO = true;
              ad.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
            }
          }
          else if (k > j)
          {
            paramb.gnh = j;
            paramb.gni = (j * m / k);
            paramb.vgO = true;
            ad.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
          }
        }
        else if (paramRecordConfigProvider.vhK == 3)
        {
          paramb.gnh = parama.width;
          paramb.gni = parama.height;
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
    if ((parama.dwp == 90) || (parama.dwp == 270)) {
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
      ad.e("MicroMsg.RemuxMediaEditConfig", "configProvider  is null");
      paramRecordConfigProvider = new b((byte)0);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    Object localObject1 = (Collection)paramb.gBs;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.vhH;
      k.g(paramRecordConfigProvider, "configProvider.videoParam");
      paramb = new b((byte)0);
      e.vgG.dhq();
      localObject1 = e.vgG;
      paramb.gnh = e.getWidth();
      localObject1 = e.vgG;
      paramb.gni = e.getHeight();
      localObject1 = e.vgG;
      paramb.frameRate = e.getFrameRate();
      float f2 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pnY, 2.0F);
      float f1 = f2;
      if (f2 <= 1.0F) {
        f1 = 1.0F;
      }
      paramb.audioBitrate = paramRecordConfigProvider.audioBitrate;
      paramb.audioSampleRate = paramRecordConfigProvider.audioSampleRate;
      paramb.gnH = paramRecordConfigProvider.gnH;
      paramb.videoBitrate = ((int)(f1 * paramRecordConfigProvider.videoBitrate));
      paramb.gta = 0;
      paramb.vgO = true;
      paramb.vgP = true;
      AppMethodBeat.o(163420);
      return paramb;
    }
    if (paramRecordConfigProvider.vhH == null)
    {
      localObject1 = com.tencent.mm.modelcontrol.d.awT();
      k.g(localObject1, "SubCoreVideoControl.getCore()");
      paramRecordConfigProvider.vhH = ((com.tencent.mm.modelcontrol.d)localObject1).awW();
    }
    localObject1 = paramRecordConfigProvider.vhH;
    Object localObject2;
    if ((localObject1 == null) || (((VideoTransPara)localObject1).hcj != 1))
    {
      localObject1 = paramRecordConfigProvider.vhH;
      if ((localObject1 == null) || (((VideoTransPara)localObject1).hcj != 2)) {}
    }
    else
    {
      localObject2 = paramRecordConfigProvider.vhH;
      if (localObject2 != null)
      {
        localObject1 = paramRecordConfigProvider.vhH;
        if (localObject1 == null) {
          break label474;
        }
        localObject1 = Integer.valueOf(((VideoTransPara)localObject1).hcr);
        ((VideoTransPara)localObject2).videoBitrate = ((Integer)localObject1).intValue();
      }
      localObject2 = new StringBuilder("match aba switch, target videoBitrate:");
      localObject1 = paramRecordConfigProvider.vhH;
      if (localObject1 == null) {
        break label480;
      }
    }
    label474:
    label480:
    for (localObject1 = Integer.valueOf(((VideoTransPara)localObject1).videoBitrate);; localObject1 = null)
    {
      ad.i("MicroMsg.RemuxMediaEditConfig", localObject1);
      if ((this.vgI.isEmpty()) && (this.vgH == null)) {
        break label486;
      }
      localObject1 = new b((byte)0);
      ((b)localObject1).vgO = true;
      ((b)localObject1).vgP = true;
      ad.i("MicroMsg.RemuxMediaEditConfig", "remux by add editItems " + this.vgI);
      paramRecordConfigProvider = a(paramb.gBj, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
      localObject1 = null;
      break;
    }
    label486:
    if ((this.vgK - 80 >= 0) || (this.vgL + 80 <= paramb.gBm))
    {
      ad.i("MicroMsg.RemuxMediaEditConfig", "remux by time reMuxEndTimeMs:" + this.vgL + "  reMuxStartTimeMs:" + this.vgK);
      localObject1 = new b((byte)0);
      ((b)localObject1).vgO = true;
      ((b)localObject1).vgP = true;
      paramRecordConfigProvider = a(paramb.gBj, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    boolean bool = r.isH265Video(paramb.gBj);
    ad.i("MicroMsg.RemuxMediaEditConfig", "generateTargetConfig, isH265File:".concat(String.valueOf(bool)));
    if (bool)
    {
      ad.i("MicroMsg.RemuxMediaEditConfig", "force remux h265 file");
      localObject1 = new b((byte)0);
      ((b)localObject1).vgO = true;
      paramRecordConfigProvider = a(paramb.gBj, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    if ((paramRecordConfigProvider.vhB == 2) && (this.vgI.isEmpty()))
    {
      paramRecordConfigProvider = new b((byte)0);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    paramRecordConfigProvider = a(paramb.gBj, paramRecordConfigProvider, new b((byte)0));
    AppMethodBeat.o(163420);
    return paramRecordConfigProvider;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75375);
    String str = "RemuxMediaEditConfig(muteOrigin=" + this.vgx + ", audioCacheInfo=" + this.vgH + ", editItems=" + this.vgI + ", drawingRect=" + Arrays.toString(this.vem) + ", reMuxStartTimeMs=" + this.vgK + ", reMuxEndTimeMs=" + this.vgL + ')';
    AppMethodBeat.o(75375);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$Companion;", "", "()V", "TAG", "", "VIDEO_BITRATE_TOLERANT", "", "VIDEO_DURATION_TOLERANT_MS", "VIDEO_FPS_TOLERANT_RATIO", "", "VIDEO_LENGTH_TOLERANT", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "needRemux", "", "change", "minQP", "maxQP", "qpSwitch", "(IIIIIIIIZZIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getChange", "()Z", "setChange", "(Z)V", "getFrameRate", "setFrameRate", "getMaxQP", "setMaxQP", "getMinQP", "setMinQP", "getNeedRemux", "setNeedRemux", "getQpSwitch", "setQpSwitch", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "buildMediaCodecConfig", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class b
  {
    public int audioBitrate = 0;
    public int audioSampleRate = 0;
    public int frameRate = 0;
    public int gnH = 1;
    public int gnh = 0;
    public int gni = 0;
    public int gnp = 0;
    public int gnq = 0;
    public int gta = 0;
    public int hck = 0;
    public boolean vgO = false;
    public boolean vgP = false;
    public int videoBitrate = 0;
    
    public final b dhr()
    {
      AppMethodBeat.i(163419);
      if (this.gnh % 16 != 0) {
        this.gnh = com.tencent.mm.plugin.mmsight.d.GN(this.gnh);
      }
      if (this.gni % 16 != 0) {
        this.gni = com.tencent.mm.plugin.mmsight.d.GN(this.gni);
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
          if ((this.gnh != paramObject.gnh) || (this.gni != paramObject.gni) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.gta != paramObject.gta) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.gnH != paramObject.gnH) || (this.vgO != paramObject.vgO) || (this.vgP != paramObject.vgP) || (this.gnp != paramObject.gnp) || (this.gnq != paramObject.gnq) || (this.hck != paramObject.hck)) {}
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
      String str = "EncodeConfig(targetWidth=" + this.gnh + ", targetHeight=" + this.gni + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.gta + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.gnH + ", needRemux=" + this.vgO + ", change=" + this.vgP + ", qpmin=" + this.gnp + ", qpmax=" + this.gnq + ')';
      AppMethodBeat.o(75373);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.f
 * JD-Core Version:    0.7.0.1
 */