package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSegmentUI$9
  implements a.a
{
  VideoSegmentUI$9(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final boolean di(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    VideoSegmentUI.m(this.mnw);
    this.mnw.finish();
    VideoSegmentUI.b(this.mnw);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.9
 * JD-Core Version:    0.7.0.1
 */