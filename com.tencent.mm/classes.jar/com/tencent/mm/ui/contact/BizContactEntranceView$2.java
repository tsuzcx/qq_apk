package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class BizContactEntranceView$2
  implements View.OnTouchListener
{
  BizContactEntranceView$2(BizContactEntranceView paramBizContactEntranceView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37658);
    if ((BizContactEntranceView.a(this.XqO) instanceof MMActivity)) {
      ((MMActivity)BizContactEntranceView.a(this.XqO)).hideVKB();
    }
    AppMethodBeat.o(37658);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView.2
 * JD-Core Version:    0.7.0.1
 */