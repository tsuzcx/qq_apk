package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.cl.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b.d;
import com.tencent.xweb.i;
import com.tencent.xweb.t;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class k
  implements a
{
  private k()
  {
    XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.wkq);
    t.a(ae.getContext(), com.tencent.mm.cl.a.wDk, com.tencent.mm.cl.a.wDl, null);
    b.cND();
    d.a(com.tencent.mm.plugin.cdndownloader.i.a.aDE());
    XWalkEnvironment.setIsForbidDownloadCode(e.cqq());
  }
  
  public final boolean aj(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    int i = paramIntent.getIntExtra("intent_extra_download_type", 4);
    y.i("MicroMsg.WCWebDownloadMgr", "WCWebDownloadMgr  downloadType = %d", new Object[] { Integer.valueOf(i) });
    paramIntent = new HashMap();
    if (i == 5) {
      paramIntent.put("UpdaterCheckType", "1");
    }
    for (;;)
    {
      i.a(ae.getContext(), paramIntent);
      return true;
      paramIntent.put("UpdaterCheckType", "0");
    }
  }
  
  public final boolean isBusy()
  {
    boolean bool = i.isBusy();
    y.i("MicroMsg.WCWebDownloadMgr", "bIsBusy = " + bool);
    return bool;
  }
  
  public final void mo(boolean paramBoolean) {}
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k
 * JD-Core Version:    0.7.0.1
 */