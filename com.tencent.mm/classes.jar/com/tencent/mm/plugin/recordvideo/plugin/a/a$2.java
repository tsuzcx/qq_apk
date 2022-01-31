package com.tencent.mm.plugin.recordvideo.plugin.a;

import a.f.b.j;
import a.l;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.a;
import com.tencent.mm.protocal.protobuf.baz;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin$2", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "onLyricsSelected", "visible", "", "lyricsInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "pauseAudio", "toggleOrigin", "remove", "plugin-recordvideo_release"})
public final class a$2
  implements EditorAudioView.a
{
  public final void a(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(150781);
    if (paramAudioCacheInfo != null)
    {
      i = paramAudioCacheInfo.type;
      localObject = AudioCacheInfo.swC;
      if (i == AudioCacheInfo.cBu())
      {
        a.a(this.qdE).pauseAudio();
        AppMethodBeat.o(150781);
        return;
      }
    }
    this.qdE.qaV = paramAudioCacheInfo;
    Object localObject = new Bundle();
    ((Bundle)localObject).putParcelable("EDIT_SELECT_MUSIC_PARCELABLE", (Parcelable)paramAudioCacheInfo);
    this.qdE.qbI.a(d.c.qeE, (Bundle)localObject);
    localObject = a.a(this.qdE).b(paramAudioCacheInfo);
    if (localObject != null) {
      a.b(this.qdE).setMusicPlayer((v)localObject);
    }
    localObject = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    if (paramAudioCacheInfo != null)
    {
      localObject = Integer.valueOf(paramAudioCacheInfo.swp);
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_MUSIC_ID_INT", localObject);
      localObject = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      if (paramAudioCacheInfo == null) {
        break label227;
      }
      i = paramAudioCacheInfo.position;
      label145:
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_MUSIC_INDEX_INT", Integer.valueOf(i + 1));
      localObject = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      if (paramAudioCacheInfo == null) {
        break label233;
      }
      localObject = Long.valueOf(paramAudioCacheInfo.swu);
      label172:
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_MUSIC_REQ_ID_INT", localObject);
      localObject = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      if (paramAudioCacheInfo == null) {
        break label241;
      }
      i = paramAudioCacheInfo.cpt;
      paramAudioCacheInfo = AudioCacheInfo.swC;
      if (i != AudioCacheInfo.cBz()) {
        break label241;
      }
    }
    label227:
    label233:
    label241:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_SEARCH_MUSIC_INT", Integer.valueOf(i));
      AppMethodBeat.o(150781);
      return;
      localObject = Integer.valueOf(-1);
      break;
      i = -2;
      break label145;
      localObject = Integer.valueOf(-1);
      break label172;
    }
  }
  
  public final void b(boolean paramBoolean, List<? extends baz> paramList)
  {
    AppMethodBeat.i(150779);
    j.q(paramList, "lyricsInfos");
    AppMethodBeat.o(150779);
  }
  
  public final void kt(boolean paramBoolean)
  {
    AppMethodBeat.i(150782);
    this.qdE.qdB = paramBoolean;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN", paramBoolean);
    this.qdE.qbI.a(d.c.qeD, localBundle);
    AppMethodBeat.o(150782);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(150780);
    a.a(this.qdE).pauseAudio();
    AppMethodBeat.o(150780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.a.2
 * JD-Core Version:    0.7.0.1
 */