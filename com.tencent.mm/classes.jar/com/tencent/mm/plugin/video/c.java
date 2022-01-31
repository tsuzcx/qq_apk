package com.tencent.mm.plugin.video;

import com.tencent.mm.sdk.platformtools.bk;
import java.math.BigInteger;

public final class c
{
  public static String PU(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    return new BigInteger(Long.toBinaryString(bk.getLong(paramString, 0L)), 2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.video.c
 * JD-Core Version:    0.7.0.1
 */