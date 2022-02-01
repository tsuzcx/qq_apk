package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView LyN;
  private int iNr;
  private int iNs;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.LyN = paramWheelView;
    this.offset = paramInt;
    this.iNr = 2147483647;
    this.iNs = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(200566);
    if (this.iNr == 2147483647) {
      this.iNr = this.offset;
    }
    this.iNs = ((int)(this.iNr * 0.1F));
    if (this.iNs == 0) {
      if (this.iNr >= 0) {
        break label92;
      }
    }
    label92:
    for (this.iNs = -1; Math.abs(this.iNr) <= 1; this.iNs = 1)
    {
      this.LyN.aQp();
      this.LyN.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(200566);
      return;
    }
    this.LyN.setTotalScrollY(this.LyN.getTotalScrollY() + this.iNs);
    if (!this.LyN.iuX)
    {
      float f1 = this.LyN.getItemHeight();
      float f2 = -this.LyN.getInitPosition();
      float f3 = this.LyN.getItemsCount() - 1 - this.LyN.getInitPosition();
      if ((this.LyN.getTotalScrollY() <= f2 * f1) || (this.LyN.getTotalScrollY() >= f1 * f3))
      {
        this.LyN.setTotalScrollY(this.LyN.getTotalScrollY() - this.iNs);
        this.LyN.aQp();
        this.LyN.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(200566);
        return;
      }
    }
    this.LyN.getHandler().sendEmptyMessage(1000);
    this.iNr -= this.iNs;
    AppMethodBeat.o(200566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.c
 * JD-Core Version:    0.7.0.1
 */