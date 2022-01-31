package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public final void run()
  {
    if (this.mlU.eIT != null) {
      y.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
    }
    try
    {
      this.mlU.eIT.stop();
      this.mlU.eIT.release();
      this.mlU.eIT = null;
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.i.1
 * JD-Core Version:    0.7.0.1
 */