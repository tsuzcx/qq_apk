package com.tencent.mm.plugin.sight.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  
  public static void addReportMetadata(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133635);
    int j = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vuM, 1);
    Log.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate RemuxOutput: %s, abaSwitch: [%d] ,qpSwitch [%d] androidflag[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(j) });
    byte[] arrayOfByte;
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      arrayOfByte = new byte[4];
      byte[] tmp78_76 = arrayOfByte;
      tmp78_76[0] = 1;
      byte[] tmp83_78 = tmp78_76;
      tmp83_78[1] = 0;
      byte[] tmp88_83 = tmp83_78;
      tmp88_83[2] = 0;
      byte[] tmp93_88 = tmp88_83;
      tmp93_88[3] = 0;
      tmp93_88;
      int i = 0;
      paramInt1 = 0;
      if (paramArrayOfInt != null)
      {
        arrayOfByte[2] = ((byte)paramArrayOfInt[3]);
        i = paramArrayOfInt[3];
        paramInt1 = paramArrayOfInt[4];
      }
      if (j == 1)
      {
        arrayOfByte[3] = 66;
        Log.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate RemuxOutput: %s  [%d]", new Object[] { paramString, Integer.valueOf(i) });
        if (i <= 0) {
          break label320;
        }
        tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, true);
        label174:
        optimizeMP4VFS(paramString);
      }
    }
    else if ((paramInt2 == 1) || (paramInt2 == 2))
    {
      arrayOfByte = new byte[4];
      byte[] tmp196_194 = arrayOfByte;
      tmp196_194[0] = 0;
      byte[] tmp201_196 = tmp196_194;
      tmp201_196[1] = 1;
      byte[] tmp206_201 = tmp201_196;
      tmp206_201[2] = 0;
      byte[] tmp211_206 = tmp206_201;
      tmp211_206[3] = 0;
      tmp211_206;
      arrayOfByte[2] = ((byte)paramArrayOfInt[3]);
      if (j != 1) {
        break label348;
      }
      arrayOfByte[3] = 66;
      label237:
      Log.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate(QP) RemuxOutput: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
      if (paramArrayOfInt[3] <= 0) {
        break label357;
      }
      Log.i("MicroMsg.SightVideoJNI", "ABA: Adaptive Bitrate Write Atom: %s  [%d]", new Object[] { paramString, Integer.valueOf(paramArrayOfInt[3]) });
      tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, true);
    }
    for (;;)
    {
      optimizeMP4VFS(paramString);
      AppMethodBeat.o(133635);
      return;
      arrayOfByte[3] = 68;
      break;
      label320:
      if (paramInt1 > 0)
      {
        tagMP4CprtChpl(paramString, "AdaptiveBitrateDown", arrayOfByte, true);
        break label174;
      }
      tagMP4CprtChpl(paramString, "AdaptiveBitrateUP", arrayOfByte, false);
      break label174;
      label348:
      arrayOfByte[3] = 68;
      break label237;
      label357:
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
  
  public static native void finishVideoEncode(int paramInt);
  
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
    boolean bool = com.tencent.mm.modelcontrol.c.bkl();
    paramString = getSimpleMp4Info(q.n(paramString, false), bool);
    AppMethodBeat.o(133624);
    return paramString;
  }
  
  public static String getSimpleMp4InfoVFS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213846);
    paramBoolean = com.tencent.mm.modelcontrol.c.bkl();
    paramString = getSimpleMp4Info(q.n(paramString, false), paramBoolean);
    AppMethodBeat.o(213846);
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
  
  public static native int initDataBufferForMMSight(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3, String paramString, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6);
  
  public static int initDataBufferForMMSightLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3)
  {
    AppMethodBeat.i(133611);
    synchronized (MMSightLock)
    {
      paramInt1 = initDataBufferForMMSight(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat2, paramBoolean1, paramBoolean2, paramInt10, paramBoolean3, c.fIw(), c.av(paramBoolean2, false), true, false);
      AppMethodBeat.o(133611);
      return paramInt1;
    }
  }
  
  public static int initDataBufferForMMSightLock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, int paramInt10, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(213783);
    synchronized (MMSightLock)
    {
      paramInt1 = initDataBufferForMMSight(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramFloat2, paramBoolean1, paramBoolean2, paramInt10, paramBoolean3, c.fIw(), paramBoolean5, true, paramBoolean4);
      AppMethodBeat.o(213783);
      return paramInt1;
    }
  }
  
  private static native int initDataBufferForRemux(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public static int initDataBufferForRemux(boolean paramBoolean)
  {
    AppMethodBeat.i(133612);
    int i = initDataBufferForRemux(c.fIw(), c.av(false, paramBoolean), true, paramBoolean);
    AppMethodBeat.o(133612);
    return i;
  }
  
  public static native void initScaleAndRoateBuffer(int paramInt);
  
  private static native int initSoftEncodeDataBuffer(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, boolean paramBoolean1, int paramInt4, int paramInt5, int paramInt6, float paramFloat2, boolean paramBoolean2, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean3, String paramString);
  
  public static int initSoftEncodeDataBufferLock(int paramInt1, int paramInt2, int paramInt3, float paramFloat, boolean paramBoolean1, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2)
  {
    AppMethodBeat.i(213787);
    int i;
    if (paramBoolean1) {
      i = 5;
    }
    for (;;)
    {
      boolean bool = d.JrG;
      synchronized (MMSightLock)
      {
        paramInt1 = initSoftEncodeDataBuffer(paramInt1, paramInt2, paramInt3, paramFloat, paramBoolean1, i, 8, 2, 23.0F, bool, paramInt4, paramInt5, paramInt6, paramBoolean2, c.fIw());
        AppMethodBeat.o(213787);
        return paramInt1;
        i = 1;
      }
    }
  }
  
  public static int initSoftEncodeDataBufferLock(int paramInt1, int paramInt2, int paramInt3, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213790);
    int i;
    if (paramBoolean1) {
      i = 5;
    }
    for (;;)
    {
      boolean bool = d.JrG;
      synchronized (MMSightLock)
      {
        paramInt1 = initSoftEncodeDataBuffer(paramInt1, paramInt2, paramInt3, paramFloat, paramBoolean1, i, 8, 2, 23.0F, bool, -1, -1, -1, paramBoolean2, c.fIw());
        AppMethodBeat.o(213790);
        return paramInt1;
        i = 1;
      }
    }
  }
  
  public static int initSoftEncodeDataBufferLock(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, float paramFloat1, int paramInt4, int paramInt5, int paramInt6, float paramFloat2, boolean paramBoolean2, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean3)
  {
    AppMethodBeat.i(213793);
    synchronized (MMSightLock)
    {
      paramInt1 = initSoftEncodeDataBuffer(paramInt1, paramInt2, paramInt3, paramFloat1, paramBoolean1, paramInt4, paramInt5, paramInt6, paramFloat2, paramBoolean2, paramInt7, paramInt8, paramInt9, paramBoolean3, c.fIw());
      AppMethodBeat.o(213793);
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
    AppMethodBeat.i(213828);
    paramInt1 = muxingLock(paramInt1, null, paramInt2, 1024, 2, paramInt3, 0L, paramString, paramFloat, paramInt4, paramInt5, d.JrF, 8, 2, 23.0F, null, 0, false, paramBoolean1, false, false, paramBoolean2);
    AppMethodBeat.o(213828);
    return paramInt1;
  }
  
  public static int muxingLock(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2, float paramFloat1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat2, byte[] paramArrayOfByte, int paramInt11, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(213834);
    for (;;)
    {
      synchronized (MMSightLock)
      {
        long l = Util.currentTicks();
        paramInt1 = muxing(paramInt1, q.n(paramString1, false), paramInt2, paramInt3, paramInt4, paramInt5, paramLong, q.n(paramString2, true), paramFloat1, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramFloat2, paramArrayOfByte, paramInt11, paramBoolean1, paramBoolean2, paramBoolean5, c.fIv());
        c.av(0L, 1L);
        if (paramInt1 < 0)
        {
          c.av(2L, 1L);
          paramLong = Util.ticksToNow(l);
          c.av(3L, paramLong);
          Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight reportMuxingResult retVal: %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        switch (paramInt1)
        {
        case 10001: 
          AppMethodBeat.o(213834);
          return paramInt1;
          c.av(1L, 1L);
        }
      }
      c.av(15L, 1L);
      c.av(16L, 1L);
      c.av(18L, paramLong);
      continue;
      c.av(15L, 1L);
      c.av(17L, 1L);
      c.av(18L, paramLong);
      continue;
      c.av(20L, 1L);
      c.av(21L, 1L);
      c.av(23L, paramLong);
      continue;
      c.av(20L, 1L);
      c.av(22L, 1L);
      c.av(23L, paramLong);
      continue;
      c.av(25L, 1L);
      c.av(26L, 1L);
      c.av(28L, paramLong);
      continue;
      c.av(25L, 1L);
      c.av(27L, 1L);
      c.av(28L, paramLong);
      continue;
      c.av(30L, 1L);
      c.av(31L, 1L);
      c.av(33L, paramLong);
      continue;
      c.av(30L, 1L);
      c.av(32L, 1L);
      c.av(33L, paramLong);
      continue;
      c.av(35L, 1L);
      c.av(36L, 1L);
      c.av(38L, paramLong);
      continue;
      c.av(35L, 1L);
      c.av(37L, 1L);
      c.av(38L, paramLong);
      continue;
      c.av(40L, 1L);
      c.av(41L, 1L);
      c.av(43L, paramLong);
      continue;
      c.av(40L, 1L);
      c.av(42L, 1L);
      c.av(43L, paramLong);
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
    AppMethodBeat.i(213860);
    paramString = q.n(paramString, true);
    String str = paramString + ".tmp";
    boolean bool = optimizeMP4(paramString, str);
    Log.d("MicroMsg.SightVideoJNI", "optimizeMP4VFS result:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      u.oo(str, paramString);
      if ((Build.VERSION.SDK_INT >= 30) && (!paramString.contains("/" + MMApplicationContext.getContext().getPackageName())) && (!new File(new File(paramString).getParent(), ".nomedia").exists())) {
        com.tencent.e.h.ZvG.o(new SightVideoJNI.1(paramString), 800L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(213860);
      return bool;
      Log.e("MicroMsg.SightVideoJNI", "optimizeMP4VFS error");
      u.deleteFile(str);
      com.tencent.mm.plugin.report.service.h.IzE.p(986L, 147L, 1L);
    }
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
    boolean bool = c.fIu();
    paramInt1 = remuxing(q.n(paramString1, false), q.n(paramString2, true), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloat1, paramFloat2, paramArrayOfByte, paramInt7, paramBoolean, paramInt8, paramInt9, c.fIw(), bool);
    if (bool)
    {
      c.av(82L, 1L);
      if (paramInt1 < 0) {
        c.av(81L, 1L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133623);
      return paramInt1;
      c.av(80L, 1L);
      continue;
      c.av(85L, 1L);
      if (paramInt1 < 0) {
        c.av(84L, 1L);
      } else {
        c.av(83L, 1L);
      }
    }
  }
  
  public static void reportIDKey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(176224);
    try
    {
      f.Iyx.idkeyStat(paramLong1, paramLong2, paramLong3, false);
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
    AppMethodBeat.i(213820);
    synchronized (MMSightLock)
    {
      writeDtsData(paramInt, paramLong);
      AppMethodBeat.o(213820);
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