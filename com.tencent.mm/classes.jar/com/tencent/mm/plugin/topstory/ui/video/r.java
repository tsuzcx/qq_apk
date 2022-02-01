package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.aq.e;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.esz;
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

public final class r
{
  private int LrP;
  public esy MWv;
  b MYE;
  q NaK;
  public f NaL;
  public boolean NaM;
  public boolean NaN;
  public boolean NaO;
  private d.a NaP;
  private boolean NaQ;
  private boolean NaR;
  private com.tencent.mm.model.d kKI;
  
  public r()
  {
    AppMethodBeat.i(126212);
    this.LrP = 0;
    this.NaO = false;
    this.NaP = new d.a()
    {
      public final void bcu() {}
      
      public final void bcv() {}
      
      public final void bcw() {}
      
      public final void bcx() {}
    };
    this.kKI = com.tencent.mm.model.d.bcs();
    AppMethodBeat.o(126212);
  }
  
  public static boolean aK(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(126218);
    this.kKI.fZ(false);
    AppMethodBeat.o(126218);
  }
  
  private void grG()
  {
    AppMethodBeat.i(126215);
    if (this.NaK.getParent() != null) {
      ((ViewGroup)this.NaK.getParent()).removeView(this.NaK);
    }
    AppMethodBeat.o(126215);
  }
  
  private q grH()
  {
    AppMethodBeat.i(126216);
    q localq = new q(this.MYE.eOa(), this.MYE);
    localq.setRootPath(this.MYE.gqz());
    localq.setIOnlineVideoProxy(new b((byte)0));
    localq.setReporter(new r.c(this, (byte)0));
    AppMethodBeat.o(126216);
    return localq;
  }
  
  private void requestAudioFocus()
  {
    AppMethodBeat.i(126217);
    this.kKI.a(this.NaP);
    AppMethodBeat.o(126217);
  }
  
  public final void a(b paramb, esy paramesy, String paramString, int paramInt)
  {
    AppMethodBeat.i(126214);
    if (paramesy.Uvn != null) {
      paramesy.Uvn.fxt = false;
    }
    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { paramesy.Crh, paramesy.title, paramString });
    paramb.gqy().b(paramb.gqA());
    paramb.gqy().grC();
    paramb.gqy().a(paramesy, paramInt, paramString);
    this.NaK.setKeepScreenOn(true);
    this.NaK.grF();
    this.NaK.bfe(paramString);
    this.MWv = paramesy;
    this.NaM = true;
    this.NaN = false;
    ((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramesy.Crh, Integer.valueOf(0));
    AppMethodBeat.o(126214);
  }
  
  public final void a(f paramf, i.e parame)
  {
    AppMethodBeat.i(126213);
    if ((paramf == this.NaL) || (this.MYE == null))
    {
      AppMethodBeat.o(126213);
      return;
    }
    if (this.NaK == null) {
      this.NaK = grH();
    }
    grG();
    paramf.getVideoViewParent().addView(this.NaK);
    this.NaK.setVideoFooterView(paramf.getControlBar());
    this.NaK.setScaleType(parame);
    this.NaK.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.kKI.a(this.NaP);
    this.NaL = paramf;
    AppMethodBeat.o(126213);
  }
  
