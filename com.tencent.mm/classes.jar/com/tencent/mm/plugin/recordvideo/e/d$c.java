package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class d$c
  implements Runnable
{
  d$c(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(76179);
    Log.i("MicroMsg.MediaFileUtil", "exec delete filePath:" + this.pqJ);
    u.deleteFile(this.pqJ);
    AppMethodBeat.o(76179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.d.c
 * JD-Core Version:    0.7.0.1
 */