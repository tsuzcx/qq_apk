package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.video.VideoView;

final class VideoRecorderPreviewUI$3
  implements MediaPlayer.OnErrorListener
{
  VideoRecorderPreviewUI$3(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VideoRecorderPreviewUI.a(this.pzh).stopPlayback();
    h.h(this.pzh, R.l.video_play_faile, R.l.video_play_err);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.3
 * JD-Core Version:    0.7.0.1
 */