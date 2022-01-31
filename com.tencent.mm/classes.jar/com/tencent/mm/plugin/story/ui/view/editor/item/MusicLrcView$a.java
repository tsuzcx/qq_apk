package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-story_release"})
public final class MusicLrcView$a
  implements q.a
{
  public final void a(e parame) {}
  
  public final void aF(boolean paramBoolean) {}
  
  public final void ai(int paramInt) {}
  
  public final void b(p paramp) {}
  
  public final void b(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(110677);
    if (paramInt == 3)
    {
      this.sRk.bNM();
      localObject1 = this.sRk.getPlayer();
      if (localObject1 == null) {
        break label118;
      }
    }
    label118:
    for (Object localObject1 = Long.valueOf(((v)localObject1).getDuration());; localObject1 = null)
    {
      if (localObject1 == null) {
        j.ebi();
      }
      if (((Long)localObject1).longValue() < this.sRk.getRndDuration())
      {
        MusicLrcView localMusicLrcView = this.sRk;
        v localv = this.sRk.getPlayer();
        localObject1 = localObject2;
        if (localv != null) {
          localObject1 = Long.valueOf(localv.getDuration());
        }
        if (localObject1 == null) {
          j.ebi();
        }
        localMusicLrcView.setRndDuration((int)((Long)localObject1).longValue());
      }
      AppMethodBeat.o(110677);
      return;
    }
  }
  
  public final void na() {}
  
  public final void nb() {}
  
  public final void nc() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.MusicLrcView.a
 * JD-Core Version:    0.7.0.1
 */