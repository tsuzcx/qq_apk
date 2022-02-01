package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class a
  extends TimerTask
{
  private final WheelView QUE;
  private float jKc;
  private final float jKd;
  
  public a(WheelView paramWheelView, float paramFloat)
  {
    this.QUE = paramWheelView;
    this.jKd = paramFloat;
    this.jKc = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(198522);
    if (this.jKc == 2.147484E+009F)
    {
      if (Math.abs(this.jKd) <= 2000.0F) {
        break label103;
      }
      if (this.jKd <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.jKc = f1;; this.jKc = this.jKd)
    {
      if ((Math.abs(this.jKc) < 0.0F) || (Math.abs(this.jKc) > 20.0F)) {
        break label114;
      }
      this.QUE.bkU();
      this.QUE.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(198522);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.jKc / 100.0F);
    this.QUE.setTotalScrollY(this.QUE.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.QUE.jqj)
    {
      f5 = this.QUE.getItemHeight();
      f3 = -this.QUE.getInitPosition() * f5;
      f4 = (this.QUE.getItemsCount() - 1 - this.QUE.getInitPosition()) * f5;
      if (this.QUE.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.QUE.getTotalScrollY() + i;
        f1 = f4;
        if (this.QUE.getTotalScrollY() > f2) {
          break label347;
        }
        this.jKc = 40.0F;
        this.QUE.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.jKc >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.jKc += 20.0F;; this.jKc -= 20.0F)
    {
      this.QUE.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(198522);
      return;
      f1 = f4;
      f2 = f3;
      if (this.QUE.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.QUE.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.QUE.getTotalScrollY() < f1) {
        break label262;
      }
      this.QUE.setTotalScrollY((int)f1);
      this.jKc = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.a
 * JD-Core Version:    0.7.0.1
 */