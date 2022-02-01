package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.e.d.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "", "muteOrigin", "", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "drawingRect", "", "reMuxStartTimeMs", "", "reMuxEndTimeMs", "fakeImagesList", "", "blurBgPath", "validRect", "(ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;Ljava/util/ArrayList;Ljava/util/ArrayList;[FIILjava/util/ArrayList;Ljava/lang/String;[F)V", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "getFakeImagesList", "setFakeImagesList", "getMuteOrigin", "()Z", "setMuteOrigin", "(Z)V", "getReMuxEndTimeMs", "()I", "setReMuxEndTimeMs", "(I)V", "getReMuxStartTimeMs", "setReMuxStartTimeMs", "getValidRect", "setValidRect", "generateTargetConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isLandVideoBySizeAndRotation", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "isLandVideoOnlyBySize", "setSize", "", "config", "toString", "videoConfigForFile", "videoPath", "videoConfigForPhotoToVideo", "params", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "Companion", "EncodeConfig", "plugin-recordvideo_release"})
public final class f
{
  public static final f.a BNs;
  public float[] BKV;
  public float[] BKW;
  public String BLa;
  public boolean BNc;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> BNn;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> BNo;
  public int BNp;
  public int BNq;
  public ArrayList<String> BNr;
  public AudioCacheInfo wgG;
  
  static
  {
    AppMethodBeat.i(75378);
    BNs = new f.a((byte)0);
    AppMethodBeat.o(75378);
  }
  
  public f(boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramArrayList, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramArrayList1, float[] paramArrayOfFloat1, int paramInt1, int paramInt2, ArrayList<String> paramArrayList2, String paramString, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(237255);
    this.BNc = paramBoolean;
    this.wgG = paramAudioCacheInfo;
    this.BNn = paramArrayList;
    this.BNo = paramArrayList1;
    this.BKV = paramArrayOfFloat1;
    this.BNp = paramInt1;
    this.BNq = paramInt2;
    this.BNr = paramArrayList2;
    this.BLa = paramString;
    this.BKW = paramArrayOfFloat2;
    AppMethodBeat.o(237255);
  }
  
