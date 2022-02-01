package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.pluginsdk.o.c.a;
import com.tencent.mm.protocal.protobuf.gfx;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  implements o.c.a
{
  public final String inR()
  {
    AppMethodBeat.i(29977);
    Object localObject = a.inI().Wiz.Wjk;
    if (localObject != null)
    {
      localObject = ((gfx)localObject).accL + "\n" + ((gfx)localObject).accM + "\n" + ((gfx)localObject).accN;
      AppMethodBeat.o(29977);
      return localObject;
    }
    AppMethodBeat.o(29977);
    return "Not Connect";
  }
  
  public final void inS()
  {
    AppMethodBeat.i(29978);
    a.inJ().a(new com.tencent.mm.plugin.wear.model.f.a());
    AppMethodBeat.o(29978);
  }
  
  public final boolean inT()
  {
    AppMethodBeat.i(29979);
    Object localObject = a.inI().Wiz.Wjk;
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
        localObject = ((gfx)localObject).accI;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c
 * JD-Core Version:    0.7.0.1
 */