package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xwebutil.c;
import com.tencent.xweb.ao;
import java.util.HashMap;

public final class k
  implements a
{
  private k()
  {
    AppMethodBeat.i(32813);
    c.nU(MMApplicationContext.getContext());
    ao.a(com.tencent.mm.plugin.cdndownloader.i.a.dqi());
    AppMethodBeat.o(32813);
  }
  
  public final void Kr(boolean paramBoolean) {}
  
  public final boolean bX(Intent paramIntent)
  {
    AppMethodBeat.i(32811);
    if (paramIntent == null)
    {
      AppMethodBeat.o(32811);
      return false;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 4);
    Log.i("MicroMsg.XWeb.MM.WCWebDownloadMgr", "handleCommand, downloadType:%d [4:timer/5:notify/6:config]", new Object[] { Integer.valueOf(i) });
    paramIntent = new HashMap();
    if (i == 5) {
      paramIntent.put("UpdaterCheckType", "1");
    }
    for (;;)
    {
      ao.b(MMApplicationContext.getContext(), paramIntent);
      AppMethodBeat.o(32811);
      return true;
      if (i == 6) {
        paramIntent.put("UpdaterCheckType", "5");
      } else {
        paramIntent.put("UpdaterCheckType", "0");
      }
    }
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32812);
    boolean bool = ao.isBusy();
    Log.i("MicroMsg.XWeb.MM.WCWebDownloadMgr", "isBusy = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(32812);
    return bool;
  }
  
  public final void onDestroy() {}
  
  public static final class a
  {
    public static final k acoQ;
    
    static
    {
      AppMethodBeat.i(32810);
      acoQ = new k((byte)0);
      AppMethodBeat.o(32810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */