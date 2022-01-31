package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  implements e
{
  private long aZw;
  private long eRN;
  private int eRW;
  private boolean fAK = false;
  private String fZg;
  private int frameCount = 0;
  private byte[] oKh = null;
  private e.a oKw;
  
  public final void a(e.a parama)
  {
    this.oKw = parama;
  }
  
  public final Point amc()
  {
    AppMethodBeat.i(3606);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    AppMethodBeat.o(3606);
    return localPoint;
  }
  
  public final int amd()
  {
    return 2;
  }
  
  public final void mm(int paramInt)
  {
    AppMethodBeat.i(3608);
    ab.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.eRW = paramInt;
    AppMethodBeat.o(3608);
  }
  
  public final int p(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(3604);
    ab.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.fZg = paramString;
    this.aZw = paramLong1;
    this.eRN = paramLong2;
    if (!bo.isNullOrNil(paramString))
    {
      long l = bo.yB();
      int i = MP4MuxerJNI.ffmpegOpenAndSeekFile(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ab.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(3604);
      return i;
    }
    AppMethodBeat.o(3604);
    return -1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(3607);
    ab.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[] { Boolean.valueOf(this.fAK) });
    this.fAK = false;
    AppMethodBeat.o(3607);
  }
  
  public final void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(3605);
    ab.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.fAK = true;
    this.frameCount = 0;
    for (;;)
    {
      if (!this.fAK)
      {
        AppMethodBeat.o(3605);
        return;
      }
      long l = bo.yB();
      this.oKh = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.oKh);
      ab.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      boolean bool = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
      if ((this.oKh == null) || (bool))
      {
        ab.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool) });
        this.fAK = false;
        paramRunnable.run();
        AppMethodBeat.o(3605);
        return;
      }
      this.frameCount += 1;
      if (((this.eRW <= 1) || (this.frameCount % this.eRW != 0)) && (this.oKw != null)) {
        this.oKw.bb(this.oKh);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.b
 * JD-Core Version:    0.7.0.1
 */