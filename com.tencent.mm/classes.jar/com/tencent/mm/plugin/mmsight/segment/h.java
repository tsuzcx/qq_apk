package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;

public final class h
  implements e.a
{
  private static int jtZ = -1;
  int dYT;
  long endTimeMs;
  int ies;
  c igg;
  private int jtM;
  private int jtN;
  private int jtO;
  private int jtP;
  private int jtQ;
  private int jtR;
  VideoTransPara jtV;
  private int jtW;
  String jtX;
  private MediaFormat jua;
  private Object lock;
  private int srcHeight;
  private int srcWidth;
  long startTimeMs;
  int videoTrackIndex;
  private boolean zyA;
  a zyy;
  e zyz;
  
  public h()
  {
    AppMethodBeat.i(107657);
    this.startTimeMs = -1L;
    this.endTimeMs = -1L;
    this.jtW = 0;
    this.zyA = false;
    this.lock = new byte[0];
    this.ies = -1;
    AppMethodBeat.o(107657);
  }
  
  public static int getDecoderType()
  {
    AppMethodBeat.i(107658);
    int i = CaptureMMProxy.getInstance().getInt(ar.a.NZg, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (d.oD(21)) {
          jtZ = 2;
        }
      }
      for (;;)
      {
        i = jtZ;
        AppMethodBeat.o(107658);
        return i;
        jtZ = 1;
        continue;
        if (i == 2) {
          jtZ = 1;
        } else {
          jtZ = 3;
        }
      }
    }
    if (jtZ != -1)
    {
      i = jtZ;
      AppMethodBeat.o(107658);
      return i;
    }
    i = ae.gKA.gIT;
    if (i != -1) {
      if (i == 1) {
        jtZ = 1;
      }
    }
    for (;;)
    {
      i = jtZ;
      AppMethodBeat.o(107658);
      return i;
      if (i == 2)
      {
        if (d.oD(21)) {
          jtZ = 2;
        } else {
          jtZ = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          jtZ = 3;
          break;
        } while (!d.oD(Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        jtZ = 1;
      }
    }
  }
  
  private static Point v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107661);
    Log.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(107661);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(107661);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
      paramInt4 = paramInt1 / 2;
      paramInt3 = paramInt2 / 2;
      paramInt1 = paramInt4;
      if (paramInt4 % 2 != 0) {
        paramInt1 = paramInt4 + 1;
      }
      paramInt2 = paramInt3;
      if (paramInt3 % 2 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      localPoint = new Point(paramInt1, paramInt2);
      AppMethodBeat.o(107661);
      return localPoint;
    }
    m /= 2;
    k /= 2;
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
      paramInt4 = paramInt1 / 2;
      paramInt3 = paramInt2 / 2;
      paramInt1 = paramInt4;
      if (paramInt4 % 2 != 0) {
        paramInt1 = paramInt4 + 1;
      }
      paramInt2 = paramInt3;
      if (paramInt3 % 2 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      localPoint = new Point(paramInt1, paramInt2);
      AppMethodBeat.o(107661);
      return localPoint;
    }
    Point localPoint = new Point();
    double d;
    if (paramInt1 < paramInt2)
    {
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt1 * 1.0D / paramInt3;
      paramInt2 = (int)(paramInt2 / d);
      paramInt1 = paramInt3;
    }
    for (;;)
    {
      paramInt3 = paramInt2;
      if (paramInt2 % 2 != 0) {
        paramInt3 = paramInt2 + 1;
      }
      paramInt2 = paramInt1;
      if (paramInt1 % 2 != 0) {
        paramInt2 = paramInt1 + 1;
      }
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      AppMethodBeat.o(107661);
      return localPoint;
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt2 * 1.0D / paramInt3;
      paramInt1 = (int)(paramInt1 / d);
      paramInt2 = paramInt3;
    }
  }
  
  public final void bJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(107663);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(107663);
      return;
    }
    Point localPoint1 = this.zyz.bhJ();
    this.srcWidth = localPoint1.x;
    this.srcHeight = localPoint1.y;
    Point localPoint2;
    if ((this.jtR <= 0) || (this.jtQ <= 0))
    {
      localPoint2 = v(this.srcWidth, this.srcHeight, this.jtM, this.jtN);
      if (localPoint2 == null) {
        break label533;
      }
      this.jtQ = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.jtR = localPoint2.y;; this.jtR = this.srcHeight)
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.jtQ), Integer.valueOf(this.jtR), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
      long l = Util.currentTicks();
      int i = 0;
      int j = 0;
      if (this.jua != null)
      {
        k = this.jua.getInteger("width");
        m = this.jua.getInteger("height");
        if (this.jtO > 0)
        {
          i = k;
          j = m;
          if (this.jtP > 0) {}
        }
        else
        {
          localPoint2 = v(k, m, this.jtM, this.jtN);
          if (localPoint2 == null) {
            break;
          }
          this.jtO = localPoint2.x;
          this.jtP = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.jtQ = this.jtO;
            this.jtR = this.jtP;
          }
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.jtO), Integer.valueOf(this.jtP), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.jtW = this.zyz.bhK();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.jtQ, this.jtR, this.jtW, i, j);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (i < 0) {
        Log.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.zyy == null)
      {
        MP4MuxerJNI.initH264Encoder(this.jtO, this.jtP, this.jtV.fps, this.jtV.videoBitrate, this.jtV.iSV, 8, this.jtV.iSU, 23.0F, 0, 51);
        this.zyy = new a((byte)0);
        com.tencent.f.h.RTc.ba(this.zyy);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      }
      AppMethodBeat.o(107663);
      return;
      label533:
      this.jtQ = this.srcWidth;
    }
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.jtO = k;
    }
    for (this.jtP = m;; this.jtP = localPoint1.y)
    {
      bool = false;
      break;
      this.jtO = localPoint1.x;
    }
  }
  
  public final void dA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107660);
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.jtM = paramInt1;
    this.jtN = paramInt2;
    AppMethodBeat.o(107660);
  }
  
  public final int h(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(107659);
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.jtX });
    this.jua = paramMediaFormat;
    int i = getDecoderType();
    if (i == 1)
    {
      this.zyz = new i(this.igg, paramMediaFormat, this.videoTrackIndex);
      this.zyA = false;
    }
    for (;;)
    {
      if (this.zyz == null)
      {
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.zyz = new i(this.igg, paramMediaFormat, this.videoTrackIndex);
        this.zyA = false;
      }
      int j = this.zyz.n(this.jtX, this.startTimeMs, this.endTimeMs);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (jtZ != 1)
        {
          i = j;
          if (jtZ != 2) {}
        }
        else
        {
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.zyz.stop();
        this.zyz = null;
        label193:
        this.zyz = new b();
        this.zyA = true;
        jtZ = 3;
        i = this.zyz.n(this.jtX, this.startTimeMs, this.endTimeMs);
        this.zyz.a(this);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(jtZ) });
        AppMethodBeat.o(107659);
        return i;
        if (i == 2)
        {
          this.zyz = new j(this.igg, paramMediaFormat, this.videoTrackIndex);
          this.zyA = false;
          continue;
        }
        this.zyz = new b();
        this.zyA = true;
      }
      catch (Exception paramMediaFormat)
      {
        break label193;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(107662);
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(jtZ) });
    try
    {
      if (this.zyz != null) {
        this.zyz.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBuf(0);
      jtZ = -1;
      AppMethodBeat.o(107662);
    }
  }
  
  final class a
    extends com.tencent.f.i.b
  {
    volatile int ifA;
    int isP;
    Object ite;
    boolean jue;
    
    private a()
    {
      AppMethodBeat.i(107655);
      this.ite = new Object();
      AppMethodBeat.o(107655);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(107656);
      if (this.isP == -1)
      {
        this.isP = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.isP) });
      }
      this.ifA = 0;
      for (;;)
      {
        int i;
        synchronized (this.ite)
        {
          if (this.jue) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.ifA), false);
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.ifA;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(20L);
          this.ifA = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(107656);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = Util.currentTicks();
      this.ifA = MP4MuxerJNI.triggerEncodeForSegment(this.ifA, true);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */