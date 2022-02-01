package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class a
  extends TimerTask
{
  private final WheelView HKt;
  private float hRn;
  private final float hRo;
  
  public a(WheelView paramWheelView, float paramFloat)
  {
    this.HKt = paramWheelView;
    this.hRo = paramFloat;
    this.hRn = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(195370);
    if (this.hRn == 2.147484E+009F)
    {
      if (Math.abs(this.hRo) <= 2000.0F) {
        break label103;
      }
      if (this.hRo <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.hRn = f1;; this.hRn = this.hRo)
    {
      if ((Math.abs(this.hRn) < 0.0F) || (Math.abs(this.hRn) > 20.0F)) {
        break label114;
      }
      this.HKt.aFS();
      this.HKt.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(195370);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.hRn / 100.0F);
    this.HKt.setTotalScrollY(this.HKt.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.HKt.hyg)
    {
      f5 = this.HKt.getItemHeight();
      f3 = -this.HKt.getInitPosition() * f5;
      f4 = (this.HKt.getItemsCount() - 1 - this.HKt.getInitPosition()) * f5;
      if (this.HKt.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.HKt.getTotalScrollY() + i;
        f1 = f4;
        if (this.HKt.getTotalScrollY() > f2) {
          break label347;
        }
        this.hRn = 40.0F;
        this.HKt.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.hRn >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.hRn += 20.0F;; this.hRn -= 20.0F)
    {
      this.HKt.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(195370);
      return;
      f1 = f4;
      f2 = f3;
      if (this.HKt.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.HKt.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.HKt.getTotalScrollY() < f1) {
        break label262;
      }
      this.HKt.setTotalScrollY((int)f1);
      this.hRn = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.a
 * JD-Core Version:    0.7.0.1
 */