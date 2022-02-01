package com.tencent.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  public boolean isExclusive = true;
  public boolean isInternal = true;
  public boolean isSelected = false;
  public String name = "";
  public int trackType = 0;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194536);
    if ((paramObject == null) || (!(paramObject instanceof n)))
    {
      AppMethodBeat.o(194536);
      return false;
    }
    if ((this.name.equals(((n)paramObject).name)) && (this.trackType == ((n)paramObject).trackType))
    {
      AppMethodBeat.o(194536);
      return true;
    }
    AppMethodBeat.o(194536);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.b.n
 * JD-Core Version:    0.7.0.1
 */