package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.model.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends g
{
  private boolean VmY;
  private boolean VmZ;
  
  public b(w paramw, Orders paramOrders)
  {
    super(paramw, paramOrders);
    AppMethodBeat.i(69284);
    this.VmY = false;
    ifW();
    AppMethodBeat.o(69284);
  }
  
  private void ifW()
  {
    AppMethodBeat.i(69285);
    this.VmY = false;
    p.ifO();
    if ((p.ifP().VKi != null) && (this.Vna.Nxi != null))
    {
      String str = this.Vna.hAk;
      p.ifO();
      if (str.equals(p.ifP().VKi.field_bankcardType))
      {
        if ((this.Vna.Nxi.hUR != 31) && (this.Vna.Nxi.hUR != 32) && (this.Vna.Nxi.hUR != 33) && (this.Vna.Nxi.hUR != 42) && (this.Vna.Nxi.hUR != 37) && (this.Vna.Nxi.hUR != 56)) {
          break label193;
        }
        this.VmY = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.VmY), Boolean.valueOf(this.VmZ) });
      AppMethodBeat.o(69285);
      return;
      label193:
      this.VmZ = true;
    }
  }
  
  protected void bi(Map<String, String> paramMap)
  {
    AppMethodBeat.i(69286);
    ifW();
    if ((this.VmY) || (this.VmZ)) {
      paramMap.put("busi_scene", this.Vna.hAk);
    }
    AppMethodBeat.o(69286);
  }
  
  public int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69289);
    if (this.VmY) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 26L, 1L, false);
    }
    for (;;)
    {
      int i = super.doScene(paramg, paramh);
      AppMethodBeat.o(69289);
      return i;
      if (this.VmZ) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 22L, 1L, false);
      }
    }
  }
  
  public int getFuncId()
  {
    AppMethodBeat.i(69287);
    ifW();
    if (this.VmY)
    {
      AppMethodBeat.o(69287);
      return 1281;
    }
    if (this.VmZ)
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
    ifW();
    if (this.VmY)
    {
      AppMethodBeat.o(69288);
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.VmZ)
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
      if (this.VmY)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 27L, 1L, false);
        AppMethodBeat.o(69290);
        return;
      }
      if (this.VmZ) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 23L, 1L, false);
      }
    }
    AppMethodBeat.o(69290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */