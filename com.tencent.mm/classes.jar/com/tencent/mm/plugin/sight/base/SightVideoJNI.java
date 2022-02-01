package com.tencent.mm.plugin.sight.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.File;
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
  
  public static native void NV21ToYUV420XXAndScaleRotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native int addAudioPtsArray(long[] paramArrayOfLong);
  
  public static void addReportArrayMetadata(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292136);
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      byte[] arrayOfByte = new byte[4];
      byte[] tmp22_20 = arrayOfByte;
      tmp22_20[0] = 1;
      byte[] tmp27_22 = tmp22_20;
      tmp27_22[1] = 0;
      byte[] tmp32_27 = tmp27_22;
      tmp32_27[2] = 0;
      byte[] tmp37_32 = tmp32_27;
      tmp37_32[3] = 0;
      tmp37_32;
      if (paramArrayOfInt != null) {
        arrayOfByte[2] = ((byte)paramArrayOfInt[3]);
      }
      arrayOfByte[3] = 68;
      String str1;
      String str2;
      if ((paramArrayOfInt != null) && (paramArrayOfInt[3] > 0))
      {
        str1 = "br11";
        if ((paramArrayOfInt == null) || (paramArrayOfInt[35] <= 0)) {
          break label202;
        }
        str2 = "dr1";
        label90:
        if ((paramArrayOfInt == null) || (paramArrayOfInt[20] != 1)) {
          break label209;
        }
        paramArrayOfInt = "1";
      }
      for (;;)
      {
        paramArrayOfInt = "wxmmca" + str1 + str2 + paramArrayOfInt + "00";
        Log.i("MicroMsg.SightVideoJNI", "ABA: array method add the metadata filename: [%s] cprt [%s]", new Object[] { paramString, paramArrayOfInt });
        tagMP4CprtChpl(paramString, paramArrayOfInt, arrayOfByte, true);
        optimizeMP4VFS(paramString);
        AppMethodBeat.o(292136);
        return;
        if ((paramArrayOfInt != null) && (paramArrayOfInt[4] > 0))
        {
          str1 = "br22";
          break;
        }
        str1 = "br00";
        break;
        label202:
        str2 = "dr0";
        break label90;
        label209:
        if ((paramArrayOfInt != null) && (paramArrayOfInt[20] == 2)) {
          paramArrayOfInt = "2";
        } else {
          paramArrayOfInt = "0";
        }
      }
    }
    Log.i("MicroMsg.SightVideoJNI", "ABA: array method aba switch is closed");
    AppMethodBeat.o(292136);
  }
  
  public static void addReportMetadata(String paramString, ABAPrams paramABAPrams, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292124);
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      byte[] arrayOfByte = new byte[4];
      byte[] tmp22_20 = arrayOfByte;
      tmp22_20[0] = 1;
      byte[] tmp27_22 = tmp22_20;
      tmp27_22[1] = 0;
      byte[] tmp32_27 = tmp27_22;
      tmp32_27[2] = 0;
      byte[] tmp37_32 = tmp32_27;
      tmp37_32[3] = 0;
      tmp37_32;
      if (paramABAPrams != null) {
        arrayOfByte[2] = ((byte)paramABAPrams.bitrateAdaptiveUP);
      }
      arrayOfByte[3] = 68;
      String str1;
      String str2;
      if ((paramABAPrams != null) && (paramABAPrams.bitrateAdaptiveUP > 0))
      {
        str1 = "br11";
        if ((paramABAPrams == null) || (paramABAPrams.skipVideoCompress <= 0)) {
          break label205;
        }
        str2 = "dr1";
        label92:
        if ((paramABAPrams == null) || (paramABAPrams.isEnableHEVC != 1)) {
          break label212;
        }
        paramABAPrams = "1";
      }
      for (;;)
      {
        paramABAPrams = "wxmmca" + str1 + str2 + paramABAPrams + "00";
        Log.i("MicroMsg.SightVideoJNI", "ABA: add the metadata filename: [%s] cprt [%s]", new Object[] { paramString, paramABAPrams });
        tagMP4CprtChpl(paramString, paramABAPrams, arrayOfByte, true);
        optimizeMP4VFS(paramString);
        AppMethodBeat.o(292124);
        return;
        if ((paramABAPrams != null) && (paramABAPrams.bitrateAdaptiveDown > 0))
        {
          str1 = "br22";
          break;
        }
        str1 = "br00";
        break;
        label205:
        str2 = "dr0";
        break label92;
        label212:
        if ((paramABAPrams != null) && (paramABAPrams.isEnableHEVC == 2)) {
          paramABAPrams = "2";
        } else {
          paramABAPrams = "0";
        }
      }
    }
    Log.i("MicroMsg.SightVideoJNI", "ABA: aba switch is closed");
    AppMethodBeat.o(292124);
  }
  
  public static native int addVideoDtsArray(long[] paramArrayOfLong, float paramFloat);
  
  public static native int addVideoPtsArray(long[] paramArrayOfLong, float paramFloat);
  
  public static native void blendYuvFrame(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void cropCameraData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void cropCameraDataLongEdge(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void cropCameraDataLongEdgeCenterCrop(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int drawFrame(int paramInt1, Bitmap paramBitmap1, int paramInt2, Bitmap paramBitmap2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native int drawScaledFrame(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public static native int drawSurfaceColor(Surface paramSurface, int paramInt);
  
  public static native int drawSurfaceFrame(int paramInt1, Surface paramSurface, int paramInt2, Bitmap paramBitmap, boolean paramBoolean);
  
  public static native int drawSurfaceThumb(Surface paramSurface, Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native void finishVideoEncode(int paramInt);
  
  public static native int freeAll();
  
  public static native int freeObj(int paramInt);
  
  public static native byte[] getAACADTSHeaderData(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int[] getBlurThumbData(int paramInt);
  
  public static native int[] getBlurThumbDataFromBmp(Bitmap paramBitmap);
  
  public static native long[] getEncodeDtsArray(int paramInt);
  
  public static native long[] getEncodePtsArray(int paramInt);
  
  public static native String getH264FilePath(int paramInt);
  
  public static native int getHeight(int paramInt);
  
  private static native byte[] getMP4Chpl(String paramString);
  
  private static native byte[] getMP4Cprt(String paramString);
  
  public static String getMP4CprtH(String paramString)
  {
    AppMethodBeat.i(133633);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133633);
      return null;
    }
    paramString = getMP4Cprt(q.n(paramString, false));
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
      Log.i("MicroMsg.SightVideoJNI", "tagMP4Cprt, index: %s", new Object[] { Integer.valueOf(i) });
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
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133631);
      return null;
    }
    paramString = getMP4RecordInfo(q.n(paramString, false));
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
      Log.i("MicroMsg.SightVideoJNI", "getMp4RecordInfo, index: %s", new Object[] { Integer.valueOf(i) });
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
    int i = getMp4Rotate(q.n(paramString, false));
    AppMethodBeat.o(133628);
    return i;
  }
  
  private static native String getSimpleMp4Info(String paramString, boolean paramBoolean);
  
  public static String getSimpleMp4InfoVFS(String paramString)
  {
    AppMethodBeat.i(133624);
    boolean bool = com.tencent.mm.modelcontrol.c.bIc();
    paramString = getSimpleMp4Info(q.n(paramString, false), bool);
    AppMethodBeat.o(133624);
    return paramString;
  }
  
  public static String getSimpleMp4InfoVFS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(292025);
    paramBoolean = com.tencent.mm.modelcontrol.c.bIc();
    paramString = getSimpleMp4Info(q.n(paramString, false), paramBoolean);
    AppMethodBeat.o(292025);
    return paramString;
  }
  
  public static native byte[] getThumbData(int paramInt);
  
  public static native double getVideoDuration(int paramInt);
  
  public static native int getVideoHeight(int paramInt);
  
  public static native String getVideoInfo(int paramInt);
  
  public static native String getVideoMetaData(String paramString);
  
  public static native double getVideoPlayTime(int paramInt);
  
  public static native double getVideoRate(int paramInt);
  
  public static native double getVideoStartTime(int paramInt);
  
  public static native int getVideoWidth(int paramInt);
  
  public static native int getWidth(int paramInt);
  
  public static native int handleThumb(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3);
  
  public static native int initDataBufferForMMSight(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3, String paramString, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6);
  
  public static int initDataBufferForMMSightLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3)
  {
    AppMethodBeat.i(133611);
    synchronized (MMSightLock)
    {
      paramInt1 = initDataBufferForMMSight(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat2, paramBoolean1, paramBoolean2, paramInt10, paramBoolean3, c.gYp(), c.aO(paramBoolean2, false), true, false);
      AppMethodBeat.o(133611);
      return paramInt1;
    }
  }
  
  public static int initDataBufferForMMSightLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(291945);
    synchronized (MMSightLock)
    {
      paramInt1 = initDataBufferForMMSight(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat2, paramBoolean1, paramBoolean2, paramInt10, paramBoolean3, c.gYp(), paramBoolean5, true, paramBoolean4);
      AppMethodBeat.o(291945);
      return paramInt1;
    }
  }
  
  private static native int initDataBufferForRemux(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public static int initDataBufferForRemux(boolean paramBoolean)
  {
    AppMethodBeat.i(133612);
    int i = initDataBufferForRemux(c.gYp(), c.aO(false, paramBoolean), true, paramBoolean);
    AppMethodBeat.o(133612);
    return i;
  }
  
  public static native void initScaleAndRoateBuffer(int paramInt);
  
  private static native int initSoftEncodeDataBuffer(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, boolean paramBoolean1, int paramInt4, int paramInt5, int paramInt6, float paramFloat2, boolean paramBoolean2, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean3, String paramString);
  
  public static int initSoftEncodeDataBufferLock(int paramInt1, int paramInt2, int paramInt3, float paramFloat, boolean paramBoolean1, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2)
  {
    AppMethodBeat.i(291949);
    int i;
    if (paramBoolean1) {
      i = 5;
    }
    for (;;)
    {
      boolean bool = d.PFi;
      synchronized (MMSightLock)
      {
        paramInt1 = initSoftEncodeDataBuffer(paramInt1, paramInt2, paramInt3, paramFloat, paramBoolean1, i, 8, 2, 23.0F, bool, paramInt4, paramInt5, paramInt6, paramBoolean2, c.gYp());
        AppMethodBeat.o(291949);
        return paramInt1;
        i = 1;
      }
    }
  }
  
  public static int initSoftEncodeDataBufferLock(int paramInt1, int paramInt2, int paramInt3, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(291951);
    int i;
    if (paramBoolean1) {
      i = 5;
    }
    for (;;)
    {
      boolean bool = d.PFi;
      synchronized (MMSightLock)
      {
        paramInt1 = initSoftEncodeDataBuffer(paramInt1, paramInt2, paramInt3, paramFloat, paramBoolean1, i, 8, 2, 23.0F, bool, -1, -1, -1, paramBoolean2, c.gYp());
        AppMethodBeat.o(291951);
        return paramInt1;
        i = 1;
      }
    }
  }
  
  public static int initSoftEncodeDataBufferLock(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, float paramFloat1, int paramInt4, int paramInt5, int paramInt6, float paramFloat2, boolean paramBoolean2, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean3)
  {
    AppMethodBeat.i(291953);
    synchronized (MMSightLock)
    {
      paramInt1 = initSoftEncodeDataBuffer(paramInt1, paramInt2, paramInt3, paramFloat1, paramBoolean1, paramInt4, paramInt5, paramInt6, paramFloat2, paramBoolean2, paramInt7, paramInt8, paramInt9, paramBoolean3, c.gYp());
      AppMethodBeat.o(291953);
      return paramInt1;
    }
  }
  
  private static native boolean isH265Video(String paramString);
  
  public static boolean isH265VideoVFS(String paramString)
  {
    AppMethodBeat.i(133625);
    boolean bool = isH265Video(q.n(paramString, false));
    AppMethodBeat.o(133625);
    return bool;
  }
  
  private static native int isSightOk(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int paramInt);
  
  public static int isSightOkVFS(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int paramInt)
  {
    AppMethodBeat.i(133626);
    paramInt = isSightOk(q.n(paramString, false), paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramInt);
    AppMethodBeat.o(133626);
    return paramInt;
  }
  
  public static native byte[] loadAACData(int paramInt);
  
  public static native void mirrorCameraData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native int muxing(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat2, byte[] paramArrayOfByte, int paramInt11, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  public static int muxingLock(int paramInt1, String paramString, int paramInt2, int paramInt3, float paramFloat, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292004);
    paramInt1 = muxingLock(paramInt1, null, paramInt2, 1024, 2, paramInt3, 0L, paramString, paramFloat, paramInt4, paramInt5, d.PFh, 8, 2, 23.0F, null, 0, false, paramBoolean1, false, false, paramBoolean2);
    AppMethodBeat.o(292004);
    return paramInt1;
  }
  
  public static int muxingLock(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat2, byte[] paramArrayOfByte, int paramInt11, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(292009);
    for (;;)
    {
      synchronized (MMSightLock)
      {
        long l = Util.currentTicks();
        paramInt1 = muxing(paramInt1, q.n(paramString1, false), paramInt2, paramInt3, paramInt4, paramInt5, paramLong, q.n(paramString2, true), paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloat2, paramArrayOfByte, paramInt11, paramBoolean1, paramBoolean2, paramBoolean5, c.gYo());
        c.bf(0L, 1L);
        if (paramInt1 < 0)
        {
          c.bf(2L, 1L);
          paramLong = Util.ticksToNow(l);
          c.bf(3L, paramLong);
          Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight reportMuxingResult retVal: %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        switch (paramInt1)
        {
        case 10001: 
          AppMethodBeat.o(292009);
          return paramInt1;
          c.bf(1L, 1L);
        }
      }
      c.bf(15L, 1L);
      c.bf(16L, 1L);
      c.bf(18L, paramLong);
      continue;
      c.bf(15L, 1L);
      c.bf(17L, 1L);
      c.bf(18L, paramLong);
      continue;
      c.bf(20L, 1L);
      c.bf(21L, 1L);
      c.bf(23L, paramLong);
      continue;
      c.bf(20L, 1L);
      c.bf(22L, 1L);
      c.bf(23L, paramLong);
      continue;
      c.bf(25L, 1L);
      c.bf(26L, 1L);
      c.bf(28L, paramLong);
      continue;
      c.bf(25L, 1L);
      c.bf(27L, 1L);
      c.bf(28L, paramLong);
      continue;
      c.bf(30L, 1L);
      c.bf(31L, 1L);
      c.bf(33L, paramLong);
      continue;
      c.bf(30L, 1L);
      c.bf(32L, 1L);
      c.bf(33L, paramLong);
      continue;
      c.bf(35L, 1L);
      c.bf(36L, 1L);
      c.bf(38L, paramLong);
      continue;
      c.bf(35L, 1L);
      c.bf(37L, 1L);
      c.bf(38L, paramLong);
      continue;
      c.bf(40L, 1L);
      c.bf(41L, 1L);
      c.bf(43L, paramLong);
      continue;
      c.bf(40L, 1L);
      c.bf(42L, 1L);
      c.bf(43L, paramLong);
    }
  }
  
  public static native void nativeBufferCopy(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2, int paramInt3);
  
  private static native int openFile(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static int openFileVFS(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(133608);
    paramInt1 = openFile(q.n(paramString, false), paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(133608);
    return paramInt1;
  }
  
  private static native boolean optimizeMP4(String paramString1, String paramString2);
  
  public static boolean optimizeMP4VFS(String paramString)
  {
    AppMethodBeat.i(292146);
    paramString = q.n(paramString, true);
    String str = paramString + ".tmp";
    boolean bool = optimizeMP4(paramString, str);
    Log.d("MicroMsg.SightVideoJNI", "optimizeMP4VFS result:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      y.qn(str, paramString);
      if ((Build.VERSION.SDK_INT >= 30) && (!paramString.contains("/" + MMApplicationContext.getContext().getPackageName())) && (!new File(new File(paramString).getParent(), ".nomedia").exists())) {
        com.tencent.threadpool.h.ahAA.p(new SightVideoJNI.1(paramString), 800L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(292146);
      return bool;
      Log.e("MicroMsg.SightVideoJNI", "optimizeMP4VFS error");
      y.deleteFile(str);
      com.tencent.mm.plugin.report.service.h.OAn.p(986L, 147L, 1L);
    }
  }
  
  public static native void paddingYuvData16(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int parallelMuxing(String[] paramArrayOfString, String paramString1, String paramString2, long paramLong, float paramFloat, boolean paramBoolean);
  
  public static int parallelMuxingLock(String[] paramArrayOfString, String paramString1, String paramString2, long paramLong, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(292189);
    synchronized (MMSightLock)
    {
      int i = parallelMuxing(paramArrayOfString, paramString1, paramString2, paramLong, paramFloat, paramBoolean);
      AppMethodBeat.o(292189);
      return i;
    }
  }
  
  public static native int parallelRelease();
  
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
  
  public static native int releaseRecorderBuffer();
  
  public static void releaseRecorderBufferRef(String paramString)
  {
    AppMethodBeat.i(133614);
    Log.d("MicroMsg.SightVideoJNI", "ashutest::call release recorder buffer, %s", new Object[] { paramString });
    releaseRecorderBuffer();
    AppMethodBeat.o(133614);
  }
  
  public static void releaseRecorderBufferRefLock(String paramString)
  {
    AppMethodBeat.i(133615);
    synchronized (MMSightLock)
    {
      Log.d("MicroMsg.SightVideoJNI", "ashutest::call release recorder buffer, %s", new Object[] { paramString });
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
    boolean bool = c.gYn();
    paramInt1 = remuxing(q.n(paramString1, false), q.n(paramString2, true), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloat1, paramFloat2, paramArrayOfByte, paramInt7, paramBoolean, paramInt8, paramInt9, c.gYp(), bool);
    if (bool)
    {
      c.bf(82L, 1L);
      if (paramInt1 < 0) {
        c.bf(81L, 1L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133623);
      return paramInt1;
      c.bf(80L, 1L);
      continue;
      c.bf(85L, 1L);
      if (paramInt1 < 0) {
        c.bf(84L, 1L);
      } else {
        c.bf(83L, 1L);
      }
    }
  }
  
  public static void reportIDKey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(176224);
    try
    {
      f.Ozc.idkeyStat(paramLong1, paramLong2, paramLong3, false);
      Log.d("MicroMsg.SightVideoJNI", "reportIDKey jni called: %d, %d, %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(176224);
      return;
    }
    catch (Error localError)
    {
      Log.printErrStackTrace("MicroMsg.SightVideoJNI", localError, "reportIDKey jni called error", new Object[0]);
      AppMethodBeat.o(176224);
    }
  }
  
  public static native void rgbaToNV21(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int seekStream(double paramDouble, int paramInt);
  
  public static native int seekStreamWithFlag(double paramDouble, int paramInt1, int paramInt2);
  
  public static native void setEnableVCodecEncode(int paramInt);
  
  public static native void setI420Format(int paramInt, boolean paramBoolean);
  
  public static native void setRotateForBufId(int paramInt1, int paramInt2);
  
  public static native void setVideoFormatHeader(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  private static native int shouldRemuxing(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4);
  
  public static int shouldRemuxingVFS(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4)
  {
    AppMethodBeat.i(133622);
    paramInt1 = shouldRemuxing(q.n(paramString, false), paramInt1, paramInt2, paramInt3, paramDouble, paramInt4);
    AppMethodBeat.o(133622);
    return paramInt1;
  }
  
  public static void tagMP4CprtChpl(String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(133634);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(133634);
      return;
    }
    long l = Util.currentTicks();
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
    tagMP4CprtChpl(q.n(paramString1, false), paramString2, paramString2.length, paramArrayOfByte, paramArrayOfByte.length, paramBoolean);
    Log.i("MicroMsg.SightVideoJNI", "tagMP4CprtInfo used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(133634);
  }
  
  private static native void tagMP4CprtChpl(String paramString, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, boolean paramBoolean);
  
  public static void tagMP4Dscp(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133632);
    if ((Util.isNullOrNil(paramString)) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(133632);
      return;
    }
    long l = Util.currentTicks();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length + 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(new byte[] { 85, -60 });
    localByteBuffer.put(paramArrayOfByte);
    paramArrayOfByte = localByteBuffer.array();
    tagMP4Dscp(q.n(paramString, false), paramArrayOfByte, paramArrayOfByte.length);
    Log.i("MicroMsg.SightVideoJNI", "tagMP4Dscp used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(133632);
  }
  
  private static native void tagMP4Dscp(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  private static native void tagMP4RecordInfo(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public static void tagMp4RecordInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133630);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(133630);
      return;
    }
    long l = Util.currentTicks();
    paramString2 = paramString2.getBytes();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString2.length + 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.put(new byte[] { 85, -60 });
    localByteBuffer.put(paramString2);
    paramString2 = localByteBuffer.array();
    tagMP4RecordInfo(q.n(paramString1, false), paramString2, paramString2.length);
    Log.i("MicroMsg.SightVideoJNI", "tagMP4RecordInfo used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(133630);
  }
  
  private static native int tagRotateVideo(String paramString1, String paramString2, int paramInt);
  
  public static int tagRotateVideoVFS(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133627);
    paramInt = tagRotateVideo(q.n(paramString1, false), q.n(paramString2, true), paramInt);
    AppMethodBeat.o(133627);
    return paramInt;
  }
  
  public static native int triggerEncode(int paramInt1, int paramInt2, boolean paramBoolean);
  
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
  
  private static native void writeDtsData(int paramInt, long paramLong);
  
  public static void writeDtsDataLock(int paramInt, long paramLong)
  {
    AppMethodBeat.i(291994);
    synchronized (MMSightLock)
    {
      writeDtsData(paramInt, paramLong);
      AppMethodBeat.o(291994);
      return;
    }
  }
  
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
  
  public static native void writeYuvDataForMMSight(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6);
  
  public static native void writeYuvDataForMMSightEncode(int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);
  
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
  
  public static native void writeYuvDataForMMSightWithBuffer(int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.SightVideoJNI
 * JD-Core Version:    0.7.0.1
 */