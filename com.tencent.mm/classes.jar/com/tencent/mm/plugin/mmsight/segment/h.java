package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
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
  private static int mjD = -1;
  a FdT;
  e FdU;
  long endTimeMs;
  int fSM;
  int kTg;
  c kUU;
  private boolean lib;
  private Object lock;
  private int mjA;
  String mjB;
  private MediaFormat mjE;
  private int mjq;
  private int mjr;
  private int mjs;
  private int mjt;
  private int mju;
  private int mjv;
  VideoTransPara mjz;
  private int srcHeight;
  private int srcWidth;
  long startTimeMs;
  int videoTrackIndex;
  
  public h()
  {
    AppMethodBeat.i(107657);
    this.startTimeMs = -1L;
    this.endTimeMs = -1L;
    this.mjA = 0;
    this.lib = false;
    this.lock = new byte[0];
    this.kTg = -1;
    AppMethodBeat.o(107657);
  }
  
  public static int getDecoderType()
  {
    AppMethodBeat.i(107658);
    int i = CaptureMMProxy.getInstance().getInt(ar.a.Vng, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (d.qV(21)) {
          mjD = 2;
        }
      }
      for (;;)
      {
        i = mjD;
        AppMethodBeat.o(107658);
        return i;
        mjD = 1;
        continue;
        if (i == 2) {
          mjD = 1;
        } else {
          mjD = 3;
        }
      }
    }
    if (mjD != -1)
    {
      i = mjD;
      AppMethodBeat.o(107658);
      return i;
    }
    i = af.juO.jtl;
    if (i != -1) {
      if (i == 1) {
        mjD = 1;
      }
    }
    for (;;)
    {
      i = mjD;
      AppMethodBeat.o(107658);
      return i;
      if (i == 2)
      {
        if (d.qV(21)) {
          mjD = 2;
        } else {
          mjD = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          mjD = 3;
          break;
        } while (!d.qV(Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        mjD = 1;
      }
    }
  }
  
  private static Point x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  public final void bZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(107663);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(107663);
      return;
    }
    Point localPoint1 = this.FdU.brg();
    this.srcWidth = localPoint1.x;
    this.srcHeight = localPoint1.y;
    Point localPoint2;
    if ((this.mjv <= 0) || (this.mju <= 0))
    {
      localPoint2 = x(this.srcWidth, this.srcHeight, this.mjq, this.mjr);
      if (localPoint2 == null) {
        break label533;
      }
      this.mju = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.mjv = localPoint2.y;; this.mjv = this.srcHeight)
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.mju), Integer.valueOf(this.mjv), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
      long l = Util.currentTicks();
      int i = 0;
      int j = 0;
      if (this.mjE != null)
      {
        k = this.mjE.getInteger("width");
        m = this.mjE.getInteger("height");
        if (this.mjs > 0)
        {
          i = k;
          j = m;
          if (this.mjt > 0) {}
        }
        else
        {
          localPoint2 = x(k, m, this.mjq, this.mjr);
          if (localPoint2 == null) {
            break;
          }
          this.mjs = localPoint2.x;
          this.mjt = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.mju = this.mjs;
            this.mjv = this.mjt;
          }
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.mjs), Integer.valueOf(this.mjt), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.mjA = this.FdU.brh();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.mju, this.mjv, this.mjA, i, j);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (i < 0) {
        Log.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.FdT == null)
      {
        MP4MuxerJNI.initH264Encoder(this.mjs, this.mjt, this.mjz.fps, this.mjz.videoBitrate, this.mjz.lJn, 8, this.mjz.lJm, 23.0F, 0, 51);
        this.FdT = new a((byte)0);
        com.tencent.e.h.ZvG.bh(this.FdT);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      }
      AppMethodBeat.o(107663);
      return;
      label533:
      this.mju = this.srcWidth;
    }
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.mjs = k;
    }
    for (this.mjt = m;; this.mjt = localPoint1.y)
    {
      bool = false;
      break;
      this.mjs = localPoint1.x;
    }
  }
  
  public final void dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107660);
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mjq = paramInt1;
    this.mjr = paramInt2;
    AppMethodBeat.o(107660);
  }
  
  public final int f(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(107659);
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.mjB });
    this.mjE = paramMediaFormat;
    int i = getDecoderType();
    if (i == 1)
    {
      this.FdU = new i(this.kUU, paramMediaFormat, this.videoTrackIndex);
      this.lib = false;
    }
    for (;;)
    {
      if (this.FdU == null)
      {
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.FdU = new i(this.kUU, paramMediaFormat, this.videoTrackIndex);
        this.lib = false;
      }
      int j = this.FdU.m(this.mjB, this.startTimeMs, this.endTimeMs);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (mjD != 1)
        {
          i = j;
          if (mjD != 2) {}
        }
        else
        {
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.FdU.stop();
        this.FdU = null;
        label193:
        this.FdU = new b();
        this.lib = true;
        mjD = 3;
        i = this.FdU.m(this.mjB, this.startTimeMs, this.endTimeMs);
        this.FdU.a(this);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(mjD) });
        AppMethodBeat.o(107659);
        return i;
        if (i == 2)
        {
          this.FdU = new j(this.kUU, paramMediaFormat, this.videoTrackIndex);
          this.lib = false;
          continue;
        }
        this.FdU = new b();
        this.lib = true;
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
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(mjD) });
    try
    {
      if (this.FdU != null) {
        this.FdU.stop();
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
      mjD = -1;
      AppMethodBeat.o(107662);
    }
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    volatile int kUo;
    int lhU;
    Object lik;
    boolean mjI;
    
    private a()
    {
      AppMethodBeat.i(107655);
      this.lik = new Object();
      AppMethodBeat.o(107655);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(107656);
      if (this.lhU == -1)
      {
        this.lhU = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.lhU) });
      }
      this.kUo = 0;
      for (;;)
      {
        int i;
        synchronized (this.lik)
        {
          if (this.mjI) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.kUo), false);
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.kUo;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(20L);
          this.kUo = i;
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
      this.kUo = MP4MuxerJNI.triggerEncodeForSegment(this.kUo, true);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */