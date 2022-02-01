package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.EncodeReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class YTAGReflectLiveCheckJNIInterface
{
  public static int TIME_REGULATION_LOOSE = 1;
  public static int TIME_REGULATION_STRICT = 0;
  private static YTAGReflectLiveCheckJNIInterface instance = null;
  private long FRnativePtr;
  public Context context;
  private long nativePtr;
  
  private YTAGReflectLiveCheckJNIInterface()
  {
    AppMethodBeat.i(43374);
    this.context = null;
    FRNativeConstructor();
    AppMethodBeat.o(43374);
  }
  
  public static native String FRVersion();
  
  public static void NativeLog(int paramInt, String paramString)
  {
    AppMethodBeat.i(43380);
    if (!YTLogger.isEnableNativeLog())
    {
      AppMethodBeat.o(43380);
      return;
    }
    switch (paramInt)
    {
    default: 
      YTLogger.d("NativeLog-".concat(String.valueOf(paramInt)), "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(43380);
      return;
    case 2: 
      YTLogger.v("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(43380);
      return;
    case 3: 
      YTLogger.d("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(43380);
      return;
    case 4: 
      YTLogger.i("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(43380);
      return;
    case 5: 
      YTLogger.w("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(43380);
      return;
    }
    YTLogger.e("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(43380);
  }
  
  public static void compressTest(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(43377);
    try
    {
      Object localObject = new File("/sdcard/reflect/");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = "/sdcard/reflect/" + paramInt + "/";
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new FileOutputStream(new File((String)localObject, "mytestInJava_" + System.currentTimeMillis() + ".jpg"));
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, (OutputStream)localObject);
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      AppMethodBeat.o(43377);
      return;
    }
    catch (Exception paramBitmap)
    {
      AppMethodBeat.o(43377);
    }
  }
  
  public static byte[] encodeJpeg(Bitmap paramBitmap)
  {
    AppMethodBeat.i(43379);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 99, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(43379);
    return paramBitmap;
  }
  
  public static byte[] encodeJpeg(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(43378);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(43378);
    return paramBitmap;
  }
  
  public static YTAGReflectLiveCheckJNIInterface getInstance()
  {
    try
    {
      AppMethodBeat.i(43373);
      if (instance == null) {
        instance = new YTAGReflectLiveCheckJNIInterface();
      }
      YTAGReflectLiveCheckJNIInterface localYTAGReflectLiveCheckJNIInterface = instance;
      AppMethodBeat.o(43373);
      return localYTAGReflectLiveCheckJNIInterface;
    }
    finally {}
  }
  
  public static String modelVersion()
  {
    return "";
  }
  
  public static String sdkVersion()
  {
    return "";
  }
  
  public native int FRDoDetectionYuvs(boolean paramBoolean, int paramInt);
  
  public native FullPack FRGetAGin();
  
  public native Bitmap FRGetBestImg(int paramInt);
  
  public native int FRGetChangePoint();
  
  public native int FRGetConfigBegin();
  
  public native int FRGetConfigEnd();
  
  public native EncodeReflectData FRGetEncodeReflectData();
  
  public native double FRGetISObackup();
  
  public native String FRInit(boolean paramBoolean, String paramString, int paramInt);
  
  public native void FRNativeConstructor();
  
  public native void FRNativeDestructor();
  
  public native void FRPushCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOImgYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRPushYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRSetBegin(Timeval paramTimeval);
  
  public native void FRSetChangePointTime(Timeval paramTimeval);
  
  public native void FRSetDoingDelayCalc(boolean paramBoolean);
  
  public native void FRSetEnd(Timeval paramTimeval);
  
  public native void FRSetISObackup(double paramDouble);
  
  public native void FRSetISOchangeTime(Timeval paramTimeval);
  
  public native void FRSetSafetyLevel(int paramInt);
  
  public void destroy()
  {
    AppMethodBeat.i(43375);
    FRNativeDestructor();
    AppMethodBeat.o(43375);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(43376);
    FRNativeDestructor();
    AppMethodBeat.o(43376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface
 * JD-Core Version:    0.7.0.1
 */