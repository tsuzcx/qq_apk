package com.tencent.mm.plugin.mmsight.segment;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSegmentUI$d$1
  implements Runnable
{
  VideoSegmentUI$d$1(VideoSegmentUI.d paramd) {}
  
  public final void run()
  {
    if ((VideoSegmentUI.t(this.mnJ.mnw)) || (this.mnJ.mnw.isFinishing()) || (VideoSegmentUI.j(this.mnJ.mnw) == null) || (VideoSegmentUI.d(this.mnJ.mnw) == null))
    {
      y.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
      return;
    }
    ((View)VideoSegmentUI.j(this.mnJ.mnw)).setAlpha(0.0F);
    ((View)VideoSegmentUI.j(this.mnJ.mnw)).setVisibility(0);
    ((View)VideoSegmentUI.j(this.mnJ.mnw)).animate().setDuration(300L).setStartDelay(200L).alpha(1.0F);
    float f1 = VideoSegmentUI.j(this.mnJ.mnw).bjK();
    float f2 = VideoSegmentUI.j(this.mnJ.mnw).bjL();
    if ((f2 - f1) * VideoSegmentUI.e(this.mnJ.mnw) <= VideoSegmentUI.p(this.mnJ.mnw)) {
      this.mnJ.mnw.enableOptionMenu(true);
    }
    VideoSegmentUI.d(this.mnJ.mnw).setLoop((int)(f1 * VideoSegmentUI.e(this.mnJ.mnw)), (int)(f2 * VideoSegmentUI.e(this.mnJ.mnw)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.d.1
 * JD-Core Version:    0.7.0.1
 */