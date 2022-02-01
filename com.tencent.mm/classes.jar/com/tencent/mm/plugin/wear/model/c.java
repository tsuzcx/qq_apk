package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.pluginsdk.o.c.a;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  implements o.c.a
{
  public final String fVT()
  {
    AppMethodBeat.i(29977);
    Object localObject = a.fVM().IxH.Iyu;
    if (localObject != null)
    {
      localObject = ((eys)localObject).Nvs + "\n" + ((eys)localObject).Nvt + "\n" + ((eys)localObject).Nvu;
      AppMethodBeat.o(29977);
      return localObject;
    }
    AppMethodBeat.o(29977);
    return "Not Connect";
  }
  
  public final void fVU()
  {
    AppMethodBeat.i(29978);
    a.fVN().a(new com.tencent.mm.plugin.wear.model.f.a());
    AppMethodBeat.o(29978);
  }
  
  public final boolean fVV()
  {
    AppMethodBeat.i(29979);
    Object localObject = a.fVM().IxH.Iyu;
    if ((Util.isNullOrNil(null)) && (Util.isNullOrNil(null)))
    {
      if (localObject != null)
      {
        AppMethodBeat.o(29979);
        return true;
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (Util.isNullOrNil(null))
    {
      if (localObject != null) {
        throw new NullPointerException();
      }
      AppMethodBeat.o(29979);
      return false;
    }
    if (Util.isNullOrNil(null))
    {
      if (localObject != null)
      {
        localObject = ((eys)localObject).Nvp;
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