package com.tencent.mm.plugin.nearby.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.s;

final class a$7
  implements Runnable
{
  a$7(s params, MMHandler paramMMHandler) {}
  
  public final void run()
  {
    AppMethodBeat.i(89815);
    if (this.ucj != null)
    {
      this.ucj.dismiss();
      this.val$handler.sendEmptyMessage(0);
    }
    AppMethodBeat.o(89815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a.7
 * JD-Core Version:    0.7.0.1
 */