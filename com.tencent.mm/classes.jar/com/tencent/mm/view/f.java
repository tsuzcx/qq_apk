package com.tencent.mm.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"exposedDataSet", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/view/ExposedData;", "Lkotlin/collections/HashMap;", "uiHandler", "Landroid/os/Handler;", "addExposedData", "", "key", "data", "removeExposedData", "runOnUI", "call", "Lkotlin/Function0;", "getExposedInfo", "Landroid/view/View;", "setOnRecyclerViewChildExposedListener", "Landroidx/recyclerview/widget/RecyclerView;", "listener", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "setOnViewExposedListener", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "setOnViewGroupChildExposedListener", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "libmmui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final HashMap<Integer, g> agGs;
  private static final Handler eLs;
  
  static
  {
    AppMethodBeat.i(234717);
    eLs = new Handler(Looper.getMainLooper());
    agGs = new HashMap();
    AppMethodBeat.o(234717);
  }
  
  public static final void a(final View paramView, e.b paramb)
  {
    AppMethodBeat.i(234690);
    s.u(paramView, "<this>");
    bt((a)new c(paramb, paramView));
    AppMethodBeat.o(234690);
  }
  
  public static final void a(final ViewGroup paramViewGroup, e.c paramc)
  {
    AppMethodBeat.i(234694);
    s.u(paramViewGroup, "<this>");
    bt((a)new d(paramc, paramViewGroup));
    AppMethodBeat.o(234694);
  }
  
  public static final void a(RecyclerView paramRecyclerView, e.a parama)
  {
    AppMethodBeat.i(234698);
    s.u(paramRecyclerView, "<this>");
    bt((a)new f.b(parama, paramRecyclerView));
    AppMethodBeat.o(234698);
  }
  
  public static final void bt(a<ah> parama)
  {
    AppMethodBeat.i(234702);
    s.u(parama, "call");
    if (Thread.currentThread().getId() == eLs.getLooper().getThread().getId())
    {
      parama.invoke();
      AppMethodBeat.o(234702);
      return;
    }
    eLs.post(new f..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(234702);
  }
  
  private static final void cg(a parama)
  {
    AppMethodBeat.i(234704);
    s.u(parama, "$call");
    parama.invoke();
    AppMethodBeat.o(234704);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/ExposeElvesKt$addExposedData$attachStateChangeListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    a(g paramg) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(234835);
      s.u(paramView, "v");
      if (s.p(this.agGt.view, paramView))
      {
        this.agGt.agGJ = false;
        f.a(paramView.hashCode(), this.agGt);
      }
      AppMethodBeat.o(234835);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(234843);
      s.u(paramView, "v");
      if (s.p(this.agGt.view, paramView))
      {
        paramView = f.my(paramView);
        if (paramView != null) {
          paramView.agGJ = true;
        }
      }
      AppMethodBeat.o(234843);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(e.b paramb, View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(e.c paramc, ViewGroup paramViewGroup)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.view.f
 * JD-Core Version:    0.7.0.1
 */