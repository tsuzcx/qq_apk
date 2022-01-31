package com.tencent.mm.ui.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTextView$1
  extends GestureDetector.SimpleOnGestureListener
{
  MMTextView$1(MMTextView paramMMTextView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107921);
    if (MMTextView.a(this.ADV) == null)
    {
      AppMethodBeat.o(107921);
      return false;
    }
    boolean bool = MMTextView.a(this.ADV).eR(this.ADV);
    AppMethodBeat.o(107921);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextView.1
 * JD-Core Version:    0.7.0.1
 */