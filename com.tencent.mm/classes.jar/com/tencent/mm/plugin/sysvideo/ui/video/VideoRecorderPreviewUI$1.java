package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class VideoRecorderPreviewUI$1
  implements MenuItem.OnMenuItemClickListener
{
  VideoRecorderPreviewUI$1(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.pzh.finish();
    this.pzh.overridePendingTransition(0, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */