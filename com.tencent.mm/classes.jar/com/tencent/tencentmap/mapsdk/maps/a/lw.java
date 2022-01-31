package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class lw
{
  public double a;
  public double b;
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149250);
    if (this == paramObject)
    {
      AppMethodBeat.o(149250);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(149250);
      return false;
    }
    paramObject = (lw)paramObject;
    if (Double.compare(paramObject.a, this.a) != 0)
    {
      AppMethodBeat.o(149250);
      return false;
    }
    if (Double.compare(paramObject.b, this.b) != 0)
    {
      AppMethodBeat.o(149250);
      return false;
    }
    AppMethodBeat.o(149250);
    return true;
  }
  
  public int hashCode()
  {
    long l2 = 0L;
    AppMethodBeat.i(149251);
    if (this.a != 0.0D) {}
    for (long l1 = Double.doubleToLongBits(this.a);; l1 = 0L)
    {
      long l3 = (int)l1 * 31;
      l1 = l2;
      if (this.b != 0.0D) {
        l1 = Double.doubleToLongBits(this.b);
      }
      int i = (int)(l3 + l1);
      AppMethodBeat.o(149251);
      return i;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(149252);
    String str = this.a + "," + this.b;
    AppMethodBeat.o(149252);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lw
 * JD-Core Version:    0.7.0.1
 */