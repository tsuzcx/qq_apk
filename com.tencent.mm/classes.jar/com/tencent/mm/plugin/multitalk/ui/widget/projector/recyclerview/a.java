package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/CenterSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculateDxToMakeVisible", "", "view", "Landroid/view/View;", "snapPreference", "calculateDyToMakeVisible", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-multitalk_release"})
public final class a
  extends androidx.recyclerview.widget.p
{
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(203635);
    AppMethodBeat.o(203635);
  }
  
  public final int E(View paramView, int paramInt)
  {
    AppMethodBeat.i(203633);
    kotlin.g.b.p.k(paramView, "view");
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollVertically()))
    {
      AppMethodBeat.o(203633);
      return 0;
    }
    paramInt = (paramView.getTop() + paramView.getBottom()) / 2;
    int i = localLayoutManager.getHeight() / 2;
    AppMethodBeat.o(203633);
    return i - paramInt;
  }
  
  public final int F(View paramView, int paramInt)
  {
    AppMethodBeat.i(203632);
    kotlin.g.b.p.k(paramView, "view");
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollHorizontally()))
    {
      AppMethodBeat.o(203632);
      return 0;
    }
    paramInt = (paramView.getLeft() + paramView.getRight()) / 2;
    int i = localLayoutManager.getWidth() / 2;
    AppMethodBeat.o(203632);
    return i - paramInt;
  }
  
  public final float a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(203634);
    kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
    float f = 50.0F / paramDisplayMetrics.densityDpi;
    AppMethodBeat.o(203634);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */