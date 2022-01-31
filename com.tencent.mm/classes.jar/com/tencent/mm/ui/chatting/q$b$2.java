package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.o;

final class q$b$2
  implements ap.a
{
  q$b$2(q.b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(30697);
    if ((q.b.d(this.zzO) != null) && (q.b.e(this.zzO) != null)) {
      q.b.e(this.zzO).showAsDropDown(q.b.d(this.zzO), q.b.f(this.zzO), q.b.g(this.zzO));
    }
    AppMethodBeat.o(30697);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.b.2
 * JD-Core Version:    0.7.0.1
 */