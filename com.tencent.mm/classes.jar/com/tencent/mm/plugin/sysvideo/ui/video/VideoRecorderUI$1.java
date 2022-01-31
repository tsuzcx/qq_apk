package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.res.Resources;
import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.j;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class VideoRecorderUI$1
  implements am.a
{
  VideoRecorderUI$1(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final boolean tC()
  {
    if (VideoRecorderUI.a(this.pzG) == -1L) {
      VideoRecorderUI.a(this.pzG, SystemClock.elapsedRealtime());
    }
    long l1 = VideoRecorderUI.a(this.pzG);
    l1 = SystemClock.elapsedRealtime() - l1;
    VideoRecorderUI.b(this.pzG).setText(e.jL((int)(l1 / 1000L)));
    if ((l1 <= 30000L) && (l1 >= 20000L))
    {
      long l2 = (30000L - l1) / 1000L;
      VideoRecorderUI.c(this.pzG).setVisibility(0);
      VideoRecorderUI.c(this.pzG).setText(this.pzG.getResources().getQuantityString(R.j.video_recorder_time_limit, (int)l2, new Object[] { Long.valueOf(l2) }));
    }
    while (l1 >= 30000L)
    {
      y.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
      VideoRecorderUI.d(this.pzG);
      VideoRecorderUI.a(this.pzG, -1L);
      return false;
      VideoRecorderUI.c(this.pzG).setVisibility(8);
    }
    VideoRecorderUI.a(this.pzG, VideoRecorderUI.e(this.pzG) % 2);
    if (VideoRecorderUI.e(this.pzG) == 0) {
      VideoRecorderUI.f(this.pzG).setVisibility(4);
    }
    for (;;)
    {
      VideoRecorderUI.g(this.pzG);
      return true;
      VideoRecorderUI.f(this.pzG).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.1
 * JD-Core Version:    0.7.0.1
 */