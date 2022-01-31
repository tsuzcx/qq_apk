package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.e.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ag;

public final class b
{
  public static String Vz(String paramString)
  {
    AppMethodBeat.i(104961);
    e locale = k.bVH().oZe.bVs();
    if ((locale == null) || (!paramString.equalsIgnoreCase(locale.fKj)))
    {
      paramString = "0_" + ag.cE(paramString);
      AppMethodBeat.o(104961);
      return paramString;
    }
    paramString = com.tencent.mm.plugin.music.h.b.K(locale);
    AppMethodBeat.o(104961);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.b
 * JD-Core Version:    0.7.0.1
 */