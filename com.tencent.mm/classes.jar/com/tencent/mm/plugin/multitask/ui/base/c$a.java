package com.tencent.mm.plugin.multitask.ui.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$ParentAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "multiTaskView", "Landroid/view/View;", "launcherView", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper;Landroid/view/View;Landroid/view/View;)V", "getLauncherView", "()Landroid/view/View;", "getMultiTaskView", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "obj", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
  extends a
{
  private final View LFo;
  private final View LFp;
  
  public c$a(View paramView1, View paramView2)
  {
    AppMethodBeat.i(304578);
    this.LFo = paramView2;
    this.LFp = localObject;
    AppMethodBeat.o(304578);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(304592);
    s.u(paramViewGroup, "container");
    s.u(paramObject, "object");
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(304592);
  }
  
  public final int getCount()
  {
    return 2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(304586);
    s.u(paramViewGroup, "container");
    if (paramInt == 0) {}
    for (View localView = this.LFo;; localView = this.LFp)
    {
      paramViewGroup.removeView(localView);
      paramViewGroup.addView(localView);
      AppMethodBeat.o(304586);
      return localView;
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(304597);
    s.u(paramView, "view");
    s.u(paramObject, "obj");
    boolean bool = s.p(paramView, paramObject);
    AppMethodBeat.o(304597);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.c.a
 * JD-Core Version:    0.7.0.1
 */