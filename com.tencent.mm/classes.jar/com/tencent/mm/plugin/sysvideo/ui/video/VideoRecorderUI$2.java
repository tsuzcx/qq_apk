package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.SurfaceView;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.y;

final class VideoRecorderUI$2
  implements DialogInterface.OnCancelListener
{
  VideoRecorderUI$2(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.d("MicroMsg.VideoRecorderUI", "tipDialog onCancel");
    if (VideoRecorderUI.h(this.pzG) != null)
    {
      VideoRecorderUI.u(this.pzG);
      VideoRecorderUI.v(this.pzG).setVisibility(0);
      VideoRecorderUI.w(this.pzG).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.2
 * JD-Core Version:    0.7.0.1
 */