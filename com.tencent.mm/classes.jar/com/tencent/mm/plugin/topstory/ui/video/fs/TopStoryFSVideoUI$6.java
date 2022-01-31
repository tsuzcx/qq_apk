package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.e;

final class TopStoryFSVideoUI$6
  implements Runnable
{
  TopStoryFSVideoUI$6(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(1958);
    i locali = this.tkZ.tkM;
    int i = locali.getFootersCount();
    int j = locali.getItemCount();
    locali.cJy();
    locali.aq(j - i, i);
    AppMethodBeat.o(1958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.6
 * JD-Core Version:    0.7.0.1
 */