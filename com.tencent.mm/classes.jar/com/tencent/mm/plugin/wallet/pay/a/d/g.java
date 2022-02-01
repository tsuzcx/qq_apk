package com.tencent.mm.plugin.wallet.pay.a.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public Orders CZT;
  protected v Dai;
  private int mPayScene;
  
  public g(v paramv, Orders paramOrders)
  {
    AppMethodBeat.i(69294);
    this.CZT = null;
    this.mPayScene = -1;
    this.CZT = paramOrders;
    this.Dai = paramv;
    List localList = paramOrders.DpP;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).dmx;
    }
    if (paramv.xDC == null)
    {
      ae.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
      AppMethodBeat.o(69294);
      return;
    }
    this.mPayScene = paramv.xDC.dDH;
    int i = paramv.xDC.channel;
    b(paramOrders.dmw, (String)localObject, paramv.xDC.dDH, i, paramv.dlT, paramv.wRt);
    paramOrders = new HashMap();
    localObject = new HashMap();
    paramOrders.put("flag", paramv.flag);
    paramOrders.put("passwd", paramv.jfC);
    boolean bool;
    if (!bu.isNullOrNil(paramv.jfC))
    {
      bool = true;
      ae.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramv.xDC, paramOrders, (Map)localObject, bool);
      paramOrders.put("verify_type", paramv.dDe);
      if (paramv.dDe != 0) {
        break label414;
      }
      paramOrders.put("verify_code", paramv.DrK);
    }
    for (;;)
    {
      paramOrders.put("token", paramv.token);
      paramOrders.put("bank_type", paramv.dlT);
      paramOrders.put("bind_serial", paramv.wRt);
      paramOrders.put("arrive_type", paramv.DlB);
      paramOrders.put("default_favorcomposedid", paramv.DlE);
      paramOrders.put("favorcomposedid", paramv.DlF);
      aY(paramOrders);
      if (z.fVT())
      {
        ((Map)localObject).put("uuid_for_bindcard", z.getBindCardUuid());
        ((Map)localObject).put("bindcard_scene", z.fVU());
      }
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69294);
      return;
      bool = false;
      break;
      label414:
      paramOrders.put("cre_tail", paramv.DrM);
      paramOrders.put("cre_type", paramv.DrN);
    }
  }
  
  protected void aY(Map<String, String> paramMap) {}
  
  public final boolean eHd()
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
    ae.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:".concat(String.valueOf(paramJSONObject.optString("bind_serial"))));
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.CZT = Orders.a(paramJSONObject, this.CZT);
      ae.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label172;
      }
      ae.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
      e.bx(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.bac("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dyY.putInt("key_is_clear_failure", this.LWg);
      }
      setPaySuccess(false);
      break;
      label172:
      ae.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
    }
    AppMethodBeat.o(69295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.g
 * JD-Core Version:    0.7.0.1
 */