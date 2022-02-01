package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsMsgUI$16
  implements View.OnTouchListener
{
  SnsMsgUI$16(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(308561);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(308561);
      return false;
      this.RtY.hideVKB();
      SnsMsgUI.i(this.RtY)[0] = ((int)paramMotionEvent.getRawX());
      SnsMsgUI.i(this.RtY)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.16
 * JD-Core Version:    0.7.0.1
 */