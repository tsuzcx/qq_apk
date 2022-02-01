package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.ui.adapter.a.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.h;
import com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.b;
import com.tencent.mm.xeffect.effect.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.ak;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "blurEffect", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "childListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1;", "currentIndex", "", "currentTime", "fullLyricView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "kotlin.jvm.PlatformType", "getFullLyricView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "fullLyricView$delegate", "Lkotlin/Lazy;", "isShowFulScreenLyric", "", "()Z", "setShowFulScreenLyric", "(Z)V", "itemClick", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1;", "itemView", "Landroid/view/View;", "lyricEventListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1;", "lyricLines", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lyricList", "Landroid/support/v7/widget/RecyclerView;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRV", "mainRV", "getMainRV", "()Landroid/support/v7/widget/RecyclerView;", "mainRV$delegate", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "hideFullLyric", "", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "selectView", "parent", "setCurrentTime", "currentPos", "setSongInfo", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "obj", "plugin-mv_release"})
public final class MusicMvLyricUIC
  extends UIComponent
{
  e Amv;
  private final kotlin.f AtI;
  private final kotlin.f AtJ;
  RecyclerView AtK;
  ArrayList<RecyclerView> AtL;
  private final ArrayList<String> AtM;
  private b AtN;
  public boolean AtO;
  private final c AtP;
  final d AtQ;
  private final a AtR;
  private final c Atl;
  private final String TAG;
  View aus;
  int currentIndex;
  int dCS;
  
  public MusicMvLyricUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257146);
    this.TAG = "MicroMsg.MusicMvLyricUIC";
    this.AtI = g.ah((kotlin.g.a.a)new b(paramAppCompatActivity));
    this.AtJ = g.ah((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.AtL = new ArrayList();
    this.AtM = new ArrayList();
    this.currentIndex = -1;
    this.Atl = new c();
    this.AtP = new c(this, paramAppCompatActivity);
    this.AtQ = new d(this);
    this.AtR = new a(this);
    AppMethodBeat.o(257146);
  }
  
  private final void evR()
  {
    AppMethodBeat.i(257145);
    Object localObject1 = this.AtK;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setVisibility(0);
    }
    this.Atl.restore();
    localObject1 = evQ();
    if (localObject1 != null) {
      ((MusicMvLyricView)localObject1).setVisibility(8);
    }
    localObject1 = this.AtK;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(this.currentIndex, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "hideFullLyric", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "hideFullLyric", "()V", "Undefined", "scrollToPosition", "(I)V");
    }
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMainUIC.class);
    p.g(localObject1, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
    localObject1 = (MusicMvMainUIC)localObject1;
    Object localObject2 = ((MusicMvMainUIC)localObject1).evU();
    b localb;
    if (localObject2 != null)
    {
      localb = this.AtN;
      if (localb == null) {
        break label247;
      }
    }
    label247:
    for (long l = localb.id;; l = -1L)
    {
      ((EffectManager)localObject2).Ot(l);
      this.AtN = null;
      this.AtO = false;
      localObject2 = ((MusicMvMainUIC)localObject1).getAdapter();
      int i = ((MusicMvMainUIC)localObject1).AtW.hbQ;
      localObject1 = MusicMvMainUIC.Aul;
      ((WxRecyclerAdapter)localObject2).e(i, 1, MusicMvMainUIC.evV());
      AppMethodBeat.o(257145);
      return;
    }
  }
  
  public final void a(axy paramaxy, e parame)
  {
    AppMethodBeat.i(257143);
    this.AtM.clear();
    this.Amv = parame;
    e locale = this.Amv;
    String str;
    Object localObject;
    if (locale != null)
    {
      int j = locale.euw();
      int i = 0;
      while (i < j)
      {
        ArrayList localArrayList = this.AtM;
        str = locale.SQ(i).content;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localArrayList.add(localObject);
        i += 1;
      }
    }
    evQ().setLyricObj(parame);
    if (paramaxy != null)
    {
      parame = paramaxy.BPc;
      if (parame != null)
      {
        localObject = evQ();
        p.g(parame, "name");
        str = paramaxy.lDR;
        p.h(parame, "songName");
        paramaxy = parame;
        if (str != null) {
          paramaxy = parame + '·' + str;
        }
        ((MusicMvLyricView)localObject).Ayf.setText(paramaxy);
        ((MusicMvLyricView)localObject).Ayf.setTextBold(true);
        AppMethodBeat.o(257143);
        return;
      }
      AppMethodBeat.o(257143);
      return;
    }
    AppMethodBeat.o(257143);
  }
  
  final MusicMvLyricView evQ()
  {
    AppMethodBeat.i(257141);
    MusicMvLyricView localMusicMvLyricView = (MusicMvLyricView)this.AtI.getValue();
    AppMethodBeat.o(257141);
    return localMusicMvLyricView;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(257144);
    MusicMvLyricView localMusicMvLyricView = evQ();
    if ((localMusicMvLyricView != null) && (localMusicMvLyricView.getVisibility() == 0))
    {
      evR();
      AppMethodBeat.o(257144);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(257144);
    return bool;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(257142);
    super.onCreateAfter(paramBundle);
    paramBundle = (RecyclerView)this.AtJ.getValue();
    if (paramBundle != null)
    {
      paramBundle.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)this.AtR);
      AppMethodBeat.o(257142);
      return;
    }
    AppMethodBeat.o(257142);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "onChildViewAdded", "", "parent", "Landroid/view/View;", "child", "onChildViewRemoved", "plugin-mv_release"})
  public static final class a
    implements ViewGroup.OnHierarchyChangeListener
  {
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(257133);
      if (paramView2 != null)
      {
        paramView1 = (RecyclerView)paramView2.findViewById(2131304296);
        if (paramView1 != null) {}
      }
      else
      {
        AppMethodBeat.o(257133);
        return;
      }
      if (MusicMvLyricUIC.h(this.AtS).contains(paramView1))
      {
        AppMethodBeat.o(257133);
        return;
      }
      MusicMvLyricUIC.h(this.AtS).add(paramView1);
      if ((com.tencent.mm.plugin.mv.ui.adapter.a)paramView1.getAdapter() == null)
      {
        paramView2 = new com.tencent.mm.plugin.mv.ui.adapter.a((a.b)MusicMvLyricUIC.i(this.AtS));
        List localList = (List)MusicMvLyricUIC.j(this.AtS);
        p.h(localList, "list");
        paramView2.kgc.clear();
        paramView2.kgc.addAll((Collection)localList);
        paramView2.notifyDataSetChanged();
        paramView1.setAdapter((RecyclerView.a)paramView2);
      }
      if ((LinearLayoutManager)paramView1.getLayoutManager() != null)
      {
        paramView2 = com.tencent.mm.hellhoundlib.b.c.a(MusicMvLyricUIC.k(this.AtS), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramView1, paramView2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        paramView1.scrollToPosition(((Integer)paramView2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramView1, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
      }
      AppMethodBeat.o(257133);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(257134);
      if (paramView2 != null)
      {
        paramView1 = (RecyclerView)paramView2.findViewById(2131304296);
        if (paramView1 != null) {}
      }
      else
      {
        AppMethodBeat.o(257134);
        return;
      }
      MusicMvLyricUIC.h(this.AtS).remove(paramView1);
      AppMethodBeat.o(257134);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MusicMvLyricView>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "onClick", "", "position", "", "plugin-mv_release"})
  public static final class c
    implements a.b
  {
    c(AppCompatActivity paramAppCompatActivity) {}
    
    public final void cVN()
    {
      AppMethodBeat.i(257137);
      Object localObject1 = MusicMvLyricUIC.a(this.AtS);
      if (localObject1 != null) {
        MusicMvLyricUIC.b(this.AtS).eD((View)localObject1).s(ak.setOf(new Integer[] { Integer.valueOf(2131304298), Integer.valueOf(2131305158), Integer.valueOf(2131301663), Integer.valueOf(2131302300), Integer.valueOf(2131299322) }));
      }
      localObject1 = MusicMvLyricUIC.c(this.AtS);
      if (localObject1 != null) {
        ((RecyclerView)localObject1).setVisibility(8);
      }
      localObject1 = MusicMvLyricUIC.d(this.AtS);
      if (localObject1 != null) {
        ((MusicMvLyricView)localObject1).setVisibility(4);
      }
      localObject1 = MusicMvLyricUIC.d(this.AtS);
      if (localObject1 != null) {
        ((MusicMvLyricView)localObject1).setAlpha(0.0F);
      }
      localObject1 = MusicMvLyricUIC.a(this.AtS);
      if (localObject1 != null) {
        ((View)localObject1).post((Runnable)new a(this));
      }
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(MusicMvMainUIC.class);
      p.g(localObject1, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
      localObject1 = (MusicMvMainUIC)localObject1;
      Object localObject2 = ((MusicMvMainUIC)localObject1).evU();
      if (localObject2 != null)
      {
        MusicMvLyricUIC.a(this.AtS, (b)((EffectManager)localObject2).a(j.Ryj));
        b localb = MusicMvLyricUIC.f(this.AtS);
        if (localb != null) {
          localb.setRadius(20.0F);
        }
        ((EffectManager)localObject2).a((ad)MusicMvLyricUIC.f(this.AtS));
      }
      this.AtS.AtO = true;
      localObject2 = ((MusicMvMainUIC)localObject1).getAdapter();
      int i = ((MusicMvMainUIC)localObject1).AtW.hbQ;
      localObject1 = MusicMvMainUIC.Aul;
      ((WxRecyclerAdapter)localObject2).e(i, 1, MusicMvMainUIC.evV());
      AppMethodBeat.o(257137);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MusicMvLyricUIC.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(257136);
        MusicMvLyricView localMusicMvLyricView = MusicMvLyricUIC.d(this.AtT.AtS);
        if (localMusicMvLyricView != null) {
          localMusicMvLyricView.E(MusicMvLyricUIC.e(this.AtT.AtS), false);
        }
        localMusicMvLyricView = MusicMvLyricUIC.d(this.AtT.AtS);
        if (localMusicMvLyricView != null) {
          localMusicMvLyricView.setVisibility(0);
        }
        localMusicMvLyricView = MusicMvLyricUIC.d(this.AtT.AtS);
        if (localMusicMvLyricView != null)
        {
          localMusicMvLyricView.animate().cancel();
          localMusicMvLyricView.animate().alpha(1.0F).start();
          AppMethodBeat.o(257136);
          return;
        }
        AppMethodBeat.o(257136);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "onBackClick", "", "onLineClick", "position", "", "time", "", "plugin-mv_release"})
  public static final class d
    implements MusicMvLyricView.h
  {
    public final void Hu(long paramLong)
    {
      AppMethodBeat.i(257139);
      com.tencent.mm.ay.a.tG((int)paramLong);
      if (com.tencent.mm.ay.a.bec())
      {
        com.tencent.mm.ay.a.bdZ();
        AppMethodBeat.o(257139);
        return;
      }
      com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.bef();
      if (localf != null) {
        localf.dvv = ((int)paramLong);
      }
      k.euj().t(localf);
      AppMethodBeat.o(257139);
    }
    
    public final void evS()
    {
      AppMethodBeat.i(257138);
      MusicMvLyricUIC.g(this.AtS);
      AppMethodBeat.o(257138);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvLyricUIC
 * JD-Core Version:    0.7.0.1
 */