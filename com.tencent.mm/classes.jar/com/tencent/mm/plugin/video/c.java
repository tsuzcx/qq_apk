package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;

public final class c
{
  public static String aeA(String paramString)
  {
    AppMethodBeat.i(50970);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50970);
      return "";
    }
    paramString = new BigInteger(Long.toBinaryString(bo.getLong(paramString, 0L)), 2).toString();
    AppMethodBeat.o(50970);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.video.c
 * JD-Core Version:    0.7.0.1
 */