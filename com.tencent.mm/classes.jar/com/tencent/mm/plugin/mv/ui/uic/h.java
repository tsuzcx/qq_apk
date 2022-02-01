package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.ui.adapter.a.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.h;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "blurEffect", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "childListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1;", "currentIndex", "", "currentTime", "enterFullLyricPageTime", "", "getEnterFullLyricPageTime", "()J", "setEnterFullLyricPageTime", "(J)V", "fullLyricView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "kotlin.jvm.PlatformType", "getFullLyricView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "fullLyricView$delegate", "Lkotlin/Lazy;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "hasMV", "", "getHasMV", "()Z", "setHasMV", "(Z)V", "imageBlurEffect", "isShowFulScreenLyric", "setShowFulScreenLyric", "itemClick", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1;", "itemView", "Landroid/view/View;", "lyricEventListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1;", "lyricLines", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lyricList", "Landroidx/recyclerview/widget/RecyclerView;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRV", "mainRV", "getMainRV", "()Landroidx/recyclerview/widget/RecyclerView;", "mainRV$delegate", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "getViewRecord", "()Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "hideFullLyric", "", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "selectView", "parent", "setCurrentTime", "currentPos", "setSongInfo", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "obj", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends UIComponent
{
  e LOA;
  private final ArrayList<String> Mcc;
  private final x MdQ;
  private com.tencent.mm.xeffect.effect.b MeA;
  public boolean MeB;
  long MeC;
  public boolean MeD;
  private final d MeE;
  private final e MeF;
  private final a MeG;
  private final kotlin.j Mew;
  private final kotlin.j Mex;
  private RecyclerView Mey;
  ArrayList<RecyclerView> Mez;
  private final String TAG;
  private View caK;
  int currentIndex;
  int currentTime;
  private final GestureDetector nwZ;
  
  public h(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287675);
    this.TAG = "MicroMsg.MusicMvLyricUIC";
    this.Mew = kotlin.k.cm((kotlin.g.a.a)new b(paramAppCompatActivity));
    this.Mex = kotlin.k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.Mez = new ArrayList();
    this.Mcc = new ArrayList();
    this.currentIndex = -1;
    this.MdQ = new x();
    this.MeE = new d(paramAppCompatActivity, this);
    this.MeF = new e(this, paramAppCompatActivity);
    this.MeG = new a(this);
    this.nwZ = new GestureDetector((Context)getContext(), (GestureDetector.OnGestureListener)new c(this));
    AppMethodBeat.o(287675);
  }
  
  private static final boolean a(h paramh, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(287684);
    s.u(paramh, "this$0");
    paramh = paramh.nwZ;
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramh, paramView.aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "onCreateAfter$lambda-0", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramh, paramh.onTouchEvent((MotionEvent)paramView.sb(0)), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "onCreateAfter$lambda-0", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(287684);
    return bool;
  }
  
  public final void a(boo paramboo, e parame)
  {
    AppMethodBeat.i(287793);
    this.Mcc.clear();
    this.LOA = parame;
    e locale = this.LOA;
    int i;
    int k;
    if (locale != null)
    {
      i = 0;
      k = locale.LMm.size();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      ArrayList localArrayList = this.Mcc;
      String str2 = locale.adz(i).content;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localArrayList.add(str1);
      if (j >= k)
      {
        gqI().setLyricObj(parame);
        if (paramboo != null)
        {
          parame = paramboo.songName;
          if (parame != null) {
            gqI().kE(parame, paramboo.rDl);
          }
        }
        paramboo = ((Iterable)this.Mez).iterator();
        while (paramboo.hasNext())
        {
          parame = (com.tencent.mm.plugin.mv.ui.adapter.a)((RecyclerView)paramboo.next()).getAdapter();
          if (parame != null) {
            parame.hM((List)this.Mcc);
          }
        }
        AppMethodBeat.o(287793);
        return;
      }
      i = j;
    }
  }
  
  final MusicMvLyricView gqI()
  {
    AppMethodBeat.i(287772);
    MusicMvLyricView localMusicMvLyricView = (MusicMvLyricView)this.Mew.getValue();
    AppMethodBeat.o(287772);
    return localMusicMvLyricView;
  }
  
  public final void gqJ()
  {
    AppMethodBeat.i(287809);
    Object localObject1 = p.mutableListOf(new Integer[] { Integer.valueOf(b.e.LSX), Integer.valueOf(b.e.LSB), Integer.valueOf(b.e.LSK) });
    Object localObject2;
    label227:
    com.tencent.mm.xeffect.effect.b localb;
    long l1;
    label312:
    long l2;
    if (this.MeD)
    {
      ((List)localObject1).add(Integer.valueOf(b.e.LTL));
      localObject2 = x.Mhf;
      x.a.a(this.caK, (List)localObject1, 0);
      localObject1 = this.Mey;
      if (localObject1 != null) {
        ((RecyclerView)localObject1).setVisibility(0);
      }
      localObject1 = gqI();
      if (localObject1 != null) {
        ((MusicMvLyricView)localObject1).setVisibility(8);
      }
      localObject1 = this.Mey;
      if (localObject1 != null)
      {
        localObject2 = c.a(this.currentIndex, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "hideFullLyric", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "hideFullLyric", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
      localObject1 = getActivity();
      if (!(localObject1 instanceof MMFragmentActivity)) {
        break label459;
      }
      localObject1 = (MMFragmentActivity)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((MMFragmentActivity)localObject1).getSwipeBackLayout();
        if (localObject1 != null) {
          ((SwipeBackLayout)localObject1).setEnableGesture(true);
        }
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(i.class);
      s.s(localObject1, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
      localObject1 = (i)localObject1;
      localObject2 = ((i)localObject1).getEffectManager();
      if (localObject2 != null)
      {
        localb = this.MeA;
        if (localb != null) {
          break label465;
        }
        l1 = -1L;
        ((EffectManager)localObject2).AT(l1);
        this.MeA = null;
      }
      ((i)localObject1).gqM();
      this.MeB = false;
      ((i)localObject1).getAdapter().e(((i)localObject1).MeK.mma, 1, "hideFullLyric");
      l1 = Util.currentTicks();
      l2 = this.MeC;
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (dtk)a.a.a((Context)getActivity(), 7, dtk.class);
      if (localObject1 != null) {
        break label474;
      }
    }
    label459:
    label465:
    label474:
    for (localObject1 = null;; localObject1 = Long.valueOf(((dtk)localObject1).aaZb + (l1 - l2)))
    {
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject2 = (dtk)a.a.a((Context)getActivity(), 7, dtk.class);
      if (localObject2 != null) {
        ((dtk)localObject2).aaZb = ((Long)localObject1).longValue();
      }
      AppMethodBeat.o(287809);
      return;
      ((List)localObject1).add(Integer.valueOf(b.e.LUZ));
      break;
      localObject1 = null;
      break label227;
      l1 = localb.id;
      break label312;
    }
  }
  
  public final void it(View paramView)
  {
    Object localObject = null;
    AppMethodBeat.i(287787);
    this.caK = paramView;
    MusicMvLyricView localMusicMvLyricView = gqI();
    if (localMusicMvLyricView != null) {
      localMusicMvLyricView.setEventListener(null);
    }
    if (paramView == null) {}
    for (paramView = localObject;; paramView = (RecyclerView)paramView.findViewById(b.e.LSX))
    {
      this.Mey = paramView;
      paramView = gqI();
      if (paramView != null) {
        paramView.setEventListener((MusicMvLyricView.h)this.MeF);
      }
      AppMethodBeat.o(287787);
      return;
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(287797);
    MusicMvLyricView localMusicMvLyricView = gqI();
    if ((localMusicMvLyricView != null) && (localMusicMvLyricView.getVisibility() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      gqJ();
      AppMethodBeat.o(287797);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(287797);
    return bool;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(287782);
    super.onCreateAfter(paramBundle);
    paramBundle = gqI().getLyricRv();
    if (paramBundle != null) {
      paramBundle.setOnTouchListener(new h..ExternalSyntheticLambda0(this));
    }
    paramBundle = (RecyclerView)this.Mex.getValue();
    if (paramBundle != null) {
      paramBundle.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)this.MeG);
    }
    AppMethodBeat.o(287782);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "onChildViewAdded", "", "parent", "Landroid/view/View;", "child", "onChildViewRemoved", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewGroup.OnHierarchyChangeListener
  {
    a(h paramh) {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(288106);
      if (paramView2 == null) {}
      for (paramView1 = null; paramView1 == null; paramView1 = (RecyclerView)paramView2.findViewById(b.e.LSX))
      {
        AppMethodBeat.o(288106);
        return;
      }
      if (h.f(this.MeH).contains(paramView1))
      {
        AppMethodBeat.o(288106);
        return;
      }
      h.f(this.MeH).add(paramView1);
      if ((com.tencent.mm.plugin.mv.ui.adapter.a)paramView1.getAdapter() == null)
      {
        paramView2 = new com.tencent.mm.plugin.mv.ui.adapter.a((a.b)h.g(this.MeH));
        paramView2.hM((List)h.i(this.MeH));
        ah localah = ah.aiuX;
        paramView1.setAdapter((RecyclerView.a)paramView2);
      }
      if ((LinearLayoutManager)paramView1.getLayoutManager() != null)
      {
        paramView2 = c.a(h.h(this.MeH), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramView1, paramView2.aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        paramView1.scrollToPosition(((Integer)paramView2.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramView1, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
      }
      AppMethodBeat.o(288106);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(288112);
      if (paramView2 == null) {}
      for (paramView1 = null; paramView1 == null; paramView1 = (RecyclerView)paramView2.findViewById(b.e.LSX))
      {
        AppMethodBeat.o(288112);
        return;
      }
      h.f(this.MeH).remove(paramView1);
      AppMethodBeat.o(288112);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MusicMvLyricView>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$gestureDetector$1", "Landroid/view/GestureDetector$OnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements GestureDetector.OnGestureListener
  {
    c(h paramh) {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(288136);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(288136);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public final void onShowPress(MotionEvent paramMotionEvent) {}
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(288121);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      if (paramMotionEvent == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(288121);
        return false;
      }
      int i = (int)paramMotionEvent.getRawY();
      int j = h.c(this.MeH).getLastVisibleItemPos()[1];
      if ((i > com.tencent.mm.cd.a.fromDPToPix((Context)this.MeH.getContext(), 20) + j) || ((int)paramMotionEvent.getRawY() < h.c(this.MeH).getFirstVisibleItemPos()[1] - com.tencent.mm.cd.a.fromDPToPix((Context)this.MeH.getContext(), 20)))
      {
        this.MeH.gqJ();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(288121);
        return true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(288121);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "onClick", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements a.b
  {
    d(AppCompatActivity paramAppCompatActivity, h paramh) {}
    
    private static final void a(h paramh, AppCompatActivity paramAppCompatActivity)
    {
      AppMethodBeat.i(288093);
      s.u(paramh, "this$0");
      s.u(paramAppCompatActivity, "$activity");
      Object localObject = h.c(paramh);
      if (localObject != null) {
        ((MusicMvLyricView)localObject).N(h.d(paramh), false);
      }
      localObject = h.c(paramh);
      if (localObject != null) {
        ((MusicMvLyricView)localObject).setVisibility(0);
      }
      localObject = h.c(paramh);
      if (localObject != null)
      {
        ((MusicMvLyricView)localObject).animate().cancel();
        ((MusicMvLyricView)localObject).animate().alpha(1.0F).start();
      }
      localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject = (dtk)a.a.a((Context)paramAppCompatActivity, 7, dtk.class);
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(((dtk)localObject).aaYZ + 1))
      {
        a.a locala = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramAppCompatActivity = (dtk)a.a.a((Context)paramAppCompatActivity, 7, dtk.class);
        if (paramAppCompatActivity != null) {
          paramAppCompatActivity.aaYZ = ((Integer)localObject).intValue();
        }
        paramh.MeC = Util.currentTicks();
        AppMethodBeat.o(288093);
        return;
      }
    }
    
    private static final void j(h paramh)
    {
      AppMethodBeat.i(288101);
      s.u(paramh, "this$0");
      paramh = h.a(paramh);
      s.checkNotNull(paramh);
      ImageView localImageView = (ImageView)paramh.findViewById(b.e.cover_iv);
      if (localImageView != null)
      {
        paramh = localImageView.getDrawable();
        if (paramh == null) {}
      }
      for (paramh = ((BitmapDrawable)paramh).getBitmap();; paramh = null)
      {
        if (paramh == null)
        {
          AppMethodBeat.o(288101);
          return;
        }
        com.tencent.mm.videocomposition.effect.a locala = new com.tencent.mm.videocomposition.effect.a();
        s.checkNotNull(paramh);
        locala.setInputBitmap(paramh);
        locala.setOutputSize(localImageView.getWidth(), localImageView.getHeight());
        paramh = (com.tencent.mm.xeffect.effect.b)locala.HkF.GpO.a(com.tencent.mm.xeffect.effect.j.agYb);
        if (paramh != null) {
          paramh.setRadius(20.0F);
        }
        locala.HkF.GpO.b((af)paramh);
        locala.aW((kotlin.g.a.b)new h.d.a(localImageView));
        AppMethodBeat.o(288101);
        return;
      }
    }
    
    public final void dRJ()
    {
      AppMethodBeat.i(288126);
      Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d(this.Awh).q(i.class);
      s.s(localObject1, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
      i locali = (i)localObject1;
      localObject1 = h.a(jdField_this);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = x.Mhf;
        x.a.a((View)localObject1, p.mutableListOf(new Integer[] { Integer.valueOf(b.e.LSX), Integer.valueOf(b.e.LTL), Integer.valueOf(b.e.LSB), Integer.valueOf(b.e.LSK), Integer.valueOf(b.e.LUZ) }), 8);
      }
      localObject1 = h.b(jdField_this);
      if (localObject1 != null) {
        ((RecyclerView)localObject1).setVisibility(8);
      }
      localObject1 = h.c(jdField_this);
      if (localObject1 != null) {
        ((MusicMvLyricView)localObject1).setVisibility(4);
      }
      localObject1 = h.c(jdField_this);
      if (localObject1 != null) {
        ((MusicMvLyricView)localObject1).setAlpha(0.0F);
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((g)com.tencent.mm.ui.component.k.d(this.Awh).q(g.class)).Meo.gsf();
      localObject1 = h.a(jdField_this);
      if (localObject1 != null) {
        ((View)localObject1).post(new h.d..ExternalSyntheticLambda1(jdField_this, this.Awh));
      }
      localObject1 = this.Awh;
      if ((localObject1 instanceof MMFragmentActivity)) {}
      for (localObject1 = (MMFragmentActivity)localObject1;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject1 = ((MMFragmentActivity)localObject1).getSwipeBackLayout();
          if (localObject1 != null) {
            ((SwipeBackLayout)localObject1).setEnableGesture(false);
          }
        }
        localObject1 = locali.getEffectManager();
        if (localObject1 != null)
        {
          localObject2 = jdField_this;
          h.a((h)localObject2, (com.tencent.mm.xeffect.effect.b)((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.agYb));
          com.tencent.mm.xeffect.effect.b localb = h.e((h)localObject2);
          if (localb != null) {
            localb.setRadius(20.0F);
          }
          ((EffectManager)localObject1).b((af)h.e((h)localObject2));
        }
        locali.gqM();
        localObject1 = h.a(jdField_this);
        if (localObject1 != null) {
          ((View)localObject1).post(new h.d..ExternalSyntheticLambda0(jdField_this));
        }
        jdField_this.MeB = true;
        AppMethodBeat.o(288126);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "onBackClick", "", "onDragged", "onLineClick", "position", "", "time", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MusicMvLyricView.h
  {
    e(h paramh, AppCompatActivity paramAppCompatActivity) {}
    
    public final void eft()
    {
      AppMethodBeat.i(288064);
      this.MeH.gqJ();
      AppMethodBeat.o(288064);
    }
    
    public final void gqK()
    {
      AppMethodBeat.i(288083);
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject = (dtk)a.a.a((Context)paramAppCompatActivity, 7, dtk.class);
      if (localObject != null) {
        ((dtk)localObject).aaZa = 1;
      }
      AppMethodBeat.o(288083);
    }
    
    public final void sL(long paramLong)
    {
      AppMethodBeat.i(288074);
      com.tencent.mm.aw.a.wH((int)paramLong);
      if (com.tencent.mm.aw.a.bLk()) {
        com.tencent.mm.aw.a.bLh();
      }
      for (;;)
      {
        Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = (dtk)a.a.a((Context)paramAppCompatActivity, 7, dtk.class);
        if (localObject != null) {
          ((dtk)localObject).aaZa = 1;
        }
        AppMethodBeat.o(288074);
        return;
        localObject = com.tencent.mm.aw.a.bLn();
        if (localObject != null) {
          ((f)localObject).startTime = ((int)paramLong);
        }
        com.tencent.mm.plugin.music.logic.j.gnw().x((f)localObject);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.h
 * JD-Core Version:    0.7.0.1
 */