package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.sdk.platformtools.ah;

final class VideoRecorderUI$8
  implements View.OnClickListener
{
  VideoRecorderUI$8(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void onClick(View paramView)
  {
    VideoRecorderUI.o(this.pzG).setEnabled(false);
    VideoRecorderUI.p(this.pzG).sendEmptyMessageDelayed(0, 3000L);
    VideoRecorderUI.a(this.pzG, true);
    VideoRecorderUI.h(this.pzG).clT();
    if ((VideoRecorderUI.h(this.pzG).a(this.pzG, VideoRecorderUI.q(this.pzG)) != 0) || (VideoRecorderUI.h(this.pzG).b(VideoRecorderUI.r(this.pzG)) != 0)) {
      VideoRecorderUI.s(this.pzG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.8
 * JD-Core Version:    0.7.0.1
 */