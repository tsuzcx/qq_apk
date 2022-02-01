package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class TopStoryBaseVideoUI$7
  implements u.g
{
  TopStoryBaseVideoUI$7(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(126084);
    params.clear();
    params.oh(2, c.g.enter_multi_task);
    AppMethodBeat.o(126084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.7
 * JD-Core Version:    0.7.0.1
 */