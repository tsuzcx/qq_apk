package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lu.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class j$3
  extends c<lu>
{
  j$3(j paramj)
  {
    AppMethodBeat.i(32316);
    this.__eventId = lu.class.getName().hashCode();
    AppMethodBeat.o(32316);
  }
  
  private boolean a(lu paramlu)
  {
    AppMethodBeat.i(32317);
    if (!j.f(this.zNd).acc(paramlu.cBN.cBO))
    {
      AppMethodBeat.o(32317);
      return false;
    }
    if ((paramlu.cBN.retCode != 0) && (paramlu.cBN.retCode != -21006))
    {
      ab.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramlu.cBN.retCode);
      j.a(this.zNd, paramlu.cBN.cBO, paramlu.cBN.retCode);
      AppMethodBeat.o(32317);
      return false;
    }
    switch (paramlu.cBN.cut)
    {
    default: 
      ab.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramlu.cBN.cut);
    }
    for (;;)
    {
      AppMethodBeat.o(32317);
      return false;
      m localm = j.f(this.zNd);
      long l2 = paramlu.cBN.offset;
      long l1 = paramlu.cBN.cBP;
      boolean bool = paramlu.cBN.cBQ;
      ab.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localm.fVm), Integer.valueOf(localm.fVl), Long.valueOf(l1), Long.valueOf(localm.edG) });
      if (localm.fVl != 0) {
        ab.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
      }
      for (;;)
      {
        j.a(this.zNd, true);
        break;
        if (l1 > localm.edG) {}
        for (;;)
        {
          for (;;)
          {
            localm.edG = l1;
            h.qsU.idkeyStat(354L, 5L, 1L, false);
            localm.rJM = bo.aoy();
            o.alE();
            paramlu = t.vf(localm.filename);
            try
            {
              if (localm.fVk != null) {
                break label440;
              }
              ab.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
            }
            catch (Exception paramlu)
            {
              ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramlu, "", new Object[0]);
              ab.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramlu.toString());
            }
          }
          break;
          l1 = localm.edG;
        }
        label440:
        if (localm.fVk.C(paramlu, l2))
        {
          localm.fVl = localm.fVk.gmx;
          ab.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localm.fVl), localm.filename, Boolean.valueOf(bool) });
          if (!bool) {
            al.d(new m.1(localm));
          }
          if (localm.fVm == -1) {}
          for (localm.fVj = 1;; localm.fVj = 2)
          {
            h.qsU.idkeyStat(354L, 7L, 1L, false);
            break;
          }
        }
        ab.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
        o.alF();
        e.r(localm.cBO, 0, -1);
        u.af(localm.filename, 15);
        h.qsU.idkeyStat(354L, 8L, 1L, false);
        ab.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localm.hashCode()), localm.filename });
        h.qsU.e(13836, new Object[] { Integer.valueOf(302), Long.valueOf(bo.aox()), "" });
      }
      localm = j.f(this.zNd);
      Object localObject = paramlu.cBN.cBO;
      int i = paramlu.cBN.offset;
      int j = paramlu.cBN.length;
      localm.fVs = false;
      if ((i < 0) || (j < 0)) {
        ab.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      while (!localm.acc((String)localObject))
      {
        if (paramlu.cBN.length <= 0) {
          break;
        }
        this.zNd.dh(true);
        break;
      }
      localObject = localm.cBO + i + "_" + j;
      localObject = (Integer)localm.rJI.get(localObject);
      if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
        localm.fVp = ((Integer)localObject).intValue();
      }
      for (;;)
      {
        ab.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localm.fVp) });
        break;
        try
        {
          localm.fVp = localm.fVk.cP(i, j);
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
          ab.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
        }
      }
      this.zNd.dh(true);
      continue;
      paramlu = j.f(this.zNd);
      ab.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramlu.fVj) });
      paramlu.fVs = false;
      paramlu.fVi = 3;
      if (paramlu.fVj == 0)
      {
        ab.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
        paramlu.cuh();
        h.qsU.idkeyStat(354L, 6L, 1L, false);
      }
      for (;;)
      {
        paramlu.dKT();
        h.qsU.idkeyStat(354L, 26L, 1L, false);
        this.zNd.dh(true);
        break;
        if (paramlu.fVj == 5)
        {
          ab.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramlu.cBO);
          paramlu.cuh();
        }
      }
      localm = j.f(this.zNd);
      String str = paramlu.cBN.cBO;
      i = paramlu.cBN.offset;
      if (localm.acc(str))
      {
        localm.rJK = (i * 100 / localm.gVW);
        ab.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localm.rJK);
      }
      if (localm.rJK >= 100)
      {
        localm.fVi = 3;
        continue;
        paramlu = j.f(this.zNd);
        ab.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
        paramlu.dKT();
        paramlu.cuh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.3
 * JD-Core Version:    0.7.0.1
 */