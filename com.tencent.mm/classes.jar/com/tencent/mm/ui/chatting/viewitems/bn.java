package com.tencent.mm.ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b.a;

final class bn
  extends LinkMovementMethod
{
  private a Irh;
  
  private static a a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37563);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    paramTextView = (a[])paramSpannable.getSpans(i, i, a.class);
    if (paramTextView.length > 0) {}
    for (paramTextView = paramTextView[0];; paramTextView = null)
    {
      AppMethodBeat.o(37563);
      return paramTextView;
    }
  }
  
  public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37562);
    if (paramMotionEvent.getAction() == 0)
    {
      this.Irh = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.Irh != null)
      {
        this.Irh.setIsPressed(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.Irh), paramSpannable.getSpanEnd(this.Irh));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37562);
      return true;
      if (paramMotionEvent.getAction() == 2)
      {
        paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
        if ((this.Irh != null) && (paramTextView != this.Irh))
        {
          this.Irh.setIsPressed(false);
          this.Irh = null;
          Selection.removeSelection(paramSpannable);
        }
      }
      else
      {
        if (this.Irh != null)
        {
          this.Irh.setIsPressed(false);
          super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
        }
        this.Irh = null;
        Selection.removeSelection(paramSpannable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bn
 * JD-Core Version:    0.7.0.1
 */