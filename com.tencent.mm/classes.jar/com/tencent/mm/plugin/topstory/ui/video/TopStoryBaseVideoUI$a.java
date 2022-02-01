package com.tencent.mm.plugin.topstory.ui.video;

import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class TopStoryBaseVideoUI$a
  extends f
{
  private TopStoryBaseVideoUI$a(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void D(RecyclerView.v paramv)
  {
    AppMethodBeat.i(271793);
    super.D(paramv);
    this.TMz.hOn();
    this.TMz.TLZ.b(this.TMz);
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramv.KJ()) });
    AppMethodBeat.o(271793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.a
 * JD-Core Version:    0.7.0.1
 */