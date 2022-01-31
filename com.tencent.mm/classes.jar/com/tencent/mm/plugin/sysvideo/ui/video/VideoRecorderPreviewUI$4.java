package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.video.VideoView;

final class VideoRecorderPreviewUI$4
  implements MediaPlayer.OnPreparedListener
{
  VideoRecorderPreviewUI$4(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    y.d("MicroMsg.VideoRecorderPreviewUI", g.zH() + " onPrepared");
    y.d("MicroMsg.VideoRecorderPreviewUI", g.zH() + " onPrepared");
    paramMediaPlayer = VideoRecorderPreviewUI.a(this.pzh);
    if ((paramMediaPlayer.gHZ != null) && (paramMediaPlayer.snv)) {
      paramMediaPlayer.gHZ.start();
    }
    for (paramMediaPlayer.gHF = false;; paramMediaPlayer.gHF = true)
    {
      VideoRecorderPreviewUI.b(this.pzh).sendEmptyMessageDelayed(0, 3000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */