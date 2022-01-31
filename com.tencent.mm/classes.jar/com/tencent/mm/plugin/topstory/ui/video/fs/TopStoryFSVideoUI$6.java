package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class TopStoryFSVideoUI$6
  implements Runnable
{
  TopStoryFSVideoUI$6(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final void run()
  {
    TopStoryFSVideoUI.b(this.pHz).setVisibility(4);
    TopStoryFSVideoUI.c(this.pHz).setVisibility(4);
    this.pHz.pFa.smoothScrollBy(0, 3);
    if (TopStoryFSVideoUI.d(this.pHz) != null)
    {
      TopStoryFSVideoUI.d(this.pHz).dismiss();
      TopStoryFSVideoUI.e(this.pHz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.6
 * JD-Core Version:    0.7.0.1
 */