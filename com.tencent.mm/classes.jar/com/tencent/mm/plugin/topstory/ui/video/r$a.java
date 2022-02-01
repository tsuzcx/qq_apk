package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.g.h.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.foi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class r$a
  implements h.a
{
  boolean TNC;
  private boolean TND;
  
  private r$a(r paramr) {}
  
  public final void a(final String paramString, int paramInt, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(126205);
    final int i = paramInt;
    if (com.tencent.mm.plugin.topstory.a.g.hMI())
    {
      i = paramInt;
      if (this.TNB.TNx)
      {
        this.TNB.TNx = false;
        i = 404;
      }
    }
    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
    Object localObject1;
    Object localObject2;
    if (this.TNB.TLn != null)
    {
      localObject1 = this.TNB.TLn.hNA();
      if (((m)localObject1).TMW.containsKey(paramString))
      {
        localObject2 = (foi)((m)localObject1).TMW.get(paramString);
        if (i == 0)
        {
          ((foi)localObject2).mediaId = paramString;
          ((foi)localObject2).abOQ = ((foi)localObject2).abOC;
          ((foi)localObject2).abOR = m.bu(((foi)localObject2).abOQ, ((foi)localObject2).abOC);
          ((m)localObject1).TMW.put(paramString, localObject2);
        }
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(((foi)localObject2).abOR), Util.getSizeMB(((foi)localObject2).abOQ, 100.0D), Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = this.TNB.TLn.hNK().apc(this.TNB.TLn.hND());
        int k = n.aPK();
        localObject1 = paramd;
        if (paramd == null) {
          localObject1 = new com.tencent.mm.g.d();
        }
        int m = ((foh)localObject2).abOL;
        long l1 = ((com.tencent.mm.g.d)localObject1).field_startTime;
        long l2 = ((com.tencent.mm.g.d)localObject1).field_endTime;
        int n = ((com.tencent.mm.g.d)localObject1).field_averageSpeed;
        int i1 = ((com.tencent.mm.g.d)localObject1).field_averageConnectCost;
        int i2 = ((com.tencent.mm.g.d)localObject1).field_firstConnectCost;
        int i3 = ((com.tencent.mm.g.d)localObject1).field_moovFailReason;
        int i4 = ((com.tencent.mm.g.d)localObject1).field_httpStatusCode;
        paramd = ((com.tencent.mm.g.d)localObject1).field_clientIP;
        Object localObject3 = ((com.tencent.mm.g.d)localObject1).field_serverIP;
        Object localObject4 = ((com.tencent.mm.g.d)localObject1).field_xErrorNo;
        int i5 = ((com.tencent.mm.g.d)localObject1).field_cSeqCheck;
        if (!((com.tencent.mm.g.d)localObject1).field_isCrossNet) {
          continue;
        }
        paramInt = 1;
        if (!((com.tencent.mm.g.d)localObject1).field_usePrivateProtocol) {
          continue;
        }
        j = 1;
        paramd = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), paramd, localObject3, localObject4, Integer.valueOf(i5), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k) });
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", new Object[] { paramd });
        com.tencent.mm.plugin.report.f.Ozc.kvStat(16270, paramd);
        if (i != 0)
        {
          paramd = new eqy();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("videoplayfailreport=1");
          ((StringBuilder)localObject3).append("&vt=").append(((foh)localObject2).abOL);
          ((StringBuilder)localObject3).append("&errorcode=").append(i);
          ((StringBuilder)localObject3).append("&filetype=2");
          ((StringBuilder)localObject3).append("&startdownloadtime=").append(((com.tencent.mm.g.d)localObject1).field_startTime);
          ((StringBuilder)localObject3).append("&enddownloadtime=").append(((com.tencent.mm.g.d)localObject1).field_endTime);
          ((StringBuilder)localObject3).append("&averagespeed=").append(((com.tencent.mm.g.d)localObject1).field_averageSpeed);
          ((StringBuilder)localObject3).append("&averageconnectcost=").append(((com.tencent.mm.g.d)localObject1).field_averageConnectCost);
          ((StringBuilder)localObject3).append("&firstconnectcost=").append(((com.tencent.mm.g.d)localObject1).field_firstConnectCost);
          ((StringBuilder)localObject3).append("&moovfailreason=").append(((com.tencent.mm.g.d)localObject1).field_moovFailReason);
          ((StringBuilder)localObject3).append("&httpstatuscode=").append(((com.tencent.mm.g.d)localObject1).field_httpStatusCode);
          ((StringBuilder)localObject3).append("&clientip=").append(((com.tencent.mm.g.d)localObject1).field_clientIP);
          ((StringBuilder)localObject3).append("&serverip=").append(((com.tencent.mm.g.d)localObject1).field_serverIP);
          ((StringBuilder)localObject3).append("&xerrno=").append(((com.tencent.mm.g.d)localObject1).field_xErrorNo);
          ((StringBuilder)localObject3).append("&cseqresult=").append(((com.tencent.mm.g.d)localObject1).field_cSeqCheck);
          localObject4 = ((StringBuilder)localObject3).append("&crossnet=");
          if (!((com.tencent.mm.g.d)localObject1).field_isCrossNet) {
            continue;
          }
          paramInt = 1;
          ((StringBuilder)localObject4).append(paramInt);
          localObject4 = ((StringBuilder)localObject3).append("&privateprotocol=");
          if (!((com.tencent.mm.g.d)localObject1).field_usePrivateProtocol) {
            continue;
          }
          paramInt = 1;
          ((StringBuilder)localObject4).append(paramInt);
          ((StringBuilder)localObject3).append("&nettype=").append(k);
          ((StringBuilder)localObject3).append("&cdnsourcetype=").append(((foh)localObject2).abOI);
          ((StringBuilder)localObject3).append("&cdnscene=").append(((foh)localObject2).abOH);
          ((StringBuilder)localObject3).append("&expand=").append(((foh)localObject2).abOy);
          paramd.abuE = ((StringBuilder)localObject3).toString();
          paramd.abuS = ((com.tencent.mm.g.d)localObject1).field_httpResponseHeader;
          paramd.IJC = ((foh)localObject2).videoUrl;
          paramd.abuT = ((foh)localObject2).ELy;
          Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", new Object[] { paramd.abuE, paramd.abuS, paramd.IJC, paramd.abuT });
          paramd = new ae(paramd);
          com.tencent.mm.kernel.h.aZW().a(paramd, 0);
        }
      }
      catch (Exception paramd)
      {
        int j;
        continue;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126200);
          if ((r.a.this.TNB.TNt != null) && (r.a.this.TNB.TLn != null))
          {
            com.tencent.mm.plugin.topstory.a.b.b localb = r.a.this.TNB.TLn.hNx().TNp;
            if ((localb != null) && (localb.TIN == 0L)) {
              localb.TIN = (System.currentTimeMillis() - localb.TIB);
            }
            r.a.this.TNB.TNt.bb(paramString, i);
            if (i != 0)
            {
              a.rG(9);
              AppMethodBeat.o(126200);
              return;
            }
            a.rG(27);
          }
          AppMethodBeat.o(126200);
        }
      });
      AppMethodBeat.o(126205);
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
  
  public final void a(String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(271792);
    if (!this.TNC)
    {
      this.TNC = true;
      if (this.TNB.TLn != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126197);
            if ((r.a.this.TNB.TNt != null) && (r.a.this.TNB.TLn != null))
            {
              com.tencent.mm.plugin.topstory.a.b.b localb = r.a.this.TNB.TLn.hNx().TNp;
              if ((localb != null) && (localb.TIO == 0L))
              {
                localb.TIO = (System.currentTimeMillis() - localb.TIB);
                localb.TIQ = paramLong1;
                localb.TIR = (paramLong1 + this.IBh);
                localb.ObD = paramString2;
                Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(localb.TIO), Long.valueOf(paramLong1), Long.valueOf(this.IBh) });
              }
              r.a.this.TNB.TNt.jb(paramLong1);
            }
            AppMethodBeat.o(126197);
          }
        });
      }
      AppMethodBeat.o(271792);
      return;
    }
    AppMethodBeat.o(271792);
  }
  
  public final void h(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126203);
    if (this.TNB.TLn != null)
    {
      Object localObject = this.TNB.TLn.hNA();
      if (((m)localObject).TMW.containsKey(paramString))
      {
        foi localfoi = (foi)((m)localObject).TMW.get(paramString);
        localfoi.mediaId = paramString;
        localfoi.abOC = paramLong2;
        localfoi.abOQ = paramLong1;
        localfoi.abOR = m.bu(localfoi.abOQ, localfoi.abOC);
        ((m)localObject).TMW.put(paramString, localfoi);
      }
      localObject = this.TNB.TLn.hNx().TNp;
      if (localObject != null) {
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject).TIV = paramLong2;
      }
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126199);
        if (r.a.this.TNB.TNt != null) {
          r.a.this.TNB.TNt.h(paramString, paramLong1, this.IAr);
        }
        if (r.bv(paramLong1 * 100L / this.IAr, paramLong1)) {
          r.a.this.hOI();
        }
        AppMethodBeat.o(126199);
      }
    });
    AppMethodBeat.o(126203);
  }
  
  public final void hOI()
  {
    AppMethodBeat.i(126204);
    m localm;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    if ((!this.TND) && (this.TNB.TIZ != null) && (this.TNB.TLn != null) && ((this.TNB.TLn.hNw().fvi()) || (aj.isFreeSimCard())))
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
      this.TND = true;
      localm = this.TNB.TLn.hNA();
      localObject3 = this.TNB.TIZ;
      localObject1 = localm.TLn.hNK();
      localObject4 = new ArrayList();
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = ((n)localObject1).aiJ().size();
        i = 0;
        if (i >= j) {
          break label676;
        }
        if (!((foh)localObject3).Ido.equals(((foh)((n)localObject1).aiJ().get(i)).Ido)) {
          break label696;
        }
      }
      finally
      {
        String str2;
        com.tencent.mm.g.h localh;
        AppMethodBeat.o(126204);
      }
      if (i < j)
      {
        ((List)localObject4).add((foh)((n)localObject1).aiJ().get(i));
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
          localObject5 = (foh)((Iterator)localObject4).next();
          str1 = com.tencent.mm.plugin.topstory.ui.d.bL(((foh)localObject5).Ido, ((foh)localObject5).abOw);
          if (localm.TMW.containsKey(str1))
          {
            localObject1 = (foi)localm.TMW.get(str1);
            ((HashMap)localObject3).put(str1, localObject1);
            j = (int)m.bu(a.a.TIq.longValue(), ((foh)localObject5).abOC);
            if (j >= 20) {
              break label632;
            }
            i = 20;
            if (((foi)localObject1).abOR >= i) {
              break label646;
            }
            str2 = localm.TLn.hNy() + str1 + ".mp4";
            localObject5 = ((foh)localObject5).videoUrl;
            localh = new com.tencent.mm.g.h();
            localh.taskName = "task_TopStoryPreloadMgr";
            localh.field_mediaId = str1;
            localh.url = ((String)localObject5);
            localh.lxb = 2;
            localh.lxi = 2;
            localh.lxc = 3;
            localh.lxn = i;
            localh.field_preloadRatio = i;
            localh.concurrentCount = 4;
            localh.field_fullpath = str2;
            localh.lwL = new m.d(localm, (byte)0);
            localh.lxd = new m.c(localm, (byte)0);
            k.bHW().b(localh, -1);
            Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((foi)localObject1).abOR), Integer.valueOf(i) });
            if (((HashMap)localObject3).size() != 6) {
              break label674;
            }
          }
        }
        else
        {
          localm.TMX.clear();
          localm.TMX.addAll(((HashMap)localObject3).keySet());
          localm.TMW.putAll((Map)localObject3);
          ThreadPool.post(new m.a(localm, localm.TMV), "TopStory.DeleteVideoCacheTask");
          AppMethodBeat.o(126204);
          return;
        }
        localObject1 = new foi();
        ((foi)localObject1).mediaId = str1;
        ((foi)localObject1).abOC = ((foh)localObject5).abOC;
        continue;
        label632:
        i = j;
        if (j > 100)
        {
          i = 100;
          continue;
          label646:
          Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((foi)localObject1).abOR) });
          continue;
          label674:
          continue;
          label676:
          i = -1;
          if ((i >= 0) && (i + 1 < j))
          {
            i += 1;
            continue;
            label696:
            i += 1;
          }
        }
      }
    }
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126202);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126198);
        if (r.a.this.TNB.TNt != null) {
          r.a.this.TNB.TNt.onDataAvailable(paramString, paramLong1, this.IBh);
        }
        AppMethodBeat.o(126198);
      }
    });
    AppMethodBeat.o(126202);
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.a
 * JD-Core Version:    0.7.0.1
 */