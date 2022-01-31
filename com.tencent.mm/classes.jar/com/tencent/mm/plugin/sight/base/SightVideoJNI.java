package com.tencent.mm.plugin.sight.base;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SightVideoJNI
{
  public static final int MMSIGHT_YUV420P = 2;
  public static final int MMSIGHT_YUV420SP = 1;
  private static final Object MMSightLock;
  private static final String TAG = "MicroMsg.SightVideoJNI";
  public static final int TYPE_BITMAP = 1;
  public static final int TYPE_SURFACE = 0;
  
  static
  {
    AppMethodBeat.i(117325);
    MMSightLock = new Object();
    AppMethodBeat.o(117325);
  }
  
  public static native void NV21ToYUV420P(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void NV21ToYUV420PAndRotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void NV21ToYUV420PAndScaleRotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6);
  
  public static native void NV21ToYUV420SP(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void NV21ToYUV420SPAndRotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void NV21ToYUV420SPAndScaleRotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6);
  
  public static native void NV21ToYUV420XXAndScaleRotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void YUV420SPScale(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void YUV420SPScaleCtxRelease();
  
  public static void addReportMetadata(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140311);
    ab.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate RemuxOutput: %s  [%d],  abaSwitch: [%d] ,qpSwitch [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    byte[] arrayOfByte;
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      arrayOfByte = new byte[5];
      byte[] tmp60_58 = arrayOfByte;
      tmp60_58[0] = 1;
      byte[] tmp65_60 = tmp60_58;
      tmp65_60[1] = 0;
      byte[] tmp70_65 = tmp65_60;
      tmp70_65[2] = 0;
      byte[] tmp75_70 = tmp70_65;
      tmp75_70[3] = 0;
      byte[] tmp80_75 = tmp75_70;
      tmp80_75[4] = 0;
      tmp80_75;
      arrayOfByte[2] = ((byte)paramArrayOfInt[3]);
      arrayOfByte[3] = ((byte)paramArrayOfInt[4]);
      arrayOfByte[4] = ((byte)paramArrayOfInt[5]);
      ab.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate RemuxOutput: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
      if (paramArrayOfInt[3] <= 0) {
        break label256;
      }
      ab.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate Write Atom: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
      tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, true);
    }
    for (;;)
    {
      optimizeMP4(paramString);
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        ab.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate RemuxOutput: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
        tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", new byte[] { 0, 1, 0, 0, 0 }, false);
        optimizeMP4(paramString);
      }
      AppMethodBeat.o(140311);
      return;
      label256:
      tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, false);
    }
  }
  
  public static native void blendYuvFrame(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void cropCameraData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void cropCameraDataLongEdge(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int drawFrame(int paramInt1, Bitmap paramBitmap1, int paramInt2, Bitmap paramBitmap2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native int drawScaledFrame(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public static native int drawSurfaceColor(Surface paramSurface, int paramInt);
  
  public static native int drawSurfaceFrame(int paramInt1, Surface paramSurface, int paramInt2, Bitmap paramBitmap, boolean paramBoolean);
  
  public static native int drawSurfaceThumb(Surface paramSurface, Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native int freeAll();
  
  public static native int freeObj(int paramInt);
  
  public static native int[] getBlurThumbData(int paramInt);
  
  public static native int[] getBlurThumbDataFromBmp(Bitmap paramBitmap);
  
  public static native int[] getCodecID(String paramString);
  
  public static native int getHeight(int paramInt);
  
  private static native byte[] getMP4Chpl(String paramString);
  
  private static native byte[] getMP4Cprt(String paramString);
  
  public static String getMP4CprtH(String paramString)
  {
    AppMethodBeat.i(140309);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(140309);
      return null;
    }
    paramString = getMP4Cprt(paramString);
    int i;
    if ((paramString != null) && (paramString.length > 0))
    {
      i = 0;
      if (i >= paramString.length) {
        break label126;
      }
      if (paramString[i] != -57) {}
    }
    for (;;)
    {
      ab.i("MicroMsg.SightVideoJNI", "tagMP4Cprt, index: %s", new Object[] { Integer.valueOf(i) });
      if (i + 1 < paramString.length)
      {
        try
        {
          byte[] arrayOfByte = new byte[paramString.length - (i + 1)];
          System.arraycopy(paramString, i + 1, arrayOfByte, 0, arrayOfByte.length);
          paramString = new String(arrayOfByte);
          AppMethodBeat.o(140309);
          return paramString;
        }
        catch (Exception paramString) {}
        i += 1;
        break;
      }
      AppMethodBeat.o(140309);
      return null;
      label126:
      i = 0;
    }
  }
  
  private static native byte[] getMP4RecordInfo(String paramString);
  
  public static String getMp4RecordInfo(String paramString)
  {
    AppMethodBeat.i(117323);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117323);
      return null;
    }
    paramString = getMP4RecordInfo(paramString);
    int i;
    if ((paramString != null) && (paramString.length > 0))
    {
      i = 0;
      if (i >= paramString.length) {
        break label126;
      }
      if (paramString[i] != -60) {}
    }
    for (;;)
    {
      ab.i("MicroMsg.SightVideoJNI", "getMp4RecordInfo, index: %s", new Object[] { Integer.valueOf(i) });
      if (i + 1 < paramString.length)
      {
        try
        {
          byte[] arrayOfByte = new byte[paramString.length - (i + 1)];
          System.arraycopy(paramString, i + 1, arrayOfByte, 0, arrayOfByte.length);
          paramString = new String(arrayOfByte);
          AppMethodBeat.o(117323);
          return paramString;
        }
        catch (Exception paramString) {}
        i += 1;
        break;
      }
      AppMethodBeat.o(117323);
      return null;
      label126:
      i = 0;
    }
  }
  
  public static native int getMp4Rotate(String paramString);
  
  public static native String getSimpleMp4Info(String paramString);
  
  public static native byte[] getThumbData(int paramInt);
  
  public static native double getVideoDuration(int paramInt);
  
  public static native int getVideoHeight(int paramInt);
  
  public static native String getVideoInfo(int paramInt);
  
  public static native double getVideoPlayTime(int paramInt);
  
  public static native double getVideoRate(int paramInt);
  
  public static native double getVideoStartTime(int paramInt);
  
  public static native int getVideoWidth(int paramInt);
  
  public static native int getWidth(int paramInt);
  
  public static native int handleThumb(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3);
  
  public static native int initBlurBuffer(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int initDataBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, float paramFloat2, int paramInt12);
  
  public static native int initDataBufferForMMSight(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3);
  
  public static int initDataBufferForMMSightLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3)
  {
    AppMethodBeat.i(117313);
    synchronized (MMSightLock)
    {
      paramInt1 = initDataBufferForMMSight(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat2, paramBoolean1, paramBoolean2, paramInt10, paramBoolean3);
      AppMethodBeat.o(117313);
      return paramInt1;
    }
  }
  
  public static native int initDataBufferForRemux();
  
  public static int initDataBufferRef(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, float paramFloat2, int paramInt12)
  {
    AppMethodBeat.i(117315);
    paramInt1 = initDataBuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramFloat1, paramInt8, paramInt9, paramInt10, paramInt11, paramFloat2, paramInt12);
    ab.d("MicroMsg.SightVideoJNI", "ashutest::call initDataBuffer, ret %d", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(117315);
    return paramInt1;
  }
  
  public static native void initScaleAndRoateBuffer(int paramInt);
  
  public static native int isSightOk(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int paramInt);
  
  public static native byte[] loadAACData(int paramInt);
  
  public static native void mirrorCameraData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native int muxing(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat2, byte[] paramArrayOfByte, int paramInt11, boolean paramBoolean1, boolean paramBoolean2);
  
  public static int muxingLock(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat2, byte[] paramArrayOfByte, int paramInt11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(117321);
    synchronized (MMSightLock)
    {
      paramInt1 = muxing(paramInt1, paramString1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramString2, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloat2, paramArrayOfByte, paramInt11, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(117321);
      return paramInt1;
    }
  }
  
  public static native int openFile(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native void optimizeMP4(String paramString);
  
  public static native void paddingYuvData16(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void registerALL();
  
  public static native void releaseBigSightDataBuffer(int paramInt);
  
  public static void releaseBigSightDataBufferLock(int paramInt)
  {
    AppMethodBeat.i(117314);
    synchronized (MMSightLock)
    {
      releaseBigSightDataBuffer(paramInt);
      AppMethodBeat.o(117314);
      return;
    }
  }
  
  public static native void releaseDataBuffer(int paramInt);
  
  public static void releaseDataBufferRef(int paramInt)
  {
    AppMethodBeat.i(117317);
    ab.d("MicroMsg.SightVideoJNI", "ashutest::call release dataBufferRef %d", new Object[] { Integer.valueOf(paramInt) });
    releaseDataBuffer(paramInt);
    AppMethodBeat.o(117317);
  }
  
  public static native int releaseRecorderBuffer();
  
  public static void releaseRecorderBufferRef(String paramString)
  {
    AppMethodBeat.i(117316);
    ab.d("MicroMsg.SightVideoJNI", "ashutest::call release recorder buffer, %s", new Object[] { paramString });
    releaseRecorderBuffer();
    AppMethodBeat.o(117316);
  }
  
  public static native void releaseScaleAndRoateBuffer(int paramInt);
  
  public static native int remuxing(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, byte[] paramArrayOfByte, int paramInt7, boolean paramBoolean, int paramInt8, int paramInt9);
  
  public static native void rgbaToNV21(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int seekStream(double paramDouble, int paramInt);
  
  public static native int seekStreamWithFlag(double paramDouble, int paramInt1, int paramInt2);
  
  public static native void setRotateForBufId(int paramInt1, int paramInt2);
  
  public static native int shouldRemuxing(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4);
  
  public static void tagMP4CprtChpl(String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(140310);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(140310);
      return;
    }
    long l = bo.yB();
    paramString2 = paramString2.getBytes();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString2.length + 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(new byte[] { 21, -57 });
    localByteBuffer.put(paramString2);
    paramString2 = localByteBuffer.array();
    localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length + 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(new byte[] { 85, -60 });
    localByteBuffer.put(paramArrayOfByte);
    paramArrayOfByte = localByteBuffer.array();
    tagMP4CprtChpl(paramString1, paramString2, paramString2.length, paramArrayOfByte, paramArrayOfByte.length, paramBoolean);
    ab.i("MicroMsg.SightVideoJNI", "tagMP4CprtInfo used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(140310);
  }
  
  private static native void tagMP4CprtChpl(String paramString, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, boolean paramBoolean);
  
  public static void tagMP4Dscp(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117324);
    if ((bo.isNullOrNil(paramString)) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(117324);
      return;
    }
    long l = bo.yB();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length + 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(new byte[] { 85, -60 });
    localByteBuffer.put(paramArrayOfByte);
    paramArrayOfByte = localByteBuffer.array();
    tagMP4Dscp(paramString, paramArrayOfByte, paramArrayOfByte.length);
    ab.i("MicroMsg.SightVideoJNI", "tagMP4Dscp used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(117324);
  }
  
  private static native void tagMP4Dscp(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  private static native void tagMP4RecordInfo(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public static void tagMp4RecordInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117322);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(117322);
      return;
    }
    long l = bo.yB();
    paramString2 = paramString2.getBytes();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString2.length + 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(new byte[] { 85, -60 });
    localByteBuffer.put(paramString2);
    paramString2 = localByteBuffer.array();
    tagMP4RecordInfo(paramString1, paramString2, paramString2.length);
    ab.i("MicroMsg.SightVideoJNI", "tagMP4RecordInfo used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(117322);
  }
  
  public static native int tagRotateVideo(String paramString1, String paramString2, int paramInt);
  
  public static native int triggerEncode(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native int triggerEncodeForBigSight(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void writeAACData(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  
  public static void writeAACDataLock(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    AppMethodBeat.i(117318);
    synchronized (MMSightLock)
    {
      writeAACData(paramInt1, paramByteBuffer, paramInt2);
      AppMethodBeat.o(117318);
      return;
    }
  }
  
  public static native void writeBlurData(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void writeH264Data(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  
  public static void writeH264DataLock(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    AppMethodBeat.i(117320);
    synchronized (MMSightLock)
    {
      writeH264Data(paramInt1, paramByteBuffer, paramInt2);
      AppMethodBeat.o(117320);
      return;
    }
  }
  
  public static native void writeRGBDataForMMSight(int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5);
  
  public static native void writeThumbData(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void writeYuvData(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void writeYuvDataForMMSight(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6);
  
  public static void writeYuvDataForMMSightLock(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(117319);
    synchronized (MMSightLock)
    {
      writeYuvDataForMMSight(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramInt5, paramInt6);
      AppMethodBeat.o(117319);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.SightVideoJNI
 * JD-Core Version:    0.7.0.1
 */