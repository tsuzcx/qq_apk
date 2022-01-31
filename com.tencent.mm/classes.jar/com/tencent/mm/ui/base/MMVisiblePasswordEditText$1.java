package com.tencent.mm.ui.base;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMVisiblePasswordEditText$1
  implements View.OnTouchListener
{
  MMVisiblePasswordEditText$1(MMVisiblePasswordEditText paramMMVisiblePasswordEditText) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(106954);
    paramView = this.znR;
    if (paramView.getCompoundDrawables()[2] == null)
    {
      AppMethodBeat.o(106954);
      return false;
    }
    if (paramMotionEvent.getAction() != 1)
    {
      AppMethodBeat.o(106954);
      return false;
    }
    if (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.znR.znO.getIntrinsicWidth())
    {
      paramView = this.znR;
      if (MMVisiblePasswordEditText.a(this.znR)) {
        break label107;
      }
    }
    for (;;)
    {
      MMVisiblePasswordEditText.a(paramView, bool);
      MMVisiblePasswordEditText.b(this.znR);
      AppMethodBeat.o(106954);
      return false;
      label107:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVisiblePasswordEditText.1
 * JD-Core Version:    0.7.0.1
 */