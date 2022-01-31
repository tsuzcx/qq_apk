package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.b;

final class VideoRecorderUI$4
  implements DialogInterface.OnClickListener
{
  VideoRecorderUI$4(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25648);
    VideoRecorderUI.h(this.tbs).dmH();
    this.tbs.finish();
    AppMethodBeat.o(25648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.4
 * JD-Core Version:    0.7.0.1
 */