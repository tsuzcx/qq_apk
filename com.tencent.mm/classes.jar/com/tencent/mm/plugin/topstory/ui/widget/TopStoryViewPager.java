package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.widget.MMWebView.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/topstory/ui/widget/TopStoryViewPager;", "Lcom/tencent/mm/ui/base/CustomViewPager;", "Lcom/tencent/mm/ui/widget/MMWebView$MMScrollListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "mGalleryPagerWidth", "", "mSideGalleryExposeWidth", "canScroll", "", "v", "Landroid/view/View;", "checkV", "dx", "x", "y", "onOverScroll", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "setDisplayMetrics", "", "pagerWidth", "sideItemDisplayWidth", "ui-topstory_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TopStoryViewPager
  extends CustomViewPager
  implements MMWebView.b
{
  private final String TAG = "MicroMsg.MultiTaskViewPager";
  
  public TopStoryViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean S(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(271716);
    if (((paramInt3 == 0) && (paramInt1 < 0)) || ((Math.abs(paramInt3 - paramInt4) < 160) && (paramInt1 > 0) && (paramInt2 == 0)))
    {
      setUnableDrag(false, true);
      Log.d(this.TAG, "onOverScroll, Horizontal Scroll trigger");
      AppMethodBeat.o(271716);
      return true;
    }
    AppMethodBeat.o(271716);
    return false;
  }
  
  public boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager
 * JD-Core Version:    0.7.0.1
 */