package com.tencent.mm.ui.base;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMAutoCompleteTextView$1
  implements View.OnTouchListener
{
  MMAutoCompleteTextView$1(MMAutoCompleteTextView paramMMAutoCompleteTextView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106472);
    paramView = this.ziJ;
    if (paramView.getCompoundDrawables()[2] == null)
    {
      AppMethodBeat.o(106472);
      return false;
    }
    if (paramMotionEvent.getAction() != 1)
    {
      AppMethodBeat.o(106472);
      return false;
    }
    if (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.ziJ.vQV.getIntrinsicWidth())
    {
      paramView.setText("");
      MMAutoCompleteTextView.a(this.ziJ);
    }
    AppMethodBeat.o(106472);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoCompleteTextView.1
 * JD-Core Version:    0.7.0.1
 */