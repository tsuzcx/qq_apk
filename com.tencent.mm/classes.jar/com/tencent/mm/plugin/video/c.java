package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;

public final class c
{
  public static String bfp(String paramString)
  {
    AppMethodBeat.i(127140);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127140);
      return "";
    }
    paramString = new BigInteger(Long.toBinaryString(Util.getLong(paramString, 0L)), 2).toString();
    AppMethodBeat.o(127140);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.video.c
 * JD-Core Version:    0.7.0.1
 */