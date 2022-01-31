package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public final void run()
  {
    try
    {
      if (this.mlP.mlF != null)
      {
        y.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
        this.mlP.mlF.stop();
        this.mlP.mlF.release();
        this.mlP.mlF = null;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g.1
 * JD-Core Version:    0.7.0.1
 */