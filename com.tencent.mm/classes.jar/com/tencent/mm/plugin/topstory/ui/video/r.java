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
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class r
{
  private int ASI;
  public dpa BJb;
  b BLm;
  q BNq;
  public f BNr;
  public boolean BNs;
  public boolean BNt;
  public boolean BNu;
  private d.a BNv;
  private boolean BNw;
  private boolean BNx;
  private com.tencent.mm.model.d hdv;
  
  public r()
  {
    AppMethodBeat.i(126212);
    this.ASI = 0;
    this.BNu = false;
    this.BNv = new d.a()
    {
      public final void aAo() {}
      
      public final void aAp() {}
      
      public final void aAq() {}
      
      public final void aAr() {}
    };
    this.hdv = new com.tencent.mm.model.d();
    AppMethodBeat.o(126212);
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(126218);
    this.hdv.ez(false);
    AppMethodBeat.o(126218);
  }
  
  public static boolean ao(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void euj()
  {
    AppMethodBeat.i(126215);
    if (this.BNq.getParent() != null) {
      ((ViewGroup)this.BNq.getParent()).removeView(this.BNq);
    }
    AppMethodBeat.o(126215);
  }
  
  private q euk()
  {
    AppMethodBeat.i(126216);
    q localq = new q(this.BLm.dkN(), this.BLm);
    localq.setRootPath(this.BLm.etf());
    localq.setIOnlineVideoProxy(new b((byte)0));
    localq.setReporter(new r.c(this, (byte)0));
    AppMethodBeat.o(126216);
    return localq;
  }
  
  private void requestAudioFocus()
  {
    AppMethodBeat.i(126217);
    this.hdv.a(this.BNv);
    AppMethodBeat.o(126217);
  }
  
  public final void a(b paramb, dpa paramdpa, String paramString, int paramInt)
  {
    AppMethodBeat.i(126214);
    if (paramdpa.HWB != null) {
      paramdpa.HWB.dnq = false;
    }
    ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { paramdpa.udb, paramdpa.title, paramString });
    paramb.ete().b(paramb.etg());
    paramb.ete().euf();
    paramb.ete().a(paramdpa, paramInt, paramString);
    this.BNq.setKeepScreenOn(true);
    this.BNq.eui();
    this.BNq.aEq(paramString);
    this.BJb = paramdpa;
    this.BNs = true;
    this.BNt = false;
    ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramdpa.udb, Integer.valueOf(0));
    AppMethodBeat.o(126214);
  }
  
  public final void a(f paramf, i.e parame)
  {
    AppMethodBeat.i(126213);
    if ((paramf == this.BNr) || (this.BLm == null))
    {
      AppMethodBeat.o(126213);
      return;
    }
    if (this.BNq == null) {
      this.BNq = euk();
    }
    euj();
    paramf.getVideoViewParent().addView(this.BNq);
    this.BNq.setVideoFooterView(paramf.getControlBar());
    this.BNq.setScaleType(parame);
    this.BNq.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.hdv.a(this.BNv);
    this.BNr = paramf;
    AppMethodBeat.o(126213);
  }
  
  public final void aEr(String paramString)
  {
    AppMethodBeat.i(126229);
    com.tencent.mm.plugin.topstory.a.b.b localb = this.BLm.ete().BNm;
    if (localb != null) {
      localb.BIH = 1L;
    }
    if ((this.BNq != null) && (this.BNq.getSessionId().equals(paramString)))
    {
      if (this.BJb != null) {
        ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.BJb.udb);
      }
      stopPlay();
    }
    com.tencent.mm.plugin.websearch.api.a.a.md(26);
    AppMethodBeat.o(126229);
  }
  
  public final void cyX()
  {
    AppMethodBeat.i(126222);
    if (this.BNq != null)
    {
      abandonAudioFocus();
      this.BNq.setKeepScreenOn(false);
      this.BNq.pause();
      this.BNt = true;
    }
    AppMethodBeat.o(126222);
  }
  
  public final void d(b paramb)
  {
    this.ASI += 1;
    this.BLm = paramb;
  }
  
  public final void edW()
  {
    AppMethodBeat.i(126221);
    if (this.BNq != null)
    {
      requestAudioFocus();
      this.BNq.setKeepScreenOn(true);
      this.BNq.play();
      this.BNt = false;
    }
    AppMethodBeat.o(126221);
  }
  
  public final boolean eul()
  {
    AppMethodBeat.i(126219);
    if (this.BNq != null)
    {
      boolean bool = this.BNq.isPlaying();
      AppMethodBeat.o(126219);
      return bool;
    }
    AppMethodBeat.o(126219);
    return false;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126232);
    if (this.BNq != null)
    {
      int i = this.BNq.getCurrPosMs();
      AppMethodBeat.o(126232);
      return i;
    }
    AppMethodBeat.o(126232);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126230);
    if (this.BNq != null)
    {
      int i = this.BNq.getCurrPosSec();
      AppMethodBeat.o(126230);
      return i;
    }
    AppMethodBeat.o(126230);
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(126231);
    if (this.BNq != null)
    {
      int i = this.BNq.getVideoDurationSec();
      AppMethodBeat.o(126231);
      return i;
    }
    AppMethodBeat.o(126231);
    return 0;
  }
  
  public final void ip(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126228);
    if (paramInt1 == 0)
    {
      if ((this.BNs) && (this.BNx))
      {
        this.BNx = false;
        edW();
        AppMethodBeat.o(126228);
      }
    }
    else if (paramInt2 == 0)
    {
      if ((this.BNs) && (eul()))
      {
        this.BNx = true;
        cyX();
        AppMethodBeat.o(126228);
      }
    }
    else if ((paramInt2 == 1) && (this.BNw) && (this.BNs) && (this.BNt))
    {
      this.BNw = false;
      edW();
      this.BNr.etB();
    }
    AppMethodBeat.o(126228);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(126227);
    if ((this.BNq != null) && (this.BNq.getSessionId().equals(paramString))) {
      stopPlay();
    }
    AppMethodBeat.o(126227);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126226);
    this.ASI -= 1;
    ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.ASI) });
    if (this.ASI <= 0)
    {
      if (this.BNq != null)
      {
        stopPlay();
        this.BNq.onUIDestroy();
      }
      this.BLm = null;
    }
    AppMethodBeat.o(126226);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126225);
    if (this.BNq != null) {
      this.BNq.onUIPause();
    }
    AppMethodBeat.o(126225);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126224);
    if (this.BNq != null)
    {
      this.BNq.onUIResume();
      if (this.BNr != null) {
        this.BNr.etE();
      }
    }
    AppMethodBeat.o(126224);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(126220);
    if (this.BNq != null) {
      this.BNq.setMute(paramBoolean);
    }
    AppMethodBeat.o(126220);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(126223);
    if (this.BNq != null)
    {
      ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      abandonAudioFocus();
      this.BNq.euh();
      this.BNq.setKeepScreenOn(false);
      this.BNq.stop();
      this.BJb = null;
      this.BNs = false;
      this.BNt = false;
      if (this.BLm != null)
      {
        this.BLm.ete().b(this.BLm.etg());
        this.BLm.ete().euf();
      }
      if (this.BNr != null) {
        this.BNr.etF();
      }
    }
    AppMethodBeat.o(126223);
  }
  
  final class a
    implements h.a
  {
    private boolean BNA;
    boolean BNz;
    
    private a() {}
    
    public final void a(final String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(126205);
      final int i = paramInt;
      if (com.tencent.mm.plugin.topstory.a.h.esr())
      {
        i = paramInt;
        if (r.this.BNu)
        {
          r.this.BNu = false;
          i = 404;
        }
      }
      ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
      Object localObject1;
      Object localObject2;
      if (r.this.BLm != null)
      {
        localObject1 = r.this.BLm.eth();
        if (((m)localObject1).BMU.containsKey(paramString))
        {
          localObject2 = (dpb)((m)localObject1).BMU.get(paramString);
          if (i == 0)
          {
            ((dpb)localObject2).mediaId = paramString;
            ((dpb)localObject2).HWC = ((dpb)localObject2).HWo;
            ((dpb)localObject2).HWD = m.an(((dpb)localObject2).HWC, ((dpb)localObject2).HWo);
            ((m)localObject1).BMU.put(paramString, localObject2);
          }
          ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(((dpb)localObject2).HWD), bu.a(((dpb)localObject2).HWC, 100.0D), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = r.this.BLm.ets().TN(r.this.BLm.etl());
          int k = n.abf();
          localObject1 = paramd;
          if (paramd == null) {
            localObject1 = new com.tencent.mm.i.d();
          }
          int m = ((dpa)localObject2).HWy;
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
          ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", new Object[] { paramd });
          com.tencent.mm.plugin.report.e.ywz.kvStat(16270, paramd);
          if (i != 0)
          {
            paramd = new cvj();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("videoplayfailreport=1");
            ((StringBuilder)localObject3).append("&vt=").append(((dpa)localObject2).HWy);
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
            ((StringBuilder)localObject3).append("&cdnsourcetype=").append(((dpa)localObject2).HWu);
            ((StringBuilder)localObject3).append("&cdnscene=").append(((dpa)localObject2).HWt);
            ((StringBuilder)localObject3).append("&expand=").append(((dpa)localObject2).HWj);
            paramd.HFU = ((StringBuilder)localObject3).toString();
            paramd.HGi = ((com.tencent.mm.i.d)localObject1).field_httpResponseHeader;
            paramd.usR = ((dpa)localObject2).videoUrl;
            paramd.HGj = ((dpa)localObject2).HWw;
            ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", new Object[] { paramd.HFU, paramd.HGi, paramd.usR, paramd.HGj });
            paramd = new z(paramd);
            g.ajj().a(paramd, 0);
          }
        }
        catch (Exception paramd)
        {
          int j;
          continue;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126200);
            if ((r.this.BNq != null) && (r.this.BLm != null))
            {
              com.tencent.mm.plugin.topstory.a.b.b localb = r.this.BLm.ete().BNm;
              if ((localb != null) && (localb.BIP == 0L)) {
                localb.BIP = (System.currentTimeMillis() - localb.BID);
              }
              r.this.BNq.at(paramString, i);
              if (i != 0)
              {
                com.tencent.mm.plugin.websearch.api.a.a.md(9);
                AppMethodBeat.o(126200);
                return;
              }
              com.tencent.mm.plugin.websearch.api.a.a.md(27);
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
      AppMethodBeat.i(220240);
      if (!this.BNz)
      {
        this.BNz = true;
        if (r.this.BLm != null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126197);
              if ((r.this.BNq != null) && (r.this.BLm != null))
              {
                com.tencent.mm.plugin.topstory.a.b.b localb = r.this.BLm.ete().BNm;
                if ((localb != null) && (localb.BIQ == 0L))
                {
                  localb.BIQ = (System.currentTimeMillis() - localb.BID);
                  localb.BIR = paramLong1;
                  localb.BIS = (paramLong1 + this.lqk);
                  localb.BIW = paramString2;
                  ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(localb.BIQ), Long.valueOf(paramLong1), Long.valueOf(this.lqk) });
                }
                r.this.BNq.sC(paramLong1);
              }
              AppMethodBeat.o(126197);
            }
          });
        }
        AppMethodBeat.o(220240);
        return;
      }
      AppMethodBeat.o(220240);
    }
    
    public final void eum()
    {
      AppMethodBeat.i(126204);
      m localm;
      Object localObject3;
      Object localObject1;
      Object localObject4;
      if ((!this.BNA) && (r.this.BJb != null) && (r.this.BLm != null) && ((r.this.BLm.etd().ciH()) || (com.tencent.mm.plugin.topstory.a.h.esu())))
      {
        ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
        this.BNA = true;
        localm = r.this.BLm.eth();
        localObject3 = r.this.BJb;
        localObject1 = localm.BLm.ets();
        localObject4 = new ArrayList();
      }
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = ((n)localObject1).cPU().size();
          i = 0;
          if (i >= j) {
            break label673;
          }
          if (!((dpa)localObject3).udb.equals(((dpa)((n)localObject1).cPU().get(i)).udb)) {
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
          ((List)localObject4).add(((n)localObject1).cPU().get(i));
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
            localObject5 = (dpa)((Iterator)localObject4).next();
            str1 = com.tencent.mm.plugin.topstory.ui.d.bt(((dpa)localObject5).udb, ((dpa)localObject5).HWh);
            if (localm.BMU.containsKey(str1))
            {
              localObject1 = (dpb)localm.BMU.get(str1);
              ((HashMap)localObject3).put(str1, localObject1);
              j = (int)m.an(a.a.BIs.longValue(), ((dpa)localObject5).HWo);
              if (j >= 20) {
                break label629;
              }
              i = 20;
              if (((dpb)localObject1).HWD >= i) {
                break label643;
              }
              str2 = localm.BLm.etf() + str1 + ".mp4";
              localObject5 = ((dpa)localObject5).videoUrl;
              localh = new com.tencent.mm.i.h();
              localh.fLl = "task_TopStoryPreloadMgr";
              localh.field_mediaId = str1;
              localh.url = ((String)localObject5);
              localh.fLC = 2;
              localh.fLI = 2;
              localh.fLD = 3;
              localh.fLN = i;
              localh.field_preloadRatio = i;
              localh.concurrentCount = 4;
              localh.field_fullpath = str2;
              localh.fLm = new m.d(localm, (byte)0);
              localh.fLE = new m.c(localm, (byte)0);
              com.tencent.mm.an.f.aGZ().b(localh, -1);
              ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((dpb)localObject1).HWD), Integer.valueOf(i) });
              if (((HashMap)localObject3).size() != 6) {
                break label671;
              }
            }
          }
          else
          {
            localm.BMV.clear();
            localm.BMV.addAll(((HashMap)localObject3).keySet());
            localm.BMU.putAll((Map)localObject3);
            com.tencent.mm.sdk.g.b.c(new m.a(localm, localm.BMT), "TopStory.DeleteVideoCacheTask");
            AppMethodBeat.o(126204);
            return;
          }
          localObject1 = new dpb();
          ((dpb)localObject1).mediaId = str1;
          ((dpb)localObject1).HWo = ((dpa)localObject5).HWo;
          continue;
          label629:
          i = j;
          if (j > 100)
          {
            i = 100;
            continue;
            label643:
            ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((dpb)localObject1).HWD) });
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
      if (r.this.BLm != null)
      {
        Object localObject = r.this.BLm.eth();
        if (((m)localObject).BMU.containsKey(paramString))
        {
          dpb localdpb = (dpb)((m)localObject).BMU.get(paramString);
          localdpb.mediaId = paramString;
          localdpb.HWo = paramLong2;
          localdpb.HWC = paramLong1;
          localdpb.HWD = m.an(localdpb.HWC, localdpb.HWo);
          ((m)localObject).BMU.put(paramString, localdpb);
        }
        localObject = r.this.BLm.ete().BNm;
        if (localObject != null) {
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject).BIX = paramLong2;
        }
      }
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126199);
          if (r.this.BNq != null) {
            r.this.BNq.i(paramString, paramLong1, this.ujY);
          }
          if (r.ao(paramLong1 * 100L / this.ujY, paramLong1)) {
            r.a.this.eum();
          }
          AppMethodBeat.o(126199);
        }
      });
      AppMethodBeat.o(126203);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(126202);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126198);
          if (r.this.BNq != null) {
            r.this.BNq.onDataAvailable(paramString, paramLong1, this.lqk);
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
    private dpb BNC;
    
    private b() {}
    
    public final void a(b.a parama) {}
    
    public final void gp(String paramString)
    {
      AppMethodBeat.i(126207);
      com.tencent.mm.modelvideo.o.aNi().m(paramString, null);
      AppMethodBeat.o(126207);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126209);
      if ((this.BNC != null) && (paramInt1 + paramInt2 <= this.BNC.HWC)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramInt1 == 0) && (bool1) && (r.this.BLm != null))
        {
          com.tencent.mm.plugin.topstory.a.b.b localb = r.this.BLm.ete().BNm;
          if ((localb != null) && (localb.BIT == 0L))
          {
            localb.BIT = (System.currentTimeMillis() - localb.BID);
            localb.BIU = paramInt1;
            localb.BIV = (paramInt1 + paramInt2);
            ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(localb.BIQ), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
        }
        boolean bool2 = bool1;
        if (!bool1) {
          bool2 = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
        }
        AppMethodBeat.o(126209);
        return bool2;
      }
    }
    
    public final void p(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(126206);
      ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
      if (r.this.BLm == null)
      {
        AppMethodBeat.o(126206);
        return;
      }
      Object localObject2 = r.this.BLm.eth();
      Object localObject3 = ((m)localObject2).BLm.ete().BNm;
      Object localObject1;
      boolean bool;
      if (localObject3 != null)
      {
        if (!((m)localObject2).BMU.containsKey(paramString1)) {
          break label509;
        }
        localObject1 = (dpb)((m)localObject2).BMU.get(paramString1);
        if (((dpb)localObject1).HWD >= 5L)
        {
          ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((dpb)localObject1).HWD), bu.DB(((dpb)localObject1).HWC) });
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).BIL = 1L;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).BIM = ((dpb)localObject1).HWD;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).BIN = ((dpb)localObject1).HWC;
          com.tencent.mm.plugin.websearch.api.a.a.md(25);
          this.BNC = ((dpb)localObject1);
          localObject1 = new r.a(r.this, (byte)0);
          if (this.BNC == null) {
            break label562;
          }
          localObject2 = new long[2];
          if (this.BNC.HWD >= 100L) {
            break label541;
          }
          com.tencent.mm.modelvideo.o.aNi().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
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
        ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[] { paramString1, Boolean.valueOf(bool) });
        if ((bool) && (!((r.a)localObject1).BNz)) {
          ((r.a)localObject1).a(paramString1, (int)localObject2[0], (int)localObject2[1], "");
        }
        if (r.ao(this.BNC.HWD, this.BNC.HWC)) {
          ((r.a)localObject1).eum();
        }
        paramString2 = r.this.BLm.ete().BNm;
        if (paramString2 != null) {
          paramString2.BIX = this.BNC.HWo;
        }
        if (this.BNC.HWD == 100L)
        {
          ((r.a)localObject1).i(paramString1, (int)this.BNC.HWC, (int)this.BNC.HWo);
          ((r.a)localObject1).a(paramString1, 0, null);
        }
        AppMethodBeat.o(126206);
        return;
        ae.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((dpb)localObject1).HWD), bu.DB(((dpb)localObject1).HWC) });
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).BIL = 3L;
        for (;;)
        {
          ((m)localObject2).eub();
          localObject1 = null;
          break;
          label509:
          localObject1 = new dpb();
          ((dpb)localObject1).mediaId = paramString1;
          ((m)localObject2).BMU.put(paramString1, localObject1);
        }
        label541:
        bool = true;
        localObject2[0] = new com.tencent.mm.plugin.a.b().Jy(paramString2);
      }
      label562:
      com.tencent.mm.modelvideo.o.aNi().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
      AppMethodBeat.o(126206);
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126208);
      if ((this.BNC != null) && (paramInt1 + paramInt2 <= this.BNC.HWC))
      {
        AppMethodBeat.o(126208);
        return;
      }
      com.tencent.mm.modelvideo.o.aNi();
      com.tencent.mm.an.e.r(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(126208);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */