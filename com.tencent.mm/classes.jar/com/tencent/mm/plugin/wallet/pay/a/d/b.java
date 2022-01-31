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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends f
{
  private boolean tVE;
  private boolean tVF;
  
  public b(u paramu, Orders paramOrders)
  {
    super(paramu, paramOrders);
    AppMethodBeat.i(45941);
    this.tVE = false;
    cRO();
    AppMethodBeat.o(45941);
  }
  
  private void cRO()
  {
    AppMethodBeat.i(45942);
    this.tVE = false;
    s.cRG();
    if ((s.cRH().ulT != null) && (this.tVG.pVo != null))
    {
      String str = this.tVG.poq;
      s.cRG();
      if (str.equals(s.cRH().ulT.field_bankcardType))
      {
        if ((this.tVG.pVo.cCD != 31) && (this.tVG.pVo.cCD != 32) && (this.tVG.pVo.cCD != 33) && (this.tVG.pVo.cCD != 42) && (this.tVG.pVo.cCD != 37)) {
          break label178;
        }
        this.tVE = true;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.tVE), Boolean.valueOf(this.tVF) });
      AppMethodBeat.o(45942);
      return;
      label178:
      this.tVF = true;
    }
  }
  
  protected final void aj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(45943);
    cRO();
    if ((this.tVE) || (this.tVF)) {
      paramMap.put("busi_scene", this.tVG.poq);
    }
    AppMethodBeat.o(45943);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(45946);
    if (this.tVE) {
      h.qsU.idkeyStat(663L, 26L, 1L, false);
    }
    for (;;)
    {
      int i = super.doScene(parame, paramf);
      AppMethodBeat.o(45946);
      return i;
      if (this.tVF) {
        h.qsU.idkeyStat(663L, 22L, 1L, false);
      }
    }
  }
  
  public final int getFuncId()
  {
    AppMethodBeat.i(45944);
    cRO();
    if (this.tVE)
    {
      AppMethodBeat.o(45944);
      return 1281;
    }
    if (this.tVF)
    {
      AppMethodBeat.o(45944);
      return 1305;
    }
    AppMethodBeat.o(45944);
    return 1601;
  }
  
  public final int getTenpayCgicmd()
  {
    return 121;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(45945);
    cRO();
    if (this.tVE)
    {
      AppMethodBeat.o(45945);
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.tVF)
    {
      AppMethodBeat.o(45945);
      return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
    }
    AppMethodBeat.o(45945);
    return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45947);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0)
    {
      if (this.tVE)
      {
        h.qsU.idkeyStat(663L, 27L, 1L, false);
        AppMethodBeat.o(45947);
        return;
      }
      if (this.tVF) {
        h.qsU.idkeyStat(663L, 23L, 1L, false);
      }
    }
    AppMethodBeat.o(45947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */