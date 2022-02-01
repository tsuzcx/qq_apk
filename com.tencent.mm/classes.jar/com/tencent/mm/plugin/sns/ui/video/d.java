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
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static d ASF;
  private List<WeakReference<SnsTimelineVideoView>> ASG;
  private List<SnsTimelineVideoView> ASH;
  private int ASI;
  public c ASJ;
  public String ASK;
  public SnsTimelineVideoView ASL;
  
  public d()
  {
    AppMethodBeat.i(100419);
    this.ASG = new LinkedList();
    this.ASH = new ArrayList();
    this.ASI = 0;
    AppMethodBeat.o(100419);
  }
  
  private static boolean E(OnlineVideoView paramOnlineVideoView)
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
  
  private void OA()
  {
    AppMethodBeat.i(100421);
    ae.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
    final SnsTimelineVideoView localSnsTimelineVideoView;
    if (!this.ASH.isEmpty())
    {
      localIterator = this.ASH.iterator();
      while (localIterator.hasNext())
      {
        localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
        if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
        {
          ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
          localSnsTimelineVideoView.ASw = false;
          localViewGroup.removeView(localSnsTimelineVideoView);
        }
        else if (localSnsTimelineVideoView != null)
        {
          localSnsTimelineVideoView.eio();
        }
      }
      this.ASH.clear();
    }
    this.ASL = null;
    this.ASJ = null;
    this.ASK = "";
    Iterator localIterator = this.ASG.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((WeakReference)localIterator.next()).get();
      j = i;
      if (localSnsTimelineVideoView != null)
      {
        j = i;
        if (!localSnsTimelineVideoView.ASx) {
          j = i + 1;
        }
        localSnsTimelineVideoView.edK();
        h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100417);
            localSnsTimelineVideoView.Ali = true;
            localSnsTimelineVideoView.onDestroy();
            AppMethodBeat.o(100417);
          }
        });
      }
    }
    ae.w("MicroMsg.Sns.SnsVideoViewMgr", "[fallbackRelease] releaseCount=%s allCount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ASG.size()) });
    this.ASG.clear();
    AppMethodBeat.o(100421);
  }
  
  public static d eir()
  {
    try
    {
      AppMethodBeat.i(100418);
      if (ASF == null) {
        ASF = new d();
      }
      d locald = ASF;
      AppMethodBeat.o(100418);
      return locald;
    }
    finally {}
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, c paramc, String paramString)
  {
    AppMethodBeat.i(100420);
    this.ASL = ((SnsTimelineVideoView)paramOnlineVideoView);
    if (this.ASL != null) {
      this.ASL.setVisibility(0);
    }
    ae.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", new Object[] { Integer.valueOf(0), paramc.dKe.Id, paramString, Integer.valueOf(this.ASH.size()), paramOnlineVideoView.edR() });
    Object localObject1 = new ArrayList();
    Object localObject2 = this.ASH.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject2).next();
      if (localSnsTimelineVideoView != paramOnlineVideoView) {
        if ((!localSnsTimelineVideoView.isPlaying()) && (!localSnsTimelineVideoView.OG()))
        {
          ae.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()), Boolean.valueOf(localSnsTimelineVideoView.isPlaying()), Boolean.valueOf(localSnsTimelineVideoView.OG()) });
          ((List)localObject1).add(localSnsTimelineVideoView);
        }
        else
        {
          boolean bool = E(localSnsTimelineVideoView);
          localSnsTimelineVideoView.rM(true);
          if (bool) {
            localSnsTimelineVideoView.eim();
          }
          ae.i("MicroMsg.Sns.SnsVideoViewMgr", "%s pause ", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()) });
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
      this.ASH.remove(localObject2);
      ((SnsTimelineVideoView)localObject2).eio();
    }
    if (this.ASL.ASr != null)
    {
      if ((bu.lX(paramString, this.ASL.ASs)) && (this.ASL.ASr.dKe.Id.equals(paramc.dKe.Id)))
      {
        ae.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", new Object[] { Integer.valueOf(this.ASL.hashCode()) });
        if (!this.ASL.isPlaying())
        {
          this.ASL.setScene(1);
          paramOnlineVideoView = this.ASL;
          paramc = new StringBuilder();
          com.tencent.mm.kernel.g.ajP();
          paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bu.fpO());
          this.ASL.setSessionTimestamp(bu.fpO());
          this.ASL.setSnsId(this.ASL.ASr.dAg);
          this.ASL.setFilePath(aw.D(this.ASL.ASr.dKe));
        }
        this.ASL.edW();
        this.ASL.setMute(true);
        this.ASL.abandonAudioFocus();
        AppMethodBeat.o(100420);
        return;
      }
      ae.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", new Object[] { Integer.valueOf(this.ASL.hashCode()) });
      this.ASL.eiq();
    }
    this.ASL.ASr = paramc;
    this.ASL.ASs = paramString;
    this.ASL.ASq = SnsTimelineVideoView.a.ASD;
    this.ASL.ASt = System.currentTimeMillis();
    ae.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", new Object[] { Integer.valueOf(this.ASL.hashCode()), paramOnlineVideoView.edR() });
    this.ASJ = paramc;
    this.ASK = paramString;
    this.ASL.setMute(true);
    this.ASL.a(paramc.dKe, paramc.dqc, paramc.icw);
    this.ASL.abandonAudioFocus();
    this.ASL.onResume();
    this.ASL.setScene(1);
    paramOnlineVideoView = this.ASL;
    paramc = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bu.fpO());
    this.ASL.setSessionTimestamp(bu.fpO());
    this.ASL.setSnsId(this.ASL.ASr.dAg);
    this.ASL.setFilePath(aw.D(this.ASL.ASr.dKe));
    ae.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
    AppMethodBeat.o(100420);
  }
  
  public final SnsTimelineVideoView aCA(String paramString)
  {
    AppMethodBeat.i(100426);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100426);
      return null;
    }
    Object localObject = this.ASH.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    while (((Iterator)localObject).hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject).next();
      if (paramString.equals(localSnsTimelineVideoView.ASs)) {
        this.ASH.remove(localSnsTimelineVideoView);
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
      if (localSnsTimelineVideoView != this.ASL)
      {
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView == null) {}
      for (localObject = null;; localObject = gs(localSnsTimelineVideoView.getContext()))
      {
        localSnsTimelineVideoView.ASw = true;
        localViewGroup.removeView(localSnsTimelineVideoView);
        if (((SnsTimelineVideoView)localObject).getParent() != null)
        {
          ((SnsTimelineVideoView)localObject).eip();
          ((SnsTimelineVideoView)localObject).ASw = true;
          ((ViewGroup)((SnsTimelineVideoView)localObject).getParent()).removeView((View)localObject);
        }
        ((SnsTimelineVideoView)localObject).setVisibility(0);
        ((SnsTimelineVideoView)localObject).setVideoScaleType(i.e.Flk);
        localViewGroup.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
        ((SnsTimelineVideoView)localObject).setTag(new a());
        ((SnsTimelineVideoView)localObject).a(localSnsTimelineVideoView.ASr.dKe, localSnsTimelineVideoView.ASr.dqc, localSnsTimelineVideoView.ASr.icw);
        ((SnsTimelineVideoView)localObject).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        a((OnlineVideoView)localObject, localSnsTimelineVideoView.ASr, localSnsTimelineVideoView.ASs);
        ae.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", new Object[] { paramString });
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      localSnsTimelineVideoView = null;
    }
  }
  
  public final SnsTimelineVideoView aCB(String paramString)
  {
    AppMethodBeat.i(100427);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100427);
      return null;
    }
    Iterator localIterator = this.ASH.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (paramString.equals(localSnsTimelineVideoView.ASs))
      {
        AppMethodBeat.o(100427);
        return localSnsTimelineVideoView;
      }
    }
    AppMethodBeat.o(100427);
    return null;
  }
  
  public final boolean aCy(String paramString)
  {
    AppMethodBeat.i(220134);
    if ((bu.isNullOrNil(this.ASK)) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(220134);
      return false;
    }
    boolean bool = this.ASK.equals(paramString);
    AppMethodBeat.o(220134);
    return bool;
  }
  
  public final boolean aCz(String paramString)
  {
    AppMethodBeat.i(100425);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100425);
      return false;
    }
    Iterator localIterator = this.ASH.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if ((paramString.equals(localSnsTimelineVideoView.ASs)) && (localSnsTimelineVideoView.ASq != SnsTimelineVideoView.a.ASB))
      {
        AppMethodBeat.o(100425);
        return true;
      }
    }
    AppMethodBeat.o(100425);
    return false;
  }
  
  public final void aJ(Activity paramActivity)
  {
    AppMethodBeat.i(100424);
    this.ASI -= 1;
    ae.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.ASI) });
    if ((this.ASI <= 0) || ((paramActivity instanceof SnsTimeLineUI)))
    {
      if (this.ASI > 0) {
        com.tencent.mm.plugin.report.service.g.yxI.n(31L, 4L, 1L);
      }
      OA();
    }
    AppMethodBeat.o(100424);
  }
  
  public final void cyX()
  {
    AppMethodBeat.i(100422);
    ae.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
    if (this.ASL != null)
    {
      boolean bool = E(this.ASL);
      this.ASL.rM(true);
      if (bool) {
        this.ASL.eim();
      }
    }
    AppMethodBeat.o(100422);
  }
  
  public final void eis()
  {
    this.ASI += 1;
  }
  
  public final SnsTimelineVideoView gs(Context paramContext)
  {
    AppMethodBeat.i(100428);
    Object localObject = null;
    Iterator localIterator = this.ASH.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    if (localIterator.hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (localSnsTimelineVideoView.ASq != SnsTimelineVideoView.a.ASB) {
        break label494;
      }
      localObject = localSnsTimelineVideoView;
    }
    label494:
    for (;;)
    {
      break;
      if (localObject == null) {
        if (this.ASH.size() < 3)
        {
          paramContext = new SnsTimelineVideoView(paramContext);
          this.ASH.add(paramContext);
          this.ASG.add(new WeakReference(paramContext));
        }
      }
      for (;;)
      {
        paramContext.ASq = SnsTimelineVideoView.a.ASC;
        paramContext.edO();
        ae.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", new Object[] { Integer.valueOf(paramContext.hashCode()) });
        AppMethodBeat.o(100428);
        return paramContext;
        localObject = new ArrayList();
        int i = -1;
        int j = 0;
        while (j < this.ASH.size())
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)this.ASH.get(j);
          int k = i;
          if (localSnsTimelineVideoView.ASq != SnsTimelineVideoView.a.ASD)
          {
            k = i;
            if (localSnsTimelineVideoView.ASt < 9223372036854775807L)
            {
              k = i;
              if (!localSnsTimelineVideoView.ASv) {
                k = j;
              }
            }
          }
          if (localSnsTimelineVideoView.ASv) {
            ((List)localObject).add(localSnsTimelineVideoView);
          }
          j += 1;
          i = k;
        }
        if ((i < 0) && (((List)localObject).size() > 0))
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)((List)localObject).get(0);
          this.ASH.remove(localSnsTimelineVideoView);
          if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
          {
            localSnsTimelineVideoView.ASw = false;
            ((ViewGroup)localSnsTimelineVideoView.getParent()).removeView(localSnsTimelineVideoView);
          }
          for (;;)
          {
            paramContext = new SnsTimelineVideoView(paramContext);
            this.ASH.add(paramContext);
            this.ASG.add(new WeakReference(paramContext));
            ae.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(((SnsTimelineVideoView)((List)localObject).get(0)).hashCode()) });
            break;
            if (localSnsTimelineVideoView != null) {
              localSnsTimelineVideoView.eio();
            }
          }
        }
        paramContext = this.ASH;
        if (i < 0) {}
        for (j = 0;; j = i)
        {
          paramContext = (SnsTimelineVideoView)paramContext.get(j);
          ae.i("MicroMsg.Sns.SnsVideoViewMgr", "use minIndex: %s", new Object[] { Integer.valueOf(i) });
          break;
        }
        paramContext = (Context)localObject;
      }
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(100423);
    ae.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay onUIPause");
    if (this.ASL != null)
    {
      boolean bool = E(this.ASL);
      this.ASL.ein();
      if (bool) {
        this.ASL.eim();
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