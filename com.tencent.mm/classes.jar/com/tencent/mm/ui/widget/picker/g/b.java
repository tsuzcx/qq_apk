package com.tencent.mm.ui.widget.picker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.WheelView.b;
import com.tencent.mm.ui.widget.picker.d.c;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.List;

public final class b<T>
{
  WheelView.b HJC;
  d HKr;
  WheelView HKv;
  public WheelView HKw;
  private int hRF;
  float hSE;
  public List<T> hSX;
  public boolean hSY = true;
  boolean hSg;
  
  @Deprecated
  private void aGh()
  {
    AppMethodBeat.i(195380);
    this.HKw.setDividerColor(this.hRF);
    AppMethodBeat.o(195380);
  }
  
  private void pJ(int paramInt)
  {
    AppMethodBeat.i(195383);
    if (this.hSX != null) {
      this.HKw.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(195383);
  }
  
  public final int[] aGi()
  {
    AppMethodBeat.i(195381);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.HKw.getCurrentItem();
    AppMethodBeat.o(195381);
    return arrayOfInt;
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195385);
    this.HKw.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(195385);
  }
  
  public final void pI(int paramInt)
  {
    AppMethodBeat.i(195382);
    if (this.hSY)
    {
      pJ(paramInt);
      AppMethodBeat.o(195382);
      return;
    }
    this.HKw.setCurrentItem(paramInt);
    AppMethodBeat.o(195382);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(195384);
    this.hRF = paramInt;
    aGh();
    AppMethodBeat.o(195384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.b
 * JD-Core Version:    0.7.0.1
 */