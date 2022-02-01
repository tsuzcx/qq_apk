package com.tencent.mm.plugin.vlog.ui.manager;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;
import d.g.a.q;
import d.g.a.r;
import d.g.b.k;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "", "context", "Landroid/content/Context;", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "muteOrigin", "", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "callback", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "onMuxEnd", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "remuxer", "Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "vLogGenerateModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "vLogMusicManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "getThumbBitmap", "previewWidth", "previewHeight", "getVideoDurationMs", "handleBgRemux", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "release", "setVideoCropInfo", "rect", "Landroid/graphics/Rect;", "beforeCropSize", "Landroid/graphics/Point;", "startBackgroundGenerate", "success", "startGenerate", "Companion", "VLogOutputInfo", "plugin-vlog_release"})
public final class a
{
  public static final a Asv;
  public b Asq;
  public com.tencent.mm.plugin.vlog.remux.d Asr;
  private final w Ass;
  public final r<String, String, Boolean, Integer, d.y> Ast;
  public final com.tencent.mm.plugin.vlog.model.y Asu;
  private final Context context;
  public final RecordConfigProvider rRi;
  public q<? super Boolean, ? super Integer, ? super b, d.y> sMG;
  
  static
  {
    AppMethodBeat.i(111149);
    Asv = new a((byte)0);
    AppMethodBeat.o(111149);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.vlog.model.y paramy, RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(111148);
    this.context = paramContext;
    this.Asu = paramy;
    this.rRi = paramRecordConfigProvider;
    this.Asq = new b();
    this.Ass = new w();
    this.Ast = ((r)new c(this));
    int k = com.tencent.mm.plugin.mmsight.d.IJ(this.rRi.wqt.width);
    paramContext = aj.cl(ai.getContext());
    int i = paramContext.y;
    int j = paramContext.x;
    if (this.rRi.scene == 11)
    {
      j = com.tencent.mm.plugin.mmsight.d.IJ(this.rRi.wqt.height);
      ac.i("MicroMsg.VLogGenerateManager", "targetWidth:" + k + " targetHeight:" + j + ", videoParam:" + this.rRi.wqt);
      paramContext = com.tencent.mm.plugin.recordvideo.e.b.wDE;
      com.tencent.mm.plugin.recordvideo.e.b.e(this.rRi);
      ac.i("MicroMsg.VLogGenerateManager", "output path:" + this.rRi.wqG);
      if (!paramBoolean) {
        break label466;
      }
      if (paramAudioCacheInfo != null) {
        break label460;
      }
      i = 0;
    }
    for (;;)
    {
      ac.i("MicroMsg.VLogGenerateManager", "audioMixType:" + i + ", muteOrigin:" + paramBoolean + ", audioInfo:" + paramAudioCacheInfo);
      paramContext = this.Ass;
      paramContext.AoQ = getVideoDurationMs();
      paramContext.AoR = i;
      paramy = this.rRi.wqG;
      k.g(paramy, "configProvider.outputVideoPath");
      paramContext.ayl(paramy);
      paramContext.gNU = k;
      paramContext.gNV = j;
      paramContext.videoBitrate = this.rRi.wqt.videoBitrate;
      paramContext.audioBitrate = this.rRi.wqt.audioBitrate;
      paramContext.frameRate = this.rRi.wqt.fps;
      paramContext.audioSampleRate = this.rRi.wqt.audioSampleRate;
      paramContext.gOt = this.rRi.wqt.gOt;
      ac.i("MicroMsg.VLogGenerateManager", "vLogGenerateModel is :" + this.Ass);
      this.Asr = new com.tencent.mm.plugin.vlog.remux.d(this.Asu, this.Ass);
      AppMethodBeat.o(111148);
      return;
      j = com.tencent.mm.plugin.mmsight.d.IJ(i * k / j);
      break;
      label460:
      i = 2;
      continue;
      label466:
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
    Iterator localIterator = ((Iterable)this.Asu.AoV).iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.endTime <= l) {
        break label92;
      }
      l = locali.endTime;
    }
    label92:
    for (;;)
    {
      break;
      ac.i("MicroMsg.VLogGenerateManager", "parse config duration : ".concat(String.valueOf(l)));
      int i = (int)l;
      AppMethodBeat.o(111147);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$Companion;", "", "()V", "ERROR_DEFAULT", "", "ERROR_MUSIC_DOWNLOAD_ERROR", "ERROR_MUSIC_MEDIA_EXTRACTOR_ERROR", "ERROR_OK", "ERROR_VIDEO_BG_REMUX", "ERROR_VIDEO_ENCODER_ERROR", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getVideoPath", "setVideoPath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements r<String, String, Boolean, Integer, d.y>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.a
 * JD-Core Version:    0.7.0.1
 */