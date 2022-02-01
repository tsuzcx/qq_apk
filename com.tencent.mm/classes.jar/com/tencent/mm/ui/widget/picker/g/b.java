package com.tencent.mm.ui.widget.picker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.WheelView.b;
import com.tencent.mm.ui.widget.picker.d.c;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.List;

public final class b<T>
{
  WheelView.b LxX;
  d LyM;
  WheelView LyQ;
  public WheelView LyR;
  private int iNG;
  float iOF;
  public List<T> iOY;
  public boolean iOZ = true;
  boolean iOh;
  
  @Deprecated
  private void aQE()
  {
    AppMethodBeat.i(200574);
    this.LyR.setDividerColor(this.iNG);
    AppMethodBeat.o(200574);
  }
  
  private void qZ(int paramInt)
  {
    AppMethodBeat.i(200577);
    if (this.iOY != null) {
      this.LyR.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(200577);
  }
  
  public final int[] aQF()
  {
    AppMethodBeat.i(200575);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.LyR.getCurrentItem();
    AppMethodBeat.o(200575);
    return arrayOfInt;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200579);
    this.LyR.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(200579);
  }
  
  public final void qY(int paramInt)
  {
    AppMethodBeat.i(200576);
    if (this.iOZ)
    {
      qZ(paramInt);
      AppMethodBeat.o(200576);
      return;
    }
    this.LyR.setCurrentItem(paramInt);
    AppMethodBeat.o(200576);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(200578);
    this.iNG = paramInt;
    aQE();
    AppMethodBeat.o(200578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.b
 * JD-Core Version:    0.7.0.1
 */