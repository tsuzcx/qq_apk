package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

final class VideoRecorderUI$7
  implements View.OnClickListener
{
  VideoRecorderUI$7(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(this.pzG);
      return;
    }
    if (VideoRecorderUI.k(this.pzG))
    {
      VideoRecorderUI.d(this.pzG);
      return;
    }
    if (VideoRecorderUI.l(this.pzG))
    {
      h.a(this.pzG, this.pzG.getString(R.l.video_recorder_restart), this.pzG.getString(R.l.app_tip), new VideoRecorderUI.7.1(this), new VideoRecorderUI.7.2(this));
      return;
    }
    VideoRecorderUI.m(this.pzG).setImageResource(R.g.video_recorder_stop_btn);
    VideoRecorderUI.n(this.pzG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.7
 * JD-Core Version:    0.7.0.1
 */