package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.pluginsdk.o.c.a;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  implements o.c.a
{
  public final String eOk()
  {
    AppMethodBeat.i(29977);
    Object localObject = a.eOd().DOs.DPe;
    if (localObject != null)
    {
      localObject = ((eek)localObject).IiO + "\n" + ((eek)localObject).IiP + "\n" + ((eek)localObject).IiQ;
      AppMethodBeat.o(29977);
      return localObject;
    }
    AppMethodBeat.o(29977);
    return "Not Connect";
  }
  
  public final void eOl()
  {
    AppMethodBeat.i(29978);
    a.eOe().a(new com.tencent.mm.plugin.wear.model.f.a());
    AppMethodBeat.o(29978);
  }
  
  public final boolean eOm()
  {
    AppMethodBeat.i(29979);
    Object localObject = a.eOd().DOs.DPe;
    if ((bu.isNullOrNil(null)) && (bu.isNullOrNil(null)))
    {
      if (localObject != null)
      {
        AppMethodBeat.o(29979);
        return true;
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (bu.isNullOrNil(null))
    {
      if (localObject != null) {
        throw new NullPointerException();
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (bu.isNullOrNil(null))
    {
      if (localObject != null)
      {
        localObject = ((eek)localObject).IiL;
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