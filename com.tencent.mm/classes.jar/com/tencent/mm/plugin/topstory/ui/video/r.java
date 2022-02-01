package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class r
{
  private int ABn;
  public dod BrC;
  b BtO;
  q BvS;
  public f BvT;
  public boolean BvU;
  public boolean BvV;
  public boolean BvW;
  private d.a BvX;
  private boolean BvY;
  private boolean BvZ;
  private com.tencent.mm.model.d haI;
  
  public r()
  {
    AppMethodBeat.i(126212);
    this.ABn = 0;
    this.BvW = false;
    this.BvX = new d.a()
    {
      public final void aAa() {}
      
      public final void aAb() {}
      
      public final void azY() {}
      
      public final void azZ() {}
    };
    this.haI = new com.tencent.mm.model.d();
    AppMethodBeat.o(126212);
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(126218);
    this.haI.ex(false);
    AppMethodBeat.o(126218);
  }
  
  public static boolean ap(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void eqC()
  {
    AppMethodBeat.i(126215);
    if (this.BvS.getParent() != null) {
      ((ViewGroup)this.BvS.getParent()).removeView(this.BvS);
    }
    AppMethodBeat.o(126215);
  }
  
  private q eqD()
  {
    AppMethodBeat.i(126216);
    q localq = new q(this.BtO.dhO(), this.BtO);
    localq.setRootPath(this.BtO.epy());
    localq.setIOnlineVideoProxy(new b((byte)0));
    localq.setReporter(new c((byte)0));
    AppMethodBeat.o(126216);
    return localq;
  }
  
  private void requestAudioFocus()
  {
    AppMethodBeat.i(126217);
    this.haI.a(this.BvX);
    AppMethodBeat.o(126217);
  }
  
  public final void a(b paramb, dod paramdod, String paramString, int paramInt)
  {
    AppMethodBeat.i(126214);
    if (paramdod.HCO != null) {
      paramdod.HCO.dmo = false;
    }
    ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { paramdod.tSk, paramdod.title, paramString });
    paramb.epx().b(paramb.epz());
    paramb.epx().eqy();
    paramb.epx().a(paramdod, paramInt, paramString);
    this.BvS.setKeepScreenOn(true);
    this.BvS.eqB();
    this.BvS.aCX(paramString);
    this.BrC = paramdod;
    this.BvU = true;
    this.BvV = false;
    ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramdod.tSk, Integer.valueOf(0));
    AppMethodBeat.o(126214);
  }
  
  public final void a(f paramf, i.e parame)
  {
    AppMethodBeat.i(126213);
    if ((paramf == this.BvT) || (this.BtO == null))
    {
      AppMethodBeat.o(126213);
      return;
    }
    if (this.BvS == null) {
      this.BvS = eqD();
    }
    eqC();
    paramf.getVideoViewParent().addView(this.BvS);
    this.BvS.setVideoFooterView(paramf.getControlBar());
    this.BvS.setScaleType(parame);
    this.BvS.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.haI.a(this.BvX);
    this.BvT = paramf;
    AppMethodBeat.o(126213);
  }
  
  public final void aCY(String paramString)
  {
    AppMethodBeat.i(126229);
    com.tencent.mm.plugin.topstory.a.b.b localb = this.BtO.epx().BvO;
    if (localb != null) {
      localb.Bri = 1L;
    }
    if ((this.BvS != null) && (this.BvS.getSessionId().equals(paramString)))
    {
      if (this.BrC != null) {
        ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.BrC.tSk);
      }
      stopPlay();
    }
    com.tencent.mm.plugin.websearch.api.a.a.ma(26);
    AppMethodBeat.o(126229);
  }
  
  public final void cxw()
  {
    AppMethodBeat.i(126222);
    if (this.BvS != null)
    {
      abandonAudioFocus();
      this.BvS.setKeepScreenOn(false);
      this.BvS.pause();
      this.BvV = true;
    }
    AppMethodBeat.o(126222);
  }
  
  public final void d(b paramb)
  {
    this.ABn += 1;
    this.BtO = paramb;
  }
  
  public final void eaq()
  {
    AppMethodBeat.i(126221);
    if (this.BvS != null)
    {
      requestAudioFocus();
      this.BvS.setKeepScreenOn(true);
      this.BvS.play();
      this.BvV = false;
    }
    AppMethodBeat.o(126221);
  }
  
  public final boolean eqE()
  {
    AppMethodBeat.i(126219);
    if (this.BvS != null)
    {
      boolean bool = this.BvS.isPlaying();
      AppMethodBeat.o(126219);
      return bool;
    }
    AppMethodBeat.o(126219);
    return false;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126232);
    if (this.BvS != null)
    {
      int i = this.BvS.getCurrPosMs();
      AppMethodBeat.o(126232);
      return i;
    }
    AppMethodBeat.o(126232);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126230);
    if (this.BvS != null)
    {
      int i = this.BvS.getCurrPosSec();
      AppMethodBeat.o(126230);
      return i;
    }
    AppMethodBeat.o(126230);
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(126231);
    if (this.BvS != null)
    {
      int i = this.BvS.getVideoDurationSec();
      AppMethodBeat.o(126231);
      return i;
    }
    AppMethodBeat.o(126231);
    return 0;
  }
  
  public final void im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126228);
    if (paramInt1 == 0)
    {
      if ((this.BvU) && (this.BvZ))
      {
        this.BvZ = false;
        eaq();
        AppMethodBeat.o(126228);
      }
    }
    else if (paramInt2 == 0)
    {
      if ((this.BvU) && (eqE()))
      {
        this.BvZ = true;
        cxw();
        AppMethodBeat.o(126228);
      }
    }
    else if ((paramInt2 == 1) && (this.BvY) && (this.BvU) && (this.BvV))
    {
      this.BvY = false;
      eaq();
      this.BvT.epU();
    }
    AppMethodBeat.o(126228);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(126227);
    if ((this.BvS != null) && (this.BvS.getSessionId().equals(paramString))) {
      stopPlay();
    }
    AppMethodBeat.o(126227);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126226);
    this.ABn -= 1;
    ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.ABn) });
    if (this.ABn <= 0)
    {
      if (this.BvS != null)
      {
        stopPlay();
        this.BvS.onUIDestroy();
      }
      this.BtO = null;
    }
    AppMethodBeat.o(126226);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126225);
    if (this.BvS != null) {
      this.BvS.onUIPause();
    }
    AppMethodBeat.o(126225);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126224);
    if (this.BvS != null)
    {
      this.BvS.onUIResume();
      if (this.BvT != null) {
        this.BvT.epX();
      }
    }
    AppMethodBeat.o(126224);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(126220);
    if (this.BvS != null) {
      this.BvS.setMute(paramBoolean);
    }
    AppMethodBeat.o(126220);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(126223);
    if (this.BvS != null)
    {
      ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      abandonAudioFocus();
      this.BvS.eqA();
      this.BvS.setKeepScreenOn(false);
      this.BvS.stop();
      this.BrC = null;
      this.BvU = false;
      this.BvV = false;
      if (this.BtO != null)
      {
        this.BtO.epx().b(this.BtO.epz());
        this.BtO.epx().eqy();
      }
      if (this.BvT != null) {
        this.BvT.epY();
      }
    }
    AppMethodBeat.o(126223);
  }
  
  final class a
    implements h.a
  {
    boolean Bwb;
    private boolean Bwc;
    
    private a() {}
    
    public final void a(final String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(126205);
      final int i = paramInt;
      if (com.tencent.mm.plugin.topstory.a.h.eoK())
      {
        i = paramInt;
        if (r.this.BvW)
        {
          r.this.BvW = false;
          i = 404;
        }
      }
      ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
      Object localObject1;
      Object localObject2;
      if (r.this.BtO != null)
      {
        localObject1 = r.this.BtO.epA();
        if (((m)localObject1).Bvw.containsKey(paramString))
        {
          localObject2 = (doe)((m)localObject1).Bvw.get(paramString);
          if (i == 0)
          {
            ((doe)localObject2).mediaId = paramString;
            ((doe)localObject2).HCP = ((doe)localObject2).HCB;
            ((doe)localObject2).HCQ = m.ao(((doe)localObject2).HCP, ((doe)localObject2).HCB);
            ((m)localObject1).Bvw.put(paramString, localObject2);
          }
          ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(((doe)localObject2).HCQ), bt.a(((doe)localObject2).HCP, 100.0D), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = r.this.BtO.epL().Tg(r.this.BtO.epE());
          int k = n.aaW();
          localObject1 = paramd;
          if (paramd == null) {
            localObject1 = new com.tencent.mm.i.d();
          }
          int m = ((dod)localObject2).HCL;
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
          ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", new Object[] { paramd });
          com.tencent.mm.plugin.report.e.ygI.kvStat(16270, paramd);
          if (i != 0)
          {
            paramd = new cup();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("videoplayfailreport=1");
            ((StringBuilder)localObject3).append("&vt=").append(((dod)localObject2).HCL);
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
            ((StringBuilder)localObject3).append("&cdnsourcetype=").append(((dod)localObject2).HCH);
            ((StringBuilder)localObject3).append("&cdnscene=").append(((dod)localObject2).HCG);
            ((StringBuilder)localObject3).append("&expand=").append(((dod)localObject2).HCw);
            paramd.Hmu = ((StringBuilder)localObject3).toString();
            paramd.HmI = ((com.tencent.mm.i.d)localObject1).field_httpResponseHeader;
            paramd.uht = ((dod)localObject2).videoUrl;
            paramd.HmJ = ((dod)localObject2).HCJ;
            ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", new Object[] { paramd.Hmu, paramd.HmI, paramd.uht, paramd.HmJ });
            paramd = new z(paramd);
            g.aiU().a(paramd, 0);
          }
        }
        catch (Exception paramd)
        {
          int j;
          continue;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126200);
            if ((r.this.BvS != null) && (r.this.BtO != null))
            {
              com.tencent.mm.plugin.topstory.a.b.b localb = r.this.BtO.epx().BvO;
              if ((localb != null) && (localb.Brq == 0L)) {
                localb.Brq = (System.currentTimeMillis() - localb.Bre);
              }
              r.this.BvS.as(paramString, i);
              if (i != 0)
              {
                com.tencent.mm.plugin.websearch.api.a.a.ma(9);
                AppMethodBeat.o(126200);
                return;
              }
              com.tencent.mm.plugin.websearch.api.a.a.ma(27);
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
      AppMethodBeat.i(199596);
      if (!this.Bwb)
      {
        this.Bwb = true;
        if (r.this.BtO != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126197);
              if ((r.this.BvS != null) && (r.this.BtO != null))
              {
                com.tencent.mm.plugin.topstory.a.b.b localb = r.this.BtO.epx().BvO;
                if ((localb != null) && (localb.Brr == 0L))
                {
                  localb.Brr = (System.currentTimeMillis() - localb.Bre);
                  localb.Brs = paramLong1;
                  localb.Brt = (paramLong1 + this.llK);
                  localb.Brx = paramString2;
                  ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(localb.Brr), Long.valueOf(paramLong1), Long.valueOf(this.llK) });
                }
                r.this.BvS.sp(paramLong1);
              }
              AppMethodBeat.o(126197);
            }
          });
        }
        AppMethodBeat.o(199596);
        return;
      }
      AppMethodBeat.o(199596);
    }
    
    public final void eqF()
    {
      AppMethodBeat.i(126204);
      m localm;
      Object localObject3;
      Object localObject1;
      Object localObject4;
      if ((!this.Bwc) && (r.this.BrC != null) && (r.this.BtO != null) && ((r.this.BtO.epw().chr()) || (com.tencent.mm.plugin.topstory.a.h.eoN())))
      {
        ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
        this.Bwc = true;
        localm = r.this.BtO.epA();
        localObject3 = r.this.BrC;
        localObject1 = localm.BtO.epL();
        localObject4 = new ArrayList();
      }
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = ((n)localObject1).cNm().size();
          i = 0;
          if (i >= j) {
            break label673;
          }
          if (!((dod)localObject3).tSk.equals(((dod)((n)localObject1).cNm().get(i)).tSk)) {
            break label693;
          }
        }
        finally
        {
          String str2;
          com.tencent.mm.i.h localh;
          AppMethodBeat.o(126204);
        }
        if (i < j)
        {
          ((List)localObject4).add(((n)localObject1).cNm().get(i));
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
            localObject5 = (dod)((Iterator)localObject4).next();
            str1 = com.tencent.mm.plugin.topstory.ui.d.bs(((dod)localObject5).tSk, ((dod)localObject5).HCu);
            if (localm.Bvw.containsKey(str1))
            {
              localObject1 = (doe)localm.Bvw.get(str1);
              ((HashMap)localObject3).put(str1, localObject1);
              j = (int)m.ao(a.a.BqT.longValue(), ((dod)localObject5).HCB);
              if (j >= 20) {
                break label629;
              }
              i = 20;
              if (((doe)localObject1).HCQ >= i) {
                break label643;
              }
              str2 = localm.BtO.epy() + str1 + ".mp4";
              localObject5 = ((dod)localObject5).videoUrl;
              localh = new com.tencent.mm.i.h();
              localh.fJi = "task_TopStoryPreloadMgr";
              localh.field_mediaId = str1;
              localh.url = ((String)localObject5);
              localh.fJz = 2;
              localh.fJF = 2;
              localh.fJA = 3;
              localh.fJK = i;
              localh.field_preloadRatio = i;
              localh.concurrentCount = 4;
              localh.field_fullpath = str2;
              localh.fJj = new m.d(localm, (byte)0);
              localh.fJB = new m.c(localm, (byte)0);
              com.tencent.mm.ao.f.aGI().b(localh, -1);
              ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((doe)localObject1).HCQ), Integer.valueOf(i) });
              if (((HashMap)localObject3).size() != 6) {
                break label671;
              }
            }
          }
          else
          {
            localm.Bvx.clear();
            localm.Bvx.addAll(((HashMap)localObject3).keySet());
            localm.Bvw.putAll((Map)localObject3);
            com.tencent.mm.sdk.g.b.c(new m.a(localm, localm.Bvv), "TopStory.DeleteVideoCacheTask");
            AppMethodBeat.o(126204);
            return;
          }
          localObject1 = new doe();
          ((doe)localObject1).mediaId = str1;
          ((doe)localObject1).HCB = ((dod)localObject5).HCB;
          continue;
          label629:
          i = j;
          if (j > 100)
          {
            i = 100;
            continue;
            label643:
            ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((doe)localObject1).HCQ) });
            continue;
            label671:
            continue;
            label673:
            i = -1;
            if ((i >= 0) && (i + 1 < j))
            {
              i += 1;
              continue;
              label693:
              i += 1;
            }
          }
        }
      }
    }
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(126203);
      if (r.this.BtO != null)
      {
        Object localObject = r.this.BtO.epA();
        if (((m)localObject).Bvw.containsKey(paramString))
        {
          doe localdoe = (doe)((m)localObject).Bvw.get(paramString);
          localdoe.mediaId = paramString;
          localdoe.HCB = paramLong2;
          localdoe.HCP = paramLong1;
          localdoe.HCQ = m.ao(localdoe.HCP, localdoe.HCB);
          ((m)localObject).Bvw.put(paramString, localdoe);
        }
        localObject = r.this.BtO.epx().BvO;
        if (localObject != null) {
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Bry = paramLong2;
        }
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126199);
          if (r.this.BvS != null) {
            r.this.BvS.i(paramString, paramLong1, this.tYW);
          }
          if (r.ap(paramLong1 * 100L / this.tYW, paramLong1)) {
            r.a.this.eqF();
          }
          AppMethodBeat.o(126199);
        }
      });
      AppMethodBeat.o(126203);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(126202);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126198);
          if (r.this.BvS != null) {
            r.this.BvS.onDataAvailable(paramString, paramLong1, this.llK);
          }
          AppMethodBeat.o(126198);
        }
      });
      AppMethodBeat.o(126202);
    }
  }
  
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    private doe Bwe;
    
    private b() {}
    
    public final void a(b.a parama) {}
    
    public final void gj(String paramString)
    {
      AppMethodBeat.i(126207);
      com.tencent.mm.modelvideo.o.aMK().m(paramString, null);
      AppMethodBeat.o(126207);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126209);
      if ((this.Bwe != null) && (paramInt1 + paramInt2 <= this.Bwe.HCP)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramInt1 == 0) && (bool1) && (r.this.BtO != null))
        {
          com.tencent.mm.plugin.topstory.a.b.b localb = r.this.BtO.epx().BvO;
          if ((localb != null) && (localb.Bru == 0L))
          {
            localb.Bru = (System.currentTimeMillis() - localb.Bre);
            localb.Brv = paramInt1;
            localb.Brw = (paramInt1 + paramInt2);
            ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(localb.Brr), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
        }
        boolean bool2 = bool1;
        if (!bool1) {
          bool2 = com.tencent.mm.modelvideo.o.aMK().isVideoDataAvailable(paramString, paramInt1, paramInt2);
        }
        AppMethodBeat.o(126209);
        return bool2;
      }
    }
    
    public final void p(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(126206);
      ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
      if (r.this.BtO == null)
      {
        AppMethodBeat.o(126206);
        return;
      }
      Object localObject2 = r.this.BtO.epA();
      Object localObject3 = ((m)localObject2).BtO.epx().BvO;
      Object localObject1;
      boolean bool;
      if (localObject3 != null)
      {
        if (!((m)localObject2).Bvw.containsKey(paramString1)) {
          break label509;
        }
        localObject1 = (doe)((m)localObject2).Bvw.get(paramString1);
        if (((doe)localObject1).HCQ >= 5L)
        {
          ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((doe)localObject1).HCQ), bt.Dd(((doe)localObject1).HCP) });
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).Brm = 1L;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).Brn = ((doe)localObject1).HCQ;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).Bro = ((doe)localObject1).HCP;
          com.tencent.mm.plugin.websearch.api.a.a.ma(25);
          this.Bwe = ((doe)localObject1);
          localObject1 = new r.a(r.this, (byte)0);
          if (this.Bwe == null) {
            break label562;
          }
          localObject2 = new long[2];
          if (this.Bwe.HCQ >= 100L) {
            break label541;
          }
          com.tencent.mm.modelvideo.o.aMK().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
          localObject3 = new CdnLogic.C2CDownloadRequest();
          ((CdnLogic.C2CDownloadRequest)localObject3).fileKey = paramString1;
          ((CdnLogic.C2CDownloadRequest)localObject3).fileType = 90;
          ((CdnLogic.C2CDownloadRequest)localObject3).url = paramString3;
          ((CdnLogic.C2CDownloadRequest)localObject3).setSavePath(paramString2);
          bool = CdnLogic.queryVideoMoovInfo((CdnLogic.C2CDownloadRequest)localObject3, (long[])localObject2);
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[] { paramString1, Boolean.valueOf(bool) });
        if ((bool) && (!((r.a)localObject1).Bwb)) {
          ((r.a)localObject1).a(paramString1, (int)localObject2[0], (int)localObject2[1], "");
        }
        if (r.ap(this.Bwe.HCQ, this.Bwe.HCP)) {
          ((r.a)localObject1).eqF();
        }
        paramString2 = r.this.BtO.epx().BvO;
        if (paramString2 != null) {
          paramString2.Bry = this.Bwe.HCB;
        }
        if (this.Bwe.HCQ == 100L)
        {
          ((r.a)localObject1).i(paramString1, (int)this.Bwe.HCP, (int)this.Bwe.HCB);
          ((r.a)localObject1).a(paramString1, 0, null);
        }
        AppMethodBeat.o(126206);
        return;
        ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((doe)localObject1).HCQ), bt.Dd(((doe)localObject1).HCP) });
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).Brm = 3L;
        for (;;)
        {
          ((m)localObject2).equ();
          localObject1 = null;
          break;
          label509:
          localObject1 = new doe();
          ((doe)localObject1).mediaId = paramString1;
          ((m)localObject2).Bvw.put(paramString1, localObject1);
        }
        label541:
        bool = true;
        localObject2[0] = new com.tencent.mm.plugin.a.b().IZ(paramString2);
      }
      label562:
      com.tencent.mm.modelvideo.o.aMK().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
      AppMethodBeat.o(126206);
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126208);
      if ((this.Bwe != null) && (paramInt1 + paramInt2 <= this.Bwe.HCP))
      {
        AppMethodBeat.o(126208);
        return;
      }
      com.tencent.mm.modelvideo.o.aMK();
      com.tencent.mm.ao.e.r(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(126208);
    }
  }
  
  final class c
    implements i.c
  {
    private c() {}
    
    public final void qQ(long paramLong)
    {
      AppMethodBeat.i(126210);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(600L, paramLong, 1L, false);
      AppMethodBeat.o(126210);
    }
    
    public final void vk(String paramString)
    {
      AppMethodBeat.i(126211);
      com.tencent.mm.plugin.report.e.ygI.kvStat(14349, paramString);
      AppMethodBeat.o(126211);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */