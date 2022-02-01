package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends g
{
  private boolean HFU;
  private boolean HFV;
  
  public b(v paramv, Orders paramOrders)
  {
    super(paramv, paramOrders);
    AppMethodBeat.i(69284);
    this.HFU = false;
    fOo();
    AppMethodBeat.o(69284);
  }
  
  private void fOo()
  {
    AppMethodBeat.i(69285);
    this.HFU = false;
    s.fOg();
    if ((s.fOh().IbQ != null) && (this.HFW.BDB != null))
    {
      String str = this.HFW.dDj;
      s.fOg();
      if (str.equals(s.fOh().IbQ.field_bankcardType))
      {
        if ((this.HFW.BDB.dVv != 31) && (this.HFW.BDB.dVv != 32) && (this.HFW.BDB.dVv != 33) && (this.HFW.BDB.dVv != 42) && (this.HFW.BDB.dVv != 37) && (this.HFW.BDB.dVv != 56)) {
          break label193;
        }
        this.HFU = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.HFU), Boolean.valueOf(this.HFV) });
      AppMethodBeat.o(69285);
      return;
      label193:
      this.HFV = true;
    }
  }
  
  protected void aX(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69286);
    fOo();
    if ((this.HFU) || (this.HFV)) {
      paramMap.put("busi_scene", this.HFW.dDj);
    }
    AppMethodBeat.o(69286);
  }
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(69289);
    if (this.HFU) {
      h.CyF.idkeyStat(663L, 26L, 1L, false);
    }
    for (;;)
    {
      int i = super.doScene(paramg, parami);
      AppMethodBeat.o(69289);
      return i;
      if (this.HFV) {
        h.CyF.idkeyStat(663L, 22L, 1L, false);
      }
    }
  }
  
  public int getFuncId()
  {
    AppMethodBeat.i(69287);
    fOo();
    if (this.HFU)
    {
      AppMethodBeat.o(69287);
      return 1281;
    }
    if (this.HFV)
    {
      AppMethodBeat.o(69287);
      return 1305;
    }
    AppMethodBeat.o(69287);
    return 1601;
  }
  
  public int getTenpayCgicmd()
  {
    return 121;
  }
  
  public String getUri()
  {
    AppMethodBeat.i(69288);
    fOo();
    if (this.HFU)
    {
      AppMethodBeat.o(69288);
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.HFV)
    {
      AppMethodBeat.o(69288);
      return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
    }
    AppMethodBeat.o(69288);
    return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69290);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0)
    {
      if (this.HFU)
      {
        h.CyF.idkeyStat(663L, 27L, 1L, false);
        AppMethodBeat.o(69290);
        return;
      }
      if (this.HFV) {
        h.CyF.idkeyStat(663L, 23L, 1L, false);
      }
    }
    AppMethodBeat.o(69290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */