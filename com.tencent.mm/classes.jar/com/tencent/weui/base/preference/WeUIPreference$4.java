package com.tencent.weui.base.preference;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class WeUIPreference$4
  implements AbsListView.OnScrollListener
{
  WeUIPreference$4(WeUIPreference paramWeUIPreference) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (1 == paramInt)
    {
      paramAbsListView = this.xfT.getCurrentFocus();
      if (paramAbsListView != null) {
        paramAbsListView.clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.4
 * JD-Core Version:    0.7.0.1
 */