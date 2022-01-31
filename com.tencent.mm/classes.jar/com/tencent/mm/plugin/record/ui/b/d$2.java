package com.tencent.mm.plugin.record.ui.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class d$2
  implements View.OnTouchListener
{
  d$2(d paramd) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.nuF.idy = ((int)paramMotionEvent.getRawX());
      this.nuF.idz = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.2
 * JD-Core Version:    0.7.0.1
 */