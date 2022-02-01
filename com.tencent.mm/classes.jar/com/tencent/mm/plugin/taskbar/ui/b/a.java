package com.tencent.mm.plugin.taskbar.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  private List<Double> STN;
  public double STO;
  public double nyq;
  public double nyr;
  
  public a()
  {
    AppMethodBeat.i(264179);
    this.STN = new ArrayList(100);
    this.STO = 0.0D;
    this.nyq = 1.7976931348623157E+308D;
    this.nyr = 4.9E-324D;
    AppMethodBeat.o(264179);
  }
  
  public final void aXX()
  {
    AppMethodBeat.i(264195);
    if (this.STN == null)
    {
      AppMethodBeat.o(264195);
      return;
    }
    if (this.STN.size() > 10000)
    {
      AppMethodBeat.o(264195);
      return;
    }
    if (this.STN.size() != 0)
    {
      Iterator localIterator = this.STN.iterator();
      double d2;
      for (double d1 = 0.0D; localIterator.hasNext(); d1 += d2)
      {
        d2 = ((Double)localIterator.next()).doubleValue();
        this.nyq = Math.min(this.nyq, d2);
        this.nyr = Math.max(this.nyr, d2);
      }
      this.STO = (d1 / this.STN.size());
    }
    AppMethodBeat.o(264195);
  }
  
  public final void aXY()
  {
    double d1 = 60.0D;
    double d2 = 0.0D;
    AppMethodBeat.i(264203);
    double d3 = c.STP.mvK;
    if (d3 > 60.0D) {}
    for (;;)
    {
      if (d1 < 0.0D) {
        d1 = d2;
      }
      for (;;)
      {
        this.STN.add(Double.valueOf(d1));
        AppMethodBeat.o(264203);
        return;
      }
      d1 = d3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.b.a
 * JD-Core Version:    0.7.0.1
 */