package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;

final class TopStoryListVideoUI$4
  implements Runnable
{
  TopStoryListVideoUI$4(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final void run()
  {
    if (!this.pId.pFu)
    {
      TopStoryListVideoUI.a(this.pId).setVisibility(4);
      TopStoryListVideoUI.b(this.pId).setVisibility(4);
    }
    for (;;)
    {
      if (TopStoryListVideoUI.f(this.pId) != null)
      {
        TopStoryListVideoUI.f(this.pId).dismiss();
        TopStoryListVideoUI.g(this.pId);
      }
      return;
      TopStoryListVideoUI.c(this.pId).setVisibility(4);
      TopStoryListVideoUI.d(this.pId).setVisibility(4);
      TopStoryListVideoUI.e(this.pId).smoothScrollBy(0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.4
 * JD-Core Version:    0.7.0.1
 */