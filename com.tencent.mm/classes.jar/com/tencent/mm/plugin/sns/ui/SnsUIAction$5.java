package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUIAction$5
  implements Runnable
{
  SnsUIAction$5(SnsUIAction paramSnsUIAction) {}
  
  public final void run()
  {
    AppMethodBeat.i(145642);
    SnsUIAction.5.1 local1 = new SnsUIAction.5.1(this);
    if (this.sbh.rmc != null) {
      this.sbh.rmc.setOnDragListener(local1);
    }
    AppMethodBeat.o(145642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.5
 * JD-Core Version:    0.7.0.1
 */