package com.tencent.mm.plugin.vlog.ui.manager;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.plugin.vlog.remux.e;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.ezn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "", "context", "Landroid/content/Context;", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "muteOrigin", "", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;ZLcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "callback", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "onMuxEnd", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "remuxer", "Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "vLogGenerateModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "vLogMusicManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogMusicManager;", "getThumbBitmap", "previewWidth", "previewHeight", "getVideoDurationMs", "handleBgRemux", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "mixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "release", "setVideoCropInfo", "rect", "Landroid/graphics/Rect;", "beforeCropSize", "Landroid/graphics/Point;", "startBackgroundGenerate", "success", "startGenerate", "Companion", "VLogOutputInfo", "plugin-vlog_release"})
public final class a
{
  public static final a NtO;
  public final RecordConfigProvider ALV;
  public b NtJ;
  public e NtK;
  private final af NtL;
  public final r<String, String, Boolean, Integer, x> NtM;
  public final ah NtN;
  private final Context context;
  public kotlin.g.a.q<? super Boolean, ? super Integer, ? super b, x> nmO;
  
  static
  {
    AppMethodBeat.i(111149);
    NtO = new a((byte)0);
    AppMethodBeat.o(111149);
  }
  
  public a(Context paramContext, ah paramah, RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(111148);
    this.context = paramContext;
    this.NtN = paramah;
    this.ALV = paramRecordConfigProvider;
    this.NtJ = new b();
    this.NtL = new af();
    this.NtM = ((r)new c(this));
    int k = com.tencent.mm.plugin.mmsight.d.WV(this.ALV.mfk.width);
    paramContext = ar.au(MMApplicationContext.getContext());
    int i = paramContext.y;
    int j = paramContext.x;
    if (this.ALV.scene == 11)
    {
      j = com.tencent.mm.plugin.mmsight.d.WV(this.ALV.mfk.height);
      Log.i("MicroMsg.VLogGenerateManager", "targetWidth:" + k + " targetHeight:" + j + ", videoParam:" + this.ALV.mfk);
      paramContext = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      com.tencent.mm.plugin.recordvideo.e.d.g(this.ALV);
      Log.i("MicroMsg.VLogGenerateManager", "output path:" + this.ALV.HLg);
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
      Log.i("MicroMsg.VLogGenerateManager", "audioMixType:" + i + ", muteOrigin:" + paramBoolean + ", audioInfo:" + paramAudioCacheInfo);
      paramContext = this.NtL;
      paramContext.Nnr = getVideoDurationMs();
      paramContext.Nns = i;
      paramah = this.ALV.HLg;
      p.j(paramah, "configProvider.outputVideoPath");
      paramContext.bfy(paramah);
      paramContext.targetWidth = k;
      paramContext.targetHeight = j;
      paramContext.videoBitrate = this.ALV.mfk.videoBitrate;
      paramContext.audioBitrate = this.ALV.mfk.audioBitrate;
      paramContext.frameRate = this.ALV.mfk.fps;
      paramContext.audioSampleRate = this.ALV.mfk.audioSampleRate;
      paramContext.audioChannelCount = this.ALV.mfk.audioChannelCount;
      Log.i("MicroMsg.VLogGenerateManager", "vLogGenerateModel is :" + this.NtL);
      this.NtK = new e(this.NtN, this.NtL);
      AppMethodBeat.o(111148);
      return;
      j = com.tencent.mm.plugin.mmsight.d.WV(i * k / j);
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
    Iterator localIterator = ((Iterable)this.NtN.Nnw).iterator();
    if (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      if (locals.endTime <= l) {
        break label92;
      }
      l = locals.endTime;
    }
    label92:
    for (;;)
    {
      break;
      Log.i("MicroMsg.VLogGenerateManager", "parse config duration : ".concat(String.valueOf(l)));
      int i = (int)l;
      AppMethodBeat.o(111147);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$Companion;", "", "()V", "ERROR_DEFAULT", "", "ERROR_MUSIC_DOWNLOAD_ERROR", "ERROR_MUSIC_MEDIA_EXTRACTOR_ERROR", "ERROR_OK", "ERROR_VIDEO_BG_REMUX", "ERROR_VIDEO_ENCODER_ERROR", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getVideoPath", "setVideoPath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
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
          if ((!p.h(this.videoPath, paramObject.videoPath)) || (!p.h(this.thumbPath, paramObject.thumbPath))) {}
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements r<String, String, Boolean, Integer, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "thumbPath", "b", "", "i", "", "invoke"})
  public static final class d
    extends kotlin.g.b.q
    implements r<String, String, Boolean, Integer, x>
  {
    public d(a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  public static final class e
    extends kotlin.g.b.q
    implements m<Boolean, String, x>
  {
    public e(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.manager.a
 * JD-Core Version:    0.7.0.1
 */