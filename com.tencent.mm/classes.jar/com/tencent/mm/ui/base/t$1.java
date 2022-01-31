package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class t$1
  implements ap.a
{
  t$1(t paramt) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(106870);
    if (t.a(this.zmY) == -1L)
    {
      this.zmY.show();
      AppMethodBeat.o(106870);
      return true;
    }
    t.b(this.zmY);
    if (t.c(this.zmY) >= 0)
    {
      this.zmY.show();
      AppMethodBeat.o(106870);
      return true;
    }
    this.zmY.cancel();
    AppMethodBeat.o(106870);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.t.1
 * JD-Core Version:    0.7.0.1
 */