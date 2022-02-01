package com.tencent.mm.plugin.vlog.ui.timelineeditor.scene;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorFollowMusicPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/scene/TimelineEditorPlatformVideoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isFollowMusic", "", "musicPlugin", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin;", "getMusicPlugin", "()Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin;", "musicPlugin$delegate", "Lkotlin/Lazy;", "initFollowMusicLogic", "", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "logTag", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TimelineEditorFollowMusicPluginLayout
  extends TimelineEditorPlatformVideoPluginLayout
{
  private boolean GoQ;
  private final j Uro;
  
  public TimelineEditorFollowMusicPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282213);
    this.Uro = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(282213);
  }
  
  private final com.tencent.mm.plugin.vlog.ui.a getMusicPlugin()
  {
    AppMethodBeat.i(282218);
    com.tencent.mm.plugin.vlog.ui.a locala = (com.tencent.mm.plugin.vlog.ui.a)this.Uro.getValue();
    AppMethodBeat.o(282218);
    return locala;
  }
  
  public final void a(b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(282242);
    Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", s.X("loadCurrentPage:", paramb));
    Object localObject2;
    label42:
    Object localObject3;
    boolean bool;
    label66:
    Object localObject4;
    int i;
    if (paramb == null)
    {
      localObject2 = null;
      if (Util.isNullOrNil((String)localObject2)) {
        break label292;
      }
      if (paramb != null) {
        break label210;
      }
      localObject1 = "";
      localObject3 = new AudioCacheInfo();
      ((AudioCacheInfo)localObject3).NID = ((int)System.currentTimeMillis());
      if (paramb != null) {
        break label253;
      }
      bool = false;
      if (!bool) {
        break label280;
      }
      localObject4 = AudioCacheInfo.NIB;
      i = AudioCacheInfo.gHV();
      label79:
      ((AudioCacheInfo)localObject3).source = i;
      ((AudioCacheInfo)localObject3).cached = true;
      ((AudioCacheInfo)localObject3).NIH = true;
      ((AudioCacheInfo)localObject3).cachePath = ((String)localObject2);
      ((AudioCacheInfo)localObject3).aPk((String)localObject1);
      ((AudioCacheInfo)localObject3).duration = ((int)getMaxCropVideoDurationMs());
      localObject1 = getMusicPlugin();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.vlog.ui.a)localObject1).setLocalAudioList(p.listOf(localObject3));
      }
      this.GoQ = true;
      Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", s.X("initFollowMusicLogic audioInfo1:", localObject3));
      if (paramb != null) {
        break label368;
      }
      bool = false;
    }
    for (;;)
    {
      setMediaMute(bool);
      super.a(paramb);
      AppMethodBeat.o(282242);
      return;
      localObject2 = paramb.nKf;
      if (localObject2 == null)
      {
        localObject2 = null;
        break;
      }
      localObject2 = ((Bundle)localObject2).getString("KEY_ORIGIN_MUSIC_PATH");
      break;
      label210:
      localObject1 = paramb.nKf;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label42;
      }
      localObject3 = ((Bundle)localObject1).getString("KEY_ORIGIN_MUSIC_NAME");
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label42;
      }
      localObject1 = "";
      break label42;
      label253:
      localObject4 = paramb.nKf;
      if (localObject4 == null)
      {
        bool = false;
        break label66;
      }
      bool = ((Bundle)localObject4).getBoolean("KEY_BGM_IF_ORIGIN");
      break label66;
      label280:
      localObject4 = AudioCacheInfo.NIB;
      i = AudioCacheInfo.gHW();
      break label79;
      label292:
      if (paramb == null) {}
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = getMusicPlugin();
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.vlog.ui.a)localObject2).setLocalAudioList(p.listOf(localObject1));
          }
          this.GoQ = true;
        }
        Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", s.X("initFollowMusicLogic audioInfo2:", localObject1));
        break;
        localObject2 = paramb.nKf;
        if (localObject2 != null) {
          localObject1 = (AudioCacheInfo)((Bundle)localObject2).getParcelable("KEY_SELECT_AUDIO_INFO");
        }
      }
      label368:
      localObject1 = paramb.nKf;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Bundle)localObject1).getBoolean("KEY_MEDIA_MUTE", false);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282228);
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", s.X("init logic ", paramRecordConfigProvider));
    AppMethodBeat.o(282228);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    boolean bool2 = false;
    com.tencent.mm.plugin.vlog.ui.a locala = null;
    AppMethodBeat.i(282255);
    s.u(paramc, "status");
    Log.i("MicroMsg.TimelineEditorFollowMusicPluginLayout", "statusChange " + paramc + " param:" + paramBundle);
    Object localObject1;
    Object localObject2;
    Bundle localBundle;
    if (paramc == a.c.NOP)
    {
      localObject1 = CaptureDataManager.NHH.rnY;
      localObject2 = AudioCacheInfo.NIB;
      ((Bundle)localObject1).putInt("SOUND_TRACK_TYPE", AudioCacheInfo.gHU());
      localObject1 = getMusicPlugin();
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.vlog.ui.a)localObject1).Gss;
        if (localObject2 != null)
        {
          if (!((AudioCacheInfo)localObject2).NIH) {
            break label433;
          }
          localBundle = CaptureDataManager.NHH.rnY;
          localObject1 = getCaptureInfo();
          if (localObject1 != null) {
            break label341;
          }
          localObject1 = null;
          localBundle.putString("ORIGIN_MUSIC_ID", (String)localObject1);
          localBundle = CaptureDataManager.NHH.rnY;
          localObject1 = getCaptureInfo();
          if (localObject1 != null) {
            break label372;
          }
          localObject1 = null;
          label163:
          localBundle.putString("ORIGIN_MUSIC_PATH", (String)localObject1);
          localBundle = CaptureDataManager.NHH.rnY;
          localObject1 = getCaptureInfo();
          if (localObject1 != null) {
            break label402;
          }
          localObject1 = null;
          label195:
          localBundle.putByteArray("ORIGIN_MUSIC_INFO", (byte[])localObject1);
          label205:
          CaptureDataManager.NHH.rnY.putInt("SOUND_TRACK_TYPE", ((AudioCacheInfo)localObject2).source);
        }
      }
      localObject2 = CaptureDataManager.NHH.rnY;
      localObject1 = getCaptureInfo();
      if (localObject1 != null) {
        break label468;
      }
      localObject1 = locala;
      label245:
      ((Bundle)localObject2).putString("ORIGIN_BGM_URL", (String)localObject1);
      localObject1 = CaptureDataManager.NHH.rnY;
      locala = getMusicPlugin();
      if (locala != null) {
        break label497;
      }
      bool1 = false;
      label276:
      if ((!bool1) && (!hUF())) {
        break label509;
      }
      bool1 = true;
      label289:
      ((Bundle)localObject1).putBoolean("MEDIA_IS_MUTE", bool1);
      localObject1 = CaptureDataManager.NHH.rnY;
      locala = getMusicPlugin();
      if (locala != null) {
        break label514;
      }
    }
    label514:
    for (boolean bool1 = bool2;; bool1 = locala.hSj())
    {
      ((Bundle)localObject1).putBoolean("MUSIC_IS_MUTE", bool1);
      super.a(paramc, paramBundle);
      AppMethodBeat.o(282255);
      return;
      label341:
      localObject1 = ((b)localObject1).nKf;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((Bundle)localObject1).getString("KEY_ORIGIN_MUSIC_ID");
      break;
      label372:
      localObject1 = ((b)localObject1).nKf;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label163;
      }
      localObject1 = ((Bundle)localObject1).getString("KEY_ORIGIN_MUSIC_PATH");
      break label163;
      label402:
      localObject1 = ((b)localObject1).nKf;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label195;
      }
      localObject1 = ((Bundle)localObject1).getByteArray("KEY_ORIGIN_MUSIC_INFO");
      break label195;
      label433:
      if (((AudioCacheInfo)localObject2).ABJ != null) {
        break label205;
      }
      localObject1 = ((AudioCacheInfo)localObject2).NIC.toByteArray();
      CaptureDataManager.NHH.rnY.putByteArray("MEDIA_EXTRA_MUSIC", (byte[])localObject1);
      break label205;
      label468:
      localBundle = ((b)localObject1).nKf;
      localObject1 = locala;
      if (localBundle == null) {
        break label245;
      }
      localObject1 = localBundle.getString("KEY_ORIGIN_BGM_URL");
      break label245;
      label497:
      bool1 = locala.Gso.getMuteOrigin();
      break label276;
      label509:
      bool1 = false;
      break label289;
    }
  }
  
  protected final String hUH()
  {
    return "MicroMsg.TimelineEditorFollowMusicPluginLayout";
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.vlog.ui.a>
  {
    a(TimelineEditorFollowMusicPluginLayout paramTimelineEditorFollowMusicPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorFollowMusicPluginLayout
 * JD-Core Version:    0.7.0.1
 */