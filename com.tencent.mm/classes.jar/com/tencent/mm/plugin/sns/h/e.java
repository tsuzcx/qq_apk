package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.c;

public final class e
{
  public static void aAQ(String paramString)
  {
    AppMethodBeat.i(96132);
    ae.i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.model.c.d.aDI().xi(paramString);
    if (!paramString.isValid()) {
      ae.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
    }
    if (paramString.fsy() != null) {
      ae.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + paramString.field_rawXML);
    }
    AppMethodBeat.o(96132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.e
 * JD-Core Version:    0.7.0.1
 */