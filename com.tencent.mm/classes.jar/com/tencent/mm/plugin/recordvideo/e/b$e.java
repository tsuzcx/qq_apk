package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class b$e
  implements Runnable
{
  b$e(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(76181);
    ae.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.yhh);
    o.deleteFile(this.yhh);
    AppMethodBeat.o(76181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.e
 * JD-Core Version:    0.7.0.1
 */