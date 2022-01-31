package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.plugin.voip.a.e;

final class VideoActivity$13
  implements Runnable
{
  VideoActivity$13(VideoActivity paramVideoActivity) {}
  
  public final void run()
  {
    if (VideoActivity.d(this.pWM) != null) {
      VideoActivity.d(this.pWM).cD(this.pWM.getString(a.e.voip_shutdown_tip), -1);
    }
    VideoActivity.e(this.pWM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.13
 * JD-Core Version:    0.7.0.1
 */