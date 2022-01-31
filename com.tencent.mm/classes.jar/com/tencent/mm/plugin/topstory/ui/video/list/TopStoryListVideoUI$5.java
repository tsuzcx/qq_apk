package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.ProgressDialog;
import android.view.View;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;

final class TopStoryListVideoUI$5
  implements Runnable
{
  TopStoryListVideoUI$5(TopStoryListVideoUI paramTopStoryListVideoUI, String paramString) {}
  
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
      TopStoryListVideoUI.a(this.pId, this.bhH);
      return;
      TopStoryListVideoUI.c(this.pId).setVisibility(4);
      TopStoryListVideoUI.d(this.pId).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.5
 * JD-Core Version:    0.7.0.1
 */