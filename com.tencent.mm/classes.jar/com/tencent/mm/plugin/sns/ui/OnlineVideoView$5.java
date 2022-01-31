package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ak.e;
import com.tencent.mm.h.a.lf;
import com.tencent.mm.h.a.lf.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class OnlineVideoView$5
  extends c<lf>
{
  OnlineVideoView$5(OnlineVideoView paramOnlineVideoView)
  {
    this.udX = lf.class.getName().hashCode();
  }
  
  private boolean a(lf paramlf)
  {
    if (OnlineVideoView.k(this.oRM) == null) {
      y.w("MicroMsg.OnlineVideoView", "%d online video helper is null.", new Object[] { Integer.valueOf(this.oRM.hashCode()) });
    }
    for (;;)
    {
      return false;
      try
      {
        if (OnlineVideoView.k(this.oRM).Pi(paramlf.bUh.bUi)) {
          if (paramlf.bUh.retCode == -21112)
          {
            paramlf = this.oRM;
            h.nFQ.a(354L, 218L, 1L, false);
            paramlf.itx.post(new OnlineVideoView.9(paramlf));
            return false;
          }
        }
      }
      catch (Exception paramlf)
      {
        y.e("MicroMsg.OnlineVideoView", "online video callback error: " + paramlf.toString());
        return false;
      }
    }
    if ((paramlf.bUh.retCode != 0) && (paramlf.bUh.retCode != -21006))
    {
      y.w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(this.oRM.hashCode()), Integer.valueOf(paramlf.bUh.retCode) });
      return false;
    }
    switch (paramlf.bUh.bNb)
    {
    }
    for (;;)
    {
      y.w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", new Object[] { Integer.valueOf(this.oRM.hashCode()), Integer.valueOf(paramlf.bUh.bNb) });
      return false;
      ae localae = OnlineVideoView.k(this.oRM);
      long l2 = paramlf.bUh.offset;
      long l1 = paramlf.bUh.bUj;
      boolean bool = paramlf.bUh.bUk;
      y.i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localae.eFu), localae.eFo, Long.valueOf(l1), Long.valueOf(localae.dmd) });
      if (localae.eFu != 0) {
        y.w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
      }
      for (;;)
      {
        OnlineVideoView.r(this.oRM);
        return false;
        if (l1 > localae.dmd) {}
        for (;;)
        {
          for (;;)
          {
            localae.dmd = l1;
            localae.oRU = bk.UY();
            try
            {
              if (localae.eFt != null) {
                break label480;
              }
              y.w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
            }
            catch (Exception paramlf)
            {
              y.e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + paramlf.toString());
            }
          }
          break;
          l1 = localae.dmd;
        }
        label480:
        if (localae.eFt.t(localae.eFp, l2))
        {
          localae.eFu = localae.eFt.eUz;
          y.i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localae.eFu), localae.eFo, Boolean.valueOf(bool) });
          if (!bool) {
            ai.d(new ae.1(localae));
          }
          if (localae.eFv == -1) {}
          for (localae.eFs = 1;; localae.eFs = 2)
          {
            h.nFQ.a(354L, 204L, 1L, false);
            break;
          }
        }
        y.w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", new Object[] { localae.eFo });
        o.Ss();
        e.h(localae.eFo, 0, -1);
        h.nFQ.a(354L, 205L, 1L, false);
        h.nFQ.f(13836, new Object[] { Integer.valueOf(402), Long.valueOf(bk.UX()), "" });
      }
      localae = OnlineVideoView.k(this.oRM);
      Object localObject = paramlf.bUh.bUi;
      int i = paramlf.bUh.offset;
      int j = paramlf.bUh.length;
      localae.eFB = false;
      if ((i < 0) || (j < 0)) {
        y.w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      while (!localae.Pi((String)localObject))
      {
        if (paramlf.bUh.length <= 0) {
          break;
        }
        this.oRM.ce(true);
        return false;
      }
      localObject = localae.eFo + i + "_" + j;
      localObject = (Integer)localae.oRQ.get(localObject);
      if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
        localae.eFy = ((Integer)localObject).intValue();
      }
      for (;;)
      {
        y.i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localae.eFy) });
        break;
        try
        {
          localae.eFy = localae.eFt.bE(i, j);
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + localException.toString());
        }
      }
      this.oRM.ce(true);
      return false;
      y.i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(this.oRM.hashCode()), paramlf.bUh.bUi, Integer.valueOf(OnlineVideoView.s(this.oRM)), Integer.valueOf(OnlineVideoView.t(this.oRM)) });
      paramlf = OnlineVideoView.k(this.oRM);
      y.i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramlf.eFs), paramlf.eFo });
      paramlf.eFB = false;
      paramlf.eFr = 3;
      h.nFQ.a(354L, 206L, 1L, false);
      if (paramlf.eFs == 0)
      {
        y.w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
        paramlf.bHV();
      }
      while (OnlineVideoView.s(this.oRM) > 0)
      {
        OnlineVideoView.n(this.oRM);
        OnlineVideoView.b(this.oRM, OnlineVideoView.s(this.oRM));
        return false;
        if (paramlf.eFs == 5)
        {
          y.w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + paramlf.eFo);
          paramlf.bHV();
        }
      }
      if (OnlineVideoView.t(this.oRM) > 0)
      {
        OnlineVideoView.n(this.oRM);
        OnlineVideoView.b(this.oRM, OnlineVideoView.t(this.oRM), OnlineVideoView.u(this.oRM));
        return false;
      }
      if (OnlineVideoView.v(this.oRM))
      {
        OnlineVideoView.n(this.oRM);
        OnlineVideoView.w(this.oRM);
        return false;
      }
      this.oRM.ce(true);
      return false;
      if (OnlineVideoView.j(this.oRM) == 1)
      {
        localae = OnlineVideoView.k(this.oRM);
        String str = paramlf.bUh.bUi;
        i = paramlf.bUh.offset;
        j = paramlf.bUh.length;
        if (localae.Pi(str))
        {
          localae.progress = i;
          localae.total = j;
          localae.oRS = (localae.progress * 100 / localae.total);
          y.i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localae.eFo, Integer.valueOf(localae.progress), Integer.valueOf(localae.total), Integer.valueOf(localae.oRS) });
        }
        if (localae.oRS < 100) {
          break;
        }
        localae.eFr = 3;
        return false;
      }
      if (OnlineVideoView.j(this.oRM) != 2) {
        break;
      }
      OnlineVideoView.a(this.oRM, paramlf.bUh.offset, paramlf.bUh.length);
      return false;
      paramlf = OnlineVideoView.k(this.oRM);
      y.i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", new Object[] { paramlf.eFo });
      paramlf.bHV();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.5
 * JD-Core Version:    0.7.0.1
 */