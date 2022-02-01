package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.e.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  public static String anH(String paramString)
  {
    AppMethodBeat.i(63092);
    f localf = k.diO().veU.diz();
    if ((localf == null) || (!paramString.equalsIgnoreCase(localf.hNS)))
    {
      paramString = "0_" + ah.dg(paramString);
      AppMethodBeat.o(63092);
      return paramString;
    }
    paramString = com.tencent.mm.plugin.music.h.b.O(localf);
    AppMethodBeat.o(63092);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.b
 * JD-Core Version:    0.7.0.1
 */