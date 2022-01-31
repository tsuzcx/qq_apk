package com.tencent.mm.plugin.topstory.ui.video.list;

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

final class f$6
  implements h.b
{
  f$6(f paramf) {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(2041);
    ab.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 0)
    {
      paramString2 = f.p(this.tlr).cJs().GI(f.o(this.tlr).cJk());
      if ((paramString2 != null) && (paramString2.xVj != null))
      {
        ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramString2.xVj.size()), paramString2.videoUrl, Integer.valueOf(paramString2.xVo) });
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
            ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localckz.url, Integer.valueOf(localckz.xVo) });
            com.tencent.mm.plugin.websearch.api.a.b.kS(com.tencent.mm.plugin.websearch.api.a.b.uLh);
            this.tlr.postDelayed(new f.6.1(this), 100L);
            AppMethodBeat.o(2041);
            return;
          }
          i += 1;
        }
      }
    }
    f.s(this.tlr).cJs().a(f.q(this.tlr).cJf(), f.r(this.tlr).cJk());
    this.tlr.gT(this.tlr.getContext().getString(2131304511, new Object[] { paramInt1 + ":" + paramInt2 }), this.tlr.getContext().getString(2131304536));
    this.tlr.getListVideoUIComponent().cJh().onError(paramString1);
    com.tencent.mm.plugin.topstory.a.h.Gw(paramInt1);
    paramString1 = this.tlr.getListVideoUIComponent().cJd().tjL;
    paramInt2 = j;
    if (paramString1 != null)
    {
      paramInt2 = j;
      if (paramString1.teT > 0L) {
        paramInt2 = (int)(System.currentTimeMillis() - paramString1.teT) / 1000;
      }
    }
    com.tencent.mm.plugin.topstory.a.h.a(f.t(this.tlr), paramInt1, paramString3, paramInt2);
    AppMethodBeat.o(2041);
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2042);
    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
    f.u(this.tlr).aFG();
    if (!f.v(this.tlr)) {
      this.tlr.cJB();
    }
    AppMethodBeat.o(2042);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2043);
    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.w(this.tlr).cJb()), Integer.valueOf(f.x(this.tlr).cJb()) });
    this.tlr.getListVideoUIComponent().cJh().aeq(paramString1);
    this.tlr.getListVideoUIComponent().cJd().tjK = 1;
    if ((!this.tlr.getListVideoUIComponent().Gz(f.y(this.tlr).cJb() + 1)) && ((f.z(this.tlr) instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {}
    try
    {
      Thread.sleep(100L);
      label134:
      ((com.tencent.mm.plugin.topstory.ui.video.h)f.A(this.tlr)).mA(true);
      f.g(this.tlr).setVisibility(8);
      f.a(this.tlr, false);
      AppMethodBeat.o(2043);
      return;
    }
    catch (InterruptedException paramString1)
    {
      break label134;
    }
  }
  
  public final void cs(String paramString1, String paramString2) {}
  
  public final void ct(String paramString1, String paramString2) {}
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2045);
    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
    f.a(this.tlr, true);
    AppMethodBeat.o(2045);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2046);
    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
    f.a(this.tlr, false);
    f.g(this.tlr).setVisibility(8);
    this.tlr.cJB();
    paramString1 = this.tlr.getListVideoUIComponent().cJd().tjL;
    if ((paramString1 != null) && (paramString1.tfe == 0L))
    {
      paramString1.tfe = (System.currentTimeMillis() - paramString1.teT);
      ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramString1.tfb), Long.valueOf(paramString1.tfe) });
    }
    AppMethodBeat.o(2046);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2044);
    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(2044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.6
 * JD-Core Version:    0.7.0.1
 */