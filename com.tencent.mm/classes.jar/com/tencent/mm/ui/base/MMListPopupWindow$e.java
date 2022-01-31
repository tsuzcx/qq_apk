package com.tencent.mm.ui.base;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class MMListPopupWindow$e
  implements View.OnTouchListener
{
  private MMListPopupWindow$e(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (MMListPopupWindow.b(this.uWx) != null) && (MMListPopupWindow.b(this.uWx).isShowing()) && (j >= 0) && (j < MMListPopupWindow.b(this.uWx).getWidth()) && (k >= 0) && (k < MMListPopupWindow.b(this.uWx).getHeight())) {
      MMListPopupWindow.d(this.uWx).postDelayed(MMListPopupWindow.c(this.uWx), 250L);
    }
    for (;;)
    {
      return false;
      if (i == 1) {
        MMListPopupWindow.d(this.uWx).removeCallbacks(MMListPopupWindow.c(this.uWx));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.e
 * JD-Core Version:    0.7.0.1
 */