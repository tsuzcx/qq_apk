package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class ak$a$4
  implements ap.a
{
  ak$a$4(ak.a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(27399);
    ak.a.i(this.vLU);
    AppMethodBeat.o(27399);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(27400);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(27400);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak.a.4
 * JD-Core Version:    0.7.0.1
 */