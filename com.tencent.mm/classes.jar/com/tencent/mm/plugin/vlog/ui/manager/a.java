package com.tencent.mm.plugin.vlog.ui.manager;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.remux.e;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.fvr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "", "context", "Landroid/content/Context;", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "muteOrigin", "", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "callback", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "onMuxEnd", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "remuxer", "Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "vLogGenerateModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "vLogMusicManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "getThumbBitmap", "previewWidth", "previewHeight", "getVideoDurationMs", "handleBgRemux", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "release", "setVideoCropInfo", "rect", "Landroid/graphics/Rect;", "beforeCropSize", "Landroid/graphics/Point;", "startBackgroundGenerate", "success", "startGenerate", "Companion", "VLogOutputInfo", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Uhc;
  public q<? super Boolean, ? super Integer, ? super b, kotlin.ah> HJY;
  public final com.tencent.mm.plugin.vlog.model.ah Uhd;
  public b Uhe;
  public e Uhf;
  private final af Uhg;
  public final r<String, String, Boolean, Integer, kotlin.ah> Uhh;
  private final Context context;
  public final RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(111149);
    Uhc = new a((byte)0);
    AppMethodBeat.o(111149);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.vlog.model.ah paramah, RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(111148);
    this.context = paramContext;
    this.Uhd = paramah;
    this.oaV = paramRecordConfigProvider;
    this.Uhe = new b();
    this.Uhg = new af();
    this.Uhh = ((r)new c(this));
    int k = d.aaX(this.oaV.oXZ.width);
    paramContext = aw.bf(MMApplicationContext.getContext());
    int i = paramContext.y;
    int j = paramContext.x;
    if (this.oaV.scene == 11)
    {
      j = d.aaX(this.oaV.oXZ.height);
      Log.i("MicroMsg.VLogGenerateManager", "targetWidth:" + k + " targetHeight:" + j + ", videoParam:" + this.oaV.oXZ);
      paramContext = f.Obq;
      f.l(this.oaV);
      Log.i("MicroMsg.VLogGenerateManager", kotlin.g.b.s.X("output path:", this.oaV.NIe));
      if (!paramBoolean) {
        break label448;
      }
      if (paramAudioCacheInfo != null) {
        break label442;
      }
      i = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.VLogGenerateManager", "audioMixType:" + i + ", muteOrigin:" + paramBoolean + ", audioInfo:" + paramAudioCacheInfo);
      paramContext = this.Uhg;
      paramContext.UaS = getVideoDurationMs();
      paramContext.UaT = i;
      paramah = this.oaV.NIe;
      kotlin.g.b.s.s(paramah, "configProvider.outputVideoPath");
      paramContext.bff(paramah);
      paramContext.nxO = k;
      paramContext.nxP = j;
      paramContext.videoBitrate = this.oaV.oXZ.videoBitrate;
      paramContext.audioBitrate = this.oaV.oXZ.audioBitrate;
      paramContext.frameRate = this.oaV.oXZ.fps;
      paramContext.audioSampleRate = this.oaV.oXZ.audioSampleRate;
      paramContext.audioChannelCount = this.oaV.oXZ.audioChannelCount;
      Log.i("MicroMsg.VLogGenerateManager", kotlin.g.b.s.X("vLogGenerateModel is :", this.Uhg));
      this.Uhf = new e(this.Uhd, this.Uhg);
      AppMethodBeat.o(111148);
      return;
      j = d.aaX(i * k / j);
      break;
      label442:
      i = 2;
      continue;
      label448:
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
    Iterator localIterator = ((Iterable)this.Uhd.UaY).iterator();
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.vlog.model.s locals = (com.tencent.mm.plugin.vlog.model.s)localIterator.next();
      if (locals.endTime <= l) {
        break label92;
      }
      l = locals.endTime;
    }
    label92:
    for (;;)
    {
      break;
      Log.i("MicroMsg.VLogGenerateManager", kotlin.g.b.s.X("parse config duration : ", Long.valueOf(l)));
      int i = (int)l;
      AppMethodBeat.o(111147);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$Companion;", "", "()V", "ERROR_DEFAULT", "", "ERROR_MUSIC_DOWNLOAD_ERROR", "ERROR_MUSIC_MEDIA_EXTRACTOR_ERROR", "ERROR_OK", "ERROR_VIDEO_BG_REMUX", "ERROR_VIDEO_ENCODER_ERROR", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getVideoPath", "setVideoPath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      if (this == paramObject)
      {
        AppMethodBeat.o(111142);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(111142);
        return false;
      }
      paramObject = (b)paramObject;
      if (!kotlin.g.b.s.p(this.videoPath, paramObject.videoPath))
      {
        AppMethodBeat.o(111142);
        return false;
      }
      if (!kotlin.g.b.s.p(this.thumbPath, paramObject.thumbPath))
      {
        AppMethodBeat.o(111142);
        return false;
      }
      AppMethodBeat.o(111142);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111141);
      int i = this.videoPath.hashCode();
      int j = this.thumbPath.hashCode();
      AppMethodBeat.o(111141);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111140);
      String str = "VLogOutputInfo(videoPath=" + this.videoPath + ", thumbPath=" + this.thumbPath + ')';
      AppMethodBeat.o(111140);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements r<String, String, Boolean, Integer, kotlin.ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "thumbPath", "b", "", "i", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements r<String, String, Boolean, Integer, kotlin.ah>
  {
    public d(a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "filePath", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements m<Boolean, String, kotlin.ah>
  {
    public e(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.a
 * JD-Core Version:    0.7.0.1
 */