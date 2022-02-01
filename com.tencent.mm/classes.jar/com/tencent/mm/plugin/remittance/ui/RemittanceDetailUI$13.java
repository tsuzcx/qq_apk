package com.tencent.mm.plugin.remittance.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceDetailUI$13
  implements View.OnTouchListener
{
  RemittanceDetailUI$13(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68138);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68138);
      return false;
      RemittanceDetailUI.a(this.wRp, (int)paramMotionEvent.getRawX());
      RemittanceDetailUI.b(this.wRp, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.13
 * JD-Core Version:    0.7.0.1
 */