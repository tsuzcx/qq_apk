package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.o;
import java.util.HashMap;

public final class k
  implements a
{
  private k()
  {
    AppMethodBeat.i(28999);
    com.tencent.mm.cn.d.iO(ah.getContext());
    com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.i.a.bgb());
    AppMethodBeat.o(28999);
  }
  
  public final boolean aI(Intent paramIntent)
  {
    AppMethodBeat.i(28997);
    if (paramIntent == null)
    {
      AppMethodBeat.o(28997);
      return false;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 4);
    ab.i("MicroMsg.WCWebDownloadMgr", "WCWebDownloadMgr  downloadType = %d", new Object[] { Integer.valueOf(i) });
    paramIntent = new HashMap();
    if (i == 5) {
      paramIntent.put("UpdaterCheckType", "1");
    }
    for (;;)
    {
      o.a(ah.getContext(), paramIntent);
      AppMethodBeat.o(28997);
      return true;
      paramIntent.put("UpdaterCheckType", "0");
    }
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(28998);
    boolean bool = o.isBusy();
    ab.i("MicroMsg.WCWebDownloadMgr", "bIsBusy = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(28998);
    return bool;
  }
  
  public final void onDestroy() {}
  
  public final void pD(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */