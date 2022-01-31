package com.tencent.mm.plugin.story.ui.view;

import a.l;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/AudioWaveView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-story_release"})
public final class AudioWaveView$a
  implements q.a
{
  public final void a(e parame) {}
  
  public final void aF(boolean paramBoolean) {}
  
  public final void ai(int paramInt) {}
  
  public final void b(p paramp) {}
  
  public final void b(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110285);
    if (paramInt == 3) {
      this.sLf.setPlayerLoading(false);
    }
    AppMethodBeat.o(110285);
  }
  
  public final void na() {}
  
  public final void nb() {}
  
  public final void nc() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.AudioWaveView.a
 * JD-Core Version:    0.7.0.1
 */