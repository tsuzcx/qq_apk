package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.widget.MMWebView.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "Lcom/tencent/mm/ui/base/CustomViewPager;", "Lcom/tencent/mm/ui/widget/MMWebView$MMScrollListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "mConsumeTouchEvent", "", "mGalleryPagerWidth", "", "mOnlySlideBySide", "mSideGalleryExposeWidth", "canScroll", "v", "Landroid/view/View;", "checkV", "dx", "x", "y", "onInterceptTouchEvent", "motionEvent", "Landroid/view/MotionEvent;", "onOverScroll", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "setCanOnlySlideBySide", "", "enable", "setDisplayMetrics", "pagerWidth", "sideItemDisplayWidth", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MultiTaskViewPager
  extends CustomViewPager
  implements MMWebView.b
{
  private boolean LFk;
  private final String TAG = "MicroMsg.MultiTaskViewPager";
  
  public MultiTaskViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiTaskViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean S(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304570);
    if (((paramInt3 == 0) && (paramInt1 < 0)) || ((Math.abs(paramInt3 - paramInt4) < 160) && (paramInt1 > 0) && (paramInt2 == 0)))
    {
      setUnableDrag(false, true);
      AppMethodBeat.o(304570);
      return true;
    }
    AppMethodBeat.o(304570);
    return false;
  }
  
  public boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(304563);
    if (this.LFk)
    {
      AppMethodBeat.o(304563);
      return true;
    }
    int k;
    int m;
    int i;
    if (((paramView instanceof ViewGroup)) && (((ViewGroup)paramView).getVisibility() == 0))
    {
      k = ((ViewGroup)paramView).getScrollX();
      m = ((ViewGroup)paramView).getScrollY();
      i = ((ViewGroup)paramView).getChildCount() - 1;
      if (i < 0) {}
    }
    for (;;)
    {
      int j = i - 1;
      View localView = ((ViewGroup)paramView).getChildAt(i);
      if ((paramInt2 + k >= localView.getLeft()) && (paramInt2 + k < localView.getRight()) && (paramInt3 + m >= localView.getTop()) && (paramInt3 + m < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + k - localView.getLeft(), paramInt3 + m - localView.getTop())) && (localView.isEnabled()))
      {
        AppMethodBeat.o(304563);
        return true;
      }
      if (j < 0)
      {
        if ((paramBoolean) && (z.n(paramView, -paramInt1)))
        {
          if ((paramView != null) && (paramView.getVisibility() == 0)) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            AppMethodBeat.o(304563);
            return true;
          }
        }
        AppMethodBeat.o(304563);
        return false;
      }
      i = j;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(304556);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(304556);
    return bool;
  }
  
  public final void setCanOnlySlideBySide(boolean paramBoolean)
  {
    this.LFk = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.MultiTaskViewPager
 * JD-Core Version:    0.7.0.1
 */