package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;

class MMJpegOptim
{
  public static native boolean checkIntegrity(String paramString);
  
  public static native int compressByQuality(Bitmap paramBitmap, int paramInt, boolean paramBoolean, String paramString);
  
  public static native int compressByQualityOptim(Bitmap paramBitmap, int paramInt, boolean paramBoolean, String paramString);
  
  public static native int convertToProgressive(String paramString1, String paramString2, int paramInt);
  
  public static native int decodeToBitmap(String paramString, Bitmap paramBitmap, int paramInt);
  
  public static native int isProgressiveFile(String paramString);
  
  public static native int queryQuality(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMJpegOptim
 * JD-Core Version:    0.7.0.1
 */