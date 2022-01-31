package com.tencent.mm.ui.base;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMListPopupWindow$e
  implements View.OnTouchListener
{
  private MMListPopupWindow$e(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112518);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (MMListPopupWindow.b(this.zkQ) != null) && (MMListPopupWindow.b(this.zkQ).isShowing()) && (j >= 0) && (j < MMListPopupWindow.b(this.zkQ).getWidth()) && (k >= 0) && (k < MMListPopupWindow.b(this.zkQ).getHeight())) {
      MMListPopupWindow.d(this.zkQ).postDelayed(MMListPopupWindow.c(this.zkQ), 250L);
    }
    for (;;)
    {
      AppMethodBeat.o(112518);
      return false;
      if (i == 1) {
        MMListPopupWindow.d(this.zkQ).removeCallbacks(MMListPopupWindow.c(this.zkQ));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.e
 * JD-Core Version:    0.7.0.1
 */