package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileViewPager
  extends ViewPager
{
  public BizProfileViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(305954);
    AppMethodBeat.o(305954);
  }
  
  public BizProfileViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(305966);
    AppMethodBeat.o(305966);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileViewPager
 * JD-Core Version:    0.7.0.1
 */