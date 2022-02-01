package com.tencent.mm.plugin.remittance.ui;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements View.OnTouchListener
{
  private a.a wMa;
  
  public static a dxR()
  {
    AppMethodBeat.i(67915);
    a locala = new a();
    AppMethodBeat.o(67915);
    return locala;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67916);
    if (this.wMa == null) {
      this.wMa = new a.a(paramView);
    }
    TextView localTextView = (TextView)paramView;
    localTextView.setMovementMethod(null);
    Object localObject = localTextView.getText();
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    int i = paramMotionEvent.getAction();
    if ((i == 0) || (i == 1))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = localTextView.getTotalPaddingLeft();
      int n = localTextView.getTotalPaddingTop();
      int i1 = localTextView.getScrollX();
      int i2 = localTextView.getScrollY();
      paramMotionEvent = localTextView.getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramMotionEvent = (ClickableSpan[])((Spannable)localObject).getSpans(j, j, ClickableSpan.class);
      if (paramMotionEvent.length != 0)
      {
        if (i == 0) {
          paramView.postDelayed(this.wMa, ViewConfiguration.getLongPressTimeout());
        }
        for (;;)
        {
          AppMethodBeat.o(67916);
          return true;
          paramView.removeCallbacks(this.wMa);
          paramMotionEvent[0].onClick(localTextView);
        }
      }
    }
    else if (i == 3)
    {
      paramView.removeCallbacks(this.wMa);
    }
    AppMethodBeat.o(67916);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.a
 * JD-Core Version:    0.7.0.1
 */