package com.tencent.mm.plugin.wallet.pay.a.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class j
  extends n
{
  public Orders BhZ;
  private int mPayScene;
  
  public j(u paramu, Orders paramOrders)
  {
    AppMethodBeat.i(69299);
    this.BhZ = null;
    this.mPayScene = -1;
    this.BhZ = paramOrders;
    if (paramu.wfX != null)
    {
      this.mPayScene = paramu.wfX.dqL;
      i = paramu.wfX.channel;
    }
    List localList = paramOrders.BxR;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).dad;
    }
    c(paramOrders.dac, (String)localObject, this.mPayScene, i, paramu.cZz, paramu.vwo);
    paramOrders = new HashMap();
    localObject = new HashMap();
    if (!bs.isNullOrNil(paramu.iJA)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramu.wfX, paramOrders, (Map)localObject, bool);
      paramOrders.put("flag", paramu.flag);
      paramOrders.put("passwd", paramu.iJA);
      paramOrders.put("verify_code", paramu.BzM);
      paramOrders.put("token", paramu.token);
      paramOrders.put("favorcomposedid", paramu.BtK);
      paramOrders.put("default_favorcomposedid", paramu.BtJ);
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69299);
      return;
    }
  }
  
  public final boolean epw()
  {
    return (this.mPayScene == 11) || (this.mPayScene == 21);
  }
  
  public int getFuncId()
  {
    if (this.mPayScene == 11) {
      return 1684;
    }
    if (this.mPayScene == 21) {
      return 1608;
    }
    return 474;
  }
  
  public int getTenpayCgicmd()
  {
    return 16;
  }
  
  public String getUri()
  {
    if (this.mPayScene == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
    }
    if (this.mPayScene == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
    }
    return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69300);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0)
    {
      AppMethodBeat.o(69300);
      return;
    }
    ac.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:".concat(String.valueOf(paramJSONObject.optString("bind_serial"))));
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.BhZ = Orders.a(paramJSONObject, this.BhZ);
      ac.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label169;
      }
      ac.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
      e.bo(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.aSA("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dmf.putInt("key_is_clear_failure", this.JGn);
      }
      setPaySuccess(false);
      break;
      label169:
      ac.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
    }
    AppMethodBeat.o(69300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.e.j
 * JD-Core Version:    0.7.0.1
 */