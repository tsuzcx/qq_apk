package com.tencent.mm.plugin.product.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HtmlTextView2$1
  implements View.OnTouchListener
{
  HtmlTextView2$1(HtmlTextView2 paramHtmlTextView2) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(44020);
    if (paramMotionEvent.getAction() == 2)
    {
      AppMethodBeat.o(44020);
      return true;
    }
    AppMethodBeat.o(44020);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView2.1
 * JD-Core Version:    0.7.0.1
 */