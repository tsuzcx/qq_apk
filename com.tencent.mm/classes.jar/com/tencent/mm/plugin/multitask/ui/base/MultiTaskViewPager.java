package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.widget.MMWebView.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "Lcom/tencent/mm/ui/base/CustomViewPager;", "Lcom/tencent/mm/ui/widget/MMWebView$MMScrollListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "mConsumeTouchEvent", "", "mGalleryPagerWidth", "", "mOnlySlideBySide", "mSideGalleryExposeWidth", "canScroll", "v", "Landroid/view/View;", "checkV", "dx", "x", "y", "onInterceptTouchEvent", "motionEvent", "Landroid/view/MotionEvent;", "onOverScroll", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "setCanOnlySlideBySide", "", "enable", "setDisplayMetrics", "pagerWidth", "sideItemDisplayWidth", "plugin-multitask_release"})
public class MultiTaskViewPager
  extends CustomViewPager
  implements MMWebView.b
{
  private boolean FJU;
  private final String TAG = "MicroMsg.MultiTaskViewPager";
  
  public MultiTaskViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiTaskViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean I(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(247712);
    if (((paramInt3 == 0) && (paramInt1 < 0)) || ((Math.abs(paramInt3 - paramInt4) < 160) && (paramInt1 > 0) && (paramInt2 == 0)))
    {
      setUnableDrag(false, true);
      AppMethodBeat.o(247712);
      return true;
    }
    AppMethodBeat.o(247712);
    return false;
  }
  
  public boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(247711);
    if (this.FJU)
    {
      AppMethodBeat.o(247711);
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
        p.j(localView, "child");
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop())) && (localView.isEnabled()))
        {
          AppMethodBeat.o(247711);
          return true;
        }
        i -= 1;
      }
    }
    if ((paramBoolean) && (w.n(paramView, -paramInt1)) && (paramView != null) && (paramView.getVisibility() == 0))
    {
      AppMethodBeat.o(247711);
      return true;
    }
    AppMethodBeat.o(247711);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247710);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(247710);
    return bool;
  }
  
  public final void setCanOnlySlideBySide(boolean paramBoolean)
  {
    this.FJU = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.MultiTaskViewPager
 * JD-Core Version:    0.7.0.1
 */