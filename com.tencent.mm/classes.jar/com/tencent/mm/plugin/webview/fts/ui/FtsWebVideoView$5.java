package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;

final class FtsWebVideoView$5
  implements View.OnClickListener
{
  FtsWebVideoView$5(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void onClick(View paramView)
  {
    if (FtsWebVideoView.d(this.raW).isPlaying())
    {
      FtsWebVideoView.c(this.raW).bOy();
      this.raW.pause();
      return;
    }
    FtsWebVideoView.c(this.raW).akG();
    this.raW.eg(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.5
 * JD-Core Version:    0.7.0.1
 */