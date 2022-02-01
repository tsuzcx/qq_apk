package com.tencent.mm.plugin.taskbar.ui.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.af;
import android.support.v7.widget.aj;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "()V", "context", "Landroid/content/Context;", "helper", "Landroid/support/v7/widget/OrientationHelper;", "markView", "Landroid/view/View;", "maxScrollDistance", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scroller", "Landroid/widget/Scroller;", "attachToRecyclerView", "", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "calculateScrollDistance", "velocityX", "velocityY", "distanceToStart", "findFirstView", "findSnapView", "plugin-taskbar_release"})
public final class f
  extends af
{
  private Scroller Ays;
  private aj FVE;
  private int FVF;
  private View FVG;
  private Context context;
  private RecyclerView hak;
  
  private final aj i(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(238519);
    if (this.FVE == null) {
      this.FVE = aj.d(paramLayoutManager);
    }
    paramLayoutManager = this.FVE;
    if (paramLayoutManager == null) {
      p.hyc();
    }
    AppMethodBeat.o(238519);
    return paramLayoutManager;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject1 = null;
    AppMethodBeat.i(238516);
    aj localaj = i(paramLayoutManager);
    if (paramLayoutManager == null)
    {
      AppMethodBeat.o(238516);
      return null;
    }
    int m = paramLayoutManager.getChildCount();
    if (m == 0)
    {
      AppMethodBeat.o(238516);
      return null;
    }
    int i = 2147483647;
    int n = localaj.kH();
    Object localObject2 = this.hak;
    if ((localObject2 != null) && (!((RecyclerView)localObject2).canScrollHorizontally(1)))
    {
      paramLayoutManager = this.FVG;
      AppMethodBeat.o(238516);
      return paramLayoutManager;
    }
    int j = 0;
    if (j < m)
    {
      localObject2 = paramLayoutManager.getChildAt(j);
      int k = Math.abs(localaj.bo((View)localObject2) - n);
      if (k >= i) {
        break label144;
      }
      i = k;
      localObject1 = localObject2;
    }
    label144:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(238516);
      return localObject1;
    }
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(238517);
    p.h(paramLayoutManager, "layoutManager");
    p.h(paramView, "targetView");
    int[] arrayOfInt = new int[2];
    paramLayoutManager = i(paramLayoutManager);
    if (p.j(paramView, this.FVG)) {}
    for (int i = 0;; i = paramLayoutManager.bo(paramView) - paramLayoutManager.kH())
    {
      arrayOfInt[0] = i;
      AppMethodBeat.o(238517);
      return arrayOfInt;
    }
  }
  
  public final int[] aC(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(238518);
    int[] arrayOfInt = new int[2];
    Object localObject = this.FVE;
    if (localObject == null)
    {
      AppMethodBeat.o(238518);
      return arrayOfInt;
    }
    if (this.FVF <= 0)
    {
      localObject = ((aj)localObject).getLayoutManager().getChildAt(0);
      if (localObject == null) {
        break label81;
      }
    }
    label81:
    for (int i = ((View)localObject).getWidth();; i = 0)
    {
      this.FVF = i;
      if (this.FVF > 0) {
        break;
      }
      AppMethodBeat.o(238518);
      return arrayOfInt;
    }
    localObject = this.Ays;
    if (localObject != null) {
      ((Scroller)localObject).fling(0, 0, paramInt1, paramInt2, -this.FVF, this.FVF, 0, 0);
    }
    localObject = this.Ays;
    if (localObject != null) {}
    for (paramInt1 = ((Scroller)localObject).getFinalX();; paramInt1 = 0)
    {
      arrayOfInt[0] = paramInt1;
      localObject = this.Ays;
      paramInt1 = j;
      if (localObject != null) {
        paramInt1 = ((Scroller)localObject).getFinalY();
      }
      arrayOfInt[1] = paramInt1;
      AppMethodBeat.o(238518);
      return arrayOfInt;
    }
  }
  
  public final void f(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(238515);
    if (paramRecyclerView != null)
    {
      this.context = paramRecyclerView.getContext();
      this.Ays = new Scroller(this.context, (Interpolator)new DecelerateInterpolator());
    }
    for (;;)
    {
      this.FVG = new View(this.context);
      this.hak = paramRecyclerView;
      super.f(paramRecyclerView);
      AppMethodBeat.o(238515);
      return;
      this.Ays = null;
      this.context = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.f
 * JD-Core Version:    0.7.0.1
 */