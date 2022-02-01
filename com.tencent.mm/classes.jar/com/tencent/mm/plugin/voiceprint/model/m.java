package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am;
import com.tencent.mm.vfs.k;

public final class m
{
  public static String ch(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29794);
    String str = am.IKh;
    ae.i("MicroMsg.VoicePrintLogic", "dbCachePath ".concat(String.valueOf(str)));
    if (str.endsWith("/")) {}
    for (paramString = str + paramString;; paramString = str + "/" + paramString)
    {
      ae.i("MicroMsg.VoicePrintLogic", "genpath ".concat(String.valueOf(paramString)));
      if (!bu.isNullOrNil(paramString)) {
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
    if (new k(paramString).exists())
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