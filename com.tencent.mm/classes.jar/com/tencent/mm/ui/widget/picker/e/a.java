package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class a
  extends TimerTask
{
  private final WheelView JkQ;
  private float irs;
  private final float irt;
  
  public a(WheelView paramWheelView, float paramFloat)
  {
    this.JkQ = paramWheelView;
    this.irt = paramFloat;
    this.irs = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(199841);
    if (this.irs == 2.147484E+009F)
    {
      if (Math.abs(this.irt) <= 2000.0F) {
        break label103;
      }
      if (this.irt <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.irs = f1;; this.irs = this.irt)
    {
      if ((Math.abs(this.irs) < 0.0F) || (Math.abs(this.irs) > 20.0F)) {
        break label114;
      }
      this.JkQ.aMF();
      this.JkQ.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(199841);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.irs / 100.0F);
    this.JkQ.setTotalScrollY(this.JkQ.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.JkQ.hYH)
    {
      f5 = this.JkQ.getItemHeight();
      f3 = -this.JkQ.getInitPosition() * f5;
      f4 = (this.JkQ.getItemsCount() - 1 - this.JkQ.getInitPosition()) * f5;
      if (this.JkQ.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.JkQ.getTotalScrollY() + i;
        f1 = f4;
        if (this.JkQ.getTotalScrollY() > f2) {
          break label347;
        }
        this.irs = 40.0F;
        this.JkQ.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.irs >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.irs += 20.0F;; this.irs -= 20.0F)
    {
      this.JkQ.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(199841);
      return;
      f1 = f4;
      f2 = f3;
      if (this.JkQ.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.JkQ.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.JkQ.getTotalScrollY() < f1) {
        break label262;
      }
      this.JkQ.setTotalScrollY((int)f1);
      this.irs = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.a
 * JD-Core Version:    0.7.0.1
 */