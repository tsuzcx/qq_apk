package com.tencent.mm.plugin.sns.ui.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static d Fdl;
  private List<WeakReference<SnsTimelineVideoView>> Fdm;
  private List<SnsTimelineVideoView> Fdn;
  private int Fdo;
  public c Fdp;
  public String Fdq;
  public SnsTimelineVideoView Fdr;
  private WeakReference<SnsTimelineVideoView> JRM;
  
  public d()
  {
    AppMethodBeat.i(100419);
    this.Fdm = new LinkedList();
    this.Fdn = new ArrayList();
    this.Fdo = 0;
    this.JRM = null;
    AppMethodBeat.o(100419);
  }
  
  private static boolean H(OnlineVideoView paramOnlineVideoView)
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
  
  public static d fkS()
  {
    try
    {
      AppMethodBeat.i(100418);
      if (Fdl == null) {
        Fdl = new d();
      }
      d locald = Fdl;
      AppMethodBeat.o(100418);
      return locald;
    }
    finally {}
  }
  
  public static boolean gcR()
  {
    AppMethodBeat.i(258147);
    boolean bool = ((b)g.af(b.class)).a(b.a.zpN, true);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "enableNewSmallViewType %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(258147);
    return bool;
  }
  
  private void stopAll()
  {
    AppMethodBeat.i(100421);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
    final SnsTimelineVideoView localSnsTimelineVideoView;
    if (!this.Fdn.isEmpty())
    {
      localIterator = this.Fdn.iterator();
      while (localIterator.hasNext())
      {
        localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
        if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
        {
          ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
          localSnsTimelineVideoView.Fdc = false;
          localViewGroup.removeView(localSnsTimelineVideoView);
        }
        else if (localSnsTimelineVideoView != null)
        {
          localSnsTimelineVideoView.fkP();
        }
      }
      this.Fdn.clear();
    }
    this.Fdr = null;
    this.Fdp = null;
    this.Fdq = "";
    Iterator localIterator = this.Fdm.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((WeakReference)localIterator.next()).get();
      j = i;
      if (localSnsTimelineVideoView != null)
      {
        j = i;
        if (!localSnsTimelineVideoView.Fdd) {
          j = i + 1;
        }
        localSnsTimelineVideoView.fgc();
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100417);
            localSnsTimelineVideoView.EtU = true;
            localSnsTimelineVideoView.onDestroy();
            AppMethodBeat.o(100417);
          }
        });
      }
    }
    Log.w("MicroMsg.Sns.SnsVideoViewMgr", "[fallbackRelease] releaseCount=%s allCount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Fdm.size()) });
    this.Fdm.clear();
    AppMethodBeat.o(100421);
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, c paramc, String paramString)
  {
    AppMethodBeat.i(100420);
    if (paramc == null)
    {
      Log.e("MicroMsg.Sns.SnsVideoViewMgr", "startPlay without videoInfo");
      AppMethodBeat.o(100420);
      return;
    }
    this.Fdr = ((SnsTimelineVideoView)paramOnlineVideoView);
    if (this.Fdr != null) {
      this.Fdr.setVisibility(0);
    }
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", new Object[] { Integer.valueOf(0), paramc.ebR.Id, paramString, Integer.valueOf(this.Fdn.size()), paramOnlineVideoView.fgj() });
    Object localObject1 = new ArrayList();
    Object localObject2 = this.Fdn.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject2).next();
      if (localSnsTimelineVideoView != paramOnlineVideoView) {
        if ((!localSnsTimelineVideoView.isPlaying()) && (!localSnsTimelineVideoView.YY()))
        {
          Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()), Boolean.valueOf(localSnsTimelineVideoView.isPlaying()), Boolean.valueOf(localSnsTimelineVideoView.YY()) });
          ((List)localObject1).add(localSnsTimelineVideoView);
        }
        else
        {
          boolean bool = H(localSnsTimelineVideoView);
          localSnsTimelineVideoView.vi(true);
          if (bool) {
            localSnsTimelineVideoView.fkN();
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
      this.Fdn.remove(localObject2);
      ((SnsTimelineVideoView)localObject2).fkP();
    }
    if (this.Fdr.FcY != null)
    {
      if ((Util.isEqual(paramString, this.Fdr.FcZ)) && (this.Fdr.FcY.ebR.Id.equals(paramc.ebR.Id)))
      {
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", new Object[] { Integer.valueOf(this.Fdr.hashCode()) });
        if (!this.Fdr.isPlaying())
        {
          this.Fdr.setScene(1);
          paramOnlineVideoView = this.Fdr;
          paramc = new StringBuilder();
          g.aAf();
          paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + Util.nowMilliSecond());
          this.Fdr.setSessionTimestamp(Util.nowMilliSecond());
          this.Fdr.setSnsId(this.Fdr.FcY.dRS);
          this.Fdr.setFilePath(ay.E(this.Fdr.FcY.ebR));
        }
        this.Fdr.eYd();
        this.Fdr.setMute(true);
        this.Fdr.abandonAudioFocus();
        AppMethodBeat.o(100420);
        return;
      }
      Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", new Object[] { Integer.valueOf(this.Fdr.hashCode()) });
      this.Fdr.fkR();
    }
    this.Fdr.FcY = paramc;
    this.Fdr.FcZ = paramString;
    this.Fdr.FcX = SnsTimelineVideoView.a.Fdj;
    this.Fdr.vgi = System.currentTimeMillis();
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", new Object[] { Integer.valueOf(this.Fdr.hashCode()), paramOnlineVideoView.fgj() });
    this.Fdp = paramc;
    this.Fdq = paramString;
    this.Fdr.setMute(true);
    this.Fdr.a(paramc.ebR, paramc.dHp, paramc.iXu);
    this.Fdr.abandonAudioFocus();
    this.Fdr.onResume();
    this.Fdr.setScene(1);
    paramOnlineVideoView = this.Fdr;
    paramc = new StringBuilder();
    g.aAf();
    paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + Util.nowMilliSecond());
    this.Fdr.setSessionTimestamp(Util.nowMilliSecond());
    this.Fdr.setSnsId(this.Fdr.FcY.dRS);
    this.Fdr.setFilePath(ay.E(this.Fdr.FcY.ebR));
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
    AppMethodBeat.o(100420);
  }
  
  public final void aN(Activity paramActivity)
  {
    AppMethodBeat.i(100424);
    this.Fdo -= 1;
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.Fdo) });
    if ((this.Fdo <= 0) || ((paramActivity instanceof SnsTimeLineUI)))
    {
      if (this.Fdo > 0) {
        com.tencent.mm.plugin.report.service.h.CyF.n(31L, 4L, 1L);
      }
      stopAll();
    }
    AppMethodBeat.o(100424);
  }
  
  public final boolean aRu(String paramString)
  {
    AppMethodBeat.i(203977);
    if ((Util.isNullOrNil(this.Fdq)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(203977);
      return false;
    }
    boolean bool = this.Fdq.equals(paramString);
    AppMethodBeat.o(203977);
    return bool;
  }
  
  public final boolean aRv(String paramString)
  {
    AppMethodBeat.i(100425);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100425);
      return false;
    }
    Iterator localIterator = this.Fdn.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if ((paramString.equals(localSnsTimelineVideoView.FcZ)) && (localSnsTimelineVideoView.FcX != SnsTimelineVideoView.a.Fdh))
      {
        AppMethodBeat.o(100425);
        return true;
      }
    }
    AppMethodBeat.o(100425);
    return false;
  }
  
  public final SnsTimelineVideoView aRw(String paramString)
  {
    AppMethodBeat.i(100426);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100426);
      return null;
    }
    Object localObject = this.Fdn.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    while (((Iterator)localObject).hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject).next();
      if (paramString.equals(localSnsTimelineVideoView.FcZ)) {
        this.Fdn.remove(localSnsTimelineVideoView);
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
      if (localSnsTimelineVideoView != this.Fdr)
      {
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView == null)
      {
        localObject = null;
        localSnsTimelineVideoView.Fdc = true;
        localViewGroup.removeView(localSnsTimelineVideoView);
        if (((SnsTimelineVideoView)localObject).getParent() != null)
        {
          ((SnsTimelineVideoView)localObject).fkQ();
          ((SnsTimelineVideoView)localObject).Fdc = true;
          ((ViewGroup)((SnsTimelineVideoView)localObject).getParent()).removeView((View)localObject);
        }
        ((SnsTimelineVideoView)localObject).setVisibility(0);
        ((SnsTimelineVideoView)localObject).setVideoScaleType(i.e.Kcc);
        localViewGroup.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
        ((SnsTimelineVideoView)localObject).setTag(new a());
        ((SnsTimelineVideoView)localObject).a(localSnsTimelineVideoView.FcY.ebR, localSnsTimelineVideoView.FcY.dHp, localSnsTimelineVideoView.FcY.iXu);
        ((SnsTimelineVideoView)localObject).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        if (!gcR()) {
          break label306;
        }
        this.Fdp = localSnsTimelineVideoView.FcY;
        this.Fdq = localSnsTimelineVideoView.FcZ;
        this.JRM = new WeakReference(localObject);
      }
      for (;;)
      {
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", new Object[] { paramString });
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
        localObject = hd(localSnsTimelineVideoView.getContext());
        break;
        label306:
        a((OnlineVideoView)localObject, localSnsTimelineVideoView.FcY, localSnsTimelineVideoView.FcZ);
      }
      localSnsTimelineVideoView = null;
    }
  }
  
  public final SnsTimelineVideoView aRx(String paramString)
  {
    AppMethodBeat.i(100427);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100427);
      return null;
    }
    Iterator localIterator = this.Fdn.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (paramString.equals(localSnsTimelineVideoView.FcZ))
      {
        AppMethodBeat.o(100427);
        return localSnsTimelineVideoView;
      }
    }
    AppMethodBeat.o(100427);
    return null;
  }
  
  public final void cXa()
  {
    AppMethodBeat.i(100422);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
    if (this.Fdr != null)
    {
      boolean bool = H(this.Fdr);
      this.Fdr.vi(true);
      if (bool) {
        this.Fdr.fkN();
      }
    }
    AppMethodBeat.o(100422);
  }
  
  public final void fkT()
  {
    this.Fdo += 1;
  }
  
  public final SnsTimelineVideoView hd(Context paramContext)
  {
    AppMethodBeat.i(100428);
    Object localObject = null;
    Iterator localIterator = this.Fdn.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    if (localIterator.hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (localSnsTimelineVideoView.FcX != SnsTimelineVideoView.a.Fdh) {
        break label494;
      }
      localObject = localSnsTimelineVideoView;
    }
    label494:
    for (;;)
    {
      break;
      if (localObject == null) {
        if (this.Fdn.size() < 3)
        {
          paramContext = new SnsTimelineVideoView(paramContext);
          this.Fdn.add(paramContext);
          this.Fdm.add(new WeakReference(paramContext));
        }
      }
      for (;;)
      {
        paramContext.FcX = SnsTimelineVideoView.a.Fdi;
        paramContext.fgg();
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", new Object[] { Integer.valueOf(paramContext.hashCode()) });
        AppMethodBeat.o(100428);
        return paramContext;
        localObject = new ArrayList();
        int i = -1;
        int j = 0;
        while (j < this.Fdn.size())
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)this.Fdn.get(j);
          int k = i;
          if (localSnsTimelineVideoView.FcX != SnsTimelineVideoView.a.Fdj)
          {
            k = i;
            if (localSnsTimelineVideoView.vgi < 9223372036854775807L)
            {
              k = i;
              if (!localSnsTimelineVideoView.Fdb) {
                k = j;
              }
            }
          }
          if (localSnsTimelineVideoView.Fdb) {
            ((List)localObject).add(localSnsTimelineVideoView);
          }
          j += 1;
          i = k;
        }
        if ((i < 0) && (((List)localObject).size() > 0))
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)((List)localObject).get(0);
          this.Fdn.remove(localSnsTimelineVideoView);
          if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
          {
            localSnsTimelineVideoView.Fdc = false;
            ((ViewGroup)localSnsTimelineVideoView.getParent()).removeView(localSnsTimelineVideoView);
          }
          for (;;)
          {
            paramContext = new SnsTimelineVideoView(paramContext);
            this.Fdn.add(paramContext);
            this.Fdm.add(new WeakReference(paramContext));
            Log.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(((SnsTimelineVideoView)((List)localObject).get(0)).hashCode()) });
            break;
            if (localSnsTimelineVideoView != null) {
              localSnsTimelineVideoView.fkP();
            }
          }
        }
        paramContext = this.Fdn;
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
    if (this.Fdr != null)
    {
      boolean bool = H(this.Fdr);
      this.Fdr.fkO();
      if (bool) {
        this.Fdr.fkN();
      }
    }
    AppMethodBeat.o(100423);
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.d
 * JD-Core Version:    0.7.0.1
 */