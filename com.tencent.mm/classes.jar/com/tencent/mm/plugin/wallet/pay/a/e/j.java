package com.tencent.mm.plugin.wallet.pay.a.e;

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
  private int mPayScene;
  public Orders zPF;
  
  public j(u paramu, Orders paramOrders)
  {
    AppMethodBeat.i(69299);
    this.zPF = null;
    this.mPayScene = -1;
    this.zPF = paramOrders;
    if (paramu.uXi != null)
    {
      this.mPayScene = paramu.uXi.dtb;
      i = paramu.uXi.channel;
    }
    List localList = paramOrders.Afx;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).dcF;
    }
    c(paramOrders.dcE, (String)localObject, this.mPayScene, i, paramu.dca, paramu.uns);
    paramOrders = new HashMap();
    localObject = new HashMap();
    if (!bt.isNullOrNil(paramu.ijt)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramu.uXi, paramOrders, (Map)localObject, bool);
      paramOrders.put("flag", paramu.flag);
      paramOrders.put("passwd", paramu.ijt);
      paramOrders.put("verify_code", paramu.Ahs);
      paramOrders.put("token", paramu.token);
      paramOrders.put("favorcomposedid", paramu.Abq);
      paramOrders.put("default_favorcomposedid", paramu.Abp);
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69299);
      return;
    }
  }
  
  public final boolean eaa()
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
    ad.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:".concat(String.valueOf(paramJSONObject.optString("bind_serial"))));
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.zPF = Orders.a(paramJSONObject, this.zPF);
      ad.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label169;
      }
      ad.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
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
      label169:
      ad.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
    }
    AppMethodBeat.o(69300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.e.j
 * JD-Core Version:    0.7.0.1
 */