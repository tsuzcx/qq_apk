package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class k$7
  implements View.OnTouchListener
{
  k$7(k paramk) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    }
    this.vTA.hideVKB();
    k.f(this.vTA)[0] = ((int)paramMotionEvent.getRawX());
    k.f(this.vTA)[1] = ((int)paramMotionEvent.getRawY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.7
 * JD-Core Version:    0.7.0.1
 */