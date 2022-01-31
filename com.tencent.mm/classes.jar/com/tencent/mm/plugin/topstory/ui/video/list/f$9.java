package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.ab;

final class f$9
  implements View.OnClickListener
{
  f$9(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2052);
    if (this.tlr.getListVideoUIComponent().cJh().tjS)
    {
      if (f.g(this.tlr).getVideoTotalTime() - f.g(this.tlr).getmPosition() < 2)
      {
        ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
        AppMethodBeat.o(2052);
        return;
      }
      this.tlr.getListVideoUIComponent().cJd().g(f.P(this.tlr));
      if (this.tlr.getListVideoUIComponent().cJh().cKj())
      {
        this.tlr.getListVideoUIComponent().cJh().crn();
        f.g(this.tlr).baj();
      }
      for (;;)
      {
        this.tlr.cJB();
        AppMethodBeat.o(2052);
        return;
        this.tlr.getListVideoUIComponent().cJh().ctY();
        f.g(this.tlr).aFn();
      }
    }
    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
    AppMethodBeat.o(2052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.9
 * JD-Core Version:    0.7.0.1
 */