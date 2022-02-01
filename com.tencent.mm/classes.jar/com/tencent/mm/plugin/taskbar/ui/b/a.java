package com.tencent.mm.plugin.taskbar.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  private List<Double> MqB;
  public double MqC;
  public double kSF;
  public double kSG;
  
  public a()
  {
    AppMethodBeat.i(214892);
    this.MqB = new ArrayList(100);
    this.MqC = 0.0D;
    this.kSF = 1.7976931348623157E+308D;
    this.kSG = 4.9E-324D;
    AppMethodBeat.o(214892);
  }
  
  public final void aEV()
  {
    AppMethodBeat.i(214896);
    if (this.MqB == null)
    {
      AppMethodBeat.o(214896);
      return;
    }
    if (this.MqB.size() > 10000)
    {
      AppMethodBeat.o(214896);
      return;
    }
    if (this.MqB.size() != 0)
    {
      Iterator localIterator = this.MqB.iterator();
      double d2;
      for (double d1 = 0.0D; localIterator.hasNext(); d1 += d2)
      {
        d2 = ((Double)localIterator.next()).doubleValue();
        this.kSF = Math.min(this.kSF, d2);
        this.kSG = Math.max(this.kSG, d2);
      }
      this.MqC = (d1 / this.MqB.size());
    }
    AppMethodBeat.o(214896);
  }
  
  public final void aEW()
  {
    double d1 = 60.0D;
    double d2 = 0.0D;
    AppMethodBeat.i(214900);
    double d3 = c.MqD.jVQ;
    if (d3 > 60.0D) {}
    for (;;)
    {
      if (d1 < 0.0D) {
        d1 = d2;
      }
      for (;;)
      {
        this.MqB.add(Double.valueOf(d1));
        AppMethodBeat.o(214900);
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