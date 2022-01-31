package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class f$1
  implements ap.a
{
  f$1(f paramf) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(1925);
    this.tkJ.setVisibility(8);
    f.a(this.tkJ).stopTimer();
    AppMethodBeat.o(1925);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f.1
 * JD-Core Version:    0.7.0.1
 */