package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.c;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "autoInitTransitionInfo", "", "(Landroid/content/Context;Z)V", "applyAllTransitionGroup", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getApplyAllTransitionGroup", "()Landroid/widget/LinearLayout;", "applyAllTransitionGroup$delegate", "Lkotlin/Lazy;", "applyAllTransitionIcon", "Landroid/widget/ImageView;", "getApplyAllTransitionIcon", "()Landroid/widget/ImageView;", "applyAllTransitionIcon$delegate", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "confirmIcon", "getConfirmIcon", "confirmIcon$delegate", "editTransitionIndex", "", "editTransitionListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "emptyHolder", "Landroid/view/View;", "getEmptyHolder", "()Landroid/view/View;", "emptyHolder$delegate", "isApplyAll", "originTransEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "selectedIndex", "selectedTransitionItem", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "transitionAdapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "transitionInfoList", "", "transitionRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getTransitionRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "transitionRecycler$delegate", "getItemOffsetLength", "initStatus", "", "transitionIndex", "order", "path", "", "initTransitionInfo", "setApplyAll", "enabled", "setEditTransitionListener", "listenerEdit", "Companion", "EditTransitionListener", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RelativeLayout
{
  private static final a UnU;
  private final j BqY;
  private final j UnV;
  private final j UnW;
  private final j UnX;
  private final j UnY;
  private final j UnZ;
  private final List<d> Uoa;
  private final c Uob;
  private b Uoc;
  private a.a Uod;
  private d Uoe;
  private int Uof;
  private boolean Uog;
  private int dbk;
  
  static
  {
    AppMethodBeat.i(283085);
    UnU = new a((byte)0);
    AppMethodBeat.o(283085);
  }
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(282901);
    this.UnV = k.cm((kotlin.g.a.a)new d(this));
    this.UnW = k.cm((kotlin.g.a.a)new c(this));
    this.UnX = k.cm((kotlin.g.a.a)new h(this));
    this.BqY = k.cm((kotlin.g.a.a)new e(this));
    this.UnY = k.cm((kotlin.g.a.a)new f(this));
    this.UnZ = k.cm((kotlin.g.a.a)new g(this));
    this.Uoa = ((List)new ArrayList());
    this.Uoe = new d();
    LayoutInflater.from(paramContext).inflate(a.g.editor_edit_transition_view, (ViewGroup)this, true);
    this.Uob = new c(this.Uoa);
    setOnClickListener(b..ExternalSyntheticLambda3.INSTANCE);
    if (paramBoolean) {
      hUl();
    }
    setApplyAll(this.Uog);
    c localc = this.Uob;
    c.d locald = (c.d)new c.d()
    {
      public final void a(d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(282889);
        s.u(paramAnonymousd, "item");
        if (!paramAnonymousd.Bvd)
        {
          b.a(this.Uoh).Bvd = false;
          b.b(this.Uoh).t(b.c(this.Uoh), new Object());
          paramAnonymousd.Bvd = true;
          b.b(this.Uoh).t(paramAnonymousInt, new Object());
          b.a(this.Uoh, paramAnonymousInt);
          b.a(this.Uoh, paramAnonymousd);
          paramAnonymousd = b.d(this.Uoh);
          if (paramAnonymousd != null) {
            paramAnonymousd.b(b.e(this.Uoh), b.a(this.Uoh).Uoo);
          }
        }
        AppMethodBeat.o(282889);
      }
    };
    s.u(locald, "listener");
    localc.Uok = locald;
    getTransitionRecycler().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    getTransitionRecycler().setAdapter((RecyclerView.a)this.Uob);
    getTransitionRecycler().setItemAnimator(null);
    int i = getItemOffsetLength();
    getTransitionRecycler().a((RecyclerView.h)new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(282892);
        s.u(paramAnonymousRect, "outRect");
        s.u(paramAnonymousView, "view");
        s.u(paramAnonymousRecyclerView, "parent");
        s.u(paramAnonymouss, "state");
        super.a(paramAnonymousRect, paramAnonymousView, paramAnonymousRecyclerView, paramAnonymouss);
        paramAnonymousRect.left = this.SDB;
        paramAnonymousRect.right = this.SDB;
        AppMethodBeat.o(282892);
      }
    });
    getApplyAllTransitionGroup().setOnClickListener(new b..ExternalSyntheticLambda1(this));
    getCloseIcon().setOnClickListener(new b..ExternalSyntheticLambda2(this));
    getConfirmIcon().setImageDrawable(bb.m(paramContext, a.h.icons_outlined_done, paramContext.getResources().getColor(a.c.Orange)));
    getConfirmIcon().setOnClickListener(new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(282901);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(282995);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (!paramb.Uog) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.setApplyAll(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282995);
      return;
    }
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(283009);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (!s.p(paramb.Uod, paramb.Uoe.Uoo))
    {
      paramView = paramb.Uoc;
      if (paramView != null) {
        paramView.b(paramb.Uof, paramb.Uod);
      }
    }
    paramb = paramb.Uoc;
    if (paramb != null) {
      paramb.bfj();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283009);
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(283018);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (paramb.Uog)
    {
      paramView = paramb.Uoc;
      if (paramView != null) {
        paramView.a(paramb.Uof, paramb.Uoe.Uoo);
      }
    }
    paramb = paramb.Uoc;
    if (paramb != null) {
      paramb.bfj();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283018);
  }
  
  private static final void dg(View paramView)
  {
    AppMethodBeat.i(282982);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282982);
  }
  
  private final LinearLayout getApplyAllTransitionGroup()
  {
    AppMethodBeat.i(282918);
    LinearLayout localLinearLayout = (LinearLayout)this.UnW.getValue();
    AppMethodBeat.o(282918);
    return localLinearLayout;
  }
  
  private final ImageView getApplyAllTransitionIcon()
  {
    AppMethodBeat.i(282909);
    ImageView localImageView = (ImageView)this.UnV.getValue();
    AppMethodBeat.o(282909);
    return localImageView;
  }
  
  private final WeImageView getCloseIcon()
  {
    AppMethodBeat.i(282930);
    WeImageView localWeImageView = (WeImageView)this.BqY.getValue();
    AppMethodBeat.o(282930);
    return localWeImageView;
  }
  
  private final ImageView getConfirmIcon()
  {
    AppMethodBeat.i(282940);
    ImageView localImageView = (ImageView)this.UnY.getValue();
    AppMethodBeat.o(282940);
    return localImageView;
  }
  
  private final View getEmptyHolder()
  {
    AppMethodBeat.i(282951);
    View localView = (View)this.UnZ.getValue();
    AppMethodBeat.o(282951);
    return localView;
  }
  
  private final int getItemOffsetLength()
  {
    AppMethodBeat.i(282963);
    int i = com.tencent.mm.cd.a.ms(getContext()) - com.tencent.mm.cd.a.fromDPToPix(getContext(), 26.0F);
    int j = com.tencent.mm.cd.a.br(getContext(), a.d.Edge_8A);
    int m = i * 10 / j;
    int k = m % 10;
    m /= 10;
    if (k > 7)
    {
      i = (i - (int)(j / 2 * (m + 1.5F))) / ((m + 1) * 2 + 1);
      AppMethodBeat.o(282963);
      return i;
    }
    if (k < 2)
    {
      i = (i - (int)(j / 2 * (m + 0.5F))) / (m * 2 + 1);
      AppMethodBeat.o(282963);
      return i;
    }
    i = j / 4;
    AppMethodBeat.o(282963);
    return i;
  }
  
  private final RecyclerView getTransitionRecycler()
  {
    AppMethodBeat.i(282921);
    RecyclerView localRecyclerView = (RecyclerView)this.UnX.getValue();
    AppMethodBeat.o(282921);
    return localRecyclerView;
  }
  
  private final void setApplyAll(boolean paramBoolean)
  {
    AppMethodBeat.i(282970);
    this.Uog = paramBoolean;
    ImageView localImageView = getApplyAllTransitionIcon();
    Context localContext = getContext();
    if (this.Uog) {}
    for (int i = a.h.ui_rescoures_checkbox_selected;; i = a.h.ui_rescoures_checkbox_unselected)
    {
      localImageView.setImageDrawable(bb.m(localContext, i, Color.parseColor("#CCFFFFFF")));
      AppMethodBeat.o(282970);
      return;
    }
  }
  
  public final void hUl()
  {
    AppMethodBeat.i(283161);
    this.Uoa.clear();
    this.Uoa.add(new d());
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    localObject = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.hRr()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      this.Uoa.add(new d(locala));
    }
    Log.i("MicroMsg.EditorEditTransitionView", s.X("initTransitionInfo: size:", Integer.valueOf(this.Uoa.size())));
    this.dbk = 0;
    this.Uoe = ((d)p.oK(this.Uoa));
    if (this.Uoa.size() <= 1)
    {
      getEmptyHolder().setVisibility(0);
      getApplyAllTransitionGroup().setVisibility(4);
      getTransitionRecycler().setVisibility(4);
      localObject = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      com.tencent.mm.plugin.vlog.model.local.a.j(new WeakReference(this));
      AppMethodBeat.o(283161);
      return;
    }
    getEmptyHolder().setVisibility(4);
    getApplyAllTransitionGroup().setVisibility(0);
    getTransitionRecycler().setVisibility(0);
    this.Uob.bZE.notifyChanged();
    AppMethodBeat.o(283161);
  }
  
  public final void mB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283146);
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    Object localObject2 = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.hRr()).iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((a.a)localObject1).order == paramInt2)
      {
        i = 1;
        label57:
        if (i == 0) {
          break label289;
        }
        label61:
        this.Uod = ((a.a)localObject1);
        this.Uof = paramInt1;
        this.Uoe.Bvd = false;
        this.Uob.fV(this.dbk);
        localObject1 = this.Uoa.iterator();
        paramInt1 = 0;
        label107:
        if (!((Iterator)localObject1).hasNext()) {
          break label304;
        }
        if (!s.p(((d)((Iterator)localObject1).next()).Uoo, this.Uod)) {
          break label297;
        }
      }
    }
    for (;;)
    {
      this.dbk = paramInt1;
      this.Uoe = ((d)this.Uoa.get(this.dbk));
      localObject1 = getTransitionRecycler();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(this.dbk, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(II)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(II)V", "Undefined", "scrollToPosition", "(I)V");
      this.Uoe.Bvd = true;
      this.Uob.fV(this.dbk);
      setApplyAll(false);
      AppMethodBeat.o(283146);
      return;
      i = 0;
      break label57;
      label289:
      break;
      localObject1 = null;
      break label61;
      label297:
      paramInt1 += 1;
      break label107;
      label304:
      paramInt1 = -1;
    }
  }
  
  public final void setEditTransitionListener(b paramb)
  {
    AppMethodBeat.i(283170);
    s.u(paramb, "listenerEdit");
    this.Uoc = paramb;
    AppMethodBeat.o(283170);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "", "onApplyTransitionToAll", "", "editTransitionIndex", "", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(int paramInt, a.a parama);
    
    public abstract void b(int paramInt, a.a parama);
    
    public abstract void bfj();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<View>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    h(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.b
 * JD-Core Version:    0.7.0.1
 */