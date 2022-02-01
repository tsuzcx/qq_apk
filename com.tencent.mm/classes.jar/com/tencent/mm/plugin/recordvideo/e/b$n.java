package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.l;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class b$n
  implements Runnable
{
  b$n(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(199451);
    Iterator localIterator = ((Iterable)this.wDN.hbP).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ac.i("MicroMsg.MediaFileUtil", "delete file:".concat(String.valueOf(str)));
      i.deleteFile(str);
    }
    AppMethodBeat.o(199451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.n
 * JD-Core Version:    0.7.0.1
 */