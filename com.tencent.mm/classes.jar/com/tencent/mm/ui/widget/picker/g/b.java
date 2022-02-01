package com.tencent.mm.ui.widget.picker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.WheelView.b;
import com.tencent.mm.ui.widget.picker.d.c;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.List;

public final class b<T>
{
  WheelView.b JjZ;
  d JkO;
  WheelView JkS;
  public WheelView JkT;
  private int irK;
  float isJ;
  boolean isl;
  public List<T> itc;
  public boolean itd = true;
  
  @Deprecated
  private void aMU()
  {
    AppMethodBeat.i(199851);
    this.JkT.setDividerColor(this.irK);
    AppMethodBeat.o(199851);
  }
  
  private void qw(int paramInt)
  {
    AppMethodBeat.i(199854);
    if (this.itc != null) {
      this.JkT.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(199854);
  }
  
  public final int[] aMV()
  {
    AppMethodBeat.i(199852);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.JkT.getCurrentItem();
    AppMethodBeat.o(199852);
    return arrayOfInt;
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199856);
    this.JkT.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(199856);
  }
  
  public final void qv(int paramInt)
  {
    AppMethodBeat.i(199853);
    if (this.itd)
    {
      qw(paramInt);
      AppMethodBeat.o(199853);
      return;
    }
    this.JkT.setCurrentItem(paramInt);
    AppMethodBeat.o(199853);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(199855);
    this.irK = paramInt;
    aMU();
    AppMethodBeat.o(199855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.b
 * JD-Core Version:    0.7.0.1
 */