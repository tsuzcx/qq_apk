package com.tencent.mm.plugin.sns.ui.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static d ABk;
  private List<WeakReference<SnsTimelineVideoView>> ABl;
  private List<SnsTimelineVideoView> ABm;
  private int ABn;
  public c ABo;
  public String ABp;
  public SnsTimelineVideoView ABq;
  
  public d()
  {
    AppMethodBeat.i(100419);
    this.ABl = new LinkedList();
    this.ABm = new ArrayList();
    this.ABn = 0;
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
  
  private void OC()
  {
    AppMethodBeat.i(100421);
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
    final SnsTimelineVideoView localSnsTimelineVideoView;
    if (!this.ABm.isEmpty())
    {
      localIterator = this.ABm.iterator();
      while (localIterator.hasNext())
      {
        localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
        if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
        {
          ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
          localSnsTimelineVideoView.ABb = false;
          localViewGroup.removeView(localSnsTimelineVideoView);
        }
        else if (localSnsTimelineVideoView != null)
        {
          localSnsTimelineVideoView.eeH();
        }
      }
      this.ABm.clear();
    }
    this.ABq = null;
    this.ABo = null;
    this.ABp = "";
    Iterator localIterator = this.ABl.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((WeakReference)localIterator.next()).get();
      j = i;
      if (localSnsTimelineVideoView != null)
      {
        j = i;
        if (!localSnsTimelineVideoView.ABc) {
          j = i + 1;
        }
        localSnsTimelineVideoView.eae();
        h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100417);
            localSnsTimelineVideoView.zUb = true;
            localSnsTimelineVideoView.onDestroy();
            AppMethodBeat.o(100417);
          }
        });
      }
    }
    ad.w("MicroMsg.Sns.SnsVideoViewMgr", "[fallbackRelease] releaseCount=%s allCount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ABl.size()) });
    this.ABl.clear();
    AppMethodBeat.o(100421);
  }
  
  public static d eeK()
  {
    try
    {
      AppMethodBeat.i(100418);
      if (ABk == null) {
        ABk = new d();
      }
      d locald = ABk;
      AppMethodBeat.o(100418);
      return locald;
    }
    finally {}
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, c paramc, String paramString)
  {
    AppMethodBeat.i(100420);
    this.ABq = ((SnsTimelineVideoView)paramOnlineVideoView);
    if (this.ABq != null) {
      this.ABq.setVisibility(0);
    }
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", new Object[] { Integer.valueOf(0), paramc.dIQ.Id, paramString, Integer.valueOf(this.ABm.size()), paramOnlineVideoView.eal() });
    Object localObject1 = new ArrayList();
    Object localObject2 = this.ABm.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject2).next();
      if (localSnsTimelineVideoView != paramOnlineVideoView) {
        if ((!localSnsTimelineVideoView.isPlaying()) && (!localSnsTimelineVideoView.OI()))
        {
          ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()), Boolean.valueOf(localSnsTimelineVideoView.isPlaying()), Boolean.valueOf(localSnsTimelineVideoView.OI()) });
          ((List)localObject1).add(localSnsTimelineVideoView);
        }
        else
        {
          boolean bool = B(localSnsTimelineVideoView);
          localSnsTimelineVideoView.rF(true);
          if (bool) {
            localSnsTimelineVideoView.eeE();
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
      this.ABm.remove(localObject2);
      ((SnsTimelineVideoView)localObject2).eeH();
    }
    if (this.ABq.AAW != null)
    {
      if ((bt.lQ(paramString, this.ABq.AAX)) && (this.ABq.AAW.dIQ.Id.equals(paramc.dIQ.Id)))
      {
        ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", new Object[] { Integer.valueOf(this.ABq.hashCode()) });
        if (!this.ABq.isPlaying())
        {
          this.ABq.setScene(1);
          paramOnlineVideoView = this.ABq;
          paramc = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bt.flT());
          this.ABq.setSessionTimestamp(bt.flT());
          this.ABq.setSnsId(this.ABq.AAW.dzb);
          this.ABq.setFilePath(av.D(this.ABq.AAW.dIQ));
        }
        this.ABq.eaq();
        this.ABq.setMute(true);
        this.ABq.abandonAudioFocus();
        AppMethodBeat.o(100420);
        return;
      }
      ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", new Object[] { Integer.valueOf(this.ABq.hashCode()) });
      this.ABq.eeJ();
    }
    this.ABq.AAW = paramc;
    this.ABq.AAX = paramString;
    this.ABq.AAV = SnsTimelineVideoView.a.ABi;
    this.ABq.AAY = System.currentTimeMillis();
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", new Object[] { Integer.valueOf(this.ABq.hashCode()), paramOnlineVideoView.eal() });
    this.ABo = paramc;
    this.ABp = paramString;
    this.ABq.setMute(true);
    this.ABq.a(paramc.dIQ, paramc.doX, paramc.hZE);
    this.ABq.abandonAudioFocus();
    this.ABq.onResume();
    this.ABq.setScene(1);
    paramOnlineVideoView = this.ABq;
    paramc = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bt.flT());
    this.ABq.setSessionTimestamp(bt.flT());
    this.ABq.setSnsId(this.ABq.AAW.dzb);
    this.ABq.setFilePath(av.D(this.ABq.AAW.dIQ));
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
    AppMethodBeat.o(100420);
  }
  
  public final boolean aBh(String paramString)
  {
    AppMethodBeat.i(198589);
    if ((bt.isNullOrNil(this.ABp)) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(198589);
      return false;
    }
    boolean bool = this.ABp.equals(paramString);
    AppMethodBeat.o(198589);
    return bool;
  }
  
  public final boolean aBi(String paramString)
  {
    AppMethodBeat.i(100425);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100425);
      return false;
    }
    Iterator localIterator = this.ABm.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if ((paramString.equals(localSnsTimelineVideoView.AAX)) && (localSnsTimelineVideoView.AAV != SnsTimelineVideoView.a.ABg))
      {
        AppMethodBeat.o(100425);
        return true;
      }
    }
    AppMethodBeat.o(100425);
    return false;
  }
  
  public final SnsTimelineVideoView aBj(String paramString)
  {
    AppMethodBeat.i(100426);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100426);
      return null;
    }
    Object localObject = this.ABm.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    while (((Iterator)localObject).hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject).next();
      if (paramString.equals(localSnsTimelineVideoView.AAX)) {
        this.ABm.remove(localSnsTimelineVideoView);
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
      if (localSnsTimelineVideoView != this.ABq)
      {
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView == null) {}
      for (localObject = null;; localObject = gn(localSnsTimelineVideoView.getContext()))
      {
        localSnsTimelineVideoView.ABb = true;
        localViewGroup.removeView(localSnsTimelineVideoView);
        if (((SnsTimelineVideoView)localObject).getParent() != null)
        {
          ((SnsTimelineVideoView)localObject).eeI();
          ((SnsTimelineVideoView)localObject).ABb = true;
          ((ViewGroup)((SnsTimelineVideoView)localObject).getParent()).removeView((View)localObject);
        }
        ((SnsTimelineVideoView)localObject).setVisibility(0);
        ((SnsTimelineVideoView)localObject).setVideoScaleType(i.e.ESP);
        localViewGroup.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
        ((SnsTimelineVideoView)localObject).setTag(new a());
        ((SnsTimelineVideoView)localObject).a(localSnsTimelineVideoView.AAW.dIQ, localSnsTimelineVideoView.AAW.doX, localSnsTimelineVideoView.AAW.hZE);
        ((SnsTimelineVideoView)localObject).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        a((OnlineVideoView)localObject, localSnsTimelineVideoView.AAW, localSnsTimelineVideoView.AAX);
        ad.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", new Object[] { paramString });
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      localSnsTimelineVideoView = null;
    }
  }
  
  public final SnsTimelineVideoView aBk(String paramString)
  {
    AppMethodBeat.i(100427);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100427);
      return null;
    }
    Iterator localIterator = this.ABm.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (paramString.equals(localSnsTimelineVideoView.AAX))
      {
        AppMethodBeat.o(100427);
        return localSnsTimelineVideoView;
      }
    }
    AppMethodBeat.o(100427);
    return null;
  }
  
  public final void aI(Activity paramActivity)
  {
    AppMethodBeat.i(100424);
    this.ABn -= 1;
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.ABn) });
    if ((this.ABn <= 0) || ((paramActivity instanceof SnsTimeLineUI)))
    {
      if (this.ABn > 0) {
        com.tencent.mm.plugin.report.service.g.yhR.n(31L, 4L, 1L);
      }
      OC();
    }
    AppMethodBeat.o(100424);
  }
  
  public final void cxw()
  {
    AppMethodBeat.i(100422);
    ad.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
    if (this.ABq != null)
    {
      boolean bool = B(this.ABq);
      this.ABq.rF(true);
      if (bool) {
        this.ABq.eeE();
      }
    }
    AppMethodBeat.o(100422);
  }
  
  public final void eeL()
  {
    this.ABn += 1;
  }
  
  public final SnsTimelineVideoView gn(Context paramContext)
  {
    AppMethodBeat.i(100428);
    Object localObject = null;
    Iterator localIterator = this.ABm.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    if (localIterator.hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (localSnsTimelineVideoView.AAV != SnsTimelineVideoView.a.ABg) {
        break label494;
      }
      localObject = localSnsTimelineVideoView;
    }
    label494:
    for (;;)
    {
      break;
      if (localObject == null) {
        if (this.ABm.size() < 3)
        {
          paramContext = new SnsTimelineVideoView(paramContext);
          this.ABm.add(paramContext);
          this.ABl.add(new WeakReference(paramContext));
        }
      }
      for (;;)
      {
        paramContext.AAV = SnsTimelineVideoView.a.ABh;
        paramContext.eai();
        ad.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", new Object[] { Integer.valueOf(paramContext.hashCode()) });
        AppMethodBeat.o(100428);
        return paramContext;
        localObject = new ArrayList();
        int i = -1;
        int j = 0;
        while (j < this.ABm.size())
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)this.ABm.get(j);
          int k = i;
          if (localSnsTimelineVideoView.AAV != SnsTimelineVideoView.a.ABi)
          {
            k = i;
            if (localSnsTimelineVideoView.AAY < 9223372036854775807L)
            {
              k = i;
              if (!localSnsTimelineVideoView.ABa) {
                k = j;
              }
            }
          }
          if (localSnsTimelineVideoView.ABa) {
            ((List)localObject).add(localSnsTimelineVideoView);
          }
          j += 1;
          i = k;
        }
        if ((i < 0) && (((List)localObject).size() > 0))
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)((List)localObject).get(0);
          this.ABm.remove(localSnsTimelineVideoView);
          if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
          {
            localSnsTimelineVideoView.ABb = false;
            ((ViewGroup)localSnsTimelineVideoView.getParent()).removeView(localSnsTimelineVideoView);
          }
          for (;;)
          {
            paramContext = new SnsTimelineVideoView(paramContext);
            this.ABm.add(paramContext);
            this.ABl.add(new WeakReference(paramContext));
            ad.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(((SnsTimelineVideoView)((List)localObject).get(0)).hashCode()) });
            break;
            if (localSnsTimelineVideoView != null) {
              localSnsTimelineVideoView.eeH();
            }
          }
        }
        paramContext = this.ABm;
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
    if (this.ABq != null)
    {
      boolean bool = B(this.ABq);
      this.ABq.eeF();
      if (bool) {
        this.ABq.eeE();
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