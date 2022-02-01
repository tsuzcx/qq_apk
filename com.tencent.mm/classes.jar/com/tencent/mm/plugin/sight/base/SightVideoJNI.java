package com.tencent.mm.plugin.sight.base;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    AppMethodBeat.i(133637);
    MMSightLock = new Object();
    AppMethodBeat.o(133637);
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
    AppMethodBeat.i(133635);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqp, 0);
    ad.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate RemuxOutput: %s  [%d],  abaSwitch: [%d] ,qpSwitch [%d] androidflag[%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    byte[] arrayOfByte;
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      arrayOfByte = new byte[4];
      byte[] tmp87_85 = arrayOfByte;
      tmp87_85[0] = 1;
      byte[] tmp92_87 = tmp87_85;
      tmp92_87[1] = 0;
      byte[] tmp97_92 = tmp92_87;
      tmp97_92[2] = 0;
      byte[] tmp102_97 = tmp97_92;
      tmp102_97[3] = 0;
      tmp102_97;
      arrayOfByte[2] = ((byte)paramArrayOfInt[3]);
      if (i == 1)
      {
        arrayOfByte[3] = 66;
        ad.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate RemuxOutput: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
        if (paramArrayOfInt[3] <= 0) {
          break label335;
        }
        ad.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate Write Atom: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
        tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, true);
        label191:
        optimizeMP4VFS(paramString);
      }
    }
    else if ((paramInt2 == 1) || (paramInt2 == 2))
    {
      arrayOfByte = new byte[4];
      byte[] tmp212_210 = arrayOfByte;
      tmp212_210[0] = 0;
      byte[] tmp217_212 = tmp212_210;
      tmp217_212[1] = 1;
      byte[] tmp222_217 = tmp217_212;
      tmp222_217[2] = 0;
      byte[] tmp227_222 = tmp222_217;
      tmp227_222[3] = 0;
      tmp227_222;
      arrayOfByte[2] = ((byte)paramArrayOfInt[3]);
      if (i != 1) {
        break label365;
      }
      arrayOfByte[3] = 66;
      label253:
      ad.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate(QP) RemuxOutput: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
      if (paramArrayOfInt[3] <= 0) {
        break label374;
      }
      ad.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate Write Atom: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
      tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, true);
    }
    for (;;)
    {
      optimizeMP4VFS(paramString);
      AppMethodBeat.o(133635);
      return;
      arrayOfByte[3] = 68;
      break;
      label335:
      if (paramArrayOfInt[4] > 0)
      {
        tagMP4CprtChpl(paramString, "AdaptiveBitrateDown", arrayOfByte, true);
        break label191;
      }
      tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, false);
      break label191;
      label365:
      arrayOfByte[3] = 68;
      break label253;
      label374:
      tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, false);
    }
  }
  
  public static native void blendYuvFrame(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void cropCameraData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void cropCameraDataLongEdge(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void cropCameraDataLongEdgeCenterCrop(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int drawFrame(int paramInt1, Bitmap paramBitmap1, int paramInt2, Bitmap paramBitmap2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native int drawScaledFrame(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public static native int drawSurfaceColor(Surface paramSurface, int paramInt);
  
  public static native int drawSurfaceFrame(int paramInt1, Surface paramSurface, int paramInt2, Bitmap paramBitmap, boolean paramBoolean);
  
  public static native int drawSurfaceThumb(Surface paramSurface, Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native int freeAll();
  
  public static native int freeObj(int paramInt);
  
  public static native int[] getBlurThumbData(int paramInt);
  
  public static native int[] getBlurThumbDataFromBmp(Bitmap paramBitmap);
  
  public static native int getHeight(int paramInt);
  
  private static native byte[] getMP4Chpl(String paramString);
  
  private static native byte[] getMP4Cprt(String paramString);
  
  public static String getMP4CprtH(String paramString)
  {
    AppMethodBeat.i(133633);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133633);
      return null;
    }
    paramString = getMP4Cprt(q.k(paramString, false));
    int i;
    if ((paramString != null) && (paramString.length > 0))
    {
      i = 0;
      if (i >= paramString.length) {
        break label130;
      }
      if (paramString[i] != -57) {}
    }
    for (;;)
    {
      ad.i("MicroMsg.SightVideoJNI", "tagMP4Cprt, index: %s", new Object[] { Integer.valueOf(i) });
      if (i + 1 < paramString.length)
      {
        try
        {
          byte[] arrayOfByte = new byte[paramString.length - (i + 1)];
          System.arraycopy(paramString, i + 1, arrayOfByte, 0, arrayOfByte.length);
          paramString = new String(arrayOfByte);
          AppMethodBeat.o(133633);
          return paramString;
        }
        catch (Exception paramString) {}
        i += 1;
        break;
      }
      AppMethodBeat.o(133633);
      return null;
      label130:
      i = 0;
    }
  }
  
  private static native byte[] getMP4RecordInfo(String paramString);
  
  public static String getMp4RecordInfo(String paramString)
  {
    AppMethodBeat.i(133631);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133631);
      return null;
    }
    paramString = getMP4RecordInfo(q.k(paramString, false));
    int i;
    if ((paramString != null) && (paramString.length > 0))
    {
      i = 0;
      if (i >= paramString.length) {
        break label130;
      }
      if (paramString[i] != -60) {}
    }
    for (;;)
    {
      ad.i("MicroMsg.SightVideoJNI", "getMp4RecordInfo, index: %s", new Object[] { Integer.valueOf(i) });
      if (i + 1 < paramString.length)
      {
        try
        {
          byte[] arrayOfByte = new byte[paramString.length - (i + 1)];
          System.arraycopy(paramString, i + 1, arrayOfByte, 0, arrayOfByte.length);
          paramString = new String(arrayOfByte);
          AppMethodBeat.o(133631);
          return paramString;
        }
        catch (Exception paramString) {}
        i += 1;
        break;
      }
      AppMethodBeat.o(133631);
      return null;
      label130:
      i = 0;
    }
  }
  
  private static native int getMp4Rotate(String paramString);
  
  public static int getMp4RotateVFS(String paramString)
  {
    AppMethodBeat.i(133628);
    int i = getMp4Rotate(q.k(paramString, false));
    AppMethodBeat.o(133628);
    return i;
  }
  
  private static native String getSimpleMp4Info(String paramString);
  
  public static String getSimpleMp4InfoVFS(String paramString)
  {
    AppMethodBeat.i(133624);
    paramString = getSimpleMp4Info(q.k(paramString, false));
    AppMethodBeat.o(133624);
    return paramString;
  }
  
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
  
  public static native int initDataBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, float paramFloat2, int paramInt12, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native int initDataBufferForMMSight(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3, String paramString, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6);
  
  public static int initDataBufferForMMSightLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, String paramString)
  {
    AppMethodBeat.i(187805);
    synchronized (MMSightLock)
    {
      paramInt1 = initDataBufferForMMSight(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat2, paramBoolean1, paramBoolean2, paramInt10, false, paramString, b.af(paramBoolean2, false), true, false);
      AppMethodBeat.o(187805);
      return paramInt1;
    }
  }
  
  public static int initDataBufferForMMSightLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3)
  {
    AppMethodBeat.i(133611);
    synchronized (MMSightLock)
    {
      paramInt1 = initDataBufferForMMSight(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat2, paramBoolean1, paramBoolean2, paramInt10, paramBoolean3, b.dPX(), b.af(paramBoolean2, false), true, false);
      AppMethodBeat.o(133611);
      return paramInt1;
    }
  }
  
  public static int initDataBufferForMMSightLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(187804);
    synchronized (MMSightLock)
    {
      paramInt1 = initDataBufferForMMSight(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat2, paramBoolean1, paramBoolean2, paramInt10, paramBoolean3, b.dPX(), paramBoolean5, true, paramBoolean4);
      AppMethodBeat.o(187804);
      return paramInt1;
    }
  }
  
  private static native int initDataBufferForRemux(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public static int initDataBufferForRemux(boolean paramBoolean)
  {
    AppMethodBeat.i(133612);
    int i = initDataBufferForRemux(b.dPX(), b.af(false, paramBoolean), true, paramBoolean);
    AppMethodBeat.o(133612);
    return i;
  }
  
  public static int initDataBufferRef(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, float paramFloat2, int paramInt12)
  {
    AppMethodBeat.i(133609);
    paramInt1 = initDataBuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramFloat1, paramInt8, paramInt9, paramInt10, paramInt11, paramFloat2, paramInt12, b.dPX(), false, true);
    ad.d("MicroMsg.SightVideoJNI", "ashutest::call initDataBuffer, ret %d", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(133609);
    return paramInt1;
  }
  
  public static native void initScaleAndRoateBuffer(int paramInt);
  
  private static native boolean isH265Video(String paramString);
  
  public static boolean isH265VideoVFS(String paramString)
  {
    AppMethodBeat.i(133625);
    boolean bool = isH265Video(q.k(paramString, false));
    AppMethodBeat.o(133625);
    return bool;
  }
  
  private static native int isSightOk(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int paramInt);
  
  public static int isSightOkVFS(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int paramInt)
  {
    AppMethodBeat.i(133626);
    paramInt = isSightOk(q.k(paramString, false), paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramInt);
    AppMethodBeat.o(133626);
    return paramInt;
  }
  
  public static native byte[] loadAACData(int paramInt);
  
  public static native void mirrorCameraData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native int muxing(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat2, byte[] paramArrayOfByte, int paramInt11, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  public static int muxingLock(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat2, byte[] paramArrayOfByte, int paramInt11, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(187806);
    for (;;)
    {
      synchronized (MMSightLock)
      {
        long l = bt.HI();
        paramInt1 = muxing(paramInt1, q.k(paramString1, false), paramInt2, paramInt3, paramInt4, paramInt5, paramLong, q.k(paramString2, true), paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloat2, paramArrayOfByte, paramInt11, paramBoolean1, paramBoolean2, paramBoolean5, b.dPW());
        b.ai(0L, 1L);
        if (paramInt1 < 0)
        {
          b.ai(2L, 1L);
          paramLong = bt.aO(l);
          b.ai(3L, paramLong);
          ad.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight reportMuxingResult retVal: %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        switch (paramInt1)
        {
        case 10001: 
          AppMethodBeat.o(187806);
          return paramInt1;
          b.ai(1L, 1L);
        }
      }
      b.ai(15L, 1L);
      b.ai(16L, 1L);
      b.ai(18L, paramLong);
      continue;
      b.ai(15L, 1L);
      b.ai(17L, 1L);
      b.ai(18L, paramLong);
      continue;
      b.ai(20L, 1L);
      b.ai(21L, 1L);
      b.ai(23L, paramLong);
      continue;
      b.ai(20L, 1L);
      b.ai(22L, 1L);
      b.ai(23L, paramLong);
      continue;
      b.ai(25L, 1L);
      b.ai(26L, 1L);
      b.ai(28L, paramLong);
      continue;
      b.ai(25L, 1L);
      b.ai(27L, 1L);
      b.ai(28L, paramLong);
      continue;
      b.ai(30L, 1L);
      b.ai(31L, 1L);
      b.ai(33L, paramLong);
      continue;
      b.ai(30L, 1L);
      b.ai(32L, 1L);
      b.ai(33L, paramLong);
      continue;
      b.ai(35L, 1L);
      b.ai(36L, 1L);
      b.ai(38L, paramLong);
      continue;
      b.ai(35L, 1L);
      b.ai(37L, 1L);
      b.ai(38L, paramLong);
      continue;
      b.ai(40L, 1L);
      b.ai(41L, 1L);
      b.ai(43L, paramLong);
      continue;
      b.ai(40L, 1L);
      b.ai(42L, 1L);
      b.ai(43L, paramLong);
    }
  }
  
  private static native int openFile(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static int openFileVFS(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(133608);
    paramInt1 = openFile(q.k(paramString, false), paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(133608);
    return paramInt1;
  }
  
  private static native void optimizeMP4(String paramString);
  
  public static void optimizeMP4VFS(String paramString)
  {
    AppMethodBeat.i(133636);
    optimizeMP4(q.k(paramString, false));
    AppMethodBeat.o(133636);
  }
  
  public static native void paddingYuvData16(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void registerALL();
  
  public static native void releaseBigSightDataBuffer(int paramInt);
  
  public static void releaseBigSightDataBufferLock(int paramInt)
  {
    AppMethodBeat.i(133613);
    synchronized (MMSightLock)
    {
      releaseBigSightDataBuffer(paramInt);
      AppMethodBeat.o(133613);
      return;
    }
  }
  
  public static native void releaseDataBuffer(int paramInt);
  
  public static void releaseDataBufferRef(int paramInt)
  {
    AppMethodBeat.i(133616);
    ad.d("MicroMsg.SightVideoJNI", "ashutest::call release dataBufferRef %d", new Object[] { Integer.valueOf(paramInt) });
    releaseDataBuffer(paramInt);
    AppMethodBeat.o(133616);
  }
  
  public static native int releaseRecorderBuffer();
  
  public static void releaseRecorderBufferRef(String paramString)
  {
    AppMethodBeat.i(133614);
    ad.d("MicroMsg.SightVideoJNI", "ashutest::call release recorder buffer, %s", new Object[] { paramString });
    releaseRecorderBuffer();
    AppMethodBeat.o(133614);
  }
  
  public static void releaseRecorderBufferRefLock(String paramString)
  {
    AppMethodBeat.i(133615);
    synchronized (MMSightLock)
    {
      ad.d("MicroMsg.SightVideoJNI", "ashutest::call release recorder buffer, %s", new Object[] { paramString });
      releaseRecorderBuffer();
      AppMethodBeat.o(133615);
      return;
    }
  }
  
  public static native void releaseScaleAndRoateBuffer(int paramInt);
  
  private static native int remuxing(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, byte[] paramArrayOfByte, int paramInt7, boolean paramBoolean1, int paramInt8, int paramInt9, String paramString3, boolean paramBoolean2);
  
  public static int remuxingVFS(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat1, float paramFloat2, byte[] paramArrayOfByte, int paramInt7, boolean paramBoolean, int paramInt8, int paramInt9)
  {
    AppMethodBeat.i(133623);
    boolean bool = b.dPV();
    paramInt1 = remuxing(q.k(paramString1, false), q.k(paramString2, true), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloat1, paramFloat2, paramArrayOfByte, paramInt7, paramBoolean, paramInt8, paramInt9, b.dPX(), bool);
    if (bool)
    {
      b.ai(82L, 1L);
      if (paramInt1 < 0) {
        b.ai(81L, 1L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133623);
      return paramInt1;
      b.ai(80L, 1L);
      continue;
      b.ai(85L, 1L);
      if (paramInt1 < 0) {
        b.ai(84L, 1L);
      } else {
        b.ai(83L, 1L);
      }
    }
  }
  
  public static void reportIDKey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(176224);
    try
    {
      e.ygI.idkeyStat(paramLong1, paramLong2, paramLong3, false);
      ad.d("MicroMsg.SightVideoJNI", "reportIDKey jni called: %d, %d, %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(176224);
      return;
    }
    catch (Error localError)
    {
      ad.printErrStackTrace("MicroMsg.SightVideoJNI", localError, "reportIDKey jni called error", new Object[0]);
      AppMethodBeat.o(176224);
    }
  }
  
  public static native void rgbaToNV21(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int seekStream(double paramDouble, int paramInt);
  
  public static native int seekStreamWithFlag(double paramDouble, int paramInt1, int paramInt2);
  
  public static native void setRotateForBufId(int paramInt1, int paramInt2);
  
  private static native int shouldRemuxing(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4);
  
  public static int shouldRemuxingVFS(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4)
  {
    AppMethodBeat.i(133622);
    paramInt1 = shouldRemuxing(q.k(paramString, false), paramInt1, paramInt2, paramInt3, paramDouble, paramInt4);
    AppMethodBeat.o(133622);
    return paramInt1;
  }
  
  public static void tagMP4CprtChpl(String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(133634);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(133634);
      return;
    }
    long l = bt.HI();
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
    tagMP4CprtChpl(q.k(paramString1, false), paramString2, paramString2.length, paramArrayOfByte, paramArrayOfByte.length, paramBoolean);
    ad.i("MicroMsg.SightVideoJNI", "tagMP4CprtInfo used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(133634);
  }
  
  private static native void tagMP4CprtChpl(String paramString, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, boolean paramBoolean);
  
  public static void tagMP4Dscp(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133632);
    if ((bt.isNullOrNil(paramString)) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(133632);
      return;
    }
    long l = bt.HI();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length + 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(new byte[] { 85, -60 });
    localByteBuffer.put(paramArrayOfByte);
    paramArrayOfByte = localByteBuffer.array();
    tagMP4Dscp(q.k(paramString, false), paramArrayOfByte, paramArrayOfByte.length);
    ad.i("MicroMsg.SightVideoJNI", "tagMP4Dscp used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(133632);
  }
  
  private static native void tagMP4Dscp(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  private static native void tagMP4RecordInfo(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public static void tagMp4RecordInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133630);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(133630);
      return;
    }
    long l = bt.HI();
    paramString2 = paramString2.getBytes();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString2.length + 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(new byte[] { 85, -60 });
    localByteBuffer.put(paramString2);
    paramString2 = localByteBuffer.array();
    tagMP4RecordInfo(q.k(paramString1, false), paramString2, paramString2.length);
    ad.i("MicroMsg.SightVideoJNI", "tagMP4RecordInfo used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(133630);
  }
  
  private static native int tagRotateVideo(String paramString1, String paramString2, int paramInt);
  
  public static int tagRotateVideoVFS(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133627);
    paramInt = tagRotateVideo(q.k(paramString1, false), q.k(paramString2, true), paramInt);
    AppMethodBeat.o(133627);
    return paramInt;
  }
  
  public static native int triggerEncode(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native int triggerEncodeForBigSight(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void writeAACData(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, long paramLong);
  
  public static void writeAACDataLock(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(133617);
    synchronized (MMSightLock)
    {
      writeAACData(paramInt1, paramByteBuffer, paramInt2, paramLong);
      AppMethodBeat.o(133617);
      return;
    }
  }
  
  public static native void writeAACDataWithADTS(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5);
  
  public static void writeAACDataWithADTSLock(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(133618);
    synchronized (MMSightLock)
    {
      writeAACDataWithADTS(paramInt1, paramByteBuffer, paramInt2, paramLong, paramInt3, paramInt4, paramInt5);
      AppMethodBeat.o(133618);
      return;
    }
  }
  
  public static native void writeBlurData(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void writeH264Data(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, long paramLong);
  
  public static void writeH264DataLock(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(133620);
    synchronized (MMSightLock)
    {
      writeH264Data(paramInt1, paramByteBuffer, paramInt2, paramLong);
      AppMethodBeat.o(133620);
      return;
    }
  }
  
  public static native void writeRGBDataForMMSight(int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5);
  
  public static native void writeThumbData(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void writeYuvData(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void writeYuvDataForMMSight(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6);
  
  public static void writeYuvDataForMMSightLock(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(133619);
    synchronized (MMSightLock)
    {
      writeYuvDataForMMSight(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramInt5, paramInt6);
      AppMethodBeat.o(133619);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.SightVideoJNI
 * JD-Core Version:    0.7.0.1
 */