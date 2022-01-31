package com.tencent.tencentmap.mapsdk.a;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class ry
  implements Cloneable
{
  private static DecimalFormat a = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
  private final double b;
  private final double c;
  
  public ry(double paramDouble1, double paramDouble2)
  {
    if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {}
    for (this.b = a(paramDouble2);; this.b = a(((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D))
    {
      this.c = a(Math.max(-85.0D, Math.min(85.0D, paramDouble1)));
      return;
    }
  }
  
  private static double a(double paramDouble)
  {
    return Double.parseDouble(a.format(paramDouble));
  }
  
  public final ry a()
  {
    return new ry(this.c, this.b);
  }
  
  public final double b()
  {
    return this.c;
  }
  
  public final double c()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ry)) {
        return false;
      }
      paramObject = (ry)paramObject;
    } while ((Double.doubleToLongBits(this.c) == Double.doubleToLongBits(paramObject.c)) && (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(paramObject.b)));
    return false;
  }
  
  public final int hashCode()
  {
    long l = Double.doubleToLongBits(this.c);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.b);
    return (i + 31) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    return "lat/lng: (" + this.c + "," + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ry
 * JD-Core Version:    0.7.0.1
 */