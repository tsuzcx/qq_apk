package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MainUI$16
  implements View.OnTouchListener
{
  MainUI$16(MainUI paramMainUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282795);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(282795);
      return false;
      this.XCY.hideVKB();
      MainUI.e(this.XCY)[0] = ((int)paramMotionEvent.getRawX());
      MainUI.e(this.XCY)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.16
 * JD-Core Version:    0.7.0.1
 */