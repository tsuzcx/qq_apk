package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;

public final class e
{
  public static void aPM(String paramString)
  {
    AppMethodBeat.i(96132);
    Log.i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.model.c.d.aXu().Fu(paramString);
    if (!paramString.isValid()) {
      Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
    }
    if (paramString.gzz() != null) {
      Log.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + paramString.field_rawXML);
    }
    AppMethodBeat.o(96132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.e
 * JD-Core Version:    0.7.0.1
 */