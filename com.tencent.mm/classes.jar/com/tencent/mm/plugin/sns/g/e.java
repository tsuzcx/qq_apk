package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.d;

public final class e
{
  public static void aba(String paramString)
  {
    AppMethodBeat.i(36804);
    ab.i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.model.c.c.abU().me(paramString);
    if (!paramString.isValid()) {
      ab.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
    }
    if (paramString.dvN() != null) {
      ab.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + paramString.field_rawXML);
    }
    AppMethodBeat.o(36804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.e
 * JD-Core Version:    0.7.0.1
 */