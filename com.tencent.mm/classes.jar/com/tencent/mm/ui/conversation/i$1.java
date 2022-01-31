package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class i$1
  implements ap.a
{
  i$1(i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(34397);
    if (i.a(this.AkC)) {
      i.b(this.AkC);
    }
    AppMethodBeat.o(34397);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i.1
 * JD-Core Version:    0.7.0.1
 */