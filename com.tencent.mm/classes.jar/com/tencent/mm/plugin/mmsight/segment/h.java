package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;

public final class h
  implements e.a
{
  private static int eJF = -1;
  long aRW = -1L;
  long eIR = -1L;
  int eIU;
  int eIV = -1;
  VideoTransPara eJA;
  private int eJB = 0;
  String eJC;
  MediaExtractor eJD;
  private MediaFormat eJG;
  private int eJm;
  private int eJn;
  private int eJo;
  private int eJp;
  private int eJq;
  private int eJr;
  private int eJs;
  private int eJt;
  private Object lock = new byte[0];
  h.a mlQ;
  e mlR;
  private boolean mlS = false;
  Thread mlg;
  int rotate;
  
  public static int bjU()
  {
    int i = CaptureMMProxy.getInstance().getInt(ac.a.utW, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (d.gF(21)) {
          eJF = 2;
        }
      }
      for (;;)
      {
        return eJF;
        eJF = 1;
        continue;
        if (i == 2) {
          eJF = 1;
        } else {
          eJF = 3;
        }
      }
    }
    if (eJF != -1) {
      return eJF;
    }
    i = q.dyk.dyw;
    if (i != -1) {
      if (i == 1) {
        eJF = 1;
      }
    }
    for (;;)
    {
      return eJF;
      if (i == 2)
      {
        if (d.gF(21)) {
          eJF = 2;
        } else {
          eJF = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          eJF = 3;
          break;
        } while (!d.gF(bk.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        eJF = 1;
      }
    }
  }
  
  private static Point n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
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
      return new Point(paramInt1, paramInt2);
    }
    m /= 2;
    k /= 2;
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
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
      return new Point(paramInt1, paramInt2);
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
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      return localPoint;
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt2 * 1.0D / paramInt3;
      paramInt1 = (int)(paramInt1 / d);
      paramInt2 = paramInt3;
    }
  }
  
  public final void aD(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      return;
    }
    Point localPoint1 = this.mlR.SP();
    this.eJm = localPoint1.x;
    this.eJn = localPoint1.y;
    Point localPoint2;
    if ((this.eJt <= 0) || (this.eJs <= 0))
    {
      localPoint2 = n(this.eJm, this.eJn, this.eJo, this.eJp);
      if (localPoint2 == null) {
        break label522;
      }
      this.eJs = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.eJt = localPoint2.y;; this.eJt = this.eJn)
    {
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.eJs), Integer.valueOf(this.eJt), Integer.valueOf(this.eJm), Integer.valueOf(this.eJn) });
      long l = bk.UZ();
      int i = 0;
      int j = 0;
      if (this.eJG != null)
      {
        k = this.eJG.getInteger("width");
        m = this.eJG.getInteger("height");
        if (this.eJq > 0)
        {
          i = k;
          j = m;
          if (this.eJr > 0) {}
        }
        else
        {
          localPoint2 = n(k, m, this.eJo, this.eJp);
          if (localPoint2 == null) {
            break label541;
          }
          this.eJq = localPoint2.x;
          this.eJr = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.eJs = this.eJq;
            this.eJt = this.eJr;
          }
          y.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.eJq), Integer.valueOf(this.eJr), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.eJB = this.mlR.SQ();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.eJs, this.eJt, this.eJB, i, j);
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
      if (i < 0) {
        y.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.mlQ != null) {
        break;
      }
      MP4MuxerJNI.initH264Encoder(this.eJq, this.eJr, this.eJA.fps, this.eJA.videoBitrate, this.eJA.ejP, 8, this.eJA.ejO, 23.0F);
      this.mlQ = new h.a(this, (byte)0);
      this.mlg = com.tencent.mm.sdk.f.e.b(this.mlQ, "MediaCodecFFMpegTranscoder_Encoder");
      this.mlg.start();
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      return;
      label522:
      this.eJs = this.eJm;
    }
    label541:
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.eJq = k;
    }
    for (this.eJr = m;; this.eJr = localPoint1.y)
    {
      bool = false;
      break;
      this.eJq = localPoint1.x;
    }
  }
  
  public final void by(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.eJo = paramInt1;
    this.eJp = paramInt2;
  }
  
  public final int e(MediaFormat paramMediaFormat)
  {
    y.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.eJC });
    this.eJG = paramMediaFormat;
    int i = bjU();
    if (i == 1)
    {
      this.mlR = new i(this.eJD, paramMediaFormat, this.eIU);
      this.mlS = false;
    }
    for (;;)
    {
      if (this.mlR == null)
      {
        y.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.mlR = new i(this.eJD, paramMediaFormat, this.eIU);
        this.mlS = false;
      }
      int j = this.mlR.i(this.eJC, this.aRW, this.eIR);
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (eJF != 1)
        {
          i = j;
          if (eJF != 2) {}
        }
        else
        {
          y.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.mlR.stop();
        this.mlR = null;
        label187:
        this.mlR = new b();
        this.mlS = true;
        eJF = 3;
        i = this.mlR.i(this.eJC, this.aRW, this.eIR);
        this.mlR.a(this);
        y.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(eJF) });
        return i;
        if (i == 2)
        {
          this.mlR = new j(this.eJD, paramMediaFormat, this.eIU);
          this.mlS = false;
          continue;
        }
        this.mlR = new b();
        this.mlS = true;
      }
      catch (Exception paramMediaFormat)
      {
        break label187;
      }
    }
  }
  
  public final void release()
  {
    y.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(eJF) });
    try
    {
      if (this.mlR != null) {
        this.mlR.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBuf(0);
      eJF = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */