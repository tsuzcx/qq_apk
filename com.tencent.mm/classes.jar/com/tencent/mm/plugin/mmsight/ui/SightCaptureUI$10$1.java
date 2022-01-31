package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.model.o;

final class SightCaptureUI$10$1
  implements Runnable
{
  SightCaptureUI$10$1(SightCaptureUI.10 param10, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(55194);
    k.a(SightCaptureUI.p(this.oQi.oQf).getFilePath(), SightCaptureUI.K(this.oQi.oQf), j.oHG.eqK, j.oHG.eZQ);
    k.e(false, this.oQh);
    AppMethodBeat.o(55194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.10.1
 * JD-Core Version:    0.7.0.1
 */