package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.sdk.platformtools.ac;

final class VideoSegmentUI$9
  implements a.a
{
  VideoSegmentUI$9(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final boolean gk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94475);
    ac.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    VideoSegmentUI.m(this.uQl);
    this.uQl.finish();
    VideoSegmentUI.b(this.uQl);
    AppMethodBeat.o(94475);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.9
 * JD-Core Version:    0.7.0.1
 */