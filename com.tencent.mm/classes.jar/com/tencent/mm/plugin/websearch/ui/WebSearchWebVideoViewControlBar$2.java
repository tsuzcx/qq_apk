package com.tencent.mm.plugin.websearch.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

public final class WebSearchWebVideoViewControlBar$2
  implements ap.a
{
  public WebSearchWebVideoViewControlBar$2(WebSearchWebVideoViewControlBar paramWebSearchWebVideoViewControlBar) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(73837);
    if (!WebSearchWebVideoViewControlBar.b(this.uLz))
    {
      AppMethodBeat.o(73837);
      return false;
    }
    AppMethodBeat.o(73837);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.2
 * JD-Core Version:    0.7.0.1
 */