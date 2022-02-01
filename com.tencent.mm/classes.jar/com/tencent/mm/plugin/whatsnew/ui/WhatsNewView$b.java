package com.tencent.mm.plugin.whatsnew.ui;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView$HolderAdapter;", "Landroid/support/v4/view/PagerAdapter;", "()V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "app_release"})
final class WhatsNewView$b
  extends q
{
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(230990);
    p.h(paramViewGroup, "container");
    p.h(paramObject, "obj");
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(230990);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(230987);
    int i = WhatsNewView.glc().length;
    AppMethodBeat.o(230987);
    return i + 1;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(230989);
    p.h(paramViewGroup, "container");
    View localView = new View(paramViewGroup.getContext());
    paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(230989);
    return localView;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(230988);
    p.h(paramView, "view");
    p.h(paramObject, "obj");
    if (paramView == paramObject)
    {
      AppMethodBeat.o(230988);
      return true;
    }
    AppMethodBeat.o(230988);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewView.b
 * JD-Core Version:    0.7.0.1
 */