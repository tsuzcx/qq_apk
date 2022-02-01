package com.tencent.mm.plugin.recordvideo.c;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "", "muteOrigin", "", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "drawingRect", "", "reMuxStartTimeMs", "", "reMuxEndTimeMs", "fakeImagesList", "", "blurBgPath", "validRect", "(ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;Ljava/util/ArrayList;Ljava/util/ArrayList;[FIILjava/util/ArrayList;Ljava/lang/String;[F)V", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "getFakeImagesList", "setFakeImagesList", "getMuteOrigin", "()Z", "setMuteOrigin", "(Z)V", "getReMuxEndTimeMs", "()I", "setReMuxEndTimeMs", "(I)V", "getReMuxStartTimeMs", "setReMuxStartTimeMs", "getValidRect", "setValidRect", "generateTargetConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isLandVideoBySizeAndRotation", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "isLandVideoOnlyBySize", "setSize", "", "config", "toString", "videoConfigForFile", "videoPath", "videoConfigForPhotoToVideo", "params", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "Companion", "EncodeConfig", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a NGT;
  public AudioCacheInfo Gss;
  public float[] NEA;
  public float[] NEB;
  public String NEF;
  public boolean NGG;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> NGU;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> NGV;
  public int NGW;
  public int NGX;
  public ArrayList<String> NGY;
  
  static
  {
    AppMethodBeat.i(75378);
    NGT = new g.a((byte)0);
    AppMethodBeat.o(75378);
  }
  
  public g(boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramArrayList, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramArrayList1, float[] paramArrayOfFloat1, int paramInt1, int paramInt2, ArrayList<String> paramArrayList2, String paramString, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(279699);
    this.NGG = paramBoolean;
    this.Gss = paramAudioCacheInfo;
    this.NGU = paramArrayList;
    this.NGV = paramArrayList1;
    this.NEA = paramArrayOfFloat1;
    this.NGW = paramInt1;
    this.NGX = paramInt2;
    this.NGY = paramArrayList2;
    this.NEF = paramString;
    this.NEB = paramArrayOfFloat2;
    AppMethodBeat.o(279699);
  }
  
  private static b a(String paramString, RecordConfigProvider paramRecordConfigProvider, b paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(75374);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(75374);
      return paramb;
    }
    com.tencent.mm.plugin.recordvideo.util.g localg = com.tencent.mm.plugin.recordvideo.util.g.Obu;
    s.checkNotNull(paramString);
    paramString = com.tencent.mm.plugin.recordvideo.util.g.aTF(paramString);
    int i;
    if (paramString != null)
    {
      paramb.audioBitrate = paramRecordConfigProvider.oXZ.audioBitrate;
      paramb.audioSampleRate = paramRecordConfigProvider.oXZ.audioSampleRate;
      paramb.videoBitrate = paramString.videoBitrate;
      paramb.nCg = paramString.hYK;
      paramb.audioChannelCount = paramRecordConfigProvider.oXZ.audioChannelCount;
      Log.d("MicroMsg.RemuxMediaEditConfig", s.X("video info : ", paramString));
      if (paramString.videoBitrate - 200000 > paramRecordConfigProvider.oXZ.videoBitrate)
      {
        paramb.videoBitrate = paramRecordConfigProvider.oXZ.videoBitrate;
        paramb.NGZ = true;
        Log.i("MicroMsg.RemuxMediaEditConfig", "remux by high videoBitrate " + paramString.videoBitrate + "  " + paramRecordConfigProvider.oXZ.videoBitrate);
      }
      a(paramRecordConfigProvider, paramb, paramString);
      int j = paramString.fps;
      i = j;
      if (paramString.fps > paramRecordConfigProvider.oXZ.fps * 1.5F)
      {
        i = j;
        if (paramRecordConfigProvider.oXZ.fps >= 0) {
          i = paramRecordConfigProvider.oXZ.fps;
        }
      }
      paramb.frameRate = i;
    }
    paramb.videoBitrate = paramRecordConfigProvider.oXZ.videoBitrate;
    if (paramRecordConfigProvider == null)
    {
      paramString = null;
      if ((paramString == null) || (paramString.oCc != 2)) {
        break label374;
      }
      i = 1;
      label265:
      if (i != 0)
      {
        if (paramString != null) {
          break label379;
        }
        paramRecordConfigProvider = null;
        label275:
        paramb.nxU = paramRecordConfigProvider.intValue();
        if (paramString != null) {
          break label390;
        }
        paramRecordConfigProvider = null;
        label289:
        paramb.nxV = paramRecordConfigProvider.intValue();
        if (paramString != null) {
          break label401;
        }
      }
    }
    label390:
    label401:
    for (paramString = localObject;; paramString = Integer.valueOf(paramString.oCc))
    {
      paramb.oCc = paramString.intValue();
      Log.i("MicroMsg.RemuxMediaEditConfig", "ABA: Min/Max QP Methods:videoBitrate [%d]  minQP [%d]  maxQP [%d]", new Object[] { Integer.valueOf(paramb.videoBitrate), Integer.valueOf(paramb.nxU), Integer.valueOf(paramb.nxV) });
      paramString = paramb.gHu();
      AppMethodBeat.o(75374);
      return paramString;
      paramString = paramRecordConfigProvider.oXZ;
      break;
      label374:
      i = 0;
      break label265;
      label379:
      paramRecordConfigProvider = Integer.valueOf(paramString.nxU);
      break label275;
      paramRecordConfigProvider = Integer.valueOf(paramString.nxV);
      break label289;
    }
  }
  
  private static void a(RecordConfigProvider paramRecordConfigProvider, b paramb, com.tencent.mm.plugin.recordvideo.util.g.a parama)
  {
    AppMethodBeat.i(163421);
    int i = paramRecordConfigProvider.oXZ.width;
    int j = paramRecordConfigProvider.oXZ.height;
    boolean bool = a(parama);
    if (bool) {}
    for (;;)
    {
      int m;
      if (paramRecordConfigProvider.NHT == 1)
      {
        Point localPoint = aw.bf(MMApplicationContext.getContext());
        k = localPoint.y;
        m = localPoint.x;
        paramRecordConfigProvider.oXZ.height = (k * paramRecordConfigProvider.oXZ.width / m);
        k = parama.width;
        m = parama.height;
        if ((k - 32 > j) || (m - 32 > i))
        {
          paramb.nxO = j;
          paramb.nxP = i;
          paramb.NGZ = true;
          Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:FIT_SCREEN by high size " + parama.width + "  " + paramb.nxO);
        }
      }
      for (;;)
      {
        if ((paramRecordConfigProvider.NIl) && (b(parama)))
        {
          paramb.nxO = Math.min(paramRecordConfigProvider.oXZ.width, paramRecordConfigProvider.oXZ.height);
          paramb.nxP = Math.max(paramRecordConfigProvider.oXZ.width, paramRecordConfigProvider.oXZ.height);
        }
        AppMethodBeat.o(163421);
        return;
        paramb.nxP = parama.height;
        paramb.nxO = parama.width;
        continue;
        if (paramRecordConfigProvider.NHT == 2)
        {
          k = parama.width;
          m = parama.height;
          if ((k != j) || (m != i))
          {
            paramb.NGZ = true;
            Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:FORCE_WIDTH_AND_HEIGHT by high size ");
          }
          paramb.nxO = j;
          paramb.nxP = i;
        }
        else if (paramRecordConfigProvider.NHT == 4)
        {
          k = parama.width - 32;
          m = parama.height - 32;
          paramb.nxP = parama.height;
          paramb.nxO = parama.width;
          if (bool)
          {
            if (m > i)
            {
              paramb.nxP = i;
              paramb.nxO = (i * k / m);
              paramb.NGZ = true;
              Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
            }
          }
          else if (k > j)
          {
            paramb.nxO = j;
            paramb.nxP = (j * m / k);
            paramb.NGZ = true;
            Log.i("MicroMsg.RemuxMediaEditConfig", "remux by:SCALE_SIZE by high size ");
          }
        }
        else if (paramRecordConfigProvider.NHT == 3)
        {
          paramb.nxO = parama.width;
          paramb.nxP = parama.height;
        }
      }
      int k = i;
      i = j;
      j = k;
    }
  }
  
  private static boolean a(com.tencent.mm.plugin.recordvideo.util.g.a parama)
  {
    AppMethodBeat.i(279718);
    Point localPoint = aw.bf(MMApplicationContext.getContext());
    Log.i("MicroMsg.RemuxMediaEditConfig", s.X("screenSize:", localPoint));
    if (localPoint.x < localPoint.y)
    {
      if (parama.width > parama.height)
      {
        AppMethodBeat.o(279718);
        return true;
      }
      AppMethodBeat.o(279718);
      return false;
    }
    if (parama.height > parama.width)
    {
      AppMethodBeat.o(279718);
      return true;
    }
    AppMethodBeat.o(279718);
    return false;
  }
  
  private static boolean b(com.tencent.mm.plugin.recordvideo.util.g.a parama)
  {
    if ((parama.hYK == 90) || (parama.hYK == 270)) {
      if (parama.height <= parama.width) {}
    }
    while (parama.width > parama.height)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final b a(RecordConfigProvider paramRecordConfigProvider, b paramb)
  {
    AppMethodBeat.i(163420);
    if ((paramRecordConfigProvider == null) || (paramb == null))
    {
      Log.e("MicroMsg.RemuxMediaEditConfig", "configProvider  is null");
      paramRecordConfigProvider = new b((byte)0);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    Object localObject = (Collection)paramb.nKc;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.oXZ;
      s.s(paramRecordConfigProvider, "configProvider.videoParam");
      paramb = new b((byte)0);
      f.NGM.gHt();
      localObject = f.NGM;
      paramb.nxO = f.getWidth();
      localObject = f.NGM;
      paramb.nxP = f.getHeight();
      localObject = f.NGM;
      paramb.frameRate = f.getFrameRate();
      float f2 = ((c)h.ax(c.class)).a(c.a.yQH, 2.0F);
      float f1 = f2;
      if (f2 <= 1.0F) {
        f1 = 1.0F;
      }
      paramb.audioBitrate = paramRecordConfigProvider.audioBitrate;
      paramb.audioSampleRate = paramRecordConfigProvider.audioSampleRate;
      paramb.audioChannelCount = paramRecordConfigProvider.audioChannelCount;
      paramb.videoBitrate = ((int)(f1 * paramRecordConfigProvider.videoBitrate));
      paramb.nCg = 0;
      paramb.NGZ = true;
      paramb.NHa = true;
      AppMethodBeat.o(163420);
      return paramb;
    }
    if (paramRecordConfigProvider.oXZ == null) {
      paramRecordConfigProvider.oXZ = e.bIg().bIk();
    }
    localObject = paramRecordConfigProvider.oXZ;
    if ((localObject != null) && (((VideoTransPara)localObject).oCb == 1))
    {
      i = 1;
      if (i == 0)
      {
        localObject = paramRecordConfigProvider.oXZ;
        if ((localObject == null) || (((VideoTransPara)localObject).oCb != 2)) {
          break label453;
        }
        i = 1;
        label300:
        if (i == 0) {}
      }
      else
      {
        VideoTransPara localVideoTransPara = paramRecordConfigProvider.oXZ;
        if (localVideoTransPara != null)
        {
          localObject = paramRecordConfigProvider.oXZ;
          if (localObject != null) {
            break label459;
          }
          localObject = null;
          label330:
          localVideoTransPara.videoBitrate = ((Integer)localObject).intValue();
        }
        localObject = paramRecordConfigProvider.oXZ;
        if (localObject != null) {
          break label472;
        }
      }
    }
    label453:
    label459:
    label472:
    for (localObject = null;; localObject = Integer.valueOf(((VideoTransPara)localObject).videoBitrate))
    {
      Log.i("MicroMsg.RemuxMediaEditConfig", s.X("match aba switch, target videoBitrate:", localObject));
      if ((this.NGU.isEmpty()) && (this.Gss == null) && (!this.NGG)) {
        break label485;
      }
      localObject = new b((byte)0);
      ((b)localObject).NGZ = true;
      ((b)localObject).NHa = true;
      Log.i("MicroMsg.RemuxMediaEditConfig", s.X("remux by add editItems ", this.NGU));
      paramRecordConfigProvider = a(paramb.nJU, paramRecordConfigProvider, (b)localObject);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
      i = 0;
      break;
      i = 0;
      break label300;
      localObject = Integer.valueOf(((VideoTransPara)localObject).oCk);
      break label330;
    }
    label485:
    if ((this.NGW - 80 >= 0) || (this.NGX + 80 <= paramb.endTime))
    {
      Log.i("MicroMsg.RemuxMediaEditConfig", "remux by time reMuxEndTimeMs:" + this.NGX + "  reMuxStartTimeMs:" + this.NGW);
      localObject = new b((byte)0);
      ((b)localObject).NGZ = true;
      ((b)localObject).NHa = true;
      paramRecordConfigProvider = a(paramb.nJU, paramRecordConfigProvider, (b)localObject);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    boolean bool = y.isH265Video(paramb.nJU);
    Log.i("MicroMsg.RemuxMediaEditConfig", s.X("generateTargetConfig, isH265File:", Boolean.valueOf(bool)));
    if (bool)
    {
      Log.i("MicroMsg.RemuxMediaEditConfig", "force remux h265 file");
      localObject = new b((byte)0);
      ((b)localObject).NGZ = true;
      paramRecordConfigProvider = a(paramb.nJU, paramRecordConfigProvider, (b)localObject);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    if ((paramRecordConfigProvider.remuxType == 2) && (this.NGU.isEmpty()))
    {
      paramRecordConfigProvider = new b((byte)0);
      AppMethodBeat.o(163420);
      return paramRecordConfigProvider;
    }
    paramRecordConfigProvider = a(paramb.nJU, paramRecordConfigProvider, new b((byte)0));
    AppMethodBeat.o(163420);
    return paramRecordConfigProvider;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75375);
    String str = "RemuxMediaEditConfig(muteOrigin=" + this.NGG + ", audioCacheInfo=" + this.Gss + ", editItems=" + this.NGU + ", drawingRect=" + Arrays.toString(this.NEA) + ", reMuxStartTimeMs=" + this.NGW + ", reMuxEndTimeMs=" + this.NGX + ')';
    AppMethodBeat.o(75375);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "", "targetWidth", "", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "needRemux", "", "change", "minQP", "maxQP", "qpSwitch", "(IIIIIIIIZZIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getChange", "()Z", "setChange", "(Z)V", "getFrameRate", "setFrameRate", "getMaxQP", "setMaxQP", "getMinQP", "setMinQP", "getNeedRemux", "setNeedRemux", "getQpSwitch", "setQpSwitch", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "buildMediaCodecConfig", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public boolean NGZ = false;
    public boolean NHa = false;
    public int audioBitrate = 0;
    public int audioChannelCount = 1;
    public int audioSampleRate = 0;
    public int frameRate = 0;
    public int nCg = 0;
    public int nxO = 0;
    public int nxP = 0;
    public int nxU = 0;
    public int nxV = 0;
    public int oCc = 0;
    public int videoBitrate = 0;
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.nxO != paramObject.nxO) {
          return false;
        }
        if (this.nxP != paramObject.nxP) {
          return false;
        }
        if (this.videoBitrate != paramObject.videoBitrate) {
          return false;
        }
        if (this.audioBitrate != paramObject.audioBitrate) {
          return false;
        }
        if (this.frameRate != paramObject.frameRate) {
          return false;
        }
        if (this.nCg != paramObject.nCg) {
          return false;
        }
        if (this.audioSampleRate != paramObject.audioSampleRate) {
          return false;
        }
        if (this.audioChannelCount != paramObject.audioChannelCount) {
          return false;
        }
        if (this.NGZ != paramObject.NGZ) {
          return false;
        }
        if (this.NHa != paramObject.NHa) {
          return false;
        }
        if (this.nxU != paramObject.nxU) {
          return false;
        }
        if (this.nxV != paramObject.nxV) {
          return false;
        }
      } while (this.oCc == paramObject.oCc);
      return false;
    }
    
    public final b gHu()
    {
      AppMethodBeat.i(163419);
      if (this.nxO % 16 != 0) {
        this.nxO = d.aaX(this.nxO);
      }
      if (this.nxP % 16 != 0) {
        this.nxP = d.aaX(this.nxP);
      }
      AppMethodBeat.o(163419);
      return this;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75373);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EncodeConfig(targetWidth=").append(this.nxO).append(", targetHeight=").append(this.nxP).append(", videoBitrate=").append(this.videoBitrate).append(", audioBitrate=").append(this.audioBitrate).append(", frameRate=").append(this.frameRate).append(", videoRotate=").append(this.nCg).append(", audioSampleRate=").append(this.audioSampleRate).append(", audioChannelCount=").append(this.audioChannelCount).append(", needRemux=").append(this.NGZ).append(", change=").append(this.NHa).append(", qpmin=").append(this.nxU).append(", qpmax=");
      ((StringBuilder)localObject).append(this.nxV).append(')');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(75373);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.g
 * JD-Core Version:    0.7.0.1
 */