package com.tencent.mm.ui.widget.picker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.WheelView.b;
import com.tencent.mm.ui.widget.picker.d.c;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.List;

public final class b<T>
{
  WheelView.b QTM;
  d QUC;
  WheelView QUG;
  public WheelView QUH;
  boolean jKW;
  private int jKu;
  public List<T> jLN;
  public boolean jLO = true;
  float jLu;
  
  @Deprecated
  private void blj()
  {
    AppMethodBeat.i(198532);
    this.QUH.setDividerColor(this.jKu);
    AppMethodBeat.o(198532);
  }
  
  private void uR(int paramInt)
  {
    AppMethodBeat.i(198535);
    if (this.jLN != null) {
      this.QUH.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(198535);
  }
  
  public final int[] blk()
  {
    AppMethodBeat.i(198533);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.QUH.getCurrentItem();
    AppMethodBeat.o(198533);
    return arrayOfInt;
  }
  
  public final void dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198537);
    this.QUH.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(198537);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(198536);
    this.jKu = paramInt;
    blj();
    AppMethodBeat.o(198536);
  }
  
  public final void uQ(int paramInt)
  {
    AppMethodBeat.i(198534);
    if (this.jLO)
    {
      uR(paramInt);
      AppMethodBeat.o(198534);
      return;
    }
    this.QUH.setCurrentItem(paramInt);
    AppMethodBeat.o(198534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.b
 * JD-Core Version:    0.7.0.1
 */