package com.tencent.mm.plugin.wallet.pay.a.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.utils.i;
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
  public Orders OxA;
  protected w OxP;
  private int mPayScene;
  
  public g(w paramw, Orders paramOrders)
  {
    AppMethodBeat.i(69294);
    this.OxA = null;
    this.mPayScene = -1;
    this.OxA = paramOrders;
    this.OxP = paramw;
    List localList = paramOrders.ORd;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).fww;
    }
    if (paramw.HzF == null)
    {
      Log.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
      AppMethodBeat.o(69294);
      return;
    }
    this.mPayScene = paramw.HzF.fOY;
    int i = paramw.HzF.channel;
    b(paramOrders.fwv, (String)localObject, paramw.HzF.fOY, i, paramw.fvP, paramw.GGC);
    paramOrders = new HashMap();
    localObject = new HashMap();
    paramOrders.put("flag", paramw.flag);
    paramOrders.put("passwd", paramw.mVf);
    boolean bool;
    if (!Util.isNullOrNil(paramw.mVf))
    {
      bool = true;
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramw.HzF, paramOrders, (Map)localObject, bool);
      paramOrders.put("verify_type", paramw.fOv);
      if (paramw.fOv != 0) {
        break label414;
      }
      paramOrders.put("verify_code", paramw.OTh);
    }
    for (;;)
    {
      paramOrders.put("token", paramw.token);
      paramOrders.put("bank_type", paramw.fvP);
      paramOrders.put("bind_serial", paramw.GGC);
      paramOrders.put("arrive_type", paramw.OMV);
      paramOrders.put("default_favorcomposedid", paramw.OMY);
      paramOrders.put("favorcomposedid", paramw.OMZ);
      aR(paramOrders);
      if (z.iiS())
      {
        ((Map)localObject).put("uuid_for_bindcard", z.getBindCardUuid());
        ((Map)localObject).put("bindcard_scene", z.iiT());
      }
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69294);
      return;
      bool = false;
      break;
      label414:
      paramOrders.put("cre_tail", paramw.OTj);
      paramOrders.put("cre_type", paramw.OTk);
    }
  }
  
  protected void aR(Map<String, String> paramMap) {}
  
  public final boolean gGS()
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
      this.OxA = Orders.a(paramJSONObject, this.OxA);
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label172;
      }
      Log.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
      i.ch(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.bCh("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).fKb.putInt("key_is_clear_failure", this.YWu);
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