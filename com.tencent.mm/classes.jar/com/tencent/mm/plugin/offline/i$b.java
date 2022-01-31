package com.tencent.mm.plugin.offline;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class i$b
  implements Runnable
{
  private i$b(i parami) {}
  
  public final void run()
  {
    y.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
    if (!g.DN().Dc())
    {
      y.w("MicroMsg.OfflineTokensMgr", "account not init.");
      return;
    }
    this.mKq.dy(6, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i.b
 * JD-Core Version:    0.7.0.1
 */