package com.tencent.mm.ui.widget.textview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class a$3
  implements View.OnTouchListener
{
  a$3(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.wsy.wsq = ((int)paramMotionEvent.getX());
    this.wsy.wsr = ((int)paramMotionEvent.getY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.3
 * JD-Core Version:    0.7.0.1
 */