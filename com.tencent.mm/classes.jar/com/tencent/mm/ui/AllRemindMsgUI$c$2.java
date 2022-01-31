package com.tencent.mm.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AllRemindMsgUI$c$2
  implements View.OnTouchListener
{
  AllRemindMsgUI$c$2(AllRemindMsgUI.c paramc, AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(29122);
    paramView.setTag(2131820681, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    AppMethodBeat.o(29122);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c.2
 * JD-Core Version:    0.7.0.1
 */