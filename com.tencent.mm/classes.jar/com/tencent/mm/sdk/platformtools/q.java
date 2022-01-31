package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static int b(Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(93393);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(93393);
      return -1;
    }
    paramInt = MMJpegOptim.compressByQualityOptim(paramBitmap, paramInt, false, paramString);
    AppMethodBeat.o(93393);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.q
 * JD-Core Version:    0.7.0.1
 */