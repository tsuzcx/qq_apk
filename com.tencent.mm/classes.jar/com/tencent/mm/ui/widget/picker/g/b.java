package com.tencent.mm.ui.widget.picker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.WheelView.b;
import com.tencent.mm.ui.widget.picker.d.c;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.List;

public final class b<T>
{
  WheelView.b Lbw;
  d Lcl;
  WheelView Lcp;
  public WheelView Lcq;
  private int iKN;
  float iLM;
  boolean iLo;
  public List<T> iMf;
  public boolean iMg = true;
  
  @Deprecated
  private void aQf()
  {
    AppMethodBeat.i(192801);
    this.Lcq.setDividerColor(this.iKN);
    AppMethodBeat.o(192801);
  }
  
  private void qW(int paramInt)
  {
    AppMethodBeat.i(192804);
    if (this.iMf != null) {
      this.Lcq.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(192804);
  }
  
  public final int[] aQg()
  {
    AppMethodBeat.i(192802);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.Lcq.getCurrentItem();
    AppMethodBeat.o(192802);
    return arrayOfInt;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192806);
    this.Lcq.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(192806);
  }
  
  public final void qV(int paramInt)
  {
    AppMethodBeat.i(192803);
    if (this.iMg)
    {
      qW(paramInt);
      AppMethodBeat.o(192803);
      return;
    }
    this.Lcq.setCurrentItem(paramInt);
    AppMethodBeat.o(192803);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(192805);
    this.iKN = paramInt;
    aQf();
    AppMethodBeat.o(192805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.b
 * JD-Core Version:    0.7.0.1
 */