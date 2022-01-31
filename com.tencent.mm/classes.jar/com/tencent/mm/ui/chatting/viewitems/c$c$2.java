package com.tencent.mm.ui.chatting.viewitems;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class c$c$2
  implements View.OnTouchListener
{
  c$c$2(c.c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    c.c.a(this.vBh, (int)paramMotionEvent.getRawX());
    c.c.b(this.vBh, (int)paramMotionEvent.getRawY());
    c.c.a(this.vBh, paramView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.c.2
 * JD-Core Version:    0.7.0.1
 */