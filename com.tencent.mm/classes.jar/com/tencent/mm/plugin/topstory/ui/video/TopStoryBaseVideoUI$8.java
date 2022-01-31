package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryBaseVideoUI$8
  implements Runnable
{
  TopStoryBaseVideoUI$8(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  private static void a(e parame)
  {
    AppMethodBeat.i(1728);
    int i = parame.getFootersCount();
    int j = parame.getItemCount();
    parame.cJy();
    parame.aq(j - i, i);
    AppMethodBeat.o(1728);
  }
  
  public final void run()
  {
    AppMethodBeat.i(1727);
    a(this.tiT.tix);
    a(this.tiT.tiB);
    AppMethodBeat.o(1727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.8
 * JD-Core Version:    0.7.0.1
 */