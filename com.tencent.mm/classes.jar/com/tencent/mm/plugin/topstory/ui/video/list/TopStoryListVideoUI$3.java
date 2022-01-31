package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryListVideoUI$3
  implements Runnable
{
  TopStoryListVideoUI$3(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(2101);
    if (this.tlQ.tlM.getVisibility() == 0) {
      this.tlQ.tlM.setVisibility(8);
    }
    AppMethodBeat.o(2101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.3
 * JD-Core Version:    0.7.0.1
 */