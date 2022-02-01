package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g$b<K, T>
{
  public int adxx;
  public T adxy;
  public K object;
  
  public g$b(K paramK, int paramInt)
  {
    this.object = paramK;
    this.adxx = paramInt;
    this.adxy = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(32999);
    if (this == paramObject)
    {
      AppMethodBeat.o(32999);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(32999);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(32999);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.adxx != paramObject.adxx)
    {
      AppMethodBeat.o(32999);
      return false;
    }
    if (this.object == null)
    {
      if (paramObject.object != null)
      {
        AppMethodBeat.o(32999);
        return false;
      }
    }
    else if (!this.object.equals(paramObject.object))
    {
      AppMethodBeat.o(32999);
      return false;
    }
    AppMethodBeat.o(32999);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(32998);
    int j = this.adxx;
    if (this.object == null) {}
    for (int i = 0;; i = this.object.hashCode())
    {
      AppMethodBeat.o(32998);
      return i + (j + 31) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.g.b
 * JD-Core Version:    0.7.0.1
 */