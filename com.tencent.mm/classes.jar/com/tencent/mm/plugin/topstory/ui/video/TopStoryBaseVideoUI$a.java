package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class TopStoryBaseVideoUI$a
  extends v
{
  private TopStoryBaseVideoUI$a(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void E(RecyclerView.v paramv)
  {
    AppMethodBeat.i(1729);
    super.E(paramv);
    this.tiT.cJS();
    this.tiT.tiy.b(this.tiT);
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramv.jN()) });
    AppMethodBeat.o(1729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.a
 * JD-Core Version:    0.7.0.1
 */