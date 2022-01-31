package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;

final class TopStoryBaseVideoUI$3
  extends RecyclerView.m
{
  TopStoryBaseVideoUI$3(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((!this.pFv.pFh) || (paramInt2 == 0)) {
      return;
    }
    this.pFv.bOf();
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    if (!this.pFv.pFh) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.pFv.pFu)
    {
      this.pFv.pFg.b(this.pFv);
      return;
    }
    this.pFv.pFc.b(this.pFv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.3
 * JD-Core Version:    0.7.0.1
 */