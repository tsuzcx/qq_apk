package com.tencent.mm.ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a.a;

final class bd
  extends LinkMovementMethod
{
  private a zYW;
  
  private static a a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(33453);
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
      AppMethodBeat.o(33453);
      return paramTextView;
    }
  }
  
  public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(33452);
    if (paramMotionEvent.getAction() == 0)
    {
      this.zYW = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.zYW != null)
      {
        this.zYW.setIsPressed(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.zYW), paramSpannable.getSpanEnd(this.zYW));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33452);
      return true;
      if (paramMotionEvent.getAction() == 2)
      {
        paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
        if ((this.zYW != null) && (paramTextView != this.zYW))
        {
          this.zYW.setIsPressed(false);
          this.zYW = null;
          Selection.removeSelection(paramSpannable);
        }
      }
      else
      {
        if (this.zYW != null)
        {
          this.zYW.setIsPressed(false);
          super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
        }
        this.zYW = null;
        Selection.removeSelection(paramSpannable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd
 * JD-Core Version:    0.7.0.1
 */