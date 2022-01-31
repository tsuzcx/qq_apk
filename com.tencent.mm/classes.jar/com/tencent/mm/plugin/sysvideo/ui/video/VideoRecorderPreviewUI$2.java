package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.Message;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VideoRecorderPreviewUI$2
  extends ak
{
  VideoRecorderPreviewUI$2(VideoRecorderPreviewUI paramVideoRecorderPreviewUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(25631);
    this.taU.getWindow().setFlags(1024, 1024);
    this.taU.hideTitleView();
    AppMethodBeat.o(25631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */