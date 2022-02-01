package com.tencent.mm.plugin.wallet.pay.a.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.v;
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
  public Orders CIn;
  private int mPayScene;
  
  public j(v paramv, Orders paramOrders)
  {
    AppMethodBeat.i(69299);
    this.CIn = null;
    this.mPayScene = -1;
    this.CIn = paramOrders;
    if (paramv.xnF != null)
    {
      this.mPayScene = paramv.xnF.dCC;
      i = paramv.xnF.channel;
    }
    List localList = paramOrders.CYk;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).dlv;
    }
    b(paramOrders.dlu, (String)localObject, this.mPayScene, i, paramv.dkR, paramv.wBI);
    paramOrders = new HashMap();
    localObject = new HashMap();
    if (!bt.isNullOrNil(paramv.jcJ)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      setPayInfo(paramv.xnF, paramOrders, (Map)localObject, bool);
      paramOrders.put("flag", paramv.flag);
      paramOrders.put("passwd", paramv.jcJ);
      paramOrders.put("verify_code", paramv.Daf);
      paramOrders.put("token", paramv.token);
      paramOrders.put("favorcomposedid", paramv.CTZ);
      paramOrders.put("default_favorcomposedid", paramv.CTY);
      setRequestData(paramOrders);
      setWXRequestData((Map)localObject);
      AppMethodBeat.o(69299);
      return;
    }
  }
  
  public final boolean eDw()
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
      this.CIn = Orders.a(paramJSONObject, this.CIn);
      ad.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.mPayScene);
      if (this.mPayScene != 39) {
        break label169;
      }
      ad.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
      e.bx(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.aYz("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dxT.putInt("key_is_clear_failure", this.Lzr);
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