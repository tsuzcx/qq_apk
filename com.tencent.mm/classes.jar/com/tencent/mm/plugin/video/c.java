package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.math.BigInteger;

public final class c
{
  public static String aDi(String paramString)
  {
    AppMethodBeat.i(127140);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127140);
      return "";
    }
    paramString = new BigInteger(Long.toBinaryString(bt.getLong(paramString, 0L)), 2).toString();
    AppMethodBeat.o(127140);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.video.c
 * JD-Core Version:    0.7.0.1
 */