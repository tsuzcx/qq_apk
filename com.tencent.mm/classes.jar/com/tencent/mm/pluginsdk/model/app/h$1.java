package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.Map;

final class h$1
  implements ap.a
{
  h$1(h paramh) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(79299);
    this.vLj.hqI.clear();
    AppMethodBeat.o(79299);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.h.1
 * JD-Core Version:    0.7.0.1
 */