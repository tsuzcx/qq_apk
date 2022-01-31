package com.tencent.mm.ui.base;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class MMVisiblePasswordEditText$1
  implements View.OnTouchListener
{
  MMVisiblePasswordEditText$1(MMVisiblePasswordEditText paramMMVisiblePasswordEditText) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    paramView = this.uZA;
    if (paramView.getCompoundDrawables()[2] == null) {}
    while ((paramMotionEvent.getAction() != 1) || (paramMotionEvent.getX() <= paramView.getWidth() - paramView.getPaddingRight() - this.uZA.uZx.getIntrinsicWidth())) {
      return false;
    }
    paramView = this.uZA;
    if (!MMVisiblePasswordEditText.a(this.uZA)) {}
    for (;;)
    {
      MMVisiblePasswordEditText.a(paramView, bool);
      MMVisiblePasswordEditText.b(this.uZA);
      return false;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText.1
 * JD-Core Version:    0.7.0.1
 */