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
import com.tencent.mm.storage.al.a;

public final class h
  implements e.a
{
  private static int ivS = -1;
  int dGc;
  int hiI;
  long hiy;
  c hjX;
  int hjY;
  private int ivD;
  private int ivE;
  private int ivF;
  private int ivG;
  private int ivH;
  private int ivI;
  private int ivJ;
  private int ivK;
  VideoTransPara ivO;
  private int ivP;
  String ivQ;
  private MediaFormat ivT;
  private Object lock;
  long startTimeMs;
  a vRM;
  e vRN;
  private boolean vRO;
  
  public h()
  {
    AppMethodBeat.i(107657);
    this.startTimeMs = -1L;
    this.hiy = -1L;
    this.ivP = 0;
    this.vRO = false;
    this.lock = new byte[0];
    this.hiI = -1;
    AppMethodBeat.o(107657);
  }
  
  public static int getDecoderType()
  {
    AppMethodBeat.i(107658);
    int i = CaptureMMProxy.getInstance().getInt(al.a.IwG, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (d.ly(21)) {
          ivS = 2;
        }
      }
      for (;;)
      {
        i = ivS;
        AppMethodBeat.o(107658);
        return i;
        ivS = 1;
        continue;
        if (i == 2) {
          ivS = 1;
        } else {
          ivS = 3;
        }
      }
    }
    if (ivS != -1)
    {
      i = ivS;
      AppMethodBeat.o(107658);
      return i;
    }
    i = ae.gcL.gbn;
    if (i != -1) {
      if (i == 1) {
        ivS = 1;
      }
    }
    for (;;)
    {
      i = ivS;
      AppMethodBeat.o(107658);
      return i;
      if (i == 2)
      {
        if (d.ly(21)) {
          ivS = 2;
        } else {
          ivS = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          ivS = 3;
          break;
        } while (!d.ly(bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        ivS = 1;
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
  
  public final void bt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(107663);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(107663);
      return;
    }
    Point localPoint1 = this.vRN.aNh();
    this.ivD = localPoint1.x;
    this.ivE = localPoint1.y;
    Point localPoint2;
    if ((this.ivK <= 0) || (this.ivJ <= 0))
    {
      localPoint2 = v(this.ivD, this.ivE, this.ivF, this.ivG);
      if (localPoint2 == null) {
        break label533;
      }
      this.ivJ = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.ivK = localPoint2.y;; this.ivK = this.ivE)
    {
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.ivJ), Integer.valueOf(this.ivK), Integer.valueOf(this.ivD), Integer.valueOf(this.ivE) });
      long l = bt.HI();
      int i = 0;
      int j = 0;
      if (this.ivT != null)
      {
        k = this.ivT.getInteger("width");
        m = this.ivT.getInteger("height");
        if (this.ivH > 0)
        {
          i = k;
          j = m;
          if (this.ivI > 0) {}
        }
        else
        {
          localPoint2 = v(k, m, this.ivF, this.ivG);
          if (localPoint2 == null) {
            break;
          }
          this.ivH = localPoint2.x;
          this.ivI = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.ivJ = this.ivH;
            this.ivK = this.ivI;
          }
          ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.ivH), Integer.valueOf(this.ivI), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.ivP = this.vRN.aNi();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.ivJ, this.ivK, this.ivP, i, j);
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
      if (i < 0) {
        ad.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.vRM == null)
      {
        MP4MuxerJNI.initH264Encoder(this.ivH, this.ivI, this.ivO.fps, this.ivO.videoBitrate, this.ivO.hVf, 8, this.ivO.hVe, 23.0F, 0, 51);
        this.vRM = new a((byte)0);
        com.tencent.e.h.LTJ.aU(this.vRM);
        ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      }
      AppMethodBeat.o(107663);
      return;
      label533:
      this.ivJ = this.ivD;
    }
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.ivH = k;
    }
    for (this.ivI = m;; this.ivI = localPoint1.y)
    {
      bool = false;
      break;
      this.ivH = localPoint1.x;
    }
  }
  
  public final void dq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107660);
    ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.ivF = paramInt1;
    this.ivG = paramInt2;
    AppMethodBeat.o(107660);
  }
  
  public final int h(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(107659);
    ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.ivQ });
    this.ivT = paramMediaFormat;
    int i = getDecoderType();
    if (i == 1)
    {
      this.vRN = new i(this.hjX, paramMediaFormat, this.hjY);
      this.vRO = false;
    }
    for (;;)
    {
      if (this.vRN == null)
      {
        ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.vRN = new i(this.hjX, paramMediaFormat, this.hjY);
        this.vRO = false;
      }
      int j = this.vRN.n(this.ivQ, this.startTimeMs, this.hiy);
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (ivS != 1)
        {
          i = j;
          if (ivS != 2) {}
        }
        else
        {
          ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.vRN.stop();
        this.vRN = null;
        label193:
        this.vRN = new b();
        this.vRO = true;
        ivS = 3;
        i = this.vRN.n(this.ivQ, this.startTimeMs, this.hiy);
        this.vRN.a(this);
        ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(ivS) });
        AppMethodBeat.o(107659);
        return i;
        if (i == 2)
        {
          this.vRN = new j(this.hjX, paramMediaFormat, this.hjY);
          this.vRO = false;
          continue;
        }
        this.vRN = new b();
        this.vRO = true;
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
    ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(ivS) });
    try
    {
      if (this.vRN != null) {
        this.vRN.stop();
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
      ivS = -1;
      AppMethodBeat.o(107662);
    }
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    volatile int hjQ;
    int hwa;
    Object hwp;
    boolean ivX;
    
    private a()
    {
      AppMethodBeat.i(107655);
      this.hwp = new Object();
      AppMethodBeat.o(107655);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(107656);
      if (this.hwa == -1)
      {
        this.hwa = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hwa) });
      }
      this.hjQ = 0;
      for (;;)
      {
        int i;
        synchronized (this.hwp)
        {
          if (this.ivX) {
            break label193;
          }
          l = bt.HI();
          ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.hjQ), false);
          ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.hjQ;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(20L);
          this.hjQ = i;
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
      long l = bt.HI();
      this.hjQ = MP4MuxerJNI.triggerEncodeForSegment(this.hjQ, true);
      ad.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */