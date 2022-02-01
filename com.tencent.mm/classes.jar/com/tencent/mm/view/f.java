package com.tencent.mm.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"exposedDataSet", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/view/ExposedData;", "Lkotlin/collections/HashMap;", "uiHandler", "Landroid/os/Handler;", "addExposedData", "", "key", "data", "removeExposedData", "getExposedInfo", "Landroid/view/View;", "setOnRecyclerViewChildExposedListener", "Landroidx/recyclerview/widget/RecyclerView;", "listener", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "setOnViewExposedListener", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "setOnViewGroupChildExposedListener", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "libmmui_release"})
public final class f
{
  private static final HashMap<Integer, g> YKC;
  private static final Handler cQo;
  
  static
  {
    AppMethodBeat.i(203130);
    cQo = new Handler(Looper.getMainLooper());
    YKC = new HashMap();
    AppMethodBeat.o(203130);
  }
  
  public static final void a(View paramView, final e.b paramb)
  {
    AppMethodBeat.i(203123);
    p.k(paramView, "$this$setOnViewExposedListener");
    cQo.post((Runnable)new c(paramView, paramb));
    AppMethodBeat.o(203123);
  }
  
  public static final void a(ViewGroup paramViewGroup, final e.c paramc)
  {
    AppMethodBeat.i(203125);
    p.k(paramViewGroup, "$this$setOnViewGroupChildExposedListener");
    cQo.post((Runnable)new d(paramViewGroup, paramc));
    AppMethodBeat.o(203125);
  }
  
  public static final void a(RecyclerView paramRecyclerView, final e.a parama)
  {
    AppMethodBeat.i(203127);
    p.k(paramRecyclerView, "$this$setOnRecyclerViewChildExposedListener");
    cQo.post((Runnable)new b(paramRecyclerView, parama));
    AppMethodBeat.o(203127);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/ExposeElvesKt$addExposedData$attachStateChangeListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "libmmui_release"})
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    a(g paramg) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(223484);
      p.k(paramView, "v");
      if (p.h(this.YKD.view, paramView)) {
        f.a(paramView.hashCode(), this.YKD);
      }
      AppMethodBeat.o(223484);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(223487);
      p.k(paramView, "v");
      if (p.h(this.YKD.view, paramView))
      {
        f.azm(paramView.hashCode());
        Object localObject = this.YKD.YKP;
        if (localObject != null) {
          ((e.b)localObject).p(paramView, false);
        }
        localObject = this.YKD.YKQ;
        if (localObject != null)
        {
          ((e.c)localObject).b(paramView, (List)v.aaAd);
          AppMethodBeat.o(223487);
          return;
        }
      }
      AppMethodBeat.o(223487);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RecyclerView paramRecyclerView, e.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(214249);
      if (parama == null)
      {
        f.a((ViewGroup)this.YKE, null);
        localObject1 = this.YKE.getTag(a.g.expose_elves_scroll_listener);
        if (localObject1 != null)
        {
          if ((localObject1 instanceof RecyclerView.l)) {
            this.YKE.b((RecyclerView.l)localObject1);
          }
          AppMethodBeat.o(214249);
          return;
        }
        AppMethodBeat.o(214249);
        return;
      }
      Object localObject1 = new aa.d();
      ((aa.d)localObject1).aaBA = 0;
      final boolean bool = parama.dpC();
      Object localObject2 = this.YKE.getTag(a.g.expose_elves_scroll_listener);
      if ((localObject2 != null) && ((localObject2 instanceof RecyclerView.l))) {
        this.YKE.b((RecyclerView.l)localObject2);
      }
      localObject2 = new f.b.a((aa.d)localObject1);
      this.YKE.a((RecyclerView.l)localObject2);
      this.YKE.setTag(a.g.expose_elves_scroll_listener, localObject2);
      f.a((ViewGroup)this.YKE, (e.c)new e.c()
      {
        public final void b(View paramAnonymousView, List<? extends View> paramAnonymousList)
        {
          AppMethodBeat.i(200307);
          p.k(paramAnonymousView, "parent");
          p.k(paramAnonymousList, "exposedChildren");
          paramAnonymousView = new LinkedList();
          paramAnonymousList = ((Iterable)paramAnonymousList).iterator();
          while (paramAnonymousList.hasNext())
          {
            Object localObject = (View)paramAnonymousList.next();
            localObject = this.YKG.YKE.bf((View)localObject);
            if (localObject != null) {
              paramAnonymousView.add(localObject);
            }
          }
          this.YKG.YKF.b((View)this.YKG.YKE, (List)paramAnonymousView);
          AppMethodBeat.o(200307);
        }
        
        public final long er(View paramAnonymousView)
        {
          AppMethodBeat.i(200311);
          p.k(paramAnonymousView, "view");
          long l = this.YKG.YKF.af(this.YKG.YKE.bf(paramAnonymousView));
          AppMethodBeat.o(200311);
          return l;
        }
        
        public final boolean igW()
        {
          return (bool) && (this.YKI.aaBA == 2);
        }
      });
      AppMethodBeat.o(214249);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView, e.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(187665);
      if (paramb != null)
      {
        localObject = f.ja(this.YKJ);
        if (localObject != null)
        {
          ((g)localObject).YKP = paramb;
          AppMethodBeat.o(187665);
          return;
        }
        localObject = this.YKJ;
        g localg = new g(this.YKJ);
        localg.YKP = paramb;
        f.a(((View)localObject).hashCode(), localg);
        AppMethodBeat.o(187665);
        return;
      }
      Object localObject = f.ja(this.YKJ);
      if (localObject != null)
      {
        ((g)localObject).YKP = null;
        if ((((g)localObject).YKP == null) && (((g)localObject).YKQ == null))
        {
          ((g)localObject).view.removeOnAttachStateChangeListener(((g)localObject).YKO);
          f.azm(this.YKJ.hashCode());
        }
        AppMethodBeat.o(187665);
        return;
      }
      AppMethodBeat.o(187665);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ViewGroup paramViewGroup, e.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(199741);
      if (paramc != null)
      {
        localObject = f.ja((View)this.YKL);
        if (localObject != null)
        {
          ((g)localObject).YKQ = paramc;
          AppMethodBeat.o(199741);
          return;
        }
        localObject = this.YKL;
        g localg = new g((View)this.YKL);
        localg.YKQ = paramc;
        f.a(((ViewGroup)localObject).hashCode(), localg);
        AppMethodBeat.o(199741);
        return;
      }
      Object localObject = f.ja((View)this.YKL);
      if (localObject != null)
      {
        ((g)localObject).YKQ = null;
        if ((((g)localObject).YKP == null) && (((g)localObject).YKQ == null))
        {
          ((g)localObject).view.removeOnAttachStateChangeListener(((g)localObject).YKO);
          f.azm(this.YKL.hashCode());
        }
        AppMethodBeat.o(199741);
        return;
      }
      AppMethodBeat.o(199741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.f
 * JD-Core Version:    0.7.0.1
 */