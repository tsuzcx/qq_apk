package com.tencent.mm.plugin.story.image2video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(150930);
    c localc = this.ssT;
    ab.i("MicroMsg.Story.GLThread", "draw");
    if (localc.ssR != null) {
      localc.ssR.onDrawFrame();
    }
    localc.swapBuffers();
    AppMethodBeat.o(150930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.c.2
 * JD-Core Version:    0.7.0.1
 */