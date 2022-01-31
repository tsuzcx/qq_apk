package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements View.OnTouchListener
{
  c$1(c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(84564);
    if (paramMotionEvent.getAction() == 0)
    {
      this.BEU.BES = false;
      this.BEU.Ajw = paramMotionEvent.getX();
      if (this.BEU.BER != null) {
        this.BEU.BER.aFf();
      }
      AppMethodBeat.o(84564);
      return true;
    }
    float f2;
    if (paramMotionEvent.getAction() == 2)
    {
      f2 = paramMotionEvent.getX();
      float f3 = this.BEU.qTC.getWidth();
      f2 = (int)(f2 - this.BEU.Ajw + f3);
      if (f2 >= 0.0F) {}
    }
    for (;;)
    {
      this.BEU.BET = (f1 * 100.0F / this.BEU.qTD.getWidth());
      this.BEU.c(this.BEU.BET, true);
      if (this.BEU.BER != null) {
        this.BEU.BER.aFf();
      }
      this.BEU.BES = true;
      break;
      if (f2 > this.BEU.qTD.getWidth())
      {
        f1 = this.BEU.qTD.getWidth();
        continue;
        if ((this.BEU.BES) && (this.BEU.BER != null)) {
          this.BEU.BER.bE(this.BEU.BET);
        }
        this.BEU.BES = false;
        break;
      }
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c.1
 * JD-Core Version:    0.7.0.1
 */