package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$2
  implements Runnable
{
  g$2(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(3643);
    try
    {
      if (this.oKW.oKO != null)
      {
        ab.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
        this.oKW.oKO.stop();
        this.oKW.oKO.release();
        this.oKW.oKO = null;
      }
      AppMethodBeat.o(3643);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(3643);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g.2
 * JD-Core Version:    0.7.0.1
 */