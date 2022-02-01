package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.pluginsdk.n.c.a;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  implements n.c.a
{
  public final String eww()
  {
    AppMethodBeat.i(29977);
    Object localObject = a.ewp().BWt.BXg;
    if (localObject != null)
    {
      localObject = ((dwt)localObject).GdB + "\n" + ((dwt)localObject).GdC + "\n" + ((dwt)localObject).GdD;
      AppMethodBeat.o(29977);
      return localObject;
    }
    AppMethodBeat.o(29977);
    return "Not Connect";
  }
  
  public final void ewx()
  {
    AppMethodBeat.i(29978);
    a.ewq().a(new com.tencent.mm.plugin.wear.model.f.a());
    AppMethodBeat.o(29978);
  }
  
  public final boolean ewy()
  {
    AppMethodBeat.i(29979);
    Object localObject = a.ewp().BWt.BXg;
    if ((bs.isNullOrNil(null)) && (bs.isNullOrNil(null)))
    {
      if (localObject != null)
      {
        AppMethodBeat.o(29979);
        return true;
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (bs.isNullOrNil(null))
    {
      if (localObject != null) {
        throw new NullPointerException();
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (bs.isNullOrNil(null))
    {
      if (localObject != null)
      {
        localObject = ((dwt)localObject).Gdy;
        throw new NullPointerException();
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (localObject != null) {
      throw new NullPointerException();
    }
    AppMethodBeat.o(29979);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c
 * JD-Core Version:    0.7.0.1
 */