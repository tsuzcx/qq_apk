package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;

final class TopStoryListVideoUI$9
  implements Runnable
{
  TopStoryListVideoUI$9(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(2109);
    if (!this.tlQ.tiR)
    {
      TopStoryListVideoUI.a(this.tlQ).setVisibility(4);
      TopStoryListVideoUI.b(this.tlQ).setVisibility(4);
    }
    for (;;)
    {
      if (TopStoryListVideoUI.f(this.tlQ) != null)
      {
        TopStoryListVideoUI.f(this.tlQ).dismiss();
        TopStoryListVideoUI.g(this.tlQ);
      }
      AppMethodBeat.o(2109);
      return;
      TopStoryListVideoUI.c(this.tlQ).setVisibility(4);
      TopStoryListVideoUI.d(this.tlQ).setVisibility(4);
      TopStoryListVideoUI.e(this.tlQ).a(0, 3, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.9
 * JD-Core Version:    0.7.0.1
 */