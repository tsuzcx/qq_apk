package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.Message;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VideoRecorderUI$9
  extends ak
{
  VideoRecorderUI$9(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(25654);
    super.handleMessage(paramMessage);
    VideoRecorderUI.o(this.tbs).setEnabled(true);
    AppMethodBeat.o(25654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.9
 * JD-Core Version:    0.7.0.1
 */