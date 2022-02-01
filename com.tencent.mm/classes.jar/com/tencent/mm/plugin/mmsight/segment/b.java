package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  implements e
{
  private int frameCount = 0;
  private boolean hYP = false;
  private long hlm;
  private int hlw;
  private String iyJ;
  private long startTimeMs;
  private byte[] wda = null;
  private e.a wdp;
  
  public final void F(Runnable paramRunnable)
  {
    AppMethodBeat.i(107605);
    ae.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.hYP = true;
    this.frameCount = 0;
    for (;;)
    {
      if (!this.hYP)
      {
        AppMethodBeat.o(107605);
        return;
      }
      long l = bu.HQ();
      this.wda = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.wda);
      ae.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      boolean bool = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
      if ((this.wda == null) || (bool))
      {
        ae.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool) });
        this.hYP = false;
        paramRunnable.run();
        AppMethodBeat.o(107605);
        return;
      }
      this.frameCount += 1;
      if (((this.hlw <= 1) || (this.frameCount % this.hlw != 0)) && (this.wdp != null)) {
        this.wdp.bs(this.wda);
      }
    }
  }
  
  public final void a(e.a parama)
  {
    this.wdp = parama;
  }
  
  public final Point aNF()
  {
    AppMethodBeat.i(107606);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    AppMethodBeat.o(107606);
    return localPoint;
  }
  
  public final int aNG()
  {
    return 2;
  }
  
  public final int n(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107604);
    ae.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.iyJ = paramString;
    this.startTimeMs = paramLong1;
    this.hlm = paramLong2;
    if (!bu.isNullOrNil(paramString))
    {
      long l = bu.HQ();
      int i = MP4MuxerJNI.ffmpegOpenAndSeekFileVFS(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ae.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(107604);
      return i;
    }
    AppMethodBeat.o(107604);
    return -1;
  }
  
  public final void qp(int paramInt)
  {
    AppMethodBeat.i(107608);
    ae.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hlw = paramInt;
    AppMethodBeat.o(107608);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107607);
    ae.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[] { Boolean.valueOf(this.hYP) });
    this.hYP = false;
    AppMethodBeat.o(107607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.b
 * JD-Core Version:    0.7.0.1
 */