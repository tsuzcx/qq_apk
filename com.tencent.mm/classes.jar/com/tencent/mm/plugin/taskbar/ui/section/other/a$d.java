package com.tencent.mm.plugin.taskbar.ui.section.other;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.taskbar.d.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;Landroid/content/Context;)V", "viewWidth", "", "onAttachedToWindow", "", "onMeasure", "widthSpec", "heightSpec", "setClipChild", "updateItemOffset", "width", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$d
  extends RecyclerView
{
  private int mbM;
  
  public a$d(Context paramContext)
  {
    super(localObject);
    AppMethodBeat.i(264280);
    AppMethodBeat.o(264280);
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(264294);
    super.onAttachedToWindow();
    setClipChildren(false);
    View localView = getRootView();
    Object localObject = getParent();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(264294);
      throw ((Throwable)localObject);
    }
    for (localObject = (View)localObject; (localObject != localView) && ((localObject instanceof ViewGroup)); localObject = (View)localObject)
    {
      ((ViewGroup)localObject).setClipChildren(false);
      if ((localObject instanceof RecyclerView)) {
        break;
      }
      localObject = ((View)localObject).getParent();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(264294);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(264294);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264287);
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredWidth() != this.mbM)
    {
      this.mbM = getMeasuredWidth();
      Context localContext = getContext();
      s.s(localContext, "context");
      while (getItemDecorationCount() > 0) {
        JL();
      }
      a((RecyclerView.h)new a(localContext));
    }
    AppMethodBeat.o(264287);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView$updateItemOffset$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.h
  {
    a(Context paramContext) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(264307);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      int j = RecyclerView.bA(paramView);
      int i = j;
      if (j == -1) {
        i = paramRecyclerView.bj(paramView).caM;
      }
      paramView = a.SUg;
      paramRect.left = (a.hEi() / 2);
      paramView = a.SUg;
      paramRect.right = (a.hEi() / 2);
      if (i / 3 > 0) {}
      for (paramRect.top = com.tencent.mm.cd.a.bs(this.$context, d.b.Edge_2_5_A);; paramRect.top = 0)
      {
        paramRect.bottom = 0;
        AppMethodBeat.o(264307);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.other.a.d
 * JD-Core Version:    0.7.0.1
 */