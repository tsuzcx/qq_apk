package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class da$a
{
  private double a = (1.0D / 0.0D);
  private double b = (-1.0D / 0.0D);
  private double c = (0.0D / 0.0D);
  private double d = (0.0D / 0.0D);
  
  private boolean a(double paramDouble)
  {
    if (this.c <= this.d) {
      if ((this.c > paramDouble) || (paramDouble > this.d)) {}
    }
    while ((this.c <= paramDouble) || (paramDouble <= this.d))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final a a(cz paramcz)
  {
    AppMethodBeat.i(150036);
    this.a = Math.min(this.a, paramcz.a);
    this.b = Math.max(this.b, paramcz.a);
    double d1 = paramcz.b;
    if (Double.isNaN(this.c))
    {
      this.c = d1;
      this.d = d1;
    }
    for (;;)
    {
      AppMethodBeat.o(150036);
      return this;
      if (!a(d1))
      {
        if (da.a(this.c, d1) >= da.b(this.d, d1)) {
          break;
        }
        this.c = d1;
      }
    }
  }
  
  public final a a(Iterable<cz> paramIterable)
  {
    AppMethodBeat.i(150037);
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((cz)paramIterable.next());
      }
    }
    AppMethodBeat.o(150037);
    return this;
  }
  
  public final da a()
  {
    AppMethodBeat.i(150038);
    da localda = new da(new cz(this.a, this.c), new cz(this.b, this.d));
    AppMethodBeat.o(150038);
    return localda;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.da.a
 * JD-Core Version:    0.7.0.1
 */