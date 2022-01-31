package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.res.Resources;
import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VideoRecorderUI$1
  implements ap.a
{
  VideoRecorderUI$1(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25643);
    if (VideoRecorderUI.a(this.tbs) == -1L) {
      VideoRecorderUI.a(this.tbs, SystemClock.elapsedRealtime());
    }
    long l1 = VideoRecorderUI.a(this.tbs);
    l1 = SystemClock.elapsedRealtime() - l1;
    VideoRecorderUI.b(this.tbs).setText(f.mH((int)(l1 / 1000L)));
    if ((l1 <= 30000L) && (l1 >= 20000L))
    {
      long l2 = (30000L - l1) / 1000L;
      VideoRecorderUI.c(this.tbs).setVisibility(0);
      VideoRecorderUI.c(this.tbs).setText(this.tbs.getResources().getQuantityString(2131361826, (int)l2, new Object[] { Long.valueOf(l2) }));
    }
    while (l1 >= 30000L)
    {
      ab.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
      VideoRecorderUI.d(this.tbs);
      VideoRecorderUI.a(this.tbs, -1L);
      AppMethodBeat.o(25643);
      return false;
      VideoRecorderUI.c(this.tbs).setVisibility(8);
    }
    VideoRecorderUI.a(this.tbs, VideoRecorderUI.e(this.tbs) % 2);
    if (VideoRecorderUI.e(this.tbs) == 0) {
      VideoRecorderUI.f(this.tbs).setVisibility(4);
    }
    for (;;)
    {
      VideoRecorderUI.g(this.tbs);
      AppMethodBeat.o(25643);
      return true;
      VideoRecorderUI.f(this.tbs).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.1
 * JD-Core Version:    0.7.0.1
 */