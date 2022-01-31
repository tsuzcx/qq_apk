package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.y;

final class e$5
  implements View.OnClickListener
{
  e$5(e parame) {}
  
  public final void onClick(View paramView)
  {
    if (this.pGX.getFSVideoUIComponent().bNx().pGx)
    {
      if ((!(e.l(this.pGX) instanceof k)) && (e.l(this.pGX).getVideoTotalTime() - e.l(this.pGX).getmPosition() < 2))
      {
        y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
        return;
      }
      this.pGX.getFSVideoUIComponent().bNt().c(e.K(this.pGX));
      if (this.pGX.getFSVideoUIComponent().bNx().bOu())
      {
        this.pGX.getFSVideoUIComponent().bNx().bFy();
        e.l(this.pGX).bOy();
      }
      for (;;)
      {
        this.pGX.bNN();
        return;
        this.pGX.getFSVideoUIComponent().bNx().bMs();
        e.l(this.pGX).akG();
      }
    }
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.5
 * JD-Core Version:    0.7.0.1
 */