package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements h.b
{
  e$2(e parame) {}
  
  public final void bH(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
    e.x(this.pGX).bOl();
    if (!e.y(this.pGX)) {
      this.pGX.bNN();
    }
  }
  
  public final void bI(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded");
    this.pGX.getFSVideoUIComponent().bNx().PO(paramString1);
    if ((this.pGX.getFSVideoUIComponent().bNs().aIq()) || (g.bNg()))
    {
      this.pGX.getFSVideoUIComponent().bNt().pGp = 1;
      this.pGX.getFSVideoUIComponent().zw(e.z(this.pGX).bNr() + 1);
    }
    for (;;)
    {
      e.l(this.pGX).setVisibility(8);
      e.a(this.pGX, false);
      return;
      this.pGX.bNQ();
    }
  }
  
  public final void bJ(String paramString1, String paramString2) {}
  
  public final void bK(String paramString1, String paramString2) {}
  
  public final void bL(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
    e.a(this.pGX, true);
  }
  
  public final void bM(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
    e.a(this.pGX, false);
    e.l(this.pGX).setVisibility(8);
    this.pGX.bNN();
    paramString1 = this.pGX.getFSVideoUIComponent().bNt().pGq;
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
    this.pGX.fc(this.pGX.getContext().getString(b.g.video_error_warnning, new Object[] { paramInt1 + ":" + paramInt2 }), this.pGX.getContext().getString(b.g.video_retry_play));
    this.pGX.getFSVideoUIComponent().bNx().onError(paramString1);
    h.zu(paramInt1);
    paramString1 = this.pGX.getFSVideoUIComponent().bNt().pGq;
    paramInt2 = i;
    if (paramString1 != null)
    {
      paramInt2 = i;
      if (paramString1.pDe > 0L) {
        paramInt2 = (int)(System.currentTimeMillis() - paramString1.pDe) / 1000;
      }
    }
    h.a(e.t(this.pGX), paramInt1, paramString3, paramInt2);
    if ((paramInt1 == 403) || (paramInt1 == 405)) {
      e.w(this.pGX).bNJ().a(e.u(this.pGX).bNv(), e.v(this.pGX).bNB());
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.2
 * JD-Core Version:    0.7.0.1
 */