package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  implements e
{
  private int frameCount = 0;
  private boolean hVX = false;
  private int hiI;
  private long hiy;
  private String ivQ;
  private long startTimeMs;
  private byte[] vQW = null;
  private e.a vRl;
  
  public final void H(Runnable paramRunnable)
  {
    AppMethodBeat.i(107605);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.hVX = true;
    this.frameCount = 0;
    for (;;)
    {
      if (!this.hVX)
      {
        AppMethodBeat.o(107605);
        return;
      }
      long l = bt.HI();
      this.vQW = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.vQW);
      ad.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
      boolean bool = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
      if ((this.vQW == null) || (bool))
      {
        ad.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool) });
        this.hVX = false;
        paramRunnable.run();
        AppMethodBeat.o(107605);
        return;
      }
      this.frameCount += 1;
      if (((this.hiI <= 1) || (this.frameCount % this.hiI != 0)) && (this.vRl != null)) {
        this.vRl.bt(this.vQW);
      }
    }
  }
  
  public final void a(e.a parama)
  {
    this.vRl = parama;
  }
  
  public final Point aNh()
  {
    AppMethodBeat.i(107606);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    AppMethodBeat.o(107606);
    return localPoint;
  }
  
  public final int aNi()
  {
    return 2;
  }
  
  public final int n(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107604);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.ivQ = paramString;
    this.startTimeMs = paramLong1;
    this.hiy = paramLong2;
    if (!bt.isNullOrNil(paramString))
    {
      long l = bt.HI();
      int i = MP4MuxerJNI.ffmpegOpenAndSeekFileVFS(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ad.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(107604);
      return i;
    }
    AppMethodBeat.o(107604);
    return -1;
  }
  
  public final void qm(int paramInt)
  {
    AppMethodBeat.i(107608);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hiI = paramInt;
    AppMethodBeat.o(107608);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107607);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[] { Boolean.valueOf(this.hVX) });
    this.hVX = false;
    AppMethodBeat.o(107607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.b
 * JD-Core Version:    0.7.0.1
 */