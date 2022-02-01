package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.i.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eix;
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
  private int Fdo;
  public eiw GjK;
  b GlS;
  q GnX;
  public f GnY;
  public boolean GnZ;
  public boolean Goa;
  public boolean Gob;
  private d.a Goc;
  private boolean God;
  private boolean Goe;
  private com.tencent.mm.model.d hWh;
  
  public r()
  {
    AppMethodBeat.i(126212);
    this.Fdo = 0;
    this.Gob = false;
    this.Goc = new d.a()
    {
      public final void aTw() {}
      
      public final void aTx() {}
      
      public final void aTy() {}
      
      public final void aTz() {}
    };
    this.hWh = new com.tencent.mm.model.d();
    AppMethodBeat.o(126212);
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(126218);
    this.hWh.fp(false);
    AppMethodBeat.o(126218);
  }
  
  public static boolean av(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void fzF()
  {
    AppMethodBeat.i(126215);
    if (this.GnX.getParent() != null) {
      ((ViewGroup)this.GnX.getParent()).removeView(this.GnX);
    }
    AppMethodBeat.o(126215);
  }
  
  private q fzG()
  {
    AppMethodBeat.i(126216);
    q localq = new q(this.GlS.eeF(), this.GlS);
    localq.setRootPath(this.GlS.fyC());
    localq.setIOnlineVideoProxy(new b((byte)0));
    localq.setReporter(new c((byte)0));
    AppMethodBeat.o(126216);
    return localq;
  }
  
  private void requestAudioFocus()
  {
    AppMethodBeat.i(126217);
    this.hWh.a(this.Goc);
    AppMethodBeat.o(126217);
  }
  
  public final void a(b paramb, eiw parameiw, String paramString, int paramInt)
  {
    AppMethodBeat.i(126214);
    if (parameiw.NiI != null) {
      parameiw.NiI.dEF = false;
    }
    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { parameiw.psI, parameiw.title, paramString });
    paramb.fyB().b(paramb.fyD());
    paramb.fyB().fzB();
    paramb.fyB().a(parameiw, paramInt, paramString);
    this.GnX.setKeepScreenOn(true);
    this.GnX.fzE();
    this.GnX.aTG(paramString);
    this.GjK = parameiw;
    this.GnZ = true;
    this.Goa = false;
    ((PluginTopStoryUI)g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(parameiw.psI, Integer.valueOf(0));
    AppMethodBeat.o(126214);
  }
  
  public final void a(f paramf, i.e parame)
  {
    AppMethodBeat.i(126213);
    if ((paramf == this.GnY) || (this.GlS == null))
    {
      AppMethodBeat.o(126213);
      return;
    }
    if (this.GnX == null) {
      this.GnX = fzG();
    }
    fzF();
    paramf.getVideoViewParent().addView(this.GnX);
    this.GnX.setVideoFooterView(paramf.getControlBar());
    this.GnX.setScaleType(parame);
    this.GnX.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.hWh.a(this.Goc);
    this.GnY = paramf;
    AppMethodBeat.o(126213);
  }
  
  public final void aTH(String paramString)
  {
    AppMethodBeat.i(126229);
    com.tencent.mm.plugin.topstory.a.b.b localb = this.GlS.fyB().GnT;
    if (localb != null) {
      localb.Gjq = 1L;
    }
    if ((this.GnX != null) && (this.GnX.getSessionId().equals(paramString)))
    {
      if (this.GjK != null) {
        ((PluginTopStoryUI)g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.GjK.psI);
      }
      stopPlay();
    }
    com.tencent.mm.plugin.websearch.api.a.a.pl(26);
    AppMethodBeat.o(126229);
  }
  
  public final void cXa()
  {
    AppMethodBeat.i(126222);
    if (this.GnX != null)
    {
      abandonAudioFocus();
      this.GnX.setKeepScreenOn(false);
      this.GnX.pause();
      this.Goa = true;
    }
    AppMethodBeat.o(126222);
  }
  
  public final void d(b paramb)
  {
    this.Fdo += 1;
    this.GlS = paramb;
  }
  
  public final boolean dFG()
  {
    AppMethodBeat.i(126219);
    if (this.GnX != null)
    {
      boolean bool = this.GnX.isPlaying();
      AppMethodBeat.o(126219);
      return bool;
    }
    AppMethodBeat.o(126219);
    return false;
  }
  
  public final void eYd()
  {
    AppMethodBeat.i(126221);
    if (this.GnX != null)
    {
      requestAudioFocus();
      this.GnX.setKeepScreenOn(true);
      this.GnX.play();
      this.Goa = false;
    }
    AppMethodBeat.o(126221);
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126232);
    if (this.GnX != null)
    {
      int i = this.GnX.getCurrPosMs();
      AppMethodBeat.o(126232);
      return i;
    }
    AppMethodBeat.o(126232);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126230);
    if (this.GnX != null)
    {
      int i = this.GnX.getCurrPosSec();
      AppMethodBeat.o(126230);
      return i;
    }
    AppMethodBeat.o(126230);
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(126231);
    if (this.GnX != null)
    {
      int i = this.GnX.getVideoDurationSec();
      AppMethodBeat.o(126231);
      return i;
    }
    AppMethodBeat.o(126231);
    return 0;
  }
  
  public final void jp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126228);
    if (paramInt1 == 0)
    {
      if ((this.GnZ) && (this.Goe))
      {
        this.Goe = false;
        eYd();
        AppMethodBeat.o(126228);
      }
    }
    else if (paramInt2 == 0)
    {
      if ((this.GnZ) && (dFG()))
      {
        this.Goe = true;
        cXa();
        AppMethodBeat.o(126228);
      }
    }
    else if ((paramInt2 == 1) && (this.God) && (this.GnZ) && (this.Goa))
    {
      this.God = false;
      eYd();
      this.GnY.fyX();
    }
    AppMethodBeat.o(126228);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(126227);
    if ((this.GnX != null) && (this.GnX.getSessionId().equals(paramString))) {
      stopPlay();
    }
    AppMethodBeat.o(126227);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126226);
    this.Fdo -= 1;
    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.Fdo) });
    if (this.Fdo <= 0)
    {
      if (this.GnX != null)
      {
        stopPlay();
        this.GnX.onUIDestroy();
      }
      this.GlS = null;
    }
    AppMethodBeat.o(126226);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126225);
    if (this.GnX != null) {
      this.GnX.onUIPause();
    }
    AppMethodBeat.o(126225);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126224);
    if (this.GnX != null)
    {
      this.GnX.onUIResume();
      if (this.GnY != null) {
        this.GnY.fza();
      }
    }
    AppMethodBeat.o(126224);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(126220);
    if (this.GnX != null) {
      this.GnX.setMute(paramBoolean);
    }
    AppMethodBeat.o(126220);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(126223);
    if (this.GnX != null)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      abandonAudioFocus();
      this.GnX.fzD();
      this.GnX.setKeepScreenOn(false);
      this.GnX.stop();
      this.GjK = null;
      this.GnZ = false;
      this.Goa = false;
      if (this.GlS != null)
      {
        this.GlS.fyB().b(this.GlS.fyD());
        this.GlS.fyB().fzB();
      }
      if (this.GnY != null) {
        this.GnY.fzb();
      }
    }
    AppMethodBeat.o(126223);
  }
  
  final class a
    implements h.a
  {
    boolean Gog;
    private boolean Goh;
    
    private a() {}
    
    public final void Ds(String paramString) {}
    
    public final void a(final String paramString, int paramInt, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(126205);
      final int i = paramInt;
      if (com.tencent.mm.plugin.topstory.a.h.fxR())
      {
        i = paramInt;
        if (r.this.Gob)
        {
          r.this.Gob = false;
          i = 404;
        }
      }
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
      Object localObject1;
      Object localObject2;
      if (r.this.GlS != null)
      {
        localObject1 = r.this.GlS.fyE();
        if (((m)localObject1).GnA.containsKey(paramString))
        {
          localObject2 = (eix)((m)localObject1).GnA.get(paramString);
          if (i == 0)
          {
            ((eix)localObject2).mediaId = paramString;
            ((eix)localObject2).NiK = ((eix)localObject2).Niv;
            ((eix)localObject2).NiL = m.au(((eix)localObject2).NiK, ((eix)localObject2).Niv);
            ((m)localObject1).GnA.put(paramString, localObject2);
          }
          Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(((eix)localObject2).NiL), Util.getSizeMB(((eix)localObject2).NiK, 100.0D), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = r.this.GlS.fyO().acd(r.this.GlS.fyH());
          int k = n.ape();
          localObject1 = paramd;
          if (paramd == null) {
            localObject1 = new com.tencent.mm.i.d();
          }
          int m = ((eiw)localObject2).NiF;
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
          com.tencent.mm.plugin.report.e.Cxv.kvStat(16270, paramd);
          if (i != 0)
          {
            paramd = new doc();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("videoplayfailreport=1");
            ((StringBuilder)localObject3).append("&vt=").append(((eiw)localObject2).NiF);
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
            ((StringBuilder)localObject3).append("&cdnsourcetype=").append(((eiw)localObject2).NiB);
            ((StringBuilder)localObject3).append("&cdnscene=").append(((eiw)localObject2).NiA);
            ((StringBuilder)localObject3).append("&expand=").append(((eiw)localObject2).Nir);
            paramd.MRe = ((StringBuilder)localObject3).toString();
            paramd.MRs = ((com.tencent.mm.i.d)localObject1).field_httpResponseHeader;
            paramd.xLk = ((eiw)localObject2).videoUrl;
            paramd.MRt = ((eiw)localObject2).NiD;
            Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", new Object[] { paramd.MRe, paramd.MRs, paramd.xLk, paramd.MRt });
            paramd = new ad(paramd);
            g.azz().a(paramd, 0);
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
            if ((r.this.GnX != null) && (r.this.GlS != null))
            {
              com.tencent.mm.plugin.topstory.a.b.b localb = r.this.GlS.fyB().GnT;
              if ((localb != null) && (localb.Gjy == 0L)) {
                localb.Gjy = (System.currentTimeMillis() - localb.Gjm);
              }
              r.this.GnX.ax(paramString, i);
              if (i != 0)
              {
                com.tencent.mm.plugin.websearch.api.a.a.pl(9);
                AppMethodBeat.o(126200);
                return;
              }
              com.tencent.mm.plugin.websearch.api.a.a.pl(27);
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
      AppMethodBeat.i(236394);
      if (!this.Gog)
      {
        this.Gog = true;
        if (r.this.GlS != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(126197);
              if ((r.this.GnX != null) && (r.this.GlS != null))
              {
                com.tencent.mm.plugin.topstory.a.b.b localb = r.this.GlS.fyB().GnT;
                if ((localb != null) && (localb.Gjz == 0L))
                {
                  localb.Gjz = (System.currentTimeMillis() - localb.Gjm);
                  localb.GjA = paramLong1;
                  localb.GjB = (paramLong1 + this.mwP);
                  localb.GjF = paramString2;
                  Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(localb.Gjz), Long.valueOf(paramLong1), Long.valueOf(this.mwP) });
                }
                r.this.GnX.AI(paramLong1);
              }
              AppMethodBeat.o(126197);
            }
          });
        }
        AppMethodBeat.o(236394);
        return;
      }
      AppMethodBeat.o(236394);
    }
    
    public final void fzH()
    {
      AppMethodBeat.i(126204);
      m localm;
      Object localObject3;
      Object localObject1;
      Object localObject4;
      if ((!this.Goh) && (r.this.GjK != null) && (r.this.GlS != null) && ((r.this.GlS.fyA().cGF()) || (ai.isFreeSimCard())))
      {
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
        this.Goh = true;
        localm = r.this.GlS.fyE();
        localObject3 = r.this.GjK;
        localObject1 = localm.GlS.fyO();
        localObject4 = new ArrayList();
      }
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = ((n)localObject1).GW().size();
          i = 0;
          if (i >= j) {
            break label673;
          }
          if (!((eiw)localObject3).psI.equals(((eiw)((n)localObject1).GW().get(i)).psI)) {
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
          ((List)localObject4).add(((n)localObject1).GW().get(i));
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
            localObject5 = (eiw)((Iterator)localObject4).next();
            str1 = c.bu(((eiw)localObject5).psI, ((eiw)localObject5).Nip);
            if (localm.GnA.containsKey(str1))
            {
              localObject1 = (eix)localm.GnA.get(str1);
              ((HashMap)localObject3).put(str1, localObject1);
              j = (int)m.au(a.a.Gjb.longValue(), ((eiw)localObject5).Niv);
              if (j >= 20) {
                break label629;
              }
              i = 20;
              if (((eix)localObject1).NiL >= i) {
                break label643;
              }
              str2 = localm.GlS.fyC() + str1 + ".mp4";
              localObject5 = ((eiw)localObject5).videoUrl;
              localh = new com.tencent.mm.i.h();
              localh.taskName = "task_TopStoryPreloadMgr";
              localh.field_mediaId = str1;
              localh.url = ((String)localObject5);
              localh.gqO = 2;
              localh.gqU = 2;
              localh.gqP = 3;
              localh.gqZ = i;
              localh.field_preloadRatio = i;
              localh.concurrentCount = 4;
              localh.field_fullpath = str2;
              localh.gqy = new m.d(localm, (byte)0);
              localh.gqQ = new m.c(localm, (byte)0);
              com.tencent.mm.an.f.baQ().b(localh, -1);
              Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((eix)localObject1).NiL), Integer.valueOf(i) });
              if (((HashMap)localObject3).size() != 6) {
                break label671;
              }
            }
          }
          else
          {
            localm.GnB.clear();
            localm.GnB.addAll(((HashMap)localObject3).keySet());
            localm.GnA.putAll((Map)localObject3);
            ThreadPool.post(new m.a(localm, localm.Gnz), "TopStory.DeleteVideoCacheTask");
            AppMethodBeat.o(126204);
            return;
          }
          localObject1 = new eix();
          ((eix)localObject1).mediaId = str1;
          ((eix)localObject1).Niv = ((eiw)localObject5).Niv;
          continue;
          label629:
          i = j;
          if (j > 100)
          {
            i = 100;
            continue;
            label643:
            Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((eix)localObject1).NiL) });
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
      if (r.this.GlS != null)
      {
        Object localObject = r.this.GlS.fyE();
        if (((m)localObject).GnA.containsKey(paramString))
        {
          eix localeix = (eix)((m)localObject).GnA.get(paramString);
          localeix.mediaId = paramString;
          localeix.Niv = paramLong2;
          localeix.NiK = paramLong1;
          localeix.NiL = m.au(localeix.NiK, localeix.Niv);
          ((m)localObject).GnA.put(paramString, localeix);
        }
        localObject = r.this.GlS.fyB().GnT;
        if (localObject != null) {
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject).GjG = paramLong2;
        }
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126199);
          if (r.this.GnX != null) {
            r.this.GnX.i(paramString, paramLong1, this.xCr);
          }
          if (r.av(paramLong1 * 100L / this.xCr, paramLong1)) {
            r.a.this.fzH();
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
          if (r.this.GnX != null) {
            r.this.GnX.onDataAvailable(paramString, paramLong1, this.mwP);
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
    private eix Goj;
    
    private b() {}
    
    public final void a(b.a parama) {}
    
    public final void he(String paramString)
    {
      AppMethodBeat.i(126207);
      com.tencent.mm.modelvideo.o.bhk().m(paramString, null);
      AppMethodBeat.o(126207);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126209);
      if ((this.Goj != null) && (paramInt1 + paramInt2 <= this.Goj.NiK)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramInt1 == 0) && (bool1) && (r.this.GlS != null))
        {
          com.tencent.mm.plugin.topstory.a.b.b localb = r.this.GlS.fyB().GnT;
          if ((localb != null) && (localb.GjC == 0L))
          {
            localb.GjC = (System.currentTimeMillis() - localb.Gjm);
            localb.GjD = paramInt1;
            localb.GjE = (paramInt1 + paramInt2);
            Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(localb.Gjz), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
        }
        boolean bool2 = bool1;
        if (!bool1) {
          bool2 = com.tencent.mm.modelvideo.o.bhk().isVideoDataAvailable(paramString, paramInt1, paramInt2);
        }
        AppMethodBeat.o(126209);
        return bool2;
      }
    }
    
    public final void p(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(126206);
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
      if (r.this.GlS == null)
      {
        AppMethodBeat.o(126206);
        return;
      }
      Object localObject2 = r.this.GlS.fyE();
      Object localObject3 = ((m)localObject2).GlS.fyB().GnT;
      Object localObject1;
      boolean bool;
      if (localObject3 != null)
      {
        if (!((m)localObject2).GnA.containsKey(paramString1)) {
          break label509;
        }
        localObject1 = (eix)((m)localObject2).GnA.get(paramString1);
        if (((eix)localObject1).NiL >= 5L)
        {
          Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((eix)localObject1).NiL), Util.getSizeMB(((eix)localObject1).NiK) });
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).Gju = 1L;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).Gjv = ((eix)localObject1).NiL;
          ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).Gjw = ((eix)localObject1).NiK;
          com.tencent.mm.plugin.websearch.api.a.a.pl(25);
          this.Goj = ((eix)localObject1);
          localObject1 = new r.a(r.this, (byte)0);
          if (this.Goj == null) {
            break label562;
          }
          localObject2 = new long[2];
          if (this.Goj.NiL >= 100L) {
            break label541;
          }
          com.tencent.mm.modelvideo.o.bhk().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
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
        if ((bool) && (!((r.a)localObject1).Gog)) {
          ((r.a)localObject1).a(paramString1, (int)localObject2[0], (int)localObject2[1], "");
        }
        if (r.av(this.Goj.NiL, this.Goj.NiK)) {
          ((r.a)localObject1).fzH();
        }
        paramString2 = r.this.GlS.fyB().GnT;
        if (paramString2 != null) {
          paramString2.GjG = this.Goj.Niv;
        }
        if (this.Goj.NiL == 100L)
        {
          ((r.a)localObject1).i(paramString1, (int)this.Goj.NiK, (int)this.Goj.Niv);
          ((r.a)localObject1).a(paramString1, 0, null);
        }
        AppMethodBeat.o(126206);
        return;
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((eix)localObject1).NiL), Util.getSizeMB(((eix)localObject1).NiK) });
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).Gju = 3L;
        for (;;)
        {
          ((m)localObject2).fzx();
          localObject1 = null;
          break;
          label509:
          localObject1 = new eix();
          ((eix)localObject1).mediaId = paramString1;
          ((m)localObject2).GnA.put(paramString1, localObject1);
        }
        label541:
        bool = true;
        localObject2[0] = new com.tencent.mm.plugin.a.b().Sw(paramString2);
      }
      label562:
      com.tencent.mm.modelvideo.o.bhk().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
      AppMethodBeat.o(126206);
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(126208);
      if ((this.Goj != null) && (paramInt1 + paramInt2 <= this.Goj.NiK))
      {
        AppMethodBeat.o(126208);
        return;
      }
      com.tencent.mm.modelvideo.o.bhk();
      com.tencent.mm.an.e.r(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(126208);
    }
  }
  
  final class c
    implements i.c
  {
    private c() {}
    
    public final void DX(String paramString)
    {
      AppMethodBeat.i(126211);
      com.tencent.mm.plugin.report.e.Cxv.kvStat(14349, paramString);
      AppMethodBeat.o(126211);
    }
    
    public final void yU(long paramLong)
    {
      AppMethodBeat.i(126210);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(600L, paramLong, 1L, false);
      AppMethodBeat.o(126210);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */