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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;

public final class h
  implements e.a
{
  private static int icw = -1;
  long bvf;
  int duc;
  int gOI;
  long gOz;
  c gRF;
  int gRG;
  private int ich;
  private int ici;
  private int icj;
  private int ick;
  private int icl;
  private int icm;
  private int icn;
  private int ico;
  VideoTransPara ics;
  private int ict;
  String icu;
  private MediaFormat icx;
  private Object lock;
  a uOD;
  e uOE;
  private boolean uOF;
  
  public h()
  {
    AppMethodBeat.i(107657);
    this.bvf = -1L;
    this.gOz = -1L;
    this.ict = 0;
    this.uOF = false;
    this.lock = new byte[0];
    this.gOI = -1;
    AppMethodBeat.o(107657);
  }
  
  public static int getDecoderType()
  {
    AppMethodBeat.i(107658);
    int i = CaptureMMProxy.getInstance().getInt(ah.a.GKo, -1);
    if (i != -1)
    {
      if (i == 1) {
        if (d.kZ(21)) {
          icw = 2;
        }
      }
      for (;;)
      {
        i = icw;
        AppMethodBeat.o(107658);
        return i;
        icw = 1;
        continue;
        if (i == 2) {
          icw = 1;
        } else {
          icw = 3;
        }
      }
    }
    if (icw != -1)
    {
      i = icw;
      AppMethodBeat.o(107658);
      return i;
    }
    i = ae.fJk.fHN;
    if (i != -1) {
      if (i == 1) {
        icw = 1;
      }
    }
    for (;;)
    {
      i = icw;
      AppMethodBeat.o(107658);
      return i;
      if (i == 2)
      {
        if (d.kZ(21)) {
          icw = 2;
        } else {
          icw = 1;
        }
      }
      else if (i == 3)
      {
        do
        {
          icw = 3;
          break;
        } while (!d.kZ(bs.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21)));
        icw = 1;
      }
    }
  }
  
  private static Point v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107661);
    ac.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(107661);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(107661);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
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
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
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
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
  
  public final void bq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(107663);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(107663);
      return;
    }
    Point localPoint1 = this.uOE.aJY();
    this.ich = localPoint1.x;
    this.ici = localPoint1.y;
    Point localPoint2;
    if ((this.ico <= 0) || (this.icn <= 0))
    {
      localPoint2 = v(this.ich, this.ici, this.icj, this.ick);
      if (localPoint2 == null) {
        break label533;
      }
      this.icn = localPoint2.x;
    }
    int k;
    int m;
    boolean bool;
    for (this.ico = localPoint2.y;; this.ico = this.ici)
    {
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.icn), Integer.valueOf(this.ico), Integer.valueOf(this.ich), Integer.valueOf(this.ici) });
      long l = bs.Gn();
      int i = 0;
      int j = 0;
      if (this.icx != null)
      {
        k = this.icx.getInteger("width");
        m = this.icx.getInteger("height");
        if (this.icl > 0)
        {
          i = k;
          j = m;
          if (this.icm > 0) {}
        }
        else
        {
          localPoint2 = v(k, m, this.icj, this.ick);
          if (localPoint2 == null) {
            break;
          }
          this.icl = localPoint2.x;
          this.icm = localPoint2.y;
          bool = true;
          if (bool)
          {
            this.icn = this.icl;
            this.ico = this.icm;
          }
          ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.icl), Integer.valueOf(this.icm), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          j = m;
          i = k;
        }
      }
      this.ict = this.uOE.aJZ();
      i = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, localPoint1.x, localPoint1.y, this.icn, this.ico, this.ict, i, j);
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      if (i < 0) {
        ac.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(i) });
      }
      if (this.uOD == null)
      {
        MP4MuxerJNI.initH264Encoder(this.icl, this.icm, this.ics.fps, this.ics.videoBitrate, this.ics.hCA, 8, this.ics.hCz, 23.0F, 0, 51);
        this.uOD = new a((byte)0);
        com.tencent.e.h.JZN.aV(this.uOD);
        ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
      }
      AppMethodBeat.o(107663);
      return;
      label533:
      this.icn = this.ich;
    }
    if ((Math.abs(m - localPoint1.y) > 0) && (k == localPoint1.x)) {
      this.icl = k;
    }
    for (this.icm = m;; this.icm = localPoint1.y)
    {
      bool = false;
      break;
      this.icl = localPoint1.x;
    }
  }
  
  public final void jdMethod_do(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107660);
    ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.icj = paramInt1;
    this.ick = paramInt2;
    AppMethodBeat.o(107660);
  }
  
  public final int h(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(107659);
    ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[] { paramMediaFormat, this.icu });
    this.icx = paramMediaFormat;
    int i = getDecoderType();
    if (i == 1)
    {
      this.uOE = new i(this.gRF, paramMediaFormat, this.gRG);
      this.uOF = false;
    }
    for (;;)
    {
      if (this.uOE == null)
      {
        ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
        this.uOE = new i(this.gRF, paramMediaFormat, this.gRG);
        this.uOF = false;
      }
      int j = this.uOE.n(this.icu, this.bvf, this.gOz);
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j < 0) {
        if (icw != 1)
        {
          i = j;
          if (icw != 2) {}
        }
        else
        {
          ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
        }
      }
      try
      {
        this.uOE.stop();
        this.uOE = null;
        label193:
        this.uOE = new b();
        this.uOF = true;
        icw = 3;
        i = this.uOE.n(this.icu, this.bvf, this.gOz);
        this.uOE.a(this);
        ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(icw) });
        AppMethodBeat.o(107659);
        return i;
        if (i == 2)
        {
          this.uOE = new j(this.gRF, paramMediaFormat, this.gRG);
          this.uOF = false;
          continue;
        }
        this.uOE = new b();
        this.uOF = true;
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
    ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(icw) });
    try
    {
      if (this.uOE != null) {
        this.uOE.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBuf(0);
      icw = -1;
      AppMethodBeat.o(107662);
    }
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    volatile int gRy;
    int hdS;
    Object heh;
    boolean icB;
    
    private a()
    {
      AppMethodBeat.i(107655);
      this.heh = new Object();
      AppMethodBeat.o(107655);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(107656);
      if (this.hdS == -1)
      {
        this.hdS = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hdS) });
      }
      this.gRy = 0;
      for (;;)
      {
        int i;
        synchronized (this.heh)
        {
          if (this.icB) {
            break label193;
          }
          l = bs.Gn();
          ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.gRy), false);
          ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.gRy;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(20L);
          this.gRy = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(107656);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bs.Gn();
      this.gRy = MP4MuxerJNI.triggerEncodeForSegment(this.gRy, true);
      ac.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h
 * JD-Core Version:    0.7.0.1
 */