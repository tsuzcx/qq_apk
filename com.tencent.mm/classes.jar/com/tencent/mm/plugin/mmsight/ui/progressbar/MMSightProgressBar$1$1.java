package com.tencent.mm.plugin.mmsight.ui.progressbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.wcdb.support.Log;
import java.util.List;

final class MMSightProgressBar$1$1
  implements b.a
{
  MMSightProgressBar$1$1(MMSightProgressBar.1 param1) {}
  
  public final void a(a parama)
  {
    AppMethodBeat.i(55333);
    MMSightProgressBar.b(this.oRa.oQZ).add(parama);
    MMSightProgressBar.a(this.oRa.oQZ, null);
    if (MMSightProgressBar.b(this.oRa.oQZ).size() >= 5)
    {
      Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
      if (MMSightProgressBar.e(this.oRa.oQZ) != null) {
        MMSightProgressBar.e(this.oRa.oQZ);
      }
    }
    for (;;)
    {
      this.oRa.oQZ.invalidate();
      AppMethodBeat.o(55333);
      return;
      if (MMSightProgressBar.a(this.oRa.oQZ)) {
        MMSightProgressBar.f(this.oRa.oQZ).sendEmptyMessage(233);
      }
    }
  }
  
  public final void bSn()
  {
    AppMethodBeat.i(55334);
    this.oRa.oQZ.invalidate();
    AppMethodBeat.o(55334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar.1.1
 * JD-Core Version:    0.7.0.1
 */