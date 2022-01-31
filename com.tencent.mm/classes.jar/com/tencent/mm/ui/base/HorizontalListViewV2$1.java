package com.tencent.mm.ui.base;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HorizontalListViewV2$1
  implements View.OnTouchListener
{
  HorizontalListViewV2$1(HorizontalListViewV2 paramHorizontalListViewV2) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106328);
    boolean bool = HorizontalListViewV2.a(this.zim).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(106328);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.1
 * JD-Core Version:    0.7.0.1
 */