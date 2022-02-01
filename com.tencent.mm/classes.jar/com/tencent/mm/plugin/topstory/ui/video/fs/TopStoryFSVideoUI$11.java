package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryFSVideoUI$11
  implements Runnable
{
  TopStoryFSVideoUI$11(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(126346);
    if (this.TOI.TOC.getVisibility() == 0) {
      this.TOI.TOC.setVisibility(8);
    }
    AppMethodBeat.o(126346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.11
 * JD-Core Version:    0.7.0.1
 */