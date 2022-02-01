package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;

public final class h
  implements e.a
{
  private static int hBV = -1;
  long bxw;
  int dwp;
  long gnO;
  int gnX;
  c gqX;
  int gqY;
  private int hBG;
  private int hBH;
  private int hBI;
  private int hBJ;
  private int hBK;
  private int hBL;
  private int hBM;
  private int hBN;
  VideoTransPara hBR;
  private int hBS;
  String hBT;
  private MediaFormat hBW;
  private Object lock;
  a tGi;
  e tGj;
  private boolean tGk;
  
  public h()
  {
    AppMethodBeat.i(107657);
    this.bxw = -1L;
    this.gnO = -1L;
    this.hBS = 0;
    this.tGk = false;
    this.lock = new byte[0];
    this.gnX = -1;
    AppMethodBeat.o(107657);
  }
  
  public static int getDecoderType()
  {
    AppMethodBeat.i(107658);
    int i = CaptureMMProxy.getInstance().getInt(ae.a.Fmz, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (d.lf(21)) {
          hBV = 2;
        }
      }
      for (;;)
      {
        i = hBV;
        AppMethodBeat.o(107658);
        return i;
        hBV = 1;
        continue;
        if (i == 2) {
          hBV = 1;
        } else {
          hBV = 3;
        }
      }
    }
    if (hBV != -1)
    {
      i = hBV;
      AppMethodBeat.o(107658);
      return i;
    }
    i = ae.fFD.fEg;
    if (i != -1) {
      if (i == 1) {
        hBV = 1;
      }
    }
    for (;;)
    {
      i = hBV;
      AppMethodBeat.o(107658);
      return i;
      if (i == 2)
      {
        if (d.lf(21)) {
          hBV = 2;
        } else {
          hBV = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          hBV = 3;
          break;
        } while (!d.lf(bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        hBV = 1;
      }
    }
  }
  
  private static Point v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107661);
    ad.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(107661);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(107661);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
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
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
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
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
  
  public final void br(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(107663);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(107663);
      return;
    }
    Point localPoint1 = this.tGj.aDh();
    this.hBG = localPoint1.x;
    this.hBH = localPoint1.y;
    Point localPoint2;
    if ((this.hBN <= 0) || (this.hBM <= 0))
    {
      localPoint2 = v(this.hBG, this.hBH, this.hBI, this.hBJ);
      if (localPoint2 == null) {
        break label533;
      }
      this.hBM = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.hBN = localPoint2.y;; this.hBN = this.hBH)
    {
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.hBM), Integer.valueOf(this.hBN), Integer.valueOf(this.hBG), Integer.valueOf(this.hBH) });
      long l = bt.GC();
      int i = 0;
      int j = 0;
      if (this.hBW != null)
      {
        k = this.hBW.getInteger("width");
        m = this.hBW.getInteger("height");
        if (this.hBK > 0)
        {
          i = k;
          j = m;
          if (this.hBL > 0) {}
        }
        else
        {
          localPoint2 = v(k, m, this.hBI, this.hBJ);
          if (localPoint2 == null) {
            break;
          }
          this.hBK = localPoint2.x;
          this.hBL = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.hBM = this.hBK;
            this.hBN = this.hBL;
          }
          ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.hBK), Integer.valueOf(this.hBL), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.hBS = this.tGj.aDi();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.hBM, this.hBN, this.hBS, i, j);
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      if (i < 0) {
        ad.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.tGi == null)
      {
        MP4MuxerJNI.initH264Encoder(this.hBK, this.hBL, this.hBR.fps, this.hBR.videoBitrate, this.hBR.hbY, 8, this.hBR.hbX, 23.0F, 0, 51);
        this.tGi = new a((byte)0);
        com.tencent.e.h.Iye.aS(this.tGi);
        ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      }
      AppMethodBeat.o(107663);
      return;
      label533:
      this.hBM = this.hBG;
    }
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.hBK = k;
    }
    for (this.hBL = m;; this.hBL = localPoint1.y)
    {
      bool = false;
      break;
      this.hBK = localPoint1.x;
    }
  }
  
  public final void jdMethod_do(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107660);
    ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.hBI = paramInt1;
    this.hBJ = paramInt2;
    AppMethodBeat.o(107660);
  }
  
  public final int m(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(107659);
    ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.hBT });
    this.hBW = paramMediaFormat;
    int i = getDecoderType();
    if (i == 1)
    {
      this.tGj = new i(this.gqX, paramMediaFormat, this.gqY);
      this.tGk = false;
    }
    for (;;)
    {
      if (this.tGj == null)
      {
        ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.tGj = new i(this.gqX, paramMediaFormat, this.gqY);
        this.tGk = false;
      }
      int j = this.tGj.q(this.hBT, this.bxw, this.gnO);
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (hBV != 1)
        {
          i = j;
          if (hBV != 2) {}
        }
        else
        {
          ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.tGj.stop();
        this.tGj = null;
        label193:
        this.tGj = new b();
        this.tGk = true;
        hBV = 3;
        i = this.tGj.q(this.hBT, this.bxw, this.gnO);
        this.tGj.a(this);
        ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(hBV) });
        AppMethodBeat.o(107659);
        return i;
        if (i == 2)
        {
          this.tGj = new j(this.gqX, paramMediaFormat, this.gqY);
          this.tGk = false;
          continue;
        }
        this.tGj = new b();
        this.tGk = true;
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
    ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(hBV) });
    try
    {
      if (this.tGj != null) {
        this.tGj.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBuf(0);
      hBV = -1;
      AppMethodBeat.o(107662);
    }
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    Object gDG;
    int gDr;
    volatile int gqQ;
    boolean hCa;
    
    private a()
    {
      AppMethodBeat.i(107655);
      this.gDG = new Object();
      AppMethodBeat.o(107655);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(107656);
      if (this.gDr == -1)
      {
        this.gDr = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.gDr) });
      }
      this.gqQ = 0;
      for (;;)
      {
        int i;
        synchronized (this.gDG)
        {
          if (this.hCa) {
            break label193;
          }
          l = bt.GC();
          ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.gqQ), false);
          ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.gqQ;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(20L);
          this.gqQ = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(107656);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bt.GC();
      this.gqQ = MP4MuxerJNI.triggerEncodeForSegment(this.gqQ, true);
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */