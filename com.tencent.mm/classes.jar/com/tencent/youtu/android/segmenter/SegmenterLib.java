package com.tencent.youtu.android.segmenter;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SegmenterLib
{
  private static boolean sLoadOpenclSuccess;
  private int mErrorCode;
  private int mErrorType;
  private long nativePtr;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: putstatic 28	com/tencent/youtu/android/segmenter/SegmenterLib:sLoadOpenclSuccess	Z
    //   9: invokestatic 34	com/tencent/ttpic/manager/FeatureManager:isSegmentationReady	()Z
    //   12: ifeq +224 -> 236
    //   15: ldc 36
    //   17: invokestatic 42	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   20: ldc 44
    //   22: invokestatic 42	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   25: getstatic 49	com/tencent/ttpic/fabby/FabbyManager:sChooseGPU_Segment	Z
    //   28: ifne +35 -> 63
    //   31: ldc 51
    //   33: invokestatic 52	com/tencent/ttpic/manager/FeatureManager:loadLibrary	(Ljava/lang/String;)V
    //   36: iconst_0
    //   37: putstatic 28	com/tencent/youtu/android/segmenter/SegmenterLib:sLoadOpenclSuccess	Z
    //   40: getstatic 28	com/tencent/youtu/android/segmenter/SegmenterLib:sLoadOpenclSuccess	Z
    //   43: ifne +193 -> 236
    //   46: getstatic 49	com/tencent/ttpic/fabby/FabbyManager:sChooseGPU_Segment	Z
    //   49: ifeq +187 -> 236
    //   52: ldc 51
    //   54: invokestatic 52	com/tencent/ttpic/manager/FeatureManager:loadLibrary	(Ljava/lang/String;)V
    //   57: ldc 20
    //   59: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: ldc 57
    //   65: invokestatic 52	com/tencent/ttpic/manager/FeatureManager:loadLibrary	(Ljava/lang/String;)V
    //   68: iconst_1
    //   69: putstatic 28	com/tencent/youtu/android/segmenter/SegmenterLib:sLoadOpenclSuccess	Z
    //   72: goto -32 -> 40
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 63	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   80: getstatic 28	com/tencent/youtu/android/segmenter/SegmenterLib:sLoadOpenclSuccess	Z
    //   83: ifne +153 -> 236
    //   86: getstatic 49	com/tencent/ttpic/fabby/FabbyManager:sChooseGPU_Segment	Z
    //   89: ifeq +147 -> 236
    //   92: ldc 51
    //   94: invokestatic 52	com/tencent/ttpic/manager/FeatureManager:loadLibrary	(Ljava/lang/String;)V
    //   97: ldc 20
    //   99: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: return
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 63	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   108: ldc 20
    //   110: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore_0
    //   115: aload_0
    //   116: invokestatic 63	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   119: ldc 20
    //   121: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: return
    //   125: astore_0
    //   126: aload_0
    //   127: invokestatic 63	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   130: getstatic 28	com/tencent/youtu/android/segmenter/SegmenterLib:sLoadOpenclSuccess	Z
    //   133: ifne +103 -> 236
    //   136: getstatic 49	com/tencent/ttpic/fabby/FabbyManager:sChooseGPU_Segment	Z
    //   139: ifeq +97 -> 236
    //   142: ldc 51
    //   144: invokestatic 52	com/tencent/ttpic/manager/FeatureManager:loadLibrary	(Ljava/lang/String;)V
    //   147: ldc 20
    //   149: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: return
    //   153: astore_0
    //   154: aload_0
    //   155: invokestatic 63	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   158: ldc 20
    //   160: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: return
    //   164: astore_0
    //   165: aload_0
    //   166: invokestatic 63	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   169: getstatic 28	com/tencent/youtu/android/segmenter/SegmenterLib:sLoadOpenclSuccess	Z
    //   172: ifne +64 -> 236
    //   175: getstatic 49	com/tencent/ttpic/fabby/FabbyManager:sChooseGPU_Segment	Z
    //   178: ifeq +58 -> 236
    //   181: ldc 51
    //   183: invokestatic 52	com/tencent/ttpic/manager/FeatureManager:loadLibrary	(Ljava/lang/String;)V
    //   186: ldc 20
    //   188: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: astore_0
    //   193: aload_0
    //   194: invokestatic 63	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   197: ldc 20
    //   199: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: return
    //   203: astore_0
    //   204: getstatic 28	com/tencent/youtu/android/segmenter/SegmenterLib:sLoadOpenclSuccess	Z
    //   207: ifne +14 -> 221
    //   210: getstatic 49	com/tencent/ttpic/fabby/FabbyManager:sChooseGPU_Segment	Z
    //   213: ifeq +8 -> 221
    //   216: ldc 51
    //   218: invokestatic 52	com/tencent/ttpic/manager/FeatureManager:loadLibrary	(Ljava/lang/String;)V
    //   221: ldc 20
    //   223: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_0
    //   227: athrow
    //   228: astore_1
    //   229: aload_1
    //   230: invokestatic 63	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   233: goto -12 -> 221
    //   236: ldc 20
    //   238: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   75	2	0	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   103	2	0	localException1	java.lang.Exception
    //   114	2	0	localException2	java.lang.Exception
    //   125	2	0	localRuntimeException	java.lang.RuntimeException
    //   153	2	0	localException3	java.lang.Exception
    //   164	2	0	localException4	java.lang.Exception
    //   192	2	0	localException5	java.lang.Exception
    //   203	24	0	localObject	Object
    //   228	2	1	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   15	40	75	java/lang/UnsatisfiedLinkError
    //   63	72	75	java/lang/UnsatisfiedLinkError
    //   52	57	103	java/lang/Exception
    //   92	97	114	java/lang/Exception
    //   15	40	125	java/lang/RuntimeException
    //   63	72	125	java/lang/RuntimeException
    //   142	147	153	java/lang/Exception
    //   15	40	164	java/lang/Exception
    //   63	72	164	java/lang/Exception
    //   181	186	192	java/lang/Exception
    //   15	40	203	finally
    //   63	72	203	finally
    //   76	80	203	finally
    //   126	130	203	finally
    //   165	169	203	finally
    //   216	221	228	java/lang/Exception
  }
  
  public SegmenterLib(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84506);
    this.mErrorCode = 0;
    this.mErrorType = 0;
    initWithProto(paramString1, paramString2);
    this.mErrorCode = getInitErrorCode();
    this.mErrorType = getInitErrorType();
    AppMethodBeat.o(84506);
  }
  
  private native boolean getGPUSupportOpenCL();
  
  private native int getInitErrorCode();
  
  private native int getInitErrorType();
  
  private native boolean initWithProto(String paramString1, String paramString2);
  
  public native void clearSegmentBuffer();
  
  public native int compileKernel();
  
  public native int copyBufferToTexture(int paramInt1, int paramInt2, int paramInt3);
  
  public native int copyTextureToBuffer(int paramInt1, int paramInt2, int paramInt3);
  
  public native void destroy();
  
  public int getErrorCode()
  {
    return this.mErrorCode;
  }
  
  public int getErrorType()
  {
    return this.mErrorType;
  }
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public boolean isGPUSupportOpenCL()
  {
    AppMethodBeat.i(84505);
    if (sLoadOpenclSuccess)
    {
      boolean bool = getGPUSupportOpenCL();
      AppMethodBeat.o(84505);
      return bool;
    }
    AppMethodBeat.o(84505);
    return false;
  }
  
  public boolean isInitSuccess()
  {
    return (this.mErrorCode == 0) && (this.mErrorType == 0);
  }
  
  public native Bitmap segment(Bitmap paramBitmap);
  
  public native void segmentOnBit(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void segmentOnBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int segmentOnTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6);
  
  public native int segmentOnTextureV2(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.android.segmenter.SegmenterLib
 * JD-Core Version:    0.7.0.1
 */