package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class av$b
  implements ap.a
{
  private Runnable gaj;
  
  av$b(Runnable paramRunnable)
  {
    this.gaj = paramRunnable;
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(6805);
    if (this.gaj != null) {
      this.gaj.run();
    }
    AppMethodBeat.o(6805);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.av.b
 * JD-Core Version:    0.7.0.1
 */