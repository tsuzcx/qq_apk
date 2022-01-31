package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMSightRecordButton$1
  implements MMSightCircularProgressBar.a
{
  MMSightRecordButton$1(MMSightRecordButton paramMMSightRecordButton, MMSightCircularProgressBar.a parama) {}
  
  public final void boZ()
  {
    AppMethodBeat.i(55091);
    ab.b("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
    this.oOg.hideProgress();
    MMSightRecordButton.a(this.oOg, new MMSightRecordButton.1.1(this));
    AppMethodBeat.o(55091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.1
 * JD-Core Version:    0.7.0.1
 */