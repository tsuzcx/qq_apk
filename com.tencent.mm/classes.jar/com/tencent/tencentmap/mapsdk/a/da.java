package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class da
{
  public final cz a;
  public final cz b;
  
  public da(cz paramcz1, cz paramcz2)
  {
    this.a = paramcz1;
    this.b = paramcz2;
  }
  
  static double a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150041);
    paramDouble1 = c(paramDouble1, paramDouble2);
    AppMethodBeat.o(150041);
    return paramDouble1;
  }
  
  public static da.a a()
  {
    AppMethodBeat.i(150039);
    da.a locala = new da.a();
    AppMethodBeat.o(150039);
    return locala;
  }
  
  static double b(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150042);
    paramDouble1 = d(paramDouble1, paramDouble2);
    AppMethodBeat.o(150042);
    return paramDouble1;
  }
  
  private static double c(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  private static double d(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(150040);
    if (this == paramObject)
    {
      AppMethodBeat.o(150040);
      return true;
    }
    if (!(paramObject instanceof da))
    {
      AppMethodBeat.o(150040);
      return false;
    }
    paramObject = (da)paramObject;
    if ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)))
    {
      AppMethodBeat.o(150040);
      return true;
    }
    AppMethodBeat.o(150040);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.da
 * JD-Core Version:    0.7.0.1
 */