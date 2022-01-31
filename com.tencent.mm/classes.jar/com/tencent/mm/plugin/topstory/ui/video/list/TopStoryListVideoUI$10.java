package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.ProgressDialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;

final class TopStoryListVideoUI$10
  implements Runnable
{
  TopStoryListVideoUI$10(TopStoryListVideoUI paramTopStoryListVideoUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(2110);
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
      TopStoryListVideoUI.a(this.tlQ, this.byh);
      AppMethodBeat.o(2110);
      return;
      TopStoryListVideoUI.c(this.tlQ).setVisibility(4);
      TopStoryListVideoUI.d(this.tlQ).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.10
 * JD-Core Version:    0.7.0.1
 */