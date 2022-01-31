package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryBaseVideoUI$3
  extends RecyclerView.m
{
  TopStoryBaseVideoUI$3(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1720);
    if ((!this.tiT.tiD) || (paramInt2 == 0))
    {
      AppMethodBeat.o(1720);
      return;
    }
    this.tiT.cJS();
    AppMethodBeat.o(1720);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(1719);
    if (!this.tiT.tiD)
    {
      AppMethodBeat.o(1719);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(1719);
      return;
      if (this.tiT.tiR)
      {
        this.tiT.tiC.b(this.tiT);
        AppMethodBeat.o(1719);
        return;
      }
      this.tiT.tiy.b(this.tiT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.3
 * JD-Core Version:    0.7.0.1
 */