  private static b a(String paramString, RecordConfigProvider paramRecordConfigProvider, b paramb)
  {
    AppMethodBeat.i(75374);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(75374);
      return paramb;
    }
    com.tencent.mm.plugin.recordvideo.e.d locald = com.tencent.mm.plugin.recordvideo.e.d.Cin;
    if (paramString == null) {
      p.hyc();
    }
    paramString = com.tencent.mm.plugin.recordvideo.e.d.aLQ(paramString);
    if (paramString != null)
    {
      paramb.audioBitrate = paramRecordConfigProvider.BOm.audioBitrate;
      paramb.audioSampleRate = paramRecordConfigProvider.BOm.audioSampleRate;
      paramb.videoBitrate = paramString.videoBitrate;
      paramb.ihS = paramString.dYT;
      paramb.audioChannelCount = paramRecordConfigProvider.BOm.audioChannelCount;
      Log.d("MicroMsg.RemuxMediaEditConfig", "video info : ".concat(String.valueOf(paramString)));
      if (paramString.videoBitrate - 200000 > paramRecordConfigProvider.BOm.videoBitrate)
      {
        paramb.videoBitrate = paramRecordConfigProvider.BOm.videoBitrate;
        paramb.BNt = true;
        Log.i("MicroMsg.RemuxMediaEditConfig", "remux by high videoBitrate " + paramString.videoBitrate + "  " + paramRecordConfigProvider.BOm.videoBitrate);
      }
      a(paramRecordConfigProvider, paramb, paramString);
      int j = paramString.fps;
      int i = j;
      if (paramString.fps > paramRecordConfigProvider.BOm.fps * 1.5F)
      {
        i = j;
        if (paramRecordConfigProvider.BOm.fps >= 0) {
          i = paramRecordConfigProvider.BOm.fps;
        }
      }
      paramb.frameRate = i;
    }
    paramb.videoBitrate = paramRecordConfigProvider.BOm.videoBitrate;
    if (paramRecordConfigProvider != null) {}
    for (paramString = paramRecordConfigProvider.BOm;; paramString = null)
    {
      if ((paramString != null) && (paramString.iTh == 2))
      {
        paramb.idF = paramString.idF;
        paramb.idG = paramString.idG;
        paramb.iTh = paramString.iTh;
        Log.i("MicroMsg.RemuxMediaEditConfig", "ABA: Min/Max QP Methods:videoBitrate [%d]  minQP [%d]  maxQP [%d]", new Object[] { Integer.valueOf(paramb.videoBitrate), Integer.valueOf(paramb.idF), Integer.valueOf(paramb.idG) });
      }
      paramString = paramb.eJw();
      AppMethodBeat.o(75374);
      return paramString;
    }
  }
  
  private static void a(RecordConfigProvider paramRecordConfigProvider, b paramb, d.a parama)
  {
    AppMethodBeat.i(163421);
    int i = paramRecordConfigProvider.BOm.width;
    int j = paramRecordConfigProvider.BOm.height;
    boolean bool = a(parama);
    if (bool) {}
    for (;;)
    {
      int m;
      if (paramRecordConfigProvider.BOp == 1)
      {
        Point localPoint = ao.az(MMApplicationContext.getContext());
        k = localPoint.y;
        m = localPoint.x;
        paramRecordConfigProvider.BOm.height = (k * paramRecordConfigProvider.BOm.width / m);
        k = parama.width;
        m = parama.height;
        if ((k - 32 > j) || (m - 32 > i))
        {
          paramb.targetWidth = j;
          paramb.targetHeight = i;
          paramb.BNt = true;
          Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:FIT_SCREEN by high size " + parama.width + "  " + paramb.targetWidth);
        }
      }
      for (;;)
      {
        if ((paramRecordConfigProvider.BOH) && (b(parama)))
        {
          paramb.targetWidth = Math.min(paramRecordConfigProvider.BOm.width, paramRecordConfigProvider.BOm.height);
          paramb.targetHeight = Math.max(paramRecordConfigProvider.BOm.width, paramRecordConfigProvider.BOm.height);
        }
        AppMethodBeat.o(163421);
        return;
        paramb.targetHeight = parama.height;
        paramb.targetWidth = parama.width;
        continue;
        if (paramRecordConfigProvider.BOp == 2)
        {
          k = parama.width;
          m = parama.height;
          if ((k != j) || (m != i))
          {
            paramb.BNt = true;
            Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:FORCE_WIDTH_AND_HEIGHT by high size ");
          }
          paramb.targetWidth = j;
          paramb.targetHeight = i;
        }
        else if (paramRecordConfigProvider.BOp == 4)
        {
          k = parama.width - 32;
          m = parama.height - 32;
          paramb.targetHeight = parama.height;
          paramb.targetWidth = parama.width;
          if (bool)
          {
            if (m > i)
            {
              paramb.targetHeight = i;
              paramb.targetWidth = (i * k / m);
              paramb.BNt = true;
              Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
            }
          }
          else if (k > j)
          {
            paramb.targetWidth = j;
            paramb.targetHeight = (j * m / k);
            paramb.BNt = true;
            Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
          }
        }
        else if (paramRecordConfigProvider.BOp == 3)
        {
          paramb.targetWidth = parama.width;
          paramb.targetHeight = parama.height;
        }
      }
      int k = i;
      i = j;
      j = k;
    }
  }
  
  private static boolean a(d.a parama)
  {
    return parama.width > parama.height;
  }
  
  private static boolean b(d.a parama)
  {
    if ((parama.dYT == 90) || (parama.dYT == 270)) {
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
      Log.e("MicroMsg.RemuxMediaEditConfig", "configProvider  is null");
      paramRecordConfigProvider = new b((byte)0);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    Object localObject1 = (Collection)paramb.iqm;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.BOm;
      p.g(paramRecordConfigProvider, "configProvider.videoParam");
      paramb = new b((byte)0);
      e.BNm.eJv();
      localObject1 = e.BNm;
      paramb.targetWidth = e.getWidth();
      localObject1 = e.BNm;
      paramb.targetHeight = e.getHeight();
      localObject1 = e.BNm;
      paramb.frameRate = e.getFrameRate();
      float f2 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVN, 2.0F);
      float f1 = f2;
      if (f2 <= 1.0F) {
        f1 = 1.0F;
      }
      paramb.audioBitrate = paramRecordConfigProvider.audioBitrate;
      paramb.audioSampleRate = paramRecordConfigProvider.audioSampleRate;
      paramb.audioChannelCount = paramRecordConfigProvider.audioChannelCount;
      paramb.videoBitrate = ((int)(f1 * paramRecordConfigProvider.videoBitrate));
      paramb.ihS = 0;
      paramb.BNt = true;
      paramb.BNu = true;
      AppMethodBeat.o(163420);
      return paramb;
    }
    if (paramRecordConfigProvider.BOm == null)
    {
      localObject1 = com.tencent.mm.modelcontrol.e.baZ();
      p.g(localObject1, "SubCoreVideoControl.getCore()");
      paramRecordConfigProvider.BOm = ((com.tencent.mm.modelcontrol.e)localObject1).bbc();
    }
    localObject1 = paramRecordConfigProvider.BOm;
    Object localObject2;
    if ((localObject1 == null) || (((VideoTransPara)localObject1).iTg != 1))
    {
      localObject1 = paramRecordConfigProvider.BOm;
      if ((localObject1 == null) || (((VideoTransPara)localObject1).iTg != 2)) {}
    }
    else
    {
      localObject2 = paramRecordConfigProvider.BOm;
      if (localObject2 != null)
      {
        localObject1 = paramRecordConfigProvider.BOm;
        if (localObject1 == null) {
          break label481;
        }
        localObject1 = Integer.valueOf(((VideoTransPara)localObject1).iTp);
        ((VideoTransPara)localObject2).videoBitrate = ((Integer)localObject1).intValue();
      }
      localObject2 = new StringBuilder("match aba switch, target videoBitrate:");
      localObject1 = paramRecordConfigProvider.BOm;
      if (localObject1 == null) {
        break label487;
      }
    }
    label481:
    label487:
    for (localObject1 = Integer.valueOf(((VideoTransPara)localObject1).videoBitrate);; localObject1 = null)
    {
      Log.i("MicroMsg.RemuxMediaEditConfig", localObject1);
      if ((this.BNn.isEmpty()) && (this.wgG == null) && (!this.BNc)) {
        break label493;
      }
      localObject1 = new b((byte)0);
      ((b)localObject1).BNt = true;
      ((b)localObject1).BNu = true;
      Log.i("MicroMsg.RemuxMediaEditConfig", "remux by add editItems " + this.BNn);
      paramRecordConfigProvider = a(paramb.iqd, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
      localObject1 = null;
      break;
    }
    label493:
    if ((this.BNp - 80 >= 0) || (this.BNq + 80 <= paramb.iqg))
    {
      Log.i("MicroMsg.RemuxMediaEditConfig", "remux by time reMuxEndTimeMs:" + this.BNq + "  reMuxStartTimeMs:" + this.BNp);
      localObject1 = new b((byte)0);
      ((b)localObject1).BNt = true;
      ((b)localObject1).BNu = true;
      paramRecordConfigProvider = a(paramb.iqd, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    boolean bool = r.isH265Video(paramb.iqd);
    Log.i("MicroMsg.RemuxMediaEditConfig", "generateTargetConfig, isH265File:".concat(String.valueOf(bool)));
    if (bool)
    {
      Log.i("MicroMsg.RemuxMediaEditConfig", "force remux h265 file");
      localObject1 = new b((byte)0);
      ((b)localObject1).BNt = true;
      paramRecordConfigProvider = a(paramb.iqd, paramRecordConfigProvider, (b)localObject1);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    if ((paramRecordConfigProvider.remuxType == 2) && (this.BNn.isEmpty()))
    {
      paramRecordConfigProvider = new b((byte)0);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    paramRecordConfigProvider = a(paramb.iqd, paramRecordConfigProvider, new b((byte)0));
    AppMethodBeat.o(163420);
    return paramRecordConfigProvider;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75375);
    String str = "RemuxMediaEditConfig(muteOrigin=" + this.BNc + ", audioCacheInfo=" + this.wgG + ", editItems=" + this.BNn + ", drawingRect=" + Arrays.toString(this.BKV) + ", reMuxStartTimeMs=" + this.BNp + ", reMuxEndTimeMs=" + this.BNq + ')';
    AppMethodBeat.o(75375);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "needRemux", "", "change", "minQP", "maxQP", "qpSwitch", "(IIIIIIIIZZIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getChange", "()Z", "setChange", "(Z)V", "getFrameRate", "setFrameRate", "getMaxQP", "setMaxQP", "getMinQP", "setMinQP", "getNeedRemux", "setNeedRemux", "getQpSwitch", "setQpSwitch", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "buildMediaCodecConfig", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class b
  {
    public boolean BNt = false;
    public boolean BNu = false;
    public int audioBitrate = 0;
    public int audioChannelCount = 1;
    public int audioSampleRate = 0;
    public int frameRate = 0;
    public int iTh = 0;
    public int idF = 0;
    public int idG = 0;
    public int ihS = 0;
    public int targetHeight = 0;
    public int targetWidth = 0;
    public int videoBitrate = 0;
    
    public final b eJw()
    {
      AppMethodBeat.i(163419);
      if (this.targetWidth % 16 != 0) {
        this.targetWidth = com.tencent.mm.plugin.mmsight.d.QH(this.targetWidth);
      }
      if (this.targetHeight % 16 != 0) {
        this.targetHeight = com.tencent.mm.plugin.mmsight.d.QH(this.targetHeight);
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
          if ((this.targetWidth != paramObject.targetWidth) || (this.targetHeight != paramObject.targetHeight) || (this.videoBitrate != paramObject.videoBitrate) || (this.audioBitrate != paramObject.audioBitrate) || (this.frameRate != paramObject.frameRate) || (this.ihS != paramObject.ihS) || (this.audioSampleRate != paramObject.audioSampleRate) || (this.audioChannelCount != paramObject.audioChannelCount) || (this.BNt != paramObject.BNt) || (this.BNu != paramObject.BNu) || (this.idF != paramObject.idF) || (this.idG != paramObject.idG) || (this.iTh != paramObject.iTh)) {}
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
      String str = "EncodeConfig(targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.ihS + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", needRemux=" + this.BNt + ", change=" + this.BNu + ", qpmin=" + this.idF + ", qpmax=" + this.idG + ')';
      AppMethodBeat.o(75373);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.f
 * JD-Core Version:    0.7.0.1
 */