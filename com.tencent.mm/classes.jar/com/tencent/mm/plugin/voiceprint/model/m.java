package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.u;

public final class m
{
  public static String dt(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29794);
    String str = at.acHq;
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
    if (new u(paramString).jKS())
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