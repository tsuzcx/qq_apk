package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoRecorderPreviewUI$1
  implements MenuItem.OnMenuItemClickListener
{
  VideoRecorderPreviewUI$1(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25630);
    this.taU.finish();
    this.taU.overridePendingTransition(0, 0);
    AppMethodBeat.o(25630);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */