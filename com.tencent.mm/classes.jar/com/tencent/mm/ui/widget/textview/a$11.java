package com.tencent.mm.ui.widget.textview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$11
  implements View.OnTouchListener
{
  a$11(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138210);
    ak.d("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= this.ANs.AMN.getWidth()) || (j < 0) || (j >= this.ANs.AMN.getHeight())))
    {
      ak.d("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
      this.ANs.AMT.postDelayed(this.ANs.ANp, 100L);
      AppMethodBeat.o(138210);
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      ak.d("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
      this.ANs.AMT.postDelayed(this.ANs.ANp, 100L);
      AppMethodBeat.o(138210);
      return true;
    }
    AppMethodBeat.o(138210);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.11
 * JD-Core Version:    0.7.0.1
 */