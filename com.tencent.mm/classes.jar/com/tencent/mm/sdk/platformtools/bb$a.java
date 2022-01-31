package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class bb$a<V>
{
  final V ypP;
  
  bb$a(V paramV)
  {
    this.ypP = paramV;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(52241);
    if (paramObject == null)
    {
      AppMethodBeat.o(52241);
      return false;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(52241);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.ypP == null)
    {
      if (paramObject.ypP == null)
      {
        AppMethodBeat.o(52241);
        return true;
      }
      AppMethodBeat.o(52241);
      return false;
    }
    boolean bool = this.ypP.equals(paramObject.ypP);
    AppMethodBeat.o(52241);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bb.a
 * JD-Core Version:    0.7.0.1
 */