package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends g
{
  private boolean Dag;
  private boolean Dah;
  
  public b(v paramv, Orders paramOrders)
  {
    super(paramv, paramOrders);
    AppMethodBeat.i(69284);
    this.Dag = false;
    eHe();
    AppMethodBeat.o(69284);
  }
  
  private void eHe()
  {
    AppMethodBeat.i(69285);
    this.Dag = false;
    s.eGW();
    if ((s.eGX().DsE != null) && (this.Dai.xDC != null))
    {
      String str = this.Dai.dlT;
      s.eGW();
      if (str.equals(s.eGX().DsE.field_bankcardType))
      {
        if ((this.Dai.xDC.dDH != 31) && (this.Dai.xDC.dDH != 32) && (this.Dai.xDC.dDH != 33) && (this.Dai.xDC.dDH != 42) && (this.Dai.xDC.dDH != 37) && (this.Dai.xDC.dDH != 56)) {
          break label193;
        }
        this.Dag = true;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.Dag), Boolean.valueOf(this.Dah) });
      AppMethodBeat.o(69285);
      return;
      label193:
      this.Dah = true;
    }
  }
  
  protected void aY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69286);
    eHe();
    if ((this.Dag) || (this.Dah)) {
      paramMap.put("busi_scene", this.Dai.dlT);
    }
    AppMethodBeat.o(69286);
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69289);
    if (this.Dag) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(663L, 26L, 1L, false);
    }
    for (;;)
    {
      int i = super.doScene(parame, paramf);
      AppMethodBeat.o(69289);
      return i;
      if (this.Dah) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(663L, 22L, 1L, false);
      }
    }
  }
  
  public int getFuncId()
  {
    AppMethodBeat.i(69287);
    eHe();
    if (this.Dag)
    {
      AppMethodBeat.o(69287);
      return 1281;
    }
    if (this.Dah)
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
    eHe();
    if (this.Dag)
    {
      AppMethodBeat.o(69288);
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.Dah)
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
      if (this.Dag)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(663L, 27L, 1L, false);
        AppMethodBeat.o(69290);
        return;
      }
      if (this.Dah) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(663L, 23L, 1L, false);
      }
    }
    AppMethodBeat.o(69290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */