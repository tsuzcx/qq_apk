package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class b$d
  implements Runnable
{
  b$d(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(76180);
    ae.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.yhh);
    o.deleteFile(this.yhh);
    AppMethodBeat.o(76180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.d
 * JD-Core Version:    0.7.0.1
 */