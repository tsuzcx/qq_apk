package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class TopStoryBaseVideoUI$6
  implements Runnable
{
  TopStoryBaseVideoUI$6(TopStoryBaseVideoUI paramTopStoryBaseVideoUI, List paramList, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(1724);
    if (this.tiT.tiR)
    {
      this.tiT.tiB.l(this.tiV, this.tiW);
      this.tiT.tix.ajb.notifyChanged();
      AppMethodBeat.o(1724);
      return;
    }
    this.tiT.tix.l(this.tiV, this.tiW);
    this.tiT.tiB.ajb.notifyChanged();
    AppMethodBeat.o(1724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.6
 * JD-Core Version:    0.7.0.1
 */