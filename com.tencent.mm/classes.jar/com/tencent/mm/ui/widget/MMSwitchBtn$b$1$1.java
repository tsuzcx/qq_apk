package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMSwitchBtn$b$1$1
  implements Runnable
{
  MMSwitchBtn$b$1$1(MMSwitchBtn.b.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(112574);
    if (MMSwitchBtn.b(this.ADP.ADO.ADM) != null) {
      MMSwitchBtn.b(this.ADP.ADO.ADM).onStatusChange(MMSwitchBtn.a(this.ADP.ADO.ADM));
    }
    AppMethodBeat.o(112574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn.b.1.1
 * JD-Core Version:    0.7.0.1
 */