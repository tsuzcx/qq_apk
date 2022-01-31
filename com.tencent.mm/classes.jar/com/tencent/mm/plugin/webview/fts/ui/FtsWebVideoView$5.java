package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;

final class FtsWebVideoView$5
  implements View.OnClickListener
{
  FtsWebVideoView$5(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(5828);
    if (FtsWebVideoView.d(this.uQE).isPlaying())
    {
      FtsWebVideoView.c(this.uQE).baj();
      this.uQE.pause();
      AppMethodBeat.o(5828);
      return;
    }
    FtsWebVideoView.c(this.uQE).aFn();
    this.uQE.start(true);
    AppMethodBeat.o(5828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.5
 * JD-Core Version:    0.7.0.1
 */