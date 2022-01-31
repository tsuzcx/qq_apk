package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoRecorderUI$11
  implements DialogInterface.OnClickListener
{
  VideoRecorderUI$11(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25656);
    this.tbs.finish();
    AppMethodBeat.o(25656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.11
 * JD-Core Version:    0.7.0.1
 */