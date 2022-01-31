package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.h;

final class TopStoryFSVideoUI$5$1
  implements Runnable
{
  TopStoryFSVideoUI$5$1(TopStoryFSVideoUI.5 param5, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(1956);
    h localh = this.tla.tkZ.cJm().b(this.tiX.tfm);
    if ((localh != null) && ((localh instanceof g))) {
      ((f)localh.cJM().getControlBar()).i(this.tiX.tfm);
    }
    AppMethodBeat.o(1956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.5.1
 * JD-Core Version:    0.7.0.1
 */