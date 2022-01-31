package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.y;

final class f$6
  implements h.b
{
  f$6(f paramf) {}
  
  public final void bH(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
    f.r(this.pHJ).bOl();
    if (!f.s(this.pHJ)) {
      this.pHJ.bNN();
    }
  }
  
  public final void bI(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.t(this.pHJ).bNr()), Integer.valueOf(f.u(this.pHJ).bNr()) });
    this.pHJ.getListVideoUIComponent().bNx().PO(paramString1);
    if ((this.pHJ.getListVideoUIComponent().bNs().aIq()) || (com.tencent.mm.plugin.topstory.a.g.bNg()))
    {
      this.pHJ.getListVideoUIComponent().bNt().pGp = 1;
      this.pHJ.getListVideoUIComponent().zw(f.v(this.pHJ).bNr() + 1);
    }
    for (;;)
    {
      f.f(this.pHJ).setVisibility(8);
      f.a(this.pHJ, false);
      return;
      this.pHJ.bNQ();
    }
  }
  
  public final void bJ(String paramString1, String paramString2) {}
  
  public final void bK(String paramString1, String paramString2) {}
  
  public final void bL(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
    f.a(this.pHJ, true);
  }
  
  public final void bM(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
    f.a(this.pHJ, false);
    f.f(this.pHJ).setVisibility(8);
    this.pHJ.bNN();
    paramString1 = this.pHJ.getListVideoUIComponent().bNt().pGq;
    if ((paramString1 != null) && (paramString1.pDp == 0L))
    {
      paramString1.pDp = (System.currentTimeMillis() - paramString1.pDe);
      y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramString1.pDm), Long.valueOf(paramString1.pDp) });
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    int i = 0;
    y.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.pHJ.fc(this.pHJ.getContext().getString(b.g.video_error_warnning, new Object[] { paramInt1 + ":" + paramInt2 }), this.pHJ.getContext().getString(b.g.video_retry_play));
    this.pHJ.getListVideoUIComponent().bNx().onError(paramString1);
    h.zu(paramInt1);
    paramString1 = this.pHJ.getListVideoUIComponent().bNt().pGq;
    paramInt2 = i;
    if (paramString1 != null)
    {
      paramInt2 = i;
      if (paramString1.pDe > 0L) {
        paramInt2 = (int)(System.currentTimeMillis() - paramString1.pDe) / 1000;
      }
    }
    h.a(f.n(this.pHJ), paramInt1, paramString3, paramInt2);
    if ((paramInt1 == 403) || (paramInt1 == 405)) {
      f.q(this.pHJ).bNJ().a(f.o(this.pHJ).bNv(), f.p(this.pHJ).bNB());
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.6
 * JD-Core Version:    0.7.0.1
 */