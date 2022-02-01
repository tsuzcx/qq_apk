package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applyAllTransitionGroup", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getApplyAllTransitionGroup", "()Landroid/widget/LinearLayout;", "applyAllTransitionGroup$delegate", "Lkotlin/Lazy;", "applyAllTransitionIcon", "Landroid/widget/ImageView;", "getApplyAllTransitionIcon", "()Landroid/widget/ImageView;", "applyAllTransitionIcon$delegate", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "confirmIcon", "getConfirmIcon", "confirmIcon$delegate", "editTransitionIndex", "", "editTransitionListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "emptyHolder", "Landroid/view/View;", "getEmptyHolder", "()Landroid/view/View;", "emptyHolder$delegate", "isApplyAll", "", "originTransEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "selectedIndex", "selectedTransitionItem", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "transitionAdapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "transitionInfoList", "", "transitionRecycler", "Landroid/support/v7/widget/RecyclerView;", "getTransitionRecycler", "()Landroid/support/v7/widget/RecyclerView;", "transitionRecycler$delegate", "getItemOffsetLength", "initStatus", "", "transitionIndex", "order", "initTransitionInfo", "setApplyAll", "enabled", "setEditTransitionListener", "listenerEdit", "Companion", "EditTransitionListener", "plugin-vlog_release"})
public final class b
  extends RelativeLayout
{
  @Deprecated
  public static final a GNN;
  private final f GNB;
  private final f GNC;
  private final f GND;
  private final f GNE;
  private final f GNF;
  private final List<d> GNG;
  private final c GNH;
  private b GNI;
  private a.a GNJ;
  private d GNK;
  private int GNL;
  private boolean GNM;
  private int bxP;
  private final f udQ;
  
  static
  {
    AppMethodBeat.i(191996);
    GNN = new a((byte)0);
    AppMethodBeat.o(191996);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(191995);
    this.GNB = g.ah((kotlin.g.a.a)new d(this));
    this.GNC = g.ah((kotlin.g.a.a)new c(this));
    this.GND = g.ah((kotlin.g.a.a)new h(this));
    this.udQ = g.ah((kotlin.g.a.a)new e(this));
    this.GNE = g.ah((kotlin.g.a.a)new f(this));
    this.GNF = g.ah((kotlin.g.a.a)new g(this));
    this.GNG = ((List)new ArrayList());
    this.GNK = new d();
    LayoutInflater.from(paramContext).inflate(2131493882, (ViewGroup)this, true);
    setOnClickListener((View.OnClickListener)1.GNO);
    fEs();
    setApplyAll(this.GNM);
    this.GNH = new c(this.GNG);
    Object localObject = this.GNH;
    c.d locald = (c.d)new c.d()
    {
      public final void a(d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(191973);
        p.h(paramAnonymousd, "item");
        if (!paramAnonymousd.uOQ)
        {
          b.a(this.GNP).uOQ = false;
          b.b(this.GNP).b(b.c(this.GNP), new Object());
          paramAnonymousd.uOQ = true;
          b.b(this.GNP).b(paramAnonymousInt, new Object());
          b.a(this.GNP, paramAnonymousInt);
          b.a(this.GNP, paramAnonymousd);
          paramAnonymousd = b.d(this.GNP);
          if (paramAnonymousd != null)
          {
            paramAnonymousd.b(b.e(this.GNP), b.a(this.GNP).GNZ);
            AppMethodBeat.o(191973);
            return;
          }
        }
        AppMethodBeat.o(191973);
      }
    };
    p.h(locald, "listener");
    ((c)localObject).GNQ = locald;
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.GNH);
    localObject = getTransitionRecycler();
    p.g(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setItemAnimator(null);
    int i = getItemOffsetLength();
    getTransitionRecycler().b((RecyclerView.h)new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(191974);
        p.h(paramAnonymousRect, "outRect");
        p.h(paramAnonymousView, "view");
        p.h(paramAnonymousRecyclerView, "parent");
        p.h(paramAnonymouss, "state");
        super.a(paramAnonymousRect, paramAnonymousView, paramAnonymousRecyclerView, paramAnonymouss);
        paramAnonymousRect.left = this.gUs;
        paramAnonymousRect.right = this.gUs;
        AppMethodBeat.o(191974);
      }
    });
    getApplyAllTransitionGroup().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191975);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.GNP;
        if (!b.f(this.GNP)) {}
        for (boolean bool = true;; bool = false)
        {
          b.a(paramAnonymousView, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191975);
          return;
        }
      }
    });
    getCloseIcon().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191976);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((p.j(b.g(this.GNP), b.a(this.GNP).GNZ) ^ true))
        {
          paramAnonymousView = b.d(this.GNP);
          if (paramAnonymousView != null) {
            paramAnonymousView.b(b.e(this.GNP), b.g(this.GNP));
          }
        }
        paramAnonymousView = b.d(this.GNP);
        if (paramAnonymousView != null) {
          paramAnonymousView.onClose();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191976);
      }
    });
    getConfirmIcon().setImageDrawable(ar.m(paramContext, 2131690787, paramContext.getResources().getColor(2131099792)));
    getConfirmIcon().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191977);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (b.f(this.GNP))
        {
          paramAnonymousView = b.d(this.GNP);
          if (paramAnonymousView != null) {
            paramAnonymousView.a(b.e(this.GNP), b.a(this.GNP).GNZ);
          }
        }
        paramAnonymousView = b.d(this.GNP);
        if (paramAnonymousView != null) {
          paramAnonymousView.onClose();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191977);
      }
    });
    AppMethodBeat.o(191995);
  }
  
  private final LinearLayout getApplyAllTransitionGroup()
  {
    AppMethodBeat.i(191985);
    LinearLayout localLinearLayout = (LinearLayout)this.GNC.getValue();
    AppMethodBeat.o(191985);
    return localLinearLayout;
  }
  
  private final ImageView getApplyAllTransitionIcon()
  {
    AppMethodBeat.i(191984);
    ImageView localImageView = (ImageView)this.GNB.getValue();
    AppMethodBeat.o(191984);
    return localImageView;
  }
  
  private final WeImageView getCloseIcon()
  {
    AppMethodBeat.i(191987);
    WeImageView localWeImageView = (WeImageView)this.udQ.getValue();
    AppMethodBeat.o(191987);
    return localWeImageView;
  }
  
  private final ImageView getConfirmIcon()
  {
    AppMethodBeat.i(191988);
    ImageView localImageView = (ImageView)this.GNE.getValue();
    AppMethodBeat.o(191988);
    return localImageView;
  }
  
  private final View getEmptyHolder()
  {
    AppMethodBeat.i(191989);
    View localView = (View)this.GNF.getValue();
    AppMethodBeat.o(191989);
    return localView;
  }
  
  private final int getItemOffsetLength()
  {
    AppMethodBeat.i(191990);
    int i = com.tencent.mm.cb.a.jn(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 26.0F);
    int j = com.tencent.mm.cb.a.aG(getContext(), 2131165312);
    int m = i * 10 / j;
    int k = m % 10;
    m /= 10;
    if (k > 7)
    {
      i = (i - (int)(j / 2 * (m + 1.5F))) / ((m + 1) * 2 + 1);
      AppMethodBeat.o(191990);
      return i;
    }
    if (k < 2)
    {
      i = (i - (int)(j / 2 * (m + 0.5F))) / (m * 2 + 1);
      AppMethodBeat.o(191990);
      return i;
    }
    i = j / 4;
    AppMethodBeat.o(191990);
    return i;
  }
  
  private final RecyclerView getTransitionRecycler()
  {
    AppMethodBeat.i(191986);
    RecyclerView localRecyclerView = (RecyclerView)this.GND.getValue();
    AppMethodBeat.o(191986);
    return localRecyclerView;
  }
  
  private final void setApplyAll(boolean paramBoolean)
  {
    AppMethodBeat.i(191993);
    this.GNM = paramBoolean;
    ImageView localImageView = getApplyAllTransitionIcon();
    Context localContext = getContext();
    if (this.GNM) {}
    for (int i = 2131691675;; i = 2131691676)
    {
      localImageView.setImageDrawable(ar.m(localContext, i, Color.parseColor("#CCFFFFFF")));
      AppMethodBeat.o(191993);
      return;
    }
  }
  
  public final void fEs()
  {
    AppMethodBeat.i(191992);
    this.GNG.clear();
    this.GNG.add(new d());
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    localObject = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.fBM()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      this.GNG.add(new d(locala));
    }
    Log.i("MicroMsg.EditorEditTransitionView", "initTransitionInfo: size:" + this.GNG.size());
    this.bxP = 0;
    this.GNK = ((d)j.ks(this.GNG));
    if (this.GNG.size() <= 1)
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
      localObject = com.tencent.mm.plugin.vlog.model.local.a.GAD;
      com.tencent.mm.plugin.vlog.model.local.a.i(new WeakReference(this));
      AppMethodBeat.o(191992);
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
    AppMethodBeat.o(191992);
  }
  
  public final void jy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191991);
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    Object localObject2 = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.fBM()).iterator();
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
        this.GNJ = ((a.a)localObject1);
        this.GNL = paramInt1;
        this.GNK.uOQ = false;
        this.GNH.ci(this.bxP);
        localObject1 = this.GNG.iterator();
        paramInt1 = 0;
        label107:
        if (!((Iterator)localObject1).hasNext()) {
          break label304;
        }
        if (!p.j(((d)((Iterator)localObject1).next()).GNZ, this.GNJ)) {
          break label297;
        }
      }
    }
    for (;;)
    {
      this.bxP = paramInt1;
      this.GNK = ((d)this.GNG.get(this.bxP));
      localObject1 = getTransitionRecycler();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(this.bxP, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(II)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(II)V", "Undefined", "scrollToPosition", "(I)V");
      this.GNK.uOQ = true;
      this.GNH.ci(this.bxP);
      setApplyAll(false);
      AppMethodBeat.o(191991);
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
    AppMethodBeat.i(191994);
    p.h(paramb, "listenerEdit");
    this.GNI = paramb;
    AppMethodBeat.o(191994);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "", "onApplyTransitionToAll", "", "editTransitionIndex", "", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "plugin-vlog_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, a.a parama);
    
    public abstract void b(int paramInt, a.a parama);
    
    public abstract void onClose();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<View>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    h(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.b
 * JD-Core Version:    0.7.0.1
 */