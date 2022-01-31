package com.tencent.mm.plugin.offline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class i$b
  implements Runnable
{
  private i$b(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(43339);
    ab.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.OfflineTokensMgr", "account not init.");
      AppMethodBeat.o(43339);
      return;
    }
    this.pkF.eY(6, 6);
    AppMethodBeat.o(43339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i.b
 * JD-Core Version:    0.7.0.1
 */