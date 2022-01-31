package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.ab;

final class e$7
  implements View.OnClickListener
{
  e$7(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1892);
    if (this.tkq.getFSVideoUIComponent().cJh().tjS)
    {
      if ((!(this.tkq.tkg instanceof l)) && (this.tkq.tkg.getVideoTotalTime() - this.tkq.tkg.getmPosition() < 2))
      {
        ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
        AppMethodBeat.o(1892);
        return;
      }
      this.tkq.getFSVideoUIComponent().cJd().g(e.P(this.tkq));
      if (this.tkq.getFSVideoUIComponent().cJh().cKj())
      {
        this.tkq.getFSVideoUIComponent().cJh().crn();
        this.tkq.tkg.baj();
      }
      for (;;)
      {
        this.tkq.cJB();
        AppMethodBeat.o(1892);
        return;
        this.tkq.getFSVideoUIComponent().cJh().ctY();
        this.tkq.tkg.aFn();
      }
    }
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
    AppMethodBeat.o(1892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.7
 * JD-Core Version:    0.7.0.1
 */