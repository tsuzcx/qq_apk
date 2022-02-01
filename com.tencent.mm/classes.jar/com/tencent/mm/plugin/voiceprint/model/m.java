package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al;
import com.tencent.mm.vfs.e;

public final class m
{
  public static String cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29794);
    String str = al.IpN;
    ad.i("MicroMsg.VoicePrintLogic", "dbCachePath ".concat(String.valueOf(str)));
    if (str.endsWith("/")) {}
    for (paramString = str + paramString;; paramString = str + "/" + paramString)
    {
      ad.i("MicroMsg.VoicePrintLogic", "genpath ".concat(String.valueOf(paramString)));
      if (!bt.isNullOrNil(paramString)) {
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