package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.c;

public final class e
{
  public static void aut(String paramString)
  {
    AppMethodBeat.i(96132);
    ac.i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.model.c.d.aAp().tJ(paramString);
    if (!paramString.isValid()) {
      ac.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
    }
    if (paramString.eYV() != null) {
      ac.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + paramString.field_rawXML);
    }
    AppMethodBeat.o(96132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.e
 * JD-Core Version:    0.7.0.1
 */