package com.tencent.mm.plugin.mmsight.segment;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoSegmentUI$5
  implements MenuItem.OnMenuItemClickListener
{
  VideoSegmentUI$5(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55034);
    this.oME.finish();
    VideoSegmentUI.b(this.oME);
    AppMethodBeat.o(55034);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.5
 * JD-Core Version:    0.7.0.1
 */