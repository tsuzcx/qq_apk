package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.File;

public final class m
{
  public static String bE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(26113);
    String str = ac.eQv;
    ab.i("MicroMsg.VoicePrintLogic", "dbCachePath ".concat(String.valueOf(str)));
    if (str.endsWith(File.separator)) {}
    for (paramString = str + paramString;; paramString = str + File.separator + paramString)
    {
      ab.i("MicroMsg.VoicePrintLogic", "genpath ".concat(String.valueOf(paramString)));
      if (!bo.isNullOrNil(paramString)) {
        break;
      }
      AppMethodBeat.o(26113);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(26113);
      return paramString;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(26113);
      return paramString;
    }
    AppMethodBeat.o(26113);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.m
 * JD-Core Version:    0.7.0.1
 */