package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dm
{
  public final cz a;
  public final cz b;
  public final cz c;
  public final cz d;
  public final da e;
  
  public dm(cz paramcz1, cz paramcz2, cz paramcz3, cz paramcz4, da paramda)
  {
    this.a = paramcz1;
    this.b = paramcz2;
    this.c = paramcz3;
    this.d = paramcz4;
    this.e = paramda;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(150120);
    if (this == paramObject)
    {
      AppMethodBeat.o(150120);
      return true;
    }
    if (!(paramObject instanceof dm))
    {
      AppMethodBeat.o(150120);
      return false;
    }
    paramObject = (dm)paramObject;
    if ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)) && (this.c.equals(paramObject.c)) && (this.d.equals(paramObject.d)) && (this.e.equals(paramObject.e)))
    {
      AppMethodBeat.o(150120);
      return true;
    }
    AppMethodBeat.o(150120);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150121);
    String str = "nearLeft" + this.a + "nearRight" + this.b + "farLeft" + this.c + "farRight" + this.d + "latLngBounds" + this.e;
    AppMethodBeat.o(150121);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dm
 * JD-Core Version:    0.7.0.1
 */