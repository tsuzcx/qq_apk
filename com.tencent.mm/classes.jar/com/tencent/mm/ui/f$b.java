package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$b<K, T>
{
  public K object;
  public int yVM;
  public T yVN;
  
  public f$b(K paramK, int paramInt)
  {
    this.object = paramK;
    this.yVM = paramInt;
    this.yVN = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(29174);
    if (this == paramObject)
    {
      AppMethodBeat.o(29174);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(29174);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(29174);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.yVM != paramObject.yVM)
    {
      AppMethodBeat.o(29174);
      return false;
    }
    if (this.object == null)
    {
      if (paramObject.object != null)
      {
        AppMethodBeat.o(29174);
        return false;
      }
    }
    else if (!this.object.equals(paramObject.object))
    {
      AppMethodBeat.o(29174);
      return false;
    }
    AppMethodBeat.o(29174);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(29173);
    int j = this.yVM;
    if (this.object == null) {}
    for (int i = 0;; i = this.object.hashCode())
    {
      AppMethodBeat.o(29173);
      return i + (j + 31) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.f.b
 * JD-Core Version:    0.7.0.1
 */