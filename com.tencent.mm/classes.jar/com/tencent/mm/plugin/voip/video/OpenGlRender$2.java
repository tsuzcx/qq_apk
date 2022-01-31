package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.b.b;
import com.tencent.mm.plugin.voip.video.b.f;
import com.tencent.mm.sdk.platformtools.ab;

final class OpenGlRender$2
  implements Runnable
{
  OpenGlRender$2(OpenGlRender paramOpenGlRender) {}
  
  public final void run()
  {
    AppMethodBeat.i(140194);
    if (OpenGlRender.a(this.tHf) != null) {
      OpenGlRender.a(this.tHf).destroy();
    }
    if (OpenGlRender.b(this.tHf) != null)
    {
      f localf = OpenGlRender.b(this.tHf);
      ab.i("MicroMsg.VoipRenderer", "%s do destroy", new Object[] { Integer.valueOf(localf.hashCode()) });
      if (localf.tIK != null) {
        localf.tIK.cPT();
      }
      if (localf.tIL != null) {
        localf.tIL.cPT();
      }
      localf.tIK = null;
      localf.tIL = null;
    }
    AppMethodBeat.o(140194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender.2
 * JD-Core Version:    0.7.0.1
 */