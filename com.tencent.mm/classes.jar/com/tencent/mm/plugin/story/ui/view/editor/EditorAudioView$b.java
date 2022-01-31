package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.story.ui.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$initAudioSearchPanel$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$AudioSearchCallback;", "onPauseAudio", "", "onSearchAudioCancel", "onSearchAudioFinish", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "onSearchAudioSelected", "plugin-story_release"})
public final class EditorAudioView$b
  implements EditorAudioSearchView.a
{
  public final void cFE()
  {
    AppMethodBeat.i(110513);
    EditorAudioView.a locala = this.sOy.getCallback();
    if (locala != null)
    {
      locala.pauseAudio();
      AppMethodBeat.o(110513);
      return;
    }
    AppMethodBeat.o(110513);
  }
  
  public final void cFF()
  {
    AppMethodBeat.i(110516);
    EditorAudioView.c(this.sOy, true);
    EditorAudioView.b(this.sOy, false);
    AppMethodBeat.o(110516);
  }
  
  public final void d(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(110514);
    if (paramAudioCacheInfo != null)
    {
      Object localObject = new ArrayList();
      AudioCacheInfo.a locala = AudioCacheInfo.swC;
      paramAudioCacheInfo.type = AudioCacheInfo.cBt();
      locala = AudioCacheInfo.swC;
      paramAudioCacheInfo.cpt = AudioCacheInfo.cBz();
      ((ArrayList)localObject).add(paramAudioCacheInfo);
      paramAudioCacheInfo = EditorAudioView.f(this.sOy);
      localObject = (List)localObject;
      j.q(localObject, "audios");
      paramAudioCacheInfo.sIi.addAll(0, (Collection)localObject);
      paramAudioCacheInfo.notifyDataSetChanged();
      EditorAudioView.g(this.sOy).smoothScrollToPosition(0);
      this.sOy.Gg(0);
      EditorAudioView.b(this.sOy, false);
      EditorAudioView.c(this.sOy, true);
      EditorAudioView.d(this.sOy, true);
    }
    AppMethodBeat.o(110514);
  }
  
  public final void e(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(110515);
    if (paramAudioCacheInfo != null)
    {
      int i = paramAudioCacheInfo.type;
      Object localObject = AudioCacheInfo.swC;
      if (i == AudioCacheInfo.cBv())
      {
        localObject = this.sOy.getCallback();
        if (localObject != null)
        {
          ((EditorAudioView.a)localObject).a(paramAudioCacheInfo);
          AppMethodBeat.o(110515);
        }
      }
    }
    else
    {
      AppMethodBeat.o(110515);
      return;
    }
    AppMethodBeat.o(110515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.b
 * JD-Core Version:    0.7.0.1
 */