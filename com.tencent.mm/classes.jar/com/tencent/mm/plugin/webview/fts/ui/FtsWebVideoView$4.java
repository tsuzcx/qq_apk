package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.sdk.platformtools.ab;

final class FtsWebVideoView$4
  implements b
{
  FtsWebVideoView$4(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void aFf()
  {
    AppMethodBeat.i(5826);
    ab.i("MicroMsg.FtsWebVideoView", "onSeekPre");
    FtsWebVideoView.c(this.uQE).baj();
    AppMethodBeat.o(5826);
  }
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(5827);
    ab.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramInt) });
    this.uQE.at(paramInt, false);
    FtsWebVideoView.c(this.uQE).aFn();
    if (FtsWebVideoView.h(this.uQE) != null) {
      FtsWebVideoView.h(this.uQE).daP();
    }
    AppMethodBeat.o(5827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.4
 * JD-Core Version:    0.7.0.1
 */