package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class b$d
  implements Runnable
{
  b$d(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(76180);
    ac.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.wDH);
    i.deleteFile(this.wDH);
    AppMethodBeat.o(76180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.d
 * JD-Core Version:    0.7.0.1
 */