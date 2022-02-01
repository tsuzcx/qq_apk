package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.a.j;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applyAllTransitionGroup", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getApplyAllTransitionGroup", "()Landroid/widget/LinearLayout;", "applyAllTransitionGroup$delegate", "Lkotlin/Lazy;", "applyAllTransitionIcon", "Landroid/widget/ImageView;", "getApplyAllTransitionIcon", "()Landroid/widget/ImageView;", "applyAllTransitionIcon$delegate", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "confirmIcon", "getConfirmIcon", "confirmIcon$delegate", "editTransitionIndex", "", "editTransitionListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "emptyHolder", "Landroid/view/View;", "getEmptyHolder", "()Landroid/view/View;", "emptyHolder$delegate", "isApplyAll", "", "originTransEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "selectedIndex", "selectedTransitionItem", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "transitionAdapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "transitionInfoList", "", "transitionRecycler", "Landroid/support/v7/widget/RecyclerView;", "getTransitionRecycler", "()Landroid/support/v7/widget/RecyclerView;", "transitionRecycler$delegate", "getItemOffsetLength", "initStatus", "", "transitionIndex", "effectId", "", "initTransitionInfo", "setApplyAll", "enabled", "setEditTransitionListener", "listenerEdit", "Companion", "EditTransitionListener", "plugin-vlog_release"})
public final class b
  extends RelativeLayout
{
  @Deprecated
  public static final a CkL;
  private final f CkA;
  private final f CkB;
  private final f CkC;
  private final f CkD;
  private final List<d> CkE;
  private final c CkF;
  private b CkG;
  private a.a CkH;
  private d CkI;
  private int CkJ;
  private boolean CkK;
  private final f Ckz;
  private int bxN;
  private final f yaF;
  
  static
  {
    AppMethodBeat.i(192257);
    CkL = new a((byte)0);
    AppMethodBeat.o(192257);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(192256);
    this.Ckz = g.O((d.g.a.a)new d(this));
    this.CkA = g.O((d.g.a.a)new c(this));
    this.CkB = g.O((d.g.a.a)new h(this));
    this.yaF = g.O((d.g.a.a)new e(this));
    this.CkC = g.O((d.g.a.a)new f(this));
    this.CkD = g.O((d.g.a.a)new g(this));
    this.CkE = ((List)new ArrayList());
    this.CkI = new d();
    LayoutInflater.from(paramContext).inflate(2131496448, (ViewGroup)this, true);
    setOnClickListener((View.OnClickListener)1.CkM);
    exH();
    setApplyAll(this.CkK);
    this.CkF = new c(this.CkE);
    Object localObject = this.CkF;
    c.d locald = (c.d)new c.d()
    {
      public final void a(d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(192234);
        p.h(paramAnonymousd, "item");
        if (!paramAnonymousd.tqA)
        {
          b.a(this.CkN).tqA = false;
          b.b(this.CkN).b(b.c(this.CkN), new Object());
          paramAnonymousd.tqA = true;
          b.b(this.CkN).b(paramAnonymousInt, new Object());
          b.a(this.CkN, paramAnonymousInt);
          b.a(this.CkN, paramAnonymousd);
          paramAnonymousd = b.d(this.CkN);
          if (paramAnonymousd != null)
          {
            paramAnonymousd.b(b.e(this.CkN), b.a(this.CkN).CkX);
            AppMethodBeat.o(192234);
            return;
          }
        }
        AppMethodBeat.o(192234);
      }
    };
    p.h(locald, "listener");
    ((c)localObject).CkO = locald;
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager(0));
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.CkF);
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setItemAnimator(null);
    int i = getItemOffsetLength();
    getTransitionRecycler().b((RecyclerView.h)new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
      {
        AppMethodBeat.i(192235);
        p.h(paramAnonymousRect, "outRect");
        p.h(paramAnonymousView, "view");
        p.h(paramAnonymousRecyclerView, "parent");
        p.h(paramAnonymoust, "state");
        super.a(paramAnonymousRect, paramAnonymousView, paramAnonymousRecyclerView, paramAnonymoust);
        paramAnonymousRect.left = this.BxB;
        paramAnonymousRect.right = this.BxB;
        AppMethodBeat.o(192235);
      }
    });
    getApplyAllTransitionGroup().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192236);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.CkN;
        if (!b.f(this.CkN)) {}
        for (boolean bool = true;; bool = false)
        {
          b.a(paramAnonymousView, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(192236);
          return;
        }
      }
    });
    getCloseIcon().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192237);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((p.i(b.g(this.CkN), b.a(this.CkN).CkX) ^ true))
        {
          paramAnonymousView = b.d(this.CkN);
          if (paramAnonymousView != null) {
            paramAnonymousView.b(b.e(this.CkN), b.g(this.CkN));
          }
        }
        paramAnonymousView = b.d(this.CkN);
        if (paramAnonymousView != null) {
          paramAnonymousView.onClose();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192237);
      }
    });
    getConfirmIcon().setImageDrawable(ao.k(paramContext, 2131690558, paramContext.getResources().getColor(2131099777)));
    getConfirmIcon().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192238);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (b.f(this.CkN))
        {
          paramAnonymousView = b.d(this.CkN);
          if (paramAnonymousView != null) {
            paramAnonymousView.a(b.e(this.CkN), b.a(this.CkN).CkX);
          }
        }
        paramAnonymousView = b.d(this.CkN);
        if (paramAnonymousView != null) {
          paramAnonymousView.onClose();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192238);
      }
    });
    AppMethodBeat.o(192256);
  }
  
  private final LinearLayout getApplyAllTransitionGroup()
  {
    AppMethodBeat.i(192246);
    LinearLayout localLinearLayout = (LinearLayout)this.CkA.getValue();
    AppMethodBeat.o(192246);
    return localLinearLayout;
  }
  
  private final ImageView getApplyAllTransitionIcon()
  {
    AppMethodBeat.i(192245);
    ImageView localImageView = (ImageView)this.Ckz.getValue();
    AppMethodBeat.o(192245);
    return localImageView;
  }
  
  private final WeImageView getCloseIcon()
  {
    AppMethodBeat.i(192248);
    WeImageView localWeImageView = (WeImageView)this.yaF.getValue();
    AppMethodBeat.o(192248);
    return localWeImageView;
  }
  
  private final ImageView getConfirmIcon()
  {
    AppMethodBeat.i(192249);
    ImageView localImageView = (ImageView)this.CkC.getValue();
    AppMethodBeat.o(192249);
    return localImageView;
  }
  
  private final View getEmptyHolder()
  {
    AppMethodBeat.i(192250);
    View localView = (View)this.CkD.getValue();
    AppMethodBeat.o(192250);
    return localView;
  }
  
  private final int getItemOffsetLength()
  {
    AppMethodBeat.i(192251);
    int i = com.tencent.mm.cb.a.iu(getContext()) - com.tencent.mm.cb.a.h(getContext(), 26.0F);
    int j = com.tencent.mm.cb.a.ax(getContext(), 2131165301);
    int m = i * 10 / j;
    int k = m % 10;
    m /= 10;
    if (k > 7)
    {
      i = (i - (int)(j / 2 * (m + 1.5F))) / ((m + 1) * 2 + 1);
      AppMethodBeat.o(192251);
      return i;
    }
    if (k < 2)
    {
      i = (i - (int)(j / 2 * (m + 0.5F))) / (m * 2 + 1);
      AppMethodBeat.o(192251);
      return i;
    }
    i = j / 4;
    AppMethodBeat.o(192251);
    return i;
  }
  
  private final RecyclerView getTransitionRecycler()
  {
    AppMethodBeat.i(192247);
    RecyclerView localRecyclerView = (RecyclerView)this.CkB.getValue();
    AppMethodBeat.o(192247);
    return localRecyclerView;
  }
  
  private final void setApplyAll(boolean paramBoolean)
  {
    AppMethodBeat.i(192254);
    this.CkK = paramBoolean;
    ImageView localImageView = getApplyAllTransitionIcon();
    Context localContext = getContext();
    if (this.CkK) {}
    for (int i = 2131691343;; i = 2131691344)
    {
      localImageView.setImageDrawable(ao.k(localContext, i, Color.parseColor("#CCFFFFFF")));
      AppMethodBeat.o(192254);
      return;
    }
  }
  
  public final void aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(192252);
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.BYT;
    Object localObject2 = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.evZ()).iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((a.a)localObject1).yeZ == paramLong)
      {
        i = 1;
        label59:
        if (i == 0) {
          break label293;
        }
        label64:
        this.CkH = ((a.a)localObject1);
        this.CkJ = paramInt;
        this.CkI.tqA = false;
        this.CkF.cj(this.bxN);
        localObject1 = this.CkE.iterator();
        paramInt = 0;
        label110:
        if (!((Iterator)localObject1).hasNext()) {
          break label308;
        }
        if (!p.i(((d)((Iterator)localObject1).next()).CkX, this.CkH)) {
          break label301;
        }
      }
    }
    for (;;)
    {
      this.bxN = paramInt;
      this.CkI = ((d)this.CkE.get(this.bxN));
      localObject1 = getTransitionRecycler();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(this.bxN, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(IJ)V", "Undefined", "scrollToPosition", "(I)V");
      this.CkI.tqA = true;
      this.CkF.cj(this.bxN);
      setApplyAll(false);
      AppMethodBeat.o(192252);
      return;
      i = 0;
      break label59;
      label293:
      break;
      localObject1 = null;
      break label64;
      label301:
      paramInt += 1;
      break label110;
      label308:
      paramInt = -1;
    }
  }
  
  public final void exH()
  {
    AppMethodBeat.i(192253);
    this.CkE.clear();
    this.CkE.add(new d());
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.BYT;
    localObject = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.evZ()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      this.CkE.add(new d(locala));
    }
    ae.i("MicroMsg.EditorEditTransitionView", "initTransitionInfo: size:" + this.CkE.size());
    this.bxN = 0;
    this.CkI = ((d)j.jl(this.CkE));
    if (this.CkE.size() <= 1)
    {
      localObject = getEmptyHolder();
      p.g(localObject, "emptyHolder");
      ((View)localObject).setVisibility(0);
      localObject = getApplyAllTransitionGroup();
      p.g(localObject, "applyAllTransitionGroup");
      ((LinearLayout)localObject).setVisibility(4);
      localObject = getTransitionRecycler();
      p.g(localObject, "transitionRecycler");
      ((RecyclerView)localObject).setVisibility(4);
      localObject = com.tencent.mm.plugin.vlog.model.local.a.BYT;
      com.tencent.mm.plugin.vlog.model.local.a.h(new WeakReference(this));
      AppMethodBeat.o(192253);
      return;
    }
    localObject = getEmptyHolder();
    p.g(localObject, "emptyHolder");
    ((View)localObject).setVisibility(4);
    localObject = getApplyAllTransitionGroup();
    p.g(localObject, "applyAllTransitionGroup");
    ((LinearLayout)localObject).setVisibility(0);
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setVisibility(0);
    AppMethodBeat.o(192253);
  }
  
  public final void setEditTransitionListener(b paramb)
  {
    AppMethodBeat.i(192255);
    p.h(paramb, "listenerEdit");
    this.CkG = paramb;
    AppMethodBeat.o(192255);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "", "onApplyTransitionToAll", "", "editTransitionIndex", "", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "plugin-vlog_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, a.a parama);
    
    public abstract void b(int paramInt, a.a parama);
    
    public abstract void onClose();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<LinearLayout>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<ImageView>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<WeImageView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<ImageView>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<View>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<RecyclerView>
  {
    h(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.b
 * JD-Core Version:    0.7.0.1
 */