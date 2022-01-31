package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements a
{
  b$1(b paramb, FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void aDk()
  {
    AppMethodBeat.i(5929);
    FtsWebVideoView localFtsWebVideoView = this.uQV;
    ab.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
    if (localFtsWebVideoView.uQj.idm) {
      localFtsWebVideoView.uQj.aDh();
    }
    localFtsWebVideoView.ey(false);
    AppMethodBeat.o(5929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b.1
 * JD-Core Version:    0.7.0.1
 */