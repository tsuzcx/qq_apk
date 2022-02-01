package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.w;
import java.util.HashMap;

public final class l
  implements a
{
  private l()
  {
    AppMethodBeat.i(32813);
    d.kQ(aj.getContext());
    WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.bZd());
    AppMethodBeat.o(32813);
  }
  
  public final boolean bh(Intent paramIntent)
  {
    AppMethodBeat.i(32811);
    if (paramIntent == null)
    {
      AppMethodBeat.o(32811);
      return false;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 4);
    ad.i("MicroMsg.WCWebDownloadMgr", "WCWebDownloadMgr  downloadType = %d", new Object[] { Integer.valueOf(i) });
    paramIntent = new HashMap();
    if (i == 5) {
      paramIntent.put("UpdaterCheckType", "1");
    }
    for (;;)
    {
      w.a(aj.getContext(), paramIntent);
      AppMethodBeat.o(32811);
      return true;
      paramIntent.put("UpdaterCheckType", "0");
    }
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32812);
    boolean bool = w.isBusy();
    ad.i("MicroMsg.WCWebDownloadMgr", "bIsBusy = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(32812);
    return bool;
  }
  
  public final void onDestroy() {}
  
  public final void wq(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.l
 * JD-Core Version:    0.7.0.1
 */