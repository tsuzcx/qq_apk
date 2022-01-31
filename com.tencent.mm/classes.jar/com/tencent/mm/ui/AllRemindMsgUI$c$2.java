package com.tencent.mm.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R.h;

final class AllRemindMsgUI$c$2
  implements View.OnTouchListener
{
  AllRemindMsgUI$c$2(AllRemindMsgUI.c paramc, AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    paramView.setTag(R.h.touch_loc, new int[] { i, j });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c.2
 * JD-Core Version:    0.7.0.1
 */