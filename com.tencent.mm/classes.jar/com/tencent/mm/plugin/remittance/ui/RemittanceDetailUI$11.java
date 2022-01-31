package com.tencent.mm.plugin.remittance.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceDetailUI$11
  implements View.OnTouchListener
{
  RemittanceDetailUI$11(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(45007);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(45007);
      return false;
      RemittanceDetailUI.a(this.qpY, (int)paramMotionEvent.getRawX());
      RemittanceDetailUI.b(this.qpY, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.11
 * JD-Core Version:    0.7.0.1
 */