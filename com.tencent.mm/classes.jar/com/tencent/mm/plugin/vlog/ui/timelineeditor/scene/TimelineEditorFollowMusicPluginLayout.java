package com.tencent.mm.plugin.vlog.ui.timelineeditor.scene;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorFollowMusicPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isFollowMusic", "", "musicPlugin", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin;", "getMusicPlugin", "()Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin;", "musicPlugin$delegate", "Lkotlin/Lazy;", "initFollowMusicLogic", "", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "logTag", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-vlog_release"})
public final class TimelineEditorFollowMusicPluginLayout
  extends TimelineEditorPlatformVideoPluginLayout
{
  private boolean AMb;
  private final f NFc;
  
  public TimelineEditorFollowMusicPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(228910);
    this.NFc = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(228910);
  }
  
  private final com.tencent.mm.plugin.vlog.ui.a getMusicPlugin()
  {
    AppMethodBeat.i(228887);
    com.tencent.mm.plugin.vlog.ui.a locala = (com.tencent.mm.plugin.vlog.ui.a)this.NFc.getValue();
    AppMethodBeat.o(228887);
    return locala;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(228900);
    Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", "loadCurrentPage:".concat(String.valueOf(paramb)));
    Object localObject1;
    Object localObject2;
    label88:
    Object localObject4;
    label136:
    int i;
    if (paramb != null)
    {
      localObject1 = paramb.lfu;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getString("KEY_ORIGIN_MUSIC_PATH");
        if (Util.isNullOrNil((String)localObject1)) {
          break label295;
        }
        if (paramb != null)
        {
          localObject2 = paramb.lfu;
          if (localObject2 != null)
          {
            localObject3 = ((Bundle)localObject2).getString("KEY_ORIGIN_MUSIC_NAME");
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label88;
            }
          }
        }
        localObject2 = "";
        p.j(localObject2, "model?.extInfo?.getStrin…_ORIGIN_MUSIC_NAME) ?: \"\"");
        Object localObject3 = new AudioCacheInfo();
        ((AudioCacheInfo)localObject3).HLC = ((int)System.currentTimeMillis());
        if (paramb == null) {
          break label278;
        }
        localObject4 = paramb.lfu;
        if (localObject4 == null) {
          break label278;
        }
        bool = ((Bundle)localObject4).getBoolean("KEY_BGM_IF_ORIGIN");
        if (!bool) {
          break label283;
        }
        localObject4 = AudioCacheInfo.HMa;
        i = AudioCacheInfo.fwm();
        label149:
        ((AudioCacheInfo)localObject3).source = i;
        ((AudioCacheInfo)localObject3).aGs = true;
        ((AudioCacheInfo)localObject3).HLG = true;
        ((AudioCacheInfo)localObject3).cachePath = ((String)localObject1);
        ((AudioCacheInfo)localObject3).aSq((String)localObject2);
        ((AudioCacheInfo)localObject3).duration = ((int)getMaxCropVideoDurationMs());
        localObject1 = getMusicPlugin();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.ui.a)localObject1).setLocalAudioList(j.listOf(localObject3));
        }
        this.AMb = true;
        Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", "initFollowMusicLogic audioInfo1:".concat(String.valueOf(localObject3)));
        if (paramb == null) {
          break label377;
        }
        localObject1 = paramb.lfu;
        if (localObject1 == null) {
          break label377;
        }
      }
    }
    label278:
    label283:
    label295:
    label377:
    for (boolean bool = ((Bundle)localObject1).getBoolean("KEY_MEDIA_MUTE", false);; bool = false)
    {
      setMediaMute(bool);
      super.a(paramb);
      AppMethodBeat.o(228900);
      return;
      localObject1 = null;
      break;
      bool = false;
      break label136;
      localObject4 = AudioCacheInfo.HMa;
      i = AudioCacheInfo.fwn();
      break label149;
      if (paramb != null)
      {
        localObject1 = paramb.lfu;
        if (localObject1 == null) {}
      }
      for (localObject1 = (AudioCacheInfo)((Bundle)localObject1).getParcelable("KEY_SELECT_AUDIO_INFO");; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject2 = getMusicPlugin();
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.vlog.ui.a)localObject2).setLocalAudioList(j.listOf(localObject1));
          }
          this.AMb = true;
        }
        Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", "initFollowMusicLogic audioInfo2:".concat(String.valueOf(localObject1)));
        break;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(228889);
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", "init logic ".concat(String.valueOf(paramRecordConfigProvider)));
    super.a(parama, paramRecordConfigProvider);
    AppMethodBeat.o(228889);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    boolean bool2 = false;
    com.tencent.mm.plugin.vlog.ui.a locala = null;
    AppMethodBeat.i(228908);
    p.k(paramc, "status");
    Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", "statusChange " + paramc + " param:" + paramBundle);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramc == d.c.HSj)
    {
      localObject1 = CaptureDataManager.HKJ;
      p.j(localObject1, "CaptureDataManager.INSTANCE");
      localObject1 = ((CaptureDataManager)localObject1).getExtData();
      localObject2 = AudioCacheInfo.HMa;
      ((Bundle)localObject1).putInt("SOUND_TRACK_TYPE", AudioCacheInfo.fwl());
      localObject1 = getMusicPlugin();
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.vlog.ui.a)localObject1).AQf;
        if (localObject2 != null)
        {
          if (!((AudioCacheInfo)localObject2).HLG) {
            break label550;
          }
          localObject1 = CaptureDataManager.HKJ;
          p.j(localObject1, "CaptureDataManager.INSTANCE");
          localObject3 = ((CaptureDataManager)localObject1).getExtData();
          localObject1 = getCaptureInfo();
          if (localObject1 == null) {
            break label532;
          }
          localObject1 = ((b)localObject1).lfu;
          if (localObject1 == null) {
            break label532;
          }
          localObject1 = ((Bundle)localObject1).getString("KEY_ORIGIN_MUSIC_ID");
          ((Bundle)localObject3).putString("ORIGIN_MUSIC_ID", (String)localObject1);
          localObject1 = CaptureDataManager.HKJ;
          p.j(localObject1, "CaptureDataManager.INSTANCE");
          localObject3 = ((CaptureDataManager)localObject1).getExtData();
          localObject1 = getCaptureInfo();
          if (localObject1 == null) {
            break label538;
          }
          localObject1 = ((b)localObject1).lfu;
          if (localObject1 == null) {
            break label538;
          }
          localObject1 = ((Bundle)localObject1).getString("KEY_ORIGIN_MUSIC_PATH");
          label236:
          ((Bundle)localObject3).putString("ORIGIN_MUSIC_PATH", (String)localObject1);
          localObject1 = CaptureDataManager.HKJ;
          p.j(localObject1, "CaptureDataManager.INSTANCE");
          localObject3 = ((CaptureDataManager)localObject1).getExtData();
          localObject1 = getCaptureInfo();
          if (localObject1 == null) {
            break label544;
          }
          localObject1 = ((b)localObject1).lfu;
          if (localObject1 == null) {
            break label544;
          }
          localObject1 = ((Bundle)localObject1).getByteArray("KEY_ORIGIN_MUSIC_INFO");
          label299:
          ((Bundle)localObject3).putByteArray("ORIGIN_MUSIC_INFO", (byte[])localObject1);
          label309:
          localObject1 = CaptureDataManager.HKJ;
          p.j(localObject1, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject1).getExtData().putInt("SOUND_TRACK_TYPE", ((AudioCacheInfo)localObject2).source);
        }
      }
      localObject1 = CaptureDataManager.HKJ;
      p.j(localObject1, "CaptureDataManager.INSTANCE");
      localObject2 = ((CaptureDataManager)localObject1).getExtData();
      localObject3 = getCaptureInfo();
      localObject1 = locala;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).lfu;
        localObject1 = locala;
        if (localObject3 != null) {
          localObject1 = ((Bundle)localObject3).getString("KEY_ORIGIN_BGM_URL");
        }
      }
      ((Bundle)localObject2).putString("ORIGIN_BGM_URL", (String)localObject1);
      localObject1 = CaptureDataManager.HKJ;
      p.j(localObject1, "CaptureDataManager.INSTANCE");
      localObject1 = ((CaptureDataManager)localObject1).getExtData();
      locala = getMusicPlugin();
      if (locala == null) {
        break label597;
      }
      bool1 = locala.AQb.getMuteOrigin();
      label449:
      if ((!bool1) && (!gwI())) {
        break label602;
      }
    }
    label532:
    label538:
    label544:
    label550:
    label597:
    label602:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((Bundle)localObject1).putBoolean("MEDIA_IS_MUTE", bool1);
      localObject1 = CaptureDataManager.HKJ;
      p.j(localObject1, "CaptureDataManager.INSTANCE");
      localObject1 = ((CaptureDataManager)localObject1).getExtData();
      locala = getMusicPlugin();
      bool1 = bool2;
      if (locala != null) {
        bool1 = locala.guu();
      }
      ((Bundle)localObject1).putBoolean("MUSIC_IS_MUTE", bool1);
      super.a(paramc, paramBundle);
      AppMethodBeat.o(228908);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label236;
      localObject1 = null;
      break label299;
      if (((AudioCacheInfo)localObject2).xcx != null) {
        break label309;
      }
      localObject1 = ((AudioCacheInfo)localObject2).HLB.toByteArray();
      localObject3 = CaptureDataManager.HKJ;
      p.j(localObject3, "CaptureDataManager.INSTANCE");
      ((CaptureDataManager)localObject3).getExtData().putByteArray("MEDIA_EXTRA_MUSIC", (byte[])localObject1);
      break label309;
      bool1 = false;
      break label449;
    }
  }
  
  protected final String gwK()
  {
    return "MicroMsg.TimelineEditorFollowMusicPluginLayout";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.vlog.ui.a>
  {
    a(TimelineEditorFollowMusicPluginLayout paramTimelineEditorFollowMusicPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorFollowMusicPluginLayout
 * JD-Core Version:    0.7.0.1
 */