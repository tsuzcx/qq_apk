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
import com.tencent.mm.storage.at.a;

public final class h
  implements e.a
{
  private static int pda = -1;
  a KZC;
  e KZD;
  long endTimeMs;
  int hYK;
  private Object lock;
  c nAr;
  private boolean nMK;
  int nyO;
  private int pcN;
  private int pcO;
  private int pcP;
  private int pcQ;
  private int pcR;
  private int pcS;
  VideoTransPara pcW;
  private int pcX;
  String pcY;
  private MediaFormat pdb;
  private int srcHeight;
  private int srcWidth;
  long startTimeMs;
  int videoTrackIndex;
  
  public h()
  {
    AppMethodBeat.i(107657);
    this.startTimeMs = -1L;
    this.endTimeMs = -1L;
    this.pcX = 0;
    this.nMK = false;
    this.lock = new byte[0];
    this.nyO = -1;
    AppMethodBeat.o(107657);
  }
  
  private static Point D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  public static int getDecoderType()
  {
    AppMethodBeat.i(107658);
    int i = CaptureMMProxy.getInstance().getInt(at.a.acOB, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (d.rb(21)) {
          pda = 2;
        }
      }
      for (;;)
      {
        i = pda;
        AppMethodBeat.o(107658);
        return i;
        pda = 1;
        continue;
        if (i == 2) {
          pda = 1;
        } else {
          pda = 3;
        }
      }
    }
    if (pda != -1)
    {
      i = pda;
      AppMethodBeat.o(107658);
      return i;
    }
    i = af.lYf.lWC;
    if (i != -1) {
      if (i == 1) {
        pda = 1;
      }
    }
    for (;;)
    {
      i = pda;
      AppMethodBeat.o(107658);
      return i;
      if (i == 2)
      {
        if (d.rb(21)) {
          pda = 2;
        } else {
          pda = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          pda = 3;
          break;
        } while (!d.rb(Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        pda = 1;
      }
    }
  }
  
  public final void cb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(107663);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(107663);
      return;
    }
    Point localPoint1 = this.KZD.bOM();
    this.srcWidth = localPoint1.x;
    this.srcHeight = localPoint1.y;
    Point localPoint2;
    if ((this.pcS <= 0) || (this.pcR <= 0))
    {
      localPoint2 = D(this.srcWidth, this.srcHeight, this.pcN, this.pcO);
      if (localPoint2 == null) {
        break label533;
      }
      this.pcR = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.pcS = localPoint2.y;; this.pcS = this.srcHeight)
    {
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.pcR), Integer.valueOf(this.pcS), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
      long l = Util.currentTicks();
      int i = 0;
      int j = 0;
      if (this.pdb != null)
      {
        k = this.pdb.getInteger("width");
        m = this.pdb.getInteger("height");
        if (this.pcP > 0)
        {
          i = k;
          j = m;
          if (this.pcQ > 0) {}
        }
        else
        {
          localPoint2 = D(k, m, this.pcN, this.pcO);
          if (localPoint2 == null) {
            break;
          }
          this.pcP = localPoint2.x;
          this.pcQ = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.pcR = this.pcP;
            this.pcS = this.pcQ;
          }
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.pcP), Integer.valueOf(this.pcQ), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.pcX = this.KZD.bON();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.pcR, this.pcS, this.pcX, i, j);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (i < 0) {
        Log.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.KZC == null)
      {
        MP4MuxerJNI.initH264Encoder(this.pcP, this.pcQ, this.pcW.fps, this.pcW.videoBitrate, this.pcW.oBP, 8, this.pcW.oBO, 23.0F, 0, 51);
        this.KZC = new a((byte)0);
        com.tencent.threadpool.h.ahAA.bp(this.KZC);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      }
      AppMethodBeat.o(107663);
      return;
      label533:
      this.pcR = this.srcWidth;
    }
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.pcP = k;
    }
    for (this.pcQ = m;; this.pcQ = localPoint1.y)
    {
      bool = false;
      break;
      this.pcP = localPoint1.x;
    }
  }
  
  public final void eP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107660);
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.pcN = paramInt1;
    this.pcO = paramInt2;
    AppMethodBeat.o(107660);
  }
  
  public final int f(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(107659);
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.pcY });
    this.pdb = paramMediaFormat;
    int i = getDecoderType();
    if (i == 1)
    {
      this.KZD = new i(this.nAr, paramMediaFormat, this.videoTrackIndex);
      this.nMK = false;
    }
    for (;;)
    {
      if (this.KZD == null)
      {
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.KZD = new i(this.nAr, paramMediaFormat, this.videoTrackIndex);
        this.nMK = false;
      }
      int j = this.KZD.o(this.pcY, this.startTimeMs, this.endTimeMs);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (pda != 1)
        {
          i = j;
          if (pda != 2) {}
        }
        else
        {
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.KZD.stop();
        this.KZD = null;
        label193:
        this.KZD = new b();
        this.nMK = true;
        pda = 3;
        i = this.KZD.o(this.pcY, this.startTimeMs, this.endTimeMs);
        this.KZD.a(this);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(pda) });
        AppMethodBeat.o(107659);
        return i;
        if (i == 2)
        {
          this.KZD = new j(this.nAr, paramMediaFormat, this.videoTrackIndex);
          this.nMK = false;
          continue;
        }
        this.KZD = new b();
        this.nMK = true;
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
    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(pda) });
    try
    {
      if (this.KZD != null) {
        this.KZD.stop();
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
      pda = -1;
      AppMethodBeat.o(107662);
    }
  }
  
  final class a
    extends com.tencent.threadpool.i.b
  {
    int nMD;
    Object nMT;
    volatile int nzX;
    boolean pdf;
    
    private a()
    {
      AppMethodBeat.i(107655);
      this.nMT = new Object();
      AppMethodBeat.o(107655);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(107656);
      if (this.nMD == -1)
      {
        this.nMD = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.nMD) });
      }
      this.nzX = 0;
      for (;;)
      {
        int i;
        synchronized (this.nMT)
        {
          if (this.pdf) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.nzX), false);
          Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.nzX;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(20L);
          this.nzX = i;
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
      this.nzX = MP4MuxerJNI.triggerEncodeForSegment(this.nzX, true);
      Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */