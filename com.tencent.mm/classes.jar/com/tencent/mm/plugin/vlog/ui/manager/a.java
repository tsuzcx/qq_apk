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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.z;
import java.util.Iterator;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "", "context", "Landroid/content/Context;", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "muteOrigin", "", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "callback", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "onMuxEnd", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "remuxer", "Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "vLogGenerateModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "vLogMusicManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "getThumbBitmap", "previewWidth", "previewHeight", "getVideoDurationMs", "handleBgRemux", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "release", "setVideoCropInfo", "rect", "Landroid/graphics/Rect;", "beforeCropSize", "Landroid/graphics/Point;", "startBackgroundGenerate", "success", "startGenerate", "Companion", "VLogOutputInfo", "plugin-vlog_release"})
public final class a
{
  public static final a BMi;
  public b BMd;
  public com.tencent.mm.plugin.vlog.remux.d BMe;
  private final y BMf;
  public final r<String, String, Boolean, Integer, z> BMg;
  public final aa BMh;
  private final Context context;
  public final RecordConfigProvider sNI;
  public d.g.a.q<? super Boolean, ? super Integer, ? super b, z> tJo;
  
  static
  {
    AppMethodBeat.i(111149);
    BMi = new a((byte)0);
    AppMethodBeat.o(111149);
  }
  
  public a(Context paramContext, aa paramaa, RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(111148);
    this.context = paramContext;
    this.BMh = paramaa;
    this.sNI = paramRecordConfigProvider;
    this.BMd = new b();
    this.BMf = new y();
    this.BMg = ((r)new c(this));
    int k = com.tencent.mm.plugin.mmsight.d.Kg(this.sNI.xyj.width);
    paramContext = al.ci(aj.getContext());
    int i = paramContext.y;
    int j = paramContext.x;
    if (this.sNI.scene == 11)
    {
      j = com.tencent.mm.plugin.mmsight.d.Kg(this.sNI.xyj.height);
      ad.i("MicroMsg.VLogGenerateManager", "targetWidth:" + k + " targetHeight:" + j + ", videoParam:" + this.sNI.xyj);
      paramContext = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      com.tencent.mm.plugin.recordvideo.e.b.e(this.sNI);
      ad.i("MicroMsg.VLogGenerateManager", "output path:" + this.sNI.xyx);
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
      paramContext = this.BMf;
      paramContext.BGH = getVideoDurationMs();
      paramContext.BGI = i;
      paramaa = this.sNI.xyx;
      p.g(paramaa, "configProvider.outputVideoPath");
      paramContext.aDr(paramaa);
      paramContext.targetWidth = k;
      paramContext.targetHeight = j;
      paramContext.videoBitrate = this.sNI.xyj.videoBitrate;
      paramContext.audioBitrate = this.sNI.xyj.audioBitrate;
      paramContext.frameRate = this.sNI.xyj.fps;
      paramContext.audioSampleRate = this.sNI.xyj.audioSampleRate;
      paramContext.audioChannelCount = this.sNI.xyj.audioChannelCount;
      ad.i("MicroMsg.VLogGenerateManager", "vLogGenerateModel is :" + this.BMf);
      this.BMe = new com.tencent.mm.plugin.vlog.remux.d(this.BMh, this.BMf);
      AppMethodBeat.o(111148);
      return;
      j = com.tencent.mm.plugin.mmsight.d.Kg(i * k / j);
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
    Iterator localIterator = ((Iterable)this.BMh.BGM).iterator();
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
      ad.i("MicroMsg.VLogGenerateManager", "parse config duration : ".concat(String.valueOf(l)));
      int i = (int)l;
      AppMethodBeat.o(111147);
      return i;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$Companion;", "", "()V", "ERROR_DEFAULT", "", "ERROR_MUSIC_DOWNLOAD_ERROR", "ERROR_MUSIC_MEDIA_EXTRACTOR_ERROR", "ERROR_OK", "ERROR_VIDEO_BG_REMUX", "ERROR_VIDEO_ENCODER_ERROR", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getVideoPath", "setVideoPath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements r<String, String, Boolean, Integer, z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "", "thumbPath", "b", "", "i", "", "invoke"})
  public static final class d
    extends d.g.b.q
    implements r<String, String, Boolean, Integer, z>
  {
    public d(a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
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