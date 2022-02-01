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
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class r
{
  b Acd;
  q Aeg;
  public f Aeh;
  public boolean Aei;
  public boolean Aej;
  public boolean Aek;
  private d.a Ael;
  private boolean Aem;
  private boolean Aen;
  private com.tencent.mm.model.d gGY;
  public dio zZQ;
  private int zjn;
  
  public r()
  {
    AppMethodBeat.i(126212);
    this.zjn = 0;
    this.Aek = false;
    this.Ael = new d.a()
    {
      public final void axj() {}
      
      public final void axk() {}
      
      public final void axl() {}
      
      public final void axm() {}
    };
    this.gGY = new com.tencent.mm.model.d();
    AppMethodBeat.o(126212);
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(126218);
    this.gGY.ev(false);
    AppMethodBeat.o(126218);
  }
  
  public static boolean am(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void eel()
  {
    AppMethodBeat.i(126215);
    if (this.Aeg.getParent() != null) {
      ((ViewGroup)this.Aeg.getParent()).removeView(this.Aeg);
    }
    AppMethodBeat.o(126215);
  }
  
  private q eem()
  {
    AppMethodBeat.i(126216);
    q localq = new q(this.Acd.cYC(), this.Acd);
    localq.setRootPath(this.Acd.edg());
    localq.setIOnlineVideoProxy(new b((byte)0));
    localq.setReporter(new c((byte)0));
    AppMethodBeat.o(126216);
    return localq;
  }
  
  private void requestAudioFocus()
  {
    AppMethodBeat.i(126217);
    this.gGY.a(this.Ael);
    AppMethodBeat.o(126217);
  }
  
  public final void a(b paramb, dio paramdio, String paramString, int paramInt)
  {
    AppMethodBeat.i(126214);
    if (paramdio.FSi != null) {
      paramdio.FSi.daU = false;
    }
    ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { paramdio.sVF, paramdio.title, paramString });
    paramb.edf().b(paramb.edh());
    paramb.edf().eeh();
    paramb.edf().a(paramdio, paramInt, paramString);
    this.Aeg.setKeepScreenOn(true);
    this.Aeg.eek();
    this.Aeg.axS(paramString);
    this.zZQ = paramdio;
    this.Aei = true;
    this.Aej = false;
    ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramdio.sVF, Integer.valueOf(0));
    AppMethodBeat.o(126214);
  }
  
  public final void a(f paramf, h.e parame)
  {
    AppMethodBeat.i(126213);
    if ((paramf == this.Aeh) || (this.Acd == null))
    {
      AppMethodBeat.o(126213);
      return;
    }
    if (this.Aeg == null) {
      this.Aeg = eem();
    }
    eel();
    paramf.getVideoViewParent().addView(this.Aeg);
    this.Aeg.setVideoFooterView(paramf.getControlBar());
    this.Aeg.setScaleType(parame);
    this.Aeg.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.gGY.a(this.Ael);
    this.Aeh = paramf;
    AppMethodBeat.o(126213);
  }
  
  public final void axT(String paramString)
  {
    AppMethodBeat.i(126229);
    com.tencent.mm.plugin.topstory.a.b.b localb = this.Acd.edf().Aec;
    if (localb != null) {
      localb.zZw = 1L;
    }
    if ((this.Aeg != null) && (this.Aeg.getSessionId().equals(paramString)))
    {
      if (this.zZQ != null) {
        ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.zZQ.sVF);
      }
      stopPlay();
    }
    com.tencent.mm.plugin.websearch.api.a.a.lA(26);
    AppMethodBeat.o(126229);
  }
  
  public final void crK()
  {
    AppMethodBeat.i(126222);
    if (this.Aeg != null)
    {
      abandonAudioFocus();
      this.Aeg.setKeepScreenOn(false);
      this.Aeg.pause();
      this.Aej = true;
    }
    AppMethodBeat.o(126222);
  }
  
  public final void d(b paramb)
  {
    this.zjn += 1;
    this.Acd = paramb;
  }
  
  public final void dOc()
  {
    AppMethodBeat.i(126221);
    if (this.Aeg != null)
    {
      requestAudioFocus();
      this.Aeg.setKeepScreenOn(true);
      this.Aeg.play();
      this.Aej = false;
    }
    AppMethodBeat.o(126221);
  }
  
  public final boolean een()
  {
    AppMethodBeat.i(126219);
    if (this.Aeg != null)
    {
      boolean bool = this.Aeg.isPlaying();
      AppMethodBeat.o(126219);
      return bool;
    }
    AppMethodBeat.o(126219);
    return false;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126232);
    if (this.Aeg != null)
    {
      int i = this.Aeg.getCurrPosMs();
      AppMethodBeat.o(126232);
      return i;
    }
    AppMethodBeat.o(126232);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126230);
    if (this.Aeg != null)
    {
      int i = this.Aeg.getCurrPosSec();
      AppMethodBeat.o(126230);
      return i;
    }
    AppMethodBeat.o(126230);
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(126231);
    if (this.Aeg != null)
    {
      int i = this.Aeg.getVideoDurationSec();
      AppMethodBeat.o(126231);
      return i;
    }
    AppMethodBeat.o(126231);
    return 0;
  }
  
  public final void hW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126228);
    if (paramInt1 == 0)
    {
      if ((this.Aei) && (this.Aen))
      {
        this.Aen = false;
        dOc();
        AppMethodBeat.o(126228);
      }
    }
    else if (paramInt2 == 0)
    {
      if ((this.Aei) && (een()))
      {
        this.Aen = true;
        crK();
        AppMethodBeat.o(126228);
      }
    }
    else if ((paramInt2 == 1) && (this.Aem) && (this.Aei) && (this.Aej))
    {
      this.Aem = false;
      dOc();
      this.Aeh.edC();
    }
    AppMethodBeat.o(126228);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(126227);
    if ((this.Aeg != null) && (this.Aeg.getSessionId().equals(paramString))) {
      stopPlay();
    }
    AppMethodBeat.o(126227);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126226);
    this.zjn -= 1;
    ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.zjn) });
    if (this.zjn <= 0)
    {
      if (this.Aeg != null)
      {
        stopPlay();
        this.Aeg.onUIDestroy();
      }
      this.Acd = null;
    }
    AppMethodBeat.o(126226);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126225);
    if (this.Aeg != null) {
      this.Aeg.onUIPause();
    }
    AppMethodBeat.o(126225);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126224);
    if (this.Aeg != null)
    {
      this.Aeg.onUIResume();
      if (this.Aeh != null) {
        this.Aeh.edF();
      }
    }
    AppMethodBeat.o(126224);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(126220);
    if (this.Aeg != null) {
      this.Aeg.setMute(paramBoolean);
    }
    AppMethodBeat.o(126220);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(126223);
    if (this.Aeg != null)
    {
      ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      abandonAudioFocus();
      this.Aeg.eej();
      this.Aeg.setKeepScreenOn(false);
      this.Aeg.stop();
      this.zZQ = null;
      this.Aei = false;
      this.Aej = false;
      if (this.Acd != null)
      {
        this.Acd.edf().b(this.Acd.edh());
        this.Acd.edf().eeh();
      }
      if (this.Aeh != null) {
        this.Aeh.edG();
      }
    }
    AppMethodBeat.o(126223);
  }
  
  final class a
    implements h.a
  {
    boolean Aep;
    private boolean Aeq;
    
    private a() {}
    
    public final void a(final String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(126205);
      final int i = paramInt;
      if (com.tencent.mm.plugin.topstory.a.h.ect())
      {
        i = paramInt;
        if (r.this.Aek)
        {
          r.this.Aek = false;
          i = 404;
        }
      }
      ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
      Object localObject1;
      Object localObject2;
      if (r.this.Acd != null)
      {
        localObject1 = r.this.Acd.edi();
        if (((m)localObject1).AdL.containsKey(paramString))
        {
          localObject2 = (dip)((m)localObject1).AdL.get(paramString);
          if (i == 0)
          {
            ((dip)localObject2).mediaId = paramString;
            ((dip)localObject2).FSj = ((dip)localObject2).FRV;
            ((dip)localObject2).FSk = m.al(((dip)localObject2).FSj, ((dip)localObject2).FRV);
            ((m)localObject1).AdL.put(paramString, localObject2);
          }
          ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(((dip)localObject2).FSk), bs.a(((dip)localObject2).FSj, 100.0D), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = r.this.Acd.edt().Rw(r.this.Acd.edm());
          int k = n.Yu();
          localObject1 = paramd;
          if (paramd == null) {
            localObject1 = new com.tencent.mm.i.d();
          }
          int m = ((dio)localObject2).FSf;
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
          ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", new Object[] { paramd });
          com.tencent.mm.plugin.report.e.wTc.kvStat(16270, paramd);
          if (i != 0)
          {
            paramd = new cpk();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("videoplayfailreport=1");
            ((StringBuilder)localObject3).append("&vt=").append(((dio)localObject2).FSf);
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
            ((StringBuilder)localObject3).append("&cdnsourcetype=").append(((dio)localObject2).FSb);
            ((StringBuilder)localObject3).append("&cdnscene=").append(((dio)localObject2).FSa);
            ((StringBuilder)localObject3).append("&expand=").append(((dio)localObject2).FRQ);
            paramd.FCf = ((StringBuilder)localObject3).toString();
            paramd.FCt = ((com.tencent.mm.i.d)localObject1).field_httpResponseHeader;
            paramd.tjt = ((dio)localObject2).videoUrl;
            paramd.FCu = ((dio)localObject2).FSd;
            ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", new Object[] { paramd.FCf, paramd.FCt, paramd.tjt, paramd.FCu });
            paramd = new v(paramd);
            g.agi().a(paramd, 0);
          }
        }
        catch (Exception paramd)
        {
          int j;
          continue;
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126200);
            if ((r.this.Aeg != null) && (r.this.Acd != null))
            {
              com.tencent.mm.plugin.topstory.a.b.b localb = r.this.Acd.edf().Aec;
              if ((localb != null) && (localb.zZE == 0L)) {
                localb.zZE = (System.currentTimeMillis() - localb.zZs);
              }
              r.this.Aeg.aq(paramString, i);
              if (i != 0)
              {
                com.tencent.mm.plugin.websearch.api.a.a.lA(9);
                AppMethodBeat.o(126200);
                return;
              }
              com.tencent.mm.plugin.websearch.api.a.a.lA(27);
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
      AppMethodBeat.i(206779);
      if (!this.Aep)
      {
        this.Aep = true;
        if (r.this.Acd != null) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126197);
              if ((r.this.Aeg != null) && (r.this.Acd != null))
              {
                com.tencent.mm.plugin.topstory.a.b.b localb = r.this.Acd.edf().Aec;
                if ((localb != null) && (localb.zZF == 0L))
                {
                  localb.zZF = (System.currentTimeMillis() - localb.zZs);
                  localb.zZG = paramLong1;
                  localb.zZH = (paramLong1 + this.kPh);
                  localb.zZL = paramString2;
                  ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(localb.zZF), Long.valueOf(paramLong1), Long.valueOf(this.kPh) });
                }
                r.this.Aeg.qq(paramLong1);
              }
              AppMethodBeat.o(126197);
            }
          });
        }
        AppMethodBeat.o(206779);
        return;
      }
      AppMethodBeat.o(206779);
    }
    
    public final void eeo()
    {
      AppMethodBeat.i(126204);
      m localm;
      Object localObject3;
      Object localObject1;
      Object localObject4;
      if ((!this.Aeq) && (r.this.zZQ != null) && (r.this.Acd != null) && ((r.this.Acd.ede().ccN()) || (com.tencent.mm.plugin.topstory.a.h.ecw())))
      {
        ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
        this.Aeq = true;
        localm = r.this.Acd.edi();
        localObject3 = r.this.zZQ;
        localObject1 = localm.Acd.edt();
        localObject4 = new ArrayList();
      }
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = ((n)localObject1).eed().size();
          i = 0;
          if (i >= j) {
            break label665;
          }
          if (!((dio)localObject3).sVF.equals(((dio)((n)localObject1).eed().get(i)).sVF)) {
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
          ((List)localObject4).add(((n)localObject1).eed().get(i));
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
            localObject5 = (dio)((Iterator)localObject4).next();
            str1 = com.tencent.mm.plugin.topstory.ui.d.bp(((dio)localObject5).sVF, ((dio)localObject5).FRO);
            if (localm.AdL.containsKey(str1))
            {
              localObject1 = (dip)localm.AdL.get(str1);
              ((HashMap)localObject3).put(str1, localObject1);
              j = (int)m.al(a.a.zZh.longValue(), ((dio)localObject5).FRV);
              if (j >= 20) {
                break label621;
              }
              i = 20;
              if (((dip)localObject1).FSk >= i) {
                break label635;
              }
              str2 = localm.Acd.edg() + str1 + ".mp4";
              localObject5 = ((dio)localObject5).videoUrl;
              localh = new com.tencent.mm.i.h();
              localh.field_mediaId = str1;
              localh.url = ((String)localObject5);
              localh.frq = 2;
              localh.frw = 2;
              localh.frr = 3;
              localh.frB = i;
              localh.field_preloadRatio = i;
              localh.concurrentCount = 4;
              localh.field_fullpath = str2;
              localh.frb = new m.d(localm, (byte)0);
              localh.frs = new m.c(localm, (byte)0);
              com.tencent.mm.an.f.aDD().b(localh, -1);
              ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((dip)localObject1).FSk), Integer.valueOf(i) });
              if (((HashMap)localObject3).size() != 6) {
                break label663;
              }
            }
          }
          else
          {
            localm.AdM.clear();
            localm.AdM.addAll(((HashMap)localObject3).keySet());
            localm.AdL.putAll((Map)localObject3);
            com.tencent.mm.sdk.g.b.c(new m.a(localm, localm.AdK), "TopStory.DeleteVideoCacheTask");
            AppMethodBeat.o(126204);
            return;
          }
          localObject1 = new dip();
          ((dip)localObject1).mediaId = str1;
          ((dip)localObject1).FRV = ((dio)localObject5).FRV;
          continue;
          label621:
          i = j;
          if (j > 100)
          {
            i = 100;
            continue;
            label635:
            ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((dip)localObject1).FSk) });
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
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(126203);
      if (r.this.Acd != null)
      {
        Object localObject = r.this.Acd.edi();
        if (((m)localObject).AdL.containsKey(paramString))
        {
          dip localdip = (dip)((m)localObject).AdL.get(paramString);
          localdip.mediaId = paramString;
          localdip.FRV = paramLong2;
          localdip.FSj = paramLong1;
          localdip.FSk = m.al(localdip.FSj, localdip.FRV);
          ((m)localObject).AdL.put(paramString, localdip);
        }
        localObject = r.this.Acd.edf().Aec;
        if (localObject != null) {
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject).zZM = paramLong2;
        }
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126199);
          if (r.this.Aeg != null) {
            r.this.Aeg.i(paramString, paramLong1, this.tbg);
          }
          if (r.am(paramLong1 * 100L / this.tbg, paramLong1)) {
            r.a.this.eeo();
          }
          AppMethodBeat.o(126199);
        }
      });
      AppMethodBeat.o(126203);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(126202);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126198);
          if (r.this.Aeg != null) {
            r.this.Aeg.onDataAvailable(paramString, paramLong1, this.kPh);
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
    private dip Aes;
    
    private b() {}
    
    public final void a(b.a parama) {}
    
    public final void fo(String paramString)
    {
      AppMethodBeat.i(126207);
      com.tencent.mm.modelvideo.o.aJz().k(paramString, null);
      AppMethodBeat.o(126207);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126209);
      if ((this.Aes != null) && (paramInt1 + paramInt2 <= this.Aes.FSj)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramInt1 == 0) && (bool1) && (r.this.Acd != null))
        {
          com.tencent.mm.plugin.topstory.a.b.b localb = r.this.Acd.edf().Aec;
          if ((localb != null) && (localb.zZI == 0L))
          {
            localb.zZI = (System.currentTimeMillis() - localb.zZs);
            localb.zZJ = paramInt1;
            localb.zZK = (paramInt1 + paramInt2);
            ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(localb.zZF), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
        }
        boolean bool2 = bool1;
        if (!bool1) {
          bool2 = com.tencent.mm.modelvideo.o.aJz().isVideoDataAvailable(paramString, paramInt1, paramInt2);
        }
        AppMethodBeat.o(126209);
        return bool2;
      }
    }
    
    public final void q(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(126206);
      ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
      if (r.this.Acd == null)
      {
        AppMethodBeat.o(126206);
        return;
      }
      Object localObject2 = r.this.Acd.edi();
      Object localObject3 = ((m)localObject2).Acd.edf().Aec;
      Object localObject1;
      boolean bool;
      if (localObject3 != null)
      {
        if (!((m)localObject2).AdL.containsKey(paramString1)) {
          break label509;
        }
        localObject1 = (dip)((m)localObject2).AdL.get(paramString1);
        if (((dip)localObject1).FSk >= 5L)
        {
          ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((dip)localObject1).FSk), bs.An(((dip)localObject1).FSj) });
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).zZA = 1L;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).zZB = ((dip)localObject1).FSk;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).zZC = ((dip)localObject1).FSj;
          com.tencent.mm.plugin.websearch.api.a.a.lA(25);
          this.Aes = ((dip)localObject1);
          localObject1 = new r.a(r.this, (byte)0);
          if (this.Aes == null) {
            break label562;
          }
          localObject2 = new long[2];
          if (this.Aes.FSk >= 100L) {
            break label541;
          }
          com.tencent.mm.modelvideo.o.aJz().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
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
        ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[] { paramString1, Boolean.valueOf(bool) });
        if ((bool) && (!((r.a)localObject1).Aep)) {
          ((r.a)localObject1).a(paramString1, (int)localObject2[0], (int)localObject2[1], "");
        }
        if (r.am(this.Aes.FSk, this.Aes.FSj)) {
          ((r.a)localObject1).eeo();
        }
        paramString2 = r.this.Acd.edf().Aec;
        if (paramString2 != null) {
          paramString2.zZM = this.Aes.FRV;
        }
        if (this.Aes.FSk == 100L)
        {
          ((r.a)localObject1).i(paramString1, (int)this.Aes.FSj, (int)this.Aes.FRV);
          ((r.a)localObject1).a(paramString1, 0, null);
        }
        AppMethodBeat.o(126206);
        return;
        ac.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((dip)localObject1).FSk), bs.An(((dip)localObject1).FSj) });
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).zZA = 3L;
        for (;;)
        {
          ((m)localObject2).eec();
          localObject1 = null;
          break;
          label509:
          localObject1 = new dip();
          ((dip)localObject1).mediaId = paramString1;
          ((m)localObject2).AdL.put(paramString1, localObject1);
        }
        label541:
        bool = true;
        localObject2[0] = new com.tencent.mm.plugin.a.b().FK(paramString2);
      }
      label562:
      com.tencent.mm.modelvideo.o.aJz().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
      AppMethodBeat.o(126206);
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126208);
      if ((this.Aes != null) && (paramInt1 + paramInt2 <= this.Aes.FSj))
      {
        AppMethodBeat.o(126208);
        return;
      }
      com.tencent.mm.modelvideo.o.aJz();
      com.tencent.mm.an.e.p(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(126208);
    }
  }
  
  final class c
    implements h.c
  {
    private c() {}
    
    public final void oQ(long paramLong)
    {
      AppMethodBeat.i(126210);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(600L, paramLong, 1L, false);
      AppMethodBeat.o(126210);
    }
    
    public final void sv(String paramString)
    {
      AppMethodBeat.i(126211);
      com.tencent.mm.plugin.report.e.wTc.kvStat(14349, paramString);
      AppMethodBeat.o(126211);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */