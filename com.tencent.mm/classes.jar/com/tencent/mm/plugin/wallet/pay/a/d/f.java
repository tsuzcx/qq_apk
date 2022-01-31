package com.tencent.mm.plugin.wallet.pay.a.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends n
{
  private int mPayScene;
  protected u tVG;
  public Orders tVr;
  
  public f(u paramu, Orders paramOrders)
  {
    AppMethodBeat.i(45948);
    this.tVr = null;
    this.mPayScene = -1;
    this.tVr = paramOrders;
    this.tVG = paramu;
    List localList = paramOrders.ujl;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).cnJ;
    }
    if (paramu.pVo == null)
    {
      ab.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
      AppMethodBeat.o(45948);
      return;
    }
    this.mPayScene = paramu.pVo.cCD;
    int i = paramu.pVo.cCy;
    b(paramOrders.cnI, (String)localObject, paramu.pVo.cCD, i, paramu.poq, paramu.por);
    paramOrders = new HashMap();
    localObject = new HashMap();
    paramOrders.put("flag", paramu.flag);
    paramOrders.put("passwd", paramu.gww);
    boolean bool;
    if (!bo.isNullOrNil(paramu.gww))
    {
      bool = true;
      ab.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramu.pVo, paramOrders, (Map)localObject, bool);
      paramOrders.put("verify_type", paramu.cCd);
      if (paramu.cCd != 0) {
        break label414;
      }
      paramOrders.put("verify_code", paramu.uld);
    }
    for (;;)
    {
      paramOrders.put("token", paramu.token);
      paramOrders.put("bank_type", paramu.poq);
      paramOrders.put("bind_serial", paramu.por);
      paramOrders.put("arrive_type", paramu.ufd);
      paramOrders.put("default_favorcomposedid", paramu.ufg);
      paramOrders.put("favorcomposedid", paramu.ufh);
      aj(paramOrders);
      if (x.dSp())
      {
        ((Map)localObject).put("uuid_for_bindcard", x.dSr());
        ((Map)localObject).put("bindcard_scene", x.dSq());
      }
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(45948);
      return;
      bool = false;
      break;
      label414:
      paramOrders.put("cre_tail", paramu.ulf);
      paramOrders.put("cre_type", paramu.ulg);
    }
  }
  
  protected void aj(Map<String, String> paramMap) {}
  
  public final boolean cRN()
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
    AppMethodBeat.i(45949);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0)
    {
      AppMethodBeat.o(45949);
      return;
    }
    ab.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:".concat(String.valueOf(paramJSONObject.optString("bind_serial"))));
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.tVr = Orders.a(paramJSONObject, this.tVr);
      ab.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label172;
      }
      ab.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
      b.aP(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.avV("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((c)paramString.next()).mEJ.putInt("key_is_clear_failure", this.AXY);
      }
      setPaySuccess(false);
      break;
      label172:
      ab.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
    }
    AppMethodBeat.o(45949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.f
 * JD-Core Version:    0.7.0.1
 */