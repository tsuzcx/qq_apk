package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.y;

final class MMLoadMoreListView$1
  implements AbsListView.OnScrollListener
{
  MMLoadMoreListView$1(MMLoadMoreListView paramMMLoadMoreListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (this.uWC.getChildAt(0) != null) && (this.uWC.getChildAt(0).getTop() == this.uWC.getPaddingTop())) {
      MMLoadMoreListView.a(this.uWC, true);
    }
    for (;;)
    {
      y.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[] { MMLoadMoreListView.b(this.uWC) });
      return;
      MMLoadMoreListView.a(this.uWC, false);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (MMLoadMoreListView.a(this.uWC) != null)) {
      MMLoadMoreListView.a(this.uWC).yb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMLoadMoreListView.1
 * JD-Core Version:    0.7.0.1
 */