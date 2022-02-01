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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends g
{
  private boolean Bim;
  private boolean Bin;
  
  public b(u paramu, Orders paramOrders)
  {
    super(paramu, paramOrders);
    AppMethodBeat.i(69284);
    this.Bim = false;
    epx();
    AppMethodBeat.o(69284);
  }
  
  private void epx()
  {
    AppMethodBeat.i(69285);
    this.Bim = false;
    s.epp();
    if ((s.epq().BAI != null) && (this.Bio.wfX != null))
    {
      String str = this.Bio.cZz;
      s.epp();
      if (str.equals(s.epq().BAI.field_bankcardType))
      {
        if ((this.Bio.wfX.dqL != 31) && (this.Bio.wfX.dqL != 32) && (this.Bio.wfX.dqL != 33) && (this.Bio.wfX.dqL != 42) && (this.Bio.wfX.dqL != 37) && (this.Bio.wfX.dqL != 56)) {
          break label193;
        }
        this.Bim = true;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.Bim), Boolean.valueOf(this.Bin) });
      AppMethodBeat.o(69285);
      return;
      label193:
      this.Bin = true;
    }
  }
  
  protected void aP(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69286);
    epx();
    if ((this.Bim) || (this.Bin)) {
      paramMap.put("busi_scene", this.Bio.cZz);
    }
    AppMethodBeat.o(69286);
  }
  
  public int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(69289);
    if (this.Bim) {
      h.wUl.idkeyStat(663L, 26L, 1L, false);
    }
    for (;;)
    {
      int i = super.doScene(parame, paramg);
      AppMethodBeat.o(69289);
      return i;
      if (this.Bin) {
        h.wUl.idkeyStat(663L, 22L, 1L, false);
      }
    }
  }
  
  public int getFuncId()
  {
    AppMethodBeat.i(69287);
    epx();
    if (this.Bim)
    {
      AppMethodBeat.o(69287);
      return 1281;
    }
    if (this.Bin)
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
    epx();
    if (this.Bim)
    {
      AppMethodBeat.o(69288);
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.Bin)
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
      if (this.Bim)
      {
        h.wUl.idkeyStat(663L, 27L, 1L, false);
        AppMethodBeat.o(69290);
        return;
      }
      if (this.Bin) {
        h.wUl.idkeyStat(663L, 23L, 1L, false);
      }
    }
    AppMethodBeat.o(69290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */