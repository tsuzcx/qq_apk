package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VideoRecorderPreviewUI$5
  implements View.OnClickListener
{
  VideoRecorderPreviewUI$5(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25634);
    VideoRecorderPreviewUI.b(this.taU).removeMessages(0);
    if (this.taU.isTitleShowing())
    {
      this.taU.getWindow().setFlags(1024, 1024);
      this.taU.hideTitleView();
      AppMethodBeat.o(25634);
      return;
    }
    this.taU.getWindow().clearFlags(1024);
    this.taU.showTitleView();
    VideoRecorderPreviewUI.b(this.taU).removeMessages(0);
    VideoRecorderPreviewUI.b(this.taU).sendEmptyMessageDelayed(0, 3000L);
    AppMethodBeat.o(25634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */