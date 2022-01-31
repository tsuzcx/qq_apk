package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

final class MMHorList$2
  extends DataSetObserver
{
  MMHorList$2(MMHorList paramMMHorList) {}
  
  public final void onChanged()
  {
    MMHorList.a(this.uWr);
    this.uWr.invalidate();
    this.uWr.requestLayout();
  }
  
  public final void onInvalidated()
  {
    MMHorList.b(this.uWr);
    this.uWr.invalidate();
    this.uWr.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList.2
 * JD-Core Version:    0.7.0.1
 */