package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.f;

final class MMTagPanel$7
  implements View.OnTouchListener
{
  MMTagPanel$7(MMTagPanel paramMMTagPanel, MMTagPanel.c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106816);
    if (MMTagPanel.g(this.zmE))
    {
      paramMotionEvent = this.zmE.getEditText();
      if (!bo.isNullOrNil(paramMotionEvent))
      {
        paramView = paramMotionEvent;
        if (this.zmF != null)
        {
          paramView = paramMotionEvent;
          if (f.auQ(paramMotionEvent) > this.zmF.zmK)
          {
            int i = this.zmF.zmK - f.auS(paramMotionEvent);
            paramView = paramMotionEvent;
            if (i < paramMotionEvent.length()) {
              paramView = paramMotionEvent.substring(0, i);
            }
          }
        }
        this.zmE.cj(paramView, true);
        if (MMTagPanel.e(this.zmE) != null) {
          MMTagPanel.e(this.zmE).Li(paramView);
        }
        this.zmE.dEm();
      }
    }
    AppMethodBeat.o(106816);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.7
 * JD-Core Version:    0.7.0.1
 */