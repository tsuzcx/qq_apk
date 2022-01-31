package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R.h;

public final class t$f
  implements View.OnTouchListener
{
  private int[] vkw = new int[2];
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    }
    this.vkw[0] = ((int)paramMotionEvent.getRawX());
    this.vkw[1] = ((int)paramMotionEvent.getRawY());
    paramView.setTag(R.h.touch_loc, this.vkw);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.f
 * JD-Core Version:    0.7.0.1
 */