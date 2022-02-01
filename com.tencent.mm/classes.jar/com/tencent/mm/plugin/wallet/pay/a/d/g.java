package com.tencent.mm.plugin.wallet.pay.a.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public Orders HFH;
  protected v HFW;
  private int mPayScene;
  
  public g(v paramv, Orders paramOrders)
  {
    AppMethodBeat.i(69294);
    this.HFH = null;
    this.mPayScene = -1;
    this.HFH = paramOrders;
    this.HFW = paramv;
    List localList = paramOrders.HZd;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).dDM;
    }
    if (paramv.BDB == null)
    {
      Log.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
      AppMethodBeat.o(69294);
      return;
    }
    this.mPayScene = paramv.BDB.dVv;
    int i = paramv.BDB.channel;
    b(paramOrders.dDL, (String)localObject, paramv.BDB.dVv, i, paramv.dDj, paramv.ANo);
    paramOrders = new HashMap();
    localObject = new HashMap();
    paramOrders.put("flag", paramv.flag);
    paramOrders.put("passwd", paramv.kdF);
    boolean bool;
    if (!Util.isNullOrNil(paramv.kdF))
    {
      bool = true;
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramv.BDB, paramOrders, (Map)localObject, bool);
      paramOrders.put("verify_type", paramv.dUT);
      if (paramv.dUT != 0) {
        break label414;
      }
      paramOrders.put("verify_code", paramv.IaW);
    }
    for (;;)
    {
      paramOrders.put("token", paramv.token);
      paramOrders.put("bank_type", paramv.dDj);
      paramOrders.put("bind_serial", paramv.ANo);
      paramOrders.put("arrive_type", paramv.HUU);
      paramOrders.put("default_favorcomposedid", paramv.HUX);
      paramOrders.put("favorcomposedid", paramv.HUY);
      aX(paramOrders);
      if (z.hhq())
      {
        ((Map)localObject).put("uuid_for_bindcard", z.getBindCardUuid());
        ((Map)localObject).put("bindcard_scene", z.hhr());
      }
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69294);
      return;
      bool = false;
      break;
      label414:
      paramOrders.put("cre_tail", paramv.IaY);
      paramOrders.put("cre_type", paramv.IaZ);
    }
  }
  
  protected void aX(Map<String, String> paramMap) {}
  
  public final boolean fOn()
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
    Log.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:".concat(String.valueOf(paramJSONObject.optString("bind_serial"))));
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.HFH = Orders.a(paramJSONObject, this.HFH);
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label172;
      }
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
      e.bW(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.bpk("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dQL.putInt("key_is_clear_failure", this.RuW);
      }
      setPaySuccess(false);
      break;
      label172:
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
    }
    AppMethodBeat.o(69295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.g
 * JD-Core Version:    0.7.0.1
 */