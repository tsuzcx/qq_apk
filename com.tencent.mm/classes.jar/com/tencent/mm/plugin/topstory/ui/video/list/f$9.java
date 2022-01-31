package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.y;

final class f$9
  implements View.OnClickListener
{
  f$9(f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (this.pHJ.getListVideoUIComponent().bNx().pGx)
    {
      if (f.f(this.pHJ).getVideoTotalTime() - f.f(this.pHJ).getmPosition() < 2)
      {
        y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
        return;
      }
      this.pHJ.getListVideoUIComponent().bNt().c(f.G(this.pHJ));
      if (this.pHJ.getListVideoUIComponent().bNx().bOu())
      {
        this.pHJ.getListVideoUIComponent().bNx().bFy();
        f.f(this.pHJ).bOy();
      }
      for (;;)
      {
        this.pHJ.bNN();
        return;
        this.pHJ.getListVideoUIComponent().bNx().bMs();
        f.f(this.pHJ).akG();
      }
    }
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.9
 * JD-Core Version:    0.7.0.1
 */