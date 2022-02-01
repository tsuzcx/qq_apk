package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends g
{
  private boolean zPS;
  private boolean zPT;
  
  public b(u paramu, Orders paramOrders)
  {
    super(paramu, paramOrders);
    AppMethodBeat.i(69284);
    this.zPS = false;
    eab();
    AppMethodBeat.o(69284);
  }
  
  private void eab()
  {
    AppMethodBeat.i(69285);
    this.zPS = false;
    s.dZT();
    if ((s.dZU().Ain != null) && (this.zPU.uXi != null))
    {
      String str = this.zPU.dca;
      s.dZT();
      if (str.equals(s.dZU().Ain.field_bankcardType))
      {
        if ((this.zPU.uXi.dtb != 31) && (this.zPU.uXi.dtb != 32) && (this.zPU.uXi.dtb != 33) && (this.zPU.uXi.dtb != 42) && (this.zPU.uXi.dtb != 37) && (this.zPU.uXi.dtb != 56)) {
          break label193;
        }
        this.zPS = true;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.zPS), Boolean.valueOf(this.zPT) });
      AppMethodBeat.o(69285);
      return;
      label193:
      this.zPT = true;
    }
  }
  
  protected void aL(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69286);
    eab();
    if ((this.zPS) || (this.zPT)) {
      paramMap.put("busi_scene", this.zPU.dca);
    }
    AppMethodBeat.o(69286);
  }
  
  public int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(69289);
    if (this.zPS) {
      h.vKh.idkeyStat(663L, 26L, 1L, false);
    }
    for (;;)
    {
      int i = super.doScene(parame, paramg);
      AppMethodBeat.o(69289);
      return i;
      if (this.zPT) {
        h.vKh.idkeyStat(663L, 22L, 1L, false);
      }
    }
  }
  
  public int getFuncId()
  {
    AppMethodBeat.i(69287);
    eab();
    if (this.zPS)
    {
      AppMethodBeat.o(69287);
      return 1281;
    }
    if (this.zPT)
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
    eab();
    if (this.zPS)
    {
      AppMethodBeat.o(69288);
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.zPT)
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
      if (this.zPS)
      {
        h.vKh.idkeyStat(663L, 27L, 1L, false);
        AppMethodBeat.o(69290);
        return;
      }
      if (this.zPT) {
        h.vKh.idkeyStat(663L, 23L, 1L, false);
      }
    }
    AppMethodBeat.o(69290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */