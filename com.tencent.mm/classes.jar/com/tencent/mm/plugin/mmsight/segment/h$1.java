package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    h localh = this.mlT;
    y.i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", new Object[] { localh.mlQ, localh.mlg });
    if ((localh.mlQ != null) && (localh.mlg != null)) {
      localh.mlQ.eJM = true;
    }
    try
    {
      localh.mlg.join();
      e.remove(localh.mlQ);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", localException, "waitEncoderFinish, join error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h.1
 * JD-Core Version:    0.7.0.1
 */