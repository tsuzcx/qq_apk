package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ly
{
  private DoublePoint a;
  private double b;
  
  public ly(lw paramlw, double paramDouble)
  {
    AppMethodBeat.i(149262);
    this.a = new DoublePoint(paramlw.a, paramlw.b);
    this.b = paramDouble;
    AppMethodBeat.o(149262);
  }
  
  public DoublePoint a()
  {
    return this.a;
  }
  
  public void a(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public double b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149259);
    if (((paramObject instanceof ly)) && (((ly)paramObject).a.equals(this.a)))
    {
      AppMethodBeat.o(149259);
      return true;
    }
    AppMethodBeat.o(149259);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(149260);
    int i = this.a.hashCode();
    AppMethodBeat.o(149260);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(149261);
    String str = "x:" + this.a.x + ", y:" + this.a.y;
    AppMethodBeat.o(149261);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ly
 * JD-Core Version:    0.7.0.1
 */