package com.tencent.smtt.export.external.X5Graphics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BitmapFactory
{
  private static final int CONFIG_ALPHA_8 = 1;
  private static final int CONFIG_ARGB_4444 = 4;
  private static final int CONFIG_ARGB_8888 = 5;
  private static final int CONFIG_RGB_565 = 3;
  public static final int SHARPP_STATUS_OK = 0;
  public static final int TPGType = 2;
  public static final String TPGmimetype = "image/tpg";
  public static final int sharpPType = 1;
  public static final String sharpPmimetype = "image/sharpp";
  
  public static void closeDecoder(BitmapInfo paramBitmapInfo)
  {
    AppMethodBeat.i(53162);
    new StringBuilder("closeDecoder 0 decodeHandle = ").append(paramBitmapInfo.decodeHandle);
    if (!X5Graphics.isEnable())
    {
      AppMethodBeat.o(53162);
      return;
    }
    if (paramBitmapInfo.decodeHandle == 0L)
    {
      AppMethodBeat.o(53162);
      return;
    }
    nativeCloseDecoder(paramBitmapInfo.decodeHandle);
    AppMethodBeat.o(53162);
  }
  
  public static BitmapInfo createDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53160);
    new StringBuilder("createDecoder 0data = ").append(paramArrayOfByte).append(", len = ").append(paramArrayOfByte.length);
    if (!X5Graphics.isEnable())
    {
      AppMethodBeat.o(53160);
      return null;
    }
    paramArrayOfByte = nativeCreateDecoder(paramArrayOfByte);
    new StringBuilder("createDecoder 2 bmpInfo=").append(paramArrayOfByte);
    AppMethodBeat.o(53160);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Options paramOptions)
  {
    AppMethodBeat.i(53156);
    if (!X5Graphics.isEnable())
    {
      AppMethodBeat.o(53156);
      return null;
    }
    new StringBuilder("decodeByteArray 0data = ").append(paramArrayOfByte).append(", len = ").append(paramArrayOfByte.length);
    if (((paramInt1 | paramInt2) < 0) || (paramArrayOfByte.length < paramInt1 + paramInt2))
    {
      paramArrayOfByte = new ArrayIndexOutOfBoundsException();
      AppMethodBeat.o(53156);
      throw paramArrayOfByte;
    }
    BitmapInfo localBitmapInfo = nativeDecodeInfo(paramArrayOfByte, paramInt1, paramInt2);
    if (localBitmapInfo == null)
    {
      AppMethodBeat.o(53156);
      return null;
    }
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    int i;
    Bitmap localBitmap1;
    if (paramOptions != null)
    {
      paramOptions.outWidth = localBitmapInfo.width;
      paramOptions.outHeight = localBitmapInfo.height;
      paramOptions.outMimeType = localBitmapInfo.mimeType;
      if (paramOptions.inJustDecodeBounds)
      {
        AppMethodBeat.o(53156);
        return null;
      }
      if (paramOptions.inPreferredConfig != Bitmap.Config.ARGB_8888)
      {
        AppMethodBeat.o(53156);
        return null;
      }
      if (paramOptions.inSampleSize <= 0)
      {
        AppMethodBeat.o(53156);
        return null;
      }
      i = paramOptions.inSampleSize;
      localConfig = paramOptions.inPreferredConfig;
      if (paramOptions.inBitmap != null)
      {
        Bitmap localBitmap2 = paramOptions.inBitmap;
        if (localBitmap2.getWidth() != localBitmapInfo.width)
        {
          AppMethodBeat.o(53156);
          return null;
        }
        if (localBitmap2.getHeight() != localBitmapInfo.height)
        {
          AppMethodBeat.o(53156);
          return null;
        }
        localBitmap1 = localBitmap2;
        if (localBitmap2.getConfig() != localConfig)
        {
          AppMethodBeat.o(53156);
          return null;
        }
      }
      else
      {
        localBitmap1 = null;
      }
      paramOptions.outWidth = (localBitmapInfo.width / i);
      paramOptions.outHeight = (localBitmapInfo.height / i);
      new StringBuilder("decodeByteArray 3 outWidth=").append(paramOptions.outWidth).append(";outHeight=").append(paramOptions.outHeight);
    }
    for (paramOptions = localConfig;; paramOptions = localConfig)
    {
      int j = getBitmapConfigValue(paramOptions);
      if (j == 0)
      {
        AppMethodBeat.o(53156);
        return null;
      }
      paramArrayOfByte = nativeDecodePixels(paramArrayOfByte, paramInt1, paramInt2, j, i);
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(53156);
        return null;
      }
      if (localBitmap1 != null)
      {
        localBitmap1.setPixels(paramArrayOfByte, 0, getBitmapStride(paramOptions, localBitmapInfo.width / i) / 4, 0, 0, localBitmapInfo.width / i, localBitmapInfo.height / i);
        AppMethodBeat.o(53156);
        return localBitmap1;
      }
      new StringBuilder("decodeByteArray 6 length=").append(paramArrayOfByte.length).append("; width=").append(localBitmapInfo.width / i).append("; height=").append(localBitmapInfo.height / i);
      paramArrayOfByte = Bitmap.createBitmap(paramArrayOfByte, localBitmapInfo.width / i, localBitmapInfo.height / i, paramOptions);
      AppMethodBeat.o(53156);
      return paramArrayOfByte;
      i = 1;
      localBitmap1 = null;
    }
  }
  
  public static Bitmap decodeOneFrame(byte[] paramArrayOfByte, int paramInt, BitmapInfo paramBitmapInfo, Options paramOptions)
  {
    AppMethodBeat.i(53161);
    new StringBuilder("decodeOneFrame 0 data.length=").append(paramArrayOfByte.length).append(", frameIndex = ").append(paramInt);
    if (!X5Graphics.isEnable())
    {
      AppMethodBeat.o(53161);
      return null;
    }
    if (paramBitmapInfo == null)
    {
      AppMethodBeat.o(53161);
      return null;
    }
    new StringBuilder("decodeOneFrame 1 frameCount = ").append(paramBitmapInfo.frameCount).append("; decodeHandle=").append(paramBitmapInfo.decodeHandle);
    if (paramBitmapInfo.decodeHandle == 0L)
    {
      AppMethodBeat.o(53161);
      return null;
    }
    Object localObject1 = null;
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    int i = paramBitmapInfo.width;
    int j = paramBitmapInfo.height;
    Object localObject2;
    if (paramOptions != null)
    {
      new StringBuilder("decodeOneFrame 3  inSampleSize=").append(paramOptions.inSampleSize).append(", outDelayTime=").append(paramOptions.outDelayTime);
      paramOptions.outWidth = paramBitmapInfo.width;
      paramOptions.outHeight = paramBitmapInfo.height;
      paramOptions.outMimeType = paramBitmapInfo.mimeType;
      if (paramOptions.inJustDecodeBounds)
      {
        AppMethodBeat.o(53161);
        return null;
      }
      if (paramOptions.inPreferredConfig != Bitmap.Config.ARGB_8888)
      {
        AppMethodBeat.o(53161);
        return null;
      }
      if (paramOptions.inSampleSize <= 0)
      {
        AppMethodBeat.o(53161);
        return null;
      }
      i = paramOptions.inSampleSize;
      localConfig = paramOptions.inPreferredConfig;
      if (paramOptions.inBitmap != null)
      {
        localObject2 = paramOptions.inBitmap;
        if (((Bitmap)localObject2).getWidth() != paramBitmapInfo.width)
        {
          AppMethodBeat.o(53161);
          return null;
        }
        if (((Bitmap)localObject2).getHeight() != paramBitmapInfo.height)
        {
          AppMethodBeat.o(53161);
          return null;
        }
        localObject1 = localObject2;
        if (((Bitmap)localObject2).getConfig() != localConfig)
        {
          AppMethodBeat.o(53161);
          return null;
        }
      }
      paramOptions.outWidth = (paramBitmapInfo.width / i);
      paramOptions.outHeight = (paramBitmapInfo.height / i);
      i = paramOptions.outWidth;
      j = paramOptions.outHeight;
      new StringBuilder("decodeOneFrame  4  outWidth=").append(paramOptions.outWidth).append(";outHeight=").append(paramOptions.outHeight);
    }
    for (;;)
    {
      int k = getBitmapConfigValue(localConfig);
      if (k == 0)
      {
        AppMethodBeat.o(53161);
        return null;
      }
      new StringBuilder("decodeOneFrame  5 dstBitmap=").append(localObject1);
      long l = System.currentTimeMillis();
      localObject2 = new OneFrameInfo(0, null);
      if ((localObject1 != null) && (!localObject1.isRecycled()) && (localObject1.getWidth() > 1) && (localObject1.getHeight() > 1)) {
        ((OneFrameInfo)localObject2).frameDuration = nativeDecodeOneFrameUseBmp(paramArrayOfByte, paramInt, paramBitmapInfo.decodeHandle, k, i, j, localObject1);
      }
      for (paramArrayOfByte = (byte[])localObject2;; paramArrayOfByte = nativeDecodeOneFrameNewPixel(paramArrayOfByte, paramInt, paramBitmapInfo.decodeHandle, k, i, j))
      {
        new StringBuilder("decodeOneFrame  6  oneFrame=").append(paramArrayOfByte);
        if (paramArrayOfByte != null) {
          break;
        }
        AppMethodBeat.o(53161);
        return null;
      }
      new StringBuilder("decodeOneFrame  7  duration=").append(paramArrayOfByte.frameDuration);
      paramBitmapInfo = paramArrayOfByte.framePixel;
      if (paramOptions != null)
      {
        if (paramArrayOfByte.frameDuration < 0)
        {
          AppMethodBeat.o(53161);
          return null;
        }
        l = System.currentTimeMillis() - l;
        if (paramArrayOfByte.frameDuration <= l) {
          break label674;
        }
      }
      label674:
      for (paramOptions.outDelayTime = (paramArrayOfByte.frameDuration - l);; paramOptions.outDelayTime = 0L)
      {
        new StringBuilder("decodeOneFrame  8  opts.outDelayTime=").append(paramOptions.outDelayTime);
        if (localObject1 == null) {
          break;
        }
        new StringBuilder("decodeOneFrame  9 dstBitmap=").append(localObject1).append(";dstBitmap.isRecycled()=").append(localObject1.isRecycled()).append(";bmpWidth=").append(localObject1.getWidth()).append(";bmpHeight=").append(localObject1.getHeight());
        AppMethodBeat.o(53161);
        return localObject1;
      }
      if (paramBitmapInfo == null)
      {
        AppMethodBeat.o(53161);
        return null;
      }
      new StringBuilder("decodeOneFrame 10 length=").append(paramBitmapInfo.length).append("; width=").append(i).append("; height=").append(j).append(";config=").append(localConfig);
      paramArrayOfByte = Bitmap.createBitmap(paramBitmapInfo, i, j, localConfig);
      AppMethodBeat.o(53161);
      return paramArrayOfByte;
      localObject1 = null;
    }
  }
  
  private static BitmapInfo generateBitmapInfo(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString)
  {
    AppMethodBeat.i(53157);
    paramString = new BitmapInfo(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramString);
    AppMethodBeat.o(53157);
    return paramString;
  }
  
  private static OneFrameInfo generateFrameInfo(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(53158);
    paramArrayOfInt = new OneFrameInfo(paramInt, paramArrayOfInt);
    AppMethodBeat.o(53158);
    return paramArrayOfInt;
  }
  
  private static int getBitmapConfigValue(Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(53154);
    switch (BitmapFactory.1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
    {
    default: 
      AppMethodBeat.o(53154);
      return 0;
    case 1: 
      AppMethodBeat.o(53154);
      return 1;
    case 2: 
      AppMethodBeat.o(53154);
      return 3;
    case 3: 
      AppMethodBeat.o(53154);
      return 4;
    }
    AppMethodBeat.o(53154);
    return 5;
  }
  
  private static int getBitmapStride(Bitmap.Config paramConfig, int paramInt)
  {
    AppMethodBeat.i(53155);
    switch (BitmapFactory.1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
    {
    default: 
      AppMethodBeat.o(53155);
      return 0;
    case 1: 
      AppMethodBeat.o(53155);
      return paramInt;
    case 2: 
      AppMethodBeat.o(53155);
      return paramInt * 2;
    case 3: 
      AppMethodBeat.o(53155);
      return paramInt * 2;
    }
    AppMethodBeat.o(53155);
    return paramInt * 4;
  }
  
  public static boolean loadSharpSuccess()
  {
    boolean bool = false;
    AppMethodBeat.i(53163);
    if (!X5Graphics.isEnable())
    {
      AppMethodBeat.o(53163);
      return false;
    }
    if (nativeLoadSharpP() == 0) {}
    for (;;)
    {
      AppMethodBeat.o(53163);
      return bool;
      bool = true;
    }
  }
  
  private static native void nativeCloseDecoder(long paramLong);
  
  private static native BitmapInfo nativeCreateDecoder(byte[] paramArrayOfByte);
  
  private static native BitmapInfo nativeDecodeInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native OneFrameInfo nativeDecodeOneFrameNewPixel(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int nativeDecodeOneFrameUseBmp(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap);
  
  private static native int[] nativeDecodePixels(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int nativeLoadSharpP();
  
  public static BitmapInfo parseHeader(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53159);
    new StringBuilder("parseHeader 0 data = ").append(paramArrayOfByte).append(", len = ").append(paramArrayOfByte.length);
    if (!X5Graphics.isEnable())
    {
      AppMethodBeat.o(53159);
      return null;
    }
    paramArrayOfByte = nativeDecodeInfo(paramArrayOfByte, 0, paramArrayOfByte.length);
    new StringBuilder("parseHeader 2 bmpInfo=").append(paramArrayOfByte);
    AppMethodBeat.o(53159);
    return paramArrayOfByte;
  }
  
  public static class BitmapInfo
  {
    public long decodeHandle;
    public int frameCount;
    public int height;
    public int imageType;
    public String mimeType;
    public int width;
    
    public BitmapInfo(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.mimeType = paramString;
      this.frameCount = paramInt3;
      this.decodeHandle = paramLong;
      this.imageType = paramInt4;
    }
  }
  
  public static class OneFrameInfo
  {
    public int frameDuration;
    public int[] framePixel;
    
    public OneFrameInfo(int paramInt, int[] paramArrayOfInt)
    {
      this.frameDuration = paramInt;
      this.framePixel = paramArrayOfInt;
    }
  }
  
  public static class Options
  {
    public Bitmap inBitmap = null;
    public boolean inJustDecodeBounds = false;
    public Bitmap.Config inPreferredConfig = Bitmap.Config.ARGB_8888;
    public int inSampleSize = 1;
    public long outDelayTime = 0L;
    public int outHeight = 0;
    public String outMimeType = "";
    public int outWidth = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.export.external.X5Graphics.BitmapFactory
 * JD-Core Version:    0.7.0.1
 */