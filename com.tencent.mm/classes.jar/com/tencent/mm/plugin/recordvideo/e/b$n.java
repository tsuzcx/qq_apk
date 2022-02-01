package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.l;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class b$n
  implements Runnable
{
  b$n(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(204331);
    Iterator localIterator = ((Iterable)this.LpV.gBt).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad.i("MicroMsg.MediaFileUtil", "delete file:".concat(String.valueOf(str)));
      i.deleteFile(str);
    }
    AppMethodBeat.o(204331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.n
 * JD-Core Version:    0.7.0.1
 */