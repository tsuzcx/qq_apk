package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class SnsMsgUI$17
  implements View.OnTouchListener
{
  SnsMsgUI$17(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    }
    this.paq.XM();
    SnsMsgUI.j(this.paq)[0] = ((int)paramMotionEvent.getRawX());
    SnsMsgUI.j(this.paq)[1] = ((int)paramMotionEvent.getRawY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.17
 * JD-Core Version:    0.7.0.1
 */