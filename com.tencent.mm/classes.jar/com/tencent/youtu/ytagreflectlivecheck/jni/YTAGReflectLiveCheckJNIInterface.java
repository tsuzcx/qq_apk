package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

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
    AppMethodBeat.i(123176);
    this.context = null;
    FRNativeConstructor();
    AppMethodBeat.o(123176);
  }
  
  public static native boolean FRInitFaceSDK(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native boolean FRReleaseFaceSDK();
  
  public static void NativeLog(int paramInt, String paramString)
  {
    AppMethodBeat.i(123180);
    if (!YTLogger.isEnableNativeLog())
    {
      AppMethodBeat.o(123180);
      return;
    }
    switch (paramInt)
    {
    default: 
      YTLogger.d("NativeLog-".concat(String.valueOf(paramInt)), "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(123180);
      return;
    case 2: 
      YTLogger.v("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(123180);
      return;
    case 3: 
      YTLogger.d("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(123180);
      return;
    case 4: 
      YTLogger.i("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(123180);
      return;
    case 5: 
      YTLogger.w("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(123180);
      return;
    }
    YTLogger.e("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(123180);
  }
  
  public static byte[] encodeJpeg(Bitmap paramBitmap)
  {
    AppMethodBeat.i(123179);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 99, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(123179);
    return paramBitmap;
  }
  
  public static YTAGReflectLiveCheckJNIInterface getInstance()
  {
    try
    {
      AppMethodBeat.i(123175);
      if (instance == null) {
        instance = new YTAGReflectLiveCheckJNIInterface();
      }
      YTAGReflectLiveCheckJNIInterface localYTAGReflectLiveCheckJNIInterface = instance;
      AppMethodBeat.o(123175);
      return localYTAGReflectLiveCheckJNIInterface;
    }
    finally {}
  }
  
  public static String modelVersion()
  {
    return "0.0.1_20180605";
  }
  
  public static String sdkVersion()
  {
    return "0.0.1_20180605";
  }
  
  public native void ConfigNativeLog(boolean paramBoolean);
  
  public native void FRClearRAW();
  
  public native void FRDoDetectionImages(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int FRDoDetectionYuvs(boolean paramBoolean, int paramInt);
  
  public native FullPack FRGetAGin();
  
  public native Bitmap FRGetBestImg();
  
  public native int FRGetChangePoint();
  
  public native int FRGetChannel();
  
  public native int FRGetConfigBegin();
  
  public native int FRGetConfigEnd();
  
  public native boolean FRGetDoingDelayCalc();
  
  public native int FRGetISOImgVecSize();
  
  public native double FRGetISObackup();
  
  public native int FRGetISOchangeFrame();
  
  public native double FRGetISOmin();
  
  public native int FRGetLabelShowing();
  
  public native int FRGetSeqBeginInd();
  
  public native int FRGetSeqEndInd();
  
  public native String FRInit(boolean paramBoolean, String paramString);
  
  public native void FRNativeConstructor();
  
  public native void FRNativeDestructor();
  
  public native void FRPushCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOImg(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRPushISOImgYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRPushRawImg(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRPushRawImgYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native void FRPushRawImgYuvDebug(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Bitmap paramBitmap);
  
  public native void FRPushYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRSetBegin(Timeval paramTimeval);
  
  public native void FRSetChangePointTime(Timeval paramTimeval);
  
  public native void FRSetDoingDelayCalc(boolean paramBoolean);
  
  public native void FRSetEnd(Timeval paramTimeval);
  
  public native void FRSetISObackup(double paramDouble);
  
  public native void FRSetISOchangeFrame(int paramInt);
  
  public native void FRSetISOchangeTime(Timeval paramTimeval);
  
  public native void FRSetISOmin(double paramDouble);
  
  public native void FRSetLabelShowing(int paramInt);
  
  public native void FRSetLandmarks(ArrayList<ArrayList<ArrayList<Integer>>> paramArrayList);
  
  public void destroy()
  {
    AppMethodBeat.i(123177);
    FRNativeDestructor();
    AppMethodBeat.o(123177);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(123178);
    FRNativeDestructor();
    AppMethodBeat.o(123178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface
 * JD-Core Version:    0.7.0.1
 */