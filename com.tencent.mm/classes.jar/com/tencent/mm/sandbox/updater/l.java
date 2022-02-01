package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.w;
import java.util.HashMap;

public final class l
  implements a
{
  private l()
  {
    AppMethodBeat.i(32813);
    d.kT(MMApplicationContext.getContext());
    WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cyj());
    AppMethodBeat.o(32813);
  }
  
  public final void Ay(boolean paramBoolean) {}
  
  public final boolean bu(Intent paramIntent)
  {
    AppMethodBeat.i(32811);
    if (paramIntent == null)
    {
      AppMethodBeat.o(32811);
      return false;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 4);
    Log.i("MicroMsg.WCWebDownloadMgr", "WCWebDownloadMgr  downloadType = %d", new Object[] { Integer.valueOf(i) });
    paramIntent = new HashMap();
    if (i == 5) {
      paramIntent.put("UpdaterCheckType", "1");
    }
    for (;;)
    {
      w.b(MMApplicationContext.getContext(), paramIntent);
      AppMethodBeat.o(32811);
      return true;
      paramIntent.put("UpdaterCheckType", "0");
    }
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32812);
    boolean bool = w.isBusy();
    Log.i("MicroMsg.WCWebDownloadMgr", "bIsBusy = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(32812);
    return bool;
  }
  
  public final void onDestroy() {}
  
  public static final class a
  {
    public static final l NGg;
    
    static
    {
      AppMethodBeat.i(32810);
      NGg = new l((byte)0);
      AppMethodBeat.o(32810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.l
 * JD-Core Version:    0.7.0.1
 */