package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MainSightForwardContainerView$7
  implements MediaPlayer.OnCompletionListener
{
  MainSightForwardContainerView$7(MainSightForwardContainerView paramMainSightForwardContainerView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(25042);
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    AppMethodBeat.o(25042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.7
 * JD-Core Version:    0.7.0.1
 */