  public final void bff(String paramString)
  {
    AppMethodBeat.i(126229);
    com.tencent.mm.plugin.topstory.a.b.b localb = this.MYE.gqy().NaG;
    if (localb != null) {
      localb.MWb = 1L;
    }
    if ((this.NaK != null) && (this.NaK.getSessionId().equals(paramString)))
    {
      if (this.MWv != null) {
        ((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.MWv.Crh);
      }
      stopPlay();
    }
    a.rE(26);
    AppMethodBeat.o(126229);
  }
  
  public final void d(b paramb)
  {
    this.LrP += 1;
    this.MYE = paramb;
  }
  
  public final void dmi()
  {
    AppMethodBeat.i(126222);
    if (this.NaK != null)
    {
      abandonAudioFocus();
      this.NaK.setKeepScreenOn(false);
      this.NaK.pause();
      this.NaN = true;
    }
    AppMethodBeat.o(126222);
  }
  
  public final boolean ehu()
  {
    AppMethodBeat.i(126219);
    if (this.NaK != null)
    {
      boolean bool = this.NaK.isPlaying();
      AppMethodBeat.o(126219);
      return bool;
    }
    AppMethodBeat.o(126219);
    return false;
  }
  
  public final void fLJ()
  {
    AppMethodBeat.i(126221);
    if (this.NaK != null)
    {
      requestAudioFocus();
      this.NaK.setKeepScreenOn(true);
      this.NaK.bqo();
      this.NaN = false;
    }
    AppMethodBeat.o(126221);
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126232);
    if (this.NaK != null)
    {
      int i = this.NaK.getCurrPosMs();
      AppMethodBeat.o(126232);
      return i;
    }
    AppMethodBeat.o(126232);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126230);
    if (this.NaK != null)
    {
      int i = this.NaK.getCurrPosSec();
      AppMethodBeat.o(126230);
      return i;
    }
    AppMethodBeat.o(126230);
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(126231);
    if (this.NaK != null)
    {
      int i = this.NaK.getVideoDurationSec();
      AppMethodBeat.o(126231);
      return i;
    }
    AppMethodBeat.o(126231);
    return 0;
  }
  
  public final void kB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126228);
    if (paramInt1 == 0)
    {
      if ((this.NaM) && (this.NaR))
      {
        this.NaR = false;
        fLJ();
        AppMethodBeat.o(126228);
      }
    }
    else if (paramInt2 == 0)
    {
      if ((this.NaM) && (ehu()))
      {
        this.NaR = true;
        dmi();
        AppMethodBeat.o(126228);
      }
    }
    else if ((paramInt2 == 1) && (this.NaQ) && (this.NaM) && (this.NaN))
    {
      this.NaQ = false;
      fLJ();
      this.NaL.gqW();
    }
    AppMethodBeat.o(126228);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(126227);
    if ((this.NaK != null) && (this.NaK.getSessionId().equals(paramString))) {
      stopPlay();
    }
    AppMethodBeat.o(126227);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126226);
    this.LrP -= 1;
    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.LrP) });
    if (this.LrP <= 0)
    {
      if (this.NaK != null)
      {
        stopPlay();
        this.NaK.onUIDestroy();
      }
      this.MYE = null;
    }
    AppMethodBeat.o(126226);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126225);
    if (this.NaK != null) {
      this.NaK.onUIPause();
    }
    AppMethodBeat.o(126225);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126224);
    if (this.NaK != null)
    {
      this.NaK.onUIResume();
      if (this.NaL != null) {
        this.NaL.gqZ();
      }
    }
    AppMethodBeat.o(126224);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(126220);
    if (this.NaK != null) {
      this.NaK.setMute(paramBoolean);
    }
    AppMethodBeat.o(126220);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(126223);
    if (this.NaK != null)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      abandonAudioFocus();
      this.NaK.grE();
      this.NaK.setKeepScreenOn(false);
      this.NaK.stop();
      this.MWv = null;
      this.NaM = false;
      this.NaN = false;
      if (this.MYE != null)
      {
        this.MYE.gqy().b(this.MYE.gqA());
        this.MYE.gqy().grC();
      }
      if (this.NaL != null) {
        this.NaL.gra();
      }
    }
    AppMethodBeat.o(126223);
  }
  
  final class a
    implements h.a
  {
    boolean NaT;
    private boolean NaU;
    
    private a() {}
    
    public final void Kj(String paramString) {}
    
    public final void a(final String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(126205);
      final int i = paramInt;
      if (com.tencent.mm.plugin.topstory.a.h.gpM())
      {
        i = paramInt;
        if (r.this.NaO)
        {
          r.this.NaO = false;
          i = 404;
        }
      }
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
      Object localObject1;
      Object localObject2;
      if (r.this.MYE != null)
      {
        localObject1 = r.this.MYE.gqB();
        if (((m)localObject1).Nan.containsKey(paramString))
        {
          localObject2 = (esz)((m)localObject1).Nan.get(paramString);
          if (i == 0)
          {
            ((esz)localObject2).mediaId = paramString;
            ((esz)localObject2).Uvp = ((esz)localObject2).Uvb;
            ((esz)localObject2).Uvq = m.aJ(((esz)localObject2).Uvp, ((esz)localObject2).Uvb);
            ((m)localObject1).Nan.put(paramString, localObject2);
          }
          Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(((esz)localObject2).Uvq), Util.getSizeMB(((esz)localObject2).Uvp, 100.0D), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = r.this.MYE.gqL().ajJ(r.this.MYE.gqE());
          int k = n.avq();
          localObject1 = paramd;
          if (paramd == null) {
            localObject1 = new com.tencent.mm.i.d();
          }
          int m = ((esy)localObject2).Uvk;
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
          Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", new Object[] { paramd });
          com.tencent.mm.plugin.report.f.Iyx.kvStat(16270, paramd);
          if (i != 0)
          {
            paramd = new dxu();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("videoplayfailreport=1");
            ((StringBuilder)localObject3).append("&vt=").append(((esy)localObject2).Uvk);
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
            ((StringBuilder)localObject3).append("&cdnsourcetype=").append(((esy)localObject2).Uvh);
            ((StringBuilder)localObject3).append("&cdnscene=").append(((esy)localObject2).Uvg);
            ((StringBuilder)localObject3).append("&expand=").append(((esy)localObject2).UuX);
            paramd.Udk = ((StringBuilder)localObject3).toString();
            paramd.Udy = ((com.tencent.mm.i.d)localObject1).field_httpResponseHeader;
            paramd.CPs = ((esy)localObject2).videoUrl;
            paramd.Udz = ((esy)localObject2).zGJ;
            Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", new Object[] { paramd.Udk, paramd.Udy, paramd.CPs, paramd.Udz });
            paramd = new ad(paramd);
            com.tencent.mm.kernel.h.aGY().a(paramd, 0);
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
            if ((r.this.NaK != null) && (r.this.MYE != null))
            {
              com.tencent.mm.plugin.topstory.a.b.b localb = r.this.MYE.gqy().NaG;
              if ((localb != null) && (localb.MWj == 0L)) {
                localb.MWj = (System.currentTimeMillis() - localb.MVX);
              }
              r.this.NaK.aP(paramString, i);
              if (i != 0)
              {
                a.rE(9);
                AppMethodBeat.o(126200);
                return;
              }
              a.rE(27);
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
      AppMethodBeat.i(202760);
      if (!this.NaT)
      {
        this.NaT = true;
        if (r.this.MYE != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126197);
              if ((r.this.NaK != null) && (r.this.MYE != null))
              {
                com.tencent.mm.plugin.topstory.a.b.b localb = r.this.MYE.gqy().NaG;
                if ((localb != null) && (localb.MWk == 0L))
                {
                  localb.MWk = (System.currentTimeMillis() - localb.MVX);
                  localb.MWl = paramLong1;
                  localb.MWm = (paramLong1 + this.CGX);
                  localb.MWq = paramString2;
                  Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(localb.MWk), Long.valueOf(paramLong1), Long.valueOf(this.CGX) });
                }
                r.this.NaK.GQ(paramLong1);
              }
              AppMethodBeat.o(126197);
            }
          });
        }
        AppMethodBeat.o(202760);
        return;
      }
      AppMethodBeat.o(202760);
    }
    
    public final void grI()
    {
      AppMethodBeat.i(126204);
      m localm;
      Object localObject3;
      Object localObject1;
      Object localObject4;
      if ((!this.NaU) && (r.this.MWv != null) && (r.this.MYE != null) && ((r.this.MYE.gqx().eqb()) || (ai.isFreeSimCard())))
      {
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
        this.NaU = true;
        localm = r.this.MYE.gqB();
        localObject3 = r.this.MWv;
        localObject1 = localm.MYE.gqL();
        localObject4 = new ArrayList();
      }
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = ((n)localObject1).eiH().size();
          i = 0;
          if (i >= j) {
            break label673;
          }
          if (!((esy)localObject3).Crh.equals(((esy)((n)localObject1).eiH().get(i)).Crh)) {
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
          ((List)localObject4).add(((n)localObject1).eiH().get(i));
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
            localObject5 = (esy)((Iterator)localObject4).next();
            str1 = com.tencent.mm.plugin.topstory.ui.d.bz(((esy)localObject5).Crh, ((esy)localObject5).UuV);
            if (localm.Nan.containsKey(str1))
            {
              localObject1 = (esz)localm.Nan.get(str1);
              ((HashMap)localObject3).put(str1, localObject1);
              j = (int)m.aJ(a.a.MVM.longValue(), ((esy)localObject5).Uvb);
              if (j >= 20) {
                break label629;
              }
              i = 20;
              if (((esz)localObject1).Uvq >= i) {
                break label643;
              }
              str2 = localm.MYE.gqz() + str1 + ".mp4";
              localObject5 = ((esy)localObject5).videoUrl;
              localh = new com.tencent.mm.i.h();
              localh.taskName = "task_TopStoryPreloadMgr";
              localh.field_mediaId = str1;
              localh.url = ((String)localObject5);
              localh.iUW = 2;
              localh.iVd = 2;
              localh.iUX = 3;
              localh.iVi = i;
              localh.field_preloadRatio = i;
              localh.concurrentCount = 4;
              localh.field_fullpath = str2;
              localh.iUG = new m.d(localm, (byte)0);
              localh.iUY = new m.c(localm, (byte)0);
              com.tencent.mm.aq.f.bkg().b(localh, -1);
              Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((esz)localObject1).Uvq), Integer.valueOf(i) });
              if (((HashMap)localObject3).size() != 6) {
                break label671;
              }
            }
          }
          else
          {
            localm.Nao.clear();
            localm.Nao.addAll(((HashMap)localObject3).keySet());
            localm.Nan.putAll((Map)localObject3);
            ThreadPool.post(new m.a(localm, localm.Nam), "TopStory.DeleteVideoCacheTask");
            AppMethodBeat.o(126204);
            return;
          }
          localObject1 = new esz();
          ((esz)localObject1).mediaId = str1;
          ((esz)localObject1).Uvb = ((esy)localObject5).Uvb;
          continue;
          label629:
          i = j;
          if (j > 100)
          {
            i = 100;
            continue;
            label643:
            Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((esz)localObject1).Uvq) });
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
    
    public final void h(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(126203);
      if (r.this.MYE != null)
      {
        Object localObject = r.this.MYE.gqB();
        if (((m)localObject).Nan.containsKey(paramString))
        {
          esz localesz = (esz)((m)localObject).Nan.get(paramString);
          localesz.mediaId = paramString;
          localesz.Uvb = paramLong2;
          localesz.Uvp = paramLong1;
          localesz.Uvq = m.aJ(localesz.Uvp, localesz.Uvb);
          ((m)localObject).Nan.put(paramString, localesz);
        }
        localObject = r.this.MYE.gqy().NaG;
        if (localObject != null) {
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject).MWr = paramLong2;
        }
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126199);
          if (r.this.NaK != null) {
            r.this.NaK.h(paramString, paramLong1, this.CGr);
          }
          if (r.aK(paramLong1 * 100L / this.CGr, paramLong1)) {
            r.a.this.grI();
          }
          AppMethodBeat.o(126199);
        }
      });
      AppMethodBeat.o(126203);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(126202);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126198);
          if (r.this.NaK != null) {
            r.this.NaK.onDataAvailable(paramString, paramLong1, this.CGX);
          }
          AppMethodBeat.o(126198);
        }
      });
      AppMethodBeat.o(126202);
    }
  }
  
  final class b
    implements com.tencent.mm.modelvideo.f
  {
    private esz NaW;
    
    private b() {}
    
    public final void a(f.a parama) {}
    
    public final void hR(String paramString)
    {
      AppMethodBeat.i(126207);
      s.bqC().l(paramString, null);
      AppMethodBeat.o(126207);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126209);
      if ((this.NaW != null) && (paramInt1 + paramInt2 <= this.NaW.Uvp)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramInt1 == 0) && (bool1) && (r.this.MYE != null))
        {
          com.tencent.mm.plugin.topstory.a.b.b localb = r.this.MYE.gqy().NaG;
          if ((localb != null) && (localb.MWn == 0L))
          {
            localb.MWn = (System.currentTimeMillis() - localb.MVX);
            localb.MWo = paramInt1;
            localb.MWp = (paramInt1 + paramInt2);
            Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(localb.MWk), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
        }
        boolean bool2 = bool1;
        if (!bool1) {
          bool2 = s.bqC().isVideoDataAvailable(paramString, paramInt1, paramInt2);
        }
        AppMethodBeat.o(126209);
        return bool2;
      }
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126208);
      if ((this.NaW != null) && (paramInt1 + paramInt2 <= this.NaW.Uvp))
      {
        AppMethodBeat.o(126208);
        return;
      }
      s.bqC();
      e.s(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(126208);
    }
    
    public final void s(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(126206);
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
      if (r.this.MYE == null)
      {
        AppMethodBeat.o(126206);
        return;
      }
      Object localObject2 = r.this.MYE.gqB();
      Object localObject3 = ((m)localObject2).MYE.gqy().NaG;
      Object localObject1;
      boolean bool;
      if (localObject3 != null)
      {
        if (!((m)localObject2).Nan.containsKey(paramString1)) {
          break label510;
        }
        localObject1 = (esz)((m)localObject2).Nan.get(paramString1);
        if (((esz)localObject1).Uvq >= 5L)
        {
          Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((esz)localObject1).Uvq), Util.getSizeMB(((esz)localObject1).Uvp) });
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).MWf = 1L;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).MWg = ((esz)localObject1).Uvq;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).MWh = ((esz)localObject1).Uvp;
          a.rE(25);
          this.NaW = ((esz)localObject1);
          localObject1 = new r.a(r.this, (byte)0);
          if (this.NaW == null) {
            break label563;
          }
          localObject2 = new long[2];
          if (this.NaW.Uvq >= 100L) {
            break label542;
          }
          s.bqC().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
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
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[] { paramString1, Boolean.valueOf(bool) });
        if ((bool) && (!((r.a)localObject1).NaT)) {
          ((r.a)localObject1).a(paramString1, (int)localObject2[0], (int)localObject2[1], "");
        }
        if (r.aK(this.NaW.Uvq, this.NaW.Uvp)) {
          ((r.a)localObject1).grI();
        }
        paramString2 = r.this.MYE.gqy().NaG;
        if (paramString2 != null) {
          paramString2.MWr = this.NaW.Uvb;
        }
        if (this.NaW.Uvq == 100L)
        {
          ((r.a)localObject1).h(paramString1, (int)this.NaW.Uvp, (int)this.NaW.Uvb);
          ((r.a)localObject1).a(paramString1, 0, null);
        }
        AppMethodBeat.o(126206);
        return;
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((esz)localObject1).Uvq), Util.getSizeMB(((esz)localObject1).Uvp) });
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).MWf = 3L;
        for (;;)
        {
          ((m)localObject2).gry();
          localObject1 = null;
          break;
          label510:
          localObject1 = new esz();
          ((esz)localObject1).mediaId = paramString1;
          ((m)localObject2).Nan.put(paramString1, localObject1);
        }
        label542:
        bool = true;
        localObject2[0] = new com.tencent.mm.plugin.a.b().ZY(paramString2);
      }
      label563:
      s.bqC().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
      AppMethodBeat.o(126206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */