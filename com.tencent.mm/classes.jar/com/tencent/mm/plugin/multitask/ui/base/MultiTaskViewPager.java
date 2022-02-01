package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "Lcom/tencent/mm/ui/base/CustomViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mConsumeTouchEvent", "", "mGalleryPagerWidth", "", "mOnlySlideBySide", "mSideGalleryExposeWidth", "canScroll", "v", "Landroid/view/View;", "checkV", "dx", "x", "y", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "setCanOnlySlideBySide", "enable", "setDisplayMetrics", "pagerWidth", "sideItemDisplayWidth", "plugin-multitask_release"})
public class MultiTaskViewPager
  extends CustomViewPager
{
  private boolean Adp;
  
  public MultiTaskViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiTaskViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200760);
    if (this.Adp)
    {
      AppMethodBeat.o(200760);
      return true;
    }
    if (((paramView instanceof ViewGroup)) && (((ViewGroup)paramView).getVisibility() == 0))
    {
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = ((ViewGroup)paramView).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((ViewGroup)paramView).getChildAt(i);
        p.g(localView, "child");
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop())) && (localView.isEnabled()))
        {
          AppMethodBeat.o(200760);
          return true;
        }
        i -= 1;
      }
    }
    if ((paramBoolean) && (u.n(paramView, -paramInt1)) && (paramView != null) && (paramView.getVisibility() == 0))
    {
      AppMethodBeat.o(200760);
      return true;
    }
    AppMethodBeat.o(200760);
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200761);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(200761);
  }
  
  public final void setCanOnlySlideBySide(boolean paramBoolean)
  {
    this.Adp = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.MultiTaskViewPager
 * JD-Core Version:    0.7.0.1
 */