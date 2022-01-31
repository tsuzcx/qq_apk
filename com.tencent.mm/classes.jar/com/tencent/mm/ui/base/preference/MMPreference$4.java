package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class MMPreference$4
  implements AbsListView.OnScrollListener
{
  MMPreference$4(MMPreference paramMMPreference) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (1 == paramInt)
    {
      paramAbsListView = this.vdh.getCurrentFocus();
      if (paramAbsListView != null) {
        paramAbsListView.clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.4
 * JD-Core Version:    0.7.0.1
 */