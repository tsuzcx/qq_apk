package com.tencent.mm.ui.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class MMTextView$1
  extends GestureDetector.SimpleOnGestureListener
{
  MMTextView$1(MMTextView paramMMTextView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (MMTextView.a(this.wkn) == null) {
      return false;
    }
    return MMTextView.a(this.wkn).dI(this.wkn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextView.1
 * JD-Core Version:    0.7.0.1
 */