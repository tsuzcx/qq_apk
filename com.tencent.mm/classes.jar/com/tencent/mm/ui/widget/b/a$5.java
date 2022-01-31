package com.tencent.mm.ui.widget.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.ao;

final class a$5
  implements View.OnTouchListener
{
  a$5(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    }
    a.Iz((int)paramMotionEvent.getRawX());
    a.IA((int)paramMotionEvent.getRawY());
    a.b(this.woj, a.e(this.woj));
    a.cKi();
    ao.t("popmenu view set , x_down=" + a.aGh() + "y_down=" + a.cKj(), new Object[0]);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a.5
 * JD-Core Version:    0.7.0.1
 */