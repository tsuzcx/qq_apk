package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class YTAGReflectLiveCheckJNIInterface
{
  public static int TIME_REGULATION_LOOSE;
  public static int TIME_REGULATION_STRICT;
  private static YTAGReflectLiveCheckJNIInterface instance;
  private static Lock instanceLock;
  private static IYtLoggerListener loggerListener;
  private long FRnativePtr;
  public Context context;
  
  static
  {
    AppMethodBeat.i(218081);
    TIME_REGULATION_STRICT = 0;
    TIME_REGULATION_LOOSE = 1;
    instance = null;
    instanceLock = new ReentrantLock();
    AppMethodBeat.o(218081);
  }
  
  private YTAGReflectLiveCheckJNIInterface()
  {
    AppMethodBeat.i(43374);
    this.context = null;
    FRNativeConstructor();
    AppMethodBeat.o(43374);
  }
  
  public static native String Checksum(String paramString);
  
  public static native String ChecksumPose(String paramString1, String paramString2, String paramString3);
  
  public static native String FRGenConfigData(int paramInt, String paramString);
  
  public static native String FRVersion();
  
  public static native void SetActStr(String paramString);
  
  public static native void SetPipelineVersion(String paramString);
  
  /* Error */
  public static void clearInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 66
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 42	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   11: invokeinterface 71 1 0
    //   16: getstatic 35	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   19: ifnull +13 -> 32
    //   22: getstatic 35	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   25: invokevirtual 74	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRNativeDestructor	()V
    //   28: aconst_null
    //   29: putstatic 35	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   32: getstatic 42	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   35: invokeinterface 77 1 0
    //   40: ldc 66
    //   42: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: return
    //   49: astore_0
    //   50: getstatic 42	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 77 1 0
    //   58: ldc 66
    //   60: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: athrow
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	15	0	localObject1	Object
    //   65	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	32	49	finally
    //   3	8	65	finally
    //   32	45	65	finally
    //   50	65	65	finally
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
  
  public static native void configNativeLog(boolean paramBoolean);
  
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
  
  /* Error */
  public static YTAGReflectLiveCheckJNIInterface getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 166
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 42	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   11: invokeinterface 71 1 0
    //   16: getstatic 35	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   19: ifnonnull +13 -> 32
    //   22: new 2	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface
    //   25: dup
    //   26: invokespecial 167	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:<init>	()V
    //   29: putstatic 35	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   32: getstatic 42	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   35: invokeinterface 77 1 0
    //   40: getstatic 35	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instance	Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   43: astore_0
    //   44: ldc 166
    //   46: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: areturn
    //   54: astore_0
    //   55: getstatic 42	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:instanceLock	Ljava/util/concurrent/locks/Lock;
    //   58: invokeinterface 77 1 0
    //   63: ldc 166
    //   65: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   43	10	0	localYTAGReflectLiveCheckJNIInterface	YTAGReflectLiveCheckJNIInterface
    //   54	15	0	localObject1	Object
    //   70	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	32	54	finally
    //   3	8	70	finally
    //   32	49	70	finally
    //   55	70	70	finally
  }
  
  public static String modelVersion()
  {
    return "";
  }
  
  public static void nativeLog(int paramInt, String paramString)
  {
    AppMethodBeat.i(218059);
    if (loggerListener != null) {
      loggerListener.log("[YTAGReflectLiveCheckJNIInterface.nativeLog]", paramString);
    }
    AppMethodBeat.o(218059);
  }
  
  public static void nativeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218058);
    if (loggerListener != null) {
      loggerListener.log(paramString1, paramString2);
    }
    AppMethodBeat.o(218058);
  }
  
  public static String sdkVersion()
  {
    return "";
  }
  
  public static void setLoggerListener(IYtLoggerListener paramIYtLoggerListener)
  {
    loggerListener = paramIYtLoggerListener;
  }
  
  public static native int updateParam(String paramString1, String paramString2);
  
  public native int FRDoDetectionYuvs(boolean paramBoolean, int paramInt);
  
  public native FullPack FRGetAGin();
  
  public native int FRGetChangePoint();
  
  public native int FRGetConfigBegin();
  
  public native int FRGetConfigEnd();
  
  public native int FRGetISOCaptureTimeVecSize();
  
  public native double FRGetISObackup();
  
  public native int FRGetISOchangeFrame();
  
  public native double FRGetISOmin();
  
  public native RawYuvData[] FRGetRawYuvDatas();
  
  public native int FRGetTriggerTime();
  
  public native int FRInit(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong, float paramFloat);
  
  public native void FRNativeConstructor();
  
  public native void FRNativeDestructor();
  
  public native void FRPushCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOCaptureTime(Timeval paramTimeval);
  
  public native void FRPushISOImgYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void FRPushYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3, float[] paramArrayOfFloat);
  
  public native int FRRelease();
  
  public native void FRSetBegin(Timeval paramTimeval);
  
  public native void FRSetChangePointTime(Timeval paramTimeval);
  
  public native void FRSetDoingDelayCalc(boolean paramBoolean);
  
  public native void FRSetEnd(Timeval paramTimeval);
  
  public native void FRSetISObackup(double paramDouble);
  
  public native void FRSetISOchangeFrame(int paramInt);
  
  public native void FRSetISOchangeTime(Timeval paramTimeval);
  
  public native void FRSetSafetyLevel(int paramInt);
  
  public static abstract interface IYtLoggerListener
  {
    public abstract void log(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface
 * JD-Core Version:    0.7.0.1
 */