package com.tencent.mm.plugin.topstory.ui.video.list;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class g$1
  implements ap.a
{
  g$1(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(2075);
    this.tlv.setVisibility(8);
    g.a(this.tlv).stopTimer();
    AppMethodBeat.o(2075);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g.1
 * JD-Core Version:    0.7.0.1
 */