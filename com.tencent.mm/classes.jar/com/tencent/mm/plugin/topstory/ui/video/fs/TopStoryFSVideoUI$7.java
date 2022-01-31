package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.app.ProgressDialog;
import android.view.View;

final class TopStoryFSVideoUI$7
  implements Runnable
{
  TopStoryFSVideoUI$7(TopStoryFSVideoUI paramTopStoryFSVideoUI, String paramString) {}
  
  public final void run()
  {
    TopStoryFSVideoUI.b(this.pHz).setVisibility(4);
    TopStoryFSVideoUI.c(this.pHz).setVisibility(4);
    if (TopStoryFSVideoUI.d(this.pHz) != null)
    {
      TopStoryFSVideoUI.d(this.pHz).dismiss();
      TopStoryFSVideoUI.e(this.pHz);
    }
    TopStoryFSVideoUI.a(this.pHz, this.bhH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.7
 * JD-Core Version:    0.7.0.1
 */