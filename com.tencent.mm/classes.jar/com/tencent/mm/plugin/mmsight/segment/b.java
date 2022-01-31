package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements e
{
  private long aRW;
  private long eIR;
  private int eIV;
  private String eJC;
  private boolean eku = false;
  private int frameCount = 0;
  private byte[] mla = null;
  private e.a mlq;
  
  public final Point SP()
  {
    return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
  }
  
  public final int SQ()
  {
    return 2;
  }
  
  public final void a(e.a parama)
  {
    this.mlq = parama;
  }
  
  public final int i(String paramString, long paramLong1, long paramLong2)
  {
    y.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.eJC = paramString;
    this.aRW = paramLong1;
    this.eIR = paramLong2;
    if (!bk.bl(paramString))
    {
      long l = bk.UZ();
      int i = MP4MuxerJNI.ffmpegOpenAndSeekFile(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      y.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
      return i;
    }
    return -1;
  }
  
  public final void ju(int paramInt)
  {
    y.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.eIV = paramInt;
  }
  
  public final void r(Runnable paramRunnable)
  {
    y.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.eku = true;
    this.frameCount = 0;
    for (;;)
    {
      if (!this.eku) {
        return;
      }
      long l = bk.UZ();
      this.mla = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.mla);
      y.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
      boolean bool = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
      if ((this.mla == null) || (bool))
      {
        y.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool) });
        this.eku = false;
        paramRunnable.run();
        return;
      }
      this.frameCount += 1;
      if (((this.eIV <= 1) || (this.frameCount % this.eIV != 0)) && (this.mlq != null)) {
        this.mlq.aD(this.mla);
      }
    }
  }
  
  public final void stop()
  {
    y.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[] { Boolean.valueOf(this.eku) });
    this.eku = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.b
 * JD-Core Version:    0.7.0.1
 */