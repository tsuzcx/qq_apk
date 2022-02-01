package com.tencent.mm.plugin.wallet.pay.a.d;

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
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends n
{
  public Orders VmL;
  protected w Vna;
  private int mPayScene;
  
  public g(w paramw, Orders paramOrders)
  {
    AppMethodBeat.i(69294);
    this.VmL = null;
    this.mPayScene = -1;
    this.VmL = paramOrders;
    this.Vna = paramw;
    List localList = paramOrders.VGX;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).hAU;
    }
    if (paramw.Nxi == null)
    {
      Log.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
      AppMethodBeat.o(69294);
      return;
    }
    this.mPayScene = paramw.Nxi.hUR;
    int i = paramw.Nxi.channel;
    b(paramOrders.hAT, (String)localObject, paramw.Nxi.hUR, i, paramw.hAk, paramw.MDt);
    paramOrders = new HashMap();
    localObject = new HashMap();
    paramOrders.put("flag", paramw.flag);
    paramOrders.put("passwd", paramw.pRM);
    boolean bool;
    if (!Util.isNullOrNil(paramw.pRM))
    {
      bool = true;
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramw.Nxi, paramOrders, (Map)localObject, bool);
      paramOrders.put("verify_type", paramw.hUo);
      if (paramw.hUo != 0) {
        break label414;
      }
      paramOrders.put("verify_code", paramw.VJo);
    }
    for (;;)
    {
      paramOrders.put("token", paramw.token);
      paramOrders.put("bank_type", paramw.hAk);
      paramOrders.put("bind_serial", paramw.MDt);
      paramOrders.put("arrive_type", paramw.VCG);
      paramOrders.put("default_favorcomposedid", paramw.VCJ);
      paramOrders.put("favorcomposedid", paramw.VCK);
      bi(paramOrders);
      if (aa.jOO())
      {
        ((Map)localObject).put("uuid_for_bindcard", aa.getBindCardUuid());
        ((Map)localObject).put("bindcard_scene", aa.jOP());
      }
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69294);
      return;
      bool = false;
      break;
      label414:
      paramOrders.put("cre_tail", paramw.VJq);
      paramOrders.put("cre_type", paramw.VJr);
    }
  }
  
  protected void bi(Map<String, String> paramMap) {}
  
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
  
  public final boolean ifV()
  {
    return (this.mPayScene == 11) || (this.mPayScene == 21);
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
      this.VmL = Orders.a(paramJSONObject, this.VmL);
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label172;
      }
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
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
      label172:
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
    }
    AppMethodBeat.o(69295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.g
 * JD-Core Version:    0.7.0.1
 */