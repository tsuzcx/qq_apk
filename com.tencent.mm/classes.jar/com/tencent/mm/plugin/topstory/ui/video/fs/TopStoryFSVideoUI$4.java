package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.app.ProgressDialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryFSVideoUI$4
  implements Runnable
{
  TopStoryFSVideoUI$4(TopStoryFSVideoUI paramTopStoryFSVideoUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(1955);
    TopStoryFSVideoUI.e(this.tkZ).setVisibility(4);
    TopStoryFSVideoUI.f(this.tkZ).setVisibility(4);
    if (TopStoryFSVideoUI.g(this.tkZ) != null)
    {
      TopStoryFSVideoUI.g(this.tkZ).dismiss();
      TopStoryFSVideoUI.h(this.tkZ);
    }
    TopStoryFSVideoUI.a(this.tkZ, this.byh);
    AppMethodBeat.o(1955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.4
 * JD-Core Version:    0.7.0.1
 */