package com.tencent.mm.ui.base;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMClearEditText$3
  implements View.OnTouchListener
{
  MMClearEditText$3(MMClearEditText paramMMClearEditText) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159154);
    paramView = this.Hws;
    if (paramView.getCompoundDrawables()[2] == null)
    {
      AppMethodBeat.o(159154);
      return false;
    }
    if (paramMotionEvent.getAction() != 1)
    {
      AppMethodBeat.o(159154);
      return false;
    }
    if (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.Hws.DnU.getIntrinsicWidth())
    {
      paramView.setText("");
      MMClearEditText.c(this.Hws);
    }
    AppMethodBeat.o(159154);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText.3
 * JD-Core Version:    0.7.0.1
 */