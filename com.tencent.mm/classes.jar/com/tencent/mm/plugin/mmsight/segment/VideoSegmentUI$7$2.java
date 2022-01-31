package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;

final class VideoSegmentUI$7$2
  implements Runnable
{
  VideoSegmentUI$7$2(VideoSegmentUI.7 param7, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    if (VideoSegmentUI.k(this.mny.mnw) != null) {
      VideoSegmentUI.k(this.mny.mnw).dismiss();
    }
    if (VideoSegmentUI.j(this.mny.mnw) != null) {
      VideoSegmentUI.j(this.mny.mnw).hv(false);
    }
    VideoSegmentUI.a(this.mny.mnw, this.mnz, this.mnA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.7.2
 * JD-Core Version:    0.7.0.1
 */