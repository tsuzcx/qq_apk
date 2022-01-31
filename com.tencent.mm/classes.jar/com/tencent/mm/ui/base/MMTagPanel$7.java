package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.tools.f;

final class MMTagPanel$7
  implements View.OnTouchListener
{
  MMTagPanel$7(MMTagPanel paramMMTagPanel, MMTagPanel.c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (MMTagPanel.g(this.uYn))
    {
      paramMotionEvent = this.uYn.getEditText();
      if (!bk.bl(paramMotionEvent))
      {
        paramView = paramMotionEvent;
        if (this.uYo != null)
        {
          paramView = paramMotionEvent;
          if (f.aek(paramMotionEvent) > this.uYo.uYu)
          {
            int i = this.uYo.uYu - f.ael(paramMotionEvent);
            paramView = paramMotionEvent;
            if (i <= paramMotionEvent.length()) {
              paramView = paramMotionEvent.substring(0, i);
            }
          }
        }
        this.uYn.bH(paramView, true);
        if (MMTagPanel.e(this.uYn) != null) {
          MMTagPanel.e(this.uYn).Bg(paramView);
        }
        this.uYn.cAZ();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.7
 * JD-Core Version:    0.7.0.1
 */