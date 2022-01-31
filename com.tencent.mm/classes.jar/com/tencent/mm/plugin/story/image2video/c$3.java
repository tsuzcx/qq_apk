package com.tencent.mm.plugin.story.image2video;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(150931);
    c localc = this.ssT;
    ab.i("MicroMsg.Story.GLThread", "destoryGL");
    b.a locala = b.eZw;
    b.a.a(localc.ssS);
    localc.rYn.quit();
    localc.ssR.czY();
    AppMethodBeat.o(150931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.c.3
 * JD-Core Version:    0.7.0.1
 */