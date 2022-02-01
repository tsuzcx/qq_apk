package com.tencent.mm.plugin.taskbar.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  private List<Double> FVg;
  public double FVh;
  public double idW;
  public double idX;
  
  public a()
  {
    AppMethodBeat.i(238313);
    this.FVg = new ArrayList(100);
    this.FVh = 0.0D;
    this.idW = 1.7976931348623157E+308D;
    this.idX = 4.9E-324D;
    AppMethodBeat.o(238313);
  }
  
  public final void axD()
  {
    AppMethodBeat.i(238314);
    if (this.FVg == null)
    {
      AppMethodBeat.o(238314);
      return;
    }
    if (this.FVg.size() > 10000)
    {
      AppMethodBeat.o(238314);
      return;
    }
    if (this.FVg.size() != 0)
    {
      Iterator localIterator = this.FVg.iterator();
      double d2;
      for (double d1 = 0.0D; localIterator.hasNext(); d1 += d2)
      {
        d2 = ((Double)localIterator.next()).doubleValue();
        this.idW = Math.min(this.idW, d2);
        this.idX = Math.max(this.idX, d2);
      }
      this.FVh = (d1 / this.FVg.size());
    }
    AppMethodBeat.o(238314);
  }
  
  public final void axE()
  {
    double d1 = 60.0D;
    double d2 = 0.0D;
    AppMethodBeat.i(238315);
    double d3 = c.FVi.hkh;
    if (d3 > 60.0D) {}
    for (;;)
    {
      if (d1 < 0.0D) {
        d1 = d2;
      }
      for (;;)
      {
        this.FVg.add(Double.valueOf(d1));
        AppMethodBeat.o(238315);
        return;
      }
      d1 = d3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.b.a
 * JD-Core Version:    0.7.0.1
 */