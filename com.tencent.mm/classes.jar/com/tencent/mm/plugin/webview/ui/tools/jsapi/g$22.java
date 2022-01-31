package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.nk.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class g$22
  implements Runnable
{
  g$22(g paramg, nk paramnk, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(154937);
    ab.i("MicroMsg.MsgHandler", "JSOAUTH errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(this.pvW.cDN.errCode), Boolean.valueOf(this.pvW.cDN.cDO) });
    if (this.pvW.cDN.errCode == -119)
    {
      AppMethodBeat.o(154937);
      return;
    }
    if (this.pvW.cDN.errCode != 0)
    {
      this.vqm.a(g.k(this.vqm), this.vqF + "fail", null);
      AppMethodBeat.o(154937);
      return;
    }
    if (!this.pvW.cDN.cDO)
    {
      this.vqm.a(g.k(this.vqm), this.vqF + "cancel", null);
      AppMethodBeat.o(154937);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("nationalCode", this.pvW.cDN.cDP);
    localHashMap.put("userName", this.pvW.cDN.userName);
    localHashMap.put("telNumber", this.pvW.cDN.cDQ);
    localHashMap.put("addressPostalCode", this.pvW.cDN.cDR);
    localHashMap.put("proviceFirstStageName", this.pvW.cDN.cDS);
    localHashMap.put("addressCitySecondStageName", this.pvW.cDN.cDT);
    localHashMap.put("addressCountiesThirdStageName", this.pvW.cDN.cDU);
    localHashMap.put("addressDetailInfo", this.pvW.cDN.cDV);
    this.vqm.a(g.k(this.vqm), this.vqF + "ok", localHashMap);
    AppMethodBeat.o(154937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.22
 * JD-Core Version:    0.7.0.1
 */