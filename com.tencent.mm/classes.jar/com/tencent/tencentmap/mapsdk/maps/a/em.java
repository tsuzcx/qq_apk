package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;

public final class em
  extends Number
{
  private final String a;
  
  public em(String paramString)
  {
    this.a = paramString;
  }
  
  public final double doubleValue()
  {
    AppMethodBeat.i(147601);
    double d = Double.parseDouble(this.a);
    AppMethodBeat.o(147601);
    return d;
  }
  
  public final float floatValue()
  {
    AppMethodBeat.i(147600);
    float f = Float.parseFloat(this.a);
    AppMethodBeat.o(147600);
    return f;
  }
  
  public final int intValue()
  {
    AppMethodBeat.i(147598);
    int i;
    try
    {
      i = Integer.parseInt(this.a);
      AppMethodBeat.o(147598);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        long l = Long.parseLong(this.a);
        i = (int)l;
        AppMethodBeat.o(147598);
        return i;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        i = new BigInteger(this.a).intValue();
        AppMethodBeat.o(147598);
      }
    }
    return i;
  }
  
  public final long longValue()
  {
    AppMethodBeat.i(147599);
    long l;
    try
    {
      l = Long.parseLong(this.a);
      AppMethodBeat.o(147599);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      l = new BigInteger(this.a).longValue();
      AppMethodBeat.o(147599);
    }
    return l;
  }
  
  public final String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.em
 * JD-Core Version:    0.7.0.1
 */