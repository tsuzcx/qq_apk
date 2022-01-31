package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$a
{
  public int height;
  public int width;
  
  f$a(f paramf, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(86592);
    if (this == paramObject)
    {
      AppMethodBeat.o(86592);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(86592);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.width != paramObject.width)
    {
      AppMethodBeat.o(86592);
      return false;
    }
    if (this.height == paramObject.height)
    {
      AppMethodBeat.o(86592);
      return true;
    }
    AppMethodBeat.o(86592);
    return false;
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.util.f.a
 * JD-Core Version:    0.7.0.1
 */