package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.pluginsdk.p.c.a;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  implements p.c.a
{
  public final String cYA()
  {
    AppMethodBeat.i(26286);
    Object localObject = a.cYy().uGC.uGT.uHH;
    if (localObject != null)
    {
      localObject = ((cwy)localObject).yeF + "\n" + ((cwy)localObject).yeG + "\n" + ((cwy)localObject).yeH;
      AppMethodBeat.o(26286);
      return localObject;
    }
    AppMethodBeat.o(26286);
    return "Not Connect";
  }
  
  public final void cYB()
  {
    AppMethodBeat.i(26287);
    a.cYy().uGI.a(new com.tencent.mm.plugin.wear.model.f.a());
    AppMethodBeat.o(26287);
  }
  
  public final boolean cYC()
  {
    AppMethodBeat.i(26288);
    Object localObject = a.cYy().uGC.uGT.uHH;
    if ((bo.isNullOrNil(null)) && (bo.isNullOrNil(null)))
    {
      if (localObject != null)
      {
        AppMethodBeat.o(26288);
        return true;
      }
      AppMethodBeat.o(26288);
      return false;
    }
    if (bo.isNullOrNil(null))
    {
      if (localObject != null) {
        throw new NullPointerException();
      }
      AppMethodBeat.o(26288);
      return false;
    }
    if (bo.isNullOrNil(null))
    {
      if (localObject != null)
      {
        localObject = ((cwy)localObject).yeC;
        throw new NullPointerException();
      }
      AppMethodBeat.o(26288);
      return false;
    }
    if (localObject != null) {
      throw new NullPointerException();
    }
    AppMethodBeat.o(26288);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c
 * JD-Core Version:    0.7.0.1
 */