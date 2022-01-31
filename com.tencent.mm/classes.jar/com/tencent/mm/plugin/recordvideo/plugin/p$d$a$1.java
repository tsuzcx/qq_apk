package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class p$d$a$1
  implements Runnable
{
  p$d$a$1(p.d.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(150681);
    ab.i("MicroMsg.MMRecordUI", "onTextureUpdate");
    this.qcN.qcM.qcH.oKC.setAlpha(1.0F);
    d.b.a(this.qcN.qcM.qcL, d.c.qet);
    AppMethodBeat.o(150681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p.d.a.1
 * JD-Core Version:    0.7.0.1
 */