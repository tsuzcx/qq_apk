package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;

public final class n
{
  public static int a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return -1;
    }
    return MMJpegOptim.compressByQualityOptim(paramBitmap, paramInt, false, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.n
 * JD-Core Version:    0.7.0.1
 */