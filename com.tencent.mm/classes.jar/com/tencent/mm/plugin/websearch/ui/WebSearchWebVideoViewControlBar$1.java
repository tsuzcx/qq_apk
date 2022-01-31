package com.tencent.mm.plugin.websearch.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class WebSearchWebVideoViewControlBar$1
  implements ap.a
{
  WebSearchWebVideoViewControlBar$1(WebSearchWebVideoViewControlBar paramWebSearchWebVideoViewControlBar) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(73836);
    this.uLz.setVisibility(8);
    WebSearchWebVideoViewControlBar.a(this.uLz).stopTimer();
    AppMethodBeat.o(73836);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.1
 * JD-Core Version:    0.7.0.1
 */