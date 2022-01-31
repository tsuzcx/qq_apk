package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.a.b;

final class VideoActivity$6
  implements Runnable
{
  VideoActivity$6(VideoActivity paramVideoActivity) {}
  
  public final void run()
  {
    if ((b.Ay(VideoActivity.b(this.pWM))) && (!VideoActivity.c(this.pWM)) && (VideoActivity.d(this.pWM) != null)) {
      VideoActivity.d(this.pWM).cD(this.pWM.getString(a.e.voip_callout_timeout_prompt), 10000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.6
 * JD-Core Version:    0.7.0.1
 */