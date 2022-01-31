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
    AppMethodBeat.i(33540);
    if ((BizContactEntranceView.a(this.Abv) instanceof MMActivity)) {
      ((MMActivity)BizContactEntranceView.a(this.Abv)).hideVKB();
    }
    AppMethodBeat.o(33540);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView.2
 * JD-Core Version:    0.7.0.1
 */