package com.tencent.mm.plugin.mmsight.ui.progressbar;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.wcdb.support.Log;
import java.util.List;

final class MMSightProgressBar$1$1
  implements b.a
{
  MMSightProgressBar$1$1(MMSightProgressBar.1 param1) {}
  
  public final void a(a parama)
  {
    MMSightProgressBar.b(this.mrm.mrl).add(parama);
    MMSightProgressBar.a(this.mrm.mrl, null);
    if (MMSightProgressBar.b(this.mrm.mrl).size() >= 5)
    {
      Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
      if (MMSightProgressBar.e(this.mrm.mrl) != null) {
        MMSightProgressBar.e(this.mrm.mrl);
      }
    }
    for (;;)
    {
      this.mrm.mrl.invalidate();
      return;
      if (MMSightProgressBar.a(this.mrm.mrl)) {
        MMSightProgressBar.f(this.mrm.mrl).sendEmptyMessage(233);
      }
    }
  }
  
  public final void bkm()
  {
    this.mrm.mrl.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar.1.1
 * JD-Core Version:    0.7.0.1
 */