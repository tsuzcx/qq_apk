package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onSimpleTap"})
final class s$b
  implements MMSightRecordButton.d
{
  s$b(s params) {}
  
  public final void bpa()
  {
    AppMethodBeat.i(150699);
    if ((this.qcT.qcS == -1L) || (bo.av(this.qcT.qcS) > this.qcT.qcR))
    {
      ab.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { bo.dtY().toString() });
      d.b.a(this.qcT.qbI, d.c.qer);
      this.qcT.qcS = bo.yB();
      AppMethodBeat.o(150699);
      return;
    }
    ab.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { bo.dtY().toString() });
    AppMethodBeat.o(150699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s.b
 * JD-Core Version:    0.7.0.1
 */