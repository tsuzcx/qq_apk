package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;

public final class i
  extends ArrowKeyMovementMethod
{
  private static i BEJ;
  
  public static i esX()
  {
    AppMethodBeat.i(30637);
    if (BEJ == null) {
      BEJ = new i();
    }
    i locali = BEJ;
    AppMethodBeat.o(30637);
    return locali;
  }
  
  public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30638);
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int m = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int n = paramTextView.getTotalPaddingLeft();
      int k = paramTextView.getTotalPaddingTop();
      m = paramTextView.getScrollX() + (m - n);
      n = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(n + (j - k)), m);
      localObject = (k[])paramSpannable.getSpans(j, j + 1, k.class);
      if ((m < b.bSG()) && (localObject.length != 0))
      {
        if (i == 0) {
          localObject[0].a(paramTextView, paramSpannable, paramMotionEvent, localObject[0]);
        }
        AppMethodBeat.o(30638);
        return false;
      }
    }
    AppMethodBeat.o(30638);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.i
 * JD-Core Version:    0.7.0.1
 */