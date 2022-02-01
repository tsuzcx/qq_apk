package com.tencent.mm.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"exposedDataSet", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/view/ExposedData;", "Lkotlin/collections/HashMap;", "addExposedData", "", "key", "data", "removeExposedData", "getExposedInfo", "Landroid/view/View;", "setOnRecyclerViewChildExposedListener", "Landroid/support/v7/widget/RecyclerView;", "listener", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "setOnViewExposedListener", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "setOnViewGroupChildExposedListener", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "libmmui_release"})
public final class f
{
  private static final HashMap<Integer, g> RiU;
  
  static
  {
    AppMethodBeat.i(204942);
    RiU = new HashMap();
    AppMethodBeat.o(204942);
  }
  
  private static final void a(int paramInt, g paramg)
  {
    AppMethodBeat.i(204937);
    if (!RiU.containsKey(Integer.valueOf(paramInt)))
    {
      ((Map)RiU).put(Integer.valueOf(paramInt), paramg);
      Object localObject = new a(paramg);
      if (paramg.view.getTag(2131300237) == null)
      {
        paramg.view.setTag(2131300237, localObject);
        paramg.view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)localObject);
      }
      localObject = paramg.view.getTag(2131300237);
      if (localObject == null)
      {
        paramg = new t("null cannot be cast to non-null type android.view.View.OnAttachStateChangeListener");
        AppMethodBeat.o(204937);
        throw paramg;
      }
      paramg.Rjb = ((View.OnAttachStateChangeListener)localObject);
      paramg = e.RiQ;
      e.apM(RiU.size());
    }
    AppMethodBeat.o(204937);
  }
  
  public static final void a(RecyclerView paramRecyclerView, final e.a parama)
  {
    AppMethodBeat.i(204941);
    p.h(paramRecyclerView, "$this$setOnRecyclerViewChildExposedListener");
    final z.d locald = new z.d();
    locald.SYE = 0;
    Object localObject = paramRecyclerView.getTag(2131300238);
    if ((localObject != null) && ((localObject instanceof RecyclerView.l))) {
      paramRecyclerView.b((RecyclerView.l)localObject);
    }
    localObject = new c(locald);
    paramRecyclerView.a((RecyclerView.l)localObject);
    paramRecyclerView.setTag(2131300238, localObject);
    localObject = (ViewGroup)paramRecyclerView;
    paramRecyclerView = (e.c)new b(paramRecyclerView, parama, true, locald);
    p.h(localObject, "$this$setOnViewGroupChildExposedListener");
    parama = hF((View)localObject);
    if (parama != null)
    {
      parama.Rjd = paramRecyclerView;
      AppMethodBeat.o(204941);
      return;
    }
    parama = new g((View)localObject);
    parama.Rjd = paramRecyclerView;
    a(((ViewGroup)localObject).hashCode(), parama);
    AppMethodBeat.o(204941);
  }
  
  public static final void a(View paramView, e.b paramb)
  {
    AppMethodBeat.i(204940);
    p.h(paramView, "$this$setOnViewExposedListener");
    if (paramb != null)
    {
      g localg = hF(paramView);
      if (localg != null)
      {
        localg.Rjc = paramb;
        AppMethodBeat.o(204940);
        return;
      }
      localg = new g(paramView);
      localg.Rjc = paramb;
      a(paramView.hashCode(), localg);
      AppMethodBeat.o(204940);
      return;
    }
    paramb = hF(paramView);
    if (paramb != null)
    {
      paramb.Rjc = null;
      if ((paramb.Rjc == null) && (paramb.Rjd == null))
      {
        paramb.view.removeOnAttachStateChangeListener(paramb.Rjb);
        apN(paramView.hashCode());
      }
      AppMethodBeat.o(204940);
      return;
    }
    AppMethodBeat.o(204940);
  }
  
  private static final g apN(int paramInt)
  {
    AppMethodBeat.i(204938);
    g localg = (g)RiU.remove(Integer.valueOf(paramInt));
    if (localg != null)
    {
      localg.Rja = -1L;
      localg.Rjb = null;
    }
    e locale = e.RiQ;
    e.apM(RiU.size());
    AppMethodBeat.o(204938);
    return localg;
  }
  
  private static final g hF(View paramView)
  {
    AppMethodBeat.i(204939);
    paramView = (g)RiU.get(Integer.valueOf(paramView.hashCode()));
    AppMethodBeat.o(204939);
    return paramView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/ExposeElvesKt$addExposedData$attachStateChangeListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "libmmui_release"})
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    a(g paramg) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(204931);
      p.h(paramView, "v");
      if (p.j(this.RiV.view, paramView)) {
        f.b(paramView.hashCode(), this.RiV);
      }
      AppMethodBeat.o(204931);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(204932);
      p.h(paramView, "v");
      if (p.j(this.RiV.view, paramView))
      {
        f.apO(paramView.hashCode());
        Object localObject = this.RiV.Rjc;
        if (localObject != null) {
          ((e.b)localObject).p(paramView, false);
        }
        localObject = this.RiV.Rjd;
        if (localObject != null)
        {
          ((e.c)localObject).b(paramView, (List)v.SXr);
          AppMethodBeat.o(204932);
          return;
        }
      }
      AppMethodBeat.o(204932);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$3", "Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "ignoreExposeChanged", "", "onChildExposeChanged", "", "parent", "exposedChildren", "", "libmmui_release"})
  public static final class b
    extends e.c
  {
    b(RecyclerView paramRecyclerView, e.a parama, boolean paramBoolean, z.d paramd) {}
    
    public final void b(View paramView, List<? extends View> paramList)
    {
      AppMethodBeat.i(204933);
      p.h(paramView, "parent");
      p.h(paramList, "exposedChildren");
      paramView = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject = (View)paramList.next();
        localObject = this.RiW.bu((View)localObject);
        if (localObject != null) {
          paramView.add(localObject);
        }
      }
      parama.b((View)this.RiW, (List)paramView);
      AppMethodBeat.o(204933);
    }
    
    public final long hE(View paramView)
    {
      AppMethodBeat.i(204934);
      p.h(paramView, "view");
      System.nanoTime();
      long l = parama.ae(this.RiW.bu(paramView));
      AppMethodBeat.o(204934);
      return l;
    }
    
    public final boolean hfA()
    {
      return (this.RiY) && (locald.SYE == 2);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "libmmui_release"})
  public static final class c
    extends RecyclerView.l
  {
    c(z.d paramd) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(204935);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      a.b("com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      this.RiZ.SYE = paramInt;
      a.a(this, "com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(204935);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204936);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      a.b("com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/view/ExposeElvesKt$setOnRecyclerViewChildExposedListener$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(204936);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.f
 * JD-Core Version:    0.7.0.1
 */