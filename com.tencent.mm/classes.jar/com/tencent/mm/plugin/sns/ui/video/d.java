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
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static d zjk;
  private List<WeakReference<SnsTimelineVideoView>> zjl;
  private List<SnsTimelineVideoView> zjm;
  private int zjn;
  public c zjo;
  public String zjp;
  public SnsTimelineVideoView zjq;
  
  public d()
  {
    AppMethodBeat.i(100419);
    this.zjl = new LinkedList();
    this.zjm = new ArrayList();
    this.zjn = 0;
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
  
  private void MT()
  {
    AppMethodBeat.i(100421);
    ac.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
    final SnsTimelineVideoView localSnsTimelineVideoView;
    if (!this.zjm.isEmpty())
    {
      localIterator = this.zjm.iterator();
      while (localIterator.hasNext())
      {
        localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
        if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
        {
          ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
          localSnsTimelineVideoView.zjb = false;
          localViewGroup.removeView(localSnsTimelineVideoView);
        }
        else if (localSnsTimelineVideoView != null)
        {
          localSnsTimelineVideoView.dSn();
        }
      }
      this.zjm.clear();
    }
    this.zjq = null;
    this.zjo = null;
    this.zjp = "";
    Iterator localIterator = this.zjl.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((WeakReference)localIterator.next()).get();
      j = i;
      if (localSnsTimelineVideoView != null)
      {
        j = i;
        if (!localSnsTimelineVideoView.zjc) {
          j = i + 1;
        }
        localSnsTimelineVideoView.dNR();
        com.tencent.e.h.JZN.aS(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100417);
            localSnsTimelineVideoView.yCG = true;
            localSnsTimelineVideoView.onDestroy();
            AppMethodBeat.o(100417);
          }
        });
      }
    }
    ac.w("MicroMsg.Sns.SnsVideoViewMgr", "[fallbackRelease] releaseCount=%s allCount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.zjl.size()) });
    this.zjl.clear();
    AppMethodBeat.o(100421);
  }
  
  public static d dSq()
  {
    try
    {
      AppMethodBeat.i(100418);
      if (zjk == null) {
        zjk = new d();
      }
      d locald = zjk;
      AppMethodBeat.o(100418);
      return locald;
    }
    finally {}
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, c paramc, String paramString)
  {
    AppMethodBeat.i(100420);
    this.zjq = ((SnsTimelineVideoView)paramOnlineVideoView);
    if (this.zjq != null) {
      this.zjq.setVisibility(0);
    }
    ac.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", new Object[] { Integer.valueOf(0), paramc.dwE.Id, paramString, Integer.valueOf(this.zjm.size()), paramOnlineVideoView.dNY() });
    Object localObject1 = new ArrayList();
    Object localObject2 = this.zjm.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject2).next();
      if (localSnsTimelineVideoView != paramOnlineVideoView) {
        if ((!localSnsTimelineVideoView.isPlaying()) && (!localSnsTimelineVideoView.MZ()))
        {
          ac.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()), Boolean.valueOf(localSnsTimelineVideoView.isPlaying()), Boolean.valueOf(localSnsTimelineVideoView.MZ()) });
          ((List)localObject1).add(localSnsTimelineVideoView);
        }
        else
        {
          boolean bool = B(localSnsTimelineVideoView);
          localSnsTimelineVideoView.rb(true);
          if (bool) {
            localSnsTimelineVideoView.dSk();
          }
          ac.i("MicroMsg.Sns.SnsVideoViewMgr", "%s pause ", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()) });
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
      this.zjm.remove(localObject2);
      ((SnsTimelineVideoView)localObject2).dSn();
    }
    if (this.zjq.ziW != null)
    {
      if ((bs.lr(paramString, this.zjq.ziX)) && (this.zjq.ziW.dwE.Id.equals(paramc.dwE.Id)))
      {
        ac.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", new Object[] { Integer.valueOf(this.zjq.hashCode()) });
        if (!this.zjq.isPlaying())
        {
          this.zjq.setScene(1);
          paramOnlineVideoView = this.zjq;
          paramc = new StringBuilder();
          g.agP();
          paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bs.eWj());
          this.zjq.setSessionTimestamp(bs.eWj());
          this.zjq.setSnsId(this.zjq.ziW.dnn);
          this.zjq.setFilePath(au.D(this.zjq.ziW.dwE));
        }
        this.zjq.dOc();
        this.zjq.setMute(true);
        this.zjq.abandonAudioFocus();
        AppMethodBeat.o(100420);
        return;
      }
      ac.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", new Object[] { Integer.valueOf(this.zjq.hashCode()) });
      this.zjq.dSp();
    }
    this.zjq.ziW = paramc;
    this.zjq.ziX = paramString;
    this.zjq.ziV = SnsTimelineVideoView.a.zji;
    this.zjq.ziY = System.currentTimeMillis();
    ac.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", new Object[] { Integer.valueOf(this.zjq.hashCode()), paramOnlineVideoView.dNY() });
    this.zjo = paramc;
    this.zjp = paramString;
    this.zjq.setMute(true);
    this.zjq.a(paramc.dwE, paramc.ddB, paramc.hGU);
    this.zjq.abandonAudioFocus();
    this.zjq.onResume();
    this.zjq.setScene(1);
    paramOnlineVideoView = this.zjq;
    paramc = new StringBuilder();
    g.agP();
    paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bs.eWj());
    this.zjq.setSessionTimestamp(bs.eWj());
    this.zjq.setSnsId(this.zjq.ziW.dnn);
    this.zjq.setFilePath(au.D(this.zjq.ziW.dwE));
    ac.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
    AppMethodBeat.o(100420);
  }
  
  public final void aI(Activity paramActivity)
  {
    AppMethodBeat.i(100424);
    this.zjn -= 1;
    ac.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.zjn) });
    if ((this.zjn <= 0) || ((paramActivity instanceof SnsTimeLineUI)))
    {
      if (this.zjn > 0) {
        com.tencent.mm.plugin.report.service.h.wUl.n(31L, 4L, 1L);
      }
      MT();
    }
    AppMethodBeat.o(100424);
  }
  
  public final boolean awa(String paramString)
  {
    AppMethodBeat.i(100425);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100425);
      return false;
    }
    Iterator localIterator = this.zjm.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if ((paramString.equals(localSnsTimelineVideoView.ziX)) && (localSnsTimelineVideoView.ziV != SnsTimelineVideoView.a.zjg))
      {
        AppMethodBeat.o(100425);
        return true;
      }
    }
    AppMethodBeat.o(100425);
    return false;
  }
  
  public final SnsTimelineVideoView awb(String paramString)
  {
    AppMethodBeat.i(100426);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100426);
      return null;
    }
    Object localObject = this.zjm.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    while (((Iterator)localObject).hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject).next();
      if (paramString.equals(localSnsTimelineVideoView.ziX)) {
        this.zjm.remove(localSnsTimelineVideoView);
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
      if (localSnsTimelineVideoView != this.zjq)
      {
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView == null) {}
      for (localObject = null;; localObject = gj(localSnsTimelineVideoView.getContext()))
      {
        localSnsTimelineVideoView.zjb = true;
        localViewGroup.removeView(localSnsTimelineVideoView);
        if (((SnsTimelineVideoView)localObject).getParent() != null)
        {
          ((SnsTimelineVideoView)localObject).dSo();
          ((SnsTimelineVideoView)localObject).zjb = true;
          ((ViewGroup)((SnsTimelineVideoView)localObject).getParent()).removeView((View)localObject);
        }
        ((SnsTimelineVideoView)localObject).setVisibility(0);
        ((SnsTimelineVideoView)localObject).setVideoScaleType(h.e.DnK);
        localViewGroup.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
        ((SnsTimelineVideoView)localObject).setTag(new a());
        ((SnsTimelineVideoView)localObject).a(localSnsTimelineVideoView.ziW.dwE, localSnsTimelineVideoView.ziW.ddB, localSnsTimelineVideoView.ziW.hGU);
        ((SnsTimelineVideoView)localObject).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        a((OnlineVideoView)localObject, localSnsTimelineVideoView.ziW, localSnsTimelineVideoView.ziX);
        ac.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", new Object[] { paramString });
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      localSnsTimelineVideoView = null;
    }
  }
  
  public final SnsTimelineVideoView awc(String paramString)
  {
    AppMethodBeat.i(100427);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100427);
      return null;
    }
    Iterator localIterator = this.zjm.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (paramString.equals(localSnsTimelineVideoView.ziX))
      {
        AppMethodBeat.o(100427);
        return localSnsTimelineVideoView;
      }
    }
    AppMethodBeat.o(100427);
    return null;
  }
  
  public final void crK()
  {
    AppMethodBeat.i(100422);
    ac.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
    if (this.zjq != null)
    {
      boolean bool = B(this.zjq);
      this.zjq.rb(true);
      if (bool) {
        this.zjq.dSk();
      }
    }
    AppMethodBeat.o(100422);
  }
  
  public final void dSr()
  {
    this.zjn += 1;
  }
  
  public final SnsTimelineVideoView gj(Context paramContext)
  {
    AppMethodBeat.i(100428);
    Object localObject = null;
    Iterator localIterator = this.zjm.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    if (localIterator.hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (localSnsTimelineVideoView.ziV != SnsTimelineVideoView.a.zjg) {
        break label494;
      }
      localObject = localSnsTimelineVideoView;
    }
    label494:
    for (;;)
    {
      break;
      if (localObject == null) {
        if (this.zjm.size() < 3)
        {
          paramContext = new SnsTimelineVideoView(paramContext);
          this.zjm.add(paramContext);
          this.zjl.add(new WeakReference(paramContext));
        }
      }
      for (;;)
      {
        paramContext.ziV = SnsTimelineVideoView.a.zjh;
        paramContext.dNV();
        ac.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", new Object[] { Integer.valueOf(paramContext.hashCode()) });
        AppMethodBeat.o(100428);
        return paramContext;
        localObject = new ArrayList();
        int i = -1;
        int j = 0;
        while (j < this.zjm.size())
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)this.zjm.get(j);
          int k = i;
          if (localSnsTimelineVideoView.ziV != SnsTimelineVideoView.a.zji)
          {
            k = i;
            if (localSnsTimelineVideoView.ziY < 9223372036854775807L)
            {
              k = i;
              if (!localSnsTimelineVideoView.zja) {
                k = j;
              }
            }
          }
          if (localSnsTimelineVideoView.zja) {
            ((List)localObject).add(localSnsTimelineVideoView);
          }
          j += 1;
          i = k;
        }
        if ((i < 0) && (((List)localObject).size() > 0))
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)((List)localObject).get(0);
          this.zjm.remove(localSnsTimelineVideoView);
          if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
          {
            localSnsTimelineVideoView.zjb = false;
            ((ViewGroup)localSnsTimelineVideoView.getParent()).removeView(localSnsTimelineVideoView);
          }
          for (;;)
          {
            paramContext = new SnsTimelineVideoView(paramContext);
            this.zjm.add(paramContext);
            this.zjl.add(new WeakReference(paramContext));
            ac.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(((SnsTimelineVideoView)((List)localObject).get(0)).hashCode()) });
            break;
            if (localSnsTimelineVideoView != null) {
              localSnsTimelineVideoView.dSn();
            }
          }
        }
        paramContext = this.zjm;
        if (i < 0) {}
        for (j = 0;; j = i)
        {
          paramContext = (SnsTimelineVideoView)paramContext.get(j);
          ac.i("MicroMsg.Sns.SnsVideoViewMgr", "use minIndex: %s", new Object[] { Integer.valueOf(i) });
          break;
        }
        paramContext = (Context)localObject;
      }
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(100423);
    ac.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay onUIPause");
    if (this.zjq != null)
    {
      boolean bool = B(this.zjq);
      this.zjq.dSl();
      if (bool) {
        this.zjq.dSk();
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