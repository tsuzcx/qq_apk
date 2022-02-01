package com.tencent.mm.plugin.sns.ui.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static d xWo;
  private List<WeakReference<SnsTimelineVideoView>> xWp;
  private List<SnsTimelineVideoView> xWq;
  private int xWr;
  public c xWs;
  public String xWt;
  public SnsTimelineVideoView xWu;
  
  public d()
  {
    AppMethodBeat.i(100419);
    this.xWp = new LinkedList();
    this.xWq = new ArrayList();
    this.xWr = 0;
    AppMethodBeat.o(100419);
  }
  
  private static boolean B(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(100429);
    bool2 = false;
    bool1 = bool2;
    if (paramOnlineVideoView != null) {}
    try
    {
      boolean bool3 = paramOnlineVideoView.isPlaying();
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
    }
    catch (Exception paramOnlineVideoView)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(100429);
    return bool1;
  }
  
  private void MV()
  {
    AppMethodBeat.i(100421);
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
    final SnsTimelineVideoView localSnsTimelineVideoView;
    if (!this.xWq.isEmpty())
    {
      localIterator = this.xWq.iterator();
      while (localIterator.hasNext())
      {
        localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
        if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
        {
          ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
          localSnsTimelineVideoView.xWf = false;
          localViewGroup.removeView(localSnsTimelineVideoView);
        }
        else if (localSnsTimelineVideoView != null)
        {
          localSnsTimelineVideoView.dDP();
        }
      }
      this.xWq.clear();
    }
    this.xWu = null;
    this.xWs = null;
    this.xWt = "";
    Iterator localIterator = this.xWp.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((WeakReference)localIterator.next()).get();
      j = i;
      if (localSnsTimelineVideoView != null)
      {
        j = i;
        if (!localSnsTimelineVideoView.xWg) {
          j = i + 1;
        }
        localSnsTimelineVideoView.dzu();
        com.tencent.e.h.Iye.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100417);
            localSnsTimelineVideoView.xpQ = true;
            localSnsTimelineVideoView.onDestroy();
            AppMethodBeat.o(100417);
          }
        });
      }
    }
    ad.w("MicroMsg.Sns.SnsVideoViewMgr", "[fallbackRelease] releaseCount=%s allCount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.xWp.size()) });
    this.xWp.clear();
    AppMethodBeat.o(100421);
  }
  
  public static d dDS()
  {
    try
    {
      AppMethodBeat.i(100418);
      if (xWo == null) {
        xWo = new d();
      }
      d locald = xWo;
      AppMethodBeat.o(100418);
      return locald;
    }
    finally {}
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, c paramc, String paramString)
  {
    AppMethodBeat.i(100420);
    this.xWu = ((SnsTimelineVideoView)paramOnlineVideoView);
    if (this.xWu != null) {
      this.xWu.setVisibility(0);
    }
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", new Object[] { Integer.valueOf(0), paramc.dyS.Id, paramString, Integer.valueOf(this.xWq.size()), paramOnlineVideoView.dzB() });
    Object localObject1 = new ArrayList();
    Object localObject2 = this.xWq.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject2).next();
      if (localSnsTimelineVideoView != paramOnlineVideoView) {
        if ((!localSnsTimelineVideoView.isPlaying()) && (!localSnsTimelineVideoView.Nb()))
        {
          ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()), Boolean.valueOf(localSnsTimelineVideoView.isPlaying()), Boolean.valueOf(localSnsTimelineVideoView.Nb()) });
          ((List)localObject1).add(localSnsTimelineVideoView);
        }
        else
        {
          boolean bool = B(localSnsTimelineVideoView);
          localSnsTimelineVideoView.qc(true);
          if (bool) {
            localSnsTimelineVideoView.dDM();
          }
          ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s pause ", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()) });
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SnsTimelineVideoView)((Iterator)localObject1).next();
      if (((SnsTimelineVideoView)localObject2).getParent() != null) {
        ((ViewGroup)((SnsTimelineVideoView)localObject2).getParent()).removeView((View)localObject2);
      }
      this.xWq.remove(localObject2);
      ((SnsTimelineVideoView)localObject2).dDP();
    }
    if (this.xWu.xWa != null)
    {
      if ((bt.kU(paramString, this.xWu.xWb)) && (this.xWu.xWa.dyS.Id.equals(paramc.dyS.Id)))
      {
        ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", new Object[] { Integer.valueOf(this.xWu.hashCode()) });
        if (!this.xWu.isPlaying())
        {
          this.xWu.setScene(1);
          paramOnlineVideoView = this.xWu;
          paramc = new StringBuilder();
          g.afz();
          paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bt.eGO());
          this.xWu.setSessionTimestamp(bt.eGO());
          this.xWu.setSnsId(this.xWu.xWa.dpC);
          this.xWu.setFilePath(at.D(this.xWu.xWa.dyS));
        }
        this.xWu.dzF();
        this.xWu.setMute(true);
        this.xWu.abandonAudioFocus();
        AppMethodBeat.o(100420);
        return;
      }
      ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", new Object[] { Integer.valueOf(this.xWu.hashCode()) });
      this.xWu.dDR();
    }
    this.xWu.xWa = paramc;
    this.xWu.xWb = paramString;
    this.xWu.xVZ = SnsTimelineVideoView.a.xWm;
    this.xWu.xWc = System.currentTimeMillis();
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", new Object[] { Integer.valueOf(this.xWu.hashCode()), paramOnlineVideoView.dzB() });
    this.xWs = paramc;
    this.xWt = paramString;
    this.xWu.setMute(true);
    this.xWu.a(paramc.dyS, paramc.dgg, paramc.hgr);
    this.xWu.abandonAudioFocus();
    this.xWu.onResume();
    this.xWu.setScene(1);
    paramOnlineVideoView = this.xWu;
    paramc = new StringBuilder();
    g.afz();
    paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bt.eGO());
    this.xWu.setSessionTimestamp(bt.eGO());
    this.xWu.setSnsId(this.xWu.xWa.dpC);
    this.xWu.setFilePath(at.D(this.xWu.xWa.dyS));
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
    AppMethodBeat.o(100420);
  }
  
  public final void aE(Activity paramActivity)
  {
    AppMethodBeat.i(100424);
    this.xWr -= 1;
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.xWr) });
    if ((this.xWr <= 0) || ((paramActivity instanceof SnsTimeLineUI)))
    {
      if (this.xWr > 0) {
        com.tencent.mm.plugin.report.service.h.vKh.m(31L, 4L, 1L);
      }
      MV();
    }
    AppMethodBeat.o(100424);
  }
  
  public final boolean aqR(String paramString)
  {
    AppMethodBeat.i(100425);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100425);
      return false;
    }
    Iterator localIterator = this.xWq.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if ((paramString.equals(localSnsTimelineVideoView.xWb)) && (localSnsTimelineVideoView.xVZ != SnsTimelineVideoView.a.xWk))
      {
        AppMethodBeat.o(100425);
        return true;
      }
    }
    AppMethodBeat.o(100425);
    return false;
  }
  
  public final SnsTimelineVideoView aqS(String paramString)
  {
    AppMethodBeat.i(100426);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100426);
      return null;
    }
    Object localObject = this.xWq.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    while (((Iterator)localObject).hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject).next();
      if (paramString.equals(localSnsTimelineVideoView.xWb)) {
        this.xWq.remove(localSnsTimelineVideoView);
      }
    }
    for (;;)
    {
      if (localSnsTimelineVideoView == null)
      {
        AppMethodBeat.o(100426);
        return null;
      }
      ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
      if (localViewGroup == null)
      {
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView != this.xWu)
      {
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView == null) {}
      for (localObject = null;; localObject = fX(localSnsTimelineVideoView.getContext()))
      {
        localSnsTimelineVideoView.xWf = true;
        localViewGroup.removeView(localSnsTimelineVideoView);
        if (((SnsTimelineVideoView)localObject).getParent() != null)
        {
          ((SnsTimelineVideoView)localObject).dDQ();
          ((SnsTimelineVideoView)localObject).xWf = true;
          ((ViewGroup)((SnsTimelineVideoView)localObject).getParent()).removeView((View)localObject);
        }
        ((SnsTimelineVideoView)localObject).setVisibility(0);
        ((SnsTimelineVideoView)localObject).setVideoScaleType(h.e.BVt);
        localViewGroup.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
        ((SnsTimelineVideoView)localObject).setTag(new a());
        ((SnsTimelineVideoView)localObject).a(localSnsTimelineVideoView.xWa.dyS, localSnsTimelineVideoView.xWa.dgg, localSnsTimelineVideoView.xWa.hgr);
        ((SnsTimelineVideoView)localObject).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        a((OnlineVideoView)localObject, localSnsTimelineVideoView.xWa, localSnsTimelineVideoView.xWb);
        ad.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", new Object[] { paramString });
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      localSnsTimelineVideoView = null;
    }
  }
  
  public final SnsTimelineVideoView aqT(String paramString)
  {
    AppMethodBeat.i(100427);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100427);
      return null;
    }
    Iterator localIterator = this.xWq.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (paramString.equals(localSnsTimelineVideoView.xWb))
      {
        AppMethodBeat.o(100427);
        return localSnsTimelineVideoView;
      }
    }
    AppMethodBeat.o(100427);
    return null;
  }
  
  public final void ckd()
  {
    AppMethodBeat.i(100422);
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
    if (this.xWu != null)
    {
      boolean bool = B(this.xWu);
      this.xWu.qc(true);
      if (bool) {
        this.xWu.dDM();
      }
    }
    AppMethodBeat.o(100422);
  }
  
  public final void dDT()
  {
    this.xWr += 1;
  }
  
  public final SnsTimelineVideoView fX(Context paramContext)
  {
    AppMethodBeat.i(100428);
    Object localObject = null;
    Iterator localIterator = this.xWq.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    if (localIterator.hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (localSnsTimelineVideoView.xVZ != SnsTimelineVideoView.a.xWk) {
        break label494;
      }
      localObject = localSnsTimelineVideoView;
    }
    label494:
    for (;;)
    {
      break;
      if (localObject == null) {
        if (this.xWq.size() < 3)
        {
          paramContext = new SnsTimelineVideoView(paramContext);
          this.xWq.add(paramContext);
          this.xWp.add(new WeakReference(paramContext));
        }
      }
      for (;;)
      {
        paramContext.xVZ = SnsTimelineVideoView.a.xWl;
        paramContext.dzy();
        ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", new Object[] { Integer.valueOf(paramContext.hashCode()) });
        AppMethodBeat.o(100428);
        return paramContext;
        localObject = new ArrayList();
        int i = -1;
        int j = 0;
        while (j < this.xWq.size())
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)this.xWq.get(j);
          int k = i;
          if (localSnsTimelineVideoView.xVZ != SnsTimelineVideoView.a.xWm)
          {
            k = i;
            if (localSnsTimelineVideoView.xWc < 9223372036854775807L)
            {
              k = i;
              if (!localSnsTimelineVideoView.xWe) {
                k = j;
              }
            }
          }
          if (localSnsTimelineVideoView.xWe) {
            ((List)localObject).add(localSnsTimelineVideoView);
          }
          j += 1;
          i = k;
        }
        if ((i < 0) && (((List)localObject).size() > 0))
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)((List)localObject).get(0);
          this.xWq.remove(localSnsTimelineVideoView);
          if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
          {
            localSnsTimelineVideoView.xWf = false;
            ((ViewGroup)localSnsTimelineVideoView.getParent()).removeView(localSnsTimelineVideoView);
          }
          for (;;)
          {
            paramContext = new SnsTimelineVideoView(paramContext);
            this.xWq.add(paramContext);
            this.xWp.add(new WeakReference(paramContext));
            ad.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(((SnsTimelineVideoView)((List)localObject).get(0)).hashCode()) });
            break;
            if (localSnsTimelineVideoView != null) {
              localSnsTimelineVideoView.dDP();
            }
          }
        }
        paramContext = this.xWq;
        if (i < 0) {}
        for (j = 0;; j = i)
        {
          paramContext = (SnsTimelineVideoView)paramContext.get(j);
          ad.i("MicroMsg.Sns.SnsVideoViewMgr", "use minIndex: %s", new Object[] { Integer.valueOf(i) });
          break;
        }
        paramContext = (Context)localObject;
      }
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(100423);
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay onUIPause");
    if (this.xWu != null)
    {
      boolean bool = B(this.xWu);
      this.xWu.dDN();
      if (bool) {
        this.xWu.dDM();
      }
    }
    AppMethodBeat.o(100423);
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.d
 * JD-Core Version:    0.7.0.1
 */