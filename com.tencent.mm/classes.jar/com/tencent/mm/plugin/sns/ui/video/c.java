package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static c smf;
  private List<SnsTimelineVideoView> smg;
  private int smh;
  public b smi;
  public String smj;
  public SnsTimelineVideoView smk;
  
  public c()
  {
    AppMethodBeat.i(145772);
    this.smg = new ArrayList();
    this.smh = 0;
    AppMethodBeat.o(145772);
  }
  
  public static boolean A(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(145781);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramOnlineVideoView != null)
    {
      bool1 = bool2;
      if (paramOnlineVideoView.isPlaying()) {
        bool1 = true;
      }
    }
    AppMethodBeat.o(145781);
    return bool1;
  }
  
  private void Dm()
  {
    AppMethodBeat.i(145774);
    ab.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
    if (!this.smg.isEmpty())
    {
      Iterator localIterator = this.smg.iterator();
      while (localIterator.hasNext())
      {
        SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
        if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null)) {
          ((ViewGroup)localSnsTimelineVideoView.getParent()).removeView(localSnsTimelineVideoView);
        }
      }
      this.smg.clear();
    }
    this.smk = null;
    this.smi = null;
    this.smj = "";
    AppMethodBeat.o(145774);
  }
  
  public static c cxv()
  {
    try
    {
      AppMethodBeat.i(145771);
      if (smf == null) {
        smf = new c();
      }
      c localc = smf;
      AppMethodBeat.o(145771);
      return localc;
    }
    finally {}
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, b paramb, String paramString)
  {
    AppMethodBeat.i(145773);
    this.smk = ((SnsTimelineVideoView)paramOnlineVideoView);
    if (this.smk != null) {
      this.smk.setVisibility(0);
    }
    ab.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", new Object[] { Integer.valueOf(0), paramb.cIc.Id, paramString, Integer.valueOf(this.smg.size()), paramOnlineVideoView.ctT() });
    Object localObject1 = new ArrayList();
    Object localObject2 = this.smg.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject2).next();
      if (localSnsTimelineVideoView != paramOnlineVideoView) {
        if ((!localSnsTimelineVideoView.isPlaying()) && (!localSnsTimelineVideoView.Ds()))
        {
          ab.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()), Boolean.valueOf(localSnsTimelineVideoView.isPlaying()), Boolean.valueOf(localSnsTimelineVideoView.Ds()) });
          ((List)localObject1).add(localSnsTimelineVideoView);
        }
        else
        {
          boolean bool = A(localSnsTimelineVideoView);
          localSnsTimelineVideoView.lI(true);
          if (bool) {
            localSnsTimelineVideoView.cxq();
          }
          ab.i("MicroMsg.Sns.SnsVideoViewMgr", "%s pause ", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()) });
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
      this.smg.remove(localObject2);
      ((SnsTimelineVideoView)localObject2).cxt();
    }
    if (this.smk.slT != null)
    {
      if ((bo.isEqual(paramString, this.smk.slU)) && (this.smk.slT.cIc.Id.equals(paramb.cIc.Id)))
      {
        ab.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", new Object[] { Integer.valueOf(this.smk.hashCode()) });
        if (!this.smk.isPlaying())
        {
          this.smk.setScene(1);
          paramOnlineVideoView = this.smk;
          paramb = new StringBuilder();
          g.RJ();
          paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bo.aoy());
          this.smk.setSessionTimestamp(bo.aoy());
          this.smk.setSnsId(this.smk.slT.czw);
          this.smk.setFilePath(ar.D(this.smk.slT.cIc));
        }
        this.smk.ctY();
        this.smk.setMute(true);
        this.smk.ctQ();
        AppMethodBeat.o(145773);
        return;
      }
      ab.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", new Object[] { Integer.valueOf(this.smk.hashCode()) });
      this.smk.onDestroy();
    }
    this.smk.slT = paramb;
    this.smk.slU = paramString;
    this.smk.slS = SnsTimelineVideoView.a.smd;
    this.smk.slV = System.currentTimeMillis();
    ab.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", new Object[] { Integer.valueOf(this.smk.hashCode()), paramOnlineVideoView.ctT() });
    this.smi = paramb;
    this.smj = paramString;
    this.smk.setMute(true);
    this.smk.setKeepScreenOn(true);
    this.smk.a(paramb.cIc, paramb.crk, paramb.fDT);
    this.smk.ctQ();
    this.smk.onResume();
    this.smk.setScene(1);
    paramOnlineVideoView = this.smk;
    paramb = new StringBuilder();
    g.RJ();
    paramOnlineVideoView.setSessionId(new p(a.getUin()).toString() + "_" + bo.aoy());
    this.smk.setSessionTimestamp(bo.aoy());
    this.smk.setSnsId(this.smk.slT.czw);
    this.smk.setFilePath(ar.D(this.smk.slT.cIc));
    ab.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
    AppMethodBeat.o(145773);
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(145776);
    this.smh -= 1;
    ab.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.smh) });
    if (this.smh <= 0) {
      Dm();
    }
    AppMethodBeat.o(145776);
  }
  
  public final boolean acs(String paramString)
  {
    AppMethodBeat.i(145777);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(145777);
      return false;
    }
    Iterator localIterator = this.smg.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if ((paramString.equals(localSnsTimelineVideoView.slU)) && (localSnsTimelineVideoView.slS != SnsTimelineVideoView.a.smb))
      {
        AppMethodBeat.o(145777);
        return true;
      }
    }
    AppMethodBeat.o(145777);
    return false;
  }
  
  public final SnsTimelineVideoView act(String paramString)
  {
    AppMethodBeat.i(145778);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(145778);
      return null;
    }
    Object localObject = this.smg.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    while (((Iterator)localObject).hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject).next();
      if (paramString.equals(localSnsTimelineVideoView.slU)) {
        this.smg.remove(localSnsTimelineVideoView);
      }
    }
    for (;;)
    {
      if (localSnsTimelineVideoView == null)
      {
        AppMethodBeat.o(145778);
        return null;
      }
      ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
      if (localViewGroup == null)
      {
        AppMethodBeat.o(145778);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView != this.smk)
      {
        AppMethodBeat.o(145778);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView == null) {}
      for (localObject = null;; localObject = eX(localSnsTimelineVideoView.getContext()))
      {
        localSnsTimelineVideoView.slY = true;
        localViewGroup.removeView(localSnsTimelineVideoView);
        if (((SnsTimelineVideoView)localObject).getParent() != null) {
          ((ViewGroup)((SnsTimelineVideoView)localObject).getParent()).removeView((View)localObject);
        }
        ((SnsTimelineVideoView)localObject).setVisibility(0);
        ((SnsTimelineVideoView)localObject).setVideoScaleType(h.d.vQL);
        localViewGroup.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
        ((SnsTimelineVideoView)localObject).setTag(new c.a());
        ((SnsTimelineVideoView)localObject).a(localSnsTimelineVideoView.slT.cIc, localSnsTimelineVideoView.slT.crk, localSnsTimelineVideoView.slT.fDT);
        ((SnsTimelineVideoView)localObject).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        a((OnlineVideoView)localObject, localSnsTimelineVideoView.slT, localSnsTimelineVideoView.slU);
        ab.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", new Object[] { paramString });
        AppMethodBeat.o(145778);
        return localSnsTimelineVideoView;
      }
      localSnsTimelineVideoView = null;
    }
  }
  
  public final SnsTimelineVideoView acu(String paramString)
  {
    AppMethodBeat.i(145779);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(145779);
      return null;
    }
    Iterator localIterator = this.smg.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (paramString.equals(localSnsTimelineVideoView.slU))
      {
        AppMethodBeat.o(145779);
        return localSnsTimelineVideoView;
      }
    }
    AppMethodBeat.o(145779);
    return null;
  }
  
  public final void crn()
  {
    AppMethodBeat.i(145775);
    ab.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
    if (this.smk != null)
    {
      boolean bool = A(this.smk);
      this.smk.lI(true);
      if (bool) {
        this.smk.cxq();
      }
    }
    AppMethodBeat.o(145775);
  }
  
  public final void cxw()
  {
    this.smh += 1;
  }
  
  public final SnsTimelineVideoView eX(Context paramContext)
  {
    AppMethodBeat.i(145780);
    Object localObject = null;
    Iterator localIterator = this.smg.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    if (localIterator.hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (localSnsTimelineVideoView.slS != SnsTimelineVideoView.a.smb) {
        break label406;
      }
      localObject = localSnsTimelineVideoView;
    }
    label406:
    for (;;)
    {
      break;
      if (localObject == null) {
        if (this.smg.size() < 3)
        {
          paramContext = new SnsTimelineVideoView(paramContext);
          this.smg.add(paramContext);
        }
      }
      for (;;)
      {
        paramContext.slS = SnsTimelineVideoView.a.smc;
        paramContext.ctP();
        ab.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", new Object[] { Integer.valueOf(paramContext.hashCode()) });
        AppMethodBeat.o(145780);
        return paramContext;
        localObject = new ArrayList();
        int i = -1;
        int j = 0;
        while (j < this.smg.size())
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)this.smg.get(j);
          int k = i;
          if (localSnsTimelineVideoView.slS != SnsTimelineVideoView.a.smd)
          {
            k = i;
            if (localSnsTimelineVideoView.slV < 9223372036854775807L)
            {
              k = i;
              if (!localSnsTimelineVideoView.slX) {
                k = j;
              }
            }
          }
          if (localSnsTimelineVideoView.slX) {
            ((List)localObject).add(localSnsTimelineVideoView);
          }
          j += 1;
          i = k;
        }
        if ((i < 0) && (((List)localObject).size() > 0))
        {
          this.smg.remove(((List)localObject).get(0));
          paramContext = new SnsTimelineVideoView(paramContext);
          this.smg.add(paramContext);
          ab.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(((SnsTimelineVideoView)((List)localObject).get(0)).hashCode()) });
        }
        else
        {
          paramContext = this.smg;
          if (i < 0) {}
          for (j = 0;; j = i)
          {
            paramContext = (SnsTimelineVideoView)paramContext.get(j);
            ab.i("MicroMsg.Sns.SnsVideoViewMgr", "use minIndex: %s", new Object[] { Integer.valueOf(i) });
            break;
          }
          paramContext = (Context)localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.c
 * JD-Core Version:    0.7.0.1
 */