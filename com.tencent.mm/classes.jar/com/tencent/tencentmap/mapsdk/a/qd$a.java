package com.tencent.tencentmap.mapsdk.a;

import java.util.Iterator;

public final class qd$a
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
  
  public final a a(qc paramqc)
  {
    this.a = Math.min(this.a, paramqc.a);
    this.b = Math.max(this.b, paramqc.a);
    double d1 = paramqc.b;
    if (Double.isNaN(this.c)) {
      this.c = d1;
    }
    do
    {
      this.d = d1;
      do
      {
        return this;
      } while (a(d1));
    } while (qd.a(this.c, d1) >= qd.b(this.d, d1));
    this.c = d1;
    return this;
  }
  
  public final a a(Iterable<qc> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((qc)paramIterable.next());
      }
    }
    return this;
  }
  
  public final qd a()
  {
    return new qd(new qc(this.a, this.c), new qc(this.b, this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qd.a
 * JD-Core Version:    0.7.0.1
 */