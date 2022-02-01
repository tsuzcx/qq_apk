package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView Lcm;
  private int iKy;
  private int iKz;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.Lcm = paramWheelView;
    this.offset = paramInt;
    this.iKy = 2147483647;
    this.iKz = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(192793);
    if (this.iKy == 2147483647) {
      this.iKy = this.offset;
    }
    this.iKz = ((int)(this.iKy * 0.1F));
    if (this.iKz == 0) {
      if (this.iKy >= 0) {
        break label92;
      }
    }
    label92:
    for (this.iKz = -1; Math.abs(this.iKy) <= 1; this.iKz = 1)
    {
      this.Lcm.aPQ();
      this.Lcm.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(192793);
      return;
    }
    this.Lcm.setTotalScrollY(this.Lcm.getTotalScrollY() + this.iKz);
    if (!this.Lcm.isd)
    {
      float f1 = this.Lcm.getItemHeight();
      float f2 = -this.Lcm.getInitPosition();
      float f3 = this.Lcm.getItemsCount() - 1 - this.Lcm.getInitPosition();
      if ((this.Lcm.getTotalScrollY() <= f2 * f1) || (this.Lcm.getTotalScrollY() >= f1 * f3))
      {
        this.Lcm.setTotalScrollY(this.Lcm.getTotalScrollY() - this.iKz);
        this.Lcm.aPQ();
        this.Lcm.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(192793);
        return;
      }
    }
    this.Lcm.getHandler().sendEmptyMessage(1000);
    this.iKy -= this.iKz;
    AppMethodBeat.o(192793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.c
 * JD-Core Version:    0.7.0.1
 */