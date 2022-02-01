package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

final class bo$1
  implements Runnable
{
  bo$1(bo parambo) {}
  
  public final void run()
  {
    AppMethodBeat.i(117147);
    int i = this.adjU.jbe();
    Log.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    h.baE().ban().B(143618, Integer.valueOf(i));
    AppMethodBeat.o(117147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bo.1
 * JD-Core Version:    0.7.0.1
 */