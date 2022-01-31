package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.sdk.platformtools.y;

final class FtsWebVideoView$4
  implements b
{
  FtsWebVideoView$4(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void akz()
  {
    y.i("MicroMsg.FtsWebVideoView", "onSeekPre");
    FtsWebVideoView.c(this.raW).bOy();
  }
  
  public final void lE(int paramInt)
  {
    y.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramInt) });
    this.raW.D(paramInt, false);
    FtsWebVideoView.c(this.raW).akG();
    if (FtsWebVideoView.h(this.raW) != null) {
      FtsWebVideoView.h(this.raW).caP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.4
 * JD-Core Version:    0.7.0.1
 */