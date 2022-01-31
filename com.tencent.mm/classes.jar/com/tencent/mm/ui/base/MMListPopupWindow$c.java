package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

final class MMListPopupWindow$c
  extends DataSetObserver
{
  private MMListPopupWindow$c(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void onChanged()
  {
    if (this.uWx.fvf.isShowing()) {
      this.uWx.show();
    }
  }
  
  public final void onInvalidated()
  {
    this.uWx.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.c
 * JD-Core Version:    0.7.0.1
 */