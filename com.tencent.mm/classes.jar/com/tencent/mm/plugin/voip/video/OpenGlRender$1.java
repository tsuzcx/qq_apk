package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class OpenGlRender$1
  implements Runnable
{
  public OpenGlRender$1(OpenGlRender paramOpenGlRender) {}
  
  public final void run()
  {
    AppMethodBeat.i(115641);
    ??? = e.idb();
    try
    {
      if (((e)???).UQM != null)
      {
        t localt2 = t.UBA;
        t.hXU();
        if (((e)???).UFV != null) {
          ((e)???).UFV.close();
        }
        ((e)???).UQM.release();
        ((e)???).UQM = null;
        Log.i("MicroMsg.VoipHardDecodeUtil", "uninit surface texture");
      }
    }
    catch (Exception localException1)
    {
      t localt1;
      synchronized (OpenGlRender.icm())
      {
        try
        {
          OpenGlRender.icm().notifyAll();
          AppMethodBeat.o(115641);
          return;
          localException1 = localException1;
          Log.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", localException1, "uninitSurfaceTexture error", new Object[0]);
          localt1 = t.UBA;
          t.hXV();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printErrStackTrace(OpenGlRender.access$000(), localException2, "", new Object[0]);
          }
        }
      }
    }
    Log.i(OpenGlRender.access$000(), "releaseSurfaceTexture call finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender.1
 * JD-Core Version:    0.7.0.1
 */