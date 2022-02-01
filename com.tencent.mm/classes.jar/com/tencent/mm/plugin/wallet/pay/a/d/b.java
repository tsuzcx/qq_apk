package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends g
{
  private boolean OxN;
  private boolean OxO;
  
  public b(w paramw, Orders paramOrders)
  {
    super(paramw, paramOrders);
    AppMethodBeat.i(69284);
    this.OxN = false;
    gGT();
    AppMethodBeat.o(69284);
  }
  
  private void gGT()
  {
    AppMethodBeat.i(69285);
    this.OxN = false;
    s.gGL();
    if ((s.gGM().OUc != null) && (this.OxP.HzF != null))
    {
      String str = this.OxP.fvP;
      s.gGL();
      if (str.equals(s.gGM().OUc.field_bankcardType))
      {
        if ((this.OxP.HzF.fOY != 31) && (this.OxP.HzF.fOY != 32) && (this.OxP.HzF.fOY != 33) && (this.OxP.HzF.fOY != 42) && (this.OxP.HzF.fOY != 37) && (this.OxP.HzF.fOY != 56)) {
          break label193;
        }
        this.OxN = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.OxN), Boolean.valueOf(this.OxO) });
      AppMethodBeat.o(69285);
      return;
      label193:
      this.OxO = true;
    }
  }
  
  protected void aR(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69286);
    gGT();
    if ((this.OxN) || (this.OxO)) {
      paramMap.put("busi_scene", this.OxP.fvP);
    }
    AppMethodBeat.o(69286);
  }
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(69289);
    if (this.OxN) {
      h.IzE.idkeyStat(663L, 26L, 1L, false);
    }
    for (;;)
    {
      int i = super.doScene(paramg, parami);
      AppMethodBeat.o(69289);
      return i;
      if (this.OxO) {
        h.IzE.idkeyStat(663L, 22L, 1L, false);
      }
    }
  }
  
  public int getFuncId()
  {
    AppMethodBeat.i(69287);
    gGT();
    if (this.OxN)
    {
      AppMethodBeat.o(69287);
      return 1281;
    }
    if (this.OxO)
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
    gGT();
    if (this.OxN)
    {
      AppMethodBeat.o(69288);
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.OxO)
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
      if (this.OxN)
      {
        h.IzE.idkeyStat(663L, 27L, 1L, false);
        AppMethodBeat.o(69290);
        return;
      }
      if (this.OxO) {
        h.IzE.idkeyStat(663L, 23L, 1L, false);
      }
    }
    AppMethodBeat.o(69290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */