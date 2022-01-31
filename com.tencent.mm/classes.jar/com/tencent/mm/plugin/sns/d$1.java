package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ap.a;

final class d$1
  implements ap.a
{
  d$1(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(35603);
    pl localpl = new pl();
    localpl.cFY.cxq = null;
    a.ymk.l(localpl);
    AppMethodBeat.o(35603);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d.1
 * JD-Core Version:    0.7.0.1
 */