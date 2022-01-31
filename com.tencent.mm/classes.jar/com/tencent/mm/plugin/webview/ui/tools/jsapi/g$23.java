package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.h.a.mp;
import com.tencent.mm.h.a.mp.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class g$23
  implements Runnable
{
  g$23(g paramg, mp parammp, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.MsgHandler", "JSOAUTH errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(this.mTQ.bWa.errCode), Boolean.valueOf(this.mTQ.bWa.bWb) });
    if (this.mTQ.bWa.errCode == -119) {
      return;
    }
    if (this.mTQ.bWa.errCode != 0)
    {
      g.a(this.rzi, g.j(this.rzi), this.rzE + "fail", null);
      return;
    }
    if (!this.mTQ.bWa.bWb)
    {
      g.a(this.rzi, g.j(this.rzi), this.rzE + "cancel", null);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("nationalCode", this.mTQ.bWa.bWc);
    localHashMap.put("userName", this.mTQ.bWa.userName);
    localHashMap.put("telNumber", this.mTQ.bWa.bWd);
    localHashMap.put("addressPostalCode", this.mTQ.bWa.bWe);
    localHashMap.put("proviceFirstStageName", this.mTQ.bWa.bWf);
    localHashMap.put("addressCitySecondStageName", this.mTQ.bWa.bWg);
    localHashMap.put("addressCountiesThirdStageName", this.mTQ.bWa.bWh);
    localHashMap.put("addressDetailInfo", this.mTQ.bWa.bWi);
    g.a(this.rzi, g.j(this.rzi), this.rzE + "ok", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.23
 * JD-Core Version:    0.7.0.1
 */