package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.pluginsdk.o.c.a;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  implements o.c.a
{
  public final String eKC()
  {
    AppMethodBeat.i(29977);
    Object localObject = a.eKv().DwN.Dxz;
    if (localObject != null)
    {
      localObject = ((ect)localObject).HOH + "\n" + ((ect)localObject).HOI + "\n" + ((ect)localObject).HOJ;
      AppMethodBeat.o(29977);
      return localObject;
    }
    AppMethodBeat.o(29977);
    return "Not Connect";
  }
  
  public final void eKD()
  {
    AppMethodBeat.i(29978);
    a.eKw().a(new com.tencent.mm.plugin.wear.model.f.a());
    AppMethodBeat.o(29978);
  }
  
  public final boolean eKE()
  {
    AppMethodBeat.i(29979);
    Object localObject = a.eKv().DwN.Dxz;
    if ((bt.isNullOrNil(null)) && (bt.isNullOrNil(null)))
    {
      if (localObject != null)
      {
        AppMethodBeat.o(29979);
        return true;
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (bt.isNullOrNil(null))
    {
      if (localObject != null) {
        throw new NullPointerException();
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (bt.isNullOrNil(null))
    {
      if (localObject != null)
      {
        localObject = ((ect)localObject).HOE;
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