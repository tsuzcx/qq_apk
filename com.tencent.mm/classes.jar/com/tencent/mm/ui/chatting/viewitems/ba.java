package com.tencent.mm.ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.ui.base.a.a;

final class ba
  extends LinkMovementMethod
{
  private a vHB;
  
  private static a a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    paramTextView = (a[])paramSpannable.getSpans(i, i, a.class);
    if (paramTextView.length > 0) {
      return paramTextView[0];
    }
    return null;
  }
  
  public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.vHB = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.vHB != null)
      {
        this.vHB.mf(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.vHB), paramSpannable.getSpanEnd(this.vHB));
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() != 2) {
        break;
      }
      paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
    } while ((this.vHB == null) || (paramTextView == this.vHB));
    this.vHB.mf(false);
    this.vHB = null;
    Selection.removeSelection(paramSpannable);
    return true;
    if (this.vHB != null)
    {
      this.vHB.mf(false);
      super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    this.vHB = null;
    Selection.removeSelection(paramSpannable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba
 * JD-Core Version:    0.7.0.1
 */