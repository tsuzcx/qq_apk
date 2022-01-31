package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;

class IntelliCrop
{
  public static native int crop(Bitmap paramBitmap, int[] paramArrayOfInt);
  
  public static native void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.IntelliCrop
 * JD-Core Version:    0.7.0.1
 */