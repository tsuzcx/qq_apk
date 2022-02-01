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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private static e LrM;
  private List<WeakReference<SnsTimelineVideoView>> LrN;
  private List<SnsTimelineVideoView> LrO;
  private int LrP;
  public d LrQ;
  public String LrR;
  public SnsTimelineVideoView LrS;
  private WeakReference<SnsTimelineVideoView> LrT;
  
  public e()
  {
    AppMethodBeat.i(100419);
    this.LrN = new LinkedList();
    this.LrO = new ArrayList();
    this.LrP = 0;
    this.LrT = null;
    AppMethodBeat.o(100419);
  }
  
  private static boolean Q(OnlineVideoView paramOnlineVideoView)
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
  
  public static e fZg()
  {
    try
    {
      AppMethodBeat.i(100418);
      if (LrM == null) {
        LrM = new e();
      }
      e locale = LrM;
      AppMethodBeat.o(100418);
      return locale;
    }
    finally {}
  }
  
  public static boolean fZi()
  {
    AppMethodBeat.i(202768);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGA, true);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "enableNewSmallViewType %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(202768);
    return bool;
  }
  
  private void stopAll()
  {
    AppMethodBeat.i(100421);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
    final SnsTimelineVideoView localSnsTimelineVideoView;
    if (!this.LrO.isEmpty())
    {
      localIterator = this.LrO.iterator();
      while (localIterator.hasNext())
      {
        localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
        if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
        {
          ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
          localSnsTimelineVideoView.Lry = false;
          localViewGroup.removeView(localSnsTimelineVideoView);
        }
        else if (localSnsTimelineVideoView != null)
        {
          localSnsTimelineVideoView.fZa();
        }
      }
      this.LrO.clear();
    }
    this.LrS = null;
    this.LrQ = null;
    this.LrR = "";
    Iterator localIterator = this.LrN.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((WeakReference)localIterator.next()).get();
      j = i;
      if (localSnsTimelineVideoView != null)
      {
        j = i;
        if (!localSnsTimelineVideoView.Lrz) {
          j = i + 1;
        }
        localSnsTimelineVideoView.fTZ();
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100417);
            localSnsTimelineVideoView.KHA = true;
            localSnsTimelineVideoView.onDestroy();
            AppMethodBeat.o(100417);
          }
        });
      }
    }
    Log.w("MicroMsg.Sns.SnsVideoViewMgr", "[fallbackRelease] releaseCount=%s allCount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.LrN.size()) });
    this.LrN.clear();
    AppMethodBeat.o(100421);
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, d paramd, String paramString)
  {
    AppMethodBeat.i(100420);
    if (paramd == null)
    {
      Log.e("MicroMsg.Sns.SnsVideoViewMgr", "startPlay without videoInfo");
      AppMethodBeat.o(100420);
      return;
    }
    this.LrS = ((SnsTimelineVideoView)paramOnlineVideoView);
    if (this.LrS != null) {
      this.LrS.setVisibility(0);
    }
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", new Object[] { Integer.valueOf(0), paramd.fVT.Id, paramString, Integer.valueOf(this.LrO.size()), paramOnlineVideoView.fUh() });
    Object localObject1 = new ArrayList();
    Object localObject2 = this.LrO.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject2).next();
      if (localSnsTimelineVideoView != paramOnlineVideoView) {
        if ((!localSnsTimelineVideoView.isPlaying()) && (!localSnsTimelineVideoView.adH()))
        {
          Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()), Boolean.valueOf(localSnsTimelineVideoView.isPlaying()), Boolean.valueOf(localSnsTimelineVideoView.adH()) });
          ((List)localObject1).add(localSnsTimelineVideoView);
        }
        else
        {
          boolean bool = Q(localSnsTimelineVideoView);
          localSnsTimelineVideoView.yp(true);
          if (bool) {
            localSnsTimelineVideoView.fYY();
          }
          Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s pause ", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()) });
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
      this.LrO.remove(localObject2);
      ((SnsTimelineVideoView)localObject2).fZa();
    }
    if (this.LrS.Lru != null)
    {
      if ((Util.isEqual(paramString, this.LrS.Lrv)) && (this.LrS.Lru.fVT.Id.equals(paramd.fVT.Id)))
      {
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", new Object[] { Integer.valueOf(this.LrS.hashCode()) });
        if (!this.LrS.isPlaying())
        {
          this.LrS.setScene(1);
          paramOnlineVideoView = this.LrS;
          paramd = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramOnlineVideoView.setSessionId(new p(com.tencent.mm.kernel.b.getUin()).toString() + "_" + Util.nowMilliSecond());
          this.LrS.setSessionTimestamp(Util.nowMilliSecond());
          this.LrS.setSnsId(this.LrS.Lru.fLp);
          this.LrS.setFilePath(ax.E(this.LrS.Lru.fVT));
        }
        this.LrS.fLJ();
        this.LrS.setMute(true);
        this.LrS.abandonAudioFocus();
        AppMethodBeat.o(100420);
        return;
      }
      Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", new Object[] { Integer.valueOf(this.LrS.hashCode()) });
      this.LrS.fZc();
    }
    this.LrS.Lru = paramd;
    this.LrS.Lrv = paramString;
    this.LrS.Lrt = SnsTimelineVideoView.a.LrF;
    this.LrS.zXq = System.currentTimeMillis();
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", new Object[] { Integer.valueOf(this.LrS.hashCode()), paramOnlineVideoView.fUh() });
    this.LrQ = paramd;
    this.LrR = paramString;
    this.LrS.setMute(true);
    this.LrS.a(paramd.fVT, paramd.fAg, paramd.createTime);
    this.LrS.abandonAudioFocus();
    this.LrS.onResume();
    this.LrS.setScene(1);
    paramOnlineVideoView = this.LrS;
    paramd = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    paramOnlineVideoView.setSessionId(new p(com.tencent.mm.kernel.b.getUin()).toString() + "_" + Util.nowMilliSecond());
    this.LrS.setSessionTimestamp(Util.nowMilliSecond());
    this.LrS.setSnsId(this.LrS.Lru.fLp);
    this.LrS.setFilePath(ax.E(this.LrS.Lru.fVT));
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
    AppMethodBeat.o(100420);
  }
  
  public final void aT(Activity paramActivity)
  {
    AppMethodBeat.i(100424);
    this.LrP -= 1;
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.LrP) });
    if ((this.LrP <= 0) || ((paramActivity instanceof SnsTimeLineUI)))
    {
      if (this.LrP > 0) {
        com.tencent.mm.plugin.report.service.h.IzE.p(31L, 4L, 1L);
      }
      stopAll();
    }
    AppMethodBeat.o(100424);
  }
  
  public final boolean bcA(String paramString)
  {
    AppMethodBeat.i(100425);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100425);
      return false;
    }
    Iterator localIterator = this.LrO.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if ((paramString.equals(localSnsTimelineVideoView.Lrv)) && (localSnsTimelineVideoView.Lrt != SnsTimelineVideoView.a.LrD))
      {
        AppMethodBeat.o(100425);
        return true;
      }
    }
    AppMethodBeat.o(100425);
    return false;
  }
  
  public final SnsTimelineVideoView bcB(String paramString)
  {
    AppMethodBeat.i(100426);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100426);
      return null;
    }
    Object localObject = this.LrO.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    while (((Iterator)localObject).hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject).next();
      if (paramString.equals(localSnsTimelineVideoView.Lrv)) {
        this.LrO.remove(localSnsTimelineVideoView);
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
      if (localSnsTimelineVideoView != this.LrS)
      {
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView == null)
      {
        localObject = null;
        localSnsTimelineVideoView.Lry = true;
        localViewGroup.removeView(localSnsTimelineVideoView);
        if (((SnsTimelineVideoView)localObject).getParent() != null)
        {
          ((SnsTimelineVideoView)localObject).fZb();
          ((SnsTimelineVideoView)localObject).Lry = true;
          ((ViewGroup)((SnsTimelineVideoView)localObject).getParent()).removeView((View)localObject);
        }
        ((SnsTimelineVideoView)localObject).setVisibility(0);
        ((SnsTimelineVideoView)localObject).setVideoScaleType(i.e.RcH);
        localViewGroup.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
        ((SnsTimelineVideoView)localObject).setTag(new a());
        ((SnsTimelineVideoView)localObject).a(localSnsTimelineVideoView.Lru.fVT, localSnsTimelineVideoView.Lru.fAg, localSnsTimelineVideoView.Lru.createTime);
        ((SnsTimelineVideoView)localObject).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        if (!fZi()) {
          break label306;
        }
        this.LrQ = localSnsTimelineVideoView.Lru;
        this.LrR = localSnsTimelineVideoView.Lrv;
        this.LrT = new WeakReference(localObject);
      }
      for (;;)
      {
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", new Object[] { paramString });
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
        localObject = ie(localSnsTimelineVideoView.getContext());
        break;
        label306:
        a((OnlineVideoView)localObject, localSnsTimelineVideoView.Lru, localSnsTimelineVideoView.Lrv);
      }
      localSnsTimelineVideoView = null;
    }
  }
  
  public final SnsTimelineVideoView bcC(String paramString)
  {
    AppMethodBeat.i(100427);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100427);
      return null;
    }
    Iterator localIterator = this.LrO.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (paramString.equals(localSnsTimelineVideoView.Lrv))
      {
        AppMethodBeat.o(100427);
        return localSnsTimelineVideoView;
      }
    }
    AppMethodBeat.o(100427);
    return null;
  }
  
  public final boolean bcz(String paramString)
  {
    AppMethodBeat.i(202761);
    if ((Util.isNullOrNil(this.LrR)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(202761);
      return false;
    }
    boolean bool = this.LrR.equals(paramString);
    AppMethodBeat.o(202761);
    return bool;
  }
  
  public final void dmi()
  {
    AppMethodBeat.i(100422);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
    if (this.LrS != null)
    {
      boolean bool = Q(this.LrS);
      this.LrS.yp(true);
      if (bool) {
        this.LrS.fYY();
      }
    }
    AppMethodBeat.o(100422);
  }
  
  public final void fZh()
  {
    this.LrP += 1;
  }
  
  public final SnsTimelineVideoView ie(Context paramContext)
  {
    AppMethodBeat.i(100428);
    Object localObject = null;
    Iterator localIterator = this.LrO.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    if (localIterator.hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (localSnsTimelineVideoView.Lrt != SnsTimelineVideoView.a.LrD) {
        break label494;
      }
      localObject = localSnsTimelineVideoView;
    }
    label494:
    for (;;)
    {
      break;
      if (localObject == null) {
        if (this.LrO.size() < 3)
        {
          paramContext = new SnsTimelineVideoView(paramContext);
          this.LrO.add(paramContext);
          this.LrN.add(new WeakReference(paramContext));
        }
      }
      for (;;)
      {
        paramContext.Lrt = SnsTimelineVideoView.a.LrE;
        paramContext.fUe();
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", new Object[] { Integer.valueOf(paramContext.hashCode()) });
        AppMethodBeat.o(100428);
        return paramContext;
        localObject = new ArrayList();
        int i = -1;
        int j = 0;
        while (j < this.LrO.size())
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)this.LrO.get(j);
          int k = i;
          if (localSnsTimelineVideoView.Lrt != SnsTimelineVideoView.a.LrF)
          {
            k = i;
            if (localSnsTimelineVideoView.zXq < 9223372036854775807L)
            {
              k = i;
              if (!localSnsTimelineVideoView.Lrx) {
                k = j;
              }
            }
          }
          if (localSnsTimelineVideoView.Lrx) {
            ((List)localObject).add(localSnsTimelineVideoView);
          }
          j += 1;
          i = k;
        }
        if ((i < 0) && (((List)localObject).size() > 0))
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)((List)localObject).get(0);
          this.LrO.remove(localSnsTimelineVideoView);
          if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
          {
            localSnsTimelineVideoView.Lry = false;
            ((ViewGroup)localSnsTimelineVideoView.getParent()).removeView(localSnsTimelineVideoView);
          }
          for (;;)
          {
            paramContext = new SnsTimelineVideoView(paramContext);
            this.LrO.add(paramContext);
            this.LrN.add(new WeakReference(paramContext));
            Log.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(((SnsTimelineVideoView)((List)localObject).get(0)).hashCode()) });
            break;
            if (localSnsTimelineVideoView != null) {
              localSnsTimelineVideoView.fZa();
            }
          }
        }
        paramContext = this.LrO;
        if (i < 0) {}
        for (j = 0;; j = i)
        {
          paramContext = (SnsTimelineVideoView)paramContext.get(j);
          Log.i("MicroMsg.Sns.SnsVideoViewMgr", "use minIndex: %s", new Object[] { Integer.valueOf(i) });
          break;
        }
        paramContext = (Context)localObject;
      }
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(100423);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay onUIPause");
    if (this.LrS != null)
    {
      boolean bool = Q(this.LrS);
      this.LrS.fYZ();
      if (bool) {
        this.LrS.fYY();
      }
    }
    AppMethodBeat.o(100423);
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.e
 * JD-Core Version:    0.7.0.1
 */