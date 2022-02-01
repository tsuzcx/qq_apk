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
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applyAllTransitionGroup", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getApplyAllTransitionGroup", "()Landroid/widget/LinearLayout;", "applyAllTransitionGroup$delegate", "Lkotlin/Lazy;", "applyAllTransitionIcon", "Landroid/widget/ImageView;", "getApplyAllTransitionIcon", "()Landroid/widget/ImageView;", "applyAllTransitionIcon$delegate", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "confirmIcon", "getConfirmIcon", "confirmIcon$delegate", "editTransitionIndex", "", "editTransitionListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "emptyHolder", "Landroid/view/View;", "getEmptyHolder", "()Landroid/view/View;", "emptyHolder$delegate", "isApplyAll", "", "originTransEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "selectedIndex", "selectedTransitionItem", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "transitionAdapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "transitionInfoList", "", "transitionRecycler", "Landroid/support/v7/widget/RecyclerView;", "getTransitionRecycler", "()Landroid/support/v7/widget/RecyclerView;", "transitionRecycler$delegate", "getItemOffsetLength", "initStatus", "", "transitionIndex", "effectId", "", "initTransitionInfo", "setApplyAll", "enabled", "setEditTransitionListener", "listenerEdit", "Companion", "EditTransitionListener", "plugin-vlog_release"})
public final class b
  extends RelativeLayout
{
  @Deprecated
  public static final a BTl;
  private final f BSZ;
  private final f BTa;
  private final f BTb;
  private final f BTc;
  private final f BTd;
  private final List<d> BTe;
  private final c BTf;
  private b BTg;
  private a.a BTh;
  private d BTi;
  private int BTj;
  private boolean BTk;
  private int bxN;
  private final f xKJ;
  
  static
  {
    AppMethodBeat.i(196794);
    BTl = new a((byte)0);
    AppMethodBeat.o(196794);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(196793);
    this.BSZ = g.O((d.g.a.a)new d(this));
    this.BTa = g.O((d.g.a.a)new c(this));
    this.BTb = g.O((d.g.a.a)new h(this));
    this.xKJ = g.O((d.g.a.a)new e(this));
    this.BTc = g.O((d.g.a.a)new f(this));
    this.BTd = g.O((d.g.a.a)new g(this));
    this.BTe = ((List)new ArrayList());
    this.BTi = new d();
    LayoutInflater.from(paramContext).inflate(2131496448, (ViewGroup)this, true);
    setOnClickListener((View.OnClickListener)1.OdJ);
    eub();
    setApplyAll(this.BTk);
    this.BTf = new c(this.BTe);
    Object localObject = this.BTf;
    c.d locald = (c.d)new c.d()
    {
      public final void a(d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(221631);
        p.h(paramAnonymousd, "item");
        if (!paramAnonymousd.tfH)
        {
          b.a(this.BTm).tfH = false;
          b.b(this.BTm).b(b.c(this.BTm), new Object());
          paramAnonymousd.tfH = true;
          b.b(this.BTm).b(paramAnonymousInt, new Object());
          b.a(this.BTm, paramAnonymousInt);
          b.a(this.BTm, paramAnonymousd);
          paramAnonymousd = b.d(this.BTm);
          if (paramAnonymousd != null)
          {
            paramAnonymousd.b(b.e(this.BTm), b.a(this.BTm).BTw);
            AppMethodBeat.o(221631);
            return;
          }
        }
        AppMethodBeat.o(221631);
      }
    };
    p.h(locald, "listener");
    ((c)localObject).BTn = locald;
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager(0));
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.BTf);
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setItemAnimator(null);
    int i = getItemOffsetLength();
    getTransitionRecycler().b((RecyclerView.h)new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
      {
        AppMethodBeat.i(221632);
        p.h(paramAnonymousRect, "outRect");
        p.h(paramAnonymousView, "view");
        p.h(paramAnonymousRecyclerView, "parent");
        p.h(paramAnonymoust, "state");
        super.a(paramAnonymousRect, paramAnonymousView, paramAnonymousRecyclerView, paramAnonymoust);
        paramAnonymousRect.left = this.Bgd;
        paramAnonymousRect.right = this.Bgd;
        AppMethodBeat.o(221632);
      }
    });
    getApplyAllTransitionGroup().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196774);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BTm;
        if (!b.f(this.BTm)) {}
        for (boolean bool = true;; bool = false)
        {
          b.a(paramAnonymousView, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(196774);
          return;
        }
      }
    });
    getCloseIcon().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196775);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((p.i(b.g(this.BTm), b.a(this.BTm).BTw) ^ true))
        {
          paramAnonymousView = b.d(this.BTm);
          if (paramAnonymousView != null) {
            paramAnonymousView.b(b.e(this.BTm), b.g(this.BTm));
          }
        }
        paramAnonymousView = b.d(this.BTm);
        if (paramAnonymousView != null) {
          paramAnonymousView.onClose();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196775);
      }
    });
    getConfirmIcon().setImageDrawable(ao.k(paramContext, 2131690558, paramContext.getResources().getColor(2131099777)));
    getConfirmIcon().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(221633);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (b.f(this.BTm))
        {
          paramAnonymousView = b.d(this.BTm);
          if (paramAnonymousView != null) {
            paramAnonymousView.a(b.e(this.BTm), b.a(this.BTm).BTw);
          }
        }
        paramAnonymousView = b.d(this.BTm);
        if (paramAnonymousView != null) {
          paramAnonymousView.onClose();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(221633);
      }
    });
    AppMethodBeat.o(196793);
  }
  
  private final LinearLayout getApplyAllTransitionGroup()
  {
    AppMethodBeat.i(196783);
    LinearLayout localLinearLayout = (LinearLayout)this.BTa.getValue();
    AppMethodBeat.o(196783);
    return localLinearLayout;
  }
  
  private final ImageView getApplyAllTransitionIcon()
  {
    AppMethodBeat.i(196782);
    ImageView localImageView = (ImageView)this.BSZ.getValue();
    AppMethodBeat.o(196782);
    return localImageView;
  }
  
  private final WeImageView getCloseIcon()
  {
    AppMethodBeat.i(196785);
    WeImageView localWeImageView = (WeImageView)this.xKJ.getValue();
    AppMethodBeat.o(196785);
    return localWeImageView;
  }
  
  private final ImageView getConfirmIcon()
  {
    AppMethodBeat.i(196786);
    ImageView localImageView = (ImageView)this.BTc.getValue();
    AppMethodBeat.o(196786);
    return localImageView;
  }
  
  private final View getEmptyHolder()
  {
    AppMethodBeat.i(196787);
    View localView = (View)this.BTd.getValue();
    AppMethodBeat.o(196787);
    return localView;
  }
  
  private final int getItemOffsetLength()
  {
    AppMethodBeat.i(196788);
    int i = com.tencent.mm.cc.a.ip(getContext()) - com.tencent.mm.cc.a.g(getContext(), 26.0F);
    int j = com.tencent.mm.cc.a.ax(getContext(), 2131165301);
    int m = i * 10 / j;
    int k = m % 10;
    m /= 10;
    if (k > 7)
    {
      i = (i - (int)(j / 2 * (m + 1.5F))) / ((m + 1) * 2 + 1);
      AppMethodBeat.o(196788);
      return i;
    }
    if (k < 2)
    {
      i = (i - (int)(j / 2 * (m + 0.5F))) / (m * 2 + 1);
      AppMethodBeat.o(196788);
      return i;
    }
    i = j / 4;
    AppMethodBeat.o(196788);
    return i;
  }
  
  private final RecyclerView getTransitionRecycler()
  {
    AppMethodBeat.i(196784);
    RecyclerView localRecyclerView = (RecyclerView)this.BTb.getValue();
    AppMethodBeat.o(196784);
    return localRecyclerView;
  }
  
  private final void setApplyAll(boolean paramBoolean)
  {
    AppMethodBeat.i(196791);
    this.BTk = paramBoolean;
    ImageView localImageView = getApplyAllTransitionIcon();
    Context localContext = getContext();
    if (this.BTk) {}
    for (int i = 2131691343;; i = 2131691344)
    {
      localImageView.setImageDrawable(ao.k(localContext, i, Color.parseColor("#CCFFFFFF")));
      AppMethodBeat.o(196791);
      return;
    }
  }
  
  public final void aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(196789);
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.BHu;
    Object localObject2 = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.ess()).iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((a.a)localObject1).xPg == paramLong)
      {
        i = 1;
        label59:
        if (i == 0) {
          break label293;
        }
        label64:
        this.BTh = ((a.a)localObject1);
        this.BTj = paramInt;
        this.BTi.tfH = false;
        this.BTf.cj(this.bxN);
        localObject1 = this.BTe.iterator();
        paramInt = 0;
        label110:
        if (!((Iterator)localObject1).hasNext()) {
          break label308;
        }
        if (!p.i(((d)((Iterator)localObject1).next()).BTw, this.BTh)) {
          break label301;
        }
      }
    }
    for (;;)
    {
      this.bxN = paramInt;
      this.BTi = ((d)this.BTe.get(this.bxN));
      localObject1 = getTransitionRecycler();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(this.bxN, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(IJ)V", "Undefined", "scrollToPosition", "(I)V");
      this.BTi.tfH = true;
      this.BTf.cj(this.bxN);
      setApplyAll(false);
      AppMethodBeat.o(196789);
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
  
  public final void eub()
  {
    AppMethodBeat.i(196790);
    this.BTe.clear();
    this.BTe.add(new d());
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.BHu;
    localObject = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.ess()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      this.BTe.add(new d(locala));
    }
    ad.i("MicroMsg.EditorEditTransitionView", "initTransitionInfo: size:" + this.BTe.size());
    this.bxN = 0;
    this.BTi = ((d)j.jc(this.BTe));
    if (this.BTe.size() <= 1)
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
      localObject = com.tencent.mm.plugin.vlog.model.local.a.BHu;
      com.tencent.mm.plugin.vlog.model.local.a.d(new WeakReference(this));
      AppMethodBeat.o(196790);
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
    AppMethodBeat.o(196790);
  }
  
  public final void setEditTransitionListener(b paramb)
  {
    AppMethodBeat.i(196792);
    p.h(paramb, "listenerEdit");
    this.BTg = paramb;
    AppMethodBeat.o(196792);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "", "onApplyTransitionToAll", "", "editTransitionIndex", "", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "plugin-vlog_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, a.a parama);
    
    public abstract void b(int paramInt, a.a parama);
    
    public abstract void onClose();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<LinearLayout>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<ImageView>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<WeImageView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<ImageView>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<View>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
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