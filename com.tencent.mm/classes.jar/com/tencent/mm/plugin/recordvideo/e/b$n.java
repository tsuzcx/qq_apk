package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class b$n
  implements Runnable
{
  b$n(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(207135);
    Iterator localIterator = ((Iterable)this.yhn.hwL).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ae.i("MicroMsg.MediaFileUtil", "delete file:".concat(String.valueOf(str)));
      o.deleteFile(str);
    }
    AppMethodBeat.o(207135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.n
 * JD-Core Version:    0.7.0.1
 */