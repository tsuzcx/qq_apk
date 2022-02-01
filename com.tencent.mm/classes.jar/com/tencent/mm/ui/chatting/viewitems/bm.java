package com.tencent.mm.ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b.a;

final class bm
  extends LinkMovementMethod
{
  private a GRg;
  
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
      this.GRg = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.GRg != null)
      {
        this.GRg.setIsPressed(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.GRg), paramSpannable.getSpanEnd(this.GRg));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37562);
      return true;
      if (paramMotionEvent.getAction() == 2)
      {
        paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
        if ((this.GRg != null) && (paramTextView != this.GRg))
        {
          this.GRg.setIsPressed(false);
          this.GRg = null;
          Selection.removeSelection(paramSpannable);
        }
      }
      else
      {
        if (this.GRg != null)
        {
          this.GRg.setIsPressed(false);
          super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
        }
        this.GRg = null;
        Selection.removeSelection(paramSpannable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bm
 * JD-Core Version:    0.7.0.1
 */