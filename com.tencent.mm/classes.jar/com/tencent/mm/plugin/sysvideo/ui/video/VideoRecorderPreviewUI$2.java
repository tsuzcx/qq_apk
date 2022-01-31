package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.Message;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class VideoRecorderPreviewUI$2
  extends ah
{
  VideoRecorderPreviewUI$2(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    this.pzh.getWindow().setFlags(1024, 1024);
    this.pzh.mController.hideTitleView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */