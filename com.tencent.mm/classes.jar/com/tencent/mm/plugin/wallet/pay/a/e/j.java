package com.tencent.mm.plugin.wallet.pay.a.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.utils.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class j
  extends n
{
  public Orders VmL;
  private int mPayScene;
  
  public j(w paramw, Orders paramOrders)
  {
    AppMethodBeat.i(69299);
    this.VmL = null;
    this.mPayScene = -1;
    this.VmL = paramOrders;
    if (paramw.Nxi != null)
    {
      this.mPayScene = paramw.Nxi.hUR;
      i = paramw.Nxi.channel;
    }
    List localList = paramOrders.VGX;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).hAU;
    }
    b(paramOrders.hAT, (String)localObject, this.mPayScene, i, paramw.hAk, paramw.MDt);
    paramOrders = new HashMap();
    localObject = new HashMap();
    if (!Util.isNullOrNil(paramw.pRM)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramw.Nxi, paramOrders, (Map)localObject, bool);
      paramOrders.put("flag", paramw.flag);
      paramOrders.put("passwd", paramw.pRM);
      paramOrders.put("verify_code", paramw.VJo);
      paramOrders.put("token", paramw.token);
      paramOrders.put("favorcomposedid", paramw.VCK);
      paramOrders.put("default_favorcomposedid", paramw.VCJ);
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69299);
      return;
    }
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
  
  public final boolean ifV()
  {
    return (this.mPayScene == 11) || (this.mPayScene == 21);
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
    Log.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:".concat(String.valueOf(paramJSONObject.optString("bind_serial"))));
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.VmL = Orders.a(paramJSONObject, this.VmL);
      Log.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label169;
      }
      Log.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
      l.cD(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.bEC("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((e)paramString.next()).hPH.putInt("key_is_clear_failure", this.agUo);
      }
      setPaySuccess(false);
      break;
      label169:
      Log.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
    }
    AppMethodBeat.o(69300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.e.j
 * JD-Core Version:    0.7.0.1
 */