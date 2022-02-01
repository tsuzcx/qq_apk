package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  public final double a;
  public final double b;
  
  public b(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    return (this.a == ((b)paramObject).a) && (this.b == ((b)paramObject).b);
  }
  
  public String toString()
  {
    AppMethodBeat.i(199645);
    String str = "Point{x=" + this.a + ", y=" + this.b + '}';
    AppMethodBeat.o(199645);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b
 * JD-Core Version:    0.7.0.1
 */