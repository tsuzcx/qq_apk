package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryFSVideoUI$3
  implements Runnable
{
  TopStoryFSVideoUI$3(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(1954);
    TopStoryFSVideoUI.e(this.tkZ).setVisibility(4);
    TopStoryFSVideoUI.f(this.tkZ).setVisibility(4);
    this.tkZ.tiw.a(0, 3, null);
    if (TopStoryFSVideoUI.g(this.tkZ) != null)
    {
      TopStoryFSVideoUI.g(this.tkZ).dismiss();
      TopStoryFSVideoUI.h(this.tkZ);
    }
    AppMethodBeat.o(1954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.3
 * JD-Core Version:    0.7.0.1
 */