package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class t$3$1
  implements Runnable
{
  t$3$1(t.3 param3, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(31476);
    if ((!bo.isNullOrNil(t.e(this.zGF.zGC))) && (!bo.isNullOrNil(this.cat)) && (this.cat.equals(t.e(this.zGF.zGC)))) {
      this.zGF.zGC.qV(false);
    }
    AppMethodBeat.o(31476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.3.1
 * JD-Core Version:    0.7.0.1
 */