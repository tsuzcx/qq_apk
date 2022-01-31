package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ak.e;
import com.tencent.mm.h.a.lf;
import com.tencent.mm.h.a.lf.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class j$4
  extends c<lf>
{
  j$4(j paramj)
  {
    this.udX = lf.class.getName().hashCode();
  }
  
  private boolean a(lf paramlf)
  {
    if (!j.f(this.vwT).Pi(paramlf.bUh.bUi)) {
      return false;
    }
    if ((paramlf.bUh.retCode != 0) && (paramlf.bUh.retCode != -21006))
    {
      y.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramlf.bUh.retCode);
      j.a(this.vwT, paramlf.bUh.bUi, paramlf.bUh.retCode);
      return false;
    }
    switch (paramlf.bUh.bNb)
    {
    default: 
      y.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramlf.bUh.bNb);
    }
    for (;;)
    {
      return false;
      m localm = j.f(this.vwT);
      long l2 = paramlf.bUh.offset;
      long l1 = paramlf.bUh.bUj;
      boolean bool = paramlf.bUh.bUk;
      y.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localm.eFv), Integer.valueOf(localm.eFu), Long.valueOf(l1), Long.valueOf(localm.dmd) });
      if (localm.eFu != 0) {
        y.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
      }
      for (;;)
      {
        j.a(this.vwT, true);
        break;
        if (l1 > localm.dmd) {}
        for (;;)
        {
          for (;;)
          {
            localm.dmd = l1;
            h.nFQ.a(354L, 5L, 1L, false);
            localm.oRU = bk.UY();
            o.Sr();
            paramlf = t.nS(localm.filename);
            try
            {
              if (localm.eFt != null) {
                break label414;
              }
              y.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
            }
            catch (Exception paramlf)
            {
              y.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramlf, "", new Object[0]);
              y.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramlf.toString());
            }
          }
          break;
          l1 = localm.dmd;
        }
        label414:
        if (localm.eFt.t(paramlf, l2))
        {
          localm.eFu = localm.eFt.eUz;
          y.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localm.eFu), localm.filename, Boolean.valueOf(bool) });
          if (!bool) {
            ai.d(new m.1(localm));
          }
          if (localm.eFv == -1) {}
          for (localm.eFs = 1;; localm.eFs = 2)
          {
            h.nFQ.a(354L, 7L, 1L, false);
            break;
          }
        }
        y.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
        o.Ss();
        e.h(localm.bUi, 0, -1);
        u.X(localm.filename, 15);
        h.nFQ.a(354L, 8L, 1L, false);
        y.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localm.hashCode()), localm.filename });
        h.nFQ.f(13836, new Object[] { Integer.valueOf(302), Long.valueOf(bk.UX()), "" });
      }
      localm = j.f(this.vwT);
      Object localObject = paramlf.bUh.bUi;
      int i = paramlf.bUh.offset;
      int j = paramlf.bUh.length;
      localm.eFB = false;
      if ((i < 0) || (j < 0)) {
        y.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      while (!localm.Pi((String)localObject))
      {
        if (paramlf.bUh.length <= 0) {
          break;
        }
        this.vwT.ce(true);
        break;
      }
      localObject = localm.bUi + i + "_" + j;
      localObject = (Integer)localm.oRQ.get(localObject);
      if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
        localm.eFy = ((Integer)localObject).intValue();
      }
      for (;;)
      {
        y.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localm.eFy) });
        break;
        try
        {
          localm.eFy = localm.eFt.bE(i, j);
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
          y.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
        }
      }
      this.vwT.ce(true);
      continue;
      paramlf = j.f(this.vwT);
      y.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramlf.eFs) });
      paramlf.eFB = false;
      paramlf.eFr = 3;
      if (paramlf.eFs == 0)
      {
        y.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
        paramlf.bHV();
        h.nFQ.a(354L, 6L, 1L, false);
      }
      for (;;)
      {
        paramlf.cGL();
        h.nFQ.a(354L, 26L, 1L, false);
        this.vwT.ce(true);
        break;
        if (paramlf.eFs == 5)
        {
          y.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramlf.bUi);
          paramlf.bHV();
        }
      }
      localm = j.f(this.vwT);
      String str = paramlf.bUh.bUi;
      i = paramlf.bUh.offset;
      if (localm.Pi(str))
      {
        localm.oRS = (i * 100 / localm.fDG);
        y.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localm.oRS);
      }
      if (localm.oRS >= 100)
      {
        localm.eFr = 3;
        continue;
        paramlf = j.f(this.vwT);
        y.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
        paramlf.cGL();
        paramlf.bHV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.4
 * JD-Core Version:    0.7.0.1
 */