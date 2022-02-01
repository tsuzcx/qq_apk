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
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ddc;
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
  private com.tencent.mm.model.d qnr;
  private int xWr;
  public ddb yLY;
  b yOm;
  q yQq;
  public f yQr;
  public boolean yQs;
  public boolean yQt;
  public boolean yQu;
  private d.a yQv;
  private boolean yQw;
  private boolean yQx;
  
  public r()
  {
    AppMethodBeat.i(126212);
    this.xWr = 0;
    this.yQu = false;
    this.yQv = new d.a()
    {
      public final void aqt() {}
      
      public final void aqu() {}
      
      public final void aqv() {}
      
      public final void aqw() {}
    };
    this.qnr = new com.tencent.mm.model.d();
    AppMethodBeat.o(126212);
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(126218);
    this.qnr.ea(false);
    AppMethodBeat.o(126218);
  }
  
  public static boolean ap(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void dPM()
  {
    AppMethodBeat.i(126215);
    if (this.yQq.getParent() != null) {
      ((ViewGroup)this.yQq.getParent()).removeView(this.yQq);
    }
    AppMethodBeat.o(126215);
  }
  
  private q dPN()
  {
    AppMethodBeat.i(126216);
    q localq = new q(this.yOm.cKW(), this.yOm);
    localq.setRootPath(this.yOm.dOG());
    localq.setIOnlineVideoProxy(new b((byte)0));
    localq.setReporter(new c((byte)0));
    AppMethodBeat.o(126216);
    return localq;
  }
  
  private void requestAudioFocus()
  {
    AppMethodBeat.i(126217);
    this.qnr.a(this.yQv);
    AppMethodBeat.o(126217);
  }
  
  public final void a(b paramb, ddb paramddb, String paramString, int paramInt)
  {
    AppMethodBeat.i(126214);
    if (paramddb.Evh != null) {
      paramddb.Evh.ddw = false;
    }
    ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { paramddb.rNP, paramddb.title, paramString });
    paramb.dOF().b(paramb.dOH());
    paramb.dOF().dPI();
    paramb.dOF().a(paramddb, paramInt, paramString);
    this.yQq.setKeepScreenOn(true);
    this.yQq.dPL();
    this.yQq.asJ(paramString);
    this.yLY = paramddb;
    this.yQs = true;
    this.yQt = false;
    ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramddb.rNP, Integer.valueOf(0));
    AppMethodBeat.o(126214);
  }
  
  public final void a(f paramf, h.e parame)
  {
    AppMethodBeat.i(126213);
    if ((paramf == this.yQr) || (this.yOm == null))
    {
      AppMethodBeat.o(126213);
      return;
    }
    if (this.yQq == null) {
      this.yQq = dPN();
    }
    dPM();
    paramf.getVideoViewParent().addView(this.yQq);
    this.yQq.setVideoFooterView(paramf.getControlBar());
    this.yQq.setScaleType(parame);
    this.yQq.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.qnr.a(this.yQv);
    this.yQr = paramf;
    AppMethodBeat.o(126213);
  }
  
  public final void asK(String paramString)
  {
    AppMethodBeat.i(126229);
    com.tencent.mm.plugin.topstory.a.b.b localb = this.yOm.dOF().yQm;
    if (localb != null) {
      localb.yLD = 1L;
    }
    if ((this.yQq != null) && (this.yQq.getSessionId().equals(paramString)))
    {
      if (this.yLY != null) {
        ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.yLY.rNP);
      }
      stopPlay();
    }
    com.tencent.mm.plugin.websearch.api.a.a.lI(26);
    AppMethodBeat.o(126229);
  }
  
  public final void ckd()
  {
    AppMethodBeat.i(126222);
    if (this.yQq != null)
    {
      abandonAudioFocus();
      this.yQq.setKeepScreenOn(false);
      this.yQq.pause();
      this.yQt = true;
    }
    AppMethodBeat.o(126222);
  }
  
  public final void d(b paramb)
  {
    this.xWr += 1;
    this.yOm = paramb;
  }
  
  public final boolean dPO()
  {
    AppMethodBeat.i(126219);
    if (this.yQq != null)
    {
      boolean bool = this.yQq.isPlaying();
      AppMethodBeat.o(126219);
      return bool;
    }
    AppMethodBeat.o(126219);
    return false;
  }
  
  public final void dzF()
  {
    AppMethodBeat.i(126221);
    if (this.yQq != null)
    {
      requestAudioFocus();
      this.yQq.setKeepScreenOn(true);
      this.yQq.play();
      this.yQt = false;
    }
    AppMethodBeat.o(126221);
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126232);
    if (this.yQq != null)
    {
      int i = this.yQq.getCurrPosMs();
      AppMethodBeat.o(126232);
      return i;
    }
    AppMethodBeat.o(126232);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126230);
    if (this.yQq != null)
    {
      int i = this.yQq.getCurrPosSec();
      AppMethodBeat.o(126230);
      return i;
    }
    AppMethodBeat.o(126230);
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(126231);
    if (this.yQq != null)
    {
      int i = this.yQq.getVideoDurationSec();
      AppMethodBeat.o(126231);
      return i;
    }
    AppMethodBeat.o(126231);
    return 0;
  }
  
  public final void hM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126228);
    if (paramInt1 == 0)
    {
      if ((this.yQs) && (this.yQx))
      {
        this.yQx = false;
        dzF();
        AppMethodBeat.o(126228);
      }
    }
    else if (paramInt2 == 0)
    {
      if ((this.yQs) && (dPO()))
      {
        this.yQx = true;
        ckd();
        AppMethodBeat.o(126228);
      }
    }
    else if ((paramInt2 == 1) && (this.yQw) && (this.yQs) && (this.yQt))
    {
      this.yQw = false;
      dzF();
      this.yQr.dPc();
    }
    AppMethodBeat.o(126228);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(126227);
    if ((this.yQq != null) && (this.yQq.getSessionId().equals(paramString))) {
      stopPlay();
    }
    AppMethodBeat.o(126227);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126226);
    this.xWr -= 1;
    ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.xWr) });
    if (this.xWr <= 0)
    {
      if (this.yQq != null)
      {
        stopPlay();
        this.yQq.onUIDestroy();
      }
      this.yOm = null;
    }
    AppMethodBeat.o(126226);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126225);
    if (this.yQq != null) {
      this.yQq.onUIPause();
    }
    AppMethodBeat.o(126225);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126224);
    if (this.yQq != null)
    {
      this.yQq.onUIResume();
      if (this.yQr != null) {
        this.yQr.dPf();
      }
    }
    AppMethodBeat.o(126224);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(126220);
    if (this.yQq != null) {
      this.yQq.setMute(paramBoolean);
    }
    AppMethodBeat.o(126220);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(126223);
    if (this.yQq != null)
    {
      ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      abandonAudioFocus();
      this.yQq.dPK();
      this.yQq.setKeepScreenOn(false);
      this.yQq.stop();
      this.yLY = null;
      this.yQs = false;
      this.yQt = false;
      if (this.yOm != null)
      {
        this.yOm.dOF().b(this.yOm.dOH());
        this.yOm.dOF().dPI();
      }
      if (this.yQr != null) {
        this.yQr.dPg();
      }
    }
    AppMethodBeat.o(126223);
  }
  
  final class a
    implements h.a
  {
    private boolean yQA;
    boolean yQz;
    
    private a() {}
    
    public final void a(final String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(126205);
      final int i = paramInt;
      if (com.tencent.mm.plugin.topstory.a.h.dNT())
      {
        i = paramInt;
        if (r.this.yQu)
        {
          r.this.yQu = false;
          i = 404;
        }
      }
      ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
      Object localObject1;
      Object localObject2;
      if (r.this.yOm != null)
      {
        localObject1 = r.this.yOm.dOI();
        if (((m)localObject1).yPU.containsKey(paramString))
        {
          localObject2 = (ddc)((m)localObject1).yPU.get(paramString);
          if (i == 0)
          {
            ((ddc)localObject2).mediaId = paramString;
            ((ddc)localObject2).Evi = ((ddc)localObject2).EuU;
            ((ddc)localObject2).Evj = m.ao(((ddc)localObject2).Evi, ((ddc)localObject2).EuU);
            ((m)localObject1).yPU.put(paramString, localObject2);
          }
          ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(((ddc)localObject2).Evj), bt.a(((ddc)localObject2).Evi, 100.0D), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = r.this.yOm.dOT().Pq(r.this.yOm.dOM());
          int k = n.Xx();
          localObject1 = paramd;
          if (paramd == null) {
            localObject1 = new com.tencent.mm.i.d();
          }
          int m = ((ddb)localObject2).Eve;
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
          com.tencent.mm.plugin.report.e.vIY.kvStat(16270, paramd);
          if (i != 0)
          {
            paramd = new ckd();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("videoplayfailreport=1");
            ((StringBuilder)localObject3).append("&vt=").append(((ddb)localObject2).Eve);
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
            ((StringBuilder)localObject3).append("&cdnsourcetype=").append(((ddb)localObject2).Eva);
            ((StringBuilder)localObject3).append("&cdnscene=").append(((ddb)localObject2).EuZ);
            ((StringBuilder)localObject3).append("&expand=").append(((ddb)localObject2).EuP);
            paramd.Eff = ((StringBuilder)localObject3).toString();
            paramd.Eft = ((com.tencent.mm.i.d)localObject1).field_httpResponseHeader;
            paramd.sbz = ((ddb)localObject2).videoUrl;
            paramd.Efu = ((ddb)localObject2).Evc;
            ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", new Object[] { paramd.Eff, paramd.Eft, paramd.sbz, paramd.Efu });
            paramd = new w(paramd);
            g.aeS().a(paramd, 0);
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
            if ((r.this.yQq != null) && (r.this.yOm != null))
            {
              com.tencent.mm.plugin.topstory.a.b.b localb = r.this.yOm.dOF().yQm;
              if ((localb != null) && (localb.yLL == 0L)) {
                localb.yLL = (System.currentTimeMillis() - localb.yLz);
              }
              r.this.yQq.am(paramString, i);
              if (i != 0)
              {
                com.tencent.mm.plugin.websearch.api.a.a.lI(9);
                AppMethodBeat.o(126200);
                return;
              }
              com.tencent.mm.plugin.websearch.api.a.a.lI(27);
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
      AppMethodBeat.i(202282);
      if (!this.yQz)
      {
        this.yQz = true;
        if (r.this.yOm != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126197);
              if ((r.this.yQq != null) && (r.this.yOm != null))
              {
                com.tencent.mm.plugin.topstory.a.b.b localb = r.this.yOm.dOF().yQm;
                if ((localb != null) && (localb.yLM == 0L))
                {
                  localb.yLM = (System.currentTimeMillis() - localb.yLz);
                  localb.yLN = paramLong1;
                  localb.yLO = (paramLong1 + this.knN);
                  localb.yLS = paramString2;
                  ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(localb.yLM), Long.valueOf(paramLong1), Long.valueOf(this.knN) });
                }
                r.this.yQq.Bl(paramLong1);
              }
              AppMethodBeat.o(126197);
            }
          });
        }
        AppMethodBeat.o(202282);
        return;
      }
      AppMethodBeat.o(202282);
    }
    
    public final void dPP()
    {
      AppMethodBeat.i(126204);
      m localm;
      Object localObject3;
      Object localObject1;
      Object localObject4;
      if ((!this.yQA) && (r.this.yLY != null) && (r.this.yOm != null) && ((r.this.yOm.dOE().bVA()) || (com.tencent.mm.plugin.topstory.a.h.dNW())))
      {
        ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
        this.yQA = true;
        localm = r.this.yOm.dOI();
        localObject3 = r.this.yLY;
        localObject1 = localm.yOm.dOT();
        localObject4 = new ArrayList();
      }
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = ((n)localObject1).dPE().size();
          i = 0;
          if (i >= j) {
            break label665;
          }
          if (!((ddb)localObject3).rNP.equals(((ddb)((n)localObject1).dPE().get(i)).rNP)) {
            break label685;
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
          ((List)localObject4).add(((n)localObject1).dPE().get(i));
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
            localObject5 = (ddb)((Iterator)localObject4).next();
            str1 = com.tencent.mm.plugin.topstory.ui.d.bn(((ddb)localObject5).rNP, ((ddb)localObject5).EuN);
            if (localm.yPU.containsKey(str1))
            {
              localObject1 = (ddc)localm.yPU.get(str1);
              ((HashMap)localObject3).put(str1, localObject1);
              j = (int)m.ao(a.a.yLo.longValue(), ((ddb)localObject5).EuU);
              if (j >= 20) {
                break label621;
              }
              i = 20;
              if (((ddc)localObject1).Evj >= i) {
                break label635;
              }
              str2 = localm.yOm.dOG() + str1 + ".mp4";
              localObject5 = ((ddb)localObject5).videoUrl;
              localh = new com.tencent.mm.i.h();
              localh.field_mediaId = str1;
              localh.url = ((String)localObject5);
              localh.fnW = 2;
              localh.foc = 2;
              localh.fnX = 3;
              localh.foh = i;
              localh.field_preloadRatio = i;
              localh.concurrentCount = 4;
              localh.field_fullpath = str2;
              localh.fnH = new m.d(localm, (byte)0);
              localh.fnY = new m.c(localm, (byte)0);
              com.tencent.mm.ao.f.awL().b(localh, -1);
              ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((ddc)localObject1).Evj), Integer.valueOf(i) });
              if (((HashMap)localObject3).size() != 6) {
                break label663;
              }
            }
          }
          else
          {
            localm.yPV.clear();
            localm.yPV.addAll(((HashMap)localObject3).keySet());
            localm.yPU.putAll((Map)localObject3);
            com.tencent.mm.sdk.g.b.c(new m.a(localm, localm.yPT), "TopStory.DeleteVideoCacheTask");
            AppMethodBeat.o(126204);
            return;
          }
          localObject1 = new ddc();
          ((ddc)localObject1).mediaId = str1;
          ((ddc)localObject1).EuU = ((ddb)localObject5).EuU;
          continue;
          label621:
          i = j;
          if (j > 100)
          {
            i = 100;
            continue;
            label635:
            ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((ddc)localObject1).Evj) });
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
    
    public final void k(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(126203);
      if (r.this.yOm != null)
      {
        Object localObject = r.this.yOm.dOI();
        if (((m)localObject).yPU.containsKey(paramString))
        {
          ddc localddc = (ddc)((m)localObject).yPU.get(paramString);
          localddc.mediaId = paramString;
          localddc.EuU = paramLong2;
          localddc.Evi = paramLong1;
          localddc.Evj = m.ao(localddc.Evi, localddc.EuU);
          ((m)localObject).yPU.put(paramString, localddc);
        }
        localObject = r.this.yOm.dOF().yQm;
        if (localObject != null) {
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject).yLT = paramLong2;
        }
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126199);
          if (r.this.yQq != null) {
            r.this.yQq.k(paramString, paramLong1, this.rTo);
          }
          if (r.ap(paramLong1 * 100L / this.rTo, paramLong1)) {
            r.a.this.dPP();
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
          if (r.this.yQq != null) {
            r.this.yQq.onDataAvailable(paramString, paramLong1, this.knN);
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
    private ddc yQC;
    
    private b() {}
    
    public final void a(b.a parama) {}
    
    public final void fy(String paramString)
    {
      AppMethodBeat.i(126207);
      com.tencent.mm.modelvideo.o.aCJ().k(paramString, null);
      AppMethodBeat.o(126207);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126209);
      if ((this.yQC != null) && (paramInt1 + paramInt2 <= this.yQC.Evi)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramInt1 == 0) && (bool1) && (r.this.yOm != null))
        {
          com.tencent.mm.plugin.topstory.a.b.b localb = r.this.yOm.dOF().yQm;
          if ((localb != null) && (localb.yLP == 0L))
          {
            localb.yLP = (System.currentTimeMillis() - localb.yLz);
            localb.yLQ = paramInt1;
            localb.yLR = (paramInt1 + paramInt2);
            ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(localb.yLM), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
        }
        boolean bool2 = bool1;
        if (!bool1) {
          bool2 = com.tencent.mm.modelvideo.o.aCJ().isVideoDataAvailable(paramString, paramInt1, paramInt2);
        }
        AppMethodBeat.o(126209);
        return bool2;
      }
    }
    
    public final void q(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(126206);
      ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
      if (r.this.yOm == null)
      {
        AppMethodBeat.o(126206);
        return;
      }
      Object localObject2 = r.this.yOm.dOI();
      Object localObject3 = ((m)localObject2).yOm.dOF().yQm;
      Object localObject1;
      boolean bool;
      if (localObject3 != null)
      {
        if (!((m)localObject2).yPU.containsKey(paramString1)) {
          break label509;
        }
        localObject1 = (ddc)((m)localObject2).yPU.get(paramString1);
        if (((ddc)localObject1).Evj >= 5L)
        {
          ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((ddc)localObject1).Evj), bt.vK(((ddc)localObject1).Evi) });
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).yLH = 1L;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).yLI = ((ddc)localObject1).Evj;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).yLJ = ((ddc)localObject1).Evi;
          com.tencent.mm.plugin.websearch.api.a.a.lI(25);
          this.yQC = ((ddc)localObject1);
          localObject1 = new r.a(r.this, (byte)0);
          if (this.yQC == null) {
            break label562;
          }
          localObject2 = new long[2];
          if (this.yQC.Evj >= 100L) {
            break label541;
          }
          com.tencent.mm.modelvideo.o.aCJ().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
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
        if ((bool) && (!((r.a)localObject1).yQz)) {
          ((r.a)localObject1).a(paramString1, (int)localObject2[0], (int)localObject2[1], "");
        }
        if (r.ap(this.yQC.Evj, this.yQC.Evi)) {
          ((r.a)localObject1).dPP();
        }
        paramString2 = r.this.yOm.dOF().yQm;
        if (paramString2 != null) {
          paramString2.yLT = this.yQC.EuU;
        }
        if (this.yQC.Evj == 100L)
        {
          ((r.a)localObject1).k(paramString1, (int)this.yQC.Evi, (int)this.yQC.EuU);
          ((r.a)localObject1).a(paramString1, 0, null);
        }
        AppMethodBeat.o(126206);
        return;
        ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((ddc)localObject1).Evj), bt.vK(((ddc)localObject1).Evi) });
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).yLH = 3L;
        for (;;)
        {
          ((m)localObject2).dPD();
          localObject1 = null;
          break;
          label509:
          localObject1 = new ddc();
          ((ddc)localObject1).mediaId = paramString1;
          ((m)localObject2).yPU.put(paramString1, localObject1);
        }
        label541:
        bool = true;
        localObject2[0] = new com.tencent.mm.plugin.a.b().BG(paramString2);
      }
      label562:
      com.tencent.mm.modelvideo.o.aCJ().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
      AppMethodBeat.o(126206);
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126208);
      if ((this.yQC != null) && (paramInt1 + paramInt2 <= this.yQC.Evi))
      {
        AppMethodBeat.o(126208);
        return;
      }
      com.tencent.mm.modelvideo.o.aCJ();
      com.tencent.mm.ao.e.q(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(126208);
    }
  }
  
  final class c
    implements h.c
  {
    private c() {}
    
    public final void ln(long paramLong)
    {
      AppMethodBeat.i(126210);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(600L, paramLong, 1L, false);
      AppMethodBeat.o(126210);
    }
    
    public final void pj(String paramString)
    {
      AppMethodBeat.i(126211);
      com.tencent.mm.plugin.report.e.vIY.kvStat(14349, paramString);
      AppMethodBeat.o(126211);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */