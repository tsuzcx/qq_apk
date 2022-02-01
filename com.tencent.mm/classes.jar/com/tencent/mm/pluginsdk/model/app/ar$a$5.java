package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class ar$a$5
  implements MTimerHandler.CallBack
{
  ar$a$5(ar.a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(244883);
    ar.a.j(this.XTr);
    AppMethodBeat.o(244883);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(244885);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(244885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ar.a.5
 * JD-Core Version:    0.7.0.1
 */