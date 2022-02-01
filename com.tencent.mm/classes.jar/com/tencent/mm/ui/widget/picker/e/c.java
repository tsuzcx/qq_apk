package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView QUD;
  private int jKf;
  private int jKg;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.QUD = paramWheelView;
    this.offset = paramInt;
    this.jKf = 2147483647;
    this.jKg = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(198524);
    if (this.jKf == 2147483647) {
      this.jKf = this.offset;
    }
    this.jKg = ((int)(this.jKf * 0.1F));
    if (this.jKg == 0) {
      if (this.jKf >= 0) {
        break label92;
      }
    }
    label92:
    for (this.jKg = -1; Math.abs(this.jKf) <= 1; this.jKg = 1)
    {
      this.QUD.bkU();
      this.QUD.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(198524);
      return;
    }
    this.QUD.setTotalScrollY(this.QUD.getTotalScrollY() + this.jKg);
    if (!this.QUD.jqj)
    {
      float f1 = this.QUD.getItemHeight();
      float f2 = -this.QUD.getInitPosition();
      float f3 = this.QUD.getItemsCount() - 1 - this.QUD.getInitPosition();
      if ((this.QUD.getTotalScrollY() <= f2 * f1) || (this.QUD.getTotalScrollY() >= f1 * f3))
      {
        this.QUD.setTotalScrollY(this.QUD.getTotalScrollY() - this.jKg);
        this.QUD.bkU();
        this.QUD.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(198524);
        return;
      }
    }
    this.QUD.getHandler().sendEmptyMessage(1000);
    this.jKf -= this.jKg;
    AppMethodBeat.o(198524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.c
 * JD-Core Version:    0.7.0.1
 */