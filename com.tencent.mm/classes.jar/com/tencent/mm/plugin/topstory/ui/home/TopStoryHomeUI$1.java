package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class TopStoryHomeUI$1
  implements Runnable
{
  TopStoryHomeUI$1(TopStoryHomeUI paramTopStoryHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(1554);
    ab.i("MicroMsg.TopStory.TopStoryHomeUI", " finish");
    TopStoryHomeUI.a(this.tfY);
    AppMethodBeat.o(1554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryHomeUI.1
 * JD-Core Version:    0.7.0.1
 */