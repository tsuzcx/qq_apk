package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.c;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "autoInitTransitionInfo", "", "(Landroid/content/Context;Z)V", "applyAllTransitionGroup", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getApplyAllTransitionGroup", "()Landroid/widget/LinearLayout;", "applyAllTransitionGroup$delegate", "Lkotlin/Lazy;", "applyAllTransitionIcon", "Landroid/widget/ImageView;", "getApplyAllTransitionIcon", "()Landroid/widget/ImageView;", "applyAllTransitionIcon$delegate", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "confirmIcon", "getConfirmIcon", "confirmIcon$delegate", "editTransitionIndex", "", "editTransitionListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "emptyHolder", "Landroid/view/View;", "getEmptyHolder", "()Landroid/view/View;", "emptyHolder$delegate", "isApplyAll", "originTransEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "selectedIndex", "selectedTransitionItem", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "transitionAdapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "transitionInfoList", "", "transitionRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getTransitionRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "transitionRecycler$delegate", "getItemOffsetLength", "initStatus", "", "transitionIndex", "order", "path", "", "initTransitionInfo", "setApplyAll", "enabled", "setEditTransitionListener", "listenerEdit", "Companion", "EditTransitionListener", "plugin-vlog_release"})
public final class b
  extends RelativeLayout
{
  @Deprecated
  public static final a NBv;
  private final f NBj;
  private final f NBk;
  private final f NBl;
  private final f NBm;
  private final f NBn;
  private final List<d> NBo;
  private final c NBp;
  private b NBq;
  private a.a NBr;
  private d NBs;
  private int NBt;
  private boolean NBu;
  private int bhr;
  private final f xRy;
  
  static
  {
    AppMethodBeat.i(225631);
    NBv = new a((byte)0);
    AppMethodBeat.o(225631);
  }
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(225629);
    this.NBj = g.ar((kotlin.g.a.a)new d(this));
    this.NBk = g.ar((kotlin.g.a.a)new c(this));
    this.NBl = g.ar((kotlin.g.a.a)new h(this));
    this.xRy = g.ar((kotlin.g.a.a)new e(this));
    this.NBm = g.ar((kotlin.g.a.a)new f(this));
    this.NBn = g.ar((kotlin.g.a.a)new g(this));
    this.NBo = ((List)new ArrayList());
    this.NBs = new d();
    LayoutInflater.from(paramContext).inflate(a.g.editor_edit_transition_view, (ViewGroup)this, true);
    this.NBp = new c(this.NBo);
    setOnClickListener((View.OnClickListener)1.NBw);
    if (paramBoolean) {
      gwt();
    }
    setApplyAll(this.NBu);
    Object localObject = this.NBp;
    c.d locald = (c.d)new c.d()
    {
      public final void a(d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(232597);
        p.k(paramAnonymousd, "item");
        if (!paramAnonymousd.xUg)
        {
          b.a(this.NBx).xUg = false;
          b.b(this.NBx).d(b.c(this.NBx), new Object());
          paramAnonymousd.xUg = true;
          b.b(this.NBx).d(paramAnonymousInt, new Object());
          b.a(this.NBx, paramAnonymousInt);
          b.a(this.NBx, paramAnonymousd);
          paramAnonymousd = b.d(this.NBx);
          if (paramAnonymousd != null)
          {
            paramAnonymousd.b(b.e(this.NBx), b.a(this.NBx).NBH);
            AppMethodBeat.o(232597);
            return;
          }
        }
        AppMethodBeat.o(232597);
      }
    };
    p.k(locald, "listener");
    ((c)localObject).NBy = locald;
    localObject = getTransitionRecycler();
    p.j(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    localObject = getTransitionRecycler();
    p.j(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.NBp);
    localObject = getTransitionRecycler();
    p.j(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setItemAnimator(null);
    int i = getItemOffsetLength();
    getTransitionRecycler().b((RecyclerView.h)new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(229086);
        p.k(paramAnonymousRect, "outRect");
        p.k(paramAnonymousView, "view");
        p.k(paramAnonymousRecyclerView, "parent");
        p.k(paramAnonymouss, "state");
        super.a(paramAnonymousRect, paramAnonymousView, paramAnonymousRecyclerView, paramAnonymouss);
        paramAnonymousRect.left = this.jFk;
        paramAnonymousRect.right = this.jFk;
        AppMethodBeat.o(229086);
      }
    });
    getApplyAllTransitionGroup().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231435);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.NBx;
        if (!b.f(this.NBx)) {}
        for (boolean bool = true;; bool = false)
        {
          b.a(paramAnonymousView, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(231435);
          return;
        }
      }
    });
    getCloseIcon().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(230151);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((p.h(b.g(this.NBx), b.a(this.NBx).NBH) ^ true))
        {
          paramAnonymousView = b.d(this.NBx);
          if (paramAnonymousView != null) {
            paramAnonymousView.b(b.e(this.NBx), b.g(this.NBx));
          }
        }
        paramAnonymousView = b.d(this.NBx);
        if (paramAnonymousView != null) {
          paramAnonymousView.onClose();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230151);
      }
    });
    getConfirmIcon().setImageDrawable(au.o(paramContext, a.h.icons_outlined_done, paramContext.getResources().getColor(a.c.Orange)));
    getConfirmIcon().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231838);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (b.f(this.NBx))
        {
          paramAnonymousView = b.d(this.NBx);
          if (paramAnonymousView != null) {
            paramAnonymousView.a(b.e(this.NBx), b.a(this.NBx).NBH);
          }
        }
        paramAnonymousView = b.d(this.NBx);
        if (paramAnonymousView != null) {
          paramAnonymousView.onClose();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231838);
      }
    });
    AppMethodBeat.o(225629);
  }
  
  private final LinearLayout getApplyAllTransitionGroup()
  {
    AppMethodBeat.i(225598);
    LinearLayout localLinearLayout = (LinearLayout)this.NBk.getValue();
    AppMethodBeat.o(225598);
    return localLinearLayout;
  }
  
  private final ImageView getApplyAllTransitionIcon()
  {
    AppMethodBeat.i(225596);
    ImageView localImageView = (ImageView)this.NBj.getValue();
    AppMethodBeat.o(225596);
    return localImageView;
  }
  
  private final WeImageView getCloseIcon()
  {
    AppMethodBeat.i(225600);
    WeImageView localWeImageView = (WeImageView)this.xRy.getValue();
    AppMethodBeat.o(225600);
    return localWeImageView;
  }
  
  private final ImageView getConfirmIcon()
  {
    AppMethodBeat.i(225601);
    ImageView localImageView = (ImageView)this.NBm.getValue();
    AppMethodBeat.o(225601);
    return localImageView;
  }
  
  private final View getEmptyHolder()
  {
    AppMethodBeat.i(225602);
    View localView = (View)this.NBn.getValue();
    AppMethodBeat.o(225602);
    return localView;
  }
  
  private final int getItemOffsetLength()
  {
    AppMethodBeat.i(225606);
    int i = com.tencent.mm.ci.a.kr(getContext()) - com.tencent.mm.ci.a.fromDPToPix(getContext(), 26.0F);
    int j = com.tencent.mm.ci.a.aY(getContext(), a.d.Edge_8A);
    int m = i * 10 / j;
    int k = m % 10;
    m /= 10;
    if (k > 7)
    {
      i = (i - (int)(j / 2 * (m + 1.5F))) / ((m + 1) * 2 + 1);
      AppMethodBeat.o(225606);
      return i;
    }
    if (k < 2)
    {
      i = (i - (int)(j / 2 * (m + 0.5F))) / (m * 2 + 1);
      AppMethodBeat.o(225606);
      return i;
    }
    i = j / 4;
    AppMethodBeat.o(225606);
    return i;
  }
  
  private final RecyclerView getTransitionRecycler()
  {
    AppMethodBeat.i(225599);
    RecyclerView localRecyclerView = (RecyclerView)this.NBl.getValue();
    AppMethodBeat.o(225599);
    return localRecyclerView;
  }
  
  private final void setApplyAll(boolean paramBoolean)
  {
    AppMethodBeat.i(225619);
    this.NBu = paramBoolean;
    ImageView localImageView = getApplyAllTransitionIcon();
    Context localContext = getContext();
    if (this.NBu) {}
    for (int i = a.h.ui_rescoures_checkbox_selected;; i = a.h.ui_rescoures_checkbox_unselected)
    {
      localImageView.setImageDrawable(au.o(localContext, i, Color.parseColor("#CCFFFFFF")));
      AppMethodBeat.o(225619);
      return;
    }
  }
  
  public final void gwt()
  {
    AppMethodBeat.i(225617);
    this.NBo.clear();
    this.NBo.add(new d());
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    localObject = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.gtJ()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      this.NBo.add(new d(locala));
    }
    Log.i("MicroMsg.EditorEditTransitionView", "initTransitionInfo: size:" + this.NBo.size());
    this.bhr = 0;
    this.NBs = ((d)j.lo(this.NBo));
    if (this.NBo.size() <= 1)
    {
      localObject = getEmptyHolder();
      p.j(localObject, "emptyHolder");
      ((View)localObject).setVisibility(0);
      localObject = getApplyAllTransitionGroup();
      p.j(localObject, "applyAllTransitionGroup");
      ((LinearLayout)localObject).setVisibility(4);
      localObject = getTransitionRecycler();
      p.j(localObject, "transitionRecycler");
      ((RecyclerView)localObject).setVisibility(4);
      localObject = com.tencent.mm.plugin.vlog.model.local.a.Nol;
      com.tencent.mm.plugin.vlog.model.local.a.h(new WeakReference(this));
      AppMethodBeat.o(225617);
      return;
    }
    localObject = getEmptyHolder();
    p.j(localObject, "emptyHolder");
    ((View)localObject).setVisibility(4);
    localObject = getApplyAllTransitionGroup();
    p.j(localObject, "applyAllTransitionGroup");
    ((LinearLayout)localObject).setVisibility(0);
    localObject = getTransitionRecycler();
    p.j(localObject, "transitionRecycler");
    ((RecyclerView)localObject).setVisibility(0);
    this.NBp.notifyDataSetChanged();
    AppMethodBeat.o(225617);
  }
  
  public final void kL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225614);
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    Object localObject2 = ((Iterable)com.tencent.mm.plugin.vlog.model.local.a.gtJ()).iterator();
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
        this.NBr = ((a.a)localObject1);
        this.NBt = paramInt1;
        this.NBs.xUg = false;
        this.NBp.cL(this.bhr);
        localObject1 = this.NBo.iterator();
        paramInt1 = 0;
        label107:
        if (!((Iterator)localObject1).hasNext()) {
          break label304;
        }
        if (!p.h(((d)((Iterator)localObject1).next()).NBH, this.NBr)) {
          break label297;
        }
      }
    }
    for (;;)
    {
      this.bhr = paramInt1;
      this.NBs = ((d)this.NBo.get(this.bhr));
      localObject1 = getTransitionRecycler();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(this.bhr, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(II)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(II)V", "Undefined", "scrollToPosition", "(I)V");
      this.NBs.xUg = true;
      this.NBp.cL(this.bhr);
      setApplyAll(false);
      AppMethodBeat.o(225614);
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
    AppMethodBeat.i(225622);
    p.k(paramb, "listenerEdit");
    this.NBq = paramb;
    AppMethodBeat.o(225622);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "", "onApplyTransitionToAll", "", "editTransitionIndex", "", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "plugin-vlog_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, a.a parama);
    
    public abstract void b(int paramInt, a.a parama);
    
    public abstract void onClose();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<View>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.b
 * JD-Core Version:    0.7.0.1
 */