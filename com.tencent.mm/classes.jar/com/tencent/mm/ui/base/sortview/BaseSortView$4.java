package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class BaseSortView$4
  implements AdapterView.OnItemSelectedListener
{
  BaseSortView$4(BaseSortView paramBaseSortView) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (BaseSortView.e(this.veh) != null) {
      BaseSortView.e(this.veh).onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    if (BaseSortView.e(this.veh) != null) {
      BaseSortView.e(this.veh).onNothingSelected(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView.4
 * JD-Core Version:    0.7.0.1
 */