package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;

public final class MMNativeWebP
{
  public static native Bitmap nativeDecodeByteArray(byte[] paramArrayOfByte, BitmapFactory.Options paramOptions);
  
  public static native byte[] nativeEncodeBitmap(Bitmap paramBitmap, int paramInt);
  
  public static native boolean nativeIsWebPImage(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMNativeWebP
 * JD-Core Version:    0.7.0.1
 */