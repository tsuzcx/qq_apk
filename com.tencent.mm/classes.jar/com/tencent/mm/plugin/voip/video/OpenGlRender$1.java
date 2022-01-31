package com.tencent.mm.plugin.voip.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.video.b.d;
import com.tencent.mm.sdk.platformtools.ab;

final class OpenGlRender$1
  implements Runnable
{
  OpenGlRender$1(OpenGlRender paramOpenGlRender) {}
  
  public final void run()
  {
    AppMethodBeat.i(5069);
    ??? = d.cPX();
    try
    {
      if (((d)???).mSurfaceTexture != null)
      {
        s locals2 = s.tyN;
        s.cNC();
        GLES20.glDeleteTextures(1, new int[] { ((d)???).textureId }, 0);
        ((d)???).mSurfaceTexture.release();
        ((d)???).mSurfaceTexture = null;
        ab.i("MicroMsg.VoipHardDecodeUtil", "uninit surface texture");
      }
      ab.i(OpenGlRender.access$000(), "releaseSurfaceTexture call finish");
    }
    catch (Exception localException1)
    {
      s locals1;
      synchronized (OpenGlRender.cPJ())
      {
        try
        {
          OpenGlRender.cPJ().notifyAll();
          AppMethodBeat.o(5069);
          return;
          localException1 = localException1;
          ab.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", localException1, "uninitSurfaceTexture error", new Object[0]);
          locals1 = s.tyN;
          s.cND();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.printErrStackTrace(OpenGlRender.access$000(), localException2, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender.1
 * JD-Core Version:    0.7.0.1
 */