package com.tencent.mm.plugin.wallet.pay.a.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends n
{
  private int mPayScene;
  public Orders zPF;
  protected u zPU;
  
  public g(u paramu, Orders paramOrders)
  {
    AppMethodBeat.i(69294);
    this.zPF = null;
    this.mPayScene = -1;
    this.zPF = paramOrders;
    this.zPU = paramu;
    List localList = paramOrders.Afx;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).dcF;
    }
    if (paramu.uXi == null)
    {
      ad.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
      AppMethodBeat.o(69294);
      return;
    }
    this.mPayScene = paramu.uXi.dtb;
    int i = paramu.uXi.channel;
    c(paramOrders.dcE, (String)localObject, paramu.uXi.dtb, i, paramu.dca, paramu.uns);
    paramOrders = new HashMap();
    localObject = new HashMap();
    paramOrders.put("flag", paramu.flag);
    paramOrders.put("passwd", paramu.ijt);
    boolean bool;
    if (!bt.isNullOrNil(paramu.ijt))
    {
      bool = true;
      ad.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramu.uXi, paramOrders, (Map)localObject, bool);
      paramOrders.put("verify_type", paramu.dsC);
      if (paramu.dsC != 0) {
        break label414;
      }
      paramOrders.put("verify_code", paramu.Ahs);
    }
    for (;;)
    {
      paramOrders.put("token", paramu.token);
      paramOrders.put("bank_type", paramu.dca);
      paramOrders.put("bind_serial", paramu.uns);
      paramOrders.put("arrive_type", paramu.Abm);
      paramOrders.put("default_favorcomposedid", paramu.Abp);
      paramOrders.put("favorcomposedid", paramu.Abq);
      aL(paramOrders);
      if (z.fjX())
      {
        ((Map)localObject).put("uuid_for_bindcard", z.getBindCardUuid());
        ((Map)localObject).put("bindcard_scene", z.fjY());
      }
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69294);
      return;
      bool = false;
      break;
      label414:
      paramOrders.put("cre_tail", paramu.Ahu);
      paramOrders.put("cre_type", paramu.Ahv);
    }
  }
  
  protected void aL(Map<String, String> paramMap) {}
  
  public final boolean eaa()
  {
    return (this.mPayScene == 11) || (this.mPayScene == 21);
  }
  
  public int getFuncId()
  {
    if (this.mPayScene == 11) {
      return 1607;
    }
    if (this.mPayScene == 21) {
      return 1606;
    }
    return 462;
  }
  
  public int getTenpayCgicmd()
  {
    return 1;
  }
  
  public String getUri()
  {
    if (this.mPayScene == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveverify";
    }
    if (this.mPayScene == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchverify";
    }
    return "/cgi-bin/mmpay-bin/tenpay/verify";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69295);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0)
    {
      AppMethodBeat.o(69295);
      return;
    }
    ad.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:".concat(String.valueOf(paramJSONObject.optString("bind_serial"))));
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.zPF = Orders.a(paramJSONObject, this.zPF);
      ad.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label172;
      }
      ad.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
      e.bn(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.aMX("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dow.putInt("key_is_clear_failure", this.IeL);
      }
      setPaySuccess(false);
      break;
      label172:
      ad.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
    }
    AppMethodBeat.o(69295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.g
 * JD-Core Version:    0.7.0.1
 */