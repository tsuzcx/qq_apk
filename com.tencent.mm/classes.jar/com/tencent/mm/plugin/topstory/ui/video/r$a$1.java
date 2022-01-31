package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class r$a$1
  implements Runnable
{
  r$a$1(r.a parama, int paramInt1, int paramInt2, String paramString) {}
  
  public final void run()
  {
    if ((this.pGG.pGD.pGu != null) && (this.pGG.pGD.pEp != null))
    {
      a locala = this.pGG.pGD.pEp.bNt().pGq;
      if ((locala != null) && (locala.pDr == 0L))
      {
        locala.pDr = (System.currentTimeMillis() - locala.pDe);
        locala.pDs = this.ejr;
        locala.pDt = (this.ejr + this.ejs);
        y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(locala.pDr), Integer.valueOf(this.ejr), Integer.valueOf(this.ejs) });
      }
      this.pGG.pGD.pGu.jq(this.ejr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.a.1
 * JD-Core Version:    0.7.0.1
 */