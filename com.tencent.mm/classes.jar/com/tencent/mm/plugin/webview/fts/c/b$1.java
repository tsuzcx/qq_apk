package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements a
{
  b$1(b paramb, FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void ajc()
  {
    FtsWebVideoView localFtsWebVideoView = this.rbn;
    y.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
    if (localFtsWebVideoView.raC.gEh) {
      localFtsWebVideoView.raC.aiZ();
    }
    localFtsWebVideoView.dt(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b.1
 * JD-Core Version:    0.7.0.1
 */