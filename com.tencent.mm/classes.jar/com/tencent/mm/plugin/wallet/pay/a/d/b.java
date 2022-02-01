package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends g
{
  private boolean CIA;
  private boolean CIB;
  
  public b(v paramv, Orders paramOrders)
  {
    super(paramv, paramOrders);
    AppMethodBeat.i(69284);
    this.CIA = false;
    eDx();
    AppMethodBeat.o(69284);
  }
  
  private void eDx()
  {
    AppMethodBeat.i(69285);
    this.CIA = false;
    s.eDp();
    if ((s.eDq().Dba != null) && (this.CIC.xnF != null))
    {
      String str = this.CIC.dkR;
      s.eDp();
      if (str.equals(s.eDq().Dba.field_bankcardType))
      {
        if ((this.CIC.xnF.dCC != 31) && (this.CIC.xnF.dCC != 32) && (this.CIC.xnF.dCC != 33) && (this.CIC.xnF.dCC != 42) && (this.CIC.xnF.dCC != 37) && (this.CIC.xnF.dCC != 56)) {
          break label193;
        }
        this.CIA = true;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.CIA), Boolean.valueOf(this.CIB) });
      AppMethodBeat.o(69285);
      return;
      label193:
      this.CIB = true;
    }
  }
  
  protected void aS(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69286);
    eDx();
    if ((this.CIA) || (this.CIB)) {
      paramMap.put("busi_scene", this.CIC.dkR);
    }
    AppMethodBeat.o(69286);
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69289);
    if (this.CIA) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(663L, 26L, 1L, false);
    }
    for (;;)
    {
      int i = super.doScene(parame, paramf);
      AppMethodBeat.o(69289);
      return i;
      if (this.CIB) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(663L, 22L, 1L, false);
      }
    }
  }
  
  public int getFuncId()
  {
    AppMethodBeat.i(69287);
    eDx();
    if (this.CIA)
    {
      AppMethodBeat.o(69287);
      return 1281;
    }
    if (this.CIB)
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
    eDx();
    if (this.CIA)
    {
      AppMethodBeat.o(69288);
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.CIB)
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
      if (this.CIA)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(663L, 27L, 1L, false);
        AppMethodBeat.o(69290);
        return;
      }
      if (this.CIB) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(663L, 23L, 1L, false);
      }
    }
    AppMethodBeat.o(69290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */