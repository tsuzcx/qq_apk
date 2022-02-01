package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public final class s
{
  public static int c(Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(156180);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(156180);
      return -1;
    }
    paramInt = MMJpegOptim.compressByQualityOptim(paramBitmap, paramInt, false, q.k(paramString, false));
    AppMethodBeat.o(156180);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.s
 * JD-Core Version:    0.7.0.1
 */