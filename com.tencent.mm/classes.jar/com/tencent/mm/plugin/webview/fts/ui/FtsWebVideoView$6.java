package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.a;

final class FtsWebVideoView$6
  implements WebSearchWebVideoViewControlBar.a
{
  FtsWebVideoView$6(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final int aEV()
  {
    AppMethodBeat.i(5829);
    int i = FtsWebVideoView.d(this.uQE).getCacheTimeSec();
    AppMethodBeat.o(5829);
    return i;
  }
  
  public final int aEW()
  {
    AppMethodBeat.i(5830);
    int i = FtsWebVideoView.d(this.uQE).getVideoDurationSec();
    AppMethodBeat.o(5830);
    return i;
  }
  
  public final int cZZ()
  {
    AppMethodBeat.i(5831);
    int i = FtsWebVideoView.d(this.uQE).getCurrPosMs();
    AppMethodBeat.o(5831);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.6
 * JD-Core Version:    0.7.0.1
 */