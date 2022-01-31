package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class e$3
  implements h.b
{
  e$3(e parame) {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(1880);
    ab.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString2 = e.v(this.tkq).cJs().GI(e.u(this.tkq).cJk());
    if ((paramString2 != null) && (paramString2.xVj != null))
    {
      ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramString2.xVj.size()), paramString2.videoUrl, Integer.valueOf(paramString2.xVo) });
      int i = 0;
      while (i < paramString2.xVj.size())
      {
        ckz localckz = (ckz)paramString2.xVj.get(i);
        if (paramString2.videoUrl.equals(localckz.url))
        {
          if (i + 1 >= paramString2.xVj.size()) {
            break;
          }
          i += 1;
          localckz = (ckz)paramString2.xVj.get(i);
          if ((localckz == null) || (bo.isNullOrNil(localckz.url))) {
            break;
          }
          paramString2.xVo = localckz.xVo;
          paramString2.videoUrl = localckz.url;
          ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localckz.url, Integer.valueOf(localckz.xVo) });
          com.tencent.mm.plugin.websearch.api.a.b.kS(com.tencent.mm.plugin.websearch.api.a.b.uLh);
          this.tkq.postDelayed(new e.3.1(this), 100L);
          AppMethodBeat.o(1880);
          return;
        }
        i += 1;
      }
    }
    e.y(this.tkq).cJs().a(e.w(this.tkq).cJf(), e.x(this.tkq).cJk());
    this.tkq.gT(this.tkq.getContext().getString(2131304511, new Object[] { paramInt1 + ":" + paramInt2 }), this.tkq.getContext().getString(2131304536));
    this.tkq.getFSVideoUIComponent().cJh().onError(paramString1);
    com.tencent.mm.plugin.topstory.a.h.Gw(paramInt1);
    paramString1 = this.tkq.getFSVideoUIComponent().cJd().tjL;
    paramInt2 = j;
    if (paramString1 != null)
    {
      paramInt2 = j;
      if (paramString1.teT > 0L) {
        paramInt2 = (int)(System.currentTimeMillis() - paramString1.teT) / 1000;
      }
    }
    com.tencent.mm.plugin.topstory.a.h.a(paramString2, paramInt1, paramString3, paramInt2);
    AppMethodBeat.o(1880);
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1881);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
    this.tkq.tkh.aFG();
    if (!e.z(this.tkq)) {
      this.tkq.cJB();
    }
    AppMethodBeat.o(1881);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1882);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
    this.tkq.getFSVideoUIComponent().cJh().aeq(paramString1);
    this.tkq.getFSVideoUIComponent().cJd().tjK = 1;
    int i = this.tkq.getFSVideoUIComponent().cJw();
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", new Object[] { Integer.valueOf(i) });
    if ((i == 1) && (this.tkq.getFSVideoUIComponent().cJn()) && ((e.A(this.tkq) instanceof j))) {}
    try
    {
      Thread.sleep(100L);
      ((j)e.B(this.tkq)).mA(true);
      ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "VVideoAutoPlay replay succ");
      bool = true;
      if ((bool) || (!(e.D(this.tkq) instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {}
    }
    catch (InterruptedException paramString1)
    {
      try
      {
        for (;;)
        {
          Thread.sleep(100L);
          label166:
          ((com.tencent.mm.plugin.topstory.ui.video.h)e.E(this.tkq)).mA(true);
          e.a(this.tkq, false);
          AppMethodBeat.o(1882);
          return;
          boolean bool = this.tkq.getFSVideoUIComponent().Gz(e.C(this.tkq).cJb() + 1);
        }
        paramString1 = paramString1;
      }
      catch (InterruptedException paramString1)
      {
        break label166;
      }
    }
  }
  
  public final void cs(String paramString1, String paramString2) {}
  
  public final void ct(String paramString1, String paramString2) {}
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1884);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
    e.a(this.tkq, true);
    AppMethodBeat.o(1884);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(1885);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
    e.a(this.tkq, false);
    this.tkq.cJB();
    paramString1 = this.tkq.getFSVideoUIComponent().cJd().tjL;
    if ((paramString1 != null) && (paramString1.tfe == 0L))
    {
      paramString1.tfe = (System.currentTimeMillis() - paramString1.teT);
      ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramString1.tfb), Long.valueOf(paramString1.tfe) });
    }
    AppMethodBeat.o(1885);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1883);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(1883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.3
 * JD-Core Version:    0.7.0.1
 */