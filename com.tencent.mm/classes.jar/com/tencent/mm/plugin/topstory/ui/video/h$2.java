package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class h$2
  implements u.g
{
  h$2(h paramh) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(126073);
    params.bx(0, c.g.video_share_to_friend, c.f.bottomsheet_icon_transmit);
    params.bx(1, c.g.video_share_to_sns, c.f.bottomsheet_icon_moment);
    AppMethodBeat.o(126073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.2
 * JD-Core Version:    0.7.0.1
 */