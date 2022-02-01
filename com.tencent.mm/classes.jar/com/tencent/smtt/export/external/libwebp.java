package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.X5Graphics.GraphicsLib;
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
  private static String mModle = "";
  private int mBitmapType = 4;
  
  public static int checkIsHuaModel()
  {
    AppMethodBeat.i(53237);
    String str = Build.MANUFACTURER.trim().toLowerCase();
    int j = 0;
    int i = j;
    if (str != null)
    {
      i = j;
      if (str.length() > 0)
      {
        i = j;
        if (str.contains("huawei")) {
          i = 1;
        }
      }
    }
    AppMethodBeat.o(53237);
    return i;
  }
  
  private String getCPUinfo()
  {
    AppMethodBeat.i(53231);
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
    AppMethodBeat.o(53231);
    return str1;
  }
  
  public static libwebp getInstance(Context paramContext)
  {
    AppMethodBeat.i(53227);
    if (mInstance == null)
    {
      mIsLoadLibSuccess = GraphicsLib.loadWepLibraryIfNeed(paramContext);
      mInstance = new libwebp();
    }
    paramContext = mInstance;
    AppMethodBeat.o(53227);
    return paramContext;
  }
  
  private boolean isMultiCore()
  {
    AppMethodBeat.i(53230);
    boolean bool = getCPUinfo().contains("processor");
    AppMethodBeat.o(53230);
    return bool;
  }
  
  public static void loadWepLibraryIfNeed(Context paramContext)
  {
    AppMethodBeat.i(53229);
    mIsLoadLibSuccess = GraphicsLib.loadWepLibraryIfNeed(paramContext);
    AppMethodBeat.o(53229);
  }
  
  public static void loadWepLibraryIfNeed(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53228);
    mIsLoadLibSuccess = GraphicsLib.loadWepLibraryIfNeed(paramContext, paramString);
    AppMethodBeat.o(53228);
  }
  
  public int[] decodeBase(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(53233);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(53233);
      return null;
    }
    paramArrayOfByte = nativeDecode(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(53233);
    return paramArrayOfByte;
  }
  
  public int[] decodeBase_16bit(byte[] paramArrayOfByte, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(53234);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(53234);
      return null;
    }
    switch (1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
    {
    default: 
      this.mBitmapType = 2;
    }
    for (;;)
    {
      paramArrayOfByte = nativeDecode_16bit(paramArrayOfByte, isMultiCore, this.mBitmapType);
      AppMethodBeat.o(53234);
      return paramArrayOfByte;
      this.mBitmapType = 3;
      continue;
      this.mBitmapType = 2;
    }
  }
  
  public int[] decodeInto(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(53235);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(53235);
      return null;
    }
    paramArrayOfByte = nativeDecodeInto(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(53235);
    return paramArrayOfByte;
  }
  
  public int getInfo(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(53232);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(53232);
      return 0;
    }
    int i = nativeGetInfo(paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(53232);
    return i;
  }
  
  public int[] incDecode(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(53236);
    if (!mIsLoadLibSuccess)
    {
      AppMethodBeat.o(53236);
      return null;
    }
    paramArrayOfByte = nativeIDecode(paramArrayOfByte, isMultiCore, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(53236);
    return paramArrayOfByte;
  }
  
  public native int[] nativeDecode(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeDecodeInto(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeDecode_16bit(byte[] paramArrayOfByte, boolean paramBoolean, int paramInt);
  
  public native int nativeGetInfo(byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int[] nativeIDecode(byte[] paramArrayOfByte, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.libwebp
 * JD-Core Version:    0.7.0.1
 */