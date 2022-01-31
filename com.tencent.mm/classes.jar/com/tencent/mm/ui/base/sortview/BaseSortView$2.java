package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class BaseSortView$2
  implements AdapterView.OnItemClickListener
{
  BaseSortView$2(BaseSortView paramBaseSortView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (BaseSortView.c(this.veh) != null) {
      BaseSortView.c(this.veh).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView.2
 * JD-Core Version:    0.7.0.1
 */