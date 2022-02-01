package com.tencent.mm.plugin.sns.ui.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private static e RUP;
  private List<WeakReference<SnsTimelineVideoView>> RUQ;
  private List<SnsTimelineVideoView> RUR;
  private int RUS;
  public d RUT;
  public String RUU;
  public SnsTimelineVideoView RUV;
  private WeakReference<SnsTimelineVideoView> RUW;
  
  public e()
  {
    AppMethodBeat.i(100419);
    this.RUQ = new LinkedList();
    this.RUR = new ArrayList();
    this.RUS = 0;
    this.RUW = null;
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
  
  public static e hsu()
  {
    try
    {
      AppMethodBeat.i(100418);
      if (RUP == null) {
        RUP = new e();
      }
      e locale = RUP;
      AppMethodBeat.o(100418);
      return locale;
    }
    finally {}
  }
  
  public static boolean hsw()
  {
    AppMethodBeat.i(308590);
    boolean bool = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yWi, true);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "enableNewSmallViewType %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(308590);
    return bool;
  }
  
  private void stopAll()
  {
    AppMethodBeat.i(100421);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
    final SnsTimelineVideoView localSnsTimelineVideoView;
    if (!this.RUR.isEmpty())
    {
      localIterator = this.RUR.iterator();
      while (localIterator.hasNext())
      {
        localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
        if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
        {
          ViewGroup localViewGroup = (ViewGroup)localSnsTimelineVideoView.getParent();
          localSnsTimelineVideoView.RUC = false;
          localViewGroup.removeView(localSnsTimelineVideoView);
        }
        else if (localSnsTimelineVideoView != null)
        {
          localSnsTimelineVideoView.hsl();
        }
      }
      this.RUR.clear();
    }
    this.RUV = null;
    this.RUT = null;
    this.RUU = "";
    Iterator localIterator = this.RUQ.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((WeakReference)localIterator.next()).get();
      j = i;
      if (localSnsTimelineVideoView != null)
      {
        j = i;
        if (!localSnsTimelineVideoView.RUD) {
          j = i + 1;
        }
        localSnsTimelineVideoView.hmt();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100417);
            localSnsTimelineVideoView.Rha = true;
            localSnsTimelineVideoView.onDestroy();
            AppMethodBeat.o(100417);
          }
        });
      }
    }
    Log.w("MicroMsg.Sns.SnsVideoViewMgr", "[fallbackRelease] releaseCount=%s allCount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.RUQ.size()) });
    this.RUQ.clear();
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
    this.RUV = ((SnsTimelineVideoView)paramOnlineVideoView);
    if (this.RUV != null) {
      this.RUV.setVisibility(0);
    }
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", new Object[] { Integer.valueOf(0), paramd.ibT.Id, paramString, Integer.valueOf(this.RUR.size()), paramOnlineVideoView.hmB() });
    Object localObject1 = new ArrayList();
    Object localObject2 = this.RUR.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject2).next();
      if (localSnsTimelineVideoView != paramOnlineVideoView) {
        if ((!localSnsTimelineVideoView.isPlaying()) && (!localSnsTimelineVideoView.aFF()))
        {
          Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", new Object[] { Integer.valueOf(localSnsTimelineVideoView.hashCode()), Boolean.valueOf(localSnsTimelineVideoView.isPlaying()), Boolean.valueOf(localSnsTimelineVideoView.aFF()) });
          ((List)localObject1).add(localSnsTimelineVideoView);
        }
        else
        {
          boolean bool = Q(localSnsTimelineVideoView);
          localSnsTimelineVideoView.Dt(true);
          if (bool) {
            localSnsTimelineVideoView.hsj();
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
      this.RUR.remove(localObject2);
      ((SnsTimelineVideoView)localObject2).hsl();
    }
    if (this.RUV.RUz != null)
    {
      if ((Util.isEqual(paramString, this.RUV.Rcp)) && (this.RUV.RUz.ibT.Id.equals(paramd.ibT.Id)))
      {
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", new Object[] { Integer.valueOf(this.RUV.hashCode()) });
        if (!this.RUV.isPlaying())
        {
          this.RUV.setScene(1);
          paramOnlineVideoView = this.RUV;
          paramd = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramOnlineVideoView.setSessionId(new p(b.getUin()).toString() + "_" + Util.nowMilliSecond());
          this.RUV.setSessionTimestamp(Util.nowMilliSecond());
          this.RUV.setSnsId(this.RUV.RUz.hQX);
          this.RUV.setFilePath(az.E(this.RUV.RUz.ibT));
        }
        this.RUV.bcl();
        this.RUV.setMute(true);
        this.RUV.abandonAudioFocus();
        AppMethodBeat.o(100420);
        return;
      }
      Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", new Object[] { Integer.valueOf(this.RUV.hashCode()) });
      this.RUV.hsn();
    }
    this.RUV.RUz = paramd;
    this.RUV.Rcp = paramString;
    this.RUV.RUy = SnsTimelineVideoView.a.RUJ;
    this.RUV.FsW = System.currentTimeMillis();
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", new Object[] { Integer.valueOf(this.RUV.hashCode()), paramOnlineVideoView.hmB() });
    this.RUT = paramd;
    this.RUU = paramString;
    this.RUV.setMute(true);
    this.RUV.a(paramd.ibT, paramd.hES, paramd.createTime);
    this.RUV.abandonAudioFocus();
    this.RUV.onResume();
    this.RUV.setScene(1);
    paramOnlineVideoView = this.RUV;
    paramd = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    paramOnlineVideoView.setSessionId(new p(b.getUin()).toString() + "_" + Util.nowMilliSecond());
    this.RUV.setSessionTimestamp(Util.nowMilliSecond());
    this.RUV.setSnsId(this.RUV.RUz.hQX);
    this.RUV.setFilePath(az.E(this.RUV.RUz.ibT));
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
    AppMethodBeat.o(100420);
  }
  
  public final boolean bbn(String paramString)
  {
    AppMethodBeat.i(308615);
    if ((Util.isNullOrNil(this.RUU)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(308615);
      return false;
    }
    boolean bool = this.RUU.equals(paramString);
    AppMethodBeat.o(308615);
    return bool;
  }
  
  public final boolean bbo(String paramString)
  {
    AppMethodBeat.i(100425);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100425);
      return false;
    }
    Iterator localIterator = this.RUR.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if ((paramString.equals(localSnsTimelineVideoView.Rcp)) && (localSnsTimelineVideoView.RUy != SnsTimelineVideoView.a.RUH))
      {
        AppMethodBeat.o(100425);
        return true;
      }
    }
    AppMethodBeat.o(100425);
    return false;
  }
  
  public final SnsTimelineVideoView bbp(String paramString)
  {
    AppMethodBeat.i(100426);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100426);
      return null;
    }
    Object localObject = this.RUR.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    while (((Iterator)localObject).hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)((Iterator)localObject).next();
      if (paramString.equals(localSnsTimelineVideoView.Rcp)) {
        this.RUR.remove(localSnsTimelineVideoView);
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
      if (localSnsTimelineVideoView != this.RUV)
      {
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
      }
      if (localSnsTimelineVideoView == null)
      {
        localObject = null;
        localSnsTimelineVideoView.RUC = true;
        localViewGroup.removeView(localSnsTimelineVideoView);
        if (((SnsTimelineVideoView)localObject).getParent() != null)
        {
          ((SnsTimelineVideoView)localObject).hsm();
          ((SnsTimelineVideoView)localObject).RUC = true;
          ((ViewGroup)((SnsTimelineVideoView)localObject).getParent()).removeView((View)localObject);
        }
        ((SnsTimelineVideoView)localObject).setVisibility(0);
        ((SnsTimelineVideoView)localObject).setVideoScaleType(i.e.XYN);
        localViewGroup.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
        ((SnsTimelineVideoView)localObject).setTag(new a());
        ((SnsTimelineVideoView)localObject).a(localSnsTimelineVideoView.RUz.ibT, localSnsTimelineVideoView.RUz.hES, localSnsTimelineVideoView.RUz.createTime);
        ((SnsTimelineVideoView)localObject).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        if (!hsw()) {
          break label306;
        }
        this.RUT = localSnsTimelineVideoView.RUz;
        this.RUU = localSnsTimelineVideoView.Rcp;
        this.RUW = new WeakReference(localObject);
      }
      for (;;)
      {
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", new Object[] { paramString });
        AppMethodBeat.o(100426);
        return localSnsTimelineVideoView;
        localObject = jU(localSnsTimelineVideoView.getContext());
        break;
        label306:
        a((OnlineVideoView)localObject, localSnsTimelineVideoView.RUz, localSnsTimelineVideoView.Rcp);
      }
      localSnsTimelineVideoView = null;
    }
  }
  
  public final SnsTimelineVideoView bbq(String paramString)
  {
    AppMethodBeat.i(100427);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(100427);
      return null;
    }
    Iterator localIterator = this.RUR.iterator();
    while (localIterator.hasNext())
    {
      SnsTimelineVideoView localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (paramString.equals(localSnsTimelineVideoView.Rcp))
      {
        AppMethodBeat.o(100427);
        return localSnsTimelineVideoView;
      }
    }
    AppMethodBeat.o(100427);
    return null;
  }
  
  public final void bck()
  {
    AppMethodBeat.i(100422);
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
    if (this.RUV != null)
    {
      boolean bool = Q(this.RUV);
      this.RUV.Dt(true);
      if (bool) {
        this.RUV.hsj();
      }
    }
    AppMethodBeat.o(100422);
  }
  
  public final void bx(Activity paramActivity)
  {
    AppMethodBeat.i(100424);
    this.RUS -= 1;
    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.RUS) });
    if ((this.RUS <= 0) || ((paramActivity instanceof SnsTimeLineUI)))
    {
      if (this.RUS > 0) {
        com.tencent.mm.plugin.report.service.h.OAn.p(31L, 4L, 1L);
      }
      stopAll();
    }
    AppMethodBeat.o(100424);
  }
  
  public final void hsv()
  {
    this.RUS += 1;
  }
  
  public final SnsTimelineVideoView jU(Context paramContext)
  {
    AppMethodBeat.i(100428);
    Object localObject = null;
    Iterator localIterator = this.RUR.iterator();
    SnsTimelineVideoView localSnsTimelineVideoView;
    if (localIterator.hasNext())
    {
      localSnsTimelineVideoView = (SnsTimelineVideoView)localIterator.next();
      if (localSnsTimelineVideoView.RUy != SnsTimelineVideoView.a.RUH) {
        break label494;
      }
      localObject = localSnsTimelineVideoView;
    }
    label494:
    for (;;)
    {
      break;
      if (localObject == null) {
        if (this.RUR.size() < 3)
        {
          paramContext = new SnsTimelineVideoView(paramContext);
          this.RUR.add(paramContext);
          this.RUQ.add(new WeakReference(paramContext));
        }
      }
      for (;;)
      {
        paramContext.RUy = SnsTimelineVideoView.a.RUI;
        paramContext.hmy();
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", new Object[] { Integer.valueOf(paramContext.hashCode()) });
        AppMethodBeat.o(100428);
        return paramContext;
        localObject = new ArrayList();
        int i = -1;
        int j = 0;
        while (j < this.RUR.size())
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)this.RUR.get(j);
          int k = i;
          if (localSnsTimelineVideoView.RUy != SnsTimelineVideoView.a.RUJ)
          {
            k = i;
            if (localSnsTimelineVideoView.FsW < 9223372036854775807L)
            {
              k = i;
              if (!localSnsTimelineVideoView.RUB) {
                k = j;
              }
            }
          }
          if (localSnsTimelineVideoView.RUB) {
            ((List)localObject).add(localSnsTimelineVideoView);
          }
          j += 1;
          i = k;
        }
        if ((i < 0) && (((List)localObject).size() > 0))
        {
          localSnsTimelineVideoView = (SnsTimelineVideoView)((List)localObject).get(0);
          this.RUR.remove(localSnsTimelineVideoView);
          if ((localSnsTimelineVideoView != null) && (localSnsTimelineVideoView.getParent() != null))
          {
            localSnsTimelineVideoView.RUC = false;
            ((ViewGroup)localSnsTimelineVideoView.getParent()).removeView(localSnsTimelineVideoView);
          }
          for (;;)
          {
            paramContext = new SnsTimelineVideoView(paramContext);
            this.RUR.add(paramContext);
            this.RUQ.add(new WeakReference(paramContext));
            Log.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(((SnsTimelineVideoView)((List)localObject).get(0)).hashCode()) });
            break;
            if (localSnsTimelineVideoView != null) {
              localSnsTimelineVideoView.hsl();
            }
          }
        }
        paramContext = this.RUR;
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
    if (this.RUV != null)
    {
      boolean bool = Q(this.RUV);
      this.RUV.hsk();
      if (bool) {
        this.RUV.hsj();
      }
    }
    AppMethodBeat.o(100423);
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.e
 * JD-Core Version:    0.7.0.1
 */