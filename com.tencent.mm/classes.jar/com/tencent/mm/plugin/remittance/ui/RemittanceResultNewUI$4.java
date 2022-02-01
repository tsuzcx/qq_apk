package com.tencent.mm.plugin.remittance.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceResultNewUI$4
  implements View.OnTouchListener
{
  RemittanceResultNewUI$4(RemittanceResultNewUI paramRemittanceResultNewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68282);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68282);
      return false;
      RemittanceResultNewUI.a(this.Cxd, (int)paramMotionEvent.getRawX());
      RemittanceResultNewUI.b(this.Cxd, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.4
 * JD-Core Version:    0.7.0.1
 */