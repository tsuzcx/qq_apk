package com.tencent.mm.plugin.vlog.ui.manager;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ai;
import d.g.a.m;
import d.g.a.q;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "", "context", "Landroid/content/Context;", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "muteOrigin", "", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "callback", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "onMuxEnd", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "remuxer", "Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "vLogGenerateModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "vLogMusicManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "getThumbBitmap", "previewWidth", "previewHeight", "getVideoDurationMs", "handleBgRemux", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "release", "setVideoCropInfo", "rect", "Landroid/graphics/Rect;", "beforeCropSize", "Landroid/graphics/Point;", "startBackgroundGenerate", "success", "startGenerate", "Companion", "VLogOutputInfo", "plugin-vlog_release"})
public final class b
{
  public static final a zct;
  private final Context context;
  public q<? super Boolean, ? super Integer, ? super b, y> rDO;
  public final RecordConfigProvider vcC;
  public c zco;
  public com.tencent.mm.plugin.vlog.remux.g zcp;
  private final com.tencent.mm.plugin.vlog.model.g zcq;
  public final r<String, String, Boolean, Integer, y> zcr;
  public final h zcs;
  
  static
  {
    AppMethodBeat.i(111149);
    zct = new a((byte)0);
    AppMethodBeat.o(111149);
  }
  
  public b(Context paramContext, h paramh, RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(111148);
    this.context = paramContext;
    this.zcs = paramh;
    this.vcC = paramRecordConfigProvider;
    this.zco = new c();
    this.zcq = new com.tencent.mm.plugin.vlog.model.g();
    this.zcr = ((r)new c(this));
    int k = com.tencent.mm.plugin.mmsight.d.GN(this.vcC.vhH.width);
    paramContext = ai.cf(aj.getContext());
    int i = paramContext.y;
    int j = paramContext.x;
    if (this.vcC.scene == 11)
    {
      j = com.tencent.mm.plugin.mmsight.d.GN(this.vcC.vhH.height);
      ad.i("MicroMsg.VLogGenerateManager", "targetWidth:" + k + " targetHeight:" + j + ", videoParam:" + this.vcC.vhH);
      paramContext = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      com.tencent.mm.plugin.recordvideo.e.b.d(this.vcC);
      ad.i("MicroMsg.VLogGenerateManager", "output path:" + this.vcC.vhU);
      if (!paramBoolean) {
        break label467;
      }
      if (paramAudioCacheInfo != null) {
        break label461;
      }
      i = 0;
    }
    for (;;)
    {
      ad.i("MicroMsg.VLogGenerateManager", "audioMixType:" + i + ", muteOrigin:" + paramBoolean + ", audioInfo:" + paramAudioCacheInfo);
      paramContext = this.zcq;
      paramContext.yZp = getVideoDurationMs();
      paramContext.yZq = i;
      paramh = this.vcC.vhU;
      k.g(paramh, "configProvider.outputVideoPath");
      paramContext.asV(paramh);
      paramContext.gnh = k;
      paramContext.gni = j;
      paramContext.videoBitrate = this.vcC.vhH.videoBitrate;
      paramContext.audioBitrate = this.vcC.vhH.audioBitrate;
      paramContext.frameRate = this.vcC.vhH.fps;
      paramContext.audioSampleRate = this.vcC.vhH.audioSampleRate;
      paramContext.gnH = this.vcC.vhH.gnH;
      ad.i("MicroMsg.VLogGenerateManager", "vLogGenerateModel is :" + this.zcq);
      this.zcp = new com.tencent.mm.plugin.vlog.remux.g(this.zcs, this.zcq);
      AppMethodBeat.o(111148);
      return;
      j = com.tencent.mm.plugin.mmsight.d.GN(i * k / j);
      break;
      label461:
      i = 2;
      continue;
      label467:
      if (paramAudioCacheInfo == null) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  private final int getVideoDurationMs()
  {
    AppMethodBeat.i(111147);
    long l = 0L;
    Iterator localIterator = ((Iterable)this.zcs.yZs).iterator();
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.vlog.model.d locald = (com.tencent.mm.plugin.vlog.model.d)localIterator.next();
      if (locald.endTime <= l) {
        break label92;
      }
      l = locald.endTime;
    }
    label92:
    for (;;)
    {
      break;
      ad.i("MicroMsg.VLogGenerateManager", "parse config duration : ".concat(String.valueOf(l)));
      int i = (int)l;
      AppMethodBeat.o(111147);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$Companion;", "", "()V", "ERROR_DEFAULT", "", "ERROR_MUSIC_DOWNLOAD_ERROR", "ERROR_MUSIC_MEDIA_EXTRACTOR_ERROR", "ERROR_OK", "ERROR_VIDEO_BG_REMUX", "ERROR_VIDEO_ENCODER_ERROR", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getVideoPath", "setVideoPath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
  public static final class b
  {
    public String thumbPath;
    public String videoPath;
    
    public b(String paramString1, String paramString2)
    {
      AppMethodBeat.i(111139);
      this.videoPath = paramString1;
      this.thumbPath = paramString2;
      AppMethodBeat.o(111139);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111142);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!k.g(this.videoPath, paramObject.videoPath)) || (!k.g(this.thumbPath, paramObject.thumbPath))) {}
        }
      }
      else
      {
        AppMethodBeat.o(111142);
        return true;
      }
      AppMethodBeat.o(111142);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(111141);
      String str = this.videoPath;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.thumbPath;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(111141);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111140);
      String str = "VLogOutputInfo(videoPath=" + this.videoPath + ", thumbPath=" + this.thumbPath + ")";
      AppMethodBeat.o(111140);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements r<String, String, Boolean, Integer, y>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "", "thumbPath", "b", "", "i", "", "invoke"})
  public static final class d
    extends d.g.b.l
    implements r<String, String, Boolean, Integer, y>
  {
    public d(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  public static final class e
    extends d.g.b.l
    implements m<Boolean, String, y>
  {
    public e(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.b
 * JD-Core Version:    0.7.0.1
 */