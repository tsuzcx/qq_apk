package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.a.c;

final class OpenGlRender$3
  implements Runnable
{
  OpenGlRender$3(OpenGlRender paramOpenGlRender) {}
  
  public final void run()
  {
    AppMethodBeat.i(140195);
    if (OpenGlRender.a(this.tHf) != null) {
      OpenGlRender.a(this.tHf).destroy();
    }
    AppMethodBeat.o(140195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender.3
 * JD-Core Version:    0.7.0.1
 */