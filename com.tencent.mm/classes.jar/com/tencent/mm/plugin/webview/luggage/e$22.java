package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class e$22
  implements Runnable
{
  e$22(e parame, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(6045);
    if (this.uRQ.uRn != null)
    {
      if (!bo.isNullOrNil(this.cbK)) {
        this.uRQ.uRn.setTitleText(this.cbK);
      }
      if (this.ixw != 0) {
        this.uRQ.uRn.setTitleColor(this.ixw);
      }
    }
    AppMethodBeat.o(6045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.22
 * JD-Core Version:    0.7.0.1
 */