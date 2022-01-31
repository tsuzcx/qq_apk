package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.R.g;

final class VideoRecorderUI$7$1
  implements DialogInterface.OnClickListener
{
  VideoRecorderUI$7$1(VideoRecorderUI.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoRecorderUI.m(this.pzH.pzG).setImageResource(R.g.video_recorder_stop_btn);
    VideoRecorderUI.n(this.pzH.pzG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.7.1
 * JD-Core Version:    0.7.0.1
 */