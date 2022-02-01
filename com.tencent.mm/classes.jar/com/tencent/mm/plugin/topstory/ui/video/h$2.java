package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class h$2
  implements q.f
{
  h$2(h paramh) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(126073);
    paramo.aW(0, c.g.video_share_to_friend, c.f.bottomsheet_icon_transmit);
    paramo.aW(1, c.g.video_share_to_sns, c.f.bottomsheet_icon_moment);
    AppMethodBeat.o(126073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.2
 * JD-Core Version:    0.7.0.1
 */