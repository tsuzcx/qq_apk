package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    int j = 1;
    AppMethodBeat.i(63832);
    String str1 = Build.BRAND.trim().toLowerCase();
    String str2 = Build.MODEL.trim().toLowerCase();
    int k = 0;
    int i = k;
    if (str1 != null)
    {
      i = k;
      if (str1.length() > 0)
      {
        i = k;
        if (str1.contains("huawei")) {
          i = 1;
        }
      }
    }
    if ((str2 != null) && (str2.length() > 0) && (str2.contains("huawei"))) {
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(63832);
      return i;
    }
  }
  
  private String getCPUinfo()
  {
    AppMethodBeat.i(63826);
    String str1 = "";
    str2 = str1;
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
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject = str2;
      }
    }
    AppMethodBeat.o(63826);
    return str1;
  }
  
  public static libwebp getInstance(Context paramContext)
  {
    AppMethodBeat.i(63822);
    if (mInstance == null)
    {
      loadWepLibraryIfNeed(paramContext);
      mInstance = new libwebp();
    }
    paramContext = mInstance;
    AppMethodBeat.o(63822);
    return paramContext;
  }
  
  private boolean isMultiCore()
  {
    AppMethodBeat.i(63825);
    boolean bool = getCPUinfo().contains("processor");
    AppMethodBeat.o(63825);
    return bool;
  }
  
  public static void loadWepLibraryIfNeed(Context paramContext)
  {
    AppMethodBeat.i(63824);
    if (!mIsLoadLibSuccess) {
      try
      {
        LibraryLoader.loadLibrary(paramContext, "webp_base");
        mIsLoadLibSuccess = true;
        AppMethodBeat.o(63824);
        return;
      }
      catch (UnsatisfiedLinkError paramContext) {}
    }
    AppMethodBeat.o(63824);
  }
  
  public static void loadWepLibraryIfNeed(Context paramContext, String paramString)
  {
    AppMethodBeat.i(63823);
    if (!mIsLoadLibSuccess) {
      try
      {
        System.load(paramString + File.separator + "libwebp_base.so");
        mIsLoadLibSuccess = true;
        AppMethodBeat.o(63823);
        return;
      }
      catch (UnsatisfiedLinkError paramContext) {}
    }
    AppMethodBeat.o(63823);
  }
  
  public int[] decodeBase(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(63828);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(63828);
      return null;
    }
    paramArrayOfByte = nativeDecode(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(63828);
    return paramArrayOfByte;
  }
  
  public int[] decodeBase_16bit(byte[] paramArrayOfByte, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(63829);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(63829);
      return null;
    }
    switch (libwebp.1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
    {
    default: 
      this.mBitmapType = 2;
    }
    for (;;)
    {
      paramArrayOfByte = nativeDecode_16bit(paramArrayOfByte, isMultiCore, this.mBitmapType);
      AppMethodBeat.o(63829);
      return paramArrayOfByte;
      this.mBitmapType = 3;
      continue;
      this.mBitmapType = 2;
    }
  }
  
  public int[] decodeInto(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(63830);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(63830);
      return null;
    }
    paramArrayOfByte = nativeDecodeInto(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(63830);
    return paramArrayOfByte;
  }
  
  public int getInfo(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(63827);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(63827);
      return 0;
    }
    int i = nativeGetInfo(paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(63827);
    return i;
  }
  
  public int[] incDecode(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(63831);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(63831);
      return null;
    }
    paramArrayOfByte = nativeIDecode(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(63831);
    return paramArrayOfByte;
  }
  
  public native int[] nativeDecode(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeDecodeInto(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeDecode_16bit(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt);
  
  public native int nativeGetInfo(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeIDecode(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.libwebp
 * JD-Core Version:    0.7.0.1
 */