package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.math.BigInteger;

public final class c
{
  public static String aEB(String paramString)
  {
    AppMethodBeat.i(127140);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127140);
      return "";
    }
    paramString = new BigInteger(Long.toBinaryString(bu.getLong(paramString, 0L)), 2).toString();
    AppMethodBeat.o(127140);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.video.c
 * JD-Core Version:    0.7.0.1
 */