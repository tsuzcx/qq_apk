package com.tencent.mm.ui.base;

import android.view.View;

final class MMListPopupWindow$1
  implements Runnable
{
  MMListPopupWindow$1(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void run()
  {
    View localView = this.uWx.aeU;
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.uWx.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */