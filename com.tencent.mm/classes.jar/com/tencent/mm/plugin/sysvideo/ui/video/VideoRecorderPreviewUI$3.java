package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.video.VideoView;

final class VideoRecorderPreviewUI$3
  implements MediaPlayer.OnErrorListener
{
  VideoRecorderPreviewUI$3(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25632);
    VideoRecorderPreviewUI.a(this.taU).stopPlayback();
    h.h(this.taU, 2131304530, 2131304528);
    AppMethodBeat.o(25632);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.3
 * JD-Core Version:    0.7.0.1
 */