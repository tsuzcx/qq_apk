package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class VideoRecorderPreviewUI$6
  implements MediaPlayer.OnCompletionListener
{
  VideoRecorderPreviewUI$6(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.pzh.finish();
    this.pzh.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.6
 * JD-Core Version:    0.7.0.1
 */