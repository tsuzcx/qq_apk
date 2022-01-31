package com.tencent.mm.ui.base;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class MMClearEditText$3
  implements View.OnTouchListener
{
  MMClearEditText$3(MMClearEditText paramMMClearEditText) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.uUz;
    if (paramView.getCompoundDrawables()[2] == null) {}
    while ((paramMotionEvent.getAction() != 1) || (paramMotionEvent.getX() <= paramView.getWidth() - paramView.getPaddingRight() - this.uUz.saf.getIntrinsicWidth())) {
      return false;
    }
    paramView.setText("");
    MMClearEditText.c(this.uUz);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText.3
 * JD-Core Version:    0.7.0.1
 */