package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class b$d
  implements Runnable
{
  b$d(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(76181);
    ad.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.vtG);
    i.deleteFile(this.vtG);
    AppMethodBeat.o(76181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.d
 * JD-Core Version:    0.7.0.1
 */