package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lu.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class OnlineVideoView$5
  extends c<lu>
{
  OnlineVideoView$5(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(38392);
    this.__eventId = lu.class.getName().hashCode();
    AppMethodBeat.o(38392);
  }
  
  private boolean a(lu paramlu)
  {
    AppMethodBeat.i(38393);
    if (this.rJD.rJi == null)
    {
      ab.w("MicroMsg.OnlineVideoView", "%d online video helper is null.", new Object[] { Integer.valueOf(this.rJD.hashCode()) });
      AppMethodBeat.o(38393);
      return false;
    }
    try
    {
      bool = this.rJD.rJi.acc(paramlu.cBN.cBO);
      if (!bool)
      {
        AppMethodBeat.o(38393);
        return false;
      }
      if (paramlu.cBN.retCode == -21112)
      {
        paramlu = this.rJD;
        h.qsU.idkeyStat(354L, 218L, 1L, false);
        paramlu.kuE.post(new OnlineVideoView.9(paramlu));
        AppMethodBeat.o(38393);
        return false;
      }
      if ((paramlu.cBN.retCode != 0) && (paramlu.cBN.retCode != -21006))
      {
        ab.w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(this.rJD.hashCode()), Integer.valueOf(paramlu.cBN.retCode) });
        AppMethodBeat.o(38393);
        return false;
      }
      switch (paramlu.cBN.cut)
      {
      }
    }
    catch (Exception paramlu)
    {
      for (;;)
      {
        boolean bool;
        long l2;
        long l1;
        ab.e("MicroMsg.OnlineVideoView", "online video callback error: " + paramlu.toString());
        continue;
        if (l1 > localae.edG) {}
        for (;;)
        {
          for (;;)
          {
            localae.edG = l1;
            localae.rJM = bo.aoy();
            try
            {
              if (localae.fVk != null) {
                break label518;
              }
              ab.w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
            }
            catch (Exception paramlu)
            {
              ab.e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + paramlu.toString());
            }
          }
          break;
          l1 = localae.edG;
        }
        if (localae.fVk.C(localae.fVg, l2))
        {
          localae.fVl = localae.fVk.gmx;
          ab.i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localae.fVl), localae.fVf, Boolean.valueOf(bool) });
          if (!bool) {
            al.d(new ae.1(localae));
          }
          if (localae.fVm == -1) {}
          for (localae.fVj = 1;; localae.fVj = 2)
          {
            h.qsU.idkeyStat(354L, 204L, 1L, false);
            break;
          }
        }
        ab.w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", new Object[] { localae.fVf });
        o.alF();
        e.r(localae.fVf, 0, -1);
        h.qsU.idkeyStat(354L, 205L, 1L, false);
        h.qsU.e(13836, new Object[] { Integer.valueOf(402), Long.valueOf(bo.aox()), "" });
        continue;
        ae localae = this.rJD.rJi;
        Object localObject = paramlu.cBN.cBO;
        int i = paramlu.cBN.offset;
        int j = paramlu.cBN.length;
        localae.fVs = false;
        if ((i < 0) || (j < 0)) {
          ab.w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        }
        while (!localae.acc((String)localObject))
        {
          if (paramlu.cBN.length <= 0) {
            break;
          }
          this.rJD.dh(true);
          break;
        }
        localObject = localae.fVf + i + "_" + j;
        localObject = (Integer)localae.rJI.get(localObject);
        if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
          localae.fVp = ((Integer)localObject).intValue();
        }
        for (;;)
        {
          ab.i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localae.fVp) });
          break;
          try
          {
            localae.fVp = localae.fVk.cP(i, j);
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + localException.toString());
          }
        }
        this.rJD.dh(true);
        continue;
        ab.i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(this.rJD.hashCode()), paramlu.cBN.cBO, Integer.valueOf(OnlineVideoView.r(this.rJD)), Integer.valueOf(OnlineVideoView.s(this.rJD)) });
        paramlu = this.rJD.rJi;
        ab.i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramlu.fVj), paramlu.fVf });
        paramlu.fVs = false;
        paramlu.fVi = 3;
        h.qsU.idkeyStat(354L, 206L, 1L, false);
        if (paramlu.fVj == 0)
        {
          ab.w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
          paramlu.cuh();
        }
        for (;;)
        {
          if (OnlineVideoView.r(this.rJD) <= 0) {
            break label1225;
          }
          OnlineVideoView.l(this.rJD);
          OnlineVideoView.b(this.rJD, OnlineVideoView.r(this.rJD));
          break;
          if (paramlu.fVj == 5)
          {
            ab.w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + paramlu.fVf);
            paramlu.cuh();
          }
        }
        if (OnlineVideoView.s(this.rJD) > 0)
        {
          OnlineVideoView.l(this.rJD);
          OnlineVideoView.b(this.rJD, OnlineVideoView.s(this.rJD), OnlineVideoView.t(this.rJD));
        }
        else if (OnlineVideoView.u(this.rJD))
        {
          OnlineVideoView.l(this.rJD);
          OnlineVideoView.v(this.rJD);
        }
        else
        {
          this.rJD.dh(true);
          continue;
          if (OnlineVideoView.i(this.rJD) == 1)
          {
            localae = this.rJD.rJi;
            String str = paramlu.cBN.cBO;
            i = paramlu.cBN.offset;
            j = paramlu.cBN.length;
            if (localae.acc(str))
            {
              localae.progress = i;
              localae.total = j;
              localae.rJK = (localae.progress * 100 / localae.total);
              ab.i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localae.fVf, Integer.valueOf(localae.progress), Integer.valueOf(localae.total), Integer.valueOf(localae.rJK) });
            }
            if (localae.rJK >= 100) {
              localae.fVi = 3;
            }
          }
          else if (OnlineVideoView.i(this.rJD) == 2)
          {
            OnlineVideoView.a(this.rJD, paramlu.cBN.offset, paramlu.cBN.length);
            continue;
            paramlu = this.rJD.rJi;
            ab.i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", new Object[] { paramlu.fVf });
            paramlu.cuh();
          }
        }
      }
    }
    ab.w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", new Object[] { Integer.valueOf(this.rJD.hashCode()), Integer.valueOf(paramlu.cBN.cut) });
    for (;;)
    {
      AppMethodBeat.o(38393);
      return false;
      localae = this.rJD.rJi;
      l2 = paramlu.cBN.offset;
      l1 = paramlu.cBN.cBP;
      bool = paramlu.cBN.cBQ;
      ab.i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localae.fVl), localae.fVf, Long.valueOf(l1), Long.valueOf(localae.edG) });
      if (localae.fVl == 0) {
        break;
      }
      ab.w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
      OnlineVideoView.q(this.rJD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.5
 * JD-Core Version:    0.7.0.1
 */