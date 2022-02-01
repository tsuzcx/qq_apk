package com.tencent.mm.plugin.multitask.ui.base;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$ParentAdapter;", "Landroid/support/v4/view/PagerAdapter;", "multiTaskView", "Landroid/view/View;", "launcherView", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;Landroid/view/View;Landroid/view/View;)V", "getLauncherView", "()Landroid/view/View;", "getMultiTaskView", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "obj", "plugin-multitask_release"})
public final class d$a
  extends q
{
  private final View Adt;
  private final View Adu;
  
  public d$a(View paramView1, View paramView2)
  {
    AppMethodBeat.i(200765);
    this.Adt = paramView2;
    this.Adu = localObject;
    AppMethodBeat.o(200765);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(200763);
    p.h(paramViewGroup, "container");
    p.h(paramObject, "object");
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(200763);
  }
  
  public final int getCount()
  {
    return 2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(200762);
    p.h(paramViewGroup, "container");
    if (paramInt == 0) {}
    for (View localView = this.Adt;; localView = this.Adu)
    {
      paramViewGroup.removeView(localView);
      paramViewGroup.addView(localView);
      AppMethodBeat.o(200762);
      return localView;
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(200764);
    p.h(paramView, "view");
    p.h(paramObject, "obj");
    boolean bool = p.j(paramView, paramObject);
    AppMethodBeat.o(200764);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.d.a
 * JD-Core Version:    0.7.0.1
 */