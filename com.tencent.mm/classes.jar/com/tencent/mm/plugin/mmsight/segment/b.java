package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  implements e
{
  private long bvf;
  private int frameCount = 0;
  private int gOI;
  private long gOz;
  private boolean hDs = false;
  private String icu;
  private byte[] uNN = null;
  private e.a uOc;
  
  public final void I(Runnable paramRunnable)
  {
    AppMethodBeat.i(107605);
    ac.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.hDs = true;
    this.frameCount = 0;
    for (;;)
    {
      if (!this.hDs)
      {
        AppMethodBeat.o(107605);
        return;
      }
      long l = bs.Gn();
      this.uNN = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.uNN);
      ac.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      boolean bool = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
      if ((this.uNN == null) || (bool))
      {
        ac.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool) });
        this.hDs = false;
        paramRunnable.run();
        AppMethodBeat.o(107605);
        return;
      }
      this.frameCount += 1;
      if (((this.gOI <= 1) || (this.frameCount % this.gOI != 0)) && (this.uOc != null)) {
        this.uOc.bq(this.uNN);
      }
    }
  }
  
  public final void a(e.a parama)
  {
    this.uOc = parama;
  }
  
  public final Point aJY()
  {
    AppMethodBeat.i(107606);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    AppMethodBeat.o(107606);
    return localPoint;
  }
  
  public final int aJZ()
  {
    return 2;
  }
  
  public final int n(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107604);
    ac.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.icu = paramString;
    this.bvf = paramLong1;
    this.gOz = paramLong2;
    if (!bs.isNullOrNil(paramString))
    {
      long l = bs.Gn();
      int i = MP4MuxerJNI.ffmpegOpenAndSeekFileVFS(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ac.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(107604);
      return i;
    }
    AppMethodBeat.o(107604);
    return -1;
  }
  
  public final void pK(int paramInt)
  {
    AppMethodBeat.i(107608);
    ac.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gOI = paramInt;
    AppMethodBeat.o(107608);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107607);
    ac.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[] { Boolean.valueOf(this.hDs) });
    this.hDs = false;
    AppMethodBeat.o(107607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.b
 * JD-Core Version:    0.7.0.1
 */