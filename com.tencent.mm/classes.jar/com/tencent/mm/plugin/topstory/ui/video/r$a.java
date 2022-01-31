package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.f;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class r$a
  implements h.a
{
  boolean tjZ;
  private boolean tka;
  
  private r$a(r paramr) {}
  
  public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(1831);
    int i = paramInt;
    if (com.tencent.mm.plugin.topstory.a.g.cIw())
    {
      i = paramInt;
      if (this.tjY.tjU)
      {
        this.tjY.tjU = false;
        i = 404;
      }
    }
    ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
    Object localObject1;
    Object localObject2;
    if (this.tjY.thM != null)
    {
      localObject1 = this.tjY.thM.cJg();
      if (((m)localObject1).tjq.containsKey(paramString))
      {
        localObject2 = (cky)((m)localObject1).tjq.get(paramString);
        if (i == 0)
        {
          ((cky)localObject2).cBO = paramString;
          ((cky)localObject2).xVt = ((cky)localObject2).xVi;
          ((cky)localObject2).xVu = m.ac(((cky)localObject2).xVt, ((cky)localObject2).xVi);
          ((m)localObject1).tjq.put(paramString, localObject2);
        }
        ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(((cky)localObject2).xVu), bo.b(((cky)localObject2).xVt, 100.0D), Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = this.tjY.thM.cJs().GI(this.tjY.thM.cJk());
        int k = n.LZ();
        localObject1 = paramd;
        if (paramd == null) {
          localObject1 = new com.tencent.mm.i.d();
        }
        int m = ((ckx)localObject2).xVo;
        long l1 = ((com.tencent.mm.i.d)localObject1).field_startTime;
        long l2 = ((com.tencent.mm.i.d)localObject1).field_endTime;
        int n = ((com.tencent.mm.i.d)localObject1).field_averageSpeed;
        int i1 = ((com.tencent.mm.i.d)localObject1).field_averageConnectCost;
        int i2 = ((com.tencent.mm.i.d)localObject1).field_firstConnectCost;
        int i3 = ((com.tencent.mm.i.d)localObject1).field_moovFailReason;
        int i4 = ((com.tencent.mm.i.d)localObject1).field_httpStatusCode;
        paramd = ((com.tencent.mm.i.d)localObject1).field_clientIP;
        Object localObject3 = ((com.tencent.mm.i.d)localObject1).field_serverIP;
        Object localObject4 = ((com.tencent.mm.i.d)localObject1).field_xErrorNo;
        int i5 = ((com.tencent.mm.i.d)localObject1).field_cSeqCheck;
        if (!((com.tencent.mm.i.d)localObject1).field_isCrossNet) {
          continue;
        }
        paramInt = 1;
        if (!((com.tencent.mm.i.d)localObject1).field_usePrivateProtocol) {
          continue;
        }
        j = 1;
        paramd = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), paramd, localObject3, localObject4, Integer.valueOf(i5), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k) });
        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", new Object[] { paramd });
        e.qrI.kvStat(16270, paramd);
        if (i != 0)
        {
          paramd = new buo();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("videoplayfailreport=1");
          ((StringBuilder)localObject3).append("&vt=").append(((ckx)localObject2).xVo);
          ((StringBuilder)localObject3).append("&errorcode=").append(i);
          ((StringBuilder)localObject3).append("&filetype=2");
          ((StringBuilder)localObject3).append("&startdownloadtime=").append(((com.tencent.mm.i.d)localObject1).field_startTime);
          ((StringBuilder)localObject3).append("&enddownloadtime=").append(((com.tencent.mm.i.d)localObject1).field_endTime);
          ((StringBuilder)localObject3).append("&averagespeed=").append(((com.tencent.mm.i.d)localObject1).field_averageSpeed);
          ((StringBuilder)localObject3).append("&averageconnectcost=").append(((com.tencent.mm.i.d)localObject1).field_averageConnectCost);
          ((StringBuilder)localObject3).append("&firstconnectcost=").append(((com.tencent.mm.i.d)localObject1).field_firstConnectCost);
          ((StringBuilder)localObject3).append("&moovfailreason=").append(((com.tencent.mm.i.d)localObject1).field_moovFailReason);
          ((StringBuilder)localObject3).append("&httpstatuscode=").append(((com.tencent.mm.i.d)localObject1).field_httpStatusCode);
          ((StringBuilder)localObject3).append("&clientip=").append(((com.tencent.mm.i.d)localObject1).field_clientIP);
          ((StringBuilder)localObject3).append("&serverip=").append(((com.tencent.mm.i.d)localObject1).field_serverIP);
          ((StringBuilder)localObject3).append("&xerrno=").append(((com.tencent.mm.i.d)localObject1).field_xErrorNo);
          ((StringBuilder)localObject3).append("&cseqresult=").append(((com.tencent.mm.i.d)localObject1).field_cSeqCheck);
          localObject4 = ((StringBuilder)localObject3).append("&crossnet=");
          if (!((com.tencent.mm.i.d)localObject1).field_isCrossNet) {
            continue;
          }
          paramInt = 1;
          ((StringBuilder)localObject4).append(paramInt);
          localObject4 = ((StringBuilder)localObject3).append("&privateprotocol=");
          if (!((com.tencent.mm.i.d)localObject1).field_usePrivateProtocol) {
            continue;
          }
          paramInt = 1;
          ((StringBuilder)localObject4).append(paramInt);
          ((StringBuilder)localObject3).append("&nettype=").append(k);
          ((StringBuilder)localObject3).append("&cdnsourcetype=").append(((ckx)localObject2).xVr);
          ((StringBuilder)localObject3).append("&cdnscene=").append(((ckx)localObject2).xVs);
          ((StringBuilder)localObject3).append("&expand=").append(((ckx)localObject2).xVd);
          paramd.xHP = ((StringBuilder)localObject3).toString();
          paramd.xIf = ((com.tencent.mm.i.d)localObject1).field_httpResponseHeader;
          paramd.nrZ = ((ckx)localObject2).videoUrl;
          paramd.xIg = ((ckx)localObject2).xVq;
          ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", new Object[] { paramd.xHP, paramd.xIf, paramd.nrZ, paramd.xIg });
          paramd = new w(paramd);
          com.tencent.mm.kernel.g.Rc().a(paramd, 0);
        }
      }
      catch (Exception paramd)
      {
        int j;
        continue;
      }
      al.d(new r.a.4(this, paramString, i));
      AppMethodBeat.o(1831);
      return;
      paramInt = 0;
      continue;
      j = 0;
      continue;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
  }
  
  public final void cKk()
  {
    AppMethodBeat.i(1830);
    m localm;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    if ((!this.tka) && (this.tjY.tjR != null) && (this.tjY.thM != null) && ((this.tjY.thM.cJc().blP()) || (com.tencent.mm.plugin.topstory.a.g.cIz())))
    {
      ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
      this.tka = true;
      localm = this.tjY.thM.cJg();
      localObject3 = this.tjY.tjR;
      localObject1 = localm.thM.cJs();
      localObject4 = new ArrayList();
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = ((n)localObject1).cKb().size();
        i = 0;
        if (i >= j) {
          break label665;
        }
        if (!((ckx)localObject3).xVa.equals(((ckx)((n)localObject1).cKb().get(i)).xVa)) {
          break label685;
        }
      }
      finally
      {
        String str2;
        h localh;
        AppMethodBeat.o(1830);
      }
      if (i < j)
      {
        ((List)localObject4).add(((n)localObject1).cKb().get(i));
        i += 1;
      }
      else
      {
        localObject3 = new HashMap();
        localObject4 = ((List)localObject4).iterator();
        Object localObject5;
        String str1;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ckx)((Iterator)localObject4).next();
          str1 = com.tencent.mm.plugin.topstory.ui.d.aK(((ckx)localObject5).xVa, ((ckx)localObject5).xVb);
          if (localm.tjq.containsKey(str1))
          {
            localObject1 = (cky)localm.tjq.get(str1);
            ((HashMap)localObject3).put(str1, localObject1);
            j = (int)m.ac(a.a.teS.longValue(), ((ckx)localObject5).xVi);
            if (j >= 20) {
              break label621;
            }
            i = 20;
            if (((cky)localObject1).xVu >= i) {
              break label635;
            }
            str2 = localm.thM.cJe() + str1 + ".mp4";
            localObject5 = ((ckx)localObject5).videoUrl;
            localh = new h();
            localh.field_mediaId = str1;
            localh.url = ((String)localObject5);
            localh.edD = 2;
            localh.edJ = 2;
            localh.edE = 3;
            localh.edO = i;
            localh.field_preloadRatio = i;
            localh.concurrentCount = 4;
            localh.field_fullpath = str2;
            localh.edp = new m.d(localm, (byte)0);
            localh.edF = new m.c(localm, (byte)0);
            f.afO().b(localh, -1);
            ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((cky)localObject1).xVu), Integer.valueOf(i) });
            if (((HashMap)localObject3).size() != 6) {
              break label663;
            }
          }
        }
        else
        {
          localm.tjr.clear();
          localm.tjr.addAll(((HashMap)localObject3).keySet());
          localm.tjq.putAll((Map)localObject3);
          com.tencent.mm.sdk.g.d.post(new m.a(localm, localm.tjp), "TopStory.DeleteVideoCacheTask");
          AppMethodBeat.o(1830);
          return;
        }
        localObject1 = new cky();
        ((cky)localObject1).cBO = str1;
        ((cky)localObject1).xVi = ((ckx)localObject5).xVi;
        continue;
        label621:
        i = j;
        if (j > 100)
        {
          i = 100;
          continue;
          label635:
          ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((cky)localObject1).xVu) });
          continue;
          label663:
          continue;
          label665:
          i = -1;
          if ((i >= 0) && (i + 1 < j))
          {
            i += 1;
            continue;
            label685:
            i += 1;
          }
        }
      }
    }
  }
  
  public final void l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1827);
    if (!this.tjZ)
    {
      this.tjZ = true;
      al.d(new r.a.1(this, paramInt1, paramInt2, paramString));
      AppMethodBeat.o(1827);
      return;
    }
    AppMethodBeat.o(1827);
  }
  
  public final void m(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(1828);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(1824);
        if (r.a.this.tjY.tjP != null) {
          r.a.this.tjY.tjP.m(paramString, paramInt1, paramInt2);
        }
        AppMethodBeat.o(1824);
      }
    });
    AppMethodBeat.o(1828);
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1829);
    if (this.tjY.thM != null)
    {
      m localm = this.tjY.thM.cJg();
      long l1 = paramInt1;
      long l2 = paramInt2;
      if (localm.tjq.containsKey(paramString))
      {
        cky localcky = (cky)localm.tjq.get(paramString);
        localcky.cBO = paramString;
        localcky.xVi = l2;
        localcky.xVt = l1;
        localcky.xVu = m.ac(localcky.xVt, localcky.xVi);
        localm.tjq.put(paramString, localcky);
      }
    }
    al.d(new r.a.3(this, paramString, paramInt1, paramInt2));
    AppMethodBeat.o(1829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.a
 * JD-Core Version:    0.7.0.1
 */