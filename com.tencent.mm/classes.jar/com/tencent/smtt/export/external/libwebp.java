package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class libwebp
{
  private static final int BITMAP_ALPHA_8 = 1;
  private static final int BITMAP_ARGB_4444 = 3;
  private static final int BITMAP_ARGB_8888 = 4;
  private static final int BITMAP_RGB_565 = 2;
  private static final String LOGTAG = "[image]";
  private static boolean isMultiCore = false;
  private static libwebp mInstance = null;
  private static boolean mIsLoadLibSuccess = false;
  private int mBitmapType = 4;
  
  public static int checkIsHuaModel()
  {
    String str1 = Build.BRAND.trim().toLowerCase();
    String str2 = Build.MODEL.trim().toLowerCase();
    int j = 0;
    int i = j;
    if (str1 != null)
    {
      i = j;
      if (str1.length() > 0)
      {
        i = j;
        if (str1.contains("huawei")) {
          i = 1;
        }
      }
    }
    if ((str2 != null) && (str2.length() > 0) && (str2.contains("huawei"))) {
      return 1;
    }
    return i;
  }
  
  private String getCPUinfo()
  {
    String str1 = "";
    String str2 = str1;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/proc/cpuinfo" }).start().getInputStream();
      str2 = str1;
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        str2 = str1;
        if (localInputStream.read(arrayOfByte) == -1) {
          break;
        }
        str2 = str1;
        str1 = str1 + new String(arrayOfByte);
      }
      str2 = str1;
      localInputStream.close();
      return str1;
    }
    catch (IOException localIOException) {}
    return str2;
  }
  
  public static libwebp getInstance(Context paramContext)
  {
    if (mInstance == null)
    {
      loadWepLibraryIfNeed(paramContext);
      mInstance = new libwebp();
    }
    return mInstance;
  }
  
  private boolean isMultiCore()
  {
    return getCPUinfo().contains("processor");
  }
  
  public static void loadWepLibraryIfNeed(Context paramContext)
  {
    if (!mIsLoadLibSuccess) {}
    try
    {
      LibraryLoader.loadLibrary(paramContext, "webp_base");
      mIsLoadLibSuccess = true;
      return;
    }
    catch (UnsatisfiedLinkError paramContext) {}
  }
  
  public static void loadWepLibraryIfNeed(Context paramContext, String paramString)
  {
    if (!mIsLoadLibSuccess) {}
    try
    {
      System.load(paramString + File.separator + "libwebp_base.so");
      mIsLoadLibSuccess = true;
      return;
    }
    catch (UnsatisfiedLinkError paramContext) {}
  }
  
  public int[] decodeBase(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!mIsLoadLibSuccess) {
      return null;
    }
    return nativeDecode(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public int[] decodeBase_16bit(byte[] paramArrayOfByte, Bitmap.Config paramConfig)
  {
    if (!mIsLoadLibSuccess) {
      return null;
    }
    switch (libwebp.1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
    {
    default: 
      this.mBitmapType = 2;
    }
    for (;;)
    {
      return nativeDecode_16bit(paramArrayOfByte, isMultiCore, this.mBitmapType);
      this.mBitmapType = 3;
      continue;
      this.mBitmapType = 2;
    }
  }
  
  public int[] decodeInto(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!mIsLoadLibSuccess) {
      return null;
    }
    return nativeDecodeInto(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public int getInfo(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!mIsLoadLibSuccess) {
      return 0;
    }
    return nativeGetInfo(paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public int[] incDecode(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!mIsLoadLibSuccess) {
      return null;
    }
    return nativeIDecode(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public native int[] nativeDecode(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeDecodeInto(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeDecode_16bit(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt);
  
  public native int nativeGetInfo(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeIDecode(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.export.external.libwebp
 * JD-Core Version:    0.7.0.1
 */