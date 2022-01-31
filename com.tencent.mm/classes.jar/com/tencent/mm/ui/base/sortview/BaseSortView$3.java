package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

final class BaseSortView$3
  implements AdapterView.OnItemLongClickListener
{
  BaseSortView$3(BaseSortView paramBaseSortView) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (BaseSortView.d(this.veh) != null) {
      return BaseSortView.d(this.veh).onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView.3
 * JD-Core Version:    0.7.0.1
 */