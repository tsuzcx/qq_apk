package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;

public final class m
{
  public static String cz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29794);
    String str = ar.NSe;
    Log.i("MicroMsg.VoicePrintLogic", "dbCachePath ".concat(String.valueOf(str)));
    if (str.endsWith("/")) {}
    for (paramString = str + paramString;; paramString = str + "/" + paramString)
    {
      Log.i("MicroMsg.VoicePrintLogic", "genpath ".concat(String.valueOf(paramString)));
      if (!Util.isNullOrNil(paramString)) {
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
    if (new o(paramString).exists())
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