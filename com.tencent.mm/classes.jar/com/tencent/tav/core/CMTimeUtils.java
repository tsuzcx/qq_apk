package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;

public class CMTimeUtils
{
  public static long CMTimeConvertToUs(CMTime paramCMTime)
  {
    AppMethodBeat.i(215317);
    long l = (paramCMTime.getTimeSeconds() * 1000.0F * 1000.0F);
    AppMethodBeat.o(215317);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tav.core.CMTimeUtils
 * JD-Core Version:    0.7.0.1
 */