package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(3653);
    h localh = this.oLa;
    ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", new Object[] { localh.oKX, localh.eUH });
    if ((localh.oKX != null) && (localh.eUH != null))
    {
      localh.oKX.fZn = true;
      try
      {
        localh.eUH.join();
        d.ysm.remove(localh.oKX);
        AppMethodBeat.o(3653);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", localException, "waitEncoderFinish, join error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(3653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h.1
 * JD-Core Version:    0.7.0.1
 */