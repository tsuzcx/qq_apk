package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.pluginsdk.n.c.a;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  implements n.c.a
{
  public final String ehc()
  {
    AppMethodBeat.i(29977);
    Object localObject = a.egV().ADZ.AEM;
    if (localObject != null)
    {
      localObject = ((drc)localObject).EGp + "\n" + ((drc)localObject).EGq + "\n" + ((drc)localObject).EGr;
      AppMethodBeat.o(29977);
      return localObject;
    }
    AppMethodBeat.o(29977);
    return "Not Connect";
  }
  
  public final void ehd()
  {
    AppMethodBeat.i(29978);
    a.egW().a(new com.tencent.mm.plugin.wear.model.f.a());
    AppMethodBeat.o(29978);
  }
  
  public final boolean ehe()
  {
    AppMethodBeat.i(29979);
    Object localObject = a.egV().ADZ.AEM;
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
        localObject = ((drc)localObject).EGm;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c
 * JD-Core Version:    0.7.0.1
 */