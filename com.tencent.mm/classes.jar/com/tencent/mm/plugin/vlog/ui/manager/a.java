package com.tencent.mm.plugin.vlog.ui.manager;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.z;
import java.util.Iterator;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "", "context", "Landroid/content/Context;", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "muteOrigin", "", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "callback", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "onMuxEnd", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "remuxer", "Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "vLogGenerateModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "vLogMusicManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "getThumbBitmap", "previewWidth", "previewHeight", "getVideoDurationMs", "handleBgRemux", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "release", "setVideoCropInfo", "rect", "Landroid/graphics/Rect;", "beforeCropSize", "Landroid/graphics/Point;", "startBackgroundGenerate", "success", "startGenerate", "Companion", "VLogOutputInfo", "plugin-vlog_release"})
public final class a
{
  public static final a CdH;
  public b CdC;
  public com.tencent.mm.plugin.vlog.remux.d CdD;
  private final y CdE;
  public final r<String, String, Boolean, Integer, z> CdF;
  public final aa CdG;
  private final Context context;
  public final RecordConfigProvider sYT;
  public d.g.a.q<? super Boolean, ? super Integer, ? super b, z> tUf;
  
  static
  {
    AppMethodBeat.i(111149);
    CdH = new a((byte)0);
    AppMethodBeat.o(111149);
  }
  
  public a(Context paramContext, aa paramaa, RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(111148);
    this.context = paramContext;
    this.CdG = paramaa;
    this.sYT = paramRecordConfigProvider;
    this.CdC = new b();
    this.CdE = new y();
    this.CdF = ((r)new c(this));
    int k = com.tencent.mm.plugin.mmsight.d.KG(this.sYT.xOg.width);
    paramContext = al.ck(ak.getContext());
    int i = paramContext.y;
    int j = paramContext.x;
    if (this.sYT.scene == 11)
    {
      j = com.tencent.mm.plugin.mmsight.d.KG(this.sYT.xOg.height);
      ae.i("MicroMsg.VLogGenerateManager", "targetWidth:" + k + " targetHeight:" + j + ", videoParam:" + this.sYT.xOg);
      paramContext = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      com.tencent.mm.plugin.recordvideo.e.b.e(this.sYT);
      ae.i("MicroMsg.VLogGenerateManager", "output path:" + this.sYT.xOt);
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
      ae.i("MicroMsg.VLogGenerateManager", "audioMixType:" + i + ", muteOrigin:" + paramBoolean + ", audioInfo:" + paramAudioCacheInfo);
      paramContext = this.CdE;
      paramContext.BYg = getVideoDurationMs();
      paramContext.BYh = i;
      paramaa = this.sYT.xOt;
      p.g(paramaa, "configProvider.outputVideoPath");
      paramContext.aEK(paramaa);
      paramContext.targetWidth = k;
      paramContext.targetHeight = j;
      paramContext.videoBitrate = this.sYT.xOg.videoBitrate;
      paramContext.audioBitrate = this.sYT.xOg.audioBitrate;
      paramContext.frameRate = this.sYT.xOg.fps;
      paramContext.audioSampleRate = this.sYT.xOg.audioSampleRate;
      paramContext.audioChannelCount = this.sYT.xOg.audioChannelCount;
      ae.i("MicroMsg.VLogGenerateManager", "vLogGenerateModel is :" + this.CdE);
      this.CdD = new com.tencent.mm.plugin.vlog.remux.d(this.CdG, this.CdE);
      AppMethodBeat.o(111148);
      return;
      j = com.tencent.mm.plugin.mmsight.d.KG(i * k / j);
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
    Iterator localIterator = ((Iterable)this.CdG.BYl).iterator();
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.vlog.model.l locall = (com.tencent.mm.plugin.vlog.model.l)localIterator.next();
      if (locall.endTime <= l) {
        break label92;
      }
      l = locall.endTime;
    }
    label92:
    for (;;)
    {
      break;
      ae.i("MicroMsg.VLogGenerateManager", "parse config duration : ".concat(String.valueOf(l)));
      int i = (int)l;
      AppMethodBeat.o(111147);
      return i;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$Companion;", "", "()V", "ERROR_DEFAULT", "", "ERROR_MUSIC_DOWNLOAD_ERROR", "ERROR_MUSIC_MEDIA_EXTRACTOR_ERROR", "ERROR_OK", "ERROR_VIDEO_BG_REMUX", "ERROR_VIDEO_ENCODER_ERROR", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getVideoPath", "setVideoPath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
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
          if ((!p.i(this.videoPath, paramObject.videoPath)) || (!p.i(this.thumbPath, paramObject.thumbPath))) {}
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements r<String, String, Boolean, Integer, z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "thumbPath", "b", "", "i", "", "invoke"})
  public static final class d
    extends d.g.b.q
    implements r<String, String, Boolean, Integer, z>
  {
    public d(a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  public static final class e
    extends d.g.b.q
    implements m<Boolean, String, z>
  {
    public e(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.a
 * JD-Core Version:    0.7.0.1
 */