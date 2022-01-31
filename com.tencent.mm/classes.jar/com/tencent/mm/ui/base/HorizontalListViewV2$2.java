package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

final class HorizontalListViewV2$2
  extends DataSetObserver
{
  HorizontalListViewV2$2(HorizontalListViewV2 paramHorizontalListViewV2) {}
  
  public final void onChanged()
  {
    HorizontalListViewV2.b(this.uTM);
    HorizontalListViewV2.c(this.uTM);
    HorizontalListViewV2.d(this.uTM);
    this.uTM.invalidate();
    this.uTM.requestLayout();
  }
  
  public final void onInvalidated()
  {
    HorizontalListViewV2.c(this.uTM);
    HorizontalListViewV2.d(this.uTM);
    HorizontalListViewV2.e(this.uTM);
    this.uTM.invalidate();
    this.uTM.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.2
 * JD-Core Version:    0.7.0.1
 */