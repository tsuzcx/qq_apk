package com.tencent.mm.ui.base;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;

final class MMListPopupWindow$d
  implements AbsListView.OnScrollListener
{
  private MMListPopupWindow$d(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((MMListPopupWindow.a(this.uWx) != null) && (MMListPopupWindow.e(this.uWx) != null) && (MMListPopupWindow.f(this.uWx) != null) && (MMListPopupWindow.a(this.uWx) != null))
    {
      if ((MMListPopupWindow.a(this.uWx).getLastVisiblePosition() == MMListPopupWindow.f(this.uWx).getCount() - 1) && (MMListPopupWindow.a(this.uWx).getChildAt(MMListPopupWindow.a(this.uWx).getChildCount() - 1) != null) && (MMListPopupWindow.a(this.uWx).getChildAt(MMListPopupWindow.a(this.uWx).getChildCount() - 1).getBottom() <= MMListPopupWindow.a(this.uWx).getHeight())) {
        MMListPopupWindow.e(this.uWx).setVisibility(8);
      }
    }
    else {
      return;
    }
    MMListPopupWindow.e(this.uWx).setVisibility(0);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) && (!this.uWx.isInputMethodNotNeeded()) && (MMListPopupWindow.b(this.uWx).getContentView() != null))
    {
      MMListPopupWindow.d(this.uWx).removeCallbacks(MMListPopupWindow.c(this.uWx));
      MMListPopupWindow.c(this.uWx).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.d
 * JD-Core Version:    0.7.0.1
 */