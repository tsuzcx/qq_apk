package com.tencent.mm.plugin.multitask.ui.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$ParentAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "multiTaskView", "Landroid/view/View;", "launcherView", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;Landroid/view/View;Landroid/view/View;)V", "getLauncherView", "()Landroid/view/View;", "getMultiTaskView", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "obj", "plugin-multitask_release"})
public final class d$a
  extends a
{
  private final View FJY;
  private final View FJZ;
  
  public d$a(View paramView1, View paramView2)
  {
    AppMethodBeat.i(247591);
    this.FJY = paramView2;
    this.FJZ = localObject;
    AppMethodBeat.o(247591);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(247585);
    p.k(paramViewGroup, "container");
    p.k(paramObject, "object");
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(247585);
  }
  
  public final int getCount()
  {
    return 2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(247584);
    p.k(paramViewGroup, "container");
    if (paramInt == 0) {}
    for (View localView = this.FJY;; localView = this.FJZ)
    {
      paramViewGroup.removeView(localView);
      paramViewGroup.addView(localView);
      AppMethodBeat.o(247584);
      return localView;
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(247586);
    p.k(paramView, "view");
    p.k(paramObject, "obj");
    boolean bool = p.h(paramView, paramObject);
    AppMethodBeat.o(247586);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.d.a
 * JD-Core Version:    0.7.0.1
 */