package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.plugin.music.e.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
{
  public static String aiM(String paramString)
  {
    AppMethodBeat.i(63092);
    f localf = k.cVi().tWk.cUT();
    if ((localf == null) || (!paramString.equalsIgnoreCase(localf.hnp)))
    {
      paramString = "0_" + ai.du(paramString);
      AppMethodBeat.o(63092);
      return paramString;
    }
    paramString = com.tencent.mm.plugin.music.h.b.N(localf);
    AppMethodBeat.o(63092);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.b
 * JD-Core Version:    0.7.0.1
 */