package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(3642);
    try
    {
      if (this.oKW.oKN != null)
      {
        ab.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
        this.oKW.oKN.stop();
        this.oKW.oKN.release();
        this.oKW.oKN = null;
      }
      AppMethodBeat.o(3642);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(3642);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g.1
 * JD-Core Version:    0.7.0.1
 */