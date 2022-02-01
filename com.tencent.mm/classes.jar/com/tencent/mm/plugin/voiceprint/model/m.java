package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah;
import com.tencent.mm.vfs.e;

public final class m
{
  public static String bW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29794);
    String str = ah.GDu;
    ac.i("MicroMsg.VoicePrintLogic", "dbCachePath ".concat(String.valueOf(str)));
    if (str.endsWith("/")) {}
    for (paramString = str + paramString;; paramString = str + "/" + paramString)
    {
      ac.i("MicroMsg.VoicePrintLogic", "genpath ".concat(String.valueOf(paramString)));
      if (!bs.isNullOrNil(paramString)) {
        break;
      }
      AppMethodBeat.o(29794);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(29794);
      return paramString;
    }
    if (new e(paramString).exists())
    {
      AppMethodBeat.o(29794);
      return paramString;
    }
    AppMethodBeat.o(29794);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.m
 * JD-Core Version:    0.7.0.1
 */