package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.matrix.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class d$1
  implements a
{
  d$1(d paramd) {}
  
  public final void onForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(301031);
    Log.d("MicroMsg.MemoryWatchDog", "[%s] isProcessForeground: %s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(paramBoolean) });
    d.a(this.MOm, paramBoolean);
    if (!paramBoolean) {
      d.a(this.MOm, System.currentTimeMillis());
    }
    AppMethodBeat.o(301031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.d.1
 * JD-Core Version:    0.7.0.1
 */