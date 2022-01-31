package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import com.tencent.mm.sdk.platformtools.y;

final class g$2
  implements Runnable
{
  g$2(g paramg) {}
  
  public final void run()
  {
    try
    {
      if (this.mlP.mlG != null)
      {
        y.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
        this.mlP.mlG.stop();
        this.mlP.mlG.release();
        this.mlP.mlG = null;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.g.2
 * JD-Core Version:    0.7.0.1
 */