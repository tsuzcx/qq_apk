package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  implements e
{
  private long bxw;
  private int frameCount = 0;
  private long gnO;
  private int gnX;
  private String hBT;
  private boolean hcP = false;
  private e.a tFH;
  private byte[] tFs = null;
  
  public final void G(Runnable paramRunnable)
  {
    AppMethodBeat.i(107605);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.hcP = true;
    this.frameCount = 0;
    for (;;)
    {
      if (!this.hcP)
      {
        AppMethodBeat.o(107605);
        return;
      }
      long l = bt.GC();
      this.tFs = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.tFs);
      ad.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      boolean bool = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
      if ((this.tFs == null) || (bool))
      {
        ad.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool) });
        this.hcP = false;
        paramRunnable.run();
        AppMethodBeat.o(107605);
        return;
      }
      this.frameCount += 1;
      if (((this.gnX <= 1) || (this.frameCount % this.gnX != 0)) && (this.tFH != null)) {
        this.tFH.br(this.tFs);
      }
    }
  }
  
  public final void a(e.a parama)
  {
    this.tFH = parama;
  }
  
  public final Point aDh()
  {
    AppMethodBeat.i(107606);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    AppMethodBeat.o(107606);
    return localPoint;
  }
  
  public final int aDi()
  {
    return 2;
  }
  
  public final void oV(int paramInt)
  {
    AppMethodBeat.i(107608);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gnX = paramInt;
    AppMethodBeat.o(107608);
  }
  
  public final int q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107604);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.hBT = paramString;
    this.bxw = paramLong1;
    this.gnO = paramLong2;
    if (!bt.isNullOrNil(paramString))
    {
      long l = bt.GC();
      int i = MP4MuxerJNI.ffmpegOpenAndSeekFileVFS(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ad.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      AppMethodBeat.o(107604);
      return i;
    }
    AppMethodBeat.o(107604);
    return -1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107607);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[] { Boolean.valueOf(this.hcP) });
    this.hcP = false;
    AppMethodBeat.o(107607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.b
 * JD-Core Version:    0.7.0.1
 */