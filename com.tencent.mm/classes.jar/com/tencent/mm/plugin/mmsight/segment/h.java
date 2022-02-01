package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;

public final class h
  implements e.a
{
  private static int iyL = -1;
  int dHi;
  long hlm;
  int hlw;
  c hmL;
  int hmM;
  private int iyA;
  private int iyB;
  private int iyC;
  private int iyD;
  VideoTransPara iyH;
  private int iyI;
  String iyJ;
  private MediaFormat iyM;
  private int iyw;
  private int iyx;
  private int iyy;
  private int iyz;
  private Object lock;
  long startTimeMs;
  a wdQ;
  e wdR;
  private boolean wdS;
  
  public h()
  {
    AppMethodBeat.i(107657);
    this.startTimeMs = -1L;
    this.hlm = -1L;
    this.iyI = 0;
    this.wdS = false;
    this.lock = new byte[0];
    this.hlw = -1;
    AppMethodBeat.o(107657);
  }
  
  public static int getDecoderType()
  {
    AppMethodBeat.i(107658);
    int i = CaptureMMProxy.getInstance().getInt(am.a.IRe, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (d.lA(21)) {
          iyL = 2;
        }
      }
      for (;;)
      {
        i = iyL;
        AppMethodBeat.o(107658);
        return i;
        iyL = 1;
        continue;
        if (i == 2) {
          iyL = 1;
        } else {
          iyL = 3;
        }
      }
    }
    if (iyL != -1)
    {
      i = iyL;
      AppMethodBeat.o(107658);
      return i;
    }
    i = com.tencent.mm.compatible.deviceinfo.ae.geT.gdv;
    if (i != -1) {
      if (i == 1) {
        iyL = 1;
      }
    }
    for (;;)
    {
      i = iyL;
      AppMethodBeat.o(107658);
      return i;
      if (i == 2)
      {
        if (d.lA(21)) {
          iyL = 2;
        } else {
          iyL = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          iyL = 3;
          break;
        } while (!d.lA(bu.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        iyL = 1;
      }
    }
  }
  
  private static Point v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107661);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(107661);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(107661);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
  
  public final void bs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(107663);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(107663);
      return;
    }
    Point localPoint1 = this.wdR.aNF();
    this.iyw = localPoint1.x;
    this.iyx = localPoint1.y;
    Point localPoint2;
    if ((this.iyD <= 0) || (this.iyC <= 0))
    {
      localPoint2 = v(this.iyw, this.iyx, this.iyy, this.iyz);
      if (localPoint2 == null) {
        break label533;
      }
      this.iyC = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.iyD = localPoint2.y;; this.iyD = this.iyx)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.iyC), Integer.valueOf(this.iyD), Integer.valueOf(this.iyw), Integer.valueOf(this.iyx) });
      long l = bu.HQ();
      int i = 0;
      int j = 0;
      if (this.iyM != null)
      {
        k = this.iyM.getInteger("width");
        m = this.iyM.getInteger("height");
        if (this.iyA > 0)
        {
          i = k;
          j = m;
          if (this.iyB > 0) {}
        }
        else
        {
          localPoint2 = v(k, m, this.iyy, this.iyz);
          if (localPoint2 == null) {
            break;
          }
          this.iyA = localPoint2.x;
          this.iyB = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.iyC = this.iyA;
            this.iyD = this.iyB;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.iyA), Integer.valueOf(this.iyB), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.iyI = this.wdR.aNG();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.iyC, this.iyD, this.iyI, i, j);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      if (i < 0) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.wdQ == null)
      {
        MP4MuxerJNI.initH264Encoder(this.iyA, this.iyB, this.iyH.fps, this.iyH.videoBitrate, this.iyH.hXX, 8, this.iyH.hXW, 23.0F, 0, 51);
        this.wdQ = new a((byte)0);
        com.tencent.e.h.MqF.aR(this.wdQ);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      }
      AppMethodBeat.o(107663);
      return;
      label533:
      this.iyC = this.iyw;
    }
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.iyA = k;
    }
    for (this.iyB = m;; this.iyB = localPoint1.y)
    {
      bool = false;
      break;
      this.iyA = localPoint1.x;
    }
  }
  
  public final void dq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107660);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.iyy = paramInt1;
    this.iyz = paramInt2;
    AppMethodBeat.o(107660);
  }
  
  public final int h(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(107659);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.iyJ });
    this.iyM = paramMediaFormat;
    int i = getDecoderType();
    if (i == 1)
    {
      this.wdR = new i(this.hmL, paramMediaFormat, this.hmM);
      this.wdS = false;
    }
    for (;;)
    {
      if (this.wdR == null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.wdR = new i(this.hmL, paramMediaFormat, this.hmM);
        this.wdS = false;
      }
      int j = this.wdR.n(this.iyJ, this.startTimeMs, this.hlm);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (iyL != 1)
        {
          i = j;
          if (iyL != 2) {}
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.wdR.stop();
        this.wdR = null;
        label193:
        this.wdR = new b();
        this.wdS = true;
        iyL = 3;
        i = this.wdR.n(this.iyJ, this.startTimeMs, this.hlm);
        this.wdR.a(this);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(iyL) });
        AppMethodBeat.o(107659);
        return i;
        if (i == 2)
        {
          this.wdR = new j(this.hmL, paramMediaFormat, this.hmM);
          this.wdS = false;
          continue;
        }
        this.wdR = new b();
        this.wdS = true;
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(iyL) });
    try
    {
      if (this.wdR != null) {
        this.wdR.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBuf(0);
      iyL = -1;
      AppMethodBeat.o(107662);
    }
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    volatile int hmE;
    int hyO;
    Object hzd;
    boolean iyQ;
    
    private a()
    {
      AppMethodBeat.i(107655);
      this.hzd = new Object();
      AppMethodBeat.o(107655);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(107656);
      if (this.hyO == -1)
      {
        this.hyO = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hyO) });
      }
      this.hmE = 0;
      for (;;)
      {
        int i;
        synchronized (this.hzd)
        {
          if (this.iyQ) {
            break label193;
          }
          l = bu.HQ();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.hmE), false);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.hmE;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(20L);
          this.hmE = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(107656);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bu.HQ();
      this.hmE = MP4MuxerJNI.triggerEncodeForSegment(this.hmE, true);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */