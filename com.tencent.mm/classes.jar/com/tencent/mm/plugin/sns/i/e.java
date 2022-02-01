package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.c;

public final class e
{
  public static void aph(String paramString)
  {
    AppMethodBeat.i(96132);
    ad.i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.model.c.d.aty().qu(paramString);
    if (!paramString.isValid()) {
      ad.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
    }
    if (paramString.eJy() != null) {
      ad.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + paramString.field_rawXML);
    }
    AppMethodBeat.o(96132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.e
 * JD-Core Version:    0.7.0.1
 */