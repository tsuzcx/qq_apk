package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  implements e
{
  private byte[] KYe = null;
  private e.a KZa;
  private long endTimeMs;
  private int frameCount = 0;
  private int nyO;
  private boolean oCI = false;
  private String pcY;
  private long startTimeMs;
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(107605);
    Log.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.oCI = true;
    this.frameCount = 0;
    for (;;)
    {
      if (!this.oCI)
      {
        AppMethodBeat.o(107605);
        return;
      }
      long l = Util.currentTicks();
      this.KYe = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.KYe);
      Log.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      boolean bool = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
      if ((this.KYe == null) || (bool))
      {
        Log.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool) });
        this.oCI = false;
        paramRunnable.run();
        AppMethodBeat.o(107605);
        return;
      }
      this.frameCount += 1;
      if (((this.nyO <= 1) || (this.frameCount % this.nyO != 0)) && (this.KZa != null)) {
        this.KZa.cb(this.KYe);
      }
    }
  }
  
  public final void a(e.a parama)
  {
    this.KZa = parama;
  }
  
  public final Point bOM()
  {
    AppMethodBeat.i(107606);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    AppMethodBeat.o(107606);
    return localPoint;
  }
  
  public final int bON()
  {
    return 2;
  }
  
  public final int o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(107604);
    Log.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.pcY = paramString;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    if (!Util.isNullOrNil(paramString))
    {
      long l = Util.currentTicks();
      int i = MP4MuxerJNI.ffmpegOpenAndSeekFileVFS(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      Log.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(107604);
      return i;
    }
    AppMethodBeat.o(107604);
    return -1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107607);
    Log.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[] { Boolean.valueOf(this.oCI) });
    this.oCI = false;
    AppMethodBeat.o(107607);
  }
  
  public final void xe(int paramInt)
  {
    AppMethodBeat.i(107608);
    Log.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nyO = paramInt;
    AppMethodBeat.o(107608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.b
 * JD-Core Version:    0.7.0.1
 */