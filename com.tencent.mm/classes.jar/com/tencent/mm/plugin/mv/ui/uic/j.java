package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.ui.adapter.a.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.h;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "blurEffect", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "childListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1;", "currentIndex", "", "currentTime", "enterFullLyricPageTime", "", "getEnterFullLyricPageTime", "()J", "setEnterFullLyricPageTime", "(J)V", "fullLyricView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "kotlin.jvm.PlatformType", "getFullLyricView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "fullLyricView$delegate", "Lkotlin/Lazy;", "imageBlurEffect", "isShowFulScreenLyric", "", "()Z", "setShowFulScreenLyric", "(Z)V", "itemClick", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1;", "itemView", "Landroid/view/View;", "lyricEventListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1;", "lyricLines", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lyricList", "Landroidx/recyclerview/widget/RecyclerView;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRV", "mainRV", "getMainRV", "()Landroidx/recyclerview/widget/RecyclerView;", "mainRV$delegate", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "hideFullLyric", "", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "selectView", "parent", "setCurrentTime", "currentPos", "setSongInfo", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "obj", "plugin-mv_release"})
public final class j
  extends UIComponent
{
  e FTB;
  private final ArrayList<String> GgR;
  private final z GiQ;
  public boolean GjA;
  long GjB;
  private final c GjC;
  final d GjD;
  private final a GjE;
  private final kotlin.f Gjv;
  private final kotlin.f Gjw;
  RecyclerView Gjx;
  ArrayList<RecyclerView> Gjy;
  private b Gjz;
  private final String TAG;
  View amk;
  int currentIndex;
  int currentTime;
  
  public j(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(228183);
    this.TAG = "MicroMsg.MusicMvLyricUIC";
    this.Gjv = kotlin.g.ar((kotlin.g.a.a)new j.b(paramAppCompatActivity));
    this.Gjw = kotlin.g.ar((kotlin.g.a.a)new j.e(paramAppCompatActivity));
    this.Gjy = new ArrayList();
    this.GgR = new ArrayList();
    this.currentIndex = -1;
    this.GiQ = new z();
    this.GjC = new c(this, paramAppCompatActivity);
    this.GjD = new d(this, paramAppCompatActivity);
    this.GjE = new a(this);
    AppMethodBeat.o(228183);
  }
  
  private final void fgZ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(228180);
    Object localObject1 = this.Gjx;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setVisibility(0);
    }
    this.GiQ.restore();
    localObject1 = fgY();
    if (localObject1 != null) {
      ((MusicMvLyricView)localObject1).setVisibility(8);
    }
    localObject1 = this.Gjx;
    if (localObject1 != null)
    {
      localObject3 = c.a(this.currentIndex, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "hideFullLyric", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "hideFullLyric", "()V", "Undefined", "scrollToPosition", "(I)V");
    }
    Object localObject3 = getActivity();
    localObject1 = localObject3;
    if (!(localObject3 instanceof MMFragmentActivity)) {
      localObject1 = null;
    }
    localObject1 = (MMFragmentActivity)localObject1;
    if (localObject1 != null)
    {
      localObject1 = ((MMFragmentActivity)localObject1).getSwipeBackLayout();
      if (localObject1 != null) {
        ((SwipeBackLayout)localObject1).setEnableGesture(true);
      }
    }
    localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = com.tencent.mm.ui.component.g.b(getActivity()).i(k.class);
    p.j(localObject1, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
    localObject1 = (k)localObject1;
    localObject3 = ((k)localObject1).getEffectManager();
    b localb;
    if (localObject3 != null)
    {
      localb = this.Gjz;
      if (localb == null) {
        break label405;
      }
    }
    label405:
    for (long l1 = localb.id;; l1 = -1L)
    {
      ((EffectManager)localObject3).WI(l1);
      this.Gjz = null;
      ((k)localObject1).fhc();
      this.GjA = false;
      localObject3 = ((k)localObject1).getAdapter();
      int i = ((k)localObject1).GjI.jNa;
      localObject1 = k.GjX;
      ((WxRecyclerAdapter)localObject3).e(i, 1, k.fhd());
      l1 = Util.currentTicks();
      long l2 = this.GjB;
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject3 = (dbs)a.a.a((Context)getActivity(), 7, dbs.class);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Long.valueOf(((dbs)localObject3).TJl + (l1 - l2));
      }
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (dbs)a.a.a((Context)getActivity(), 7, dbs.class);
      if (localObject2 == null) {
        break;
      }
      ((dbs)localObject2).TJl = ((Long)localObject1).longValue();
      AppMethodBeat.o(228180);
      return;
    }
    AppMethodBeat.o(228180);
  }
  
  public final void a(bds parambds, e parame)
  {
    AppMethodBeat.i(228173);
    this.GgR.clear();
    this.FTB = parame;
    e locale = this.FTB;
    String str;
    Object localObject;
    if (locale != null)
    {
      int j = locale.feO();
      int i = 0;
      while (i < j)
      {
        ArrayList localArrayList = this.GgR;
        str = locale.Zm(i).content;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localArrayList.add(localObject);
        i += 1;
      }
    }
    fgY().setLyricObj(parame);
    if (parambds != null)
    {
      parame = parambds.HLH;
      if (parame != null)
      {
        localObject = fgY();
        p.j(parame, "name");
        str = parambds.ozs;
        p.k(parame, "songName");
        parambds = parame;
        if (str != null) {
          parambds = parame + '·' + str;
        }
        ((MusicMvLyricView)localObject).titleView.setText((CharSequence)parambds);
      }
    }
    parambds = ((Iterable)this.Gjy).iterator();
    while (parambds.hasNext())
    {
      parame = (com.tencent.mm.plugin.mv.ui.adapter.a)((RecyclerView)parambds.next()).getAdapter();
      if (parame != null) {
        parame.gg((List)this.GgR);
      }
    }
    AppMethodBeat.o(228173);
  }
  
  final MusicMvLyricView fgY()
  {
    AppMethodBeat.i(228164);
    MusicMvLyricView localMusicMvLyricView = (MusicMvLyricView)this.Gjv.getValue();
    AppMethodBeat.o(228164);
    return localMusicMvLyricView;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(228175);
    MusicMvLyricView localMusicMvLyricView = fgY();
    if ((localMusicMvLyricView != null) && (localMusicMvLyricView.getVisibility() == 0))
    {
      fgZ();
      AppMethodBeat.o(228175);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(228175);
    return bool;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(228168);
    super.onCreateAfter(paramBundle);
    paramBundle = (RecyclerView)this.Gjw.getValue();
    if (paramBundle != null)
    {
      paramBundle.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)this.GjE);
      AppMethodBeat.o(228168);
      return;
    }
    AppMethodBeat.o(228168);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "onChildViewAdded", "", "parent", "Landroid/view/View;", "child", "onChildViewRemoved", "plugin-mv_release"})
  public static final class a
    implements ViewGroup.OnHierarchyChangeListener
  {
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(237030);
      if (paramView2 != null)
      {
        paramView1 = (RecyclerView)paramView2.findViewById(b.e.FXx);
        if (paramView1 != null) {}
      }
      else
      {
        AppMethodBeat.o(237030);
        return;
      }
      if (j.h(this.GjF).contains(paramView1))
      {
        AppMethodBeat.o(237030);
        return;
      }
      j.h(this.GjF).add(paramView1);
      if ((com.tencent.mm.plugin.mv.ui.adapter.a)paramView1.getAdapter() == null)
      {
        paramView2 = new com.tencent.mm.plugin.mv.ui.adapter.a((a.b)j.i(this.GjF));
        paramView2.gg((List)j.j(this.GjF));
        paramView1.setAdapter((RecyclerView.a)paramView2);
      }
      if ((LinearLayoutManager)paramView1.getLayoutManager() != null)
      {
        paramView2 = c.a(j.k(this.GjF), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramView1, paramView2.aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        paramView1.scrollToPosition(((Integer)paramView2.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramView1, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
      }
      AppMethodBeat.o(237030);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(237031);
      if (paramView2 != null)
      {
        paramView1 = (RecyclerView)paramView2.findViewById(b.e.FXx);
        if (paramView1 != null) {}
      }
      else
      {
        AppMethodBeat.o(237031);
        return;
      }
      j.h(this.GjF).remove(paramView1);
      AppMethodBeat.o(237031);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "onClick", "", "position", "", "plugin-mv_release"})
  public static final class c
    implements a.b
  {
    c(AppCompatActivity paramAppCompatActivity) {}
    
    public final void dkT()
    {
      AppMethodBeat.i(230603);
      Object localObject1 = j.a(this.GjF);
      if (localObject1 != null) {
        j.b(this.GjF).fF((View)localObject1).s(ak.setOf(new Integer[] { Integer.valueOf(b.e.lyric_view), Integer.valueOf(b.e.FYj), Integer.valueOf(b.e.FXm), Integer.valueOf(b.e.FXq), Integer.valueOf(b.e.FWY) }));
      }
      localObject1 = j.c(this.GjF);
      if (localObject1 != null) {
        ((RecyclerView)localObject1).setVisibility(8);
      }
      localObject1 = j.d(this.GjF);
      if (localObject1 != null) {
        ((MusicMvLyricView)localObject1).setVisibility(4);
      }
      localObject1 = j.d(this.GjF);
      if (localObject1 != null) {
        ((MusicMvLyricView)localObject1).setAlpha(0.0F);
      }
      localObject1 = j.a(this.GjF);
      if (localObject1 != null) {
        ((View)localObject1).post((Runnable)new a(this));
      }
      Object localObject2 = paramAppCompatActivity;
      localObject1 = localObject2;
      if (!(localObject2 instanceof MMFragmentActivity)) {
        localObject1 = null;
      }
      localObject1 = (MMFragmentActivity)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((MMFragmentActivity)localObject1).getSwipeBackLayout();
        if (localObject1 != null) {
          ((SwipeBackLayout)localObject1).setEnableGesture(false);
        }
      }
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = com.tencent.mm.ui.component.g.b(paramAppCompatActivity).i(k.class);
      p.j(localObject1, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
      localObject1 = (k)localObject1;
      localObject2 = ((k)localObject1).getEffectManager();
      if (localObject2 != null)
      {
        j.a(this.GjF, (b)((EffectManager)localObject2).a(com.tencent.mm.xeffect.effect.j.YZP));
        b localb = j.f(this.GjF);
        if (localb != null) {
          localb.setRadius(20.0F);
        }
        ((EffectManager)localObject2).b((af)j.f(this.GjF));
      }
      ((k)localObject1).fhc();
      localObject2 = j.a(this.GjF);
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new j.c.b(this));
      }
      this.GjF.GjA = true;
      localObject2 = ((k)localObject1).getAdapter();
      int i = ((k)localObject1).GjI.jNa;
      localObject1 = k.GjX;
      ((WxRecyclerAdapter)localObject2).e(i, 1, k.fhd());
      AppMethodBeat.o(230603);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(j.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(234702);
        Object localObject1 = j.d(this.GjG.GjF);
        if (localObject1 != null) {
          ((MusicMvLyricView)localObject1).E(j.e(this.GjG.GjF), false);
        }
        localObject1 = j.d(this.GjG.GjF);
        if (localObject1 != null) {
          ((MusicMvLyricView)localObject1).setVisibility(0);
        }
        localObject1 = j.d(this.GjG.GjF);
        if (localObject1 != null)
        {
          ((MusicMvLyricView)localObject1).animate().cancel();
          ((MusicMvLyricView)localObject1).animate().alpha(1.0F).start();
        }
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject1 = (dbs)a.a.a((Context)this.GjG.wYZ, 7, dbs.class);
        if (localObject1 != null) {}
        for (localObject1 = Integer.valueOf(((dbs)localObject1).TJj + 1);; localObject1 = null)
        {
          Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
          localObject2 = (dbs)a.a.a((Context)this.GjG.wYZ, 7, dbs.class);
          if (localObject2 != null) {
            ((dbs)localObject2).TJj = ((Integer)localObject1).intValue();
          }
          this.GjG.GjF.GjB = Util.currentTicks();
          AppMethodBeat.o(234702);
          return;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "onBackClick", "", "onDragged", "onLineClick", "position", "", "time", "", "plugin-mv_release"})
  public static final class d
    implements MusicMvLyricView.h
  {
    d(AppCompatActivity paramAppCompatActivity) {}
    
    public final void OO(long paramLong)
    {
      AppMethodBeat.i(231984);
      com.tencent.mm.bb.a.wG((int)paramLong);
      if (com.tencent.mm.bb.a.bnx()) {
        com.tencent.mm.bb.a.bnu();
      }
      for (;;)
      {
        Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject = (dbs)a.a.a((Context)paramAppCompatActivity, 7, dbs.class);
        if (localObject == null) {
          break;
        }
        ((dbs)localObject).TJk = 1;
        AppMethodBeat.o(231984);
        return;
        localObject = com.tencent.mm.bb.a.bnA();
        if (localObject != null) {
          ((com.tencent.mm.bb.f)localObject).fod = ((int)paramLong);
        }
        com.tencent.mm.plugin.music.e.k.fet().t((com.tencent.mm.bb.f)localObject);
      }
      AppMethodBeat.o(231984);
    }
    
    public final void dvz()
    {
      AppMethodBeat.i(231981);
      j.g(this.GjF);
      AppMethodBeat.o(231981);
    }
    
    public final void fha()
    {
      AppMethodBeat.i(231986);
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject = (dbs)a.a.a((Context)paramAppCompatActivity, 7, dbs.class);
      if (localObject != null)
      {
        ((dbs)localObject).TJk = 1;
        AppMethodBeat.o(231986);
        return;
      }
      AppMethodBeat.o(231986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.j
 * JD-Core Version:    0.7.0.1
 */