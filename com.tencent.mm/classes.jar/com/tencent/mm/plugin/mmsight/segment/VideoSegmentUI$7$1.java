package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.tencent.mm.plugin.u.a.h;

final class VideoSegmentUI$7$1
  implements Runnable
{
  VideoSegmentUI$7$1(VideoSegmentUI.7 param7) {}
  
  public final void run()
  {
    if (VideoSegmentUI.k(this.mny.mnw) != null) {
      VideoSegmentUI.k(this.mny.mnw).dismiss();
    }
    if (VideoSegmentUI.j(this.mny.mnw) != null) {
      VideoSegmentUI.j(this.mny.mnw).hv(false);
    }
    Toast.makeText(this.mny.mnw, a.h.mmsight_clip_failed, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.7.1
 * JD-Core Version:    0.7.0.1
 */