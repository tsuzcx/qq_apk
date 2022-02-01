package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class b$b
  implements Runnable
{
  b$b(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(76178);
    ae.i("MicroMsg.MediaFileUtil", "deleteDaemonMediaFile");
    o.deleteFile(this.yhg.hwF);
    o.deleteFile(this.yhg.hwG);
    AppMethodBeat.o(76178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.b
 * JD-Core Version:    0.7.0.1
 */