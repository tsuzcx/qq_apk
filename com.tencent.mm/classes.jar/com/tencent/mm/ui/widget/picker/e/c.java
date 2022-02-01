package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView HKs;
  private int hRq;
  private int hRr;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.HKs = paramWheelView;
    this.offset = paramInt;
    this.hRq = 2147483647;
    this.hRr = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(195372);
    if (this.hRq == 2147483647) {
      this.hRq = this.offset;
    }
    this.hRr = ((int)(this.hRq * 0.1F));
    if (this.hRr == 0) {
      if (this.hRq >= 0) {
        break label92;
      }
    }
    label92:
    for (this.hRr = -1; Math.abs(this.hRq) <= 1; this.hRr = 1)
    {
      this.HKs.aFS();
      this.HKs.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(195372);
      return;
    }
    this.HKs.setTotalScrollY(this.HKs.getTotalScrollY() + this.hRr);
    if (!this.HKs.hyg)
    {
      float f1 = this.HKs.getItemHeight();
      float f2 = -this.HKs.getInitPosition();
      float f3 = this.HKs.getItemsCount() - 1 - this.HKs.getInitPosition();
      if ((this.HKs.getTotalScrollY() <= f2 * f1) || (this.HKs.getTotalScrollY() >= f1 * f3))
      {
        this.HKs.setTotalScrollY(this.HKs.getTotalScrollY() - this.hRr);
        this.HKs.aFS();
        this.HKs.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(195372);
        return;
      }
    }
    this.HKs.getHandler().sendEmptyMessage(1000);
    this.hRq -= this.hRr;
    AppMethodBeat.o(195372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.c
 * JD-Core Version:    0.7.0.1
 */