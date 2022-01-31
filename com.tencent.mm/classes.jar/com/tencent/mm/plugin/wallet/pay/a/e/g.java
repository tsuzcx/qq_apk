package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.mm.plugin.wallet_core.e.b;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends k
{
  private int nzY = -1;
  public Orders qmc = null;
  
  public g(p paramp, Orders paramOrders)
  {
    this.qmc = paramOrders;
    if (paramp.nqa != null)
    {
      this.nzY = paramp.nqa.bUV;
      i = paramp.nqa.bUR;
    }
    List localList = paramOrders.qwN;
    if (localList.size() > 0) {
      localObject = ((Orders.Commodity)localList.get(0)).bMY;
    }
    a(paramOrders.bMX, (String)localObject, this.nzY, i, paramp.mOb, paramp.mOc);
    paramOrders = new HashMap();
    localObject = new HashMap();
    if (!bk.bl(paramp.feN)) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      a(paramp.nqa, paramOrders, (Map)localObject, bool);
      paramOrders.put("flag", paramp.flag);
      paramOrders.put("passwd", paramp.feN);
      paramOrders.put("verify_code", paramp.qyu);
      paramOrders.put("token", paramp.token);
      paramOrders.put("favorcomposedid", paramp.qsU);
      paramOrders.put("default_favorcomposedid", paramp.qsT);
      D(paramOrders);
      aC((Map)localObject);
      return;
    }
  }
  
  public int HH()
  {
    if (this.nzY == 11) {
      return 1684;
    }
    if (this.nzY == 21) {
      return 1608;
    }
    return 474;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramString, paramJSONObject);
    if (paramInt != 0) {
      return;
    }
    paramString = paramJSONObject.optString("bind_serial");
    y.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:" + paramString);
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      this.qno = true;
      this.qmc = Orders.a(paramJSONObject, this.qmc);
    }
    for (;;)
    {
      y.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.nzY);
      if (this.nzY != 39) {
        break;
      }
      y.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
      b.aw(paramJSONObject);
      return;
      this.qno = false;
    }
    y.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
  }
  
  public final int aEC()
  {
    return 16;
  }
  
  public final boolean bTR()
  {
    return (this.nzY == 11) || (this.nzY == 21);
  }
  
  public String getUri()
  {
    if (this.nzY == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
    }
    if (this.nzY == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
    }
    return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.e.g
 * JD-Core Version:    0.7.0.1
 */