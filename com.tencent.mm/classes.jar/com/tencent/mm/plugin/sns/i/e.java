package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;

public final class e
{
  public static void aZg(String paramString)
  {
    AppMethodBeat.i(96132);
    Log.i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.model.newabtest.d.bEt().Fd(paramString);
    if (paramString == null)
    {
      Log.i("MicroMsg.SnsABTestStrategy", "abtest is null");
      AppMethodBeat.o(96132);
      return;
    }
    if (!paramString.isValid()) {
      Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
    }
    if (paramString.iWZ() != null) {
      Log.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + paramString.field_rawXML);
    }
    AppMethodBeat.o(96132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.e
 * JD-Core Version:    0.7.0.1
 */