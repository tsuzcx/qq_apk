package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

final class c$1
  implements View.OnTouchListener
{
  c$1(c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if (paramMotionEvent.getAction() == 0)
    {
      this.xhH.xhF = false;
      this.xhH.vRH = paramMotionEvent.getX();
      if (this.xhH.xhE != null) {
        this.xhH.xhE.akz();
      }
      return true;
    }
    float f2;
    if (paramMotionEvent.getAction() == 2)
    {
      f2 = paramMotionEvent.getX();
      float f3 = this.xhH.ofo.getWidth();
      f2 = (int)(f2 - this.xhH.vRH + f3);
      if (f2 >= 0.0F) {}
    }
    for (;;)
    {
      this.xhH.xhG = (f1 * 100.0F / this.xhH.ofp.getWidth());
      this.xhH.c(this.xhH.xhG, true);
      if (this.xhH.xhE != null) {
        this.xhH.xhE.akz();
      }
      this.xhH.xhF = true;
      return true;
      if (f2 > this.xhH.ofp.getWidth())
      {
        f1 = this.xhH.ofp.getWidth();
        continue;
        if ((this.xhH.xhF) && (this.xhH.xhE != null)) {
          this.xhH.xhE.aT(this.xhH.xhG);
        }
        this.xhH.xhF = false;
        return true;
      }
      else
      {
        f1 = f2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c.1
 * JD-Core Version:    0.7.0.1
 */