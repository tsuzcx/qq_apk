package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.pluginsdk.i.b;

final class VideoRecorderUI$10
  implements View.OnClickListener
{
  VideoRecorderUI$10(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.pzG, VideoRecorderPreviewUI.class);
    paramView.putExtra("VideoRecorder_FileName", VideoRecorderUI.h(this.pzG).filename);
    paramView.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.h(this.pzG).oiw.eHH);
    paramView.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.h(this.pzG).fileSize);
    paramView.putExtra("VideoRecorder_ToUser", VideoRecorderUI.i(this.pzG));
    paramView.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.t(this.pzG));
    this.pzG.startActivityForResult(paramView, 0);
    this.pzG.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.10
 * JD-Core Version:    0.7.0.1
 */