package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

public final class h
  implements e.a
{
  private static int fZi = -1;
  long aZw;
  long eRN;
  int eRW;
  Thread eUH;
  int eUR;
  private int fYR;
  private int fYS;
  private int fYT;
  private int fYU;
  private int fYV;
  private int fYW;
  private int fYX;
  private int fYY;
  VideoTransPara fZe;
  private int fZf;
  String fZg;
  private MediaFormat fZj;
  private Object lock;
  MediaExtractor mediaExtractor;
  h.a oKX;
  e oKY;
  private boolean oKZ;
  int rotate;
  
  public h()
  {
    AppMethodBeat.i(3656);
    this.aZw = -1L;
    this.eRN = -1L;
    this.fZf = 0;
    this.oKZ = false;
    this.lock = new byte[0];
    this.eRW = -1;
    AppMethodBeat.o(3656);
  }
  
  public static int bRH()
  {
    AppMethodBeat.i(3657);
    int i = CaptureMMProxy.getInstance().getInt(ac.a.yDZ, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (com.tencent.mm.compatible.util.d.fv(21)) {
          fZi = 2;
        }
      }
      for (;;)
      {
        i = fZi;
        AppMethodBeat.o(3657);
        return i;
        fZi = 1;
        continue;
        if (i == 2) {
          fZi = 1;
        } else {
          fZi = 3;
        }
      }
    }
    if (fZi != -1)
    {
      i = fZi;
      AppMethodBeat.o(3657);
      return i;
    }
    i = ac.erB.eqO;
    if (i != -1) {
      if (i == 1) {
        fZi = 1;
      }
    }
    for (;;)
    {
      i = fZi;
      AppMethodBeat.o(3657);
      return i;
      if (i == 2)
      {
        if (com.tencent.mm.compatible.util.d.fv(21)) {
          fZi = 2;
        } else {
          fZi = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          fZi = 3;
          break;
        } while (!com.tencent.mm.compatible.util.d.fv(bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        fZi = 1;
      }
    }
  }
  
  private static Point v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(3660);
    ab.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(3660);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(3660);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
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
      AppMethodBeat.o(3660);
      return localPoint;
    }
    m /= 2;
    k /= 2;
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
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
      AppMethodBeat.o(3660);
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
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      AppMethodBeat.o(3660);
      return localPoint;
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt2 * 1.0D / paramInt3;
      paramInt1 = (int)(paramInt1 / d);
      paramInt2 = paramInt3;
    }
  }
  
  public final void bb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(3662);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(3662);
      return;
    }
    Point localPoint1 = this.oKY.amc();
    this.fYR = localPoint1.x;
    this.fYS = localPoint1.y;
    Point localPoint2;
    if ((this.fYY <= 0) || (this.fYX <= 0))
    {
      localPoint2 = v(this.fYR, this.fYS, this.fYT, this.fYU);
      if (localPoint2 == null) {
        break label543;
      }
      this.fYX = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.fYY = localPoint2.y;; this.fYY = this.fYS)
    {
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.fYX), Integer.valueOf(this.fYY), Integer.valueOf(this.fYR), Integer.valueOf(this.fYS) });
      long l = bo.yB();
      int i = 0;
      int j = 0;
      if (this.fZj != null)
      {
        k = this.fZj.getInteger("width");
        m = this.fZj.getInteger("height");
        if (this.fYV > 0)
        {
          i = k;
          j = m;
          if (this.fYW > 0) {}
        }
        else
        {
          localPoint2 = v(k, m, this.fYT, this.fYU);
          if (localPoint2 == null) {
            break;
          }
          this.fYV = localPoint2.x;
          this.fYW = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.fYX = this.fYV;
            this.fYY = this.fYW;
          }
          ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.fYV), Integer.valueOf(this.fYW), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.fZf = this.oKY.amd();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.fYX, this.fYY, this.fZf, i, j);
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      if (i < 0) {
        ab.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.oKX == null)
      {
        MP4MuxerJNI.initH264Encoder(this.fYV, this.fYW, this.fZe.fps, this.fZe.videoBitrate, this.fZe.fzW, 8, this.fZe.fzV, 23.0F, 0, 51);
        this.oKX = new h.a(this, (byte)0);
        this.eUH = com.tencent.mm.sdk.g.d.h(this.oKX, "MediaCodecFFMpegTranscoder_Encoder");
        this.eUH.start();
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      }
      AppMethodBeat.o(3662);
      return;
      label543:
      this.fYX = this.fYR;
    }
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.fYV = k;
    }
    for (this.fYW = m;; this.fYW = localPoint1.y)
    {
      bool = false;
      break;
      this.fYV = localPoint1.x;
    }
  }
  
  public final void cI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3659);
    ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.fYT = paramInt1;
    this.fYU = paramInt2;
    AppMethodBeat.o(3659);
  }
  
  public final int g(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(3658);
    ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.fZg });
    this.fZj = paramMediaFormat;
    int i = bRH();
    if (i == 1)
    {
      this.oKY = new i(this.mediaExtractor, paramMediaFormat, this.eUR);
      this.oKZ = false;
    }
    for (;;)
    {
      if (this.oKY == null)
      {
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.oKY = new i(this.mediaExtractor, paramMediaFormat, this.eUR);
        this.oKZ = false;
      }
      int j = this.oKY.p(this.fZg, this.aZw, this.eRN);
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (fZi != 1)
        {
          i = j;
          if (fZi != 2) {}
        }
        else
        {
          ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.oKY.stop();
        this.oKY = null;
        label193:
        this.oKY = new b();
        this.oKZ = true;
        fZi = 3;
        i = this.oKY.p(this.fZg, this.aZw, this.eRN);
        this.oKY.a(this);
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(fZi) });
        AppMethodBeat.o(3658);
        return i;
        if (i == 2)
        {
          this.oKY = new j(this.mediaExtractor, paramMediaFormat, this.eUR);
          this.oKZ = false;
          continue;
        }
        this.oKY = new b();
        this.oKZ = true;
      }
      catch (Exception paramMediaFormat)
      {
        break label193;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(3661);
    ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(fZi) });
    try
    {
      if (this.oKY != null) {
        this.oKY.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBuf(0);
      fZi = -1;
      AppMethodBeat.o(3661);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */