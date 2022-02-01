package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AssetImageGenerator$DefaultBitmapFactory
  implements AssetImageGenerator.OutputBitmapFactory
{
  public Bitmap getOutputBitmap(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188650);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    AppMethodBeat.o(188650);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AssetImageGenerator.DefaultBitmapFactory
 * JD-Core Version:    0.7.0.1
 */