package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.protocal.c.ccn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class g$45
  implements f
{
  g$45(g paramg, ab paramab, i parami) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (ccn)this.rzQ.esv.ecF.ecN;
      if (paramString.jxl != 0) {
        break label115;
      }
      paramString = paramString.tRG;
      if ((paramString != null) && (!paramString.isEmpty())) {
        paramString = paramString.iterator();
      }
      while (paramString.hasNext())
      {
        paramm = (String)paramString.next();
        g.a(this.rzi, paramm);
        continue;
        g.a(this.rzi, this.rzR, "startMonitoringBeacons:no uuids", null);
      }
    }
    for (;;)
    {
      au.Dk().b(1702, this);
      return;
      label115:
      g.a(this.rzi, this.rzR, "startMonitoringBeacons:system error", null);
      y.i("MicroMsg.MsgHandler", "verify beacon js permission err:%s", new Object[] { paramString.jxm });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.45
 * JD-Core Version:    0.7.0.1
 */