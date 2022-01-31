package com.tencent.mm.plugin.sns.ui.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.sns.i.f;

final class a$1
  implements View.OnTouchListener
{
  a$1(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      paramView.setTag(i.f.touch_loc, new int[] { i, j });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.1
 * JD-Core Version:    0.7.0.1
 */