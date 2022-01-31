package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class i
{
  public static boolean Iu()
  {
    AppMethodBeat.i(4368);
    if (bo.gz(bo.a((Long)g.RL().Ru().get(77828, null), 0L)) * 1000L > 1800000L)
    {
      AppMethodBeat.o(4368);
      return true;
    }
    AppMethodBeat.o(4368);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.i
 * JD-Core Version:    0.7.0.1
 */