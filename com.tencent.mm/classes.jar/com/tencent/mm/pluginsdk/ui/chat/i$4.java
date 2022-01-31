package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.o;

final class i$4
  implements ap.a
{
  i$4(i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(27959);
    i locali = this.vYT;
    if (locali.vYP != null) {
      locali.vYP.dismiss();
    }
    AppMethodBeat.o(27959);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i.4
 * JD-Core Version:    0.7.0.1
 */