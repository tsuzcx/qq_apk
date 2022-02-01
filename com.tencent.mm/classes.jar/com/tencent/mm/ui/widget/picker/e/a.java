package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class a
  extends TimerTask
{
  private final WheelView Lcn;
  private float iKv;
  private final float iKw;
  
  public a(WheelView paramWheelView, float paramFloat)
  {
    this.Lcn = paramWheelView;
    this.iKw = paramFloat;
    this.iKv = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(192791);
    if (this.iKv == 2.147484E+009F)
    {
      if (Math.abs(this.iKw) <= 2000.0F) {
        break label103;
      }
      if (this.iKw <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.iKv = f1;; this.iKv = this.iKw)
    {
      if ((Math.abs(this.iKv) < 0.0F) || (Math.abs(this.iKv) > 20.0F)) {
        break label114;
      }
      this.Lcn.aPQ();
      this.Lcn.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(192791);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.iKv / 100.0F);
    this.Lcn.setTotalScrollY(this.Lcn.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.Lcn.isd)
    {
      f5 = this.Lcn.getItemHeight();
      f3 = -this.Lcn.getInitPosition() * f5;
      f4 = (this.Lcn.getItemsCount() - 1 - this.Lcn.getInitPosition()) * f5;
      if (this.Lcn.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.Lcn.getTotalScrollY() + i;
        f1 = f4;
        if (this.Lcn.getTotalScrollY() > f2) {
          break label347;
        }
        this.iKv = 40.0F;
        this.Lcn.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.iKv >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.iKv += 20.0F;; this.iKv -= 20.0F)
    {
      this.Lcn.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(192791);
      return;
      f1 = f4;
      f2 = f3;
      if (this.Lcn.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.Lcn.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.Lcn.getTotalScrollY() < f1) {
        break label262;
      }
      this.Lcn.setTotalScrollY((int)f1);
      this.iKv = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.a
 * JD-Core Version:    0.7.0.1
 */