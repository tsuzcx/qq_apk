package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(35280);
    if (this.AAZ.tipDialog != null) {
      this.AAZ.tipDialog.dismiss();
    }
    this.AAZ.aMj();
    AppMethodBeat.o(35280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.e.1
 * JD-Core Version:    0.7.0.1
 */