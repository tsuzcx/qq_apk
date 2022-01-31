package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.b.f;
import com.tencent.mm.sdk.platformtools.ab;

final class OpenGlRender$4
  implements Runnable
{
  OpenGlRender$4(OpenGlRender paramOpenGlRender) {}
  
  public final void run()
  {
    AppMethodBeat.i(140196);
    if (OpenGlRender.c(this.tHf))
    {
      OpenGlRender.b(this.tHf).cQa();
      OpenGlRender.d(this.tHf);
      OpenGlRender.e(this.tHf);
      OpenGlRender.f(this.tHf);
      ab.i(OpenGlRender.access$000(), "detach finish");
    }
    synchronized (OpenGlRender.access$700())
    {
      try
      {
        OpenGlRender.access$700().notifyAll();
        AppMethodBeat.o(140196);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace(OpenGlRender.access$000(), localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender.4
 * JD-Core Version:    0.7.0.1
 */