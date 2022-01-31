package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.j.g.a;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.byh;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class r
{
  b pEp;
  private int pFU = 0;
  private d.a pGA = new r.1(this);
  private boolean pGB;
  private boolean pGC;
  private com.tencent.mm.model.d pGt = new com.tencent.mm.model.d();
  q pGu;
  public f pGv;
  byg pGw;
  public boolean pGx;
  public boolean pGy;
  public boolean pGz = false;
  
  public static boolean O(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void bOt()
  {
    this.pGt.bH(false);
  }
  
  public final void PO(String paramString)
  {
    com.tencent.mm.plugin.topstory.a.b.a locala = this.pEp.bNt().pGq;
    if (locala != null) {
      locala.pDi = 1L;
    }
    if ((this.pGu != null) && (this.pGu.getSessionId().equals(paramString))) {
      stopPlay();
    }
    com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(26);
  }
  
  public final void Se()
  {
    if (this.pGu != null) {
      this.pGu.Se();
    }
  }
  
  public final void Sf()
  {
    if (this.pGu != null)
    {
      this.pGu.Sf();
      if (this.pGv != null) {
        this.pGv.bNR();
      }
    }
  }
  
  public final void a(b paramb, byg parambyg, String paramString, int paramInt)
  {
    y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { parambyg.tOx, parambyg.title, paramString });
    paramb.bNt().b(paramb.bNv());
    paramb.bNt().bOp();
    paramb.bNt().a(parambyg, paramInt, paramString);
    this.pGu.setKeepScreenOn(true);
    this.pGu.bOs();
    this.pGu.PN(paramString);
    this.pGw = parambyg;
    this.pGx = true;
    this.pGy = false;
  }
  
  public final void a(f paramf, h.d paramd)
  {
    if (this.pGu == null)
    {
      q localq = new q(this.pEp.bfn(), this.pEp);
      localq.setRootPath(this.pEp.bNu());
      localq.setIOnlineVideoProxy(new r.b(this, (byte)0));
      localq.setReporter(new c((byte)0));
      this.pGu = localq;
    }
    if (this.pGu.getParent() != null) {
      ((ViewGroup)this.pGu.getParent()).removeView(this.pGu);
    }
    paramf.getVideoViewParent().addView(this.pGu);
    this.pGu.setVideoFooterView(paramf.getControlBar());
    this.pGu.setScaleType(paramd);
    this.pGu.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.pGt.a(this.pGA);
    this.pGv = paramf;
  }
  
  public final void akT()
  {
    this.pFU -= 1;
    y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.pFU) });
    if (this.pFU <= 0)
    {
      if (this.pGu != null)
      {
        stopPlay();
        this.pGu.akT();
      }
      this.pEp = null;
    }
  }
  
  public final void bFy()
  {
    if (this.pGu != null)
    {
      bOt();
      this.pGu.setKeepScreenOn(false);
      this.pGu.pause();
      this.pGy = true;
    }
  }
  
  public final void bMs()
  {
    if (this.pGu != null)
    {
      this.pGt.a(this.pGA);
      this.pGu.setKeepScreenOn(true);
      this.pGu.play();
      this.pGy = false;
    }
  }
  
  public final boolean bOu()
  {
    if (this.pGu != null) {
      return this.pGu.isPlaying();
    }
    return false;
  }
  
  public final void d(b paramb)
  {
    this.pFU += 1;
    this.pEp = paramb;
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      if ((this.pGx) && (this.pGC))
      {
        this.pGC = false;
        bMs();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt2 != 0) {
            break;
          }
        } while ((!this.pGx) || (!bOu()));
        this.pGC = true;
        bFy();
        return;
        if (paramInt2 != 2) {
          break;
        }
      } while ((!this.pGx) || (this.pEp.bNs().pFL));
      if (bOu())
      {
        this.pGB = true;
        bFy();
      }
      this.pGv.bNT();
      return;
    } while ((paramInt2 != 1) || (!this.pGB) || (!this.pGx) || (!this.pGy));
    this.pGB = false;
    bMs();
    this.pGv.bNN();
  }
  
  public final int getCurrPosMs()
  {
    if (this.pGu != null) {
      return this.pGu.getCurrPosMs();
    }
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    if (this.pGu != null) {
      return this.pGu.getCurrPosSec();
    }
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    if (this.pGu != null) {
      return this.pGu.getVideoDurationSec();
    }
    return 0;
  }
  
  public final void onError(String paramString)
  {
    if ((this.pGu != null) && (this.pGu.getSessionId().equals(paramString))) {
      stopPlay();
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    if (this.pGu != null) {
      this.pGu.setMute(paramBoolean);
    }
  }
  
  public final void stopPlay()
  {
    if (this.pGu != null)
    {
      y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      bOt();
      ((TopStoryVideoPlayTextureView)this.pGu.iuC).setAlpha(0.0F);
      this.pGu.setKeepScreenOn(false);
      this.pGu.stop();
      this.pGw = null;
      this.pGx = false;
      this.pGy = false;
      if (this.pEp != null)
      {
        this.pEp.bNt().b(this.pEp.bNv());
        this.pEp.bNt().bOp();
      }
      if (this.pGv != null) {
        this.pGv.bNS();
      }
    }
  }
  
  private final class a
    implements g.a
  {
    boolean pGE;
    private boolean pGF;
    
    private a() {}
    
    public final void bOv()
    {
      m localm;
      Object localObject3;
      Object localObject1;
      Object localObject4;
      if ((!this.pGF) && (r.this.pGw != null) && (r.this.pEp != null) && ((r.this.pEp.bNs().aIq()) || (com.tencent.mm.plugin.topstory.a.g.bNg())))
      {
        y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
        this.pGF = true;
        localm = r.this.pEp.bNw();
        localObject3 = r.this.pGw;
        localObject1 = localm.pEp.bNJ();
        localObject4 = new ArrayList();
      }
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = ((n)localObject1).cnS().size();
          i = 0;
          if (i >= j) {
            break label647;
          }
          if (!((byg)localObject3).tOx.equals(((byg)((n)localObject1).cnS().get(i)).tOx)) {
            break label667;
          }
        }
        finally {}
        if (i < j)
        {
          ((List)localObject4).add(((n)localObject1).cnS().get(i));
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
            localObject5 = (byg)((Iterator)localObject4).next();
            str1 = com.tencent.mm.plugin.topstory.ui.d.an(((byg)localObject5).tOx, ((byg)localObject5).tOy);
            if (localm.pFS.containsKey(str1))
            {
              localObject1 = (byh)localm.pFS.get(str1);
              ((HashMap)localObject3).put(str1, localObject1);
              j = (int)m.N(a.a.pDd.longValue(), ((byg)localObject5).tOF);
              if (j >= 20) {
                break label602;
              }
              i = 20;
              if (((byh)localObject1).tOM >= i) {
                break label616;
              }
              String str2 = localm.pEp.bNu() + str1 + ".mp4";
              localObject5 = ((byg)localObject5).videoUrl;
              com.tencent.mm.j.g localg = new com.tencent.mm.j.g();
              localg.field_mediaId = str1;
              localg.url = ((String)localObject5);
              localg.dma = 2;
              localg.dmg = 2;
              localg.dmb = 3;
              localg.dml = i;
              localg.field_preloadRatio = i;
              localg.concurrentCount = 4;
              localg.field_fullpath = str2;
              localg.dlP = new m.d(localm, (byte)0);
              localg.dmc = new m.c(localm, (byte)0);
              com.tencent.mm.ak.f.Nd().b(localg, -1);
              y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", new Object[] { str1, Long.valueOf(((byh)localObject1).tOM), Integer.valueOf(i) });
              if (((HashMap)localObject3).size() != 6) {
                break label645;
              }
            }
          }
          else
          {
            localm.pFT.clear();
            localm.pFT.addAll(((HashMap)localObject3).keySet());
            localm.pFS.putAll((Map)localObject3);
            e.post(new m.a(localm, localm.pFR), "TopStory.DeleteVideoCacheTask");
            return;
          }
          localObject1 = new byh();
          ((byh)localObject1).bUi = str1;
          ((byh)localObject1).tOF = ((byg)localObject5).tOF;
          continue;
          label602:
          i = j;
          if (j > 100)
          {
            i = 100;
            continue;
            label616:
            y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", new Object[] { str1, Long.valueOf(((byh)localObject1).tOM) });
            continue;
            label645:
            continue;
            label647:
            i = -1;
            if ((i >= 0) && (i + 1 < j))
            {
              i += 1;
              continue;
              label667:
              i += 1;
            }
          }
        }
      }
    }
    
    public final void e(String paramString, int paramInt1, int paramInt2)
    {
      if (r.this.pEp != null)
      {
        m localm = r.this.pEp.bNw();
        long l1 = paramInt1;
        long l2 = paramInt2;
        if (localm.pFS.containsKey(paramString))
        {
          byh localbyh = (byh)localm.pFS.get(paramString);
          localbyh.bUi = paramString;
          localbyh.tOF = l2;
          localbyh.tOL = l1;
          localbyh.tOM = m.N(localbyh.tOL, localbyh.tOF);
          localm.pFS.put(paramString, localbyh);
        }
      }
      ai.d(new r.a.3(this, paramString, paramInt1, paramInt2));
    }
    
    public final void onDataAvailable(final String paramString, final int paramInt1, final int paramInt2)
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          if (r.this.pGu != null) {
            r.this.pGu.onDataAvailable(paramString, paramInt1, paramInt2);
          }
        }
      });
    }
    
    public final void onMoovReady(String paramString, int paramInt1, int paramInt2)
    {
      if (!this.pGE)
      {
        this.pGE = true;
        ai.d(new r.a.1(this, paramInt1, paramInt2, paramString));
      }
    }
    
    public final void x(String paramString, int paramInt)
    {
      int i = paramInt;
      if (com.tencent.mm.plugin.topstory.a.g.bNd())
      {
        i = paramInt;
        if (r.this.pGz)
        {
          r.this.pGz = false;
          i = 403;
        }
      }
      y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", new Object[] { paramString, Integer.valueOf(i) });
      if (r.this.pEp != null)
      {
        m localm = r.this.pEp.bNw();
        if (localm.pFS.containsKey(paramString))
        {
          byh localbyh = (byh)localm.pFS.get(paramString);
          if (i == 0)
          {
            localbyh.bUi = paramString;
            localbyh.tOL = localbyh.tOF;
            localbyh.tOM = m.N(localbyh.tOL, localbyh.tOF);
            localm.pFS.put(paramString, localbyh);
          }
          y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", new Object[] { paramString, Long.valueOf(localbyh.tOM), bk.a(localbyh.tOL, 100.0D), Integer.valueOf(i) });
        }
      }
      ai.d(new r.a.4(this, paramString, i));
    }
  }
  
  private final class c
    implements h.c
  {
    private c() {}
    
    public final void cB(long paramLong)
    {
      com.tencent.mm.plugin.report.f.nEG.a(600L, paramLong, 1L, false);
    }
    
    public final void qk(String paramString)
    {
      com.tencent.mm.plugin.report.f.nEG.aC(14349, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */