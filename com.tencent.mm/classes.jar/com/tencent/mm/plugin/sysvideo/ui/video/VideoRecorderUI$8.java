package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.sdk.platformtools.ak;

final class VideoRecorderUI$8
  implements View.OnClickListener
{
  VideoRecorderUI$8(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25653);
    VideoRecorderUI.o(this.tbs).setEnabled(false);
    VideoRecorderUI.p(this.tbs).sendEmptyMessageDelayed(0, 3000L);
    VideoRecorderUI.a(this.tbs, true);
    VideoRecorderUI.h(this.tbs).dmH();
    if ((VideoRecorderUI.h(this.tbs).b(this.tbs, VideoRecorderUI.q(this.tbs)) != 0) || (VideoRecorderUI.h(this.tbs).b(VideoRecorderUI.r(this.tbs)) != 0)) {
      VideoRecorderUI.s(this.tbs);
    }
    AppMethodBeat.o(25653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.8
 * JD-Core Version:    0.7.0.1
 */