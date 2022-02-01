package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h$a
{
  public int Jxz;
  public String Jzt;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(266957);
    if (this == paramObject)
    {
      AppMethodBeat.o(266957);
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((this.Jxz == paramObject.Jxz) && (this.Jzt != null) && (this.Jzt.equals(paramObject.Jzt)))
      {
        AppMethodBeat.o(266957);
        return true;
      }
    }
    AppMethodBeat.o(266957);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(266958);
    String str = this.Jzt + "|" + this.Jxz;
    AppMethodBeat.o(266958);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.h.a
 * JD-Core Version:    0.7.0.1
 */