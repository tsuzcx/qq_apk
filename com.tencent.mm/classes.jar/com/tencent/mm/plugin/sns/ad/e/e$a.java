package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  public String DsJ;
  public int weAppType;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201906);
    if (this == paramObject)
    {
      AppMethodBeat.o(201906);
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((this.weAppType == paramObject.weAppType) && (this.DsJ != null) && (this.DsJ.equals(paramObject.DsJ)))
      {
        AppMethodBeat.o(201906);
        return true;
      }
    }
    AppMethodBeat.o(201906);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201907);
    String str = this.DsJ + "|" + this.weAppType;
    AppMethodBeat.o(201907);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.e.a
 * JD-Core Version:    0.7.0.1
 */