package com.tencent.mm.ui.base.sortview;

import android.database.DataSetObserver;

final class BaseSortView$1
  extends DataSetObserver
{
  BaseSortView$1(BaseSortView paramBaseSortView) {}
  
  public final void onChanged()
  {
    if (BaseSortView.a(this.veh) != null) {
      BaseSortView.a(this.veh).aH(BaseSortView.b(this.veh).ved);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView.1
 * JD-Core Version:    0.7.0.1
 */