package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public final class am
{
  public static Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (Throwable paramConfig) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.am
 * JD-Core Version:    0.7.0.1
 */