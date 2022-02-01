package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView JkP;
  private int irv;
  private int irw;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.JkP = paramWheelView;
    this.offset = paramInt;
    this.irv = 2147483647;
    this.irw = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(199843);
    if (this.irv == 2147483647) {
      this.irv = this.offset;
    }
    this.irw = ((int)(this.irv * 0.1F));
    if (this.irw == 0) {
      if (this.irv >= 0) {
        break label92;
      }
    }
    label92:
    for (this.irw = -1; Math.abs(this.irv) <= 1; this.irw = 1)
    {
      this.JkP.aMF();
      this.JkP.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(199843);
      return;
    }
    this.JkP.setTotalScrollY(this.JkP.getTotalScrollY() + this.irw);
    if (!this.JkP.hYH)
    {
      float f1 = this.JkP.getItemHeight();
      float f2 = -this.JkP.getInitPosition();
      float f3 = this.JkP.getItemsCount() - 1 - this.JkP.getInitPosition();
      if ((this.JkP.getTotalScrollY() <= f2 * f1) || (this.JkP.getTotalScrollY() >= f1 * f3))
      {
        this.JkP.setTotalScrollY(this.JkP.getTotalScrollY() - this.irw);
        this.JkP.aMF();
        this.JkP.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(199843);
        return;
      }
    }
    this.JkP.getHandler().sendEmptyMessage(1000);
    this.irv -= this.irw;
    AppMethodBeat.o(199843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.c
 * JD-Core Version:    0.7.0.1
 */