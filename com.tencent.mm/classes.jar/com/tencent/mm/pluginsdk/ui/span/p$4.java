package com.tencent.mm.pluginsdk.ui.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class p$4
  implements View.OnTouchListener
{
  p$4(Spannable paramSpannable, TextView paramTextView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(245164);
    int j = paramMotionEvent.getAction();
    paramView = (TextView)paramView;
    int k;
    int i;
    if ((j == 1) || (j == 3))
    {
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])this.Abg.getSpans(0, this.Abg.length(), ClickableSpan.class);
      if ((arrayOfClickableSpan != null) && (arrayOfClickableSpan.length > 0))
      {
        k = arrayOfClickableSpan.length;
        i = 0;
        while (i < k)
        {
          ClickableSpan localClickableSpan = arrayOfClickableSpan[i];
          if ((localClickableSpan instanceof t))
          {
            ((t)localClickableSpan).setIsPressed(false);
            this.Abh.invalidate();
          }
          i += 1;
        }
      }
    }
    if ((j == 1) || (j == 0))
    {
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      int m = paramView.getPaddingLeft();
      int n = paramView.getPaddingTop();
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      paramMotionEvent = paramView.getLayout();
      i = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), i - m + i1);
      paramMotionEvent = (ClickableSpan[])this.Abg.getSpans(i, i, ClickableSpan.class);
      if (paramMotionEvent.length != 0)
      {
        paramMotionEvent = paramMotionEvent[0];
        if (j == 1) {
          paramMotionEvent.onClick(paramView);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MMSpanManager", "touch ${event.x}, ${event.y}, ret:${ret}");
      AppMethodBeat.o(245164);
      return bool;
      if ((paramMotionEvent instanceof t))
      {
        ((t)paramMotionEvent).setIsPressed(true);
        this.Abh.invalidate();
      }
      Selection.setSelection(this.Abg, this.Abg.getSpanStart(paramMotionEvent), this.Abg.getSpanEnd(paramMotionEvent));
      break;
      Selection.removeSelection(this.Abg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.p.4
 * JD-Core Version:    0.7.0.1
 */