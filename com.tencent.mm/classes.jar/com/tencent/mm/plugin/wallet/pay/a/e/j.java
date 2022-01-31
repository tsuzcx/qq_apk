package com.tencent.mm.plugin.wallet.pay.a.e;

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
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class j
  extends n
{
  private int mPayScene;
  public Orders tVr;
  
  public j(u paramu, Orders paramOrders)
  {
    AppMethodBeat.i(45950);
    this.tVr = null;
    this.mPayScene = -1;
    this.tVr = paramOrders;
    if (paramu.pVo != null)
    {
      this.mPayScene = paramu.pVo.cCD;
      i = paramu.pVo.cCy;
    }
    List localList = paramOrders.ujl;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).cnJ;
    }
    b(paramOrders.cnI, (String)localObject, this.mPayScene, i, paramu.poq, paramu.por);
    paramOrders = new HashMap();
    localObject = new HashMap();
    if (!bo.isNullOrNil(paramu.gww)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramu.pVo, paramOrders, (Map)localObject, bool);
      paramOrders.put("flag", paramu.flag);
      paramOrders.put("passwd", paramu.gww);
      paramOrders.put("verify_code", paramu.uld);
      paramOrders.put("token", paramu.token);
      paramOrders.put("favorcomposedid", paramu.ufh);
      paramOrders.put("default_favorcomposedid", paramu.ufg);
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(45950);
      return;
    }
  }
  
  public final boolean cRN()
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
    AppMethodBeat.i(45951);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    if (paramInt != 0)
    {
      AppMethodBeat.o(45951);
      return;
    }
    ab.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:".concat(String.valueOf(paramJSONObject.optString("bind_serial"))));
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.tVr = Orders.a(paramJSONObject, this.tVr);
      ab.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label169;
      }
      ab.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
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
      label169:
      ab.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
    }
    AppMethodBeat.o(45951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.e.j
 * JD-Core Version:    0.7.0.1
 */